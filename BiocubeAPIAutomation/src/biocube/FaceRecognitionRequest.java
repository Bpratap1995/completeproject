package biocube;

public class FaceRecognitionRequest {
	private String encoding;
	private String image;
	private boolean liveliness;
	private boolean mobile;
	public String getEncoding() {
		return encoding;
	}
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public boolean isLiveliness() {
		return liveliness;
	}
	public void setLiveliness(boolean liveliness) {
		this.liveliness = liveliness;
	}
	public boolean isMobile() {
		return mobile;
	}
	public void setMobile(boolean mobile) {
		this.mobile = mobile;
	}

}
