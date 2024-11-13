package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilityFile {

	public static FileInputStream fis ;
	public static FileOutputStream fos ;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static String path;
	
	public ExcelUtilityFile(String path){
		this.path=path;
	}
	
	public void createExcel() {
		
	}
	public static String getCellData(String sheetName, int rowNum, int cellNum) throws IOException {
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		XSSFCell cell = sheet.getRow(rowNum).getCell(cellNum);
		DataFormatter formatter = new DataFormatter();
		String cellContent = formatter.formatCellValue(cell);
		return cellContent;
	}
	public void setCellData(String sheetName, int rowNum, int cellNum, String value) throws IOException {
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.createCell(cellNum);
		cell.setCellValue(value);
		fos = new FileOutputStream(path);
		workbook.write(fos);
		workbook.close();
		fis.close();
		fos.close();
	}
	public int getRowCount(String sheetName) throws IOException {
		fis=new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		return sheet.getLastRowNum();
	}
	public int getCellCount(String sheetName , int rowNum) throws IOException {
		fis=new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		return sheet.getRow(rowNum).getLastCellNum();
	}	
}

