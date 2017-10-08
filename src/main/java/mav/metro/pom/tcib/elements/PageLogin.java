package mav.metro.pom.tcib.elements;

import mav.metro.library.functions.CommonDef;
import mav.metro.utilities.enums.Locators;

import org.openqa.selenium.By;

public class PageLogin {

	public static By PageLogin_FSCS() {
		return CommonDef.locatorValue(Locators.XPATH, "//p[contains(.,'Your eligible deposits with Metro Bank PLC are protected up')]");
	}
	
	
}
