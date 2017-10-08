package mav.metro.alltestpack;

import mav.metro.driver.DriverFactory;
import mav.metro.framework.*;
import mav.metro.library.functions.MethodDef;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.junit.Assert;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestNGMethods {
	public ExReporter classReport;
	public final static Logger logger = Logger.getLogger(System.getProperty("ResSuite"));
	
	@BeforeSuite(alwaysRun = true)
	public static void beforeSuite(ITestContext ctx) {
		String suiteName = ctx.getCurrentXmlTest().getSuite().getName();	
		logger.info("TEST PACK EXECUTION STARTED for TESTNG Suite... :" + suiteName);		
		ExReporter.initReport(suiteName);		
		if (System.getProperty("ResSuite").contains("TCIBTestPack")) {			
			Map<String, String> t = new HashMap<String, String>();
			SyncMap.init(t);
			addUnivUsers(ProjectConfig.getPropertyValue("users"));			
		}
	}

	private static void addUnivUsers(String userlist) {
		try {
			for (String userstring : userlist.split(","))
				SyncMap.setAvailable(userstring);
		} catch (Exception E) {
			Assert.fail("Error setting the users for the test run: Quitting jobs");
		}
	}

	@AfterSuite(alwaysRun = true)
	public static void afterSuite(ITestContext ctx) {
		String suiteName = ctx.getCurrentXmlTest().getSuite().getName();
		logger.info("TEST PACK EXECUTION ENDED for TESTNG Suite... :" + suiteName);
		ExReporter.endReport(suiteName);
		testEmail(suiteName);
	}

	private static void testEmail(String suiteName) {
		try {

			HtmlEmail email = new HtmlEmail();
			EmailAttachment attachment = new EmailAttachment();
			email.setHostName("smtp.office365.com");
			email.setSmtpPort(587);
			email.setAuthenticator(new DefaultAuthenticator("gabrielsj@maveric-systems.com",
					MethodDef.convertHexToString("4d61766572696339373040"))); // email.setSSLOnConnect(true);
			email.setStartTLSRequired(true);
			email.setFrom("gabrielsj@maveric-systems.com");
			String jobname = System.getProperty("ResSuite");
			email.setSubject("AUTOMATION RESULTS ON THE SETTINGS : " + jobname);
			String bmsg, mmsg;
			if (suiteName.equalsIgnoreCase("Browser")) {
				bmsg = "BROWSER RESULTS:" + "\n " + "************* \n" + "PASS:  " + ExReporter.passCountD + "\n"
						+ "FAIL: " + ExReporter.failCountD;
				email.setMsg(bmsg);
				attachment.setPath(ExReporter.reportPath + "/Browser-Browser-Results.htm");
				//attachment.setDisposition(EmailAttachment.ATTACHMENT);
				//attachment.setDescription("Browser Result Attachment");
				//attachment.setName("Browser Result.htm");
				//email.attach(attachment);

			} else if (suiteName.equalsIgnoreCase("mBrowser")) {
				mmsg = "Mobile BROWSER RESULTS:" + "\n" + "***************** \n" + "PASS:  " + ExReporter.passCountM
						+ "\n" + "FAIL: " + ExReporter.failCountM;
				email.setMsg(mmsg);
				attachment.setPath(ExReporter.reportPath + "/Mobile-Browser-Results.htm");
				//attachment.setDisposition(EmailAttachment.ATTACHMENT);
				//attachment.setDescription("Mobile Browser Result Attachment");
				//attachment.setName("Browser Result");
				//email.attach(attachment);
			}
			email.addTo("gabrielsj@maveric-systems.com");			
			email.send();
			System.out.println("EMAIL SENT");
		} catch (Exception E) {
			System.out.println("Error sending email: " + E.getMessage());
		}
	}

	@BeforeClass(alwaysRun = true)
	public void beforeClass(ITestContext ctx) {
		String className = this.getClass().getSimpleName();
		String suiteName = ctx.getCurrentXmlTest().getSuite().getName();
		String testName = ctx.getCurrentXmlTest().getName();
		logger.info("Starting TestNG Class  for SUITE..." + suiteName + "... :" + className);
		if (suiteName.equalsIgnoreCase("browser"))
			classReport = new ExReporter(testName, "-", suiteName);
		else
			classReport = new ExReporter(className + "-" + testName, testName, suiteName);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass(ITestContext ctx) {
		String suiteName = ctx.getCurrentXmlTest().getSuite().getName();
		String className = this.getClass().getSimpleName();
		logger.info("Ended TestNG Class  for SUITE..." + suiteName + "... :" + className);
		classReport.endParent(suiteName);
	}
	@SuppressWarnings("unchecked")
	@BeforeMethod(alwaysRun = true)
	public static void beforeMethod(Object[] testArgs, ITestContext ctx, Method method) {
		//System.out.println("inside before method");
		String suiteName = ctx.getCurrentXmlTest().getSuite().getName();
		ConfigProvider.init((Map<String, String>) testArgs[0]);
		TestData.init((Map<String, String>) testArgs[1]);
		logger.info("Executing SUITE ::: " + suiteName + " ||| METHOD ::: " + method.getName() + " @ "
				+ ConfigProvider.getConfig("Data") + " ||| on Browser ::: " + ConfigProvider.getConfig("Browser") + "-"
				+ ConfigProvider.getConfig("Version"));
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestContext context, Method method, ITestResult result) {
		String suiteName = context.getCurrentXmlTest().getSuite().getName();
		String status = getResultString(result);
		logger.info("RESULT SUITE ::: " + suiteName + " ||| METHOD ::: " + method.getName() + " @ "
				+ ConfigProvider.getConfig("Data") + " ||| on Browser ::: " + ConfigProvider.getConfig("Browser") + "-"
				+ ConfigProvider.getConfig("Version") + " ||| RESULT ::: " + status);
		if (System.getProperty("ResSuite").contains("TCIB")) {
			releaseUser("User");
			//releaseUser("VerifyUser");

		}
		classReport.appendParent();
		DriverFactory.closeDriver();
		ConfigProvider.endThreadLocal();
		TestData.endThreadLocal();
	}

	private String getResultString(ITestResult result) {
		String executionStatus = null;
		int execStatus = result.getStatus();
		if (execStatus == ITestResult.SUCCESS) {
			executionStatus = "PASS";
		} else if (execStatus == ITestResult.FAILURE) {
			executionStatus = "FAIL";
		} else if (execStatus == ITestResult.SKIP) {
			executionStatus = "SKIP";
		}
		return executionStatus;
	}

	private void releaseUser(String user) {
		try {
			user = TestData.getConfig(user);
			// SyncMap.availableStat(user);
			if (!user.equalsIgnoreCase("n/a"))
				SyncMap.setAvailable(user);
			// SyncMap.availableStat(user);
		} catch (Exception e) {
		}
	}

	@SuppressWarnings("unchecked")
	@Parameters({ "TEST" })
	@DataProvider(name = "TestDataParallel", parallel = true)
	public static Object[][] GlobalTestData(Method method, ITestContext context, ITestNGMethod met2) {
		return testDataComputer(method, context, met2);
	}

	@DataProvider(name = "TestDataSerial", parallel = false)
	public static Object[][] GlobalTestDataNoParallel(Method method, ITestContext context, ITestNGMethod met2) {
		return testDataComputer(method, context, met2);
	}

	@SuppressWarnings("unchecked")
	private static Object[][] testDataComputer(Method method, ITestContext context, ITestNGMethod met2) {
		String className = method.getDeclaringClass().getSimpleName();
		String methodName = method.getName();

		String suiteName = context.getCurrentXmlTest().getSuite().getName();
		// System.out.println("DATA PRO SUITE NAME : " + suiteName);
		String testXMLName = "";
		if (suiteName.equals("Browser"))
			testXMLName = (context.getCurrentXmlTest().getName()).split("-")[1];
		else if (suiteName.equals("mBrowser"))
			testXMLName = context.getCurrentXmlTest().getName();

		ArrayList<Map<String, String>> browData = new ArrayList<Map<String, String>>();
		ArrayList<Map<String, String>> dataComb = new ArrayList<Map<String, String>>();

		ArrayList<String> dataArr = new ArrayList<String>();

		// System.out.println("DATA PRO DATA NAME: " + testXMLName);
		JSONArray browcomb = ExcelReader.getBrowCombination(suiteName, className, methodName, testXMLName);
		if (browcomb != null) {
			for (int i = 0; i < browcomb.size(); i++) {
				if (suiteName.equals("mBrowser")) {
					if (i == 0)
						browData.add((Map<String, String>) browcomb.get(i));
					Map<String, String> test = new HashMap<String, String>();
					test = (Map<String, String>) browcomb.get(i);
					dataArr.add(test.get("Data"));
				} else if (suiteName.equals("Browser")) {
					browData.add((Map<String, String>) browcomb.get(i));
				}
			}
		}
		// System.out.println("DATA PROV TEST DATA: " + browData);
		if (suiteName.equals("Browser"))
			dataComb = ExcelReader.getTestDataCombination(methodName, testXMLName);
		else if (suiteName.equals("mBrowser"))
			dataComb = ExcelReader.getTestDataCombination(methodName, dataArr);
		// System.out.println("DATACOMB" + dataComb);
		int i = 0;
		int count = browData.size() * dataComb.size();

		Object[][] test = new Object[count][2];

		for (Map<String, String> elem : browData) {
			for (Map<String, String> entryD : dataComb) {
				test[i][0] = elem;
				test[i][1] = entryD;
				i++;
			}
		}

		return test;
	}

}
