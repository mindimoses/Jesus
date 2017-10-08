package mav.metro.pom.tcib.functions;

import mav.metro.driver.DriverFactory;
import mav.metro.framework.ExReporter;
import mav.metro.framework.TestData;
import mav.metro.library.functions.CommonDef;
import mav.metro.library.functions.MethodDef;
import mav.metro.pom.tcib.elements.PageLogin;
import mav.metro.pom.tcib.elements.Statements;






import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.LogStatus;

public class StatementsFns {
	public static void Statements (String customertype)
	{
		WebDriver driver = DriverFactory.getCurrentDriver();	
		Keyboard kb = ((RemoteWebDriver) driver).getKeyboard();	
		ExReporter.log(LogStatus.INFO, "Statements");
		try{
			if (!customertype.startsWith("Only"))
			{
			BasePageFns.profileChange(TestData.getConfig("ProfileName"));	
			}
			MethodDef.clickJS(Statements.Statements_Menu(), "Statements Menu");
			if (TestData.getConfig("Select_Action").equals("n/a"))
			{			
			MethodDef.clickJS(Statements.Statements_TabLetters(),"Letters tab");
			CommonDef.Wait();
			BasePageFns.selectItem(Statements.Statements_ShowLetters(),TestData.getConfig("FromAc_No"));
			CommonDef.Wait();
			BasePageFns.selectItem(Statements.Statements_PaymentType(),TestData.getConfig("PaymentType"));
			MethodDef.clickJS(Statements.Statements_Retrieve(),"Retrieve Button");
			}
			else
			{
				CommonDef.Wait();
				//MethodDef.assertElemsContains(Statements.Certificates_InterestTab(), TestData.getConfig("TabContent"));
				MethodDef.assertElemsContains(Statements.Certificates_StatementsHeader(), TestData.getConfig("Header1"));				
				MethodDef.clickJS(Statements.Certificates_Tab(),"Certificates tab");
				CommonDef.Wait();
				//MethodDef.assertElemsContains(Statements.Certificates_InterestHeader(), TestData.getConfig("Header"));
				//CommonDef.Wait();
				MethodDef.assertElemsContains(Statements.Certificates_Contents(), TestData.getConfig("Message"));
				//MethodDef.assertElemsContains(Statements.Certificates_ErrorMessage(), TestData.getConfig("ErrorMessage"));				
			}
		}
			catch (Exception e) {
				ExReporter.log(LogStatus.ERROR, "Error in performing Statements Function");
			}
		}	
		
}
