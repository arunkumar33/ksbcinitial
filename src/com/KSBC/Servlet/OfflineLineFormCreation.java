package com.KSBC.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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
import com.KSBC.Bean.REGNumberCreation;
import com.KSBC.Bean.REGNumberCreation23;
import com.KSBC.Bean.ScheduleConfirmationBean;
import com.KSBC.JSPRelatedFunctions.JSPRelatedFunctionsimp;
import com.KSBC.Util.HibernateUtil;

/**
 * Servlet implementation class OfflineLineFormCreation
 */

public class OfflineLineFormCreation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OfflineLineFormCreation() {
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
		
		ScheduleConfirmationBean ScheduleConfirmationBean = new ScheduleConfirmationBean();
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		PrintWriter out = response.getWriter();
		try
		{
		
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
		ScheduleConfirmationBean.setPlaceOfPractice(request.getParameter("PlaceOfPractice"));
String regNumberUniquecode=System.nanoTime()+First_name+""+parsed+request.getParameter("PlaceOfPractice");

System.out.println("****************** Before  ********************");
REGNumberCreation23 REGNumberCreation23= new REGNumberCreation23();
REGNumberCreation23.setRegNumber(regNumberUniquecode);
System.out.println(regNumberUniquecode + "  Reg&&&&&&&&&&&&&&&&&&&&&*************************");
Session.saveOrUpdate(REGNumberCreation23);
System.out.println("****************** After  ********************");
Query query = Session.createQuery("from REGNumberCreation23 where RegNumber = :RegNumber  ");
query.setParameter("RegNumber", regNumberUniquecode);
 @SuppressWarnings("unchecked")
ArrayList<REGNumberCreation23> list = (ArrayList<REGNumberCreation23>)query.list();
 int id= list.get(0).getId();
System.out.println(list.get(0).getId());
int year=2017;
id=id+20000; // final version is 146 //143
String REGNumber="REG"+"/"+id +"/"+year;
ScheduleConfirmationBean.setRegNumber(REGNumber);
		Session.saveOrUpdate(ScheduleConfirmationBean);
		HttpSession HTTPSession = request.getSession();
		HTTPSession.setAttribute("KARNumber", ScheduleConfirmationBean.getRegNumber());
	//	KARNumber
		System.out.println(HTTPSession.getAttribute("KARNumber"));
		 
		  DateScheduleForInterviewBean DateScheduleForInterviewBean= new DateScheduleForInterviewBean();
		  
		  java.sql.Date sqlDate = null ;
	         java.util.Date parsed1 = null;
			try {
				parsed1 =  format.parse(SceduleDate);
				sqlDate = new java.sql.Date(parsed1.getTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Errorrrrrrrrrrrrrrr");
				
			}
			
			DateScheduleForInterviewBean.setDateOfSchedule(sqlDate);
			DateScheduleForInterviewBean.setRegNumber(ScheduleConfirmationBean.getRegNumber());
			Session.saveOrUpdate(DateScheduleForInterviewBean);
			
	//	HTTPSession.getAttribute("KARNumber");
		 response.setContentType("text/html");
		    
		    
		   
		 String   responseString="<form action='OfflineFileImageUpload' method='post'"
                    +" enctype='multipart/form-data'>"
						
						
						
						+"<div class='form-group'>"
+" <label class='col-md-4 control-label'>Upload your Photo"
+" (Must not more then 500KB only jpg and png is allowed)</label> "  
+" <div class='col-md-4 inputGroupContainer'> "
+" <div class='input-group'> "
+"  <span class='input-group-addon'><i class='glyphicon glyphicon-user'></i></span> "
+"  <input type='file' name='ChallanFile' size='50' /> </br></br> "
+"  <button type='submit' class='btn btn-warning'>Next Step <span class='glyphicon glyphicon-send'></span></button>"
+" </div> "
+" </div> "
+ " </div>"
+ " </form>";
		    out.println(responseString);
		    
		    
		    Session.beginTransaction().commit();
		    Session.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			out.println("Please enter valid inputs");
		}
	}
	}


