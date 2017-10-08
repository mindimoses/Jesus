package mav.metro.pom.tcib.functions;
import mav.metro.driver.DriverFactory;
import mav.metro.framework.ExReporter;
import mav.metro.framework.TestData;
import mav.metro.library.functions.*;

import mav.metro.pom.tcib.elements.PageLogin;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.LogStatus;
public class PageLoginFns {
	public static void PageLogin(String customertype){
		WebDriver driver = DriverFactory.getCurrentDriver();		
		ExReporter.log(LogStatus.INFO, "PageLogin");
		try {
			if (!customertype.startsWith("Only"))
			{BasePageFns.profileChange(TestData.getConfig("ProfileName"));	
			}
			MethodDef.assertElemsContains(PageLogin.PageLogin_FSCS(), TestData.getConfig("SuccessMessage"));
			
		}
		catch (Exception e) {
			ExReporter.log(LogStatus.ERROR, "Error in Pagelogin Function");
		}
		
	}
	

}
