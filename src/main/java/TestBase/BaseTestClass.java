package TestBase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import ObjectFactory.DriverObjectFactory;
import ObjectFactory.DriverObjectFactory.DriverType;
import Utilities.ExtentManager;
import ObjectFactory.RemoteDriverObjectFactory;
import ObjectFactory.UtilitiesObjectFactory;

/**
 * This is Test Base class for LamdaTest Selenium Advanced Certification
 * assignment.
 * 
 * This class is responsible for taking care of pre and post condition
 * operations for test execution. This class also contains common method which
 * are frequently used by other classes.
 *
 * @author Ketan Patoliya
 * @version 1.0
 * @since 2022-10-22
 */
public class BaseTestClass {
	
	@BeforeClass
	public void beforeClass(){
		ExtentManager.extentReportSetup();
	}
	
	@AfterClass
	public void afterClass(){
		ExtentManager.extentReportTeardown();
	}

	/**
	 * This method is pre-condition for test execution.
	 * 
	 * @param browser
	 * @param version
	 * @param platform
	 * 
	 *            All the parameters are fetched from TestNG.xaml file. And, are
	 *            set with DesiredCapabilities instance.
	 */
	@Parameters({ "browserType"})
	@BeforeMethod
	public void setUpBrowser(String browser) {
		DriverObjectFactory.setWebDriverInstance(DriverType.valueOf(browser));
		getDriver().get("http://automationpractice.com/");
	}

	/**
	 * This is post-condition for test execution.
	 * 
	 * Closing the driver instance.
	 */
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}

	/**
	 * This method returns the instance of RemoteWebDriver
	 * 
	 * @return instance of RemoteWebDriver
	 */
	public static WebDriver getDriver() {
		return DriverObjectFactory.getWebDriverInstance();
	}

	/**
	 * This method is responsible for switching to another window.
	 * 
	 * @param pageTitle
	 */
	public void switchToWindow(String pageTitle) {
		Set<String> totalWindowHandles = getDriver().getWindowHandles();
		Iterator<String> setIterator = totalWindowHandles.iterator();
		while (setIterator.hasNext()) {
			getDriver().switchTo().window(setIterator.next());
			if (getDriver().getTitle().equals(pageTitle)) {
				break;
			}
		}
	}

	/**
	 * This method will return the window handles of currently opened windows by
	 * driver.
	 * 
	 * @return window handles
	 */
	public String printOpenWindowHandles() {
		String openedWindows = "";

		Set<String> windows = getDriver().getWindowHandles();
		Iterator<String> setIterator = windows.iterator();
		while (setIterator.hasNext()) {
			openedWindows = setIterator.next() + ", " + openedWindows;
		}
		return openedWindows;
	}

	/**
	 * This method is responsible to capture screenshot during the test execution.
	 * 
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */
	public String captureScreenshot(WebDriver driver, String screenShotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenShotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
}
