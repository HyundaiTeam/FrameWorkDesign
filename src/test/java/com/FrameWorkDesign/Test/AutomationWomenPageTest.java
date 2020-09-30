package com.FrameWorkDesign.Test;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.FrameWorkDesign.Base.CommonComponents;
import com.FrameWorkDesign.Page.AutomationPractiseHomePage;
import com.FrameWorkDesign.Page.Automation_Practice_Women;
import com.FrameWorkDesign.Ultilities.Reporter;

public class AutomationWomenPageTest extends CommonComponents {

	Automation_Practice_Women womenPg = new Automation_Practice_Women();

	

	@Test(priority = 8)

	public void clothSelection() {
		Reporter.createTest("009", "clothSelection");
		applyApplicationWaits(20, 25);
		womenPg.tShirtSelection();
	}

	@Test(priority = 9)
	public void shoppingContinue() {
		Reporter.createTest("010", "shoppingContinue");
		womenPg.continueShopping("T-shirts");

	}

	@Test(priority = 10)
	public void verifySelectionPopup() {
		Reporter.createTest("011", "verifySelectionPopup");
		womenPg.selectionPopupVerify();
	}

	@Test(priority = 13)
	public void addressVerify() {
		Reporter.createTest("014", "addressVerify");
		womenPg.addressHeaderVerification("Addresses");
	}

	@Test(priority = 14)
	public void detailOfAddress() {
		Reporter.createTest("015", "detailOfAddress");
		womenPg.addressDetailsVerification();
	}

	@Test(priority = 15)
	public void shippingVerify() {
		Reporter.createTest("016", "shippingVerify");
		womenPg.shippingPageVerification("Shipping", "You must agree to the terms of service before continuing.");

	}

	@Test(priority = 16)
	public void shippingTerms() {
		Reporter.createTest("017", "shippingTerms");
		womenPg.clickTerms();

	}

	@Test(priority = 17)
	public void verifyPayment() {

		Reporter.createTest("018", "verifyPayment");
		womenPg.paymentVerify("Please choose your payment method");
	}

	@Test(priority = 18)

	public void selectPayment() {
		Reporter.createTest("019", "selectPayment");
		womenPg.paymentSelection("Order summary", "BANK-WIRE PAYMENT.");

	}

	@Test(priority = 19)
	public void selectAlterPayment() {
		Reporter.createTest("020", "selectAlterPayment");
		womenPg.alternativePaymentSelection("Check payment.");
	}

	@Test(priority = 20)
	public void confirmPayment() {
		Reporter.createTest("021", "confirmPayment");
		womenPg.paymentConfirm("Your order on My Store is complete.");
	}

}