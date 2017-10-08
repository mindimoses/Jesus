package mav.metro.pom.tcib.functions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.remote.RemoteWebDriver;

import mav.metro.driver.DriverFactory;
import mav.metro.framework.ExReporter;
import mav.metro.framework.TestData;
import mav.metro.library.functions.*;
import mav.metro.pom.tcib.elements.*;

import com.relevantcodes.extentreports.LogStatus;

public class TermsandCondFns {
	//TermsandCond Functionality - Edge Admin Console
	public static void TermsandCond(){
		WebDriver driver = DriverFactory.getCurrentDriver();
		Keyboard kb = ((RemoteWebDriver) driver).getKeyboard();	
		ExReporter.log(LogStatus.INFO, "Interstitial");
		try {			
			String Action = TestData.getConfig("Action");
			String Title = TestData.getConfig("Title");			
			String StartTime = TestData.getConfig("StartTime");
			String EndTime = TestData.getConfig("EndTime");
			String Message = TestData.getConfig("Message");
			String PublishList = TestData.getConfig("PublishList");			
			String StatusMessage = TestData.getConfig("StatusMessage");
			String MessageID =TestData.getConfig("MessageID");
			MethodDef.clickJS(Interstitial.Interstitial_AdminLink(), "Admin Menu");
			MethodDef.clickJS(Interstitial.Interstitial_AdminLink(), "Admin Menu");
			CommonDef.Wait();
			MethodDef.clickJS(Interstitial.Interstitial_Link(), "Interstitial Link Menu");
			CommonDef.Wait();
			if (Action.equals("Create"))
			{
			MethodDef.clickJS(TermsandCond.TermsandCond_AddButton(), "TermsandCond Add Button");
			MethodDef.sendKeys(TermsandCond.TermsandCond_Title(), Title);
			MethodDef.sendKeys(TermsandCond.TermsandCond_Start(), StartTime);
			MethodDef.sendKeys(TermsandCond.TermsandCond_Message(), Message);
			if(!EndTime.equalsIgnoreCase("n/a"))
			{MethodDef.sendKeys(TermsandCond.TermsandCond_Stop(), EndTime);
			}						
			if(!PublishList.equalsIgnoreCase("n/a"))
			{
			MethodDef.clickJS(TermsandCond.TermsandCond_Publish(), "Publish List");			
			}			
			MethodDef.clickJS(TermsandCond.TermsandCond_Create(), "Create button");			
			}
			else if (Action.equals("Update"))
			{
			MethodDef.clickJS(TermsandCond.TermsandCond_SelectMessage(MessageID), "Select Message");
			
			if(!StartTime.equalsIgnoreCase("n/a"))
			{
			MethodDef.sendKeys(TermsandCond.TermsandCond_Start(), StartTime);
			}
			if(!EndTime.equalsIgnoreCase("n/a"))
			{
			MethodDef.sendKeys(TermsandCond.TermsandCond_Stop(), EndTime);
			}			
			MethodDef.clickJS(TermsandCond.TermsandCond_Update(), "Update button");		
			}	
			CommonDef.assertContains(TermsandCond.TermsandCond_SuccessMessage(), StatusMessage);
			MethodDef.clickJS(TermsandCond.TermsandCond_Back(), "Back button");
		}
		catch (Exception e) {
			ExReporter.log(LogStatus.ERROR, "Error in performing TermsandCond Function");
		}
	}
}
