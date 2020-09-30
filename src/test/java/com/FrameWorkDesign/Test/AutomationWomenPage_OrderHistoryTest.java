package com.FrameWorkDesign.Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.FrameWorkDesign.Base.CommonComponents;
import com.FrameWorkDesign.Page.Automation_Practice_Women_OrderHistoryPage;
import com.FrameWorkDesign.Ultilities.Reporter;

public class AutomationWomenPage_OrderHistoryTest extends CommonComponents {

	Automation_Practice_Women_OrderHistoryPage orderHistory = new Automation_Practice_Women_OrderHistoryPage();

	@Test(priority = 21)
	public void navOrderHistory() {
		Reporter.createTest("022", "navOrderHistory");

		orderHistory.orderHistoryNav("Order history");
	}

	@Test(priority = 22)
	public void verifyOrderHistoryProduct() {
		Reporter.createTest("023", "verifyOrderHistoryProduct");
		orderHistory.orderHisotryProduct("Test", "Message successfully sent");
	}

	@Test(priority = 23)
	public void orderReorderVerify() {
		Reporter.createTest("024", "orderReorderVerify");
		orderHistory.reorderVerify("Shopping-cart summary");

	}
	
	@AfterMethod
	public void teardown() {
		report.endTest();

	}

	@AfterClass
	public void closeresources() {
		report.endresult();
		quitAllBroswer();
	}

}