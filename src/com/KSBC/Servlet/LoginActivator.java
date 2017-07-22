package com.KSBC.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.classic.Session;

import com.KSBC.Bean.DomainLoginBean;
import com.KSBC.Bean.RegistrationFormBean;
import com.KSBC.JSPRelatedFunctions.JSPRelatedFunctionsimp;
import com.KSBC.SendMail.SendMailImp;
import com.KSBC.Util.HibernateUtil;

/**
 * Servlet implementation class LoginActivator
 */
/*@WebServlet("/LoginActivator")*/
public class LoginActivator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginActivator() {
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
		System.out.println("Coming here Login Activate");
		String UserName = (String)request.getParameter("UserName");
		String Domain = request.getParameter("Domain");
		String email = request.getParameter("email");
		String Validate = (String)request.getParameter("Validate");
		JSPRelatedFunctionsimp JSPRelatedFunctionsimp= new JSPRelatedFunctionsimp();
		
		String Password=JSPRelatedFunctionsimp.RegNumberGenration(UserName);
		DomainLoginBean DomainLoginBean = new DomainLoginBean();
		DomainLoginBean.setDomain(Domain);
		DomainLoginBean.setPassword(Password);
		DomainLoginBean.setUserName(UserName);
		Session.beginTransaction().commit();
		if (Validate.equalsIgnoreCase("yes"))
		{
			Session.saveOrUpdate(DomainLoginBean);
			SendMailImp SendMailImp= new SendMailImp();
			
			String Subject = "Congradulation you got an access";
			String Message="Hi You got a access to the ksbc portal and your user name is "+UserName+" password is  "+Password+"  Please dont share the password with anyone.";
			SendMailImp.SendMail("arunkumar.1rn12ec400@gmail.com", "sowmyaMANJULA", "Notification from KSBC", email, Subject, Message);
		}
		else
		{
			Session.delete(DomainLoginBean);
		}
		
		Session.beginTransaction().commit();
	Session.saveOrUpdate(DomainLoginBean);
		 Session.close();
		
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
