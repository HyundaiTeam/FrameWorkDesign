package com.FrameWorkDesign.Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.FrameWorkDesign.Base.CommonComponents;
import com.FrameWorkDesign.Page.AutomationPractiseHomePage;
import com.FrameWorkDesign.Page.AutomationPractiseMyAccountPage;
import com.FrameWorkDesign.Ultilities.Reporter;

@Listeners(com.FrameWorkDesign.Listerners.ApplyListeners.class)

public class AutomationHomePageTest extends CommonComponents {

	AutomationPractiseHomePage apHomePage = new AutomationPractiseHomePage();

	@BeforeSuite
	public void loadSetup() throws IOException {
		ConfigurationSetUp();
		Reporter.extentReportSetUp();
		XpathConfigurations("xpathLaod");
	}

	@BeforeClass
	public void loadUrl() {
		initiliazeSetup();
		UrlLaunch();

	}
	
	
	@Test(retryAnalyzer = com.FrameWorkDesign.Listerners.RetryAnalyzer.class , priority = 0 )
	public void verifyClickCreateButton() {
		Reporter.createTest("001", "Verifycreateaccountbutton");
		applyApplicationWaits(20, 25);
		apHomePage.verifyClickSign();
		apHomePage.verifyemailAddress("venkay67@mail.com");
		apHomePage.verifyClickCreateAccount();

	}

	@Test(priority = 1)
	public void verifyresigstration() {
		Reporter.createTest("002", "VerifyRegistration");
		apHomePage.verifyRegistration("Male", "karthick", "Jessy", "Password1", "6", "3", "1996", "Alphatech",
				"No 139 Siruseri , dlf techpark", "chennai", "Alaska", "4", "75036", "HelloPageRegistrationcheck",
				"5588664470", "9988774450", "jaisankartesta@gmail.com");

	}

	@Test(priority = 2)
	public void verifyLogout() {
		Reporter.createTest("003", "LoggoingoutFromApplication");
		apHomePage.verifylogout();
	}

	@Test(priority = 4)
	public void verifySignIn() {
		Reporter.createTest("004", "Verify Sign In");
		apHomePage.logInPage("venkay67@mail.com", "Password1");
	}

	@Test(priority = 3)
	public void verifyForgotPassword() {
		Reporter.createTest("005", "Verify ForgotPasswordlink");
		apHomePage.forgotPassword("venkay26@mail.com",
				"A confirmation email has been sent to your address: venkay26@mail.com");
	}

}
