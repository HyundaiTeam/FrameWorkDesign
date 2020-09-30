package com.FrameWorkDesign.Ultilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.checkerframework.common.reflection.qual.GetMethod;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.FrameWorkDesign.Base.CommonComponents;
import com.FrameWorkDesign.Config.ConfigurationLoader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reporter extends ConfigurationLoader {

	/*
	 * hardcore value remove takesnapshot -- methodname takesnapshot -- randonnummer
	 */

	private static final Logger log = Logger.getLogger(Log.class.getClass());
	static ExtentReports extent;
	static ExtentTest test;
	public static Method method;

	public static ExtentReports extentReportSetUp() {
		try {
			extent = new ExtentReports(prop.getProperty("extentreportpath"));
			extent.loadConfig(new File(prop.getProperty("extentconfiguration")));
			extent.addSystemInfo("User Name", prop.getProperty("UserName"));//
			extent.addSystemInfo("Host Name", prop.getProperty("HostName"));//
			log.info("ExtentReport setUp Complete , ready to StartTest");
		} catch (NullPointerException e) {
			log.error("Given path value is not valid ", e);
		} catch (Exception e) {
			log.error("Error found while loading extentReport", e);
		}
		return extent;
	}

	public static ExtentTest createTest(String testcasename, String testcasedesc) {
		try {
			test = extent.startTest(testcasename, testcasedesc);
			log.info("Extent report - Create Test is initiated");
		} catch (Exception e) {
			log.error("Unknown error Found on Creating test", e);
		}
		return test;
	}

	public void endTest() {
		if (test != null) {
			extent.endTest(test);
			log.info("Extent Report closed with testcases executed-closing extent report ");
		}
		if (test == null) {
			log.info("No test cases to execute and attach - closing extent report ");
		}
	}

	public void endresult() {
		extent.flush();
		log.info("ExtentReport is ready to view ");
	}

	public static void reportStep(String message, String status) {
		if (status.equalsIgnoreCase("PASS")) {
			test.log(LogStatus.PASS, message);
			log.info("extent report step tracked as Passed");
		} else if (status.equalsIgnoreCase("INFO")) {
			test.log(LogStatus.INFO, message);
			log.info("extent report step tracked as Info");
		} else if (status.equalsIgnoreCase("WARN")) {
			test.log(LogStatus.WARNING, message);
			log.info("extent report step tracked as Warning");
		} else if (status.equalsIgnoreCase("FAIL")) {
			test.log(LogStatus.FAIL, message);


		}
	}

	public static long takeScreenshot() {
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
		try {
			TakesScreenshot srchot = (TakesScreenshot) driver;
			File src = srchot.getScreenshotAs(OutputType.FILE);
			File desc = new File(prop.getProperty("screenevidance") + number + ".jpg");
			FileUtils.copyFile(src, desc);
		} catch (NullPointerException e) {
			log.error("Empty value in the path", e);
		} catch (IOException e) {
			log.error("Error in File Operations", e);
		}
		return number;

	}
	
	public void captureExtent(String imagePath) {
		test.addScreenCapture(imagePath);
	}

}
