package mav.metro.pom.elements;

import mav.metro.library.functions.CommonDef;
import mav.metro.utilities.enums.Locators;
import org.openqa.selenium.By;

public class Administration {

	public static By Link_Administration() {
		return CommonDef.locatorValue(Locators.CSS, "a[href='/portalserver/administration']");
	}

	public static By Link_AdminDashboard() {
		return CommonDef.locatorValue(Locators.CSS, ".side-nav");
	}

	public static By Link_UserList() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//li[contains(@class,'vertical-tab')]//div[contains(.,'User List')]");
	}

	public static By Link_UserListDashboard() {
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='user-list']//tbody/tr");
	}

	public static By Link_AccessGroups() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//li[contains(@class,'vertical-tab')]//div[contains(.,'Access Groups')]");
	}

	public static By Link_AccessGroupsDashboard() {
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='pagedList']//div[@ng-switch-when='listItem']");
	}

	public static By Link_EntAccounts() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//li[contains(@class,'vertical-tab')]//div[contains(.,'Account Groups')]");
	}

	public static By Link_EntAccountsDashboard() {
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='met-list-item']");
	}

	// Entitlement UserList

	public static By Link_UserListScreen() {
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='mandate-item ng-scope']");
	}

	public static By Link_User_AccSelection(String num) {
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='user-list']//a[.='" + num + "']");
	}

	public static By Btn_User_AccessGrpSelect() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//h5[.='Access Groups templates']/following-sibling::div//button[contains(@class,'btn btn-secondary')]");
	}

	public static By Link_User_AccessGrpSelect(String data) {
		/*
		 * return CommonDef.locatorValue(Locators.XPATH,
		 * "//h5[.='Access Groups templates']/following-sibling::div[@class='pagedList']//div[@class='item-inner']//a[.='"
		 * + data + "']");
		 */
		return CommonDef.locatorValue(Locators.XPATH,
				"//h5[contains(.,'Access Groups templates')]/parent::div//div[@class='met-list-item']//div[@class='item-selected pull-left ng-hide']/parent::div[@class='met-list-item']//h3/a");
	}

	public static By Btn_User_MandatesSelect() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//h5[.='Mandates templates']/following-sibling::div//button[contains(@class,'btn btn-secondary')]");
	}

	public static By Link_User_MandatesSelect(String data) {

		/*
		 * return CommonDef.locatorValue(Locators.XPATH,
		 * "//h5[.='Mandates templates']/following-sibling::div[@class='pagedList']//div[@class='item-inner']//a[.='"
		 * + data + "']");
		 */
		return CommonDef.locatorValue(Locators.XPATH,
				"//h5[.='Mandates templates']/following-sibling::div[@class='pagedList']//div[@class='item-selected pull-left ng-hide']/parent::div[@class='met-list-item']//h3/a");

	}

	public static By Btn_User_AccountGrpSelect() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//h5[.='Account Groups templates']/following-sibling::div//button[contains(@class,'btn btn-secondary')]");
	}

	public static By Link_User_AccountGrpSelect(String data) {
		return CommonDef.locatorValue(Locators.XPATH,
				"//h5[.='Account Groups templates']/following-sibling::div[@class='pagedList']//div[@class='item-selected pull-left ng-hide']/parent::div[@class='met-list-item']//h3/a");
		/*
		 * "//h5[.='Account Groups templates']/following-sibling::div[@class='pagedList']//div[@class='item-inner']//a[.='"
		 * + data + "']");
		 */
	}

	public static By Btn_User_Save() {
		return CommonDef.locatorValue(Locators.XPATH, "//button[.='Save']");
	}

	public static By Text_User_Hardtoken() {
		return CommonDef.locatorValue(Locators.XPATH, "//input[@type='password']");
	}

	public static By Btn_User_ContinueButton() {
		return CommonDef.locatorValue(Locators.XPATH, "//button[.='Continue']");
	}

	public static By Link_User_NotificationItem() {
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='modal fade in']//div[@class='notification-item']");
	}

	public static By Link_User_SuccessMessage() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='modal fade in']//div[@class='notification-item']//span");
	}

	public static By Btn_User_CloseButton() {
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='modal fade in']//button//i");
	}

	// Entitlement Accounts

	public static By entile_accArrow() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[contains(.,'Administration')]/following-sibling::div/i[@class='fa fa-lg fa-caret-right toggle']");
	}

	public static By entile_accLink() {
		return CommonDef.locatorValue(Locators.XPATH, "//a[contains(.,'Account Groups')]");
	}

	public static By entile_createNew() {
		return CommonDef.locatorValue(Locators.XPATH, "//button[contains(.,'Create new')]");
	}

	public static By entile_titleName() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area active']//input[@name='nameAccountGroup']");
	}

	public static By entile_titleDescr() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area active']//input[@name='descriptionAccountGroup']");
	}

	public static By entile_businessSavings(String accType) {
		return CommonDef.locatorValue(Locators.XPATH, "//div/p[contains(.,'" + accType + "')]");
	}

	public static By entile_accNo(String accNo) {
		return CommonDef.locatorValue(Locators.XPATH, "//p[.='" + accNo + "']");
	}

	public static By entile_accLoad(String AccType) {
		return CommonDef.locatorValue(Locators.XPATH, "//strong[contains(.,'" + AccType
				+ "')]/parent::p/parent::div/following-sibling::div//div[@ng-repeat='account in item.accounts']");
	}

	public static By entile_createInclude() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area active']//h4[.='Include']/parent::div/parent::div/following-sibling::div[@class='row include-box-body']//button");
		// form[@name='forms.createAccountGroup']//div[@ng-hide='mainCtrl.includeAll']//button[@data-ng-click='mainCtrl.inclExclItem(true)']
	}

	public static By entile_save() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area active']//span[contains(.,'Save')]");
	}

	public static By entile_successMessage() {
		return CommonDef.locatorValue(Locators.CSS,
				"div[ng-show='result'] li[data-notification-id='CREATE_ACCOUNT_GROUP_SUCCESS'] span.message");
	}

	public static By entile_updateInclude() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area active']//h4[.='Include']/parent::div/parent::div/following-sibling::div[@class='row include-box-body']//button");
	}
	// form[@name='forms.updateAccountGroup']//div[@ng-hide='mainCtrl.includeAll']//button[@ng-disabled='!mainCtrl.selectedAccItem
	// || readOnly']

	public static By entile_updateButton() {
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='--area bp-area active']//button[@type='submit']");
	}

	public static By entile_updateSelectAcc(String accNo) {
		return CommonDef.locatorValue(Locators.XPATH, "//h3/a[contains(.,'" + accNo + "')]");
	}

	public static By entile_SelectAllAccounts(String accType) {
		return CommonDef.locatorValue(Locators.XPATH, "//p[contains(.,'" + accType
				+ "')]/parent::div/following-sibling::div/p[contains(.,'Select all accounts in this category')]");
	}

	// h3/a[contains(.,'Automation Access21')]
	public static By entile_close() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='modal fade in']//button[@class='close lightbox-close-x']");
	}

	public static By entile_UserPermissionDrop() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='tab-pane ng-scope active']//div[@class='panel-heading']//h4[contains(.,'User Permissions')]");
	}

	public static By entile_decisionItem(String reference, String decision) {
		return CommonDef.locatorValue(Locators.XPATH, "//span[contains(.,'" + reference
				+ "')]/parent::td/following-sibling::td//button[@class='btn btn-sm " + decision + "-item']");
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

	public static By entile_Updateclose() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='modal hardtoken fade in']//button[@class='close lightbox-close-x']");
	}

	public static By entile_UpdatesuccessMessage() {
		return CommonDef.locatorValue(Locators.CSS,
				"div.ng-scope[ng-show='result && !modal.hardToken.getToken'] div.metro-notification[data-ng-hide='!message.show']");
	}

	public static By entile_InsertHardToken() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='modal hardtoken fade in']//input[@ng-model='create.hardToken']");
	}

	public static By btn_updateSend() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='modal hardtoken fade in']//button[contains(.,'Send')]");
	}

	// Approvals and Verifications

	public static By Lnk_Payments() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='tab-pane ng-scope active']//h4[contains(.,'Payments and Transfers')]");
	}

	public static By Lnk_Administration() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='tab-pane ng-scope active']//h4[contains(.,'User Permissions')]");
	}

	public static By btn_approve(String Actn, String Txn) {
		return CommonDef.locatorValue(Locators.XPATH, "//span[contains(.,'" + Txn
				+ "')]/parent::td/following-sibling::td//button[@class='btn btn-sm " + Actn + "-item']");
	}

	public static By btn_approve(String Actn) {
		return CommonDef.locatorValue(Locators.XPATH, "//button[@class='btn pull-right " + Actn + "-item ng-scope']");
	}

	public static By Lnk_Verified() {
		return CommonDef.locatorValue(Locators.XPATH, "//p[contains(.,'Item verified')]");
	}

	public static By Lnk_Approved() {
		return CommonDef.locatorValue(Locators.XPATH, "//p[contains(.,'Item approved')]");
	}

	// Entitlement Access Groups

	public static By Lnk_AccssDashboard() {
		return CommonDef.locatorValue(Locators.XPATH, "//tr[@ng-repeat='row in model.table.rows']");
	}

	public static By Text_AccssTitle() {
		return CommonDef.locatorValue(Locators.XPATH, "//input[@name='accessGroupName']");
	}

	public static By Text_AccssDescription() {
		return CommonDef.locatorValue(Locators.XPATH, "//input[@name='accessGroupDescription']");
	}

	public static By Table_ColCount() {
		return CommonDef.locatorValue(Locators.XPATH, "//table[@class='ng-scope']//th");
	}

	public static By Table_RowSelect(String AccssType) {
		return CommonDef.locatorValue(Locators.XPATH,
				"//span[contains(.,'" + AccssType + "')]//ancestor::tr//input[not(@disabled='disabled')]");
	}

	public static By Table_RowSelect(String AccssType, String IndexVal) {
		return CommonDef.locatorValue(Locators.XPATH,
				"(//span[.='" + AccssType
						+ "']/ancestor::td[@ng-repeat='model in row.items']/following-sibling::td//input[@type='checkbox'])["
						+ IndexVal + "]");
	}

	public static By Link_AmendSelect(String Data) {
		return CommonDef.locatorValue(Locators.XPATH, "//h5[.='Unassigned']/parent::div//a[.='" + Data + "']");
	}

	public static By Button_AccGrpSave() {
		return CommonDef.locatorValue(Locators.XPATH, "//span[contains(.,'Save')]");
	}

	public static By Button_AccGrpUpdate() {
		return CommonDef.locatorValue(Locators.XPATH, "//span[contains(.,'Update')]");
	}

	public static By Button_AccGrpUpdateSend() {
		return CommonDef.locatorValue(Locators.XPATH, "//button[contains(.,'Send')]");
	}

	public static By Link_AccGrp_SuccessMessage() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='modal fade in']//div[@class='notification-item']//span[contains(.,'Access Group successfully created')]");
	}

	public static By Link_AccGrp_UpdateMessage() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='modal fade in']//div[@class='notification-item']//span[contains(.,'Access Group successfully updated')]");
	}

	public static By Text_AccGrp_HardToken() {
		return CommonDef.locatorValue(Locators.XPATH, "//input[@name='token']");
	}

	public static By searchEntAcc() {
		return CommonDef.locatorValue(Locators.CSS, ".lp-widget-management .search-row.ng-scope input");
	}

	public static By searchEntAccButton() {
		return CommonDef.locatorValue(Locators.CSS, ".lp-widget-management .search-row.ng-scope .input-group-btn");
	}

	public static By uncheckAccessGroup() {
		return CommonDef.locatorValue(Locators.CSS, "form[name='forms.updateAccountGroup'] li .row.items-header i");
	}

	public static By negAccNotification() {
		return CommonDef.locatorValue(Locators.CSS,
				".modal.hardtoken.fade.in  div[ng-show]:not([class*=ng-hide]) .metro-notification-message p");
	}

	public static By searchEntAccGrp() {
		return CommonDef.locatorValue(Locators.CSS, "div.input-group input[required]");
	}

	public static By searchBtnEntAccGrp() {
		return CommonDef.locatorValue(Locators.CSS, "div[required] div.input-group button > span");
	}

}
