package mav.metro.pom.tcib.functions;

import mav.metro.framework.ExReporter;
import mav.metro.framework.TestData;
import mav.metro.library.functions.CommonDef;
import mav.metro.library.functions.MethodDef;
import mav.metro.pom.tcib.elements.*;

import com.relevantcodes.extentreports.LogStatus;

public class AccountSummaryFns {	
	//AccountSummary Functions Functionality 
	public static void AccountSummary(String customertype){
	ExReporter.log(LogStatus.INFO, "Account Summary Details");
	try {
		if (!customertype.startsWith("Only"))
		{
		BasePageFns.profileChange(TestData.getConfig("ProfileName"));	
		}		
			MethodDef.clickJS(AccountSummary.AccountSummary_EditLink(), "Edit Link");
			if (!TestData.getConfig("AccountName").equals("n/a")){
				MethodDef.sendKeys(AccountSummary.AccountSummary_EditContent(), TestData.getConfig("AccountName"));;}
			MethodDef.clickJS(AccountSummary.AccountSummary_Save(), "Save Link");
			if (!TestData.getConfig("Message").equals("n/a")){
			MethodDef.assertElemsContains(AccountSummary.AccountSummary_ErrorMessage(), TestData.getConfig("Message"));
			}
			else{
			ExReporter.log(LogStatus.PASS, "Edit Account Nick name");}
	}
	catch (Exception e) {
		ExReporter.log(LogStatus.ERROR, "Error in performing Account Summary Functions");
	}
}

}