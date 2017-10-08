package mav.metro.pom.functions;

import com.relevantcodes.extentreports.LogStatus;
import mav.metro.framework.ExReporter;
import mav.metro.framework.TestData;
import mav.metro.library.functions.CommonDef;
import mav.metro.library.functions.MethodDef;
import mav.metro.pom.elements.Dashboard;

public class DashboardFns {

	public static void Dashboard() {

		try {
			CommonDef.moveToElement(Dashboard.Link_Dashboard_DropdownDetails(TestData.getConfig("Account_No")),
					"Account Number");
			MethodDef.clickJS(Dashboard.Link_Dashboard_DropdownDetails(TestData.getConfig("Account_No")),
					"Clicked Dropdown link");
			CommonDef.waitVisibleNoError(Dashboard.Validation_Dashboard_1());
			CommonDef.assertContains(Dashboard.Validation_Dashboard_2(), "BIC Code");
			ExReporter.log(LogStatus.PASS, "Dashboard for Selected Account displayed");

		} catch (Exception E) {
			ExReporter.log(LogStatus.FAIL, "Dashboard Overview" + E.getMessage());
		}

	}
}
