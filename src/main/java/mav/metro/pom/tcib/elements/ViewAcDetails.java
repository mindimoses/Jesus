package mav.metro.pom.tcib.elements;

import org.openqa.selenium.By;

import mav.metro.library.functions.CommonDef;
import mav.metro.utilities.enums.Locators;



public class ViewAcDetails {
	
	public static By ViewAc_Recent()
	{
		return CommonDef.locatorValue(Locators.ID, "TAB_84CA218887C7452326178");
	}
	public static By ViewAc_TransactionProcessed()
	{
		return CommonDef.locatorValue(Locators.ID, "TAB_24036ACA29E10CE3700189");
	}
	public static By ViewAc_UpComing()
	{
		return CommonDef.locatorValue(Locators.ID, "TAB_84CA218887C7452326230");
	}
	public static By ViewAc_RegularPayments()
	{
		return CommonDef.locatorValue(Locators.ID, "TAB_7DBA9120F8BEF939288337");
	}
	
	public static By ViewAc_UsefulAccount()
	{
		return CommonDef.locatorValue(Locators.ID, "TAB_84CA218887C7452326237");
	}
	
	public static By ViewAc_OrderChequeLink()
	{
		return CommonDef.locatorValue(Locators.LINKTEXT, "Order a new cheque book");
	}
	public static By ViewAc_CancelChequeLink()
	{
		return CommonDef.locatorValue(Locators.LINKTEXT, "Cancel cheque book");
	}
	public static By ViewAc_ViewExchangeRates()
	{
		return CommonDef.locatorValue(Locators.LINKTEXT, "View the current exchange rates");
	}
	
	public static By ViewAc_ChequeSelectAc()
	{
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='QUE_E7F4E68E641309F7351278_chzn']/a/span");
	}
	public static By ViewAc_OrderCheque()
	{
		return CommonDef.locatorValue(Locators.ID, "BUT_2705B8ADA586593C520515");
	}
	public static By ViewAc_ChequeSuccessful()
	{
		return CommonDef.locatorValue(Locators.XPATH, "//em[contains(.,'We have been')]");
	}
	
	public static By ViewAc_CancelCheque()
	{
		return CommonDef.locatorValue(Locators.ID, "BUT_FCD873D8DDFC27DF1575346");
	}
	
	public static By ViewAc_DownloadTranscations()
	{
		return CommonDef.locatorValue(Locators.ID, "BUT_81752B75369FA043129962");
	}
	//R9
	
	public static By ViewAc_SearchTranscations()
	{
		return CommonDef.locatorValue(Locators.ID, "BUT_SEACH_TX");
	}
	
	public static By Search_MetroBank()
	{
		return CommonDef.locatorValue(Locators.ID, "QUE_0CCB45AD05D277F0104546_0");
	}
	
	public static By Search_SearchTranscations()
	{
		return CommonDef.locatorValue(Locators.ID, "SEARCH_TX");
	}
	
}
