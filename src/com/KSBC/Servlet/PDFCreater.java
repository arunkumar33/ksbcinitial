package com.KSBC.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import javax.servlet.ServletConfig;
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

/**
 * Servlet implementation class PDFCreater
 */
@WebServlet("/PDFCreater")
public class PDFCreater extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PDFCreater() {
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
		System.out.println("*********************** Hi  **********************************");
		 response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		    Session Session = HibernateUtil.getSessionFactory().openSession();
			Transaction Tx = Session.beginTransaction();

			 System.out.println("HI FeeStructure");
			 HashMap<String, Integer> mapChallanScannedCopy = new HashMap<String, Integer>();
			
			 Integer EnrollmentFee = Integer.parseInt(request.getParameter("EnrollmentFee"));
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
			 String PlaceOftheClient = request.getParameter("PlaceOftheClient");
			 Integer EnrollmentApplication = Integer.parseInt(request.getParameter("EnrollmentApplication"));
			 Integer IdentityCard = Integer.parseInt(request.getParameter("IdentityCard"));
			 String NameOftheClient = (request.getParameter("NameOftheClient"));
			 Integer ComplaintFee = Integer.parseInt(request.getParameter("ComplaintFee"));
			 Integer ChangeOfAddress = Integer.parseInt(request.getParameter("ChangeOfAddress"));
			 Integer ContinuityCertificate = Integer.parseInt(request.getParameter("ContinuityCertificate"));
			 Integer VSP = Integer.parseInt(request.getParameter("VSP"));
			 Integer ProcessFee = Integer.parseInt(request.getParameter("ProcessFee"));
			 Integer miscReceipts = Integer.parseInt(request.getParameter("MiscReceipts"));
			//miscReceipts 
			 Integer NOC = Integer.parseInt(request.getParameter("NOC"));
			 Integer ChangeOfNamePublication = Integer.parseInt(request.getParameter("ChangeOfNamePublication"));
			 Integer endomentCertificate = Integer.parseInt(request.getParameter("EndomentCertificate"));
			 Integer reimbursementOFSalaryDeduction = Integer.parseInt(request.getParameter("ReimbursementOFSalaryDeduction"));
			 //reimbursementOFSalaryDeduction
			 Integer enrollmentApplication = Integer.parseInt(request.getParameter("EnrollmentApplication"));
			
			 
			 Integer total= EnrollmentFee+ReimbursementOFSalaryDeduction+ClosingFD+KSBCCostReceipt+ElectionRules;
			 total+=NominationForm+VoterCD+ElectionDeposit+PDC+DOBCertificate+PostageReceipts+DuplicateEnrollment+EndomentCertificate;
			 total+=KSBCInterestONFD+EnrollmentApplication+IdentityCard+ComplaintFee+ChangeOfAddress+ContinuityCertificate;
			 total+=VSP+ProcessFee+miscReceipts+NOC+ChangeOfNamePublication+endomentCertificate+reimbursementOFSalaryDeduction+enrollmentApplication;
			 
			 
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
			 
			 
			/* if (miscReceipts>0)
			 {
				 mapChallanScannedCopy.put("misc Receipts", miscReceipts);  
			 } */ 
			 
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
			// FeeStructureForKAR.setEnrollmentFee(EnrollmentFee);
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
			 
			Session.saveOrUpdate(FeeStructureForKAR);
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
			
		String	responseString=""	;
		    String timeStamp1 = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
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
+ "<div>1. Name:</div><br></br>"
+ "<div>2. Place:</div><br></br><div style='width:100%;height:3%;border:1px solid black'>" 
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
+ "<div>1. Name:</div><br></br>"
+ "<div>2. Place:</div><br></br><div style='width:100%;height:3%;border:1px solid black'>" 
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
+ "<div>1. Name:</div><br></br>"
+ "<div>2. Place:</div><br></br><div style='width:100%;height:3%;border:1px solid black'>" 
+"<div style='float:left;width:25%'>Sl.No.</div> <div style='float:left;width:53%'>Particulars</div>" 
+"<div style='float:left;width:0%'>Amount</div><br></br>  </div> <div class='ForWhatPaying'></div>"
+"<br></br><br></br><br></br><br></br><br></br><br></br><br></br> <br></br><br></br><br></br><br></br><br></br><br></br><br></br><br></br> Rupees:<p id='Rupees'>0</p>"
 +"<br></br><br></br><br></br><br></br><br></br><div style='width:100%'>   <div style='float:left'>Receipt No.</div>  "
 +"<div style='float:right'><strong>CASHIER</strong></div></div></div>"
 
 
 
 
 
 +"</body>"
 +"</html>");
*/	
		    out.println(responseString);
		    /*response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(responseString);*/
	}

}
