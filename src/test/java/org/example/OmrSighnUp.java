package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.invoke.SwitchPoint;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class OmrSighnUp {

	public static void main(String[] args) throws IOException {

	File file = new File("C:\\Users\\nixon\\eclipse-workspace\\FrameWork\\Sample\\Excel Sheet\\SignUpPage.xlsx");

	FileInputStream fileInputStream = new FileInputStream(file);

	Workbook workbook = new XSSFWorkbook(fileInputStream);

		Sheet sheet = workbook.getSheet("SignUpDetails");

		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);
				CellType type = cell.getCellType();

				switch (type) {

				case STRING:

					String value = cell.getStringCellValue();
					System.out.println(value);

					break;

				case NUMERIC:

					if (DateUtil.isCellDateFormatted(cell)) {
						Date dateCellValue = cell.getDateCellValue();
						SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yy");
						String date = dateFormat.format(dateCellValue);
						System.out.println(dateFormat);

					} else {
						double numericCellValue = cell.getNumericCellValue();
						BigDecimal b = BigDecimal.valueOf(numericCellValue);
						String num = String.valueOf(b);
						System.out.println(num);

					}
					break;

				default:
					break;
				}
			}

		}
	}

}
