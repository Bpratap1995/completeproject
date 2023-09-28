package dataDriven;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Data {

	public static void main(String[] args) throws IOException {
		FileInputStream Fis = new FileInputStream("C:\\Users\\Bhanu Pratap\\Downloads\\DataDriven.xlsx");
		
	XSSFWorkbook wb = new XSSFWorkbook(Fis);
	XSSFSheet sheet = wb.getSheet(null);
	int row = sheet.getPhysicalNumberOfRows();

	}

}
