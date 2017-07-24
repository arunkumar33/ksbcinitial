package com.KSBC.Servlet;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.Base64;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.apache.commons.io.IOUtils;

import com.KSBC.Util.JDBCUtil;

/**
 * Servlet implementation class ImageFetching
 */
/*@WebServlet("/ImageFetching")*/
public class ImageFetching extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageFetching() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		response.setContentType("text/html");
				ServletOutputStream out ;
				String OutputResult="not working";
				int resultoutput=0;
				String photoinstring="";
				String KARNumber= request.getParameter("KARNumber");
				out = response.getOutputStream();
				Connection conn = null;
				String responseString = " Error while processing please try again later ";
				try {

					//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
					/*String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
					String user = "sa";
					String pass = "ksbc@123";
					System.out.println("Hi");
					
					try {
						Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					conn = DriverManager.getConnection(dbURL, user, pass);*/
					try
					{
					 conn = JDBCUtil.GetConnection();
					 
					}catch(Exception e)
					{
						e.printStackTrace();
					}
					if (conn != null) {
						DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
					//	 java.sql.Statement stmt = conn.createStatement();
						
					      String sql;
					      //sql = "  select EnrollmentId   FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments] where EnrollmentId='KAR/1/2002'";
					      sql = "select [photo] from  [dbo].[Enrollment_Photos] "
					      		
					      		+ "WHERE EnrollmentId=?";
					      
					      
					
					   
					   PreparedStatement PrepareStateMent = conn.prepareStatement(sql);
					   PrepareStateMent.setInt(1, 44726);
				//PrepareStateMent.setString(1, KARNumber);
				
					   byte[] bytes =null;
			
					      ResultSet rs = PrepareStateMent.executeQuery();
					      byte[] read = null;
					      while(rs.next())
					      {
					    	  
					    	  photoinstring=rs.getString("photo");
					      
					      System.out.println("data:image/png;base64,"+rs.getString("photo"));
					      }
								  out.flush();
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
			
			
				out.println("data:image/png;base64,"+photoinstring);
			//	return "String ";	
			
				
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
