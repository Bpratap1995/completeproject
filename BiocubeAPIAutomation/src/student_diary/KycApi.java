package student_diary;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.datadriven.test.Xls_Reader;

import io.restassured.RestAssured;

public class KycApi {

	public static void main(String[] args) {
		
	//Data from excel
	Xls_Reader reader = new Xls_Reader("C:\\Users\\Bhanu Pratap\\Downloads\\MOCK_DATA.xlsx");
	int size = reader.getRowCount("kycdata");
	System.out.println(size);
	int rowNumber =2;
		
		for(int i =2;i<=size;i++) {
			
			KycData kd = new KycData();
			
			
	      String Address = reader.getCellData("kycdata","address", i);
	      String Dob = reader.getCellData("kycdata","dob", i);
	      String Fname = reader.getCellData("kycdata","fname", i);
	      String Firstname = reader.getCellData("kycdata","firstname", i);
	      String Gender = reader.getCellData("kycdata","gender", i);
	      String Lastname = reader.getCellData("kycdata","last_name", i);
	      String UserId = reader.getCellData("kycdata", "userId", i);
	      float id1 = Float.parseFloat(UserId);
	      int id = (int)id1;
	   System.out.println(id);
	      
	       kd.setAddress(Address);
	       kd.setDob(Dob);
	       kd.setfName(Fname);
	       kd.setFirstName(Firstname);;
	       kd.setGender(Gender);
	       kd.setKycstatus(0);
	       kd.setLastName(Lastname);
	       kd.setMiddleName("");
	       kd.setSyncStatus(true);
	       kd.setUserId(id);
	 
	
	       List<KycData> kf = new ArrayList<KycData>();
	       kf.add(kd);
	 
	      KycRequest req = new KycRequest();
	      req.setKyc(kf);
	 
       RestAssured.baseURI = "https://biopasstest.com:8443/studentdiary";
	 
		String result = given()
				.header("apiKeyMobile", "p2lbgWkFrykA4QyUmpHihzmc5BNzIABq")
				.header("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI5MzU0MTIzNDU3IiwicHJvamVjdE5hbWUiOiJNT1NKIiwiZXhwIjoxNzAzMjUwODk2LCJpYXQiOjE2NzE3MTQ4OTYsImp0aSI6IjMifQ.q2hUxzVwkUddQL1MH3ywY1FSftdvKgxZL0phgbZRjn3bCJ8BjaK7wKLnqt4HTtaPMXzjPCy0B--I6Y30Akqv9A")
				.header("Content-Type", "application/json")
				.body(req)
				.when()
				.post("/bioapi/synckyc")
				.then()
				.extract()
				.response()
				.asString();
	         	System.out.println(result);
	         	
		reader.setCellData("kycdata","Response", rowNumber, result);
		
	 rowNumber++;
	
	
		

	}
	

}

	

		
	}

