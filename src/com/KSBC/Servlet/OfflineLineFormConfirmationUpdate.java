package com.KSBC.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.classic.Session;

import com.KSBC.Bean.DateScheduleForInterviewBean;
import com.KSBC.Bean.REGNumberCreation23;
import com.KSBC.Bean.ScheduleConfirmationBean;
import com.KSBC.JSPRelatedFunctions.JSPRelatedFunctionsimp;
import com.KSBC.Util.HibernateUtil;

/**
 * Servlet implementation class OfflineLineFormConfirmationUpdate
 */
/*@WebServlet("/OfflineLineFormConfirmationUpdate")*/
public class OfflineLineFormConfirmationUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OfflineLineFormConfirmationUpdate() {
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
		 response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
			Session Session = HibernateUtil.getSessionFactory().openSession();
			Session.beginTransaction();
			
		try
		{
			
		
		ScheduleConfirmationBean ScheduleConfirmationBean = new ScheduleConfirmationBean();

		String REGNumber=request.getParameter("REGNumber");

	 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		 System.out.println(request.getParameter("birthdate") + "Birthdate");
		String First_name = request.getParameter("first_name");
		System.out.println(First_name + " ********** *************** **************** **********");
		      java.util.Date parsed = null;
			try {
				parsed =  format.parse(request.getParameter("birthdate"));
				 java.sql.Date sql = new java.sql.Date(parsed.getTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  java.sql.Date sql = new java.sql.Date(parsed.getTime());
			  
			  
			  
			 
				  String SceduleDate = request.getParameter("ScheduleInterview");	 
		ScheduleConfirmationBean.setAddress(null);
		ScheduleConfirmationBean.setBirthdate(sql);
		ScheduleConfirmationBean.setBloodGroup(null);
		ScheduleConfirmationBean.setBusinessDetails(null);
		ScheduleConfirmationBean.setCastCategory(null);
		
		ScheduleConfirmationBean.setCity(null);
		ScheduleConfirmationBean.setCollege(null);
		ScheduleConfirmationBean.setConvictedDetails(null);
	//	ScheduleConfirmationBean.setDiscontinuanceOfPractice(request.getParameter(arg0));
		ScheduleConfirmationBean.setEmail(null);
		ScheduleConfirmationBean.setFather_name(request.getParameter("Father_name"));
		// ScheduleConfirmationBean.setFullName(request.getParameter(arg0));
		ScheduleConfirmationBean.setGenderCategory(null);
		ScheduleConfirmationBean.setNomineeDetails(null);
		ScheduleConfirmationBean.setNotAnClitizen(null);
		// ScheduleConfirmationBean.setNotAnClitizen(request.getParameter(arg0));
		
		ScheduleConfirmationBean.setOtherProfessional(null);
		ScheduleConfirmationBean.setPendingCriminalCases(null);
		ScheduleConfirmationBean.setFirst_name(request.getParameter("First_name"));
		ScheduleConfirmationBean.setFullName(First_name);


ScheduleConfirmationBean.setRegNumber(REGNumber);
	//	ScheduleConfirmationBean.setPhone(request.getParameter(arg0));
		ScheduleConfirmationBean.setPlaceOfPractice(request.getParameter("PlaceOfPractice"));
		ScheduleConfirmationBean.setPreviousApplicationDetails(null);
	//	ScheduleConfirmationBean.setPreviousEmployment(request.getParameter(arg0));
		ScheduleConfirmationBean.setProportionOfShare(null);
	//	ScheduleConfirmationBean.setRegNumber(request.getParameter(arg0));
		ScheduleConfirmationBean.setState(null);
		ScheduleConfirmationBean.setTerminatedDetails(null);
		ScheduleConfirmationBean.setUniversity_Name(null);
		ScheduleConfirmationBean.setYear_course(null);
		ScheduleConfirmationBean.setYear_of_Completion(1);
System.out.println("DOne");
		ScheduleConfirmationBean.setZipCode(0);
		Session.update(ScheduleConfirmationBean);
		HttpSession HTTPSession = request.getSession();
		HTTPSession.setAttribute("KARNumber", ScheduleConfirmationBean.getRegNumber());
	//	KARNumber
		System.out.println(HTTPSession.getAttribute("KARNumber"));
		  JSPRelatedFunctionsimp JSPRelatedFunctionsimp= new JSPRelatedFunctionsimp();
		  DateScheduleForInterviewBean DateScheduleForInterviewBean= new DateScheduleForInterviewBean();
		  
		  java.sql.Date sqlDate = null ;
	         java.util.Date parsed1 = null;
			try {
				parsed1 =  format.parse(SceduleDate);
				sqlDate = new java.sql.Date(parsed1.getTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			sqlDate = new java.sql.Date(parsed1.getTime());
			DateScheduleForInterviewBean.setDateOfSchedule(sqlDate);
			DateScheduleForInterviewBean.setRegNumber(ScheduleConfirmationBean.getRegNumber());
			Session.update(DateScheduleForInterviewBean);
			
	//	HTTPSession.getAttribute("KARNumber");
		
		    
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		 String   responseString="Updated Successfully";
		    out.println(responseString);
		    
		    
		    Session.beginTransaction().commit();
		    Session.close();
	}

}