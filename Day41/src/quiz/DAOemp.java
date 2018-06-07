package quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class DAOemp {
	
	Deptlist dp = new Deptlist();
	
	private Connection dbConnet() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE"; 
		String DB_USER = "kh";
		String DB_PASSWORD = "kh";
		Connection con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
		return con;
	}
	
	public List<Deptlist> selectDB() throws Exception {
		Connection con = this.dbConnet();
		PreparedStatement pst =null;
		String sql = "select nvl(e.dept_code,'인턴'), "
				+ " nvl((SELECT dept_title FROM DEPARTMENT where e.dept_code = dept_id),'인턴'), to_char(sum(e.salary),'L999,999,999') " + 
				" from employee e GROUP BY e.DEPT_CODE";
		pst = con.prepareStatement(sql);
		ResultSet rs  = pst.executeQuery();
		List<Deptlist> list = new ArrayList<>();
		while(rs.next()) {
			Deptlist dep = new Deptlist();
			
			String deco = rs.getString(1);
			String deti = rs.getString(2);
			String sa = rs.getString(3);
			
			dep.setDeptcode(deco);
			dep.setDeptname(deti);
			dep.setSalary(sa);
			
			list.add(dep);
		}
		return list;
	}
	
	public List<JobCodeList> jobselectDB() throws Exception{
		Connection con = this.dbConnet();
		PreparedStatement pst =null;
		String sql = "SELECT e.JOB_CODE,j.JOB_NAME, TO_CHAR(sum(e.SALARY),'L999,999,999')||'원',TO_CHAR(floor(avg(e.SALARY)),'L999,999,999')||'원',COUNT(*)||'명'  " + 
				" FROM EMPLOYEE e, JOB j where  e.job_code = j.JOB_CODE " + 
				" GROUP BY e.JOB_CODE , j.JOB_NAME ORDER BY 1";
		pst = con.prepareStatement(sql);
		ResultSet rs  = pst.executeQuery();
		List<JobCodeList> list = new ArrayList<>();
		while(rs.next()) {
			JobCodeList jot = new JobCodeList();
			
			String jobc = rs.getString(1);
			String jobt = rs.getString(2);
			String sum = rs.getString(3);
			String avg = rs.getString(4);
			String coun = rs.getString(5);
			
			jot.setJobCode(jobc);
			jot.setJobTitle(jobt);
			jot.setTotalSalary(sum);
			jot.setAvgSalary(avg);
			jot.setCountpeople(coun);
			
			list.add(jot);
		}
		return list;
	}
	
}
