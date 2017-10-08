package mav.metro.pom.functions;

import com.relevantcodes.extentreports.LogStatus;
import mav.metro.driver.DriverFactory;
import mav.metro.framework.ExReporter;
import mav.metro.framework.TestData;
import mav.metro.library.functions.CommonDef;
import mav.metro.library.functions.MethodDef;
import mav.metro.pom.elements.LandingPage;
import mav.metro.pom.elements.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPageFns {

	public static void landingPageValidation() {
		try {
			//CommonDef.isDisplayed(Login.loginValidation(), "Login Page is available");
		} catch (Exception e) {
			ExReporter.log(LogStatus.ERROR, "Page Load Error :" + e.getMessage());
		}
	}

	public static void LandingPage() {
		try {
			String link = TestData.getConfig("Link");
			String page = TestData.getConfig("windowVerify");
			if (TestData.getConfig("Link").equalsIgnoreCase("Home"))
				validatePageNav(LandingPage.Link_Home(), link, page);
			else if (TestData.getConfig("Link").equalsIgnoreCase("StoreLocator"))
				validatePageNav(LandingPage.Link_StoreLocator(), link, page);
			else if (TestData.getConfig("Link").equalsIgnoreCase("NewCustomer"))
				validatePageNav(LandingPage.Link_NewCustomer(), link, page);
			else if (TestData.getConfig("Link").equalsIgnoreCase("PersonalInternetBanking")) {
				navMenuValidation();
				validatePageNav(LandingPage.Link_PersonalInternetBanking(), link, page);
			} else if (TestData.getConfig("Link").equalsIgnoreCase("LegalInformation"))
				validatePageNav(LandingPage.Link_LegalInformation(), link, page);
			else if (TestData.getConfig("Link").equalsIgnoreCase("SecurityAndPrivacy"))
				validatePageNav(LandingPage.Link_SecurityAndPrivacy(), link, page);
			else if (TestData.getConfig("Link").equalsIgnoreCase("HelpInfo"))
				validatePageNav(LandingPage.Link_helpAndInfo(), link, page);
			else if (TestData.getConfig("Link").equalsIgnoreCase("ContactUs"))
				validatePageNav(LandingPage.Link_contactUs(), link, page);
		} catch (Exception E) {
			ExReporter.log(LogStatus.FAIL, "Landing Page Validation Error : " + E.getMessage());
		}
	}
	
	public static void navMenuValidation() {
		BasePageFns.toggleTopNavMenu();
		CommonDef.isDisplayed(LandingPage.LoginNavDesktop(), "Backbase Home Page Loaded");
		BasePageFns.toggleTopNavMenu();
	}

	public static void validatePageNav(By link_click, String link, String page) {
		MethodDef.clickJS(link_click, "Test Data Link URL Clicked Successfully");
		urlContains(link, page);
	}

	public static void urlContains(String link, String page) {
		CommonDef.switch_Window();
		WebDriver driver = DriverFactory.getCurrentDriver();
		CommonDef.waitForPageLoad();
		String curURL = driver.getCurrentUrl();
		CommonDef.brokenLinkValidation(curURL);
		ExReporter.log(LogStatus.INFO, "curURL " + curURL);
		/*
		 * ExReporter.log(LogStatus.INFO, "page " + page); if
		 * (curURL.contains(page)) { ExReporter.log(LogStatus.PASS,
		 * "Navigated to New Window successfully: " + page); } else {
		 * ExReporter.log(LogStatus.FAIL, "Unable to Navigate New Window : " +
		 * page); }
		 */
	}
}
