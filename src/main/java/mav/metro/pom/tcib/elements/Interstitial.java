package mav.metro.pom.tcib.elements;
import mav.metro.library.functions.CommonDef;
import mav.metro.utilities.enums.Locators;

import org.openqa.selenium.By;

public class Interstitial {
	public static By Interstitial_AdminLink() {
		return CommonDef.locatorValue(Locators.ID, "BUT_420E07161E0F21C79313");
	}
	public static By Interstitial_Link() {
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='BUT_1C13FEC6E7C70B2422923']//span[contains(.,'Manage Interstitial Messages')]");
	}
	public static By Interstitial_AddButton() {
		return CommonDef.locatorValue(Locators.ID, "BUT_1C13FEC6E7C70B2422656");
	}
	public static By Interstitial_ImageHelp() {
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='HELP_HEAD_70134081AE9F4E611632687']/img");
	}
	public static By Interstitial_ImageClose() {
		return CommonDef.locatorValue(Locators.XPATH, "html/body/p/a");
	}
	public static By Interstitial_Title() {
		return CommonDef.locatorValue(Locators.ID, "QUE_1C13FEC6E7C70B2422671");
	}
	public static By StartDateTimeInput() {
		return CommonDef.locatorValue(Locators.ID, "StartDateTimeInput");
	}
	public static By StopDateTimeInput() {
		return CommonDef.locatorValue(Locators.ID, "StopDateTimeInput");
	}	
	public static By Interstitial_Message() {
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='jqte_editor']");
	}
	public static By Interstitial_Publish() {
		return CommonDef.locatorValue(Locators.ID, "QUE_1C13FEC6E7C70B2422675_0");
	}
	public static By Interstitial_ShowDonot() {
		return CommonDef.locatorValue(Locators.ID, "QUE_1C13FEC6E7C70B2422676_0");
	}
	public static By Interstitial_Store() {
		return CommonDef.locatorValue(Locators.ID, "QUE_1C13FEC6E7C70B2422677");
	}
	public static By Interstitial_Product() {
		return CommonDef.locatorValue(Locators.ID, "QUE_1C13FEC6E7C70B2422678");
	}
	public static By Interstitial_Create() {
		return CommonDef.locatorValue(Locators.ID, "BUT_1C13FEC6E7C70B2422680");
	}
	public static By Interstitial_Update() {
		return CommonDef.locatorValue(Locators.ID, "BUT_1C13FEC6E7C70B2422680");
	}	
	public static By Interstitial_Back() {
		return CommonDef.locatorValue(Locators.ID, "BUT_1C13FEC6E7C70B2422679");
	}	
	public static By Interstitial_SuccessMessage() {
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='p1_HEAD_1C13FEC6E7C70B2422670']/div[contains(.,'Interstitial')]");
	}		
	public static By Interstitial_CreateMessage() {
		return CommonDef.locatorValue(Locators.XPATH, "//span[contains(.,'Interstitial')]");
	}
	public static By Interstitial_SelectMessage(String messageID) {
		return CommonDef.locatorValue(Locators.XPATH, "//span[contains(.,'"+messageID+"')]/following::td[1]/div/a/span");
	}
	
}
