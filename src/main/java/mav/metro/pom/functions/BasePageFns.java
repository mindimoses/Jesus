package mav.metro.pom.functions;

import com.relevantcodes.extentreports.LogStatus;
import mav.metro.framework.ConfigProvider;
import mav.metro.framework.ExReporter;
import mav.metro.framework.ProjectConfig;
import mav.metro.library.functions.CommonDef;
import mav.metro.library.functions.MethodDef;
import mav.metro.pom.elements.BasePage;
import mav.metro.pom.elements.Login;
import mav.metro.pom.elements.Payments;
import org.openqa.selenium.By;

public class BasePageFns {

	public static void openItemLogoutMenu() {
		if (ConfigProvider.getConfig("Platform").equalsIgnoreCase("mBrowser")) {
			MethodDef.click(Login.devLogOutToggle(), "Logout Toggle - Open");
		}
	}

	public static void approvalValidation(String action) {
		if (action.contains("approve")) {
			if (!CommonDef.assertContains(Payments.Lnk_PaymentsMsg(), "Item approved"))
				ExReporter.log(LogStatus.ERROR, "Approval Failed");
		} else {
			if (!CommonDef.assertContains(Payments.Lnk_PaymentsMsg(), "Item rejected"))
				ExReporter.log(LogStatus.ERROR, "Rejection Failed");
		}
	}

	public static void verificationValidation(String Action) {
		if (Action.contains("verify")) {
			if (!CommonDef.assertContains(Payments.Lnk_PaymentsMsg(), "Item verified"))
				ExReporter.log(LogStatus.ERROR, "Verification Failed");
		} else {
			if (!CommonDef.assertContains(Payments.Lnk_PaymentsMsg(), "Item rejected"))
				ExReporter.log(LogStatus.ERROR, "Verification Rejection Failed");
		}
	}

	public static void openMainMenu() {
		if (ConfigProvider.getConfig("Platform").equalsIgnoreCase("mBrowser")) {
			CommonDef.moveToElement(Payments.mob_Mainmenu(), "Main Menu");
			MethodDef.clickJS(Payments.mob_Mainmenu());
		}
	}
	
	public static void openPaymentsdropdownMobile() {
		if (ConfigProvider.getConfig("Platform").equalsIgnoreCase("mBrowser")) {
			openMainMenu();
			MethodDef.clickJS(Payments.mob_MainmenuPaymentOpen());
		} else 
			MethodDef.clickJS(Payments.mob_MainmenuPaymentOpen());
			//MethodDef.clickJS(Payments.Link_PaymentsMenuItems(), "Payments & Transfer Page");
	}

	public static void hardTokenEnter(By by) {
		try {
			Thread.sleep(1000);
			MethodDef.sendKeys(by, ProjectConfig.getPropertyValue("hardtoken"));
		} catch (Exception E) {

		}
	}

	public static void toggleTopNavMenu() {
		if (ConfigProvider.getConfig("Platform").equalsIgnoreCase("mBrowser")) {
			MethodDef.click(BasePage.mob_Headermenu(), "Top Right navigation Menu");
		}
	}
}
