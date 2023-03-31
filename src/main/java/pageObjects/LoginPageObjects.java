package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.DriverFactory;
import testBase.TestBase;

public class LoginPageObjects extends TestBase {

	/*
	 * @FindBy(name = "login[email]") WebElement txt_email;
	 * 
	 * @FindBy(name = "login[password]") WebElement txt_password;
	 * 
	 * @FindBy(xpath = "//button[@type='submit' and text() = 'Login ']") WebElement
	 * btn_login;
	 */

	By EMAIL = By.name("login[email]");
	By PASSWORD = By.name("login[password]");
	By LOGIN_BTN = By.xpath("//button[@type='submit' and text() = 'Login ']");

	public void Login(String email, String password) {
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(EMAIL), "LoginEmailfield", email);
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(PASSWORD), "LoginPasswordfield", password);
		click_custom(DriverFactory.getInstance().getDriver().findElement(LOGIN_BTN), "LoginButton");
	}

}
