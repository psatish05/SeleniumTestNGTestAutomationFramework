package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPageObjects {
	/*By btn_addUser = By.xpath("//button[text()='Add User']");
	By field_Search = By.id("search_menu");
	By txt_Search = By.xpath("//*[@id='search_menu']//input[@name='search[keywords]']");
	By btn_Search = By.xpath("//*[@id='search_menu']//input[@type='submit']");
	By dd_group = By.id("users_users_group_id");
	By txt_FullName = By.name("users[name]");
	By txt_Password = By.name("users[password]");
	By txt_Email = By.name("users[email]");
	By txt_Phone = By.name("extra_fields[9]");
	By btn_UserPhoto = By.id("users_photo");
	By btn_Save = By.id("submit_button");
	By chk_notifyUser = By.id("users_notify");*/
	//WebDriver driver = null;
	@FindBy(xpath = "//button[text()='Add User']")
	WebElement btn_addUser;
	@FindBy(id = "search_menu")
	WebElement field_Search;
	@FindBy(xpath = "//*[@id='search_menu']//input[@name='search[keywords]']")
	WebElement txt_Search;
	@FindBy(xpath = "//*[@id='search_menu']//input[@type='submit']")
	WebElement btn_Search;
	@FindBy(id = "users_users_group_id")
	WebElement dd_group;
	@FindBy(name = "users[name]")
	WebElement txt_FullName;
	@FindBy(name = "users[name]")
	WebElement txt_Password;
	@FindBy(name = "users[password]")
	WebElement txt_Email;
	@FindBy(name = "users[email]")
	WebElement txt_Phone;
	@FindBy(id = "users_photo")
	WebElement btn_UserPhoto;
	@FindBy(id = "submit_button")
	WebElement btn_Save;
	@FindBy(id = "users_users_group_id")
	WebElement users_notify;
	//Initialize all the objects for the giver driver instance
	public UserPageObjects (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
