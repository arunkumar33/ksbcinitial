package com.KSBC.Servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.KSBC.JSPRelatedFunctions.JSPRelatedFunctionsimp;

/**
 * Servlet implementation class RegistrationLogin
 */
/*@WebServlet("/RegistrationLogin")*/
public class RegistrationLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationLogin() {
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
		
		System.out.println("****** Coming Here *********");
		String REGNumber=request.getParameter("REGNumber");
		System.out.println("User name " + REGNumber);
		HttpSession Servletsession = request.getSession(false);
		if (Servletsession==null)
		{
			Servletsession = request.getSession(true);
		}
		
		Servletsession.setAttribute("REGNumber", REGNumber);
		
		System.out.println(Servletsession.getAttribute("REGNumber")   +  "   Session");
		String Password=request.getParameter("Password");
		System.out.println("Password " + Password);
		JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
		/*String Domain_name = "New Enrollment";
		
		String ResultOfInsertintoDomainTable = JSPRelatedFunctionsimp.InsertintoLoginDomain(UserName, Password, Domain_name);
		*/
		//System.out.println(ResultOfInsertintoDomainTable + " Insert Result");
		String Domain=JSPRelatedFunctionsimp.RegistrationLoginFormValidatationForUSernameandPassword(REGNumber, Password);
		if (Domain.equals("Success"))
		{
			System.out.println(" HI Login is successful redirecting to new url");
			
			response.setContentType("text/html");  
			PrintWriter pw=response.getWriter();  
			request.setAttribute("REGNumber", REGNumber);
			
			response.sendRedirect("RegistrationForm3.jsp");  
			  
			pw.close();  
		}
		else
		{
			System.out.println(" HI Login is not successful redirecting to same  url");
				response.setContentType("text/html");  
				PrintWriter pw=response.getWriter();  
				request.setAttribute("REGNumber", REGNumber);
				
				response.sendRedirect("index1.jsp");  
				  
				pw.close();  
			
		}
	}

}
