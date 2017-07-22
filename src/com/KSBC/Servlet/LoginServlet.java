package com.KSBC.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KSBC.Bean.Login;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		Login Login = new Login();
		String LoginType = request.getParameter("LoginType");
		if (LoginType.equalsIgnoreCase("Enrollment"))
		{
			Login.setDepartment("Enrollment");
			Login.setPassword(request.getParameter("Password"));
			Login.setUSerName(request.getParameter("UserName"));
		}
		else if (LoginType.equalsIgnoreCase("New_Enrollment"))
		{
			Login.setDepartment("New Enrollment");
			Login.setPassword(request.getParameter("Password"));
			Login.setUSerName(request.getParameter("UserName"));
		}
		else if (LoginType.equalsIgnoreCase("Account"))
		{
			Login.setDepartment("Account");
			Login.setPassword(request.getParameter("Password"));
			Login.setUSerName(request.getParameter("UserName"));
			
		}
	}

}
