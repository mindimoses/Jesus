package mav.metro.pom.functions;

import com.relevantcodes.extentreports.LogStatus;
import mav.metro.framework.ExReporter;
import mav.metro.framework.TestData;
import mav.metro.library.functions.CommonDef;
import mav.metro.pom.elements.BeneficiaryGroup;

public class BeneficiaryGroupFns {
	
	public static void BeneficiaryGroup() {
		try{
		CommonDef.click(BeneficiaryGroup.bengrp_link(),"Beneficiry Link");
		CommonDef.click(BeneficiaryGroup.bengrp_batchLink(), "Batch payment Group");
		CommonDef.click(BeneficiaryGroup.bengrp_create(),"Create Beneficiary Group ");
		CommonDef.findElement(BeneficiaryGroup.bengrp_title()).sendKeys(TestData.getConfig("Title"));
		CommonDef.click(BeneficiaryGroup.bengrp_addBeneficiary(),"Add beneficiary");
		CommonDef.click(BeneficiaryGroup.bengrp_selectBeneficiary(),"Select beneficiary");
		CommonDef.click(BeneficiaryGroup.bengrp_create(),"Create button");
		CommonDef.click(BeneficiaryGroup.bengrp_close(),"close button");
		}
		catch (Exception E) {
			ExReporter.log(LogStatus.FAIL, "Beneficiary Group can not be created");			
		}
		
	}
}

