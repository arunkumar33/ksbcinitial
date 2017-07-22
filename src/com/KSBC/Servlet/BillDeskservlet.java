package com.KSBC.Servlet;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BillDeskservlet
 */
/*@WebServlet("/BillDeskservlet")*/
public class BillDeskservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillDeskservlet() {
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
	/*	request.setAttribute("msg1", "Arun");
		HttpSession Servletsession = request.getSession(false);
		if (Servletsession==null)
		{
			Servletsession = request.getSession(true);
		}
		Servletsession.setAttribute("msg12", "Kiran");
		
		// String nextJSP = "/billdesk2.jsp";
*/		Map<String, String[]> extraParams = new TreeMap<String, String[]>();
		extraParams.put("msg",  new String[]{"KSBC|1223464566645|NA|2|NA|NA|NA|INR|NA|R|ksbc|NA|NA|"
+"F|REG/1/2002|A Arun|arunkumar@gmail.con|NA|NA|"
+"NA| NA|http://139.59.34.42:8080/ksbc2/Response.jsp|1F2BFDBA10A377DAE6ED28D5E84BA492E63BD849C16C2241F66B538E3369521D"});
				HttpServletRequest wrappedRequest = new PrettyFacesWrappedRequest(request, extraParams);
				
				request=wrappedRequest;
				
				System.out.println(wrappedRequest.getParameter("msg") + "wrappedRequest");
				System.out.println(request.getParameter("msg") + "    msg");
	/*	RequestDispatcher rd= request.getRequestDispatcher("BillDeskReceiveChecking");*/
		
		/*request.getParameterMap().put("msg",  new String[]{"value1"});*/
		/*rd.forward(wrappedRequest,response);*/
		response.setStatus(307); //this makes the redirection keep your requesting method as is.
		response.addHeader("Location", "https://pgi.billdesk.com/pgidsk/PGIMerchantPayment");
		

	}

}
