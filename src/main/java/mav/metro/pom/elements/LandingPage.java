package mav.metro.pom.elements;

import mav.metro.library.functions.CommonDef;
import mav.metro.utilities.enums.Locators;
import org.openqa.selenium.By;

public class LandingPage extends BasePage {

	public static By Link_Home() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='collapse navbar-collapse']//span[contains(.,'Home')]");
	}

	public static By Validation_Link_Home() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='collapse navbar-collapse']//span[contains(.,'Home')]/parent::a");
	}

	public static By Link_StoreLocator() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='login-info-links container hidden-xs']//span[contains(.,'Store Locator')]");
	}

	public static By Validation_Link_StoreLocator() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='login-info-links container hidden-xs']//span[contains(.,'Store Locator')]/parent::a");
	}

	public static By Link_NewCustomer() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='collapse navbar-collapse']//span[contains(.,'New Customer')]");
	}
	
	public static By Link_PersonalInternetBanking() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='collapse navbar-collapse']//span[contains(.,'Personal Internet Banking')]");
	}

	public static By Validation_Link_NewCustomer() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='collapse navbar-collapse']//span[contains(.,'New Customer')]/parent::a");
	}

	public static By Link_LegalInformation() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//span[contains(.,'Legal information')]");
	}

	public static By Link_SecurityAndPrivacy() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//span[contains(.,'Security & Privacy')]");
	}

	public static By Link_helpAndInfo() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='login-info-links container hidden-xs']//span[contains(.,'Help & Information')]");
	}

	public static By Link_contactUs() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='login-info-links container hidden-xs']//span[contains(.,'Contact us')]");
	}

}
