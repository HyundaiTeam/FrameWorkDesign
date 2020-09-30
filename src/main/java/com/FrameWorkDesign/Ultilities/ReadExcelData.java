package com.FrameWorkDesign.Ultilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;

import com.FrameWorkDesign.Base.CommonComponents;

public class ReadExcelData extends CommonComponents {

	public static String getdata(String rowvalue, String columnvalue) throws IOException {
		String Datasheetname = prop.getProperty("datasheetName");
		FileInputStream fis = new FileInputStream("./testData/" + Datasheetname + ".xls");
		HSSFWorkbook workbook = new HSSFWorkbook(fis);
		HSSFSheet sheet = workbook.getSheet("Sheet1");
		HSSFRow row = sheet.getRow(0);

		int col_num = -1;//???

		for (int i = 0; i < row.getLastCellNum(); i++) {
			if (row.getCell(i).getStringCellValue().trim().equals(columnvalue))
				col_num = i; //0
		}
		Sheet Sheet1 = workbook.getSheet("Sheet1");
		String rowValue = rowvalue;
		Integer i = null;
		for (i = 1; i <= Sheet1.getLastRowNum(); i++) {
			if (rowValue.equals(Sheet1.getRow(i).getCell(0).getStringCellValue())) {
				System.out.println(i);
				break;
			}
		}

		row = sheet.getRow(i);
		if (row == null || col_num == -1) {

			System.out.println("Row or Column not present for the test case");
		}
		HSSFCell cell = row.getCell(col_num);

		String value = cell.getStringCellValue();

		if (value == "") {

			System.out.println("Value is not present in the data sheet");
		}
		return value;
	}

}
/*---------------------
@Test(priority=1)

public void logIn() throws IOException {

String email = ReadExcelData.getdata("TC_001", "Email");

Reporter.createTest("TC_001", "Verification of Login Page");

//applyApplicationWaits(20, 20);

autPrac.logInPage(email, "Password1");

}*/
