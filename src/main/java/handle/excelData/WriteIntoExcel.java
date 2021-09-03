package handle.excelData;

import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteIntoExcel {
	@Test
	public void WriteData() throws IOException
	{
		String file="./xcelfile/WriteData.xlsx/";
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		Sheet sheet=workbook.getSheetAt(0);
		Row row=sheet.getRow(0);
		Cell cell=row.createCell(2);
		cell.setCellValue("Security Question");
		FileOutputStream fos=new FileOutputStream(file);
		workbook.write(fos);
		fos.close();
	}

}
