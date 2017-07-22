package com.KSBC.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.KSBC.Bean.AIBTable;
import com.KSBC.Bean.EnrollmentDetails;
import com.KSBC.JSPRelatedFunctions.JSPRelatedFunctionsimp;
import com.KSBC.Util.HibernateUtil;

/**
 * Servlet implementation class AIB
 */
/*@WebServlet("/AIB")*/
public class AIB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AIB() {
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
		
		System.out.println("Hi");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String KARArray=request.getParameter("KARNumber");
		  Session Session = HibernateUtil.getSessionFactory().openSession();
			Transaction Tx = Session.beginTransaction();
			
		int len=0;
		System.out.println("Hi");
		String communication1="";
		String communication2="";
		String communication3="";
		String AIBRemarks=request.getParameter("Remark");
		String AIBDateString=request.getParameter("AIBDate");
		
		System.out.println(AIBDateString + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		
		String name="";
		String place="";
	
		String Another="<!DOCTYPE html> "
				+"<html> "
				+"<head> "
				+"<meta charset=\"ISO-8859-1\"> "
				+ "</head>"
				+ "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">"


+"<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js\"></script>"


+"<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>"
				+ ""
				+ ""
				+"<title>Insert title here</title> "
				+"<br></br><br></br><br></br><br></br><h1><center><b>KSBC  Old KGID Building Bangalore</b></center></h1>"
				+ "<h1><center><b>AIB Report </b></center></h1>"
				+ "<br></br><br></br>"
				+ "<table class='table table-striped'>"
				+ "<th>SL Number</th>"
				+ "<th>KAR Details</th>"
				  +  "<tbody>";
/*		
		<thead><tr><th>SL Number</th>"
		+ "<th >Details</th>"
	
	
		+" </tr>"
		  +  " </thead>"
		*/
		
		AIBTable AIBTable = new AIBTable();
		
		AIBTable.setAIBRemarks(AIBRemarks);
		AIBTable.setAIBdate(AIBDateString);
		JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
		if((KARArray==null) ||(KARArray.equalsIgnoreCase("")))
				{
			len=1;
				}
		EnrollmentDetails ed=null;
		if(len==0)
		{
		String[] KARStringArray = KARArray.split(",");
		int indexForSchedule=0;
		if((KARStringArray!=null) ||(KARStringArray.length>0))
		{
			for (String KARNumber : KARStringArray) {
				
				try
				
				{
					AIBTable.setKARNumber(KARNumber);
					Session.saveOrUpdate(AIBTable);
					Session.beginTransaction().commit();
				}
				
				catch(Exception e)
				{
					e.printStackTrace();
				}
				ed=JSPRelatedFunctionsimp.GetEnrollmentDetails(KARNumber);
				communication1=ed.getCommunication_Address1();
				communication2=ed.getCommunication_Address2();
				communication3=ed.getCommunication_Address3();
				name=ed.getName();
				place=ed.getPlace_Of_Practice();
				if((name==null) )
				{
					name="";
				}
				if((place==null) )
				{
					place="";
				}
				if((communication1==null) )
				{
					communication1="";
				}
				if((communication2==null) )
				{
					communication2="";
				}
				if((communication3==null) )
				{
					communication3="";
				}
				
				 Another += 
						 " <tr><td rowspan=\"4\"> "+(indexForSchedule+1)+"</td></tr> "
  
   +"   <tr><td> " +ed.getName()+"</td></tr> "
    +"  <tr><td> " +communication1+","+communication2+","+communication3+","+"</td></tr> "
    +"  <tr><td> " +KARNumber+"</td></tr> "
   ;
						 
					/*	 " <tr>"
						    +  "  <th scope='row'>"+(indexForSchedule+1)+"</th>"
						   
						      +  " <td rowspan=\"3\"> " +ed.getName()+"/n"+communication1+","+communication2+","+communication3+","+"\n"+KARNumber+"</td>"
						    
						      +  " <td> " +communication1+","+communication2+","+communication3+","+"</td>"
						      +  " <td> " +KARNumber+"</td>"    
						     +" </tr>";*/
				 indexForSchedule++;
			}
			
			
		}
		
		}
		
		Session.close();
		 response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		    
		   out.println(Another);
		   
	}

}
