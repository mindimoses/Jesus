package mav.metro.pom.tcib.elements;
import mav.metro.library.functions.CommonDef;
import mav.metro.utilities.enums.Locators;

import org.openqa.selenium.By;
public class Statements {
	public static By Statements_Menu() {
		return CommonDef.locatorValue(Locators.ID, "BUT_E8BAE60B5EFF4C8247974");
	}
	
	public static By Statements_TabStatements() {
		return CommonDef.locatorValue(Locators.ID, "TAB_C5D1C29FB96588E7110068");
	}
	public static By Statements_TabLetters() {
		return CommonDef.locatorValue(Locators.ID, "TAB_14D44A8BEB9BA60A1239104");
	}
	public static By Statements_ShowLetters() {
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='QUE_14D44A8BEB9BA60A1119007_chzn']/a/span");
	}
	public static By Statements_PaymentType() {
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='QUE_55EB615EB87950B42311160_chzn']/a/span");
	}
	public static By Statements_Retrieve() {
		return CommonDef.locatorValue(Locators.ID, "BUT_14D44A8BEB9BA60A1119010");
	}
	//R10
	public static By Certificates_Tab() {
		return CommonDef.locatorValue(Locators.ID, "TAB_TAX");
	}
	public static By Certificates_InterestTab() {
		return CommonDef.locatorValue(Locators.XPATH, "//span[contains(.,'Certificates Of Interest')]");
	}
	
	public static By Certificates_InterestHeader() {
		return CommonDef.locatorValue(Locators.XPATH, "//h3[contains(.,'Certificates Of Interest')]");
	}
	
	public static By Certificates_StatementsHeader() {
		return CommonDef.locatorValue(Locators.XPATH, "//h1[contains(.,'Statements')]");
	}
	
	public static By Certificates_ErrorMessage() {
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='p1_HEAD_79D4EE43AECCB108523081']/div[contains(.,'We have')]");
	}
	public static By Certificates_Contents() {
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='p1_HEAD_CC33DAB2913B4D28527140']//div[contains(.,'Below are your most recent')]");
	}
	
	
	
	
}
