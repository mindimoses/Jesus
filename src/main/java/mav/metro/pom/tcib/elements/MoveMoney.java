package mav.metro.pom.tcib.elements;

import java.sql.Connection;
import java.util.HashMap;

import mav.metro.library.functions.CommonDef;
import mav.metro.utilities.enums.Locators;

import org.openqa.selenium.By;


public class MoveMoney extends BasePage{
	
	public static By makepayment_menu() {
		return CommonDef.locatorValue(Locators.ID, "BUT_AA76E5E393F0103923800");		
	}
	public static By movemoney_button() {
		return CommonDef.locatorValue(Locators.ID, "MOVE_MONEY_BUTTON");		
	}
	public static By movemoney_amount() {
		return CommonDef.locatorValue(Locators.ID, "QUE_D95409D004C922E0390481");		
	}
	public static By movemoney_From() {
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='QUE_635613178EB252CF23202_chzn']/a/div/b");		
	}
	public static By movemoney_ToProfile() {
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='MAKEAPAY_ENTITY_chzn']/a/div/b");		
	}
	public static By movemoney_ToAccount() {
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='QUE_635613178EB252CF23226_chzn']/a/div/b");		
	}
	public static By movemoney_FromTab() {
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='FMT_757E8DDD8ACC7AF8413658']/legend");		
	}
	public static By movemoney_ToTab() {
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='FMT_757E8DDD8ACC7AF8416808']/legend");		
	}
	/*public static By movemoney_From() {
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='QUE_635613178EB252CF23202_chzn']/a/span");		
	}
	public static By movemoney_ToProfile() {
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='MAKEAPAY_ENTITY_chzn']/a/span");		
	}
	public static By movemoney_ToAccount() {
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='QUE_635613178EB252CF23226_chzn']/a/span");		
	}*/
	public static By regular_start() {
		return CommonDef.locatorValue(Locators.XPATH, "//label[contains(.,'The first payment starting...')]/parent::div/parent::div/following-sibling::div//button[@class='ui-datepicker-trigger']");		
	}
	public static By regular_frequency() {
		return CommonDef.locatorValue(Locators.ID, "QUE_635613178EB252CF23344");		
	}
	
	public static By regular_end() {
		return CommonDef.locatorValue(Locators.XPATH, "//label[contains(.,'And continue until')]/parent::div/parent::div/following-sibling::div//button[@class='ui-datepicker-trigger']");		
	}
	public static By regular_untilfurther() {
		return CommonDef.locatorValue(Locators.ID, "QUE_635613178EB252CF23363_0");		
	}
	public static By future_date() {
		return CommonDef.locatorValue(Locators.XPATH, "//label[contains(.,'Pay at a future date')]/parent::div/parent::div/following-sibling::div//button[@class='ui-datepicker-trigger']");		
	}	
	public static By success_message() {
		return CommonDef.locatorValue(Locators.XPATH, "//h3[contains(.,'Your payment has been completed')]");		
	}
	
	public static By success_regularpayment() {
		return CommonDef.locatorValue(Locators.XPATH, "//h3[contains(.,'Success! Your Regular Payment has been setup')]");		
	}
	public static By Account_summary() {
		return CommonDef.locatorValue(Locators.ID, "BUT_873509E30FE55906298033");		
	}	
	public static By Recent_transcations() {
		return CommonDef.locatorValue(Locators.ID, "TAB_84CA218887C7452326178");		
	}	
	public static By Regular_payment() {
		return CommonDef.locatorValue(Locators.ID, "TAB_7DBA9120F8BEF939288337");		
	}
	
	

	
	
	
	
	/*public static By movemoney_From() {
		return CommonDef.locatorValue(Locators.ID, "QUE_635613178EB252CF23202_chzn");		
	}
	public static By movemoney_ToProfile() {
		return CommonDef.locatorValue(Locators.ID, "MAKEAPAY_ENTITY_chzn");		
	}
	public static By movemoney_ToAccount() {
		return CommonDef.locatorValue(Locators.ID, "QUE_635613178EB252CF23226_chzn");		
	}
	*/
	public static By paynow_button() {
		return CommonDef.locatorValue(Locators.XPATH, "//em[contains(.,'Pay now')]");		
	}
	public static By regularpayment_button() {
		return CommonDef.locatorValue(Locators.XPATH, "//em[contains(.,'Make this a Regular Payment')]");		
	}
	public static By futuredate_button(){
		return CommonDef.locatorValue(Locators.XPATH, "//em[contains(.,'Pay at a future date')]");		
	}
	
	public static By continue_button() {
		return CommonDef.locatorValue(Locators.XPATH, "//button[@value='Continue']");
	}
	public static By makepayment_button() {
		return CommonDef.locatorValue(Locators.XPATH, "//button[@value='Make the Payment']");
	}
	
}
	
