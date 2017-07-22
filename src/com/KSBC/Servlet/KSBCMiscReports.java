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

import com.KSBC.Bean.FeeStructureForKAR;
import com.KSBC.JSPRelatedFunctions.JSPRelatedFunctionsimp;
import com.KSBC.Util.HibernateUtil;

*//**
 * Servlet implementation class KSBCMiscReports
 *//*
@WebServlet("/KSBCMiscReports")
public class KSBCMiscReports extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    *//**
     * @see HttpServlet#HttpServlet()
     *//*
    public KSBCMiscReports() {
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
		 System.out.println("HI FeeStructure");
		 LinkedHashMap<String, Integer> mapChallanScannedCopy = new LinkedHashMap<String, Integer>();
		 response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		    Session Session = HibernateUtil.getSessionFactory().openSession();
			Transaction Tx = Session.beginTransaction();
			
			try{
		 Integer EnrollmentFee = Integer.parseInt(request.getParameter("EnrollmentFee"));
		 catch(Exception e){
				e.printStackTrace();
			}
			
		 Integer ReimbursementOFSalaryDeduction = Integer.parseInt(request.getParameter("ReimbursementOFSalaryDeduction"));
		
	
		 Integer ClosingFD = Integer.parseInt(request.getParameter("ClosingFD"));
	
	
		 Integer KSBCCostReceipt = Integer.parseInt(request.getParameter("KSBCCostReceipt"));
		
		 
	
		 Integer ElectionRules = Integer.parseInt(request.getParameter("ElectionRules"));
	
		 Integer NominationForm = Integer.parseInt(request.getParameter("NominationForm"));
		
		 Integer VoterCD = Integer.parseInt(request.getParameter("VoterCD"));
		
			
			
				 
		 Integer ElectionDeposit = Integer.parseInt(request.getParameter("ElectionDeposit"));
		 
		 Integer PDC = Integer.parseInt(request.getParameter("PDC"));
		 
		 Integer DOBCertificate = Integer.parseInt(request.getParameter("DOBCertificate"));
		 
		 Integer CertificateCopyCharges = Integer.parseInt(request.getParameter("CertificateCopyCharges"));
		 
		 Integer PostageReceipts = Integer.parseInt(request.getParameter("PostageReceipts"));
		 
		 String KARNumber = request.getParameter("KARNumber");
		 
		 Integer DuplicateEnrollment = Integer.parseInt(request.getParameter("DuplicateEnrollemt"));
		 
		 
		 Integer EndomentCertificate = Integer.parseInt(request.getParameter("EndomentCertificate"));
		 Integer KSBCInterestONFD = Integer.parseInt(request.getParameter("KSBCInterestONFD"));
		 String PlaceOftheClient = request.getParameter("Place");
		 int EnrollmentApplication=0;
		 try{
		 EnrollmentApplication = Integer.parseInt(request.getParameter("EnrollmentApplication"));
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
		 
		 Integer IdentityCard = Integer.parseInt(request.getParameter("IdentityCard"));
		 String NameOftheClient = (request.getParameter("Name"));
		 
		 System.out.println(NameOftheClient + "  Name");
		 int ComplaintFee=0;
		 try{
		  ComplaintFee = Integer.parseInt(request.getParameter("ComplaintFee"));
		 }catch(Exception e){
				e.printStackTrace();
			}
		 
		 int ChangeOfAddress=0;
		 try{
		 ChangeOfAddress = Integer.parseInt(request.getParameter("ChangeOfAddress"));
		 }catch(Exception e){
				e.printStackTrace();
			}
		 
		int ContinuityCertificate=0;
		 try{
		  ContinuityCertificate = Integer.parseInt(request.getParameter("ContinuityCertificate"));
		 }catch(Exception e){
				e.printStackTrace();
			}
		 
		 int VSP=0;
		 try{
		  VSP = Integer.parseInt(request.getParameter("VSP"));
		 }catch(Exception e){
				e.printStackTrace();
			}
		 
		 int ProcessFee=0;
		 try{
		  ProcessFee = Integer.parseInt(request.getParameter("ProcessFee"));
		 }catch(Exception e){
				e.printStackTrace();
			}
		 
		 Integer miscReceipts = Integer.parseInt(request.getParameter("MiscReceipts"));
		
		 int NOC=0;
		 try{
		  NOC = Integer.parseInt(request.getParameter("NOC"));
		 }catch(Exception e){
				e.printStackTrace();
			}
		 int ChangeOfNamePublication=0;
		try{
		  ChangeOfNamePublication = Integer.parseInt(request.getParameter("ChangeOfNamePublication"));
		 }catch(Exception e){
				e.printStackTrace();
			}
		
		int Resumption=0;
		 try{
			  Resumption=Integer.parseInt(request.getParameter("Resumption"));
		 }
	 catch(Exception e){
		 e.printStackTrace();
	 }
		 
		 Integer endomentCertificate = Integer.parseInt(request.getParameter("EndomentCertificate"));
		 Integer reimbursementOFSalaryDeduction = Integer.parseInt(request.getParameter("ReimbursementOFSalaryDeduction"));
		 //reimbursementOFSalaryDeduction
	
		 int enrollmentApplication=0;
		 try{
		  enrollmentApplication = Integer.parseInt(request.getParameter("EnrollmentApplication"));
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
		 
		 Integer total= ReimbursementOFSalaryDeduction+ClosingFD+KSBCCostReceipt+ElectionRules;
		 total+=NominationForm+VoterCD+ElectionDeposit+PDC+DOBCertificate+PostageReceipts+DuplicateEnrollment+EndomentCertificate;
		 total+=KSBCInterestONFD+EnrollmentApplication+IdentityCard+ComplaintFee+ChangeOfAddress+ContinuityCertificate;
		 total+=VSP+ProcessFee+miscReceipts+NOC+ChangeOfNamePublication+endomentCertificate+reimbursementOFSalaryDeduction;
		 
		 
		 System.out.println(total);
		 if (EnrollmentFee>0)
		 {
			 mapChallanScannedCopy.put("EnrollmentFee", EnrollmentFee);
		 }
		 if (ReimbursementOFSalaryDeduction>0)
		 {
			 mapChallanScannedCopy.put("ReimbursementOFSalaryDeduction", ReimbursementOFSalaryDeduction);
		 }
		 if (ClosingFD>0)
		 {
			 mapChallanScannedCopy.put("ClosingFD", ClosingFD); 
		 } 
		 
		 if (KSBCCostReceipt>0)
		 {
			 mapChallanScannedCopy.put("KSBC CostReceipt", KSBCCostReceipt); 
		 } 
		 if (ElectionRules>0)
		 {
			 mapChallanScannedCopy.put("Election Rules", ElectionRules); 
		 }  
		 if (NominationForm>0)
		 {
			 mapChallanScannedCopy.put("Nomination Form", NominationForm); 
		 }  
		 
		 if (VoterCD>0)
		 {
			 mapChallanScannedCopy.put("Voter CD", VoterCD); 
		 } 
		 
		 if (ElectionDeposit>0)
		 {
			 mapChallanScannedCopy.put("Election Deposit", VoterCD); 
		 }   
		 
		 if (PDC>0)
		 {
			 mapChallanScannedCopy.put("PDC", PDC); 
		 }  
		 
		 if (DOBCertificate>0)
		 {
			 mapChallanScannedCopy.put("DOB Certificate", DOBCertificate); 
		 }   
		 
		 if (CertificateCopyCharges>0)
		 {
			 mapChallanScannedCopy.put("Certificate Copy Charges", CertificateCopyCharges); 
		 }
		 if (PostageReceipts>0)
		 {
			 mapChallanScannedCopy.put("Postage Receipts", PostageReceipts); 
		 }
		 if (DuplicateEnrollment>0)
		 {
			 mapChallanScannedCopy.put("Duplicate Enrollment", DuplicateEnrollment);  
		 }  
		 if (EndomentCertificate>0)
		 {
			 mapChallanScannedCopy.put("Endoment Certificate", EndomentCertificate);  
		 } 
		 
		 
		 
		 
		 
		 
		 
		 if (KSBCInterestONFD>0)
		 {
			 mapChallanScannedCopy.put("KSBC Interest ON FD", KSBCInterestONFD); 
		 }   
		 
		 if (EnrollmentApplication>0)
		 {
			 mapChallanScannedCopy.put("Enrollment Application", EnrollmentApplication); 
		 }  
		 
		 if (IdentityCard>0)
		 {
			 mapChallanScannedCopy.put("Identity Card", IdentityCard); 
		 }   
		 
		
		 if (ComplaintFee>0)
		 {
			 mapChallanScannedCopy.put("Complaint Fee", ComplaintFee); 
		 }
		 if (ChangeOfAddress>0)
		 {
			 mapChallanScannedCopy.put("Change Of Address", ChangeOfAddress);  
		 }  
		 if (ContinuityCertificate>0)
		 {
			 mapChallanScannedCopy.put("Continuity Certificate", ContinuityCertificate);  
		 } 
		 
		// PlaceOftheClient
		 if (VSP>0)
		 {
			 mapChallanScannedCopy.put("VSP", VSP);  
		 } 
		 
		 if (ProcessFee>0)
		 {
			 mapChallanScannedCopy.put("Proces sFee", ProcessFee);  
		 } 
		 
		 
		 if (miscReceipts>0)
		 {
			 mapChallanScannedCopy.put("misc Receipts", miscReceipts);  
		 }  
		 
		 if (NOC>0)
		 {
			 mapChallanScannedCopy.put("NOC", NOC);  
		 }
		 
		 
		 
		 
		 
		 if (ChangeOfNamePublication>0)
		 {
			 mapChallanScannedCopy.put("Change Of Name Publication", ChangeOfNamePublication); 
		 }
		 if (endomentCertificate>0)
		 {
			 mapChallanScannedCopy.put("endoment Certificate", endomentCertificate);  
		 }  
		 if (reimbursementOFSalaryDeduction>0)
		 {
			 mapChallanScannedCopy.put("reimbursement OF Salary Deduction", reimbursementOFSalaryDeduction);  
		 } 
		 
		// PlaceOftheClient
		 if (enrollmentApplication>0)
		 {
			 mapChallanScannedCopy.put("enrollment Application", enrollmentApplication);  
		 } 
		 
		
		
		 
		 FeeStructureForKAR FeeStructureForKAR= new FeeStructureForKAR();
		 
		 FeeStructureForKAR.setCertificateCopyCharges(CertificateCopyCharges);
		 FeeStructureForKAR.setChangeOfAddress(ChangeOfAddress);
		 FeeStructureForKAR.setChangeOfNamePublication(ChangeOfNamePublication);
		 FeeStructureForKAR.setClosingFD(ClosingFD);
		 FeeStructureForKAR.setComplaintFee(ComplaintFee);
		 FeeStructureForKAR.setContinuityCertificate(ContinuityCertificate);
		 FeeStructureForKAR.setDOBCertificate(DOBCertificate);
		 FeeStructureForKAR.setDuplicateEnrollemt(DuplicateEnrollment);
		 FeeStructureForKAR.setElectionDeposit(ElectionDeposit);
		 FeeStructureForKAR.setElectionRules(ElectionRules);
		
		FeeStructureForKAR.setEndomentCertificate(endomentCertificate);
		FeeStructureForKAR.setEnrollmentApplication(enrollmentApplication);
		//FeeStructureForKAR.setEnrollmentFee(EnrollmentFee);
		FeeStructureForKAR.setIdentityCard(IdentityCard);
		FeeStructureForKAR.setKARNumber(KARNumber);
		FeeStructureForKAR.setKSBCCostReceipt(KSBCCostReceipt);
		FeeStructureForKAR.setKSBCInterestONFD(KSBCInterestONFD);
	FeeStructureForKAR.setMiscReceipts(miscReceipts);
		FeeStructureForKAR.setNameOftheClient(NameOftheClient);
		FeeStructureForKAR.setNOC(NOC);
		FeeStructureForKAR.setNominationForm(NominationForm);
		FeeStructureForKAR.setPDC(PDC);
		FeeStructureForKAR.setPlaceOftheClient(PlaceOftheClient);
		FeeStructureForKAR.setPostageReceipts(PostageReceipts);
		FeeStructureForKAR.setProcessFee(ProcessFee);
		FeeStructureForKAR.setReimbursementOFSalaryDeduction(reimbursementOFSalaryDeduction);
		 
		 
		 EnrollmentFee:EnrollmentFee,ReimbursementOFSalaryDeduction:ReimbursementOFSalaryDeduction,
			ClosingFD:ClosingFD,KSBCCostReceipt:KSBCCostReceipt,
			ElectionRules:ElectionRules,MiscReceipts:MiscReceipts,
			ElectionRules:ElectionRules,NominationForm:NominationForm,
			VoterCD:VoterCD,ElectionDeposit:ElectionDeposit,PDC:PDC,
			DOBCertificate:DOBCertificate,CertificateCopyCharges:CertificateCopyCharges,
			PostageReceipts:PostageReceipts,EnrollmentFee:EnrollmentFee,KARNumber:KARNumber,
			DuplicateEnrollemt:DuplicateEnrollemt,EndomentCertificate:EndomentCertificate,
			KSBCInterestONFD:KSBCInterestONFD,WhichFunctionToHandle:WhichFunctionToHandle,PlaceOftheClient:PlaceOftheClient,
			EnrollmentApplication:EnrollmentApplication,IdentityCard:IdentityCard,NameOftheClient:NameOftheClient,
			ComplaintFee:ComplaintFee,ChangeOfAddress:ChangeOfAddress,KARNumber:KARNumber,
			ContinuityCertificate:ContinuityCertificate,VSP:VSP,ProcessFee:ProcessFee,NOC:NOC,ChangeOfNamePublication:ChangeOfNamePublication
		JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
		String timeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
		
	String 	responseString=	JSPRelatedFunctionsimp.GenerateChallan(total,mapChallanScannedCopy,NameOftheClient , timeStamp, PlaceOftheClient);
	//	  responseString="<img alt=\"Image\" src=\"KARNumberImageServlet?KARNumber="+KARNumber+"&WhichPhoto=\">";
		//System.out.println(responseString);
	out.println(responseString);
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

import com.KSBC.Bean.CashSectionMonthlyReport;
import com.KSBC.Bean.CashSectionMonthlyReportFlow;
import com.KSBC.Bean.FeeStructureForKAR;
import com.KSBC.Bean.KSBCMiscReceiptBean;
import com.KSBC.Bean.ReceiptDeleteTable;
import com.KSBC.JSPRelatedFunctions.JSPRelatedFunctionsimp;
import com.KSBC.Util.HibernateUtil;

/**
 * Servlet implementation class KSBCMiscReports
 */
/*@WebServlet("/KSBCMiscReports")*/
public class KSBCMiscReports extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KSBCMiscReports() {
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
		 System.out.println("HI FeeStructure");
		 Serializable Id;
		 int BeanSaveId=0;
		    LocalDate today = LocalDate.now();
		    int ReceiptId=0;    
		 LinkedHashMap<String, Integer> mapChallanScannedCopy = new LinkedHashMap<String, Integer>();
		 response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		    Session Session = HibernateUtil.getSessionFactory().openSession();
			Transaction Tx = Session.beginTransaction();
			String category = (String)request.getParameter("category");
			
			System.out.println("category  " + category);
				
			/*try{
		 Integer EnrollmentFee = Integer.parseInt(request.getParameter("EnrollmentFee"));
		 catch(Exception e){
				e.printStackTrace();
			}
			*/
			
		 Integer ReimbursementOFSalaryDeduction = Integer.parseInt(request.getParameter("ReimbursementOFSalaryDeduction"));
		
	
		 Integer ClosingFD = Integer.parseInt(request.getParameter("ClosingFD"));
	
		 
	
		 Integer KSBCCostReceipt = Integer.parseInt(request.getParameter("KSBCCostReceipt"));
		 
		 
		 Integer GOvtGrant = Integer.parseInt(request.getParameter("GOvtGrant"));
		 Integer ElectionRules = Integer.parseInt(request.getParameter("ElectionRules"));
	
		 Integer NominationForm = Integer.parseInt(request.getParameter("NominationForm"));
		
		 Integer VoterCD = Integer.parseInt(request.getParameter("VoterCD"));
		
		 String DDDate=request.getParameter("DDDate");
			System.out.println(DDDate);
				 
		 Integer ElectionDeposit = Integer.parseInt(request.getParameter("ElectionDeposit"));
		 HttpSession Servletsession = request.getSession(false);
			if (Servletsession==null)
			{
				Servletsession = request.getSession(true);
			} 
			
			String Operator= (String) Servletsession.getAttribute("UserName");
			
			System.out.println(Operator + " Operator");
			
		 Integer PDC = Integer.parseInt(request.getParameter("PDC"));
		 
		 Integer DOBCertificate = Integer.parseInt(request.getParameter("DOBCertificate"));
		 
		 Integer CertificateCopyCharges = Integer.parseInt(request.getParameter("CertificateCopyCharges"));
		 
		 Integer PostageReceipts = Integer.parseInt(request.getParameter("PostageReceipts"));
		 
		// String KARNumber = request.getParameter("KARNumber");
		 
		 Integer DuplicateEnrollment = Integer.parseInt(request.getParameter("DuplicateEnrollemt"));
		 
		 
		 Integer EndomentCertificate = Integer.parseInt(request.getParameter("EndomentCertificate"));
		 Integer KSBCInterestONFD = Integer.parseInt(request.getParameter("KSBCInterestONFD"));
		 String PlaceOftheClient = request.getParameter("Place");
		 int EnrollmentApplication=0;
		 try{
		 EnrollmentApplication = Integer.parseInt(request.getParameter("EnrollmentApplication"));
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
		 
		 Integer IdentityCard = Integer.parseInt(request.getParameter("IdentityCard"));
		 String NameOftheClient = (request.getParameter("Name"));
		 
		 System.out.println(NameOftheClient + "  Name");
		 int ComplaintFee=0;
		 try{
		  ComplaintFee = Integer.parseInt(request.getParameter("ComplaintFee"));
		 }catch(Exception e){
				e.printStackTrace();
			}
		 
		 int ChangeOfAddress=0;
		 try{
		 ChangeOfAddress = Integer.parseInt(request.getParameter("ChangeOfAdreess"));
		 }catch(Exception e){
				e.printStackTrace();
			}
		 
		int ContinuityCertificate=0;
		 try{
		  ContinuityCertificate = Integer.parseInt(request.getParameter("ContinuityCertificate"));
		 }catch(Exception e){
				e.printStackTrace();
			}
		 
		 int VSP=0;
		 try{
		  VSP = Integer.parseInt(request.getParameter("vsp"));
		 }catch(Exception e){
				e.printStackTrace();
			}
		 
		 int ProcessFee=0;
		 try{
		  ProcessFee = Integer.parseInt(request.getParameter("ProcessFee"));
		 }catch(Exception e){
				e.printStackTrace();
			}
		 
		 Integer miscReceipts = Integer.parseInt(request.getParameter("MiscReceipts"));
		
		 int NOC=0;
		 try{
		  NOC = Integer.parseInt(request.getParameter("NOC"));
		 }catch(Exception e){
				e.printStackTrace();
			}
		 int ChangeOfNamePublication=0;
		try{
		  ChangeOfNamePublication = Integer.parseInt(request.getParameter("ChangeofNamePublication"));
		  System.out.println("Akshay");
		 }catch(Exception e){
				e.printStackTrace();
			}
		
		int Resumption=0;
		 try{
			  Resumption=Integer.parseInt(request.getParameter("Resumption"));
		 }
	 catch(Exception e){
		 e.printStackTrace();
	 }
		 
		 Integer endomentCertificate = Integer.parseInt(request.getParameter("EndomentCertificate"));
		 Integer reimbursementOFSalaryDeduction = Integer.parseInt(request.getParameter("ReimbursementOFSalaryDeduction"));
		 //reimbursementOFSalaryDeduction
	
		 int enrollmentApplication=0;
		 try{
		  enrollmentApplication = Integer.parseInt(request.getParameter("EnrollmentApplication"));
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
		 

			String Name = (String)request.getParameter("Name");
			String KARNumber = (String)request.getParameter("KARNumber");
			String BankName = (String)request.getParameter("BankName");
			String BranchName = (String)request.getParameter("BranchName");
			String Place= (String)request.getParameter("Place");
		//	int Amount = Integer.parseInt(request.getParameter("Amount"));
		
			String DDNumber = (String)request.getParameter("DDNumber");

			 KSBCMiscReceiptBean FeeStructureForKAR= new KSBCMiscReceiptBean();
			 
			 FeeStructureForKAR.setCertificateCopyCharges(CertificateCopyCharges);
			 FeeStructureForKAR.setChangeOfAddress(ChangeOfAddress);
			 FeeStructureForKAR.setChangeOfNamePublication(ChangeOfNamePublication);
			 FeeStructureForKAR.setClosingFD(ClosingFD);
			 FeeStructureForKAR.setComplaintFee(ComplaintFee);
			 FeeStructureForKAR.setContinuityCertificate(ContinuityCertificate);
			 FeeStructureForKAR.setDOBCertificate(DOBCertificate);
			 FeeStructureForKAR.setDuplicateEnrollemt(DuplicateEnrollment);
			 FeeStructureForKAR.setElectionDeposit(ElectionDeposit);
			 FeeStructureForKAR.setElectionRules(ElectionRules);
			
			FeeStructureForKAR.setEndomentCertificate(endomentCertificate);
			FeeStructureForKAR.setEnrollmentApplication(enrollmentApplication);
			//FeeStructureForKAR.setEnrollmentFee(EnrollmentFee);
			FeeStructureForKAR.setIdentityCard(IdentityCard);
			FeeStructureForKAR.setKARNumber(KARNumber);
			FeeStructureForKAR.setKSBCCostReceipt(KSBCCostReceipt);
			FeeStructureForKAR.setKSBCInterestONFD(KSBCInterestONFD);
		FeeStructureForKAR.setMiscReceipts(miscReceipts);
			FeeStructureForKAR.setNameOftheClient(NameOftheClient);
			FeeStructureForKAR.setNOC(NOC);
			FeeStructureForKAR.setNominationForm(NominationForm);
			FeeStructureForKAR.setPDC(PDC);
			FeeStructureForKAR.setPlaceOftheClient(PlaceOftheClient);
			FeeStructureForKAR.setPostageReceipts(PostageReceipts);
			FeeStructureForKAR.setProcessFee(ProcessFee);
			FeeStructureForKAR.setReimbursementOFSalaryDeduction(reimbursementOFSalaryDeduction);
			FeeStructureForKAR.setVoterCD(VoterCD);
			FeeStructureForKAR.setGOvtGrant(GOvtGrant);
			FeeStructureForKAR.setResumption(Resumption);
		//	FeeStructureForKAR.setIdentityCard(identityCard);
			java.util.Date date = Date.from(today.atStartOfDay()
			        .atZone(ZoneId.systemDefault()).toInstant());
			    Timestamp timeStamp1 = new Timestamp(date.getTime());
			    FeeStructureForKAR.setChallanCreatedDate(timeStamp1);   	
		 Integer total= ReimbursementOFSalaryDeduction+ClosingFD+KSBCCostReceipt+ElectionRules;
		 total+=NominationForm+VoterCD+ElectionDeposit+PDC+DOBCertificate+PostageReceipts+DuplicateEnrollment+EndomentCertificate;
		 total+=KSBCInterestONFD+EnrollmentApplication+IdentityCard+ComplaintFee+ChangeOfAddress+ContinuityCertificate;
		 total+=VSP+ProcessFee+miscReceipts+NOC+ChangeOfNamePublication+GOvtGrant+Resumption + CertificateCopyCharges;
		 
		 
		 System.out.println(total);
		 /*if (EnrollmentFee>0)
		 {
			 mapChallanScannedCopy.put("EnrollmentFee", EnrollmentFee);
		 }*/
		 
		/* changeofNamePublication*/
		 
		 if (GOvtGrant>0)
		 {
			 BeanSaveId = (int)  Session.save(FeeStructureForKAR);
			 Session.beginTransaction().commit();
			  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
			  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
			  CashSectionMonthlyReportFlow.setAmount(GOvtGrant);
			  CashSectionMonthlyReportFlow.setKAWF(0);
			  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
			  CashSectionMonthlyReportFlow.setParticulars("GOvt Grant");
			  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DDDate:"+DDDate);
			  }
			  else
			  {
				  CashSectionMonthlyReportFlow.setPaymode("Cash");
					 
			  }
			  
			   if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\t"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DDDate:"+DDDate);
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
			  CashSectionMonthlyReportFlow.setMisc(GOvtGrant);
			  CashSectionMonthlyReportFlow.setPlace(Place);
			  CashSectionMonthlyReportFlow.setSTAMP(0);
			  System.out.println(" Persist  #####################################");
			  
			  CashSectionMonthlyReport.setAmount(GOvtGrant);
			  CashSectionMonthlyReport.setKAWF(0);
			  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEnrollNo(KARNumber);
			  CashSectionMonthlyReport.setParticulars("Resumption");
			//  CashSectionMonthlyReport.setPaymode("Offline");
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEntFee(0);
			  CashSectionMonthlyReport.setFDS(0);
			  CashSectionMonthlyReport.setIC(0);
			  CashSectionMonthlyReport.setKLA(0);
			  CashSectionMonthlyReport.setMisc(GOvtGrant);
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
			//  String Id=Session.save(CashSectionMonthlyReport);
		//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
				
		 
	
			 
			 mapChallanScannedCopy.put("Govt Grant", GOvtGrant);
		 }
		 
		 
		 
		 if (Resumption>0)
		 {
			  BeanSaveId = (int)  Session.save(FeeStructureForKAR);Session.beginTransaction().commit();
			  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
			  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
			  CashSectionMonthlyReportFlow.setAmount(Resumption);
			  CashSectionMonthlyReportFlow.setKAWF(0);
			  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
			  CashSectionMonthlyReportFlow.setParticulars("Resumption");
			  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DDDate:"+DDDate);
			  }
			  else
			  {
				  CashSectionMonthlyReportFlow.setPaymode("Cash");
					 
			  }
			  
			   if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\t"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DDDate:"+DDDate);
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
			  CashSectionMonthlyReportFlow.setMisc(Resumption);
			  CashSectionMonthlyReportFlow.setPlace(Place);
			  CashSectionMonthlyReportFlow.setSTAMP(0);
			  System.out.println(" Persist  #####################################");
			  
			  CashSectionMonthlyReport.setAmount(Resumption);
			  CashSectionMonthlyReport.setKAWF(0);
			  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEnrollNo(KARNumber);
			  CashSectionMonthlyReport.setParticulars("Resumption");
			//  CashSectionMonthlyReport.setPaymode("Offline");
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEntFee(0);
			  CashSectionMonthlyReport.setFDS(0);
			  CashSectionMonthlyReport.setIC(0);
			  CashSectionMonthlyReport.setKLA(0);
			  CashSectionMonthlyReport.setMisc(Resumption);
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
			//  String Id=Session.save(CashSectionMonthlyReport);
		//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
				
		 
	
			 
			 mapChallanScannedCopy.put("Resumption", Resumption);
		 }
		 
		 //Resumption
		 
		 if (ChangeOfAddress>0)
		 {
			  BeanSaveId = (int)  Session.save(FeeStructureForKAR);
			  Session.beginTransaction().commit();
			  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
			  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
			  CashSectionMonthlyReportFlow.setAmount(ChangeOfAddress);
			  CashSectionMonthlyReportFlow.setKAWF(0);
			  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
			  CashSectionMonthlyReportFlow.setParticulars("Change Of Address");
			  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DDDate:"+DDDate);
			  }
			  else
			  {
				  CashSectionMonthlyReportFlow.setPaymode("Cash");
					 
			  }
			  
			   if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\t"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DDDate:"+DDDate);
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
			  CashSectionMonthlyReportFlow.setMisc(ChangeOfAddress);
			  CashSectionMonthlyReportFlow.setPlace(Place);
			  CashSectionMonthlyReportFlow.setSTAMP(0);
			  System.out.println(" Persist  #####################################");
			  
			  CashSectionMonthlyReport.setAmount(ChangeOfAddress);
			  CashSectionMonthlyReport.setKAWF(0);
			  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEnrollNo(KARNumber);
			  CashSectionMonthlyReport.setParticulars("Change Of Address");
			//  CashSectionMonthlyReport.setPaymode("Offline");
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEntFee(0);
			  CashSectionMonthlyReport.setFDS(0);
			  CashSectionMonthlyReport.setIC(0);
			  CashSectionMonthlyReport.setKLA(0);
			  CashSectionMonthlyReport.setMisc(ChangeOfAddress);
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
				
		 
	
			 
			 mapChallanScannedCopy.put("Change Of Address", ChangeOfAddress);
		 }
		 
		 
		 
		 
		 if (ClosingFD>0)
		 {
			  BeanSaveId = (int)  Session.save(FeeStructureForKAR);Session.beginTransaction().commit();
			  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
			  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
			  CashSectionMonthlyReportFlow.setAmount(ClosingFD);
			  CashSectionMonthlyReportFlow.setKAWF(0);
			  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
			  CashSectionMonthlyReportFlow.setParticulars("KSBC ClosingFD");
			  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);
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
			  CashSectionMonthlyReportFlow.setMisc(ClosingFD);
			  CashSectionMonthlyReportFlow.setPlace(Place);
			  CashSectionMonthlyReportFlow.setSTAMP(0);
			  System.out.println(" Persist  #####################################");
			  
			  CashSectionMonthlyReport.setAmount(ClosingFD);
			  CashSectionMonthlyReport.setKAWF(0);
			  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEnrollNo(KARNumber);
			  CashSectionMonthlyReport.setParticulars("KSBC ClosingFD");
			//  CashSectionMonthlyReport.setPaymode("Offline");
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEntFee(0);
			  CashSectionMonthlyReport.setFDS(0);
			  CashSectionMonthlyReport.setIC(0);
			  CashSectionMonthlyReport.setKLA(0);
			  CashSectionMonthlyReport.setMisc(ClosingFD);
			  CashSectionMonthlyReport.setPlace(Place);
			  CashSectionMonthlyReport.setSTAMP(0);
			  CashSectionMonthlyReport.setOperator(Operator);
			  CashSectionMonthlyReportFlow.setOperator(Operator); 
			  CashSectionMonthlyReportFlow.setName(Name);
			  CashSectionMonthlyReport.setName(Name); 
			  
			  
			  //Tx.begin();
			  try
			  {
			//Serializable
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
			//  String Id=Session.save(CashSectionMonthlyReport);
		//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
				
		 
	
			 
			 mapChallanScannedCopy.put("Closing FD", ClosingFD); 
		 } 
		 
	
		 
		 if (KSBCCostReceipt>0)
		 {
			  BeanSaveId = (int)  Session.save(FeeStructureForKAR);Session.beginTransaction().commit();
			  
			  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
			  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
			  CashSectionMonthlyReportFlow.setAmount(KSBCCostReceipt);
			  CashSectionMonthlyReportFlow.setKAWF(0);
			  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
			  CashSectionMonthlyReportFlow.setParticulars("KSBC Cost Receipt");
			  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);
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
					 
			  }  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEntFee(0);
			  CashSectionMonthlyReportFlow.setFDS(0);
			  CashSectionMonthlyReportFlow.setIC(0);
			  CashSectionMonthlyReportFlow.setKLA(0);
			  CashSectionMonthlyReportFlow.setMisc(KSBCCostReceipt);
			  CashSectionMonthlyReportFlow.setPlace(Place);
			  CashSectionMonthlyReportFlow.setSTAMP(0);
			  System.out.println(" Persist  #####################################");
			  
			  CashSectionMonthlyReport.setAmount(KSBCCostReceipt);
			  CashSectionMonthlyReport.setKAWF(0);
			  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEnrollNo(KARNumber);
			  CashSectionMonthlyReport.setParticulars("KSBC Cost Receipt");
			//  CashSectionMonthlyReport.setPaymode("Offline");
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEntFee(0);
			  CashSectionMonthlyReport.setFDS(0);
			  CashSectionMonthlyReport.setIC(0);
			  CashSectionMonthlyReport.setKLA(0);
			  CashSectionMonthlyReport.setMisc(KSBCCostReceipt);
			  CashSectionMonthlyReport.setPlace(Place);
			  CashSectionMonthlyReport.setSTAMP(0);
			  CashSectionMonthlyReport.setOperator(Operator);
			  CashSectionMonthlyReportFlow.setOperator(Operator); 
			  CashSectionMonthlyReportFlow.setName(Name);
			  CashSectionMonthlyReport.setName(Name); 
			  
			  
			  //Tx.begin();
			  try
			  {
			//Serializable
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
			//  String Id=Session.save(CashSectionMonthlyReport);
		//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
				
		 
	
			 mapChallanScannedCopy.put("KSBC Cost Receipt", KSBCCostReceipt); 
		 } 
	
		 
		 if (ElectionRules>0)
		 {  
			  BeanSaveId = (int)  Session.save(FeeStructureForKAR);Session.beginTransaction().commit();
			  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
			  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
			  CashSectionMonthlyReportFlow.setAmount(ElectionRules);
			  CashSectionMonthlyReportFlow.setKAWF(0);
			  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
			  CashSectionMonthlyReportFlow.setParticulars("KSBC Election Rulest");
			  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);
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
			  CashSectionMonthlyReportFlow.setMisc(ElectionRules);
			  CashSectionMonthlyReportFlow.setPlace(Place);
			  CashSectionMonthlyReportFlow.setSTAMP(0);
			  System.out.println(" Persist  #####################################");
			  
			  CashSectionMonthlyReport.setAmount(ElectionRules);
			  CashSectionMonthlyReport.setKAWF(0);
			  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEnrollNo(KARNumber);
			  CashSectionMonthlyReport.setParticulars("KSBC Election Rules");
			 // CashSectionMonthlyReport.setPaymode("Offline");
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEntFee(0);
			  CashSectionMonthlyReport.setFDS(0);
			  CashSectionMonthlyReport.setIC(0);
			  CashSectionMonthlyReport.setKLA(0);
			  CashSectionMonthlyReport.setMisc(ElectionRules);
			  CashSectionMonthlyReport.setPlace(Place);
			  CashSectionMonthlyReport.setSTAMP(0);
			  CashSectionMonthlyReport.setOperator(Operator);
			  CashSectionMonthlyReportFlow.setOperator(Operator); 
			  CashSectionMonthlyReportFlow.setName(Name);
			  CashSectionMonthlyReport.setName(Name); 
			  
			   
			  //Tx.begin();
			  try
			  {
			//Serializable
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
			//  String Id=Session.save(CashSectionMonthlyReport);
		//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
				
	
			 mapChallanScannedCopy.put("Election Rules", ElectionRules); 
		 }  
	
		 
		 if (NominationForm>0)
		 {		  
			  BeanSaveId = (int)  Session.save(FeeStructureForKAR);Session.beginTransaction().commit(); 
			 CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
			  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
			  CashSectionMonthlyReportFlow.setAmount(NominationForm);
			  CashSectionMonthlyReportFlow.setKAWF(0);
			  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
			  CashSectionMonthlyReportFlow.setParticulars("KSBC Nomination Form");
			  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);
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
					 
			  }  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEntFee(0);
			  CashSectionMonthlyReportFlow.setFDS(0);
			  CashSectionMonthlyReportFlow.setIC(0);
			  CashSectionMonthlyReportFlow.setKLA(0);
			  CashSectionMonthlyReportFlow.setMisc(NominationForm);
			  CashSectionMonthlyReportFlow.setPlace(Place);
			  CashSectionMonthlyReportFlow.setSTAMP(0);
			  System.out.println(" Persist  #####################################");
			  
			  CashSectionMonthlyReport.setAmount(NominationForm);
			  CashSectionMonthlyReport.setKAWF(0);
			  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEnrollNo(KARNumber);
			  CashSectionMonthlyReport.setParticulars("KSBC Nomination Form");
			//  CashSectionMonthlyReport.setPaymode("Offline");
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEntFee(0);
			  CashSectionMonthlyReport.setFDS(0);
			  CashSectionMonthlyReport.setIC(0);
			  CashSectionMonthlyReport.setKLA(0);
			  CashSectionMonthlyReport.setMisc(NominationForm);
			  CashSectionMonthlyReport.setPlace(Place);
			  CashSectionMonthlyReport.setSTAMP(0);
			  CashSectionMonthlyReport.setOperator(Operator);
			  CashSectionMonthlyReportFlow.setOperator(Operator); 
			  CashSectionMonthlyReportFlow.setName(Name);
			  CashSectionMonthlyReport.setName(Name); 
			  
			   
			  //Tx.begin();
			  try
			  {
			//Serializable
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
			//  String Id=Session.save(CashSectionMonthlyReport);
		//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
					 mapChallanScannedCopy.put("Nomination Form", NominationForm); 
					 
		 }  
		 
	
		 if (VoterCD>0)
		 {		  
			  BeanSaveId = (int)  Session.save(FeeStructureForKAR);Session.beginTransaction().commit(); 
			 CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
			  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
			  CashSectionMonthlyReportFlow.setAmount(VoterCD);
			  CashSectionMonthlyReportFlow.setKAWF(0);
			  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
			  CashSectionMonthlyReportFlow.setParticulars("KSBC VoterCD");
			  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);
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
					 
			  }  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEntFee(0);
			  CashSectionMonthlyReportFlow.setFDS(0);
			  CashSectionMonthlyReportFlow.setIC(0);
			  CashSectionMonthlyReportFlow.setKLA(0);
			  CashSectionMonthlyReportFlow.setMisc(VoterCD);
			  CashSectionMonthlyReportFlow.setPlace(Place);
			  CashSectionMonthlyReportFlow.setSTAMP(0);
			  System.out.println(" Persist  #####################################");
			  
			  CashSectionMonthlyReport.setAmount(VoterCD);
			  CashSectionMonthlyReport.setKAWF(0);
			  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEnrollNo(KARNumber);
			  CashSectionMonthlyReport.setParticulars("KSBC VoterCD");
			//  CashSectionMonthlyReport.setPaymode("Offline");
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEntFee(0);
			  CashSectionMonthlyReport.setFDS(0);
			  CashSectionMonthlyReport.setIC(0);
			  CashSectionMonthlyReport.setKLA(0);
			  CashSectionMonthlyReport.setMisc(VoterCD);
			  CashSectionMonthlyReport.setPlace(Place);
			  CashSectionMonthlyReport.setSTAMP(0);
			  CashSectionMonthlyReport.setOperator(Operator);
			  CashSectionMonthlyReportFlow.setOperator(Operator); 
			  CashSectionMonthlyReportFlow.setName(Name);
			  CashSectionMonthlyReport.setName(Name); 
			  
			     
			  //Tx.begin();
			  try
			  {
			//Serializable
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
			//  String Id=Session.save(CashSectionMonthlyReport);
		//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
					 
	
			 mapChallanScannedCopy.put("Voter CD", VoterCD); 
		 } 
		 
	
		 if (ElectionDeposit>0)
		 {	
			  BeanSaveId = (int)  Session.save(FeeStructureForKAR);Session.beginTransaction().commit();
			  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
			  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
			  CashSectionMonthlyReportFlow.setAmount(ElectionDeposit);
			  CashSectionMonthlyReportFlow.setKAWF(0);
			  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
			  CashSectionMonthlyReportFlow.setParticulars("KSBC Election Deposit");
			  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);
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
					 
			  }  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEntFee(0);
			  CashSectionMonthlyReportFlow.setFDS(0);
			  CashSectionMonthlyReportFlow.setIC(0);
			  CashSectionMonthlyReportFlow.setKLA(0);
			  CashSectionMonthlyReportFlow.setMisc(ElectionDeposit);
			  CashSectionMonthlyReportFlow.setPlace(Place);
			  CashSectionMonthlyReportFlow.setSTAMP(0);
			  System.out.println(" Persist  #####################################");
			  
			  CashSectionMonthlyReport.setAmount(ElectionDeposit);
			  CashSectionMonthlyReport.setKAWF(0);
			  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEnrollNo(KARNumber);
			  CashSectionMonthlyReport.setParticulars("KSBC Election Deposit");
		//	  CashSectionMonthlyReport.setPaymode("Offline");
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEntFee(0);
			  CashSectionMonthlyReport.setFDS(0);
			  CashSectionMonthlyReport.setIC(0);
			  CashSectionMonthlyReport.setKLA(0);
			  CashSectionMonthlyReport.setMisc(ElectionDeposit);
			  CashSectionMonthlyReport.setPlace(Place);
			  CashSectionMonthlyReport.setSTAMP(0);
			  CashSectionMonthlyReport.setOperator(Operator);
			  CashSectionMonthlyReportFlow.setOperator(Operator); 
			  CashSectionMonthlyReportFlow.setName(Name);
			  CashSectionMonthlyReport.setName(Name); 
			  
			  
			  //Tx.begin();
			  try
			  {
			//Serializable
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
			//  String Id=Session.save(CashSectionMonthlyReport);
		//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
							
		 
	
			 mapChallanScannedCopy.put("Election Deposit", ElectionDeposit); 
		 }   
		 
	
		 if (PDC>0)
		 {		
			  BeanSaveId = (int)  Session.save(FeeStructureForKAR);Session.beginTransaction().commit();
			  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
			  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
			  CashSectionMonthlyReportFlow.setAmount(PDC);
			  CashSectionMonthlyReportFlow.setKAWF(0);
			  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
			  CashSectionMonthlyReportFlow.setParticulars("KSBC PDC");
			  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);
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
			  CashSectionMonthlyReportFlow.setMisc(PDC);
			  CashSectionMonthlyReportFlow.setPlace(Place);
			  CashSectionMonthlyReportFlow.setSTAMP(0);
			  System.out.println(" Persist  #####################################");
			  
			  CashSectionMonthlyReport.setAmount(PDC);
			  CashSectionMonthlyReport.setKAWF(0);
			  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEnrollNo(KARNumber);
			  CashSectionMonthlyReport.setParticulars("KSBC PDC");
			//  CashSectionMonthlyReport.setPaymode("Offline");
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEntFee(0);
			  CashSectionMonthlyReport.setFDS(0);
			  CashSectionMonthlyReport.setIC(0);
			  CashSectionMonthlyReport.setKLA(0);
			  CashSectionMonthlyReport.setMisc(PDC);
			  CashSectionMonthlyReport.setPlace(Place);
			  CashSectionMonthlyReport.setSTAMP(0);
			  CashSectionMonthlyReport.setOperator(Operator);
			  CashSectionMonthlyReportFlow.setOperator(Operator); 
			  CashSectionMonthlyReportFlow.setName(Name);
			  CashSectionMonthlyReport.setName(Name); 
			  
			   
			  //Tx.begin();
			  try
			  {
			//Serializable
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
			//  String Id=Session.save(CashSectionMonthlyReport);
		//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
							
		 
	
			 mapChallanScannedCopy.put("PDC", PDC); 
		 }  
		 
	
		 if (DOBCertificate>0)
		 {	
			  BeanSaveId = (int)  Session.save(FeeStructureForKAR);Session.beginTransaction().commit();
			  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
			  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
			  CashSectionMonthlyReportFlow.setAmount(DOBCertificate);
			  CashSectionMonthlyReportFlow.setKAWF(0);
			  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
			  CashSectionMonthlyReportFlow.setParticulars("KSBC DOB Certificate");
			  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);
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
					 
			  }  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEntFee(0);
			  CashSectionMonthlyReportFlow.setFDS(0);
			  CashSectionMonthlyReportFlow.setIC(0);
			  CashSectionMonthlyReportFlow.setKLA(0);
			  CashSectionMonthlyReportFlow.setMisc(DOBCertificate);
			  CashSectionMonthlyReportFlow.setPlace(Place);
			  CashSectionMonthlyReportFlow.setSTAMP(0);
			  System.out.println(" Persist  #####################################");
			  
			  CashSectionMonthlyReport.setAmount(DOBCertificate);
			  CashSectionMonthlyReport.setKAWF(0);
			  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEnrollNo(KARNumber);
			  CashSectionMonthlyReport.setParticulars("KSBC DOB Certificate");
			 // CashSectionMonthlyReport.setPaymode("Offline");
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEntFee(0);
			  CashSectionMonthlyReport.setFDS(0);
			  CashSectionMonthlyReport.setIC(0);
			  CashSectionMonthlyReport.setKLA(0);
			  CashSectionMonthlyReport.setMisc(DOBCertificate);
			  CashSectionMonthlyReport.setPlace(Place);
			  CashSectionMonthlyReport.setSTAMP(0);
			  CashSectionMonthlyReport.setOperator(Operator);
			  CashSectionMonthlyReportFlow.setOperator(Operator); 
			  CashSectionMonthlyReportFlow.setName(Name);
			  CashSectionMonthlyReport.setName(Name); 
			  
			  
			  //Tx.begin();
			  try
			  {
			//Serializable
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
			//  String Id=Session.save(CashSectionMonthlyReport);
		//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
							
		 
	
			 mapChallanScannedCopy.put("DOB Certificate", DOBCertificate); 
		 }   
		 
	
		 if (CertificateCopyCharges>0)
		 {	
			  BeanSaveId = (int)  Session.save(FeeStructureForKAR);Session.beginTransaction().commit();
			  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
			  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
			  CashSectionMonthlyReportFlow.setAmount(CertificateCopyCharges);
			  CashSectionMonthlyReportFlow.setKAWF(0);
			  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
			  CashSectionMonthlyReportFlow.setParticulars("KSBC Certificate Copy Charges");
			  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);
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
					 
			  }	  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEntFee(0);
			  CashSectionMonthlyReportFlow.setFDS(0);
			  CashSectionMonthlyReportFlow.setIC(0);
			  CashSectionMonthlyReportFlow.setKLA(0);
			  CashSectionMonthlyReportFlow.setMisc(CertificateCopyCharges);
			  CashSectionMonthlyReportFlow.setPlace(Place);
			  CashSectionMonthlyReportFlow.setSTAMP(0);
			  System.out.println(" Persist  #####################################");
			  
			  CashSectionMonthlyReport.setAmount(CertificateCopyCharges);
			  CashSectionMonthlyReport.setKAWF(0);
			  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEnrollNo(KARNumber);
			  CashSectionMonthlyReport.setParticulars("KSBC Certificate Copy Charges");
			//  CashSectionMonthlyReport.setPaymode("Offline");
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEntFee(0);
			  CashSectionMonthlyReport.setFDS(0);
			  CashSectionMonthlyReport.setIC(0);
			  CashSectionMonthlyReport.setKLA(0);
			  CashSectionMonthlyReport.setMisc(CertificateCopyCharges);
			  CashSectionMonthlyReport.setPlace(Place);
			  CashSectionMonthlyReport.setSTAMP(0);
			  CashSectionMonthlyReport.setOperator(Operator);
			  CashSectionMonthlyReportFlow.setOperator(Operator); 
			  CashSectionMonthlyReportFlow.setName(Name);
			  CashSectionMonthlyReport.setName(Name); 
			  
			   
			  //Tx.begin();
			  try
			  {
			//Serializable
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
			//  String Id=Session.save(CashSectionMonthlyReport);
		//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
							
		 
	
			 mapChallanScannedCopy.put("Certificate Copy Charges", CertificateCopyCharges); 
		 }
	
		 if (PostageReceipts>0)
		 {		
			  BeanSaveId = (int)  Session.save(FeeStructureForKAR);Session.beginTransaction().commit();
			 
			  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
			  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
			  CashSectionMonthlyReportFlow.setAmount(PostageReceipts);
			  CashSectionMonthlyReportFlow.setKAWF(0);
			  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
			  CashSectionMonthlyReportFlow.setParticulars("KSBC Postage Receipts");
			  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);
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
					 
			  }  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEntFee(0);
			  CashSectionMonthlyReportFlow.setFDS(0);
			  CashSectionMonthlyReportFlow.setIC(0);
			  CashSectionMonthlyReportFlow.setKLA(0);
			  CashSectionMonthlyReportFlow.setMisc(PostageReceipts);
			  CashSectionMonthlyReportFlow.setPlace(Place);
			  CashSectionMonthlyReportFlow.setSTAMP(0);
			  System.out.println(" Persist  #####################################");
			  
			  CashSectionMonthlyReport.setAmount(PostageReceipts);
			  CashSectionMonthlyReport.setKAWF(0);
			  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEnrollNo(KARNumber);
			  CashSectionMonthlyReport.setParticulars("KSBC Postage Receipts");
			//  CashSectionMonthlyReport.setPaymode("Offline");
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEntFee(0);
			  CashSectionMonthlyReport.setFDS(0);
			  CashSectionMonthlyReport.setIC(0);
			  CashSectionMonthlyReport.setKLA(0);
			  CashSectionMonthlyReport.setMisc(PostageReceipts);
			  CashSectionMonthlyReport.setPlace(Place);
			  CashSectionMonthlyReport.setSTAMP(0);
			  CashSectionMonthlyReport.setOperator(Operator);
			  CashSectionMonthlyReportFlow.setOperator(Operator); 
			  CashSectionMonthlyReportFlow.setName(Name);
			  CashSectionMonthlyReport.setName(Name); 
			  
			  
			  //Tx.begin();
			  try
			  {
			//Serializable
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
			//  String Id=Session.save(CashSectionMonthlyReport);
		//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
							
		 
	
			 mapChallanScannedCopy.put("Postage Receipts", PostageReceipts); 
		 }
	
		 if (DuplicateEnrollment>0)
		 {		  
			  BeanSaveId = (int)  Session.save(FeeStructureForKAR);Session.beginTransaction().commit();
			  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
			  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
			  CashSectionMonthlyReportFlow.setAmount(DuplicateEnrollment);
			  CashSectionMonthlyReportFlow.setKAWF(0);
			  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
			  CashSectionMonthlyReportFlow.setParticulars("KSBC Duplicate Enrollment");
			  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);
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
					 
			  }  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEntFee(0);
			  CashSectionMonthlyReportFlow.setFDS(0);
			  CashSectionMonthlyReportFlow.setIC(0);
			  CashSectionMonthlyReportFlow.setKLA(0);
			  CashSectionMonthlyReportFlow.setMisc(DuplicateEnrollment);
			  CashSectionMonthlyReportFlow.setPlace(Place);
			  CashSectionMonthlyReportFlow.setSTAMP(0);
			  System.out.println(" Persist  #####################################");
			  
			  CashSectionMonthlyReport.setAmount(DuplicateEnrollment);
			  CashSectionMonthlyReport.setKAWF(0);
			  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEnrollNo(KARNumber);
			  CashSectionMonthlyReport.setParticulars("KSBC Duplicate Enrollment");
			//  CashSectionMonthlyReport.setPaymode("Offline");
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEntFee(0);
			  CashSectionMonthlyReport.setFDS(0);
			  CashSectionMonthlyReport.setIC(0);
			  CashSectionMonthlyReport.setKLA(0);
			  CashSectionMonthlyReport.setMisc(DuplicateEnrollment);
			  CashSectionMonthlyReport.setPlace(Place);
			  CashSectionMonthlyReport.setSTAMP(0);
			  CashSectionMonthlyReport.setOperator(Operator);
			  CashSectionMonthlyReportFlow.setOperator(Operator); 
			  CashSectionMonthlyReportFlow.setName(Name);
			  CashSectionMonthlyReport.setName(Name); 
			  
			   
			  //Tx.begin();
			  try
			  {
			//Serializable
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
			//  String Id=Session.save(CashSectionMonthlyReport);
		//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
					 
	
			 
			 mapChallanScannedCopy.put("Duplicate Enrollment", DuplicateEnrollment);  
		 }  
	
		 
		 
		 if (EndomentCertificate>0)
		 {		 
			  BeanSaveId = (int)  Session.save(FeeStructureForKAR);Session.beginTransaction().commit();
			  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
			  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
			  CashSectionMonthlyReportFlow.setAmount(EndomentCertificate);
			  CashSectionMonthlyReportFlow.setKAWF(0);
			  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
			  CashSectionMonthlyReportFlow.setParticulars("KSBC Endoment Certificate");
			  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);
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
					 
			  }  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEntFee(0);
			  CashSectionMonthlyReportFlow.setFDS(0);
			  CashSectionMonthlyReportFlow.setIC(0);
			  CashSectionMonthlyReportFlow.setKLA(0);
			  CashSectionMonthlyReportFlow.setMisc(EndomentCertificate);
			  CashSectionMonthlyReportFlow.setPlace(Place);
			  CashSectionMonthlyReportFlow.setSTAMP(0);
			  System.out.println(" Persist  #####################################");
			  
			  CashSectionMonthlyReport.setAmount(EndomentCertificate);
			  CashSectionMonthlyReport.setKAWF(0);
			  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEnrollNo(KARNumber);
			  CashSectionMonthlyReport.setParticulars("KSBC Endoment Certificate");
			//  CashSectionMonthlyReport.setPaymode("Offline");
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEntFee(0);
			  CashSectionMonthlyReport.setFDS(0);
			  CashSectionMonthlyReport.setIC(0);
			  CashSectionMonthlyReport.setKLA(0);
			  CashSectionMonthlyReport.setMisc(EndomentCertificate);
			  CashSectionMonthlyReport.setPlace(Place);
			  CashSectionMonthlyReport.setSTAMP(0);
			  CashSectionMonthlyReport.setOperator(Operator);
			  CashSectionMonthlyReportFlow.setOperator(Operator); 
			  CashSectionMonthlyReportFlow.setName(Name);
			  CashSectionMonthlyReport.setName(Name); 
			  
			  
			  //Tx.begin();
			  try
			  {
			//Serializable
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
			//  String Id=Session.save(CashSectionMonthlyReport);
		//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
							
		 
	
			 
			 mapChallanScannedCopy.put("Endoment Certificate", EndomentCertificate);  
		 } 
		 
		 
		 
		 
		 
		 
		 
		 if (KSBCInterestONFD>0)
		 {		  
			 
			  BeanSaveId = (int)  Session.save(FeeStructureForKAR);Session.beginTransaction().commit();
			  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
			  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
			  CashSectionMonthlyReportFlow.setAmount(KSBCInterestONFD);
			  CashSectionMonthlyReportFlow.setKAWF(0);
			  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
			  CashSectionMonthlyReportFlow.setParticulars("KSBC KSBC Interest On FD");
			  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);
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
					 
			  }  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEntFee(0);
			  CashSectionMonthlyReportFlow.setFDS(0);
			  CashSectionMonthlyReportFlow.setIC(0);
			  CashSectionMonthlyReportFlow.setKLA(0);
			  CashSectionMonthlyReportFlow.setMisc(KSBCInterestONFD);
			  CashSectionMonthlyReportFlow.setPlace(Place);
			  CashSectionMonthlyReportFlow.setSTAMP(0);
			  System.out.println(" Persist  #####################################");
			  
			  CashSectionMonthlyReport.setAmount(KSBCInterestONFD);
			  CashSectionMonthlyReport.setKAWF(0);
			  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEnrollNo(KARNumber);
			  CashSectionMonthlyReport.setParticulars("KSBC KSBC Interest On FD");
			//  CashSectionMonthlyReport.setPaymode("Offline");
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEntFee(0);
			  CashSectionMonthlyReport.setFDS(0);
			  CashSectionMonthlyReport.setIC(0);
			  CashSectionMonthlyReport.setKLA(0);
			  CashSectionMonthlyReport.setMisc(KSBCInterestONFD);
			  CashSectionMonthlyReport.setPlace(Place);
			  CashSectionMonthlyReport.setSTAMP(0);
			  CashSectionMonthlyReport.setOperator(Operator);
			  CashSectionMonthlyReportFlow.setOperator(Operator); 
			  CashSectionMonthlyReportFlow.setName(Name);
			  CashSectionMonthlyReport.setName(Name); 
			  
			  
			  //Tx.begin();
			  try
			  {
			//Serializable
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
			//  String Id=Session.save(CashSectionMonthlyReport);
		//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
							
		 
	
			 mapChallanScannedCopy.put("KSBC Interest On FD", KSBCInterestONFD); 
		 }   
		 
		 if (EnrollmentApplication>0)
		 {	
			 
			  BeanSaveId = (int)  Session.save(FeeStructureForKAR);Session.beginTransaction().commit();
			 
			  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
			  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
			  CashSectionMonthlyReportFlow.setAmount(EnrollmentApplication);
			  CashSectionMonthlyReportFlow.setKAWF(0);
			  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
			  CashSectionMonthlyReportFlow.setParticulars("KSBC Enrollment Application");
			  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);
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
					 
			  }  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEntFee(0);
			  CashSectionMonthlyReportFlow.setFDS(0);
			  CashSectionMonthlyReportFlow.setIC(0);
			  CashSectionMonthlyReportFlow.setKLA(0);
			  CashSectionMonthlyReportFlow.setMisc(EnrollmentApplication);
			  CashSectionMonthlyReportFlow.setPlace(Place);
			  CashSectionMonthlyReportFlow.setSTAMP(0);
			  System.out.println(" Persist  #####################################");
			  
			  CashSectionMonthlyReport.setAmount(EnrollmentApplication);
			  CashSectionMonthlyReport.setKAWF(0);
			  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEnrollNo(KARNumber);
			  CashSectionMonthlyReport.setParticulars("KSBC Enrollment Application");
			//  CashSectionMonthlyReport.setPaymode("Offline");
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEntFee(0);
			  CashSectionMonthlyReport.setFDS(0);
			  CashSectionMonthlyReport.setIC(0);
			  CashSectionMonthlyReport.setKLA(0);
			  CashSectionMonthlyReport.setMisc(EnrollmentApplication);
			  CashSectionMonthlyReport.setPlace(Place);
			  CashSectionMonthlyReport.setSTAMP(0);
			  CashSectionMonthlyReport.setOperator(Operator);
			  CashSectionMonthlyReportFlow.setOperator(Operator); 
			  CashSectionMonthlyReportFlow.setName(Name);
			  CashSectionMonthlyReport.setName(Name); 
			  
			     
			  //Tx.begin();
			  try
			  {
			//Serializable
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
			//  String Id=Session.save(CashSectionMonthlyReport);
		//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
					 
	
			 mapChallanScannedCopy.put("Enrollment Application", EnrollmentApplication); 
		 }  
		 
		 if (IdentityCard>0)
		 {		
			 
			  BeanSaveId = (int)  Session.save(FeeStructureForKAR);Session.beginTransaction().commit();
			  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
			  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
			  CashSectionMonthlyReportFlow.setAmount(IdentityCard);
			  CashSectionMonthlyReportFlow.setKAWF(0);
			  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
			  CashSectionMonthlyReportFlow.setParticulars("KSBC IdentityCard");
			  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);
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
					 
			  }  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEntFee(0);
			  CashSectionMonthlyReportFlow.setFDS(0);
			  CashSectionMonthlyReportFlow.setIC(IdentityCard);
			  CashSectionMonthlyReportFlow.setKLA(0);
			  CashSectionMonthlyReportFlow.setMisc(0);
			  CashSectionMonthlyReportFlow.setPlace(Place);
			  CashSectionMonthlyReportFlow.setSTAMP(0);
			  System.out.println(" Persist  #####################################");
			  
			  CashSectionMonthlyReport.setAmount(IdentityCard);
			  CashSectionMonthlyReport.setKAWF(0);
			  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEnrollNo(KARNumber);
			  CashSectionMonthlyReport.setParticulars("KSBC IdentityCard");
			//  CashSectionMonthlyReport.setPaymode("Offline");
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEntFee(0);
			  CashSectionMonthlyReport.setFDS(0);
			  CashSectionMonthlyReport.setIC(IdentityCard);
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
			//Serializable
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
			//  String Id=Session.save(CashSectionMonthlyReport);
		//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
					 
	
			 mapChallanScannedCopy.put("Identity Card", IdentityCard); 
		 }   
		 
		
		 if (ComplaintFee>0)
		 {	
			  BeanSaveId = (int)  Session.save(FeeStructureForKAR);Session.beginTransaction().commit();
			  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
			  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
			  CashSectionMonthlyReportFlow.setAmount(ComplaintFee);
			  CashSectionMonthlyReportFlow.setKAWF(0);
			  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
			  CashSectionMonthlyReportFlow.setParticulars("KSBC ComplaintFee");
			  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);
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
					 
			  }  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEntFee(0);
			  CashSectionMonthlyReportFlow.setFDS(0);
			  CashSectionMonthlyReportFlow.setIC(0);
			  CashSectionMonthlyReportFlow.setKLA(0);
			  CashSectionMonthlyReportFlow.setMisc(ComplaintFee);
			  CashSectionMonthlyReportFlow.setPlace(Place);
			  CashSectionMonthlyReportFlow.setSTAMP(0);
			  System.out.println(" Persist  #####################################");
			  
			  CashSectionMonthlyReport.setAmount(ComplaintFee);
			  CashSectionMonthlyReport.setKAWF(0);
			  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEnrollNo(KARNumber);
			  CashSectionMonthlyReport.setParticulars("KSBC ComplaintFee");
			//  CashSectionMonthlyReport.setPaymode("Offline");
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEntFee(0);
			  CashSectionMonthlyReport.setFDS(0);
			  CashSectionMonthlyReport.setIC(0);
			  CashSectionMonthlyReport.setKLA(0);
			  CashSectionMonthlyReport.setMisc(ComplaintFee);
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
			//Serializable
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
			//  String Id=Session.save(CashSectionMonthlyReport);
		//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
							
		 
	
			 mapChallanScannedCopy.put("Complaint Fee", ComplaintFee); 
		 }
		
	/*	 if (ChangeOfAddress>0)
		 {		
			  BeanSaveId = (int)  Session.save(FeeStructureForKAR);Session.beginTransaction().commit();
			  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
			  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
			  CashSectionMonthlyReportFlow.setAmount(ChangeOfAddress);
			  CashSectionMonthlyReportFlow.setKAWF(0);
			  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
			  CashSectionMonthlyReportFlow.setParticulars("KSBC Change Of Address");
			  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);
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
					 
			  }  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEntFee(0);
			  CashSectionMonthlyReportFlow.setFDS(0);
			  CashSectionMonthlyReportFlow.setIC(0);
			  CashSectionMonthlyReportFlow.setKLA(0);
			  CashSectionMonthlyReportFlow.setMisc(ChangeOfAddress);
			  CashSectionMonthlyReportFlow.setPlace(Place);
			  CashSectionMonthlyReportFlow.setSTAMP(0);
			  System.out.println(" Persist  #####################################");
			  
			  CashSectionMonthlyReport.setAmount(ChangeOfAddress);
			  CashSectionMonthlyReport.setKAWF(0);
			  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEnrollNo(KARNumber);
			  CashSectionMonthlyReport.setParticulars("KSBC Change Of Address");
			//  CashSectionMonthlyReport.setPaymode("Offline");
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEntFee(0);
			  CashSectionMonthlyReport.setFDS(0);
			  CashSectionMonthlyReport.setIC(0);
			  CashSectionMonthlyReport.setKLA(0);
			  CashSectionMonthlyReport.setMisc(ChangeOfAddress);
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
			//Serializable
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
			//  String Id=Session.save(CashSectionMonthlyReport);
		//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
					 
	
			 mapChallanScannedCopy.put("Change Of Address", ChangeOfAddress);  
		 } */ 
	
		 if (ContinuityCertificate>0)
		 {		
			  BeanSaveId = (int)  Session.save(FeeStructureForKAR);Session.beginTransaction().commit();
			  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
			  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
			  CashSectionMonthlyReportFlow.setAmount(ContinuityCertificate);
			  CashSectionMonthlyReportFlow.setKAWF(0);
			  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
			  CashSectionMonthlyReportFlow.setParticulars("KSBC Continuity Certificate");
			  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);
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
					 
			  }  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEntFee(0);
			  CashSectionMonthlyReportFlow.setFDS(0);
			  CashSectionMonthlyReportFlow.setIC(0);
			  CashSectionMonthlyReportFlow.setKLA(0);
			  CashSectionMonthlyReportFlow.setMisc(ContinuityCertificate);
			  CashSectionMonthlyReportFlow.setPlace(Place);
			  CashSectionMonthlyReportFlow.setSTAMP(0);
			  System.out.println(" Persist  #####################################");
			  
			  CashSectionMonthlyReport.setAmount(ContinuityCertificate);
			  CashSectionMonthlyReport.setKAWF(0);
			  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEnrollNo(KARNumber);
			  CashSectionMonthlyReport.setParticulars("KSBC Continuity Certificate");
			//  CashSectionMonthlyReport.setPaymode("Offline");
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEntFee(0);
			  CashSectionMonthlyReport.setFDS(0);
			  CashSectionMonthlyReport.setIC(0);
			  CashSectionMonthlyReport.setKLA(0);
			  CashSectionMonthlyReport.setMisc(ContinuityCertificate);
			  CashSectionMonthlyReport.setPlace(Place);
			  CashSectionMonthlyReport.setSTAMP(0);
			  CashSectionMonthlyReport.setOperator(Operator);
			  CashSectionMonthlyReportFlow.setOperator(Operator); 
			  CashSectionMonthlyReportFlow.setName(Name);
			  CashSectionMonthlyReport.setName(Name); 
			  
			   
			  //Tx.begin();
			  try
			  {
			//Serializable
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
			//  String Id=Session.save(CashSectionMonthlyReport);
		//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
							
		 
	
			 mapChallanScannedCopy.put("Continuity Certificate", ContinuityCertificate);  
		 } 
		 
		// PlaceOftheClient
		 if (VSP>0)
		 {		
			  BeanSaveId = (int)  Session.save(FeeStructureForKAR);Session.beginTransaction().commit();
			  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
			  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
			  CashSectionMonthlyReportFlow.setAmount(VSP);
			  CashSectionMonthlyReportFlow.setKAWF(0);
			  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
			  CashSectionMonthlyReportFlow.setParticulars("KSBC VSP");
			  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);
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
					 
			  }  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEntFee(0);
			  CashSectionMonthlyReportFlow.setFDS(0);
			  CashSectionMonthlyReportFlow.setIC(0);
			  CashSectionMonthlyReportFlow.setKLA(0);
			  CashSectionMonthlyReportFlow.setMisc(VSP);
			  CashSectionMonthlyReportFlow.setPlace(Place);
			  CashSectionMonthlyReportFlow.setSTAMP(0);
			  System.out.println(" Persist  #####################################");
			  
			  CashSectionMonthlyReport.setAmount(VSP);
			  CashSectionMonthlyReport.setKAWF(0);
			  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEnrollNo(KARNumber);
			  CashSectionMonthlyReport.setParticulars("KSBC VSP");
			//  CashSectionMonthlyReport.setPaymode("Offline");
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEntFee(0);
			  CashSectionMonthlyReport.setFDS(0);
			  CashSectionMonthlyReport.setIC(0);
			  CashSectionMonthlyReport.setKLA(0);
			  CashSectionMonthlyReport.setMisc(VSP);
			  CashSectionMonthlyReport.setPlace(Place);
			  CashSectionMonthlyReport.setSTAMP(0);
			  CashSectionMonthlyReport.setOperator(Operator);
			  CashSectionMonthlyReportFlow.setOperator(Operator); 
			  CashSectionMonthlyReportFlow.setName(Name);
			  CashSectionMonthlyReport.setName(Name); 
			  
			    
			  //Tx.begin();
			  try
			  {
			//Serializable
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
			//  String Id=Session.save(CashSectionMonthlyReport);
		//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
							
		 
	
			 mapChallanScannedCopy.put("VSP", VSP);  
		 }
		 
		 
		 
		 if (miscReceipts>0)
		 {		
			  BeanSaveId = (int)  Session.save(FeeStructureForKAR);Session.beginTransaction().commit();Session.beginTransaction().commit();
			  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
			  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
			  CashSectionMonthlyReportFlow.setAmount(miscReceipts);
			  CashSectionMonthlyReportFlow.setKAWF(0);
			  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
			  CashSectionMonthlyReportFlow.setParticulars("KSBC Process Fee");
			  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);
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
					 
			  }  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEntFee(0);
			  CashSectionMonthlyReportFlow.setFDS(0);
			  CashSectionMonthlyReportFlow.setIC(0);
			  CashSectionMonthlyReportFlow.setKLA(0);
			  CashSectionMonthlyReportFlow.setMisc(ProcessFee);
			  CashSectionMonthlyReportFlow.setPlace(Place);
			  CashSectionMonthlyReportFlow.setSTAMP(0);
			  System.out.println(" Persist  #####################################");
			  
			  CashSectionMonthlyReport.setAmount(ProcessFee);
			  CashSectionMonthlyReport.setKAWF(0);
			  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEnrollNo(KARNumber);
			  CashSectionMonthlyReport.setParticulars("KSBC Process Fee");
			//  CashSectionMonthlyReport.setPaymode("Offline");
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEntFee(0);
			  CashSectionMonthlyReport.setFDS(0);
			  CashSectionMonthlyReport.setIC(0);
			  CashSectionMonthlyReport.setKLA(0);
			  CashSectionMonthlyReport.setMisc(miscReceipts);
			  CashSectionMonthlyReport.setPlace(Place);
			  CashSectionMonthlyReport.setSTAMP(0);
			  CashSectionMonthlyReport.setOperator(Operator);
			  CashSectionMonthlyReportFlow.setOperator(Operator); 
			  CashSectionMonthlyReportFlow.setName(Name);
			  CashSectionMonthlyReport.setName(Name); 
			  
			  
			  //Tx.begin();
			  try
			  {
			//Serializable
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
			//  String Id=Session.save(CashSectionMonthlyReport);
		//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
					 
	
			 mapChallanScannedCopy.put("Misc Receipts", miscReceipts);  
		 } 
		 
		 
		 
		 if (ProcessFee>0)
		 {	
			 
			  BeanSaveId = (int)  Session.save(FeeStructureForKAR);Session.beginTransaction().commit();
			  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
			  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
			  CashSectionMonthlyReportFlow.setAmount(ProcessFee);
			  CashSectionMonthlyReportFlow.setKAWF(0);
			  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
			  CashSectionMonthlyReportFlow.setParticulars("KSBC Process Fee");
			  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);
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
					 
			  }  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEntFee(0);
			  CashSectionMonthlyReportFlow.setFDS(0);
			  CashSectionMonthlyReportFlow.setIC(0);
			  CashSectionMonthlyReportFlow.setKLA(0);
			  CashSectionMonthlyReportFlow.setMisc(ProcessFee);
			  CashSectionMonthlyReportFlow.setPlace(Place);
			  CashSectionMonthlyReportFlow.setSTAMP(0);
			  System.out.println(" Persist  #####################################");
			  
			  CashSectionMonthlyReport.setAmount(ProcessFee);
			  CashSectionMonthlyReport.setKAWF(0);
			  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEnrollNo(KARNumber);
			  CashSectionMonthlyReport.setParticulars("KSBC Process Fee");
			//  CashSectionMonthlyReport.setPaymode("Offline");
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEntFee(0);
			  CashSectionMonthlyReport.setFDS(0);
			  CashSectionMonthlyReport.setIC(0);
			  CashSectionMonthlyReport.setKLA(0);
			  CashSectionMonthlyReport.setMisc(ProcessFee);
			  CashSectionMonthlyReport.setPlace(Place);
			  CashSectionMonthlyReport.setSTAMP(0);
			  CashSectionMonthlyReport.setOperator(Operator);
			  CashSectionMonthlyReportFlow.setOperator(Operator); 
			  CashSectionMonthlyReportFlow.setName(Name);
			  CashSectionMonthlyReport.setName(Name); 
			  
			  
			  //Tx.begin();
			  try
			  {
			//Serializable
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
			//  String Id=Session.save(CashSectionMonthlyReport);
		//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
					 
	
			 mapChallanScannedCopy.put("Proces Fee", ProcessFee);  
		 } 
		 
		 
		/* if (miscReceipts>0)
		 {
			 mapChallanScannedCopy.put("misc Receipts", miscReceipts);  
		 } */ 
		 
		 if (NOC>0)
		 {	
			  BeanSaveId = (int)  Session.save(FeeStructureForKAR);Session.beginTransaction().commit();
			  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
			  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
			  CashSectionMonthlyReportFlow.setAmount(NOC);
			  CashSectionMonthlyReportFlow.setKAWF(0);
			  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
			  CashSectionMonthlyReportFlow.setParticulars("KSBC NOC");
			  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);
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
					 
			  }  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEntFee(0);
			  CashSectionMonthlyReportFlow.setFDS(0);
			  CashSectionMonthlyReportFlow.setIC(0);
			  CashSectionMonthlyReportFlow.setKLA(0);
			  CashSectionMonthlyReportFlow.setMisc(NOC);
			  CashSectionMonthlyReportFlow.setPlace(Place);
			  CashSectionMonthlyReportFlow.setSTAMP(0);
			  System.out.println(" Persist  #####################################");
			  
			  CashSectionMonthlyReport.setAmount(NOC);
			  CashSectionMonthlyReport.setKAWF(0);
			  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEnrollNo(KARNumber);
			  CashSectionMonthlyReport.setParticulars("KSBC NOC");
			//  CashSectionMonthlyReport.setPaymode("Offline");
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEntFee(0);
			  CashSectionMonthlyReport.setFDS(0);
			  CashSectionMonthlyReport.setIC(0);
			  CashSectionMonthlyReport.setKLA(0);
			  CashSectionMonthlyReport.setMisc(NOC);
			  CashSectionMonthlyReport.setPlace(Place);
			  CashSectionMonthlyReport.setSTAMP(0);
			  CashSectionMonthlyReport.setOperator(Operator);
			  CashSectionMonthlyReportFlow.setOperator(Operator); 
			  CashSectionMonthlyReportFlow.setName(Name);
			  CashSectionMonthlyReport.setName(Name); 
			  
			   
			  //Tx.begin();
			  try
			  {
			//Serializable
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
			//  String Id=Session.save(CashSectionMonthlyReport);
		//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
							
		 
	
			 mapChallanScannedCopy.put("KSBC NOC", NOC);  
		 }
		 
		 
		 
		 
		 
		 if (ChangeOfNamePublication>0)
		 {	
			  BeanSaveId = (int)  Session.save(FeeStructureForKAR);Session.beginTransaction().commit();
			  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
			  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
			  CashSectionMonthlyReportFlow.setAmount(ChangeOfNamePublication);
			  CashSectionMonthlyReportFlow.setKAWF(0);
			  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
			  CashSectionMonthlyReportFlow.setParticulars("KSBC Change Of Name Publication");
			  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);
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
					 
			  }  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEntFee(0);
			  CashSectionMonthlyReportFlow.setFDS(0);
			  CashSectionMonthlyReportFlow.setIC(0);
			  CashSectionMonthlyReportFlow.setKLA(0);
			  CashSectionMonthlyReportFlow.setMisc(ChangeOfNamePublication);
			  CashSectionMonthlyReportFlow.setPlace(Place);
			  CashSectionMonthlyReportFlow.setSTAMP(0);
			  System.out.println(" Persist  #####################################");
			  
			  CashSectionMonthlyReport.setAmount(ChangeOfNamePublication);
			  CashSectionMonthlyReport.setKAWF(0);
			  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEnrollNo(KARNumber);
			  CashSectionMonthlyReport.setParticulars("KSBC Change Of Name Publication");
			//  CashSectionMonthlyReport.setPaymode("Offline");
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEntFee(0);
			  CashSectionMonthlyReport.setFDS(0);
			  CashSectionMonthlyReport.setIC(0);
			  CashSectionMonthlyReport.setKLA(0);
			  CashSectionMonthlyReport.setMisc(ChangeOfNamePublication);
			  CashSectionMonthlyReport.setPlace(Place);
			  CashSectionMonthlyReport.setSTAMP(0);
			  CashSectionMonthlyReport.setOperator(Operator);
			  CashSectionMonthlyReportFlow.setOperator(Operator); 
			  CashSectionMonthlyReportFlow.setName(Name);
			  CashSectionMonthlyReport.setName(Name); 
			  
			   
			  //Tx.begin();
			  try
			  {
			//Serializable
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
			//  String Id=Session.save(CashSectionMonthlyReport);
		//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
							
		 
	
			 mapChallanScannedCopy.put("Change Of Name Publication", ChangeOfNamePublication); 
		 }
		 /*if (endomentCertificate>0)
		 {		  
			  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
			  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
			  CashSectionMonthlyReportFlow.setAmount(endomentCertificate);
			  CashSectionMonthlyReportFlow.setKAWF(0);
			  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
			  CashSectionMonthlyReportFlow.setParticulars("KSBC endoment Certificate");
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
				  
				  CashSectionMonthlyReport.setPaymode("BankName:"+BankName+"\t"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber);
			  }
			  else
			  {
				  CashSectionMonthlyReport.setPaymode("Cash");
					 
			  }  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEntFee(0);
			  CashSectionMonthlyReportFlow.setFDS(0);
			  CashSectionMonthlyReportFlow.setIC(0);
			  CashSectionMonthlyReportFlow.setKLA(0);
			  CashSectionMonthlyReportFlow.setMisc(endomentCertificate);
			  CashSectionMonthlyReportFlow.setPlace(Place);
			  CashSectionMonthlyReportFlow.setSTAMP(0);
			  System.out.println(" Persist  #####################################");
			  
			  CashSectionMonthlyReport.setAmount(endomentCertificate);
			  CashSectionMonthlyReport.setKAWF(0);
			  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEnrollNo(KARNumber);
			  CashSectionMonthlyReport.setParticulars("KSBC endoment Certificatet");
			//  CashSectionMonthlyReport.setPaymode("Offline");
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEntFee(0);
			  CashSectionMonthlyReport.setFDS(0);
			  CashSectionMonthlyReport.setIC(0);
			  CashSectionMonthlyReport.setKLA(0);
			  CashSectionMonthlyReport.setMisc(endomentCertificate);
			  CashSectionMonthlyReport.setPlace(Place);
			  CashSectionMonthlyReport.setSTAMP(0);
			  
			  //Tx.begin();
			  try
			  {
			//Serializable
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
			//  String Id=Session.save(CashSectionMonthlyReport);
		//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
					 
	
			 mapChallanScannedCopy.put("Retr Endoment Certificate", endomentCertificate);  
		 }  */
		 if (reimbursementOFSalaryDeduction>0)
		 {		
			  BeanSaveId = (int)  Session.save(FeeStructureForKAR);Session.beginTransaction().commit();
			  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
			  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
			  CashSectionMonthlyReportFlow.setAmount(reimbursementOFSalaryDeduction);
			  CashSectionMonthlyReportFlow.setKAWF(0);
			  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
			  CashSectionMonthlyReportFlow.setParticulars("KSBC reimbursement OF Salary Deduction");
			  if ("DD".equalsIgnoreCase(category) || "DD".equalsIgnoreCase(category))
			  {
				  
				  System.out.println("DD Is Coming");
				  
				  CashSectionMonthlyReportFlow.setPaymode("BankName:"+BankName+"\n"+"BranchName:"+BranchName +"\n"+"DDNumber:"+ DDNumber+"\n"+"DD Date:"+DDDate);
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
					 
			  }  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEntFee(0);
			  CashSectionMonthlyReportFlow.setFDS(0);
			  CashSectionMonthlyReportFlow.setIC(0);
			  CashSectionMonthlyReportFlow.setKLA(0);
			  CashSectionMonthlyReportFlow.setMisc(reimbursementOFSalaryDeduction);
			  CashSectionMonthlyReportFlow.setPlace(Place);
			  CashSectionMonthlyReportFlow.setSTAMP(0);
			  System.out.println(" Persist  #####################################");
			  
			  CashSectionMonthlyReport.setAmount(reimbursementOFSalaryDeduction);
			  CashSectionMonthlyReport.setKAWF(0);
			  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEnrollNo(KARNumber);
			  CashSectionMonthlyReport.setParticulars("KSBC reimbursement OF Salary Deduction");
			//  CashSectionMonthlyReport.setPaymode("Offline");
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEntFee(0);
			  CashSectionMonthlyReport.setFDS(0);
			  CashSectionMonthlyReport.setIC(0);
			  CashSectionMonthlyReport.setKLA(0);
			  CashSectionMonthlyReport.setMisc(reimbursementOFSalaryDeduction);
			  CashSectionMonthlyReport.setPlace(Place);
			  CashSectionMonthlyReport.setSTAMP(0);
			  CashSectionMonthlyReport.setOperator(Operator);
			  CashSectionMonthlyReportFlow.setOperator(Operator); 
			  CashSectionMonthlyReportFlow.setName(Name);
			  CashSectionMonthlyReport.setName(Name); 
			  
			   
			  //Tx.begin();
			  try
			  {
			//Serializable
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
			//  String Id=Session.save(CashSectionMonthlyReport);
		//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
							
		 
	
			 mapChallanScannedCopy.put("Reimbursement OF Salary Deduction", reimbursementOFSalaryDeduction);  
		 } 
		 
		// PlaceOftheClient
		/* if (enrollmentApplication>0)
		 {		  
			  CashSectionMonthlyReportFlow CashSectionMonthlyReportFlow = new CashSectionMonthlyReportFlow();
			  CashSectionMonthlyReport  CashSectionMonthlyReport = new CashSectionMonthlyReport();
			  CashSectionMonthlyReportFlow.setAmount(enrollmentApplication);
			  CashSectionMonthlyReportFlow.setKAWF(0);
			  CashSectionMonthlyReportFlow.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEnrollNo(KARNumber);
			  CashSectionMonthlyReportFlow.setParticulars("KSBC enrollment Application");
			  CashSectionMonthlyReportFlow.setPaymode("Offline");
			  CashSectionMonthlyReportFlow.setBCIAWF(0);
			  CashSectionMonthlyReportFlow.setEntFee(0);
			  CashSectionMonthlyReportFlow.setFDS(0);
			  CashSectionMonthlyReportFlow.setIC(0);
			  CashSectionMonthlyReportFlow.setKLA(0);
			  CashSectionMonthlyReportFlow.setMisc(enrollmentApplication);
			  CashSectionMonthlyReportFlow.setPlace(Place);
			  CashSectionMonthlyReportFlow.setSTAMP(0);
			  System.out.println(" Persist  #####################################");
			  
			  CashSectionMonthlyReport.setAmount(enrollmentApplication);
			  CashSectionMonthlyReport.setKAWF(0);
			  CashSectionMonthlyReport.setChallanCreatedDate(java.sql.Date.valueOf(today));
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEnrollNo(KARNumber);
			  CashSectionMonthlyReport.setParticulars("KSBC enrollment Application");
			  CashSectionMonthlyReport.setPaymode("Offline");
			  CashSectionMonthlyReport.setBCIAWF(0);
			  CashSectionMonthlyReport.setEntFee(0);
			  CashSectionMonthlyReport.setFDS(0);
			  CashSectionMonthlyReport.setIC(0);
			  CashSectionMonthlyReport.setKLA(0);
			  CashSectionMonthlyReport.setMisc(enrollmentApplication);
			  CashSectionMonthlyReport.setPlace(Place);
			  CashSectionMonthlyReport.setSTAMP(0);
			  
			  //Tx.begin();
			  try
			  {
			//Serializable
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
			//  String Id=Session.save(CashSectionMonthlyReport);
		//	 System.out.println( Session.getIdentifier(CashSectionMonthlyReportFlow));
					 
	
			 mapChallanScannedCopy.put("enrollment Application", enrollmentApplication);  
		 } 
		 
	*/	
		
		 
	
		 /*EnrollmentFee:EnrollmentFee,ReimbursementOFSalaryDeduction:ReimbursementOFSalaryDeduction,
			ClosingFD:ClosingFD,KSBCCostReceipt:KSBCCostReceipt,
			ElectionRules:ElectionRules,MiscReceipts:MiscReceipts,
			ElectionRules:ElectionRules,NominationForm:NominationForm,
			VoterCD:VoterCD,ElectionDeposit:ElectionDeposit,PDC:PDC,
			DOBCertificate:DOBCertificate,CertificateCopyCharges:CertificateCopyCharges,
			PostageReceipts:PostageReceipts,EnrollmentFee:EnrollmentFee,KARNumber:KARNumber,
			DuplicateEnrollemt:DuplicateEnrollemt,EndomentCertificate:EndomentCertificate,
			KSBCInterestONFD:KSBCInterestONFD,WhichFunctionToHandle:WhichFunctionToHandle,PlaceOftheClient:PlaceOftheClient,
			EnrollmentApplication:EnrollmentApplication,IdentityCard:IdentityCard,NameOftheClient:NameOftheClient,
			ComplaintFee:ComplaintFee,ChangeOfAddress:ChangeOfAddress,KARNumber:KARNumber,
			ContinuityCertificate:ContinuityCertificate,VSP:VSP,ProcessFee:ProcessFee,NOC:NOC,ChangeOfNamePublication:ChangeOfNamePublication*/
		JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
		String timeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
		
		System.out.println(request.getRemoteAddr() + "Akshay");
		
		try
		{
		ReceiptDeleteTable ReceiptDeleteTable= new ReceiptDeleteTable();
		ReceiptDeleteTable.setChallanGenerateSLNumber(ReceiptId);
		ReceiptDeleteTable.setOperator(Operator);
		ReceiptDeleteTable.setMonthlyReportSLNumber(BeanSaveId);
		ReceiptDeleteTable.setTimeWhenDeleted(today);
		ReceiptDeleteTable.setType("KSBCMisc");
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
	String 	responseString=	JSPRelatedFunctionsimp.GenerateChallan(total,mapChallanScannedCopy,Name , timeStamp, Place,KARNumber,ReceiptId+"",category,"DD Number:"+DDNumber+"  " + "DD Date:"+DDDate+"  "+"Bank:" + BankName+"  " + "Branch:" +BranchName);
	 //	  responseString="<img alt=\"Image\" src=\"KARNumberImageServlet?KARNumber="+KARNumber+"&WhichPhoto=\">";
		//System.out.println(responseString);
	out.println(responseString);
	 }

}

