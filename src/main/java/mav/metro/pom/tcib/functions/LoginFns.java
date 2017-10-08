package mav.metro.pom.tcib.functions;
import com.relevantcodes.extentreports.LogStatus;

import mav.metro.driver.DriverFactory;
import mav.metro.framework.*;
import mav.metro.library.functions.*;
import mav.metro.pom.tcib.elements.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginFns extends BasePageFns {

	public static void Login(String usertype) {
		try {
			loginCommon(usertype);			
			MethodDef.loadWaitIE();
			CommonDef.waitForPageLoad();		
		} catch (Exception E) {
			ExReporter.log(LogStatus.ERROR, "ERROR Logging in as :" + E.getMessage());
		}
	}

	
	public static void Login() {
		try {
			loginCommon();			
			MethodDef.loadWaitIE();
			CommonDef.waitForPageLoad();			
		} catch (Exception E) {
			ExReporter.log(LogStatus.ERROR, "ERROR Logging in as :" + E.getMessage());
		}
	}
	public static void loginCommon(String usertype) {
		try {
			/*String LoginFunction = null;
			String aurl = ProjectConfig.getPropertyValue(LoginFunction);
			if(aurl.equals("Admin"))
			{
			launchEdgeURL();
			}
			else {*/
			String ibid = ProjectConfig.getPropertyValue(usertype).split("~")[0];
			String pass = ProjectConfig.getPropertyValue(usertype).split("~")[1];
			String key = ProjectConfig.getPropertyValue(usertype).split("~")[2];			
			ExReporter.log(LogStatus.INFO, "IB ID :" + ibid);			
			launchURL();	
			MethodDef.click(Login.login_Cookie(), "Cookies Button");
			MethodDef.sendKeys(Login.login_userid(), ibid);
			MethodDef.click(Login.login_continue(), "Continue Button");
			MethodDef.sendKeys(Login.login_password(), pass);			
			CommonDef.waitVisible(Login.login_securityno(), "security number");		
			
			List<WebElement> SecNums = CommonDef.findElements(Login.login_securityno());
			for (WebElement temp : SecNums) {			
			MethodDef.select(temp, key);				
			}
			MethodDef.clickJS(Login.login_login(),"Login button");			
			MethodDef.loadWaitIE();
			CommonDef.waitForPageLoad();
			//Interstital 
			/*MethodDef.clickJS(Login.login_continue(),"continue button");
			MethodDef.clickJS(Login.finish_button(),"finish button");*/
			MethodDef.clickJS(Login.login_viewmyaccounts(),"viewmyaccounts button");
			CommonDef.waitForPageLoad();			
			MethodDef.loadWaitIE();
			//}
		} catch (Exception E) {
			ExReporter.log(LogStatus.ERROR, "Login Failed" + E.getMessage());
		}

	}
	
	
	public static void loginCommon() {
		try {
			String userid = ProjectConfig.getPropertyValue("AdminLogin").split("~")[0];
			String pass = ProjectConfig.getPropertyValue("AdminLogin").split("~")[1];
			launchAdminURL();	
			MethodDef.click(EdgeLogin.EdgeLogin_login(), "Login Button");
			MethodDef.sendKeys(EdgeLogin.EdgeLogin_userid(), userid);
			MethodDef.sendKeys(EdgeLogin.EdgeLogin_password(), pass);
			MethodDef.click(EdgeLogin.EdgeLogin_login(), "Login Button");				
			MethodDef.loadWaitIE();
			CommonDef.waitForPageLoad();
			MethodDef.click(EdgeLogin.EdgeLogin_AdminLink(), "Admin Link");
			CommonDef.waitForPageLoad();
		} catch (Exception E) {
			ExReporter.log(LogStatus.ERROR, "Admin Login Failed" + E.getMessage());
		}

	}

	public static void launchURL() {
		try {
			String url = "";
			if (ConfigProvider.getConfig("Platform").equalsIgnoreCase("mBrowser"))
				url = ProjectConfig.getPropertyValue("murl");
			else if (ConfigProvider.getConfig("Platform").equalsIgnoreCase("Browser"))				
				url = ProjectConfig.getPropertyValue("url");
				System.out.println(url);
			WebDriver driver = DriverFactory.getCurrentDriver();
			int loadtrycount = 0;
			do {
				try {
					ExReporter.log(LogStatus.INFO, "Launching URL: " + url);					
					driver.get(url);
					CommonDef.waitForPageLoad();
					ExReporter.log(LogStatus.INFO, "PAGE TITLE: " + driver.getTitle());
				} catch (Exception e) {
					ExReporter.log(LogStatus.ERROR, "Unable to Launch URL: " + url + " Error: " + e.getMessage());
				}
				loadtrycount++;
			} while ((driver.getTitle().contains("error") || driver.getTitle().contains("Error")
					|| driver.getTitle().contains("problem") || driver.getTitle().contains("Problem")
					|| driver.getTitle().contains("cannot") || driver.getTitle().contains("Cannot"))
					&& loadtrycount < 2);
		} catch (Exception EE) {
			ExReporter.log(LogStatus.ERROR, "Error Launching URL: " + EE.getMessage());
		}
	}
	public static void launchAdminURL() {
		try {
			String url = "";							
				url = ProjectConfig.getPropertyValue("adminurl");
				System.out.println(url);
			WebDriver driver = DriverFactory.getCurrentDriver();
			int loadtrycount = 0;
			do {
				try {
					ExReporter.log(LogStatus.INFO, "Launching URL: " + url);					
					driver.get(url);
					CommonDef.waitForPageLoad();
					ExReporter.log(LogStatus.INFO, "PAGE TITLE: " + driver.getTitle());
				} catch (Exception e) {
					ExReporter.log(LogStatus.ERROR, "Unable to Launch URL: " + url + " Error: " + e.getMessage());
				}
				loadtrycount++;
			} while ((driver.getTitle().contains("error") || driver.getTitle().contains("Error")
					|| driver.getTitle().contains("problem") || driver.getTitle().contains("Problem")
					|| driver.getTitle().contains("cannot") || driver.getTitle().contains("Cannot"))
					&& loadtrycount < 2);
		} catch (Exception EE) {
			ExReporter.log(LogStatus.ERROR, "Error Launching URL: " + EE.getMessage());
		}
	}
	

	public static void Logout() {
		try {
			//openItemLogoutMenu();			
			MethodDef.clickJS(Login.logout_button(), "Logout");
			CommonDef.waitForPageLoad();
			CommonDef.Wait();
			MethodDef.clickJS(Login.logoutPopup_button(), "confirm logout");
			CommonDef.waitForPageLoad();
			CommonDef.waitClickable(Login.login_userid(), "Login Page - IBID Field");
		} catch (Exception e) {
			ExReporter.log(LogStatus.ERROR, "ERROR logging out");
		}
	}

	public static void AdminLogout() {
		try {	
			MethodDef.clickJS(EdgeLogin.EdgeLogin_logout(), "Logout button");
			CommonDef.waitForPageLoad();			
			CommonDef.waitClickable(EdgeLogin.EdgeLogin_userid(), "Login Page - IBID Field");
		} catch (Exception e) {
			ExReporter.log(LogStatus.ERROR, "ERROR logging out");
		}
	}
	
	/*private static void loadCheck() {
		MethodDef.loadWaitIE();
		CommonDef.waitForPageLoad();
		MethodDef.assertContains(Login.assertion(), "Accounts Summary");
		CommonDef.waitVisibleNoError(BasePage.accSummLoad());
		CommonDef.waitForPageLoad();
	}*/
}
