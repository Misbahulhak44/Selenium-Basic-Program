package handle.excelData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ToReadExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		File file=new File("./xcelfile/testdata1.xlsx");

		FileInputStream fis=new FileInputStream(file);
		
		//Creating a workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		System.out.println("First Row First cell");
		//Row row = sheet.getRow(0);
		//Cell cell = row.getCell(0);
		System.out.println(sheet.getRow(0).getCell(0));
		System.out.println("--------------------------");
		
		System.out.println("First Row second Cell");
		  //Row row1 = sheet.getRow(0); 
		  //Cell cell1 = row1.getCell(1);
		  System.out.println(sheet.getRow(0).getCell(1));
		  System.out.println("-------------------------");
		 
		  //Row row2 = sheet.getRow(1);
		  //Cell cell2 = row2.getCell(0); 
		  System.out.println(sheet.getRow(1).getCell(0));
		  
		 //Row row3 = sheet.getRow(1); 
		 //Cell cell3 = row3.getCell(1);
		 System.out.println(sheet.getRow(1).getCell(1));
		 
		 System.out.println();
		 
		 //Row row4 = sheet.getRow(2); 
		 //Cell cell4 = row3.getCell(0);
		 System.out.println(sheet.getRow(2).getCell(0));
		 
//		 Row row5 = sheet.getRow(2); 
//		 Cell cell5 = row3.getCell(1);
		 System.out.println(sheet.getRow(2).getCell(1));
		 
		 System.out.println();
		 System.out.println(sheet.getRow(3).getCell(0));
		 System.out.println(sheet.getRow(3).getCell(1));

	}

}
