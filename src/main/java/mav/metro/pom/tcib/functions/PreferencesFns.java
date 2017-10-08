package mav.metro.pom.tcib.functions;

import mav.metro.framework.ExReporter;
import mav.metro.framework.TestData;
import mav.metro.library.functions.MethodDef;
import mav.metro.pom.tcib.elements.*;

import com.relevantcodes.extentreports.LogStatus;

public class PreferencesFns {
	//Preferences Functionality 
	public static void Preferences(String customertype){
	ExReporter.log(LogStatus.INFO, "Preferences Functionality");
	try {
		if (!customertype.startsWith("Only"))
		{
		BasePageFns.profileChange(TestData.getConfig("ProfileName"));	
		}
		MethodDef.clickJS(Preferences.Preferences_DetailsMenu(), "Details and Preferences Menu");
		MethodDef.clickJS(Preferences.Preferences_ChangeDetailsMenu(), "Change Details Menu");		
		if (TestData.getConfig("Select_Action").equals("PersonalDetails"))
		{
		MethodDef.clickJS(Preferences.Preferences_UserChangeOnline(), "User Change Online");
		MethodDef.sendKeys(Preferences.Preferences_EditUserName(),TestData.getConfig("Edit Name"));
		MethodDef.click(Preferences.Preferences_UserSave(), "Preference Save");
		MethodDef.assertElemsContains(Preferences.Preferences_UserSuccessMessage(), TestData.getConfig("SuccessMessage"));
		}
		else if (TestData.getConfig("Select_Action").equals("AcPreferences"))
		{
			MethodDef.clickJS(Preferences.Preferences_TabPreferences(), "Accounts Preferences Tab");
			String[] alert = TestData.getConfig("AcPreference").split("_");	
			MethodDef.clickJS(Preferences.Preferences_UserStatements(Integer.parseInt(alert[0]),Integer.parseInt(alert[1])), "Statements Column");			
			MethodDef.click(Preferences.Preferences_StatementsSave(), "Save button");
			MethodDef.assertElemsContains(Preferences.Preferences_StatementsSuccess(), TestData.getConfig("SuccessMessage"));
		}
		else if (TestData.getConfig("Select_Action").equals("AcAlerts"))
		{
			MethodDef.clickJS(Preferences.Preferences_TabAlerts(), "Alerts Preferences Tab");
			String[] alert = TestData.getConfig("AlertPreference").split("_");	
			MethodDef.clickJS(Preferences.Preferences_UserAlerts(Integer.parseInt(alert[0]),Integer.parseInt(alert[1])), "Alerts Column");
			MethodDef.sendKeys(Preferences.Preferences_UserThreshold(Integer.parseInt(alert[2])), TestData.getConfig("Threshold"));			
			MethodDef.click(Preferences.Preferences_AlertsSave(), "Alert Save button");
			MethodDef.assertElemsContains(Preferences.Preferences_AlertsSuccess(), TestData.getConfig("SuccessMessage"));
		}
		else if (TestData.getConfig("Select_Action").equals("XeroFeed"))
		{
			String[] alert = TestData.getConfig("XeroPreference").split("_");
			MethodDef.clickJS(Preferences.Preferences_TabXero(), "Xero Preferences Tab");
			if (TestData.getConfig("SubAction").equals("Create"))
			{
			MethodDef.clickJS(Preferences.Preferences_CreateXeroContinue(), "Create Xero Continue");				
			MethodDef.clickJS(Preferences.Preferences_XeroSelect(Integer.parseInt(alert[0]),Integer.parseInt(alert[1])), "Xero Select");
			MethodDef.clickJS(Preferences.Preferences_XeroIAgree(), "I Agree ");
			MethodDef.click(Preferences.Preferences_XeroContinue(), "Agree Continue");
			MethodDef.sendKeys(Preferences.Preferences_CreateXeroName(),TestData.getConfig("Xero Name"));
			MethodDef.sendKeys(Preferences.Preferences_CreateXeroEmail(),TestData.getConfig("Xero Email"));
			MethodDef.click(Preferences.Preferences_XeroCreeateContinue(), "Create Continue");			
			}
			else if (TestData.getConfig("SubAction").equals("Edit"))
			{
				MethodDef.clickJS(Preferences.Preferences_XeroSelect(Integer.parseInt(alert[0]),Integer.parseInt(alert[1])), "Xero Select");
				MethodDef.clickJS(Preferences.Preferences_XeroClick(), "Edit Link");
				if (!TestData.getConfig("Xero Name").equals("n/a"))
					MethodDef.sendKeys(Preferences.Preferences_XeroName(),TestData.getConfig("Xero Name"));
				if (!TestData.getConfig("Xero Email").equals("n/a"))
					MethodDef.sendKeys(Preferences.Preferences_XeroEmail(),TestData.getConfig("Xero Email"));
				MethodDef.click(Preferences.Preferences_XeroEdit(), "Edit Details");
				MethodDef.assertElemsContains(Preferences.Preferences_XeroEditSuccess(), TestData.getConfig("XeroMessage"));
				MethodDef.click(Preferences.Preferences_XeroClose(), "Close Button");
				MethodDef.clickJS(Preferences.Preferences_XeroIAgree(), "I Agree ");
				MethodDef.click(Preferences.Preferences_XeroContinue(), "Agree Continue");
			}
				MethodDef.click(Preferences.Preferences_XeroSave(), "Save button");
				MethodDef.assertElemsContains(Preferences.Preferences_XeroSuccess(), TestData.getConfig("SuccessMessage"));
				MethodDef.click(Preferences.Preferences_XeroAccountSummary(), "Account Summary");
		}
	}
	catch (Exception e) {
		ExReporter.log(LogStatus.ERROR, "Error in performing Preferences details Function");
	}
}

}
