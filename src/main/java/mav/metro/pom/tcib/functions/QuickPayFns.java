package mav.metro.pom.tcib.functions;

import mav.metro.driver.DriverFactory;
import mav.metro.framework.ExReporter;
import mav.metro.framework.TestData;
import mav.metro.library.functions.CommonDef;
import mav.metro.library.functions.MethodDef;
import mav.metro.pom.tcib.elements.QuickPay;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.LogStatus;

public class QuickPayFns {
	//QuickPay Functionality - Saved Payee, One of your accounts
	public static void QuickPay(String customertype){
		WebDriver driver = DriverFactory.getCurrentDriver();
		Keyboard kb = ((RemoteWebDriver) driver).getKeyboard();	
		ExReporter.log(LogStatus.INFO, "QuickPay Functionality");
		try {
			if (!customertype.startsWith("Only"))
			{
			BasePageFns.profileChange(TestData.getConfig("ProfileName"));	
			}
			String[] Val2 = TestData.getConfig("SelectPayee").toString().split("_");			
			MethodDef.clickJS(QuickPay.QuickPay_Home(), "Home Menu");
			MethodDef.sendKeys(QuickPay.QuickPay_Amount(), TestData.getConfig("Amount"));
			MethodDef.click(QuickPay.QuickPay_AccountType(Val2[1]),"Payee Type");
			if (Val2[1].equals("0"))	{	
			///kb.pressKey(Keys.TAB);
			CommonDef.Wait();
			BasePageFns.selectItem(QuickPay.QuickPay_OneFromAccount(),TestData.getConfig("From_Ac"));
			
			if (!customertype.startsWith("Only"))
			{
			//kb.pressKey(Keys.TAB);	
			CommonDef.Wait();
			BasePageFns.selectItem(QuickPay.QuickPay_OneProfile(), TestData.getConfig("Profile"));
			CommonDef.Wait();
			///kb.pressKey(Keys.TAB);			
			}
			if (customertype.startsWith("Only"))
			{
			///kb.pressKey(Keys.TAB);
			CommonDef.Wait();
			///kb.pressKey(Keys.TAB);			
			}
			BasePageFns.selectItem(QuickPay.QuickPay_OneSelectAc(), TestData.getConfig("To_Ac"));
			MethodDef.clickJS(QuickPay.QuickPay_Continue(), "Continue");
			MethodDef.clickJS(QuickPay.QuickPay_OneConfirm(),"Payment Confirmed");
			}
			else
			{
			//kb.pressKey(Keys.TAB);
			BasePageFns.selectItem(QuickPay.QuickPay_SavedFromAccount(),TestData.getConfig("From_Ac"));					
			///kb.pressKey(Keys.TAB);
			CommonDef.Wait();
			BasePageFns.selectItem(QuickPay.QuickPay_SavedPayee(), TestData.getConfig("Select_Payee"));	
			CommonDef.Wait();
			MethodDef.sendKeys(QuickPay.QuickPay_SavedReference(), TestData.getConfig("Payee_Reference"));
			MethodDef.clickJS(QuickPay.QuickPay_Continue(), "Continue");
			MethodDef.clickJS(QuickPay.QuickPay_SavedConfirm(),"Payment Confirmed");
			}
			MethodDef.assertElemsContains(QuickPay.success_message(), TestData.getConfig("SuccessMessage"));
			MethodDef.clickJS(QuickPay.QuickPay_viewtranscations(), "Account Summary Screen");
			
		}
		catch (Exception e) {
			ExReporter.log(LogStatus.ERROR, "Error in performing QuickPay Function");
		}
	}	
}
