package mav.metro.pom.elements;

import mav.metro.library.functions.CommonDef;
import mav.metro.utilities.enums.Locators;
import org.openqa.selenium.By;

public class LoginDemo {
	
	public static By login_popup(){
		return CommonDef.locatorValue(Locators.XPATH, "//div[@title='Close']");
	}
	
	public static By login_username(){
		return CommonDef.locatorValue(Locators.XPATH,"//input[@name='UserId']");		
	}
	
	public static By login_password(){
		return CommonDef.locatorValue(Locators.XPATH,"//input[@name='Password']");		
	}
	
	public static By login_Secno1(){
		return CommonDef.locatorValue(Locators.XPATH,"//select[@name='Character0']");		
	}
	
	public static By login_Secno2(){
		return CommonDef.locatorValue(Locators.XPATH,"//select[@name='Character1']");		
	}
	
	public static By login_Secno3(){
		return CommonDef.locatorValue(Locators.XPATH,"//select[@name='Character2']");		
	}
	
	public static By login_buttonsubmit(){
		return CommonDef.locatorValue(Locators.XPATH,"//a[@id='submitlink']/img");		
	}
	
	public static By Link_Navigate_RetailIB(){
		return CommonDef.locatorValue(Locators.XPATH,"//span[.='PERSONAL LOGIN']");		
	}
	
	public static By Link_Navigate_HomePage(){
		return CommonDef.locatorValue(Locators.XPATH,"//a/span[.='Home']");		
	}
	
	public static By Link_Navigate_StoreLocator(){
		return CommonDef.locatorValue(Locators.XPATH,"//a/span[.='Our Stores']");		
	}
	
	public static By Link_ForgotPwd(){
		return CommonDef.locatorValue(Locators.XPATH,"//a[contains(.,'Forgotten your password?')]");		
	}
	
	public static By Link_ForgotSecNo(){
		return CommonDef.locatorValue(Locators.XPATH,"//a[contains(.,'Forgotten your Security Number?')]");		
	}
	
	public static By validation_HomeLoginbtn(){
		return CommonDef.locatorValue(Locators.XPATH,"//button[.='Login']");		
	}
	
	public static By validation_RIBPage(){
		return CommonDef.locatorValue(Locators.CSS,".welcome-message");		
	}
	
	public static By validation_StorePage(){
		return CommonDef.locatorValue(Locators.XPATH,"//div[@class='header-container']//a[contains(.,'Store Locator')]");		
	}
	
	public static By validation_LoginFail(){
		return CommonDef.locatorValue(Locators.XPATH,"//td[contains(.,'Log in unsuccessful')]");		
	}		
	
	public static By validation_forgpasslink(){
		return CommonDef.locatorValue(Locators.XPATH, "//a[.='Your password']");
	}
	
	public static By validation_forgseclink(){
		return CommonDef.locatorValue(Locators.XPATH, "//a[.='Your security number']");
	}
}
