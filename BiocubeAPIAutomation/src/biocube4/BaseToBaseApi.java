package biocube4;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;

import static io.restassured.RestAssured.given;

import com.datadriven.test.Xls_Reader;

import io.restassured.RestAssured;

public class BaseToBaseApi {
	
	
	
	
	public static void main(String[] args) throws IOException {
		// Create Excel sheet where data should store
				Xls_Reader reader = new Xls_Reader("C:\\Users\\Bhanu Pratap\\Result.xlsx ");
				
			    reader.addColumn("Sheet1", "Image");
			    reader.addColumn("Sheet1", "Authorization");
				reader.addColumn("Sheet1", "Result");
				
				RestAssured.baseURI="http://10.159.232.9";
				RestAssured.port=7134;
				
				// Path of the file of image
				String folderName = "C:\\Users\\Bhanu Pratap\\Downloads\\Base64_punjab\\";
				File f = new File(folderName);
				File[] listFiles = f.listFiles();
		
		
			//path of the file of document
		String folderName1	="C:\\Users\\Bhanu Pratap\\Downloads\\ID_punjab\\";
			
			File f1 = new File(folderName1);
 			File[]filelist = f1.listFiles();
 			
			
			int rowNumber = 2;
			
			for(int i=0;i<listFiles.length;i++) {
				
				String fileName = listFiles[i].getName();
				
				File f2 = new File(folderName+fileName);
	 			FileInputStream fis = new FileInputStream(f2);
	 			
	 			byte b[] = new byte[(int)f2.length()];
	 			fis.read(b);
	 			
	 			String imageString = Base64.encodeBase64String(b);
	 			System.out.println(imageString);
	 			
	 			
				
				
				String fileName1 = filelist[i].getName();
				
				File f3 = new File(folderName1+fileName1);
	 			FileInputStream fis1 = new FileInputStream(f3);
				
	 			byte b1[] = new byte[(int)f3.length()];
	 			fis.read(b);
	 			
	 			String imageString1 = Base64.encodeBase64String(b1);
	 			System.out.println(imageString1);
	 			
				
				//Api
			
				String res=given()
					.header("Content-Type","application/json")
					.body("").when().post("/Base2BaseRecognition")
					.then().extract().response().asString();
					
					String result= res;
					reader.setCellData("Sheet1", "Image", rowNumber,fileName);
					reader.setCellData("Sheet1", "Authorization", rowNumber, fileName1);
					
					reader.setCellData("Sheet1", "Result", rowNumber, result);
					rowNumber++;
					}
					
					
				}
			
			
				
		
	}




