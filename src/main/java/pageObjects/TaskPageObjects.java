package pageObjects;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import testBase.DriverFactory;
import testBase.TestBase;

public class TaskPageObjects extends TestBase {
	WebDriver driver = DriverFactory.getInstance().getDriver();

	By btn_addTask = By.xpath("//button[text()='Add Task']");
	By field_Search = By.id("search_menu");
	By txt_Search = By.xpath("//*[@id='search_menu']//input[@name='search[keywords]']");
	By btn_Search = By.xpath("//*[@id='search_menu']//input[@type='submit']");
	By dd_SelectProjectForNewTaskCreation = By.id("form_projects_id");
	By dd_taskType = By.id("tasks_tasks_type_id");
	By txt_taskName = By.id("tasks_name");
	By dd_taskStatus = By.id("tasks_tasks_status_id");
	By dd_taskPriority = By.id("tasks_tasks_priority_id");
	By dd_taskLabel = By.id("tasks_tasks_label_id");
	By dd_taskCreatedBy = By.id("tasks_created_by");
	By btn_save = By.xpath("//button[@type='submit' and text()='Save']");

	public void createTask(HashMap<String, String> testData) throws InterruptedException {

		System.out.println(testData.get("ProjectToCreateTaskUnder"));
		Thread.sleep(3000);
		selectDropDownValueByVisibleText(
				DriverFactory.getInstance().getDriver().findElement(dd_SelectProjectForNewTaskCreation),
				"NewTaskProjectDropDown", testData.get("ProjectToCreateTaskUnder"));
		selectDropDownValueByVisibleText(DriverFactory.getInstance().getDriver().findElement(dd_taskType),
				"NewTaskTypeDropDown", testData.get("TaskType"));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_taskName), "NewTaskName", testData.get("TaskName"));
		selectDropDownValueByVisibleText(DriverFactory.getInstance().getDriver().findElement(dd_taskStatus),
				"NewTaskStatusDropDown", testData.get("TaskStatus"));
		selectDropDownValueByVisibleText(DriverFactory.getInstance().getDriver().findElement(dd_taskPriority),
				"NewTaskPriorityDropDown", testData.get("TaskPriority"));
		selectDropDownValueByVisibleText(DriverFactory.getInstance().getDriver().findElement(dd_taskLabel),
				"NewTaskLabelDropDown", testData.get("Label"));
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_save), "NewTaskSaveButton");
	}

	public void search_Verify_TaskCreatedOnUI(HashMap<String, String> testData) {
		moveToElement_custom(DriverFactory.getInstance().getDriver().findElement(field_Search), "TaskSearchOption");
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txt_Search), "TaskSearchBox", testData.get("TaskName"));
		click_custom(DriverFactory.getInstance().getDriver().findElement(btn_Search), "SearchButton");
		//table verification
		stringAssertion_Custom(testData.get("TaskName"), getTaskTableCellValueByColumnName("Name"), "TaskNameInTable");
	}

	private String getTaskTableCellValueByColumnName(String columnName) {

		String valueXpath = "//table[starts-with(@id, 'itmes_listing')]/tbody/tr/td[count(//table[starts-with(@id, 'itmes_listing')]/thead/tr/th/div[text()='"+ columnName + "']/parent::th/preceding-sibling::th)+1]";
		String value = DriverFactory.getInstance().getDriver().findElement(By.xpath(valueXpath)).getText();
		return value;
	}
//	@FindBy(xpath = "//button[text()='Add Task']") 
//	WebElement btn_addTask;
//	@FindBy(id = "search_menu") 
//	WebElement field_search;
//	@FindBy(xpath = "//*[@id='search_menu']//input[@name='search[keywords]']")
//	WebElement txt_Search;
//	@FindBy(xpath = "//*[@id='search_menu']//input[@type='submit']")
//	WebElement btn_Search;
//	@FindBy(id = "form_projects_id")
//	WebElement dd_SelectProjectForNewTaskCreation;
//	@FindBy(id = "tasks_tasks_type_id")
//	WebElement dd_taskType;
//	@FindBy(id = "tasks_name")
//	WebElement txt_taskName;
//	@FindBy(id = "tasks_tasks_status_id")
//	WebElement dd_taskStatus;
//	@FindBy(id = "tasks_tasks_label_id")
//	WebElement dd_taskPriority;
//	@FindBy(id = "tasks_tasks_label_id")
//	WebElement dd_taskLabel;
//	@FindBy(id = "tasks_created_by")
//	WebElement dd_taskCreatedBy;
//	@FindBy(xpath = "//button[@type='submit' and text()='Save']")
//	WebElement btn_save;
//	
//	public TaskPageObjects(WebDriver driver) {
//		PageFactory.initElements(driver, this);
//		this.driver = driver;
//	}

}
