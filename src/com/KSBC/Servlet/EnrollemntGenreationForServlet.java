package com.KSBC.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KSBC.Bean.ScheduleInterviewListBean;
import com.KSBC.JSPRelatedFunctions.JSPRelatedFunctionsimp;

/**
 * Servlet implementation class EnrollemntGenreationForServlet
 */
/*@WebServlet("/EnrollemntGenreationForServlet")*/
public class EnrollemntGenreationForServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollemntGenreationForServlet() {
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
		 response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		    
			JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
			ArrayList<ScheduleInterviewListBean> absentList=JSPRelatedFunctionsimp.ViewInterviewconfirmCandidate();
			
			if (absentList.get(0)==null)
			{
				out.println("List is Empty ");
			}
			
			else 
			{
				
				System.out.println("Else Part");
				String   responseString="<table class='table table-striped'><thead>"
						+ "<tr><th>#</th><th>Reg Number</th>"
						+ "<th>Name</th>"
						+ "<th>Father Name</th>"
		  +  "<th>Birth date</th>"
		  + ""
		  + "<th>Place Of practice</th>  </tr>"
		  +  " </thead>"
		  +  "<tbody>";
				   int indexForSchedule=1;
				   
				   for (ScheduleInterviewListBean RegBean : absentList) {
					   responseString +=  " <tr>"
							    +  "  <th scope='row'>"+indexForSchedule+"</th>"
							    +  " <td> " +RegBean.getRegNumber()+"</td>"
							      +  " <td> " +RegBean.getFullName()+"</td>"
							     +  " <td> " +RegBean.getFather_name()+"</td>"
							      +  " <td> " +RegBean.getBirthdate()+"</td>"
							      
							     
							      +  " <td> " +RegBean.getPlaceOfPractice()+"</td>"
							      
							     +" </tr>";
					   indexForSchedule++;
				}
		    out.println("<center><h2><b>Report Of Interview Attending Candidate </h2></b></center>");
		    out.println("<br/><br/>");
		    out.println(responseString);
		System.out.println("DoGet");
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
