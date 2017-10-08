package mav.metro.pom.tcib.elements;

import mav.metro.library.functions.CommonDef;
import mav.metro.utilities.enums.Locators;

import org.openqa.selenium.By;

public class Login extends BasePage {

	

	public static By login_userid() {
		return CommonDef.locatorValue(Locators.ID, "USER_NAME");
	}

	public static By login_remember() {
		return CommonDef.locatorValue(Locators.XPATH, "//span[contains(.,'Remember me')]");
	}

	public static By login_continue() {
		return CommonDef.locatorValue(Locators.XPATH, "//button[@value='Continue']");
	}

	public static By login_submit() {
		return CommonDef.locatorValue(Locators.CSS, ".customer-security button[type='submit']");
	}

	public static By login_password() {
		return CommonDef.locatorValue(Locators.ID, "LOGIN_PASSWORD");
	}


	public static By login_securityno() {
		return CommonDef.locatorValue(Locators.TAG_NAME, "Select");
	}

	public static By login_login() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//button[@value='Log in']");
	}

	public static By login_viewmyaccounts() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//button[@value='View my accounts']");
	}

	public static By login_AnnouncementWrapper() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[contains(@data-pid,'announcements-layout')]//div[@class='bp-area --area announcements']");
	}

	public static By login_companySelWrapper() {
		return CommonDef.locatorValue(Locators.CSS, ".list-group.ng-scope");
	}

	public static By login_Dashboard() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@input-placeholder='Enter Account Name']//span[.='Search']");
	}

	public static By login_DashboardTab() {
		return CommonDef.locatorValue(Locators.CSS, ".accordion-toggle");
	}

	public static By logoutPopup_button() {
		return CommonDef.locatorValue(Locators.ID, "BUT_8F68D8857A998BAA257800");
	}
	public static By logout_button() {
		return CommonDef.locatorValue(Locators.XPATH, "//button[@value='Log out']");
	}

	
	public static By devLogOutToggle() {
		return CommonDef.locatorValue(Locators.CSS, ".navbar-header button.toggler-navigation");
	}

	public static By logout_confirmation() {
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='modal fade in']//button[.='Log Out']");
	}

	public static By assertion() {
		return CommonDef.locatorValue(Locators.CSS, ".mb-content h3");
	}

	public static By Link_ForgottenDetails() {
		return CommonDef.locatorValue(Locators.XPATH, "//a[contains(.,'Forgotten your details?')]");
	}

	public static By Validation_LoginFailed() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//p[contains(.,'Some of the information you entered does not match our records')]");
	}

	public static By ibidError() {
		return CommonDef.locatorValue(Locators.CSS, "form[name='customerNoForm'] p.msg-error:not([class*='ng-hide'])");
	}

	public static By pwdError() {
		return CommonDef.locatorValue(Locators.CSS, "form[name='securityForm'] p.msg-error:not([class*='ng-hide'])");
	}

	public static By loginBack() {
		return CommonDef.locatorValue(Locators.CSS, "button[ng-click='prevStep()']");
	}

	public static By secError() {
		return CommonDef.locatorValue(Locators.CSS, "form[name='securityForm2'] p.msg-error:not([class*='ng-hide'])");
	}

	public static By loginError1() {
		return CommonDef.locatorValue(Locators.CSS, "div[ng-bind-html] p:nth-child(1)");
	}

	public static By loginError2() {
		return CommonDef.locatorValue(Locators.CSS, "div[ng-bind-html] p:nth-child(2) span");
	}
	
	//R8
	
	public static By login_Cookie() {
		return CommonDef.locatorValue(Locators.ID, "js-mbCookieNotice-button");
	}
	
}
