package mav.metro.alltestpack;

import com.galenframework.reports.GalenTestInfo;

import mav.metro.framework.utilities.GalenLayout;
import mav.metro.library.teststeps.TCIBTestSteps;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class TCIBTests extends TestNGMethods {

	@Test(description = "MoveMoney - Test", dataProvider = "TestDataParallel")
	public static void MoveMoney(Map<String, String> brow,
			Map<String, String> data, ITestContext ctx) {
		TCIBTestSteps steps = new TCIBTestSteps();
		steps.MoveMoney();
	}

	@Test(description = "SendMoney - Test", dataProvider = "TestDataParallel")
	public static void SendMoney(Map<String, String> brow,
			Map<String, String> data, ITestContext ctx) {
		TCIBTestSteps steps = new TCIBTestSteps();
		steps.SendMoney();
	}

	@Test(description = "Messages - Test", dataProvider = "TestDataParallel")
	public static void Messages(Map<String, String> brow,
			Map<String, String> data, ITestContext ctx) {
		TCIBTestSteps steps = new TCIBTestSteps();
		steps.Messages();
	}
	@Test(description = "NewAccount - Test", dataProvider = "TestDataParallel")
	public static void NewAccount(Map<String, String> brow,
			Map<String, String> data, ITestContext ctx) {
		TCIBTestSteps steps = new TCIBTestSteps();
		steps.NewAccount();
	}
	@Test(description = "QuickPay- Test", dataProvider = "TestDataParallel")
	public static void QuickPay(Map<String, String> brow,
			Map<String, String> data, ITestContext ctx) {
		TCIBTestSteps steps = new TCIBTestSteps();
		steps.QuickPay();
	}

	@Test(description = "PayeeManagement - Test", dataProvider = "TestDataParallel")
	public static void PayeeManagement(Map<String, String> brow,
			Map<String, String> data, ITestContext ctx) {
		TCIBTestSteps steps = new TCIBTestSteps();
		steps.PayeeManagement();
	}
	@Test(description = "PaymentAcDetails - Test", dataProvider = "TestDataParallel")
	public static void PaymentAcDetails(Map<String, String> brow,
			Map<String, String> data, ITestContext ctx) {
		TCIBTestSteps steps = new TCIBTestSteps();
		steps.PaymentAcDetails();
	}
	@Test(description = "ViewAcDetails - Test", dataProvider = "TestDataParallel")
	public static void ViewAcDetails(Map<String, String> brow,
			Map<String, String> data, ITestContext ctx) {
		TCIBTestSteps steps = new TCIBTestSteps();
		steps.ViewAcDetails();
	}

	@Test(description = "AccountSummary - Test", dataProvider = "TestDataParallel")
	public static void AccountSummary(Map<String, String> brow,
			Map<String, String> data, ITestContext ctx) {
		TCIBTestSteps steps = new TCIBTestSteps();
		steps.AccountSummary();
	}
	
	@Test(description = "Preferences - Test", dataProvider = "TestDataParallel")
	public static void Preferences(Map<String, String> brow,
			Map<String, String> data, ITestContext ctx) {
		TCIBTestSteps steps = new TCIBTestSteps();
		steps.Preferences();
	}
	
	@Test(description = "PageLogin - Test", dataProvider = "TestDataParallel")
	public static void PageLogin(Map<String, String> brow,
			Map<String, String> data, ITestContext ctx) {
		TCIBTestSteps steps = new TCIBTestSteps();
		steps.PageLogin();

	}
	@Test(description = "Statements - Test", dataProvider = "TestDataParallel")
	public static void Statements(Map<String, String> brow,
			Map<String, String> data, ITestContext ctx) {
		TCIBTestSteps steps = new TCIBTestSteps();
		steps.Statements();

	}
	@Test(description = "Help - Test", dataProvider = "TestDataParallel")
	public static void Help(Map<String, String> brow,
			Map<String, String> data, ITestContext ctx) {
		TCIBTestSteps steps = new TCIBTestSteps();
		steps.Help();
	}
	@Test(description = "Interstitial - Test", dataProvider = "TestDataParallel")
	public static void Interstitial(Map<String, String> brow,
			Map<String, String> data, ITestContext ctx) {
		TCIBTestSteps steps = new TCIBTestSteps("Interstitial");		
		steps.Interstitial();
	}
	@Test(description = "TermsandCond - Test", dataProvider = "TestDataParallel")
	public static void TermsandCond(Map<String, String> brow,
			Map<String, String> data, ITestContext ctx) {
		TCIBTestSteps steps = new TCIBTestSteps("TermsandCond");		
		steps.TermsandCond();
	}
	@Test(description = "AccountApplicablity - Test", dataProvider = "TestDataParallel")
	public static void AccountApplicablity(Map<String, String> brow,
			Map<String, String> data, ITestContext ctx) {
		TCIBTestSteps steps = new TCIBTestSteps("AccountApplicablity");		
		steps.AccountApplicablity();
	}
	@Test(description = "RetailContent - Test", dataProvider = "TestDataParallel")
	public static void RetailContent(Map<String, String> brow,
			Map<String, String> data, ITestContext ctx) {
		TCIBTestSteps steps = new TCIBTestSteps("RetailContent");		
		steps.RetailContent();
	}
}