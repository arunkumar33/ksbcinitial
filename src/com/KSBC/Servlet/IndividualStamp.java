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

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.KSBC.Bean.CashSectionMonthlyReport;
import com.KSBC.Bean.CashSectionMonthlyReportFlow;
import com.KSBC.Bean.IndividualStampBean;
import com.KSBC.Bean.ReceiptDeleteTable;
import com.KSBC.JSPRelatedFunctions.JSPRelatedFunctionsimp;
import com.KSBC.Util.HibernateUtil;

/**
 * Servlet implementation class IndividualStamp
 */
/*@WebServlet("/IndividualStamp")*/
public class IndividualStamp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndividualStamp() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {System.out.println("*********************** arun Hi  **********************************");
	 response.setContentType("text/html");
	 int ReceiptId=0;
	 int BeanSaveId=0;
	    PrintWriter out = response.getWriter();
	    Session Session = HibernateUtil.getSessionFactory().openSession();
	//	Transaction Tx = Session.beginTransaction();
		 LinkedHashMap<String, Integer> mapChallanScannedCopy = new LinkedHashMap<String, Integer>();
		 LocalDate today = LocalDate.now();
	//	 LocalDate LocalDate = LocalDate.now();
		 
		 String DDDate=request.getParameter("DDDate");	
		 System.out.println(DDDate + "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&    DD Date");	
	
	int IndividualStampFee=0;
	System.out.println(request.getParameter("Stampfee"));
	try
	{
		IndividualStampFee=Integer.parseInt(request.getParameter("Stampfee"));
	}
	catch (Exception e)
	{
	e.printStackTrace();		
	}

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
	 LocalDate today1 = LocalDate.now();
		
	 IndividualStampBean IndividualStampBean = new IndividualStampBean(); 
	 java.util.Date date = Date.from(today1.atStartOfDay()
		        .atZone(ZoneId.systemDefault()).toInstant());
		    Timestamp timeStamp = new Timestamp(date.getTime());
		    IndividualStampBean.setStampfee(IndividualStampFee);
		    IndividualStampBean.setChallanCreatedDate(timeStamp);
String category = (String)request.getParameter("category");

System.out.println("category  " + category);
	String DDNumber = (String)request.getParameter("DDNumber");
	
	
	 Integer total=IndividualStampFee;
		System.out.println("TOTAL AMOUNT::"+total);
	
	String timeStamp1 = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
	 
	if (IndividualStampFee>0)
		 {
		 BeanSaveId = (int) Session.save(IndividualStampBean); 
		  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
		  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
		  CashSectionMonthlyReportFlow.setAmount(IndividualStampFee);
		  CashSectionMonthlyReportFlow.setKAWF(0);
		  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
		  CashSectionMonthlyReportFlow.setBCIAWF(0);
		  CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
		  CashSectionMonthlyReportFlow.setParticulars("IndividualStamp Fee");
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
		  CashSectionMonthlyReportFlow.setSTAMP(IndividualStampFee);
		  System.out.println(" Membeship Persist  #####################################");
		  
		  CashSectionMonthlyReport.setAmount(IndividualStampFee);
		  CashSectionMonthlyReport.setKAWF(0);
		  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
		  CashSectionMonthlyReport.setBCIAWF(0);
		  CashSectionMonthlyReport.setEnrollNo(KARNumber);
		  CashSectionMonthlyReport.setParticulars("Individual Stamp Fee");
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
		  CashSectionMonthlyReport.setSTAMP(IndividualStampFee);
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
	//	  Tx.commit();
		  }
		  catch(Exception e)
		  {
			  System.out.println("Error");
			  //Session.flush();
	//		  Tx.rollback();
			  e.printStackTrace();
		  }
	
			 mapChallanScannedCopy.put("Individual Stamp Fee", IndividualStampFee);
		 }
	try
	{
	ReceiptDeleteTable ReceiptDeleteTable= new ReceiptDeleteTable();
	ReceiptDeleteTable.setChallanGenerateSLNumber(ReceiptId);
	ReceiptDeleteTable.setOperator(Operator);
	ReceiptDeleteTable.setMonthlyReportSLNumber(BeanSaveId);
	ReceiptDeleteTable.setTimeWhenDeleted(today);
	ReceiptDeleteTable.setType("Individual");
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
