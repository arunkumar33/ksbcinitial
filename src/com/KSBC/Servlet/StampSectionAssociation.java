package com.KSBC.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.KSBC.Bean.CashSectionMonthlyReport;
import com.KSBC.Bean.ScheduleConfirmationBean;
import com.KSBC.Bean.StampSectionAssociationBean;
import com.KSBC.Util.HibernateUtil;

/**
 * Servlet implementation class StampSectionAssociation
 */
/*@WebServlet("/StampSectionAssociation")*/
public class StampSectionAssociation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StampSectionAssociation() {
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
		// TODO Auto-generated method stub
		
		
		StampSectionAssociationBean associationBean=new StampSectionAssociationBean();
		


		Session Session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = Session.beginTransaction();
		PrintWriter out = response.getWriter();
		try
		{
		
		String districtName=request.getParameter("district");
		System.out.println(districtName);
		associationBean.setDistrict(districtName);
		
		String associationName=request.getParameter("associationName");
		System.out.println(associationName + "associationName1");
		associationBean.setAssociationName(associationName);
		
		String StampFee=request.getParameter("StampFee");
		int Stampfee=Integer.parseInt(StampFee);
		System.out.println("StampFee"+Stampfee);
		associationBean.setStampFee(1);
		
		String NAmount=request.getParameter("NetAmount");
		
		try
		{
		int NetAmount=Integer.parseInt(NAmount);
		System.out.println("NetAmount"+NetAmount);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		;
		associationBean.setNetAmount(1);
		
	/*	String Dis=request.getParameter("Discount");
		int Discount=Integer.parseInt(Dis);
		System.out.println("Discount"+Discount);*/
		associationBean.setDeduction(1);
		
		
		String RecepitNumber=request.getParameter("RecepitNumber");
		
		int rn=0;
		
		try
		{
			rn=Integer.parseInt(RecepitNumber);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
	/*	String GAmount=request.getParameter("Gross_Amount");
		int Gross_Amount=Integer.parseInt(GAmount);
		System.out.println("Gross_Amount"+Gross_Amount);*/
		associationBean.setGrossAmount(1);
		
	/*	String TAmount=request.getParameter("Total_Amount");
		int Total_Amount=Integer.parseInt(TAmount);
		System.out.println("Total_Amount"+Total_Amount);*/
		associationBean.setTotalAmount(1);
		
		String PostalCharge=request.getParameter("PostalCharges");
		int PostalCharges=0;
		try
		{
		 PostalCharges=Integer.parseInt(PostalCharge);
		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println(PostalCharges);
		associationBean.setPostalCharges(PostalCharges);
	/*	
		String totStamp=request.getParameter("Total_Stamp");
		int Total_Stamp=Integer.parseInt(totStamp);
		//Total_Stamp=Total_Amount/Stampfee;
		System.out.println("Total no. of Stamp"+Total_Stamp);*/
		associationBean.setTotalStamps(1);
		
		String BeforeDis=request.getParameter("BeforeDiscount");
	
		String AfterDis=request.getParameter("AfterDiscount");
		
		
			 LocalDate today = LocalDate.now();
		    
		    java.util.Date date = Date.from(today.atStartOfDay()
			        .atZone(ZoneId.systemDefault()).toInstant());
			    Timestamp timeStamp = new Timestamp(date.getTime());
			
		 
		 associationBean.setChallanCreatedDate(timeStamp);
	        System.out.println(timeStamp);
		String Remarks=request.getParameter("remarks");
		System.out.println(Remarks);
		associationBean.setRemarks(Remarks);
CashSectionMonthlyReport	CashSectionMonthlyReport=(CashSectionMonthlyReport)	Session.get(CashSectionMonthlyReport.class, rn);
		
		int totalAmount = CashSectionMonthlyReport.getAmount();
		
int FinalAmount=totalAmount-PostalCharges;

System.out.println(FinalAmount + "FinalAmount");
int Gross_Amount=0;
if("Before".equals(BeforeDis))
	
{
	Gross_Amount=(int) (FinalAmount*1.1);
	System.out.println(Gross_Amount + " Before");

}
else if("After".equals(AfterDis))
{
	Gross_Amount= ((FinalAmount*10)/9);
	
	System.out.println(Gross_Amount + " After");
}

int totalStamp=Gross_Amount/Stampfee;

associationBean.setTotalStamps(totalStamp);
System.out.println(BeforeDis + " BeforeDis");
System.out.println(Gross_Amount + "Gross_Amount");
associationBean.setGrossAmount(Gross_Amount);
associationBean.setNetAmount(FinalAmount);
associationBean.setTotalAmount(totalAmount);
associationBean.setPaymentMode(CashSectionMonthlyReport.getPaymode());
associationBean.setPostalCharges(PostalCharges);
associationBean.setDistrict(districtName);
associationBean.setDeduction(Gross_Amount-totalAmount);
associationBean.setAssociationName(associationName);

		Session.save(associationBean);
		tx.commit();
		out.println("<br><br><br><br><h2>KSBC Stamp Fee</h2><br><br>" );
		out.println("<h3>District</h3>" + districtName);
		out.println("<h3>Association</h3>" + associationName);
		out.println("<h3>PaymentMode</h3>" + CashSectionMonthlyReport.getPaymode());
		out.println("<h3>PostalCharges</h3>" + PostalCharges);
		out.println("<h3>TotalAmount</h3>" + totalAmount);
		out.println("<h3>NetAmount</h3>" +FinalAmount );
		out.println("<h3>GrossAmount</h3>" + Gross_Amount);
		out.println("<h3>Remarks</h3>" + Remarks);
		out.println("<h3>Discount</h3>" + (Gross_Amount-totalAmount));
		
		out.println("<h3>Total Stamp</h3>" + totalStamp);
		
		}
		catch (Exception e)
		{
			e.printStackTrace();
			tx.rollback();
			out.println("Please enter correct value");
		}
	}

}
