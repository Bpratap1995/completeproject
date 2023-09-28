package biocube1;

import static io.restassured.RestAssured.given;

import java.io.File;

import com.datadriven.test.Xls_Reader;

import biocube.FaceTrainingResponse;
import io.restassured.RestAssured;

public class API {
	public static FaceLivelinessRequest  setImageRequest(String image) {
		FaceLivelinessRequest  livelinessRequest = new FaceLivelinessRequest();
		livelinessRequest.setImage(image);
		return livelinessRequest;
		
	}
	public static void main(String[] args) {
		
		
		
		RestAssured.baseURI="http://10.159.237.15:2175/liveliness/v3.0";
		//path where data is stored
		
	String folderName = "C:\\Users\\Bhanu Pratap\\Downloads\\new3\\";
		File f = new File(folderName);

		//using array
		File filesList[] = f.listFiles();
		
	
	
		 
		int rowNumber=2;
	
		for (int i = 0; i < filesList.length; i++) {
	
				String fileName = filesList[i].getName();
			
			
				

				FaceLivelinessResponse trainingResponse = given()
						.header("Content-Type","application/json")
								.body(setImageRequest(fileName))
								.when()
								.post(" ")
								.then()
								.extract()
								.response()
								.as(FaceLivelinessResponse.class);
		

	}

}
}
	
