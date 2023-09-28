package excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Excel {
	public static void main(String[] args) {
		String excelFilePath = "C:\\Users\\Bhanu Pratap\\FAke.xlsx";

		String outputFolderPath = "C:\\Users\\Bhanu Pratap\\Downloads\\Fake";

		try {
			FileInputStream excelFile = new FileInputStream(new File(excelFilePath));
			Workbook workbook = new XSSFWorkbook(excelFile);
			Sheet sheet = workbook.getSheetAt(0);

			for (Row row : sheet) {
				Cell cell = row.getCell(0); // Assuming image paths are in the first column

				if (cell != null) {
					String imagePath = cell.getStringCellValue();
					try {
						Path sourcePath = Paths.get(imagePath);
						Path destinationPath = Paths.get(outputFolderPath, sourcePath.getFileName().toString());

						Files.copy(sourcePath, destinationPath);
						System.out.println("Image copied: " + destinationPath);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}

				}
			}

			workbook.close();
			excelFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
