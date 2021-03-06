package com.KSBC.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KSBC.JSPRelatedFunctions.JSPRelatedFunctionsimp;

/**
 * Servlet implementation class Transfer
 */
/*@WebServlet("/Transfer")*/
public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Transfer() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		
		
    String Name = request.getParameter("Name");
    String KARNumber = request.getParameter("KARNumber");
    String Place = request.getParameter("Place");
    String Remarks = request.getParameter("Remarks");
    String AnotherRemarks = request.getParameter("AnotherRemarks");
    String NocNumber = request.getParameter("NocNumber");
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    
    LocalDate today = LocalDate.now();
    java.sql.Date TodayDate = java.sql.Date.valueOf(today);
    System.out.println(request.getParameter("ResumptionDate") + "ResumptionDate");
    java.util.Date parsed = null;
    try {
      parsed = format.parse(request.getParameter("ResumptionDate"));
      java.sql.Date localDate1 = new java.sql.Date(parsed.getTime());
    }
    catch (ParseException e) {
      e.printStackTrace();
    }
    java.sql.Date datesql = new java.sql.Date(parsed.getTime());
    Connection conn = null;
    String responseString = " Error while processing please try again later ";
    
    JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
   try{
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
		
		
	      String sql;
	      //sql = "  select EnrollmentId   FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments] where EnrollmentId='KAR/1/2002'";
	      sql = " INSERT INTO [dbo].[Hst_Enrollment_Transfer]"
	    		  +"(EnrollmentId "
	    		  +",ReceiptTransactionId "
	    		  +",TransferType "
	    		  +",TransferredToState "
	    		 +", ReasonForTransfer "
	    		 +", NOCNo "
	    		+",  TransferredDate "
	    		+",  DateChanged )"
	      		+ "VALUES "
	      		 +"   ('"+enrollmentID+"'"
	      		 + ",'"+""+"'"   // ReceiptTransactionId
	      		+ ",'"+""+"'"    //TransferType
	      		+ ",'"+""+"'"   //TransferredToState
	      		+ ",'"+Remarks+"'"   //ReasonForTransfer
	      		+ ",'"+""+"'"  
	      		+ ",'"+datesql+"'"  
	      		+ ",'"+TodayDate+"')"; 
		    		
		    		 

	      
/*	      
System.out.println(EnrollmentDetails.getRollNo());*/
	   
	   PreparedStatement PrepareStateMent = conn.prepareStatement(sql);

	      int rs = PrepareStateMent.executeUpdate();
	  System.out.println("!!!!!!!!!!!!!!@#$$$$$$$$$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%");
	      //STEP 5: Extract data from result set
	//      String responseString = "Not coming SOrry";
	    
	  String result="Remarks Updated";
      if (rs>0)
      {
    	  
    	  System.out.println("Sucessfully Updated");
    	  result=  JSPRelatedFunctionsimp.UpdateRemarks(KARNumber, Remarks);
    	  System.out.println(result);
   
    	  responseString="Sucessfully Updated";	  
      }
	      else
	      {
	    	  responseString="Error occured Please try again later";	
	      }
	     
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

	//	KARNumber
	
	//	HTTPSession.getAttribute("KARNumber");
		 response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		// String   responseString="Inserted Successfully";
		    out.println(responseString);
		    
	}

}
