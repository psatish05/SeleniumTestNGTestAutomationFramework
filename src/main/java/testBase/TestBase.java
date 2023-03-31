package testBase;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import reusableComponents.ActionsEngine;
import reusableComponents.PropertiesOperations;

public class TestBase extends ActionsEngine {
	
	/*private static ThreadLocal<Map<String, Object>> resourcesThreadLocal = new ThreadLocal<Map<String, Object>>();
	public static Map<String, Object> getResourceMap() {
		return resourcesThreadLocal.get();
	}*/
	
	
	BrowserFactory browserFactory = new BrowserFactory();
	
	@SuppressWarnings("deprecation") @BeforeMethod
	public void launchApplication() throws Exception {
		//WebDriver driverInstance = browserFactory.createBrowserInstance("Chrome"); 
		String browser = PropertiesOperations.getPropertyValueByKey("browser");
		String url = PropertiesOperations.getPropertyValueByKey("url");
		DriverFactory.getInstance().setDriver(browserFactory.createBrowserInstance(browser));
		WebDriver driver = DriverFactory.getInstance().getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait( 10, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(java.time.Duration duration);
		driver.navigate().to(url);
		
	}
	@AfterMethod
	public void tearDown() {
		//DriverFactory.getInstance().closeBrowser();
		DriverFactory.getInstance().closeBrowser();
	}

}
