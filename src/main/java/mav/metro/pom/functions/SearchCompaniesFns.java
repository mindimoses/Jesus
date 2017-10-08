package mav.metro.pom.functions;

import com.relevantcodes.extentreports.LogStatus;
import mav.metro.framework.ExReporter;
import mav.metro.framework.TestData;
import mav.metro.library.functions.CommonDef;
import mav.metro.library.functions.MethodDef;
import mav.metro.pom.elements.SearchCompanies;

public class SearchCompaniesFns {

	public static void SearchCompanies() {
		try {
			/*
			 * if
			 * (CommonDef.getAttribute(SearchCompanies.Validation_SearchCompPage
			 * (), "href") .contains(TestData.getConfig("Page_Validation"))) {
			 * ExReporter.log(LogStatus.PASS,
			 * "Search Companies Page Available"); } else {
			 * ExReporter.log(LogStatus.FAIL,
			 * "Search Companies Page not Available"); }
			 */
			MethodDef.click(SearchCompanies.Link_Dashboard(), "Dashboard Link Clicked");

			if (TestData.getConfig("SearchType").equalsIgnoreCase("AccountName")) {
				String account = TestData.getConfig("AccountData");
				ExReporter.log(LogStatus.INFO, "Searching by Account Name");
				MethodDef.click(SearchCompanies.List_Account_Dropdown(), "Account Dropdown Clicked");
				MethodDef.click(SearchCompanies.Link_Account_Name(), "Account Name Option Selected");
				MethodDef.sendKeys(SearchCompanies.Text_Account_Name(), account);
				MethodDef.click(SearchCompanies.Btn_Search_SC(), "Search Button CLicked");
				CommonDef.waitVisible(SearchCompanies.searchArea());
				MethodDef.assertContains(SearchCompanies.Validation_Search_Result(), TestData.getConfig("Search_Page"),
						"Search result Loaded");
				MethodDef.assertContains(SearchCompanies.Validation_Search_Result(), account,
						"Search result Loaded for correct data");
				MethodDef.assertContains(SearchCompanies.linkTestAccNum(), account);
			} else if (TestData.getConfig("SearchType").equalsIgnoreCase("AccountNumber")) {
				ExReporter.log(LogStatus.INFO, "Searching by Account Number");
				MethodDef.click(SearchCompanies.List_Account_Dropdown(), "Account Dropdown Clicked");
				MethodDef.click(SearchCompanies.Link_Account_Number(), "Account Number Option Selected");
				MethodDef.sendKeys(SearchCompanies.Text_Account_Number(), TestData.getConfig("AccountData"));
				MethodDef.click(SearchCompanies.Btn_Search_SC(), "Search Button Clicked");
				CommonDef.waitVisible(SearchCompanies.searchArea());
				MethodDef.assertContains(SearchCompanies.Validation_Search_Result(), TestData.getConfig("Search_Page"),
						"Search result Loaded");
				MethodDef.assertContains(SearchCompanies.Validation_Search_Result(), TestData.getConfig("AccountData"),
						"Search result Loaded for correct AccountNumber");
				if(TestData.getConfig("NegInd").equalsIgnoreCase("NegInd")) {
					MethodDef.assertContains(SearchCompanies.companyDashWarn(), "No results found");
				}
			} else if (TestData.getConfig("SearchType").equalsIgnoreCase("Customer")) {
				ExReporter.log(LogStatus.INFO, "Searching by Customer");
				MethodDef.click(SearchCompanies.Btn_DashboardClick(), "Dashboard button Clicked");
				MethodDef.sendKeys(SearchCompanies.Txt_Popup_EnterCompanyName(), TestData.getConfig("CustomerData"));
				MethodDef.click(SearchCompanies.Btn_Popup_SearchCompanyName(), "Search Customer Button Clicked");
				if (TestData.getConfig("NegInd").equalsIgnoreCase("NegInd")) {
					MethodDef.assertContains(SearchCompanies.companyWarn(), "No results found");
				} else
					CommonDef.isDisplayed(
							SearchCompanies.Validation_SearchCompanyNameSuccess(TestData.getConfig("CustomerData")),
							"Searched Company Successfully ");
				MethodDef.click(SearchCompanies.Link_Popup_Close(), "Dashboard Popup Window Closed");
			}
		} catch (Exception E) {
			ExReporter.log(LogStatus.FAIL, "Error accessing Dashboard screen for search: " + E.getMessage());
		}
	}
}
