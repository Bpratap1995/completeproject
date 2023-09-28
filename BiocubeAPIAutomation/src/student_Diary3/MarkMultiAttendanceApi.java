package student_Diary3;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;



import com.datadriven.test.Xls_Reader;

import io.restassured.RestAssured;

public class MarkMultiAttendanceApi {



	public static void main(String[] args) {
		Xls_Reader reader = new Xls_Reader("C:\\Users\\Bhanu Pratap\\Downloads\\Book1.xlsx");
		int size=reader.getRowCount("MultiAttendance");
		System.out.println(size);
		
		int rowNumber =2;
		
		for(int i=2;i<=size;i++) {
			
			
			String classid = reader.getCellData("MultiAttendance", "ClassId", i);
			float f=Float.parseFloat(classid);
			int Classid =(int)f;
			
			String location = reader.getCellData("MultiAttendance","Location" , i);
		
		    String userid = reader.getCellData("MultiAttendance","userId", i);
		    float f1=Float.parseFloat(userid);
		    int Userid=(int)f1;
		    
		    
		    List<Integer> userId1 = new ArrayList<>();
        
		     userId1.add(Userid);
	    
	     
	     
		AttendanceRequest ar = new AttendanceRequest();
		ar.setLocation(location);
		ar.setUserId(userId1);
		
		ar.setClassId(Classid);
		
	    
		//BaseURI
		RestAssured.baseURI = "https://biopasstest.com:8443/studentdiary";
			 
	        String result = given()
			.header("apiKeyMobile", "p2lbgWkFrykA4QyUmpHihzmc5BNzIABq")
			.header("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI5MzU0MTIzNDU3IiwicHJvamVjdE5hbWUiOiJNT1NKIiwiZXhwIjoxNzAzMjUwODk2LCJpYXQiOjE2NzE3MTQ4OTYsImp0aSI6IjMifQ.q2hUxzVwkUddQL1MH3ywY1FSftdvKgxZL0phgbZRjn3bCJ8BjaK7wKLnqt4HTtaPMXzjPCy0B--I6Y30Akqv9A")
			.header("Content-Type", "application/json")
			.body(ar)
			.when()
			.post("/bioapi/mark-multi-attendance")
			.then()
			.extract()
			.response()
			.asString();
	        
		     System.out.println(result);
		         	
		
			 reader.setCellData("MultiAttendance","Response", rowNumber, result);
		
	 rowNumber++;
		
		
		
		}
		

	}

}
