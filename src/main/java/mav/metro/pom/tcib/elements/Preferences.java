package mav.metro.pom.tcib.elements;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

import org.openqa.selenium.By;

import mav.metro.library.functions.CommonDef;
import mav.metro.utilities.enums.Locators;



public class Preferences {
	
	public static By Preferences_DetailsMenu()
	{
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='BUT_0CCB45AD05D277F0113670']/span");
		
	}
	public static By Preferences_ChangeDetailsMenu()
	{
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='BUT_0CCB45AD05D277F0113687']/span");
	}
	public static By Preferences_TabPreferences()
	{
		return CommonDef.locatorValue(Locators.ID, "TAB_PREFERENCES");
	}
	public static By Preferences_TabAlerts()
	{
		return CommonDef.locatorValue(Locators.ID, "TAB_ALERTS");
	}
	public static By Preferences_TabXero()
	{
		return CommonDef.locatorValue(Locators.ID, "TAB_XERO");
	}
	public static By Preferences_UserChangeOnline()
	{
		return CommonDef.locatorValue(Locators.ID, "BUT_336F68CAABBCC981305850");
	}

	public static By Preferences_EditUserName()
	{
		return CommonDef.locatorValue(Locators.ID, "QUE_4507F6B2796B3CF7739828");
	}
	public static By Preferences_UserSave()
	{
		return CommonDef.locatorValue(Locators.ID, "BUT_4507F6B2796B3CF7739835");
	}
	public static By Preferences_UserSuccessMessage()
	{
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='p1_HEAD_4507F6B2796B3CF7739903']/div[contains(.,'Your')]");
	}
	
	public static By Preferences_UserStatements(int val1, int val2)
	{
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='p4_QUE_9D3B2AD9595ACCAC477207_R"+val1+"']/div/div/button["+val2+"]");
	}
	public static By Preferences_StatementsSave()
	{
		return CommonDef.locatorValue(Locators.ID, "BUT_4507F6B2796B3CF71077238");
	}
	public static By Preferences_StatementsSuccess()
	{
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='p1_HEAD_29DBAF88412735BE424474']/div[contains(.,'Your account preferences have been updated and are now in effect.')]");
	}
	
	public static By Preferences_UserAlerts (int val1, int val2)
	{
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='p4_QUE_8B35CF671A53A940637599_R"+val1+"']/div/div/button["+val2+"]");
	}
	public static By Preferences_UserThreshold (int val3)
	{
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='QUE_8B35CF671A53A940637626_R"+val3+"']");
	}
	public static By Preferences_AlertsSave ()
	{
		return CommonDef.locatorValue(Locators.ID, "BUT_C6A5E9308BB2E9AD702872");
	}
	
	public static By Preferences_AlertsSuccess()
	{
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='p1_HEAD_0BD3A39D59468718668107']/div[contains(.,'Your account alerts have been updated and are now in effect.')]");
	}
	public static By Preferences_XeroSelect (int val1, int val2)
	{
		return CommonDef.locatorValue(Locators.XPATH, "//*[@id='p4_QUE_24A296B26D0A29C6512259_R"+val1+"']/div/div/button["+val2+"]");
	}
	
	public static By Preferences_CreateXeroContinue ()
	{
		return CommonDef.locatorValue(Locators.ID, "BUT_87F40894C1545C201223686");
	}
	
	public static By Preferences_XeroClick ()
	{
		return CommonDef.locatorValue(Locators.ID, "BUT_0176A3A3F72767B7522492");
	}
	
	public static By Preferences_CreateXeroName()
	{
		return CommonDef.locatorValue(Locators.ID, "QUE_2F24E487575727B9515135");
	}
	public static By Preferences_CreateXeroEmail()
	{
		return CommonDef.locatorValue(Locators.ID, "QUE_2F24E487575727B9515140");
	}
	public static By Preferences_XeroName()
	{
		return CommonDef.locatorValue(Locators.ID, "QUE_BD114EF8B78C1200524412");
	}
	public static By Preferences_XeroEmail()
	{
		return CommonDef.locatorValue(Locators.ID, "QUE_BD114EF8B78C1200524514");
	}
	public static By Preferences_XeroCreeateContinue()
	{
		return CommonDef.locatorValue(Locators.ID, "BUT_2F24E487575727B9515145");
	}
	public static By Preferences_XeroEditLink()
	{
		return CommonDef.locatorValue(Locators.ID, "p4_BUT_0176A3A3F72767B7522492");
	}

	
	public static By Preferences_XeroEdit()
	{
		return CommonDef.locatorValue(Locators.ID, "BUT_BD114EF8B78C1200524056");
	}

	public static By Preferences_XeroEditSuccess()
	{
		return CommonDef.locatorValue(Locators.XPATH, "//em[contains(.,'Your Xero details have been saved successfully')]");
	}
	
	public static By Preferences_XeroClose()
	{
		return CommonDef.locatorValue(Locators.ID, "BUT_92EADC46F59DAE23399830");
	}

	//*[@id='p4_QUE_24A296B26D0A29C6512259_R1']/div/div/button[1]
	
	public static By Preferences_XeroIAgree()
	{
		return CommonDef.locatorValue(Locators.ID, "QUE_BF397F0F4E4CCCAE535553_0");
	}
	public static By Preferences_XeroContinue()
	{
		return CommonDef.locatorValue(Locators.ID, "BUT_DEB56CBCF3DAB5531342250");
	}

	public static By Preferences_XeroSave()
	{
		return CommonDef.locatorValue(Locators.ID, "BUT_67EE3D5DEB555E101331801");
	}

	public static By Preferences_XeroSuccess()
	{
		return CommonDef.locatorValue(Locators.XPATH, "//p[contains(.,'We now need 2 working days to verify your details.')]");
	}
	
	public static By Preferences_XeroAccountSummary()
	{
		return CommonDef.locatorValue(Locators.ID, "BUT_FDF85E9589C29511513067");
	}

}
