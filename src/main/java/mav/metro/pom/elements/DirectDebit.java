package mav.metro.pom.elements;

import mav.metro.library.functions.CommonDef;
import mav.metro.utilities.enums.Locators;
import org.openqa.selenium.By;

public class DirectDebit extends MyAccounts {

	
	public static By Link_Payments_Arrow() {
		return CommonDef.locatorValue(Locators.XPATH, "//div[contains(.,'Payments')]/following-sibling::div/i[@class='fa fa-lg fa-caret-right toggle']");
	}
	
	public static By Link_Direct_Debit() {
		return CommonDef.locatorValue(Locators.PARTIAL_LINKTEXT, "Direct Debits");
	}
	public static By Validation_Direct_Debit_Page() {
		return CommonDef.locatorValue(Locators.CSS,"button[name='accountId']:not([disabled])");
	}
	public static By List_Select_An_Account() {
		return CommonDef.locatorValue(Locators.XPATH, "//button[@class='btn btn-default dropdown-toggle']");
	}
	public static By List_AccDropdown() {
		return CommonDef.locatorValue(Locators.XPATH,"//div[@class='modal-content']//button[@id='selectSearchType']");
	}
	public static By Link_AccountNum() {
		return CommonDef.locatorValue(Locators.XPATH, "//a[.='Account Number']");
	}
	
	public static By Txt_EnterAccNum() {
		return CommonDef.locatorValue(Locators.XPATH, "//input[@name='search' and @placeholder='Search by Account Number']");
	}
	
	public static By Btn_Search_Popup() {
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='metro-search-component ng-isolate-scope ng-dirty ng-valid ng-valid-required']//span[@class='hidden-xs ng-binding']");
	}
	public static By Select_Click_AccNum(String AccNum) {
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='lp-account-select-popup ng-scope']/table/tbody/tr/td[@class='hidden-xs ng-binding ng-scope' and contains(.,'"+AccNum+"')]");
	}
	public static By Tab_Active() {
		return CommonDef.locatorValue(Locators.XPATH, "//ul[@class='nav nav-tabs hidden-xs hidden-sm']//li[@class='--tab']//a[@class='--lp-i18n' and .='Active']");
	}
	public static By Validation_Tab_Active() {
		return CommonDef.locatorValue(Locators.XPATH, "//tr[@ng-repeat='item in mainCtrl.directDebitsModel.directDebits']");
	}
	public static By Tab_Cancelled() {
		return CommonDef.locatorValue(Locators.XPATH, "//ul[@class='nav nav-tabs hidden-xs hidden-sm']//li[@class='--tab']//a[@class='--lp-i18n' and .='Cancelled']");
	}
	
	public static By Validation_Tab_Cancelled() {
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='--area bp-area tab-pane active']//table[@class='table ng-scope']//tr");
	}
	
	
	
	
	
	
	
}
