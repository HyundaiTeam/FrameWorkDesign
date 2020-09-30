package com.FrameWorkDesign.Page;

import com.FrameWorkDesign.Base.CommonComponents;

public class Automation_Practice_Women_OrderHistoryPage extends CommonComponents {

	public void orderHistoryNav(String header) {
		clickByXpath(xprop.getProperty("xpath.backToOrders"), "Back to Orders");

		getTextByXpath(xprop.getProperty("xpath.orderHistoryHeader"), header);// Order history

	}

	public void orderHisotryProduct(String data, String msg) {

		clickByXpath(xprop.getProperty("xpath.orderDetails"), "Order Details");

		selectByVisibleIndexByXpath(xprop.getProperty("xpath.chooseProduct"), 1);

		enterByXpath(xprop.getProperty("xpath.enterMsg"), data);
		clickByXpath(xprop.getProperty("xpath.sendMsg"), "Send Message");

		getTextByXpath(xprop.getProperty("xpath.successMsg"), msg);// Message successfully sent

	}

	public void reorderVerify(String summary) {
		clickByXpath(xprop.getProperty("xpath.reorder"), "Reorder");

		getTextByXpath(xprop.getProperty("xpath.summarypageLanding"), summary);// Shopping-cart summary

	}

}