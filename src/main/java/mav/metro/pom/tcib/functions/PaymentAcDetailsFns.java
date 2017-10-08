package mav.metro.pom.tcib.functions;

import org.openqa.selenium.Keys;

import mav.metro.framework.ExReporter;
import mav.metro.framework.TestData;
import mav.metro.library.functions.CommonDef;
import mav.metro.library.functions.MethodDef;
import mav.metro.library.teststeps.TCIBTestSteps;
import mav.metro.pom.tcib.elements.*;

import com.relevantcodes.extentreports.LogStatus;


public class PaymentAcDetailsFns {
	//Payment Account details Functionality 
			public static void PaymentAcDetails(String customertype){
			ExReporter.log(LogStatus.INFO, "Payment Account Details");
			try {
				if (!customertype.startsWith("Only"))
				{
				BasePageFns.profileChange(TestData.getConfig("ProfileName"));	
				}
				BasePageFns.AcDetails(PaymentAcDetails.PayAcDetails_ViewAc(),PaymentAcDetails.PayAcDetails_AccountNo(), TestData.getConfig("Account_No"));
				
				if (TestData.getConfig("Select_Payment").equals("MoveMoney"))
				{
					MethodDef.clickJS(PaymentAcDetails.PayAcDetails_MakePayment(), "Tab Make payment");
					MethodDef.clickJS(PaymentAcDetails.PayAcDetails_MoveMoney(), "Move Money button");
					MethodDef.sendKeys(MoveMoney.movemoney_amount(), TestData.getConfig("Amount"));	
					CommonDef.Wait();
					BasePageFns.selectItem(MoveMoney.movemoney_ToAccount(), TestData.getConfig("ToAc_No"));				
					TCIBTestSteps.Frequency();
					MethodDef.clickJS(MoveMoney.continue_button(), "Continue");
					MethodDef.clickJS(MoveMoney.makepayment_button(),"Payment Confirmed");							
					MethodDef.assertElemsContains(MoveMoney.success_message(), TestData.getConfig("SuccessMessage"));		
					//TCIBTestSteps.CommonMoveMoney();
				}
				else if (TestData.getConfig("Select_Payment").equals("SendMoney"))
				{
					MethodDef.clickJS(PaymentAcDetails.PayAcDetails_MakePayment(), "Tab Make payment");
					MethodDef.clickJS(PaymentAcDetails.PayAcDetails_SendMoney(), "Send Money button");
					TCIBTestSteps.CommonSendMoney();
				}
				else if (TestData.getConfig("Select_Payment").equals("Edit_AcName"))
				{
					MethodDef.clickJS(PaymentAcDetails.PayAcDetails_EditLink(),"Edit Link ");
					MethodDef.sendKeys(PaymentAcDetails.PayAcDetails_EditName(),TestData.getConfig("Edit_AcName"));
					MethodDef.clickJS(PaymentAcDetails.PayAcDetails_EditSave(),"Save Link ");
					MethodDef.assertElemsContains(PaymentAcDetails.PayAcDetails_EditVerify(TestData.getConfig("Edit_AcName")), TestData.getConfig("Edit_AcName"));
					
				}
				else if (TestData.getConfig("Select_Payment").equals("Create_RegularPay"))
				{
					MethodDef.clickJS(PaymentAcDetails.PayAcDetails_RegularPayments(),"Regular Payments Tab");
					MethodDef.clickJS(PaymentAcDetails.PayAcDetails_CreateRegular(),"Create Regular Payments Link ");					
					TCIBTestSteps.CommonMoveMoney();					
				}
				else if (TestData.getConfig("Select_Payment").equals("Edit_RegularPayment"))
				{
					MethodDef.clickJS(PaymentAcDetails.PayAcDetails_RegularPayments(),"Regular Payments Tab ");
					BasePageFns.selectRegular(PaymentAcDetails.PayAcDetails_RegPayAc(),TestData.getConfig("ToAc_No"));
					//BasePageFns.selectRegular(PaymentAcDetails.PayAcDetails_RegPayAc(),PaymentAcDetails.PayAcDetails_ActionClick(), TestData.getConfig("ToAc_No"));
					MethodDef.clickJS(PaymentAcDetails.PayAcDetails_ChangeRegular(),"Change Regular Payments");
					MethodDef.sendKeys(PaymentAcDetails.PayAcDetails_ChangeReference(),TestData.getConfig("Edit_Reference"));
					MethodDef.click(PaymentAcDetails.PayAcDetails_SaveChanges(),"Save Changes");
					MethodDef.assertElemsContains(PaymentAcDetails.PayAcDetails_RegularSuccess(), TestData.getConfig("SuccessMessage"));
					MethodDef.click(PaymentAcDetails.PayAcDetails_RegularClose(), "Close button");
				}
				else if (TestData.getConfig("Select_Payment").equals("Cancel_RegularPayment"))
				{
					MethodDef.clickJS(PaymentAcDetails.PayAcDetails_RegularPayments(),"Regular Payments Tab ");
					BasePageFns.selectRegular(PaymentAcDetails.PayAcDetails_RegPayAc(), TestData.getConfig("ToAc_No"));
					MethodDef.clickJS(PaymentAcDetails.PayAcDetails_CancelRegular(),"Cancel Regular Payments");
					MethodDef.click(PaymentAcDetails.PayAcDetails_Cancelbutton(),"Cancel Button");					
					MethodDef.assertElemsContains(PaymentAcDetails.PayAcDetails_CancelSuccess(), TestData.getConfig("SuccessMessage"));
					MethodDef.click(PaymentAcDetails.PayAcDetails_CancelClose(), "Close button");
				}
				else if (TestData.getConfig("Select_Payment").equals("Edit_Error"))
				{
					MethodDef.clickJS(PaymentAcDetails.PayAcDetails_EditLink(),"Edit Link");
					CommonDef.Wait();
					if (!TestData.getConfig("Edit_AcName").equals("n/a")){
					MethodDef.sendKeys(PaymentAcDetails.PayAcDetails_EditName(),TestData.getConfig("Edit_AcName"));}
					MethodDef.clickJS(PaymentAcDetails.PayAcDetails_EditSave(),"Save Link ");
					MethodDef.assertElemsContains(PaymentAcDetails.PayAcDetails_EditError(), TestData.getConfig("ErrorMessage"));
					
				}
				
			}
			catch (Exception e) {
				ExReporter.log(LogStatus.ERROR, "Error in performing Payment AC details Function");
			}
		}
			
}		
