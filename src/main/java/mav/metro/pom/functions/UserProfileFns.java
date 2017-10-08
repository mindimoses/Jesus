package mav.metro.pom.functions;

import com.relevantcodes.extentreports.LogStatus;
import mav.metro.framework.ExReporter;
import mav.metro.framework.TestData;
import mav.metro.library.functions.CommonDef;
import mav.metro.library.functions.MethodDef;
import mav.metro.pom.elements.UserProfile;

public class UserProfileFns {

	public static void UserProfile() {
		try {

			if (CommonDef.getAttribute(UserProfile.Validation_Link_UserProfile(), "href")
					.contains(TestData.getConfig("Page_Validation"))) {
				ExReporter.log(LogStatus.PASS, "UserProfile Link Available");
			} else {
				ExReporter.log(LogStatus.FAIL, "UserProfile Link not Available");
			}

			MethodDef.click(UserProfile.Link_UserProfile(), "UserProfile Link Clicked");
			CommonDef.isDisplayed(UserProfile.Validation_Page_UserProfile(), "UserProfile Page available");
			MethodDef.click(UserProfile.Btn_ChangePassword(), "Change Password Button Clicked");
			MethodDef.sendKeys(UserProfile.Txt_OldPassword(), TestData.getConfig("OldPassword"));
			MethodDef.sendKeys(UserProfile.Txt_NewPassword(), TestData.getConfig("NewPassword"));

			if (TestData.getConfig("Action").equals("Pass")) {
				MethodDef.sendKeys(UserProfile.Txt_ReEnterNewPassword(), TestData.getConfig("NewPassword"));
			} else {
				MethodDef.sendKeys(UserProfile.Txt_ReEnterNewPassword(), TestData.getConfig("OldPassword"));
			}
			MethodDef.clickJS(UserProfile.Btn_Update(), "Update Button Clicked");

			if (TestData.getConfig("Action").equals("Pass")) {
				CommonDef.waitVisibleNoError(UserProfile.Validation_PasswordChanged());
				CommonDef.isDisplayed(UserProfile.Validation_PasswordChanged(), "Password Changed Successfully");
				ExReporter.log(LogStatus.PASS, "UserProfile Password Changed Successfully");

			} else {
				CommonDef.waitVisibleNoError(UserProfile.Validation_PasswordChangeFailed());
				CommonDef.isDisplayed(UserProfile.Validation_PasswordChangeFailed(), "Password Change Failed");
				ExReporter.log(LogStatus.PASS, "UserProfile Password Changed Failed");
			}

		} catch (Exception E) {
			ExReporter.log(LogStatus.FAIL, "UserProfile" + E.getMessage());

		}
	}

}
