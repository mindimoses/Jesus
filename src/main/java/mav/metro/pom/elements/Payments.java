package mav.metro.pom.elements;

import mav.metro.framework.TestData;
import mav.metro.library.functions.CommonDef;
import mav.metro.utilities.enums.Locators;
import org.openqa.selenium.By;

public class Payments extends BasePage {
	public static By Link_Payments() {
		return CommonDef.locatorValue(Locators.CSS, "a[href='/portalserver/payments-and-transfers']");
	}

	public static By Link_DomPayment() {
		return CommonDef.locatorValue(Locators.XPATH, "//li[@role='presentation']/a[contains(.,'Payments')]");
	}

	public static By Link_IntlPayment() {
		return CommonDef.locatorValue(Locators.XPATH, "//li[@role='presentation']/a[contains(.,'International')]");
	}

	public static By Ddown_FromAcct() {
		return CommonDef.locatorValue(Locators.CSS, "button[name='domesticAccountFrom']:not([disabled])");
	}

	public static By Ddown_FromAcctDev() {
		return CommonDef.locatorValue(Locators.CSS, "div.account-selector .lp-account-select.ng-scope button[type]");
	}
	
	public static By Ddown_FromAcctClearVal() {
		return CommonDef.locatorValue(Locators.XPATH, "//button[@name='domesticAccountFrom']/span[@class='ng-scope']");
	}

	public static By Ddown_PopAcct(String acc) {

		/*return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='modal fade in']//tbody[@class='ng-scope']//td[.='" + acc + "']");*/
		return CommonDef.locatorValue(Locators.XPATH,"//div[@class='modal fade in']//tbody[@class='ng-scope']//td[contains(.,'"+acc+"')]");
		/*
		 * return CommonDef.locatorValue(Locators.XPATH,
		 * "//div[class='modal fade in']//td[text()='" + acc + "']");
		 */
	}
	
	public static By Ddown_PopAcctAmount(String acc) {
		return CommonDef.locatorValue(Locators.XPATH,"//div[@class='modal fade in']//tbody[@class='ng-scope']//td[contains(.,'"+acc+"')]/following-sibling::td[@ng-if='showCurrentBalanceColumn']/span/span");		
	}

	public static By Btn_SelectPayee() {
		return CommonDef.locatorValue(Locators.CSS, ".btn.btn-select-payee");
	}

	public static By Btn_BenDomest() {
		return CommonDef.locatorValue(Locators.CSS, "[role='tablist'] a[data-lp-i18n='Domestic beneficiaries']");
	}

	public static By payeeSelect(String code) {
		/*return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area tab-pane active']//td[.='" + code + "']");*/
		return CommonDef.locatorValue(Locators.XPATH,"//div[@class='--area bp-area tab-pane active']//td[contains(.,'" + code + "')]");
	}

	public static By Btn_BenComAccs() {
		return CommonDef.locatorValue(Locators.CSS, "[role='tablist'] a[data-lp-i18n='Company accounts']");
	}

	public static By Btn_BenComAccsSelect(String code) {
		/*return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area tab-pane active']//td[.='" + code + "']");*/
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area tab-pane active']//td[contains(.,'" + code + "')]");
	}

	public static By Btn_BenBiller() {
		return CommonDef.locatorValue(Locators.CSS, "[role='tablist'] a[data-lp-i18n='Biller Beneficiaries']");
	}

	public static By Btn_BenBillerSelect(String code) {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area tab-pane active']//td[.='" + code + "']");
	}

	public static By Text_PayeeName() {
		return CommonDef.locatorValue(Locators.CSS, "input[name='payeeName']");
	}

	public static By Text_SortCode() {
		return CommonDef.locatorValue(Locators.CSS, "input[name='sortcode']");
	}

	public static By Text_BenAccNum() {
		return CommonDef.locatorValue(Locators.CSS, "input[name='accountNumber']");
	}

	public static By Btn_BenInfoNext() {
		return CommonDef.locatorValue(Locators.CSS, ".btn.btn-primary.btn-next");
	}

	public static By Btn_BenInfoNextDis() {
		return CommonDef.locatorValue(Locators.CSS, ".btn.btn-primary.btn-next[disabled*='disabled']");
	}

	/*
	 * public static By Text_IntlBenName() { return
	 * CommonDef.locatorValue(Locators.ID, "title"); }
	 * 
	 * public static By Text_IntlBenNickName() { return
	 * CommonDef.locatorValue(Locators.ID, "nickname"); }
	 * 
	 * public static By Text_IntlBenAddress() { return
	 * CommonDef.locatorValue(Locators.ID, "address1"); }
	 * 
	 * public static By Text_IntlBicID() { return
	 * CommonDef.locatorValue(Locators.ID, "BIC"); }
	 */

	public static By Btn_FP() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//button[@ng-if='paymentType.enabled'][contains(@class,'ng-valid')][contains(.,'Faster')]");
	}

	public static By Btn_BACKS() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//button[@ng-if='paymentType.enabled'][contains(@class,'ng-valid')][contains(.,'BACS')]");
	}

	public static By Btn_CHAPS() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//button[@ng-if='paymentType.enabled'][contains(@class,'ng-valid')][contains(.,'CHAPS')]");
	}

	public static By Btn_MP() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//button[@ng-if='paymentType.enabled'][contains(@class,'ng-valid')][contains(.,'Metro')]");
	}

	public static By Btn_ACAC() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//button[@ng-if='paymentType.enabled'][contains(@class,'ng-valid')][contains(.,'Transfers')]");
	}

	public static By Text_Amount() {
		return CommonDef.locatorValue(Locators.CSS, ".input-group input[data-label='Amount*']");
	}

	public static By Btn_Date() {
		return CommonDef.locatorValue(Locators.CSS, "span.calendar-icon");
	}

	public static By Btn_DateFwdMonth() {
		return CommonDef.locatorValue(Locators.CSS, "div[ng-switch] button.pull-right");
	}

	public static By Btn_DateBckMonth() {
		return CommonDef.locatorValue(Locators.CSS, "div[ng-switch] button.pull-left");
	}

	public static By Btn_SelectDate(String Num) {
		/*
		 * return CommonDef.locatorValue(Locators.XPATH,
		 * "//button[@class='btn btn-default btn-sm' or @class='btn btn-default btn-sm active' or @class='btn btn-default btn-sm btn-info active']//span[.='"
		 * + Num + "']");
		 */
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@ng-switch='datepickerMode']//button[not(contains(.,'btn-muted'))]//span[.='" + Num
						+ "']/ancestor::button");
	}

	public static By footer() {
		return CommonDef.locatorValue(Locators.CSS, ".navbar-foot div.container-fluid");
	}

	public static By Text_Reference() {
		return CommonDef.locatorValue(Locators.CSS, "input[name='payment-reference']");
	}

	public static By Text_ChapsReference() {
		return CommonDef.locatorValue(Locators.CSS, "input[data-label='Payment reference*']");
	}

	public static By ChkBox_ChapsCharges() {
		return CommonDef.locatorValue(Locators.XPATH, "//input[@type='checkbox' and @ng-model='chooseChargeAccount']");
	}

	public static By Btn_ChapsChargesSelect() {
		return CommonDef.locatorValue(Locators.CSS, "button.btn[name='chargeAccount']:not([disabled])");
	}

	public static By Text_ChapsChgAcc(String Acc) {
		//return CommonDef.locatorValue(Locators.XPATH, "//div[@class='modal fade in']//td[.='" + Acc + "']");
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='modal fade in']//td[contains(.,'" + Acc + "')]");
	}

	public static By Btn_Pay() {
		return CommonDef.locatorValue(Locators.CSS, ".btn.btn-primary.pull-right:not([disabled])");
	}
	
	public static By Btn_Clear() {
		return CommonDef.locatorValue(Locators.XPATH, "//button[contains(.,'Clear')]");
	}

	public static By Btn_Back() {
		return CommonDef.locatorValue(Locators.XPATH, "//button[contains(.,'Back')]");
	}

	public static By Text_Token() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//input[@class='input-hardtoken ng-isolate-scope ng-pristine form-control no-label ng-valid-pattern ng-invalid ng-invalid-required']");
	}

	public static By Btn_PayConfirm() {
		return CommonDef.locatorValue(Locators.CSS, ".btn.btn-primary.pull-right.ng-scope:not([disabled])");
	}

	public static By Text_FTReference() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//small[.='Metrobank Payment Reference']/following-sibling::span[contains(.,'FT')]");
	}

	public static By Btn_ItemMgmt() {
		return CommonDef.locatorValue(Locators.CSS, ".parent-badge.pending");
	}

	public static By Link_Tabs() {
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='dashboard-nav ng-scope']");
	}

	public static By Link_VerifTab() {
		return CommonDef.locatorValue(Locators.PARTIAL_LINKTEXT, "Verifications");
	}

	public static By itemMgtToggle() {
		return CommonDef.locatorValue(Locators.CSS, "#selectTab");
	}

	public static By itemMgtDropDownApp(String value) {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='btn-group open']//li/a[contains(.,'" + value + "')]");
	}

	public static By Btn_VerifyList(String TxnRef) {
		return CommonDef.locatorValue(Locators.XPATH, "//span[contains(.,'" + TxnRef
				+ "')]/parent::dd/parent::dl/parent::div/parent::td/parent::tr/preceding-sibling::tr//button[@class='btn btn-sm verify-item']");
	}

	public static By Btn_Verify() {
		return CommonDef.locatorValue(Locators.XPATH, "//button[@class='btn pull-right verify-item ng-scope']");
	}

	public static By Btn_ApproveList(String TxnRef) {
		return CommonDef.locatorValue(Locators.XPATH, "//span[contains(.,'" + TxnRef
				+ "')]/parent::dd/parent::dl/parent::div/parent::td/parent::tr/preceding-sibling::tr//button[@class='btn btn-sm approve-item']");
	}

	public static By Btn_Approve() {
		return CommonDef.locatorValue(Locators.XPATH, "//button[@class='btn pull-right approve-item ng-scope']");
	}

	public static By Btn_RejectList(String TxnRef) {
		return CommonDef.locatorValue(Locators.XPATH, "//span[contains(.,'" + TxnRef
				+ "')]/parent::dd/parent::dl/parent::div/parent::td/parent::tr/preceding-sibling::tr//button[@class='btn btn-sm reject-item']");
	}

	public static By Btn_Reject() {
		return CommonDef.locatorValue(Locators.XPATH, "//button[@class='btn pull-right reject-item ng-scope']");
	}

	public static By Lnk_Notific() {
		return CommonDef.locatorValue(Locators.CSS, ".modal.fade.in .notification-item");
	}

	public static By Btn_CloseAppVer() {
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='modal fade in']//button[contains(.,'Close')]");
	}

	public static By Link_AppTab() {
		return CommonDef.locatorValue(Locators.PARTIAL_LINKTEXT, "Approvals");
	}

	public static By Link_Outstanding() {
		return CommonDef.locatorValue(Locators.XPATH, "//a[contains(.,'Outstanding')]");
	}

	public static By List_AccSelection() {
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='modal fade in']//table/tbody/tr[*]/td[3]");
	}

	public static By List_BenDomest() {
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='modal fade in']//table/tbody/tr[*]/td[3]");
	}

	public static By Btn_Ddown_ItemMgmt() {
		return CommonDef.locatorValue(Locators.CSS, ".expand.fa.fa-chevron-down");
	}

	// ****************Mobile
	// Objects**********************************************

	public static By Mob_Link_DomPayments() {
		return CommonDef.locatorValue(Locators.XPATH, "//span[contains(.,'Payments and Transfer')]");
	}

	public static By Mob_Link_IntlPayment() {
		return CommonDef.locatorValue(Locators.XPATH, "//span[contains(.,'International')]");
	}

	public static By Mob_Ddown_PopAcct(String acc) {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='modal fade in']//td[@class='ng-binding ng-scope']/small[contains(.,'" + acc + "')]");
	}

	public static By Mob_Lnk_BenType() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='dropdown hidden-md hidden-lg']/a[contains(.,'Domestic')]");
	}

	public static By Mob_Lnk_DomBen() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//ul[@class='dropdown-menu --dropdown-body shown']//a[contains(.,'Domestic')]");
	}

	public static By Mob_Lnk_ComBen() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//ul[@class='dropdown-menu --dropdown-body shown']//a[contains(.,'Company accounts')]");
	}

	public static By devPayeepicker() {
		return CommonDef.locatorValue(Locators.CSS, ".tab-pane.active #selectSearchType");
	}

	public static By devSearchAccountInput() {
		return CommonDef.locatorValue(Locators.CSS, ".tab-pane.active input.form-control");
	}

	public static By devSearchSubmit() {
		return CommonDef.locatorValue(Locators.CSS, ".tab-pane.active span.input-group-btn");
	}

	public static By selectPayeeResult() {
		return CommonDef.locatorValue(Locators.CSS,
				".tab-pane.active  div[ng-show='mainCtrl.searchModel.search'] td.ng-binding:not([class='hidden-xs ng-binding'])");
	}

	public static By selectPayeeResultCC() {
		return CommonDef.locatorValue(Locators.CSS,
				// ".tab-pane.active div[ng-show='mainCtrl.searchModel.search']
				// td.ng-binding:not([class='hidden-xs ng-binding'])");
				".tab-pane.active div.ng-scope table td.ng-binding:not([class='hidden-xs'])[ng-if='showAccountNameColumn']");
	}

	public static By devPayeePickerAN() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[contains(@class,'active')]//ul[@class='dropdown-menu']//a[contains(.,'Account Number')]");
	}

	public static By Mob_Lnk_DomBenSelect(String code) {
		return CommonDef.locatorValue(Locators.XPATH, "//table//tr[contains(.,'" + code + "')]");
	}

	public static By Mob_Lnk_CompAccs() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//ul[@class='dropdown-menu --dropdown-body shown']//a[contains(.,'Company')]");
	}

	public static By Mob_Lnk_DomCompSelect(String code) {
		// Edit Accordingly
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area tab-pane active']//table//td[contains(.,'CORPACC1100')]/small[contains(.,'"
						+ code + "')]");
	}

	public static By Mob_Lnk_BilBen() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//ul[@class='dropdown-menu --dropdown-body shown']//a[contains(.,'Biller')]");
	}

	public static By Mob_Lnk_DomBillSelect(String code) {
		// Edit accordingly
		return CommonDef.locatorValue(Locators.XPATH, "//table[@class='table table-hover']//td[.='" + code + "']");
	}

	public static By Link_OutstandingPane() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area tab-pane active']//ul[@role='tablist']/li[@class='--tab active']");
	}

	public static By Text_CCYAmt() {
		return CommonDef.locatorValue(Locators.XPATH, "//input[@data-label='Debit Amount']");
	}

	public static By Link_IntlBenSelect() {
		return CommonDef.locatorValue(Locators.XPATH, "//span[.='All']/ancestor::div[@role='tabpanel']//tbody/tr");
	}

	public static By Text_IntlBenName() {
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='metro-form-input-item']/input[@id='title']");
	}

	public static By Text_IntlBenNickName() {
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='metro-form-input-item']/input[@id='nickname']");
	}

	public static By Text_IntlBenAddress() {
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='metro-form-input-item']/input[@id='address1']");
	}

	public static By Text_IntlBicID() {
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='metro-form-input-item']/input[@id='BIC']");
	}

	public static By Radio_IntlBenIBAN() {
		return CommonDef.locatorValue(Locators.XPATH, "//span[contains(.,'Beneficiary IBAN')]/parent::label/input");
	}

	public static By Text_IntlBenIBAN() {
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='metro-form-input-item']/input[@id='IBAN']");
	}

	public static By Radio_IntlBenAcct() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//span[contains(.,'Beneficiary account No')]/parent::label/input");
	}

	public static By Text_IntlBenAcct() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='metro-form-input-item']/input[@id='accountNumber']");
	}

	public static By Text_IntlSwiftCode() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='metro-form-input-item']/input[@id='intermediaryBIC']");
	}

	public static By Text_IntlAmount() {
		return CommonDef.locatorValue(Locators.XPATH, "//input[contains(@data-label,'Debit Amount')]");
	}

	public static By Text_IntlReference() {
		return CommonDef.locatorValue(Locators.XPATH, "//label[contains(.,'Payment reference*')]/parent::div/input");
	}

	public static By Radio_BankChargeCust() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//span[contains(.,'Paid by us')]/parent::label/input[@name='bankCharges']");
	}

	public static By Radio_BankChargeBen() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//span[contains(.,'Paid by Payee')]/parent::label/input[@name='bankCharges']");
	}

	public static By Radio_OtherBankChargeCust() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//span[contains(.,'Paid by us')]/parent::label/input[@name='otherCharges']");
	}

	public static By Radio_OtherBankChargeBen() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//span[contains(.,'Paid by Payee')]/parent::label/input[@name='otherCharges']");
	}

	public static By Btn_IntlCharges() {
		return CommonDef.locatorValue(Locators.CSS, "button[name='chargeAccountFrom']:not([disabled]");
	}

	public static By Link_PaymentsMenuItems() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[contains(.,'Payments')]/following-sibling::div/i[@class='fa fa-lg fa-caret-right toggle']");
	}

	public static By Ddown_IntlFromAcct() {
		return CommonDef.locatorValue(Locators.CSS, "button[name='intlAccountFrom']:not([disabled])");
	}

	public static By Lnk_Verified() {
		return CommonDef.locatorValue(Locators.XPATH, "//p[contains(.,'Item verified')]");
	}

	public static By Lnk_Approved() {
		return CommonDef.locatorValue(Locators.XPATH, "//p[contains(.,'Item approved')]");
	}

	public static By Text_IntlFTReference() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//small[.='FT Reference']/following-sibling::span[contains(.,'FT')]");
	}

	/*
	 * public static By Link_StandingOrder() { return
	 * CommonDef.locatorValue(Locators.XPATH,
	 * "//a[contains(.,'Standing Orders')]"); }
	 * 
	 * public static By Btn_AddStandingOrder() { return
	 * CommonDef.locatorValue(Locators.XPATH,
	 * "//button[contains(.,'+ Add standing order')]"); }
	 * 
	 * public static By Table_dashboard() { return
	 * CommonDef.locatorValue(Locators.XPATH,
	 * "//div[@class='--area bp-area active']//tbody/tr");
	 * 
	 * }
	 * 
	 * public static By Link_SelectAccount(String acc) { return
	 * CommonDef.locatorValue(Locators.XPATH, "//tr[contains(.,'" + acc +
	 * "')]");
	 * 
	 * }
	 * 
	 * public static By Btn_SubmitButton() { return
	 * CommonDef.locatorValue(Locators.XPATH,
	 * "//div[@class='--area bp-area active']//button[contains(.,'Submit')]");
	 * 
	 * }
	 * 
	 * public static By Btn_ConfirmButton() { return
	 * CommonDef.locatorValue(Locators.XPATH,
	 * "//div[@class='--area bp-area active']//button[contains(.,'Confirm')]");
	 * }
	 */

	public static By Btn_StartDate() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//section[@class='payment-date']//span[@class='fa fa-calendar calendar-icon']");
	}

	/*
	 * public static By Btn_Frequency() { return
	 * CommonDef.locatorValue(Locators.XPATH,
	 * "//div[@class='payment-frequency  ng-scope']//button[@type='button']"); }
	 * 
	 * public static By lst_Frequency(String frequencies) { return
	 * CommonDef.locatorValue(Locators.XPATH, "//a[.='" + frequencies + "']"); }
	 */

	public static By Btn_EndDate() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='payment-schedule-end']//span[@class='fa fa-calendar calendar-icon']");
	}

	public static By Btn_StandingSelectDate(String Num) {
		return CommonDef.locatorValue(Locators.XPATH,
				"//li[@class='clearfix end-date']//button[@class='btn btn-default btn-sm' or @class='btn btn-default btn-sm active' or @class='btn btn-default btn-sm btn-info active']//span[.='"
						+ Num + "']/parent::button");
	}

	public static By Btn_StandingDecision(String TxnRef, String decision) {
		return CommonDef.locatorValue(Locators.XPATH,
				"//dd[contains(.,'" + TxnRef
						+ "')]/parent::dl/parent::div/parent::td/parent::tr/preceding-sibling::tr//button[@class='btn btn-sm "
						+ decision + "-item']");
	}

	// li[@class='clearfix end-date']//button[@class='btn btn-default btn-sm' or
	// @class='btn btn-default btn-sm active' or @class='btn btn-default btn-sm
	// btn-info active']//span[.='25']

	// Batch Payment
	public static By Link_BatchPayments() {
		return CommonDef.locatorValue(Locators.XPATH, "//a[contains(.,'Batch Payments')]");
	}

	public static By Ddown_batchFromAcct() {
		return CommonDef.locatorValue(Locators.CSS, "button[name='accountFrom']:not([disabled])");
	}

	public static By Btn_Selectbatch() {
		return CommonDef.locatorValue(Locators.XPATH, "//button[@ng-click='mainCtrl.addBatchPaymentGroup()']");
	}
	
	public static By Btn_SearchBatch() {
		return CommonDef.locatorValue(Locators.CSS, "div.row.ng-scope .metro-search-component[required] > div.input-group > input");
	}
	
	public static By Btn_SearchButton() {
		return CommonDef.locatorValue(Locators.CSS, "div.row.ng-scope .metro-search-component[required]  span button");
	}

	public static By Btn_SelectbatchPayee() {
		return CommonDef.locatorValue(Locators.XPATH, "//button[@ng-click='mainCtrl.addPayee()']");
	}

	public static By bengrp_selectBeneficiary() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='table-responsive table-scrollable']/table[@class='table "
						+ "table-hover']//td[contains(.,'" + TestData.getConfig("Beneficiary Name")
						+ "')]/following::td/button");
	}

	public static By bengrp_addSelected() {
		return CommonDef.locatorValue(Locators.LINKTEXT, "Add selected");
	}

	public static By bengrp_close() {
		return CommonDef.locatorValue(Locators.CSS, ".lp-lightbox-on button.lp-widget-control.lp-lightbox-close");
	}

	public static By lst_Selectbatch(String Batch) {
		return CommonDef.locatorValue(Locators.XPATH, "//td[.='" + Batch + "']");
	}

	public static By Text_BatchAmount() {
		return CommonDef.locatorValue(Locators.XPATH, "//input[@ng-model='targetArrangment.amount']");
	}

	public static By Btn_BatchPay() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='widget-metro-batch-payments ng-scope']//button[@class='btn btn-primary pull-right']");
	}

	public static By Text_BatchPaymentGroup() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//input[@ng-model='mainCtrl.paymentOrder.targetArrangementGroup.name']");
	}

	public static By Btn_BatchDecision(String TxnRef, double amt, String decision) {
		return CommonDef.locatorValue(Locators.XPATH,
				"//h4[text()='Bulk & Batch Domestic Payments']/parent::div//div[@class='ng-binding ng-scope'][text()='"
						+ TxnRef + "']//ancestor::tr//span[contains(text(),'" + amt
						+ "')]//ancestor::tr//button[@class='btn btn-sm " + decision + "-item']");
	}

	public static By Btn_confirmDecision(String decision) {
		return CommonDef.locatorValue(Locators.XPATH,
				"//button[@class='btn pull-right " + decision + "-item ng-scope']");
	}

	public static By Dev() {
		return CommonDef.locatorValue(Locators.CSS, ".dropdown-menu.ng-scope li div.row");
	}

	// Standing Order

	public static By Link_StandingOrder() {
		return CommonDef.locatorValue(Locators.XPATH, "//a[contains(.,'Standing Orders')]");
	}

	public static By Btn_AddStandingOrder() {
		return CommonDef.locatorValue(Locators.XPATH, "//button[contains(.,'+ Add standing order')]");
	}

	public static By Table_dashboard() {
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='--area bp-area active']//tbody/tr");

	}

	public static By Link_SelectAccount(String acc) {
		return CommonDef.locatorValue(Locators.XPATH, "//tr[contains(.,'" + acc + "')]");
	}// button[name='intlAccountFrom']:not([disabled])

	public static By Lnk_StandBenName() {
		return CommonDef.locatorValue(Locators.CSS, "input[parent-class='input-beneficiary']");
	}

	public static By Lnk_StandReference() {
		return CommonDef.locatorValue(Locators.CSS, "input[parent-class='ct-reference']");
	}

	public static By Lnk_StandFwdMonth() {
		return CommonDef.locatorValue(Locators.CSS, ".payment-schedule-end .lp-icon.lp-icon-angle-right");
	}

	public static By Btn_SubmitButton() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area active']//button[contains(.,'Submit')]");

	}

	public static By Btn_ConfirmButton() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area active']//button[contains(.,'Confirm')]");
	}

	public static By Btn_Frequency() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='payment-frequency  ng-scope']//button[@type='button']");
	}

	public static By Lnk_StndNotification() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//span[@class='col-xs-12 mb-notification']//div[@class='metro-notification-message']");
	}

	public static By Lnk_StndSuccessMsg() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//span[@class='col-xs-12 mb-notification']//span[contains(.,'order has created successfully')]");
	}

	public static By lst_Frequency(String frequencies) {
		return CommonDef.locatorValue(Locators.XPATH, "//a[.='" + frequencies + "']");
	}

	public static By Text_StandHardToken() {
		return CommonDef.locatorValue(Locators.XPATH, "//input[@parent-class='ct-hardtoken']");
	}

	public static By Btn_StandAction(String TxnRef, String Actn) {
		return CommonDef.locatorValue(Locators.XPATH, "//dd[contains(.,'" + TxnRef
				+ "')]/ancestor::tr/preceding-sibling::tr[1]//button[@class='btn btn-sm " + Actn + "-item']");
	}

	public static By Btn_PaymentsActn(String TxnRef, String Actn) {
		return CommonDef.locatorValue(Locators.XPATH,
				"//span[contains(.,'" + TxnRef
						+ "')]/parent::dd/parent::dl/parent::div/parent::td/parent::tr/preceding-sibling::tr[1]//button[@class='btn btn-sm "
						+ Actn + "-item']");
	}

	public static By Btn_PaymentsBtnActn(String Actn) {
		return CommonDef.locatorValue(Locators.XPATH, "//button[@class='btn pull-right " + Actn + "-item ng-scope']");
	}

	public static By moblistItemsFP(String value) {
		return CommonDef.locatorValue(Locators.XPATH, "//h4[contains(.,'" + value
				+ "')]/ancestor::div//div[@class='visible-xs-block mobile-list']/div[@class='item ng-scope']");
	}

	public static By moblistItemsFP(int index) {
		return CommonDef.locatorValue(Locators.XPATH,
				"(//h4[contains(.,'Faster Payments')]/ancestor::div//div[@class='visible-xs-block mobile-list']/div[@class='item ng-scope'])["
						+ index + "]");
	}

	public static By moblistItemsFPRef() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@data-show-close-icon='!loading']//dt[@class='ng-binding'][contains(.,'Reference')]/ancestor::dl//span");
	}

	public static By moblistItemsFPRefBack() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area active']//button[contains(.,'Back')][@class='btn btn-default']");
	}

	public static By moblistItemsFPAction(String value, int i, String action) {
		return CommonDef.locatorValue(Locators.XPATH,
				"(//h4[contains(.,'" + value
						+ "')]/ancestor::div[@class='container ng-scope']//div[@class='visible-xs-block mobile-list']/div[@class='item ng-scope'])["
						+ i + "]//button[contains(.,'" + action + "')]");
	}

	public static By moblistItemsFPActionApprove(String value, int i, String action) {
		return CommonDef.locatorValue(Locators.XPATH,
				"(//h4[contains(.,'" + value
						+ "')]/ancestor::div[@class='container ng-scope']//div[@class='visible-xs-block mobile-list']/div[@class='item ng-scope'])["
						+ i + "]//button[contains(@class,'" + action + "')]");
	}

	public static By mobSpanContent(String value) {
		return CommonDef.locatorValue(Locators.XPATH, "//h4[contains(.,'" + value
				+ "')]/ancestor::div[@class='container ng-scope']//table//tr//span[@class='ng-binding ng-scope'][@data-ng-repeat]");
	}

	public static By mobSpanContent(String value, int index) {
		return CommonDef.locatorValue(Locators.XPATH,
				"(//h4[contains(.,'" + value
						+ "')]/ancestor::div[@class='container ng-scope']//table//tr//span[@class='ng-binding ng-scope'][@data-ng-repeat])["
						+ index + "]");
	}

	public static By mob_MainmenuPaymentOpen() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//a[contains(@href,'/portalserver/payments-and-transfers')]//div[@class='tab-arrow']");
	}

	public static By warningAuthSummary() {
		return CommonDef.locatorValue(Locators.XPATH, "//i[@class='fa fa-close']/ancestor::li//span/p");
	}

	public static By warningMsgSummary() {
		return CommonDef.locatorValue(Locators.XPATH, "//i[@class='fa fa-warning']/ancestor::li//span/p");
	}
	
	public static By commWarningMsg(){
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='metro-notification']//span[@class='detail ng-binding ng-scope']");
	}

	public static By invalidChar() {
		return CommonDef.locatorValue(Locators.CSS, "div.help-block");
	}

	public static By bPayClearReference() {
		return CommonDef.locatorValue(Locators.XPATH, "//span[text()='Clear references']");
	}

	public static By bPayClearReferenceConfirm() {
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='modal fade in']//span[text()='Confirm']");
	}

	public static By bPayReference() {
		return CommonDef.locatorValue(Locators.CSS, ".metro-form-input-item input[data-label='Reference']");
	}

	public static By bPayConfirmMsg() {
		return CommonDef.locatorValue(Locators.CSS, "div.metro-notification[data-ng-hide='!message.show'] .metro-notification-message span p");
	}

	public static By bPayAmountSummary() {
		return CommonDef.locatorValue(Locators.CSS, "div.payment-summary.row.ng-scope .lp-amount-positive");
	}

	public static By Webel_StandingNegative() {
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='help-block ng-binding ng-scope']");
	}

	public static By Lnk_StndErrorMsg() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//ul[@class='ng-scope ng-isolate-scope']//div[@class='error']//span[@class='detail ng-binding ng-scope']");
	}

	public static By canButton() {
		return CommonDef.locatorValue(Locators.CSS, "div.ng-scope.ct-btn > button.btn.btn-default:nth-child(2)");
	}

	public static By canConfirm() {
		return CommonDef.locatorValue(Locators.XPATH, "//button//span[text()='Confirm']");
	}

	public static By activeHeader() {
		return CommonDef.locatorValue(Locators.CSS, ".met-heading-text.ng-scope");
	}

	public static By Rdo_StandFurtherNotic(){
		return CommonDef.locatorValue(Locators.XPATH, "//span[contains(.,'Until further notice')]/preceding-sibling::input");
	}

}