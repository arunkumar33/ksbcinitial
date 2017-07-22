<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.KSBC.JSPRelatedFunctions.JSPRelatedFunctionsimp"%>
<%@page import="com.KSBC.Bean.ScheduleConfirmationBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.KSBC.Bean.EnrollmentDetails"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% 
EnrollmentDetails EnrollmentDetails=(EnrollmentDetails)session.getAttribute("validatedBean");


int enrollnumber=EnrollmentDetails.getEnrollmentId();

%>


<table class="table table-striped">
  <tbody>
  <tr>
      <tr>
      <th>Name</th>
      
       <%
      if (EnrollmentDetails.getName()==null)
      {
    	  
    	 
	    	
    	  %>
    	    <th> </th> 
    	    
    	  <%  
      }
      %>
      
       <%
       if (EnrollmentDetails.getName()!=null) 
      {
    	  
    	//  System.out.println((EnrollmentDetails.getWelfareLifeTimeMember()));
	    	
    	  %>
    	      <th><%=EnrollmentDetails.getName() %></th>
    	    
    	  <%  
      }
      %>
  
      
    </tr>
   <tr>
      <th>Address1</th>
      
        <%
      if (EnrollmentDetails.getCommunication_Address1()==null)
      {
    	  
    	 
	    	
    	  %>
    	    <th> </th> 
    	    
    	  <%  
      }
      %>
      
       <%
       if (EnrollmentDetails.getCommunication_Address1()!=null) 
      {
    	  
    	//  System.out.println((EnrollmentDetails.getWelfareLifeTimeMember()));
	    	
    	  %>
    	      <th><%=EnrollmentDetails.getCommunication_Address1() %></th>
    	    
    	  <%  
      }
      %>
   
      
    </tr>
      <tr>
      <th>Address2</th>
      
       <%
      if (EnrollmentDetails.getCommunication_Address2()==null)
      {
    	  
    	 
	    	
    	  %>
    	    <th> </th> 
    	    
    	  <%  
      }
      %>
      
       <%
       if (EnrollmentDetails.getCommunication_Address2()!=null) 
      {
    	  
    	//  System.out.println((EnrollmentDetails.getWelfareLifeTimeMember()));
	    	
    	  %>
    	      <th><%=EnrollmentDetails.getCommunication_Address2() %></th>
    	    
    	  <%  
      }
      %>
      
     
      
    </tr>
      <tr>
      <th>Address3</th>
      
          <%
      if (EnrollmentDetails.getCommunication_Address3()==null)
      {
    	  
    	 
	    	
    	  %>
    	    <th> </th> 
    	    
    	  <%  
      }
      %>
      
       <%
       if (EnrollmentDetails.getCommunication_Address3()!=null) 
      {
    	  
    	//  System.out.println((EnrollmentDetails.getWelfareLifeTimeMember()));
	    	
    	  %>
    	      <th><%=EnrollmentDetails.getCommunication_Address3() %></th>
    	    
    	  <%  
      }
      %>
      
      
   
      
    </tr>
    
    
  
  <tr>
      <th>EnrollmentID</th>
      
       
          <%
      if (EnrollmentDetails.getRollNo()==null)
      {
    	  
    	 
	    	
    	  %>
    	    <th> </th> 
    	    
    	  <%  
      }
      %>
      
       <%
       if (EnrollmentDetails.getRollNo()!=null) 
      {
    	  
    	//  System.out.println((EnrollmentDetails.getWelfareLifeTimeMember()));
	    	
    	  %>
    	      <th><%=EnrollmentDetails.getRollNo() %></th>
    	    
    	  <%  
      }
      %>
      
    
      
    </tr>
    
  <tr>
  
  
      <th>Father's Name</th>
      
       <%
      if (EnrollmentDetails.getFatherName()==null)
      {
    	  
    	 
	    	
    	  %>
    	    <th> </th> 
    	    
    	  <%  
      }
      %>
      
       <%
       if (EnrollmentDetails.getFatherName()!=null) 
      {
    	  
    	//  System.out.println((EnrollmentDetails.getWelfareLifeTimeMember()));
	    	
    	  %>
    	      <th><%=EnrollmentDetails.getFatherName() %></th>
    	    
    	  <%  
      }
      %>
   
      
    </tr>
  
 
      <tr>
      <th>Registration Number</th>
      
         <%
      if (EnrollmentDetails.getEnrollmentRegistrationNo()==null)
      {
    	  
    	 
	    	
    	  %>
    	    <th> </th> 
    	    
    	  <%  
      }
      %>
      
       <%
       if (EnrollmentDetails.getEnrollmentRegistrationNo()!=null) 
      {
    	  
    	//  System.out.println((EnrollmentDetails.getWelfareLifeTimeMember()));
	    	
    	  %>
    	      <th><%=EnrollmentDetails.getEnrollmentRegistrationNo() %></th>
    	    
    	  <%  
      }
      %>
      
     
      
    </tr>
      <tr>
      <th>Enrollment Date</th>
      
          <%
      if (EnrollmentDetails.getEnrollmentDate()==null)
      {
    	  
    	 
	    	
    	  %>
    	    <th> </th> 
    	    
    	  <%  
      }
      %>
      
       <%
       if (EnrollmentDetails.getEnrollmentDate()!=null) 
      {
    	  
    	//  System.out.println((EnrollmentDetails.getWelfareLifeTimeMember()));
	    	
    	  %>
    	      <th><%=EnrollmentDetails.getEnrollmentDate() %></th>
    	    
    	  <%  
      }
      %>
      
   
      
    </tr>
  
  <tr>
      <th>Blood Group</th>
      
         <%
      if (EnrollmentDetails.getBloodGroup()==null)
      {
    	  
    	 
	    	
    	  %>
    	    <th> </th> 
    	    
    	  <%  
      }
      %>
      
       <%
       if (EnrollmentDetails.getBloodGroup()!=null) 
      {
    	  
    	//  System.out.println((EnrollmentDetails.getWelfareLifeTimeMember()));
	    	
    	  %>
    	      <th><%=EnrollmentDetails.getBloodGroup() %></th>
    	    
    	  <%  
      }
      %>
      

      
    </tr>
  
  
  
  <tr>
      <th>Gender</th>
      
       <%
      if (EnrollmentDetails.getGender()=='F')
      {
    	  
    	  System.out.println((EnrollmentDetails.getGender()));
	    	
    	  %>
    	    <th>Female</th> 
    	    
    	  <%  
      }
      %>
      
       <%
        if (EnrollmentDetails.getGender()=='M')
      {
    	  
    	//  System.out.println((EnrollmentDetails.getWelfareLifeTimeMember()));
	    	
    	  %>
    	    <th>Male</th> 
    	    
    	  <%  
      }
      %>
      
     
    </tr>
  
  <tr>
      <th>Guardian Name </th>
      
      
         <%
      if (EnrollmentDetails.getGuardianName()==null)
      {
    	  
    	 
	    	
    	  %>
    	    <th> </th> 
    	    
    	  <%  
      }
      %>
      
       <%
       if (EnrollmentDetails.getGuardianName()!=null) 
      {
    	  
    	//  System.out.println((EnrollmentDetails.getWelfareLifeTimeMember()));
	    	
    	  %>
    	      <th><%=EnrollmentDetails.getGuardianName()%></th>
    	    
    	  <%  
      }
      %>
      
   
    </tr>
  
  <tr>
      <th>MobileNo</th>
      
      
      
         <%
      if (EnrollmentDetails.getMobileNo()==null)
      {
    	  
    	 
	    	
    	  %>
    	    <th> </th> 
    	    
    	  <%  
      }
      %>
      
       <%
       if (EnrollmentDetails.getMobileNo()!=null) 
      {
    	  
    	//  System.out.println((EnrollmentDetails.getWelfareLifeTimeMember()));
	    	
    	  %>
    	      <th><%=EnrollmentDetails.getMobileNo() %></th>
    	    
    	  <%  
      }
      %>

      
    </tr>
    
     <tr>
      <th>Welfare Fund Membership date</th>
      
      
         <%
      if (EnrollmentDetails.getWelfareMemberUpdatedDate()==null)
      {
    	  
    	 
	    	
    	  %>
    	    <th> </th> 
    	    
    	  <%  
      }
      %>
      
       <%
       if (EnrollmentDetails.getWelfareMemberUpdatedDate()!=null) 
      {
    	  
    	//  System.out.println((EnrollmentDetails.getWelfareLifeTimeMember()));
	    	
    	  %>
    	      <th><%=EnrollmentDetails.getWelfareMemberUpdatedDate() %></th>
    	    
    	  <%  
      }
      %>
    
      
    
  <tr>
      <th>Nominee Name</th>
      
      
         <%
      if (EnrollmentDetails.getNominee_Name()==null)
      {
    	  
    	 
	    	
    	  %>
    	    <th> </th> 
    	    
    	  <%  
      }
      %>
      
       <%
       if (EnrollmentDetails.getNominee_Name()!=null) 
      {
    	  
    	//  System.out.println((EnrollmentDetails.getWelfareLifeTimeMember()));
	    	
    	  %>
    	      <th><%=EnrollmentDetails.getNominee_Name() %></th>
    	    
    	  <%  
      }
      %>
      
    
    </tr>
  
  <tr>
      <th>RelationShip</th>
      
        
         <%
      if (EnrollmentDetails.getRelationship()==null)
      {
    	  
    	 
	    	
    	  %>
    	    <th> </th> 
    	    
    	  <%  
      }
      %>
      
       <%
       if (EnrollmentDetails.getRelationship()!=null) 
      {
    	  
    	//  System.out.println((EnrollmentDetails.getWelfareLifeTimeMember()));
	    	
    	  %>
    	      <th><%=EnrollmentDetails.getRelationship() %></th>
    	    
    	  <%  
      }
      %>
   
      
    </tr>
    
    
  <tr>
      <th>Place Of Practice</th>
      
         <%
      if (EnrollmentDetails.getPlace_Of_Practice()==null)
      {
    	  
    	 
	    	
    	  %>
    	    <th> </th> 
    	    
    	  <%  
      }
      %>
      
       <%
       if (EnrollmentDetails.getPlace_Of_Practice()!=null) 
      {
    	  
    	//  System.out.println((EnrollmentDetails.getWelfareLifeTimeMember()));
	    	
    	  %>
    	      <th><%=EnrollmentDetails.getPlace_Of_Practice() %></th>
    	    
    	  <%  
      }
      %>
    
      
    </tr>
  
  
    <tr>
      <th>Email ID</th>
      
      
         <%
      if (EnrollmentDetails.getEMail()==null)
      {
    	  
    	 
	    	
    	  %>
    	    <th> </th> 
    	    
    	  <%  
      }
      %>
      
       <%
       if (EnrollmentDetails.getEMail()!=null) 
      {
    	  
    	//  System.out.println((EnrollmentDetails.getWelfareLifeTimeMember()));
	    	
    	  %>
    	      <th><%=EnrollmentDetails.getEMail() %></th>
    	    
    	  <%  
      }
      %>
     
      
    </tr>
  
  
  <tr>
      <th>Date Of Birth</th>
      
      
         <%
      if (EnrollmentDetails.getDateOfBirth()==null)
      {
    	  
    	 
	    	
    	  %>
    	    <th> </th> 
    	    
    	  <%  
      }
      %>
      
       <%
       if (EnrollmentDetails.getDateOfBirth()!=null) 
      {
    	  
    	//  System.out.println((EnrollmentDetails.getWelfareLifeTimeMember()));
	    	
    	  %>
    	      <th><%=EnrollmentDetails.getDateOfBirth() %></th>
    	    
    	  <%  
      }
      %>
     
      
      
    </tr>
     
     
      <tr>
      <th>Senior Member Updated Date</th>
      
       <%
      if (EnrollmentDetails.getSeniorMemberUpdatedDate()==null)
      {
    	  
    	 
	    	
    	  %>
    	    <th> </th> 
    	    
    	  <%  
      }
      %>
      
       <%
       if (EnrollmentDetails.getSeniorMemberUpdatedDate()!=null) 
      {
    	  
    	//  System.out.println((EnrollmentDetails.getWelfareLifeTimeMember()));
	    	
    	  %>
    	      <th><%=EnrollmentDetails.getSeniorMemberUpdatedDate() %></th>
    	    
    	  <%  
      }
      %>
     
     
      
    </tr>
   <!--   From here its changing -->
       <tr>
      <th>Remarks</th>
      
        <%
      if (EnrollmentDetails.getRemarks()==null)
      {
    	  
    	 
	    	
    	  %>
    	    <th> </th> 
    	    
    	  <%  
      }
      %>
      
       <%
       if (EnrollmentDetails.getRemarks()!=null) 
      {
    	  
    	//  System.out.println((EnrollmentDetails.getWelfareLifeTimeMember()));
	    	
    	  %>
    	      <th><%=EnrollmentDetails.getRemarks() %></th>
    	    
    	  <%  
      }
      %>
   
    </tr>
    
    
      <tr>
      <th>AIB Remarks</th>
      
       <%
      if (EnrollmentDetails.getAIBRemarks()==null)
      {
    	  
    	 
	    	
    	  %>
    	    <th> </th> 
    	    
    	  <%  
      }
      %>
      
       <%
       if (EnrollmentDetails.getAIBRemarks()!=null) 
      {
    	  
    	//  System.out.println((EnrollmentDetails.getWelfareLifeTimeMember()));
	    	
    	  %>
    	      <th><%=EnrollmentDetails.getAIBRemarks() %></th>
    	    
    	  <%  
      }
      %>
     
     
      
    </tr>
    
      <tr>
      <th>AIB Year</th>
      
       <%
      if (EnrollmentDetails.getAIBDate()==null)
      {
    	  
    	 
	    	
    	  %>
    	    <th> </th> 
    	    
    	  <%  
      }
      %>
      
       <%
       if (EnrollmentDetails.getAIBDate()!=null) 
      {
    	  
    	//  System.out.println((EnrollmentDetails.getWelfareLifeTimeMember()));
	    	
    	  %>
    	      <th><%=EnrollmentDetails.getAIBDate() %></th>
    	    
    	  <%  
      }
      %>
     
     
      
    </tr>
      <tr>
      
      <th>Welfare LifeTimeMember</th>
     
      <%
      if (EnrollmentDetails.getWelfareLifeTimeMember()=='Y')
      {
    	  
    	  System.out.println((EnrollmentDetails.getWelfareLifeTimeMember()));
	    	
    	  %>
    	    <th>Yes</th> 
    	    
    	  <%  
      }
      %>
      
       <%
        if (EnrollmentDetails.getWelfareLifeTimeMember()=='N')
      {
    	  
    	  System.out.println((EnrollmentDetails.getWelfareLifeTimeMember()));
	    	
    	  %>
    	    <th>No</th> 
    	    
    	  <%  
      }
      %>
      
    
    </tr>
    <tr>
      <th>Welfare Remarks</th>
      
     <th><%= session.getAttribute("WelfatreDes")%></th>
     
   
    </tr>

    <%--   <tr>
      <th>Date Of Birth</th>
      <th><%=EnrollmentDetails.get%></th>
      
    </tr>
    
      <tr>
      <th>Date Of Birth</th>
      <th><%=EnrollmentDetails.getDateOfBirth()%></th>
      
    </tr> --%>
  </tbody>
</table>