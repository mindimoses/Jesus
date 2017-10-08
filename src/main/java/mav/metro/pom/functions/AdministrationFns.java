package mav.metro.pom.functions;

import com.relevantcodes.extentreports.LogStatus;

import mav.metro.framework.ExReporter;
import mav.metro.framework.ProjectConfig;
import mav.metro.framework.TestData;
import mav.metro.library.functions.CommonDef;
import mav.metro.library.functions.MethodDef;
import mav.metro.pom.elements.Administration;
import mav.metro.pom.elements.Payments;
import mav.metro.pom.tcib.functions.LoginFns;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AdministrationFns {

	public static void EntitlementUserList() {
		ExReporter.log(LogStatus.INFO, "Entitlement User List");
		try {
			adminMainNavigation();
			MethodDef.click(Administration.Link_UserList(), "User List Link");
			CommonDef.waitVisibleNoError(Administration.Link_UserListDashboard());
			MethodDef.click(Administration.Link_User_AccSelection(TestData.getConfig("UserList_UserName")),
					"Selecting User Link");
			CommonDef.waitVisibleNoError(Administration.Link_UserListScreen());
			if (TestData.getConfig("UserList_AccessChange").equals("Y")) {
				changeAccessGroup(Administration.Btn_User_AccessGrpSelect(),
						Administration.Link_User_AccessGrpSelect(TestData.getConfig("UserList_AccessName")),
						"UserList_AccessChange");
			}
			if (TestData.getConfig("UserList_MandateChange").equals("Y")) {
				changeAccessGroup(Administration.Btn_User_MandatesSelect(),
						Administration.Link_User_MandatesSelect(TestData.getConfig("UserList_MandateName")),
						"UserList_MandateChange");
			}
			if (TestData.getConfig("UserList_AccountChange").equals("Y")) {
				changeAccessGroup(Administration.Btn_User_AccountGrpSelect(),
						Administration.Link_User_AccountGrpSelect(TestData.getConfig("UserList_AccountName")),
						"UserList_AccountChange");
			}
			CommonDef.clickJS(Administration.Btn_User_Save(), "Save Button");
			MethodDef.sendKeys(Administration.Text_User_Hardtoken(), ProjectConfig.getPropertyValue("hardtoken"));
			MethodDef.click(Administration.Btn_User_ContinueButton(), "Continue Button");
			MethodDef.click(Administration.Link_User_NotificationItem(), "Notification Item");
			if (!CommonDef.assertContains(Administration.Link_User_SuccessMessage(), TestData.getConfig("SuccessMsg")))
				ExReporter.log(LogStatus.ERROR, "Change is not successful");
		} catch (Exception e) {
			ExReporter.log(LogStatus.ERROR, "Error in performing Entitlement User Function");
		}
	}

	private static void changeAccessGroup(By btn_User_AccessGrpSelect, By link_User_AccessGrpSelect, String accessLevel)
			throws InterruptedException {
		ExReporter.log(LogStatus.INFO, "Changing access Level: " + accessLevel);
		MethodDef.clickJS(btn_User_AccessGrpSelect, "Access Change Unassigned List");
		CommonDef.waitForAttribute(btn_User_AccessGrpSelect, "class", "btn btn-secondary selected");
		Thread.sleep(1500);
		CommonDef.moveToElement(link_User_AccessGrpSelect, "Access Change Data to be Selected");
		MethodDef.clickJS(link_User_AccessGrpSelect, "Access Change Data Link");
		ExReporter.log(LogStatus.PASS, "Data clicked successfully");
	}

	public static String entitlementAccessGroupCreate() {
		ExReporter.log(LogStatus.INFO, "Entitlement Access Group Function");
		String grpname = TestData.getConfig("GroupName") + RandomStringUtils.random(5, "ABFERPLDBNVJK");
		try {
			adminMainNavigation();
			navToAccessGroup();
			accessGroupCreation(grpname);

		} catch (Exception e) {
			ExReporter.log(LogStatus.FAIL, "Error in performing Entitlement Access Group Function");
		}
		return grpname;
	}

	private static void accessGroupCreation(String grpname) {

		MethodDef.clickJS(Administration.entile_createNew(), "Create New Button");
		CommonDef.waitVisibleNoError(Administration.Lnk_AccssDashboard());
		choosingAccess(TestData.getConfig("AmendType"), TestData.getConfig("AccessType"));
		CommonDef.sendKeys(Administration.Text_AccssTitle(), grpname);
		CommonDef.sendKeys(Administration.Text_AccssDescription(), RandomStringUtils.random(8, "ABFERPLDBNVJK"));
		CommonDef.moveToElement(Administration.Button_AccGrpSave(), "Save Button");
		MethodDef.clickJS(Administration.Button_AccGrpSave(), "Save Button");
		MethodDef.clickJS(Administration.Lnk_Notific(), "Notification Item");
		CommonDef.assertContains(Administration.Link_AccGrp_SuccessMessage(), TestData.getConfig("SuccssMsg"));
	}

	private static void navToAccessGroup() {
		MethodDef.clickJS(Administration.Link_AccessGroups(), "Access Group Link");
		CommonDef.waitVisibleNoError(Administration.Link_AccessGroupsDashboard());
	}

	public static String EntitlmentAccount() {
		ExReporter.log(LogStatus.INFO, "Entitlement Accounts Function");
		String grpname = TestData.getConfig("Account_Groupname") + RandomStringUtils.random(5, "ABFERPLDBNVJK");
		try {
			adminMainNavigation();
			navToEntAccounts();
			createAccessGroup(grpname);
		} catch (Exception e) {
			ExReporter.log(LogStatus.FAIL, "Error in processing Entitlement Accounts");
		}
		return grpname;
	}

	public static void amendAccessGroup(String grpname) throws InterruptedException {
		ExReporter.log(LogStatus.INFO, "Amend Function");

		String amall = TestData.getConfig("am_All");
		String amaccountnumber = TestData.getConfig("am_Account Number");
		String am_Account_Type = TestData.getConfig("am_Account_Type");
		// Thread.sleep(15000);

		searchAdmin(grpname);

		MethodDef.click(Administration.entile_updateSelectAcc(grpname), "Account Group Name");

		MethodDef.click(Administration.uncheckAccessGroup(), "Previously selected account unselection");

		if (!am_Account_Type.equals("Business Current Accounts")) {
			MethodDef.clickJS(Administration.entile_businessSavings(am_Account_Type), "Account Type");
		}
		if (!amall.equalsIgnoreCase("n/a")) {
			// CommonDef.moveToElement(Administration.entile_accLoad(am_Account_Type),
			// "Account Type");
			MethodDef.clickJS(Administration.entile_SelectAllAccounts(am_Account_Type), "Account Type");
			CommonDef.moveToElement(Administration.entile_updateInclude(), "Include Option");
			MethodDef.clickJS(Administration.entile_updateInclude(), "UpdateInclude Option");
		} else if (!amaccountnumber.equalsIgnoreCase("n/a")) {
			String[] AccNumber = amaccountnumber.toString().split(";");
			for (int j = 0; j < AccNumber.length; j++) {
				// CommonDef.moveToElement(Administration.entile_accNo(AccNumber[j]),
				// "Account No");
				MethodDef.clickJS(Administration.entile_accNo(AccNumber[j]), "Account No");
				CommonDef.moveToElement(Administration.entile_updateInclude(), "Include Option");
				MethodDef.clickJS(Administration.entile_updateInclude(), "UpdateInclude Option");
			}
		}

		MethodDef.clickJS(Administration.entile_updateButton(), "Update Option");
		MethodDef.sendKeys(Administration.entile_InsertHardToken(), ProjectConfig.getPropertyValue("hardtoken"));
		MethodDef.clickJS(Administration.btn_updateSend(), "Update Button");
		if (TestData.getConfig("DataBinding").contains("Neg"))
			CommonDef.assertContains(Administration.negAccNotification(), TestData.getConfig("am_successMsg"));
		else if (!CommonDef.assertContains(Administration.entile_UpdatesuccessMessage(),
				TestData.getConfig("am_successMsg")))
			ExReporter.log(LogStatus.ERROR, "Error in amending the Access Groups");
		MethodDef.clickJS(Administration.entile_Updateclose(), "close Option");
	}

	public static void searchAdmin(String grpname) {
		try {
			Thread.sleep(20000);
			MethodDef.sendKeys(Administration.searchEntAcc(), grpname);
			MethodDef.click(Administration.searchEntAccButton());
		} catch (Exception E) {
			ExReporter.log(LogStatus.ERROR, "Error in navigating to admin screen");
		}
	}

	private static void createAccessGroup(String grpname) {
		ExReporter.log(LogStatus.INFO, "Create Function");
		MethodDef.click(Administration.entile_createNew(), "Create new button");
		MethodDef.sendKeys(Administration.entile_titleName(), grpname);
		MethodDef.sendKeys(Administration.entile_titleDescr(), TestData.getConfig("Account_Description"));
		// CommonDef.waitVisibleNoError(Administration.entile_accLoad(TestData.getConfig("Account_Type")));
		ExReporter.log(LogStatus.INFO, "Account Type : " + TestData.getConfig("Account_Type"));
		if (!TestData.getConfig("Account_Type").equals("Business Current Accounts")) {
			// CommonDef.waitVisibleNoError(Administration.entile_businessSavings(TestData.getConfig("Account_Type")));
			MethodDef.clickJS(Administration.entile_businessSavings(TestData.getConfig("Account_Type")),
					"Account Type");
			// CommonDef.waitVisibleNoError(Administration.entile_accLoad(TestData.getConfig("Account_Type")));
		}
		if (!TestData.getConfig("All").equalsIgnoreCase("n/a")) {
			// CommonDef.moveToElement(Administration.entile_accLoad(TestData.getConfig("Account_Type")),
			// "Account Type");
			MethodDef.clickJS(Administration.entile_SelectAllAccounts(TestData.getConfig("Account_Type")),
					"Account Type");
		} else if (!TestData.getConfig("Account Number").equalsIgnoreCase("n/a")) {
			// CommonDef.waitVisibleNoError(Administration.entile_accLoad(TestData.getConfig("Account_Type")));
			String[] AccNumber = TestData.getConfig("Account Number").toString().split(";");
			for (int j = 0; j < AccNumber.length; j++) {
				// CommonDef.moveToElement(Administration.entile_accNo(AccNumber[j]),
				// "Account No");
				MethodDef.clickJS(Administration.entile_accNo(AccNumber[j]), "Account No");
			}
		}
		// CommonDef.moveToElement(Administration.entile_createInclude(),
		// "Include Option");
		MethodDef.clickJS(Administration.entile_createInclude(), "Include Option");
		MethodDef.clickJS(Administration.entile_save(), "Save Option");
		CommonDef.waitVisible(Administration.entile_successMessage(), "Success Message");
		if (!CommonDef.assertContains(Administration.entile_successMessage(), TestData.getConfig("successMsg")))
			ExReporter.log(LogStatus.ERROR, "Error accessing the creation of Access Group");
		MethodDef.clickJS(Administration.entile_close(), "close Option");
	}

	public static void navToEntAccounts() {
		MethodDef.click(Administration.Link_EntAccounts(), "Entitlement Accounts Link");
		CommonDef.waitVisibleNoError(Administration.Link_EntAccountsDashboard());
	}

	public static void entlVerify(String Name) {
		try {
			ExReporter.log(LogStatus.INFO, "Administraion Verify");
			adminVerApprmainflow();
			PaymentsFns.itemMgmtPageLoad();
			MethodDef.click(Payments.Link_VerifTab(), "Verify Tab");
			CommonDef.waitVisibleNoError(Payments.Btn_Ddown_ItemMgmt());
			adminVerApprcommonflow(Name, TestData.getConfig("VerifyAction"));
			if (!CommonDef.assertContains(Administration.Lnk_Verified(), "Item verified"))
				ExReporter.log(LogStatus.ERROR, "Error in verification");
			MethodDef.clickJS(Administration.Btn_CloseAppVer(), "Close Button");
		} catch (Exception e) {
			ExReporter.log(LogStatus.FAIL, "Error in verifying Entitlement Accounts");
		}
	}

	public static void entlApproval(String Name) {
		try {
			ExReporter.log(LogStatus.INFO, "Administraion Approvals");
			adminVerApprmainflow();
			PaymentsFns.itemMgmtPageLoad();
			MethodDef.click(Payments.Link_AppTab(), "Approve Tab");
			CommonDef.waitVisibleNoError(Payments.Btn_Ddown_ItemMgmt());
			adminVerApprcommonflow(Name, TestData.getConfig("AuthAction"));
			if (!CommonDef.assertContains(Administration.Lnk_Approved(), "Item approved"))
				ExReporter.log(LogStatus.ERROR, "Error in verification");
			MethodDef.clickJS(Administration.Btn_CloseAppVer(), "Close Button");
		} catch (Exception e) {
			ExReporter.log(LogStatus.FAIL, "Error in approving Entitlement Accounts");
		}
	}

	public static void adminVerApprmainflow() {
		try {
			MethodDef.click(Payments.Btn_ItemMgmt(), "Item Management");
			CommonDef.waitVisibleNoError(Payments.Link_Tabs());
		} catch (Exception e) {
			ExReporter.log(LogStatus.FAIL, "Error in performing Approval/Verify");
		}
	}

	public static void adminVerApprcommonflow(String Name, String TestData) {
		try {
			MethodDef.clickJS(Administration.Lnk_Payments(), "Minimizing Payments Link");
			MethodDef.clickJS(Administration.Lnk_Administration(), "Administration Link");
			itemMgmtItemRefreshChk(Administration.btn_approve(TestData, Name), "payment transcation",
					Administration.Lnk_Administration());
			// MethodDef.clickJS(Administration.btn_approve(TestData, Name));
			MethodDef.clickJS(Administration.btn_approve(TestData));
			MethodDef.clickJS(Administration.Lnk_Notific(), "Notification Item");
		} catch (Exception e) {
			ExReporter.log(LogStatus.FAIL, "Error in performing Approval/Verify");
		}
	}
	
	public static void itemMgmtItemRefreshChk(By element, String string, By Tab) {
		try {
			if (CommonDef.waitVisibleNoError(element)) {
				MethodDef.clickJS(element, string);
			} else {
				Thread.sleep(20000);
				MethodDef.clickJS(Tab, "Reclick Tab");
				MethodDef.clickJS(Tab, "Reclick Tab");
				MethodDef.clickJS(element, string);
			}
		} catch (Exception E) {
			ExReporter.log(LogStatus.ERROR, "Error Accessing the Item Management Element");
		}
	}

	public static void adminMainNavigation() {
		try {
			MethodDef.click(Administration.Link_Administration(), "Administration Link");
			CommonDef.waitVisibleNoError(Administration.Link_AdminDashboard());
		} catch (Exception e) {
			ExReporter.log(LogStatus.FAIL, "Error in performing Administration Common Flow");
		}
	}

	public static void choosingAccess(String AmendType, String AccessType) {
		for (WebElement elem : CommonDef.findElements(Administration.Table_RowSelect(AccessType))) {
			ExReporter.log(LogStatus.INFO, "Selecting AccessType");
			CommonDef.moveToElement(elem, "Check/Uncheck of : " + AccessType);
			CommonDef.clickJS(elem);
		}
	}

	public static void verificationStep(String grpname) {
		if (!(TestData.getConfig("VerifyUser").equalsIgnoreCase("n/a"))) {
			LoginFns.Logout();
			String verifyuser = TestData.getConfig("VerifyUser");
			ExReporter.log(LogStatus.INFO, "Verify User : " + verifyuser);
			LoginFns.Login(verifyuser);
			try {
				Thread.sleep(6000);
				AdministrationFns.entlVerify(grpname);
			} catch (Exception e) {
				ExReporter.log(LogStatus.ERROR, "Error in verifying Entitlement Accounts");
			}
		}
	}

	public static void authorisationStep(String grpname) {
		if (!(TestData.getConfig("AuthUserL1").equalsIgnoreCase("n/a"))) {
			LoginFns.Logout();
			String approvuserL1 = TestData.getConfig("AuthUserL1");
			ExReporter.log(LogStatus.INFO, "Approve User : " + approvuserL1);
			LoginFns.Login(approvuserL1);
			try {
				Thread.sleep(6000);
				AdministrationFns.entlApproval(grpname);
			} catch (Exception e) {
				ExReporter.log(LogStatus.ERROR, "Error in approving Entitlement Accounts");
			}
		} else if (!(TestData.getConfig("AuthUserL2").equalsIgnoreCase("n/a"))
				&& !TestData.getConfig("DataBinding").contains("Neg")) {
			LoginFns.Logout();
			String approvuserL2 = TestData.getConfig("AuthUserL2");
			ExReporter.log(LogStatus.INFO, "Approve User : " + approvuserL2);
			LoginFns.Login(approvuserL2);
			try {
				Thread.sleep(6000);
				AdministrationFns.entlApproval(grpname);
			} catch (Exception e) {
				ExReporter.log(LogStatus.ERROR, "Error in approving Entitlement Accounts");
			}
		}
	}

	public static void entAccessVerify(String grpname) {
		if (!(TestData.getConfig("VerifyUser").equalsIgnoreCase("n/a"))) {
			String verifyuser = TestData.getConfig("VerifyUser");
			ExReporter.log(LogStatus.INFO, "Verify User : " + verifyuser);
			LoginFns.Login(verifyuser);
			try {
				AdministrationFns.entlVerify(grpname);
			} catch (Exception e) {
				ExReporter.log(LogStatus.FAIL, "Error in verifying Entitlement Access Group");
			}
			LoginFns.Logout();
		}
	}

	public static void entAccessAuth(String grpname) {
		if (!(TestData.getConfig("AuthUserL1").equalsIgnoreCase("n/a"))) {
			String approvuserL1 = TestData.getConfig("AuthUserL1");
			ExReporter.log(LogStatus.INFO, "Approve User : " + approvuserL1);
			LoginFns.Login(approvuserL1);
			try {
				AdministrationFns.entlApproval(grpname);
			} catch (Exception e) {
				ExReporter.log(LogStatus.FAIL, "Error in approving Entitlement Access Groups");
			}
			LoginFns.Logout();
		} else if (!(TestData.getConfig("AuthUserL2").equalsIgnoreCase("n/a"))) {
			String approvuserL2 = TestData.getConfig("AuthUserL2");
			ExReporter.log(LogStatus.INFO, "Approve User : " + approvuserL2);
			LoginFns.Login(approvuserL2);
			try {
				AdministrationFns.entlApproval(grpname);
			} catch (Exception e) {
				ExReporter.log(LogStatus.FAIL, "Error in approving Entitlement Access Groups");
			}
			LoginFns.Logout();
		}
	}

	public static void entitlementAccessGroupAmend(String grpname) {
		adminMainNavigation();
		navToAccessGroup();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		MethodDef.sendKeys(Administration.searchEntAccGrp(), grpname);
		MethodDef.clickJS(Administration.searchBtnEntAccGrp(), "Search Button");

		MethodDef.clickJS(Administration.Link_AmendSelect(grpname), "Amend Link");
		CommonDef.waitVisibleNoError(Administration.Table_ColCount());
		choosingAccess(TestData.getConfig("AmendType"), TestData.getConfig("AccessType"));
		MethodDef.clickJS(Administration.Button_AccGrpUpdate(), "Update Button");
		MethodDef.sendKeys(Administration.Text_AccGrp_HardToken(), ProjectConfig.getPropertyValue("hardtoken"));
		MethodDef.clickJS(Administration.Button_AccGrpUpdateSend(), "Send Option");
		MethodDef.clickJS(Administration.Lnk_Notific(), "Notification Item");
		CommonDef.assertContains(Administration.Link_AccGrp_UpdateMessage(), TestData.getConfig("SuccssMsgUpd"));
	}
}
