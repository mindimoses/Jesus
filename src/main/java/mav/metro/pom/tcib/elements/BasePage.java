package mav.metro.pom.tcib.elements;

import mav.metro.library.functions.CommonDef;
import mav.metro.utilities.enums.Locators;
import org.openqa.selenium.By;

public class BasePage {
	
	public static By calender_year()
	{
		return CommonDef.locatorValue(Locators.CLASS_NAME, "ui-datepicker-year");
	}
	
	public static By calender_month()
	{
		return CommonDef.locatorValue(Locators.CLASS_NAME, "ui-datepicker-month");
	}
	
	
	public static By profile_menu() {
		return CommonDef.locatorValue(Locators.XPATH, ".//*[@id='QUE_A5FBC89B03D2A21F560672_chzn']/a/span");
	}
	
	public static By mob_Mainmenu() {
		return CommonDef.locatorValue(Locators.CSS, "button.mb-company-selector_menu-toggle");
	}

	public static By LoginNavDesktop() {
		return CommonDef.locatorValue(Locators.CSS, ".navbar-collapse ul.navbar-nav");
	}

	public static By mob_Headermenu() {
		return CommonDef.locatorValue(Locators.CSS, "button.toggler-navigation");
	}

	public static By calendarRows() {
		return CommonDef.locatorValue(Locators.CSS, "div[ng-switch] tr[ng-repeat]");
	}

	public static By calendarActiveDates() {
		return CommonDef.locatorValue(Locators.CSS,
				"div[ng-switch] tr[ng-repeat] td[aria-disabled='false'] > button:not([disabled])");
	}

	public static By calendarActiveDatesSOPayDate() {
		return CommonDef.locatorValue(Locators.CSS,
				"section.payment-date div[ng-switch] tr[ng-repeat] td[aria-disabled='false'] > button");
	}

	public static By totalRows() {
		return CommonDef.locatorValue(Locators.CSS, "div[ng-switch] tr[ng-repeat]");
	}

	public static By totalRowsSOPayDate() {
		return CommonDef.locatorValue(Locators.CSS, "section.payment-date div[ng-switch] tr[ng-repeat]");
	}

	public static By calendarActiveDatesLastRow(int lastindex) {
		return CommonDef.locatorValue(Locators.CSS, "div[ng-switch] tr[ng-repeat]:nth-child(" + lastindex
				+ ") td[aria-disabled='false'] > button:not([disabled])");
	}

	public static By calendarActiveDatesLastRowSOPayDate(int lastindex) {
		return CommonDef.locatorValue(Locators.CSS, "section.payment-date div[ng-switch] tr[ng-repeat]:nth-child("
				+ lastindex + ") td[aria-disabled='false'] > button");
	}

	public static By Btn_DateFwdMonthSOPayDate() {
		return CommonDef.locatorValue(Locators.CSS, "section.payment-date div[ng-switch] button.pull-right");
	}

	public static By Btn_DateFwdMonthSOEndDate() {
		return CommonDef.locatorValue(Locators.CSS, "section.payment-schedule div[ng-switch] button.pull-right");
	}

	public static By calendarActiveDatesLastRowSOEndDate(int lastindex) {
		return CommonDef.locatorValue(Locators.CSS, "section.payment-schedule div[ng-switch] tr[ng-repeat]:nth-child("
				+ lastindex + ") td[aria-disabled='false'] > button");
	}

	public static By totalRowsSOEndDate() {
		return CommonDef.locatorValue(Locators.CSS, "section.payment-schedule div[ng-switch] tr[ng-repeat]");
	}

	public static By calendarActiveDatesSOEndDate() {
		return CommonDef.locatorValue(Locators.CSS,
				"section.payment-schedule div[ng-switch] tr[ng-repeat] td[aria-disabled='false'] > button");
	}

	public static By Btn_DateSOPayDate() {
		return CommonDef.locatorValue(Locators.CSS, "section.payment-date span.calendar-icon");
	}

	public static By Btn_DateSOEndDate() {
		return CommonDef.locatorValue(Locators.CSS, "section.payment-schedule span.calendar-icon");
	}

	public static By Lnk_PaymentsMsg() {
		return CommonDef.locatorValue(Locators.XPATH, "//span[@class='message ng-binding']/p");
	}

	public static By dateActiveMonth() {
		return CommonDef.locatorValue(Locators.CSS, "div.date-picker strong.ng-binding");
	}
	
	public static By accSummLoad() {
		return CommonDef.locatorValue(Locators.CSS, ".met-account-summary");
	}
}
