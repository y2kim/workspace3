package kh.web.dbutils;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBUtils {
	public static Connection dbConnect() throws Exception {
		Context context = new InitialContext();
		DataSource ds =(DataSource)context.lookup("java:/comp/env/oracle");
		return ds.getConnection() ;
	}
}
