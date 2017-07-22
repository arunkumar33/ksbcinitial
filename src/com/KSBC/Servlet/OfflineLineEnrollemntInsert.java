package com.KSBC.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class OfflineLineEnrollemntInsert
 */
/*@WebServlet("/OfflineLineEnrollemntInsert")*/
public class OfflineLineEnrollemntInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OfflineLineEnrollemntInsert() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String PhoneNumber=request.getParameter("phone");
		System.out.println(PhoneNumber + "Phone Number");
		 long PhoneNumberLong = Long.parseLong(PhoneNumber);
		 Short Cast=1;
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		 System.out.println(request.getParameter("birthdate") + "Birthdate");
		String First_name = request.getParameter("first_name");
		System.out.println(First_name + " ********** *************** **************** **********");
		      java.util.Date parsed = null;
			try {
				parsed =  format.parse(request.getParameter("birthdate"));
				 java.sql.Date datesql = new java.sql.Date(parsed.getTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  java.sql.Date datesql = new java.sql.Date(parsed.getTime());
		String Address = (request.getParameter("address"));
		
		String BloodGroup = (request.getParameter("BloodGroup"));
		
		String CastCategory = request.getParameter("CastCategory");
		if (CastCategory.equalsIgnoreCase("General"))
		{
			Cast=1;
		}
		else
		{
			Cast=2;	
		}
		String city = request.getParameter("city");

		
	//	.setDiscontinuanceOfPractice(request.getParameter(arg0));
	
		String Father_name = request.getParameter("Father_name");
		// .setFullName(request.getParameter(arg0));
		String GenderCategory = request.getParameter("GenderCategory");
	
		// .setNotAnClitizen(request.getParameter(arg0));
		String email=(String) request.getParameter("email");
		
		
	//	.setPhone(request.getParameter(arg0));
		String PlaceOfPractice = request.getParameter("PlaceOfPractice");
	
	//	.setRegNumber(request.getParameter(arg0));
		String state = request.getParameter("state");
		String KARNumber = request.getParameter("KARNumber");
		System.out.println(KARNumber + "KARNumber");
	
		
System.out.println("DOne");
int ZipCode = Integer.parseInt(request.getParameter("ZipCode"));
		
	
java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
// TODO Auto-generated method stub




//	System.out.println(KARNumber +"  !!!!!!!!!!!!!!!");
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
	      sql = " INSERT INTO [dbo].[EnrollmentDetails] "
	    		
	    		 
	    		  +"([RollNo] "
	    		        +"   ,[EnrollNo] "
	    		        +"   ,[EnrollmentRegistrationNo] "
	    		         +"  ,[CertificateNo] "
	    		         +"  ,[TitleId] "
	    		        +"   ,[Name] "
	    		        +"   ,[Gender] "
	    		        +"   ,[Father_Title] "
	    		        		   +"   ,[FatherName] "
	    		        +"   ,[DateOfBirth] "
	    		       +"    ,[BloodGroup] "
	    		        +"   ,[CategoryId] "
	    		         +"  ,[Communication_Address1] "
	    		        +"  ,[Communication_Address2] "
	    		        +"   ,[Communication_Address3] "
	    		       +"    ,[Communication_City] "
	    		        +"   ,[Communication_State] "
	    		        +"   ,[Communication_PinCode] "
	    		        +"   ,[Permanent_Address1] "
	    		         +"  ,[Permanent_Address2] "
	    		         +"  ,[Permanent_Address3] "
	    		         +"  ,[Permanent_PinCode] "
	    		        +"   ,[Permanent_City] "
	    		         +"  ,[Permanent_State] "
	    		         +"  ,[Nominee_Title] "
	    		        +"   ,[Nominee_Name] "
	    		        +"   ,[IsMinor] "
	    		        +"   ,[GuardianName] "
	    		        +"   ,[Relationship] "
	    		        +"   ,[Nominee_Address1] "
	    		        		   +"   ,[Nominee_Address2] "
	    		        +"   ,[Nominee_Address3] "
	    		        +"   ,[Nominee_City] "
	    		        +"   ,[Nominee_State] "
	    		        +"   ,[Nominee_PinCode] "
	    		        		   +"   ,[PracticeCategory] "
	    		         +"  ,[EMail] "
	    		         +"  ,[Phone_Res] "
	    		        +"   ,[Phone_Off] "
	    		        +"   ,[MobileNo] "
	    		        +"   ,[Remarks] "
	    		        +"   ,[EnrollmentStatus] " 
	    		        +"   ,[EnrollmentSource] "
	    		        		   +"   ,[WelfareMember] "
	    		         +"  ,[EnrollmentDate] "
	    		       +"    ,[Place_Of_Practice] "
	    		        +"   ,[WelfareMemberUpdatedDate] "
	    		        +"   ,[SeniorMember] "
	    		       +"    ,[SeniorMemberUpdatedDate] "
	    		        		   +"    ,[enr_Year] "
	    		       +"    ,[enr_Month] "
	    		       +"    ,[enr_Days] "
	    		        +"   ,[SeniorAdvocate] "
	    		        +"   ,[SeniorAdvocateUpdatedDate] "
	    		        +"   ,[CertificateStatus] " 
	    		        +"   ,[CertificateIssued] "
	    		        +"   ,[CertificateIssuedOn] "
	    		        +"   ,[ManagerApproved] "
	    		       +"    ,[NomineeVerified] "
	    		        +"   ,[ApplnForm] "
	    		        +"   ,[WelfareLifeTimeMember]) "
+" VALUES "
 +"   ('"+KARNumber+"'"
 + ",'"+""+"'"   
 + ",'"+KARNumber+"'"       
        +"   ,null "
        +"   ,null "
        + ",'"+First_name+"'" 
        + ",'"+GenderCategory+"'"   
       +"    ,null "
       + ",'"+Father_name+"'" 
       + ",'"+datesql+"'" 
       + ",'"+BloodGroup+"'" 
       + ",'"+Cast+"'" 
       + ",'"+Address+"'" 
    +"      ,null "
     +"     ,null "
     + ",'"+city+"'" 
      +"     ,null "
      + ",'"+ZipCode+"'" 
    +"      ,null "
    +"      ,null "
    +"       ,null "
     +"     ,null "
     +"     ,null "
     +"      ,null "
    +"       ,null "
    +"      ,null "
          +"      ,null "
    +"        ,null "
    +"       ,null "
    +"      ,null "
    +"      ,null "
   +"       ,null "
          +"       ,null "
   +"       ,null "
   +"       ,null "
    +"       ,null "
    + ",'"+email+"'" 
    + ",'"+PhoneNumberLong+"'" 
      +"     ,null "
      + ",'"+PhoneNumberLong+"'" 
     +"      ,null "
      +"     ,null "
      +"      ,null "
      +"     ,'Y' "
      +"     ,'"+date+"'"  
      + ",'"+PlaceOfPractice+"'" 
      +"     ,null "
      +"     ,null "
     +"      ,null "
           +"     ,null "
       +"    ,null "
       +"    ,null "
      +"     ,null "
       +"    ,null "
       +"     ,null "
      +"     ,null "
      +"     ,null "
      +"     ,null "
       +"    ,null "
       +"    ,null "
       +"  ,'N')";
 	      
	      
/*	      
System.out.println(EnrollmentDetails.getRollNo());*/
	   
	   PreparedStatement PrepareStateMent = conn.prepareStatement(sql);

	      int rs = PrepareStateMent.executeUpdate();
	  System.out.println("!!!!!!!!!!!!!!@#$$$$$$$$$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%");
	      //STEP 5: Extract data from result set
	//      String responseString = "Not coming SOrry";
	    
	      
	      if (rs>0)
	      {
	    	  
	    	  System.out.println("Akshay Inserted");
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
