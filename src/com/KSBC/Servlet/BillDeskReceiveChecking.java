package com.KSBC.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BillDeskReceiveChecking
 */
/*@WebServlet("/BillDeskReceiveChecking")*/
public class BillDeskReceiveChecking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillDeskReceiveChecking() {
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
	
		
		
		 
				Enumeration en=request.getParameterNames();
		 
				while(en.hasMoreElements())
				{
					Object objOri=en.nextElement();
					String param=(String)objOri;
					String value=request.getParameter(param);
					System.out.println("Parameter Name is '"+param+"' and Parameter Value is '"+value+"'");
				}		
				
		
		System.out.println(request.getParameter("msg"));
	
		response.setStatus(307); //this makes the redirection keep your requesting method as is.
		response.addHeader("Location", "http://localhost:8080/ServletExample/OnineBillDesk1");
		
		//
	}

}
