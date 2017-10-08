package mav.metro.pom.elements;

import mav.metro.library.functions.CommonDef;
import mav.metro.utilities.enums.Locators;
import org.openqa.selenium.By;

public class MyAccounts extends BasePage {

	public static By Validation_MyAccountsPage1() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='lp-content-block met-heading-text']/h3[contains(.,'Accounts Summary')]");
	}

	public static By Validation_MyAccountsPage2() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='panel-group']//h4[contains(.,'Business Current Accounts ')]");
	}

	public static By Validation_MyAccountsPage3Table() {
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='table table-hover ng-scope']");
	}

	public static By List_Account_Dropdown() {
		return CommonDef.locatorValue(Locators.ID, "selectSearchType");
	}

	public static By Link_Account_Name() {
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='btn-group open']//a[.='Account Name']");
	}

	public static By Text_Account_Name() {
		return CommonDef.locatorValue(Locators.XPATH, "//input[@name='search' and @placeholder='Enter Account Name']");
	}

	public static By Link_Account_Number() {
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='btn-group open']//a[.='Account Number']");
	}

	public static By Text_Account_Number() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//input[@name='search' and @placeholder='Enter Account Number']");
	}

	public static By Btn_Search() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='met-account-summary']//span/button/span[.='Search']");
	}

	public static By Validation_SearchSuccess1() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='col-xs-8 search-results-label']/p[contains(.,'Search results for')]");
	}

	public static By Validation_SearchSuccess2(String Val) {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@ng-repeat='account in searchResult']//a[.='" + Val + "']");
	}

	public static By Link_AccNoClick(String Acc) {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='table table-hover ng-scope']//div[@class='td td-number hidden-xs hidden-sm']/a[contains(.,'"
						+ Acc + "')]");
	}

	public static By validSearchResultName() {
		return CommonDef.locatorValue(Locators.CSS, "div[ng-repeat] div.td-name a");
	}
	
	public static By validSearchResultNum() {
		return CommonDef.locatorValue(Locators.CSS, "div[ng-repeat] div.td-number a");
	}

	public static By Validation_ClickedSearchSuccess() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='lp-content-block met-heading-text']/h3[contains(.,'Transaction Summary')]");
	}

	public static By Link_AccountInfo() {
		return CommonDef.locatorValue(Locators.XPATH, "//a[contains(.,'Account information')]");
	}

	public static By accountInfoText() {
		return CommonDef.locatorValue(Locators.CSS, "div.account-info h1");
	}
}
