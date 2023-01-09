package excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel2 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// Step 1: Convert physical file to java readable object
		FileInputStream fis = new FileInputStream("./src/test/resources/TestScriptData.xlsx");

		// Step 2: Open the excel workbook
		// Import Workbook from org.apache.poi.ss.usermodel
		// The below statement throws EncryptedDocumentException and IOException
		Workbook wb = WorkbookFactory.create(fis);
		System.out.println(wb.getSheet("Sheet1").getRow(3).getCell(0).getNumericCellValue());
		//String data = wb.getSheet("Sheet1").getRow(0).getCell(1).getStringCellValue();
		//System.out.println(data);
		
		// Step 7: Close workbook
		wb.close();
	}

}
