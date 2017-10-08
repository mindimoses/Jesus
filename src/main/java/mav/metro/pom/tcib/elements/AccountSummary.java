package mav.metro.pom.tcib.elements;


import org.openqa.selenium.By;

import mav.metro.library.functions.CommonDef;
import mav.metro.utilities.enums.Locators;
public class AccountSummary {
	public static By AccountSummary_EditLink()
	{
		return CommonDef.locatorValue(Locators.ID, "BUT_0936EF1D3ED8C8E961607");
	}
	public static By AccountSummary_EditContent()
	{
		return CommonDef.locatorValue(Locators.ID, "QUE_CB4A0A952696618F596531");
	}
	public static By AccountSummary_Save()
	{
		return CommonDef.locatorValue(Locators.ID, "BUT_0936EF1D3ED8C8E961658");
	}
	public static By AccountSummary_ErrorMessage()
	{
		return CommonDef.locatorValue(Locators.ID, "QUE_CB4A0A952696618F596531_ERRORMESSAGE");
	}
	
		
}
