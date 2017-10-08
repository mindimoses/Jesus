package mav.metro.pom.tcib.elements;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;

import mav.metro.library.functions.CommonDef;
import mav.metro.utilities.enums.Locators;


public class PaymentAcDetails {

	public static By PayAcDetails_ViewAc()
	{
		return CommonDef.locatorValue(Locators.ID, "BUT_AA76E5E393F0103923299");
	}
	public static By PayAcDetails_AccountNo()
	{
		return CommonDef.locatorValue(Locators.XPATH, "//*[starts-with(@id,'QUE_FA673B4F9065075F248555')]");
	}
	
	public static By PayAcDetails_EditLink()
	{
		return CommonDef.locatorValue(Locators.ID, "BUT_020C18BE9324DA1E53553");
	}
	public static By PayAcDetails_EditName()
	{
		return CommonDef.locatorValue(Locators.ID, "QUE_14081163F05CD23917794");
	}
	public static By PayAcDetails_EditSave()
	{
		return CommonDef.locatorValue(Locators.ID, "BUT_14081163F05CD23917639");
	}
	public static By PayAcDetails_MakePayment()
	{
		return CommonDef.locatorValue(Locators.ID, "TAB_MAKEPAYMENT");
	}
	
	public static By PayAcDetails_MoveMoney()
	{
		return CommonDef.locatorValue(Locators.XPATH, "//div[@id='TAB_MAKEPAYMENT']//a[@id='MOVE_MONEY_BUTTON']");
	}
	public static By PayAcDetails_SendMoney()
	{
		return CommonDef.locatorValue(Locators.XPATH, "//div[@id='TAB_MAKEPAYMENT']//a[@id='SEND_MONEY_BUTTON']");
	}
	public static By PayAcDetails_RegularPayments()
	{
		return CommonDef.locatorValue(Locators.ID, "TAB_7DBA9120F8BEF939288337");
	}
	public static By PayAcDetails_RegPayAc()
	{
		return CommonDef.locatorValue(Locators.XPATH, "//*[starts-with(@id,'QUE_7FE2A5B2D9DF8623546044_R')]");
	}
					
	public static By PayAcDetails_ActionClick(int val1)
	{
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='BUT_7FE2A5B2D9DF8623546054_R" + val1 +"']");
	}
	
	//QUE_7FE2A5B2D9DF8623546044_
	public static By PayAcDetails_CreateRegular()
	{
	return CommonDef.locatorValue(Locators.LINKTEXT, "create a regular payment?");
	}
	
	public static By PayAcDetails_ChangeRegular()
	{
	return CommonDef.locatorValue(Locators.LINKTEXT, "Change this regular payment");
	}
	public static By PayAcDetails_CancelRegular()
	{
	return CommonDef.locatorValue(Locators.LINKTEXT, "Cancel this regular payment");
	}
	
	public static By PayAcDetails_ChangeReference()
	{
		return CommonDef.locatorValue(Locators.ID, "QUE_7FE2A5B2D9DF8623602750");
	}
	public static By PayAcDetails_SaveChanges()
	{
		return CommonDef.locatorValue(Locators.ID, "BUT_7FE2A5B2D9DF8623602782");
	}
	public static By PayAcDetails_RegularSuccess()
	{
	return CommonDef.locatorValue(Locators.XPATH, "//*[@id='p1_HEAD_7FE2A5B2D9DF8623602790']/div[contains(.,'Your changes to this regular payment have been saved.')]");
	}
	public static By PayAcDetails_RegularClose()
	{
	return CommonDef.locatorValue(Locators.ID, "BUT_2FAEAD07F191F071251459");
	}
	
	public static By PayAcDetails_Cancelbutton()
	{
	return CommonDef.locatorValue(Locators.ID, "BUT_7FE2A5B2D9DF8623602814");
	}
	public static By PayAcDetails_CancelSuccess()
	{
	return CommonDef.locatorValue(Locators.XPATH, "//*[@id='p1_HEAD_7FE2A5B2D9DF8623602826']/div[contains(.,'This regular payment has now been cancelled.')]");
	}
	//*[@id='p1_HEAD_7FE2A5B2D9DF8623602826']/div[contains(.,'This')]
	public static By PayAcDetails_CancelClose()
	{
	return CommonDef.locatorValue(Locators.ID, "BUT_7FE2A5B2D9DF8623602830");
	}
	public static By PayAcDetails_EditVerify(String Data)
	{
	return CommonDef.locatorValue(Locators.XPATH, "//h1[contains(.,'"+ Data +"')]");
	}

	//R10
	
	public static By PayAcDetails_EditError()
	{
	return CommonDef.locatorValue(Locators.ID, "QUE_14081163F05CD23917794_ERRORMESSAGE");
	}
	
	//label[contains(.,'Please')]
	//label[contains(.,'No Changes')]
	
}


