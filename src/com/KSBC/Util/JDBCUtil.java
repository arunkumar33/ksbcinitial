package com.KSBC.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {

	
public static  Connection GetConnection()
{

		//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
		String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
		String user = "sa";
		String pass = "ksbc@123";
		System.out.println("Hi");
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
		

