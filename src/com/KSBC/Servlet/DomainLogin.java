package com.KSBC.Servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.KSBC.JSPRelatedFunctions.JSPRelatedFunctionsimp;

/**
 * Servlet implementation class DomainLogin
 */
/*@WebServlet("/DomainLogin")*/




public class DomainLogin
  extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  
  public DomainLogin() {}
  
  public void init(ServletConfig config)
    throws ServletException
  {}
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {}
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    System.out.println("****** Coming Here *********");
    String UserName = request.getParameter("UserName");
    System.out.println("User name " + UserName);
    String path = request.getServletContext().getRealPath("/");
    path = path + "WebContent" + File.separator + "ImageStored";
    String routePath = getClass().getClassLoader().getResource(File.separator).getPath();
    System.out.println(path + "   path");
    HttpSession Servletsession = request.getSession(false);
    if (Servletsession == null)
    {
      Servletsession = request.getSession(true);
    }
    
    Servletsession.setAttribute("UserName", UserName);
    
    System.out.println(Servletsession.getAttribute("UserName") + "   Session");
    String Password = request.getParameter("Password");
    System.out.println("Password " + Password);
    JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
    




    String Domain = JSPRelatedFunctionsimp.GetDomainFromUSernameandPassword(UserName, Password);
    if (Domain == null)
    {
      System.out.println(" TO the same page because username and password is incorrect");
      response.sendRedirect("AccountLogin.jsp");


    }
    else if (Domain.equalsIgnoreCase("New Enrollment"))
    {
      System.out.println("Redirect to New Enrollment");
      
      response.setContentType("text/html");
      PrintWriter pw = response.getWriter();
      request.setAttribute("UserName", UserName);
      
      response.sendRedirect("NewEnrollementPortal.jsp");
      
      pw.close();
    }
    else if (Domain.equalsIgnoreCase("Account Section"))
    {
      System.out.println("Redirect to Account Section");
      response.setContentType("text/html");
      PrintWriter pw = response.getWriter();
      request.setAttribute("UserName", UserName);
      
      response.sendRedirect("AccountPortal.jsp");
      
      pw.close();

    }
    else if (Domain.equalsIgnoreCase("WelFare Section"))
    {
      System.out.println("Redirect to Account Section");
      response.setContentType("text/html");
      PrintWriter pw = response.getWriter();
      request.setAttribute("UserName", UserName);
      
      response.sendRedirect("WelfareAccountPortal.jsp");
      
      pw.close();

    }
    else if (Domain.equalsIgnoreCase("DC"))
    {
      System.out.println("Redirect to DC Section");
      response.setContentType("text/html");
      PrintWriter pw = response.getWriter();
      request.setAttribute("UserName", UserName);
      
      response.sendRedirect("DCComitee.jsp");
      
      pw.close();
    }
    else if (Domain.equalsIgnoreCase("TAPPAL"))
    {
      System.out.println("Redirect to DC Section");
      response.setContentType("text/html");
      PrintWriter pw = response.getWriter();
      request.setAttribute("UserName", UserName);
      
      response.sendRedirect("Tappalportal.jsp");
      
      pw.close();

    }
    else if (Domain.equalsIgnoreCase("stamp"))
    {
      System.out.println("Redirect to stamp Section");
      response.setContentType("text/html");
      PrintWriter pw = response.getWriter();
      request.setAttribute("UserName", UserName);
      
      response.sendRedirect("StampPortal.jsp");
      
      pw.close();
    }
    else if (Domain.equalsIgnoreCase("Delete"))
    {
      System.out.println("Redirect to DC Section");
      response.setContentType("text/html");
      PrintWriter pw = response.getWriter();
      request.setAttribute("UserName", UserName);
      
      response.sendRedirect("Deleteportal.jsp");
      
      pw.close();
    }
  }
}