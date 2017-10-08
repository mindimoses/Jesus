package mav.metro.pom.tcib.elements;
import mav.metro.library.functions.CommonDef;
import mav.metro.utilities.enums.Locators;

import org.openqa.selenium.By;
public class RetailContent extends Interstitial{
	
	public static By RetailContent_Link() {
		return CommonDef.locatorValue(Locators.XPATH, "//span[contains(.,'Manage Retail Contents')]");
	}
	public static By RetailContent_EditMessage(String messageID) {
		return CommonDef.locatorValue(Locators.XPATH, "//span[contains(.,'"+messageID+"')]/following::td[2]/div/button");
	}
	public static By RetailContent_Content() {
		return CommonDef.locatorValue(Locators.ID, "QUE_D59DDA56C98AD00712199");
	}
	public static By RetailContent_Comments() {
		return CommonDef.locatorValue(Locators.ID, "QUE_D59DDA56C98AD00712262");
	}
	public static By RetailContent_Save() {
		return CommonDef.locatorValue(Locators.ID, "BUT_49988DAD7DAA18F618839");
	}	
	public static By RetailContent_SuccessMessage() {
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='p1_HEAD_49988DAD7DAA18F628836']/div[contains(.,'content value')]");
	}	
}
