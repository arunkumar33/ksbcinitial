package com.KSBC.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.KSBC.Bean.AssociationStampBean;
import com.KSBC.Bean.BCI_FDSBean;
import com.KSBC.Bean.CashSectionMonthlyReport;
import com.KSBC.Bean.EnrollmentNewMemberBean;
import com.KSBC.Bean.IndividualStampBean;
import com.KSBC.Bean.KAWFLateWelfareFundBean;
import com.KSBC.Bean.KAWFMiscReceiptBean;
import com.KSBC.Bean.KSBCMiscReceiptBean;
import com.KSBC.Bean.PayedRegistrationChallan;
import com.KSBC.Bean.ReceiptDeleteTable;
import com.KSBC.Util.HibernateUtil;

/**
 * Servlet implementation class DeleteReceipt
 */
/*@WebServlet("/DeleteReceipt")*/
public class DeleteReceipt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteReceipt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = response.getWriter();
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = Session.beginTransaction();
		try
		{
			
		
		ReceiptDeleteTable ReceiptDeleteTable = new ReceiptDeleteTable();
		int ReceiptNumber=0;
		try
		{
		 ReceiptNumber = Integer.parseInt(request.getParameter("ReceiptNumber"));
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		String WhichMethod = request.getParameter("WhichMethod");
		System.out.println(ReceiptNumber + " : ReceiptNumber");
	Query query = Session.createQuery("from ReceiptDeleteTable where ChallanGenerateSLNumber = :ChallanGenerateSLNumber ");
		query.setParameter("ChallanGenerateSLNumber", ReceiptNumber);
		 @SuppressWarnings("unchecked")
		ArrayList<ReceiptDeleteTable> list = (ArrayList<ReceiptDeleteTable>)query.list();
		
		 ReceiptDeleteTable= list.get(0);
		 CashSectionMonthlyReport CashSectionMonthlyReport = (CashSectionMonthlyReport)Session.get(CashSectionMonthlyReport.class, ReceiptDeleteTable.getChallanGenerateSLNumber());
		 
		
		 if(WhichMethod.equalsIgnoreCase("KAWF"))
		 {
			 
			 
		 } // all the cases
		 
		 if(WhichMethod.equalsIgnoreCase("Associate"))
		 {
			 AssociationStampBean AssociationStampBean= (com.KSBC.Bean.AssociationStampBean) Session.get(AssociationStampBean.class, ReceiptDeleteTable.getMonthlyReportSLNumber());	 
			 Session.delete(AssociationStampBean); 
		 }
		 
		 if(WhichMethod.equalsIgnoreCase("BCI"))
		 {
			 BCI_FDSBean AssociationStampBean= (com.KSBC.Bean.BCI_FDSBean) Session.get(BCI_FDSBean.class, ReceiptDeleteTable.getMonthlyReportSLNumber());	 
			 Session.delete(AssociationStampBean); 
		 }
		 
		 if(WhichMethod.equalsIgnoreCase("Enrollment"))
		 {
			 EnrollmentNewMemberBean AssociationStampBean= (EnrollmentNewMemberBean) Session.get(EnrollmentNewMemberBean.class, ReceiptDeleteTable.getMonthlyReportSLNumber());	 
			 Session.delete(AssociationStampBean); 
		 }
		 
		 if(WhichMethod.equalsIgnoreCase("Individual"))
		 {
			 IndividualStampBean AssociationStampBean= (IndividualStampBean) Session.get(IndividualStampBean.class, ReceiptDeleteTable.getMonthlyReportSLNumber());	 
			 Session.delete(AssociationStampBean); 
		 }
		 
		 if(WhichMethod.equalsIgnoreCase("KAWFLateFee"))
		 {
			 KAWFLateWelfareFundBean AssociationStampBean= (KAWFLateWelfareFundBean) Session.get(KAWFLateWelfareFundBean.class, ReceiptDeleteTable.getMonthlyReportSLNumber());	 
			 Session.delete(AssociationStampBean); 
		 }
		 
		 if(WhichMethod.equalsIgnoreCase("KAWFMisc"))
		 {
			 KAWFMiscReceiptBean AssociationStampBean= (KAWFMiscReceiptBean) Session.get(KAWFMiscReceiptBean.class, ReceiptDeleteTable.getMonthlyReportSLNumber());	 
			 Session.delete(AssociationStampBean); 
		 }
		 
		 if(WhichMethod.equalsIgnoreCase("KSBCMisc"))
		 {
			 KSBCMiscReceiptBean AssociationStampBean= (KSBCMiscReceiptBean) Session.get(KSBCMiscReceiptBean.class, ReceiptDeleteTable.getMonthlyReportSLNumber());	 
			 Session.delete(AssociationStampBean); 
		 }
		 
		 
		 Session.delete(CashSectionMonthlyReport);
		 Session.delete(ReceiptDeleteTable);
		 tx.commit();
		 out.println("Hi Receipt is deleted:" + ReceiptNumber);
		 out.println("In the Section:" + WhichMethod);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			 out.println("Error in the PRocess. Please try again after some time");
			tx.rollback();	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
