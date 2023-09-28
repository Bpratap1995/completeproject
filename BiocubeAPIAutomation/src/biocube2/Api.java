package biocube2;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import org.apache.commons.codec.binary.Base64;

import com.datadriven.test.Xls_Reader;


import io.restassured.RestAssured;

public class Api {
	

public static LIvelinessRequest setBase64(String base64) {
	 LIvelinessRequest request = new LIvelinessRequest();
	 request.setFaceImage(base64);
	 return request;
}


     public static void main(String[] args) throws IOException {
    	 
    	
    	 
    	// Create a excel sheet 
 		Xls_Reader reader = new Xls_Reader ("C:\\Users\\Bhanu Pratap\\Falsepositive_FalseNegative.xlsx");
 		
 		reader.addColumn("Sheet1", "Base64");
		reader.addColumn("Sheet1", "message");
		reader.addColumn("sheet1", "output");
		
		//URL
		RestAssured.baseURI= "http://10.159.237.15";
		
	 	RestAssured.port=5000;
 		
 		//path where image is stored
    	 String folderName = "C:\\Users\\Bhanu Pratap\\Downloads\\Liveliness_s1\\";
 		File f = new File(folderName);
	 	
		
 		//using array
 		File filesList[] = f.listFiles();
 		int rowNumber = 2;
 		
 	      for (int i = 0; i < filesList.length; i++) {
 	    	  
 			String fileName = filesList[i].getName();
 			
		
 			File f1 = new File(folderName+fileName);
 			FileInputStream fis = new FileInputStream(f1);
 			
 			
 			
 			byte b[] = new byte[(int)f1.length()];
 			fis.read(b);
 			
 			String imageString = Base64.encodeBase64String(b);
 			System.out.println(imageString);
 			
 			reader.setCellData("sheet1", "Base64", rowNumber, fileName);
 			
 			//APi call
 			LlvelinessResponse  response = given()
 					.header("Content-Type","application/json")
 					.body(setBase64(imageString))
 					.when()
 					.post("/S1")
 					.then()
 					.extract()
 					.response()
 					.as(LlvelinessResponse.class);
			//output Response
						
 			String message = response.getMessage();
 			
			String output = response.getOutput();
					
		    reader.setCellData("sheet1", "message", rowNumber, message);
						
			reader.setCellData("sheet1", "output", rowNumber, output);
						
			rowNumber++;
			fis.close();		
 			  
 			 }
     }
}
