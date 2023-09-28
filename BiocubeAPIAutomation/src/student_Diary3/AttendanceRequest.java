package student_Diary3;

import java.util.List;

public class AttendanceRequest {
	private int classId;
	private String location;
	private List<Integer> userId;
	
	
	
	
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<Integer> getUserId() {
		return userId;
	}
	public void setUserId(List<Integer> userId) {
		this.userId = userId;
	}
	
	

}
