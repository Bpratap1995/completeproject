package aadhar_verification;

import static io.restassured.RestAssured.given;

import java.io.File;

import com.datadriven.test.Xls_Reader;

import io.restassured.RestAssured;

public class Api {

	public static void main(String[] args) {
		// Excel setup
		Xls_Reader reader = new Xls_Reader("C:\\Users\\Bhanu Pratap\\Aadhar.xlsx");
		reader.addSheet("Aadhar");
		reader.addColumn("Aadhar", "image");
		reader.addColumn("Aadhar", "Result");

		int rowNumber = 2;

		File file = new File("C:\\Users\\Bhanu Pratap\\Downloads\\Aadhar");

		File[] f = file.listFiles();

		for (File f1 : f) {
			System.out.println(f1);

			RestAssured.baseURI = "http://10.159.237.15:5465/";
			
			String res = given()
					.contentType("multipart/form-data")
					.multiPart("image", f1)
					.post("ocr/v1/aadhaar")
					.then()
					.extract().response().asString();
			String result=res;
			reader.setCellData("Aadhar", "image", rowNumber, f1.toString());
			reader.setCellData("Aadhar", "Result", rowNumber, result);
            rowNumber++;
		}

	}

}
