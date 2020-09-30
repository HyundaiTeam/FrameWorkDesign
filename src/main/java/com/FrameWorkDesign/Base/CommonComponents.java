package com.FrameWorkDesign.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.Point;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.FrameWorkDesign.Config.ConfigurationLoader;
import com.FrameWorkDesign.Ultilities.Reporter;
import com.aventstack.extentreports.Status;

public class CommonComponents extends ConfigurationLoader {

	private final Logger log = Logger.getLogger(Log.class.getClass());
	public Reporter report = new Reporter();
	public List<WebElement> listnamelemnts;
	public Actions act;
	public JavascriptExecutor jscrip;
	public WebDriverWait wait;
	public List<WebElement> listElementsId;
	public List<WebElement> listElementsXpath;

	public void findById(String idValue) {
		try {
			driver.findElement(By.id(idValue));
			Reporter.reportStep("FindById Success addressFound", "PASS");
		} catch (NoSuchElementException e) {
			Reporter.reportStep("FindById failure addressnotFound" + e, "FAIL");
		}
	}

	public void findByXpath(String xpathValue) {
		try {
			driver.findElement(By.xpath(xpathValue));
			Reporter.reportStep("FindById Success addressFound", "PASS");
		} catch (NoSuchElementException e) {
			Reporter.reportStep("FindById failure addressnotFound" + e, "FAIL");
		} catch (Exception e) {
			Reporter.reportStep("FindById failure" + e, "FAIL");
		}

	}

	public List<WebElement> elementsByName(String namevalue) {
		try {
			listnamelemnts = driver.findElements(By.name(namevalue));
			Reporter.reportStep("elementsByName Success addressFound", "PASS");
			if (listnamelemnts == null) {
				Reporter.reportStep("elementsbyName returns null", "INFO");
			}
		} catch (NoSuchElementException e) {
			Reporter.reportStep("elementsByName failure addressnotFound" + e, "FAIL");
		} catch (Exception e) {
			Reporter.reportStep("elementsByName failure" + e, "FAIL");
		}
		return listnamelemnts;
	}

	public void enterById(String idvalue, String iddata) {
		try {
			driver.findElement(By.id(idvalue)).clear();
			driver.findElement(By.id(idvalue)).sendKeys(iddata);
			Reporter.reportStep("enterById success idvalue entered", "PASS");
		} catch (NoSuchElementException e) {
			Reporter.reportStep("enterById failure idvalue addressnotFound", "FAIL");
		} catch (Exception e) {
			Reporter.reportStep("enterById failure" + e, "FAIL");
		}

	}

	public void enterByXpath(String xpathvalue, String xpathdata) {
		try {
			driver.findElement(By.xpath(xpathvalue)).clear();
			driver.findElement(By.xpath(xpathvalue)).sendKeys(xpathdata);
			Reporter.reportStep("enterByXpath success xpathvalue entered", "PASS");
		} catch (NoSuchElementException e) {
			Reporter.reportStep("enterByXpath failure xpathvalue addressnotFound", "FAIL");
		} catch (Exception e) {
			Reporter.reportStep("enterByXpath failure" + e, "FAIL");
		}

	}

	public boolean verifyIsDisplyedById(String idvalue) {
		boolean bFlag = false;
		try {
			WebElement element = driver.findElement(By.id(idvalue));
			if (element.isDisplayed()) {
				bFlag = true;
				Reporter.reportStep("verifyIsDisplyedById success ", "PASS");
			}
		} catch (NoSuchElementException e) {
			Reporter.reportStep("verifyIsDisplyedById failure idvalue addressnotFound", "FAIL");
		} catch (Exception e) {
			Reporter.reportStep("verifyIsDisplyedById failure" + e, "FAIL");

		}
		return bFlag;
	}

	public boolean verifyIsDisplyedByxpath(String xpathvalue) {

		boolean bFlag = false;
		try {
			WebElement element = driver.findElement(By.xpath(xpathvalue));
			if (element.isDisplayed()) {
				bFlag = true;
				Reporter.reportStep("verifyIsDisplyedByxpath success ", "PASS");
			}
		} catch (NoSuchElementException e) {
			Reporter.reportStep("verifyIsDisplyedByxpath failure xpathvalue addressnotFound", "FAIL");
		} catch (Exception e) {
			Reporter.reportStep("verifyIsDisplyedByxpath failure" + e, "FAIL");

		}
		return bFlag;

	}

	public boolean verifyIsSelectedById(String idvalue) {
		boolean bFlag = false;
		try {
			WebElement element = driver.findElement(By.id(idvalue));
			element.click();
			if (element.isSelected()) {
				bFlag = true;
				Reporter.reportStep("verifyIsSelectedById success ", "PASS");
			}
		} catch (NoSuchElementException e) {
			Reporter.reportStep("verifyIsSelectedById failure-addressnotFound", "FAIL");
		} catch (Exception e) {
			Reporter.reportStep("verifyIsSelectedById failure" + e, "FAIL");

		}
		return bFlag;

	}

	public boolean verifyIsSelectedByXpath(String xpathvalue) {
		boolean bFlag = false;
		try {
			WebElement element = driver.findElement(By.xpath(xpathvalue));
			element.click();
			if (element.isSelected()) {
				bFlag = true;
				Reporter.reportStep("verifyIsSelectedByXpath success ", "PASS");
			}
		} catch (NoSuchElementException e) {
			Reporter.reportStep("verifyIsSelectedByXpath failure-addressnotFound", "FAIL");
		} catch (Exception e) {
			Reporter.reportStep("verifyIsSelectedByXpath failure" + e, "FAIL");
		}
		return bFlag;
	}

	public void selectValueById(String idvalue, String valuNum) {
		try {
			WebElement element = driver.findElement(By.id(idvalue));
			element.click();
			Select radiochec = new Select(element);
			radiochec.selectByValue(valuNum);
			Reporter.reportStep("selectValueById success ", "PASS");
		} catch (NoSuchElementException e) {
			Reporter.reportStep("selectValueById failure-addressnotFound", "FAIL");
		} catch (Exception e) {
			Reporter.reportStep("selectValueById failure" + e, "FAIL");
		}
	}

	public void selectValueByXpath(String xpathvalue, String valuNum) {
		try {
			WebElement element = driver.findElement(By.xpath(xpathvalue));
			Select radiochec = new Select(element);
			radiochec.selectByValue(valuNum);
			Reporter.reportStep("selectValueByXpath success ", "PASS");
		} catch (NoSuchElementException e) {
			Reporter.reportStep("selectValueByXpath failure addressnotFound", "FAIL");
		} catch (Exception e) {
			Reporter.reportStep("selectValueByXpath failure" + e, "FAIL");
		}
	}

	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
			Reporter.reportStep("acceptAlert Accepted", "PASS");
		} catch (NoAlertPresentException e) {
			Reporter.reportStep("acceptAlert method failure" + e, "FAIL");
		} catch (UnhandledAlertException e) {
			Reporter.reportStep("acceptAlert method failure" + e, "FAIL");
		} catch (Exception e) {
			Reporter.reportStep("acceptAlert failure" + e, "FAIL");
		}

	}

	public void AlertsendKeys(String alerttext) {
		try {
			driver.switchTo().alert().sendKeys(alerttext);
			Reporter.reportStep("AlertsendKeys value entered ", "PASS");
		} catch (NoAlertPresentException e) {
			Reporter.reportStep("AlertsendKeys method failure" + e, "FAIL");
		} catch (UnhandledAlertException e) {
			Reporter.reportStep("AlertsendKeys method failure" + e, "FAIL");
		} catch (Exception e) {
			Reporter.reportStep("AlertsendKeys failure" + e, "FAIL");
		}
	}

	public void getFrameByElement(String xpathvalue) {
		try {
			WebElement element = driver.findElement(By.xpath(xpathvalue));
			driver.switchTo().frame(element);
			Reporter.reportStep("getFrameByElement method , moved to frameElement ", "PASS");
		} catch (NoSuchFrameException e) {
			Reporter.reportStep("getFrameByElement failed  " + e, "FAIL");
		} catch (Exception e) {
			Reporter.reportStep("getFrameByElement failed  " + e, "FAIL");
		}
	}

	public void getFrameByStrings(String stringvalue) {
		try {
			driver.switchTo().frame(stringvalue);
			Reporter.reportStep("getFrameByStrings, movedtoframe by stringvalue", "PASS");
		} catch (NoSuchFrameException e) {
			Reporter.reportStep("getFrameByStrings failed  " + e, "FAIL");
		} catch (Exception e) {
			Reporter.reportStep("getFrameByStrings failed  " + e, "FAIL");
		}

	}

	public void getFrameByIndex(int ValueNum) {
		try {
			driver.switchTo().frame(ValueNum);
			Reporter.reportStep("getFrameByIndex success , moved to frame by index", "PASS");
		} catch (NoSuchFrameException e) {
			Reporter.reportStep("getFrameByIndex failed  " + e, "FAIL");
		} catch (Exception e) {
			Reporter.reportStep("getFrameByIndex failed  " + e, "FAIL");
		}
	}

	public void verifyPageTitle(String expectedText) {

		try {
			String actualtext = driver.getTitle();
			if (actualtext.equalsIgnoreCase(expectedText)) {
				Reporter.reportStep("verifyPageTitle success , Page titled verified", "PASS");
			} else {
				Reporter.reportStep("verifyPageTitle failed , Page titled verifed but not matched ", "FAIL");
			}
		} catch (Exception e) {
			Reporter.reportStep("verifyPageTitle failed " + e, "FAIL");
		}

	}

	public void verifyAlerttext(String expectedtext) {

		try {
			String actualtext = driver.switchTo().alert().getText();
			if (actualtext.equalsIgnoreCase(expectedtext)) {
				Reporter.reportStep("verifyAlerttext success , Alert text verified", "PASS");
			} else {
				Reporter.reportStep("verifyAlerttext failed , Alert text verifed but not matched ", "FAIL");
			}
		} catch (Exception e) {
			Reporter.reportStep("verifyAlerttext failed " + e, "FAIL");
		}

	}

	public void applyApplicationWaits(int imtime, int pltime) {
		driver.manage().timeouts().implicitlyWait(imtime, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(pltime, TimeUnit.SECONDS);
		Reporter.reportStep("Applied wait of Implictwait" + imtime + ",Pageloadtimeouts:" + pltime, "INFO");
	}

	public void applybrowserreferesh() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Reporter.reportStep("Browser refersh and Cookies deletion done", "INFO");
	}

	public void applyWindowHandles(int windowindex) {
		boolean bFlag = false;
		try {
			Set<String> windowHandle = driver.getWindowHandles();
			if (windowHandle.isEmpty() == bFlag) {
				ArrayList<String> arrlist = new ArrayList<String>();
				arrlist.addAll(windowHandle);
				arrlist.get(windowindex);
				Reporter.reportStep("applyWindowHandles to the specific index", "PASS");
			}
		} catch (NullPointerException e) {
			Reporter.reportStep("applyWindowHandles doesnt return any SetValues ", "FAIL");
		} catch (Exception e) {
			Reporter.reportStep("applyWindowHandles failure ", "FAIL");

		}
	}

	public void closeBrowser() {
		driver.close();
		Reporter.reportStep("Browser current window closed ", "INFO");
	}

	public void quitAllBroswer() {
		driver.quit();
		Reporter.reportStep("Browsers window Opened in this session closes ", "INFO");

	}

	public void ClickHoldByXpath(String xpathValue) {
		try {
			WebElement element = driver.findElement(By.xpath(xpathValue));
			act = new Actions(driver);
			act.clickAndHold(element).perform();
		} catch (NoSuchElementException e) {
			Reporter.reportStep("ClickHoldByXpath failure " + e, "FAIL");
		} catch (Exception e) {
			Reporter.reportStep("ClickHoldByXpath failure" + e, "FAIL");
		}
	}

	public void ClickAndHoldById(String idValue) {
		try {
			WebElement element = driver.findElement(By.id(idValue));
			act = new Actions(driver);
			act.clickAndHold(element).perform();
		} catch (NoSuchElementException e) {
			Reporter.reportStep("ClickAndHoldById failure" + e, "FAIL");
		} catch (Exception e) {
			Reporter.reportStep("ClickAndHoldById failure " + e, "FAIL");
		}
	}

	public void actionsDragAndDrop(String srcXapthvalue, String descXpathValue) {
		try {
			WebElement srcele = driver.findElement(By.xpath(srcXapthvalue));
			WebElement desele = driver.findElement(By.xpath(descXpathValue));
			act = new Actions(driver);
			act.dragAndDrop(srcele, desele).perform();
		} catch (NoSuchElementException e) {
			Reporter.reportStep("actionsDragAndDrop failure of address unkown" + e, "FAIL");
		} catch (Exception e) {
			Reporter.reportStep("actionsDrapAndDrop failure  " + e, "FAIL");
		}
	}

	public void scrollBycordinates(String xpathvalue) {
		try {
			WebElement element = driver.findElement(By.xpath(xpathvalue));
			Point elementloc = element.getLocation();
			int xcordinate = elementloc.getX();
			int ycordinate = elementloc.getY();
			jscrip = (JavascriptExecutor) driver;
			jscrip.executeScript("window.scrollBy(" + xcordinate + "," + ycordinate + ")");
			Reporter.reportStep("scrollBycordinates success , moved to particular element ", "PASS");
		} catch (NoSuchElementException e) {
			Reporter.reportStep("scrollBycordinates fail  due to Address not found" + e, "FAIL");
		} catch (Exception e) {
			Reporter.reportStep("scrollBycordinates fail " + e, "FAIL");
		}
	}

	public void scrollByBodyPage() {
		try {
			jscrip = (JavascriptExecutor) driver;
			jscrip.executeScript("window.scrollTo(0, document.body.scrollHeight");
			Reporter.reportStep("scrollByBodyPage success , scroll to the body  document", "PASS");
		} catch (Exception e) {
			Reporter.reportStep("scrollByBodyPage failure" + e, "FAIL");
		}
	}

	public void clickByJsXpath(String xpathValue) {
		try {
			WebElement Element = driver.findElement(By.xpath(xpathValue));
			jscrip = (JavascriptExecutor) driver;
			jscrip.executeScript("arguments[0].click();", Element);
			Reporter.reportStep("clickByJsXpath succeess , element clicked by jsClick", "PASS");
		} catch (Exception e) {
			Reporter.reportStep("clickByJsXpath failure  , element not clicked by jsClick", "FAIL");
		}
	}

	public void elementSelectionStateToBe(int waittime, String xpathvalue) {
		try {
			wait = new WebDriverWait(driver, waittime);
			WebElement element = driver.findElement(By.xpath(xpathvalue));
			wait.until(ExpectedConditions.elementSelectionStateToBe(element, true));
			Reporter.reportStep("elementSelectionStateToBe wait condition verified", "PASS");
		} catch (Exception e) {
			Reporter.reportStep("elementSelectionStateToBe wait condition not verified" + e, "FAIL ");
		}
	}

	public void elementToBeSelected(int waittime, String xpathvalue) {
		try {
			WebElement element = driver.findElement(By.xpath(xpathvalue));
			wait = new WebDriverWait(driver, waittime);
			wait.until(ExpectedConditions.elementToBeSelected(element));
			Reporter.reportStep("elementToBeSelected wait condition verified", "PASS");
		} catch (Exception e) {
			Reporter.reportStep("elementToBeSelected wait condition not verified" + e, "FAIL ");
		}

	}

	public void visibilityOf(int waittime, String xpathvalue) {
		try {
			WebElement element = driver.findElement(By.xpath(xpathvalue));
			wait = new WebDriverWait(driver, waittime);
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.reportStep("visibilityOf wait condition verified", "PASS");
		} catch (Exception e) {
			Reporter.reportStep("visibilityOf wait condition  not verified", "PASS");
		}
	}

	public void findElementByName(String name) {

		try {
			driver.findElement(By.name(name));
			Reporter.reportStep("Name Element found successfully", "PASS");
		} catch (NoSuchElementException e) {
			Reporter.reportStep("Unable to find Name Element", "FAIL");
		}
	}

	public List<WebElement> findElementsById(String id) {
		try {
			listElementsId = driver.findElements(By.id(id));
			Reporter.reportStep("FindElementsById element found successfully", "PASS");
			if (listElementsId == null) {
				Reporter.reportStep("FindElementsById element Returns Null", "INFO");
			}
		} catch (NoSuchElementException e) {
			Reporter.reportStep("Unable to find FindElementsById element", "FAIL");
		}
		return listElementsId;
	}

	public List<WebElement> findElementsByXpath(String xpath) {

		try {
			listElementsXpath = driver.findElements(By.id(xpath));
			Reporter.reportStep("findElementsByXpath element found successfully", "PASS");
			if (listElementsXpath == null) {
				Reporter.reportStep("findElementsByXpath element Returns Null", "INFO");
			}
		} catch (NoSuchElementException e) {
			Reporter.reportStep("Unable to find findElementsByXpath element", "FAIL");
		}
		return listElementsXpath;

	}

	public void clickById(String id, String fieldValue) {

		try {
			WebElement ele = driver.findElement(By.id(id));
			ele.click();
			Reporter.reportStep("ClickById method clicked the" + fieldValue + "successfully", "PASS");
			log.info("clickById element clciked the " + fieldValue + "successfully-PASS");
		} catch (NoSuchElementException e) {
			Reporter.reportStep("Unable to click the" + fieldValue + "with the element Id", "FAIL");
			log.error("Error occured while clicking the" + fieldValue + "FAIL");
		} catch (ElementClickInterceptedException e) {
			Reporter.reportStep("Unable to click the" + fieldValue + "with the element Id", "FAIL");
			log.error("Error occured while clicking the" + fieldValue + "FAIL");
		}

	}

	public void clickByXpath(String xpath, String fieldValue) {

		try {
			WebElement ele = driver.findElement(By.xpath(xpath));
			ele.click();
			Reporter.reportStep("ClickByxpath method clicked the" + fieldValue + "successfully", "PASS");
			log.info("clickByxpath element clciked the " + fieldValue + "successfully-PASS");
		} catch (NoSuchElementException e) {
			Reporter.reportStep("Unable to click the" + fieldValue + "with the element xpath", "FAIL");
			log.error("Error occured while clicking the" + fieldValue + "FAIL");

		} catch (ElementClickInterceptedException e) {
			Reporter.reportStep("Unable to click the" + fieldValue + "with the element xpath", "FAIL");
			log.error("Error occured while clicking the" + fieldValue + "FAIL");

		}

	}

	public void clickByName(String name, String fieldValue) {

		try {
			WebElement ele = driver.findElement(By.name(name));

			ele.click();
			Reporter.reportStep("ClickByname method clicked the" + fieldValue + "successfully", "PASS");
			log.info("clickByname element clciked the " + fieldValue + "successfully-PASS");
		} catch (NoSuchElementException e) {
			Reporter.reportStep("Unable to click the" + fieldValue + "with the element name", "FAIL");
			log.error("Error occured while clicking the" + fieldValue + "FAIL");

		} catch (ElementClickInterceptedException e) {
			Reporter.reportStep("Unable to click the" + fieldValue + "with the element name", "FAIL");
			log.error("Error occured while clicking the" + fieldValue + "FAIL");

		}

	}

	public boolean isEnabledById(String id, String FieldValue) {

		boolean bFlag = false;

		try {
			WebElement ele = driver.findElement(By.id(id));

			boolean enabled = ele.isEnabled();

			if (enabled == true) {

				Reporter.reportStep("isEnabledById method" + FieldValue + "enabled successfully", "PASS");

				log.info(FieldValue + "enabled successfully in the web page-PASS");

			}
		} catch (NoSuchElementException e) {
			Reporter.reportStep("isEnabledById method" + FieldValue + "is not enabled", "FAIL");

			log.error(FieldValue + "unable to enable in the web page-FAIL");

		}

		catch (Exception e) {

			Reporter.reportStep("isEnabledById method" + FieldValue + "is not enabled", "FAIL");

			log.error(FieldValue + "unable to enable the element in the web page-FAIL");

		}

		return bFlag;

	}

	public boolean isEnabledByXpath(String xpath, String FieldValue) {

		boolean bFlag = false;

		try {
			WebElement ele = driver.findElement(By.xpath(xpath));

			boolean enabled = ele.isEnabled();

			if (enabled == true) {

				Reporter.reportStep("isEnabledByXpath method" + FieldValue + "enabled successfully", "PASS");

				log.info(FieldValue + "enabled successfully in the web page-PASS");

			}
		} catch (NoSuchElementException e) {
			Reporter.reportStep("isEnabledByXpath method" + FieldValue + "is not enabled", "FAIL");

			log.error(FieldValue + "unable to enable in the web page-FAIL");

		}

		catch (Exception e) {

			Reporter.reportStep("isEnabledById method" + FieldValue + "is not enabled", "FAIL");

			log.error(FieldValue + "unable to enable the element in the web page-FAIL");

		}

		return bFlag;

	}

	public void enterByName(String name, String data, String fieldValue) {

		try {
			driver.findElement(By.name(name)).clear();
			driver.findElement(By.name(name)).sendKeys(data);
			log.info("enterByName Method" + data + "entered successfully-PASS");
			Reporter.reportStep("The data: " + data + " entered  in field :" + fieldValue + "successfully", "PASS");
		} catch (NoSuchElementException e) {

			log.error("enterByName Method" + data + "is not entered in the" + fieldValue + "-FAIL");
			Reporter.reportStep("Unknown exception occured while entering " + data + " in the field :" + fieldValue,
					"FAIL");
		}

	}

	public void selectByVisibleTextById(String id, String value) {

		try {
			Select sel = new Select(driver.findElement(By.id(id)));

			sel.selectByVisibleText(value);
			Reporter.reportStep("The element with id: " + id + " is selected with value :" + value, "PASS");
			log.info("selectByVisibleTextById method selcted the" + id + "with the value" + value + "-PASS");

		} catch (Exception e) {

			Reporter.reportStep("Error occured while selecting" + value + "with the element id", "FAIL");
			log.error("Unable to select the selectByVisibleText method" + id + "with the value" + value + "-FAIL");
		}

	}

	public void selectByVisibleIndexByXpath(String xpath, int index) {

		try {
			WebElement element = driver.findElement(By.xpath(xpath));
			element.click();
			Select sel = new Select(element);
			sel.selectByIndex(index);
			Reporter.reportStep("The element with xpath: " + index + " is selected successfully", "PASS");
			log.info("selectByVisibleIndexByXpath method selcted the" + index + "value successfully -PASS");

		} catch (Exception e) {

			Reporter.reportStep("The element with xpath: " + index + " is selected successfully", "PASS");
			log.error("Error occured while selecting the value with" + index + "value-FAIL");
		}

	}

	public void dismissAlert() {

		try {
			driver.switchTo().alert().dismiss();
			Reporter.reportStep("Alert dismiss is successfull", "PASS");
			log.info("dismissAlert method executed successfully -PASS");
		} catch (NoAlertPresentException e) {
			Reporter.reportStep("Alert is not present in the webPage", "FAIL");
			log.error("Alert is not found in the webpage -FAIL");
		} catch (UnhandledAlertException e) {
			Reporter.reportStep("Unable to handle the alert", "FAIL");
			log.error("Alert is not found in the webpage -FAIL");
		} catch (Exception e) {
			Reporter.reportStep("Unable to find the alert", "FAIL");
			log.error("Error occured in dismissing the alert-FAIL");

		}
	}

	public void visibilityOfElementLocatedWait(String xpath, int waitTime) {
		WebElement element = null;
		try {
			wait = new WebDriverWait(driver, waitTime);
			element = driver.findElement(By.xpath(xpath));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			Reporter.reportStep(element + "successfully located in the WebPage", "PASS");
			log.error(element + "is located in the webPage-PASS");

		} catch (NoSuchElementException e) {

			Reporter.reportStep("Unable to find the webElement" + element + " in the WebPage ", "FAIL");
			log.error(element + "is not found in the webPage-FAIL");
		}

		catch (Exception e) {
			Reporter.reportStep(element + "is not located in the web page", "FAIL");
			log.error("Error occured while locating the visibility of the" + element + "FAIL");

		}

	}

	public String getTextByXpath(String xpath, String text) {

		String valuetxt = null;
		try {
			WebElement ele = driver.findElement(By.xpath(xpath));

			valuetxt = ele.getText();

			if (valuetxt.equalsIgnoreCase(text)) {

				Reporter.reportStep(
						"The element with xpath: " + text + " is matched with the value" + valuetxt + "successfully",
						"PASS");
				log.info("getTextByXpath method" + text + "is matched with value" + valuetxt + "-PASS");
			}

		} catch (Exception e) {

			Reporter.reportStep(
					"The element with xpath: " + text + " is not matched with the value" + valuetxt + "successfully",
					"FAIL");
			log.info("getTextByXpath method" + text + "is not matched with value" + valuetxt + "-FAIL");
		}

		return valuetxt;
	}

	public void verifyTitle(String TitleVerify) {

		String PageTitle = null;

		try {
			PageTitle = driver.getTitle();

			if (PageTitle.equalsIgnoreCase(TitleVerify)) {

				log.info("Page Tilte verified successfully-PASS");
				Reporter.reportStep("The" + PageTitle + "is matching with the verification Title" + TitleVerify,
						"PASS");

			} else {

				log.error("Error occured in the verification of Page Tilte-FAIL");
				Reporter.reportStep("The" + PageTitle + "is not matching with the verification Title" + TitleVerify,
						"FAIL");
			}
		} catch (Exception e) {

			log.error("Unable to verify the Page Title-FAIL");
			Reporter.reportStep("Error occured in the Page Title verification", "FAIL");

		}

	}

	public void moveToElement(String xpathVal) {

		WebElement element = null;

		try {
			Actions ac = new Actions(driver);

			element = driver.findElement(By.xpath(xpathVal));

			ac.moveToElement(element).build().perform();

			ac.release(element);

			Reporter.reportStep("Actions calss Element moved successfully", "PASS");
			log.info("Move to Element method is Successful-PASS");

		} catch (NoSuchElementException e) {

			Reporter.reportStep("Unable to find the webElement" + element + " in the WebPage", "FAIL");
			log.error(element + "is not found in the webPage-FAIL");
		} catch (Exception e) {

			Reporter.reportStep("Error occured while moving to the" + element + "in the webPage", "FAIL");
			log.error("Unable to move to the element-FAIL");
		}

	}

	public String getText(String xpathVal) {

		WebElement ele = driver.findElement(By.xpath(xpathVal));

		String text = ele.getText();

		System.out.println(text);

		return text;

	}
	
	public void waitByFluent(int timeout , int freseconds) {
		FluentWait<WebDriver> ref = new FluentWait(driver);
		ref.withTimeout(Duration.ofSeconds(timeout)).
		pollingEvery(Duration.ofSeconds(freseconds)).
		ignoring(NullPointerException.class);
	}
	
	public void waitbyImplicit() {
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	}
	
	public void waitByExplicit(String element) {
		WebDriverWait Wait = new WebDriverWait(driver,Duration.ofSeconds(25) );
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
	}

}
