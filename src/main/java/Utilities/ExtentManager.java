package Utilities;

import org.testng.ITestContext;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import TestBase.BaseTestClass;

public class ExtentManager extends BaseTestClass{

	public static ExtentReports reports;
	public static ExtentTest test;
	
	public static ExtentReports extentReportSetup(){
		reports = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReport\\testReport.html", true);		
		return reports;
	}
	
	public static ExtentTest extentTestSetup(String testName){
		test = reports.startTest(testName);
		return test;
	}
	
	public static void logPassMessage(String str){
		test.log(LogStatus.PASS, str);
	}
	
	public static void logFailMessage(String str){
		test.log(LogStatus.FAIL, str);
	}
	
	public static void logSkippedMessage(String str){
		test.log(LogStatus.SKIP, str);
	}
	
	public static void logInfoMessage(String str){
		test.log(LogStatus.INFO, str);
	}
	
	public static void extentTestTeardown(){
		reports.endTest(test);
	}
	
	public static void extentReportTeardown(){
		reports.flush();
	}
}
