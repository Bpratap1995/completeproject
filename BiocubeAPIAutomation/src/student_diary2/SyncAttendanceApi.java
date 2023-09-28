package student_diary2;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import com.datadriven.test.Xls_Reader;

import io.restassured.RestAssured;

public class SyncAttendanceApi {
	
	
		public static void main(String[] args) {
			
		//data from excel
		Xls_Reader reader = new Xls_Reader("C:\\Users\\Bhanu Pratap\\Downloads\\syncattendance.xlsx");
	    int size = reader.getRowCount("SyncAttendance");
	    System.out.println(size);
	    int rowNumber = 2;
	
	for(int i=2;i<=size;i++) {
		
		Attendance attendance = new Attendance();
		
		attendance.setAttendanceId(0);
		attendance.setCheckInLocation("gurgaon");
		attendance.setCheckOutLocation("gurgaon");
		attendance.setCheckin(reader.getCellData("SyncAttendance", "checkin", i));
		attendance.setCheckout(reader.getCellData("SyncAttendance", "checkout", i));
	    attendance.setClassId(reader.getCellData("SyncAttendance","classId", i));	
	    attendance.setCreateTime(reader.getCellData("SyncAttendance", "createTime", i));
	    attendance.setEndDate( reader.getCellData("SyncAttendance", "endDate", i));
	    attendance.setStartDate(reader.getCellData("SyncAttendance", "startDate", i));
	    attendance.setSyncMessage("");
	    attendance.setSyncStatus(true);
	    attendance.setType(0);
	    //userid in string
	    String Userid = reader.getCellData("SyncAttendance", "userId", i);
	    
	    //parse userid into floatfrom string
	    float id1 = Float.parseFloat(Userid);
	    
	    //cast into int
	    int id = (int)id1;
	    //pass the int value in userid
	    attendance.setUserId(id);
	    
	    attendance.setUserType(0);
	    attendance.setUsername(reader.getCellData("SyncAttendance", "username", i));
	    attendance.setWorkingHour(reader.getCellData("SyncAttendance", "workingHour", i));
	    
	    List<Attendance> attend  = new ArrayList<Attendance> ();
	    attend.add(attendance);
	    
	    SyncAttendanceRequest sar = new SyncAttendanceRequest();
	    sar.setAttendance(attend);
	    sar.setDeviceId(0);
	    sar.setLocation("gurgaon");
	    sar.setSiteId("");
	    sar.setSupervisorId(0);
	    
	    //Api call
	    
	    RestAssured.baseURI = "https://biopasstest.com:8443/studentdiary";
	    
		String result = given()
				.header("apiKeyMobile", "p2lbgWkFrykA4QyUmpHihzmc5BNzIABq")
				.header("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI5MzU0MTIzNDU3IiwicHJvamVjdE5hbWUiOiJNT1NKIiwiZXhwIjoxNzAzMjUwODk2LCJpYXQiOjE2NzE3MTQ4OTYsImp0aSI6IjMifQ.q2hUxzVwkUddQL1MH3ywY1FSftdvKgxZL0phgbZRjn3bCJ8BjaK7wKLnqt4HTtaPMXzjPCy0B--I6Y30Akqv9A")
				.header("Content-Type", "application/json")
				.body(sar)
				.when()
				.post("/bioapi/syncattendance")
				.then()
				.extract()
				.response()
				.asString();
		System.out.println(result);
		
		reader.setCellData("SyncAttendance","Result", rowNumber, result);
	    
	    rowNumber++;
	}
	
	}
}
