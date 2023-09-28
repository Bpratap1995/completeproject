package biocube;

public class FaceRecognitionResponse {
	private String message;
	private String statuscode;
	private FaceRecognitionData data;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(String statuscode) {
		this.statuscode = statuscode;
	}
	public FaceRecognitionData getData() {
		return data;
	}
	public void setData(FaceRecognitionData data) {
		this.data = data;
	}
	
	
	

}
