package testBase;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import reusableComponents.PropertiesOperations;

public class ExtentReportNG {
	static ExtentReports extent;
	public static ExtentReports createExtentReport() throws Exception {
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
		Date date = new Date();
		String actualDate = format.format(date);
		
		String reportPath = System.getProperty("user.dir")+"/Reports/ExecutionReport_"+actualDate+".html";
		String reportPath2 = System.getProperty("user.dir")+"/Reports/HtmlReporter/ExecutionReport_"+actualDate+".html";
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
		//ExtentSparkReporter htmlReporter = new 
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath2);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter,htmlReporter);
		sparkReporter.config().setDocumentTitle("Test Report");
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("QDPM Test Execution");
		
		extent.setSystemInfo("Executed on Envrionment: ", PropertiesOperations.getPropertyValueByKey("url") );
		extent.setSystemInfo("Executed on Browser: ", PropertiesOperations.getPropertyValueByKey("browser"));
		extent.setSystemInfo("Executed on Operating System : ", System.getProperty("os.name"));
		extent.setSystemInfo("Executed by User : ", System.getProperty("user.name"));
		
		return extent;
		
	}

}
