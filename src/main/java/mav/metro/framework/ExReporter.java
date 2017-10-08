package mav.metro.framework;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import mav.metro.library.functions.CommonDef;
import org.testng.Assert;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ExReporter {

	private static ExtentReports extentD;
	private static ExtentReports extentDwss;
	private static ExtentReports extentM;
	private static ExtentReports extentMwss;

	public ExtentTest testParent;
	public ExtentTest testParentWss;
	public static String reportPath;
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<ExtentTest> testwss = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<Boolean> isPassed = new ThreadLocal<Boolean>();

	public static int passCountD = 0;
	public static int failCountD = 0;
	public static int passCountM = 0;
	public static int failCountM = 0;

	public static Map<String, ExReporter> classReportMap = new HashMap<String, ExReporter>();

	public static void initReport(String suiteName) {
		String path = ProjectConfig.getPropertyValue("SSPath");
		String fileName = new SimpleDateFormat("yyyyMMddhhmm").format(new Date());
		new File(path + "Report_" + fileName).mkdirs();
		reportPath = path + "Report_" + fileName;
		if (suiteName.equalsIgnoreCase("Browser")) {
			extentD = new ExtentReports(reportPath + "/Browser-Browser-Results.htm", true);
			extentDwss = new ExtentReports(reportPath + "/Browser-Browser-Results-withScreens.htm", true);
		} else {
			extentM = new ExtentReports(reportPath + "/Mobile-Browser-Results.htm", true);
			extentMwss = new ExtentReports(reportPath + "/Mobile-Browser-Results-withScreens.htm", true);
		}
	}

	public ExReporter(String testName, String description, String suiteName) {
		initParent(testName, description, suiteName);
	}

	public ExReporter(String testName, String suiteName) {
		initParent(testName, suiteName);
	}

	public static void log(LogStatus logStatus, String stepName) {
		test.get().log(logStatus, stepName);
		String path = "";
		String screenPass = ProjectConfig.getPropertyValue("screenPass");
		String screenFail = ProjectConfig.getPropertyValue("screenFail");
		String screenWarn = ProjectConfig.getPropertyValue("screenWarn");

		switch (logStatus) {
		case PASS:
			if (screenPass.equals("true")) {
				path = CommonDef.captureScreen();
				testwss.get().log(logStatus, stepName + testwss.get().addScreenCapture(path));
			} else
				testwss.get().log(logStatus, stepName);
			break;
		case FAIL:
			if (screenFail.equals("true")) {
				path = CommonDef.captureScreen();
				testwss.get().log(logStatus, stepName + testwss.get().addScreenCapture(path));
			} else
				testwss.get().log(logStatus, stepName);
			isPassed.set(false);
			// Assert.fail();
			break;				
		case INFO:
		/*	path = CommonDef.captureScreen();
			testwss.get().log(logStatus, stepName + testwss.get().addScreenCapture(path));*/
		case SKIP:
			testwss.get().log(logStatus, stepName);
			break;
		case WARNING:
			if (screenWarn.equals("true")) {
				path = CommonDef.captureScreen();
				testwss.get().log(logStatus, stepName + testwss.get().addScreenCapture(path));
			} else
				testwss.get().log(logStatus, stepName);
			break;
		case ERROR:
			if (screenFail.equals("true")) {
				path = CommonDef.captureScreen();
				testwss.get().log(LogStatus.FAIL, stepName + testwss.get().addScreenCapture(path));
			} else
				testwss.get().log(LogStatus.FAIL, stepName);
			isPassed.set(false);
			Assert.fail();
			break;
		case UNKNOWN:
			isPassed.set(false);
			logStatus = LogStatus.FAIL;
			if (screenWarn.equals("true")) {
				path = CommonDef.captureScreen();
				testwss.get().log(logStatus, stepName + testwss.get().addScreenCapture(path));
			} else {
				testwss.get().log(logStatus, stepName + " ");
			}
			Assert.fail();
			break;
		case FATAL:
			isPassed.set(false);
			testwss.get().log(logStatus, stepName);
			// System.out.println(isPassed.get());
			Assert.fail();
			break;
		default:
			break;
		}

	}

	public static void logNoScreen(LogStatus logStatus, String stepName) {
		test.get().log(logStatus, stepName);
		switch (logStatus) {
		case PASS:
			testwss.get().log(logStatus, stepName);
			break;
		case FAIL:
			testwss.get().log(logStatus, stepName);
			isPassed.set(false);
			// Assert.fail();
			break;
		case INFO:
		case SKIP:
			testwss.get().log(logStatus, stepName);
			break;
		case WARNING:
			testwss.get().log(logStatus, stepName);
			break;
		case ERROR:
			testwss.get().log(LogStatus.FAIL, stepName);
			isPassed.set(false);
			Assert.fail();
			break;
		case UNKNOWN:
			isPassed.set(false);
			logStatus = LogStatus.FAIL;
			testwss.get().log(logStatus, stepName + " ");
			Assert.fail();
			break;
		case FATAL:
			isPassed.set(false);
			testwss.get().log(logStatus, stepName);
			// System.out.println(isPassed.get());
			Assert.fail();
			break;
		default:
			break;
		}

	}

	public void initParent(String testName, String description, String suiteName) {
		if ("Browser".equalsIgnoreCase(suiteName)) {
			testParent = extentD.startTest(testName, description);
			testParentWss = extentDwss.startTest(testName, description);
		} else {
			testParent = extentM.startTest(testName, description);
			testParentWss = extentMwss.startTest(testName, description);
		}
	}

	public void initParent(String testName, String suiteName) {
		if ("Browser".equalsIgnoreCase(suiteName)) {
			testParent = extentD.startTest(testName);
			testParentWss = extentDwss.startTest(testName);
		} else {
			testParent = extentM.startTest(testName);
			testParentWss = extentMwss.startTest(testName);
		}
	}

	public static void initTest(String testName, String desc) {

		isPassed.set(true);
		test.set(getextent().startTest(testName, desc));
		testwss.set(getextentwss().startTest(testName, desc));
	}

	public static void assignCatogory(String Catogory) {
		test.get().assignCategory(Catogory);
		testwss.get().assignCategory(Catogory);
	}

	public void endParent(String suiteName) {
		if ("Browser".equalsIgnoreCase(suiteName)) {
			extentD.endTest(testParent);
			extentDwss.endTest(testParentWss);
		} else {
			extentM.endTest(testParent);
			extentMwss.endTest(testParentWss);
		}
	}

	public static void endReport(String suiteName) {
		if ("Browser".equalsIgnoreCase(suiteName)) {
			extentD.flush();
			extentDwss.flush();
			extentD.close();
			extentDwss.close();
		} else {
			extentM.flush();
			extentMwss.flush();
			extentM.close();
			extentMwss.close();

		}
	}

	private static ExtentReports getextent() {
		// System.out.println(ConfigProvider.getConfig("Platform"));
		switch (ConfigProvider.getConfig("Platform").toUpperCase()) {
		case "BROWSER":
			return extentD;
		default:
			return extentM;
		}
	}

	private static ExtentReports getextentwss() {
		switch (ConfigProvider.getConfig("Platform").toUpperCase()) {
		case "BROWSER":
			return extentDwss;
		default:
			return extentMwss;
		}
	}

	public void appendParent() {
		testParent.appendChild(test.get());
		testParentWss.appendChild(testwss.get());
		// System.out.println(isPassed.get());
		if (ConfigProvider.getConfig("Platform").equalsIgnoreCase("Browser")) {
			if (isPassed.get()) {
				passCountD = passCountD + 1;
			} else {
				failCountD = failCountD + 1;
			}
		} else {
			if (isPassed.get()) {
				passCountM = passCountM + 1;
			} else {
				failCountM = failCountM + 1;
			}
		}
		test.remove();
		testwss.remove();
		isPassed.remove();

	}

}
