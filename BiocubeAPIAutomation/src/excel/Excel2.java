package excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Excel2 {
    public static void main(String[] args) {
        String excelFilePath = "C:\\Users\\Bhanu Pratap\\FAke.xlsx";
        String imageFolderPath = "C:\\Users\\Bhanu Pratap\\Downloads\\bhanu";
        String outputFolderPath = "C:\\Users\\Bhanu Pratap\\Downloads\\Fake";

        try {
            FileInputStream excelFile = new FileInputStream(new File(excelFilePath));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(0);

            List<String> imagePathsInExcel = getImagePathsFromExcel(sheet);
            List<String> matchingImagePaths = findMatchingImages(imagePathsInExcel, imageFolderPath);

            for (String imagePath : matchingImagePaths) {
                Path sourceImagePath = Paths.get(imagePath);
                Path destinationImagePath = Paths.get(outputFolderPath, sourceImagePath.getFileName().toString());
                Files.copy(sourceImagePath, destinationImagePath);
                System.out.println("Image copied: " + destinationImagePath);
            }

            workbook.close();
            excelFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> getImagePathsFromExcel(Sheet sheet) {
        List<String> imagePaths = new ArrayList<>();
        for (Row row : sheet) {
            Cell cell = row.getCell(0); // Assuming image paths are in the first column
            if (cell != null) {
                String imagePath = cell.getStringCellValue();
                imagePaths.add(imagePath);
            }
        }
        return imagePaths;
    }

    private static List<String> findMatchingImages(List<String> imagePaths, String imageFolderPath) {
        List<String> matchingImagePaths = new ArrayList<>();
        File folder = new File(imageFolderPath);
        if (folder.exists() && folder.isDirectory()) {
            for (String imagePath : imagePaths) {
                File imageFile = new File(folder, imagePath);
                if (imageFile.exists() && imageFile.isFile()) {
                    matchingImagePaths.add(imagePath);
                }
            }
        }
        return matchingImagePaths;
    }
}

