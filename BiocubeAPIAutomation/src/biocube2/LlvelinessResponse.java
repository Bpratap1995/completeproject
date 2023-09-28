package biocube2;

public class LlvelinessResponse {
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	public String getResponse_code() {
		return response_code;
	}
	public void setResponse_code(String response_code) {
		this.response_code = response_code;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getUser_data() {
		return user_data;
	}
	public void setUser_data(String user_data) {
		this.user_data = user_data;
	}
	private String  output;
	private String  response_code;
	private String score;
	private int status;
	private String  user_data;

}
