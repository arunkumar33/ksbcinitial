package com.KSBC.Servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.KSBC.Bean.FileUploadBean;
import com.KSBC.Util.HibernateUtil;

/**
 * Servlet implementation class ImageServlet
 */
/*@WebServlet("/ImageServlet")*/
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageServlet() {
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
		response.setContentType("image/jpeg");
		ServletOutputStream out;
		out = response.getOutputStream();
		Blob photo=null;
		
String RegNumber = (String)request.getParameter("RegNumber");
System.out.println(RegNumber + "  Register Number");
String WhichPhoto= (String) request.getParameter("WhichPhoto");
System.out.println(WhichPhoto + "  WhichPhoto");
System.out.println(WhichPhoto + " %%%%%%%%%%%%%%%%%%#$$$$$$$$$$$$$$$$$$");
/*WhichPhoto="ChallanScanedCopy";*/
//   http://localhost:8080/ServletExample/ImageServlet?RegNumber=reg123&WhichPhoto=photo URL
// RegNumber="REG/24/2017";
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
       
        try {
             
            transaction = session.beginTransaction();
             @SuppressWarnings("unchecked")
			ArrayList<FileUploadBean> employees = (ArrayList<FileUploadBean>) session.createQuery("from FileUploadBean where RegNumber ='" +RegNumber + "'").list();
           
            for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
            	FileUploadBean user = (FileUploadBean) iterator.next();
            	if ("DOBCertificate".equalsIgnoreCase(WhichPhoto))
            	{
            		photo=user.getDOBCertificate();
            	}
            	else 	if ("Photo".equalsIgnoreCase(WhichPhoto))
            	{
            		photo= user.getPhoto();
            	}
            	else 	if ("ChallanScanedCopy".equalsIgnoreCase(WhichPhoto))
            	{
            		photo=user.getChallanScanedCopy();
            	}
             
             
              
            }
            
            
            InputStream in = photo.getBinaryStream();
            int length = (int) photo.length();

            int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];

            while ((length = in.read(buffer)) != -1) {
              
              out.write(buffer, 0, length);
            }

            in.close();
            out.flush();
            
            transaction.commit();
           
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
		
    
	
		
		
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
