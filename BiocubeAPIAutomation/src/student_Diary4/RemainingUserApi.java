package student_Diary4;

import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.given;

import com.datadriven.test.Xls_Reader;

import io.restassured.RestAssured;



public class RemainingUserApi {

	public static void main(String[] args) {
	
		//Fetch data from excel
		Xls_Reader reader = new Xls_Reader("C:\\Users\\Bhanu Pratap\\Downloads\\RemainingUser.xlsx");
		int size = reader.getRowCount("Remaining_User");
		System.out.println(size);
		int rowNumber=2;
		
		for(int i=2;i<=size;i++) {
			
			String cId = reader.getCellData("Remaining_User", "ClassId",i);
			//parse from String to float
			float id=Float.parseFloat(cId);
			//cast it into int
			int Cid=(int)id;
			
			
			String loc = reader.getCellData("Remaining_User", "Location",i);
			
			String uId = reader.getCellData("Remaining_User", "userId",i);
			//parse from String to float
			float id1 = Float.parseFloat(uId);
			//cast it into int
			int Uid=(int)id1;
			
			//pass the userid into list of integer
			List<Integer>userId1 = new ArrayList<>();
			userId1.add(Uid);
			
			//set the value into RemainingUser class object
			
			RemainingUser ru =new RemainingUser();
			ru.setClassId(Cid);
			ru.setLocation(loc);
			ru.setUserId(userId1);
			
			//Base Uri
			
			RestAssured.baseURI="https://biopasstest.com:8443/studentdiary";
			
			  String result = given()
						.header("apiKeyMobile", "p2lbgWkFrykA4QyUmpHihzmc5BNzIABq")
						.header("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI5MzU0MTIzNDU3IiwicHJvamVjdE5hbWUiOiJNT1NKIiwiZXhwIjoxNzAzMjUwODk2LCJpYXQiOjE2NzE3MTQ4OTYsImp0aSI6IjMifQ.q2hUxzVwkUddQL1MH3ywY1FSftdvKgxZL0phgbZRjn3bCJ8BjaK7wKLnqt4HTtaPMXzjPCy0B--I6Y30Akqv9A")
						.header("Content-Type", "application/json")
						.body(ru)
						.when()
						.post("/bioapi/remaning-users")
						.then()
						.extract()
						.response()
						.asString();
			  
			  System.out.println(result);
			  reader.setCellData("Remaining_User", "Response", rowNumber, result);
			  rowNumber++;
			
			 
			
			
			
			
			
			
			
		}
		

	}

}
