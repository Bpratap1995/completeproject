package biocube1;

import java.util.List;

public class FaceLivelinessResponse {
	private int label;
	private String output;
	private List<Integer> prediction;
	public int getLabel() {
		return label;
	}
	public void setLabel(int label) {
		this.label = label;
	}
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	public List<Integer> getPrediction() {
		return prediction;
	}
	public void setPrediction(List<Integer> prediction) {
		this.prediction = prediction;
	}
	

}
