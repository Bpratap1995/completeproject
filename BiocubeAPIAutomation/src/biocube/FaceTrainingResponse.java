package biocube;

public class FaceTrainingResponse {
	private String message;
	private String statuscode;
	private FaceTrainingResponseData data;

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
	public FaceTrainingResponseData getData() {
		return data;
	}
	public void setData(FaceTrainingResponseData data) {
		this.data = data;
	}
	


}
