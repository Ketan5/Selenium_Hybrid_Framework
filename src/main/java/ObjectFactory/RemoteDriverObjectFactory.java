package ObjectFactory;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Singleton class. This is Remote Driver Object Factory Singleton class for
 * LamdaTest Selenium Advanced Certification assignment. This class is
 * responsible for the creation of instance of remote web driver.
 * 
 * @author Ketan Patoliya
 * @version 1.0
 * @since 2022-10-22
 */
public class RemoteDriverObjectFactory {

	private static ThreadLocal<RemoteWebDriver> remoteDriver = new ThreadLocal<RemoteWebDriver>();

	/**
	 * Private constructor
	 */
	private RemoteDriverObjectFactory() {
	}

	/**
	 * This method is responsible for creating the instance of RemoteWebDriver
	 * 
	 * @param url
	 * @param capabilities
	 */
	@SuppressWarnings("deprecation")
	public static void setRemoteWebDriver(URL url, DesiredCapabilities capabilities) {
		remoteDriver.set(new RemoteWebDriver(url, capabilities));
		// Maximize the screen
		remoteDriver.get().manage().window().maximize();
		// Delete all the cookies
		remoteDriver.get().manage().deleteAllCookies();
		// Implicit TimeOuts
		remoteDriver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// PageLoad TimeOuts
		remoteDriver.get().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}

	/**
	 * This class will return instance of RemoteWebDriver
	 * 
	 * @return instance of RemoteWebDriver
	 */
	public static RemoteWebDriver getRemoteWebDriver() {
		return remoteDriver.get();
	}
}
