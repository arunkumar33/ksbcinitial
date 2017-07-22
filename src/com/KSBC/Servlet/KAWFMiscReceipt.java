/*package com.KSBC.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.KSBC.Bean.CashSectionMonthlyReport;
import com.KSBC.Bean.CashSectionMonthlyReportFlow;
import com.KSBC.Bean.EnrollmentNewMemberBean;
import com.KSBC.Bean.KAWFMiscReceiptBean;
import com.KSBC.JSPRelatedFunctions.JSPRelatedFunctionsimp;
import com.KSBC.Util.HibernateUtil;

*//**
 * Servlet implementation class KAWFMiscReceipt
 *//*
@WebServlet("/KAWFMiscReceipt")
public class KAWFMiscReceipt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    *//**
     * @see HttpServlet#HttpServlet()
     *//*
    public KAWFMiscReceipt() {
        super();
        // TODO Auto-generated constructor stub
    }

	*//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *//*
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("*********************** Hi  **********************************");
		 response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		    Serializable Id;
		    LocalDate today = LocalDate.now();
		    Session Session = HibernateUtil.getSessionFactory().openSession();
			Transaction Tx = Session.beginTransaction();
			 LinkedHashMap<String, Integer> mapChallanScannedCopy = new LinkedHashMap<String, Integer>();
			 
			 
			 
			 			
			System.out.println("coming");
		int KawfSubscription = Integer.parseInt(request.getParameter("KawfSubscription"));
		//System.out.println(EnrollmentFee);
	//	int SeniorAdvocateContribution = Integer.parseInt(request.getParameter("SeniorAdvocateContribution"));
		//System.out.println(IdentityCar);
	//	int ChangeofNominee=Integer.parseInt(request.getParameter("ChangeofNominee"));
		int SeniorAdvocateContribution=0;
		try{
 SeniorAdvocateContribution = Integer.parseInt(request.getParameter("SeniorAdvocateContribution"));
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
		System.out.println(SeniorAdvocateContribution);
		


		

		int ChangeofNominee=0;
					
		try{
			ChangeofNominee =Integer.parseInt(request.getParameter("ChangeofNominee"));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		//System.out.println(miscRts);
	//	int DuplicateCertificate=Integer.parseInt(request.getParameter("DuplicateCertificate"));
		
		
				int DuplicateCertificate=0;
	try{
			DuplicateCertificate =Integer.parseInt(request.getParameter("DuplicateCertificate"));
			
		}
	catch(Exception e){
		e.printStackTrace();
	}
		
		
		
		
		
		
		
		//System.out.println(KsbcTrust);
		int WelfareFundCostReceipts=Integer.parseInt(request.getParameter("wfCost"));
		//System.out.println(KawfMembershipFee);
		int donation=Integer.parseInt(request.getParameter("donation"));
		//System.out.println(BciSubscriptio);
		int subscriptionLateFee=Integer.parseInt(request.getParameter("subscriptionFee"));
		//System.out.println(fds);
		
		
		int seniorAdvocateLateFee=Integer.parseInt(request.getParameter("seniorAdvFee"));
		
String[] seniorAdvFeeArray = request.getParameterValues("seniorAdvFee");
		
		System.out.println(seniorAdvFeeArray + "  String ");
		

		int seniorAdvocateLateFee=0;
		if ((seniorAdvFeeArray==null) || (seniorAdvFeeArray.length==0))
		{
			seniorAdvocateLateFee =0;
				
		}
		else
		{
			
			System.out.println(request.getParameter(seniorAdvFeeArray[0]));
			seniorAdvocateLateFee =Integer.parseInt(request.getParameter(seniorAdvFeeArray[0]));
			System.out.println("##################################### b ^^^^^^^^^^^");
		}
		
		
		int WFReimbursmentOfsalaryDeduction=Integer.parseInt(request.getParameter("WFsalDeduction"));
		int WelfareFundInterestOnFD=Integer.parseInt(request.getParameter("InterestFD"));
		int WelfareFundClosingFD=Integer.parseInt(request.getParameter("closingFD"));
		int SaleofStampAmount=Integer.parseInt(request.getParameter("stamp"));
	//	int LifeMembershipFee=Integer.parseInt(request.getParameter("LifeMembershipFee"));
		
		

		

		int LifeMembershipFee=0;
		try
		{
			LifeMembershipFee=Integer.parseInt(request.getParameter("LifeMembershipFee"));
		}
		catch (Exception e)
		{
		e.printStackTrace();		
		}
		
		int Govtgrant=Integer.parseInt(request.getParameter("grant"));
		int Miscellaneous=Integer.parseInt(request.getParameter("misc"));
		
		
		
		String Name = (String)request.getParameter("Name");
		String KARNumber = (String)request.getParameter("KARNumber");
		String BankName = (String)request.getParameter("BankName");
		String BranchName = (String)request.getParameter("BranchName");
		String Place= (String)request.getParameter("Place");
	//	int Amount = Integer.parseInt(request.getParameter("Amount"));
	
		String DDNumber = (String)request.getParameter("DDNumber");
		
	KAWFMiscReceiptBean kawfMiscReceiptBean=new KAWFMiscReceiptBean();
	
	kawfMiscReceiptBean.setChangeofNominee(ChangeofNominee);
	kawfMiscReceiptBean.setDonation(donation);
	kawfMiscReceiptBean.setDuplicateCertificate(DuplicateCertificate);
	kawfMiscReceiptBean.setGovtgrant(Govtgrant);
	kawfMiscReceiptBean.setKawfSubscription(KawfSubscription);
	kawfMiscReceiptBean.setLifeMembershipFee(LifeMembershipFee);
	kawfMiscReceiptBean.setMiscellaneous(Miscellaneous);
	kawfMiscReceiptBean.setSaleofStampAmount(SaleofStampAmount);
	kawfMiscReceiptBean.setSeniorAdvocateContribution(SeniorAdvocateContribution);
	kawfMiscReceiptBean.setSeniorAdvocateLateFee(seniorAdvocateLateFee);
	kawfMiscReceiptBean.setSubscriptionLateFee(subscriptionLateFee);
	kawfMiscReceiptBean.setWelfareFundClosingFD(WelfareFundClosingFD);
	kawfMiscReceiptBean.setWelfareFundCostReceipts(WelfareFundCostReceipts);
	kawfMiscReceiptBean.setWelfareFundInterestOnFD(WelfareFundInterestOnFD);
	kawfMiscReceiptBean.setWFReimbursmentOfsalaryDeduction(WFReimbursmentOfsalaryDeduction);
	
		
		String timeStamp1 = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		  if (ChangeofNominee>0)
			 {
			  
			  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
			  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
			  CashSectionMonthlyReportFlow.setAmount(ChangeofNominee);
			  CashSectionMonthlyReportFlow.setKAWF(ChangeofNominee);
			  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReportFlow.setBCIAWF(0);
			   CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
			  CashSectionMonthlyReportFlow.setParticulars("Change of Nominee Fee");
			  CashSectionMonthlyReportFlow.setPaymode("Offline");
			  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEntFee(0);
			  CashSectionMonthlyReportFlow.setFDS(0);
			  CashSectionMonthlyReportFlow.setIC(0);
			  CashSectionMonthlyReportFlow.setKLA(0);
			  CashSectionMonthlyReportFlow.setMisc(0);
			  CashSectionMonthlyReportFlow.setPlace(Place);
			  CashSectionMonthlyReportFlow.setSTAMP(0);
			  System.out.println(" Persist  #####################################");
			  
			  CashSectionMonthlyReport.setAmount(ChangeofNominee);
			  CashSectionMonthlyReport.setKAWF(ChangeofNominee);
			  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEnrollNo(KARNumber);
			  CashSectionMonthlyReport.setParticulars("Change of Nominee Fee");
			  CashSectionMonthlyReport.setPaymode("Offline");
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEntFee(0);
			  CashSectionMonthlyReport.setFDS(0);
			  CashSectionMonthlyReport.setIC(0);
			  CashSectionMonthlyReport.setKLA(0);
			  CashSectionMonthlyReport.setMisc(0);
			  CashSectionMonthlyReport.setPlace(Place);
			  CashSectionMonthlyReport.setSTAMP(0);
			  
			  //Tx.begin();
			  try
			  {
			 Id = Session.save(CashSectionMonthlyReport);
			int ReceiptId=(int) Id;
			Session.save(CashSectionMonthlyReportFlow);
			System.out.println(ReceiptId+ "   "+Id  + "ID for Receipt");
			Session.beginTransaction().commit();;
			  }
			  catch(Exception e)
			  {
				  System.out.println("Error");
				  //Session.flush();
			//	  Tx.rollback();
				  e.printStackTrace();
			  }
			  
				 mapChallanScannedCopy.put("ChangeofNominee", ChangeofNominee);
			 }
			 if (donation>0)
			 {
				 mapChallanScannedCopy.put("donation", donation);
			 }
			 if (DuplicateCertificate>0)
			 {
				 mapChallanScannedCopy.put("DuplicateCertificate", DuplicateCertificate);
			 }
			 if (Govtgrant>0)
			 {
				 mapChallanScannedCopy.put("Govtgrant", Govtgrant);
			 }
			 if (KawfSubscription>0)
			 {
				 
				 
				 if (((KawfSubscription)%1000)>0)
				 {
					   // With Fine
				 }
				 else 
				 {
					// No fine 
					 
				 }
				 mapChallanScannedCopy.put("KawfSubscription", KawfSubscription);
			 }
			 if (LifeMembershipFee>0)
			 {
				 mapChallanScannedCopy.put("LifeMembershipFee", LifeMembershipFee);
			 }
			 if (Miscellaneous>0)
			 {
				 mapChallanScannedCopy.put("Miscellaneous", Miscellaneous);
			 }
			 
			 if (SaleofStampAmount>0)
			 {
				 mapChallanScannedCopy.put("SaleofStampAmount", SaleofStampAmount);
			 }
			 if (SeniorAdvocateContribution>0)
			 {
				 mapChallanScannedCopy.put("SeniorAdvocateContribution", SeniorAdvocateContribution);
			 }
			 if (seniorAdvocateLateFee>0)
			 {
				 mapChallanScannedCopy.put("seniorAdvocateLateFee", seniorAdvocateLateFee);
			 }
			 if (subscriptionLateFee>0)
			 {
				 mapChallanScannedCopy.put("subscriptionLateFee", subscriptionLateFee);
			 }
			 if (WelfareFundClosingFD>0)
			 {
				 mapChallanScannedCopy.put("WelfareFundClosingFD", WelfareFundClosingFD);
			 }
			 if (WelfareFundCostReceipts>0)
			 {
				 mapChallanScannedCopy.put("WelfareFundCostReceipts", WelfareFundCostReceipts);
			 }
			 if (WelfareFundInterestOnFD>0)
			 {
				 mapChallanScannedCopy.put("WelfareFundInterestOnFD", WelfareFundInterestOnFD);
			 }
			 if (WFReimbursmentOfsalaryDeduction>0)
			 {
				 mapChallanScannedCopy.put("WFReimbursmentOfsalaryDeduction", WFReimbursmentOfsalaryDeduction);
			 }
			 
			 
			 Integer total=KawfSubscription+SeniorAdvocateContribution+ChangeofNominee+DuplicateCertificate+
					 WelfareFundCostReceipts+donation+subscriptionLateFee+seniorAdvocateLateFee+WFReimbursmentOfsalaryDeduction+
					 WelfareFundInterestOnFD+WelfareFundClosingFD+SaleofStampAmount+LifeMembershipFee+Govtgrant+Miscellaneous;
			System.out.println("TOTAL AMOUNT::"+total);
			 JSPRelatedFunctionsimp JSPRelatedFunctionsimp= new JSPRelatedFunctionsimp();
			 String	responseString=	JSPRelatedFunctionsimp.GenerateChallan(total,mapChallanScannedCopy,Name , timeStamp1, Place);
				
			 out.println(responseString);
			//  Session.save(EnrollmentNewMemberBean);
			  Session.close();
	}

}
*/

package com.KSBC.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.math.BigDecimal;
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

import com.KSBC.Bean.CashSectionMonthlyReport;
import com.KSBC.Bean.CashSectionMonthlyReportFlow;
import com.KSBC.Bean.EnrollmentNewMemberBean;
import com.KSBC.Bean.KAWFMiscReceiptBean;
import com.KSBC.Bean.ReceiptDeleteTable;
import com.KSBC.JSPRelatedFunctions.JSPRelatedFunctionsimp;
import com.KSBC.Util.HibernateUtil;

/**
 * Servlet implementation class KAWFMiscReceipt
 */
/*@WebServlet("/KAWFMiscReceipt")*/
public class KAWFMiscReceipt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KAWFMiscReceipt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	//	KAWFMiscReceiptBean KAWFMiscReceiptBean = new KAWFMiscReceiptBean();
		System.out.println("*********************** Hi  **********************************");
		 response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		    Serializable Id;
		    int BeanSaveId=0;
		    int ReceiptId=0;
		    LocalDate today = LocalDate.now();
		    Session Session = HibernateUtil.getSessionFactory().openSession();
			Transaction Tx = Session.beginTransaction();
			 LinkedHashMap<String, Integer> mapChallanScannedCopy = new LinkedHashMap<String, Integer>();
			 String category = (String)request.getParameter("category");
				System.out.println(category + "   Sowmya"); 
			
			 
			 String DDDate=request.getParameter("DDDate");	
			 System.out.println(DDDate + "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&    DD Date");
			 HttpSession Servletsession = request.getSession(false);
				if (Servletsession==null)
				{
					Servletsession = request.getSession(true);
				} 
				
				String Operator= (String) Servletsession.getAttribute("UserName");
				
				System.out.println(Operator + " Operator");
				
			 
			System.out.println("coming");
		int KawfSubscription = Integer.parseInt(request.getParameter("KawfSubscription"));
		//System.out.println(EnrollmentFee);
	//	int SeniorAdvocateContribution = Integer.parseInt(request.getParameter("SeniorAdvocateContribution"));
		//System.out.println(IdentityCar);
	//	int ChangeofNominee=Integer.parseInt(request.getParameter("ChangeofNominee"));
		int SeniorAdvocateContribution=0;
		try{
 SeniorAdvocateContribution = Integer.parseInt(request.getParameter("SeniorAdvocateContribution"));
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
		
		int ThisYear=0;
		
		try{
			ThisYear = Integer.parseInt(request.getParameter("ThisYear"));
					}
					catch(Exception exception){
						exception.printStackTrace();
					}
		System.out.println(ThisYear + "   ThisYear");
		int PriviousYear=0;
		try{
			PriviousYear = Integer.parseInt(request.getParameter("PriviousYear"));
					}
					catch(Exception exception){
						exception.printStackTrace();
					}
		System.out.println(PriviousYear + "   PriviousYear");

		
		int ChangeofNominee=0;
					
		try{
			ChangeofNominee =Integer.parseInt(request.getParameter("ChangeofNominee"));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		//System.out.println(miscRts);
	//	int DuplicateCertificate=Integer.parseInt(request.getParameter("DuplicateCertificate"));
		
		
				int DuplicateCertificate=0;
	try{
			DuplicateCertificate =Integer.parseInt(request.getParameter("DuplicateCertificate"));
			
		}
	catch(Exception e){
		e.printStackTrace();
	}
		
		
		
	int KawfSubscriptionForPlender=Integer.parseInt(request.getParameter("KawfSubscriptionForPlender"));
		
		System.out.println(KawfSubscriptionForPlender + "  KawfSubscriptionForPlender");
		
		//System.out.println(KsbcTrust);
		int WelfareFundCostReceipts=Integer.parseInt(request.getParameter("wfCost"));
		//System.out.println(KawfMembershipFee);
		int donation=Integer.parseInt(request.getParameter("donation"));
		//System.out.println(BciSubscriptio);
		int subscriptionLateFee=Integer.parseInt(request.getParameter("subscriptionFee"));
		//System.out.println(fds);
	System.out.println(ThisYear + "  (((((((((((((ThisYear");
	
	System.out.println(PriviousYear + "  ))))))))))))))) PriviousYear");
	int Fine_Amount=0;
		if (KawfSubscription==0)
		{
			/*int Fine_Amount=ThisYear%1000;
			subscriptionLateFee=Fine_Amount;*/
			KawfSubscription=ThisYear+PriviousYear;
			System.out.println(KawfSubscription);
			 Fine_Amount=KawfSubscription%1000;
			KawfSubscription=KawfSubscription-Fine_Amount;
			System.out.println(Fine_Amount);
		//	subscriptionLateFee=Fine_Amount;
		}
		String responseString="";
		int seniorAdvocateLateFee=Integer.parseInt(request.getParameter("seniorAdvFee"));
		
/*String[] seniorAdvFeeArray = request.getParameterValues("seniorAdvFee");
		
		System.out.println(seniorAdvFeeArray + "  String ");
		

		int seniorAdvocateLateFee=0;
		if ((seniorAdvFeeArray==null) || (seniorAdvFeeArray.length==0))
		{
			seniorAdvocateLateFee =0;
				
		}
		else
		{
			
			System.out.println(request.getParameter(seniorAdvFeeArray[0]));
			seniorAdvocateLateFee =Integer.parseInt(request.getParameter(seniorAdvFeeArray[0]));
			System.out.println("##################################### b ^^^^^^^^^^^");
		}
		*/
		
		int WFReimbursmentOfsalaryDeduction=Integer.parseInt(request.getParameter("WFsalDeduction"));
		int WelfareFundInterestOnFD=Integer.parseInt(request.getParameter("InterestFD"));
		int WelfareFundClosingFD=Integer.parseInt(request.getParameter("closingFD"));
		int SaleofStampAmount=Integer.parseInt(request.getParameter("stamp"));
	//	int LifeMembershipFee=Integer.parseInt(request.getParameter("LifeMembershipFee"));
		

		int LifeMembershipFee=0;
		try
		{
			LifeMembershipFee=Integer.parseInt(request.getParameter("LifeMembershipFee"));
		}
		catch (Exception e)
		{
		e.printStackTrace();		
		}
		
		int Govtgrant=Integer.parseInt(request.getParameter("grant"));
		int Miscellaneous=Integer.parseInt(request.getParameter("misc"));
		
		
		
		String Name = (String)request.getParameter("Name");
		String KARNumber = (String)request.getParameter("KARNumber");
		String BankName = (String)request.getParameter("BankName");
		String BranchName = (String)request.getParameter("BranchName");
		String Place= (String)request.getParameter("Place");
	//	int Amount = Integer.parseInt(request.getParameter("Amount"));
	
		String DDNumber = (String)request.getParameter("DDNumber");
		 int Fine_AmountForKawfSubscriptionForPlender=KawfSubscriptionForPlender%1000;
	KAWFMiscReceiptBean kawfMiscReceiptBean=new KAWFMiscReceiptBean();
	
	kawfMiscReceiptBean.setChangeofNominee(ChangeofNominee);
	kawfMiscReceiptBean.setDonation(donation);
	kawfMiscReceiptBean.setDuplicateCertificate(DuplicateCertificate);
	kawfMiscReceiptBean.setGovtgrant(Govtgrant);
	if (KawfSubscription>0)
	{
		kawfMiscReceiptBean.setKawfSubscription(KawfSubscription);	
	}
	else
	{
		kawfMiscReceiptBean.setKawfSubscription(KawfSubscriptionForPlender);	
	}
	
	kawfMiscReceiptBean.setLifeMembershipFee(LifeMembershipFee);
	kawfMiscReceiptBean.setMiscellaneous(Miscellaneous);
	kawfMiscReceiptBean.setSaleofStampAmount(SaleofStampAmount);
	kawfMiscReceiptBean.setSeniorAdvocateContribution(SeniorAdvocateContribution);
	kawfMiscReceiptBean.setSeniorAdvocateLateFee(seniorAdvocateLateFee);
	if (Fine_Amount>0)
	{
		kawfMiscReceiptBean.setSubscriptionLateFee(Fine_Amount);
		
		System.out.println("Akshay");
	}
	else if (Fine_AmountForKawfSubscriptionForPlender>0)
	{
kawfMiscReceiptBean.setSubscriptionLateFee(Fine_AmountForKawfSubscriptionForPlender);
		
		System.out.println("Akshay2");
	}
	else 
	{
		kawfMiscReceiptBean.setSubscriptionLateFee(subscriptionLateFee);	
		System.out.println("Akshay1");
	}
	
	
	kawfMiscReceiptBean.setWelfareFundClosingFD(WelfareFundClosingFD);
	kawfMiscReceiptBean.setWelfareFundCostReceipts(WelfareFundCostReceipts);
	kawfMiscReceiptBean.setWelfareFundInterestOnFD(WelfareFundInterestOnFD);
	kawfMiscReceiptBean.setWFReimbursmentOfsalaryDeduction(WFReimbursmentOfsalaryDeduction);
	  java.util.Date date = Date.from(today.atStartOfDay()
		        .atZone(ZoneId.systemDefault()).toInstant());
		    Timestamp timeStamp = new Timestamp(date.getTime());
		   	
		    
	kawfMiscReceiptBean.setChallanCreatedDate(timeStamp);
		String timeStamp1 = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		
		if (ChangeofNominee>0)
			 {
			 BeanSaveId = (int) Session.save(kawfMiscReceiptBean);
			  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
			  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
			  CashSectionMonthlyReportFlow.setAmount(ChangeofNominee);
			  CashSectionMonthlyReportFlow.setKAWF(ChangeofNominee);
			  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReportFlow.setBCIAWF(0);
			   CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
			  CashSectionMonthlyReportFlow.setParticulars("Change of Nominee Fee");
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
					 
			  }// CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEntFee(0);
			  CashSectionMonthlyReportFlow.setFDS(0);
			  CashSectionMonthlyReportFlow.setIC(0);
			  CashSectionMonthlyReportFlow.setKLA(0);
			  CashSectionMonthlyReportFlow.setMisc(0);
			  CashSectionMonthlyReportFlow.setPlace(Place);
			  CashSectionMonthlyReportFlow.setSTAMP(0);
			  System.out.println(" Persist  #####################################");
			  
			  CashSectionMonthlyReport.setAmount(ChangeofNominee);
			  CashSectionMonthlyReport.setKAWF(ChangeofNominee);
			  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEnrollNo(KARNumber);
			  CashSectionMonthlyReport.setParticulars("Change of Nominee Fee");
			//  CashSectionMonthlyReport.setPaymode("Offline");
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
			 Id = Session.save(CashSectionMonthlyReport);
			 ReceiptId=(int) Id;
			Session.save(CashSectionMonthlyReportFlow);
			System.out.println(ReceiptId+ "   "+Id  + "ID for Receipt");
			Session.beginTransaction().commit();;
			  }
			  catch(Exception e)
			  {
				  System.out.println("Error");
				  //Session.flush();
			//	  Tx.rollback();
				  e.printStackTrace();
			  }
			  
				 mapChallanScannedCopy.put("Change Of Nominee", ChangeofNominee);
			 }
		
		
		 if (KawfSubscriptionForPlender>0)
		 {
			  Fine_AmountForKawfSubscriptionForPlender=KawfSubscriptionForPlender%1000;
			  kawfMiscReceiptBean.setSubscriptionLateFee(Fine_AmountForKawfSubscriptionForPlender);
			  kawfMiscReceiptBean.setKawfSubscription(KawfSubscriptionForPlender-Fine_AmountForKawfSubscriptionForPlender);
			  
			  System.out.println(kawfMiscReceiptBean.getSubscriptionLateFee() + "  late Fee");
			  System.out.println(kawfMiscReceiptBean.getKawfSubscription()+ "  fee Fee");
		  BeanSaveId = (int)Session.save(kawfMiscReceiptBean);
				 System.out.println(BeanSaveId +"vikky");
				  
				  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
				  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
				  CashSectionMonthlyReportFlow.setAmount(KawfSubscriptionForPlender);
				  CashSectionMonthlyReportFlow.setKAWF(KawfSubscriptionForPlender);
				  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReportFlow.setBCIAWF(0);
				   CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
				  CashSectionMonthlyReportFlow.setParticulars("KAWF Subscription Fee");
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
						 
				  } CashSectionMonthlyReportFlow.setBCIAWF(0);
				  CashSectionMonthlyReportFlow.setEntFee(0);
				  CashSectionMonthlyReportFlow.setFDS(0);
				  CashSectionMonthlyReportFlow.setIC(0);
				  CashSectionMonthlyReportFlow.setKLA(0);
				  CashSectionMonthlyReportFlow.setMisc(0);
				  CashSectionMonthlyReportFlow.setPlace(Place);
				  CashSectionMonthlyReportFlow.setSTAMP(0);
				  System.out.println(" Persist  #####################################");
				  
				  CashSectionMonthlyReport.setAmount(KawfSubscriptionForPlender);
				  CashSectionMonthlyReport.setKAWF(KawfSubscriptionForPlender);
				  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReport.setBCIAWF(0);
				  CashSectionMonthlyReport.setEnrollNo(KARNumber);
				  CashSectionMonthlyReport.setParticulars("KAWF Sub. Fee");
				 // CashSectionMonthlyReport.setPaymode("Offline");
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
				Serializable Id1 = Session.save(CashSectionMonthlyReport);
				 ReceiptId=(int) Id1;
				Session.save(CashSectionMonthlyReportFlow);
				System.out.println(ReceiptId+ "   "+Id1  + "ID for Receipt");
				Session.beginTransaction().commit();;
				  }
				  catch(Exception e)
				  {
					  System.out.println("Error");
					  //Session.flush();
				//	  Tx.rollback();
					  e.printStackTrace();
				  } 
				  if (Fine_AmountForKawfSubscriptionForPlender>0)
				  {
					  mapChallanScannedCopy.put("KAWF Subscription Fee ", KawfSubscriptionForPlender-Fine_AmountForKawfSubscriptionForPlender);
					  mapChallanScannedCopy.put("KAWF Late Fee ", Fine_AmountForKawfSubscriptionForPlender);
				  }
				  else
				  {
					  mapChallanScannedCopy.put("KAWF Subscription Fee ", KawfSubscriptionForPlender);
				  }
				 
		 }
				  // check the above code
		  
			 if (donation>0)
			 {
				 
				 BeanSaveId = (int)	Session.save(kawfMiscReceiptBean);
					 
					  
						  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
					  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
					  CashSectionMonthlyReportFlow.setAmount(donation);
					  CashSectionMonthlyReportFlow.setKAWF(donation);
					  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
					  CashSectionMonthlyReportFlow.setBCIAWF(0);
					   CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
					  CashSectionMonthlyReportFlow.setParticulars("KAWF Misc Donation");
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
							 
					  } CashSectionMonthlyReportFlow.setBCIAWF(0);
					  CashSectionMonthlyReportFlow.setEntFee(0);
					  CashSectionMonthlyReportFlow.setFDS(0);
					  CashSectionMonthlyReportFlow.setIC(0);
					  CashSectionMonthlyReportFlow.setKLA(0);
					  CashSectionMonthlyReportFlow.setMisc(0);
					  CashSectionMonthlyReportFlow.setPlace(Place);
					  CashSectionMonthlyReportFlow.setSTAMP(0);
					  System.out.println(" Persist  #####################################");
					  
					  CashSectionMonthlyReport.setAmount(donation);
					  CashSectionMonthlyReport.setKAWF(donation);
					  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
					  CashSectionMonthlyReport.setBCIAWF(0);
					  CashSectionMonthlyReport.setEnrollNo(KARNumber);
					  CashSectionMonthlyReport.setParticulars("KAWF Misc Donation");
					 // CashSectionMonthlyReport.setPaymode("Offline");
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
					Serializable Id1 = Session.save(CashSectionMonthlyReport);
					 ReceiptId=(int) Id1;
					Session.save(CashSectionMonthlyReportFlow);
					System.out.println(ReceiptId+ "   "+Id1  + "ID for Receipt");
					Session.beginTransaction().commit();;
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
						
				 
				 mapChallanScannedCopy.put("Donation", donation);
			 }
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 if (DuplicateCertificate>0)
			 {
				 BeanSaveId = (int)Session.save(kawfMiscReceiptBean);
					 
				  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
				  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
				  CashSectionMonthlyReportFlow.setAmount(DuplicateCertificate);
				  CashSectionMonthlyReportFlow.setKAWF(DuplicateCertificate);
				  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReportFlow.setBCIAWF(0);
				   CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
				  CashSectionMonthlyReportFlow.setParticulars("KAWF Duplicate Certificate Fee");
				  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate); 
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
				  
				  CashSectionMonthlyReport.setAmount(DuplicateCertificate);
				  CashSectionMonthlyReport.setKAWF(DuplicateCertificate);
				  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReport.setBCIAWF(0);
				  CashSectionMonthlyReport.setEnrollNo(KARNumber);
				  CashSectionMonthlyReport.setParticulars("KAWF Duplicate Certificate Fee");
				  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);
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
				Serializable Id1 = Session.save(CashSectionMonthlyReport);
				 ReceiptId=(int) Id1;
				Session.save(CashSectionMonthlyReportFlow);
				System.out.println(ReceiptId+ "   "+Id1  + "ID for Receipt");
			//	  Tx.commit();
				  }
				  catch(Exception e)
				  {
					  System.out.println("Error");
					  //Session.flush();
			//		  Tx.rollback();
					  e.printStackTrace();
				  }
				//  Session.save(CashSectionMonthlyReportFlow);
			//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
				
				 
				 mapChallanScannedCopy.put("Duplicate Certificate", DuplicateCertificate);
			 }
			 
			 
			 
			 
			 
			 if (Govtgrant>0)
			 {
				
				 BeanSaveId = (int) Session.save(kawfMiscReceiptBean);
					
				 CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
				  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
				  CashSectionMonthlyReportFlow.setAmount(Govtgrant);
				  CashSectionMonthlyReportFlow.setKAWF(Govtgrant);
				  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReportFlow.setBCIAWF(0);
				   CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
				  CashSectionMonthlyReportFlow.setParticulars("KAWF Govtgrant Fee");
				  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate); 
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
				  
				  CashSectionMonthlyReport.setAmount(Govtgrant);
				  CashSectionMonthlyReport.setKAWF(Govtgrant);
				  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReport.setBCIAWF(0);
				  CashSectionMonthlyReport.setEnrollNo(KARNumber);
				  CashSectionMonthlyReport.setParticulars("KAWF Govtgrant Fee");
				  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate); 
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
				Serializable Id1 = Session.save(CashSectionMonthlyReport);
				 ReceiptId=(int) Id1;
				Session.save(CashSectionMonthlyReportFlow);
				System.out.println(ReceiptId+ "   "+Id1  + "ID for Receipt");
			//	  Tx.commit();
				  }
				  catch(Exception e)
				  {
					  System.out.println("Error");
					  //Session.flush();
			//		  Tx.rollback();
					  e.printStackTrace();
				  }
				//  Session.save(CashSectionMonthlyReportFlow);
			//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
				 
				 mapChallanScannedCopy.put("Govt. Grant", Govtgrant);
			 }
			 
			 
			 
			 
			 
			 if (KawfSubscription>0)
			 {
				 BeanSaveId = (int)	Session.save(kawfMiscReceiptBean);
					 
				 int rem=KawfSubscription%1000;
				 System.out.println(rem + " Remainder");
				
				 
				  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
				  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
				CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReportFlow.setBCIAWF(0);
				   CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
				  CashSectionMonthlyReportFlow.setParticulars("KAWF Subscription Fee");
				  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate); 
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
				  
				CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReport.setBCIAWF(0);
				  CashSectionMonthlyReport.setEnrollNo(KARNumber);
				  CashSectionMonthlyReport.setParticulars("KAWF Subscription Fee");
				  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate); 
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
				  if (Fine_Amount>0)
					 {
					  CashSectionMonthlyReport.setAmount(KawfSubscription+Fine_Amount);
					  CashSectionMonthlyReport.setKAWF(KawfSubscription+Fine_Amount);
					  CashSectionMonthlyReportFlow.setAmount(KawfSubscription+Fine_Amount);
					  CashSectionMonthlyReportFlow.setKAWF(KawfSubscription+Fine_Amount);
					/*  mapChallanScannedCopy.put("KAWF Subscription", KawfSubscription);*/

					    Calendar now = Calendar.getInstance();
					    int year=  now.get(Calendar.YEAR);
					    int PriYear=year-1;
					    // 
					    System.out.println("Current Year is : " + now.get(Calendar.YEAR));
					   
					 //arun
					    
					    if (ThisYear>0)
					    {
					    	mapChallanScannedCopy.put("KAWF Subscription Fee "+PriYear, PriviousYear-Fine_Amount);
							  mapChallanScannedCopy.put("KAWF Late Fee "+PriYear, Fine_Amount);
							  mapChallanScannedCopy.put("KAWF Subscription Fee " +year, ThisYear);	
								
					    }else
					    {
					    	mapChallanScannedCopy.put("KAWF Subscription Fee "+PriYear, PriviousYear-Fine_Amount);
							  mapChallanScannedCopy.put("KAWF Late Fee ", Fine_Amount);
							 
					    }
					   }
					 else
					 {
						    Calendar now = Calendar.getInstance();
						    int year=  now.get(Calendar.YEAR);
						    int PriYear=year-1;
						   
						  CashSectionMonthlyReportFlow.setAmount(KawfSubscription);
						  CashSectionMonthlyReportFlow.setKAWF(KawfSubscription);
						  CashSectionMonthlyReport.setAmount(KawfSubscription);
						  CashSectionMonthlyReport.setKAWF(KawfSubscription);
						  
						  System.out.println("DDDDDDDDDDDDDDDDDD");
						  mapChallanScannedCopy.put("KAWF Subscription Fee "+year  , KawfSubscription);  	 
					 } 
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
			//	  Tx.commit();
				  }
				  catch(Exception e)
				  {
					  System.out.println("Error");
					  //Session.flush();
			//		  Tx.rollback();
					  e.printStackTrace();
				  }
				//  Session.save(CashSectionMonthlyReportFlow);
			//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
				 System.out.println(KawfSubscription+ "          KawfSubscription");
				 
			 }
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 if (LifeMembershipFee>0)
			 {
				 int LifeTimeLateFee=LifeMembershipFee%1000;
				 kawfMiscReceiptBean.setSubscriptionLateFee(LifeTimeLateFee);
				 kawfMiscReceiptBean.setLifeMembershipFee(LifeMembershipFee-LifeTimeLateFee);
				 
				 System.out.println(kawfMiscReceiptBean.getSubscriptionLateFee() + "Late Fee");
				 JSPRelatedFunctionsimp  JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
			String Updateresult= JSPRelatedFunctionsimp.UpdateToLifeTimeMemberShip(KARNumber); 
				
		System.out.println(Updateresult + " Life time update");
				 System.out.println(kawfMiscReceiptBean.getLifeMembershipFee() + "Life Late Fee");
		BeanSaveId=(int) Session.save(kawfMiscReceiptBean);
					
				/* System.out.println(KAWF + "Serial Number");*/
				  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
				  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
				  CashSectionMonthlyReportFlow.setAmount(LifeMembershipFee);
				  CashSectionMonthlyReportFlow.setKAWF(LifeMembershipFee);
				  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReportFlow.setBCIAWF(0);
				   CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
				  CashSectionMonthlyReportFlow.setParticulars("KAWF Life Membership Fee");
				  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate); 
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
				  
				  CashSectionMonthlyReport.setAmount(LifeMembershipFee);
				  CashSectionMonthlyReport.setKAWF(LifeMembershipFee);
				  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReport.setBCIAWF(0);
				  CashSectionMonthlyReport.setEnrollNo(KARNumber);
				  CashSectionMonthlyReport.setParticulars("KAWF Life Membership Fee");
				  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate); 
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
				Serializable Id1 = Session.save(CashSectionMonthlyReport);
				 ReceiptId=(int) Id1;
				Session.save(CashSectionMonthlyReportFlow);
				System.out.println(ReceiptId+ "   "+Id1  + "ID for Receipt");
				  Tx.commit();
				  }
				  catch(Exception e)
				  {
					  System.out.println("Error");
					  //Session.flush();
			//		  Tx.rollback();
					  e.printStackTrace();
				  }
				  
				//  Session.save(CashSectionMonthlyReportFlow);
			//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
				 if(LifeTimeLateFee>0)
				 {
					 mapChallanScannedCopy.put("LifeTime Membership Fee", LifeMembershipFee-LifeTimeLateFee);
					 mapChallanScannedCopy.put("LifeTime Membership Late Fee", LifeTimeLateFee);
				 }
				 else
				 {
					 mapChallanScannedCopy.put("LifeTime Membership Fee", LifeMembershipFee);
				 }
				
			 }
			 
			 
			 
			 
			 if (Miscellaneous>0)
			 {
				 BeanSaveId = (int)	Session.save(kawfMiscReceiptBean);
					
				  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
				  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
				  CashSectionMonthlyReportFlow.setAmount(Miscellaneous);
				  CashSectionMonthlyReportFlow.setKAWF(Miscellaneous);
				  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReportFlow.setBCIAWF(0);
				   CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
				  CashSectionMonthlyReportFlow.setParticulars("KAWF Miscellaneous Fee");
				  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate); 
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
				  
				  CashSectionMonthlyReport.setAmount(Miscellaneous);
				  CashSectionMonthlyReport.setKAWF(Miscellaneous);
				  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReport.setBCIAWF(0);
				  CashSectionMonthlyReport.setEnrollNo(KARNumber);
				  CashSectionMonthlyReport.setParticulars("KAWF Miscellaneous Fee");
				  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate); 
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
				Serializable Id1 = Session.save(CashSectionMonthlyReport);
				 ReceiptId=(int) Id1;
				Session.save(CashSectionMonthlyReportFlow);
				System.out.println(ReceiptId+ "   "+Id1  + "ID for Receipt");
			//	  Tx.commit();
				  }
				  catch(Exception e)
				  {
					  System.out.println("Error");
					  //Session.flush();
			//		  Tx.rollback();
					  e.printStackTrace();
				  }
				//  Session.save(CashSectionMonthlyReportFlow);
			//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
				 mapChallanScannedCopy.put("Miscellaneous", Miscellaneous);
			 }

			 
			 
			 if (SaleofStampAmount>0)
			 {
				 
				 BeanSaveId = (int)	Session.save(kawfMiscReceiptBean);
					
				 
				 CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
				  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
				  CashSectionMonthlyReportFlow.setAmount(SaleofStampAmount);
				  CashSectionMonthlyReportFlow.setKAWF(0);
				  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReportFlow.setBCIAWF(0);
				   CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
				  CashSectionMonthlyReportFlow.setParticulars("KAWF Sale of Stamp Amount");
				  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate); 
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
				  CashSectionMonthlyReportFlow.setSTAMP(SaleofStampAmount);
				  System.out.println(" Membeship Persist  #####################################");
				  
				  CashSectionMonthlyReport.setAmount(SaleofStampAmount);
				  CashSectionMonthlyReport.setKAWF(0);
				  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReport.setBCIAWF(0);
				  CashSectionMonthlyReport.setEnrollNo(KARNumber);
				  CashSectionMonthlyReport.setParticulars("KAWF Sale of Stamp Amount");
				  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate); 
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
				  CashSectionMonthlyReport.setSTAMP(SaleofStampAmount);
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
			//	  Tx.commit();
				  }
				  catch(Exception e)
				  {
					  System.out.println("Error");
					  //Session.flush();
			//		  Tx.rollback();
					  e.printStackTrace();
				  }
				//  Session.save(CashSectionMonthlyReportFlow);
			//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
				 mapChallanScannedCopy.put("Sale Of Stamp", SaleofStampAmount);
			 }
			 
			 
			 
			 
			 if (SeniorAdvocateContribution>0)
			 {
				 
				 BeanSaveId = (int) Session.save(kawfMiscReceiptBean);
				 
				  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
				  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
				  CashSectionMonthlyReportFlow.setAmount(SeniorAdvocateContribution);
				  CashSectionMonthlyReportFlow.setKAWF(SeniorAdvocateContribution);
				  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReportFlow.setBCIAWF(0);
				   CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
				  CashSectionMonthlyReportFlow.setParticulars("KAWF Senior Advocate Contribution");
				  
				  System.out.println(category+" category");
				  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate); 
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
				  
				  CashSectionMonthlyReport.setAmount(SeniorAdvocateContribution);
				  CashSectionMonthlyReport.setKAWF(SeniorAdvocateContribution);
				  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReport.setBCIAWF(0);
				  CashSectionMonthlyReport.setEnrollNo(KARNumber);
				  CashSectionMonthlyReport.setParticulars("KAWF Senior Advocate Contribution");
				  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate); 
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
				Serializable Id1 = Session.save(CashSectionMonthlyReport);
				 ReceiptId=(int) Id1;
				Session.save(CashSectionMonthlyReportFlow);
				System.out.println(ReceiptId+ "   "+Id1  + "ID for Receipt");
			//	  Tx.commit();
				  }
				  catch(Exception e)
				  {
					  System.out.println("Error");
					  //Session.flush();
			//		  Tx.rollback();
					  e.printStackTrace();
				  }
				//  Session.save(CashSectionMonthlyReportFlow);
			//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
				 mapChallanScannedCopy.put("Senior Advocate Contribution", SeniorAdvocateContribution);
			 }
			 
			 
			 
			 
			 
			 
			 if (seniorAdvocateLateFee>0)
			 {
				 
				 BeanSaveId = (int) Session.save(kawfMiscReceiptBean);
					 
				 CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
				  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
				  CashSectionMonthlyReportFlow.setAmount(seniorAdvocateLateFee);
				  CashSectionMonthlyReportFlow.setKAWF(seniorAdvocateLateFee);
				  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReportFlow.setBCIAWF(0);
				   CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
				  CashSectionMonthlyReportFlow.setParticulars("KAWF senior Advocate Late Fee");
				  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  		  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate); 
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
				  
				  CashSectionMonthlyReport.setAmount(seniorAdvocateLateFee);
				  CashSectionMonthlyReport.setKAWF(seniorAdvocateLateFee);
				  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReport.setBCIAWF(0);
				  CashSectionMonthlyReport.setEnrollNo(KARNumber);
				  CashSectionMonthlyReport.setParticulars("KAWF senior Advocate Late Fee");
				  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);
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
				Serializable Id1 = Session.save(CashSectionMonthlyReport);
				 ReceiptId=(int) Id1;
				Session.save(CashSectionMonthlyReportFlow);
				System.out.println(ReceiptId+ "   "+Id1  + "ID for Receipt");
			//	  Tx.commit();
				  }
				  catch(Exception e)
				  {
					  System.out.println("Error");
					  //Session.flush();
			//		  Tx.rollback();
					  e.printStackTrace();
				  }
				//  Session.save(CashSectionMonthlyReportFlow);
			//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
				 mapChallanScannedCopy.put("senior Advocate LateFee", seniorAdvocateLateFee);
			 }
			 
			 
			 
			 if (subscriptionLateFee>0)
			 {
				 
				 BeanSaveId = (int) Session.save(kawfMiscReceiptBean);
					
					
				 
				  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
				  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
				  CashSectionMonthlyReportFlow.setAmount(subscriptionLateFee);
				  CashSectionMonthlyReportFlow.setKAWF(subscriptionLateFee);
				  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReportFlow.setBCIAWF(0);
				   CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
				  CashSectionMonthlyReportFlow.setParticulars("KAWF subscription Late Fee");
				  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);
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
				  
				  CashSectionMonthlyReport.setAmount(subscriptionLateFee);
				  CashSectionMonthlyReport.setKAWF(subscriptionLateFee);
				  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReport.setBCIAWF(0);
				  CashSectionMonthlyReport.setEnrollNo(KARNumber);
				  CashSectionMonthlyReport.setParticulars("KAWF subscription Late Fee");
				  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);
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
					  
					  /*if (KawfSubscription>0)
					  {
						  System.out.println("Nothing To save");
					  }
					  else
					  {
						*/  Serializable Id1 = Session.save(CashSectionMonthlyReport);
							 ReceiptId=(int) Id1;
							Session.save(CashSectionMonthlyReportFlow);
							System.out.println(ReceiptId+ "   "+Id1  + "ID for Receipt");
						  
					 /* }*/
				//	  Tx.commit();
				  }
				  catch(Exception e)
				  {
					  System.out.println("Error");
					  //Session.flush();
			//		  Tx.rollback();
					  e.printStackTrace();
				  }
				//  Session.save(CashSectionMonthlyReportFlow);
			//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
				 mapChallanScannedCopy.put("subscription Late Fee", subscriptionLateFee);
			 }
			 
			 
			 
			 if (WelfareFundClosingFD>0)
			 {
				 BeanSaveId = (int) Session.save(kawfMiscReceiptBean);
					
				  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
				  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
				  CashSectionMonthlyReportFlow.setAmount(WelfareFundClosingFD);
				  CashSectionMonthlyReportFlow.setKAWF(WelfareFundClosingFD);
				  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReportFlow.setBCIAWF(0);
				   CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
				  CashSectionMonthlyReportFlow.setParticulars("KAWF WelfareFund ClosingFD Fee");
				  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);
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
				  
				  CashSectionMonthlyReport.setAmount(WelfareFundClosingFD);
				  CashSectionMonthlyReport.setKAWF(WelfareFundClosingFD);
				  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReport.setBCIAWF(0);
				  CashSectionMonthlyReport.setEnrollNo(KARNumber);
				  CashSectionMonthlyReport.setParticulars("KAWF WelfareFund Closing FD Fee");
				  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);
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
				Serializable Id1 = Session.save(CashSectionMonthlyReport);
				 ReceiptId=(int) Id1;
				Session.save(CashSectionMonthlyReportFlow);
				System.out.println(ReceiptId+ "   "+Id1  + "ID for Receipt");
			//	  Tx.commit();
				  }
				  catch(Exception e)
				  {
					  System.out.println("Error");
					  //Session.flush();
			//		  Tx.rollback();
					  e.printStackTrace();
				  }
				//  Session.save(CashSectionMonthlyReportFlow);
			//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
				 mapChallanScannedCopy.put("WelfareFund Closing FD", WelfareFundClosingFD);
			 }
			 
			 
			 
			 
			 
			 
			 if (WelfareFundCostReceipts>0)
			 {
				 BeanSaveId = (int) Session.save(kawfMiscReceiptBean);
					
				  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
				  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
				  CashSectionMonthlyReportFlow.setAmount(WelfareFundCostReceipts);
				  CashSectionMonthlyReportFlow.setKAWF(WelfareFundCostReceipts);
				  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReportFlow.setBCIAWF(0);
				   CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
				  CashSectionMonthlyReportFlow.setParticulars("KAWF WelfareFund Cost Receipts Fee");
				  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);
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
				  
				  CashSectionMonthlyReport.setAmount(WelfareFundCostReceipts);
				  CashSectionMonthlyReport.setKAWF(WelfareFundCostReceipts);
				  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReport.setBCIAWF(0);
				  CashSectionMonthlyReport.setEnrollNo(KARNumber);
				  CashSectionMonthlyReport.setParticulars("KAWF WelfareFund Cost Receipts Fee");
				  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);
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
				Serializable Id1 = Session.save(CashSectionMonthlyReport);
				 ReceiptId=(int) Id1;
				Session.save(CashSectionMonthlyReportFlow);
				System.out.println(ReceiptId+ "   "+Id1  + "ID for Receipt");
			//	  Tx.commit();
				  }
				  catch(Exception e)
				  {
					  System.out.println("Error");
					  //Session.flush();
			//		  Tx.rollback();
					  e.printStackTrace();
				  }
				//  Session.save(CashSectionMonthlyReportFlow);
			//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
				 mapChallanScannedCopy.put("WelfareFund Cost Receipts", WelfareFundCostReceipts);
			 }
			 
			 
			 
			 
			 
			 
			 
			 if (WelfareFundInterestOnFD>0)
			 {		 BeanSaveId = (int) Session.save(kawfMiscReceiptBean);
					
				 
				 CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
			  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
			  CashSectionMonthlyReportFlow.setAmount(WelfareFundInterestOnFD);
			  CashSectionMonthlyReportFlow.setKAWF(WelfareFundInterestOnFD);
			  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReportFlow.setBCIAWF(0);
			   CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
			  CashSectionMonthlyReportFlow.setParticulars("KAWF WelfareFund Interest On FD ");
			  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);
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
			  
			  CashSectionMonthlyReport.setAmount(WelfareFundInterestOnFD);
			  CashSectionMonthlyReport.setKAWF(WelfareFundInterestOnFD);
			  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEnrollNo(KARNumber);
			  CashSectionMonthlyReport.setParticulars("KAWF WelfareFund Interest On FD");
			  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);
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
			Serializable Id1 = Session.save(CashSectionMonthlyReport);
			 ReceiptId=(int) Id1;
			Session.save(CashSectionMonthlyReportFlow);
			System.out.println(ReceiptId+ "   "+Id1  + "ID for Receipt");
		//	  Tx.commit();
			  }
			  catch(Exception e)
			  {
				  System.out.println("Error");
				  //Session.flush();
		//		  Tx.rollback();
				  e.printStackTrace();
			  }
			//  Session.save(CashSectionMonthlyReportFlow);
		//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
				 mapChallanScannedCopy.put("Welfare Fund Interest On FD", WelfareFundInterestOnFD);
			 }
			 
			 
			 
			 
			 
			 
			 if (WFReimbursmentOfsalaryDeduction>0)
			 {
				 BeanSaveId = (int)	Session.save(kawfMiscReceiptBean);
					 
				  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
				  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
				  CashSectionMonthlyReportFlow.setAmount(WFReimbursmentOfsalaryDeduction);
				  CashSectionMonthlyReportFlow.setKAWF(WFReimbursmentOfsalaryDeduction);
				  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReportFlow.setBCIAWF(0);
				   CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
				  CashSectionMonthlyReportFlow.setParticulars("KAWF Reimbursment Of salary Deduction");
				  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);
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
				  
				  CashSectionMonthlyReport.setAmount(WFReimbursmentOfsalaryDeduction);
				  CashSectionMonthlyReport.setKAWF(WFReimbursmentOfsalaryDeduction);
				  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReport.setBCIAWF(0);
				  CashSectionMonthlyReport.setEnrollNo(KARNumber);
				  CashSectionMonthlyReport.setParticulars("KAWF Reimbursment Of salary Deduction");
				  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);
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
				Serializable Id1 = Session.save(CashSectionMonthlyReport);
				 ReceiptId=(int) Id1;
				Session.save(CashSectionMonthlyReportFlow);
				System.out.println(ReceiptId+ "   "+Id1  + "ID for Receipt");
			//	  Tx.commit();
				  }
				  catch(Exception e)
				  {
					  System.out.println("Error");
					  //Session.flush();
			//		  Tx.rollback();
					  e.printStackTrace();
				  }
				//  Session.save(CashSectionMonthlyReportFlow);
			//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
				 mapChallanScannedCopy.put("WF Reimbursment Of salary", WFReimbursmentOfsalaryDeduction);
			 }
			 
			 // added fine
			 Integer total=KawfSubscriptionForPlender+Fine_Amount+KawfSubscription+SeniorAdvocateContribution+ChangeofNominee+DuplicateCertificate+
					 WelfareFundCostReceipts+donation+subscriptionLateFee+seniorAdvocateLateFee+WFReimbursmentOfsalaryDeduction+
					 WelfareFundInterestOnFD+WelfareFundClosingFD+SaleofStampAmount+LifeMembershipFee+Govtgrant+Miscellaneous;
			System.out.println("TOTAL AMOUNT::"+total);
			 JSPRelatedFunctionsimp JSPRelatedFunctionsimp= new JSPRelatedFunctionsimp();
			 	int year = Calendar.getInstance().get(Calendar.YEAR);
			   	int PriYear=year-1;
			   /* java.util.Date date = Date.from(today.atStartOfDay()
				        .atZone(ZoneId.systemDefault()).toInstant());
				    Timestamp timeStamp = new Timestamp(date.getTime());
				 */  	
			   	BigDecimal ThisYearDouble = new BigDecimal(ThisYear); 
				BigDecimal SingleYear = new BigDecimal(1);
				 Calendar now = Calendar.getInstance();
				 int PresentYearNow = now.get(Calendar.YEAR);
			System.out.println(total + "total");	 
				System.out.println(PresentYearNow + "  pl see PresentYear");
			BigDecimal	NextYear=  	new BigDecimal(ThisYear); 
			BigDecimal sum = ThisYearDouble.add(SingleYear);
			
			String InsertionResult="Sucessfully Updated";
			   	BigDecimal PriviousYearDouble = new BigDecimal(PriviousYear);  
			 if (ThisYear>0)
				{
				 String Result=JSPRelatedFunctionsimp.InsertIntoWelfarePayments(KARNumber,ReceiptId,ReceiptId, PresentYearNow, PresentYearNow+1, ThisYearDouble, timeStamp, ReceiptId, timeStamp);
				 InsertionResult=Result;
				if (InsertionResult.equalsIgnoreCase("Sucessfully Updated"))
				{
					if (PriviousYear>0)
					{
						
						ReceiptId = ReceiptId+1;
						 String Result1=JSPRelatedFunctionsimp.InsertIntoWelfarePayments(KARNumber,ReceiptId,ReceiptId, PresentYearNow-1, PresentYearNow, PriviousYearDouble, timeStamp, ReceiptId, timeStamp);
						 InsertionResult=Result1;
						
					}
				}
			
				  if ("Sucessfully Updated".equalsIgnoreCase(Result))
				{
					System.out.println("You Can go ahead");
				}
				}
			 else  if (PriviousYear>0)
				{
				 String Result=JSPRelatedFunctionsimp.InsertIntoWelfarePayments(KARNumber, ReceiptId, ReceiptId, PresentYearNow-1, PresentYearNow, PriviousYearDouble, timeStamp, ReceiptId, timeStamp);
				 if (InsertionResult.equalsIgnoreCase("Sucessfully Updated"))
					{
						if (ThisYear>0)
						{
							ReceiptId = ReceiptId+1;
							 String Result1=JSPRelatedFunctionsimp.InsertIntoWelfarePayments(KARNumber,ReceiptId,ReceiptId, PresentYearNow, PresentYearNow+1, ThisYearDouble, timeStamp, ReceiptId, timeStamp);
							 InsertionResult=Result1;
								
						}
					}
				}
			 if (InsertionResult.equalsIgnoreCase("Sucessfully Updated"))
			 {
				 	responseString=	JSPRelatedFunctionsimp.GenerateChallan(total,mapChallanScannedCopy,Name , timeStamp1, Place,KARNumber,ReceiptId+"",category,"DD Number:"+DDNumber+"  " + "DD Date:"+DDDate+"  "+"Bank:" + BankName+"  " + "Branch:" +BranchName);
						 
			 }
			 else
			 {
				 	responseString=	"Error occured while updating Welfare account Please contact support team";
			 }
			 
			 
			 try
			 {
			 ReceiptDeleteTable ReceiptDeleteTable= new ReceiptDeleteTable();
				ReceiptDeleteTable.setChallanGenerateSLNumber(ReceiptId);
				ReceiptDeleteTable.setOperator(Operator);
				ReceiptDeleteTable.setMonthlyReportSLNumber(BeanSaveId);
				ReceiptDeleteTable.setTimeWhenDeleted(today);
				ReceiptDeleteTable.setType("KAWFMisc");
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
			 out.println(responseString);
			//  Session.save(EnrollmentNewMemberBean);
			
	}

}
