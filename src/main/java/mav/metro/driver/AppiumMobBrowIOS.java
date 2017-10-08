package mav.metro.driver;

import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import mav.metro.framework.ExReporter;
import mav.metro.framework.ProjectConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumMobBrowIOS implements NewDriver {

	IOSDriver<WebElement> remoteDriver = null;

	@Override
	public WebDriver getNewDriver() {
		try {
			remoteDriver = getAppiumDriver();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return remoteDriver;
	}

	@SuppressWarnings("null")
	private IOSDriver<WebElement> getAppiumDriver() throws MalformedURLException {

		String appHost = ProjectConfig.getPropertyValue("andappiumgrid");
		// String appPort = ProjectConfig.getPropertyValue("andappiumport");
		DesiredCapabilities desiredCap = new DesiredCapabilities();

		System.out.println("MOBILE iOS");
		try {
			desiredCap.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
			desiredCap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
			desiredCap.setCapability(MobileCapabilityType.BROWSER_NAME, "safari");
			desiredCap.setCapability(MobileCapabilityType.UDID, ProjectConfig.getPropertyValue("iOSAppdevice"));
			desiredCap.setCapability(MobileCapabilityType.DEVICE_NAME, ProjectConfig.getPropertyValue("iOSAppdevice"));
			remoteDriver = new IOSDriver<WebElement>(new URL("http://" + appHost + ":" + "4444" + "/wd/hub"),
					desiredCap);

		} catch (Exception e) {
			ExReporter.log(LogStatus.FATAL, "ERROR LAUNCHING DRIVER: " + e.getMessage());
		}

		return remoteDriver;
	}

}
