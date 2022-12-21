package ObjectFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This is test class for LamdaTest Selenium Advanced Certification assignment.
 *
 * @author Ketan Patoliya
 * @version 1.0
 * @since 2022-10-22
 */
public class DriverObjectFactory {

	public enum DriverType {
		CHROME, FIREFOX, EDGE, REMOTE;
	}

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	private DriverObjectFactory() {
	}

	@SuppressWarnings("deprecation")
	public static void setWebDriverInstance(DriverType type) {
		switch (type) {

		case CHROME:
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
			break;

		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
			break;

		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
			break;
			
		default:
			break;
		}

		// Maximize the screen
		driver.get().manage().window().maximize();
		// Delete all the cookies
		driver.get().manage().deleteAllCookies();
		// Implicit TimeOuts
		driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// PageLoad TimeOuts
		driver.get().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}

	public static WebDriver getWebDriverInstance() {
		return driver.get();
	}

}
