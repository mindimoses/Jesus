package mav.metro.pom.elements;

import mav.metro.framework.TestData;
import mav.metro.library.functions.CommonDef;
import mav.metro.utilities.enums.Locators;
import org.openqa.selenium.By;

public class BeneficiaryGroup extends BasePage {
	public static By bengrp_link() {
		return CommonDef.locatorValue(Locators.CSS,
				"div.tab-icon-and-title i.fa-book");
	}

	public static By bengrp_batchLink() {
		return CommonDef.locatorValue(Locators.PARTIAL_LINKTEXT,
				"Batch Payments Groups");
	}

	public static By bengrp_batchButton() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//button[contains(.,'Create Batch Payment Group')]");
	}

	public static By bengrp_title() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//input[@data-label='Please enter a title']");
	}

	public static By bengrp_addBeneficiary() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//button[contains(.,'Add Beneficiaries')]");
	}
	
	public static By bengrp_selectBeneficiary() {
		return CommonDef.locatorValue(Locators.CSS,
				"//div[@class='table-responsive table-scrollable']/table[@class='table "
				+ "table-hover']//td[contains(.,'" + TestData.getConfig("Beneficiary Name")+ "')]/following::td/button");
	}
	public static By bengrp_addSelected() {
		return CommonDef.locatorValue(Locators.XPATH,
				"//a[contains(.,'Add selected')]");
	}

	public static By bengrp_create() {
		return CommonDef.locatorValue(Locators.CSS,
				".btn.btn-primary.pull-right.ng-scope.firefinder-match");
	}

	public static By bengrp_close() {
		return CommonDef.locatorValue(Locators.CSS,
				".lp-lightbox-on button.lp-widget-control.lp-lightbox-close");
	}
}

// div[.='Lightbox Container']//i[@class='lp-icon lp-icon-remove']

// CommonLib.BatchPaymentGroup(TestData.get("Beneficiary Name").toString());
// CommonLib.ListClick("//i[@class='lp-icon lp-icon-remove']",4);
// CommonLib.ListClick("//button[contains(.,'Back')]",1);

