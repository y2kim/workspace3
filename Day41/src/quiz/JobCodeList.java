package quiz;

public class JobCodeList {
	
	private String jobCode;
	private String jobTitle;
	private String avgSalary;
	private String totalSalary;
	private String countpeople;
	
	
	public JobCodeList() {
		
	}
	
	public JobCodeList(String jobCode, String jobTitle, String avgSalary, String totalSalary, String countpeople) {
		super();
		this.jobCode = jobCode;
		this.jobTitle = jobTitle;
		this.avgSalary = avgSalary;
		this.totalSalary = totalSalary;
		this.countpeople = countpeople;
	}
	
	
	public String getJobCode() {
		return jobCode;
	}
	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getAvgSalary() {
		return avgSalary;
	}
	public void setAvgSalary(String avgSalary) {
		this.avgSalary = avgSalary;
	}
	public String getTotalSalary() {
		return totalSalary;
	}
	public void setTotalSalary(String totalSalary) {
		this.totalSalary = totalSalary;
	}
	public String getCountpeople() {
		return countpeople;
	}
	public void setCountpeople(String countpeople) {
		this.countpeople = countpeople;
	}
	
	
}
