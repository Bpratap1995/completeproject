package multipart2;

import static io.restassured.RestAssured.given;

import java.io.File;

import com.datadriven.test.Xls_Reader;

import io.restassured.RestAssured;

public class Liveliness {

	public static void main(String[] args) {
		// Create Excel sheet where data should store
		Xls_Reader reader = new Xls_Reader("C:\\Users\\Bhanu Pratap\\liveness17082023.xlsx");

		int rowNumber = 2;
		reader.addColumn("Sheet3", "Image");
		reader.addColumn("Sheet3", "Result");

		// Path of the file
		File file = new File("C:\\Users\\Bhanu Pratap\\Downloads\\Liveliness");
		//File file1 = new File("C:\\Users\\Bhanu Pratap\\Downloads\\LIVE");
		//File file2 = new File("C:\\Users\\Bhanu Pratap\\Downloads\\PrintedPics");
		
		File[] listFiles = file.listFiles();
	
		
		 //  List<File> ll= Arrays.asList(file.listFiles());
		 //  List<File> l2=Arrays.asList(file1.listFiles());
		   
		   
		   
		  // List<File> newList = Stream.concat(ll.stream(), l2.stream())
             //      .collect(Collectors.toList());
		

		for (File f : listFiles) {
			System.out.println(f);
//http://10.159.237.12:9988/liveness/
			RestAssured.baseURI = "http://10.159.237.12";
			RestAssured.port = 9988;
			String res = given()
					.contentType("multipart/form-data")
					.multiPart("img", f)
					.post("liveness/")
					.then()
					.extract()
					.response()
					.asString();

			// String result = res.getOutput()+" "+res.getLabel()+" "+res.getPrediction();
			String result = res;

			reader.setCellData("Sheet3", "Image", rowNumber, f.toString());
			reader.setCellData("Sheet3", "Result", rowNumber, result);
			rowNumber++;
		}

	}

}
