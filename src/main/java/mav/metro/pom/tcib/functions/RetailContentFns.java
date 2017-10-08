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
public class RetailContentFns {
	//Retail Content Functionality - Edge Admin Console
		public static void RetailContent(){
			WebDriver driver = DriverFactory.getCurrentDriver();
			Keyboard kb = ((RemoteWebDriver) driver).getKeyboard();	
			ExReporter.log(LogStatus.INFO, "Account Applicablity");
			try {					
				String Action = TestData.getConfig("Action");
				String Existing = TestData.getConfig("Existing");
				String Content = TestData.getConfig("Content");					
				String Comments = TestData.getConfig("Comments");
				String StatusMessage = TestData.getConfig("StatusMessage");	
				MethodDef.clickJS(Interstitial.Interstitial_AdminLink(), "Admin Menu");
				MethodDef.clickJS(Interstitial.Interstitial_AdminLink(), "Admin Menu");
				CommonDef.Wait();
				MethodDef.clickJS(RetailContent.RetailContent_Link(), "Retail Content");				
				if (Action.equals("Update"))
				{									
					MethodDef.clickJS(RetailContent.RetailContent_EditMessage(Existing), "Retail Content");
					if(!Content.equalsIgnoreCase("n/a"))
					{
					MethodDef.sendKeys(RetailContent.RetailContent_Content(), Content);
					}	
					if(!Comments.equalsIgnoreCase("n/a"))
					{
					MethodDef.sendKeys(RetailContent.RetailContent_Comments(), Comments);
					}			
					MethodDef.clickJS(RetailContent.RetailContent_Save(), "Save Button");
					CommonDef.assertContains(RetailContent.RetailContent_SuccessMessage(), StatusMessage);
				}
			}
			catch (Exception e) {
				ExReporter.log(LogStatus.ERROR, "Error in performing retail contents Function");
			}
		}
}
