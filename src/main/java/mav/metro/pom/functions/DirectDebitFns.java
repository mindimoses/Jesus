package mav.metro.pom.functions;

import com.relevantcodes.extentreports.LogStatus;
import mav.metro.framework.ExReporter;
import mav.metro.framework.TestData;
import mav.metro.library.functions.CommonDef;
import mav.metro.library.functions.MethodDef;
import mav.metro.pom.elements.DirectDebit;

public class DirectDebitFns {

	public static void DirectDebit() {
		try {
			if (TestData.getConfig("Action").equals("Active")) {
				CommonDef.waitVisibleNoError(DirectDebit.Validation_Tab_Active());
				CommonDef.moveToElement(DirectDebit.Validation_Tab_Active(), "Active Tab");
				CommonDef.isDisplayed(DirectDebit.Validation_Tab_Active(), "Active Tab Displayed");
				ExReporter.log(LogStatus.PASS, "DirectDebit Active Tab displayed");
			} else if (TestData.getConfig("Action").equals("Cancel")) {
				CommonDef.isDisplayed(DirectDebit.Tab_Cancelled(), "Cancelled Tab Available");
				MethodDef.click(DirectDebit.Tab_Cancelled(), "Cancelled Tab Clicked");
				CommonDef.waitVisibleNoError(DirectDebit.Validation_Tab_Cancelled());
				CommonDef.moveToElement(DirectDebit.Validation_Tab_Cancelled(), "Cancelled Tab");
				CommonDef.isDisplayed(DirectDebit.Validation_Tab_Cancelled(), "Cancelled Tab Displayed ");
				ExReporter.log(LogStatus.PASS, "DirectDebit Cancelled Tab displayed");
			}
		} catch (Exception E) {
			ExReporter.log(LogStatus.FAIL, "DirectDebit" + E.getMessage());
		}
	}

	public static void initDirectDebit() {
		try {
			ExReporter.log(LogStatus.INFO, "Initiating DirectDebit");
			MethodDef.click(DirectDebit.Link_Payments_Arrow(), "Payments & Transfers arrow Clicked");
			MethodDef.click(DirectDebit.Link_Direct_Debit(), "Direct Debit Link Clicked");
			CommonDef.waitVisibleNoError(DirectDebit.Validation_Direct_Debit_Page());
			MethodDef.clickJS(DirectDebit.List_Select_An_Account(), "Account Selection Link Clicked");
			MethodDef.clickJS(DirectDebit.List_AccDropdown(), "Account Selector Clicked");
			MethodDef.click(DirectDebit.Link_AccountNum(), "Account Number Link Clicked");
			MethodDef.sendKeys(DirectDebit.Txt_EnterAccNum(), TestData.getConfig("From_Ac"));
			MethodDef.click(DirectDebit.Btn_Search_Popup(), "Search Button Clicked");
			MethodDef.clickJS(DirectDebit.Select_Click_AccNum(TestData.getConfig("From_Ac")),
					"Account Number Selected");
			ExReporter.log(LogStatus.INFO, "DirectDebit Account Number Selected Successfully");
		} catch (Exception e) {
			ExReporter.log(LogStatus.ERROR, "Direct debit initiation failed: " + e.getMessage());
		}
	}
}
