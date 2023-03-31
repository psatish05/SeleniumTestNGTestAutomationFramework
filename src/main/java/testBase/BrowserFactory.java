package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	
	//create webdriver object for given browser
	public WebDriver createBrowserInstance(String browser) {
		WebDriver driver = null;
		//RemoteWebDriver driver = null;
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			/*ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			//options.addArguments("--remote-allow-origins=*");*/
			ChromeOptions options = getChromeOptions();
			driver = new ChromeDriver(options);	
			
		}else if(browser.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions fOptions = new FirefoxOptions();
			fOptions.addArguments("--private");
			driver = new FirefoxDriver(fOptions);
			
		} if(browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			InternetExplorerOptions iOptions = new InternetExplorerOptions();
			iOptions.addCommandSwitches("-private");
			driver = new InternetExplorerDriver(iOptions);
		}
		return driver;
	}
	
	private ChromeOptions getChromeOptions() {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		options.addArguments("--remote-allow-origins=*");
		return options;
	}

}
