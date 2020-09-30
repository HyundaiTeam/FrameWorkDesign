package com.FrameWorkDesign.Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.FrameWorkDesign.Base.CommonComponents;
import com.FrameWorkDesign.Page.AutomationPractiseMyAccountPage;
import com.FrameWorkDesign.Ultilities.Reporter;
import com.relevantcodes.extentreports.model.ITest;

@Listeners(com.FrameWorkDesign.Listerners.ApplyListeners.class)

public class AutomationMyAccountPageTest extends CommonComponents {

	AutomationPractiseMyAccountPage myaccpage = new AutomationPractiseMyAccountPage();

	@Test(priority = 5)
	public void verifyChooseSection() {
		Reporter.createTest("006", "SelectUserChoise");
		myaccpage.chooseMyAccountSection("myaddress");
	}

	@Test(priority = 6)
	public void verifyAddaddress() {
		Reporter.createTest("007", "VadlidateAddressButton");
		myaccpage.verifyClickAddnewAddressButton();

	}

	@Test(priority = 7)
	public void validateNewAddressAdded() {
		Reporter.createTest("008", "AddAddress");
		myaccpage.verifyNewAddressAdded("No 29C SampathStreet", "Banglore", "Karnatka", "2", "55664", "HelloMynewAddes",
				"996633225", "554477882", "AUTOMATIONADDRESS");
	}

	

}
