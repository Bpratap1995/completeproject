package biocube;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;

import com.datadriven.test.Xls_Reader;

import io.restassured.RestAssured;

public class API1 {

	public static FaceTrainingRequest setTrainingRequest(String base64) {
		FaceTrainingRequest trainingRequest = new FaceTrainingRequest();
		trainingRequest.setImage(base64);
		trainingRequest.setLiveliness(false);
		trainingRequest.setMobile(true);
		return trainingRequest;
	}
	
	
	
	public static FaceRecognitionRequest setRecognitionRequest(String encod,String base64) {
	FaceRecognitionRequest ftr=new FaceRecognitionRequest();
	ftr.setEncoding(encod);
	ftr.setImage(base64);
	ftr.setLiveliness(false);
	ftr.setMobile(true);
    return ftr;
	}
	
	
	

	public static void main(String[] args) throws IOException {
		// Create a excel sheet 
		Xls_Reader reader = new Xls_Reader ("C:\\Users\\Bhanu Pratap\\Api.xlsx");
		reader.addSheet("API");
		reader.addColumn("API","Request");
		reader.addColumn("API","Authorization");
		reader.addColumn("API", "message");
		reader.addColumn("API", "status");
		
		RestAssured.baseURI="https://biopasstest.com:8443/ai";
		//path where data is stored
		
	    String folderName = "C:\\Users\\Bhanu Pratap\\Downloads\\new3\\";
		File f = new File(folderName);

		//using array
		File filesList[] = f.listFiles();
		
	
	
		 
		int rowNumber=2;
	
		for (int i = 0; i < filesList.length; i++) {
			for (int j = i + 1; j < filesList.length; j++) {
				String fileName = filesList[i].getName();
				String fileName1 = filesList[j].getName();
				reader.setCellData("Api", "Request", rowNumber, fileName);
				reader.setCellData("Api", "Authorization", rowNumber, fileName1);

				FaceTrainingResponse trainingResponse = given()
						.header("Content-Type","application/json")
								.body(setTrainingRequest(fileName))
								.when()
								.post("common/face-training")
								.then()
								.extract()
								.response()
								.as(FaceTrainingResponse.class);
				 String encodings =trainingResponse.getData().getEncodings();
				 
				 FaceRecognitionResponse recognitionResponse = given().log().all()
					    	.header("Content-Type","application/json")
						     .body(setRecognitionRequest( encodings,fileName1))
						      .when()
							.post("common/face-recognition")
								.then()
								.extract()
								.response()
								.as(FaceRecognitionResponse.class);
				 String message = recognitionResponse.getData().getMessage();
				 System.out.println(message);
				 reader.setCellData("API", "message", rowNumber, message);
				 String output = recognitionResponse.getData().getOutput();
				 reader.setCellData("API", "status", rowNumber, output);
				 System.out.println( output);
				 
				 rowNumber++;
		
	}
}
	}
}

		


	

	


