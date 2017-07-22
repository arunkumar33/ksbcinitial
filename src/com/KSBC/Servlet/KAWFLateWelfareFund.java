package com.KSBC.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
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
import com.KSBC.Bean.KAWFLateWelfareFundBean;
import com.KSBC.Bean.ReceiptDeleteTable;
import com.KSBC.JSPRelatedFunctions.JSPRelatedFunctionsimp;
import com.KSBC.Util.HibernateUtil;

/**
 * Servlet implementation class KAWFLateWelfareFund
 */
/*@WebServlet("/KAWFLateWelfareFund")*/
public class KAWFLateWelfareFund extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KAWFLateWelfareFund() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("*********************** arun Hi  **********************************");
		 response.setContentType("text/html");
			int ReceiptId=0;
			int BeanSaveId=0;
		    PrintWriter out = response.getWriter();
		    Session Session = HibernateUtil.getSessionFactory().openSession();
		//	Transaction Tx = Session.beginTransaction();
			 LinkedHashMap<String, Integer> mapChallanScannedCopy = new LinkedHashMap<String, Integer>();
			 LocalDate today = LocalDate.now();
		//	 LocalDate LocalDate = LocalDate.now();
		int WFLateFee=Integer.parseInt(request.getParameter("WFLateFee"));
		System.out.println(WFLateFee);
		int KAWFMembershipFee=0;
		System.out.println(request.getParameter("KAWFfee") +  "Jaggggggggg ");
		try
		{
		 KAWFMembershipFee=Integer.parseInt(request.getParameter("KAWFfee"));
		}
		catch (Exception e)
		{
		e.printStackTrace();		
		}
	//	System.out.println(WFLateFeeArray + "  String ");
		/*

		int KAWFMembershipFee=0;
		if ((WFLateFeeArray==null) || (WFLateFeeArray.length==0))
		{
			KAWFMembershipFee =0;
			System.out.println(KAWFMembershipFee + "   if");
				
		}
		else
		{
			System.out.println();
			KAWFMembershipFee =Integer.parseInt(request.getParameter(WFLateFeeArray[0]));
			System.out.println(KAWFMembershipFee + "   Else");
			System.out.println("##################################### b ^^^^^^^^^^^");
		}
		 */
		 System.out.println(KAWFMembershipFee);
		
		String Name = (String)request.getParameter("Name");
		String KARNumber = (String)request.getParameter("KARNumber");
		String BankName = (String)request.getParameter("BankName");
		String BranchName = (String)request.getParameter("BranchName");
		String Place= (String)request.getParameter("Place");
		//int Amount = Integer.parseInt(request.getParameter("Amount"));
	String category = (String)request.getParameter("category");
	
	System.out.println("category  " + category);
		String DDNumber = (String)request.getParameter("DDNumber");
		 String DDDate=request.getParameter("DDDate");	
		 System.out.println(DDDate + "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&    DD Date");	
		 LocalDate today1 = LocalDate.now();
		 HttpSession Servletsession = request.getSession(false);
			if (Servletsession==null)
			{
				Servletsession = request.getSession(true);
			} 
			
			String Operator= (String) Servletsession.getAttribute("UserName");
			
			System.out.println(Operator + " Operator");
			
			
		 
		 java.util.Date date = Date.from(today1.atStartOfDay()
			        .atZone(ZoneId.systemDefault()).toInstant());
			    Timestamp timeStamp = new Timestamp(date.getTime());
		KAWFLateWelfareFundBean kawfLateWelfareFundBean=new KAWFLateWelfareFundBean();
		kawfLateWelfareFundBean.setKAWFMembershipFee(KAWFMembershipFee);
		kawfLateWelfareFundBean.setWFMembershipLateFee(WFLateFee);
		
		 Integer total=WFLateFee+KAWFMembershipFee;
			System.out.println("TOTAL AMOUNT::"+total);
		
		String timeStamp1 = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		
		kawfLateWelfareFundBean.setChallanCreatedDate(timeStamp);
		  if (KAWFMembershipFee>0)
			 {
			  BeanSaveId = (int)  Session.save(kawfLateWelfareFundBean);
			
			
			 CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
			  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
			  CashSectionMonthlyReportFlow.setAmount(KAWFMembershipFee);
			  CashSectionMonthlyReportFlow.setKAWF(KAWFMembershipFee);
			  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
			  CashSectionMonthlyReportFlow.setParticulars("KAWF Membership Fee");
			  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				 CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);
			  }
			  else
			  {
				  CashSectionMonthlyReportFlow.setPaymode("Cash");
					 
			  }
		//	  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEntFee(0);
			  CashSectionMonthlyReportFlow.setFDS(0);
			  CashSectionMonthlyReportFlow.setIC(0);
			  CashSectionMonthlyReportFlow.setKLA(0);
			  CashSectionMonthlyReportFlow.setMisc(0);
			  CashSectionMonthlyReportFlow.setPlace(Place);
			  CashSectionMonthlyReportFlow.setSTAMP(0);
			  System.out.println(" Membeship Persist  #####################################");
			  
			  CashSectionMonthlyReport.setAmount(KAWFMembershipFee);
			  CashSectionMonthlyReport.setKAWF(KAWFMembershipFee);
			  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEnrollNo(KARNumber);
			  CashSectionMonthlyReport.setParticulars("KAWF Membership Fee");
			  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);			  }
			  else
			  {
				  CashSectionMonthlyReport.setPaymode("Cash");
					 
			  }
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEntFee(0);
			  CashSectionMonthlyReport.setFDS(0);
			  CashSectionMonthlyReport.setIC(0);
			  CashSectionMonthlyReport.setKLA(0);
			  CashSectionMonthlyReport.setMisc(0);
			  CashSectionMonthlyReport.setPlace(Place);
			  CashSectionMonthlyReport.setSTAMP(0);
			  CashSectionMonthlyReport.setOperator(Operator);
			  CashSectionMonthlyReportFlow.setOperator(Operator); 
			  CashSectionMonthlyReportFlow.setName(Name);
			  CashSectionMonthlyReport.setName(Name); 
			  
			  
			  //Tx.begin();
			  try
			  {
				  JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
				  String Result = JSPRelatedFunctionsimp.UpdateToWelfareMemberShip(KARNumber);
			System.out.println(Result);	  
			Serializable Id = Session.save(CashSectionMonthlyReport);
			 ReceiptId=(int) Id;
			Session.save(CashSectionMonthlyReportFlow);
			System.out.println(ReceiptId+ "   "+Id  + "ID for Receipt");
		//	  Tx.commit();
			  }
			  catch(Exception e)
			  {
				  System.out.println("Error");
				  //Session.flush();
		//		  Tx.rollback();
				  e.printStackTrace();
			  }
			//  Session.saveOrUpdate(CashSectionMonthlyReportFlow);
		//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
				 mapChallanScannedCopy.put("KAWF Membership Fee", KAWFMembershipFee);
			 }
		  if (WFLateFee>0)
			 {
			  BeanSaveId = (int)   Session.save(kawfLateWelfareFundBean);
			  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
			  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
			  CashSectionMonthlyReportFlow.setAmount(WFLateFee);
			  CashSectionMonthlyReportFlow.setKAWF(WFLateFee);
			  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
			  CashSectionMonthlyReportFlow.setParticulars("KAWF Membership Fee");
			  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate+"\n"+"DD Date:"+DDDate); 
			  }
			  else
			  {
				  CashSectionMonthlyReportFlow.setPaymode("Cash");
					 
			  }
			  
			   if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\t"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);
			  }
			  else
			  {
				  CashSectionMonthlyReport.setPaymode("Cash");
					 
			  }
			  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEntFee(0);
			  CashSectionMonthlyReportFlow.setFDS(0);
			  CashSectionMonthlyReportFlow.setIC(0);
			  CashSectionMonthlyReportFlow.setKLA(0);
			  CashSectionMonthlyReportFlow.setMisc(0);
			  CashSectionMonthlyReportFlow.setPlace(Place);
			  CashSectionMonthlyReportFlow.setSTAMP(0);
			  System.out.println(" Persist  #####################################");
			  
			  CashSectionMonthlyReport.setAmount(WFLateFee);
			  CashSectionMonthlyReport.setKAWF(WFLateFee);
			  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEnrollNo(KARNumber);
			  CashSectionMonthlyReport.setParticulars("KAWF Late Fee");
			  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate+"\n"+"DD Date:"+DDDate); 
			  }
			  else
			  {
				  CashSectionMonthlyReportFlow.setPaymode("Cash");
					 
			  }
			  
			   if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\t"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);
			  }
			  else
			  {
				  CashSectionMonthlyReport.setPaymode("Cash");
					 
			  }
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEntFee(0);
			  CashSectionMonthlyReport.setFDS(0);
			  CashSectionMonthlyReport.setIC(0);
			  CashSectionMonthlyReport.setKLA(0);
			  CashSectionMonthlyReport.setMisc(0);
			  CashSectionMonthlyReport.setPlace(Place);
			  CashSectionMonthlyReport.setSTAMP(0);
			  CashSectionMonthlyReport.setOperator(Operator);
			  CashSectionMonthlyReportFlow.setOperator(Operator);  
			  CashSectionMonthlyReportFlow.setName(Name);
			  CashSectionMonthlyReport.setName(Name); 
			  
			  
			  //Tx.begin();
			  try
			  {
			Serializable Id = Session.save(CashSectionMonthlyReport);
			 ReceiptId=(int) Id;
			Session.save(CashSectionMonthlyReportFlow);
			System.out.println(ReceiptId+ "   "+Id  + "ID for Receipt");
			Session.beginTransaction().commit();
			  }
			  catch(Exception e)
			  {
				  System.out.println("Error");
				  //Session.flush();
			//	  Tx.rollback();
				  e.printStackTrace();
			  }
			//  String Id=Session.save(CashSectionMonthlyReport);
		//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
				 mapChallanScannedCopy.put("WelfareFund Membership LateFee", WFLateFee);
			 }
	//		Session.beginTransaction().commit();
			try
			{
			ReceiptDeleteTable ReceiptDeleteTable= new ReceiptDeleteTable();
			ReceiptDeleteTable.setChallanGenerateSLNumber(ReceiptId);
			ReceiptDeleteTable.setOperator(Operator);
			ReceiptDeleteTable.setMonthlyReportSLNumber(BeanSaveId);
			ReceiptDeleteTable.setTimeWhenDeleted(today);
			ReceiptDeleteTable.setType("KAWFLateFee");
			
			System.out.println(ReceiptDeleteTable.getDeleteNumber());
			Session.save(ReceiptDeleteTable);
			Session.beginTransaction().commit();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		
	}
		
			 finally
			 {
				// Session.close();
			 }
			JSPRelatedFunctionsimp JSPRelatedFunctionsimp= new JSPRelatedFunctionsimp();
			 String	responseString=	JSPRelatedFunctionsimp.GenerateChallan(total,mapChallanScannedCopy,Name , timeStamp1, Place,KARNumber,ReceiptId+"",category,"DD Number:"+DDNumber+"  " + "DD Date:"+DDDate+"  "+"Bank:" + BankName+"  " + "Branch:" +BranchName);
			 Session.beginTransaction().commit(); 
			 Session.close();
			 out.println(responseString);
			//  Session.saveOrUpdate(EnrollmentNewMemberBean);
			  
	}

}