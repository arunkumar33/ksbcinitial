package com.KSBC.Servlet;

import com.KSBC.Bean.ChairmanSignature;
import com.KSBC.Bean.FileUploadBean;
import com.KSBC.Util.HibernateUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;















public class ChairmanImageServlet
  extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  
  public ChairmanImageServlet() {}
  
  public void init(ServletConfig config)
    throws ServletException
  {}
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    response.setContentType("image/jpeg");
    
    ServletOutputStream out = response.getOutputStream();
    Blob photo = null;
    
    String RegNumber = request.getParameter("SLNumber");
    System.out.println(RegNumber + "  Register Number");
    


    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;
    
    try
    {
      transaction = session.beginTransaction();
      
      ArrayList<FileUploadBean> employees = (ArrayList)session.createQuery("from ChairmanSignature where SerialNumber ='" + RegNumber + "'").list();
      
      for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
        ChairmanSignature user = (ChairmanSignature)iterator.next();
        
        photo = user.getChairmanSignature();
      }
      





      InputStream in = photo.getBinaryStream();
      int length = (int)photo.length();
      
      int bufferSize = 1024;
      byte[] buffer = new byte[bufferSize];
      
      while ((length = in.read(buffer)) != -1)
      {
        out.write(buffer, 0, length);
      }
      
      in.close();
      out.flush();
      
      transaction.commit();
    }
    catch (HibernateException e) {
      transaction.rollback();
      e.printStackTrace();
    } catch (Exception e) {
      transaction.rollback();
      e.printStackTrace();
    } finally {
      session.close();
    }
  }
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {}
}