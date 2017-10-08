package mav.metro.pom.elements;

import mav.metro.framework.TestData;
import mav.metro.library.functions.CommonDef;
import mav.metro.utilities.enums.Locators;
import org.openqa.selenium.By;

public class SearchCompanies extends MyAccounts {

	public static By Validation_SearchCompPage() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='lp-page-children bp-area --area']//li[@class='link-from-server  ']/a/span[contains(.,'Dashboard')]/parent::a");
	}

	public static By Link_Dashboard() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='lp-page-children bp-area --area']//li[@class='link-from-server  ']/a/span[contains(.,'Dashboard')]");
	}

	public static By Btn_Search_SC() {
		if (TestData.getConfig("User").contains("Multi"))
			return CommonDef.locatorValue(Locators.XPATH,
					"//div[@class='container']//div[@class='search-row ng-scope']//span[@class='input-group-btn']/button/span[contains(.,'Search')]");
		else
			return CommonDef.locatorValue(Locators.CSS,
					".pageContainer div.search-row.ng-scope button > span[ng-hide='smallSearch']");
	}

	public static By Validation_Search_Result() {
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='panel-heading']//h4");
	}

	public static By Btn_DashboardClick() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='box companies']/div/h2/following::div[contains(.,'COMPANIES')]");
	}

	public static By Txt_Popup_EnterCompanyName() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='modal-content']//div[@class='input-group']/input[@class='form-control ng-pristine ng-valid ng-valid-required']");
	}

	public static By Btn_Popup_SearchCompanyName() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='modal-content']//div[@class='input-group']/span/following::span/button/span[contains(.,'Search')]");
	}

	public static By Validation_SearchCompanyNameSuccess(String data) {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='modal-content']//div/a[contains(.,'" + data + "')]");
	}

	public static By Link_Popup_Close() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='modal-content']/button[@class='close lightbox-close-x']");
	}

	public static By linkTestAccNum() {
		return CommonDef.locatorValue(Locators.CSS, "td[ng-if='account.businessKey'] a");
	}

	public static By searchArea() {
		return CommonDef.locatorValue(Locators.CSS, "div[icon='search']");
	}

	public static By companyWarn() {
		return CommonDef.locatorValue(Locators.CSS, "div.metro-notification.ng-scope:not([class*='ng-hide']");
	}

	public static By companyDashWarn() {
		return CommonDef.locatorValue(Locators.CSS,
				"div.panel.search.ng-scope div.metro-notification.ng-scope .metro-notification-message span");
	}

	public static By companyDashRes() {
		return CommonDef.locatorValue(Locators.CSS, "tr[ng-repeat='account in searchResult']");
	}

}
