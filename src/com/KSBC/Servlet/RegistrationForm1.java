package com.KSBC.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.KSBC.Bean.Step2RegistrationForm;

/**
 * Servlet implementation class RegistrationForm1
 */

public class RegistrationForm1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationForm1() {
        super();
        // TODO Auto-generated constructor stub
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
		/*System.out.println("RegistrationForm1");
		System.out.println(request.getParameter("CitizenOfIndia") + " CitizenOfIndia ");
		
		System.out.println(request.getParameter("state") + " State ");
		System.out.println(request.getParameter("address") + " address ");
		
System.out.println(request.getParameter("ZipCode") + " ZipCode ");
		
		System.out.println(request.getParameter("BloodGroup") + " BloodGroup ");
		System.out.println(request.getParameter("birthdate") + " birthdate ");
		System.out.println(request.getParameter("NotAnClitizen") + " NotAnClitizen ");*/
		
		Step2RegistrationForm Step2RegistrationForm = new Step2RegistrationForm();
		Step2RegistrationForm.setBusinessDetails(request.getParameter("BusinessDetails"));
		Step2RegistrationForm.setCollege(request.getParameter("College"));
		Step2RegistrationForm.setConvictedDetails(request.getParameter("convictedDetails"));
		Step2RegistrationForm.setOtherProfessional(request.getParameter("OtherProfessional"));
		Step2RegistrationForm.setPendingCriminalCases(request.getParameter("PendingCriminalCases"));
		Step2RegistrationForm.setPlaceOfPractice(request.getParameter("PlaceOfPractice"));
		Step2RegistrationForm.setPreviousApplicationDetails(request.getParameter("PreviousApplicationDetails"));
		Step2RegistrationForm.setRegNumber(request.getParameter("RegNumber"));
		Step2RegistrationForm.setTerminatedDetails(request.getParameter("terminatedDetails"));
		Step2RegistrationForm.setUniversity_Name(request.getParameter("University_Name"));
		Step2RegistrationForm.setYear_course(request.getParameter("Year_course"));
		String year_of_Completion=request.getParameter("year_of_Completion");
		System.out.println(year_of_Completion + "year_of_Completion");
		 int year_of_CompletionInt = Integer.parseInt(year_of_Completion);
		Step2RegistrationForm.setYear_of_Completion(year_of_CompletionInt);
		
	/*	Calling HiberNate*/
		
		 SessionFactory TransactionsessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		   Session Transactionsession = null;
		    Transaction TransactionDBtransaction = null;
		  
		   
		 
		    Transactionsession=  TransactionsessionFactory.openSession(); // Transaction Session
		    
		    
		    TransactionDBtransaction = Transactionsession.beginTransaction(); // Transaction for Transaction DB
		    TransactionDBtransaction.begin();
		    Transactionsession.saveOrUpdate(Step2RegistrationForm);
		  
	
		 
		TransactionDBtransaction.commit();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/RegistrationForm2.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
