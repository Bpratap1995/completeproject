package student_diary;

import java.util.List;

public class SyncStudentRequest {

        private String enrolmentId;
    	private int supervisorid;
		private String trainingCenterId;
		private List<SyncStudentData> student;
		

		public String getEnrolmentId() {
			return enrolmentId;
		}
		public void setEnrolmentId(String enrolmentId) {
			this.enrolmentId = enrolmentId;
		}
		
		
		public List<SyncStudentData> getStudent() {
			return student;
		}
		public void setStudent(List<SyncStudentData> ssd) {
			this.student = ssd;
		}
		public int getSupervisorid() {
			return supervisorid;
		}
		public void setSupervisorid(int supervisorid) {
			this.supervisorid = supervisorid;
		}
		public String getTrainingCenterId() {
			return trainingCenterId;
		}
		public void setTrainingCenterId(String trainingCenterId) {
			this.trainingCenterId = trainingCenterId;
		}
		
	

}
