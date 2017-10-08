package mav.metro.pom.tcib.elements;

import mav.metro.library.functions.CommonDef;
import mav.metro.utilities.enums.Locators;

import org.openqa.selenium.By;
public class Help {
	public static By Help_Link() {
		return CommonDef.locatorValue(Locators.ID, "BUT_AA76E5E393F0103923809");
	}
	
	public static By Help_BacktoHome() {
		return CommonDef.locatorValue(Locators.ID, "BUT_AF72280793A3D01E366408");
	}
	
	public static By Help_OurStores() {
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='BUT_2FAEAD07F191F071923808_R11']/span");
	}
	
	public static By Help_NominatedBeneficiary() {
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='BUT_2FAEAD07F191F071923808_R12']/span");
	}
	
	public static By Help_Backtotopics(){
		return CommonDef.locatorValue(Locators.XPATH, "//span[contains(.,'Back to topics')]");
	}
	
	public static By Help_NominatedWhat() {
		return CommonDef.locatorValue(Locators.ID, "BUT_CBD2B2A455BE7668343673_R1");
	}
	
	public static By Help_LinkNominated() {
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='BUT_2FAEAD07F191F071923808_R12']/span[contains(.,'Nominated Beneficiary')]");
	}
	
	public static By Help_ContentNominated() {
		return CommonDef.locatorValue(Locators.XPATH, "//h2[contains(.,'Nominated Beneficiary')]");
	}
	public static By Help_ContentTopicsNomin() {
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='p1_HEAD_D6ED71CFD480CFC0342956']/div[contains(.,'Topics within Nominated Beneficiary')]");
	}
	
	public static By Help_ManagePayees() {
		return CommonDef.locatorValue(Locators.XPATH, "//span[contains(.,'MANAGE PAYEES')]");
	}
	public static By Help_ContentOurStores() {
		return CommonDef.locatorValue(Locators.XPATH, "//h2[contains(.,'Our Stores')]");
	}
	
	public static By Help_TabOurStores() {
		return CommonDef.locatorValue(Locators.ID, "TAB_CBD2B2A455BE7668343787");
	}
	
	public static By Help_TabNominatedBene() {
		return CommonDef.locatorValue(Locators.ID, "TAB_CBD2B2A455BE7668343870");
	}
	
}
