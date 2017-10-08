package mav.metro.pom.functions;

import com.relevantcodes.extentreports.LogStatus;
import mav.metro.framework.ExReporter;
import mav.metro.framework.TestData;
import mav.metro.library.functions.CommonDef;
import mav.metro.library.functions.MethodDef;
import mav.metro.pom.elements.BatchGroup;
import org.apache.commons.lang3.RandomStringUtils;

public class BatchGroupFns {

	public static void BenefGroup() {

		try {

			navToBatchGroup();

			if (TestData.getConfig("Action").equals("Create")) {
				String title = TestData.getConfig("Title") + RandomStringUtils.random(5, "ABFERPLDBNVJK");
				createBenGroup(title);
				if (TestData.getConfig("Task").equals("Delete")) {
					navToBatchGroup();
					openGroup(title);
					deleteGroup();
				}
			} else if (TestData.getConfig("Action").equals("Search")) {
				searchGroup();
			} else if (TestData.getConfig("Action").equals("Click group")) {
				openGroup(TestData.getConfig("BenGroupName"));
				if (TestData.getConfig("Task").equals("Amend")) {
					amendGroup();
				} else if (TestData.getConfig("Task").equals("Delete")) {
					deleteGroup();
				}
			}

		} catch (Exception E) {
			ExReporter.log(LogStatus.ERROR, "Beneficiary Group can not be created" + E.getMessage());
		}
	}

	private static void createBenGroup(String title) {
		try {
			ExReporter.log(LogStatus.INFO, "Performing Beneficiary Creation");
			MethodDef.click(BatchGroup.bengrp_batchButton(), "Create Beneficiary Group");
			MethodDef.sendKeys(BatchGroup.bengrp_title(), title);
			MethodDef.click(BatchGroup.bengrp_addBeneficiary(), "Add beneficiary");
			MethodDef.click(BatchGroup.bengrp_selectBeneficiary(), "Select beneficiary");
			MethodDef.click(BatchGroup.bengrp_addSelected(), "Add Selected beneficiary");
			MethodDef.click(BatchGroup.bengrp_close(), "close button");
			Thread.sleep(2000);
			MethodDef.clickJS(BatchGroup.bengrp_create(), "Create button");
			CommonDef.isDisplayed(BatchGroup.Validation_CreateBeneficiary(), "Batch payments Link is visible");
			ExReporter.log(LogStatus.PASS, "Beneficiary Created Successfully");
		} catch (Exception E) {
			ExReporter.log(LogStatus.ERROR, "Error creating beneficiary group: " + E.getMessage());
		}
	}

	private static void navToBatchGroup() {
		if (!CommonDef.ObjectExist(BatchGroup.bengrp_linkCaretOpen()))
			MethodDef.click(BatchGroup.bengrp_link(), "Beneficiry Link");
		MethodDef.click(BatchGroup.bengrp_batchLink(), "Batch Payments Groups");
		CommonDef.waitVisibleNoError(BatchGroup.Validation_BatchPaymentTblPage());
		CommonDef.isDisplayed(BatchGroup.Validation_PageBeneficiaryGrp(), "Beneficiary Group Page is visible");
	}

	private static void searchGroup() {
		try {
			ExReporter.log(LogStatus.INFO, "Performing Beneficiary Search");
			MethodDef.sendKeys(BatchGroup.Txt_bengrp_SearchGroupName(), TestData.getConfig("BenGroupName"));
			MethodDef.click(BatchGroup.Btn_bengrp_Search(), "Search button clicked");
			// CommonDef.waitVisible(BatchGroup.Validation_SearchPage());
			// CommonDef.isDisplayed(BatchGroup.Validation_SearchPage(), "Search
			// Successful");
			if (TestData.getConfig("Neg").equalsIgnoreCase("Neg")) {
				CommonDef.waitVisible(BatchGroup.searchFail());
				MethodDef.assertContains(BatchGroup.searchFail(), TestData.getConfig("SMessage"));
			} else {
				CommonDef.waitVisible(BatchGroup.searchTableData());
				CommonDef.isDisplayed(BatchGroup.searchTableData(), "Search result Table data");
			}
			ExReporter.log(LogStatus.PASS, "Beneficiary Searched Successfully");
		} catch (Exception e) {
			ExReporter.log(LogStatus.ERROR, "Error performing search: " + e.getMessage());
		}
	}

	private static void deleteGroup() {
		ExReporter.log(LogStatus.INFO, "Performing Beneficiary Deletion");
		MethodDef.click(BatchGroup.Btn_bengrp_Delete(), "Delete Button Clicked");
		CommonDef.isDisplayed(BatchGroup.Validation_ClickGrp_DeletePopup(), "Delete Window visible");
		MethodDef.click(BatchGroup.Btn_ClickGrp_DeleteBtnPopupWindow(), "Delete button clicked");
		CommonDef.isDisplayed(BatchGroup.Validation_ClickGrp_DeletedMsg(), "Deleted successfully");
		MethodDef.click(BatchGroup.link_ClickGrp_CloseDeletePopupWindow(), "Popup window closed");
		ExReporter.log(LogStatus.PASS, "Beneficiary Deleted Successfully");
	}

	private static void amendGroup() {
		ExReporter.log(LogStatus.INFO, "Performing Beneficiary Amendment");
		MethodDef.clickJS(BatchGroup.Btn_bengrp_Amend(), "Amend Button Clicked");
		MethodDef.clickJS(BatchGroup.bengrp_addBeneficiary(), "Add beneficiary");
		MethodDef.clickJS(BatchGroup.bengrp_selectBeneficiary(), "Select beneficiary");
		MethodDef.clickJS(BatchGroup.bengrp_addSelected(), "Add Selected beneficiary");
		MethodDef.clickJS(BatchGroup.bengrp_close(), "close button");
		CommonDef.waitClickable(BatchGroup.Btn_bengrp_AmendUpdate(), "update button wait");
		MethodDef.clickJS(BatchGroup.Btn_bengrp_AmendUpdate(), "Update button clicked");
		CommonDef.isDisplayed(BatchGroup.Validation_bengrp_AmendUpdated(), "Group Amended successfully");
		ExReporter.log(LogStatus.PASS, "Beneficiary Amended Successfully");
	}

	private static void openGroup(String gName) {
		ExReporter.log(LogStatus.INFO, "Clicking Beneficiary Group");
		MethodDef.sendKeys(BatchGroup.Txt_bengrp_SearchGroupName(), gName);
		MethodDef.click(BatchGroup.Btn_bengrp_Search(), "Search button clicked");
		CommonDef.waitVisible(BatchGroup.Link_bengrp_ClickGrp(gName));
		MethodDef.click(BatchGroup.Link_bengrp_ClickGrp(gName), gName + " Group Clicked");
		CommonDef.waitVisibleNoError(BatchGroup.Validation_ClickGrpPage1());
		CommonDef.isDisplayed(BatchGroup.Validation_ClickGrpPage2(), "Group Clicked Successfully");
		ExReporter.log(LogStatus.PASS, "Beneficiary Group Clicked Successfully");
		CommonDef.scollToPageEnd();
	}

}
