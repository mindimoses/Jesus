package mav.metro.pom.tcib.functions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.remote.RemoteWebDriver;

import mav.metro.driver.DriverFactory;
import mav.metro.framework.ExReporter;
import mav.metro.framework.TestData;
import mav.metro.library.functions.*;
import mav.metro.library.teststeps.TCIBTestSteps;
import mav.metro.pom.tcib.elements.*;

import com.relevantcodes.extentreports.LogStatus;


public class MoveMoneyFns {
//MoveMoney Functionality - Pay now, Regular Payment and Future Dated
public static void movemoney(String customertype){
	WebDriver driver = DriverFactory.getCurrentDriver();
	Keyboard kb = ((RemoteWebDriver) driver).getKeyboard();	
	ExReporter.log(LogStatus.INFO, "Movemoney");
	try {
		if (!customertype.startsWith("Only"))
		{
		BasePageFns.profileChange(TestData.getConfig("ProfileName"));	
		}
		MethodDef.clickJS(MoveMoney.makepayment_menu(), "MakePayment");
		MethodDef.clickJS(MoveMoney.movemoney_button(),"Movemoney button");		
		MethodDef.sendKeys(MoveMoney.movemoney_amount(), TestData.getConfig("Amount"));
		CommonDef.Wait();		
		///kb.pressKey(Keys.TAB);
		BasePageFns.selectItem(MoveMoney.movemoney_From(),TestData.getConfig("FromAc_No"));	
		CommonDef.Wait();	
		///kb.pressKey(Keys.TAB);
		if (!customertype.startsWith("Only"))
		{
		BasePageFns.selectItem(MoveMoney.movemoney_ToProfile(), TestData.getConfig("ToProfile_Name"));
		}
		BasePageFns.selectItem(MoveMoney.movemoney_ToAccount(), TestData.getConfig("ToAc_No"));
		TCIBTestSteps.Frequency();
		MethodDef.clickJS(MoveMoney.continue_button(), "Continue");
		if (TestData.getConfig("DataBinding").contains("Neg"))
		{ExReporter.log(LogStatus.INFO, "Negative Pass");		}
		else{
		MethodDef.clickJS(MoveMoney.makepayment_button(),"Payment Confirmed");
		if (TestData.getConfig("PaymentMethod").equals("Regular_Payment"))
		{MethodDef.assertElemsContains(MoveMoney.success_regularpayment(), TestData.getConfig("SuccessMessage"));}	
		else
		{		
		MethodDef.assertElemsContains(MoveMoney.success_message(), TestData.getConfig("SuccessMessage"));}
		MethodDef.clickJS(MoveMoney.Account_summary(), "Account Summary Screen");
		TCIBTestSteps.AccountSelection();		
		}
	}
	catch (Exception e) {
		ExReporter.log(LogStatus.ERROR, "Error in performing movemoney Function");
	}
}	
}	


