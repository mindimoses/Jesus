package mav.metro.pom.tcib.functions;

import mav.metro.driver.DriverFactory;
import mav.metro.framework.ExReporter;
import mav.metro.framework.TestData;
import mav.metro.library.functions.CommonDef;
import mav.metro.library.functions.MethodDef;
import mav.metro.pom.tcib.elements.NewAccount;
import mav.metro.pom.tcib.elements.PaymentAcDetails;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.LogStatus;


public class NewAccountFns {
	public static void NewAccount (String customertype)
	{
		WebDriver driver = DriverFactory.getCurrentDriver();	
		Keyboard kb = ((RemoteWebDriver) driver).getKeyboard();	
		ExReporter.log(LogStatus.INFO, "New Account Opening");
		try{
			if (!customertype.startsWith("Only"))
			{
			BasePageFns.profileChange(TestData.getConfig("ProfileName"));	
			}
			MethodDef.clickJS(NewAccount.NewAc_ViewAccounts(), "View Accounts Menu");		
			MethodDef.clickJS(NewAccount.NewAc_OpenNewAc(),"NewAccount Open Menu");
			if (TestData.getConfig("Transcation").equals("n/a")){
			if (TestData.getConfig("New_Accounts").equals("Current Ac")){	
				MethodDef.clickJS(NewAccount.NewAc_CurrentAc(),"Current Account Apply");
				MethodDef.clickJS(NewAccount.NewAc_allAgree(), "I agree");			
				MethodDef.clickJS(NewAccount.NewAc_Continue(),"Continue");
				MethodDef.clickJS(NewAccount.NewAc_CurrPaperless(),"Paperless");
				MethodDef.clickJS(NewAccount.NewAc_CurrCheque(),"Cheque");
				MethodDef.clickJS(NewAccount.NewAc_CurrStore(),"CurrentStore");
			}
			else if (TestData.getConfig("New_Accounts").equals("Cash Ac")){	
				MethodDef.clickJS(NewAccount.NewAc_CashAc(),"Cash Account Apply");
				MethodDef.clickJS(NewAccount.NewAc_allAgree(), "I agree");
				MethodDef.clickJS(NewAccount.NewAc_ContinueNext(), "Continue Next");				
				MethodDef.clickJS(NewAccount.NewAc_CurrPaperless(),"Paperless");
				MethodDef.clickJS(NewAccount.NewAc_CurrStore(),"CurrentStore");
			}
			else if (TestData.getConfig("New_Accounts").equals("Instant Access Savings")){	
				MethodDef.clickJS(NewAccount.NewAc_TabSavings(),"Savings Account Tab");
				MethodDef.clickJS(NewAccount.NewAc_SavingsAc(),"Savings Account");
				MethodDef.clickJS(NewAccount.NewAc_allAgree(), "I agree");			
				MethodDef.clickJS(NewAccount.NewAc_ContinueNext(),"Continue");
				MethodDef.clickJS(NewAccount.NewAc_CurrPaperless(),"Paperless");			
				}
			else if (TestData.getConfig("New_Accounts").equals("Fixed Term Savings")){	
				MethodDef.clickJS(NewAccount.NewAc_TabSavings(),"Savings Account Tab");
				MethodDef.clickJS(NewAccount.NewAc_FixedTermAc(),"Fixed Term Account");
				MethodDef.clickJS(NewAccount.NewAc_allAgree(), "I agree");			
				MethodDef.click(NewAccount.NewAc_ContinueNext(),"Continue next");
				String[] Val2 = TestData.getConfig("Deposit_Frequency").toString().split("_");
				MethodDef.click(NewAccount.NewAc_Fixedfrequency(Val2[1]),"Frequency");	
				String[] Val3 = TestData.getConfig("Interest_Frequency").toString().split("_");
				MethodDef.click(NewAccount.NewAc_Interestfrequency(Val3[1]),"Interest Frequency");
				MethodDef.click(NewAccount.NewAc_FixedContinueNext(),"Continue next");
				MethodDef.sendKeys(NewAccount.NewAc_FixedAmount(),TestData.getConfig("Amount"));
				BasePageFns.selectItem(NewAccount.NewAc_FixedAccountFrom(), TestData.getConfig("Deposit_FromAC"));
				MethodDef.clickJS(NewAccount.NewAc_FixedContinueNextNext(), "Continue");					
				}
			else if (TestData.getConfig("New_Accounts").equals("ISA Ac")){	
				MethodDef.clickJS(NewAccount.NewAc_TabISAAcc(),"ISA Account Tab");
				MethodDef.clickJS(NewAccount.NewAc_InstantAccess(),"ISA Account");
				MethodDef.clickJS(NewAccount.NewAc_allAgree(), "I agree");	
				MethodDef.sendKeys(NewAccount.NewAc_InstantNINumber(),TestData.getConfig("Insurance_No"));
				MethodDef.click(NewAccount.NewAc_ContinueNext(),"Continue");
				MethodDef.clickJS(NewAccount.NewAc_CurrPaperless(),"Paperless");			
				}
		MethodDef.click(NewAccount.NewAc_ApplyNow(),"Current Account Apply");
		CommonDef.assertElemsContains(NewAccount.NewAc_SuccessMessage(),TestData.getConfig("SuccessMessage"));		
		if (TestData.getConfig("Select_Payment").equals("Edit_AcName"))
		{
			MethodDef.clickJS(NewAccount.NewAc_ViewNewAccount(),"New Window");
			MethodDef.clickJS(PaymentAcDetails.PayAcDetails_EditLink(),"Edit Link ");
			MethodDef.sendKeys(PaymentAcDetails.PayAcDetails_EditName(),TestData.getConfig("Edit_AcName"));
			MethodDef.clickJS(PaymentAcDetails.PayAcDetails_EditSave(),"Save Link");
			MethodDef.assertElemsContains(PaymentAcDetails.PayAcDetails_EditVerify(TestData.getConfig("Edit_AcName")), TestData.getConfig("Edit_AcName"));
		}
		if (!TestData.getConfig("ISADetail").equals("n/a"))
		{
			MethodDef.click(NewAccount.NewAc_ViewAccountISA(),"View Your New Account");
			ExReporter.log(LogStatus.PASS, "ISA Detail Page");
		}
		
	}
		else if (TestData.getConfig("Transcation").equals("View More"))
		{
			if (TestData.getConfig("New_Accounts").equals("n/a"))
			{
			MethodDef.clickJS(NewAccount.NewAc_TabSavings(),"Savings Account Tab");
			CommonDef.assertElemsContains(NewAccount.NewAc_TextSaveFrom(),TestData.getConfig("ViewText"));
			MethodDef.clickJS(NewAccount.NewAc_ViewMoreDetails(),"View More Account Details");
			CommonDef.assertElemsContains(NewAccount.NewAc_ViewTextSaveFrom(),TestData.getConfig("ViewText"));
			}
			else if (TestData.getConfig("New_Accounts").equals("Cash Ac"))
			{
			MethodDef.clickJS(NewAccount.NewAc_CashViewMoreDetails(),"View More Details button");
			CommonDef.assertElemsContains(NewAccount.NewAc_CashMasterCard(),TestData.getConfig("MasterCard"));
			MethodDef.clickJS(NewAccount.NewAc_CashThingstoConsiderTab(),"Things to Consider Tab");
			CommonDef.Wait();
			CommonDef.assertElemsContains(NewAccount.NewAc_CashCashAccount(),TestData.getConfig("CashAccount"));
			CommonDef.assertElemsContains(NewAccount.NewAc_CashJointAccounts(),TestData.getConfig("JointAccounts"));
			CommonDef.assertElemsContains(NewAccount.NewAc_CashFasterPayments(),TestData.getConfig("FasterPayments"));
			CommonDef.assertElemsContains(NewAccount.NewAc_CashCard(),TestData.getConfig("CashCard"));			
			CommonDef.assertElemsContains(NewAccount.NewAc_ForInformation(),TestData.getConfig("ForInformation"));			
			}	
		}
	}
			catch (Exception e) {
				ExReporter.log(LogStatus.ERROR, "Error in performing NewAccount Function");
			}
		}	
		
}
