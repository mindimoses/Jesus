package mav.metro.library.teststeps;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.LogStatus;

import mav.metro.driver.DriverFactory;
import mav.metro.framework.*;
import mav.metro.library.functions.CommonDef;
import mav.metro.library.functions.MethodDef;
import mav.metro.pom.tcib.elements.*;
import mav.metro.pom.tcib.functions.*;


public class TCIBTestSteps {
	public TCIBTestSteps() {	
		initReport();
		logDetails();
		String user = checkUser("User");
		DriverFactory.driverInit();		
		ExReporter.log(LogStatus.INFO, "Test Machine IP: " + MethodDef.getIP());		
		LoginFns.Login(user);
	}

	/*public TCIBTestSteps(String ModuleName) {	
		initReport();
		logDetails();		
		DriverFactory.driverInit();		
		ExReporter.log(LogStatus.INFO, "Test Machine IP: " + MethodDef.getIP());		
		LoginFns.Login();
	}*/
	
	public TCIBTestSteps(String ModuleName) {
		initReport();
		logDetails();
		DriverFactory.driverInit();
		ExReporter.log(LogStatus.INFO, "Test Machine IP: " + MethodDef.getIP());
		LoginFns.Login();
	}

	public static void initReport() {
		String testName = ConfigProvider.getConfig("Testname") + "-" + TestData.getConfig("DataBinding");
		String desc = "";
		if (ProjectConfig.getPropertyValue("versionspecific").equals("true"))
			desc = ConfigProvider.getConfig("Browser") + "-" + ConfigProvider.getConfig("Version");
		else
			desc = ConfigProvider.getConfig("Browser");
		ExReporter.initTest(testName, desc);
	}

	private String checkUser(String user) {
		try {
			user = TestData.getConfig(user);
			System.out.println("tcib user " +user);
			// SyncMap.availableStat(user);
			if (!user.equalsIgnoreCase("n/a")) {
				boolean available = false;
				do {
					available = SyncMap.checkAvailableNew(user);
				} while (!available);
			} else
				return "";
			// SyncMap.availableStat(user);
			return user;
		} catch (Exception E) {
			// E.printStackTrace();lo
			return "";
		}
	}

	private void logDetails() {
		if (ConfigProvider.getConfig("Platform").equalsIgnoreCase("Browser"))
			ExReporter.log(LogStatus.INFO, "URL: " + ProjectConfig.getPropertyValue("url"));
		else
			ExReporter.log(LogStatus.INFO, "URL: " + ProjectConfig.getPropertyValue("murl"));
		ExReporter.log(LogStatus.INFO, "OS: " + ConfigProvider.getConfig("OS"));
		ExReporter.assignCatogory(ConfigProvider.getConfig("OS"));
		ExReporter.assignCatogory(ConfigProvider.getConfig("Testname"));

		if (ProjectConfig.getPropertyValue("versionspecific").equals("true")) {
			ExReporter.log(LogStatus.INFO,
					"Browser: " + ConfigProvider.getConfig("Browser") + "-" + ConfigProvider.getConfig("Version"));
			ExReporter.assignCatogory(ConfigProvider.getConfig("Browser") + "-" + ConfigProvider.getConfig("Version"));
		} else {
			ExReporter.log(LogStatus.INFO, "Browser: " + ConfigProvider.getConfig("Browser"));
			ExReporter.assignCatogory(ConfigProvider.getConfig("Browser"));
		}
	}

	public static void Frequency() throws Exception
	{
		if (TestData.getConfig("PaymentMethod").equals("Pay_Now"))
		{MethodDef.clickJS(MoveMoney.paynow_button(), "Paynow");}		
		else if (TestData.getConfig("PaymentMethod").equals("Regular_Payment"))
		{
			MethodDef.clickJS(MoveMoney.regularpayment_button(), "RegularPayment");			
			MethodDef.clickJS(MoveMoney.regular_start(),"regular Start");
			BasePageFns.FDate(TestData.getConfig("Start_Date"));
			if (!TestData.getConfig("Payment_Frequency").equals("Every month"))
			{MethodDef.select(MoveMoney.regular_frequency(), TestData.getConfig("Payment_Frequency"));}
			else
			{MethodDef.select(MoveMoney.regular_frequency(), "Daily");
			MethodDef.select(MoveMoney.regular_frequency(), TestData.getConfig("Payment_Frequency"));}
							
			MethodDef.clickJS(MoveMoney.regular_end(),"regular end");
			if (TestData.getConfig("End_Date").startsWith("until"))
			{MethodDef.clickJS(MoveMoney.regular_untilfurther(), "until further");}
			else{
			BasePageFns.FDate(TestData.getConfig("End_Date"));
			}
		}
		else
		{
		MethodDef.clickJS(MoveMoney.futuredate_button(), "future date button");
		MethodDef.click(MoveMoney.future_date(),"future date");
		BasePageFns.FDate(TestData.getConfig("Future_Date"));
		}
		
	}
	
	public static void AccountSelection() 
	{	if (TestData.getConfig("PaymentMethod").equals("Pay_Now"))		
		MethodDef.clickJS(MoveMoney.Recent_transcations(), "PayNow Transcations");		
		else if (TestData.getConfig("PaymentMethod").equals("Regular_Payment"))
		MethodDef.clickJS(MoveMoney.Regular_payment(), "PayNow Transcations");	
	}
	public static void CommonMoveMoney()throws Exception
	{
		WebDriver driver = DriverFactory.getCurrentDriver();
		Keyboard kb = ((RemoteWebDriver) driver).getKeyboard();
		MethodDef.sendKeys(MoveMoney.movemoney_amount(), TestData.getConfig("Amount"));			
		BasePageFns.selectItem(MoveMoney.movemoney_ToAccount(), TestData.getConfig("ToAc_No"));
		//kb.pressKey(Keys.TAB);
		CommonDef.Wait();
		TCIBTestSteps.Frequency();
		MethodDef.clickJS(MoveMoney.continue_button(), "Continue");
		MethodDef.clickJS(MoveMoney.makepayment_button(),"Payment Confirmed");
		if (TestData.getConfig("PaymentMethod").equals("Regular_Payment"))
		{MethodDef.assertElemsContains(MoveMoney.success_regularpayment(), TestData.getConfig("SuccessMessage"));}	
		else
		{		
		MethodDef.assertElemsContains(MoveMoney.success_message(), TestData.getConfig("SuccessMessage"));}		
		MethodDef.clickJS(MoveMoney.Account_summary(), "Account Summary Screen");
		TCIBTestSteps.AccountSelection();	
	}
	
	public static void CommonSendMoney() throws Exception
	{
		WebDriver driver = DriverFactory.getCurrentDriver();
		Keyboard kb = ((RemoteWebDriver) driver).getKeyboard();
		MethodDef.sendKeys(SendMoney.sendmoney_amount(), TestData.getConfig("Amount"));
		CommonDef.Wait();
		///kb.pressKey(Keys.TAB);
		//BasePageFns.selectItem(SendMoney.sendmoney_From(),TestData.getConfig("FromAc_No"));	
		if(TestData.getConfig("Payee_Category").equals("From Payee List"))
		{
		MethodDef.clickJS(SendMoney.SendMoney_Payeelist(0),"Payee list");
		}
		CommonDef.Wait();
		///kb.pressKey(Keys.TAB);		
		BasePageFns.selectItem(SendMoney.Sendmoney_Payee(), TestData.getConfig("Beneficiary_Number"));
		CommonDef.Wait();
		MethodDef.sendKeys(SendMoney.Sendmoney_reference(), TestData.getConfig("Reference_Name"));		
		TCIBTestSteps.Frequency();
		MethodDef.clickJS(MoveMoney.continue_button(), "Continue");
		MethodDef.clickJS(MoveMoney.makepayment_button(),"Payment Confirmed");		
		if (TestData.getConfig("PaymentMethod").equals("Regular_Payment"))
		{MethodDef.assertElemsContains(MoveMoney.success_regularpayment(), TestData.getConfig("SuccessMessage"));}	
		else
		{		
		MethodDef.assertElemsContains(SendMoney.success_message(), TestData.getConfig("SuccessMessage"));}		
	}
	//TCIB Functionality
	public void MoveMoney()
	{		
		MoveMoneyFns.movemoney(TestData.getConfig("CustomerType"));		
	}
	
	public void SendMoney()
	{
		SendMoneyFns.sendmoney(TestData.getConfig("CustomerType"));
	}
	
	public void Messages()
	{
		MessagesFns.Messages(TestData.getConfig("CustomerType"));		
	}
	public void NewAccount()
	{
		NewAccountFns.NewAccount(TestData.getConfig("CustomerType"));
	}
	
	public void QuickPay()
	{
		QuickPayFns.QuickPay(TestData.getConfig("CustomerType"));	
	}
	
	public void PayeeManagement()
	{
		PayeeManagementFns.PayeeManagement(TestData.getConfig("CustomerType"));	
	}
	public void PaymentAcDetails()
	{
		PaymentAcDetailsFns.PaymentAcDetails(TestData.getConfig("CustomerType"));	
	}
	public void AccountSummary()
	{
		AccountSummaryFns.AccountSummary(TestData.getConfig("CustomerType"));	
	}
	
	public void ViewAcDetails()
	{
		ViewAcDetailsFns.ViewAcDetails(TestData.getConfig("CustomerType"));	
	}
	
	public void Preferences()
	{
		PreferencesFns.Preferences(TestData.getConfig("CustomerType"));	
	}
	public void PageLogin()
	{
		PageLoginFns.PageLogin(TestData.getConfig("CustomerType"));	
	}
	public void Help()
	{
		HelpFns.Help(TestData.getConfig("CustomerType"));	
	}
	public void Statements()
	{
		StatementsFns.Statements(TestData.getConfig("CustomerType"));	
	}
	
	//Edge Admin Console
	public void Interstitial()
	{
		InterstitialFns.Interstitial();	
	}
	public void TermsandCond()
	{
		TermsandCondFns.TermsandCond();	
	}
	public void AccountApplicablity()
	{
		AccountApplicablityFns.AccountApplicablity();	
	}
	public void RetailContent()
	{
		RetailContentFns.RetailContent();	
	}
	
}
