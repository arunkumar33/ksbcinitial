package com.KSBC.Servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
import org.hibernate.Transaction;

import com.KSBC.Bean.EligibleKARChanges;
import com.KSBC.Bean.FileUploadBean;
import com.KSBC.JSPRelatedFunctions.JSPRelatedFunctionsimp;
import com.KSBC.Util.HibernateUtil;

/**
 * Servlet implementation class UploadServletForChallan
 */
/*@WebServlet("/UploadServletForChallan")*/
public class UploadServletForChallan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServletForChallan() {
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
		
		System.out.println("HI");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//process only if its multipart content
		
		String path=request.getServletContext().getRealPath("/");
		System.out.println(this.getClass().getClassLoader().getResource(File.separator).getPath());
		path=path+"ImageStored";
		ArrayList<Blob> BlobList= new ArrayList<Blob>();
		HttpSession Session = request.getSession();
		String WhichChallan = (String)Session.getAttribute("WhichChallan");
		 Session Hibernatesession = HibernateUtil.getSessionFactory().openSession();
	        Transaction transaction = null;
		String KARNumber = (String) Session.getAttribute("KARNumber");
		
		JSPRelatedFunctionsimp JSPRelatedFunctionsimp= new JSPRelatedFunctionsimp();
		
	
		int ErrorField=0;
		ArrayList<Map<String, Blob>> MapList = new ArrayList<Map<String, Blob>>();
		Map<String, Blob> mapChallanScannedCopy = new HashMap<String, Blob>();
        if(ServletFileUpload.isMultipartContent(request)){
            try {
            	
            	System.out.println("******** coming inside ************");
                @SuppressWarnings("unchecked")
				List<FileItem> multiparts = new ServletFileUpload(
                                         new DiskFileItemFactory()).parseRequest(request);
              int index=0;
                for(FileItem item : multiparts){
                	
                	
                    if(!item.isFormField())
                    {
                    	String Type=item.getContentType();
                    	
                    	if ((Type.equalsIgnoreCase("image/png")) ||( Type.equalsIgnoreCase("image/jpg")))
                    	{
                    		System.out.println("File uploaded by the user is of Photo type");
                    		
                    		long size = item.getSize();
                    		
                    		System.out.println(size + " size of" + item.getName()  +  "  " +item.getFieldName()  +  "  " +item.getName());
                    	String FeildName = item.getFieldName();
                    		String FileName=JSPRelatedFunctionsimp.RandomNumberForRegNumber()+FeildName+".PNG";
                    		
                    		System.out.println(FileName + "file name");
                    //		File FullFileName = new File(UPLOAD_DIRECTORY + File.separator + FileName);
                    		File FullFileName = new File(path + File.separator + FileName);
                    		System.out.println(FullFileName.getPath() + "  File Path");
                    		item.write( FullFileName);
                    	    try {
                                // HiberNate 
                                transaction = Hibernatesession.beginTransaction();
                    		
                    		// Here hibernate will come
                    		 byte[] fileContent = new byte[(int) FullFileName.length()];
                             try {
                                 FileInputStream fileInputStream = new FileInputStream(FullFileName);
                                 //convert file into array of bytes
                                 fileInputStream.read(fileContent);
                                 fileInputStream.close();
                             } catch (Exception e) {
                                 e.printStackTrace();
                             }
                             
                            
                             @SuppressWarnings("deprecation")
							Blob blob = Hibernate.createBlob(fileContent);
                             BlobList.add(index,blob);
                             System.out.println(BlobList.size());
                             index++;
                    	    }
                    	    
                    	    catch (HibernateException e) {
                                transaction.rollback();
                                e.printStackTrace();
                            } finally {
                            //	Hibernatesession.close();
                            }  
                    		
                    		
                    	}
                    	else 
                    	{
                    		System.out.println("File uploaded by the user is of Not a Photo type");
                    		ErrorField=1;
                    		break;
                    	}
                    	
                    	/*System.out.println(item.getContentType() + "Content Type of the file");
                    	System.out.println(item.getSize() + "Size of the File");
                    	System.out.println(item.getFieldName() + "Size of the File");
                        String name = new File(item.getName()).getName();
                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));*/
                    }
                } // For Each Loop For Blob type
                
                if (ErrorField==1)
                {
                	 request.setAttribute("message", "File Upload Failed due to " );	
                }
                else
                {
                	
                	System.out.println(BlobList.size());
                	
                	if(BlobList.size()==1)
                	{
                		// All files are updates
                		
                		System.out.println("***** successfully uploaded");
                		
                		EligibleKARChanges EligibleKARChanges = new EligibleKARChanges();
                		EligibleKARChanges.setPayedChallan(BlobList.get(0));
                		EligibleKARChanges.setPayingFor(WhichChallan);
                		EligibleKARChanges.setKARNumber(KARNumber);
                	/*	FileUploadBean.setRegNumber(RegNumber);WhichChallan
                		FileUploadBean.setDOBCertificate(BlobList.get(0));
                		FileUploadBean.setPhoto(BlobList.get(1));
                		FileUploadBean.setChallanScanedCopy(BlobList.get(2));
                		*/
                		
                		/*for (Entry<String, Blob> entry : mapChallanScannedCopy.entrySet()) {
                			
                			if (entry.getKey().equalsIgnoreCase("ChallanScannedCopy"))
                			{
                				
                				
                				FileUploadBean.setChallanScanedCopy(entry.getValue());	
                			}
                			else if (entry.getKey().equalsIgnoreCase("DOBCertificate"))
                    			{
                				FileUploadBean.setDOBCertificate( entry.getValue());	
                    			}
                			else if (entry.getKey().equalsIgnoreCase("Photo"))
                			{
                				FileUploadBean.setPhoto( entry.getValue());
                			}
                			System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
                		}*/
                		
                	
                		Hibernatesession.saveOrUpdate(EligibleKARChanges);
                		transaction.commit();	 
                	}
                	
                	request.setAttribute("message", "File Uploaded Successfully");	
                }
           
               //File uploaded successfully
               
            } catch (Exception ex) {
            	System.out.println("******** coming inside error ************");
            	ex.getStackTrace();
               request.setAttribute("message", "File Upload Failed due to " + ex);
            }
            finally
            {
            	
            	
            	System.out.println("Finally To delete the file");
            }
         
        }else{
        	
        	 System.out.println("******** coming oufghfghfghfghftside ************");
            request.setAttribute("message",
                                 "Sorry this Servlet only handles file upload request");
        }
        System.out.println("******** coming outside ************");
         request.getRequestDispatcher("/result.jsp").forward(request, response);
        
     /*   
        For School Project
        String contextPath= "http://www.java2s.com";
        response.sendRedirect(response.encodeRedirectURL(contextPath ));*/
     
    
	}

}
