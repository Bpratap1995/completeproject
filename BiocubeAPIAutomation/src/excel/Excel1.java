package excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.file.*;


public class Excel1 {
    public static void main(String[] args) throws IOException {
      String excelFilePath = "C:\\Users\\Bhanu Pratap\\FAke.xlsx";
      String outputFolderPath = "C:\\Users\\Bhanu Pratap\\Downloads\\Fake21082023";
      
        
            FileInputStream excelFile = new FileInputStream(new File(excelFilePath));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(0);
        
           int numberOfRows = sheet.getPhysicalNumberOfRows();
           
           for(int i=1;i<numberOfRows;i++) {
        Row row = sheet.getRow(i);
       Cell cell = row.getCell(0);
       
      // String imagePath1 = cell.getStringCellValue();
      // System.out.println(cell.toString());
       
       String imagePath = cell.toString();
       
       Path sourcePath = Paths.get(imagePath);
       Path destinationPath = Paths.get(outputFolderPath ,sourcePath.getFileName().toString());
       Files.copy(sourcePath, destinationPath);
         
           
    
    }
           workbook.close();
    }
      

    }


