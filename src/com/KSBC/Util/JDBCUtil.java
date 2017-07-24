package com.KSBC.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {

	
public static  Connection GetConnection()
{

		//String dbURL = "jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
	
	
	
		String dbURL="jdbc:sqlserver://localhost:1434;database=KSBCL;instanceName=KSBC;";
		String user = "sa";
		String pass = "ksbc";
		
		Connection conn=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 conn = DriverManager.getConnection(dbURL, user, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			conn=null;
		}
		return conn;
		
}
	}
		

