package com.KSBC.Servlet;

import com.KSBC.Bean.ChairmanSignature;
import com.KSBC.JSPRelatedFunctions.JSPRelatedFunctionsimp;
import com.KSBC.Util.HibernateUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



















public class OfflineChairmanImageUpload
  extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  
  public OfflineChairmanImageUpload() {}
  
  public void init(ServletConfig config)
    throws ServletException
  {}
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {}
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    File FullFileName = null;
    String path = request.getServletContext().getRealPath("/");
    path = path;
    ArrayList<Blob> BlobList = new ArrayList();
    HttpSession HTTPSession = request.getSession(false);
    if (HTTPSession == null)
    {
      HTTPSession = request.getSession(true);
    }
    
    String name = (String)HTTPSession.getAttribute("Name");
    String Desc = (String)HTTPSession.getAttribute("Desc");
    Date From = (Date)HTTPSession.getAttribute("From");
    Date To = (Date)HTTPSession.getAttribute("To");
    Timestamp Fromtimestamp = new Timestamp(From.getTime());
    Timestamp Totimestamp = new Timestamp(To.getTime());
    Session Hibernatesession = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;
    JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
    

    int ErrorField = 0;
    if (ServletFileUpload.isMultipartContent(request))
    {
      try
      {

        List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
        int index = 0;
        for (FileItem item : multiparts)
        {

          if (!item.isFormField())
          {
            String Type = item.getContentType();
            
            System.out.println("File uploaded by the user is of Photo type");
            
            long size = item.getSize();
            
            String FeildName = item.getFieldName();
            String FileName = JSPRelatedFunctionsimp.RandomNumberForRegNumber() + FeildName + ".PNG";
            
            FullFileName = new File(path + File.separator + FileName);
            System.out.println(FullFileName.getPath() + "  File Path");
            item.write(FullFileName);
            try
            {
              transaction = Hibernatesession.beginTransaction();
              

              byte[] fileContent = new byte[(int)FullFileName.length()];
              try {
                FileInputStream fileInputStream = new FileInputStream(FullFileName);
                
                fileInputStream.read(fileContent);
                fileInputStream.close();
              } catch (Exception e) {
                e.printStackTrace();
              }
              


              Blob blob = Hibernate.createBlob(fileContent);
              BlobList.add(index, blob);
              System.out.println(BlobList.size());
              index++;
            }
            catch (HibernateException e) {
              e = 
              



                e;transaction.rollback();e.printStackTrace();

            }
            finally {}

          }
          else
          {

            ErrorField = 1;
            break;
          }
        }
        







        if (ErrorField == 1)
        {
          request.setAttribute("message", "File Upload Failed  ");

        }
        else
        {
          System.out.println(BlobList.size());
          
          if (BlobList.size() == 1)
          {




            ChairmanSignature FileUploadBean = new ChairmanSignature();
            FileUploadBean.setName(name);
            FileUploadBean.setAdditionalInfo(Desc);
            FileUploadBean.setFromDate(Fromtimestamp);
            FileUploadBean.setToDate(Totimestamp);
            
            FileUploadBean.setChairmanSignature((Blob)BlobList.get(0));
            
            System.out.println(((Blob)BlobList.get(0)).length() + "len");
            Hibernatesession.saveOrUpdate(FileUploadBean);
            
            transaction.commit();
          }
          
          request.setAttribute("message", "File Uploaded Successfully");
        }
        

      }
      catch (Exception ex)
      {
        ex.getStackTrace();
        ex.printStackTrace();
        request.setAttribute("message", "File Upload Failed due to " + ex);

      }
      finally
      {
        if (FullFileName.exists())
        {
          FullFileName.delete();
        }
        System.out.println("Finally To delete the file");
      }
      
    }
    else
    {
      request.setAttribute("message", "Sorry this Servlet only handles file upload request");
    }
    
    System.out.println("******** coming outside ************");
    
    request.getRequestDispatcher("/ResultOfChairmanPhotoUpdate.jsp").forward(request, response);
  }
}