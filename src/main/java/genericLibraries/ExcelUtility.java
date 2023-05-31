package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * this class contains reusable methods to perform operations on excel
 * @author ngane
 * 

*/
public class ExcelUtility {
	private Workbook workbook;
	/*
	 * this method is used to intialize excel file
	 * @param excelpath
	 */
 public void excelInit(String excelPath) {
	 FileInputStream fis = null;
	 try {
		fis=new FileInputStream(excelPath);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	 try {
		workbook=WorkbookFactory.create(fis);
	} catch (EncryptedDocumentException | IOException e) {
		
		e.printStackTrace();
	}
}
 /**
  * this method is used to 
  * @param SheetName
  * @param rowNum
  * @param cellNum
  * @return
  */
 public String getDataFromExcel(String sheetName, int rowNum, int cellNum) {
	DataFormatter df=new  DataFormatter();
	String data=df.formatCellValue(workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum));
	return data;
	}
 /**
  * this method is used to fetch multiple data from excel
  * @param sheetName
  * @return
  */
 public Map<String,String>getDataFromExcel(String sheetName){
	 DataFormatter df =new  DataFormatter();
	 Map<String,String> map=new HashMap<>();
	 Sheet sheet =workbook.getSheet(sheetName);
	 
	  for(int i =0;i<=sheet.getFirstRowNum();i++) {
	 String key =df.formatCellValue(sheet.getRow(i).getCell(0));
	 String value =df.formatCellValue(sheet.getRow(i).getCell(1));
	 map.put(key, value);
 }
 return map;
}


public void writeToExcel (String sheetName,int rowNum,int cellNum,int data,String excelPath) {
	Cell cell=workbook.getSheet(sheetName).getRow((int)rowNum).createCell(cellNum);
	cell.setCellValue(data);
	FileOutputStream fos = null;
	try {
		fos=new FileOutputStream(excelPath);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	try {
	workbook.write(fos);
	}catch(IOException e) {
		e.printStackTrace();
	}
}
	/**
	 * this method is used to close Excel
	 */
public void closeExcel() {
	try {
	workbook.close();
	}catch(IOException e) {
		e.printStackTrace();
	}
}

}
	