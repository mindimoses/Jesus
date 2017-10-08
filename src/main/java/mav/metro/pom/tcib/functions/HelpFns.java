package mav.metro.pom.tcib.functions;
import mav.metro.driver.DriverFactory;
import mav.metro.framework.ExReporter;
import mav.metro.framework.TestData;
import mav.metro.library.functions.*;
import mav.metro.pom.tcib.elements.Help;


import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.LogStatus;

public class HelpFns {
	public static void Help(String customertype){
		WebDriver driver = DriverFactory.getCurrentDriver();		
		ExReporter.log(LogStatus.INFO, "Help");
		try {
			if (!customertype.startsWith("Only"))
			{BasePageFns.profileChange(TestData.getConfig("ProfileName"));	
			}
			MethodDef.click(Help.Help_Link(), "Help Menu");
			MethodDef.click(Help.Help_OurStores(), "Our Stores");
			MethodDef.assertElemsContains(Help.Help_ContentOurStores(), TestData.getConfig("Our Stores"));
			MethodDef.click(Help.Help_BacktoHome(), "Back to Home");
			MethodDef.assertElemsContains(Help.Help_LinkNominated(), TestData.getConfig("Nominated Beneficiary"));
			MethodDef.click(Help.Help_NominatedBeneficiary(), "Nominated Beneficiary");
			MethodDef.assertElemsContains(Help.Help_ContentNominated(), TestData.getConfig("Nominated Beneficiary"));
			MethodDef.assertElemsContains(Help.Help_ContentTopicsNomin(), TestData.getConfig("Topics Nominated Beneficiary"));
			//MethodDef.click(Help.Help_NominatedWhat(), "What Nominated Beneficiary");			
			//MethodDef.assertElemsContains(Help.Help_ManagePayees(), TestData.getConfig("Manage Payees"));
			
		}
		catch (Exception e) {
			ExReporter.log(LogStatus.ERROR, "Error in Help Function");
		}
		
	}

}
