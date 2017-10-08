package mav.metro.pom.tcib.functions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.remote.RemoteWebDriver;

import mav.metro.driver.DriverFactory;
import mav.metro.framework.ExReporter;
import mav.metro.framework.TestData;
import mav.metro.library.functions.CommonDef;
import mav.metro.library.functions.MethodDef;
import mav.metro.library.teststeps.TCIBTestSteps;
import mav.metro.pom.tcib.elements.*;

import com.relevantcodes.extentreports.LogStatus;

public class PayeeManagementFns {
	//Payee Management Functionality 
		public static void PayeeManagement(String customertype){
		ExReporter.log(LogStatus.INFO, "PayeeManagement");
		WebDriver driver = DriverFactory.getCurrentDriver();
		Keyboard kb = ((RemoteWebDriver) driver).getKeyboard();
		try {
			if (!customertype.startsWith("Only"))
			{
			BasePageFns.profileChange(TestData.getConfig("ProfileName"));	
			}		
			MethodDef.clickJS(PayeeManagement.PayMag_Payeemenu(), "Your Payee list");
			BasePageFns.selectLink(PayeeManagement.PayMag_Payeelist(),TestData.getConfig("Payee_Name"));	
			if (TestData.getConfig("Action").equals("ChangeReference"))
			{
				MethodDef.clickJS(PayeeManagement.PayMag_ChangePayee(),"Change Reference");
				MethodDef.sendKeys(PayeeManagement.PayMag_ChangeReference(), TestData.getConfig("Edit_Reference"));
				MethodDef.click(PayeeManagement.PayMag_ChangeContinue(), "Continue");
				MethodDef.assertElemsContains(PayeeManagement.PayMag_ReferenceMessage(), TestData.getConfig("SuccessMessage"));
				MethodDef.click(PayeeManagement.PayMag_ReferenceClose(), "Close button");
			}
			else if (TestData.getConfig("Action").equals("SendMoney"))
			{
				MethodDef.clickJS(PayeeManagement.PayMag_SendMoney(),"Send Money");
				MethodDef.sendKeys(SendMoney.sendmoney_amount(), TestData.getConfig("Amount"));
				CommonDef.Wait();
				///kb.pressKey(Keys.TAB);
				BasePageFns.selectItem(SendMoney.sendmoney_From(),TestData.getConfig("FromAc_No"));	
				TCIBTestSteps.Frequency();
				MethodDef.clickJS(MoveMoney.continue_button(), "Continue");
				MethodDef.clickJS(MoveMoney.makepayment_button(),"Payment Confirmed");
				MethodDef.assertElemsContains(SendMoney.success_message(), TestData.getConfig("SuccessMessage"));
				//TCIBTestSteps.CommonSendMoney();		
			}
			else
			{
				MethodDef.clickJS(PayeeManagement.PayMag_DeletePayee(),"Delete Payee");
				MethodDef.click(PayeeManagement.PayMag_YesDeletePayee(),"yes button");
				MethodDef.assertElemsContains(PayeeManagement.PayMag_DeleteMessage(),TestData.getConfig("SuccessMessage"));
				MethodDef.click(PayeeManagement.PayMag_DeleteClose(), "Close button");
			}
		
		}
		catch (Exception e) {
			ExReporter.log(LogStatus.ERROR, "Error in performing payee management Function");
		}
	}
}
	
