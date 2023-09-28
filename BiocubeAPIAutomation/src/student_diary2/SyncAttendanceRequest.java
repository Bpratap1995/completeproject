package student_diary2;

import java.util.List;


public class SyncAttendanceRequest {
	
	private List<Attendance> attendance;
	private int deviceId ;
	private String location;
	private String siteId;
	private int supervisorId;
	
	public List<Attendance> getAttendance() {
		return attendance;
	}
	public void setAttendance(List<Attendance> attendance) {
		this.attendance = attendance;
	}
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	public int getSupervisorId() {
		return supervisorId;
	}
	public void setSupervisorId(int supervisorId) {
		this.supervisorId = supervisorId;
	}
	
	
	
	

}
