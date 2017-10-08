package mav.metro.pom.tcib.elements;

import java.sql.Connection;
import java.util.HashMap;

import mav.metro.library.functions.CommonDef;
import mav.metro.utilities.enums.Locators;

import org.openqa.selenium.By;



public class SendMoney extends MoveMoney{	
	
	public static By sendmoney_button() {
		return CommonDef.locatorValue(Locators.ID, "SEND_MONEY_BUTTON");		
	}

	public static By sendmoney_amount() {
		return CommonDef.locatorValue(Locators.ID, "QUE_D95409D004C922E0390485");		
	}
	public static By sendmoney_From() {
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='QUE_22F421D5E64DD11E222293_chzn']/a/div/b");		
	}
	/*public static By Sendmoney_Payeelist()
	{return CommonDef.locatorValue(Locators.ID, "QUE_AE4F6168583977D735437_0");
	}*/
	public static By Sendmoney_Payee()
	{return CommonDef.locatorValue(Locators.XPATH, "//*[@id='QUE_635613178EB252CF23239_chzn']/a/div/b");
	}	
	/*public static By sendmoney_From() {
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='QUE_22F421D5E64DD11E222293_chzn']/a/span");		
	}
	public static By Sendmoney_Payeelist()
	{return CommonDef.locatorValue(Locators.ID, "QUE_AE4F6168583977D735437_0");
	}
	public static By Sendmoney_Payee()
	{return CommonDef.locatorValue(Locators.XPATH, "//*[@id='QUE_635613178EB252CF23239_chzn']/a/span");
	}	*/
	
	public static By SendMoney_Payeelist(int val1)
	{
	return CommonDef.locatorValue(Locators.XPATH, "//*[@id='QUE_AE4F6168583977D735437_" + val1 + "']");
	}

	public static By Sendmoney_reference(){
	return CommonDef.locatorValue(Locators.XPATH, "//*[@id='QUE_635613178EB252CF23242']");	}
	
	public static By success_message() {
		return CommonDef.locatorValue(Locators.XPATH, "//h3[contains(.,'Success! Your Payment has been made')]");		
	}
	public static By Account_summary() {
		return CommonDef.locatorValue(Locators.ID, "BUT_22F421D5E64DD11E808947");		
	}
	
}
	
	