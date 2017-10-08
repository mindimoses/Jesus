package mav.metro.pom.tcib.functions;

import mav.metro.driver.DriverFactory;
import mav.metro.framework.ExReporter;
import mav.metro.framework.TestData;
import mav.metro.library.functions.*;
import mav.metro.pom.tcib.elements.Messages;
import mav.metro.pom.tcib.elements.PayeeManagement;

import org.openqa.selenium.WebDriver;









import com.relevantcodes.extentreports.LogStatus;

public class MessagesFns {
	//Messages  Functionality 
	public static void Messages(String customertype){
		WebDriver driver = DriverFactory.getCurrentDriver();		
		ExReporter.log(LogStatus.INFO, "Messages");
		try {
			if (!customertype.startsWith("Only"))
			{BasePageFns.profileChange(TestData.getConfig("ProfileName"));	
			}
			MethodDef.clickJS(Messages.Messages_menu(),"Messages menu");	
			MethodDef.clickJS(Messages.Messages_viewandsend(),"view and send messages menu");
			if (TestData.getConfig("Action").equals("n/a"))
			{
			MethodDef.clickJS(Messages.Messages_newMessage(),"new messages button");
			CommonDef.Wait();
			
			//***** Select Query***********
			MethodDef.click(Messages.Messages_selectQuery(), "Select Query");
			String[] Val1 = TestData.getConfig("Select_Query").split("_");
			MethodDef.click(Messages.Messages_Queryelement(Val1[1]),"Query Element");
			CommonDef.Wait();
			//****** Select Subject***********
			MethodDef.click(Messages.Messages_selectSubject(), "Select Subject");
			String[] Val2 = TestData.getConfig("Select_Subject").toString().split("_");
			MethodDef.click(Messages.Messages_Subjectelement(Val2[1]),"Subject Element");
			CommonDef.Wait();
			if (Val1[1].equals("2")&Val2[1].equals("2"))
			{	MethodDef.clickJS(Messages.Messages_start(),"StartDate");
				BasePageFns.FDate(TestData.getConfig("Travel_Date"));
				MethodDef.sendKeys(Messages.Messages_travelCountry(),TestData.getConfig("Travel_Country"));
				MethodDef.clickJS(Messages.Messages_end(),"EndDate");
				BasePageFns.FDate(TestData.getConfig("Return_Date"));	
			}
			if (Val1[1].equals("2")&Val2[1].equals("3"))
			{MethodDef.sendKeys(Messages.Messages_DeclinedCard(), TestData.getConfig("LongCard_Number"));
			}
			MethodDef.sendKeys(Messages.Messages_Reason(),TestData.getConfig("Message"));
			MethodDef.clickJS(Messages.Messages_SendMessage(),"Send Message");				
			MethodDef.assertElemsContains(Messages.Messages_Success(), TestData.getConfig("SuccessMessage"));			
			MethodDef.clickJS(Messages.Messages_Inbox(),"Inbox");
			}
		
			if (TestData.getConfig("Action").equals("Delete"))
			{
			//MethodDef.clickJS(Messages.Messages_Inbox(),"Inbox");
			BasePageFns.selectMessage(Messages.Messages_InboxMessage(),TestData.getConfig("Message"));
			CommonDef.Wait();
			MethodDef.click(Messages.Messages_DeleteButton(),"Delete Button");
			MethodDef.assertElemsContains(Messages.Messages_DeleteMessage(), TestData.getConfig("SuccessMessage"));
			}
			if (TestData.getConfig("Action").equals("Inbox"))
			{
				//BasePageFns.selectMessage(Messages.Messages_InboxMessage(),TestData.getConfig("Message"));
				BasePageFns.selectNewMessage(Messages.Messages_InboxMessage(),TestData.getConfig("Message"));
				CommonDef.Wait();
				MethodDef.clickJS(Messages.Messages_BacktoInbox(),"Back to Inbox Button");
				CommonDef.Wait();
				MethodDef.assertElemsContains(Messages.Messages_Header(), TestData.getConfig("SuccessMessage"));
			}		
		}
		catch (Exception e) {
			ExReporter.log(LogStatus.ERROR, "Error in Messaging Function");
		}
	}	
}