package com.KSBC.Servlet;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PhotoFetching {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		
		java.util.Date today = new java.util.Date();
	    java.sql.Timestamp ts1 = new java.sql.Timestamp(today.getTime());
		
		
		//System.out.println(KARNumber +"  !!!!!!!!!!!!!!!");
		String OutputResult="not working";
		int resultoutput=0;
		Connection conn = null;
		String responseString = " Error while processing please try again later ";
		try {

			//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
			String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
			String user = "sa";
			String pass = "ksbc@123";
			System.out.println("Hi");
			
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(dbURL, user, pass);
			if (conn != null) {
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Driver name: " + dm.getDriverName());
				System.out.println("Driver version: " + dm.getDriverVersion());
				System.out.println("Product name: " + dm.getDatabaseProductName());
				System.out.println("Product version: " + dm.getDatabaseProductVersion());
				
				System.out.println("Product version: " + dm.getUserName());	
				
				System.out.println("Product version: " );	
			//	 java.sql.Statement stmt = conn.createStatement();
				
			      String sql;
			      //sql = "  select EnrollmentId   FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments] where EnrollmentId='KAR/1/2002'";
			      sql = "select [photo] from  [dbo].[Enrollment_Photos] "
			      		
			      		+ "WHERE EnrollmentId=?";
			      
			      
			
			   
			   PreparedStatement PrepareStateMent = conn.prepareStatement(sql);
			   PrepareStateMent.setInt(1, 4855);
		//PrepareStateMent.setString(1, KARNumber);
		
		
	
			      ResultSet rs = PrepareStateMent.executeQuery();
			      byte[] read = null;
			      while(rs.next())
			      {
			    	  read = rs.getBytes(1);
			    	  
			      }
			      System.out.println(read.length);   
			      int length = read.length;
			  System.out.println("!!!!!!!!!!!!!!@#$$$$$$$$$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%");
			      //STEP 5: Extract data from result set
			//      String responseString = "Not coming SOrry";
			  InputStream in = new ByteArrayInputStream(read);
			  PrintStream out = null;
			   int bufferSize = 1024;
	            byte[] buffer = new byte[bufferSize];

	            while ((length = in.read(buffer)) != -1) {
	              
	            System.out.println(length);
			//	out.write(buffer, 0, length);
	            }
			  
			  in.close();
			      PrepareStateMent.close();
			      conn.close();				
			    	
			}

		} catch (SQLException ex) {
			  responseString="Error occured Please try again later";	
			     ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	//	String responseString;
	
	
	
	//	return "String ";	
	
	}

}
