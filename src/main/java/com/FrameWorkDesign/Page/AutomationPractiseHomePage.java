package com.FrameWorkDesign.Page;

import org.openqa.selenium.By;

import com.FrameWorkDesign.Base.CommonComponents;
import com.FrameWorkDesign.Ultilities.Reporter;

public class AutomationPractiseHomePage extends CommonComponents {

	public void verifyClickSign() {
		clickByXpath(xprop.getProperty("xpath.Index_Signin"), "Signbutton");
	}

	public void verifyClickCreateAccount() {
		clickByXpath(xprop.getProperty("xpath.Reg_create"), "Createbutton");
	}

	public void verifyemailAddress(String getemailaddress) {
		enterByXpath(xprop.getProperty("xpath.Reg_email"), getemailaddress);
	}

	public void verifyRegistration(String gender, String enterfname, String enterLname, String enterpasswrd,
			String enterday, String entermonth, String enterYear, String entercompny, String enterregaddres,
			String enterregaddres2, String enterCity, String enterstate, String enterpostalcode,
			String enterinformation, String enterphnome, String entermobilephone, String enterseconaddress) {

		if (gender.equalsIgnoreCase("Male")) {
			clickByXpath(xprop.getProperty("xpath.gender1"), "gender");
		} else if (gender.equalsIgnoreCase("female")) {
			clickByXpath(xprop.getProperty("xpath.gender2"), "gender");
		}
		enterByXpath(xprop.getProperty("xpath.Reg_firstname"), enterfname);
		enterByXpath(xprop.getProperty("xpath.Reg_lastname"), enterLname);
		enterByXpath(xprop.getProperty("xpath.Reg_passwrd"), enterpasswrd);
		selectValueByXpath(xprop.getProperty("xpath.Reg_dobday"), enterday);
		selectValueByXpath(xprop.getProperty("xpath.Reg_months"), entermonth);
		selectValueByXpath(xprop.getProperty("xpath.Reg_years"), enterYear);
		enterByXpath(xprop.getProperty("xpath.Reg_company"), entercompny);
		enterByXpath(xprop.getProperty("xpath.Reg_address1"), enterregaddres);
		enterByXpath(xprop.getProperty("xpath.Reg_address2"), enterregaddres2);
		enterByXpath(xprop.getProperty("xpath.Reg_city"), enterCity);
		selectValueByXpath(xprop.getProperty("xpath.Reg_state"), enterstate);
		enterByXpath(xprop.getProperty("xpath.Reg_postcode"), enterpostalcode);
		enterByXpath(xprop.getProperty("xpath.Reg_others"), enterinformation);
		enterByXpath(xprop.getProperty("xpath.Reg_landphone"), enterphnome);
		enterByXpath(xprop.getProperty("xpath.Reg_mobile"), entermobilephone);
		enterByXpath(xprop.getProperty("xpath.Reg_alias"), enterseconaddress);
		clickByJsXpath(xprop.getProperty("xpath.Reg_sumbit"));
	}

	public void verifylogout() {
		clickByXpath(xprop.getProperty("xpath.logout"), "LogOut");
	}

	public void logInPage(String getemailaddress, String enterpasswrd) {

		if (driver.findElement(By.xpath(xprop.getProperty("xpath.Index_Signin"))) != null)
		{
			clickByXpath(xprop.getProperty("xpath.Index_Signin"), "Sign In Link");
			verifyTitle("Login - My Store");
			enterByXpath(xprop.getProperty("xpath.login_email"), getemailaddress);
			enterByXpath(xprop.getProperty("xpath.login_passsword"), enterpasswrd);
			clickByXpath(xprop.getProperty("xpath.login_signin"), "SignIn button");
			getTextByXpath(xprop.getProperty("xpath.my_Account"), "My account");
			Reporter.reportStep("Successfully navigated to Home page ", "PASS");
			//clickByXpath(xprop.getProperty("xpath.logout"), "Logout");
		}
		else {
			Reporter.reportStep("Error occured while navigating to Home page ", "FAIL");

		}

	}

	public void forgotPassword(String email, String text) {

		if (driver.findElement(By.xpath(xprop.getProperty("xpath.Index_Signin"))).isDisplayed())
		{
			clickByXpath(xprop.getProperty("xpath.forgotPasswordLink"), "Forgotpassword Link");
			verifyTitle("Forgot your password - My Store");
			enterByXpath(xprop.getProperty("xpath.for_email"), email);
			clickByXpath(xprop.getProperty("xpath.for_submit"), "RetrivePassword link");
			getTextByXpath(xprop.getProperty("xpath.SuccessMsg"), text);
			Reporter.reportStep("RetrivePassword is successful", "PASS");
			clickByXpath(xprop.getProperty("xpath.for_backhome"), "Back To Login Button");
			verifyTitle("Login - My Store");
		} else {
			Reporter.reportStep("Error occured while performing RetrivePassword", "FAIL");
		}

	}

	public void contactUs(String email, String orderref, String message, String Path) {
		if (driver.findElement(By.xpath(xprop.getProperty("xpath.contactUs"))) != null) {
			getTextByXpath(xprop.getProperty("xpath.contactUsHomePage"), "Customer service - Contact us");
			Reporter.reportStep("Navigated successfully to the contact us page", "PASS");
			clickByXpath(xprop.getProperty("xpath.contactUs"), "Contact Us Link");
			selectByVisibleIndexByXpath(xprop.getProperty("xpath.ConUsIn_type"), 2);
			enterByXpath(xprop.getProperty("xpath.ConUsIn_email"), email);
			enterByXpath(xprop.getProperty("xpath.ConUsIn_order"), orderref);
			enterById(xprop.getProperty("id.uploadFil"), Path);
			enterByXpath(xprop.getProperty("xpath.ConUsIn_textarea"), message);
			clickByXpath(xprop.getProperty("xpath.ConUsIn_submit"), "Submit button");
			getTextByXpath(xprop.getProperty("xpath.contactUsSuccess"),
					"Your message has been successfully sent to our team.");
			Reporter.reportStep("Contact Us form submitted successfully", "PASS");
		}
		else {
			Reporter.reportStep("Error occured while submitting the contact us Form", "PASS");

		}

	}

}
