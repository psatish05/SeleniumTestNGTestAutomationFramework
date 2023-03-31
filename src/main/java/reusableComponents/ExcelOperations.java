package reusableComponents;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import testBase.ExtentFactory;

public class ExcelOperations {
	String filePath;
	Sheet sh;
	
	public ExcelOperations(String sheetName) {
		try {
			filePath = System.getProperty("user.dir")+PropertiesOperations.getPropertyValueByKey("testdatalocation");
			//ExtentFactory.getInstance().getExtentTest().info("Test data file location: "+filePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//Open file - workbook
		File testDatafile = new File(filePath);
		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(testDatafile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sh = wb.getSheet(sheetName);
		
	}
	
	//get test data from test data sheet in hashmap based on row number
	@SuppressWarnings("deprecation")
	public HashMap<String, String> getTestDataInMap(int rowNumber) {
		//read data row by row and put in a hash map
		HashMap<String, String> testDataMap = new HashMap<>();
		for (int i=0; i<sh.getRow(0).getLastCellNum();i++) {
			String value;
			String columName;
			if(sh.getRow(rowNumber).getCell(i) != null) {
				sh.getRow(rowNumber).getCell(i).setCellType(CellType.STRING);;
				value=sh.getRow(rowNumber).getCell(i).toString();
			}else {
				value="";
			}
			columName = sh.getRow(0).getCell(i).toString();
			testDataMap.put(columName, value);
		}
		return testDataMap;
	}
	
	//get row count
	public int getRowCount() {
		return sh.getLastRowNum();
	}
	
	//get column count
	public int getColumnCount() {
		return sh.getRow(0).getLastCellNum();
	}

}
