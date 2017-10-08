package mav.metro.pom.tcib.functions;

import org.openqa.selenium.Keys;

import mav.metro.driver.DriverFactory;
import mav.metro.framework.ExReporter;
import mav.metro.framework.TestData;
import mav.metro.library.functions.*;
import mav.metro.library.teststeps.TCIBTestSteps;
import mav.metro.pom.tcib.elements.MoveMoney;
import mav.metro.pom.tcib.elements.SendMoney;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.LogStatus;

public class SendMoneyFns {
//Send Money Functionality 
	public static void sendmoney(String customertype){
	WebDriver driver = DriverFactory.getCurrentDriver();	
	Keyboard kb = ((RemoteWebDriver) driver).getKeyboard();	
	ExReporter.log(LogStatus.INFO, "SendMoney");
	try {
		if (!customertype.startsWith("Only"))
		{
		BasePageFns.profileChange(TestData.getConfig("ProfileName"));	
		}
		MethodDef.clickJS(MoveMoney.makepayment_menu(), "MakePayment");
		MethodDef.clickJS(SendMoney.sendmoney_button(),"SendMoney button");		
		MethodDef.sendKeys(SendMoney.sendmoney_amount(), TestData.getConfig("Amount"));
		BasePageFns.selectItem(SendMoney.sendmoney_From(),TestData.getConfig("FromAc_No"));
		CommonDef.Wait();
		///kb.pressKey(Keys.TAB);
		if(TestData.getConfig("Payee_Category").equals("From Payee List"))
		{
		MethodDef.click(SendMoney.SendMoney_Payeelist(0),"Payee list");
		}
		BasePageFns.selectItem(SendMoney.Sendmoney_Payee(), TestData.getConfig("Beneficiary_Number"));
		CommonDef.Wait();
		MethodDef.sendKeys(SendMoney.Sendmoney_reference(), TestData.getConfig("Reference_Name"));		
		TCIBTestSteps.Frequency();
		MethodDef.clickJS(MoveMoney.continue_button(), "Continue");
		if (TestData.getConfig("DataBinding").contains("Neg"))
		{ExReporter.log(LogStatus.INFO, "Negative Pass");		}
		else
		{
		MethodDef.clickJS(MoveMoney.makepayment_button(),"Payment Confirmed");		
		if (TestData.getConfig("PaymentMethod").equals("Regular_Payment"))
		{MethodDef.assertElemsContains(MoveMoney.success_regularpayment(), TestData.getConfig("SuccessMessage"));}	
		else
		{		
		MethodDef.assertElemsContains(SendMoney.success_message(), TestData.getConfig("SuccessMessage"));}
		
		MethodDef.clickJS(SendMoney.Account_summary(), "Account Summary Screen");
		TCIBTestSteps.AccountSelection();
		}
	}
	catch (Exception e) {		
		ExReporter.log(LogStatus.ERROR, "Error in performing sendmoney Function");
	}
}	
}