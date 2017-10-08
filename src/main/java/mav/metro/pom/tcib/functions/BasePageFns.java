package mav.metro.pom.tcib.functions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.support.ui.Select;

import mav.metro.library.functions.*;
import mav.metro.pom.tcib.elements.*;
import mav.metro.driver.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BasePageFns extends RemoteWebDriver {
	public static void profileChange(String profileName) throws InterruptedException {	
	MethodDef.click(BasePage.profile_menu(), "elemname");	
	CommonDef.Wait();
	WebDriver driver = DriverFactory.getCurrentDriver();	
	new Actions(driver).sendKeys(profileName).perform();
	CommonDef.Wait();	
	Keyboard kb = ((RemoteWebDriver) driver).getKeyboard();	
	kb.pressKey(Keys.ENTER);		
	}
	
	public static void selectItem(By selectmenu, String Account) throws InterruptedException {
	//MethodDef.SetFocus(selectmenu);
	MethodDef.click(selectmenu,"elemname");	
	CommonDef.Wait();
	WebDriver driver = DriverFactory.getCurrentDriver();	
	new Actions(driver).sendKeys(Account).perform();
	CommonDef.Wait();
	Keyboard kb = ((RemoteWebDriver) driver).getKeyboard();	
	kb.pressKey(Keys.ENTER);		
	}
	
	
	public static void selectLink(By selectmenu,String Account)
	{	
	WebDriver driver = DriverFactory.getCurrentDriver();
	List<WebElement> Links = driver.findElements(selectmenu);
	for (int i = 0; i < Links.size(); i++) {
		if(Account.equals(Links.get(i).getText())){
			int k = i+1;
			MethodDef.clickJS(PayeeManagement.PayMag_PayeeAction(k), "Element");
			//driver.findElement(By.xpath(".//*[@id='BUT_AD37C880EFD87446492974_R" + k + "']")).click();
			break;
			}
		}	
	}
	public static void selectMessage(By selectmenu,String Account)
	{	
	WebDriver driver = DriverFactory.getCurrentDriver();
	List<WebElement> Links = driver.findElements(selectmenu);
	for (int i = 1; i < Links.size(); i++) {
		if(Account.equals(Links.get(i).getText())){
			int k = i+1;
			MethodDef.click(Messages.Messages_CheckBoxMessage(k), "Check Element");
			//driver.findElement(By.xpath(".//*[@id='BUT_AD37C880EFD87446492974_R" + k + "']")).click();
			break;
			}
		}	
	}
	
	public static void selectNewMessage(By selectmenu,String Account) throws InterruptedException
	{	
	WebDriver driver = DriverFactory.getCurrentDriver();
	List<WebElement> Links = driver.findElements(selectmenu);
	for (int i = 1; i < Links.size(); i++) {
		if(Account.equals(Links.get(i).getText())){
			int k = i+1;
			MethodDef.click(Messages.Messages_CheckBoxMessage(k), "Check Element");
			CommonDef.Wait();
			MethodDef.click(Messages.Messages_Inboxview(k), "Select Element");
			//driver.findElement(By.xpath(".//*[@id='BUT_AD37C880EFD87446492974_R" + k + "']")).click();
			break;
			}
		}	
	}
	
	public static void selectRegulars(By selectmenu,By othermenu,String Account)
	{	
	WebDriver driver = DriverFactory.getCurrentDriver();
	List<WebElement> Links = driver.findElements(selectmenu); 
	for (int i = 0; i < Links.size(); i++) {
		if(Account.equals(Links.get(i).getText())){
			int k = i+1;		
			//MethodDef.clickJS(othermenu(k),"Account Details Element");
			MethodDef.clickJS(PaymentAcDetails.PayAcDetails_ActionClick(k),"Account Details Element");
			//driver.findElement(By.xpath(".//*[@id='BUT_7FE2A5B2D9DF8623546054_R" + k + "']")).click();
			break;
			}
		}	
	}
	public static void selectRegular(By selectmenu,String Account)
	{	
	WebDriver driver = DriverFactory.getCurrentDriver();
	List<WebElement> Links = driver.findElements(selectmenu); 
	for (int i = 1; i < Links.size(); i++) {
		if(Account.equals(Links.get(i).getText())){
			//int k = i+1;			
			MethodDef.clickJS(PaymentAcDetails.PayAcDetails_ActionClick(i),"Account Details Element");			
			break;
			}
		}	
	}
	/*public static void selectRegulars(By selectmenu,String Account)
	{	
	WebDriver driver = DriverFactory.getCurrentDriver();
	List<WebElement> Links = driver.findElements(selectmenu); 
	for (int i = 0; i < Links.size(); i++) {
		if(Links.get(i).getText().equals(Account)){
			int k = i+1;			
			MethodDef.clickJS(PaymentAcDetails.PayAcDetails_ActionClick(k),"Account Details Element");			
			break;
			}
		}	
	}
	*/

	public static void AcDetails(By ViewMenu, By SelectAccount, String Account) throws Exception // Object value
	{
		MethodDef.clickJS(ViewMenu, "View Ac Details");
		WebDriver driver = DriverFactory.getCurrentDriver();
		List<WebElement> Links = driver.findElements(SelectAccount);	
		for (int i = 0; i < Links.size(); i++) {
			if(Links.get(i).getText().equals(Account)){	
				Links.get(i).click();	
				break;
			}
		}
	}
	
	public static void FDate(String Name) throws Exception
	{
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();		
		String[] DteFormat = dateFormat.format(cal.getTime()).split("/");
		String V1 = Name;
        String[] UserDate = V1.split("/");
        
        String v6 = UserDate[0];
        int v7 = Integer.parseInt(v6);
        
        String v8 = UserDate[1];
        int v9 = Integer.parseInt(v8);
        
        String v10 = UserDate[2];
        int v11 = Integer.parseInt(v10);
        
        String v4 = DteFormat[2];
        int v5 = Integer.parseInt(v4);
        int year = v5 + v11;
        String str = Integer.toString(year);
               
        WebDriver driver = DriverFactory.getCurrentDriver();        
        WebElement elementYear = driver.findElement(By.className("ui-datepicker-year"));
        Select objyear = new Select(elementYear);
        objyear.selectByVisibleText(str);
       // WebElement syear = findElement(BasePage.calender_year());
       // Select objyear = new Select((WebElement) BasePage.calender_year()); 
       
        String[] Mnth = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        String v2 = DteFormat[1];
        int v3 = Integer.parseInt(v2);
        String SelectMnth = Mnth[v3 - 1 + v9];
        WebElement SelectMn = driver.findElement(By.className("ui-datepicker-month"));
        Select objmonth = new Select(SelectMn);
        objmonth.selectByVisibleText(SelectMnth);
        
        // WebElement smonth= findElement(BasePage.calender_month());
        //Select obj = new Select((WebElement) BasePage.calender_month());
        
        //Date
        int v12 = Integer.parseInt(DteFormat[0]);
        int Dte = v12 + v7;
        String Dtenew = Integer.toString(Dte);
       driver.findElement(By.linkText(Dtenew)).click();
        
	}

	/*public void NegativeScn(String TestDataBinder)
	{
		String Binder[] = TestDataBinder.split("_");
		for (int i = 0; i < Binder.length; i++) {
			if(Binder[i].equals("Negative")){
				ResultStatus ="Negative-Pass";
				break;
			}
		}
	}*/
	

}
