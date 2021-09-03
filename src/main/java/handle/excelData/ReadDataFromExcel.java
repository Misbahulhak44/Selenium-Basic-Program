package handle.excelData;

import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadDataFromExcel {
	@Test
	public void ReadExcelFile() throws IOException
	{
		String file="./xcelfile/readData.xlsx";
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		Sheet sheet=wb.getSheetAt(0);
		int lastRow=sheet.getLastRowNum();
		System.out.println("Last row:-"+lastRow);
		for(int i=0;i<=lastRow;i++)
		{
			Row row=sheet.getRow(i);
			int lastCell=row.getLastCellNum();
			for(int j=0;j<lastCell;j++)
			{
				Cell cell=row.getCell(j);
				String value=cell.getStringCellValue();
				System.out.println(value);
			}
			System.out.println();
		}
		
		
	}
	

}
