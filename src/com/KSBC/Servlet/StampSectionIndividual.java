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
import com.KSBC.Bean.StampSectionAssociationBean;
import com.KSBC.Bean.StampSectionIndividualBean;
import com.KSBC.Util.HibernateUtil;

/**
 * Servlet implementation class StampSectionIndividual
 */
/*@WebServlet("/StampSectionIndividual")*/
public class StampSectionIndividual extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StampSectionIndividual() {
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
StampSectionIndividualBean individualBean=new StampSectionIndividualBean();
Session Session = HibernateUtil.getSessionFactory().openSession();
Transaction tx = Session.beginTransaction();
PrintWriter out = response.getWriter();
try
{
		String Name=request.getParameter("name");
		System.out.println(Name);
		individualBean.setName(Name);
		
		String Place=request.getParameter("place");
		System.out.println(Place);
		individualBean.setPlace(Place);
		
		String StampFee=request.getParameter("StampFee");
		int Stampfee=Integer.parseInt(StampFee);
		System.out.println("StampFee"+Stampfee);
		individualBean.setStampFee(Stampfee);
		/*
		String NAmount=request.getParameter("NetAmount");
		int NetAmount=Integer.parseInt(NAmount);
		System.out.println("NetAmount"+NetAmount);
		individualBean.setNetAmount(NetAmount);
		
		
		
		String GAmount=request.getParameter("Gross_Amount");
		int Gross_Amount=Integer.parseInt(GAmount);
		System.out.println("Gross_Amount"+Gross_Amount);
		individualBean.setGrossAmount(Gross_Amount);
		
		String TAmount=request.getParameter("Total_Amount");
		int Total_Amount=Integer.parseInt(TAmount);
		System.out.println("Total_Amount"+Total_Amount);
		individualBean.setTotalAmount(Total_Amount);
		
		String totStamp=request.getParameter("Total_Stamp");
		int Total_Stamp=Integer.parseInt(totStamp);
		//Total_Stamp=Total_Amount/Stampfee;
		System.out.println("Total no. of Stamp"+Total_Stamp);
		individualBean.setTotalStamps(Total_Stamp);*/
		
		
		String PostalCharge=request.getParameter("PostalCharges");
		int PostalCharges=0;
		try
		{
		 PostalCharges=Integer.parseInt(PostalCharge);
		System.out.println(PostalCharges);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		individualBean.setPostalCharges(PostalCharges);
		
		String BeforeDis=request.getParameter("BeforeDiscount");
		
		int BeforeDis2=0;
		try
		{
			BeforeDis2=Integer.parseInt(BeforeDis);	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
		String AfterDis=request.getParameter("AfterDiscount");
		int AfterDiscount=0;
		try
		{
			AfterDiscount=Integer.parseInt(AfterDis);	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println(AfterDiscount);

		String Remarks=request.getParameter("remarks");
		System.out.println(Remarks);
		individualBean.setRemarks(Remarks);
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
else
{
	Gross_Amount= ((FinalAmount*1));
}

int totalStamp=Gross_Amount/Stampfee;

		
		 LocalDate today = LocalDate.now();
		    
		    java.util.Date date = Date.from(today.atStartOfDay()
			        .atZone(ZoneId.systemDefault()).toInstant());
			    Timestamp timeStamp = new Timestamp(date.getTime());
		 
	    individualBean.setChallanCreatedDate(timeStamp);
	        System.out.println(timeStamp);
	        individualBean.setGrossAmount(Gross_Amount);
	        individualBean.setNetAmount(totalAmount-Stampfee);
	        individualBean.setTotalAmount(totalAmount);
	        individualBean.setPaymentMode(CashSectionMonthlyReport.getPaymode());
	        individualBean.setTotalStamps(totalStamp);
	        Session.save(individualBean);
	        tx.commit();
			out.println("<br><br><br><br><h2>KSBC Stamp Fee</h2><br><br>" );
			out.println("<h3>Name</h3>" + Name);
			out.println("<h3>Place</h3>" + Place);
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
			tx.rollback();
			e.printStackTrace();
			out.println("Please enter correct value");
		}
	}

}
