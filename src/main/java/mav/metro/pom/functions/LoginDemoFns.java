package mav.metro.pom.functions;

import com.relevantcodes.extentreports.LogStatus;
import mav.metro.driver.DriverFactory;
import mav.metro.framework.ExReporter;
import mav.metro.framework.TestData;
import mav.metro.library.functions.CommonDef;
import mav.metro.library.functions.MethodDef;
import mav.metro.pom.elements.LoginDemo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginDemoFns {

	public static void loginmain() {
		ExReporter.log(LogStatus.INFO, "Corp Arc Login Screen");
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();
			String url = TestData.getConfig("URL");
			driver.get(url);
			MethodDef.clickNoError(LoginDemo.login_popup(), "Popup Window");
			if (CommonDef.ObjectExist(LoginDemo.login_username())) {
				ExReporter.log(LogStatus.PASS, "Login page loaded successfully");
			}
			if (!TestData.getConfig("UserID").equalsIgnoreCase("nil")) {
				MethodDef.sendKeys(LoginDemo.login_username(), TestData.getConfig("UserID"));
				MethodDef.click(LoginDemo.login_buttonsubmit(), "Login Button");
				if (CommonDef.ObjectExist(LoginDemo.login_password())) {
					ExReporter.log(LogStatus.PASS, "UserID entered successfully");
				}
				if (!TestData.getConfig("Password").equalsIgnoreCase("nil")) {
					MethodDef.sendKeys(LoginDemo.login_password(), TestData.getConfig("Password"));
					MethodDef.click(LoginDemo.login_buttonsubmit(), "Submit Button");
					if (CommonDef.ObjectExist(LoginDemo.validation_LoginFail())) {
						ExReporter.log(LogStatus.PASS, "Login Failed");
					}
				}

				if (TestData.getConfig("Password").equalsIgnoreCase("nil")) {
					if (TestData.getConfig("Action").equalsIgnoreCase("FP")) {
						MethodDef.click(LoginDemo.Link_ForgotPwd(), "Forgot Password Link");
						pagevalidation("Forgot Password Link", LoginDemo.validation_forgpasslink());
					}

					if (TestData.getConfig("Action").equalsIgnoreCase("FS")) {
						MethodDef.click(LoginDemo.Link_ForgotSecNo(), "Forgot Security Num Link");
						pagevalidation("Forgot Security Number Link", LoginDemo.validation_forgseclink());
					}
				}

				if (TestData.getConfig("Action").equalsIgnoreCase("blank")) {
					MethodDef.click(LoginDemo.login_buttonsubmit(), "Submit Button");
					if (CommonDef.ObjectExist(LoginDemo.validation_LoginFail())) {
						ExReporter.log(LogStatus.PASS, "Login Failed");
					}
				}

			}
			if (TestData.getConfig("Action").equalsIgnoreCase("Navigate")) {
				if (TestData.getConfig("Page").equalsIgnoreCase("RIB")) {
					MethodDef.click(LoginDemo.Link_Navigate_RetailIB(), "Retail Internet Banking Link");
					MethodDef.clickNoError(LoginDemo.login_popup(), "Popup Window");
					pagevalidation("Retail Internet Banking Page", LoginDemo.validation_RIBPage());
				}
				if (TestData.getConfig("Page").equalsIgnoreCase("Home")) {
					MethodDef.click(LoginDemo.Link_Navigate_HomePage(), "MetroBank Home Page Link");
					MethodDef.clickNoError(LoginDemo.login_popup(), "Popup Window");
					pagevalidation("Metro Bank Home Page", LoginDemo.validation_HomeLoginbtn());
				}
				if (TestData.getConfig("Page").equalsIgnoreCase("Store")) {
					MethodDef.click(LoginDemo.Link_Navigate_StoreLocator(), "MetroBank Stores Link");
					MethodDef.clickNoError(LoginDemo.login_popup(), "Popup Window");
					pagevalidation("Metro Bank Store Page", LoginDemo.validation_StorePage());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void pagevalidation(String PageName, By Object) {
		//WebDriver driver = DriverFactory.getCurrentDriver();
		if (CommonDef.ObjectExist(Object)) {
			ExReporter.log(LogStatus.PASS, "Navigated to " + PageName);
		} else {
			ExReporter.log(LogStatus.FAIL, "Failed to navigate " + PageName);
		}
	}

}
