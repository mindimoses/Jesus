package mav.metro.pom.elements;

import mav.metro.framework.TestData;
import mav.metro.library.functions.CommonDef;
import mav.metro.utilities.enums.Locators;
import org.openqa.selenium.By;

public class BatchGroup extends AlertsNot {
	public static By bengrp_link() {
		return CommonDef.locatorValue(Locators.XPATH, "//i[@class='fa fa-book']/ancestor::a//div[@class='tab-arrow']");
	}
	
	public static By bengrp_linkCaretOpen() {
		return CommonDef.locatorValue(Locators.CSS, "fa fa-lg toggle fa-caret-down']");
	}
	

	public static By bengrp_batchLink() {
		return CommonDef.locatorValue(Locators.PARTIAL_LINKTEXT, "Batch Payments Groups");
	}

	public static By Validation_PageBeneficiaryGrp() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='lp-content-block met-heading-text']/h3[.='Batch Payments Groups']");
	}

	public static By bengrp_batchButton() {
		return CommonDef.locatorValue(Locators.XPATH, "//button[contains(.,'Create Batch Payment Group')]");
	}

	public static By bengrp_title() {
		return CommonDef.locatorValue(Locators.XPATH, "//input[@data-label='Please enter a title']");
	}

	public static By bengrp_addBeneficiary() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area active']//button[contains(.,'Add Beneficiaries')]");
	}

	public static By bengrp_selectBeneficiary() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='table-responsive table-scrollable']//td[contains(.,'"
						+ TestData.getConfig("Beneficiary Name") + "')]//following::td/button");
	}

	public static By bengrp_addSelected() {
		return CommonDef.locatorValue(Locators.LINKTEXT, "Add selected");
	}

	public static By bengrp_create() {
		return CommonDef.locatorValue(Locators.CSS,
				"div.ng-scope .button-bar.ng-scope[ng-if='mainCtrl.createMode'] button[ng-if*='create']");
	}

	public static By bengrp_close() {
		return CommonDef.locatorValue(Locators.CSS, ".lp-lightbox-on button.lp-widget-control.lp-lightbox-close");
	}

	public static By bengrp_tbl_data() {
		return CommonDef.locatorValue(Locators.CSS,
				"form.ng-valid-required div.row.detail-beneficiaries-add tbody tr td");
	}

	public static By Validation_CreateBeneficiary() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//span[@class='message ng-binding']/p[contains(.,'You have successfully created this batch payment group')]");
	}

	public static By bengrp_titleName() {
		return CommonDef.locatorValue(Locators.CSS, "form.ng-valid-required .group-title.ng-scope div.name");
	}

	public static By bengrp_message() {
		return CommonDef.locatorValue(Locators.CSS,
				"li[data-notification-id='CREATE_GROUP_BENEFICIARY_SUCCESS'] span.detail");
	}

	// -------------------------------Search-----------------------------
	public static By Txt_bengrp_SearchGroupName() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='col-md-6']//input[@class='form-control ng-pristine ng-valid-pattern ng-valid ng-valid-required']");
	}

	public static By Btn_bengrp_Search() {
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='row search ng-scope']//span[.='Search']");
	}

	public static By Validation_SearchPage() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//span[@class='message ng-binding']/p[contains(.,'Please see the following')]");
	}

	// ---------------------------------Click Group-----------------------
	public static By Link_bengrp_ClickGrp() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//td[@class='ng-binding' and contains(.,'" + TestData.getConfig("BenGroupName") + "')]");
	}
	
	public static By Link_bengrp_ClickGrp(String gname) {
		return CommonDef.locatorValue(Locators.XPATH,
				"//td[@class='ng-binding' and contains(.,'" + gname + "')]");
	}

	public static By Validation_BatchPaymentTblPage() {
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='--area bp-area active']//table/tbody/tr");
	}

	public static By Validation_ClickGrpPage1() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area active']//div[@class='row detail-beneficiaries']//table/tbody/tr");
	}

	public static By Validation_ClickGrpPage2() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='lp-content-block met-heading-text']/h3[contains(.,'Batch Payment Group Details')]");
	}

	public static By Btn_bengrp_Amend() {
		return CommonDef.locatorValue(Locators.XPATH, "//button[contains(.,'Amend')]");
	}

	public static By Btn_bengrp_AmendUpdate() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area active']//button[@class='btn btn-primary pull-right ng-scope']");
	}

	public static By Validation_bengrp_AmendUpdated() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//span[@class='message ng-binding']/p[contains(.,'This batch payment group is now updated.')]");
	}

	public static By Btn_bengrp_Delete() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='button-bar ng-scope']/button[contains(.,'Delete')]");
	}

	public static By Validation_ClickGrp_DeletePopup() {
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='modal fade in']//div/span[.='Delete']");
	}

	public static By Btn_ClickGrp_DeleteBtnPopupWindow() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='modal fade in']//button[@class='btn btn-primary pull-right']");
	}

	public static By Validation_ClickGrp_DeletedMsg() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='metro-notification-message']/span/p[contains(.,'This batch payment group')]");
	}

	public static By link_ClickGrp_CloseDeletePopupWindow() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='modal fade in']//button[@class='close lightbox-close-x']");
	}

	public static By searchFail() {
		return CommonDef.locatorValue(Locators.CSS, ".warning .message.ng-binding");
	}

	public static By searchTableData() {
		return CommonDef.locatorValue(Locators.CSS, ".row.results.ng-scope td");
	}

}
