	/*package com.KSBC.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.KSBC.Bean.BCI_FDSBean;
import com.KSBC.Bean.EnrollmentNewMemberBean;
import com.KSBC.JSPRelatedFunctions.JSPRelatedFunctionsimp;
import com.KSBC.Util.HibernateUtil;

*//**
 * Servlet implementation class BCI_FDS
 *//*
@WebServlet("/BCI_FDS")
public class BCI_FDS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    *//**
     * @see HttpServlet#HttpServlet()
     *//*
    public BCI_FDS() {
        super();
        // TODO Auto-generated constructor stub
    }

	*//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	*//**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		System.out.println("*********************** Hi  **********************************");
		 response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		    Session Session = HibernateUtil.getSessionFactory().openSession();
			Transaction Tx = Session.beginTransaction();
			 LinkedHashMap<String, Integer> mapChallanScannedCopy = new LinkedHashMap<String, Integer>();
					
			System.out.println("coming");
		int BCISubscriptionLateFee = Integer.parseInt(request.getParameter("BCISubscriptionLateFee"));
		//System.out.println(EnrollmentFee);
		int FDSDiffAmt = Integer.parseInt(request.getParameter("FDSDiffAmt"));
	//	System.out.println(IdentityCar);
		int BCISubscription=Integer.parseInt(request.getParameter("BCISubscription"));
	int FDS=0;
		try
		{
			FDS=Integer.parseInt(request.getParameter("FDS"));
		}
		catch (Exception e)
		{
	//		int KAWFMembershipFee=Integer.parseInt("0");
		e.printStackTrace();		
		}

		 
		//int FDS=Integer.parseInt(FDSArray[0]);
	//	System.out.println(KsbcTrust);
		int CostReceipt=Integer.parseInt(request.getParameter("CostReceipt"));
	//	System.out.println(KawfMembershipFee);
		int BCIReimbursmentOfSalaryDeduction=Integer.parseInt(request.getParameter("BCIReimbursment"));
		//System.out.println(BciSubscriptio);
		int BCIInterestonFD=Integer.parseInt(request.getParameter("BCIInterestonFD"));
	//	System.out.println(fds);
		
		int BCIClosingFD=Integer.parseInt(request.getParameter("BCIClosingFD"));
		int FDSInterestonFD=Integer.parseInt(request.getParameter("FDSInterestonFD"));
		int FDSClosingFD=Integer.parseInt(request.getParameter("FDSClosingFD"));
	
		
		
		String Name = (String)request.getParameter("Name");
		String KARNumber = (String)request.getParameter("KARNumber");
		String BankName = (String)request.getParameter("BankName");
		String BranchName = (String)request.getParameter("BranchName");
		String Place= (String)request.getParameter("Place");
	
		String DDNumber = (String)request.getParameter("DDNumber");
		
		BCI_FDSBean bci_FDSBean=new BCI_FDSBean();
		
		bci_FDSBean.setBCIClosingFD(BCIClosingFD);
		bci_FDSBean.setBCIInterestonFD(BCIInterestonFD);
		bci_FDSBean.setBCIReimbursmentOfSalaryDeduction(BCIReimbursmentOfSalaryDeduction);
		bci_FDSBean.setBCISubscription(BCISubscription);
		bci_FDSBean.setBCISubscriptionLateFee(BCISubscriptionLateFee);
		bci_FDSBean.setCostReceipt(CostReceipt);
		bci_FDSBean.setFDS(FDS);
		bci_FDSBean.setFDSClosingFD(FDSClosingFD);
		bci_FDSBean.setFDSDiffAmt(FDSDiffAmt);
		bci_FDSBean.setFDSInterestonFD(FDSInterestonFD);
		
		
		
		String timeStamp1 = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		  if (BCIClosingFD>0)
			 {
				 mapChallanScannedCopy.put("BCIClosingFD", BCIClosingFD);
			 }
			 if (BCIInterestonFD>0)
			 {
				 mapChallanScannedCopy.put("BCIInterestonFD", BCIInterestonFD);
			 }
			 if (BCIReimbursmentOfSalaryDeduction>0)
			 {
				 mapChallanScannedCopy.put("BCIReimbursmentOfSalaryDeduction", BCIReimbursmentOfSalaryDeduction);
			 }
			 if (BCISubscription>0)
			 {
				 mapChallanScannedCopy.put("BCISubscription", BCISubscription);
			 }
			 if (BCISubscriptionLateFee>0)
			 {
				 mapChallanScannedCopy.put("BCISubscriptionLateFee", BCISubscriptionLateFee);
			 }
			 if (CostReceipt>0)
			 {
				 mapChallanScannedCopy.put("CostReceipt", CostReceipt);
			 }
			 if (FDSClosingFD>0)
			 {
				 mapChallanScannedCopy.put("FDSClosingFD", FDSClosingFD);
			 }
			 
			 if (FDS>0)
			 {
				 mapChallanScannedCopy.put("FDS", FDS);
			 }
			 
			 if (FDSDiffAmt>0)
			 {
				 mapChallanScannedCopy.put("FDSDiffAmt", FDSDiffAmt);
			 }
			 
			 if (FDSInterestonFD>0)
			 {
				 mapChallanScannedCopy.put("FDSInterestonFD", FDSInterestonFD);
			 }
			 
			 
			 
int total=BCIClosingFD+BCIInterestonFD+BCIReimbursmentOfSalaryDeduction+BCISubscription+BCISubscriptionLateFee+
CostReceipt+FDSClosingFD+FDS+FDSDiffAmt+FDSInterestonFD;
			 System.out.println("TOTAL AMOUNT::"+total);
			 JSPRelatedFunctionsimp JSPRelatedFunctionsimp= new JSPRelatedFunctionsimp();
			 String	responseString=	JSPRelatedFunctionsimp.GenerateChallan(total,mapChallanScannedCopy,Name , timeStamp1, Place);
				
			 out.println(responseString);
			//  Session.saveOrUpdate(EnrollmentNewMemberBean);
			  Session.close();
	}



}
*/


package com.KSBC.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
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

import com.KSBC.Bean.BCI_FDSBean;
import com.KSBC.Bean.CashSectionMonthlyReport;
import com.KSBC.Bean.CashSectionMonthlyReportFlow;
import com.KSBC.Bean.EnrollmentNewMemberBean;
import com.KSBC.Bean.ReceiptDeleteTable;
import com.KSBC.JSPRelatedFunctions.JSPRelatedFunctionsimp;
import com.KSBC.Util.HibernateUtil;

/**
 * Servlet implementation class BCI_FDS
 */
/*@WebServlet("/BCI_FDS")*/
public class BCI_FDS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BCI_FDS() {
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
		
		int ReceiptId=0;
		int BeanSaveId=0;
		System.out.println("*********************** Hi  **********************************");
		 response.setContentType("text/html");
		 String timeStamp1 = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		    PrintWriter out = response.getWriter();
		    Serializable Id;
		    LocalDate today = LocalDate.now();
		    
		    java.util.Date date = Date.from(today.atStartOfDay()
			        .atZone(ZoneId.systemDefault()).toInstant());
			    Timestamp timeStamp = new Timestamp(date.getTime());
			   	
			    String DDDate=request.getParameter("DDDate");	
				 System.out.println(DDDate + "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&    DD Date");
		    String category = (String)request.getParameter("category");
			
		    Session Session = HibernateUtil.getSessionFactory().openSession();
			Transaction Tx = Session.beginTransaction();
			 LinkedHashMap<String, Integer> mapChallanScannedCopy = new LinkedHashMap<String, Integer>();
					
			System.out.println("coming");
		int BCISubscriptionLateFee = Integer.parseInt(request.getParameter("BCISubscriptionLateFee"));
		//System.out.println(EnrollmentFee);
		int FDSDiffAmt = Integer.parseInt(request.getParameter("FDSDiffAmt"));
	//	System.out.println(IdentityCar);
		int BCISubscription=Integer.parseInt(request.getParameter("BCISubscription"));
	int FDS=0;
		try
		{
			FDS=Integer.parseInt(request.getParameter("FDS"));
		}
		catch (Exception e)
		{
	//		int KAWFMembershipFee=Integer.parseInt("0");
		e.printStackTrace();		
		}

		 
		//int FDS=Integer.parseInt(FDSArray[0]);
	//	System.out.println(KsbcTrust);
		int CostReceipt=Integer.parseInt(request.getParameter("CostReceipt"));
	//	System.out.println(KawfMembershipFee);
		int BCIReimbursmentOfSalaryDeduction=Integer.parseInt(request.getParameter("BCIReimbursment"));
		//System.out.println(BciSubscriptio);
		int BCIInterestonFD=Integer.parseInt(request.getParameter("BCIInterestonFD"));
	//	System.out.println(fds);
		
		int BCIClosingFD=Integer.parseInt(request.getParameter("BCIClosingFD"));
		int FDSInterestonFD=Integer.parseInt(request.getParameter("FDSInterestonFD"));
		int FDSClosingFD=Integer.parseInt(request.getParameter("FDSClosingFD"));
	
		HttpSession Servletsession = request.getSession(false);
		if (Servletsession==null)
		{
			Servletsession = request.getSession(true);
		} 
		
		String Operator= (String) Servletsession.getAttribute("UserName");
		
		System.out.println(Operator + " Operator");
		
		String Name = (String)request.getParameter("Name");
		String KARNumber = (String)request.getParameter("KARNumber");
		String BankName = (String)request.getParameter("BankName");
		String BranchName = (String)request.getParameter("BranchName");
		String Place= (String)request.getParameter("Place");
	
		String DDNumber = (String)request.getParameter("DDNumber");
		
		BCI_FDSBean bci_FDSBean=new BCI_FDSBean();
		
		bci_FDSBean.setBCIClosingFD(BCIClosingFD);
		bci_FDSBean.setBCIInterestonFD(BCIInterestonFD);
		bci_FDSBean.setBCIReimbursmentOfSalaryDeduction(BCIReimbursmentOfSalaryDeduction);
		bci_FDSBean.setBCISubscription(BCISubscription);
		bci_FDSBean.setBCISubscriptionLateFee(BCISubscriptionLateFee);
		bci_FDSBean.setCostReceipt(CostReceipt);
		bci_FDSBean.setFDS(FDS);
		bci_FDSBean.setFDSClosingFD(FDSClosingFD);
		bci_FDSBean.setFDSDiffAmt(FDSDiffAmt);
		bci_FDSBean.setFDSInterestonFD(FDSInterestonFD);
		bci_FDSBean.setChallanCreatedDate(timeStamp);
		//timeStamp
		
		
		
		
		if (BCIClosingFD>0)
			 {
			 BeanSaveId = (int) Session.save(bci_FDSBean);
				 
			  
			  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
			  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
			  CashSectionMonthlyReportFlow.setAmount(BCIClosingFD);
			  CashSectionMonthlyReportFlow.setKAWF(0);
			  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReportFlow.setBCIAWF(BCIClosingFD);
			   CashSectionMonthlyReportFlow.setEnrollNo(KARNumber + " " + Name);
			  CashSectionMonthlyReportFlow.setParticulars("BCI Closing FD");
			  
			  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);
			  }
			  else
			  {
				  CashSectionMonthlyReportFlow.setPaymode("Cash");
					 
			  }
			  
			   if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);			  }
			  else
			  {
				  CashSectionMonthlyReport.setPaymode("Cash");
					 
			  }
			 // CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEntFee(0);
			  CashSectionMonthlyReportFlow.setFDS(0);
			  CashSectionMonthlyReportFlow.setIC(0);
			  CashSectionMonthlyReportFlow.setKLA(0);
			  CashSectionMonthlyReportFlow.setMisc(0);
			  CashSectionMonthlyReportFlow.setPlace(Place);
			  CashSectionMonthlyReportFlow.setSTAMP(0);
			  System.out.println(" Persist  #####################################");
			  
			  CashSectionMonthlyReport.setAmount(BCIClosingFD);
			  CashSectionMonthlyReport.setKAWF(0);
			  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReport.setBCIAWF(BCIClosingFD);
			  CashSectionMonthlyReport.setEnrollNo(KARNumber);
			  CashSectionMonthlyReport.setParticulars("BCI Closing FD");
			//  CashSectionMonthlyReport.setPaymode("Offline");
			 // CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEntFee(0);
			  CashSectionMonthlyReport.setFDS(0);
			  CashSectionMonthlyReport.setIC(0);
			  CashSectionMonthlyReport.setKLA(0);
			  CashSectionMonthlyReport.setMisc(0);
			  CashSectionMonthlyReport.setPlace(Place);
			  CashSectionMonthlyReport.setSTAMP(0);
			  CashSectionMonthlyReport.setOperator(Operator);
			  CashSectionMonthlyReportFlow.setOperator(Operator);
			  CashSectionMonthlyReport.setOperator(Operator);
			  CashSectionMonthlyReportFlow.setOperator(Operator);
			  CashSectionMonthlyReportFlow.setName(Name);
			  CashSectionMonthlyReport.setName(Name);
			  //Tx.begin();
			  try
			  {
			Serializable Id1 = Session.save(CashSectionMonthlyReport);
			 ReceiptId=(int) Id1;
			Session.save(CashSectionMonthlyReportFlow);
			System.out.println(ReceiptId+ "   "+Id1  + "ID for Receipt");
			Session.beginTransaction().commit();;
			  }
			  catch(Exception e)
			  {
				  System.out.println("Error");
			//	  //Session.flush();
			//	  Tx.rollback();
				  e.printStackTrace();
			  }
			//  String Id=Session.save(CashSectionMonthlyReport);
		//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
	
				 mapChallanScannedCopy.put("BCI Closing FD", BCIClosingFD);
			 }
		  
		  
			 if (BCIInterestonFD>0)
			 {

				  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
				  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
				  CashSectionMonthlyReportFlow.setAmount(BCIInterestonFD);
				  CashSectionMonthlyReportFlow.setKAWF(0);
				  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReportFlow.setBCIAWF(BCIInterestonFD);
				   CashSectionMonthlyReportFlow.setEnrollNo(KARNumber + " " + Name);
				  CashSectionMonthlyReportFlow.setParticulars("BCI Interest on FD");
				 
				  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);				  }
				  else
				  {
					  CashSectionMonthlyReportFlow.setPaymode("Cash");
						 
				  }
				  
				   if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);				  }
				  else
				  {
					  CashSectionMonthlyReport.setPaymode("Cash");
						 
				  }// CashSectionMonthlyReportFlow.setBCIAWF(0);
				  CashSectionMonthlyReportFlow.setEntFee(0);
				  CashSectionMonthlyReportFlow.setFDS(0);
				  CashSectionMonthlyReportFlow.setIC(0);
				  CashSectionMonthlyReportFlow.setKLA(0);
				  CashSectionMonthlyReportFlow.setMisc(0);
				  CashSectionMonthlyReportFlow.setPlace(Place);
				  CashSectionMonthlyReportFlow.setSTAMP(0);
				  System.out.println(" Persist  #####################################");
				  
				  CashSectionMonthlyReport.setAmount(BCIInterestonFD);
				  CashSectionMonthlyReport.setKAWF(0);
				  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReport.setBCIAWF(BCIInterestonFD);
				  CashSectionMonthlyReport.setEnrollNo(KARNumber);
				  CashSectionMonthlyReport.setParticulars("BCI Interest on FD");
				 // CashSectionMonthlyReport.setPaymode("Offline");
				//  CashSectionMonthlyReport.setBCIAWF(0);
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
				Serializable Id1 = Session.save(CashSectionMonthlyReport);
				ReceiptId=(int) Id1;
				Session.save(CashSectionMonthlyReportFlow);
				System.out.println(ReceiptId+ "   "+Id1  + "ID for Receipt");
				Session.beginTransaction().commit();;
				  }
				  catch(Exception e)
				  {
					  System.out.println("Error");
					  ////Session.flush();
				//	  Tx.rollback();
					  e.printStackTrace();
				  }
				//  String Id=Session.save(CashSectionMonthlyReport);
			//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
		
				 mapChallanScannedCopy.put("BCI Interest On FD", BCIInterestonFD);
			 }
		
			 
			 if (BCIReimbursmentOfSalaryDeduction>0)
			 {			  
				 
				 BeanSaveId = (int) Session.save(bci_FDSBean);
				 CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
				  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
				  CashSectionMonthlyReportFlow.setAmount(BCIReimbursmentOfSalaryDeduction);
				  CashSectionMonthlyReportFlow.setKAWF(0);
				  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReportFlow.setBCIAWF(BCIReimbursmentOfSalaryDeduction);
				   CashSectionMonthlyReportFlow.setEnrollNo(KARNumber + " " + Name);
				  CashSectionMonthlyReportFlow.setParticulars("BCI Reimbursment Of Salary Deduction");
				  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);				  }
				  else
				  {
					  CashSectionMonthlyReportFlow.setPaymode("Cash");
						 
				  }
				  
				   if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);				  }
				  else
				  {
					  CashSectionMonthlyReport.setPaymode("Cash");
						 
				  } // CashSectionMonthlyReportFlow.setBCIAWF(0);
				  CashSectionMonthlyReportFlow.setEntFee(0);
				  CashSectionMonthlyReportFlow.setFDS(0);
				  CashSectionMonthlyReportFlow.setIC(0);
				  CashSectionMonthlyReportFlow.setKLA(0);
				  CashSectionMonthlyReportFlow.setMisc(0);
				  CashSectionMonthlyReportFlow.setPlace(Place);
				  CashSectionMonthlyReportFlow.setSTAMP(0);
				  System.out.println(" Persist  #####################################");
				  
				  CashSectionMonthlyReport.setAmount(BCIReimbursmentOfSalaryDeduction);
				  CashSectionMonthlyReport.setKAWF(0);
				  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReport.setBCIAWF(BCIReimbursmentOfSalaryDeduction);
				  CashSectionMonthlyReport.setEnrollNo(KARNumber);
				  CashSectionMonthlyReport.setParticulars("BCI Reimbursment Of Salary Deduction ");
				//  CashSectionMonthlyReport.setPaymode("Offline");
				  //CashSectionMonthlyReport.setBCIAWF(0);
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
				Serializable Id1 = Session.save(CashSectionMonthlyReport);
				ReceiptId=(int) Id1;
				Session.save(CashSectionMonthlyReportFlow);
				
				
				
			//	System.out.println(BCI_id + "  BCI insertion ID");
				System.out.println("BCI Insertion End");
				System.out.println(ReceiptId+ "   "+Id1  + "ID for Receipt");
				Session.beginTransaction().commit();;
				  }
				  catch(Exception e)
				  {
					  System.out.println("Error");
					  ////Session.flush();
				//	  Tx.rollback();
					  e.printStackTrace();
				  }
				//  String Id=Session.save(CashSectionMonthlyReport);
			//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
		
				 mapChallanScannedCopy.put("BCI Reimbursment Of Salary", BCIReimbursmentOfSalaryDeduction);
			 }
		
			 if (BCISubscription>0)
			 {		
				 
				 BeanSaveId = (int) Session.save(bci_FDSBean);
				 
				 
				  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
				  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
				  CashSectionMonthlyReportFlow.setAmount(BCISubscription);
				  CashSectionMonthlyReportFlow.setKAWF(0);
				  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReportFlow.setBCIAWF(BCISubscription);
				   CashSectionMonthlyReportFlow.setEnrollNo(KARNumber + " " + Name);
				  CashSectionMonthlyReportFlow.setParticulars("BCI Subscription");
				  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);				  }
				  else
				  {
					  CashSectionMonthlyReportFlow.setPaymode("Cash");
						 
				  }
				  
				   if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);				  }
				  else
				  {
					  CashSectionMonthlyReport.setPaymode("Cash");
						 
				  } // CashSectionMonthlyReportFlow.setBCIAWF(0);
				  CashSectionMonthlyReportFlow.setEntFee(0);
				  CashSectionMonthlyReportFlow.setFDS(0);
				  CashSectionMonthlyReportFlow.setIC(0);
				  CashSectionMonthlyReportFlow.setKLA(0);
				  CashSectionMonthlyReportFlow.setMisc(0);
				  CashSectionMonthlyReportFlow.setPlace(Place);
				  CashSectionMonthlyReportFlow.setSTAMP(0);
				  System.out.println(" Persist  #####################################");
				  
				  CashSectionMonthlyReport.setAmount(BCISubscription);
				  CashSectionMonthlyReport.setKAWF(0);
				  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReport.setBCIAWF(BCISubscription);
				  CashSectionMonthlyReport.setEnrollNo(KARNumber);
				  CashSectionMonthlyReport.setParticulars("BCI Subscription");
			//	  CashSectionMonthlyReport.setPaymode("Offline");
				//  CashSectionMonthlyReport.setBCIAWF(0);
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
				Serializable Id1 = Session.save(CashSectionMonthlyReport);
				ReceiptId=(int) Id1;
				Session.save(CashSectionMonthlyReportFlow);
				System.out.println(ReceiptId+ "   "+Id1  + "ID for Receipt");
				Session.beginTransaction().commit();;
				  }
				  catch(Exception e)
				  {
					  System.out.println("Error");
					  ////Session.flush();
				//	  Tx.rollback();
					  e.printStackTrace();
				  }
				//  String Id=Session.save(CashSectionMonthlyReport);
			//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
		
				 mapChallanScannedCopy.put("BCI Subscription", BCISubscription);
			 }
		
			 if (BCISubscriptionLateFee>0)
			 {	
				 
				 BeanSaveId = (int) Session.save(bci_FDSBean);
				 
				  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
				  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
				  CashSectionMonthlyReportFlow.setAmount(BCISubscriptionLateFee);
				  CashSectionMonthlyReportFlow.setKAWF(0);
				  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReportFlow.setBCIAWF(BCISubscriptionLateFee);
				   CashSectionMonthlyReportFlow.setEnrollNo(KARNumber + " " + Name);
				  CashSectionMonthlyReportFlow.setParticulars("BCI Subscription Late Fee");
				  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);				  }
				  else
				  {
					  CashSectionMonthlyReportFlow.setPaymode("Cash");
						 
				  }
				  
				   if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);				  }
				  else
				  {
					  CashSectionMonthlyReport.setPaymode("Cash");
						 
				  }	 // CashSectionMonthlyReportFlow.setBCIAWF(0);
				  CashSectionMonthlyReportFlow.setEntFee(0);
				  CashSectionMonthlyReportFlow.setFDS(0);
				  CashSectionMonthlyReportFlow.setIC(0);
				  CashSectionMonthlyReportFlow.setKLA(0);
				  CashSectionMonthlyReportFlow.setMisc(0);
				  CashSectionMonthlyReportFlow.setPlace(Place);
				  CashSectionMonthlyReportFlow.setSTAMP(0);
				  System.out.println(" Persist  #####################################");
				  
				  CashSectionMonthlyReport.setAmount(BCISubscriptionLateFee);
				  CashSectionMonthlyReport.setKAWF(0);
				  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReport.setBCIAWF(BCISubscriptionLateFee);
				  CashSectionMonthlyReport.setEnrollNo(KARNumber);
				  CashSectionMonthlyReport.setParticulars("BCI Subscription Late Fee");
				//  CashSectionMonthlyReport.setPaymode("Offline");
				//  CashSectionMonthlyReport.setBCIAWF(0);
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
				Serializable Id1 = Session.save(CashSectionMonthlyReport);
				ReceiptId=(int) Id1;
				Session.save(CashSectionMonthlyReportFlow);
				System.out.println(ReceiptId+ "   "+Id1  + "ID for Receipt");
				Session.beginTransaction().commit();;
				  }
				  catch(Exception e)
				  {
					  System.out.println("Error");
					  ////Session.flush();
				//	  Tx.rollback();
					  e.printStackTrace();
				  }
				//  String Id=Session.save(CashSectionMonthlyReport);
			//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
		
				 mapChallanScannedCopy.put("BCI Subscription Late Fee", BCISubscriptionLateFee);
			 }
		
			 if (CostReceipt>0)
			 {		
				 
				 BeanSaveId = (int) Session.save(bci_FDSBean);
				  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
				  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
				  CashSectionMonthlyReportFlow.setAmount(CostReceipt);
				  CashSectionMonthlyReportFlow.setKAWF(0);
				  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReportFlow.setBCIAWF(CostReceipt);
				   CashSectionMonthlyReportFlow.setEnrollNo(KARNumber + " " + Name);
				  CashSectionMonthlyReportFlow.setParticulars("Cost Receipt");
				  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber);
				  }
				  else
				  {
					  CashSectionMonthlyReportFlow.setPaymode("Cash");
						 
				  }
				  
				   if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);				  }
				  else
				  {
					  CashSectionMonthlyReport.setPaymode("Cash");
						 
				  } // CashSectionMonthlyReportFlow.setBCIAWF(0);
				  CashSectionMonthlyReportFlow.setEntFee(0);
				  CashSectionMonthlyReportFlow.setFDS(0);
				  CashSectionMonthlyReportFlow.setIC(0);
				  CashSectionMonthlyReportFlow.setKLA(0);
				  CashSectionMonthlyReportFlow.setMisc(0);
				  CashSectionMonthlyReportFlow.setPlace(Place);
				  CashSectionMonthlyReportFlow.setSTAMP(0);
				  System.out.println(" Persist  #####################################");
				  
				  CashSectionMonthlyReport.setAmount(CostReceipt);
				  CashSectionMonthlyReport.setKAWF(0);
				  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReport.setBCIAWF(CostReceipt);
				  CashSectionMonthlyReport.setEnrollNo(KARNumber);
				  CashSectionMonthlyReport.setParticulars("Cost Receipt");
				//  CashSectionMonthlyReport.setPaymode("Offline");
				//  CashSectionMonthlyReport.setBCIAWF(0);
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
				Serializable Id1 = Session.save(CashSectionMonthlyReport);
				ReceiptId=(int) Id1;
				Session.save(CashSectionMonthlyReportFlow);
				System.out.println(ReceiptId+ "   "+Id1  + "ID for Receipt");
				Session.beginTransaction().commit();;
				  }
				  catch(Exception e)
				  {
					  System.out.println("Error");
					  ////Session.flush();
				//	  Tx.rollback();
					  e.printStackTrace();
				  }
				//  String Id=Session.save(CashSectionMonthlyReport);
			//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
		
				 mapChallanScannedCopy.put("Cost Receipt", CostReceipt);
			 }
		
			 if (FDSClosingFD>0)
			 {		
				 
				 BeanSaveId = (int) Session.save(bci_FDSBean);
				  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
				  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
				  CashSectionMonthlyReportFlow.setAmount(FDSClosingFD);
				  CashSectionMonthlyReportFlow.setKAWF(0);
				  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReportFlow.setBCIAWF(0);
				   CashSectionMonthlyReportFlow.setEnrollNo(KARNumber + " " + Name);
				  CashSectionMonthlyReportFlow.setParticulars("FDS Closing FD");
				  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);				  }
				  else
				  {
					  CashSectionMonthlyReportFlow.setPaymode("Cash");
						 
				  }
				  
				   if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);				  }
				  else
				  {
					  CashSectionMonthlyReport.setPaymode("Cash");
						 
				  } // CashSectionMonthlyReportFlow.setBCIAWF(0);
				  CashSectionMonthlyReportFlow.setEntFee(0);
				  CashSectionMonthlyReportFlow.setFDS(FDSClosingFD);
				  CashSectionMonthlyReportFlow.setIC(0);
				  CashSectionMonthlyReportFlow.setKLA(0);
				  CashSectionMonthlyReportFlow.setMisc(0);
				  CashSectionMonthlyReportFlow.setPlace(Place);
				  CashSectionMonthlyReportFlow.setSTAMP(0);
				  System.out.println(" Persist  #####################################");
				  
				  CashSectionMonthlyReport.setAmount(FDSClosingFD);
				  CashSectionMonthlyReport.setKAWF(0);
				  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
				//  CashSectionMonthlyReport.setBCIAWF(0);
				  CashSectionMonthlyReport.setEnrollNo(KARNumber);
				  CashSectionMonthlyReport.setParticulars("FDS Closing FD");
				//  CashSectionMonthlyReport.setPaymode("Offline");
				  CashSectionMonthlyReport.setBCIAWF(0);
				  CashSectionMonthlyReport.setEntFee(0);
				  CashSectionMonthlyReport.setFDS(FDSClosingFD);
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
				Serializable Id1 = Session.save(CashSectionMonthlyReport);
				ReceiptId=(int) Id1;
				Session.save(CashSectionMonthlyReportFlow);
				System.out.println(ReceiptId+ "   "+Id1  + "ID for Receipt");
				Session.beginTransaction().commit();;
				  }
				  catch(Exception e)
				  {
					  System.out.println("Error");
					  ////Session.flush();
				//	  Tx.rollback();
					  e.printStackTrace();
				  }
				//  String Id=Session.save(CashSectionMonthlyReport);
			//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
		
				 mapChallanScannedCopy.put("FDS Closing FD", FDSClosingFD);
			 }
			 
		
			 if (FDS>0)
			 {			  
				  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
				  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
				  CashSectionMonthlyReportFlow.setAmount(FDS);
				  CashSectionMonthlyReportFlow.setKAWF(0);
				  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReportFlow.setBCIAWF(0);
				   CashSectionMonthlyReportFlow.setEnrollNo(KARNumber + " " + Name);
				  CashSectionMonthlyReportFlow.setParticulars("FDS");
				  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);				  }
				  else
				  {
					  CashSectionMonthlyReportFlow.setPaymode("Cash");
						 
				  }
				  
				   if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);				  }
				  else
				  {
					  CashSectionMonthlyReport.setPaymode("Cash");
						 
				  }	 // CashSectionMonthlyReportFlow.setBCIAWF(0);
				  CashSectionMonthlyReportFlow.setEntFee(0);
				  CashSectionMonthlyReportFlow.setFDS(FDS);
				  CashSectionMonthlyReportFlow.setIC(0);
				  CashSectionMonthlyReportFlow.setKLA(0);
				  CashSectionMonthlyReportFlow.setMisc(0);
				  CashSectionMonthlyReportFlow.setPlace(Place);
				  CashSectionMonthlyReportFlow.setSTAMP(0);
				  System.out.println(" Persist  #####################################");
				  
				  CashSectionMonthlyReport.setAmount(FDS);
				  CashSectionMonthlyReport.setKAWF(0);
				  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReport.setBCIAWF(0);
				  CashSectionMonthlyReport.setEnrollNo(KARNumber);
				  CashSectionMonthlyReport.setParticulars("FDS");
				//  CashSectionMonthlyReport.setPaymode("Offline");
				  CashSectionMonthlyReport.setBCIAWF(0);
				  CashSectionMonthlyReport.setEntFee(0);
				  CashSectionMonthlyReport.setFDS(FDS);
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
				Serializable Id1 = Session.save(CashSectionMonthlyReport);
				ReceiptId=(int) Id1;
				Session.save(CashSectionMonthlyReportFlow);
				 System.out.println("************* BCI Insertion start  ************************");
					BeanSaveId = (int) Session.save(bci_FDSBean);
				System.out.println(ReceiptId+ "   "+Id1  + "ID for Receipt");
				Session.beginTransaction().commit();;
				  }
				  catch(Exception e)
				  {
					  System.out.println("Error");
					//  ////Session.flush();
				//	  Tx.rollback();
					  e.printStackTrace();
				  }
				//  String Id=Session.save(CashSectionMonthlyReport);
			//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
		
				 mapChallanScannedCopy.put("FDS", FDS);
			 }
			 
			 if (FDSDiffAmt>0)
			 {

				 BeanSaveId = (int) Session.save(bci_FDSBean);
				  
				  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
				  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
				  CashSectionMonthlyReportFlow.setAmount(FDSDiffAmt);
				  CashSectionMonthlyReportFlow.setKAWF(0);
				  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReportFlow.setBCIAWF(0);
				   CashSectionMonthlyReportFlow.setEnrollNo(KARNumber + " " + Name);
				  CashSectionMonthlyReportFlow.setParticulars("FDS Diff Amt");
				  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);				  }
				  else
				  {
					  CashSectionMonthlyReportFlow.setPaymode("Cash");
						 
				  }
				  
				   if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);				  }
				  else
				  {
					  CashSectionMonthlyReport.setPaymode("Cash");
						 
				  }  CashSectionMonthlyReportFlow.setBCIAWF(0);
				  CashSectionMonthlyReportFlow.setEntFee(0);
				  CashSectionMonthlyReportFlow.setFDS(FDSDiffAmt);
				  CashSectionMonthlyReportFlow.setIC(0);
				  CashSectionMonthlyReportFlow.setKLA(0);
				  CashSectionMonthlyReportFlow.setMisc(0);
				  CashSectionMonthlyReportFlow.setPlace(Place);
				  CashSectionMonthlyReportFlow.setSTAMP(0);
				  System.out.println(" Persist  #####################################");
				  
				  CashSectionMonthlyReport.setAmount(FDSDiffAmt);
				  CashSectionMonthlyReport.setKAWF(0);
				  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReport.setBCIAWF(0);
				  CashSectionMonthlyReport.setEnrollNo(KARNumber);
				  CashSectionMonthlyReport.setParticulars("FDS Diff Amt");
				//  CashSectionMonthlyReport.setPaymode("Offline");
				  CashSectionMonthlyReport.setBCIAWF(0);
				  CashSectionMonthlyReport.setEntFee(0);
				  CashSectionMonthlyReport.setFDS(FDSDiffAmt);
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
				Serializable Id1 = Session.save(CashSectionMonthlyReport);
				ReceiptId=(int) Id1;
				Session.save(CashSectionMonthlyReportFlow);
				System.out.println(ReceiptId+ "   "+Id1  + "ID for Receipt");
				Session.beginTransaction().commit();;
				  }
				  catch(Exception e)
				  {
					  System.out.println("Error");
					  ////Session.flush();
				//	  Tx.rollback();
					  e.printStackTrace();
				  }
				//  String Id=Session.save(CashSectionMonthlyReport);
			//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
		
				 mapChallanScannedCopy.put("FDS Diff. Amt.", FDSDiffAmt);
			 }
			 
			 if (FDSInterestonFD>0)
			 {

				 BeanSaveId = (int) Session.save(bci_FDSBean);
				  
				  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
				  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
				  CashSectionMonthlyReportFlow.setAmount(FDSInterestonFD);
				  CashSectionMonthlyReportFlow.setKAWF(0);
				  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReportFlow.setBCIAWF(0);
				   CashSectionMonthlyReportFlow.setEnrollNo(KARNumber + " " + Name);
				  CashSectionMonthlyReportFlow.setParticulars("FDS Interest on FD");
				  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);				  }
				  else
				  {
					  CashSectionMonthlyReportFlow.setPaymode("Cash");
						 
				  }
				  
				   if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);				  }
				  else
				  {
					  CashSectionMonthlyReport.setPaymode("Cash");
						 
				  }  CashSectionMonthlyReportFlow.setBCIAWF(0);
				  CashSectionMonthlyReportFlow.setEntFee(0);
				  CashSectionMonthlyReportFlow.setFDS(FDSInterestonFD);
				  CashSectionMonthlyReportFlow.setIC(0);
				  CashSectionMonthlyReportFlow.setKLA(0);
				  CashSectionMonthlyReportFlow.setMisc(0);
				  CashSectionMonthlyReportFlow.setPlace(Place);
				  CashSectionMonthlyReportFlow.setSTAMP(0);
				  System.out.println(" Persist  #####################################");
				  
				  CashSectionMonthlyReport.setAmount(FDSInterestonFD);
				  CashSectionMonthlyReport.setKAWF(0);
				  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReport.setBCIAWF(0);
				  CashSectionMonthlyReport.setEnrollNo(KARNumber);
				  CashSectionMonthlyReport.setParticulars("FDS Interest on FD");
				//  CashSectionMonthlyReport.setPaymode("Offline");
				  CashSectionMonthlyReport.setBCIAWF(0);
				  CashSectionMonthlyReport.setEntFee(0);
				  CashSectionMonthlyReport.setFDS(FDSInterestonFD);
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
				Serializable Id1 = Session.save(CashSectionMonthlyReport);
				ReceiptId=(int) Id1;
				Session.save(CashSectionMonthlyReportFlow);
				System.out.println(ReceiptId+ "   "+Id1  + "ID for Receipt");
				Session.beginTransaction().commit();;
				  }
				  catch(Exception e)
				  {
					  System.out.println("Error");
					  //////Session.flush();
				//	  Tx.rollback();
					  e.printStackTrace();
				  }
				//  String Id=Session.save(CashSectionMonthlyReport);
			//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
		
				 mapChallanScannedCopy.put("FDS Interest On FD", FDSInterestonFD);
			 }
			 
			 
			 
int total=BCIClosingFD+BCIInterestonFD+BCIReimbursmentOfSalaryDeduction+BCISubscription+BCISubscriptionLateFee+
CostReceipt+FDSClosingFD+FDS+FDSDiffAmt+FDSInterestonFD;
			 System.out.println("TOTAL AMOUNT::"+total);
			 try
			 {
				ReceiptDeleteTable ReceiptDeleteTable= new ReceiptDeleteTable();
				ReceiptDeleteTable.setChallanGenerateSLNumber(ReceiptId);
				ReceiptDeleteTable.setOperator(Operator);
				ReceiptDeleteTable.setMonthlyReportSLNumber(BeanSaveId);
				ReceiptDeleteTable.setTimeWhenDeleted(today);
				ReceiptDeleteTable.setType("BCI");
				Session.save(ReceiptDeleteTable);
				Session.beginTransaction().commit();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		
	}
			 finally
			 {
				 Session.close();
			 }
			 JSPRelatedFunctionsimp JSPRelatedFunctionsimp= new JSPRelatedFunctionsimp();
			 String	responseString=	JSPRelatedFunctionsimp.GenerateChallan(total,mapChallanScannedCopy,Name , timeStamp1, Place,KARNumber,ReceiptId+"",category,"DD Number:"+DDNumber+"  " + "DD Date:"+DDDate+"  "+"Bank:" + BankName+"  " + "Branch:" +BranchName);
			 
			 out.println(responseString);
			//  Session.saveOrUpdate(EnrollmentNewMemberBean);
			  Session.close();
	}



}

