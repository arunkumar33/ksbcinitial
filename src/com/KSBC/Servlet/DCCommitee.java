package com.KSBC.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.KSBC.Bean.DC_Committee;
import com.KSBC.Util.HibernateUtil;

/**
 * Servlet implementation class DCCommitee
 */
/*@WebServlet("/DCCommitee")*/
public class DCCommitee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DCCommitee() {
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
		String complaintNumber = request.getParameter("complaintNumber");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


		
		
		//convert String to LocalDate
		
		String name =request.getParameter("name");
		String Advocate=request.getParameter("Advocate");
		String Reason=request.getParameter("Reason");
		String Remarks=request.getParameter("Remarks");
		String Place=request.getParameter("Place");
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Long phone=Long.parseLong(request.getParameter("phone"));
		Long phoneAgainst=Long.parseLong(request.getParameter("phoneAgainst"));
String Complaintdate=request.getParameter("Complaintdate");	
LocalDate localDateStart = LocalDate.parse(Complaintdate, formatter);




	java.util.Date date2 = Date.from(localDateStart.atStartOfDay()
	        .atZone(ZoneId.systemDefault()).toInstant());
	    Timestamp timeStamp = new Timestamp(date2.getTime());
	   	
	System.out.println(timeStamp + "   Comparing timestamp");
DC_Committee DC_Committee = new DC_Committee();
DC_Committee.setCaseDate(timeStamp);
DC_Committee.setPlace(Place);
DC_Committee.setAgainstAdvocate(Advocate);
DC_Committee.setAgainstAdvocatePhoneNumber(phoneAgainst);
DC_Committee.setCaseDate(timeStamp);
DC_Committee.setCaseDetails("NA");
DC_Committee.setComplaintPhoneNumber(phone);
DC_Committee.setName(name);
DC_Committee.setPlace(Place);
DC_Committee.setRemarks(Remarks);
DC_Committee.setComplaintNumber(complaintNumber);
DC_Committee.setReason(Reason);

Session.saveOrUpdate(DC_Committee);

//	HTTPSession.getAttribute("KARNumber");
	 response.setContentType("text/html");
	    
	    
	   
	 String   responseString="<h1>Record Added SuccessFully</h2>"
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
