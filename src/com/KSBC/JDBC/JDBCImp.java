package com.KSBC.JDBC;

import java.beans.Statement;
import java.sql.*;

public class JDBCImp implements JDBCInterface {

	@Override
	public String WelfareFundPayed(String EnrollmentID) {
		// TODO Auto-generated method stub
		

		Connection conn = null;

		try {

			String dbURL = "jdbc:sqlserver://107.180.71.40\\MSSQLSERVER";
			String user = "sa";
			String pass = "ksbc";
			System.out.println("Hi");
			conn = DriverManager.getConnection(dbURL, user, pass);
			if (conn != null) {
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Driver name: " + dm.getDriverName());
				System.out.println("Driver version: " + dm.getDriverVersion());
				System.out.println("Product name: " + dm.getDatabaseProductName());
				System.out.println("Product version: " + dm.getDatabaseProductVersion());
				
				System.out.println("Product version: " + dm.getUserName());	
				
				System.out.println("Product version: " );	
				 java.sql.Statement stmt = conn.createStatement();
			      String sql;
			      sql = "  select TOP 1  EnrollmentId,FromYear,ToYear,AmountPaid,AmountPaidOn FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments] where  EnrollmentId='kar/162/2012' order by  FromYear desc";
			      ResultSet rs = stmt.executeQuery(sql);
			 /*     SELECT TOP (1000) [EnrollmentId]
			    	      ,[ReceiptTransactionId]
			    	      ,[WelfareFundInstallmentNo]
			    	      ,[FromYear]
			    	      ,[ToYear]
			    	      ,[AmountPaid]
			    	      ,[AmountPaidOn]
			    	      ,[ReceiptNo]
			    	      ,[ReceiptDate]
			    	  FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments]*/
			      //STEP 5: Extract data from result set
			      while(rs.next()){
			         //Retrieve by column name
			    	 int EnrollmentId =rs.getInt(1);
			    	 System.out.println(EnrollmentId);
			    	 int FromYear =rs.getInt(1);
			    	 System.out.println(FromYear);
			    	 int ToYear =rs.getInt(1);
			    	 System.out.println(ToYear);
			    	 
			    	 int AmountPaid =rs.getInt(1);
			    	 System.out.println(AmountPaid);
			    	 
			    	 Date AmountPaidOn =rs.getDate(5);
			    	 System.out.println(EnrollmentId);
			         /*int id  = rs.getInt("id");
			         int age = rs.getInt("age");
			         String first = rs.getString("first");
			         String last = rs.getString("last");

			         //Display values
			         System.out.print("ID: " + id);
			         System.out.print(", Age: " + age);
			         System.out.print(", First: " + first);
			         System.out.println(", Last: " + last);*/
			      }
			      //STEP 6: Clean-up environment
			      rs.close();
			      stmt.close();
			      conn.close();
			}

		} catch (SQLException ex) {
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
		return EnrollmentID;
	}}

	


