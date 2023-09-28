package biocube;

import java.io.File;

import java.io.IOException;

import com.datadriven.test.Xls_Reader;

import io.restassured.RestAssured;
//import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ApiCall {

	public static FaceTrainingRequest setTrainingRequest(String base64) {
		FaceTrainingRequest trainingRequest = new FaceTrainingRequest();
		trainingRequest.setImage(base64);
		trainingRequest.setLiveliness(false);
		trainingRequest.setMobile(true);
		return trainingRequest;
	}

	public static FaceRecognitionRequest setRecognitionRequest(String encod, String base64) {
		FaceRecognitionRequest ftr = new FaceRecognitionRequest();
		ftr.setEncoding(encod);
		ftr.setImage(base64);
		ftr.setLiveliness(false);
		ftr.setMobile(true);
		return ftr;
	}

	public static void main(String[] args) throws IOException {
		// Create a excel sheet
		Xls_Reader reader = new Xls_Reader("C:\\Users\\Bhanu Pratap\\Api.xlsx");
		reader.addSheet("API");
		reader.addColumn("API", "Request");
		reader.addColumn("API", "Authorization");
		reader.addColumn("API", "message");
		reader.addColumn("API", "status");

		// path where data is stored

		String folderName = "C:\\Users\\Bhanu Pratap\\Downloads\\new1\\";
		File f = new File(folderName);

		// using array
		File filesList[] = f.listFiles();

		System.out.println(filesList.length);

		for (int i = 0; i < filesList.length; i++) {
			String fileName = filesList[i].getName();
			System.out.println(fileName);

			for (int i1 = i + 2; i1 <= i + 2; i1++) {
				reader.setCellData("API", "Request", i1, fileName);

				RestAssured.baseURI = "https://biopasstest.com:8443/ai";

				FaceTrainingResponse trainingResponse = given().header("Content-Type", "application/json")
						.body(setTrainingRequest(fileName)).when().post("common/face-training").then().extract()
						.response().as(FaceTrainingResponse.class);
				String encodings = trainingResponse.getData().getEncodings().toString();

				System.out.println(encodings);

				for (int j = i + 1; j < filesList.length; j++) {
					String fileName1 = filesList[j].getName();
					System.out.println(fileName1);

					for (int j1 = i + 2; j1 <= filesList.length; j1++) {
						reader.setCellData("API", "Authorization", j1, fileName1);

					}

//	RestAssured.baseURI="https://biopasstest.com:8443/ai";

					FaceRecognitionResponse recognitionResponse = given().log().all()
							.header("Content-Type", "application/json")
							.body(setRecognitionRequest(encodings, fileName1)).when().post("common/face-recognition")
							.then().extract().response().as(FaceRecognitionResponse.class);
					String message = recognitionResponse.getData().getMessage();
					String output = recognitionResponse.getData().getOutput();
					System.out.println(message);
					System.out.println(output);

				}

			}
		}

	}
}
