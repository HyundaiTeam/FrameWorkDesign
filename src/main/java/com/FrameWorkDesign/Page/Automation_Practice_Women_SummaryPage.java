package com.FrameWorkDesign.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.FrameWorkDesign.Base.CommonComponents;
import com.FrameWorkDesign.Ultilities.Reporter;

public class Automation_Practice_Women_SummaryPage extends CommonComponents {

	public static String addedProductName;

	public static String nameDelivery;
	public static String nameAddress;

	public void summaryPageVerification(String summary) {

		getTextByXpath(xprop.getProperty("xpath.summaryVerify"), summary);// Shopping-cart summary
		WebElement summaryProdAdded = driver.findElement(By.xpath(xprop.getProperty("xpath.summaryProductName")));
		String summaryAddedProductName = summaryProdAdded.getText();
		System.out.println("Product" + summaryAddedProductName);
		System.out.println(addedProductName);

		if (addedProductName.equalsIgnoreCase(summaryAddedProductName)) {

			Reporter.reportStep("Selection Page product Name" + addedProductName
					+ "is matching with the summary page product name" + summaryAddedProductName, "PASS");

		} else {
			Reporter.reportStep("Selection Page product Name" + addedProductName
					+ "is not matching with the summary page product name" + summaryAddedProductName, "FAIL");

		}

	}

	public void summaryQtyIncrease() {

		clickByXpath(xprop.getProperty("xpath.qtyIncrease"), "Quantity increase");
		clickByJsXpath(xprop.getProperty("xpath.qtyIncrease"));

		nameDelivery = getText(xprop.getProperty("xpath.summaryDeliveryName"));
		nameAddress = getText(xprop.getProperty("xpath.summaryAddressName"));
		clickByXpath(xprop.getProperty("xpath.checkOutSummary"), "Checkout Summary");

	}

}