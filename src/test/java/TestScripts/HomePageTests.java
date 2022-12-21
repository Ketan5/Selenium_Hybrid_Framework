package TestScripts;

import org.testng.ITestResult;
import org.testng.annotations.Test;

import TestBase.BaseTestClass;
import Utilities.ExtentManager;
import Utilities.Log;

public class HomePageTests extends BaseTestClass{
	
	@Test
	public void test01(ITestResult result){
		System.out.println("hello");
		Log.info("Hello");
		ExtentManager.logInfoMessage("Hello");
	}

}
