package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String readDataFromExcel(String sheetName, int rowNum, int cellNum
			) throws EncryptedDocumentException, IOException {
		
		FileInputStream fisE = new FileInputStream("./TestData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fisE);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		String cell = row.getCell(cellNum).getStringCellValue();
		
		return cell;
	}

	
}
