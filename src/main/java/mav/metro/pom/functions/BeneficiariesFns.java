package mav.metro.pom.functions;

import com.relevantcodes.extentreports.LogStatus;
import mav.metro.framework.ExReporter;
import mav.metro.framework.TestData;
import mav.metro.library.functions.CommonDef;
import mav.metro.library.functions.MethodDef;
import mav.metro.pom.elements.Beneficiaries;
import org.apache.commons.lang3.RandomStringUtils;

public class BeneficiariesFns extends PaymentsFns {

	public static String Beneficiaries() {
		String nickname = TestData.getConfig("Nick Name");
		String scode = TestData.getConfig("sortcode");
		String accno = TestData.getConfig("account no");
		String biccode = TestData.getConfig("BIC Code");
		String iban = TestData.getConfig("IBAN");
		String ref = TestData.getConfig("Reference") + RandomStringUtils.random(5, "ABFERPLDBNVJK");
		String sucmsg = TestData.getConfig("successMsg");

		try {
			MethodDef.click(Beneficiaries.bengrp_link(), "Beneficiry Link");
			CommonDef.waitVisibleNoError(Beneficiaries.bengrp_dashboard());
			CommonDef.waitForPageLoad();
			if (TestData.getConfig("Action").equals("Create")) {

				String benname = "BEN" + RandomStringUtils.random(5, "ABFERPLDBNVJK")
						+ RandomStringUtils.random(3, "ZYU");
				CommonDef.waitClickable(Beneficiaries.bengrp_beneficiaryButton(), "Create New Beneficiary button");
				Thread.sleep(2000);
				MethodDef.click(Beneficiaries.bengrp_beneficiaryButton(), "Create New Beneficiary button");
				if (TestData.getConfig("Beneficiary Type").equals("Domestic")) {
					MethodDef.sendKeys(Beneficiaries.bengrp_domName(), benname);
					MethodDef.sendKeys(Beneficiaries.bengrp_domnickName(), nickname);
					MethodDef.sendKeys(Beneficiaries.bengrp_domSortCode(), scode);
					MethodDef.sendKeys(Beneficiaries.bengrp_domAccountNumber(), accno);
					MethodDef.sendKeys(Beneficiaries.bengrp_domReference(), ref);
					if (TestData.getConfig("Reference").contains("NicNeg"))
						CommonDef.assertContains(Beneficiaries.nickWarning(), TestData.getConfig("Decision"));
					else {
						MethodDef.clickJS(Beneficiaries.bengrp_domSave(), "Save");
						hardTokenEnter(Beneficiaries.bengrp_domhardToken());
						MethodDef.clickJS(Beneficiaries.bengrp_domsubmit(), "Submit button");
						CommonDef.assertEquals(Beneficiaries.bengrp_domBeneCreated(), sucmsg);
					}
				} else if (TestData.getConfig("Beneficiary Type").equals("International")) {
					MethodDef.click(Beneficiaries.bengrp_intTab(), "International Tab");
					MethodDef.sendKeys(Beneficiaries.bengrp_intName(), benname);
					MethodDef.sendKeys(Beneficiaries.bengrp_intnickName(), nickname);
					MethodDef.sendKeys(Beneficiaries.bengrp_intSwiftCode(), biccode);
					MethodDef.sendKeys(Beneficiaries.bengrp_intIBAN(), iban);
					MethodDef.sendKeys(Beneficiaries.bengrp_intReference(), ref);

					if (TestData.getConfig("Reference").contains("NicNeg"))
						CommonDef.assertContains(Beneficiaries.nickWarning(), TestData.getConfig("Decision"));
					else {
						MethodDef.clickJS(Beneficiaries.bengrp_intSave(), "Save");
						hardTokenEnter(Beneficiaries.bengrp_inthardToken());
						MethodDef.clickJS(Beneficiaries.bengrp_intsubmit(), "Submit button");
						CommonDef.assertEquals(Beneficiaries.benefCreated(), sucmsg);
					}
				} else if (TestData.getConfig("Beneficiary Type").equals("Biller")) {
					MethodDef.click(Beneficiaries.bengrp_billerTab(), "Biller Tab");
					MethodDef.sendKeys(Beneficiaries.bengrp_bilnickName(), benname);
					MethodDef.click(Beneficiaries.bengrp_billSelectCom(), "Select Company");
					MethodDef.sendKeys(Beneficiaries.bengrp_billInputCom(), TestData.getConfig("Company"));
					MethodDef.click(Beneficiaries.bengrp_billClickCom(TestData.getConfig("Company")));

					MethodDef.sendKeys(Beneficiaries.bengrp_bilReference(), ref);
					if (TestData.getConfig("Reference").contains("NicNeg"))
						CommonDef.assertContains(Beneficiaries.nickWarning(), TestData.getConfig("Decision"));
					else {
						MethodDef.clickJS(Beneficiaries.bengrp_billSave(), "Save");
						hardTokenEnter(Beneficiaries.bengrp_billhardToken());
						MethodDef.clickJS(Beneficiaries.bengrp_billsubmit(), "Submit button");
						CommonDef.assertEquals(Beneficiaries.benefCreated(), sucmsg);
					}
				}
			}
		} catch (Exception e) {
			ExReporter.log(LogStatus.ERROR, "Error in creating beneficiary: " + e.getMessage());
		}
		return ref;
	}

	public static void BeneficiariesVerify(String Reference, String verifyAction) {
		String Type;
		Type = TestData.getConfig("Beneficiary Type");
		ExReporter.log(LogStatus.INFO, "Payments" + verifyAction);
		MethodDef.click(Beneficiaries.Btn_ItemMgmt(), "Item Management");
		CommonDef.waitVisibleNoError(Beneficiaries.Link_Tabs());
		MethodDef.click(Beneficiaries.Link_VerifTab(), verifyAction + "Tab");
		MethodDef.click(Beneficiaries.bengrp_beneficiaryDrop(), "Beneficiares dropdown");
		ExReporter.log(LogStatus.INFO, "Transaction Reference : " + Reference);
		if (Type.equalsIgnoreCase("international")) {
			CommonDef.waitVisibleNoError(Beneficiaries.Btn_Ddown_ItemMgmt());
			// MethodDef.findElementsClick(Beneficiaries.Btn_Ddown_ItemMgmt());
			int totalelems = CommonDef.findElements(Beneficiaries.approvalDomtr(Reference)).size();
			MethodDef.clickJS(Beneficiaries.bengrp_intDecision(Reference, verifyAction, totalelems),
					"international beneficiary");
		} else if (Type.equalsIgnoreCase("domestic")) {
			int totalelems = CommonDef.findElements(Beneficiaries.approvalDomtr(Reference)).size();
			MethodDef.clickJS(Beneficiaries.bengrp_decisionItem(Reference, verifyAction, totalelems),
					"Verify Transcation");
		} else if (Type.equalsIgnoreCase("biller")) {
			MethodDef.clickJS(Beneficiaries.bengrp_decisionItem(Reference, verifyAction), "Verify Transcation");
		}
		MethodDef.clickJS(Beneficiaries.Btn_confirmDecision(verifyAction), verifyAction + "Transaction Button");
		MethodDef.clickJS(Beneficiaries.Lnk_Notific());
		verificationValidation(verifyAction);
		MethodDef.clickJS(Beneficiaries.Btn_CloseAppVer(), "Close Popup Window");
	}

	public static void BeneficiariesApproval(String Referen) {
		String Act, Type;
		Act = TestData.getConfig("Auth_Action");
		Type = TestData.getConfig("Beneficiary Type");
		ExReporter.log(LogStatus.INFO, "Payments" + Act);
		MethodDef.click(Beneficiaries.Btn_ItemMgmt(), "Item Management");
		MethodDef.clickJS(Beneficiaries.bengrp_beneficiaryDrop(), "Beneficiares dropdown");
		ExReporter.log(LogStatus.INFO, "Transaction Reference : " + Referen);
		if (Type.equalsIgnoreCase("international")) {
			CommonDef.waitVisibleNoError(Beneficiaries.Btn_Ddown_ItemMgmt());
			// MethodDef.findElementsClick(Beneficiaries.Btn_Ddown_ItemMgmt());
			int totalelems = CommonDef.findElements(Beneficiaries.approvalDomtr(Referen)).size();
			MethodDef.clickJS(Beneficiaries.bengrp_intDecision(Referen, Act, totalelems),
					"Approve international Transcation");
		} else if (Type.equalsIgnoreCase("domestic")) {
			int totalelems = CommonDef.findElements(Beneficiaries.approvalDomtr(Referen)).size();
			MethodDef.clickJS(Beneficiaries.bengrp_decisionItem(Referen, Act, totalelems),
					"Approve Domestic Transcation");
		} else if (Type.equalsIgnoreCase("biller")) {
			MethodDef.clickJS(Beneficiaries.bengrp_decisionItem(Referen, Act), "Approve Biller Transcation");
		}
		MethodDef.clickJS(Beneficiaries.Btn_confirmDecision(Act), Act + "Transaction Button");
		MethodDef.clickJS(Beneficiaries.Lnk_Notific());
		approvalValidation(Act);
		MethodDef.clickJS(Beneficiaries.Btn_CloseAppVer(), "Close Popup Window");
	}
}
