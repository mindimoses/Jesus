package mav.metro.pom.functions;

import com.relevantcodes.extentreports.LogStatus;

import mav.metro.framework.ConfigProvider;
import mav.metro.framework.ExReporter;
import mav.metro.framework.ProjectConfig;
import mav.metro.framework.TestData;
import mav.metro.library.functions.CommonDef;
import mav.metro.library.functions.MethodDef;
import mav.metro.pom.elements.BasePage;
import mav.metro.pom.elements.Login;
import mav.metro.pom.elements.Payments;
import mav.metro.pom.tcib.functions.LoginFns;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

public class PaymentsFns extends BasePageFns {

	public static void PaymentsBasicSteps() {
		try {
			ExReporter.log(LogStatus.INFO, "Payments Basic Steps");

			String PaymentType = TestData.getConfig("Payment_Mode");
			String AccNum = TestData.getConfig("From_Ac");

			openMainMenu();
			MethodDef.loadWaitIE();
			CommonDef.waitForPageLoad();
			Thread.sleep(3000);
			CommonDef.waitVisibleNoError(BasePage.accSummLoad());
			MethodDef.click(Payments.Link_Payments(), "Payments and Transfers");
			MethodDef.loadWaitIE();
			By intlTab = null, domTab = null, accountSel = null,accountbal=null;
			if (ConfigProvider.getConfig("Platform").equalsIgnoreCase("mBrowser")) {
				domTab = Payments.Mob_Link_DomPayments();
				intlTab = Payments.Mob_Link_IntlPayment();
				accountSel = Payments.Mob_Ddown_PopAcct(AccNum);
			} else if (ConfigProvider.getConfig("Platform").equalsIgnoreCase("Browser")) {
				domTab = Payments.Link_DomPayment();
				intlTab = Payments.Link_IntlPayment();
				accountSel = Payments.Ddown_PopAcct(AccNum);
				accountbal=Payments.Ddown_PopAcctAmount(AccNum);
			}

			if (PaymentType.equalsIgnoreCase("International")) {
				MethodDef.click(intlTab, "International Payment Tab");
				MethodDef.clickJS(Payments.Ddown_IntlFromAcct(), "Debit Account Dropdown");
			} else if (PaymentType.equalsIgnoreCase("Domestic")) {
				MethodDef.click(domTab, "Domestic Payment Tab");
				if (!System.getProperty("ResSuite").contains("Dev"))
					MethodDef.clickJS(Payments.Ddown_FromAcct(), "Debit Account Dropdown");
				else
					MethodDef.clickJS(Payments.Ddown_FromAcctDev(), "Debit Account Dropdown");
			}
			if (System.getProperty("ResSuite").contains("Dev")) {
				Thread.sleep(2000);
				loadMore();
				MethodDef.clickJS(Payments.Dev(), "Debit Account Selection");
			} else {
				loadMore();
				if(MethodDef.getText(accountbal).length()>0){
					ExReporter.log(LogStatus.PASS, "Current Balance for the Account "+ AccNum +" is : " + MethodDef.getText(accountbal));
				}	
				MethodDef.clickJS(accountSel, "Debit Account Selection");
			}
		} catch (Exception e) {
			ExReporter.log(LogStatus.ERROR, "Error Performing the Payment Functions" + e.getMessage());
		}
	}

	private static void loadMore() {
		try {
			do {
				Thread.sleep(1000);
				try {
					CommonDef.clickThrowError(By.cssSelector(".modal.fade.in .read-more:not([class*='ng-hide']) a"),
							"Load More");
				} catch (Exception E) {
					break;
				}
			} while (true);
		} catch (Exception e) {

		}
	}

	public static void PaymentsSelectBeneficiary() {
		ExReporter.log(LogStatus.INFO, "Beneficiary Selection");
		String PaymentType = TestData.getConfig("Payment_Mode");
		String BenMode = TestData.getConfig("Payment_Method");
		String BenType = TestData.getConfig("Ben_Type");
		String BenAcc = TestData.getConfig("Ben_AcNo");
		String sortCode = TestData.getConfig("Ben_Sortcode");
		String ToAcc = TestData.getConfig("To_Ac");
		MethodDef.loadWaitIE();
		if (BenMode.equalsIgnoreCase("Address Book")) {
			MethodDef.clickJS(Payments.Btn_SelectPayee(), "Select Payee");
			if (PaymentType.equalsIgnoreCase("Domestic")) {
				if (BenType.equalsIgnoreCase("Domestic beneficiaries")) {
					if (ConfigProvider.getConfig("Platform").equalsIgnoreCase("mBrowser")) {
						searchPayee(Payments.Mob_Lnk_BenType(), Payments.Mob_Lnk_DomBen(), Payments.devPayeepicker(),
								Payments.devPayeePickerAN(), BenAcc, Payments.selectPayeeResult());
						// MethodDef.clickJS(Payments.Mob_Lnk_DomBenSelect(TestData.getConfig("Ben_Name")));
					} else if (ConfigProvider.getConfig("Platform").equalsIgnoreCase("Browser")) {
						MethodDef.click(Payments.Btn_BenDomest(), "Domestic Beneficiary");
						selectBenPayee(BenAcc);
					}
				} else if (BenType.equalsIgnoreCase("Biller Beneficiaries")) {
					if (ConfigProvider.getConfig("Platform").equalsIgnoreCase("mBrowser")) {
						MethodDef.click(Payments.Mob_Lnk_BenType(), "Beneficiary Type");
						MethodDef.click(Payments.Mob_Lnk_BilBen(), "Biller Beneficiary");
						MethodDef.clickJS(Payments.Mob_Lnk_DomBillSelect(sortCode));
					} else if (ConfigProvider.getConfig("Platform").equalsIgnoreCase("Browser")) {
						MethodDef.click(Payments.Btn_BenBiller(), "Biller Beneficiary");
						MethodDef.click(Payments.Btn_BenBillerSelect(ToAcc), "Biller Beneficiary Selected");
					}
				} else if (BenType.equalsIgnoreCase("Company accounts")) {
					if (ConfigProvider.getConfig("Platform").equalsIgnoreCase("mBrowser")) {
						searchPayee(Payments.Mob_Lnk_BenType(), Payments.Mob_Lnk_ComBen(), Payments.devPayeepicker(),
								Payments.devPayeePickerAN(), ToAcc, Payments.selectPayeeResultCC());
					} else if (ConfigProvider.getConfig("Platform").equalsIgnoreCase("Browser")) {
						MethodDef.click(Payments.Btn_BenComAccs(), "Company Accounts");
						MethodDef.click(Payments.Btn_BenComAccsSelect(ToAcc), "Company Account Selected");
					}
				}
			} else if (PaymentType.equalsIgnoreCase("International")) {
				MethodDef.clickJS(Payments.Link_IntlBenSelect());
				// Add Code
			}
		} else if (BenMode.equalsIgnoreCase("One-off")) {
			if (PaymentType.equalsIgnoreCase("Domestic")) {
				MethodDef.sendKeys(Payments.Text_PayeeName(), TestData.getConfig("Ben_Name"));
				MethodDef.sendKeys(Payments.Text_SortCode(), sortCode);
				MethodDef.sendKeys(Payments.Text_BenAccNum(), TestData.getConfig("Ben_AcNo"));
				if (TestData.getConfig("Reference").contains("PayeNeg")) {
					CommonDef.waitVisible(Payments.Btn_BenInfoNextDis());
				} else if (TestData.getConfig("Reference").contains("SortNeg")) {
					MethodDef.assertContains(Payments.invalidChar(), "Invalid sort code");
				} else
					MethodDef.clickJS(Payments.Btn_BenInfoNext());
			} else if (PaymentType.equalsIgnoreCase("International")) {
				MethodDef.sendKeys(Payments.Text_IntlBenName(), TestData.getConfig("Ben_Name"));
				MethodDef.sendKeys(Payments.Text_IntlBenNickName(), TestData.getConfig("Ben_Nickname"));
				MethodDef.sendKeys(Payments.Text_IntlBicID(), TestData.getConfig("Ben_SWIFTCode"));

				if (TestData.getConfig("Ben_ToAC").equalsIgnoreCase("AccountNo")) {
					MethodDef.clickJS(Payments.Radio_IntlBenAcct(), "Beneficiary Account Radio Button");
					MethodDef.sendKeys(Payments.Text_IntlBenAcct(), TestData.getConfig("Charge_Ac"));
				} else {
					enterIBan();
				}
			}
		}
	}

	private static void enterIBan() {
		MethodDef.clickJS(Payments.Radio_IntlBenIBAN(), "Beneficiary IBAN");
		MethodDef.sendKeys(Payments.Text_IntlBenIBAN(), TestData.getConfig("Ben_IBANNo"));
	}

	private static void searchPayee(By mob_Lnk_BenType, By mob_Lnk_DomBen, By devPayeepicker, By devPayeePickerAN,
			String benAcc, By selectPayeeResult) {
		MethodDef.click(mob_Lnk_BenType, "Beneficiary Type");
		MethodDef.click(mob_Lnk_DomBen, "Domestic Beneficiary");
		MethodDef.click(devPayeepicker, "Beneficiary picker DropDown");
		MethodDef.click(devPayeePickerAN, "Beneficiary picker - Account Number");
		MethodDef.sendKeys(Payments.devSearchAccountInput(), benAcc);
		MethodDef.click(Payments.devSearchSubmit(), "Search Submit");
		MethodDef.click(selectPayeeResult, "Result Select - Payee");
	}

	private static void selectBenPayee(String benAcc) {
		MethodDef.clickJS(Payments.payeeSelect(benAcc), "Payee from the table");
	}

	public static void PaymentsVerificaton(String PaymentName, String Action, String TxnRef) {
		try {
			ExReporter.log(LogStatus.INFO, "Payments Verification");
			MethodDef.loadWaitIE();
			openItemLogoutMenu();
			MethodDef.clickJS(Payments.Btn_ItemMgmt(), "Item Management");
			itemMgmtPageLoad();
			MethodDef.loadWaitIE();
			if (ConfigProvider.getConfig("Platform").equalsIgnoreCase("mBrowser")) {
				MethodDef.click(Payments.itemMgtToggle(), "Drop Down Toggle");
				MethodDef.click(Payments.itemMgtDropDownApp("Verifications"), "Drop Down Select - Verifications");
			} else
				MethodDef.click(Payments.Link_VerifTab(), "Verification Tab");
			ExReporter.log(LogStatus.INFO, "Transaction Reference : " + TxnRef);
			if (TestData.getConfig("DataBinding").contains("ORDER")) {
				itemMgmtItemRefreshChk(Payments.Btn_StandAction(TxnRef, Action), "Standing order", Payments.Link_VerifTab());
				//MethodDef.clickJS(Payments.Btn_StandAction(TxnRef, Action));
			} else {
				if (ConfigProvider.getConfig("Platform").equalsIgnoreCase("mBrowser")) {
					int i = 0;
					MethodDef.findElements(Payments.moblistItemsFP(PaymentName));
					int spancount = CommonDef.findElements(Payments.mobSpanContent(PaymentName)).size();
					do {
						if (CommonDef.assertInnerHTMLContainsNoError(Payments.mobSpanContent(PaymentName, i + 1),
								TxnRef)) {
							String action = "";
							if (Action.equals("verify"))
								action = "Verify";
							else if (Action.equals("reject"))
								action = "Reject";
							MethodDef.clickJS(Payments.moblistItemsFPAction(PaymentName, i + 1, action),
									"Actioning on the item");
							break;
						}
						i++;
					} while (spancount > i);
				} else
					MethodDef.clickJS(Payments.Btn_PaymentsActn(TxnRef, Action));
			}
			// if
			// (ConfigProvider.getConfig("Platform").equalsIgnoreCase("Browser"))
			// {
			MethodDef.clickJS(Payments.Btn_PaymentsBtnActn(Action));
			// }
			MethodDef.clickJS(Payments.Lnk_Notific());
			verificationValidation(Action);
			MethodDef.clickJS(Payments.Btn_CloseAppVer(), "Close Popup Window");
		} catch (Exception E) {
			ExReporter.log(LogStatus.ERROR, "Payments Verification step Failed :" + E.getMessage());
		}
	}

	public static void itemMgmtPageLoad() {
		try {
			Thread.sleep(10000);
			CommonDef.waitVisibleNoError(Payments.Link_Tabs());
			do {
				if (!CommonDef.waitVisibleNoError(Payments.Link_Tabs())) {
					ExReporter.log(LogStatus.WARNING, "ITEM Management didnt load directly - refreshing page");
					CommonDef.reloadPage();
					CommonDef.waitVisible(Payments.Link_Tabs(), "Tab Nav - Item Management");
				} else
					CommonDef.waitVisible(Payments.Link_Tabs(), "Tab Nav - Item Management");
			} while (false);
		} catch (Exception E) {
			ExReporter.log(LogStatus.ERROR, "Error Selecting Item Management Selection tab");
		}
	}

	public static void PaymentsApproval(String PaymentName, String action, String TxnRef) {
		try {
			ExReporter.log(LogStatus.INFO, "Payments Approval");
			CommonDef.waitForPageLoad();
			Thread.sleep(2000);
			MethodDef.loadWaitIE();
			openItemLogoutMenu();
			MethodDef.clickJS(Payments.Btn_ItemMgmt(), "Item Management");
			MethodDef.loadWaitIE();
			itemMgmtPageLoad();
			if (ConfigProvider.getConfig("Platform").equalsIgnoreCase("mBrowser")) {
				MethodDef.click(Payments.itemMgtToggle(), "Drop Down Toggle");
				MethodDef.click(Payments.itemMgtDropDownApp("Approvals"), "Drop Down Select - Approvals");
			} else {
				MethodDef.click(Payments.Link_AppTab(), "Approve Tab");
				CommonDef.waitVisibleNoError(Payments.Btn_Ddown_ItemMgmt());
				// MethodDef.findElementsClick(Payments.Btn_Ddown_ItemMgmt());
			}
			ExReporter.log(LogStatus.INFO, "Transaction Reference : " + TxnRef);
			if (TestData.getConfig("DataBinding").contains("ORDER")) {
				itemMgmtItemRefreshChk(Payments.Btn_StandAction(TxnRef, action), "Standing order transcation", Payments.Link_AppTab());
				//MethodDef.clickJS(Payments.Btn_StandAction(TxnRef, action));
			} else {
				if (ConfigProvider.getConfig("Platform").equalsIgnoreCase("mBrowser")) {
					int i = 0;
					String tabname = getTabName(PaymentName);
					MethodDef.findElements(Payments.moblistItemsFP(tabname));
					int spancount = CommonDef.findElements(Payments.mobSpanContent(tabname)).size();
					do {
						if (CommonDef.assertInnerHTMLContainsNoError(Payments.mobSpanContent(tabname, i + 1), TxnRef)) {
							MethodDef.clickJS(Payments.moblistItemsFPActionApprove(tabname, i + 1, action),
									"Actioning on the item");
							break;
						}
						i++;
					} while (spancount > i);
				} else {
					itemMgmtItemRefreshChk(Payments.Btn_PaymentsActn(TxnRef, action), "transcation approval", Payments.Link_AppTab());
					//MethodDef.clickJS(Payments.Btn_PaymentsActn(TxnRef, action));
				}
			}
			MethodDef.clickJS(Payments.Btn_PaymentsBtnActn(action));
			MethodDef.clickJS(Payments.Lnk_Notific());
			approvalValidation(action);
			MethodDef.clickJS(Payments.Btn_CloseAppVer(), "Close Popup Window");
		} catch (Exception e) {
			ExReporter.log(LogStatus.ERROR, "Error in performing the Payments Approval :" + e.getMessage());
		}
	}

	private static String getTabName(String paymentName) {
		if (paymentName.equalsIgnoreCase("Faster Payments"))
			return "Faster Payments";
		else if (paymentName.equalsIgnoreCase("Cross Currency"))
			return "Transfers & Metro Bank Payments";
		else if (paymentName.equalsIgnoreCase("CHAPS"))
			return "CHAPS";
		else if (paymentName.equalsIgnoreCase("BACS"))
			return "BACS";
		else if (paymentName.equalsIgnoreCase(""))
			return "International Payments";
		return "";

	}

	public static String PaymentsFinalSteps(String PaymentType) {
		String reference = TestData.getConfig("Reference") + RandomStringUtils.random(5, "ABFERPLDBNVJK");
		String orgref = TestData.getConfig("Reference");
		String closeMsg = TestData.getConfig("closeMsg");
		String warnMsg = TestData.getConfig("warnMsg");
		try {
			MethodDef.loadWaitIE();
			ExReporter.log(LogStatus.INFO, "Payments Final Steps");
			ExReporter.log(LogStatus.INFO, "Payments Final Steps");
			if (PaymentType.equalsIgnoreCase("Faster")) {
				ExReporter.log(LogStatus.INFO, PaymentType);
				MethodDef.clickJS(Payments.Btn_FP());
				MethodDef.clickJS(Payments.Btn_FP(), "Faster Payments Tab");
			} else if (PaymentType.equalsIgnoreCase("CHAPS")) {
				ExReporter.log(LogStatus.INFO, PaymentType);
				MethodDef.clickJS(Payments.Btn_CHAPS());
				MethodDef.clickJS(Payments.Btn_CHAPS(), "CHAPS Payments Tab");
			} else if (PaymentType.equalsIgnoreCase("BACS")) {
				ExReporter.log(LogStatus.INFO, PaymentType);
				MethodDef.clickJS(Payments.Btn_BACKS());
				MethodDef.clickJS(Payments.Btn_BACKS(), "BACS Payments Tab");
			} else if (PaymentType.equalsIgnoreCase("Metro Bank") || PaymentType.equalsIgnoreCase("MCross_Currency")) {
				MethodDef.clickJS(Payments.Btn_MP(), "Metro Payments Tab");
			} else if (PaymentType.equalsIgnoreCase("OwnAcTransfer")
					|| PaymentType.equalsIgnoreCase("Cross_Currency")) {
				ExReporter.log(LogStatus.INFO, PaymentType);
				CommonDef.waitClick(Payments.Btn_ACAC());
				MethodDef.clickJS(Payments.Btn_ACAC(), "Transfer Payments Tab");
			}

			// CommonDef.waitVisible(Payments.Text_Amount());
			if (PaymentType.equalsIgnoreCase("CHAPS")) {
				MethodDef.sendKeys(Payments.Text_Amount(), TestData.getConfig("Amount"));
				MethodDef.sendKeys(Payments.Text_ChapsReference(), reference);
				MethodDef.clickJS(Payments.ChkBox_ChapsCharges(), "Select Charges Checkbox");
				// CommonDef.waitVisibleNoError(Payments.Lbl_ChapsChargAcc());
				// MethodDef.moveToElement(Payments.Btn_ChapsChargesSelect(),
				// "Select Charges Dropdown Button");
				MethodDef.clickJS(Payments.Btn_ChapsChargesSelect(), "Select Charges Dropdown Button");
				MethodDef.click(Payments.Text_ChapsChgAcc(TestData.getConfig("Charge_Ac")), "Charge Account Slection");
			} else if (PaymentType.equalsIgnoreCase("Cross_Currency")
					|| PaymentType.equalsIgnoreCase("MCross_Currency")) {
				MethodDef.sendKeys(Payments.Text_CCYAmt(), TestData.getConfig("Amount"));
				MethodDef.sendKeys(Payments.Text_Reference(), reference);
			} else if (PaymentType.equalsIgnoreCase("INTL")) {
				MethodDef.sendKeys(Payments.Text_IntlAmount(), TestData.getConfig("Amount"));
				MethodDef.sendKeys(Payments.Text_IntlReference(), reference);
				if (TestData.getConfig("Metro_Charges").equalsIgnoreCase("CUSTOMER")) {
					MethodDef.clickJS(Payments.Radio_BankChargeCust(), "Metro Charge - Paid by Us");
				} else {
					MethodDef.clickJS(Payments.Radio_BankChargeBen(), "Metro Charge - Paid by Payee");
				}
				if (TestData.getConfig("Other_Charges").equalsIgnoreCase("CUSTOMER")) {
					MethodDef.clickJS(Payments.Radio_OtherBankChargeCust(), "Other Charge - Paid by Us");
					MethodDef.clickJS(Payments.ChkBox_ChapsCharges(), "Charges Checkbox");
					MethodDef.clickJS(Payments.Btn_IntlCharges(), "Charge Account Selection Dropdown");
					MethodDef.clickJS(Payments.Text_ChapsChgAcc(TestData.getConfig("Charge_Ac")),
							"Charge Account Selection");
				} else {
					MethodDef.clickJS(Payments.Radio_OtherBankChargeBen(), "Other Charge - Paid by Payee");
				}

			} else {
				MethodDef.sendKeys(Payments.Text_Amount(), TestData.getConfig("Amount"));
				MethodDef.sendKeys(Payments.Text_Reference(), reference);
			}

			MethodDef.dateFunctionBB(BasePage.calendarActiveDates(), BasePage.totalRows(), Payments.Btn_DateFwdMonth(),
					Payments.Btn_Date(), Integer.parseInt(TestData.getConfig("Payment_Date")), "payments");

			if (orgref.contains("Invalid")) {
				MethodDef.assertContains(Payments.invalidChar(), "There is an invalid character");
			} else if (orgref.contains("Clear")) {
				clearButtonValidations();
			}else {
				CommonDef.moveToElement(Payments.Btn_Pay(), "Pay Button");
				MethodDef.clickJS(Payments.Btn_Pay(), "Pay Button");
				if (CommonDef.ObjectExist(Payments.Text_Token())) {
					MethodDef.sendKeys(Payments.Text_Token(), ProjectConfig.getPropertyValue("hardtoken"));
				}
			}

			if (orgref.contains("NegLimit") || orgref.contains("Restrict"))
				limitExceededWarning(closeMsg, warnMsg);
			else if (orgref.contains("GrtLimit") /* || orgref.contains("ONKEY") */)
				limitExceededWarning(closeMsg, warnMsg);
			else if (orgref.contains("Invalid") || orgref.contains("Clear")) {
				
			}else if (orgref.contains("Back")) {
				MethodDef.clickJS(Payments.Btn_Back(), "Back Button");
				MethodDef.assertContains(Payments.Btn_Clear(), "Clear");
				clearButtonValidations();
			} else if (orgref.contains("PayCanc")) {
				MethodDef.clickJS(Payments.canButton(), "Cancel Button");
				MethodDef.clickJS(Payments.canConfirm(), "Cancel Confirm Button");
				CommonDef.waitVisible(Payments.activeHeader(), "Active Header");
			} else {
				if(TestData.getConfig("DataBinding").contains("CutOff")){
					MethodDef.assertElemsContainsWarn(Payments.commWarningMsg(), warnMsg);
				}				
				CommonDef.waitClickable(Payments.Btn_PayConfirm(), "Confirm Button");
				MethodDef.clickJS(Payments.Btn_PayConfirm(), "Confirm Button");
				paymentsValidation();
			}
		} catch (Exception e) {
			ExReporter.log(LogStatus.ERROR, "Error in accessing : " + e.getMessage());
		}
		return reference;
	}
	
	public static void clearButtonValidations(){
		MethodDef.clickJS(Payments.Btn_Clear(), "Clear Button");
		CommonDef.assertContains(Payments.Ddown_FromAcctClearVal(), "Select an account");
		CommonDef.assertContainsOnAttribute(Payments.Text_PayeeName(), "invalid", "class");
		CommonDef.assertContainsOnAttribute(Payments.Text_SortCode(), "invalid", "class");
		CommonDef.assertContainsOnAttribute(Payments.Text_BenAccNum(), "invalid", "class");
	}

	private static void limitExceededWarning(String closemsg, String warnmsg) {
		try {
			MethodDef.assertContains(Payments.warningAuthSummary(), closemsg);
			MethodDef.assertElemsContainsWarn(Payments.warningMsgSummary(), warnmsg);
		} catch (Exception E) {
			ExReporter.log(LogStatus.ERROR, "Limit Validation Failed: " + E.getMessage());
		}
	}

	public static void paymentsValidation() {
		if (TestData.getConfig("Payment_Mode").equalsIgnoreCase("Domestic")) {
			if (!TestData.getConfig("Reference").contains("Neg")) {
				if (MethodDef.getText(Payments.Text_FTReference(), "Payment REFERENCE Number").contains("FT")) {
					ExReporter.log(LogStatus.PASS,
							"FT REFERENCE NUMBER: " + MethodDef.getText(Payments.Text_FTReference()));
				} else

					ExReporter.log(LogStatus.FAIL,
							"FT REFERENCE NUMBER: " + MethodDef.getText(Payments.Text_FTReference()));
			}
		} else if (TestData.getConfig("Payment_Mode").equalsIgnoreCase("International")) {
			if (!TestData.getConfig("Reference").contains("Neg")) {
				if (MethodDef.getText(Payments.Text_IntlFTReference()).contains("FT")) {
					ExReporter.log(LogStatus.PASS,
							"FT REFERENCE NUMBER: " + MethodDef.getText(Payments.Text_IntlFTReference()));
				} else
					ExReporter.log(LogStatus.FAIL,
							"FT REFERENCE NUMBER: " + MethodDef.getText(Payments.Text_IntlFTReference()));
			}
		}
	}

	public static Boolean PaymentsAuthorize(String authuser, String paymentName, String reference) {
		ExReporter.log(LogStatus.INFO, "Approve User : " + authuser);
		LoginFns.Login(authuser);
		try {
			PaymentsFns.PaymentsApproval(paymentName, TestData.getConfig("AuthAction"), reference);
		} catch (Exception e) {
			ExReporter.log(LogStatus.FAIL, "Error in approving " + paymentName);
		}
		LoginFns.Logout();
		return true;
	}

	public static void PaymentsOutstanding() {

		// openMainMenu();
		openPaymentsdropdownMobile();
		ExReporter.log(LogStatus.INFO, "Navigating to Payments Outstanding page");
		MethodDef.click(Payments.Link_Outstanding(), "Outstanding Transactions");
		MethodDef.assertContains(Login.assertion(), "Outstanding Payments & Transfers");
		CommonDef.waitVisible(Payments.Link_OutstandingPane());
		if (CommonDef.ObjectExist(Payments.Link_OutstandingPane())) {
			ExReporter.log(LogStatus.PASS, "Navigated to Payments Outstanding page");
		}
	}

	public static void PaymentsOutstanding(String Flag) {
		if (Flag.equalsIgnoreCase("Yes")) {
			ExReporter.log(LogStatus.INFO, "Payments Outstanding");
			MethodDef.click(Payments.Link_Outstanding(), "Outstanding Transactions");
			// Add Outstanding Details
		}
	}

	public static String BatchPayment(double amt) {

		String reference = TestData.getConfig("Reference") + RandomStringUtils.random(5, "ABFERPLDBNVJK");

		try {

			MethodDef.clickJSNoError(Payments.Link_PaymentsMenuItems(), "Payments & Transfer Page");
			ExReporter.log(LogStatus.INFO, "Navigating to BatchPayment Page");
			MethodDef.clickJS(Payments.Link_BatchPayments(), " Batch Payments");
			MethodDef.clickJS(Payments.Ddown_batchFromAcct(), "Debit Account Dropdown");
			MethodDef.clickJS(Payments.Ddown_PopAcct(TestData.getConfig("From_Ac")), "Debit Account Selection");

			String PaymentType = TestData.getConfig("Payment_Type");

			if (PaymentType.equalsIgnoreCase("Faster")) {
				ExReporter.log(LogStatus.INFO, PaymentType);
				CommonDef.waitClick(Payments.Btn_FP());
				MethodDef.clickJS(Payments.Btn_FP(), "Faster Payments Tab");
			} else if (PaymentType.equalsIgnoreCase("CHAPS")) {
				ExReporter.log(LogStatus.INFO, PaymentType);
				CommonDef.waitClick(Payments.Btn_CHAPS());
				MethodDef.clickJS(Payments.Btn_CHAPS(), "CHAPS Payments Tab");
			} else if (PaymentType.equalsIgnoreCase("BACS")) {
				ExReporter.log(LogStatus.INFO, PaymentType);
				CommonDef.waitClick(Payments.Btn_BACKS());
				MethodDef.clickJS(Payments.Btn_BACKS(), "BACS Payments Tab");
			}

			if (!TestData.getConfig("Create Group").equalsIgnoreCase("n/a")) {
				MethodDef.clickJS(Payments.Btn_SelectbatchPayee(), "Select Payee");
				MethodDef.clickJS(Payments.bengrp_selectBeneficiary(), "Select beneficiary");
				MethodDef.click(Payments.bengrp_addSelected(), "Add Selected beneficiary");
				MethodDef.click(Payments.bengrp_close(), "close button");
			} else {
				MethodDef.clickJS(Payments.Btn_Selectbatch(), "Batch Payment Group");
				MethodDef.sendKeys(Payments.Btn_SearchBatch(), TestData.getConfig("Search Group"));
				MethodDef.clickJS(Payments.Btn_SearchButton(), "Search Button");
				MethodDef.clickJS(Payments.lst_Selectbatch(TestData.getConfig("Search Group")), "Search Batch Group");
			}
			MethodDef.dateFunctionBB(BasePage.calendarActiveDates(), BasePage.totalRows(), Payments.Btn_DateFwdMonth(),
					Payments.Btn_Date(), Integer.parseInt(TestData.getConfig("Payment_Date")), "payments");

			MethodDef.clickJS(Payments.bPayClearReference(), "Clear reference button");
			MethodDef.clickJS(Payments.bPayClearReferenceConfirm(), "Clear reference button");
			MethodDef.sendKeys(Payments.bPayReference(), reference);

			MethodDef.sendKeys(Payments.Text_BatchAmount(), amt + "");

			MethodDef.clickJS(Payments.Btn_BatchPay(), "Pay Button");
			if (CommonDef.ObjectExist(Payments.Text_Token())) {
				MethodDef.sendKeys(Payments.Text_Token(), ProjectConfig.getPropertyValue("hardtoken"));
			}

			if (TestData.getConfig("Reference").contains("GrtLimit")) {
				CommonDef.waitVisible(Payments.bPayConfirmMsg());
				MethodDef.assertContains(Payments.bPayConfirmMsg(), TestData.getConfig("Message"));
			} else {
				MethodDef.clickJS(Payments.Btn_PayConfirm(), "Confirm Button");
				CommonDef.waitInVisible(Payments.Btn_PayConfirm(), "Confirm Button");
				CommonDef.waitVisible(Payments.bPayAmountSummary(), "Amount in Summary");
				MethodDef.assertContains(Payments.bPayAmountSummary(), amt + "");
				CommonDef.waitVisible(Payments.bPayConfirmMsg());
				MethodDef.assertElemsContainsWarn(Payments.bPayConfirmMsg(), TestData.getConfig("Message"));
			}
		} catch (Exception e) {
			ExReporter.log(LogStatus.ERROR, "Error Performing the batch payment: " + e.getMessage());
		}
		return reference;
	}

	public static void PaymentVerify(String Reference, double amt, String verifyAction) {

		ExReporter.log(LogStatus.INFO, "Payments" + verifyAction);
		MethodDef.click(Payments.Btn_ItemMgmt(), "Item Management");
		CommonDef.waitVisibleNoError(Payments.Link_Tabs(), 60);
		itemMgmtPageLoad();
		MethodDef.click(Payments.Link_VerifTab(), verifyAction + "Tab");
		ExReporter.log(LogStatus.INFO, "Transaction Reference : " + Reference);
		itemMgmtItemRefreshChk(Payments.Btn_BatchDecision(Reference, amt, verifyAction), "payment transcation", Payments.Link_VerifTab());
		MethodDef.clickJS(Payments.Btn_confirmDecision(verifyAction), verifyAction + "Transaction Button");
		verificationValidation(verifyAction);
		MethodDef.clickJS(Payments.Lnk_Notific());
		MethodDef.clickJS(Payments.Btn_CloseAppVer(), "Close Popup Window");
	}

	public static void itemMgmtItemRefreshChk(By element, String string, By Tab) {
		try {
			if (CommonDef.waitVisibleNoError(element)) {
				MethodDef.clickJS(element, string);
			} else {
				Thread.sleep(20000);
				MethodDef.clickJS(Tab, "Reclick Tab");
				MethodDef.clickJS(element, string);
			}
		} catch (Exception E) {
			ExReporter.log(LogStatus.ERROR, "Error Accessing the Item Management Element");
		}
	}

	public static void PaymentApproval(String Reference, double amt, String AuthAction) {

		ExReporter.log(LogStatus.INFO, "Payments");
		MethodDef.click(Payments.Btn_ItemMgmt(), "Item Management");
		ExReporter.log(LogStatus.INFO, "Transaction Reference : ");
		CommonDef.waitVisibleNoError(Payments.Link_Tabs(), 60);
		itemMgmtPageLoad();
		itemMgmtItemRefreshChk(Payments.Btn_BatchDecision(Reference, amt, AuthAction), "international transcation", Payments.Link_AppTab());
		//MethodDef.clickJS(Payments.Btn_BatchDecision(Reference, amt, AuthAction), "Approval");
		MethodDef.clickJS(Payments.Btn_confirmDecision(AuthAction), AuthAction + "Transaction Button");
		approvalValidation(AuthAction);
		MethodDef.clickJS(Payments.Lnk_Notific());
		MethodDef.clickJS(Payments.Btn_CloseAppVer(), "Close Popup Window");
	}

	public static String StandingOrder() {
		String orgref = TestData.getConfig("Reference");
		String reference = TestData.getConfig("Reference") + RandomStringUtils.random(5, "ABFERPLDBNVJK");
		ExReporter.log(LogStatus.INFO, "Standing Order Function");
		MethodDef.clickJSNoError(Payments.Link_PaymentsMenuItems(), "Payments & Transfer Page");
		ExReporter.log(LogStatus.INFO, "Navigating to StandingOrder Page");
		MethodDef.clickJS(Payments.Link_StandingOrder(), " Standing Order");
		CommonDef.waitVisibleNoError(Payments.Btn_AddStandingOrder());
		MethodDef.click(Payments.Btn_AddStandingOrder(), "Add Standing Order");
		MethodDef.clickJS(Payments.Ddown_FromAcct(), "Debit Account Dropdown");
		MethodDef.clickJS(Payments.Ddown_PopAcct(TestData.getConfig("From_Ac")), "Debit Account Selection");

		ExReporter.log(LogStatus.INFO, "Beneficiary Selection");
		// String PaymentType = TestData.getConfig("Payment_Mode");
		String BenMode = TestData.getConfig("Payment_Method");
		String SelectAcc = TestData.getConfig("Beneficiary Acc");

		if (BenMode.equalsIgnoreCase("Address Book")) {
			MethodDef.clickJS(Payments.Btn_SelectPayee(), "Select Payee");
			MethodDef.clickJS(Payments.Link_SelectAccount(SelectAcc), "Selecting the account");
		} else if (BenMode.equalsIgnoreCase("One-off")) {
			MethodDef.sendKeys(Payments.Lnk_StandBenName(), TestData.getConfig("Ben_Name"));
			MethodDef.sendKeys(Payments.Text_SortCode(), TestData.getConfig("Ben_Sortcode"));
			MethodDef.sendKeys(Payments.Text_BenAccNum(), TestData.getConfig("Ben_AcNo"));
		}
		MethodDef.sendKeys(Payments.Lnk_StandReference(), reference);
		MethodDef.sendKeys(Payments.Text_Amount(), TestData.getConfig("Amount"));
		// CommonDef.moveToElement(Payments.Btn_SubmitButton(), "Submit
		// Button");
		MethodDef.dateFunctionBB(BasePage.calendarActiveDatesSOPayDate(), BasePage.totalRowsSOPayDate(),
				Payments.Btn_DateFwdMonthSOPayDate(), Payments.Btn_DateSOPayDate(),
				Integer.parseInt(TestData.getConfig("Payment_Date")), "standing order");
		// CommonDef.SelectingDate(TestData.getConfig("Payment_Date"), "Start");
		MethodDef.clickJS(Payments.Btn_Frequency(), "Payment frequency button");
		MethodDef.clickJS(Payments.lst_Frequency(TestData.getConfig("Frequency")), "Frequency Type");
		// CommonDef.moveToElement(Payments.Btn_SubmitButton(), "Submit
		// Button");
		// CommonDef.SelectingDate(TestData.getConfig("End_date"), "End");
		if (TestData.getConfig("End_date").contains("Until further notice")) {
			MethodDef.clickJS(Payments.Rdo_StandFurtherNotic());
		} else {
			//System.out.println(TestData.getConfig("End_date"));
			MethodDef.dateFunctionBB(BasePage.calendarActiveDatesSOEndDate(), BasePage.totalRowsSOEndDate(),
					Payments.Btn_DateFwdMonthSOEndDate(), Payments.Btn_DateSOEndDate(),
					Integer.parseInt(TestData.getConfig("End_date")), "End Date");
		}

		/*
		 * if(TestData.getConfig("DataBinding").contains("Negative")) {
		 * 
		 * if(CommonDef.getAttribute(Payments.Btn_SubmitButton(),
		 * "disabled").equals("disabled")){
		 * 
		 * CommonDef.assertContains(Payments.Webel_StandingNonNumeric(),
		 * TestData.getConfig("Message")); } else{
		 * System.out.println("submit button inside the ");
		 * MethodDef.clickJS(Payments.Btn_SubmitButton(), "Submit Button");
		 * CommonDef.assertContains(Payments.Webel_StandingNegative(),
		 * TestData.getConfig("Message")); }
		 * 
		 * } else { MethodDef.clickJS(Payments.Btn_SubmitButton(),
		 * "Submit Button"); if (BenMode.equalsIgnoreCase("One-off")) {
		 * MethodDef.sendKeys(Payments.Text_StandHardToken(),
		 * TestData.getConfig("HardToken")); }
		 * MethodDef.clickJS(Payments.Btn_ConfirmButton(), "Confirm Button");
		 * MethodDef.clickJS(Payments.Lnk_StndNotification(),
		 * "Notification Link");
		 * CommonDef.assertContains(Payments.Lnk_StndSuccessMsg(),
		 * TestData.getConfig("Message")); }
		 */

		if (orgref.contains("Invalid")) {
			MethodDef.assertContains(Payments.Webel_StandingNegative(), "There is an invalid character");
		} else if (orgref.contains("GrtLimit")) {
			MethodDef.clickJS(Payments.Btn_SubmitButton(), "Submit Button");
			// MethodDef.clickJS(Payments.Lnk_StndNotification(), "Notification
			// Link");
			MethodDef.assertContains(Payments.Lnk_StndErrorMsg(), TestData.getConfig("Message"));
		} else {
			MethodDef.clickJS(Payments.Btn_SubmitButton(), "Submit Button");
			if (BenMode.equalsIgnoreCase("One-off")) {
				MethodDef.sendKeys(Payments.Text_StandHardToken(), TestData.getConfig("HardToken"));
			}
			/*
			 * if (CommonDef.ObjectExist(Payments.Text_Token())) {
			 * MethodDef.sendKeys(Payments.Text_Token(),
			 * ProjectConfig.getPropertyValue("hardtoken")); }
			 */
			CommonDef.waitVisibleNoError(Payments.Btn_ConfirmButton());
			CommonDef.moveToElement(Payments.Btn_ConfirmButton(), "Confirm Button");
			MethodDef.click(Payments.Btn_ConfirmButton(), "Confirm Button");
			MethodDef.clickJS(Payments.Lnk_StndNotification(), "Notification Link");
			MethodDef.assertContains(Payments.Lnk_StndSuccessMsg(), TestData.getConfig("Message"));
		}
		return reference;
	}
}
