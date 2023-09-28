package student_diary;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.datadriven.test.Xls_Reader;

import io.restassured.RestAssured;



public class SyncStudentApi {
	
		public static void main(String[] args) throws IOException{
			
		//data from excel
		Xls_Reader reader = new Xls_Reader("C:\\Users\\Bhanu Pratap\\Downloads\\MOCK_DATA.xlsx");
		int rowNumber =2;
		
		for (int i = 2; i <= reader.getRowCount("data"); i++) {
			
			SyncStudentData ssd = new SyncStudentData();
			
		   
		    ssd.setAadhar_number(reader.getCellData("data", "aadhar_number", i));
			ssd.setAddress(reader.getCellData("data", "address", i));
			ssd.setCourseTypeId(0);
			ssd.setCreateAt(reader.getCellData("data", "createAt", i));
			ssd.setCreateTime(reader.getCellData("data", "createTime", i));
			ssd.setDevice(reader.getCellData("data", "device", i));
			ssd.setDob(reader.getCellData("data", "dob", i));
			ssd.setEmail(reader.getCellData("data", "email", i));
			ssd.setEmployee_id(reader.getCellData("data", "employee_id", i));
			ssd.setEnrolmentId(reader.getCellData("data", "enrolmentId", i));
			ssd.setFaceEncoding1("");
			ssd.setFaceEncoding2("");
			ssd.setFaceEncoding3("");
			ssd.setFname(reader.getCellData("data", "fname", i));
			ssd.setGender(reader.getCellData("data", "gender", i));
			ssd.setInstitute(reader.getCellData("data", "institute", i));
			ssd.setKycstatus(0);
			ssd.setLast_name(reader.getCellData("data", "last_name", i));
			ssd.setMiddle_name("");
			ssd.setMobile(reader.getCellData("data", "mobile", i));
			ssd.setName(reader.getCellData("data", "name", i));
			ssd.setPhotoId("");
			ssd.setProfilePic("");
			ssd.setSubjectIds("");
			ssd.setTradeId(0);
			ssd.setUserId(0);
			ssd.setUserType(0);
		    ssd.setUsercode(reader.getCellData("data", "usercode", i));
			
			List<SyncStudentData> studentList = new ArrayList<SyncStudentData>();
		     studentList.add(ssd);
		    
		     
			SyncStudentRequest ssr = new SyncStudentRequest();
			ssr.setStudent(studentList);
			ssr.setSupervisorid(0);
			ssr.setTrainingCenterId("789");
			ssr.setEnrolmentId(reader.getCellData("data","enrolmentId", i));
			
			RestAssured.baseURI = "https://biopasstest.com:8443/studentdiary";
			
    String response = given()
	.header("apiKeyMobile","p2lbgWkFrykA4QyUmpHihzmc5BNzIABq")
    .header("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI5MzU0MTIzNDU3IiwicHJvamVjdE5hbWUiOiJNT1NKIiwiZXhwIjoxNzAzMjUwODk2LCJpYXQiOjE2NzE3MTQ4OTYsImp0aSI6IjMifQ.q2hUxzVwkUddQL1MH3ywY1FSftdvKgxZL0phgbZRjn3bCJ8BjaK7wKLnqt4HTtaPMXzjPCy0B--I6Y30Akqv9A") 
	.header("Content-Type", "application/json")
    .body(ssr)
	.when()
	.post("/bioapi/syncstudent")
	.then()
	.extract()
	.response()
	.asString();
			 
	System.out.println(response);
	reader.setCellData("data", "Response", rowNumber, response);
		
	rowNumber++;
		

		}	
		}


}

