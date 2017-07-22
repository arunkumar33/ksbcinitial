package com.KSBC.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.KSBC.Bean.CashSectionMonthlyReport;
import com.KSBC.Bean.CashSectionMonthlyReportFlow;
import com.KSBC.Bean.KAWFLateWelfareFundBean;
import com.KSBC.JSPRelatedFunctions.JSPRelatedFunctionsimp;
import com.KSBC.Util.HibernateUtil;

/**
 * Servlet implementation class KAWFLateWelfareFund
 */
/*@WebServlet("/KAWFLateWelfareFund")*/
public class KAWFClaims extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KAWFClaims() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("*********************** arun Hi  **********************************");
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
			 
		String ClaimDate=request.getParameter("ClaimDate");
		System.out.println(ClaimDate);
	String KARNumber= request.getParameter("KARNumber");
	System.out.println(KARNumber);
	
	
	
	String Name= request.getParameter("Name");
	System.out.println(Name);
	
	String Place= request.getParameter("Place");
	System.out.println(Place);
	
		String ClaimType=request.getParameter("ClaimType");
		System.out.println(ClaimType);
	
		
		int ClaimAmount=Integer.parseInt(request.getParameter("ClaimAmount"));
		System.out.println(ClaimAmount);


		String Remarks = (String)request.getParameter("Remarks");
		System.out.println(Remarks);

		
		
		String ResolutionNumber=request.getParameter("ResolutionNumber");
		System.out.println(ResolutionNumber);

		
		String ResolutionDate = (String)request.getParameter("ResolutionDate");
		System.out.println(ResolutionDate);
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		 
		 LocalDate ClaimDateLocal = LocalDate.parse(ClaimDate, formatter);
		 LocalDate ResolutionDateLocal = LocalDate.parse(ResolutionDate, formatter);
		JSPRelatedFunctionsimp JSPRelatedFunctionsimp= new JSPRelatedFunctionsimp();
		
	//	public String UpdateClimReport(LocalDate ClaimDate,String KARNumber,String Name,String Place,String ClaimType,String ClaimAmount,String Remarks,String ResolutionNumber,LocalDate ResolutionDate);
		out.println("");
		String result = JSPRelatedFunctionsimp.UpdateClimReport(ClaimDateLocal, KARNumber, Name, Place, ClaimType, ClaimAmount+"", Remarks, ResolutionNumber+"", ResolutionDateLocal);
	/*	System.out.println(result);*/
		out.println(result);

	}

}