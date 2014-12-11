package ie.gmit;

import java.io.Serializable;

public class FibRequest extends FibServlet implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int jobNumber;
	private int maxNumber;
	
	
	public FibRequest(int jobNumber, int maxNumber) {
		super();
		this.jobNumber = jobNumber;
		this.maxNumber = maxNumber;
	}
	public int getJobNumber() {
		return jobNumber;
	}
	public void setJobNumber(int jobNumber) {
		this.jobNumber = jobNumber;
	}
	public int getMaxNumber() {
		return maxNumber;
	}
	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}
}
