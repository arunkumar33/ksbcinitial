package com.KSBC.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;*/







import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.KSBC.Bean.Step1RegistrationForm;
import com.KSBC.JSPRelatedFunctions.JSPRelatedFunctionsimp;
import com.KSBC.Util.HibernateUtil;

/**
 * Servlet implementation class RegistrationForm
 */
/*@WebServlet("/RegistrationForm")*/
public class RegistrationForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config); 
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
		ServletContext con = getServletContext();
		System.out.println("coming to ssdfghjkl; ervlet");
		String PhoneNumber=request.getParameter("phone");
		System.out.println(PhoneNumber + "Phone Number");
		 long PhoneNumberLong = Long.parseLong(PhoneNumber);
		 SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
		 System.out.println(request.getParameter("birthdate") + "Birthdate");
		String First_name = request.getParameter("first_name");
		JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
		 String regnumber = JSPRelatedFunctionsimp.RegNumberGenration(First_name);
	         java.util.Date parsed = null;
			try {
				parsed =  format.parse(request.getParameter("birthdate"));
				 java.sql.Date sql = new java.sql.Date(parsed.getTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        java.sql.Date sql = new java.sql.Date(parsed.getTime());
		SessionFactory Session = HibernateUtil.getSessionFactory();
		Step1RegistrationForm Step1RegistrationForm = new Step1RegistrationForm();
		Step1RegistrationForm.setAddress(request.getParameter("address"));
		Step1RegistrationForm.setBirthdate(sql);
		Step1RegistrationForm.setBloodGroup("BloodGroup");
		Step1RegistrationForm.setEmail(request.getParameter("email"));
		Step1RegistrationForm.setFather_name(request.getParameter("Father_name"));
		Step1RegistrationForm.setFirst_name(request.getParameter("first_name"));
		Step1RegistrationForm.setPhone(PhoneNumberLong);
		Step1RegistrationForm.setRegNumber(regnumber);
		Step1RegistrationForm.setState(request.getParameter("state"));
		Step1RegistrationForm.setZipCode(Integer.parseInt(request.getParameter("ZipCode")));
		Step1RegistrationForm.setCity(request.getParameter("city"));
		Step1RegistrationForm.setCitizenOfIndia(request.getParameter("CitizenOfIndia"));
		Step1RegistrationForm.setNotAnClitizen(request.getParameter("NotAnClitizen"));
		Step1RegistrationForm.setCastCategory(request.getParameter("CastCategory"));
		Step1RegistrationForm.setGenderCategory(request.getParameter("GenderCategory"));
		
		/*System.out.println(request.getParameter("city"));
		RequestDispatcher dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/RegistrationForm2");
		
		dispatcher.forward(request,response);*/
		 SessionFactory TransactionsessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		   Session Transactionsession = null;
		    Transaction TransactionDBtransaction = null;
		  
		   
		 
		    Transactionsession=  TransactionsessionFactory.openSession(); // Transaction Session
		    
		    
		    TransactionDBtransaction = Transactionsession.beginTransaction(); // Transaction for Transaction DB
		    TransactionDBtransaction.begin();
		    Transactionsession.saveOrUpdate(Step1RegistrationForm);
		  
		// request.getRequestDispatcher("/Registration2JSP").forward(request, response);
	/*	RequestDispatcher d = con.getRequestDispatcher("/WEB-INF/NewFile.jsp");
		d.forward(request, response);*/
		 
		TransactionDBtransaction.commit();
		response.sendRedirect("/ServletExample/Registration2JSP");  
	}

}
