package quiz;

public class Deptlist {
	private String deptcode;
	private String deptname;
	private String salary;
	
	
	public Deptlist() {
		
	}
	
	public Deptlist(String deptcode, String deptname, String salary) {
		super();
		this.deptcode = deptcode;
		this.deptname = deptname;
		this.salary = salary;
	}
	
	public String getDeptcode() {
		return deptcode;
	}
	public void setDeptcode(String deptcode) {
		this.deptcode = deptcode;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	
}
