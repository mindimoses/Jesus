package mav.metro.pom.elements;

import mav.metro.library.functions.CommonDef;
import mav.metro.utilities.enums.Locators;
import org.openqa.selenium.By;

public class AlertsNot extends BasePage {
	public static By Link_AlertBell() {
		return CommonDef.locatorValue(Locators.XPATH, "//span/i[@class='fa fa-bell']");
	}

	public static By Link_Itemmgmt() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//span[@class='parent-badge pending']/span[contains(.,'Item Management')]");
	}

	public static By Validation_Itemmgmt() {
		return CommonDef.locatorValue(Locators.XPATH, "//i[@class='fa fa-clock-o']/parent::span/parent::a");
	}

	public static By Validation_AlertBell() {
		return CommonDef.locatorValue(Locators.XPATH, "//i[@class='fa fa-bell']/parent::span/parent::a");
	}

	public static By Validation_ItemmgmtBell() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='lp-content-block met-heading-text']/h3[contains(.,'Item Management')]");
	}

	// ---------------------To be used for Mandates/Access Grp/Beneficiary
	// Grp-----------------
	public static By Tab_Approvals() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='dashboard-nav ng-scope']/ul/li/a[contains(.,'Approvals')]");
	}

	public static By Link_Payments_TransfersDropdown() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='accordion-toggle']/span/i[@class='fa fa-lg fa-caret-down']");
	}

	public static By Link_UserPermissions() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='tab-pane ng-scope active']//h4[contains(.,'User Permissions')]/ancestor::span/following-sibling::span/i");
	}
}
