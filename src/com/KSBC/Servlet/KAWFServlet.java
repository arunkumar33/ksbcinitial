package com.KSBC.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.KSBC.Bean.CashSectionMonthlyReport;
import com.KSBC.Bean.CashSectionMonthlyReportFlow;
import com.KSBC.Bean.KAWFfeeStructure;
import com.KSBC.JSPRelatedFunctions.JSPRelatedFunctionsimp;
import com.KSBC.Util.HibernateUtil;

/**
 * Servlet implementation class KAWFServlet
 */
/*@WebServlet("/KAWFServlet")*/
public class KAWFServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KAWFServlet() {
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
		
		
		System.out.println("*********************** Hi  **********************************");
		 response.setContentType("text/html");
		 
		    PrintWriter out = response.getWriter();
		    Session Session = HibernateUtil.getSessionFactory().openSession();
			Transaction Tx = Session.beginTransaction();
			 LinkedHashMap<String, Integer> mapChallanScannedCopy = new LinkedHashMap<String, Integer>();
			 CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();		
			 CashSectionMonthlyReport CashSectionMonthlyReport= new CashSectionMonthlyReport();
		int EnrollmentFee = Integer.parseInt(request.getParameter("EnrollmentFee"));
		int IdentityCard = Integer.parseInt(request.getParameter("IdentityCard"));
		String Name = (String)request.getParameter("Name");
		String KARNumber = (String)request.getParameter("KARNumber");
		String BankName = (String)request.getParameter("BankName");
		String BranchName = (String)request.getParameter("BranchName");
		String Place= (String)request.getParameter("Place");
		int Amount = Integer.parseInt(request.getParameter("Amount"));
		String ChequeNumber = (String)request.getParameter("ChequeNumber");
		String DDNumber = (String)request.getParameter("DDNumber");
		KAWFfeeStructure KAWFfeeStructure= new KAWFfeeStructure();
		KAWFfeeStructure.setAmount(Amount);
		KAWFfeeStructure.setBankName(BankName);
		KAWFfeeStructure.setBranchName(BranchName);
		KAWFfeeStructure.setChequeNumber(ChequeNumber);
		KAWFfeeStructure.setDDNumber(DDNumber);
		KAWFfeeStructure.setEnrollmentFee(EnrollmentFee);
		KAWFfeeStructure.setIdentityCard(IdentityCard);
		KAWFfeeStructure.setKARNumber(KARNumber);
		KAWFfeeStructure.setName(Name);
		KAWFfeeStructure.setPlace(Place);
		 HttpSession Servletsession = request.getSession(false);
			if (Servletsession==null)
			{
				Servletsession = request.getSession(true);
			} 
			
			String Operator= (String) Servletsession.getAttribute("UserName");
			
			System.out.println(Operator + " Operator");
			
		LocalDate date = LocalDate.now();
		Integer total=IdentityCard+EnrollmentFee;
		  String timeStamp1 = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		  CashSectionMonthlyReportFlow.setChallanCreatedDate(Date.valueOf(date));
		  CashSectionMonthlyReport.setChallanCreatedDate(Date.valueOf(date)); // converted from LocalDate
		  if (EnrollmentFee>0)
			 {
// person can't create or pay for 2 challan at single shot 
			  try
			  {
			  CashSectionMonthlyReport.setAmount(EnrollmentFee);
			  CashSectionMonthlyReport.setEnrollNo(KARNumber + " " + Name);
		//	  CashSectionMonthlyReport.setEntFee(EnrollmentFee);
			//  CashSectionMonthlyReport.set
			  CashSectionMonthlyReport.setParticulars("KSWF Enrollment Fee");
		  CashSectionMonthlyReport.setKAWF(EnrollmentFee);
		  
		  CashSectionMonthlyReportFlow.setAmount(EnrollmentFee);
		  CashSectionMonthlyReportFlow.setEnrollNo(KARNumber + " " + Name);
		  CashSectionMonthlyReportFlow.setEntFee(EnrollmentFee);
		//  CashSectionMonthlyReport.set
		  CashSectionMonthlyReportFlow.setParticulars("KSWF Enrollment Fee");
		  CashSectionMonthlyReportFlow.setKAWF(EnrollmentFee);
	  
	  
		  Session.saveOrUpdate(CashSectionMonthlyReport);
		  Session.saveOrUpdate(CashSectionMonthlyReportFlow);
Session.beginTransaction().commit();
				 mapChallanScannedCopy.put("EnrollmentFee", EnrollmentFee);
				 
			  }
			  catch (Exception e)
			  {
				  e.printStackTrace();
				  Session.beginTransaction()
				  .rollback();
			  }
			 }
			 if (IdentityCard>0)
			 {
				 
				 try
				 {
					 
				 
				 CashSectionMonthlyReport.setAmount(IdentityCard);
				  CashSectionMonthlyReport.setEnrollNo(KARNumber + " " + Name);
				  CashSectionMonthlyReport.setKAWF(IdentityCard);
				//  CashSectionMonthlyReport.set
				  CashSectionMonthlyReport.setParticulars("KSWF Identitiy Card");
			//  CashSectionMonthlyReport.setKAWF(EnrollmentFee);
			  
			  CashSectionMonthlyReportFlow.setAmount(EnrollmentFee);
			  CashSectionMonthlyReportFlow.setEnrollNo(KARNumber + " " + Name);
			//  CashSectionMonthlyReportFlow.setEntFee(EnrollmentFee);
			//  CashSectionMonthlyReport.set
			  CashSectionMonthlyReportFlow.setParticulars("KSWF Identitiy Card");
			  CashSectionMonthlyReportFlow.setKAWF(EnrollmentFee);
		  
		  
			  Session.saveOrUpdate(CashSectionMonthlyReport);
			  Session.saveOrUpdate(CashSectionMonthlyReportFlow);
	Session.beginTransaction().commit();
				 mapChallanScannedCopy.put("IdentityCard", IdentityCard);
			 }
			  catch (Exception e)
			  {
				  e.printStackTrace();
				  Session.beginTransaction()
				  .rollback();
			  }
			 }
			 
			// Integer total=IdentityCard+EnrollmentFee;
		//	 Session.save("");
			 JSPRelatedFunctionsimp JSPRelatedFunctionsimp= new JSPRelatedFunctionsimp();
			 String	responseString=	JSPRelatedFunctionsimp.GenerateChallan(total,mapChallanScannedCopy,Name , timeStamp1, Place,KARNumber,""+"","","DD Number:"+DDNumber+"  " + "DD Date:"+""+"  "+"Bank:" + BankName);
			 
			 
		  
		  
		  /*out.println("<!DOCTYPE html>"
				  +"<html>"
				  +"<head>"
				  +"<style>"

				  +".floating-box" 

				  +"{  float: left;  width: 400px;  height:100%;  margin: 10px;   border: 3px solid #73AD21; }"

				  +"</style>"
				  +"</head>"

				  +"<body>"

				  +"<div class='floating-box'><img src='ksbc_intro.jpg' alt='ksbc' class='iconDetails' align='left'/>"
				  +"<font face='verdana' size='2' color='green'>"
				  +"<b>(COUNTER FOIL)</b>"
				  +"<br></br>KARNATAKA STATE BAR COUNCIL<br></br>"
				  +"<p align='center'><i>Bangalore</i></p>"
				  +"</font>"
				  +"<p align='right'>Date:"+timeStamp1+"</p><br></br>"
				  + "<div>1. Name:"+Name+"</div><br></br>"
				  + "<div>2. Place:"+Place+"</div><br></br><div style='width:100%;height:3%;border:1px solid black'>" 
				  +"<div style='float:left;width:25%'>Sl.No.</div> <div style='float:left;width:53%'>Particulars</div>" 
				  +"<div style='float:left;width:0%'>Amount</div><br></br>  </div> <div class='ForWhatPaying'></div>"
				  +"<br></br><br></br><br></br><br></br><br></br><br></br><br></br> <br></br><br></br><br></br><br></br><br></br><br></br><br></br><br></br> Rupees:<p id='Rupees'>0</p>"
				   +"<br></br><br></br><br></br><br></br><br></br><div style='width:100%'>   <div style='float:left'>Receipt No.</div>  "
				   +"<div style='float:right'><strong>CASHIER</strong></div></div></div>"

				  +"<div class='floating-box'><img src='ksbc_intro.jpg' alt='ksbc' class='iconDetails' align='left'/>"
				  +"<font face='verdana' size='2' color='green'>"
				  +"<b>(COUNTER FOIL)</b>"
				  +"<br></br>KARNATAKA STATE BAR COUNCIL<br></br>"
				  +"<p align='center'><i>Bangalore</i></p>"
				  +"</font>"
				  +"<p align='right'>Date:"+timeStamp1+"</p><br></br>"
				  + "<div>1. Name:"+Name+"</div><br></br>"
				  + "<div>2. Place:"+Place+"</div><br></br><div style='width:100%;height:3%;border:1px solid black'>" 
				  +"<div style='float:left;width:25%'>Sl.No.</div> <div style='float:left;width:53%'>Particulars</div>" 
				  +"<div style='float:left;width:0%'>Amount</div><br></br>  </div> <div class='ForWhatPaying'></div>"
				  +"<br></br><br></br><br></br><br></br><br></br><br></br><br></br> <br></br><br></br><br></br><br></br><br></br><br></br><br></br><br></br> Rupees:<p id='Rupees'>0</p>"
				   +"<br></br><br></br><br></br><br></br><br></br><div style='width:100%'>   <div style='float:left'>Receipt No.</div>  "
				   +"<div style='float:right'><strong>CASHIER</strong></div></div></div>"
				   
				   
				  +"<div class='floating-box'><img src='ksbc_intro.jpg' alt='ksbc' class='iconDetails' align='left'/>"
				  +"<font face='verdana' size='2' color='green'>"
				  +"<b>(COUNTER FOIL)</b>"
				  +"<br></br>KARNATAKA STATE BAR COUNCIL<br></br>"
				  +"<p align='center'><i>Bangalore</i></p>"
				  +"</font>"
				  +"<p align='right'>Date:"+timeStamp1+"</p><br></br>"
				  + "<div>1. Name:"+Name+"</div><br></br>"
				  + "<div>2. Place:"+Place+"</div><br></br><div style='width:100%;height:3%;border:1px solid black'>" 
				  +"<div style='float:left;width:25%'>Sl.No.</div> <div style='float:left;width:53%'>Particulars</div>" 
				  +"<div style='float:left;width:0%'>Amount</div><br></br>  </div> <div class='ForWhatPaying'></div>"
				  +"<br></br><br></br><br></br><br></br><br></br><br></br><br></br> <br></br><br></br><br></br><br></br><br></br><br></br><br></br><br></br> Rupees:<p id='Rupees'>0</p>"
				   +"<br></br><br></br><br></br><br></br><br></br><div style='width:100%'>   <div style='float:left'>Receipt No.</div>  "
				   +"<div style='float:right'><strong>CASHIER</strong></div></div></div>"
				   
				   
				   
				   
				   
				   +"</body>"
				   +"</html>");
		  */
			 
			 out.println(responseString);
		  Session.saveOrUpdate(KAWFfeeStructure);
		  Session.close();
	}

}
