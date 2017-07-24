package com.KSBC.Servlet;

import com.KSBC.Bean.TappalComplaintInword;
import com.KSBC.Util.HibernateUtil;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;



public class TappalComplaint
  extends HttpServlet
{ 
  private static final long serialVersionUID = 1L;
  
  public TappalComplaint() {}
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {}
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    Session Session = HibernateUtil.getSessionFactory().openSession();
    Session.beginTransaction();
    PrintWriter out = response.getWriter();
    try
    {
      String UserName = request.getParameter("UserName");
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      
      String Address = request.getParameter("Address");
      String Particular = request.getParameter("Particular");
      String Remarks = request.getParameter("Remarks");
      String OutworldDate = request.getParameter("Date");
      LocalDate localDateStart = LocalDate.parse(OutworldDate, formatter);
      



      java.util.Date date2 = java.sql.Date.from(localDateStart.atStartOfDay()
        .atZone(ZoneId.systemDefault()).toInstant());
      Timestamp timeStamp = new Timestamp(date2.getTime());
      
      System.out.println(timeStamp + "   Comparing timestamp");
      
      TappalComplaintInword Tappal_Outworld = new TappalComplaintInword();
      Tappal_Outworld.setAddress(Address);
      Tappal_Outworld.setName(UserName);
      Tappal_Outworld.setParticular(Particular);
      
      Tappal_Outworld.setRemarks(Remarks);
      Tappal_Outworld.setOutWorldDate(timeStamp);
      

      int id = ((Integer)Session.save(Tappal_Outworld)).intValue();
      int year = 2017;
      String World = "KSBC/TAPPAL/INW/COMP/" + id + "/" + year;
      Tappal_Outworld.setInworldNumber(World);
      Session.update(Tappal_Outworld);
      
      response.setContentType("text/html");
      


      String responseString = "<h1>Record Added SuccessFully </h2> " + World + "";
      

      out.println(responseString);
      

      Session.beginTransaction().commit();
      Session.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
      out.println("Please enter valid inputs");
    }
  }
}