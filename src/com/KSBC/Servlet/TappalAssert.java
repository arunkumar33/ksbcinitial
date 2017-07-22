package com.KSBC.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.KSBC.Bean.TappalAssertTable;
import com.KSBC.Util.HibernateUtil;

/**
 * Servlet implementation class TappalAssert
 */
/*@WebServlet("/TappalAssert")*/
public class TappalAssert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TappalAssert() {
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
		response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = response.getWriter();
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = Session.beginTransaction();
		try
		{
		String UserName=request.getParameter("UserName");
		String CPUAssertNumber=request.getParameter("CPUAssertNumber");
		String HardwareConfiguration=request.getParameter("HardwareConfiguration");
		
		String MonitorAssetNumber=request.getParameter("MonitorAssetNumber");
		String MonitorSLNumber=request.getParameter("MonitorSLNumber");
		String MonitorMake=request.getParameter("MonitorMake");
		String CPUMake=request.getParameter("CPUMake");
		String IPAddess=request.getParameter("IPAddess");
		
		String PrinterMake=request.getParameter("PrinterMake");
		String PrinterModel=request.getParameter("PrinterModel");
		String Remarks=request.getParameter("Remarks");
		String iTAssert=request.getParameter("iTAssert");
		  Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	        System.out.println(timestamp);
		TappalAssertTable TappalAssertTable = new TappalAssertTable();
		TappalAssertTable.setCPUAssertNumber(CPUAssertNumber);
		TappalAssertTable.setCPUMake(CPUMake);
		TappalAssertTable.setHardwareConfiguration(HardwareConfiguration);
		TappalAssertTable.setIPAddress(IPAddess);
		TappalAssertTable.setITAssert(iTAssert);
		TappalAssertTable.setMonitorAssertNumber(MonitorAssetNumber);
		TappalAssertTable.setMonitorSLNo(MonitorSLNumber);
		TappalAssertTable.setPrinterMake(PrinterMake);
		TappalAssertTable.setPrinterModel(PrinterModel);
		TappalAssertTable.setRemarks(Remarks);
		/*TappalAssertTable.setUser(UserName);*/
		TappalAssertTable.setMonitorMake(MonitorMake);
		TappalAssertTable.setInsertedDate(timestamp);
	//	TappalAssert.
		 Session.saveOrUpdate(TappalAssertTable);
		 tx.commit();
		 out.println("Data Inserted Successfully");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			 out.println("Error in the PRocess. Please try again after some time");
			tx.rollback();	
		}
		
	}

}
