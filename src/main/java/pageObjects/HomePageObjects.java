package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import testBase.DriverFactory;
import testBase.TestBase;

public class HomePageObjects extends TestBase {
	
	
	/*@FindBy(xpath="//ul[@class='page-sidebar-menu']//i/following-sibling::span[text()='Tasks']")
	WebElement menuTasks;
	@FindBy(xpath="//ul[@class='page-sidebar-menu']//i/following-sibling::span[text()='Tasks']/ancestor::a/following-sibling::ul//span[text()='View All']")
	WebElement subMenuViewAll;
	
	public HomePageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}*/
	
	WebDriver driver = DriverFactory.getInstance().getDriver();
	By sidebarMenu_Dashboard = By.xpath("//ul[@class='page-sidebar-menu']//i/following-sibling::span[text()='Dashboard']");
	
	//click on menu bar - by passing name of menu
	public void clickOnSideMenu(String menu) {
		String menuXpath = "//ul[@class='page-sidebar-menu']//i/following-sibling::span[text()='"+menu+"']";
		DriverFactory.getInstance().getDriver().findElement(By.xpath(menuXpath)).click();
	}
	//click on sub menu - by passing name of sub menu
	public void clickOnSubSideMenu(String menu, String subMenu) {
		String menuXpath = "//ul[@class='page-sidebar-menu']//i/following-sibling::span[text()='"+menu+"']";
		DriverFactory.getInstance().getDriver().findElement(By.xpath(menuXpath)).click();
		String subMenuXpath = "//ul[@class='page-sidebar-menu']//i/following-sibling::span[text()='"+menu+"']/ancestor::a/following-sibling::ul//span[text()='"+subMenu+"']";
		DriverFactory.getInstance().getDriver().findElement(By.xpath(subMenuXpath)).click();
	}
	public void checkDashboardPageIsDisplayed() {
		Assert.assertTrue(isElementPresent_custom(DriverFactory.getInstance().getDriver().findElement(sidebarMenu_Dashboard), "DashBoardMenu"));
	}
}
