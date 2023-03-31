package testBase;

import com.aventstack.extentreports.ExtentTest;

public class ExtentFactory {

	// ThreadLocal --> java.lang --> threading
	// Design pattern --> represents best practices
	// singleton design pattern -- only instance exists ever, provide global access to that instance by creating getInstance method
	// factory design pattern

	// private constructor means no one can create an object of this class - singleton pattern
	private ExtentFactory() {

	}

	private static ExtentFactory instance = new ExtentFactory();

	public static ExtentFactory getInstance() {
		return instance;
	}
	
	// factory design pattern --> define separate factory methods for creating objects and create the objects calling those methods
	
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	public ExtentTest getExtentTest() {
		return extentTest.get();
	}
	
	public void setExtentTest(ExtentTest extentTestObject) {
		extentTest.set(extentTestObject);
	}

	public void removeExtentObject() {
		extentTest.remove();
		
	}
}
