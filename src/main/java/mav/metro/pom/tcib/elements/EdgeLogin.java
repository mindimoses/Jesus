package mav.metro.pom.tcib.elements;
import mav.metro.library.functions.CommonDef;
import mav.metro.utilities.enums.Locators;
import org.openqa.selenium.By;


public class EdgeLogin {

	
	public static By EdgeLogin_userid() {
		return CommonDef.locatorValue(Locators.ID, "QUE_F1C99D49CB9A0C28150901");
	}
	public static By EdgeLogin_password() {
		return CommonDef.locatorValue(Locators.ID, "QUE_F1C99D49CB9A0C28150902");
	}
	public static By EdgeLogin_login() {
		return CommonDef.locatorValue(Locators.ID, "BUT_F1C99D49CB9A0C28150903");
	}
	public static By EdgeLogin_logout() {
		return CommonDef.locatorValue(Locators.ID, "BUT_420E07161E0F21C79373");
	}
	public static By EdgeLogin_AdminLink() {
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='BUT_420E07161E0F21C79313']/span");
	}
}
