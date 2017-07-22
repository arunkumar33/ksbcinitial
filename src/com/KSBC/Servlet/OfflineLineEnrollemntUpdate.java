package com.KSBC.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;




import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KSBC.Bean.EnrollmentDetails;
import com.KSBC.JSPRelatedFunctions.JSPRelatedFunctionsimp;

/**
 * Servlet implementation class OfflineLineEnrollemntUpdate
 */
/*@WebServlet("/OfflineLineEnrollemntUpdate")*/
public class OfflineLineEnrollemntUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OfflineLineEnrollemntUpdate() {
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
	    String SQL2 = "";
	    String PhoneNumber = request.getParameter("phone");
	    System.out.println(PhoneNumber + "Phone Number");
	    long PhoneNumberLong = Long.parseLong(PhoneNumber);
	    Short Cast = Short.valueOf((short)1);
	    String First_name = request.getParameter("first_name");
	    System.out.println(First_name + " ********** *************** **************** **********");
	    
	    String Address = request.getParameter("address");
	    
	    String DOB = request.getParameter("DOB"); 
	    
	    System.out.println(DOB + " DOB");
	    
	    String CastCategory = request.getParameter("CastCategory");
	    if (CastCategory.equalsIgnoreCase("General"))
	    {
	      Cast = Short.valueOf((short)1);
	    }
	    else
	    {
	      Cast = Short.valueOf((short)2);
	    }
	    

	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		 String StartDate=(String)request.getParameter("DOB");
		
	 java.util.Date parsedStartDate = null;
		
		 java.sql.Date StartDateSQLdate=null;
		
		 /*java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		 System.out.println(date);*/
		


	    String Father_name = request.getParameter("Father_name");
	    
	    String GenderCategory = request.getParameter("GenderCategory");
	    

	    String email = request.getParameter("email");
	    


	    String PlaceOfPractice = request.getParameter("PlaceOfPractice");
	    String CitizenOfIndia = "Y";
	    CitizenOfIndia = request.getParameter("CitizenOfIndia");
	    String NotAnClitizen = request.getParameter("NotAnClitizen");
	    String College = request.getParameter("College");
	    String Permenent = request.getParameter("Permenent");
	    


	    String KARNumber = request.getParameter("KARNumber");
	    System.out.println(KARNumber + "KARNumber");
	 
	    String PreviousApplicationDetails = request.getParameter("PreviousApplicationDetails");
	    
	    String terminatedDetails = request.getParameter("terminatedDetails");
	    String University_Name = request.getParameter("University_Name");
	    String Year_course = request.getParameter("Year_course");
	    String year_of_Completion = request.getParameter("year_of_Completion");
	    String BusinessDetails = request.getParameter("BusinessDetails");
	    String PendingCriminalCases = request.getParameter("PendingCriminalCases");
	    String OtherProfessional = request.getParameter("OtherProfessional");
	    
	    String Remarks = request.getParameter("Remarks");
	    


	    String convictedDetails = request.getParameter("convictedDetails");
	    
	    System.out.println("DOne");
	    
	    int Result = 0;
	    JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
	    


	    String preremarks = JSPRelatedFunctionsimp.GetRemarks(KARNumber);
	    if (preremarks == null)
	    {
	      preremarks = "";
	    }
	    


	    EnrollmentDetails ed = JSPRelatedFunctionsimp.GetEnrollmentDetails(KARNumber);
	    if (ed != null)
	    {
	      Result = JSPRelatedFunctionsimp.IsAdditionalInformationFromRegNumber(ed.getEnrollmentRegistrationNo());
	    }
	    






	    Connection conn = null;
	    String responseString = " Error while processing please try again later ";
	    
	    try
	    {
	      String dbURL = "jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
	      String user = "sa";
	      String pass = "ksbc@123";
	      System.out.println("Hi");
	      try
	      {
	        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	      }
	      catch (ClassNotFoundException e) {
	        e.printStackTrace();
	      }
	      conn = DriverManager.getConnection(dbURL, user, pass);
	      if (conn != null)
	      {



	    	  String sql = " UPDATE [dbo].[EnrollmentDetails] SET   [Name]='" + First_name + "'   ,[Gender]='" + GenderCategory + "'   ,[FatherName]='" + Father_name + "'   ,[CategoryId]='" + Cast + "'  ,[Communication_Address1]='" + Address + "'  ,[Communication_Address2]=''  ,[Communication_Address3]=''  ,[Permanent_Address1]='" + Permenent + "'  ,[Permanent_Address2]=''  ,[Permanent_Address3]=''  ,[EMail]='" + email + "'   ,[MobileNo]='" + PhoneNumberLong + "'    ,[Remarks] ='" + preremarks + ", " + Remarks + "'    ,[Place_Of_Practice]='" + PlaceOfPractice + "'  where RollNo='" + KARNumber + "'";
		       
	    	  if((DOB==null) || (DOB.equalsIgnoreCase("")))
	    	  		{
	    	  	System.out.println("YYYYYYYYYYYDate is not enterd");
	    	  		}
	    	  else
	    	  {
	    			try {
	    				parsedStartDate =  format.parse(StartDate);
	    				
	    				  StartDateSQLdate = new java.sql.Date(parsedStartDate.getTime());
	    				
	    			} catch (ParseException e) {
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	    			}
	    		   sql = " UPDATE [dbo].[EnrollmentDetails] SET      [DateOfBirth] = '" + StartDateSQLdate + "',[Name]='" + First_name + "'   ,[Gender]='" + GenderCategory + "'   ,[FatherName]='" + Father_name + "'   ,[CategoryId]='" + Cast + "'  ,[Communication_Address1]='" + Address + "'  ,[Communication_Address2]=''  ,[Communication_Address3]=''  ,[Permanent_Address1]='" + Permenent + "'  ,[Permanent_Address2]=''  ,[Permanent_Address3]=''  ,[EMail]='" + email + "'   ,[MobileNo]='" + PhoneNumberLong + "'    ,[Remarks] ='" + preremarks + ", " + Remarks + "'    ,[Place_Of_Practice]='" + PlaceOfPractice + "'  where RollNo='" + KARNumber + "'";
	 		     
	    	  	System.out.println("YYYYYYYYYYYDate is  enterd");	
	    	  } 
   PreparedStatement PrepareStateMent = conn.prepareStatement(sql);
	        
	        int rs = PrepareStateMent.executeUpdate();
	        System.out.println("!!!!!!!!!!!!!!@#$$$$$$$$$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%");
	        



	        if (rs > 0)
	        {
     SQL2 = "INSERT INTO [dbo].[Addnl_EnrollmentDetails]  ([EnrollmentId] "
	          		+ "   ,[EnrollmentRegistrationNo]    ,[Name_In_Certificate]    ,[DOBVerification]   "
	          		+ " ,[Indian]     ,[NonIndian_Reason]    ,[University]    ,[College] "
	          		+ "  ,[Year_Completed]    ,[Course_Years]    ,[Business_Name]    ,[Partnership] "
	          		+ "    ,[Proprietorship]     ,[Prev_Application_Details]    "
	          		+ " ,[Prev_Service_Details]     ,[Dismissed_Details]    "
	          		+ "  ,[Convicted_Details]       ,[Criminal_Details])    "
	          		+ "  VALUES  ('" + ed.getEnrollmentId() + "' ,'" + ed.getEnrollmentRegistrationNo() + "'   ,'" + First_name + "' ,  ''  , '" + CitizenOfIndia + "' , "
	          				+ " '" + NotAnClitizen + "'  , '" + University_Name + "' , "
	          						+ " '" + College + "'  , '" + year_of_Completion + "' ,"
	          								+ "  '" + Year_course + "' ,  '" + BusinessDetails + "'  , '' , "
	          										+ " '' ,  '" + PreviousApplicationDetails + "' , "
	          												+ " '" + OtherProfessional + "'  , '" + terminatedDetails + "' "
+ " , '" + convictedDetails + "' ,  '" + PendingCriminalCases + "')";
	          

	          String SQLUpdate = "UPDATE [dbo].[Addnl_EnrollmentDetails]  SET [EnrollmentId] = '" + ed.getEnrollmentId() + "'   ,[EnrollmentRegistrationNo] = '" + ed.getEnrollmentRegistrationNo() + "'   ,[Name_In_Certificate] = '" + ed.getName() + "'  ,[DOBVerification] = ''  ,[Indian] = '" + CitizenOfIndia + "'  ,[NonIndian_Reason] = '" + NotAnClitizen + "'  ,[University] = '" + University_Name + "'   ,[College] = '" + College + "'    ,[Year_Completed] = '" + year_of_Completion + "'    ,[Course_Years] = '" + Year_course + "'    ,[Business_Name] = '" + BusinessDetails + "'    ,[Partnership] = ''    ,[Proprietorship] = ''     ,[Prev_Application_Details] = '" + PreviousApplicationDetails + "'    ,[Prev_Service_Details] = '" + OtherProfessional + "'    ,[Dismissed_Details] = '" + terminatedDetails + "'    ,[Convicted_Details] = '" + convictedDetails + "'    ,[Criminal_Details] =  '" + PendingCriminalCases + "'  where EnrollmentRegistrationNo='" + ed.getEnrollmentRegistrationNo() + "'";
	          
	          System.out.println("Akshay Inserted");
	          
	          if (Result > 0)
	          {

	            PreparedStatement PrepareStateMent1 = conn.prepareStatement(SQLUpdate);
	            System.out.println(SQLUpdate + "  SQLUpdate");
	            int rs2 = PrepareStateMent1.executeUpdate();
	            System.out.println(rs2 + " Successful");
	            PrepareStateMent1.close();
	          }
	          else
	          {
	            PreparedStatement PrepareStateMent1 = conn.prepareStatement(SQL2);
	            System.out.println(SQL2 + "  SQL2");
	            int rs2 = PrepareStateMent1.executeUpdate();
	            System.out.println(rs2 + " Successful");
	          }
	          

	          responseString = "Sucessfully Updated";
	        }
	        else
	        {
	          responseString = "Error occured Please try again later";
	        }
	        
	        PrepareStateMent.close();
	        conn.close();
	      }
	        try
	      {
	        if ((conn != null) && (!conn.isClosed())) {
	          conn.close();
	        }
	      } catch (SQLException ex) {
	        ex.printStackTrace();
	      }
	 
	      response.setContentType("text/html");
	    }
	    catch (SQLException ex)
	    {
	      responseString = "Error occured Please try again later";
	      ex.printStackTrace();
	    } finally {
	      try {
	        if ((conn != null) && (!conn.isClosed())) {
	          conn.close();
	        }
	      } catch (SQLException ex) {
	        ex.printStackTrace();
	      }
	    }
	    
	    PrintWriter out = response.getWriter();
	    
	    out.println(responseString);
	    
	}

}


