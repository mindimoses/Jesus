package mav.metro.pom.tcib.functions;

import mav.metro.framework.ExReporter;
import mav.metro.framework.TestData;
import mav.metro.library.functions.CommonDef;
import mav.metro.library.functions.MethodDef;
import mav.metro.pom.tcib.elements.*;

import com.relevantcodes.extentreports.LogStatus;

public class ViewAcDetailsFns {	
	//View Account details Functionality 
	public static void ViewAcDetails(String customertype){
	ExReporter.log(LogStatus.INFO, "View Account Details");
	try {
		if (!customertype.startsWith("Only"))
		{
		BasePageFns.profileChange(TestData.getConfig("ProfileName"));	
		}
		BasePageFns.AcDetails(PaymentAcDetails.PayAcDetails_ViewAc(),PaymentAcDetails.PayAcDetails_AccountNo(), TestData.getConfig("Account_No"));
		
		if (TestData.getConfig("Select_Action").equals("Recent_Transcations"))
		{
			MethodDef.clickJS(ViewAcDetails.ViewAc_TransactionProcessed(), "Transcations Processed");
			MethodDef.clickJS(ViewAcDetails.ViewAc_Recent(), "Recent Transcations");
			if (TestData.getConfig("SubAction").equals("Search Transcations"))
			{			
				MethodDef.click(ViewAcDetails.ViewAc_SearchTranscations(), "search transcations button");	
				CommonDef.Wait();
				MethodDef.clickJS(ViewAcDetails.Search_MetroBank(), "Value");
				CommonDef.Wait();
				MethodDef.clickJS(ViewAcDetails.Search_SearchTranscations(), "Search trasctions button");
				CommonDef.Wait();
				MethodDef.clickJS(ViewAcDetails.ViewAc_DownloadTranscations(), "Download Transcations");
				CommonDef.Wait();
				ExReporter.log(LogStatus.PASS, "Transcations Search and Download");
			}
			
		}
		else if (TestData.getConfig("Select_Action").equals("TransactionBeingProcessed"))
		{
			MethodDef.clickJS(ViewAcDetails.ViewAc_TransactionProcessed(), "Transcations Processed");
			ExReporter.log(LogStatus.PASS, "Transcations Processed");
		}
		else if (TestData.getConfig("Select_Action").equals("Upcoming_Payments"))
		{
			MethodDef.clickJS(ViewAcDetails.ViewAc_UpComing(), "Upcoming Payments");
			ExReporter.log(LogStatus.PASS, "Upcoming Payments");
		}
		else if (TestData.getConfig("Select_Action").equals("Regular_Payments"))
		{
			MethodDef.clickJS(ViewAcDetails.ViewAc_RegularPayments(), "Regular Payments");
			ExReporter.log(LogStatus.PASS, "Regular Payments");
		}		
		else if (TestData.getConfig("Select_Action").equals("Order_ChequeBook"))
		{
			MethodDef.clickJS(ViewAcDetails.ViewAc_UsefulAccount(), "Useful Account Tab");
			MethodDef.clickJS(ViewAcDetails.ViewAc_OrderChequeLink(), "Order a cheque book");
			MethodDef.click(ViewAcDetails.ViewAc_OrderCheque(), "Cheque book button");
			MethodDef.assertElemsContains(ViewAcDetails.ViewAc_ChequeSuccessful(), TestData.getConfig("SuccessMessage"));			
		}
		else if (TestData.getConfig("Select_Action").equals("Cancel_ChequeBook"))
		{
			MethodDef.clickJS(ViewAcDetails.ViewAc_UsefulAccount(), "Useful Account Tab");
			MethodDef.clickJS(ViewAcDetails.ViewAc_CancelChequeLink(), "Cancel a cheque book");
			ExReporter.log(LogStatus.PASS, "cheque book");
		}
		
		else if (TestData.getConfig("Select_Action").equals("View_ExchangeRates"))
		{
			MethodDef.clickJS(ViewAcDetails.ViewAc_UsefulAccount(), "Useful Account Tab");
			MethodDef.clickJS(ViewAcDetails.ViewAc_ViewExchangeRates(), "View Exchange Rates");
			ExReporter.log(LogStatus.PASS, "View Exchange Rates");
		}		
		else if (TestData.getConfig("Select_Action").equals("Download_Transactions"))
		{
			MethodDef.clickJS(ViewAcDetails.ViewAc_DownloadTranscations(), "Download Transcations");
			ExReporter.log(LogStatus.PASS, "Download Transcations");
					
		}
	}
	catch (Exception e) {
		ExReporter.log(LogStatus.ERROR, "Error in performing View AC details Function");
	}
}

}
