package com.KSBC.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.classic.Session;

import com.KSBC.Bean.Tappal_Outworld;
import com.KSBC.Util.HibernateUtil;

/**
 * Servlet implementation class TapalAssertInsert
 */
/*@WebServlet("/TapalAssertInsert")*/
public class Tapaloutworld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tapaloutworld() {
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
		
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		PrintWriter out = response.getWriter();
		try
		{
		String UserName=request.getParameter("UserName");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		String Address=request.getParameter("Address");
		String Particular=request.getParameter("Particular");
		String Remarks=request.getParameter("Remarks");
		String OutworldDate=request.getParameter("Date");
		LocalDate localDateStart = LocalDate.parse(OutworldDate, formatter);




		java.util.Date date2 = Date.from(localDateStart.atStartOfDay()
		        .atZone(ZoneId.systemDefault()).toInstant());
		    Timestamp timeStamp = new Timestamp(date2.getTime());
		   	
		System.out.println(timeStamp + "   Comparing timestamp");
		long postalCharge=Long.parseLong(request.getParameter("postalCharge"));
		Tappal_Outworld Tappal_Outworld= new Tappal_Outworld();
		Tappal_Outworld.setAddress(Address);
		Tappal_Outworld.setName(UserName);
		Tappal_Outworld.setParticular(Particular);
		Tappal_Outworld.setPostalCharge(postalCharge);
		Tappal_Outworld.setRemarks(Remarks);
		Tappal_Outworld.setOutWorldDate(timeStamp);
		

int id = (int)Session.save(Tappal_Outworld);
int year=2017;
String World="KSBC/TAPPAL/Out/"+id+"/"+year;
Tappal_Outworld.setOutworldNumber(World);
Session.update(Tappal_Outworld);
//	HTTPSession.getAttribute("KARNumber");
	 response.setContentType("text/html");
	    
	    
	   
	 String   responseString="<h1>Record Added SuccessFully</h2> "+World +""
               ;
	    out.println(responseString);
	    
	    
	    Session.beginTransaction().commit();
	    Session.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		out.println("Please enter valid inputs");
	}
	}
}
