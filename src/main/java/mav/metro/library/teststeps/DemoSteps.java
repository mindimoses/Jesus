package mav.metro.library.teststeps;

import com.relevantcodes.extentreports.LogStatus;
import mav.metro.driver.DriverFactory;
import mav.metro.framework.ConfigProvider;
import mav.metro.framework.ExReporter;
import mav.metro.framework.ProjectConfig;
import mav.metro.pom.functions.LoginDemoFns;

public class DemoSteps {
	
	public DemoSteps(){
		TCIBTestSteps.initReport();		
		//System.out.println("Driver about to be initiated");
		DriverFactory.driverInit();
		ExReporter.log(LogStatus.INFO, "OS: " + ConfigProvider.getConfig("OS"));
		ExReporter.assignCatogory(ConfigProvider.getConfig("OS"));

		if (ProjectConfig.getPropertyValue("versionspecific").equals("true")) {
			ExReporter.log(LogStatus.INFO,
					"Browser: " + ConfigProvider.getConfig("Browser") + "-" + ConfigProvider.getConfig("Version"));
			ExReporter.assignCatogory(ConfigProvider.getConfig("Browser") + "-" + ConfigProvider.getConfig("Version"));
		} else {
			ExReporter.log(LogStatus.INFO, "Browser: " + ConfigProvider.getConfig("Browser"));
			ExReporter.assignCatogory(ConfigProvider.getConfig("Browser"));
		}
	}
	
	public void loginDemo(){
		LoginDemoFns.loginmain();
	}
}
