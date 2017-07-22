package com.KSBC.Servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.KSBC.Bean.EnrollmentDetails;
import com.KSBC.Bean.ValidatedFinalBean;
import com.KSBC.JSPRelatedFunctions.JSPRelatedFunctionsimp;

/**
 * Servlet implementation class KARLogin
 */
/*@WebServlet("/KARLogin")*/
public class KARLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KARLogin() {
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
		HttpSession Servletsession = request.getSession(false);
		if (Servletsession==null)
		{
			Servletsession = request.getSession(true);
		}
		
		String KARNumber = request.getParameter("KARNumber");
		System.out.println(KARNumber + "  KARNumber");
		System.out.println("coming here");
		if (KARNumber==null || KARNumber=="")
		{
		System.out.println("No KAR Number");	
		
		 response.sendRedirect("index1.jsp"); 
		
		}
		else
		{
			// Check if KAR number is valid or not
			JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
			
		
			EnrollmentDetails validatedBean = JSPRelatedFunctionsimp.GetEnrollmentDetails(KARNumber);
			String AIB=JSPRelatedFunctionsimp.GetAIBRemarks(KARNumber);
			
			String[] AIBArray = AIB.split("Div");
			try
			{
			validatedBean.setAIBDate(AIBArray[0]);
			validatedBean.setAIBRemarks(AIBArray[1]);
			}
			catch(Exception e)
			{
				validatedBean.setAIBDate("");
				validatedBean.setAIBRemarks("");
			}
			if (validatedBean==null)
			{
				System.out.println("Coming Here inside if ");
				 response.sendRedirect("index1.jsp"); 	
			}
			else 
			{
				System.out.println(validatedBean.getEnrollmentId() + "  Enrollmentid");
				String src="";
				String Privioussrc=JSPRelatedFunctionsimp.GetPhotoDetailsForWelfare(validatedBean.getEnrollmentId());
				
				System.out.println(Privioussrc + "  Its what coming");
				if(!Privioussrc.contains("Error"))
				{
					src=Privioussrc;	
				}
				else
				{
					src="ImageServlet?RegNumber="+validatedBean.getEnrollmentRegistrationNo()+"&WhichPhoto=Photo";
					
					
				}
				System.out.println(src + "  src");
				System.out.println(validatedBean.getName() + "********************8 ^^^^^^^^");
				Servletsession.setAttribute("KARNumber", KARNumber);
				Servletsession.setAttribute("Name", validatedBean.getName());
				Servletsession.setAttribute("ImageURL", src);
				String WelfatreDes=JSPRelatedFunctionsimp.GetClaimRemarksForWelfare(KARNumber);
					
				Servletsession.setAttribute("WelfatreDes", WelfatreDes);
				Servletsession.setAttribute("validatedBean", validatedBean);
				request.setAttribute("validatedBean", validatedBean);
				//send redirect
				response.sendRedirect("KARLogin.jsp");  
				
			}
		}
	}

}
