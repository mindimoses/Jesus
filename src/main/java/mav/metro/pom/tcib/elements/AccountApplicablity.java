package mav.metro.pom.tcib.elements;
import mav.metro.library.functions.CommonDef;
import mav.metro.utilities.enums.Locators;
import org.openqa.selenium.By;

public class AccountApplicablity {
	public static By AccAppli_AdminLink() {
		return CommonDef.locatorValue(Locators.ID, "BUT_420E07161E0F21C79313");
	}
	public static By AccAppli_AppliLink() {
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='BUT_3F39B16CB80277829436']/span");
	}
	public static By AccAppli_TabSelect(String AccType) {
		return CommonDef.locatorValue(Locators.XPATH, "//li//a[contains(.,'"+ AccType +"')]");
	}
	public static By AccAppli_RetailTab() {
		return CommonDef.locatorValue(Locators.XPATH, "//li[@id='1']/a");
	}
	
	public static By AccAppli_SMETab() {
		return CommonDef.locatorValue(Locators.XPATH, "//li[@id='2']/a");
	}
	
	public static By AccAppli_AccountSelection() {
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='QUE_1A50E3265E1897E91575_chzn']/a/div/b");
	}
	
	public static By AccAppli_SelectOption() {
		return CommonDef.locatorValue(Locators.XPATH, "//span[contains(.,'Select an Option')]");
	}
	public static By AccAppli_AccType() {
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='chzn-search']/input[@type='text']");
	}
	
	public static By AccAppli_MakePayment() {
		return CommonDef.locatorValue(Locators.ID, "FMT_42BB3786284398EA124269");
	}
	
	public static By AccAppli_ProductClassification() {
		return CommonDef.locatorValue(Locators.ID, "FMT_0113D5C7D8DFA00211598");
	}
	public static By AccAppli_OpenNewProducts() {
		return CommonDef.locatorValue(Locators.ID, "FMT_42BB3786284398EA124319");
	}
	public static By AccAppli_ProdClassifi() {
		return CommonDef.locatorValue(Locators.ID, "QUE_0113D5C7D8DFA00211605");
	}
	public static By AccAppli_ProdDescription() {
		return CommonDef.locatorValue(Locators.ID, "QUE_0113D5C7D8DFA00211606");
	}
	public static By AccAppli_Add() {
		return CommonDef.locatorValue(Locators.ID, "BUT_0113D5C7D8DFA00211609");
	}
	public static By AccAppli_Save() {
		return CommonDef.locatorValue(Locators.ID, "BUT_C71FF177B69964819779");
	}
	public static By AccAppli_Update() {
		return CommonDef.locatorValue(Locators.ID, "BUT_0113D5C7D8DFA00211610");
	}
	
	public static By AccAppli_SuccessMessage() {
		return CommonDef.locatorValue(Locators.XPATH, "//em[contains(.,'Successfully updated applicability')]");
	}
	
	public static By AccAppli_EditProduct(String Product) {
		return CommonDef.locatorValue(Locators.XPATH, "//span[.='"+Product+"']/following::td[2]/div/button");
	}
	public static By AccAppli_RemoveProduct(String Product) {
		return CommonDef.locatorValue(Locators.XPATH, "//span[.='"+Product+"']/following::td[3]/div/button");
	}
}
