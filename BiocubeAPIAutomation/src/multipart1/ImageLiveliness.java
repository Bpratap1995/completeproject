package multipart1;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.datadriven.test.Xls_Reader;

import io.restassured.RestAssured;

public class ImageLiveliness {

	public static void main(String[] args) {
		// Create Excel sheet where data should store
		Xls_Reader reader = new Xls_Reader("C:\\Users\\Bhanu Pratap\\livelinessReport16.xlsx ");

		int rowNumber = 1002;
		reader.addColumn("Sheet1", "Image");
		reader.addColumn("Sheet1", "Result");

		// Path of the file
		//File file = new File("C:\\Users\\Bhanu Pratap\\Downloads\\Liveliness");
		//File file1 = new File("C:\\Users\\Bhanu Pratap\\Downloads\\LIVE");
		File file2 = new File("C:\\Users\\Bhanu Pratap\\Downloads\\PrintedPics");
		
		File[] listFiles = file2.listFiles();
	
		
		 //  List<File> ll= Arrays.asList(file.listFiles());
		 //  List<File> l2=Arrays.asList(file1.listFiles());
		   
		   
		   
		  // List<File> newList = Stream.concat(ll.stream(), l2.stream())
             //      .collect(Collectors.toList());
		

		for (File f : listFiles) {
			System.out.println(f);

			RestAssured.baseURI = "http://10.159.237.12";
			RestAssured.port = 6182;
			String res = given()
					.contentType("multipart/form-data")
					.multiPart("img", f)
					.post("liveness")
					.then()
					.extract()
					.response()
					.asString();

			// String result = res.getOutput()+" "+res.getLabel()+" "+res.getPrediction();
			String result = res;

			reader.setCellData("Sheet1", "Image", rowNumber, f.toString());
			reader.setCellData("Sheet1", "Result", rowNumber, result);
			rowNumber++;
		}

	}


	
	
	
}
