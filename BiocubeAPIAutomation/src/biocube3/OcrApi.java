package biocube3;

import java.io.File;

import com.datadriven.test.Xls_Reader;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class OcrApi {
	public static void main(String[] args) {
		Xls_Reader reader = new Xls_Reader("C:\\Users\\Bhanu Pratap\\OCR.xlsx");
		int rowNumber=2;
		reader.addSheet("OCR");
		reader.addColumn("OCR","FrontImage");
		reader.addColumn("OCR", "BackImage");
		reader.addColumn("OCR", "Result");
		//path of the file
		String foldername="";
		File file = new File("foldername");
		File[] f = file.listFiles();
		
		String folderName="";
		File file1 = new File("folderName");
		File[] f1 = file1.listFiles();
		
		for (int i = 0; i < f.length; i++) {
		String frontimage =	f[i].getName();
			for(int j =0;j<=i;j++) {
			String backimage = f1[j].getName();
			
			RestAssured.baseURI ="http://10.159.232.9";
			RestAssured.port=3366;
			String res= given()
			.contentType("multipart/form-data")
			.multiPart("file", frontimage)
			.multiPart("file", backimage)
			.post("ocr/v1/passport")
			.then()
			.extract()
			.response().asString();
			String result =res;
			
			reader.setCellData("OCR", "FrontImage", rowNumber, frontimage.toString());
			reader.setCellData("OCR", "BackImage", rowNumber, backimage.toString());
			reader.setCellData("OCR", "Result", rowNumber, result);
			rowNumber++;
				
			}
			
		}
		
			
		}
		
	}


