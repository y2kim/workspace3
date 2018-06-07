package kh_dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBOCON {
	private Connection conn;
	
	public DBOCON() {
		// TODO Auto-generated constructor stub
	}
	
	private Connection dbConnet() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE"; 
		String DB_USER = "kh";
		String DB_PASSWORD = "kh";
		this.conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
		return this.conn;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	
}
