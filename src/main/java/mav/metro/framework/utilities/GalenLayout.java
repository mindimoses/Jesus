package mav.metro.framework.utilities;

import com.galenframework.api.Galen;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import com.relevantcodes.extentreports.LogStatus;
import mav.metro.driver.DriverFactory;
import mav.metro.framework.ConfigProvider;
import mav.metro.framework.ExReporter;
import org.openqa.selenium.WebDriver;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GalenLayout {

	public static void testLayout(String pageSpec, String fileName, String testDescription, List<GalenTestInfo> tests) {

		WebDriver browser = DriverFactory.getCurrentDriver();
		String sectionFilter;
		if (ConfigProvider.getConfig("Browser").equalsIgnoreCase("Browser"))
			sectionFilter = "desktop";
		else {
			if (ConfigProvider.getConfig("Version").equalsIgnoreCase("Mob"))
				sectionFilter = "mobile";
			else
				sectionFilter = "tablet";
		}

		try {
			LayoutReport layoutReport = Galen.checkLayout(browser, pageSpec, Arrays.asList(sectionFilter));
			
			GalenTestInfo test = GalenTestInfo.fromString(testDescription);
			test.getReport().layout(layoutReport, "check layout on mobile device");
			tests.add(test);
			
			if (layoutReport.errors() > 0) {
				ExReporter.log(LogStatus.FAIL, "Layout is not correct");
			} else {
				ExReporter.log(LogStatus.PASS, "The Layout tests passed");
			}
			final String RELATIVE_LOC = Paths.get("").toAbsolutePath().toString();
			final String PROJECT_LOC = buildInput(RELATIVE_LOC);
			String userDirectory = PROJECT_LOC + "/target/galen-html-reports/";
			ExReporter.log(LogStatus.INFO, "<font color=\"blue\">>" + "<a href="
					+ "\"" + userDirectory + "1-" + fileName + ".html" + "\""
					+ " target=\"_blank\"" + ">" + "Result File"
					+ "</a></i></font><br/>");

		} catch (Exception e) {
			ExReporter.log(LogStatus.FATAL, "UNABLE TO TEST LAYOUT - Error Message : " + e.getMessage());
		}
	}
	
	private static String buildInput(String loc){
		if (loc.contains("target")){
			return loc.substring(0, loc.length() - 7);
		}
		else{
			return loc;
		}
	}

	public static List<GalenTestInfo> initiateTest() {
		List<GalenTestInfo> tests = new LinkedList<GalenTestInfo>();
		return tests;
	}

	public static void closeTestGroup(List<GalenTestInfo> tests, String path) {
		try {
			new HtmlReportBuilder().build(tests, path);
		} catch (Exception e) {
			ExReporter.log(LogStatus.WARNING, "Unable to group layout tests" + e.getLocalizedMessage());
		}
	}
}
