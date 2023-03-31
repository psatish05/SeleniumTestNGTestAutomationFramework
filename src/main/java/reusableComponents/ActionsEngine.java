package reusableComponents;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import testBase.DriverFactory;
import testBase.ExtentFactory;

public class ActionsEngine {
	
	//custom send keys
	public void sendKeys_custom(WebElement element, String fieldname, String value) {
		
		
		try {
			element.sendKeys(value);
			//log success message in extent report
			ExtentFactory.getInstance().getExtentTest().log(Status.PASS, fieldname+" : Value Entered ==>"+value);
			
		} catch (Exception e) {
			//log failure message in extent report
			ExtentFactory.getInstance().getExtentTest().log(Status.FAIL, "Error on entering "+value+" in field --> "+fieldname+" due to the folowwing exception ==> "+e);
			
		}
	}
	//custom click method to log every click action in extent report
	public void click_custom(WebElement element, String fieldname) {
		try {
			element.click();
			//log success message in extent report
			ExtentFactory.getInstance().getExtentTest().log(Status.PASS, fieldname+ " --> Clicked Successfully");
		}catch (Exception e) {
			// log failure in extent report
			ExtentFactory.getInstance().getExtentTest().log(Status.FAIL, "Unable to click on Element --> "+fieldname+" due to exception: "+e);
		}
	}
	
	//custom clear method
	public void clear_custom(WebElement element, String fieldname) {
		try {
			element.clear();
			ExtentFactory.getInstance().getExtentTest().log(Status.PASS, fieldname+" --> data cleared succesffully");
			
		} catch (Exception e) {
			// log exception in extent report
			ExtentFactory.getInstance().getExtentTest().log(Status.FAIL, "Unable to clear element --> "+fieldname+" due to exception: "+e);
		}
	}
	
	//custom mouse hover
	public void moveToElement_custom(WebElement element, String fieldname) {
		try {
			WebDriver driver = DriverFactory.getInstance().getDriver();
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].scrollIntoView(true)", element);
			Actions actions = new Actions(driver);
			actions.moveToElement(element).build().perform();
			ExtentFactory.getInstance().getExtentTest().log(Status.PASS, fieldname+" --> Mouse hover succesfull");
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtentTest().log(Status.FAIL, "Mouse hover on field--> "+fieldname+"failed due to exception: "+e);
		}
	}
	//check if element is present
	public Boolean isElementPresent_custom(WebElement element, String fieldname) {
		Boolean flag = false;
		try {
			flag = element.isDisplayed();
			ExtentFactory.getInstance().getExtentTest().log(Status.PASS, fieldname+" click present: "+flag);
			return flag;
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtentTest().log(Status.FAIL, "Verification of Element "+fieldname+" failed due to exception: "+e);
			return flag;
		}
	}
	//select drop down value by visible text
	public void selectDropDownValueByVisibleText(WebElement element, String fieldname, String ddVisibleText) {
		try {
			Select s = new Select(element);
			//s.wait(1000);
			//s.deselectByVisibleText(ddVisibleText);
			s.selectByVisibleText(ddVisibleText);
			ExtentFactory.getInstance().getExtentTest().log(Status.PASS, fieldname+" --> Drop down value selected by visible text: "+ddVisibleText);
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtentTest().log(Status.FAIL, "Drop down value: "+ddVisibleText+" not selected for field --> "+fieldname+" due to exception "+e);
		}
		
	}
	//select drop down value by value
		public void selectDropDownValueByValue(WebElement element, String fieldname, String ddValue) {
			try {
				Select s = new Select(element);
				s.selectByValue(ddValue);
				ExtentFactory.getInstance().getExtentTest().log(Status.PASS, fieldname+" --> Drop down value selected by visible text: "+ddValue);
			} catch (Exception e) {
				ExtentFactory.getInstance().getExtentTest().log(Status.FAIL, "Drop down value: "+ddValue+" not selected for field --> "+fieldname+" due to exception "+e);
			}
			
		}
	//Get text from element
		public String getText_Custom(WebElement element, String fieldname) {
			String text = "";
			try {
				text = element.getText();
				ExtentFactory.getInstance().getExtentTest().log(Status.PASS ,fieldname+" ---> text retrieved is "+text);
				return text;
			} catch (Exception e) {
				ExtentFactory.getInstance().getExtentTest().log(Status.FAIL, fieldname+" --> text not retrieved due to exception: "+e);
			}
			return text;
		}
		
	//String assertions
		public void stringAssertion_Custom(String expectedValue, String actualValue, String locatorName) {
			try {
				Assert.assertEquals(actualValue, expectedValue);
				ExtentFactory.getInstance().getExtentTest().log(Status.PASS, "String Assertion is successful on field "+ locatorName + " Expected value was: "+ expectedValue + " actual value is: "+actualValue);
			} catch (Exception e) {
				ExtentFactory.getInstance().getExtentTest().log(Status.FAIL, "String Assertion FAILED on field "+ locatorName + " Expected value was: "+ expectedValue + " actual value is: "+actualValue);
			}
		}

}
