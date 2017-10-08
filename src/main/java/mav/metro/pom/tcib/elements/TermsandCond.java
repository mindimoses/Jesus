package mav.metro.pom.tcib.elements;
import mav.metro.library.functions.CommonDef;
import mav.metro.utilities.enums.Locators;

import org.openqa.selenium.By;

public class TermsandCond extends Interstitial{	
	public static By TermsandCond_AddButton() {
		return CommonDef.locatorValue(Locators.ID, "BUT_17044A684D38574310086");
	}		
	public static By TermsandCond_Title() {
		return CommonDef.locatorValue(Locators.ID, "QUE_1C13FEC6E7C70B2422671");
	}
	public static By TermsandCond_Start() {
		return CommonDef.locatorValue(Locators.ID, "StartDateTimeInput");
	}
	public static By TermsandCond_Stop() {
		return CommonDef.locatorValue(Locators.ID, "StopDateTimeInput");
	}
	public static By TermsandCond_Publish() {
		return CommonDef.locatorValue(Locators.ID, "QUE_1C13FEC6E7C70B2422675_0");
	}
	public static By TermsandCond_Message() {
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='jqte_editor']");
	}
	public static By TermsandCond_Create() {
		return CommonDef.locatorValue(Locators.ID, "BUT_1C13FEC6E7C70B2422680");
	}
	public static By TermsandCond_Update() {
		return CommonDef.locatorValue(Locators.ID, "BUT_1C13FEC6E7C70B2422680");
	}	
	public static By TermsandCond_Back() {
		return CommonDef.locatorValue(Locators.ID, "BUT_1C13FEC6E7C70B2422679");
	}	
	public static By TermsandCond_SuccessMessage() {
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='p1_HEAD_1C13FEC6E7C70B2422670']/div[contains(.,'Terms')]");
	}	
	public static By TermsandCond_SelectMessage(String messageID) {
		return CommonDef.locatorValue(Locators.XPATH, "//span[contains(.,'"+messageID+"')]/following::td[1]/div/a/span");
	}
	
}
