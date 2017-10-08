package mav.metro.pom.tcib.elements;

import org.openqa.selenium.By;

import mav.metro.library.functions.CommonDef;
import mav.metro.utilities.enums.Locators;

public class QuickPay {

	public static By QuickPay_Home()
	{
	return CommonDef.locatorValue(Locators.ID,"BUT_AA76E5E393F0103923812");
	}
	public static By QuickPay_Amount()
	{
	return CommonDef.locatorValue(Locators.ID,"QUE_B24088A2772C6B6462390");
	}
	public static By QuickPay_AccountType (String val1)
	{
	return CommonDef.locatorValue(Locators.XPATH, ".//*[@id='PAYMENT_TO_" + val1 + "']");
	}
	public static By QuickPay_Continue()
	{
	return CommonDef.locatorValue(Locators.ID, "BUT_B24088A2772C6B6462397");
	}
	public static By QuickPay_OneFromAccount()
	{
	return CommonDef.locatorValue(Locators.XPATH, "//*[@id='QUE_F0512EDB96E6D968226263_chzn']/a/span");
	}
	public static By QuickPay_OneProfile()
	{
	return CommonDef.locatorValue(Locators.XPATH, "//*[@id='QUICKPAY_ENTITY_chzn']/a/span");
	}
	public static By QuickPay_OneSelectAc()
	{
	return CommonDef.locatorValue(Locators.XPATH, "//*[@id='QUE_00752AC49595EAC4424054_chzn']/a/span");
	}
	public static By QuickPay_OneConfirm()
	{
	return CommonDef.locatorValue(Locators.ID, "BUT_CFCD33B46919848C62283");
	}	
	public static By success_message() {
		return CommonDef.locatorValue(Locators.XPATH, "//span[contains(.,'Your Payment was successful')]");		
	}	
	public static By QuickPay_OneClose()
	{
	return CommonDef.locatorValue(Locators.ID, "BUT_5C3A2D92F50F019B58245");
	}
	
	public static By QuickPay_viewtranscations() {
		return CommonDef.locatorValue(Locators.XPATH, "//a[contains(.,'View Transactions for')]");		
	}
	
	public static By QuickPay_SavedFromAccount()
	{
	return CommonDef.locatorValue(Locators.XPATH, "//*[@id='QUE_F0512EDB96E6D968226291_chzn']/a/span");
	}
	public static By QuickPay_SavedPayee()
	{
	return CommonDef.locatorValue(Locators.XPATH, "//*[@id='QUE_00752AC49595EAC4423667_chzn']/a/span");
	}
	public static By QuickPay_OneSelectac()
	{
	return CommonDef.locatorValue(Locators.XPATH, "//*[@id='QUE_00752AC49595EAC4424054_chzn']/a/span");
	}
	public static By QuickPay_SavedReference()
	{
	return CommonDef.locatorValue(Locators.ID, "QUE_00752AC49595EAC4501915");
	}
	public static By QuickPay_SavedConfirm()
	{
	return CommonDef.locatorValue(Locators.ID, "BUT_E69059C36009800B83157");
	}
}
