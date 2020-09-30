package com.FrameWorkDesign.Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.FrameWorkDesign.Base.CommonComponents;

public class AutomationPractiseMyAccountPage extends CommonComponents {

	public void navigateHomePageByButton() {
		clickByXpath(xprop.getProperty("xpath.acc_home"), "HomeButton");
	}

	public void navigateHomePageByIcon() {
		clickByXpath(xprop.getProperty("xpath.acc_homeicon"), "HomePageicon");
	}

	public void chooseMyAccountSection(String sectionname) {

		if (sectionname.equalsIgnoreCase("orderhistoryanddetail")) {
			clickByXpath(xprop.getProperty("xpath.scc_orderhistory"), "orderhistory");
		} else if (sectionname.equalsIgnoreCase("myCreditslips")) {
			clickByXpath(xprop.getProperty("xpath.acc_creditslips"), "mycreditslips");
		} else if (sectionname.equalsIgnoreCase("myaddress")) {
			clickByXpath(xprop.getProperty("xpath.acc_myaddress"), "myaddress");
		} else if (sectionname.equalsIgnoreCase("mypersonalinformation")) {
			clickByXpath(xprop.getProperty("xpath.acc_mypersonal"), "personalInformation");
		} else if (sectionname.equalsIgnoreCase("xpath.acc_wishlist")) {
			clickByXpath(xprop.getProperty("xpath.acc_wishlist"), "wishlist");
		}
	}

	public void chooseAddresstoUpdate(String expectext) {

		List<WebElement> header = driver.findElements(By.xpath(xprop.getProperty("xpath.acc_myaddressheader")));
		for (int i = 0; i <= header.size(); i++) {
			String actualtext = header.get(i).getText();
			if (actualtext.equalsIgnoreCase(expectext)) {
				clickByXpath(xprop.getProperty("xpath.acc_myaddressupdatecbefore" + i + "]"), "Update");
			}
		}
	}

	public void chooseAddresstoDelete(String expectext) {

		List<WebElement> header = driver.findElements(By.xpath(xprop.getProperty("xpath.acc_myaddressheader")));
		for (int i = 1; i <= header.size(); i++) {
			String actualtext = header.get(i).getText();
			if (actualtext.equalsIgnoreCase(expectext)) {
				clickByXpath(xprop.getProperty("xpath.acc_myaddressdeletebefore" + i + "]"), "Delete");
			}
		}

	}

	public void verifyClickAddnewAddressButton() {

		clickByXpath(xprop.getProperty("xpath.acc_myaddressAddAddress"), "Add a NewAddress");

	}

	public void verifyNewAddressAdded(String enterregaddres, String enterregaddres2, String enterCity,
			String enterstate, String enterpostalcode, String enterinformation, String enterphnome,
			String entermobilephone, String enterseconaddress) {
		enterByXpath(xprop.getProperty("xpath.Reg_address1"), enterregaddres);
		enterByXpath(xprop.getProperty("xpath.Reg_address2"), enterregaddres2);
		enterByXpath(xprop.getProperty("xpath.Reg_city"), enterCity);
		selectValueByXpath(xprop.getProperty("xpath.Reg_state"), enterstate);
		enterByXpath(xprop.getProperty("xpath.Reg_postcode"), enterpostalcode);
		enterByXpath(xprop.getProperty("xpath.Reg_others"), enterinformation);
		enterByXpath(xprop.getProperty("xpath.Reg_landphone"), enterphnome);
		enterByXpath(xprop.getProperty("xpath.Reg_mobile"), entermobilephone);
		enterByXpath(xprop.getProperty("xpath.Reg_alias"), enterseconaddress);
		clickByXpath(xprop.getProperty("xpath.acc_myaddressSaveAddress"), "Submit");
	}

	public void verifyPasswordChange(String oldPasswd, String newPasswd, String Confirmpasswd) {
		enterByXpath(xprop.getProperty("xpath.accpi_currentpassword"), oldPasswd);
		enterByXpath(xprop.getProperty("xpath.accpi_newpass word"), newPasswd);
		enterByXpath(xprop.getProperty("xpath.accpi_confirmpasswrd"), Confirmpasswd);
		clickByXpath(xprop.getProperty("xpath.accpi_save"), "save");
	}

	public void verifyAddressUpdate(String address, String addreess2, String city) {
		enterByXpath(xprop.getProperty("xpath.Reg_address1"), address);
		enterByXpath(xprop.getProperty("xpath.Reg_address2"), addreess2);
		enterByXpath(xprop.getProperty("xpath.Reg_city"), city);
		clickByXpath(xprop.getProperty("xpath.accupad_save"), "Save");
	}

	public void verifyAddressDelete() {
		acceptAlert();
	}

}
