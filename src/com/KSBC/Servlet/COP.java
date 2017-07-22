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

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.KSBC.Bean.COPTable;
import com.KSBC.JSPRelatedFunctions.JSPRelatedFunctionsimp;
import com.KSBC.Util.HibernateUtil;

/**
 * Servlet implementation class COP
 */
/*@WebServlet("/COP")*/
public class COP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public COP() {
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
		 LinkedHashMap<String, Integer> mapChallanScannedCopy = new LinkedHashMap<String, Integer>();
		  PrintWriter out = response.getWriter();		
		 Session Session = HibernateUtil.getSessionFactory().openSession();
		 String timeStamp1 = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
			Transaction Tx = Session.beginTransaction();
		COPTable COPTable = new COPTable();
		int BeanSaveId=0;
long COPApplicationFee=0;
LocalDate today = LocalDate.now();

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
String category = (String)request.getParameter("category");
String DDNumber = (String)request.getParameter("DDNumber");


java.util.Date date = Date.from(today.atStartOfDay()
        .atZone(ZoneId.systemDefault()).toInstant());
    Timestamp timeStamp = new Timestamp(date.getTime());
   	
    String DDDate=request.getParameter("DDDate");	
	 System.out.println(DDDate + "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&    DD Date");

		try
		{
			COPApplicationFee= Long.parseLong(request.getParameter("COPApplicationFee"));
		}
		catch (Exception e)
		{
			
			e.printStackTrace();
			COPApplicationFee=0;	
		}
		 System.out.println(COPApplicationFee + "COPApplicationFee");
		System.out.println("*********************** Hi  **********************************");
		 response.setContentType("text/html");
	int	 ReceiptId=0; 
		 
		 long KSBCCOPFEE = Long.parseLong(request.getParameter("KSBCCOPFEE"));	 
		 long COPApplicationLateFee = Long.parseLong(request.getParameter("COPApplicationLateFee"));	
		 long RESCFee = Long.parseLong(request.getParameter("RESCFee"));	
		 long MiscFee = Long.parseLong(request.getParameter("MiscFee"));	
		 long InterestONFD = Long.parseLong(request.getParameter("InterestONFD"));	
		 
		 long ClosingFD = Long.parseLong(request.getParameter("ClosingFD"));	
		 long COPSenioradvc = Long.parseLong(request.getParameter("COPSenioradvc"));
	
		 
		 COPTable.setClosingFD(ClosingFD);
		 COPTable.setInterestONFD(InterestONFD);
		 COPTable.setEnrollNo(KARNumber);
		
		 COPTable.setKSBCCOPApplication(COPApplicationFee);
		 COPTable.setKSBCCOPFee(KSBCCOPFEE);
		 COPTable.setKSBCCOPLateFee(COPApplicationLateFee);
		 COPTable.setKSBCCOPMiscFee(MiscFee);
		 COPTable.setKSBCCOPRescFee(RESCFee);
		 COPTable.setKSBCCOPSeniorAdvc(COPSenioradvc);
		 COPTable.setName(Name);
		 COPTable.setOperator(Operator);
		 COPTable.setChallanCreatedDate(timeStamp);
		 COPTable.setPlace(Place);
		  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
		  {
			  
			  System.out.println("DD Is Coming");
			  
			  COPTable.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);
		  }
		  else
		  {
			  COPTable.setPaymode("Cash");
				 
		  }
		  
		  if(COPApplicationFee>0)
		   {
			   COPTable.setKSBCCOPApplication(COPApplicationFee);
			   mapChallanScannedCopy.put("KSBC COP Application Fee", (int)COPApplicationFee);
			   COPTable.setParticulars("KSBC COP Application Fee");
				
		   }
			 
		   if(KSBCCOPFEE>0)
		   {
			   COPTable.setKSBCCOPFee(KSBCCOPFEE);
			   mapChallanScannedCopy.put("KSBC COP Fee", (int) KSBCCOPFEE);
			   COPTable.setParticulars("KSBC COP Application Fee"); 
		   }
		   if(COPApplicationLateFee>0)
		   {
			   COPTable.setKSBCCOPLateFee(COPApplicationLateFee); 
			   mapChallanScannedCopy.put("KSBC COP Late Fee",  (int)COPApplicationLateFee);
			   COPTable.setParticulars("KSBC COP Late Fee");  
		   }
		   
		   
		   if(RESCFee>0)
		   {
			   COPTable.setKSBCCOPRescFee(RESCFee); 
			   mapChallanScannedCopy.put("KSBC COP Resc Fee", (int) RESCFee);
			   COPTable.setParticulars("KSBC COP Resc Fee");  
		   }
		   if(MiscFee>0)
		   {
			   COPTable.setKSBCCOPMiscFee(MiscFee);
			   mapChallanScannedCopy.put("KSBC COP Misc Fee", (int) MiscFee);
			   COPTable.setParticulars("KSBC COP Misc Fee");  
		   }
		   
		   if(InterestONFD>0)
		   {
			   COPTable.setInterestONFD(InterestONFD);
			   mapChallanScannedCopy.put("KSBC COP Interest On FD", (int) InterestONFD);
			   COPTable.setParticulars("KSBC COP Interest On FD");	
		   }
		   if(ClosingFD>0)
		   {
			   COPTable.setClosingFD(ClosingFD); 
			   mapChallanScannedCopy.put("KSBC COP Closing FD", (int) ClosingFD);
			   COPTable.setParticulars("KSBC COP Closing FD");
		   }
		   if(COPSenioradvc>0)
		   {
			   COPTable.setKSBCCOPSeniorAdvc(COPSenioradvc);
			   mapChallanScannedCopy.put("KSBC COP Senior Adv Fee", (int)COPSenioradvc);
			   COPTable.setParticulars("KSBC COP Senior Adv Fee");
		   }
		   
		 
		   int total=(int) (KSBCCOPFEE+COPApplicationLateFee+RESCFee+MiscFee+InterestONFD+
					  ClosingFD+COPSenioradvc+COPApplicationFee);
					  			 System.out.println("TOTAL AMOUNT::"+total);
					  			COPTable.setAmount(total);		  			 
		  try
		  {
		Serializable Id1 = Session.save(COPTable);
		 ReceiptId=(int) Id1;
	
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
			
		  
		  
		
		
		  
				  			 JSPRelatedFunctionsimp JSPRelatedFunctionsimp= new JSPRelatedFunctionsimp();
				  		//	 String	responseString=	JSPRelatedFunctionsimp.GenerateChallan(total,mapChallanScannedCopy,Name , timeStamp, Place,KARNumber,ReceiptId+"",category,"DD Number:"+DDNumber+"  " + "DD Date:"+DDDate+"  "+"Bank:" + BankName+"  " + "Branch:" +BranchName);
				  			String	responseString=	JSPRelatedFunctionsimp.GenerateChallan(total,mapChallanScannedCopy,Name , timeStamp1, Place,KARNumber,ReceiptId+"",category,"DD Number:"+DDNumber+"  " + "DD Date:"+DDDate+"  "+"Bank:" + BankName+"  " + "Branch:" +BranchName);
				 				 
				  			 out.println(responseString);
   
	}

}
