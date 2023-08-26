package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GrocerryExcel {
	
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\nixon\\eclipse-workspace\\FrameWork\\Sample\\Excel Sheet\\SignUpPage.xlsx");

		FileInputStream fileInputStream = new FileInputStream(file);

		Workbook workbook = new XSSFWorkbook(fileInputStream);
		
		Sheet sheet = workbook.getSheet("Grocerry");
		
		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
			
			Row row = sheet.getRow(i);
			
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				
				Cell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				
				switch (cellType) {
				case STRING:
					
					String value = cell.getStringCellValue();
					System.out.println(value);
					
					break;
					
				case NUMERIC:
					
					double d = cell.getNumericCellValue();
					long round = Math.round(d);
					
					if(d== round) {
						String n = String.valueOf(round);
						System.out.println(n);
					}
					else {
						String n = String.valueOf(d);
						System.out.println(n);
					}
					
					break;

				default:
					
					
					break;
				}
			}
		}
		
		

		
	}

}
