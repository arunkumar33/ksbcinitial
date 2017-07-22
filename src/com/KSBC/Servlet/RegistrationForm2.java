package com.KSBC.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.KSBC.Bean.Step3RegistrationForm;

/**
 * Servlet implementation class RegistrationForm2
 */

public class RegistrationForm2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationForm2() {
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
		
		
		Step3RegistrationForm Step3RegistrationForm = new Step3RegistrationForm();
		Step3RegistrationForm.setAddress(request.getParameter("Address"));
		
		Step3RegistrationForm.setDiscontinuanceOfPractice(request.getParameter("discontinuanceOfPractice"));
		Step3RegistrationForm.setFullName(request.getParameter("FullName"));
		Step3RegistrationForm.setNomineeDetails(request.getParameter("nomineeDetails"));
		Step3RegistrationForm.setPlaceOfPractice(request.getParameter("PlaceOfPractice"));
		
		Step3RegistrationForm.setPreviousEmployment(request.getParameter("PreviousEmployment"));
		Step3RegistrationForm.setProportionOfShare(request.getParameter("ProportionOfShare"));
		Step3RegistrationForm.setRegNumber(request.getParameter("RegNumber"));
		
		/*	Calling HiberNate*/
	/*	
		 SessionFactory TransactionsessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		   Session Transactionsession = null;
		    Transaction TransactionDBtransaction = null;
		  
		   
		 
		    Transactionsession=  TransactionsessionFactory.openSession(); // Transaction Session
		    
		    
		    TransactionDBtransaction = Transactionsession.beginTransaction(); // Transaction for Transaction DB
		    TransactionDBtransaction.begin();
		    Transactionsession.saveOrUpdate(Step3RegistrationForm);
		  
	
		 
		TransactionDBtransaction.commit();
		*/
		/*Here All the data should map to register bean class with all 3 step Registration*/
		System.out.println("All Done");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/OnlinePayment.jsp");
		dispatcher.forward(request, response);
	}

}
