package mav.metro.pom.elements;

import mav.metro.library.functions.CommonDef;
import mav.metro.utilities.enums.Locators;
import org.openqa.selenium.By;

public class FXRates extends DirectDebit {

	public static By Link_FXRates() {
		return CommonDef.locatorValue(Locators.PARTIAL_LINKTEXT, "FX Rates");
	}

	public static By Validation_FXRates_Page() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='lp-content-block met-heading-text']/h3[contains(.,'FX Rates')]");
	}

	public static By Validation_FXRates_For_Payments_TableView() {
		return CommonDef.locatorValue(Locators.XPATH, "//table[@class='table']/tbody/tr");
	}

	public static By Tab_FXRates_For_Cash() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//ul[@class='nav nav-tabs hidden-xs hidden-sm']//a[contains(.,'FX Rates for Cash')]");
	}

	public static By Validation_FXRates_For_Cash_TableView() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area tab-pane active']//table[@class='table']/tbody/tr");
	}

	public static By tableValues() {
		return CommonDef.locatorValue(Locators.CSS,
				"div.tab-pane.active .widget-metro-fx-rates table tr > td");
	}

}
