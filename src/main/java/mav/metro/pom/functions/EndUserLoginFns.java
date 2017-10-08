package mav.metro.pom.functions;

import com.relevantcodes.extentreports.LogStatus;
import mav.metro.framework.ExReporter;
import mav.metro.framework.TestData;
import mav.metro.library.functions.CommonDef;
import mav.metro.library.functions.MethodDef;
import mav.metro.pom.elements.Login;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EndUserLoginFns {
	public static void EndUserLogin() {
		try {
			if (TestData.getConfig("Flow_Type").equals("Forgot")) {
				MethodDef.click(Login.Link_ForgottenDetails(), "Forgotten your details Link clicked");
				CommonDef.switchNewWindow();
				LandingPageFns.urlContains(TestData.getConfig("windowVerify"), "Forgot Password Link");
			} else if (TestData.getConfig("Flow_Type").equals("WrongPwd")) {
				MethodDef.sendKeys(Login.login_userid(), TestData.getConfig("UserID"));
				MethodDef.click(Login.login_continue(), "Continue Button Clicked");
				MethodDef.sendKeys(Login.login_password(), TestData.getConfig("Password"));
				List<WebElement> SecNums = CommonDef.findElements(Login.login_securityno());
				for (WebElement temp : SecNums) {
					temp.sendKeys(TestData.getConfig("Security1"));
				}
				MethodDef.clickJS(Login.login_submit(), "Login Button Clicked");
				CommonDef.waitVisibleNoError(Login.Validation_LoginFailed());
				CommonDef.isDisplayed(Login.Validation_LoginFailed(), "Login Failed");
			} else {
				MethodDef.click(Login.login_continue(), "Continue Button");
				MethodDef.assertContains(Login.ibidError(), "Please enter your customer number");
				MethodDef.sendKeys(Login.login_userid(), TestData.getConfig("UserID").substring(4));
				MethodDef.click(Login.login_continue(), "Continue Button");
				MethodDef.assertContains(Login.ibidError(), "Customer number must be 12 numbers");
				MethodDef.sendKeys(Login.login_userid(), TestData.getConfig("UserID"));
				MethodDef.click(Login.login_continue(), "Continue Button");
				CommonDef.waitVisible(Login.login_password(), "Password");
				MethodDef.click(Login.loginBack(), "Back Button");
				CommonDef.waitVisible(Login.login_userid(), "Login IBID");
				MethodDef.click(Login.login_continue(), "Continue Button");
				MethodDef.clickJS(Login.login_submit(), "Submit Button");
				MethodDef.assertContains(Login.pwdError(), "Please enter your password");
				MethodDef.assertContains(Login.secError(), "Please enter your security number");
				MethodDef.sendKeys(Login.login_password(), "PASSWORD");
				CommonDef.waitInVisible(Login.pwdError(), "Password Error");
				List<WebElement> SecNums = CommonDef.findElements(Login.login_securityno());
				for (WebElement temp : SecNums) {
					temp.sendKeys(TestData.getConfig("Security1"));
					break;
				}
				MethodDef.assertContains(Login.secError(), "Please enter your security number");
				for (WebElement temp : SecNums) {
					temp.sendKeys(TestData.getConfig("Security1"));
				}
				CommonDef.waitInVisible(Login.secError(), "Security Error");
				MethodDef.clickJS(Login.login_submit(), "Submit Button");
				MethodDef.assertContains(Login.loginError1(),
						"Some of the information you entered does not match our records. Please try again");
				MethodDef.assertContains(Login.loginError2(),
						"If the problem persists, call us on 0345 08 08 508 and we will help you log in");
			}
		} catch (Exception E) {
			ExReporter.log(LogStatus.FAIL, "End User Login" + E.getMessage());
		}
	}

}
