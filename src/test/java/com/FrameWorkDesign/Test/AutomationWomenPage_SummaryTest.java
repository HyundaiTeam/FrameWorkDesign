package com.FrameWorkDesign.Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.FrameWorkDesign.Base.CommonComponents;
import com.FrameWorkDesign.Page.Automation_Practice_Women_SummaryPage;
import com.FrameWorkDesign.Ultilities.Reporter;

public class AutomationWomenPage_SummaryTest extends CommonComponents {

	Automation_Practice_Women_SummaryPage summary = new Automation_Practice_Women_SummaryPage();

	@Test(priority = 11)
	public void summaryLanding() {
		Reporter.createTest("012", "summaryLanding");
		summary.summaryPageVerification("SHOPPING-CART SUMMARY");

	}

	@Test(priority = 12)
	public void qtyIncrese() {
		Reporter.createTest("013", "qtyIncrese");
		summary.summaryQtyIncrease();

	}

}