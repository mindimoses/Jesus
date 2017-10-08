package mav.metro.pom.elements;

import mav.metro.library.functions.CommonDef;
import mav.metro.utilities.enums.Locators;
import org.openqa.selenium.By;

public class Mandates extends BasePage {

	public static By Link_Administration() {
		return CommonDef.locatorValue(Locators.XPATH, "//a[@href='/portalserver/administration']");
	}

	public static By Link_Mandates() {
		return CommonDef.locatorValue(Locators.PARTIAL_LINKTEXT, "Mandates");
	}

	// ------------------------------------Create
	// Mandate-----------------------------------
	public static By Btn_Create() {
		return CommonDef.locatorValue(Locators.XPATH, "//div/button[.='Create new']");
	}

	public static By Txt_MandateName() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area active']//input[@name='mandateName']");
	}

	public static By Txt_MandateDesc() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area active']//input[@name='mandateDescription']");
	}

	public static By Txt_MandateAmount(String Type) {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='--area bp-area active']//input[@data-label='" + Type + "']");
	}

	public static By Link_Save() {
		return CommonDef.locatorValue(Locators.CSS,
				"div.create-update-actions > button[type='submit']:not([class*='ng-hide'])");
	}

	public static By mandateResult() {
		return CommonDef.locatorValue(Locators.CSS,
				"div.ng-scope[ng-show='result']:not([class*='ng-hide']) .header-text span");
	}

	public static By mandateResultMessage() {
		return CommonDef.locatorValue(Locators.CSS,
				"div.ng-scope[ng-show='result']:not([class*='ng-hide']) .metro-notification .info p");
	}

	public static By mandateResultHardToken() {
		return CommonDef.locatorValue(Locators.CSS,
				"div.ng-scope[ng-show='result && !modal.hardToken.getToken']:not([class*='ng-hide']) .header-text span");
	}

	public static By mandateResultMessageHardToken() {
		return CommonDef.locatorValue(Locators.CSS,
				"div.ng-scope[ng-show='result && !modal.hardToken.getToken']:not([class*='ng-hide']) .metro-notification .info p");
	}

	public static By Btn_ClosePopup() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@ng-show='result'][@class='ng-scope']/ancestor::div[@data-lightbox-name='errorHandling']//button[@class='close lightbox-close-x']");
	}

	// -------------------------------Amend
	// Mandate-----------------------------------------
	public static By Link_MandateName(String grpname) {
		return CommonDef.locatorValue(Locators.XPATH, "//h3/a[text()='" + grpname + "']");
	}

	public static By Btn_Amend() {
		return CommonDef.locatorValue(Locators.XPATH, "//button[contains(.,'Amend')]");
	}

	// Mandate amt skipped Absolute Xpath
	public static By Btn_Update() {
		return CommonDef.locatorValue(Locators.XPATH, "//span[.='Update']");
	}

	public static By Txt_HardToken() {
		return CommonDef.locatorValue(Locators.CSS,
				"div[ng-show='modal.hardToken.getToken']:not([class*='ng-hide']) input[name='token']");
	}

	public static By Btn_Send() {
		return CommonDef.locatorValue(Locators.CSS,
				"div[ng-show='modal.hardToken.getToken']:not([class*='ng-hide']) div.hardTokenFooter button.btn-primary");
	}

	// ------------------------------------Delete
	// Mandate----------------------------------
	public static By Txt_Delete_MandateName() {
		return CommonDef.locatorValue(Locators.XPATH, "//input[@placeholder='Search for mandate name']");
	}

	public static By Btn_Search() {
		return CommonDef.locatorValue(Locators.XPATH, "//span[.='Search']");
	}

	public static By ChkBox_Delete_MandateName(String grpname) {
		return CommonDef.locatorValue(Locators.XPATH,
				"//a[contains(.,'" + grpname + "')]/ancestor::div[@class='met-list-item']//input[@type='checkbox']");
	}

	public static By Validate_DeleteMandate() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='modal fade in']//span[contains(.,'Are you sure you want to delete these items?')]");
	}

	public static By Txt_HardToken_DeleteMandate() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='modal fade in']//input[@class='form-control ng-pristine ng-valid']");
	}

	public static By Validation_DelMandateSuccess() {
		return CommonDef.locatorValue(Locators.XPATH, "//div[@class='modal fade in']//h5[contains(.,'Successful')]");
	}

	public static By Btn_ClosePopup_DeleteMandate() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//div[@class='modal fade in']/div/div/button[@class='close lightbox-close-x']");
	}

	public static By Btn_Delete() {
		return CommonDef.locatorValue(Locators.XPATH, "//a[contains(.,'Delete item')]");
	}

	public static By Btn_Continue() {
		return CommonDef.locatorValue(Locators.XPATH, "//button[.='Continue']");
	}

}
