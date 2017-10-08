package mav.metro.pom.functions;

import com.relevantcodes.extentreports.LogStatus;
import mav.metro.framework.ExReporter;
import mav.metro.framework.TestData;
import mav.metro.library.functions.CommonDef;
import mav.metro.library.functions.MethodDef;
import mav.metro.pom.elements.MyAccounts;

public class MyAccountsFns {

	public static void MyAccounts() {

		try {
			String accDet = TestData.getConfig("EnterAccountDetails");

			if (TestData.getConfig("AccountDropdown").equalsIgnoreCase("AccountName")) {
				ExReporter.log(LogStatus.INFO, "Searching by Account Name");
				MethodDef.click(MyAccounts.List_Account_Dropdown(), "Account Dropdown Clicked");
				MethodDef.click(MyAccounts.Link_Account_Name(), "Account Name Option Selected");
				MethodDef.sendKeys(MyAccounts.Text_Account_Name(), accDet);
				MethodDef.click(MyAccounts.Btn_Search(), "Search Button Clicked");
				CommonDef.isDisplayed(MyAccounts.Validation_SearchSuccess1(), "Searched Successfully");
				CommonDef.assertContains(
						MyAccounts.Validation_SearchSuccess2(TestData.getConfig("EnterAccountDetails")),
						TestData.getConfig("EnterAccountDetails"));
				CommonDef.assertContains(MyAccounts.validSearchResultName(), accDet, "Valid Search Entry is returned");
				// ExReporter.log(LogStatus.PASS, "Account Name Searched
				// Successfully ");
			} else if (TestData.getConfig("AccountDropdown").equalsIgnoreCase("AccountNumber")) {
				ExReporter.log(LogStatus.INFO, "Searching by Account Number");
				MethodDef.click(MyAccounts.List_Account_Dropdown(), "Account Dropdown Clicked");
				MethodDef.click(MyAccounts.Link_Account_Number(), "Account Number Option Selected");
				MethodDef.sendKeys(MyAccounts.Text_Account_Number(), TestData.getConfig("EnterAccountDetails"));
				MethodDef.click(MyAccounts.Btn_Search(), "Search Button Clicked");
				CommonDef.isDisplayed(MyAccounts.Validation_SearchSuccess1(), "Searched Successfully");
				CommonDef.assertContains(
						MyAccounts.Validation_SearchSuccess2(TestData.getConfig("EnterAccountDetails")),
						TestData.getConfig("EnterAccountDetails"));
				CommonDef.assertContains(MyAccounts.validSearchResultNum(), accDet, "Valid Search Entry is returned");
				ExReporter.log(LogStatus.PASS, "Account Number Searched Successfully ");
			}
			if (TestData.getConfig("AccountDropdown").equalsIgnoreCase("Click")) {

				ExReporter.log(LogStatus.INFO, "Searching by Clicking Account Number");
				MethodDef.clickJS(MyAccounts.Link_AccNoClick(TestData.getConfig("EnterAccountDetails")),
						"Account Number Link Clicked");
				CommonDef.waitVisibleNoError(MyAccounts.Validation_ClickedSearchSuccess());
				MethodDef.clickJS(MyAccounts.Link_AccountInfo(), "Account Info displayed");
				CommonDef.assertContains(MyAccounts.accountInfoText(), TestData.getConfig("screen_Name"),
						"Account Information is displayed");
				ExReporter.log(LogStatus.PASS, "Account Number Link Clicked Successfully ");
			}

		} catch (Exception E) {
			ExReporter.log(LogStatus.FAIL, "MyAccounts" + E.getMessage());
		}
	}

	public static void myAccountVal() {
		try {
			System.out.println("inside my account");
			CommonDef.isDisplayed(MyAccounts.Validation_MyAccountsPage1(), "MyAccounts Page Available");
			CommonDef.isDisplayed(MyAccounts.Validation_MyAccountsPage2(), "Business Current Accounts displayed");
			CommonDef.waitVisibleNoError(MyAccounts.Validation_MyAccountsPage3Table());
		} catch (Exception e) {
			ExReporter.log(LogStatus.ERROR, "My Accounts page is not available: " + e.getMessage());
		}
	}
}