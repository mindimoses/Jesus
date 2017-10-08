package mav.metro.pom.elements;

import mav.metro.library.functions.CommonDef;
import mav.metro.utilities.enums.Locators;
import org.openqa.selenium.By;

public class Beneficiaries extends BasePage {

	public static By bengrp_link() {
		return CommonDef.locatorValue(Locators.CSS, "a[href='/portalserver/beneficiaries']");

	}

	public static By bengrp_dashboard() {
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='tab-pane ng-scope active']//table/tbody/tr");
	}

	public static By bengrp_beneficiaryButton() {
		return CommonDef.locatorValue(Locators.CSS, "div[ng-if*='CreateBeneficiary'] button");
	}

	public static By bengrp_domName() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area active']//form[@name='domForm']//input[@id='title']");
	}

	public static By bengrp_domnickName() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area active']//form[@name='domForm']//input[@id='nickname']");
	}

	public static By bengrp_domSortCode() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area active']//form[@name='domForm']//input[@id='sortCode']");
	}

	public static By bengrp_domAccountNumber() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area active']//form[@name='domForm']//input[@id='accountNumber']");
	}

	public static By bengrp_domReference() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area active']//form[@name='domForm']//input[@id='item']");
	}

	public static By bengrp_domSave() {
              return CommonDef.locatorValue(Locators.CSS,
                           ".--area.bp-area.active #DOM div[ng-show='step === 1'] .btn.btn.btn-primary.pull-right:not([disabled])");
       }

	public static By bengrp_domhardToken() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area active']//input[@ng-model='domCtrl.model.hardToken']");
	}

	public static By bengrp_domsubmit() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area active']//button[@ng-click='domCtrl.submit($event)']");
	}

	public static By bengrp_domBeneCreated() {
		return CommonDef.locatorValue(Locators.CSS,
				"div[ng-show='domCtrl.dataModel.success'] li[data-notification-id='CREATE_BEN_SUCCESS'] span.message");
	}

	public static By bengrp_intTab() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area active']//a[@data-toggle='tab' and contains(.,'International')]");
	}

	public static By bengrp_intName() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area active']//form[@name='intForm']//input[@id='title']");
	}

	public static By bengrp_intnickName() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area active']//form[@name='intForm']//input[@id='nickname']");
	}

	public static By bengrp_intAddress() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area active']//form[@name='intForm']//input[@id='address1']");
	}

	public static By bengrp_intSwiftCode() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area active']//form[@name='intForm']//input[@id='BIC']");
	}

	public static By bengrp_intIBAN() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area active']//form[@name='intForm']//input[@id='IBAN']");
	}

	public static By bengrp_intReference() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area active']//form[@name='intForm']//input[@id='item']");
	}

	public static By bengrp_intSave() {
              return CommonDef.locatorValue(Locators.CSS,
                           ".--area.bp-area.active #INT input[value='Save']:not([disabled])");
       }

	public static By bengrp_inthardToken() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area active']//input[@ng-model='intCtrl.model.hardToken']");
	}

	public static By bengrp_intsubmit() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area active']//button[@ng-click='intCtrl.submit($event)']");
	}

	public static By bengrp_intBeneCreated() {
		return CommonDef.locatorValue(Locators.CSS,
				"div[ng-show='intCtrl.dataModel.success'] li[data-notification-id='CREATE_BEN_SUCCESS'] span.message");
	}

	public static By bengrp_billerTab() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area active']//a[@data-toggle='tab' and contains(.,'Biller')]");
	}

	public static By bengrp_billSelectCom() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area active']//input[@value='Select Company']");
	}

	public static By bengrp_billInputCom() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='modal fade in']//input[@placeholder='Enter company name']");
	}

	public static By bengrp_billClickCom(String company) {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='modal fade in']//td[contains(.,'" + company + "')]");
	}

	public static By bengrp_bilnickName() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area active']//form[@name='bilForm']//input[@id='nickname']");
	}

	public static By bengrp_bilReference() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area active']//form[@name='bilForm']//input[@id='item']");
	}

	public static By bengrp_billSave() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area active']//div[@id='BIL']//input[@value='Save']");
	}

	public static By bengrp_billhardToken() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area active']//input[@ng-model='bilCtrl.model.hardToken']");
	}

	public static By bengrp_billsubmit() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area active']//button[@ng-click='bilCtrl.submit($event)']");
	}

	public static By benefCreated() {
		return CommonDef.locatorValue(Locators.CSS, ".metro-notification[data-ng-hide] .info p span");
	}
	
	public static By bengrp_billBeneCreated() {
		return CommonDef.locatorValue(Locators.CSS,
				"div[ng-show='bilCtrl.dataModel.success'] li[data-notification-id='CREATE_BEN_SUCCESS'] span.message");
	}

	public static By Btn_ItemMgmt() {
		return CommonDef.locatorValue(Locators.XPATH, "//span[.='Item Management']");
	}

	public static By Link_Tabs() {
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='dashboard-nav ng-scope']");
	}

	public static By Link_VerifTab() {
		return CommonDef.locatorValue(Locators.PARTIAL_LINKTEXT, "Verifications");
	}

	public static By bengrp_beneficiaryDrop() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='tab-pane ng-scope active']//div[@class='panel-heading']//h4[contains(.,'Beneficiaries')]");
	}

	public static By bengrp_decisionItem(String reference, String decision, int size) {             
                     return CommonDef.locatorValue(Locators.XPATH,"//span[contains(.,'" + reference + "')]/parent::td/following-sibling::td//button[@class='btn btn-sm " + decision + "-item']");
       }

	public static By bengrp_decisionItem(String reference, String decision) {
		return CommonDef.locatorValue(Locators.XPATH, "//span[contains(.,'" + reference
				+ "')]/ancestor::tr//button[@class='btn btn-sm " + decision + "-item']");
	}

	public static By bengrp_intDecision(String reference, String decision, int size) {
		if (size == 1)
			return CommonDef.locatorValue(Locators.XPATH, "//span[contains(.,'" + reference
					+ "')]//ancestor::tr/preceding-sibling::tr//button[@class='btn btn-sm " + decision + "-item']");
		else
			return CommonDef.locatorValue(Locators.XPATH,
					"(//span[contains(.,'" + reference + "')]//ancestor::tr/preceding-sibling::tr)[" + size
							+ "]//button[@class='btn btn-sm " + decision + "-item']");
	}

	public static By bengrp_intDecisiondup(String decision) {
		return CommonDef.locatorValue(Locators.XPATH,
				"//span[contains(.,'Test')]/parent::dd/parent::dl/parent::div/parent::td/parent::tr/preceding-sibling::tr//button[@class='btn btn-sm "
						+ decision + "-item']");
	}

	public static By Btn_Ddown_ItemMgmt() {
		return CommonDef.locatorValue(Locators.CSS, ".expand.fa.fa-chevron-down");
	}

	public static By Btn_confirmDecision(String decision) {
		return CommonDef.locatorValue(Locators.XPATH,
				"//button[@class='btn pull-right " + decision + "-item ng-scope']");
	}

	public static By Lnk_Notific() {
		return CommonDef.locatorValue(Locators.CSS, ".modal.fade.in .notification-item");
	}

	public static By Btn_CloseAppVer() {
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='modal fade in']//button[contains(.,'Close')]");
	}

	public static By bengrp_addBeneficiary() {
		return CommonDef.locatorValue(Locators.XPATH, "//button[contains(.,'Add Beneficiaries')]");
	}

	public static By bengrp_addSelected() {
		return CommonDef.locatorValue(Locators.XPATH, "//a[contains(.,'Add selected')]");
	}

	public static By bengrp_create() {
		return CommonDef.locatorValue(Locators.CSS, ".btn.btn-primary.pull-right.ng-scope.firefinder-match");
	}

	public static By dom_back() {
		return CommonDef.locatorValue(Locators.CSS, "");
	}

	public static By approvalDomtr(String reference) {
		return CommonDef.locatorValue(Locators.XPATH,
				"//span[contains(.,'" + reference + "')]/ancestor::tr/preceding-sibling::tr");
	}

	public static By nickWarning() {
		return CommonDef.locatorValue(Locators.CSS, "div.help-block > div");
	}

	/*
	 * public static By bengrp_link() { return
	 * CommonDef.locatorValue(Locators.CSS, "div.tab-icon-and-title i.fa-book");
	 * }
	 * 
	 * public static By bengrp_batchLink() { return
	 * CommonDef.locatorValue(Locators.PARTIAL_LINKTEXT,
	 * "Batch Payments Groups"); }
	 * 
	 * public static By bengrp_batchButton() { return
	 * CommonDef.locatorValue(Locators.XPATH,
	 * "//button[contains(.,'Create Batch Payment Group')]"); }
	 * 
	 * public static By bengrp_title() { return
	 * CommonDef.locatorValue(Locators.XPATH,
	 * "//input[@data-label='Please enter a title']"); }
	 * 
	 * public static By bengrp_addBeneficiary() { return
	 * CommonDef.locatorValue(Locators.XPATH,
	 * "//button[contains(.,'Add Beneficiaries')]"); }
	 * 
	 * public static By bengrp_addSelected() { return
	 * CommonDef.locatorValue(Locators.XPATH,
	 * "//a[contains(.,'Add selected')]"); }
	 * 
	 * public static By bengrp_create() { return
	 * CommonDef.locatorValue(Locators.CSS,
	 * ".btn.btn-primary.pull-right.ng-scope.firefinder-match"); }
	 * 
	 * public static By dom_back() { return CommonDef.locatorValue(Locators.CSS,
	 * ""); }
	 */
}
