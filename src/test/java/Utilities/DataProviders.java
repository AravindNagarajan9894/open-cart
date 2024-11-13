package Utilities;

import java.io.IOException;

import org.testng.annotations.*;

public class DataProviders {
	
	@DataProvider(name="LoginTestData")
	public String [][] loginTestDatas() throws IOException {
		String filePath = ".\\TestData\\LoginTestData.xlsx";
		String sheetName ="Sheet2";
		ExcelUtilityFile excelFile = new ExcelUtilityFile(filePath);
		int rowCount = excelFile.getRowCount(sheetName);
		int cellCount = excelFile.getCellCount(sheetName, 1);
		
		String [][] data = new String[rowCount][cellCount];
		for(int i=1;i<=rowCount;i++) {
			for(int j=0;j<cellCount;j++) {
				data[i-1][j] = excelFile.getCellData(sheetName, i, j);
			}
			System.out.println();
		}
		return data;
	}
	
	@DataProvider(name="RegisterationTestData")
	public String[][] resgistrationTestData() throws IOException{
		String filePath = ".\\TestData\\LoginTestData.xlsx";
		String sheetName ="Sheet3";
		ExcelUtilityFile excel = new ExcelUtilityFile(filePath);
		int rowCount = excel.getRowCount(sheetName);
		int cellCount = excel.getCellCount(sheetName, 0);
		
		String [][] data = new String [rowCount][cellCount];
		for(int i=1;i<=rowCount;i++) {
			for(int j=0;j<cellCount;j++) {
				data[i-1][j] = excel.getCellData(sheetName, i, j);
			}
		}
		return data;
	}
}
