package mav.metro.pom.tcib.elements;

import java.util.HashMap;

import org.openqa.selenium.By;

import mav.metro.library.functions.CommonDef;
import mav.metro.utilities.enums.Locators;

public class PayeeManagement {
	public static By PayMag_Payeemenu()
	{
	return CommonDef.locatorValue(Locators.ID, "BUT_AA76E5E393F0103923803");
	}
	public static By PayMag_PayeeAction(int val1)
	{
	return CommonDef.locatorValue(Locators.XPATH, "//*[@id='BUT_AD37C880EFD87446492974_R" + val1 + "']");
	}
	public static By PayMag_Payeelist()
	{
	return CommonDef.locatorValue(Locators.XPATH, "//*[starts-with(@id,'QUE_0DBD9C0C01ABF0DE208137_R')]");
	}
	public static By PayMag_SendMoney()
	{
	return CommonDef.locatorValue(Locators.LINKTEXT, "Send Money to this Payee");
	}
	public static By PayMag_ChangePayee()
	{
	return CommonDef.locatorValue(Locators.LINKTEXT, "Change Payee reference");
	}
	public static By PayMag_DeletePayee()
	{
	return CommonDef.locatorValue(Locators.LINKTEXT, "Delete this Payee");
	}
	public static By PayMag_YesDeletePayee()
	{
	return CommonDef.locatorValue(Locators.ID, "BUT_CAE2614B5E00D43F97494");
	}
	public static By PayMag_DeleteClose()
	{
	return CommonDef.locatorValue(Locators.ID, "BUT_475858B74AC2DB18207471");
	}
	public static By PayMag_ChangeReference()
	{
	return CommonDef.locatorValue(Locators.ID, "QUE_A421CD01D85BA3C7113690");
	}
	public static By PayMag_ChangeContinue()
	{
	return CommonDef.locatorValue(Locators.ID, "BUT_A421CD01D85BA3C7113714");
	}
	public static By PayMag_ReferenceMessage()
	{
	return CommonDef.locatorValue(Locators.XPATH, "//em[contains(.,'Payee reference has been changed to')]");
	}
	public static By PayMag_DeleteMessage()
	{
	return CommonDef.locatorValue(Locators.XPATH, "//em[contains(.,'Payee reference has been changed to')]");
	}
	public static By PayMag_ReferenceClose()
	{
	return CommonDef.locatorValue(Locators.ID, "BUT_A421CD01D85BA3C7113810");
	}
	
}
