package mav.metro.pom.elements;

import mav.metro.library.functions.CommonDef;
import mav.metro.utilities.enums.Locators;
import org.openqa.selenium.By;

public class Dashboard extends MyAccounts {
	
	public static By Link_Dashboard_DropdownDetails(String drop) {
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='td td-number hidden-xs hidden-sm']/a[contains(.,'"+drop+"')]/parent::div/parent::div/div[@class='td td-expand hidden-xs hidden-sm']/a[@class='btn btn-link expand fa fa-chevron-down']");
	}
	
	public static By Validation_Dashboard_1() {
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='td td-details']");
	}
	public static By Validation_Dashboard_2() {
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='td td-details']//dt[.='BIC Code']");
	}

	
}
