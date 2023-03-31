package testBase;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
	
	//ThreadLocal --> java.lang --> threading
	//Design pattern --> represents best practices
	//singleton design pattern -- only instance exists ever, provide global access to that instance by creating getInstance method
	//factory design pattern
	
	//private constructor means no one can create an object of this class - singleton pattern 
	private DriverFactory() {
		
	}
	private static DriverFactory instance = new DriverFactory();
	public static DriverFactory getInstance () {
		return instance; 
	}
	
	//factory design pattern --> define separate factory methods for creating objects and create the objects by calling those methods
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public WebDriver getDriver() {
		return driver.get();
	}
	public void setDriver(WebDriver driverParm) {
		driver.set(driverParm);
		
	}
	public void closeBrowser() {
		driver.get().close();
		driver.remove();
	}


}
