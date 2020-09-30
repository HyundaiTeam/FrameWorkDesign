package com.FrameWorkDesign.Config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ConfigurationLoader {

	/*
	 * Hardcore value -- remove ChromeOption class
	 */
	public static Properties prop;
	public static Properties xprop;
	public static WebDriver driver;

	private static final Logger log = Logger.getLogger(Log.class.getClass());

	public Properties ConfigurationSetUp() throws IOException {
		try {
			FileInputStream fis = new FileInputStream(
					"C://Users/User//eclipse-workspace//FrameworkDesign//Config.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			log.error("Attached Filepath doesnt contain the given file ");
		} catch (IOException e) {
			log.error("InputOutput Operation Is not performed Properly ");
		}
		return prop;
	}

	public Properties XpathConfigurations(String xpath) {
		try {
			FileInputStream fisa = new FileInputStream(
					"C://Users//User//eclipse-workspace//FrameworkDesign//Xpath.properties");
			xprop = new Properties();
			xprop.load(fisa);
			log.info("xpath properties loaded successfully");
		} catch (FileNotFoundException e) {
			log.error("Attached Filepath doesnt contain the given file ");
		} catch (IOException e) {
			log.error("InputOutput Operation Is not performed Properly ");
		}
		return xprop;

	}

	public void initiliazeSetup() {
		String browsername = prop.getProperty("browser");
		if (browsername.equalsIgnoreCase("Chrome")) {
			try {
				System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriver"));
			} catch (IllegalArgumentException e) {
				log.error("Key is Improper or Not correct");
			} catch (NullPointerException e) {
				log.error("Missing Values or empty value ");
			} catch (IllegalStateException e) {
				log.error("Given Driver is not found in the given path ");
			}

		} else if (browsername.equals("firefox")) {
			try {
				System.setProperty("webdriver.gecko.driver", prop.getProperty("firefox"));
			} catch (IllegalArgumentException e) {
				log.error("Key is Improper or Not correct");
			} catch (NullPointerException e) {
				log.error("Missing Values or empty value ");
			} catch (IllegalStateException e) {
				log.error("Given Driver is not found in the given path ");
			}

		} else if (browsername.equals("Internet Explorer")) {
			try {
				System.setProperty("webdriver.ie.driver", prop.getProperty("InternetExp"));
			} catch (IllegalArgumentException e) {
				log.error("Key is Improper or Not correct");
			} catch (NullPointerException e) {
				log.error("Missing Values or empty value ");
			} catch (IllegalStateException e) {
				log.error("Given Driver is not found in the given path ");
			}
		}

	}

	public void UrlLaunch() {
		try {
			String browsername = prop.getProperty("browser");
			if (browsername.equalsIgnoreCase("Chrome")) {
				
				  ChromeOptions chrmeOption = new ChromeOptions();
				  chrmeOption.addArguments("start-maximized").addArguments("incognito").
				  addArguments("disable-infobars");
				 
				driver = new ChromeDriver(chrmeOption);
				driver.get(prop.getProperty("url"));
			} else if (browsername.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
				driver.get(prop.getProperty("url"));
			} else if (browsername.equalsIgnoreCase("InternetExplorer")) {
				driver = new InternetExplorerDriver();
				driver.get(prop.getProperty("url"));
			}
		} catch (Exception e) {
			log.error("Error in UrlLaunch Method , Unable launch browser " + e);
		}
	}

}
