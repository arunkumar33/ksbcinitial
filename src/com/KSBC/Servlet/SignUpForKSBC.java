package com.KSBC.Servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KSBC.SendMail.SendMailImp;

/**
 * Servlet implementation class SignUpForKSBC
 */
/*@WebServlet("/SignUpForKSBC")*/
public class SignUpForKSBC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpForKSBC() {
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
		
		System.out.println("Hi coming for signup");
		String Username = (String)request.getParameter("Username");
		String Email = (String)request.getParameter("Email");
		String Domain = (String)request.getParameter("Domain");
		
		String Deactivate="http://139.59.34.42:8080/KSBC4/LoginActivator?UserName="+Username+"&Domain="+Domain+"&Validate=yes&email="+Email;
		String Link="http://139.59.34.42:8080/KSBC4/LoginActivator?UserName="+Username+"&Domain="+Domain+"&Validate=yes&email="+Email;
		String Subject="Need access for "+Domain +" for the user "+ Username;
		String Message="Hi If you know the requested person please click on the below link to activate the persons account    "+ Link+"    This is automated mail please dont reply and any time if you dont want to this person to be a part of KSBC click the below click."+Deactivate;
		SendMailImp SendMailImp= new SendMailImp();
		SendMailImp.SendMail("arunkumar.1rn12ec400@gmail.com", "sowmyaMANJULA", "Notification", "arunkumar.1rn12ec400@gmail.com", Subject, Message);
		//AccountLogin.jsp
		response.sendRedirect("AccountLogin.jsp");
	}

}
