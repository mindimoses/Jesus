package mav.metro.pom.functions;

import com.relevantcodes.extentreports.LogStatus;
import mav.metro.framework.ExReporter;
import mav.metro.library.functions.CommonDef;
import mav.metro.library.functions.MethodDef;
import mav.metro.pom.elements.DirectDebit;
import mav.metro.pom.elements.FXRates;
import mav.metro.pom.elements.MyAccounts;
import org.openqa.selenium.WebElement;

public class FXRatesFns {

	public static void FXRates() {
		try {
			ExReporter.log(LogStatus.INFO, "FX Rates Page");
			CommonDef.waitVisibleNoError(FXRates.Validation_FXRates_For_Payments_TableView());
			CommonDef.isDisplayed(FXRates.Validation_FXRates_For_Payments_TableView(),
					"FX Rates for Payments Table available");
			MethodDef.clickJS(FXRates.Tab_FXRates_For_Cash(), "FX Rates for Cash Tab Clicked");
			CommonDef.waitVisibleNoError(FXRates.Validation_FXRates_For_Cash_TableView());
			CommonDef.isDisplayed(FXRates.Validation_FXRates_For_Cash_TableView(), "FX Rates for Cash Table available");
			for ( WebElement web : CommonDef.findElements(FXRates.tableValues())) 
				CommonDef.assertContainsData(web, "Data Elements");
		} catch (Exception E) {
			ExReporter.log(LogStatus.FAIL, "FX Rates Validation failed" + E.getMessage());
		}
	}

	public static void navToFXRates() {
		try {
			CommonDef.isDisplayed(MyAccounts.Validation_MyAccountsPage1(), "MyAccounts Page Displayed");
			MethodDef.click(DirectDebit.Link_Payments_Arrow(), "Payments & Transfers Arrow Clicked");
			MethodDef.clickJS(FXRates.Link_FXRates(), "FX Rates Link Clicked");
			CommonDef.isDisplayed(FXRates.Validation_FXRates_Page(), "FX Rates Page available");
		} catch (Exception E) {
			ExReporter.log(LogStatus.FAIL, "FX Rates Page is not loaded properly" + E.getMessage());
		}
	}
}
