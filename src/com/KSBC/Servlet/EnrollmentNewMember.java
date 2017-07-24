/*package com.KSBC.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.KSBC.Util.HibernateUtil;
import com.KSBC.Bean.*;
import com.KSBC.JSPRelatedFunctions.JSPRelatedFunctionsimp;

*//**
 * Servlet implementation class EnrollmentNewMember
 *//*

public class EnrollmentNewMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String who;
    *//**
     * @see HttpServlet#HttpServlet()
     *//*
    public EnrollmentNewMember() {
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
			 HashMap<String, Integer> mapChallanScannedCopy = new HashMap<String, Integer>();
					
			System.out.println("coming");
		int EnrollmentFee = Integer.parseInt(request.getParameter("category"));
		System.out.println(EnrollmentFee);
		if(EnrollmentFee==8000){
			who="specialGeneral";System.out.println(who);
		}
		else if(EnrollmentFee==5000){
			who="specialscst";
			
		}
		
		
		
		int IdentityCar = Integer.parseInt(request.getParameter("identityCard"));
		System.out.println(IdentityCar);
		int miscRts=Integer.parseInt(request.getParameter("miscRts"));
		System.out.println(miscRts);
		int KsbcTrust=Integer.parseInt(request.getParameter("KsbcTrust"));
		System.out.println(KsbcTrust);

		int KawfMembershipFee=0;
		
		try{
		 KawfMembershipFee=Integer.parseInt(request.getParameter("KawfMembershipFee"));
		
		System.out.println(KawfMembershipFee);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		int BciSubscriptio=Integer.parseInt(request.getParameter("BciSubscription"));
		System.out.println(BciSubscriptio);
		int fds=0;
		try{
		 fds=Integer.parseInt(request.getParameter("fds"));
			System.out.println(fds);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
		System.out.println(fds);
		
		
		String Name = (String)request.getParameter("Name");

		String BankName = (String)request.getParameter("BankName");
		String BranchName = (String)request.getParameter("BranchName");
		String Place= (String)request.getParameter("Place");
	
		String DDNumber = (String)request.getParameter("DDNumber");
		
		EnrollmentNewMemberBean enrollmentNewMember=new  EnrollmentNewMemberBean();
		
		enrollmentNewMember.setEnrollmentFee(EnrollmentFee);
		enrollmentNewMember.setBciSubscription(BciSubscriptio);
		enrollmentNewMember.setFds(fds);
		enrollmentNewMember.setIdentityCard(IdentityCar);
		enrollmentNewMember.setKawfMembershipFee(KawfMembershipFee);
		enrollmentNewMember.setKsbcTrust(KsbcTrust);
		enrollmentNewMember.setMiscRts(miscRts);
		
		String timeStamp1 = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		  if (EnrollmentFee>0)
			 {
				 mapChallanScannedCopy.put("EnrollmentFee", EnrollmentFee);
			 }
			 if (IdentityCar>0)
			 {
				 mapChallanScannedCopy.put("IdentityCard", IdentityCar);
			 }
			 if (BciSubscriptio>0)
			 {
				 mapChallanScannedCopy.put("BciSubscription", BciSubscriptio);
			 }
			 if (fds>0)
			 {
				 mapChallanScannedCopy.put("fds", fds);
			 }
			 if (KawfMembershipFee>0)
			 {
				 mapChallanScannedCopy.put("KawfMembershipFee", KawfMembershipFee);
			 }
			 if (KsbcTrust>0)
			 {
				 mapChallanScannedCopy.put("KsbcTrust", KsbcTrust);
			 }
			 try{
			 if(who.equals("specialGeneral"))
			 {
				 mapChallanScannedCopy.put("EnrollmentFee", 6000);
				 mapChallanScannedCopy.put("miscRts", 2000);
				 }
			 else if(who.equals("specialscst")){
				 mapChallanScannedCopy.put("EnrollmentFee", 3000);
				 mapChallanScannedCopy.put("miscRts", 2000);
			 }
			 else{
				 mapChallanScannedCopy.put("EnrollmentFee", EnrollmentFee);

			 }
			 }catch(Exception e){e.printStackTrace();}
			 
			 if(miscRts>0)
			 {
				 mapChallanScannedCopy.put("miscRts", miscRts);
			 }
			 
			 Integer total=IdentityCar+EnrollmentFee+BciSubscriptio+fds+KawfMembershipFee+KsbcTrust+miscRts;
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
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.KSBC.Util.HibernateUtil;
import com.KSBC.Bean.*;
import com.KSBC.JSPRelatedFunctions.JSPRelatedFunctionsimp;

/**
 * Servlet implementation class EnrollmentNewMember
 */

public class EnrollmentNewMember
  extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  
  public EnrollmentNewMember() {}
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    response.getWriter().append("Served at: ").append(request.getContextPath());
  }
  

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    int CertificateVerificationFee = 0;
    int BeanSaveId = 0;
    int ReceiptId = 0;
    try
    {
      CertificateVerificationFee = Integer.parseInt(request.getParameter("CertificateVerificationFee"));

    }
    catch (Exception e)
    {
      e.printStackTrace();
      CertificateVerificationFee = 0;
    }
    String who = "";
    System.out.println("*********************** Hi  **********************************");
    response.setContentType("text/html");
    
    LocalDate today1 = LocalDate.now();
    String category1 = request.getParameter("categoryID");
    String KARNumber = request.getParameter("KARNumber");
    if (KARNumber == null)
    {
      KARNumber = "";
    }
    HttpSession Servletsession = request.getSession(false);
    if (Servletsession == null)
    {
      Servletsession = request.getSession(true);
    }
    
    String Operator = (String)Servletsession.getAttribute("UserName");
    
    System.out.println(Operator + " Operator");
    

    java.util.Date date = java.sql.Date.from(today1.atStartOfDay()
      .atZone(ZoneId.systemDefault()).toInstant());
    Timestamp timeStamp = new Timestamp(date.getTime());
    PrintWriter out = response.getWriter();
    
    LocalDate today = LocalDate.now();
    Session Session = HibernateUtil.getSessionFactory().openSession();
    Transaction Tx = Session.beginTransaction();
    LinkedHashMap<String, Integer> mapChallanScannedCopy = new LinkedHashMap();
    String DDDate = request.getParameter("DDDate");
    System.out.println(DDDate + "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&    DD Date");
    System.out.println("coming");
    int EnrollmentFee = 0;
    try
    {
      EnrollmentFee = Integer.parseInt(request.getParameter("category"));

    }
    catch (Exception e)
    {
      e.printStackTrace();
      EnrollmentFee = 0;
    }
    

    System.out.println(EnrollmentFee);
    if (EnrollmentFee == 8000) {
      who = "specialGeneral";System.out.println(who);
    }
    else if (EnrollmentFee == 5000) {
      who = "specialscst";
    }
    



    int IdentityCar = Integer.parseInt(request.getParameter("identityCard"));
    System.out.println(IdentityCar);
    int miscRts = Integer.parseInt(request.getParameter("miscRts"));
    System.out.println(miscRts);
    int KsbcTrust = Integer.parseInt(request.getParameter("KsbcTrust"));
    System.out.println(KsbcTrust);
    
    int KawfMembershipFee = 0;
    try
    {
      KawfMembershipFee = Integer.parseInt(request.getParameter("KawfMembershipFee"));
      
      System.out.println(KawfMembershipFee);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    
    int BciSubscriptio = Integer.parseInt(request.getParameter("BciSubscription"));
    System.out.println(BciSubscriptio);
    int fds = 0;
    try {
      fds = Integer.parseInt(request.getParameter("fds"));
      System.out.println(fds);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    
    System.out.println(fds);
    

    String Name = request.getParameter("Name");
    
    String BankName = request.getParameter("BankName");
    String BranchName = request.getParameter("BranchName");
    String Place = request.getParameter("Place");
    
    String DDNumber = request.getParameter("DDNumber");
    
    EnrollmentNewMemberBean enrollmentNewMember = new EnrollmentNewMemberBean();
    if (EnrollmentFee > 0)
    {
      enrollmentNewMember.setCertificateVerificationFee(2500);
      enrollmentNewMember.setFds(3000);
      enrollmentNewMember.setKawfMembershipFee(2050);
      enrollmentNewMember.setBciSubscription(BciSubscriptio);
      if (EnrollmentFee == 8000) {
        enrollmentNewMember.setMiscRts(2000);
        enrollmentNewMember.setEnrollmentFee(6000);
      }
      else if (EnrollmentFee == 5000) {
        enrollmentNewMember.setMiscRts(2000);
        enrollmentNewMember.setEnrollmentFee(3000);
      }
      else
      {
        enrollmentNewMember.setMiscRts(0);
        enrollmentNewMember.setEnrollmentFee(EnrollmentFee);
      }
      
      enrollmentNewMember.setIdentityCard(IdentityCar);
      
      enrollmentNewMember.setKsbcTrust(KsbcTrust);
      enrollmentNewMember.setChallanCreatedDate(timeStamp);
    }
    else
    {
      enrollmentNewMember.setEnrollmentFee(EnrollmentFee);
      enrollmentNewMember.setBciSubscription(BciSubscriptio);
      enrollmentNewMember.setFds(fds);
      enrollmentNewMember.setIdentityCard(IdentityCar);
      enrollmentNewMember.setKawfMembershipFee(KawfMembershipFee);
      enrollmentNewMember.setKsbcTrust(KsbcTrust);
      enrollmentNewMember.setMiscRts(miscRts);
      enrollmentNewMember.setChallanCreatedDate(timeStamp);
      
      enrollmentNewMember.setCertificateVerificationFee(CertificateVerificationFee);
    }
    
    String timeStamp1 = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
    
    if (EnrollmentFee > 0)
    {
      BeanSaveId = ((Integer)Session.save(enrollmentNewMember)).intValue();
      CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
      CashSectionMonthlyReport CashSectionMonthlyReport = new CashSectionMonthlyReport();
      CashSectionMonthlyReportFlow.setAmount(EnrollmentFee + 3000 + 2050 + 2500);
      CashSectionMonthlyReportFlow.setKAWF(2050);
      CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
      CashSectionMonthlyReportFlow.setBCIAWF(0);
      
      CashSectionMonthlyReportFlow.setParticulars("Enrollment Fee");
      String category = request.getParameter("categoryID");
      if (("DD".equalsIgnoreCase(category)) || ("DD".equalsIgnoreCase(category)))
      {

        System.out.println("DD Is Coming");
        
        CashSectionMonthlyReport.setPaymode("BankName:" + BankName + "\nBranchName:" + BranchName + "\nDDNumber:" + DDNumber + "\nDD Date:" + DDDate);

      }
      else
      {
        CashSectionMonthlyReportFlow.setPaymode("Cash");
      }
      
      CashSectionMonthlyReport.setEnrollNo(KARNumber);
      CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
      
      CashSectionMonthlyReportFlow.setEntFee(EnrollmentFee);
      CashSectionMonthlyReportFlow.setFDS(3000);
      CashSectionMonthlyReportFlow.setIC(0);
      CashSectionMonthlyReportFlow.setKLA(0);
      CashSectionMonthlyReportFlow.setMisc(2500);
      CashSectionMonthlyReportFlow.setPlace(Place);
      CashSectionMonthlyReportFlow.setSTAMP(0);
      System.out.println(" Persist  #####################################");
      
      CashSectionMonthlyReport.setAmount(EnrollmentFee + 2050 + 3000 + 2500);
      CashSectionMonthlyReport.setKAWF(2050);
      CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
      CashSectionMonthlyReport.setBCIAWF(0);
      
      CashSectionMonthlyReport.setParticulars("Enrollment Fee");
      if (("DD".equalsIgnoreCase(category)) || ("DD".equalsIgnoreCase(category)))
      {

        System.out.println("DD Is Coming");
        
        CashSectionMonthlyReport.setPaymode("BankName:" + BankName + "\nBranchName:" + BranchName + "\nDDNumber:" + DDNumber + "\nDD Date:" + DDDate);
      }
      else
      {
        CashSectionMonthlyReport.setPaymode("Cash");
      }
      


      if (("DD".equalsIgnoreCase(category)) || ("DD".equalsIgnoreCase(category)))
      {

        System.out.println("DD Is Coming");
        
        CashSectionMonthlyReport.setPaymode("BankName:" + BankName + "\nBranchName:" + BranchName + "\nDDNumber:" + DDNumber + "\nDD Date:" + DDDate);
      }
      else {
        CashSectionMonthlyReport.setPaymode("Cash");
      }
      
      CashSectionMonthlyReport.setBCIAWF(0);
      CashSectionMonthlyReport.setEntFee(EnrollmentFee);
      CashSectionMonthlyReport.setFDS(3000);
      CashSectionMonthlyReport.setIC(0);
      CashSectionMonthlyReport.setKLA(0);
      CashSectionMonthlyReport.setMisc(2500);
      CashSectionMonthlyReport.setPlace(Place);
      CashSectionMonthlyReport.setSTAMP(0);
      CashSectionMonthlyReport.setEnrollNo(KARNumber);
      CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
      CashSectionMonthlyReport.setOperator(Operator);
      CashSectionMonthlyReportFlow.setOperator(Operator);
      CashSectionMonthlyReportFlow.setName(Name);
      CashSectionMonthlyReport.setName(Name);
      
      try
      {
        if ((EnrollmentFee != 5000) && (EnrollmentFee != 8000))
        {
          Serializable Id1 = Session.save(CashSectionMonthlyReport);
          ReceiptId = ((Integer)Id1).intValue();
          Session.save(CashSectionMonthlyReportFlow);
          System.out.println(ReceiptId + "   " + Id1 + "ID for Receipt");
          
          Session.beginTransaction().commit();
        }
        else
        {
          System.out.println("Do nothing");
        }
      }
      catch (Exception e)
      {
        System.out.println("Error");
        

        e.printStackTrace();
      }
      


      if (CertificateVerificationFee > 0)
      {

        mapChallanScannedCopy.put("Enrollment Fee", Integer.valueOf(EnrollmentFee));
        
        mapChallanScannedCopy.put("KAWF", Integer.valueOf(2050));
        mapChallanScannedCopy.put("FDS", Integer.valueOf(3000));
        mapChallanScannedCopy.put("Cert. Veri. Fee", Integer.valueOf(2500));
      }
      else
      {
        mapChallanScannedCopy.put("Enrollment Fee", Integer.valueOf(EnrollmentFee));
        
        mapChallanScannedCopy.put("KAWF", Integer.valueOf(2050));
        mapChallanScannedCopy.put("FDS", Integer.valueOf(3000));
      }
    }
    

    if (IdentityCar > 0)
    {
      BeanSaveId = ((Integer)Session.save(enrollmentNewMember)).intValue();
      
      CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
      CashSectionMonthlyReport CashSectionMonthlyReport = new CashSectionMonthlyReport();
      CashSectionMonthlyReportFlow.setAmount(IdentityCar);
      CashSectionMonthlyReportFlow.setKAWF(0);
      CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
      CashSectionMonthlyReportFlow.setBCIAWF(0);
      
      CashSectionMonthlyReportFlow.setParticulars("Identity Card");
      String category = request.getParameter("categoryID");
      CashSectionMonthlyReport.setEnrollNo(KARNumber);
      CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
      if (("DD".equalsIgnoreCase(category)) || ("DD".equalsIgnoreCase(category)))
      {

        System.out.println("DD Is Coming");
        
        CashSectionMonthlyReport.setPaymode("BankName:" + BankName + "\nBranchName:" + BranchName + "\nDDNumber:" + DDNumber + "\nDD Date:" + DDDate);
      }
      else {
        CashSectionMonthlyReport.setPaymode("Cash");
      }
      

      CashSectionMonthlyReportFlow.setEntFee(0);
      CashSectionMonthlyReportFlow.setFDS(0);
      CashSectionMonthlyReportFlow.setIC(IdentityCar);
      CashSectionMonthlyReportFlow.setKLA(0);
      CashSectionMonthlyReportFlow.setMisc(0);
      CashSectionMonthlyReportFlow.setPlace(Place);
      CashSectionMonthlyReportFlow.setSTAMP(0);
      System.out.println(" Persist  #####################################");
      
      CashSectionMonthlyReport.setAmount(IdentityCar);
      CashSectionMonthlyReport.setKAWF(0);
      CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
      CashSectionMonthlyReport.setBCIAWF(0);
      
      CashSectionMonthlyReport.setParticulars("Identity Card");
      category = request.getParameter("category");
      if (("DD".equalsIgnoreCase(category)) || ("DD".equalsIgnoreCase(category)))
      {

        System.out.println("DD Is Coming");
        
        CashSectionMonthlyReportFlow.setPaymode("BankName:" + BankName + "\nBranchName:" + BranchName + "\nDDNumber:" + DDNumber + "\nDD Date:" + DDDate);
      }
      else {
        CashSectionMonthlyReportFlow.setPaymode("Cash");
      }
      
      CashSectionMonthlyReport.setBCIAWF(0);
      CashSectionMonthlyReport.setEntFee(0);
      CashSectionMonthlyReport.setFDS(0);
      CashSectionMonthlyReport.setIC(IdentityCar);
      CashSectionMonthlyReport.setKLA(0);
      CashSectionMonthlyReport.setMisc(0);
      CashSectionMonthlyReport.setPlace(Place);
      CashSectionMonthlyReport.setSTAMP(0);
      CashSectionMonthlyReport.setOperator(Operator);
      CashSectionMonthlyReportFlow.setOperator(Operator);
      CashSectionMonthlyReportFlow.setName(Name);
      CashSectionMonthlyReport.setName(Name);
      
      try
      {
        Serializable Id1 = Session.save(CashSectionMonthlyReport);
        ReceiptId = ((Integer)Id1).intValue();
        Session.save(CashSectionMonthlyReportFlow);
        System.out.println(ReceiptId + "   " + Id1 + "ID for Receipt");
        Session.beginTransaction().commit();
      }
      catch (Exception e)
      {
        System.out.println("Error");
        

        e.printStackTrace();
      }
      



      mapChallanScannedCopy.put("Identity Card", Integer.valueOf(IdentityCar));
    }
    

    if (BciSubscriptio > 0)
    {
      BeanSaveId = ((Integer)Session.save(enrollmentNewMember)).intValue();
      CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
      CashSectionMonthlyReport CashSectionMonthlyReport = new CashSectionMonthlyReport();
      CashSectionMonthlyReportFlow.setAmount(BciSubscriptio);
      CashSectionMonthlyReportFlow.setKAWF(0);
      CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
      CashSectionMonthlyReportFlow.setBCIAWF(BciSubscriptio);
      CashSectionMonthlyReport.setEnrollNo(KARNumber);
      CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
      
      CashSectionMonthlyReportFlow.setParticulars("Bci Subscription Fee");
      String category = request.getParameter("categoryID");
      if (("DD".equalsIgnoreCase(category)) || ("DD".equalsIgnoreCase(category)))
      {

        System.out.println("DD Is Coming");
        
        CashSectionMonthlyReport.setPaymode("BankName:" + BankName + "\nBranchName:" + BranchName + "\nDDNumber:" + DDNumber + "\nDD Date:" + DDDate);
      }
      else {
        CashSectionMonthlyReportFlow.setPaymode("Cash");
      }
      

      CashSectionMonthlyReportFlow.setEntFee(0);
      CashSectionMonthlyReportFlow.setFDS(0);
      CashSectionMonthlyReportFlow.setIC(0);
      CashSectionMonthlyReportFlow.setKLA(0);
      CashSectionMonthlyReportFlow.setMisc(0);
      CashSectionMonthlyReportFlow.setPlace(Place);
      CashSectionMonthlyReportFlow.setSTAMP(0);
      System.out.println(" Persist  #####################################");
      
      CashSectionMonthlyReport.setAmount(BciSubscriptio);
      CashSectionMonthlyReport.setKAWF(0);
      CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
      CashSectionMonthlyReport.setBCIAWF(BciSubscriptio);
      
      CashSectionMonthlyReport.setParticulars("Bci Subscription Fee");
      if (("DD".equalsIgnoreCase(category)) || ("DD".equalsIgnoreCase(category)))
      {

        System.out.println("DD Is Coming");
        
        CashSectionMonthlyReport.setPaymode("BankName:" + BankName + "\nBranchName:" + BranchName + "\nDDNumber:" + DDNumber + "\nDD Date:" + DDDate + "\n");
      }
      else {
        CashSectionMonthlyReport.setPaymode("Cash");
      }
      


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
      

      try
      {
        Serializable Id1 = Session.save(CashSectionMonthlyReport);
        ReceiptId = ((Integer)Id1).intValue();
        Session.save(CashSectionMonthlyReportFlow);
        System.out.println(ReceiptId + "   " + Id1 + "ID for Receipt");
        Session.beginTransaction().commit();
      }
      catch (Exception e)
      {
        System.out.println("Error");
        

        e.printStackTrace();
      }
      


      mapChallanScannedCopy.put("BCI Subscription", Integer.valueOf(BciSubscriptio));
    }
    


    if (fds > 0)
    {
      BeanSaveId = ((Integer)Session.save(enrollmentNewMember)).intValue();
      CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
      CashSectionMonthlyReport CashSectionMonthlyReport = new CashSectionMonthlyReport();
      CashSectionMonthlyReportFlow.setAmount(fds);
      CashSectionMonthlyReportFlow.setKAWF(0);
      CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
      CashSectionMonthlyReportFlow.setBCIAWF(0);
      CashSectionMonthlyReport.setEnrollNo(KARNumber);
      CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
      
      CashSectionMonthlyReportFlow.setParticulars("fds");
      String category = request.getParameter("categoryID");
      if (("DD".equalsIgnoreCase(category)) || ("DD".equalsIgnoreCase(category)))
      {

        System.out.println("DD Is Coming");
        
        CashSectionMonthlyReport.setPaymode("BankName:" + BankName + "\nBranchName:" + BranchName + "\nDDNumber:" + DDNumber + "\nDD Date:" + DDDate);
      }
      else {
        CashSectionMonthlyReportFlow.setPaymode("Cash");
      }
      

      CashSectionMonthlyReportFlow.setEntFee(0);
      CashSectionMonthlyReportFlow.setFDS(fds);
      CashSectionMonthlyReportFlow.setIC(0);
      CashSectionMonthlyReportFlow.setKLA(0);
      CashSectionMonthlyReportFlow.setMisc(0);
      CashSectionMonthlyReportFlow.setPlace(Place);
      CashSectionMonthlyReportFlow.setSTAMP(0);
      System.out.println(" Persist  #####################################");
      
      CashSectionMonthlyReport.setAmount(fds);
      CashSectionMonthlyReport.setKAWF(0);
      CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
      CashSectionMonthlyReport.setBCIAWF(0);
      
      CashSectionMonthlyReport.setParticulars("fds");
      if (("DD".equalsIgnoreCase(category)) || ("DD".equalsIgnoreCase(category)))
      {

        System.out.println("DD Is Coming");
        
        CashSectionMonthlyReport.setPaymode("BankName:" + BankName + "\nBranchName:" + BranchName + "\nDDNumber:" + DDNumber + "\nDD Date:" + DDDate);
      }
      else {
        CashSectionMonthlyReport.setPaymode("Cash");
      }
      
      CashSectionMonthlyReport.setBCIAWF(0);
      CashSectionMonthlyReport.setEntFee(0);
      CashSectionMonthlyReport.setFDS(fds);
      CashSectionMonthlyReport.setIC(0);
      CashSectionMonthlyReport.setKLA(0);
      CashSectionMonthlyReport.setMisc(0);
      CashSectionMonthlyReport.setPlace(Place);
      CashSectionMonthlyReport.setSTAMP(0);
      CashSectionMonthlyReport.setOperator(Operator);
      CashSectionMonthlyReportFlow.setOperator(Operator);
      CashSectionMonthlyReportFlow.setName(Name);
      CashSectionMonthlyReport.setName(Name);
      
      try
      {
        Serializable Id1 = Session.save(CashSectionMonthlyReport);
        ReceiptId = ((Integer)Id1).intValue();
        Session.save(CashSectionMonthlyReportFlow);
        System.out.println(ReceiptId + "   " + Id1 + "ID for Receipt");
        Session.beginTransaction().commit();
      }
      catch (Exception e)
      {
        System.out.println("Error");
        

        e.printStackTrace();
      }
      


      mapChallanScannedCopy.put("FDS", Integer.valueOf(fds));
    }
    

    if (KawfMembershipFee > 0)
    {

      BeanSaveId = ((Integer)Session.save(enrollmentNewMember)).intValue();
      CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
      CashSectionMonthlyReport CashSectionMonthlyReport = new CashSectionMonthlyReport();
      CashSectionMonthlyReportFlow.setAmount(KawfMembershipFee);
      CashSectionMonthlyReportFlow.setKAWF(KawfMembershipFee);
      CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
      CashSectionMonthlyReportFlow.setBCIAWF(0);
      
      CashSectionMonthlyReport.setEnrollNo(KARNumber);
      CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
      CashSectionMonthlyReportFlow.setParticulars("Kawf Membership Fee");
      

      CashSectionMonthlyReportFlow.setEntFee(0);
      CashSectionMonthlyReportFlow.setFDS(0);
      CashSectionMonthlyReportFlow.setIC(0);
      CashSectionMonthlyReportFlow.setKLA(0);
      CashSectionMonthlyReportFlow.setMisc(0);
      CashSectionMonthlyReportFlow.setPlace(Place);
      CashSectionMonthlyReportFlow.setSTAMP(0);
      System.out.println(" Persist  #####################################");
      
      CashSectionMonthlyReport.setAmount(KawfMembershipFee);
      CashSectionMonthlyReport.setKAWF(KawfMembershipFee);
      CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
      CashSectionMonthlyReport.setBCIAWF(0);
      
      CashSectionMonthlyReport.setParticulars("Kawf Membership Fee");
      String category = request.getParameter("categoryID");
      if (("DD".equalsIgnoreCase(category)) || ("DD".equalsIgnoreCase(category)))
      {

        System.out.println("DD Is Coming");
        
        CashSectionMonthlyReport.setPaymode("BankName:" + BankName + "\nBranchName:" + BranchName + "\nDDNumber:" + DDNumber + "\nDD Date:" + DDDate);
      }
      else {
        CashSectionMonthlyReportFlow.setPaymode("Cash");
      }
      

      if (("DD".equalsIgnoreCase(category)) || ("DD".equalsIgnoreCase(category)))
      {

        System.out.println("DD Is Coming");
        
        CashSectionMonthlyReport.setPaymode("BankName:" + BankName + "\nBranchName:" + BranchName + "\nDDNumber:" + DDNumber + "\nDD Date:" + DDDate);
      }
      else {
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
      
      try
      {
        Serializable Id1 = Session.save(CashSectionMonthlyReport);
        ReceiptId = ((Integer)Id1).intValue();
        Session.save(CashSectionMonthlyReportFlow);
        System.out.println(ReceiptId + "   " + Id1 + "ID for Receipt");
        Session.beginTransaction().commit();
      }
      catch (Exception e)
      {
        System.out.println("Error");
        

        e.printStackTrace();
      }
      



      mapChallanScannedCopy.put("KAWF Membership Fee", Integer.valueOf(KawfMembershipFee));
    }
    

    if (KsbcTrust > 0)
    {
      BeanSaveId = ((Integer)Session.save(enrollmentNewMember)).intValue();
      CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
      CashSectionMonthlyReport CashSectionMonthlyReport = new CashSectionMonthlyReport();
      CashSectionMonthlyReportFlow.setAmount(KsbcTrust);
      CashSectionMonthlyReportFlow.setKAWF(0);
      
      CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
      CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
      CashSectionMonthlyReportFlow.setBCIAWF(0);
      
      CashSectionMonthlyReportFlow.setParticulars("Ksbc Trust Fee");
      

      CashSectionMonthlyReportFlow.setEntFee(0);
      CashSectionMonthlyReportFlow.setFDS(0);
      CashSectionMonthlyReportFlow.setIC(0);
      CashSectionMonthlyReportFlow.setKLA(0);
      CashSectionMonthlyReportFlow.setMisc(KsbcTrust);
      CashSectionMonthlyReportFlow.setPlace(Place);
      CashSectionMonthlyReportFlow.setSTAMP(0);
      System.out.println(" Persist  #####################################");
      
      CashSectionMonthlyReport.setAmount(KsbcTrust);
      CashSectionMonthlyReport.setKAWF(0);
      CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
      CashSectionMonthlyReport.setBCIAWF(0);
      CashSectionMonthlyReport.setEnrollNo(KARNumber);
      CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
      
      CashSectionMonthlyReport.setParticulars("Ksbc Trust ");
      String category = request.getParameter("categoryID");
      if (("DD".equalsIgnoreCase(category)) || ("DD".equalsIgnoreCase(category)))
      {

        System.out.println("DD Is Coming");
        
        CashSectionMonthlyReport.setPaymode("BankName:" + BankName + "\nBranchName:" + BranchName + "\nDDNumber:" + DDNumber + "\nDD Date:" + DDDate);
      }
      else {
        CashSectionMonthlyReportFlow.setPaymode("Cash");
      }
      

      if (("DD".equalsIgnoreCase(category)) || ("DD".equalsIgnoreCase(category)))
      {

        System.out.println("DD Is Coming");
        
        CashSectionMonthlyReport.setPaymode("BankName:" + BankName + "\nBranchName:" + BranchName + "\nDDNumber:" + DDNumber + "\nDD Date:" + DDDate);
      }
      else {
        CashSectionMonthlyReport.setPaymode("Cash");
      }
      
      CashSectionMonthlyReport.setBCIAWF(0);
      CashSectionMonthlyReport.setEntFee(0);
      CashSectionMonthlyReport.setFDS(0);
      CashSectionMonthlyReport.setIC(0);
      CashSectionMonthlyReport.setKLA(0);
      CashSectionMonthlyReport.setMisc(KsbcTrust);
      CashSectionMonthlyReport.setPlace(Place);
      CashSectionMonthlyReport.setSTAMP(0);
      CashSectionMonthlyReport.setOperator(Operator);
      CashSectionMonthlyReportFlow.setOperator(Operator);
      CashSectionMonthlyReportFlow.setName(Name);
      CashSectionMonthlyReport.setName(Name);
      

      try
      {
        Serializable Id1 = Session.save(CashSectionMonthlyReport);
        ReceiptId = ((Integer)Id1).intValue();
        Session.save(CashSectionMonthlyReportFlow);
        System.out.println(ReceiptId + "   " + Id1 + "ID for Receipt");
        Session.beginTransaction().commit();
      }
      catch (Exception e)
      {
        System.out.println("Error");
        

        e.printStackTrace();
      }
      


      mapChallanScannedCopy.put("KSBC Trust", Integer.valueOf(KsbcTrust));
    }
    
    try
    {
      if (who.equals("specialGeneral"))
      {

        BeanSaveId = ((Integer)Session.save(enrollmentNewMember)).intValue();
        CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
        CashSectionMonthlyReport CashSectionMonthlyReport = new CashSectionMonthlyReport();
        CashSectionMonthlyReportFlow.setAmount(13050);
        CashSectionMonthlyReportFlow.setKAWF(2050);
        CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
        CashSectionMonthlyReportFlow.setBCIAWF(0);
        
        CashSectionMonthlyReportFlow.setParticulars(" Special General Enrollment Fee");
        CashSectionMonthlyReportFlow.setPaymode("Offline");
        
        CashSectionMonthlyReportFlow.setEntFee(6000);
        CashSectionMonthlyReport.setEnrollNo(KARNumber);
        CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
        CashSectionMonthlyReportFlow.setFDS(3000);
        CashSectionMonthlyReportFlow.setIC(0);
        CashSectionMonthlyReportFlow.setKLA(0);
        CashSectionMonthlyReportFlow.setMisc(2000);
        CashSectionMonthlyReportFlow.setPlace(Place);
        CashSectionMonthlyReportFlow.setSTAMP(0);
        System.out.println(" Persist  Jaggga   #####################################");
        
        CashSectionMonthlyReport.setAmount(15550);
        CashSectionMonthlyReport.setKAWF(2050);
        CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
        CashSectionMonthlyReport.setBCIAWF(0);
        
        CashSectionMonthlyReport.setParticulars("Special General Enrollment Fee");
        String category = request.getParameter("categoryID");
        if (("DD".equalsIgnoreCase(category)) || ("DD".equalsIgnoreCase(category)))
        {

          System.out.println("DD Is Coming");
          
          CashSectionMonthlyReport.setPaymode("BankName:" + BankName + "\nBranchName:" + BranchName + "\nDDNumber:" + DDNumber + "\nDD Date:" + DDDate);
        }
        else {
          CashSectionMonthlyReport.setPaymode("Cash");
        }
        
        CashSectionMonthlyReport.setBCIAWF(0);
        CashSectionMonthlyReport.setEntFee(6000);
        CashSectionMonthlyReport.setFDS(3000);
        CashSectionMonthlyReport.setIC(0);
        CashSectionMonthlyReport.setKLA(0);
        CashSectionMonthlyReport.setMisc(4500);
        CashSectionMonthlyReport.setPlace(Place);
        CashSectionMonthlyReport.setSTAMP(0);
        CashSectionMonthlyReport.setOperator(Operator);
        CashSectionMonthlyReportFlow.setOperator(Operator);
        CashSectionMonthlyReportFlow.setName(Name);
        CashSectionMonthlyReport.setName(Name);
        


        try
        {
          Serializable Id1 = Session.save(CashSectionMonthlyReport);
          ReceiptId = ((Integer)Id1).intValue();
          Session.save(CashSectionMonthlyReportFlow);
          System.out.println(ReceiptId + "   " + Id1 + "ID for Receipt");
          Session.beginTransaction().commit();
        }
        catch (Exception e)
        {
          System.out.println("Error");
          

          e.printStackTrace();
        }
        



        if (CertificateVerificationFee > 0)
        {

          mapChallanScannedCopy.put("Enrollment Fee", Integer.valueOf(6000));
          mapChallanScannedCopy.put("KAWF", Integer.valueOf(2050));
          mapChallanScannedCopy.put("FDS", Integer.valueOf(3000));
          mapChallanScannedCopy.put("Cert. Veri. Fee", Integer.valueOf(2500));
          mapChallanScannedCopy.put("Misc", Integer.valueOf(2000));
        }
        else
        {
          mapChallanScannedCopy.put("Enrollment Fee", Integer.valueOf(6000));
          mapChallanScannedCopy.put("KAWF", Integer.valueOf(2050));
          mapChallanScannedCopy.put("FDS", Integer.valueOf(3000));
          
          mapChallanScannedCopy.put("Misc", Integer.valueOf(2000));
        }
      }
      else if (who.equals("specialscst"))
      {
        BeanSaveId = ((Integer)Session.save(enrollmentNewMember)).intValue();
        
        CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
        CashSectionMonthlyReport CashSectionMonthlyReport = new CashSectionMonthlyReport();
        CashSectionMonthlyReportFlow.setAmount(10050);
        CashSectionMonthlyReportFlow.setKAWF(2050);
        CashSectionMonthlyReport.setEnrollNo(KARNumber);
        CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
        CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
        CashSectionMonthlyReportFlow.setBCIAWF(0);
        
        CashSectionMonthlyReportFlow.setParticulars(" Special sc/st Enrollment Fee");
        String category = request.getParameter("categoryID");
        if (("DD".equalsIgnoreCase(category)) || ("DD".equalsIgnoreCase(category)))
        {

          System.out.println("DD Is Coming");
          
          CashSectionMonthlyReportFlow.setPaymode("BankName:" + BankName + "\nBranchName:" + BranchName + "\nDDNumber:" + DDNumber + "\nDD Date:" + DDDate);
        }
        else
        {
          CashSectionMonthlyReportFlow.setPaymode("Cash");
        }
        

        CashSectionMonthlyReportFlow.setEntFee(3000);
        CashSectionMonthlyReportFlow.setFDS(3000);
        CashSectionMonthlyReportFlow.setIC(0);
        CashSectionMonthlyReportFlow.setKLA(0);
        CashSectionMonthlyReportFlow.setMisc(2000);
        CashSectionMonthlyReportFlow.setPlace(Place);
        CashSectionMonthlyReport.setEnrollNo(KARNumber);
        CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
        CashSectionMonthlyReportFlow.setSTAMP(0);
        System.out.println(" Persist  #####################################");
        
        CashSectionMonthlyReport.setAmount(12550);
        CashSectionMonthlyReport.setKAWF(2050);
        CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
        CashSectionMonthlyReport.setBCIAWF(0);
        CashSectionMonthlyReport.setEnrollNo("New Enroll");
        CashSectionMonthlyReport.setParticulars("Special sc/st Enrollment Fee");
        if (("DD".equalsIgnoreCase(category)) || ("DD".equalsIgnoreCase(category)))
        {

          System.out.println("DD Is Coming");
          
          CashSectionMonthlyReport.setPaymode("BankName:" + BankName + "\nBranchName:" + BranchName + "\nDDNumber:" + DDNumber + "\nDD Date:" + DDDate);
        }
        else {
          CashSectionMonthlyReport.setPaymode("Cash");
        }
        
        CashSectionMonthlyReport.setBCIAWF(0);
        CashSectionMonthlyReport.setEntFee(3000);
        CashSectionMonthlyReport.setFDS(3000);
        CashSectionMonthlyReport.setEnrollNo(KARNumber);
        CashSectionMonthlyReport.setIC(0);
        CashSectionMonthlyReport.setKLA(0);
        CashSectionMonthlyReport.setMisc(4500);
        CashSectionMonthlyReport.setPlace(Place);
        CashSectionMonthlyReport.setSTAMP(0);
        CashSectionMonthlyReport.setOperator(Operator);
        CashSectionMonthlyReportFlow.setOperator(Operator);
        CashSectionMonthlyReportFlow.setName(Name);
        CashSectionMonthlyReport.setName(Name);
        


        try
        {
          Serializable Id1 = Session.save(CashSectionMonthlyReport);
          ReceiptId = ((Integer)Id1).intValue();
          Session.save(CashSectionMonthlyReportFlow);
          System.out.println(ReceiptId + "   " + Id1 + "ID for Receipt");
          Session.beginTransaction().commit();
        }
        catch (Exception e)
        {
          System.out.println("Error");
          

          e.printStackTrace();
        }
        

        if (CertificateVerificationFee > 0)
        {
          mapChallanScannedCopy.put("Enrollment Fee", Integer.valueOf(3000));
          mapChallanScannedCopy.put("KAWF", Integer.valueOf(2050));
          mapChallanScannedCopy.put("FDS", Integer.valueOf(3000));
          mapChallanScannedCopy.put("Cert. Veri. Fee", Integer.valueOf(2500));
          mapChallanScannedCopy.put("Misc", Integer.valueOf(2000));
        }
        else
        {
          mapChallanScannedCopy.put("Enrollment Fee", Integer.valueOf(3000));
          mapChallanScannedCopy.put("KAWF", Integer.valueOf(2050));
          mapChallanScannedCopy.put("FDS", Integer.valueOf(3000));
          
          mapChallanScannedCopy.put("Misc", Integer.valueOf(2000));

        }
        

      }
      


    }
    catch (Exception e)
    {

      e.printStackTrace();
    }
    

    if (miscRts > 0)
    {

      BeanSaveId = ((Integer)Session.save(enrollmentNewMember)).intValue();
      CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
      CashSectionMonthlyReport CashSectionMonthlyReport = new CashSectionMonthlyReport();
      CashSectionMonthlyReportFlow.setAmount(miscRts);
      CashSectionMonthlyReportFlow.setKAWF(0);
      CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
      CashSectionMonthlyReportFlow.setBCIAWF(0);
      CashSectionMonthlyReport.setEnrollNo(KARNumber);
      CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
      
      CashSectionMonthlyReportFlow.setParticulars("misc Rts");
      String category = request.getParameter("categoryID");
      if (("DD".equalsIgnoreCase(category)) || ("DD".equalsIgnoreCase(category)))
      {

        System.out.println("DD Is Coming");
        
        CashSectionMonthlyReportFlow.setPaymode("BankName:" + BankName + "\nBranchName:" + BranchName + "\nDDNumber:" + DDNumber + "\nDD Date:" + DDDate);

      }
      else
      {
        CashSectionMonthlyReportFlow.setPaymode("Cash");
      }
      

      CashSectionMonthlyReportFlow.setEntFee(0);
      CashSectionMonthlyReportFlow.setFDS(0);
      CashSectionMonthlyReportFlow.setIC(0);
      CashSectionMonthlyReportFlow.setKLA(0);
      CashSectionMonthlyReportFlow.setMisc(miscRts);
      CashSectionMonthlyReportFlow.setPlace(Place);
      CashSectionMonthlyReportFlow.setSTAMP(0);
      System.out.println(" Persist  #####################################");
      
      CashSectionMonthlyReport.setAmount(miscRts);
      CashSectionMonthlyReport.setKAWF(0);
      CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
      CashSectionMonthlyReport.setBCIAWF(0);
      
      CashSectionMonthlyReport.setParticulars("misc Rts");
      if (("DD".equalsIgnoreCase(category)) || ("DD".equalsIgnoreCase(category)))
      {

        System.out.println("DD Is Coming");
        
        CashSectionMonthlyReport.setPaymode("BankName:" + BankName + "\nBranchName:" + BranchName + "\nDDNumber:" + DDNumber + "\nDD Date:" + DDDate);
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
      CashSectionMonthlyReport.setMisc(miscRts);
      CashSectionMonthlyReport.setPlace(Place);
      CashSectionMonthlyReport.setSTAMP(0);
      CashSectionMonthlyReport.setOperator(Operator);
      CashSectionMonthlyReportFlow.setOperator(Operator);
      CashSectionMonthlyReportFlow.setName(Name);
      CashSectionMonthlyReport.setName(Name);
      


      try
      {
        Serializable Id1 = Session.save(CashSectionMonthlyReport);
        ReceiptId = ((Integer)Id1).intValue();
        Session.save(CashSectionMonthlyReportFlow);
        System.out.println(ReceiptId + "   " + Id1 + "ID for Receipt");
        Session.beginTransaction().commit();
      }
      catch (Exception e)
      {
        System.out.println("Error");
        

        e.printStackTrace();
      }
      



      mapChallanScannedCopy.put("Misc", Integer.valueOf(miscRts));
    }
    
    if (CertificateVerificationFee > 0)
    {
      if (EnrollmentFee <= 0)
      {


        BeanSaveId = ((Integer)Session.save(enrollmentNewMember)).intValue();
        CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
        CashSectionMonthlyReport CashSectionMonthlyReport = new CashSectionMonthlyReport();
        CashSectionMonthlyReportFlow.setAmount(CertificateVerificationFee);
        CashSectionMonthlyReportFlow.setKAWF(0);
        CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
        CashSectionMonthlyReportFlow.setBCIAWF(0);
        CashSectionMonthlyReport.setEnrollNo(KARNumber);
        CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
        
        CashSectionMonthlyReportFlow.setParticulars("Certificate Verification Fee");
        String category = request.getParameter("categoryID");
        if (("DD".equalsIgnoreCase(category)) || ("DD".equalsIgnoreCase(category)))
        {

          System.out.println("DD Is Coming");
          
          CashSectionMonthlyReportFlow.setPaymode("BankName:" + BankName + "\nBranchName:" + BranchName + "\nDDNumber:" + DDNumber + "\nDD Date:" + DDDate);
        }
        else
        {
          CashSectionMonthlyReportFlow.setPaymode("Cash");
        }
        

        CashSectionMonthlyReportFlow.setEntFee(0);
        CashSectionMonthlyReportFlow.setFDS(0);
        CashSectionMonthlyReportFlow.setIC(0);
        CashSectionMonthlyReportFlow.setKLA(0);
        CashSectionMonthlyReportFlow.setMisc(CertificateVerificationFee);
        CashSectionMonthlyReportFlow.setPlace(Place);
        CashSectionMonthlyReportFlow.setSTAMP(0);
        System.out.println(" Persist  #####################################");
        
        CashSectionMonthlyReport.setAmount(CertificateVerificationFee);
        CashSectionMonthlyReport.setKAWF(0);
        CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
        CashSectionMonthlyReport.setBCIAWF(0);
        
        CashSectionMonthlyReport.setParticulars("Certificate Verification Fee");
        if (("DD".equalsIgnoreCase(category)) || ("DD".equalsIgnoreCase(category)))
        {

          System.out.println("DD Is Coming");
          
          CashSectionMonthlyReport.setPaymode("BankName:" + BankName + "\nBranchName:" + BranchName + "\nDDNumber:" + DDNumber + "\nDD Date:" + DDDate);

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
        CashSectionMonthlyReport.setMisc(CertificateVerificationFee);
        CashSectionMonthlyReport.setPlace(Place);
        CashSectionMonthlyReport.setSTAMP(0);
        CashSectionMonthlyReport.setOperator(Operator);
        CashSectionMonthlyReportFlow.setOperator(Operator);
        CashSectionMonthlyReportFlow.setName(Name);
        CashSectionMonthlyReport.setName(Name);
        


        try
        {
          Serializable Id1 = Session.save(CashSectionMonthlyReport);
          ReceiptId = ((Integer)Id1).intValue();
          Session.save(CashSectionMonthlyReportFlow);
          System.out.println(ReceiptId + "   " + Id1 + "ID for Receipt");
          Session.beginTransaction().commit();
        }
        catch (Exception e)
        {
          System.out.println("Error");
          

          e.printStackTrace();
        }
        



        mapChallanScannedCopy.put("Certificate Verification Fee", Integer.valueOf(CertificateVerificationFee));
      }
    }
    
    Integer total = Integer.valueOf(0);
    
    if (EnrollmentFee > 0)
    {

      total = Integer.valueOf(EnrollmentFee + 2050 + 3000 + CertificateVerificationFee);

    }
    else
    {

      total = Integer.valueOf(IdentityCar + EnrollmentFee + BciSubscriptio + fds + KawfMembershipFee + KsbcTrust + miscRts + CertificateVerificationFee);
    }
    




    System.out.println("TOTAL AMOUNT::" + total);
    try
    {
      ReceiptDeleteTable ReceiptDeleteTable = new ReceiptDeleteTable();
      ReceiptDeleteTable.setChallanGenerateSLNumber(ReceiptId);
      ReceiptDeleteTable.setOperator(Operator);
      ReceiptDeleteTable.setMonthlyReportSLNumber(BeanSaveId);
      ReceiptDeleteTable.setTimeWhenDeleted(today);
      ReceiptDeleteTable.setType("Enrollment");
      Session.save(ReceiptDeleteTable);
      Session.beginTransaction().commit();
    }
    catch (Exception e)
    {
      e.printStackTrace();

    }
    finally
    {
      Session.close();
    }
    
    JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
    String responseString = JSPRelatedFunctionsimp.GenerateChallan(total, mapChallanScannedCopy, Name, timeStamp1, Place, "", ReceiptId + "", category1, "DD/Chk Number:" + DDNumber + "  DD/Chk Date:" + DDDate + "  Bank:" + BankName + "  Branch:" + BranchName);
    
    out.println(responseString);
    
    Session.close();
  }
}
/*public class EnrollmentNewMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    *//**
     * @see HttpServlet#HttpServlet()
     *//*
    public EnrollmentNewMember() {
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
		int CertificateVerificationFee=0;
		int BeanSaveId=0;
		int	 ReceiptId=0; 
		try
		{
			CertificateVerificationFee= Integer.parseInt(request.getParameter("CertificateVerificationFee"));
		}
		catch (Exception e)
		{
			
			e.printStackTrace();
			CertificateVerificationFee=0;	
		}
		 String who ="";
		System.out.println("*********************** Hi  **********************************");
		 response.setContentType("text/html");
	
		 LocalDate today1 = LocalDate.now();
		 String category1 = (String)request.getParameter("categoryID");	 
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
		    PrintWriter out = response.getWriter();
		    Serializable Id;
		    LocalDate today = LocalDate.now();
		    Session Session = HibernateUtil.getSessionFactory().openSession();
			Transaction Tx = Session.beginTransaction();
			LinkedHashMap<String, Integer> mapChallanScannedCopy = new LinkedHashMap<String, Integer>();
			 String DDDate=request.getParameter("DDDate");	
			 System.out.println(DDDate + "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&    DD Date");		
			System.out.println("coming");
		int EnrollmentFee=0;
				try
				{
				EnrollmentFee= Integer.parseInt(request.getParameter("category"));
				}
				catch (Exception e)
				{
					
					e.printStackTrace();
					EnrollmentFee=0;	
				}
				
				
		System.out.println(EnrollmentFee);
		if(EnrollmentFee==8000){
			who="specialGeneral";System.out.println(who);
		}
		else if(EnrollmentFee==5000){
			who="specialscst";
			
		}
		
		
		
		int IdentityCar = Integer.parseInt(request.getParameter("identityCard"));
		System.out.println(IdentityCar);
		int miscRts=Integer.parseInt(request.getParameter("miscRts"));
		System.out.println(miscRts);
		int KsbcTrust=Integer.parseInt(request.getParameter("KsbcTrust"));
		System.out.println(KsbcTrust);

		int KawfMembershipFee=0;
		
		try{
		 KawfMembershipFee=Integer.parseInt(request.getParameter("KawfMembershipFee"));
		
		System.out.println(KawfMembershipFee);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		int BciSubscriptio=Integer.parseInt(request.getParameter("BciSubscription"));
		System.out.println(BciSubscriptio);
		int fds=0;
		try{
		 fds=Integer.parseInt(request.getParameter("fds"));
			System.out.println(fds);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
		System.out.println(fds);
		
		
		String Name = (String)request.getParameter("Name");

		String BankName = (String)request.getParameter("BankName");
		String BranchName = (String)request.getParameter("BranchName");
		String Place= (String)request.getParameter("Place");
	
		String DDNumber = (String)request.getParameter("DDNumber");
		
		EnrollmentNewMemberBean enrollmentNewMember=new  EnrollmentNewMemberBean();
		if (EnrollmentFee>0)
		{
			enrollmentNewMember.setCertificateVerificationFee(2500);
			enrollmentNewMember.setFds(3000);
			enrollmentNewMember.setKawfMembershipFee(2050);
			enrollmentNewMember.setBciSubscription(BciSubscriptio);
			if(EnrollmentFee==8000){
				enrollmentNewMember.setMiscRts(2000);
				enrollmentNewMember.setEnrollmentFee(6000);
				}
			else if(EnrollmentFee==5000){
				enrollmentNewMember.setMiscRts(2000);
				enrollmentNewMember.setEnrollmentFee(3000);
			}
			else
			{
				enrollmentNewMember.setMiscRts(0);
				enrollmentNewMember.setEnrollmentFee(EnrollmentFee);		
			}
		
			enrollmentNewMember.setIdentityCard(IdentityCar);
			
			enrollmentNewMember.setKsbcTrust(KsbcTrust);
			enrollmentNewMember.setChallanCreatedDate(timeStamp);
		}
		else
		{
		enrollmentNewMember.setEnrollmentFee(EnrollmentFee);
		enrollmentNewMember.setBciSubscription(BciSubscriptio);
		enrollmentNewMember.setFds(fds);
		enrollmentNewMember.setIdentityCard(IdentityCar);
		enrollmentNewMember.setKawfMembershipFee(KawfMembershipFee);
		enrollmentNewMember.setKsbcTrust(KsbcTrust);
		enrollmentNewMember.setMiscRts(miscRts);
		enrollmentNewMember.setChallanCreatedDate(timeStamp);
		
		enrollmentNewMember.setCertificateVerificationFee(CertificateVerificationFee);
		}
		// timeStamp
		String timeStamp1 = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		
		if (EnrollmentFee>0)
			 {
			 BeanSaveId = (int)  Session.save(enrollmentNewMember);
			  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
			  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
			  CashSectionMonthlyReportFlow.setAmount(EnrollmentFee+3000+2050+2500);
			  CashSectionMonthlyReportFlow.setKAWF(2050);
			  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReportFlow.setBCIAWF(0);
			 // CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
			  CashSectionMonthlyReportFlow.setParticulars("Enrollment Fee");
				String category = (String)request.getParameter("categoryID");
				  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);
				  }
				  else
				  {
					  CashSectionMonthlyReportFlow.setPaymode("Cash");
						 
				  }
				  CashSectionMonthlyReport.setEnrollNo(Name);
				  CashSectionMonthlyReportFlow.setEnrollNo(Name);
			 // CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEntFee(EnrollmentFee);
			  CashSectionMonthlyReportFlow.setFDS(3000);
			  CashSectionMonthlyReportFlow.setIC(0);
			  CashSectionMonthlyReportFlow.setKLA(0);
			  CashSectionMonthlyReportFlow.setMisc(2500); // Misc
			  CashSectionMonthlyReportFlow.setPlace(Place);
			  CashSectionMonthlyReportFlow.setSTAMP(0);
			  System.out.println(" Persist  #####################################");
			  
			  CashSectionMonthlyReport.setAmount(EnrollmentFee+2050+3000);
			  CashSectionMonthlyReport.setKAWF(2050);
			  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReport.setBCIAWF(0);
			 // CashSectionMonthlyReport.setEnrollNo(KARNumber);
			  CashSectionMonthlyReport.setParticulars("Enrollment Fee");
			  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);			  }
			  else
			  {
				  CashSectionMonthlyReport.setPaymode("Cash");
					 
			  };
			  
			//  String category = (String)request.getParameter("category");
			  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);			  }
			  else
			  {
				  CashSectionMonthlyReport.setPaymode("Cash");
					 
			  };
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEntFee(EnrollmentFee);
			  CashSectionMonthlyReport.setFDS(3000);
			  CashSectionMonthlyReport.setIC(0);
			  CashSectionMonthlyReport.setKLA(0);
			  CashSectionMonthlyReport.setMisc(0);
			  CashSectionMonthlyReport.setPlace(Place);
			  CashSectionMonthlyReport.setSTAMP(0);
			  CashSectionMonthlyReport.setEnrollNo(Name);
			  CashSectionMonthlyReportFlow.setEnrollNo(Name);
			  CashSectionMonthlyReport.setOperator(Operator);
			  CashSectionMonthlyReportFlow.setOperator(Operator);  
			  CashSectionMonthlyReportFlow.setName(Name);
			  CashSectionMonthlyReport.setName(Name);
			  //Tx.begin();
			  try
			  {
				  if ((EnrollmentFee!=5000) && (EnrollmentFee!=8000))
				  {
			Serializable Id1 = Session.save(CashSectionMonthlyReport);
			ReceiptId=(int) Id1;
			Session.save(CashSectionMonthlyReportFlow);
			System.out.println(ReceiptId+ "   "+Id1  + "ID for Receipt");
			
			Session.beginTransaction().commit();
				  }
				  else
				  {
					System.out.println("Do nothing");  
				  }
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
			 
			  if (CertificateVerificationFee>0)
				 {
			 
				 mapChallanScannedCopy.put("Enrollment Fee", EnrollmentFee);
				  
				 mapChallanScannedCopy.put("KAWF",2050); 
				 mapChallanScannedCopy.put("FDS",3000);
				 mapChallanScannedCopy.put("Cert. Veri. Fee",2500);
				 }
			  else
			  {
				  mapChallanScannedCopy.put("Enrollment Fee", EnrollmentFee);
				  
					 mapChallanScannedCopy.put("KAWF",2050); 
					 mapChallanScannedCopy.put("FDS",3000);  
			  }
			 }
			 
		
		if (IdentityCar>0)
			 {
			BeanSaveId = (int)  Session.save(enrollmentNewMember);
			
			  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
			  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
			  CashSectionMonthlyReportFlow.setAmount(IdentityCar);
			  CashSectionMonthlyReportFlow.setKAWF(0);
			  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReportFlow.setBCIAWF(0);
			 // CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
			  CashSectionMonthlyReportFlow.setParticulars("Identity Card");
				String category = (String)request.getParameter("categoryID");
				 CashSectionMonthlyReport.setEnrollNo(Name);
				 CashSectionMonthlyReportFlow.setEnrollNo(Name);
			  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);			  }
			  else
			  {
				  CashSectionMonthlyReport.setPaymode("Cash");
					 
			  };;
			 // CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEntFee(0);
			  CashSectionMonthlyReportFlow.setFDS(0);
			  CashSectionMonthlyReportFlow.setIC(IdentityCar);
			  CashSectionMonthlyReportFlow.setKLA(0);
			  CashSectionMonthlyReportFlow.setMisc(0);
			  CashSectionMonthlyReportFlow.setPlace(Place);
			  CashSectionMonthlyReportFlow.setSTAMP(0);
			  System.out.println(" Persist  #####################################");
			  
			  CashSectionMonthlyReport.setAmount(IdentityCar);
			  CashSectionMonthlyReport.setKAWF(0);
			  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReport.setBCIAWF(0);
			 // CashSectionMonthlyReport.setEnrollNo(KARNumber);
			  CashSectionMonthlyReport.setParticulars("Identity Card");
				 category = (String)request.getParameter("category");
				  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);				  }
				  else
				  {
					  CashSectionMonthlyReportFlow.setPaymode("Cash");
						 
				  };
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEntFee(0);
			  CashSectionMonthlyReport.setFDS(0);
			  CashSectionMonthlyReport.setIC(IdentityCar);
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
	
			
				 mapChallanScannedCopy.put("Identity Card", IdentityCar);
			 }
			
		
		if (BciSubscriptio>0)
			 {
				BeanSaveId = (int) Session.save(enrollmentNewMember);
			  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
			  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
			  CashSectionMonthlyReportFlow.setAmount(BciSubscriptio);
			  CashSectionMonthlyReportFlow.setKAWF(0);
			  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReportFlow.setBCIAWF(BciSubscriptio);
			  CashSectionMonthlyReport.setEnrollNo(Name);
			  CashSectionMonthlyReportFlow.setEnrollNo(Name);
			 // CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
			  CashSectionMonthlyReportFlow.setParticulars("Bci Subscription Fee");
				String category = (String)request.getParameter("categoryID");
				  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);				  }
				  else
				  {
					  CashSectionMonthlyReportFlow.setPaymode("Cash");
						 
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
			  
			  CashSectionMonthlyReport.setAmount(BciSubscriptio);
			  CashSectionMonthlyReport.setKAWF(0);
			  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReport.setBCIAWF(BciSubscriptio);
			 // CashSectionMonthlyReport.setEnrollNo(KARNumber);
			  CashSectionMonthlyReport.setParticulars("Bci Subscription Fee");
			  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate +"\n");			  }
			  else
			  {
				  CashSectionMonthlyReport.setPaymode("Cash");
					 
			  }
			  
			  //repeeated********** CashSectionMonthlyReport.setBCIAWF(0);
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
	
				 mapChallanScannedCopy.put("BCI Subscription", BciSubscriptio);
				 
			 }
		
		
		if (fds>0)
			 {
				BeanSaveId = (int) Session.save(enrollmentNewMember);
			  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
			  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
			  CashSectionMonthlyReportFlow.setAmount(fds);
			  CashSectionMonthlyReportFlow.setKAWF(0);
			  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReport.setEnrollNo(Name);
			  CashSectionMonthlyReportFlow.setEnrollNo(Name);
			 // CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
			  CashSectionMonthlyReportFlow.setParticulars("fds");
				String category = (String)request.getParameter("categoryID");
				  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);				  }
				  else
				  {
					  CashSectionMonthlyReportFlow.setPaymode("Cash");
						 
				  }
			 // CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEntFee(0);
			  CashSectionMonthlyReportFlow.setFDS(fds);
			  CashSectionMonthlyReportFlow.setIC(0);
			  CashSectionMonthlyReportFlow.setKLA(0);
			  CashSectionMonthlyReportFlow.setMisc(0);
			  CashSectionMonthlyReportFlow.setPlace(Place);
			  CashSectionMonthlyReportFlow.setSTAMP(0);
			  System.out.println(" Persist  #####################################");
			  
			  CashSectionMonthlyReport.setAmount(fds);
			  CashSectionMonthlyReport.setKAWF(0);
			  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReport.setBCIAWF(0);
			 // CashSectionMonthlyReport.setEnrollNo(KARNumber);
			  CashSectionMonthlyReport.setParticulars("fds");
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
			  CashSectionMonthlyReport.setFDS(fds);
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
	
				 mapChallanScannedCopy.put("FDS", fds);
			 }
		
		
			 if (KawfMembershipFee>0)
			 {
			
					BeanSaveId = (int) Session.save(enrollmentNewMember);
				 CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
				  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
				  CashSectionMonthlyReportFlow.setAmount(KawfMembershipFee);
				  CashSectionMonthlyReportFlow.setKAWF(KawfMembershipFee);
				  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReportFlow.setBCIAWF(0);
				 // CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
				  CashSectionMonthlyReport.setEnrollNo(Name);
				  CashSectionMonthlyReportFlow.setEnrollNo(Name);
				  CashSectionMonthlyReportFlow.setParticulars("Kawf Membership Fee");
				//  CashSectionMonthlyReportFlow.setPaymode("Offline");
				 // CashSectionMonthlyReportFlow.setBCIAWF(0);
				  CashSectionMonthlyReportFlow.setEntFee(0);
				  CashSectionMonthlyReportFlow.setFDS(0);
				  CashSectionMonthlyReportFlow.setIC(0);
				  CashSectionMonthlyReportFlow.setKLA(0);
				  CashSectionMonthlyReportFlow.setMisc(0);
				  CashSectionMonthlyReportFlow.setPlace(Place);
				  CashSectionMonthlyReportFlow.setSTAMP(0);
				  System.out.println(" Persist  #####################################");
				  
				  CashSectionMonthlyReport.setAmount(KawfMembershipFee);
				  CashSectionMonthlyReport.setKAWF(KawfMembershipFee);
				  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReport.setBCIAWF(0);
				 // CashSectionMonthlyReport.setEnrollNo(KARNumber);
				  CashSectionMonthlyReport.setParticulars("Kawf Membership Fee");
					String category = (String)request.getParameter("categoryID");
					  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
					  {
						  
						  System.out.println("DD Is Coming");
						  
						  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);					  }
					  else
					  {
						  CashSectionMonthlyReportFlow.setPaymode("Cash");
							 
					  }
					  
					  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
					  {
						  
						  System.out.println("DD Is Coming");
						  
						  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);					  }
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
		
				 
				 mapChallanScannedCopy.put("KAWF Membership Fee", KawfMembershipFee);
			 }
			 
			  if (CertificateVerificationFee>0)
				 {
					
					BeanSaveId = (int) Session.save(enrollmentNewMember);
				 CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
				  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
				  CashSectionMonthlyReportFlow.setAmount(CertificateVerificationFee);
				  CashSectionMonthlyReportFlow.setKAWF(0);
				  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReportFlow.setBCIAWF(0);
				 // CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
				  CashSectionMonthlyReport.setEnrollNo(Name);
				  CashSectionMonthlyReportFlow.setEnrollNo(Name);
				  CashSectionMonthlyReportFlow.setParticulars("Kawf Membership Fee");
				//  CashSectionMonthlyReportFlow.setPaymode("Offline");
				 // CashSectionMonthlyReportFlow.setBCIAWF(0);
				  CashSectionMonthlyReportFlow.setEntFee(0);
				  CashSectionMonthlyReportFlow.setFDS(0);
				  CashSectionMonthlyReportFlow.setIC(0);
				  CashSectionMonthlyReportFlow.setKLA(0);
				  CashSectionMonthlyReportFlow.setMisc(CertificateVerificationFee);
				  CashSectionMonthlyReportFlow.setPlace(Place);
				  CashSectionMonthlyReportFlow.setSTAMP(0);
				  System.out.println(" Persist  #####################################");
				  
				  CashSectionMonthlyReport.setAmount(CertificateVerificationFee);
				  CashSectionMonthlyReport.setKAWF(0);
				  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReport.setBCIAWF(0);
				 // CashSectionMonthlyReport.setEnrollNo(KARNumber);
				  CashSectionMonthlyReport.setParticulars("Cert. Veri. Fee");
					String category = (String)request.getParameter("categoryID");
					  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
					  {
						  
						  System.out.println("DD Is Coming");
						  
						  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);					  }
					  else
					  {
						  CashSectionMonthlyReportFlow.setPaymode("Cash");
							 
					  }
					  
					  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
					  {
						  
						  System.out.println("DD Is Coming");
						  
						  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);					  }
					  else
					  {
						  CashSectionMonthlyReport.setPaymode("Cash");
							 
					  }
				  CashSectionMonthlyReport.setBCIAWF(0);
				  CashSectionMonthlyReport.setEntFee(0);
				  CashSectionMonthlyReport.setFDS(0);
				  CashSectionMonthlyReport.setIC(0);
				  CashSectionMonthlyReport.setKLA(0);
				  CashSectionMonthlyReport.setMisc(CertificateVerificationFee);
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
		 
				 
				  mapChallanScannedCopy.put("Cert. Veri. Fee",2500);
				  }
			 if (KsbcTrust>0)
			 {
				BeanSaveId = (int) Session.save(enrollmentNewMember); 
				  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
				  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
				  CashSectionMonthlyReportFlow.setAmount(KsbcTrust);
				  CashSectionMonthlyReportFlow.setKAWF(0);
				 
				  CashSectionMonthlyReportFlow.setEnrollNo(Name);
				  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReportFlow.setBCIAWF(0);
				 // CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
				  CashSectionMonthlyReportFlow.setParticulars("Ksbc Trust Fee");
			//	  CashSectionMonthlyReportFlow.setPaymode("Offline");
				 // CashSectionMonthlyReportFlow.setBCIAWF(0);
				  CashSectionMonthlyReportFlow.setEntFee(0);
				  CashSectionMonthlyReportFlow.setFDS(0);
				  CashSectionMonthlyReportFlow.setIC(0);
				  CashSectionMonthlyReportFlow.setKLA(0);
				  CashSectionMonthlyReportFlow.setMisc(KsbcTrust);
				  CashSectionMonthlyReportFlow.setPlace(Place);
				  CashSectionMonthlyReportFlow.setSTAMP(0);
				  System.out.println(" Persist  #####################################");
				  
				  CashSectionMonthlyReport.setAmount(KsbcTrust);
				  CashSectionMonthlyReport.setKAWF(0);
				  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReport.setBCIAWF(0);
				  CashSectionMonthlyReport.setEnrollNo(Name);
				  CashSectionMonthlyReportFlow.setEnrollNo(Name);
				 // CashSectionMonthlyReport.setEnrollNo(KARNumber);
				  CashSectionMonthlyReport.setParticulars("Ksbc Trust ");
					String category = (String)request.getParameter("categoryID");
					  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
					  {
						  
						  System.out.println("DD Is Coming");
						  
						  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);					  }
					  else
					  {
						  CashSectionMonthlyReportFlow.setPaymode("Cash");
							 
					  }
					  
					  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
					  {
						  
						  System.out.println("DD Is Coming");
						  
						  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);					  }
					  else
					  {
						  CashSectionMonthlyReport.setPaymode("Cash");
							 
					  }
				  CashSectionMonthlyReport.setBCIAWF(0);
				  CashSectionMonthlyReport.setEntFee(0);
				  CashSectionMonthlyReport.setFDS(0);
				  CashSectionMonthlyReport.setIC(0);
				  CashSectionMonthlyReport.setKLA(0);
				  CashSectionMonthlyReport.setMisc(KsbcTrust);
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
		
				 mapChallanScannedCopy.put("KSBC Trust", KsbcTrust);
			 }
			 
			 
			 try{
			 if(who.equals("specialGeneral"))
			 {
				 
				 	BeanSaveId = (int) Session.save(enrollmentNewMember);
				 CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
				  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
				  CashSectionMonthlyReportFlow.setAmount(8000+2050+3000);
				  CashSectionMonthlyReportFlow.setKAWF(2050);
				  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReportFlow.setBCIAWF(0);
				 // CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
				  CashSectionMonthlyReportFlow.setParticulars(" Special General Enrollment Fee");
				  CashSectionMonthlyReportFlow.setPaymode("Offline");
				 // CashSectionMonthlyReportFlow.setBCIAWF(0);
				  CashSectionMonthlyReportFlow.setEntFee(6000);
				  CashSectionMonthlyReport.setEnrollNo(Name);
				  CashSectionMonthlyReportFlow.setEnrollNo(Name);
				  CashSectionMonthlyReportFlow.setFDS(3000);
				  CashSectionMonthlyReportFlow.setIC(0);
				  CashSectionMonthlyReportFlow.setKLA(0);
				  CashSectionMonthlyReportFlow.setMisc(2000);
				  CashSectionMonthlyReportFlow.setPlace(Place);
				  CashSectionMonthlyReportFlow.setSTAMP(0);
				  System.out.println(" Persist  Jaggga   #####################################");
				  
				  CashSectionMonthlyReport.setAmount(8000+2050+3000);
				  CashSectionMonthlyReport.setKAWF(2050);
				  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReport.setBCIAWF(0);
				 // CashSectionMonthlyReport.setEnrollNo(KARNumber);
				  CashSectionMonthlyReport.setParticulars("Special General Enrollment Fee");
					String category = (String)request.getParameter("categoryID");
					  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
					  {
						  
						  System.out.println("DD Is Coming");
						  
						  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);					  }
					  else
					  {
						  CashSectionMonthlyReport.setPaymode("Cash");
							 
					  }
				  CashSectionMonthlyReport.setBCIAWF(0);
				  CashSectionMonthlyReport.setEntFee(6000);
				  CashSectionMonthlyReport.setFDS(3000);
				  CashSectionMonthlyReport.setIC(0);
				  CashSectionMonthlyReport.setKLA(0);
				  CashSectionMonthlyReport.setMisc(2000);
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
				 
				  
				
				 
				  if (CertificateVerificationFee>0)
					 {
				 
				 mapChallanScannedCopy.put("Enrollment Fee", 6000);
				  mapChallanScannedCopy.put("KAWF",2050);
				  mapChallanScannedCopy.put("FDS",3000);
				  mapChallanScannedCopy.put("Cert. Veri. Fee",2500);
				  mapChallanScannedCopy.put("Misc", 2000);
					 }
				  else
				  {
					  mapChallanScannedCopy.put("Enrollment Fee", 6000);
					  mapChallanScannedCopy.put("KAWF",2050);
					  mapChallanScannedCopy.put("FDS",3000);
					  
					  mapChallanScannedCopy.put("Misc", 2000);
				  }
				 }
			 else if(who.equals("specialscst")){
				 
				 	BeanSaveId = (int) Session.save(enrollmentNewMember); 
					
				 CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
				  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
				  CashSectionMonthlyReportFlow.setAmount(5000+2050+3000);
				  CashSectionMonthlyReportFlow.setKAWF(2050);
				  CashSectionMonthlyReport.setEnrollNo(Name);
				  CashSectionMonthlyReportFlow.setEnrollNo(Name);
				  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReportFlow.setBCIAWF(0);
				 // CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
				  CashSectionMonthlyReportFlow.setParticulars(" Special sc/st Enrollment Fee");
					String category = (String)request.getParameter("categoryID");
				  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);				  }
				  else
				  {
					  CashSectionMonthlyReportFlow.setPaymode("Cash");
						 
				  }
				 // CashSectionMonthlyReportFlow.setBCIAWF(0);
				  CashSectionMonthlyReportFlow.setEntFee(3000);
				  CashSectionMonthlyReportFlow.setFDS(3000);
				  CashSectionMonthlyReportFlow.setIC(0);
				  CashSectionMonthlyReportFlow.setKLA(0);
				  CashSectionMonthlyReportFlow.setMisc(2000);
				  CashSectionMonthlyReportFlow.setPlace(Place);
				  CashSectionMonthlyReport.setEnrollNo(Name);
				  CashSectionMonthlyReportFlow.setEnrollNo(Name);
				  CashSectionMonthlyReportFlow.setSTAMP(0);
				  System.out.println(" Persist  #####################################");
				  
				  CashSectionMonthlyReport.setAmount(5000+2050+3000);
				  CashSectionMonthlyReport.setKAWF(2050);
				  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReport.setBCIAWF(0);
				  CashSectionMonthlyReport.setEnrollNo("New Enroll");
				  CashSectionMonthlyReport.setParticulars("Special sc/st Enrollment Fee");
				  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);				  }
				  else
				  {
					  CashSectionMonthlyReport.setPaymode("Cash");
						 
				  }
				  CashSectionMonthlyReport.setBCIAWF(0);
				  CashSectionMonthlyReport.setEntFee(3000);
				  CashSectionMonthlyReport.setFDS(3000);
				  CashSectionMonthlyReport.setEnrollNo(Name);
				  CashSectionMonthlyReport.setIC(0);
				  CashSectionMonthlyReport.setKLA(0);
				  CashSectionMonthlyReport.setMisc(2000);
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
				 
				  
				 if (CertificateVerificationFee>0)
				 {
					 mapChallanScannedCopy.put("Enrollment Fee", 3000);
					 mapChallanScannedCopy.put("KAWF",2050);
					 mapChallanScannedCopy.put("FDS",3000);
					 mapChallanScannedCopy.put("Cert. Veri. Fee",2500);
					  mapChallanScannedCopy.put("Misc", 2000);
				 }
				 else
				 {
					 mapChallanScannedCopy.put("Enrollment Fee", 3000);
					 mapChallanScannedCopy.put("KAWF",2050);
					 mapChallanScannedCopy.put("FDS",3000);
					
					  mapChallanScannedCopy.put("Misc", 2000);	 
				 }
				 
				 
				
			 }
			 else if (){
				 
				 
				 
				 mapChallanScannedCopy.put("EnrollmentFee", EnrollmentFee);

			 }
			 }catch(Exception e){e.printStackTrace();}
			
			
			 
			 if(miscRts>0)
			 {
				
				 	BeanSaveId = (int) Session.save(enrollmentNewMember);
				 CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
				  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
				  CashSectionMonthlyReportFlow.setAmount(miscRts);
				  CashSectionMonthlyReportFlow.setKAWF(0);
				  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReportFlow.setBCIAWF(0);
				  CashSectionMonthlyReport.setEnrollNo(Name);
				  CashSectionMonthlyReportFlow.setEnrollNo(Name);
				 // CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
				  CashSectionMonthlyReportFlow.setParticulars("misc Rts");
					String category = (String)request.getParameter("categoryID");
					  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
					  {
						  
						  System.out.println("DD Is Coming");
						  
						  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);					  }
					  else
					  {
						  CashSectionMonthlyReportFlow.setPaymode("Cash");
							 
					  }
				 // CashSectionMonthlyReportFlow.setBCIAWF(0);
				  CashSectionMonthlyReportFlow.setEntFee(0);
				  CashSectionMonthlyReportFlow.setFDS(0);
				  CashSectionMonthlyReportFlow.setIC(0);
				  CashSectionMonthlyReportFlow.setKLA(0);
				  CashSectionMonthlyReportFlow.setMisc(miscRts);
				  CashSectionMonthlyReportFlow.setPlace(Place);
				  CashSectionMonthlyReportFlow.setSTAMP(0);
				  System.out.println(" Persist  #####################################");
				  
				  CashSectionMonthlyReport.setAmount(miscRts);
				  CashSectionMonthlyReport.setKAWF(0);
				  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
				  CashSectionMonthlyReport.setBCIAWF(0);
				 // CashSectionMonthlyReport.setEnrollNo(KARNumber);
				  CashSectionMonthlyReport.setParticulars("misc Rts");
				  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
				  {
					  
					  System.out.println("DD Is Coming");
					  
					  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);				  }
				  else
				  {
					  CashSectionMonthlyReport.setPaymode("Cash");
						 
				  }
				  CashSectionMonthlyReport.setBCIAWF(0);
				  CashSectionMonthlyReport.setEntFee(0);
				  CashSectionMonthlyReport.setFDS(0);
				  CashSectionMonthlyReport.setIC(0);
				  CashSectionMonthlyReport.setKLA(0);
				  CashSectionMonthlyReport.setMisc(miscRts);
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
		
				 
				 mapChallanScannedCopy.put("Misc", miscRts);
			 }
			 Integer total=0;
			 
			 if (EnrollmentFee>0)
			 {
				 
				  total=EnrollmentFee+2050+3000+CertificateVerificationFee;
				 
				
			 }
			 else
			 {
				  total=IdentityCar+EnrollmentFee+BciSubscriptio+fds+KawfMembershipFee+KsbcTrust+miscRts+CertificateVerificationFee;
						 
			 }
			 else if ()
			 {
				 
			 }
				System.out.println("TOTAL AMOUNT::"+total);
				try
				{
				ReceiptDeleteTable ReceiptDeleteTable= new ReceiptDeleteTable();
				ReceiptDeleteTable.setChallanGenerateSLNumber(ReceiptId);
				ReceiptDeleteTable.setOperator(Operator);
				ReceiptDeleteTable.setMonthlyReportSLNumber(BeanSaveId);
				ReceiptDeleteTable.setTimeWhenDeleted(today);
				ReceiptDeleteTable.setType("Enrollment");
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
			 String	responseString=JSPRelatedFunctionsimp.GenerateChallan(total,mapChallanScannedCopy,Name , timeStamp1, Place,"",ReceiptId+"",category1,"DD Number:"+DDNumber+"  " + "DD Date:"+DDDate+"  "+"Bank:" + BankName +"  " + "Branch:" +BranchName);
			 
			 out.println(responseString);
			//  Session.save(EnrollmentNewMemberBean);
			  Session.close();
	}

}
*/