package excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//Step 1: Convert physical file to java readable object
		FileInputStream fis = new FileInputStream("./src/test/resources/TestScriptData.xlsx");
		
		//Step 2: Open the excel workbook
		//Import Workbook from org.apache.poi.ss.usermodel
		//The below statement throws EncryptedDocumentException and IOException
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step 3: Get control over particular sheet
		Sheet s = wb.getSheet("Sheet1");
		
		//Step 4: Get control over specific row
		Row r = s.getRow(0);
		
		//Step 5: Get control over cell
		Cell c = r.getCell(1);
		
		//Step 6: Fetch data from cell
		System.out.println(c.getStringCellValue());
		
		//Step 7: Close workbook
		wb.close();
	}

}
