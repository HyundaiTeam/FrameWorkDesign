package com.FrameWorkDesign.Listerners;

import java.awt.print.Printable;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.FrameWorkDesign.Base.CommonComponents;


public class ApplyListeners extends CommonComponents implements ITestListener {

	public void onTestStart(ITestResult result) {
		
		
	}

	public void onTestSuccess(ITestResult result) {
		
		String MethodName= result.getName().toString().trim();
		TakesScreenshot srchot = (TakesScreenshot) driver;
		File src = srchot.getScreenshotAs(OutputType.FILE);
		File desc = new File(prop.getProperty("screenevidance") + MethodName + ".jpg");
		report.captureExtent(prop.getProperty("screenevidance")+MethodName+".jpg");
		try {
			FileUtils.copyFile(src, desc);
		} catch (IOException e) {
	           System.out.println("error in IO "+e);
		}

		

	}

	public void onTestFailure(ITestResult result) {
		String MethodName= result.getName().toString().trim();
		TakesScreenshot srchot = (TakesScreenshot) driver;
		File src = srchot.getScreenshotAs(OutputType.FILE);
		File desc = new File(prop.getProperty("screenevidance") + MethodName + ".jpg");
		report.captureExtent(prop.getProperty("screenevidance")+MethodName+".jpg");
		try {
			FileUtils.copyFile(src, desc);
		} catch (IOException e) {
	           System.out.println("error in IO "+e);
		}
		

	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

	}
	

	
}
