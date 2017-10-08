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
public class AccountApplicablityFns {
	//Account Applicablity Functionality - Edge Admin Console
		public static void AccountApplicablity(){
			WebDriver driver = DriverFactory.getCurrentDriver();
			Keyboard kb = ((RemoteWebDriver) driver).getKeyboard();	
			ExReporter.log(LogStatus.INFO, "Account Applicablity");
			try {					
				String Action = TestData.getConfig("Action");
				String Product = TestData.getConfig("Product");	
				String Customer = TestData.getConfig("Customer");
				String AccountType = TestData.getConfig("AccountType");			
				String ProductClassification = TestData.getConfig("ProductClassification");
				String Description = TestData.getConfig("Description").toString();					
				String StatusMessage = TestData.getConfig("StatusMessage");	
				
				MethodDef.clickJS(AccountApplicablity.AccAppli_AdminLink(), "Admin Menu");
				MethodDef.clickJS(AccountApplicablity.AccAppli_AdminLink(), "Admin Menu");
				CommonDef.Wait();
				MethodDef.clickJS(AccountApplicablity.AccAppli_AppliLink(), "Account Applicablity Menu");
				CommonDef.Wait();
				MethodDef.clickJS(AccountApplicablity.AccAppli_TabSelect(Customer), "Tab Selection");
				CommonDef.Wait();
				BasePageFns.selectItem(AccountApplicablity.AccAppli_AccountSelection(), AccountType);
				MethodDef.clickJS(AccountApplicablity.AccAppli_ProductClassification(), "Product Classification");
				if (Action.equals("Create"))
				{
				MethodDef.sendKeys(AccountApplicablity.AccAppli_ProdClassifi(), ProductClassification);
				MethodDef.sendKeys(AccountApplicablity.AccAppli_ProdDescription(), Description);
				MethodDef.clickJS(AccountApplicablity.AccAppli_Add(), "Add Button");
				}
				else if (Action.equals("Update"))
				{
					MethodDef.clickJS(AccountApplicablity.AccAppli_EditProduct(Product), "Edit Customer");
						
					if(!ProductClassification.equalsIgnoreCase("n/a"))
					{
					MethodDef.sendKeys(AccountApplicablity.AccAppli_ProdClassifi(), ProductClassification);
					}	
					if(!Description.equalsIgnoreCase("n/a"))
					{
					MethodDef.sendKeys(AccountApplicablity.AccAppli_ProdDescription(), Description);
					}			
					MethodDef.clickJS(AccountApplicablity.AccAppli_Update(), "Update Button");					
				}		
				else if (Action.equals("Remove"))
				{
					CommonDef.Wait();
					MethodDef.clickJS(AccountApplicablity.AccAppli_RemoveProduct(Product), "Remove Customer");					
				}
				MethodDef.clickJS(AccountApplicablity.AccAppli_Save(), "Save Button");
				CommonDef.assertContains(AccountApplicablity.AccAppli_SuccessMessage(), StatusMessage);				
				
			}
			catch (Exception e) {
				ExReporter.log(LogStatus.ERROR, "Error in performing Account Applicablity Function");
			}
		}
}
