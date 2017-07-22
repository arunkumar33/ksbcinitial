package com.KSBC.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.KSBC.Bean.SeniorAdvocateTable;
import com.KSBC.Util.HibernateUtil;

/**
 * Servlet implementation class SeniorAdv
 */
/*@WebServlet("/SeniorAdv")*/
public class SeniorAdv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeniorAdv() {
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
		  PrintWriter out = response.getWriter();
		    Session Session = HibernateUtil.getSessionFactory().openSession();
		    Transaction tx = Session.beginTransaction();
		try
		{
		String Name = (String)request.getParameter("Name");
		String KARNumber = (String)request.getParameter("KARNumber");
		String Place= (String)request.getParameter("Place");
		
		
		int amount=0;
		try
		{
		
		 amount=Integer.parseInt(request.getParameter("PayedAmount"));
		
		}
		catch (Exception e)
		{
		e.printStackTrace();		
		}
		
		int YearOfPayed=0;
			try
		{
			YearOfPayed=Integer.parseInt(request.getParameter("PayedYear"));
		}
		catch (Exception e)
		{
		e.printStackTrace();		
		}
			 LocalDate today = LocalDate.now();
			SeniorAdvocateTable SeniorAdvocateTable = new SeniorAdvocateTable();
			SeniorAdvocateTable.setAmount(amount);
			SeniorAdvocateTable.setYearOfPayed(YearOfPayed);
			SeniorAdvocateTable.setEnrollNo(KARNumber);
			SeniorAdvocateTable.setName(Name);
			SeniorAdvocateTable.setPlace(Place);
			SeniorAdvocateTable.setChallanCreatedDate(java.sql.Date.valueOf(today));
			Session.saveOrUpdate(SeniorAdvocateTable);
			
			out.println("Data Inserted Successfully");
			tx.commit();	
	}
	
	catch(Exception e)
	{
		out.println("There is an error Please try again later " + e.getMessage());
		e.printStackTrace();
		tx.rollback();
	}

}
}
