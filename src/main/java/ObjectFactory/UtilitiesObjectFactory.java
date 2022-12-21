package ObjectFactory;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.BaseTestClass;
/**
 * This is Utilities Object Factory class for LamdaTest Selenium Advanced Certification assignment.
 * This class is responsible for the creation of instance of Utility object classes.
 * 
 * @author Ketan Patoliya
 * @version 1.0
 * @since 2022-10-22
 */
public class UtilitiesObjectFactory extends BaseTestClass{

	private static DesiredCapabilities desiredCapabilities;
	private static WebDriverWait webDriverWait;
	private static Actions action;
	private static JavascriptExecutor jsExecutor;
	
	/**
	 * This method returns instance of DesiredCapabilities class
	 * @return instance of DesiredCapabilities class
	 */
	public static DesiredCapabilities getDesiredCapabilitiesObject(){
		desiredCapabilities = new DesiredCapabilities();
		return desiredCapabilities;
		
	}
	
	/**
	 * This method returns instance of WebDriverWait class
	 * @param seconds
	 * @return instance of WebDriverWait class
	 */
	public static WebDriverWait getWebDriverWaitObject(long seconds){
		webDriverWait = new WebDriverWait(getDriver(), Duration.ofSeconds(seconds));
		return webDriverWait;
	}
	
	/**
	 * This method returns instance of Actions class
	 * @return instance of Actions class
	 */
	public static Actions getActionsClassObject(){
		action = new Actions(getDriver());
		return action;
	}
	
	/**
	 * This method returns instance of JavascriptExecutor
	 * @return instance of JavascriptExecutor
	 */
	public static JavascriptExecutor getJavascriptExecutorObject(){
		jsExecutor = (JavascriptExecutor) getDriver();
		return jsExecutor;
	}
}
