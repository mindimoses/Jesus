package mav.metro.pom.tcib.elements;

import java.sql.Connection;
import java.util.HashMap;

import org.openqa.selenium.By;

import mav.metro.library.functions.CommonDef;
import mav.metro.utilities.enums.Locators;

public class Messages {
	
	public static By Messages_menu()
	{
	return CommonDef.locatorValue(Locators.ID, "BUT_0C62B74FFDCD4CDC82643");
	}
	public static By Messages_viewandsend()
	{
	return CommonDef.locatorValue(Locators.LINKTEXT, "View & Send Messages");
	}
	public static By Messages_newMessage()
	{
	return CommonDef.locatorValue(Locators.ID, "NewMessage");
	}
	
	public static By Messages_selectQuery()
	{
	return CommonDef.locatorValue(Locators.XPATH, ".//*[@id='QUE_74AB412D29BF86D5204039_chzn']/a/span");
	}
	public static By Messages_Queryelement(String val1)
	{
	return CommonDef.locatorValue(Locators.XPATH, ".//*[@id='QUE_74AB412D29BF86D5204039_chzn_o_" + val1 + "']");
	}
	
	public static By Messages_selectSubject()
	{
	return CommonDef.locatorValue(Locators.XPATH, ".//*[@id='QUE_74AB412D29BF86D5204053_chzn']/a/span");
	}
	
	public static By Messages_Subjectelement(String val1)
	{
	return CommonDef.locatorValue(Locators.XPATH, ".//*[@id='QUE_74AB412D29BF86D5204053_chzn_o_" + val1 + "']");
	}
	
	public static By Messages_start() {
		return CommonDef.locatorValue(Locators.XPATH, "//label[contains(.,'Date of Travel')]/parent::div/parent::div/following-sibling::div//button[@class='ui-datepicker-trigger']");		
	}
	
	public static By Messages_end() {
		return CommonDef.locatorValue(Locators.XPATH, "//label[contains(.,'Date of Return to UK')]/parent::div/parent::div/following-sibling::div//button[@class='ui-datepicker-trigger']");		
	}
	public static By Messages_travelCountry()
	{
	return CommonDef.locatorValue(Locators.ID, "QUE_39B4AF0C442EB3D9120625");
	}
	public static By Messages_Reason()
	{
	return CommonDef.locatorValue(Locators.ID, "QUE_74AB412D29BF86D5204113");
	}
	public static By Messages_DeclinedCard()
	{
	return CommonDef.locatorValue(Locators.ID, "QUE_0A88C2B25C958FBF277835");
	}
	
	public static By Messages_SendMessage()
	{
	return CommonDef.locatorValue(Locators.ID, "BUT_06D55C26ECC52767153050");
	}
	public static By Messages_Success() {
		return CommonDef.locatorValue(Locators.XPATH, "//h4[contains(.,'Your message has been sent')]");		
	}
	public static By Messages_Inbox()
	{
	return CommonDef.locatorValue(Locators.ID, "TAB_74AB412D29BF86D5203612");
	}	
	public static By Messages_InboxMessage()
	{
	return CommonDef.locatorValue(Locators.XPATH, "//*[starts-with(@id,'BUT_7367BF00E92AD51E1401219_R')]");
	}
	public static By Messages_Inboxview(int val2)
	{
	return CommonDef.locatorValue(Locators.XPATH, "//*[@id='BUT_7367BF00E92AD51E1401219_R" + val2 + "']/span");
	}
	
	public static By Messages_CheckBoxMessage(int val1)
	{
	return CommonDef.locatorValue(Locators.XPATH, "//*[@id='QUE_4054B65C7D1579EF391037_0_R" + val1 + "']");
	}
	public static By Messages_DeleteButton()
	{
	return CommonDef.locatorValue(Locators.ID, "BUT_7367BF00E92AD51E1497917");
	}
	
	public static By Messages_DeleteMessage() {
		return CommonDef.locatorValue(Locators.XPATH, "//h4[contains(.,'Messages deleted!')]");		
	}
	
	public static By Messages_BacktoInbox() {
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='BUT_7367BF00E92AD51E1402753']/span");		
	}
	public static By Messages_Header() {
		return CommonDef.locatorValue(Locators.XPATH, "//h1[contains(.,'Messages')]");		
	}
	//*[@id='BUT_7367BF00E92AD51E1402753']/span
	//*[@id='QUE_4054B65C7D1579EF391037_0_R1']
		//BUT_7367BF00E92AD51E1497917
		//*[@id='HEAD_7367BF00E92AD51E1497923']
}

