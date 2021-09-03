package handle.excelData;

import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteMultipleDataInExcel {
	@Test
	public void WriteDAta() throws IOException
	{

	String path = "./xcelfile/WriteData.xlsx";
	FileInputStream fis = new FileInputStream(path);
	Workbook workbook = new XSSFWorkbook(fis);
	Sheet sheet = workbook.getSheetAt(0);
	int lastRow = sheet.getLastRowNum();
	for(int i=1; i<=lastRow; i++){
	Row row = sheet.getRow(i);
	Cell cell = row.createCell(2);
	cell.setCellValue("What is your pet  name?");
	}
	FileOutputStream fos = new FileOutputStream(path);
	workbook.write(fos);
	fos.close();
}
}
