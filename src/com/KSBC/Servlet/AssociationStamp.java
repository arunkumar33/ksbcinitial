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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import javax.servlet.http.HttpSession;

import org.hibernate.classic.Session;

import com.KSBC.Bean.AssociationStampBean;
import com.KSBC.Bean.CashSectionMonthlyReport;
import com.KSBC.Bean.CashSectionMonthlyReportFlow;
import com.KSBC.Bean.ReceiptDeleteTable;
import com.KSBC.JSPRelatedFunctions.JSPRelatedFunctionsimp;
import com.KSBC.Util.HibernateUtil;

import javax.servlet.ServletConfig;


/**
 * Servlet implementation class AssociationStamp
 */
/*@WebServlet("/AssociationStamp")*/
public class AssociationStamp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssociationStamp() {
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
		int ReceiptId=0;
		int BeanSaveId=0;
		System.out.println("*********************** arun Hi  **********************************");
		 response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		    Session Session = HibernateUtil.getSessionFactory().openSession();
		//	Transaction Tx = Session.beginTransaction();
			 LinkedHashMap<String, Integer> mapChallanScannedCopy = new LinkedHashMap<String, Integer>();
			 LocalDate today = LocalDate.now();
		//	 LocalDate LocalDate = LocalDate.now();
			 
	String associations= (String) request.getParameter("Association");
	
	String associationsName= (String) request.getParameter("NameOfAssociation");
	
	String associationsPlace= (String) request.getParameter("PlaceOfAssociation");
	
	if (associationsName!="")
	{
		
	}
	
	if (associationsPlace!="")
	{
		
	}
	String DistictName="";
	try
	{
	String[] BarAssc = associations.split(" BAR");
	System.out.println(BarAssc[1]);
	DistictName=BarAssc[0];
	}
	catch (Exception e)
	{
		String[] BarAssc = associations.split(" ADV CO-OPERATIVE SOCIETY");
		DistictName=BarAssc[0];
	}
	
	System.out.println(DistictName +" DistictName");
	//	String PostalCharges = (String) request.getParameter("PostalCharges");
		
	//	System.out.println(PostalCharges +"PostalCharges");
		int AssociationStampFee=0;
		System.out.println(request.getParameter("Stampfee"));
		try
		{
			AssociationStampFee=Integer.parseInt(request.getParameter("Stampfee"));
		}
		catch (Exception e)
		{
		e.printStackTrace();		
		}
		
		
		int PostalCharges=0;
		System.out.println(request.getParameter("PostalCharges"));
		try
		{
			PostalCharges=Integer.parseInt(request.getParameter("PostalCharges"));
		}
		catch (Exception e)
		{
		e.printStackTrace();		
		}
		
	
		
		String BankName = (String)request.getParameter("BankName");
		String BranchName = (String)request.getParameter("BranchName");
		String Place= (String)request.getParameter("Place");
	
	String category = (String)request.getParameter("category");
	
	System.out.println("category  " + category);
		String DDNumber = (String)request.getParameter("DDNumber");
		 String DDDate=request.getParameter("DDDate");	
		 System.out.println(DDDate + "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&    DD Date");
		
		 Integer total=AssociationStampFee+PostalCharges;
			System.out.println("TOTAL AMOUNT::"+total);
			AssociationStampBean AssociationStampBean = new AssociationStampBean();
			AssociationStampBean.setPostalCharges(PostalCharges);
			
			AssociationStampBean.setStampfee(AssociationStampFee);
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
				    AssociationStampBean.setChallanCreatedDate(timeStamp);
		String timeStamp1 = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		if (associationsName!="")
		{
			associations=associationsName;
		}
		
		if (associationsPlace!="")
		{
		DistictName=	associationsPlace;
		}
		
		String Name=DistictName;
		
		System.out.println(Name+"Name123");
		System.out.println(associations+"associations");
		System.out.println(DistictName+"DistictName");
		if (total>0)
			 {
			BeanSaveId=  (int) Session.save(AssociationStampBean);
			  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
			  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
			  CashSectionMonthlyReportFlow.setAmount(total);
			  CashSectionMonthlyReportFlow.setKAWF(0);
			  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEnrollNo(associations );
			  CashSectionMonthlyReportFlow.setParticulars("Association Stamp Fee");
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
			  CashSectionMonthlyReportFlow.setPlace(DistictName);
			  CashSectionMonthlyReportFlow.setSTAMP(total);
			  System.out.println(" Membeship Persist  #####################################");
			  
			  CashSectionMonthlyReport.setAmount(total);
			  CashSectionMonthlyReport.setKAWF(0);
			  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEnrollNo(associations  );
			  CashSectionMonthlyReport.setEnrollNo(associations );
			  CashSectionMonthlyReport.setParticulars("Association Stamp Fee");
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
			  CashSectionMonthlyReport.setPlace(DistictName);
			  CashSectionMonthlyReport.setSTAMP(total);
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
				  ////Session.flush();
		//		  Tx.rollback();
				  e.printStackTrace();
			  }
			  if (PostalCharges>0)
				 {
				  mapChallanScannedCopy.put("Association Stamp Fee", AssociationStampFee);
				  mapChallanScannedCopy.put("Association Postal Fee", PostalCharges);
				  
				 }
			  else
			  {
				  mapChallanScannedCopy.put("Association Stamp Fee", AssociationStampFee);
			  }
				 
			 }
		
		/*
		if (PostalCharges>0)
		 {
			 Session.save(AssociationStampBean);
		  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
		  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
		  CashSectionMonthlyReportFlow.setAmount(PostalCharges);
		  CashSectionMonthlyReportFlow.setKAWF(0);
		  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
		  CashSectionMonthlyReportFlow.setBCIAWF(0);
		  CashSectionMonthlyReportFlow.setEnrollNo(KARNumber );
		  CashSectionMonthlyReportFlow.setParticulars("Postal Fee");
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
		  CashSectionMonthlyReportFlow.setSTAMP(PostalCharges);
		  System.out.println(" Membeship Persist  #####################################");
		  
		  CashSectionMonthlyReport.setAmount(AssociationStampFee);
		  CashSectionMonthlyReport.setKAWF(0);
		  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
		  CashSectionMonthlyReport.setBCIAWF(0);
		  CashSectionMonthlyReportFlow.setEnrollNo(KARNumber + " " + Name);
		  CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
		  CashSectionMonthlyReport.setParticulars("Postal Fee");
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
		  CashSectionMonthlyReport.setSTAMP(PostalCharges);
		  CashSectionMonthlyReport.setOperator(Operator);
		  CashSectionMonthlyReportFlow.setOperator(Operator);
		    
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
			  ////Session.flush();
	//		  Tx.rollback();
			  e.printStackTrace();
		  }
	
			 mapChallanScannedCopy.put("Postal Fee", PostalCharges);
		 }*/
		
		
		Session.beginTransaction().commit();
		try
		{
		ReceiptDeleteTable ReceiptDeleteTable= new ReceiptDeleteTable();
		ReceiptDeleteTable.setChallanGenerateSLNumber(ReceiptId);
		ReceiptDeleteTable.setOperator(Operator);
		ReceiptDeleteTable.setMonthlyReportSLNumber(BeanSaveId);
		ReceiptDeleteTable.setTimeWhenDeleted(today);
		ReceiptDeleteTable.setType("Associate");
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
			 String	responseString=	JSPRelatedFunctionsimp.GenerateChallan(total,mapChallanScannedCopy,associations , timeStamp1, DistictName,"",ReceiptId+"",category,"DD Number:"+DDNumber+"  " + "DD Date:"+DDDate+"  "+"Bank:" + BankName+"  " + "Branch:" +BranchName);
			 
			 out.println(responseString);
			//  Session.saveOrUpdate(EnrollmentNewMemberBean);
			  Session.close();
	}

}
