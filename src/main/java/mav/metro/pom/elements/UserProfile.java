package mav.metro.pom.elements;

import mav.metro.library.functions.CommonDef;
import mav.metro.utilities.enums.Locators;
import org.openqa.selenium.By;

public class UserProfile {
	
	
	public static By Link_UserProfile() {
		return CommonDef.locatorValue(Locators.XPATH, "//i[@class='fa fa-cog']");
	}
	public static By Validation_Link_UserProfile() {
		return CommonDef.locatorValue(Locators.XPATH, "//i[@class='fa fa-cog']/parent::span/parent::a");
	}
	
	public static By Validation_Page_UserProfile() {
		return CommonDef.locatorValue(Locators.XPATH, "//span[@class='header-label' and contains(.,'Customer No.')]");
	}
	public static By Btn_ChangePassword() {
		return CommonDef.locatorValue(Locators.XPATH, "//button[@class='btn btn-default btn-change' and contains(.,'Change')]");
	}
	public static By Txt_OldPassword() {
		return CommonDef.locatorValue(Locators.XPATH, "//input[@name='oldPassword']");
	}
	public static By Txt_NewPassword() {
		return CommonDef.locatorValue(Locators.XPATH, "//input[@name='newPassword']");
	}
	public static By Txt_ReEnterNewPassword() {
		return CommonDef.locatorValue(Locators.XPATH, "//input[@name='verifyPassword']");
	}
	public static By Btn_Update() {
		return CommonDef.locatorValue(Locators.XPATH, "//button[@class='btn btn-primary pull-right' and contains(.,'Update')]");
	}
	public static By Validation_PasswordChanged() {
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='alert alert-success' and contains(.,'Your password has been changed')]");
	}
	public static By Validation_PasswordChangeFailed() {
		return CommonDef.locatorValue(Locators.XPATH, "//p[@class='msg-error' and contains(.,'Passwords do not match')]");
	}
	
}
