package multipart3;

import static io.restassured.RestAssured.given;

import java.io.File;

import com.datadriven.test.Xls_Reader;

import io.restassured.RestAssured;


public class Api {
	
	

	public static void main(String[] args) {
		// Create Excel sheet where data should store
		Xls_Reader reader = new Xls_Reader("C:\\Users\\Bhanu Pratap\\PracticeLiVeliness.xlsx");
		int rowNumber=2;
		reader.addColumn("Sheet1", "Image");
		reader.addColumn("Sheet1", "message");
		reader.addColumn("Sheet1", "output");
		reader.addColumn("Sheet1", "score");

		
		
		File file = new File("C:\\Users\\Bhanu Pratap\\Downloads\\liv (1)");
		File[] f1 = file.listFiles();
		for(File f:f1) {
			System.out.println(f);
		//	http://10.159.237.12:9988/liveness/
				RestAssured.baseURI = "http://10.159.237.12";
			RestAssured.port = 9988;
			Response res = given()
					.contentType("multipart/form-data")
					.multiPart("img", f)
					.post("liveness/")
					.then()
					.extract()
					.response()
					.as(Response.class);
			
		String message = res.getMessage();
			String output=res.getOutput();
			String score = res.getScore();
			
            reader.setCellData("Sheet1","Image", rowNumber, f.toString());
			reader.setCellData("Sheet1", "message", rowNumber, message);
			reader.setCellData("Sheet1", "output", rowNumber, output);
			reader.setCellData("Sheet1", "score", rowNumber, score);
			rowNumber++;
			
		}
		

	}

}
