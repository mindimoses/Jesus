package mav.metro.pom.tcib.elements;

import mav.metro.library.functions.CommonDef;
import mav.metro.utilities.enums.Locators;

import org.openqa.selenium.By;

public class NewAccount extends PaymentAcDetails{
	public static By NewAc_ViewAccounts() {
		return CommonDef.locatorValue(Locators.ID, "BUT_AA76E5E393F0103923299");		
	}
	public static By NewAc_OpenNewAc() {
		return CommonDef.locatorValue(Locators.ID, "BUT_E8BAE60B5EFF4C8248048");		
	}
	public static By NewAc_CurrentAc() {
		return CommonDef.locatorValue(Locators.ID, "BUT_8819F83145E6D755165143");		
	}
	public static By NewAc_allAgree() {
		return CommonDef.locatorValue(Locators.ID,"BUT_741F6B4CC8CC41B6117614");		
	}
	
	public static By NewAc_Continue() {
		return CommonDef.locatorValue(Locators.ID,"BUT_741F6B4CC8CC41B6120326");		
	}
	public static By NewAc_CurrPaperless() {
		return CommonDef.locatorValue(Locators.NAME,"METROBANK[1].OPENNEWACCOUNT[1].STEP3[1].PAPERLESS");		
	}
	public static By NewAc_CurrCheque() {
		return CommonDef.locatorValue(Locators.NAME,"METROBANK[1].OPENNEWACCOUNT[1].STEP3[1].WANTCHEQUEBOOK");		
	}
	public static By NewAc_CurrStore() {
		return CommonDef.locatorValue(Locators.NAME,"METROBANK[1].OPENNEWACCOUNT[1].STEP3[1].POSTIT");		
	}
	public static By NewAc_ApplyNow() {
		return CommonDef.locatorValue(Locators.ID,"BUT_F316F3F2138F1E65600708");		
	}
	public static By NewAc_CashAc() {
		return CommonDef.locatorValue(Locators.ID, "BUT_8819F83145E6D755165162");		
	}
	
	//BUT_741F6B4CC8CC41B6117614 - i agree
	
	public static By NewAc_ContinueNext(){
		return CommonDef.locatorValue(Locators.ID, "BUT_BE0472936E1AECEF297968");		
	}
	public static By NewAc_FixedContinueNext(){
		return CommonDef.locatorValue(Locators.ID, "BUT_1599AF1377E2FE43212780");		
	}
	public static By NewAc_FixedContinueNextNext(){
		return CommonDef.locatorValue(Locators.ID, "BUT_1599AF1377E2FE43214061");		
	}
	
	
	
	//BUT_BE0472936E1AECEF297968
	
	public static By NewAc_CashPaperless() {
		return CommonDef.locatorValue(Locators.NAME,"METROBANK[1].OPENNEWACCOUNT[1].STEP3[1].PAPERLESS");		
	}
	public static By NewAc_CashCurrStore() {
		return CommonDef.locatorValue(Locators.NAME,"METROBANK[1].OPENNEWACCOUNT[1].STEP3[1].POSTIT");		
	}
	public static By NewAc_SuccessMessage(){
		return CommonDef.locatorValue(Locators.XPATH, "//h3[contains(.,'Your new account has been opened successfully and is now ready to use.')]");		
	}
	public static By NewAc_ViewAccount() {
		return CommonDef.locatorValue(Locators.ID, "BUT_FE9E0F0BCD372C52321656");		
	}
	
	public static By NewAc_TabSavings() {
		return CommonDef.locatorValue(Locators.ID, "TAB_36A02276A9641D28102717");		
	}
	public static By NewAc_SavingsAc() {
		return CommonDef.locatorValue(Locators.ID, "BUT_8819F83145E6D755165949");		
	}
	public static By NewAc_FixedTermAc() {
		return CommonDef.locatorValue(Locators.ID, "BUT_8819F83145E6D755165986");		
	}
	public static By NewAc_Fixedfrequency(String val1)
	{
	return CommonDef.locatorValue(Locators.XPATH, ".//*[@id='QUE_1599AF1377E2FE43210942_" + val1 + "']");
	}
	public static By NewAc_Interestfrequency(String val1)
	{
	return CommonDef.locatorValue(Locators.XPATH, ".//*[@id='QUE_1599AF1377E2FE43212136_" + val1 + "']");
	}
	
	public static By NewAc_FixedAmount()
	{
	return CommonDef.locatorValue(Locators.ID,"QUE_1599AF1377E2FE43213074");
	}
	public static By NewAc_FixedAccountFrom() {
		return CommonDef.locatorValue(Locators.XPATH, ".//*[@id='QUE_1599AF1377E2FE43213165_chzn']/a/span");		
	}
	
	public static By NewAc_TabISAAcc() {
		return CommonDef.locatorValue(Locators.ID, "TAB_36A02276A9641D28102719");		
	}
	public static By NewAc_InstantAccess() {
		return CommonDef.locatorValue(Locators.ID, "BUT_8819F83145E6D755166210");		
	}	
	
	public static By NewAc_FixedAmt() {
		return CommonDef.locatorValue(Locators.NAME, "METROBANK[1].OPENNEWACCOUNT[1].FIXEDTERM[1].MOVEMONEY[1].AMOUNT");		
	}
	
	public static By NewAc_MoveMoneyFrom() {
		return CommonDef.locatorValue(Locators.XPATH, ".//*[@id='QUE_1599AF1377E2FE43213165_chzn']/a/span");		
	}
	
	public static By NewAc_ViewNewAccount() {
		return CommonDef.locatorValue(Locators.ID, "BUT_FE9E0F0BCD372C52216563");		
	}
	
	
	public static By NewAc_InstantNINumber() {
		return CommonDef.locatorValue(Locators.ID, "QUE_741F6B4CC8CC41B6119904");		
	}
	public static By NewAc_ViewAccountISA() {
		return CommonDef.locatorValue(Locators.ID, "BUT_FE9E0F0BCD372C52216563");		
	}
	public static By NewAc_ViewAccounttitle() {
		return CommonDef.locatorValue(Locators.TITLE, "Go view your new account");		
	}
	
	//R8
	
	public static By NewAc_TextSaveFrom() {
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='TXT_2488E89745DA62A5612726']/div/ul/li[contains(.,'Save from')]");		
	}
	public static By NewAc_ViewMoreDetails() {
		return CommonDef.locatorValue(Locators.ID, "BUT_8819F83145E6D755165951");		
	}
	
	public static By NewAc_ViewTextSaveFrom() {
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='account-overview']/div/ul/li[5][contains(.,'Save from')]");		
	}
	//R9
	
	public static By NewAc_CashViewMoreDetails() {
		return CommonDef.locatorValue(Locators.ID, "BUT_8819F83145E6D755165165");			
	}
	
	public static By NewAc_CashMasterCard() {
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='account-overview']/div/ul/li[2]/p[contains(.,'PayPass')]");		
	}
	
	public static By NewAc_CashThingstoConsiderTab() {
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='TXT_6FF5BFF2B7088A60653876']/div/nav/ul/li[3]/a");		
	}
	public static By NewAc_CashCashAccount() {
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='TXT_8BF3799324B50E45463754']/div/div/div/ul/li[1][contains(.,'You can apply')]");
	}
	
	public static By NewAc_CashJointAccounts() {
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='TXT_8BF3799324B50E45463754']/div/div/div/ul/li[4][contains(.,'Joint Accounts are')]");
	}
	public static By NewAc_CashFasterPayments() {
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='TXT_8BF3799324B50E45463754']/div/div/div/ul/li[5][contains(.,'You can make')]");
	}
	public static By NewAc_CashCard() {
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='TXT_8BF3799324B50E45463754']/div/div/div/ul/li[6][contains(.,'You will not')]");		
	}
	public static By NewAc_ForInformation() {
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='TXT_8BF3799324B50E45463754']/div/div/div/ul/li[7][contains(.,'For information')]");		
	}
	
	
	
}
