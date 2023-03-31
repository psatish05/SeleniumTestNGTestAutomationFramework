package tests;


import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import pageObjects.TaskPageObjects;
import reusableComponents.DatabaseOperations;
import reusableComponents.ExcelOperations;
import testBase.ExtentFactory;
import testBase.MyLogger;
import testBase.TestBase;

public class TestCase extends TestBase {
	LoginPageObjects loginPage = new LoginPageObjects();
	HomePageObjects homePage = new HomePageObjects(); 
	TaskPageObjects taskPage = new TaskPageObjects();
	DatabaseOperations databaseOperations = new DatabaseOperations();
	ExcelOperations excel = new ExcelOperations("TaskCreationData");
	
	@Test(dataProvider = "taskCreationData")
	public void TaskCreationTest(Object obj1) {
		
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		ExtentFactory.getInstance().getExtentTest().info("Test data: "+testData);
		loginPage.Login(testData.get("UserName"), testData.get("Password"));
		//verify if dashboard page opens
		homePage.checkDashboardPageIsDisplayed();
		//add task
		homePage.clickOnSubSideMenu("Tasks", "Add Task");
		try {
			taskPage.createTask(testData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		taskPage.search_Verify_TaskCreatedOnUI(testData);
		//verify in database
		String sqlQuery = "SELECT * FROM `tasks` WHERE name = '"+testData.get("TaskName")+"'";
		HashMap<String, String> dbData = databaseOperations.getSqlResultInMap(sqlQuery);
		String TaskName = dbData.get("name");
		stringAssertion_Custom(testData.get("TaskName"), TaskName, "DB_Task_Name");
	}
	
	// data provider method --> return object array
	@DataProvider(name = "taskCreationData")
	public Object[][] testDataFetcher(){
		Object[][] obj = new Object[excel.getRowCount()][1];
		for(int i=1; i<=excel.getRowCount(); i++) {
			HashMap<String, String> testData = excel.getTestDataInMap(i);
			obj[i-1][0] = testData;
		}
		return obj;
		
	}
//	@Test
//	public void testcase2() {
//		loginPage.Login("admin@admin.com", "Orange@9999");
//	}
//
//	@Test
//	public void testCase3() {
//		System.out.println("this is the third test case");
//		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
//		MyLogger.info("Log for first test case");
//	}
	/*
	@Test
	public void testCase2() {
		System.out.println("this is the second test case");
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		MyLogger.info("Log for second test case");
	}
	@Test
	public void testCase3() {
		System.out.println("this is the third test case");
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		MyLogger.info("Log for third test case");
	}
	@Test
	public void testCase4() {
		System.out.println("this is the fourth  test case");
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		MyLogger.info("Log for fourth test case");
	}
	@Test
	public void testCase5() {
		System.out.println("this is the fifth test case");
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		MyLogger.info("Log for fifth test case");
	}*/
}
