package mav.metro.driver;

import mav.metro.framework.ConfigProvider;
import org.openqa.selenium.WebDriver;

public class DriverFactory {
	private static ThreadLocal<WebDriver> currentDriver = new ThreadLocal<WebDriver>();

	public static WebDriver getCurrentDriver() {
		WebDriver driver = currentDriver.get();
		if (driver != null) {
			return driver;
		} else {
			return null;
		}
	}

	public static void driverInit() {
		String browser = ConfigProvider.getConfig("Browser").toUpperCase();
		switch (browser) {

		case "APPIUM":
			if (ConfigProvider.getConfig("OS").toUpperCase().equals("ANDROID"))
				currentDriver.set(new AppiumMobBrowAndroid().getNewDriver());
			else if (ConfigProvider.getConfig("OS").toUpperCase().equals("IOS"))
				currentDriver.set(new AppiumMobBrowIOS().getNewDriver());
			break;

		case "FIREFOX":
			//System.out.println("inside firefox");
			currentDriver.set(new DesktopDriver().getNewDriver());
			break;
		case "CHROME":
			currentDriver.set(new DesktopDriver().getNewDriver());
			break;
		case "IE":
			//System.out.println("inside ie");
			currentDriver.set(new DesktopDriver().getNewDriver());
			break;
		case "SAFARI":
			currentDriver.set(new DesktopDriver().getNewDriver());
			break;
		default:
			System.out.println("Unknown Driver");
		}
	}

	public static void closeDriver() {
		WebDriver driver = currentDriver.get();
		if (driver != null) {
			getCurrentDriver().close();
			getCurrentDriver().quit();
		}
		currentDriver.remove();
	}
}