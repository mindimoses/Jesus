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

public class InterstitialFns {
	//Interstitial Functionality - Edge Admin Console
	public static void Interstitial(){
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
			String ShowOption = TestData.getConfig("ShowOption");
			String StoreID = TestData.getConfig("StoreID");
			String ProductID = TestData.getConfig("ProductID");
			String StatusMessage = TestData.getConfig("StatusMessage");
			String MessageID =TestData.getConfig("MessageID");
			MethodDef.clickJS(Interstitial.Interstitial_AdminLink(), "Admin Menu");
			MethodDef.clickJS(Interstitial.Interstitial_AdminLink(), "Admin Menu");
			CommonDef.Wait();
			MethodDef.click(Interstitial.Interstitial_Link(), "Manage Interstitial Menu");
			CommonDef.Wait();
			if (Action.equals("Create"))
			{
			MethodDef.clickJS(Interstitial.Interstitial_AddButton(), "Interstitial Add Button");
			MethodDef.sendKeys(Interstitial.Interstitial_Title(), Title);
			MethodDef.sendKeys(Interstitial.StartDateTimeInput(), StartTime);
			MethodDef.sendKeys(Interstitial.Interstitial_Message(), Message);
			if(!EndTime.equalsIgnoreCase("n/a"))
			{MethodDef.sendKeys(Interstitial.StopDateTimeInput(), EndTime);
			}						
			if(!PublishList.equalsIgnoreCase("n/a"))
			{
			MethodDef.clickJS(Interstitial.Interstitial_Publish(), "Publish List");			
			}
			if(!ShowOption.equalsIgnoreCase("n/a"))
			{
			MethodDef.clickJS(Interstitial.Interstitial_ShowDonot(), "Show Donot");
			}		
			if(!StoreID.equalsIgnoreCase("n/a"))
			{
			MethodDef.sendKeys(Interstitial.Interstitial_Store(), StoreID);			
			}		
			if(!ProductID.equalsIgnoreCase("n/a"))
			{
			MethodDef.sendKeys(Interstitial.Interstitial_Product(), ProductID);
			}
			MethodDef.clickJS(Interstitial.Interstitial_Create(), "Create button");			
			}
			else if (Action.equals("Update"))
			{
			MethodDef.clickJS(Interstitial.Interstitial_SelectMessage(MessageID), "Select Message");
			
			if(!Title.equalsIgnoreCase("n/a"))
			{
			MethodDef.sendKeys(Interstitial.Interstitial_Title(), Title);
			}
			if(!StartTime.equalsIgnoreCase("n/a"))
			{
			MethodDef.sendKeys(Interstitial.StartDateTimeInput(), StartTime);
			}
			if(!EndTime.equalsIgnoreCase("n/a"))
			{
			MethodDef.sendKeys(Interstitial.StopDateTimeInput(), EndTime);
			}
			if(!Message.equalsIgnoreCase("n/a"))
			{
			MethodDef.sendKeys(Interstitial.Interstitial_Message(), Message);
			}
			if(!PublishList.equalsIgnoreCase("n/a"))
			{
			MethodDef.clickJS(Interstitial.Interstitial_Publish(), "Publish List");
			}
			if(!ShowOption.equalsIgnoreCase("n/a"))
			{
			MethodDef.clickJS(Interstitial.Interstitial_ShowDonot(), "Show Donot");
			}		
			if(!StoreID.equalsIgnoreCase("n/a"))
			{
			MethodDef.sendKeys(Interstitial.Interstitial_Store(), StoreID);
			}		
			if(!ProductID.equalsIgnoreCase("n/a"))
			{
			MethodDef.sendKeys(Interstitial.Interstitial_Product(), ProductID);
			}	
			MethodDef.clickJS(Interstitial.Interstitial_Update(), "Update button");		
			}	
			CommonDef.assertContains(Interstitial.Interstitial_SuccessMessage(), StatusMessage);
			MethodDef.clickJS(Interstitial.Interstitial_Back(), "Back button");
		}
		catch (Exception e) {
			ExReporter.log(LogStatus.ERROR, "Error in performing Interstitial Function");
		}
	}

	
}
