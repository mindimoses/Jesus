package mav.metro.driver;

import com.relevantcodes.extentreports.LogStatus;

import mav.metro.framework.ConfigProvider;
import mav.metro.framework.ExReporter;
import mav.metro.framework.ProjectConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;






import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DesktopDriver implements NewDriver {

	WebDriver remoteDriver = null;

	@Override
	public WebDriver getNewDriver() {
		remoteDriver = getRemoteDriver();
		return remoteDriver;
	}

	public WebDriver getRemoteDriver() {
		//int trycount = 0;

		String SelHost = ProjectConfig.getPropertyValue("SelHost");
		DesiredCapabilities desiredCap = null;
		ProfilesIni prof = new ProfilesIni();
		String version = ConfigProvider.getConfig("Version");
		String versionspec = ProjectConfig.getPropertyValue("versionspecific");

		try {
			switch (ConfigProvider.getConfig("Browser").toUpperCase()) {
			case "FIREFOX":				
				desiredCap = DesiredCapabilities.firefox();	
				desiredCap.setCapability("marionette", true);
				desiredCap.setCapability("proxyType", "noproxy");
				desiredCap.setCapability("acceptInsecureCerts", true);
				
				FirefoxProfile ffProfile= prof.getProfile ("myProfile");
				//ffProfile.setAcceptUntrustedCertificates(true);
				ffProfile.setAssumeUntrustedCertificateIssuer(true);
				desiredCap.setCapability(SelHost, ffProfile);
								//desiredCap.setCapability(FireFoxDriver.Protected, true);
				if (versionspec.equals("true"))
					desiredCap.setVersion(version);
				break;
			case "CHROME":
				desiredCap = DesiredCapabilities.chrome();
				
				desiredCap.setBrowserName("chrome");
				if (versionspec.equals("true"))
					desiredCap.setVersion(version);
				break;
			case "IE":				
				desiredCap = DesiredCapabilities.internetExplorer();
				desiredCap.setBrowserName("internet explorer");				
				desiredCap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				//desiredCap.setCapability(InternetExplorerDriver.Protected, true);
				//ignoreProtectedModeSettings": true
				desiredCap.setCapability("ignoreZoomSetting", true);				
				desiredCap.setCapability(InternetExplorerDriver.BROWSER_ATTACH_TIMEOUT, 30000);
				desiredCap.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
				desiredCap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
				desiredCap.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
				desiredCap.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
				//System.out.println("desired caps");
				if (versionspec.equals("true"))
					desiredCap.setVersion(version);
				break;
			case "SAFARI":
				desiredCap = DesiredCapabilities.safari();
				desiredCap.setBrowserName("safari");
				desiredCap.setCapability("webdriver.safari.noinstall", "true");
				break;
			default:
				desiredCap = DesiredCapabilities.firefox();
				break;
			}
			remoteDriver = new RemoteWebDriver(new URL(SelHost), desiredCap);
			remoteDriver.manage().window().maximize();
			ExReporter.log(LogStatus.INFO, "Browser Initiated successfully");

			remoteDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		} catch (Exception e) {
			try {
				Thread.sleep(2000);
				remoteDriver = new RemoteWebDriver(new URL(SelHost), desiredCap);
				remoteDriver.manage().window().maximize();
				remoteDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			} catch (Exception e1) {
				ExReporter.log(LogStatus.FATAL, "Browser Initiation Failed :" + e1.getMessage());
			}
		}
		return remoteDriver;
	}
}