package mav.metro.pom.functions;

import com.relevantcodes.extentreports.LogStatus;
import mav.metro.framework.ExReporter;
import mav.metro.framework.ProjectConfig;
import mav.metro.framework.TestData;
import mav.metro.library.functions.CommonDef;
import mav.metro.library.functions.MethodDef;
import mav.metro.pom.elements.Mandates;
import org.apache.commons.lang3.RandomStringUtils;

public class MandatesFns {

	public static String EntitlmentMandates() {
		ExReporter.log(LogStatus.INFO, "Entitlement Mandates Function");
		String grpname = TestData.getConfig("Mandate_Name") + RandomStringUtils.random(5, "ABFERPLDBNVJK");
		try {
			Mandates_Create(grpname);
		} catch (Exception e) {
			ExReporter.log(LogStatus.FAIL, "Error in processing Entitlement Mandates");
		}
		return grpname;
	}

	public static void mandatemainnavigation() {
		try {
		MethodDef.clickJS(Mandates.Link_Administration(), "Admin Link Clicked");
		MethodDef.clickJS(Mandates.Link_Mandates(), "Mandates Link Clicked");
		} catch (Exception E) {
			ExReporter.log(LogStatus.ERROR, "Error navigating to the mandates screen" );
		}
	}

	public static void Mandates_Create(String grpname) {
		try {

			mandatemainnavigation();
			MethodDef.click(Mandates.Btn_Create(), "Create button Clicked");
			MethodDef.sendKeys(Mandates.Txt_MandateName(), grpname);
			MethodDef.sendKeys(Mandates.Txt_MandateDesc(), TestData.getConfig("Mandate_Description"));
			if (TestData.getConfig("Mandate_PayType").equals("All")) {
				MethodDef.sendKeys(Mandates.Txt_MandateAmount("BACS"), TestData.getConfig("Mandate_Amount"));
				MethodDef.sendKeys(Mandates.Txt_MandateAmount("Bulk"), TestData.getConfig("Mandate_Amount"));
				MethodDef.sendKeys(Mandates.Txt_MandateAmount("Chaps"), TestData.getConfig("Mandate_Amount"));
				MethodDef.sendKeys(Mandates.Txt_MandateAmount("Faster payments"), TestData.getConfig("Mandate_Amount"));
				MethodDef.sendKeys(Mandates.Txt_MandateAmount("International"), TestData.getConfig("Mandate_Amount"));
				MethodDef.sendKeys(Mandates.Txt_MandateAmount("Transfer"), TestData.getConfig("Mandate_Amount"));
			} else {
				MethodDef.sendKeys(Mandates.Txt_MandateAmount(TestData.getConfig("Mandate_PayType")),
						TestData.getConfig("Mandate_Amount"));
			}
			CommonDef.waitClickable(Mandates.Link_Save(), "Save Button Clicked");
			MethodDef.clickJS(Mandates.Link_Save(), "Save Button Clicked");
			CommonDef.assertEquals(Mandates.mandateResult(), "Success");
			CommonDef.assertContains(Mandates.mandateResultMessage(), "successfully created");
			// System.out.println(MethodDef.getText(Mandates.mandateResult()));
			// System.out.println(MethodDef.getText(Mandates.mandateResultMessage()));
			MethodDef.clickJS(Mandates.Btn_ClosePopup(), "Close Popup button Clicked");

		} catch (Exception E) {
			ExReporter.log(LogStatus.FAIL, "Mandates Creation Failed" + E.getMessage());
		}
	}

	public static void Mandates_Amend(String grpname) {
		//Random rand = new Random();
		double amt = (Integer.parseInt(TestData.getConfig("Mandate_Amount")) - 1)/2;
		//amt = ((amt - 1) + ((amt + 10) - (amt - 1))) * rand.nextDouble();
		amt = Math.round(amt * 100.00) / 100.00;
		try {
			mandatemainnavigation();
			AdministrationFns.searchAdmin(grpname);
			if (TestData.getConfig("Mandate_Action").equals("Amend")) {

				MethodDef.click(Mandates.Link_MandateName(grpname), "Group Name");
				MethodDef.click(Mandates.Btn_Amend(), "Amend button Clicked");
				if (TestData.getConfig("Mandate_PayType").equals("Bulk")) {
					MethodDef.sendKeys(Mandates.Txt_MandateAmount("Bulk"), amt + "");
				}
				if (TestData.getConfig("Mandate_PayType").equals("Transfer")) {
					MethodDef.sendKeys(Mandates.Txt_MandateAmount("Transfer"), amt + "");
				}
				if (TestData.getConfig("Mandate_PayType").equals("Bacs")) {
					MethodDef.sendKeys(Mandates.Txt_MandateAmount("BACS"), amt + "");
				}
				if (TestData.getConfig("Mandate_PayType").equals("Chaps")) {
					MethodDef.sendKeys(Mandates.Txt_MandateAmount("Chaps"), amt + "");
				}
				if (TestData.getConfig("Mandate_PayType").equals("International")) {
					MethodDef.sendKeys(Mandates.Txt_MandateAmount("International"), amt + "");
				}
				if (TestData.getConfig("Mandate_PayType").equals("Faster payments")) {
					MethodDef.sendKeys(Mandates.Txt_MandateAmount("Faster payments"), amt + "");
				}
				if (TestData.getConfig("Mandate_PayType").equals("All")) {
					MethodDef.sendKeys(Mandates.Txt_MandateAmount("BACS"), amt + "");
					MethodDef.sendKeys(Mandates.Txt_MandateAmount("Bulk"), amt + "");
					MethodDef.sendKeys(Mandates.Txt_MandateAmount("Chaps"), amt + "");
					MethodDef.sendKeys(Mandates.Txt_MandateAmount("Faster payments"), amt + "");
					MethodDef.sendKeys(Mandates.Txt_MandateAmount("International"), amt + "");
					MethodDef.sendKeys(Mandates.Txt_MandateAmount("Transfer"), amt + "");
				}

				CommonDef.waitClickable(Mandates.Btn_Update(), "Update button Clicked");
				MethodDef.clickJS(Mandates.Btn_Update(), "Update button Clicked");
				MethodDef.sendKeys(Mandates.Txt_HardToken(), ProjectConfig.getPropertyValue("hardtoken"));
				MethodDef.clickJS(Mandates.Btn_Send(), "Send button Clicked");
				CommonDef.assertEquals(Mandates.mandateResultHardToken(), "Success");
				CommonDef.assertContains(Mandates.mandateResultMessageHardToken(), "mandate is now updated");

			}
		} catch (Exception E) {
			ExReporter.log(LogStatus.FAIL, "Mandates Amendment Failed" + E.getMessage());
		}
	}

	public static void Mandates_Delete(String grpname) {
		try {
			mandatemainnavigation();
			AdministrationFns.searchAdmin(grpname);
			if (TestData.getConfig("Mandate_Action").equals("Delete")) {

				MethodDef.sendKeys(Mandates.Txt_Delete_MandateName(), grpname);
				MethodDef.click(Mandates.Btn_Search(), "Search button Clicked");
				MethodDef.clickJS(Mandates.ChkBox_Delete_MandateName(grpname));
				MethodDef.click(Mandates.Btn_Delete(), "Delete button Clicked");
				CommonDef.assertEquals(Mandates.Validate_DeleteMandate(),
						"Are you sure you want to delete these items?");
				MethodDef.sendKeys(Mandates.Txt_HardToken_DeleteMandate(), ProjectConfig.getPropertyValue("hardtoken"));
				MethodDef.click(Mandates.Btn_Continue(), "Continue button Clicked");
				CommonDef.isDisplayed(Mandates.Validation_DelMandateSuccess(), "Mandate Deleted Successfully");
				MethodDef.click(Mandates.Btn_ClosePopup_DeleteMandate(),
						"Close Popup button for Deleting Mandate Clicked");
			}
		} catch (Exception E) {
			ExReporter.log(LogStatus.FAIL, "Mandates Deletion Failed" + E.getMessage());

		}

	}
}
