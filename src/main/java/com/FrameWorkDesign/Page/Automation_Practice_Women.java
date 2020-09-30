package com.FrameWorkDesign.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.FrameWorkDesign.Base.CommonComponents;
import com.FrameWorkDesign.Ultilities.Reporter;

public class Automation_Practice_Women extends CommonComponents {

	public static String addedProductName;

	public static String nameDelivery;
	public static String nameAddress;

	public void tShirtSelection() {

		clickByXpath(xprop.getProperty("xpath.womenLink"), "Women");

		getTextByXpath(xprop.getProperty("xpath.verifyWomen"), "Women");
		clickByXpath(xprop.getProperty("xpath.womenTops"), "Women-Tops Expand");

		clickByXpath(xprop.getProperty("xpath.womenTshirts"), "Women-Tshirts");

		moveToElement(xprop.getProperty("xpath.moveToWomen"));

		clickByXpath(xprop.getProperty("xpath.addToCart"), "AddToCart");

	}

	public void continueShopping(String tShirt) {

		clickByXpath(xprop.getProperty("xpath.continueShoppping"), "ContinueShopping");

		getTextByXpath(xprop.getProperty("xpath.tShirtselectionVerify"), tShirt);// T-shirts

		moveToElement(xprop.getProperty("xpath.moveToWomen"));
		clickByXpath(xprop.getProperty("xpath.addToCart"), "AddToCart");

	}

	public void selectionPopupVerify() {

		getTextByXpath(xprop.getProperty("xpath.prodAdded"), "Product successfully added to your shopping cart");

		WebElement prodAdded = driver.findElement(By.xpath(xprop.getProperty("xpath.AddedProdName")));

		addedProductName = prodAdded.getText();
		System.out.println(addedProductName + "addedProductName");

		// getText(xprop.getProperty("xpath.AddedProdName"));

		clickByJsXpath(xprop.getProperty("xpath.SelectioncheckOut"));
	}

	/// ---------------------------------Address---------------------------

	public void addressHeaderVerification(String address) {

		getTextByXpath(xprop.getProperty("xpath.addressHeading"), address);// Addresses

		selectByVisibleIndexByXpath(xprop.getProperty("xpath.deliveryAddDd"), 0);

	}

	public void addressDetailsVerification() {

		String addressName = getText(xprop.getProperty("xpath.addressNameVerify"));

		String addressver = getText(xprop.getProperty("xpath.addVerification"));

		if (nameDelivery.equalsIgnoreCase(addressName)) {

			Reporter.reportStep(
					"Summary Page  Name" + nameDelivery + "is matching with the address page name" + addressName,
					"PASS");
		} else {

			Reporter.reportStep(
					"Summary Page  Name" + nameDelivery + "is not matching with the address page name" + addressName,
					"FAIL");
		}
		if (nameAddress.equalsIgnoreCase(addressver)) {

			Reporter.reportStep(
					"Summary Page  Name" + nameAddress + "is matching with the address page name" + addressver, "PASS");

		} else {

			Reporter.reportStep(
					"Summary Page  Name" + nameAddress + "is not matching with the address page name" + addressver,
					"FAIL");
		}

		clickByXpath(xprop.getProperty("xpath.addCheckOut"), "Address Checkout");
	}
	// ----------------------------------------------------Shipping---------------------------------------------

	public void shippingPageVerification(String ship, String terms) {

		getTextByXpath(xprop.getProperty("xpath.shippingHeader"), ship);// Shipping

		/*
		 * clickByXpath(xprop.getProperty("xpath.shippingCheckout"),
		 * "CheckingShipping");
		 *
		 * getTextByXpath(xprop.getProperty("xpath.termsError"), terms);//You must agree
		 * to the terms of service before continuing.
		 *
		 * clickByJsXpath(xprop.getProperty("xpath.errorClose"));
		 */

	}

	public void clickTerms() {

		clickByXpath(xprop.getProperty("xpath.TermsShipping"), "Shipping-Terms");

		clickByXpath(xprop.getProperty("xpath.shippingCheckout"), "Checking-Shipping");

	}

	// ------------------------------------Payment
	// Page----------------------------------------------

	public void paymentVerify(String text) {

		getTextByXpath(xprop.getProperty("xpath.paymentHeader"), text);

		String payProduct = getText(xprop.getProperty("xpath.paymentProductConfir"));

		if (addedProductName.equalsIgnoreCase(payProduct)) {

			Reporter.reportStep("Selection Page product Name" + addedProductName
					+ "is matching with the payment page product name" + payProduct, "PASS");

		} else {

			Reporter.reportStep("Selection Page product Name" + addedProductName
					+ "is not matching with the payment page product name" + payProduct, "FAIL");
		}

	}

	public void paymentSelection(String order, String payment) {
		// clickByXpath(xprop.getProperty("xpath.paymentbank"), "Bank wire");
		clickByJsXpath(xprop.getProperty("xpath.paymentbank"));

		getTextByXpath(xprop.getProperty("xpath.summaryHeader"), order);// Order summary
		getTextByXpath(xprop.getProperty("xpath.payConfirmation"), payment);// Bank-wire payment.

	}

	public void alternativePaymentSelection(String cheque) {

		clickByXpath(xprop.getProperty("xpath.altPayment"), "Alternative payment");

		clickByXpath(xprop.getProperty("xpath.altCheque"), "Cheque Payment");

		getTextByXpath(xprop.getProperty("xpath.altChequeConfirm"), cheque);// Check payment.
	}

	public void paymentConfirm(String ordersuccess) {

		clickByXpath(xprop.getProperty("xpath.paymentorder"), "Payment Order");

		getTextByXpath(xprop.getProperty("xpath.PayConfirmationtext"), ordersuccess);// Your order on My Store is
																						// complete.

	}

}
