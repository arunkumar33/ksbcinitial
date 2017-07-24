package com.KSBC.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.classic.Session;

import com.KSBC.Bean.AcceptedCandidate;
import com.KSBC.Bean.EnrollmentDetails;
import com.KSBC.Bean.KARNumberCreation;
import com.KSBC.Bean.REGNumberCreation;
import com.KSBC.Bean.ScheduleInterviewListBean;
import com.KSBC.Bean.ValidatedFinalBean;
import com.KSBC.JSPRelatedFunctions.JSPRelatedFunctionsimp;
import com.KSBC.Util.HibernateUtil;
import com.KSBC.Util.JDBCUtil;

/**
 * Servlet implementation class GenerateAllCandidateKAR
 */
/*@WebServlet("/GenerateAllCandidateKAR")*/
public class GenerateAllCandidateKAR extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerateAllCandidateKAR() {
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
		
		
		try
		{
			
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
			JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
		ArrayList<AcceptedCandidate> AcceptList = JSPRelatedFunctionsimp.ViewAcceptedCandidateIndesc();
		String responseString="	<!DOCTYPE html> "
				+"<html> "
				+"<head> "
				+"<meta charset=\"ISO-8859-1\"> "
				+"<title>Insert title here</title> "
				+"<style type=\"text/css\"> "




				+".a { "
				 +"   width: 1px; "
				  +"  border: 1px white; "
				  +"  padding: 100px; "
				 +"   margin: 0px; "
				 +"} "

				+"body{ "
				 +"  page-break-inside: avoid; "
				 +"} "


				+"h1 { "
				+"page-break-before: always; "
				+"}   "

				+"</style> "

				 
				+"</head> "; // for certificate
		
		String Another="<table class='table table-striped'><thead><tr><th>#</th>"
				+ "<th>KAR Number</th><th>Reg Number</th><th>Name</th>"
				+ "<th>Father Name</th>"
				+ "<th>Place Of practice</th>"
				+ "<th>Birthdate</th>"
				+" </tr>"
				  +  " </thead>"
				  +  "<tbody>";
		// change here
		int indexForSchedule=0;
		for (AcceptedCandidate ScheduleInterviewListBean : AcceptList) {
		
			 System.out.println(AcceptList.size() + " Jagga Size");
			
		java.sql.Date Sqldate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
			
			 
			 String regNumberUniquecode=ScheduleInterviewListBean.getAddress()+System.currentTimeMillis()+ScheduleInterviewListBean.getBloodGroup()+ ScheduleInterviewListBean.getBusinessDetails()+ScheduleInterviewListBean.getBirthdate()+ScheduleInterviewListBean.getBloodGroup()+ScheduleInterviewListBean.getBirthdate()+ScheduleInterviewListBean.getEmail()+"sdfdf"+ScheduleInterviewListBean.getCity();
			 KARNumberCreation KARNumberCreation= new KARNumberCreation();
			 KARNumberCreation.setRegNumber(regNumberUniquecode);
			 System.out.println(regNumberUniquecode);
			 Session.saveOrUpdate(KARNumberCreation);
			 Session.beginTransaction().commit();
			 Query query = Session.createQuery("from KARNumberCreation where RegNumber = :RegNumber  ");
			 query.setParameter("RegNumber", regNumberUniquecode);
			  @SuppressWarnings("unchecked")
			 ArrayList<KARNumberCreation> list = (ArrayList<KARNumberCreation>)query.list();
			  int id= list.get(0).getId();
			 System.out.println(list.get(0).getId());
			 id=id+352;   //168  //165
			 int year=2017;
			 String REGNumber="KAR"+"/"+id +"/"+year;
			 
			// ChallanResponse2+=JSPRelatedFunctionsimp.GenerateCertificate(REGNumber, ScheduleInterviewListBean.getFather_name(), ScheduleInterviewListBean.getFullName(), timestamp, ScheduleInterviewListBean.getRegNumber());
			//  ChallanResponse2+=ChallanResponse;
			
			 EnrollmentDetails EnrollmentDetails = new EnrollmentDetails();
			 EnrollmentDetails.setApplnForm('0');
			 EnrollmentDetails.setBloodGroup(ScheduleInterviewListBean.getBloodGroup());
			 Short categoryId=1;
		/*	 if(ScheduleInterviewListBean.getGenderCategory().equalsIgnoreCase("M"))
			 {
				 categoryId=1;
			 }
			 else
			 {
				 categoryId=2;
			 }*/

Connection conn = null;


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
 +"   ('"+REGNumber+"'"
 + ",'"+REGNumber+"'"   
 + ",'"+ScheduleInterviewListBean.getRegNumber()+"'"       
        +"   ,null "
        +"   ,null "
        + ",'"+ScheduleInterviewListBean.getFullName()+"'" 
        + ",'"+categoryId+"'"   
       +"    ,null "
       + ",'"+ScheduleInterviewListBean.getFather_name()+"'" 
       + ",'"+ScheduleInterviewListBean.getBirthdate()+"'" 
       + ",'"+ScheduleInterviewListBean.getBloodGroup()+"'" 
       + ",'"+""+"'"  // cast
       + ",'"+ScheduleInterviewListBean.getAddress()+"'" 
    +"      ,null "
     +"     ,null "
     + ",'"+ScheduleInterviewListBean.getCity()+"'" 
      +"     ,null "
      + ",'"+ScheduleInterviewListBean.getZipCode()+"'" 
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
    + ",'"+ScheduleInterviewListBean.getEmail()+"'" 
    + ",'"+ScheduleInterviewListBean.getPhone()+"'" 
      +"     ,null "
      + ",'"+ScheduleInterviewListBean.getPhone()+"'" 
     +"      ,null "
      +"     ,null "
      +"      ,null "
      +"     ,'Y' "
      +"     ,'"+Sqldate+"'"  
      + ",'"+ScheduleInterviewListBean.getPlaceOfPractice()+"'" 
      +"     ,'"+Sqldate+"'"  
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
 	      
	      
      
System.out.println(sql + "insert query");
	   
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
			 System.out.println("#############");
			 System.out.println(responseString );
			 System.out.println(REGNumber);
			System.out.println("KAR Number" + REGNumber);
				 Another =  " <tr>"
					    +  "  <th scope='row'>"+(indexForSchedule+1)+"</th>"
					    +  " <td> " +REGNumber+"</td>"
					      +  " <td> " +ScheduleInterviewListBean.getRegNumber()+"</td>"
					      +  " <td> " +ScheduleInterviewListBean.getFullName()+"</td>"
					      +  " <td> " +ScheduleInterviewListBean.getFather_name()+"</td>"
					        +  " <td> " +ScheduleInterviewListBean.getPlaceOfPractice()+"</td>"
					     
					      +  " <td> " +ScheduleInterviewListBean.getBirthdate()+"</td>"
						      
					     +" </tr>";
			 indexForSchedule++;
		
		Session.delete(ScheduleInterviewListBean);
		Session.beginTransaction().commit();	  
		} // end
		//responseString+="</tbody></table>";
		
		
		 response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		    
		   out.println(Another);
		   
		 /*  out.println("<center><h2><b>Report Of Interview Accepted Candidate </h2></b></center>");
		    out.println("<br/><br/>");
		   */ 
		//    out.println(ChallanResponse2);
		   //out.println("HIii");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
