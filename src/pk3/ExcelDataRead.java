package pk3;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellBase;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.collect.Table.Cell;


public class ExcelDataRead {

	public static void main(String[] args) throws IOException {

		String filepath="C:\\TTech\\temp\\Read.xlsx";
		String sheetName="Sheet1";
		Object[][] bookData = {
        {"Head First Java","Kathy Serria", 79},
        {"Effective Java", "Joshua Bloch", 36},
        
		  };
		
//		FileInputStream fileinput= new FileInputStream("C:\\TTech\\temp\\Read.xlsx");
//		
//		XSSFWorkbook workbook=new XSSFWorkbook(fileinput);
//		XSSFSheet sheet = workbook.getSheet("Sheet1");
//		
//		int ro=sheet.getPhysicalNumberOfRows();
		
//		System.out.println("Number of the Rows : "+ro);
		
//		DataFormatter mat=new DataFormatter();
//		String value=mat.formatCellValue(sheet.getRow(1).getCell(0));
//		String value1=mat.formatCellValue(sheet.getRow(1).getCell(1));
//		System.out.println(value);
		
		
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hasan\\workspace\\BatchMarch2020\\Jars\\chromedriver_win32\\chromedriver.exe");
//		WebDriver driver=new FirefoxDriver();
//		driver.get("https://www.facebook.com/");
//		
//		driver.findElement(By.xpath("//*[@id='email']")).sendKeys((readExcelCellData(filepath,sheetName,0,1).toString()));
//		driver.findElement(By.xpath("//*[@id='pass']")).sendKeys((readExcelCellData(filepath,sheetName,1,1).toString()));
//		
//		
//		
//		for(int i=0;i<ro;i++){
//			
//			int cl = sheet.getRow(i).getPhysicalNumberOfCells();
//			for(int k=0;k<cl;k++){
//				
//				
//				Object va=mat.formatCellValue(sheet.getRow(i).getCell(k));
//				
//				System.out.println(va);
//			}
//		}
		
		
		//readExcelCellData(filepath,sheetName,0,1);
		
		writeExcel(filepath,sheetName,bookData);
		

	}
	
	
	public static Object readExcelCellData(String filepath,String sheetName,int rownumber,int cellnumber) throws IOException
	{
		
	FileInputStream fileinput= new FileInputStream(filepath);
		
		XSSFWorkbook workbook=new XSSFWorkbook(fileinput);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
			
		DataFormatter mat=new DataFormatter();
		Object value=mat.formatCellValue(sheet.getRow(rownumber).getCell(cellnumber));
		return value;
		
	}
	
	
	public static void writeExcel(String filepath,String sheetName,Object[][] bookData) throws IOException
	{
		
		FileInputStream fileinput= new FileInputStream(filepath);
		
		XSSFWorkbook workbook=new XSSFWorkbook(fileinput);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
//		  Object[][] bookData = {
//	                {"Head First Java", "Kathy Serria", 79},
//	                {"Effective Java", "Joshua Bloch", 36},
//	                
//	        };
		  
		  int rowCount = sheet.getLastRowNum();
		  for (Object[] aBook : bookData) {
	            Row row = sheet.createRow(++rowCount);
	             
	            int columnCount = 0;
	             
	            for (Object field : aBook) {
	                org.apache.poi.ss.usermodel.Cell cell =  row.createCell(columnCount++);
	                if (field instanceof String) {
	                     cell.setCellValue((String) field);
	                } else if (field instanceof Integer) {
	                     cell.setCellValue((Integer) field);
	                }
	            }
	             
	        }
	 
		  try (FileOutputStream outputStream = new FileOutputStream(filepath))
		  {
	            workbook.write(outputStream);
	            outputStream.close();
	        }
		
	}
	
	
	
	

}
