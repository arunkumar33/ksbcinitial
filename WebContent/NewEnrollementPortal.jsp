<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Enrollment Section</title>

    <!-- Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
       <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
     <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/1.0.2/Chart.min.js"></script>
    
<!--     <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.js" type="text/javascript"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js" type="text/javascript"></script> -->
    <!-- Bootstrap -->
 <!--    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
  
 
  <link href="https://cdnjs.cloudflare.com/ajax/libs/nprogress/0.2.0/nprogress.min.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="CSS/custom.min.css" rel="stylesheet">
    
    <script type="text/javascript">
    
    function  CallToServletFromJSP(RegNumber,WhichMethod)
    {
   alert(RegNumber); 
     alert(WhichMethod); 
 /*   alert('********** challan ***********'); */
   var KARNumber=RegNumber; 
   var WhichFunctionToHandle=WhichMethod;
          $.get('AjaxServlet',{KARNumber:KARNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) {  
   $('#Main_Content1').html(responseText); 
  
  }); 
 /*  +"  }); "*/
/*	 +"   return false; "*/
   } 
   
   
    function LoadJspIntoTheDIV(JSPpage) {
   /*  	alert("dfgdfg"); */
   
   
   if ("GenerateCertificate"==JSPpage)
	   {
	   $('#Main_Content1').load('GenerateCertificate.jsp');
	   }
   
   else if ("MoveDataFromValidateBeanToEnrollment"==JSPpage)
   {
	   alert("MoveDataFromValidateBeanToEnrollment");
   $('#Main_Content1').load(' MoveDataFromValidateBeanToEnrollment.jsp');
   } 
   
   
   else if ("ScheduleInterView"==JSPpage)
	   {
	   $('#Main_Content1').load('ScheduleInterView.jsp');
	   }
   else if ("GenerateDuplicateCertificate"==JSPpage)
	   {
	   $('#Main_Content1').load('GenerateDuplicateCertificate.jsp');
	   }
   
   else if ("ViewDocument"==JSPpage)
   {
   $('#Main_Content1').load('ViewDocument.jsp');
   } 
   else if ("ChairmanSignature"==JSPpage)
   {
   $('#Main_Content1').load('ChairmanSignature.jsp');
   } 
   
   else if ("ChangeKARStatus"==JSPpage)
   {
   $('#Main_Content1').load('ChangeKARStatus.jsp');
   }   
	  
   
   
   else if ("SuspendUpdate"==JSPpage)
   {
   $('#Main_Content1').load('SuspendUpdate.jsp');
   } 
   
   
   else if ("GenerateKAR"==JSPpage)
   {
   $('#Main_Content1').load('GenerateKAR.jsp');
   }   
   
   else if ("AbsentList"==JSPpage)
   {
/*    $('#Main_Content1').load('AbsentList.jsp'); */
   $('#Main_Content1').load('AbsentList.jsp');
 
   }  
   
   
   else if ("ViewInterviewCandidate"==JSPpage)
   {
   $('#Main_Content1').load('ViewInterviewCandidate.jsp');
   }    
   
   else if ("ConfirmInterview"==JSPpage)
   {
   $('#Main_Content1').load('ConfirmInterview.jsp');
   }   // 

   
   else if ("EnrollmentCertificateByDate"==JSPpage)
   {
   $('#Main_Content1').load('EnrollmentCertificateByDate.jsp');
   }
   else if ("InsertIntotable"==JSPpage)
   {
   $('#Main_Content1').load('InsertIntotable.jsp');
   } 
   else if ("ViewInterviewConfirmCandidate"==JSPpage)
   {
   $('#Main_Content1').load('ViewInterviewConfirmCandidate.jsp');
   }  //ViewChangeKARCandidate
   
   else if ("ViewChangeKARCandidate"==JSPpage)
   {
   $('#Main_Content1').load('ViewChangeKARCandidate.jsp');
   }
   
   
   else if ("ResumptionUpdate"==JSPpage)
   {
   $('#Main_Content1').load('ResumptionUpdate.jsp');
   }
   else if ("GenerateReport"==JSPpage)
   {
   $('#Main_Content1').load('GenerateReport.jsp');
   } 
  
   else if ("ElectionReport"==JSPpage)
   {
   $('#Main_Content1').load('ElectionReport.jsp');
   }  
   
  
   
   
   else if ("AdmissionReport"==JSPpage)
   {
   $('#Main_Content1').load('AdmissionReport.jsp');
   }  
   //NewEnrollmentTODoList
   
 else if ("NewEnrollmentTODoList"==JSPpage)
   {
   $('#Main_Content1').load('NewEnrollmentTODoList.jsp');
   }  
   else if ("UpdatedReport"==JSPpage)
   {
   $('#Main_Content1').load('UpdatedReport.jsp');
   } 
   
   
   
   else if ("KARStatusUSingName"==JSPpage)
   {
   $('#Main_Content1').load('KARStatusUSingName.jsp');
   } 
   
   
   else if ("TtansferInput"==JSPpage)
   {
   $('#Main_Content1').load('TtansferInput.jsp');
   } 
   
   else if ("AcceptedCAndidate"==JSPpage)
   {
   $('#Main_Content1').load('AcceptedCAndidate.jsp');
   } 
   
   else if ("AddPhoto"==JSPpage)
   {
   $('#Main_Content1').load('AddPhoto.jsp');
   } 
   else if ("EditForm"==JSPpage)
   {
   $('#Main_Content1').load('EditForm.jsp');
   }  
   
   else if ("ResumptionReport"==JSPpage)
   {
   $('#Main_Content1').load('ResumptionReport.jsp');
   } 
   else if ("AcceptList"==JSPpage)
   {
   $('#Main_Content1').load('AcceptList.jsp');
   } 
   
   
   else if ("IncomingReport"==JSPpage)
   {
   $('#Main_Content1').load('IncomingReport.jsp');
   } 
   else if ("TransferUpdate"==JSPpage)
   {
   $('#Main_Content1').load('TransferUpdate.jsp');
   } 
   else if ("SuspentionReportjsp"==JSPpage)
   {
   $('#Main_Content1').load('SuspentionReportjsp.jsp');
   } 
   
   
   else if ("ActiveList"==JSPpage)
   {
   $('#Main_Content1').load('ActiveList.jsp');
   } 
   
   else if ("AIB"==JSPpage)
   {
   $('#Main_Content1').load('AIB.jsp');
   } 
   else if ("EditConfirmList"==JSPpage)
   {
   $('#Main_Content1').load('EditConfirmList.jsp');
   } 
   else if ("TransferReport"==JSPpage)
   {
   $('#Main_Content1').load('TransferReport.jsp');
   } 
   
   
   else if ("GenerateCertificateForBand"==JSPpage)
   {
   $('#Main_Content1').load('GenerateCertificateForBand.jsp');
   } 
    }
    
   
    
   
	   
	   
	   
	   function  CallToImageServletFromJSP(RegNumber,WhichPhoto)
	    {
	//alert('********** CallToImageServletFromJSP ***********');
	   var RegNumber=RegNumber; 
	   var WhichPhoto=WhichPhoto;
	          $.get('ImageServlet',{RegNumber:RegNumber,WhichPhoto:WhichPhoto},function(responseText) {  
	   $('#Image_ForDocument').html(responseText); 
	  
	  }); 
	 /*  +"  }); "*/
/*	 +"   return false; "*/
	   } 
	   function CallToServletFromJSPForNewEnrollmentTodoList2(ReceiptNumber,Particulars)
	   {
		  
		   alert(ReceiptNumber);
		   alert(Particulars);
		   var WhichFunctionToHandle="CallToServletFromJSPForWelfareTodoList";
			          $.get('AjaxServlet',{ReceiptNumber:ReceiptNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText)

					  { 
				 		
								  LoadJspIntoTheDIV('NewEnrollmentTODoList'); 
								
							
					  }); 
	   }
	   
	   function CallToServletFromJSPForNewEnrollmentTodoList1(ReceiptNumber,Particulars)
	   {
		  
		   alert(ReceiptNumber);
		   alert(Particulars);
		 
				 		  if (Particulars=='Enrollment Fee')
								  {
								  LoadJspIntoTheDIV('TtansferInput'); 
								  }
				 		 
							  else  if (Particulars=='Change Of Address')
							  {
							  LoadJspIntoTheDIV('ChangeKARStatus'); 
							  }
							  else  if (Particulars=='KSBC Change Of Address')
							  {
							  LoadJspIntoTheDIV('ChangeKARStatus'); 
							  }
							  
							  else  if (Particulars=='KSBC VSP')
							  {
							  LoadJspIntoTheDIV('SuspendUpdate'); 
							  }
							  
							  else  if (Particulars=='KSBC Certificate Copy Charges')
							  {
							  LoadJspIntoTheDIV('GenerateDuplicateCertificate'); 
							  }
							  else  if (Particulars=='KSBC Continuity Certificate')
							  {
							  LoadJspIntoTheDIV('GenerateDuplicateCertificate'); 
							  }
							  else  if (Particulars=='Resumption')
							  {
							  LoadJspIntoTheDIV('ResumptionUpdate'); 
							  }
							  else  if (Particulars=='KSBC Certificate Copy Charges')
							  {
							  LoadJspIntoTheDIV('GenerateDuplicateCertificate'); 
							  }
				 		 
				 		 
				 		 else  if (Particulars=='KSBC NOC')
						  {
						  LoadJspIntoTheDIV('InsertIntotable'); 
						  }
							  else
								  {
								  
					  			  
								  LoadJspIntoTheDIV('TtansferInput'); 
								  }
							alert('Done');   
					
					  
					
			   }
	   
	   
	   function CallToServletFromJSPForNewEnrollmentTodoList1(ReceiptNumber,Particulars)
	   {
		  
		   alert(ReceiptNumber);
		   alert(Particulars);
		 
				 		  if (Particulars=='Enrollment Fee')
								  {
								  LoadJspIntoTheDIV('TtansferInput'); 
								  }
				 		 
							  else  if (Particulars=='Change Of Address')
							  {
							  LoadJspIntoTheDIV('ChangeKARStatus'); 
							  }
							  else  if (Particulars=='KSBC Change Of Address')
							  {
							  LoadJspIntoTheDIV('ChangeKARStatus'); 
							  }
							  
							  else  if (Particulars=='KSBC VSP')
							  {
							  LoadJspIntoTheDIV('SuspendUpdate'); 
							  }
							  
							  else  if (Particulars=='KSBC Certificate Copy Charges')
							  {
							  LoadJspIntoTheDIV('GenerateDuplicateCertificate'); 
							  }
							  else  if (Particulars=='KSBC Continuity Certificate')
							  {
							  LoadJspIntoTheDIV('GenerateDuplicateCertificate'); 
							  }
							  else  if (Particulars=='Resumption')
							  {
							  LoadJspIntoTheDIV('ResumptionUpdate'); 
							  }
							  else  if (Particulars=='KSBC Certificate Copy Charges')
							  {
							  LoadJspIntoTheDIV('GenerateDuplicateCertificate'); 
							  }
				 		 
				 		 
				 		 else  if (Particulars=='KSBC NOC')
						  {
						  LoadJspIntoTheDIV('InsertIntotable'); 
						  }
							  else
								  {
								  
					  			  
								  LoadJspIntoTheDIV('TtansferInput'); 
								  }
							alert('Done');   
					
					  
					
			   }
	   
	   function CallToServletFromJSPForNewEnrollmentTodoList(ReceiptNumber)
	   {
		
			  
		
		   var ReceiptNumber=ReceiptNumber; 
		   var WhichFunctionToHandle="CallToServletFromJSPForWelfareTodoList";
		          $.get('AjaxServlet',{ReceiptNumber:ReceiptNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) {  
		    LoadJspIntoTheDIV('TtansferInput');
		  
		  });  
		  
		  
		    
		   
		   
	   }
	   
	   
	   function  CallToServletFromJSPWithKARNumber(KARNumber,WhichMethod)
	    {
	  
	   var KARNumber=KARNumber; 
	   var WhichFunctionToHandle=WhichMethod;
	          $.get('AjaxServlet',{KARNumber:KARNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) {  
	   $('#Main_Content1').html(responseText); 
	  
	  }); 
	 /*  +"  }); "*/
/*	 +"   return false; "*/
	   } 
	   function CallToServletForReport()
	   {
		 
		   $.get('EnrollemntGenreationForServlet',{},function(responseText) {  
			   $('#profile_info1').html(responseText); 
		 }); 
	   }
	   
	
	   function CallToServletForGenerateKAR()
	   {
		
		   $.get('GenerateAllCandidateKAR',{},function(responseText) {  
			   $('#profile_info1').html(responseText); 
		 }); 
	   }
	   
	   function  CallToServletFromJSPForKARNumber(KARNumber,WhichMethod,payingFor)
	   {
	  
	    var KARNumber=KARNumber; 
	   var WhichFunctionToHandle=WhichMethod;
	   var payingForDetails=payingFor;

	   alert(payingForDetails);
	           $.get('AjaxServlet',{KARNumber:KARNumber,WhichFunctionToHandle:WhichFunctionToHandle,payingForDetails:payingForDetails},function(responseText) {  
	    $('#Main_Content1').html(responseText); 

	   }); 

	   }
	   
	   
	   
	   function  CallToServletForImage(REGNumber,WhichPhoto,WhichMethod)
	   {
	  
	  
	    var REGNumber=REGNumber; 
	   var WhichFunctionToHandle=WhichMethod;
	   var WhichPhoto=WhichPhoto;

	
	           $.get('AjaxServlet',{REGNumber:REGNumber,WhichFunctionToHandle:WhichFunctionToHandle,WhichPhoto:WhichPhoto},function(responseText) {  
	    $('#Main_Content1').html(responseText); 

	   }); 

	   }
	   
    </script>
    
   <style>

table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #e6f2ff;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #e6f2ff;
}

</style>


  </head>

  <body class="nav-md" id="profile_info1">
  
<%--   <% 
  System.out.println(session.getAttribute("UserName"));
 
  if ((session.getAttribute("UserName")==null) || (session.getAttribute("UserName")==""))
  {
	  System.out.println("******** UserName and password is not correct  ***********");
	  %>
	   <jsp:forward page="index1.jsp"> 
	<jsp:param name="name" value="Pritesh" /> 
	<jsp:param name="site" value="www.c4learn.com" /> 
</jsp:forward> 
  <%
  }
  
  %> --%>
  

  
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <!-- <a href="index1.jsp" class="site_title"> <span>KSBC</span></a> -->
               <img alt="ksbc" src="ksbc_logo.jpg">
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            <div class="profile clearfix">
			<!--
              <div class="profile_pic">
                <img src="images/img.jpg" alt="..." class="img-circle profile_img">
              </div>
			  -->
              <div class="profile_info">
			  <h4><b>Enrollment</b></h4> </br>
                <span>Welcome,	</span>
                <h2><%=session.getAttribute("UserName") %></h2>
              </div>
            </div>
            <!-- /menu profile quick info -->

            <br />

            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>General</h3>
                <ul class="nav side-menu">
                  <li><a><i class="fa fa-calendar-check-o"></i>Interview<span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <!-- <li><a href="index.html">Schedule Interview</a></li> -->
						<li><div class="Schedule" onclick="LoadJspIntoTheDIV('ScheduleInterView')"> <b>Schedule Interview</b></div></li>
                      <li><a onclick="LoadJspIntoTheDIV('ViewInterviewCandidate')">View Eligible Candidate</a></li>
                      <li><a onclick="LoadJspIntoTheDIV('AbsentList')">Absent List</a></li>
                       <li><a onclick="LoadJspIntoTheDIV('ViewInterviewConfirmCandidate')">View Interview Confirm List</a></li>
					  <li><a onclick="LoadJspIntoTheDIV('ConfirmInterview')">Confirm Interview</a></li>
					   <li><a onclick="LoadJspIntoTheDIV('AcceptedCAndidate')">Accepted Candidate List</a></li>
			      </ul>
                  </li>
                  <li><a><i class="fa fa-graduation-cap"></i> Certificate <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a onclick="LoadJspIntoTheDIV('GenerateCertificate')">Generate Certificate</a></li>
                      <li><a onclick="LoadJspIntoTheDIV('GenerateDuplicateCertificate')">Generate duplicate Certificate</a></li>
                      
                    
                         <li><a onclick="LoadJspIntoTheDIV('GenerateCertificateForBand')">Generate Certificate Agreement</a></li>
                 
                      <li><a onclick="LoadJspIntoTheDIV('EnrollmentCertificateByDate')">Generate Certificate By Enrollment Date</a></li>
                   
                     <li><a onclick="LoadJspIntoTheDIV('AddPhoto')">Add Photo</a></li> 
                     <li><a onclick="LoadJspIntoTheDIV('ChairmanSignature')">Add ChairmanSignature</a></li>
       
                    </ul>
                  </li>
                  <li><a><i class="fa fa-desktop"></i> Transfer <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a onclick="LoadJspIntoTheDIV('InsertIntotable')">Add Transfered Advocate</a></li>
                      
                     
                    </ul>
                  </li>
                  <li><a><i class="fa fa-table"></i> Validate <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a onclick="LoadJspIntoTheDIV('ViewDocument')">View Document</a></li>
                      
                    </ul>
                  </li>
                  <li><a><i class="fa fa-edit"></i> View KAR <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a onclick="LoadJspIntoTheDIV('ChangeKARStatus')">Change KAR Status</a></li>
                         <li><a onclick="LoadJspIntoTheDIV('ViewChangeKARCandidate')">Eligible KAR Changes</a></li>
                           <li><a onclick="LoadJspIntoTheDIV('TtansferInput')">Offline Form Fill</a></li>
                            <li><a onclick="LoadJspIntoTheDIV('InsertIntotable')">Edit Data</a></li>
                            <li><a onclick="LoadJspIntoTheDIV('EditForm')">Update KAR details</a></li>
                             <li><a onclick="LoadJspIntoTheDIV('EditConfirmList')">Edit Confirm List</a></li>
                            
                            <li><a onclick="LoadJspIntoTheDIV('KARStatusUSingName')">Search By Name</a></li>
                            
                            <li><a onclick="LoadJspIntoTheDIV('ResumptionUpdate')">Add Resumption</a></li>
                 
                  <li><a onclick="LoadJspIntoTheDIV('SuspendUpdate')">Add Suspend</a></li>
               <li><a onclick="LoadJspIntoTheDIV('TransferUpdate')">Add Transfer</a></li>
              <li><a onclick="LoadJspIntoTheDIV('AIB')">AIB</a></li>
                 
                    </ul>
                  </li>
				  
				  
				   <!-- <li><a><i class="fa fa-edit"></i> Edit Advocate Details <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a onclick="LoadJspIntoTheDIV('AdvocateChangeName')">Change Advocate Name</a></li>
                         <li><a onclick="LoadJspIntoTheDIV('ChangeAdvocateAddress')">Change Advocate Address</a></li>
                           </ul>
                  </li> -->
                  
                  
				  <li><a><i class="fa fa-desktop"></i>  Reports <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a onclick="LoadJspIntoTheDIV('GenerateReport')">Generate Report</a></li>
                     <li><a onclick="LoadJspIntoTheDIV('ElectionReport')">Election Report</a></li>
                           <li><a onclick="LoadJspIntoTheDIV('ResumptionReport')">Resumption Report</a></li>
                            <li><a onclick="LoadJspIntoTheDIV('SuspentionReportjsp')">Suspend  Report</a></li>
        <li><a onclick="LoadJspIntoTheDIV('TransferReport')">Transfer  Report</a></li>
        <li><a onclick="LoadJspIntoTheDIV('IncomingReport')">Incoming Transfer  Report</a></li>
       
      <!--   <li><a onclick="LoadJspIntoTheDIV('ActiveList')">Active List</a></li> -->
                 <!--   <li><a onclick="LoadJspIntoTheDIV('AdmissionReport')">Admission Report</a></li>
                     <li><a onclick="LoadJspIntoTheDIV('UpdatedReport')">Updated Report</a></li>
                     --> </ul>
                  </li>
				  
				  
				<!--   todo list report -->
				
				 <li><a><i class="fa fa-desktop"></i>  ToDo List <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a onclick="LoadJspIntoTheDIV('NewEnrollmentTODoList')">My To Do List</a></li>
                      </ul>
                  </li>
				  
				  
                </ul>
              </div>
      
            </div>
          
			
            <!-- /menu footer buttons -->
          </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
          <div class="nav_menu">
            <nav>
              <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
              </div>

              <ul class="nav navbar-nav navbar-right">
                <li class="">
                  <a href="Logout.jsp" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    Log Out
                    <span class=" fa fa-angle-down"></span>
                  </a>
                  <ul class="dropdown-menu dropdown-usermenu pull-right">
                    
                    <li><a href="login.html"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
                  </ul>
                </li>

				
              </ul>
            </nav>
          </div>
        </div>
        <!-- /top navigation -->

        <!-- page content -->
		<div class="right_col" role="main">
		
		<!-- <div id="Main_Content">
		Hi Everyone This is the Templet for the New Enrollment
		
		
		</div> -->
		
		<div  id="Main_Content1">
		
		<center>
		<br> <br> <br> <br>
		<canvas id="mycanvas" width="300" height="300"></canvas> </center>
		 <br> <br> <br> <br> <br> <br> 
		<center>
		
		<button type="button" id="CanvasButton" class="btn btn-info">Trigger Chart</button>
		
		</center>
		
		<script type="text/javascript">
		               
		                $('#CanvasButton').click(function(event) { 
			
				var ctx = $("#mycanvas").get(0).getContext("2d");

				var data = [
					{
						value: 270,
						color: "cornflowerblue",
						highlight: "lightskyblue",
						label: "Misc"
					},
					{
						value: 50,
						color: "lightgreen",
						highlight: "yellowgreen",
						label: "KLA"
					},
					{
						value: 70,
						color: "orange",
						highlight: "darkorange",
						label: "IC"
					}
				];

				var chart = new Chart(ctx).Doughnut(data);
			
			  }); 
			
			               /*   $.get('AjaxServlet',{EndDate:EndDate,WhichFunctionToHandle:WhichFunctionToHandle,StartDate:StartDate},function(responseText) { 
			                        $('#profile_info1').html(responseText);         
			                    });
			                }); */
		
		</script>
		 </div>
		<!-- <img alt="" src=""  id="Image_ForDocument"/> -->
		</div>
		
		<div id="Result"></div>
		
		<!--
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>Contacts Design</h3>
              </div>

              <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                  <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search for...">
                    <span class="input-group-btn">
                      <button class="btn btn-default" type="button">Go!</button>
                    </span>
                  </div>
                </div>
              </div>
            </div>

            <div class="clearfix"></div>

            <div class="row">
              <div class="col-md-12">
                <div class="x_panel">
                  <div class="x_content">
                    <div class="row">
                      <div class="col-md-12 col-sm-12 col-xs-12 text-center">
                        <ul class="pagination pagination-split">
                          <li><a href="#">A</a></li>
                          <li><a href="#">B</a></li>
                          <li><a href="#">C</a></li>
                          <li><a href="#">D</a></li>
                          <li><a href="#">E</a></li>
                          <li>...</li>
                          <li><a href="#">W</a></li>
                          <li><a href="#">X</a></li>
                          <li><a href="#">Y</a></li>
                          <li><a href="#">Z</a></li>
                        </ul>
                      </div>

                      <div class="clearfix"></div>

                      <div class="col-md-4 col-sm-4 col-xs-12 profile_details">
                        <div class="well profile_view">
                          <div class="col-sm-12">
                            <h4 class="brief"><i>Digital Strategist</i></h4>
                            <div class="left col-xs-7">
                              <h2>Nicole Pearson</h2>
                              <p><strong>About: </strong> Web Designer / UX / Graphic Artist / Coffee Lover </p>
                              <ul class="list-unstyled">
                                <li><i class="fa fa-building"></i> Address: </li>
                                <li><i class="fa fa-phone"></i> Phone #: </li>
                              </ul>
                            </div>
                            <div class="right col-xs-5 text-center">
                              <img src="images/img.jpg" alt="" class="img-circle img-responsive">
                            </div>
                          </div>
                          <div class="col-xs-12 bottom text-center">
                            <div class="col-xs-12 col-sm-6 emphasis">
                              <p class="ratings">
                                <a>4.0</a>
                                <a href="#"><span class="fa fa-star"></span></a>
                                <a href="#"><span class="fa fa-star"></span></a>
                                <a href="#"><span class="fa fa-star"></span></a>
                                <a href="#"><span class="fa fa-star"></span></a>
                                <a href="#"><span class="fa fa-star-o"></span></a>
                              </p>
                            </div>
                            <div class="col-xs-12 col-sm-6 emphasis">
                              <button type="button" class="btn btn-success btn-xs"> <i class="fa fa-user">
                                </i> <i class="fa fa-comments-o"></i> </button>
                              <button type="button" class="btn btn-primary btn-xs">
                                <i class="fa fa-user"> </i> View Profile
                              </button>
                            </div>
                          </div>
                        </div>
                      </div>

                      <div class="col-md-4 col-sm-4 col-xs-12 profile_details">
                        <div class="well profile_view">
                          <div class="col-sm-12">
                            <h4 class="brief"><i>Digital Strategist</i></h4>
                            <div class="left col-xs-7">
                              <h2>Nicole Pearson</h2>
                              <p><strong>About: </strong> Web Designer / UI. </p>
                              <ul class="list-unstyled">
                                <li><i class="fa fa-building"></i> Address: </li>
                                <li><i class="fa fa-phone"></i> Phone #: </li>
                              </ul>
                            </div>
                            <div class="right col-xs-5 text-center">
                              <img src="images/user.png" alt="" class="img-circle img-responsive">
                            </div>
                          </div>
                          <div class="col-xs-12 bottom text-center">
                            <div class="col-xs-12 col-sm-6 emphasis">
                              <p class="ratings">
                                <a>4.0</a>
                                <a href="#"><span class="fa fa-star"></span></a>
                                <a href="#"><span class="fa fa-star"></span></a>
                                <a href="#"><span class="fa fa-star"></span></a>
                                <a href="#"><span class="fa fa-star"></span></a>
                                <a href="#"><span class="fa fa-star-o"></span></a>
                              </p>
                            </div>
                            <div class="col-xs-12 col-sm-6 emphasis">
                              <button type="button" class="btn btn-success btn-xs"> <i class="fa fa-user">
                                </i> <i class="fa fa-comments-o"></i> </button>
                              <button type="button" class="btn btn-primary btn-xs">
                                <i class="fa fa-user"> </i> View Profile
                              </button>
                            </div>
                          </div>
                        </div>
                      </div>

                      <div class="col-md-4 col-sm-4 col-xs-12 profile_details">
                        <div class="well profile_view">
                          <div class="col-sm-12">
                            <h4 class="brief"><i>Digital Strategist</i></h4>
                            <div class="left col-xs-7">
                              <h2>Nicole Pearson</h2>
                              <p><strong>About: </strong> Web Designer / UI. </p>
                              <ul class="list-unstyled">
                                <li><i class="fa fa-building"></i> Address: </li>
                                <li><i class="fa fa-phone"></i> Phone #: </li>
                              </ul>
                            </div>
                            <div class="right col-xs-5 text-center">
                              <img src="images/user.png" alt="" class="img-circle img-responsive">
                            </div>
                          </div>
                          <div class="col-xs-12 bottom text-center">
                            <div class="col-xs-12 col-sm-6 emphasis">
                              <p class="ratings">
                                <a>4.0</a>
                                <a href="#"><span class="fa fa-star"></span></a>
                                <a href="#"><span class="fa fa-star"></span></a>
                                <a href="#"><span class="fa fa-star"></span></a>
                                <a href="#"><span class="fa fa-star"></span></a>
                                <a href="#"><span class="fa fa-star-o"></span></a>
                              </p>
                            </div>
                            <div class="col-xs-12 col-sm-6 emphasis">
                              <button type="button" class="btn btn-success btn-xs"> <i class="fa fa-user">
                                </i> <i class="fa fa-comments-o"></i> </button>
                              <button type="button" class="btn btn-primary btn-xs">
                                <i class="fa fa-user"> </i> View Profile
                              </button>
                            </div>
                          </div>
                        </div>
                      </div>

                      <div class="col-md-4 col-sm-4 col-xs-12 profile_details">
                        <div class="well profile_view">
                          <div class="col-sm-12">
                            <h4 class="brief"><i>Digital Strategist</i></h4>
                            <div class="left col-xs-7">
                              <h2>Nicole Pearson</h2>
                              <p><strong>About: </strong> Web Designer / UI. </p>
                              <ul class="list-unstyled">
                                <li><i class="fa fa-building"></i> Address: </li>
                                <li><i class="fa fa-phone"></i> Phone #: </li>
                              </ul>
                            </div>
                            <div class="right col-xs-5 text-center">
                              <img src="images/user.png" alt="" class="img-circle img-responsive">
                            </div>
                          </div>
                          <div class="col-xs-12 bottom text-center">
                            <div class="col-xs-12 col-sm-6 emphasis">
                              <p class="ratings">
                                <a>4.0</a>
                                <a href="#"><span class="fa fa-star"></span></a>
                                <a href="#"><span class="fa fa-star"></span></a>
                                <a href="#"><span class="fa fa-star"></span></a>
                                <a href="#"><span class="fa fa-star"></span></a>
                                <a href="#"><span class="fa fa-star-o"></span></a>
                              </p>
                            </div>
                            <div class="col-xs-12 col-sm-6 emphasis">
                              <button type="button" class="btn btn-success btn-xs"> <i class="fa fa-user">
                                </i> <i class="fa fa-comments-o"></i> </button>
                              <button type="button" class="btn btn-primary btn-xs">
                                <i class="fa fa-user"> </i> View Profile
                              </button>
                            </div>
                          </div>
                        </div>
                      </div>
                      
                      <div class="col-md-4 col-sm-4 col-xs-12 profile_details">
                        <div class="well profile_view">
                          <div class="col-sm-12">
                            <h4 class="brief"><i>Digital Strategist</i></h4>
                            <div class="left col-xs-7">
                              <h2>Nicole Pearson</h2>
                              <p><strong>About: </strong> Web Designer / UX / Graphic Artist / Coffee Lover </p>
                              <ul class="list-unstyled">
                                <li><i class="fa fa-building"></i> Address: </li>
                                <li><i class="fa fa-phone"></i> Phone #: </li>
                              </ul>
                            </div>
                            <div class="right col-xs-5 text-center">
                              <img src="images/img.jpg" alt="" class="img-circle img-responsive">
                            </div>
                          </div>
                          <div class="col-xs-12 bottom text-center">
                            <div class="col-xs-12 col-sm-6 emphasis">
                              <p class="ratings">
                                <a>4.0</a>
                                <a href="#"><span class="fa fa-star"></span></a>
                                <a href="#"><span class="fa fa-star"></span></a>
                                <a href="#"><span class="fa fa-star"></span></a>
                                <a href="#"><span class="fa fa-star"></span></a>
                                <a href="#"><span class="fa fa-star-o"></span></a>
                              </p>
                            </div>
                            <div class="col-xs-12 col-sm-6 emphasis">
                              <button type="button" class="btn btn-success btn-xs"> <i class="fa fa-user">
                                </i> <i class="fa fa-comments-o"></i> </button>
                              <button type="button" class="btn btn-primary btn-xs">
                                <i class="fa fa-user"> </i> View Profile
                              </button>
                            </div>
                          </div>
                        </div>
                      </div>

                      <div class="col-md-4 col-sm-4 col-xs-12 profile_details">
                        <div class="well profile_view">
                          <div class="col-sm-12">
                            <h4 class="brief"><i>Digital Strategist</i></h4>
                            <div class="left col-xs-7">
                              <h2>Nicole Pearson</h2>
                              <p><strong>About: </strong> Web Designer / UI. </p>
                              <ul class="list-unstyled">
                                <li><i class="fa fa-building"></i> Address: </li>
                                <li><i class="fa fa-phone"></i> Phone #: </li>
                              </ul>
                            </div>
                            <div class="right col-xs-5 text-center">
                              <img src="images/user.png" alt="" class="img-circle img-responsive">
                            </div>
                          </div>
                          <div class="col-xs-12 bottom text-center">
                            <div class="col-xs-12 col-sm-6 emphasis">
                              <p class="ratings">
                                <a>4.0</a>
                                <a href="#"><span class="fa fa-star"></span></a>
                                <a href="#"><span class="fa fa-star"></span></a>
                                <a href="#"><span class="fa fa-star"></span></a>
                                <a href="#"><span class="fa fa-star"></span></a>
                                <a href="#"><span class="fa fa-star-o"></span></a>
                              </p>
                            </div>
                            <div class="col-xs-12 col-sm-6 emphasis">
                              <button type="button" class="btn btn-success btn-xs"> <i class="fa fa-user">
                                </i> <i class="fa fa-comments-o"></i> </button>
                              <button type="button" class="btn btn-primary btn-xs">
                                <i class="fa fa-user"> </i> View Profile
                              </button>
                            </div>
                          </div>
                        </div>
                      </div>

                      <div class="col-md-4 col-sm-4 col-xs-12 profile_details">
                        <div class="well profile_view">
                          <div class="col-sm-12">
                            <h4 class="brief"><i>Digital Strategist</i></h4>
                            <div class="left col-xs-7">
                              <h2>Nicole Pearson</h2>
                              <p><strong>About: </strong> Web Designer / UI. </p>
                              <ul class="list-unstyled">
                                <li><i class="fa fa-building"></i> Address: </li>
                                <li><i class="fa fa-phone"></i> Phone #: </li>
                              </ul>
                            </div>
                            <div class="right col-xs-5 text-center">
                              <img src="images/user.png" alt="" class="img-circle img-responsive">
                            </div>
                          </div>
                          <div class="col-xs-12 bottom text-center">
                            <div class="col-xs-12 col-sm-6 emphasis">
                              <p class="ratings">
                                <a>4.0</a>
                                <a href="#"><span class="fa fa-star"></span></a>
                                <a href="#"><span class="fa fa-star"></span></a>
                                <a href="#"><span class="fa fa-star"></span></a>
                                <a href="#"><span class="fa fa-star"></span></a>
                                <a href="#"><span class="fa fa-star-o"></span></a>
                              </p>
                            </div>
                            <div class="col-xs-12 col-sm-6 emphasis">
                              <button type="button" class="btn btn-success btn-xs"> <i class="fa fa-user">
                                </i> <i class="fa fa-comments-o"></i> </button>
                              <button type="button" class="btn btn-primary btn-xs">
                                <i class="fa fa-user"> </i> View Profile
                              </button>
                            </div>
                          </div>
                        </div>
                      </div>

                      <div class="col-md-4 col-sm-4 col-xs-12 profile_details">
                        <div class="well profile_view">
                          <div class="col-sm-12">
                            <h4 class="brief"><i>Digital Strategist</i></h4>
                            <div class="left col-xs-7">
                              <h2>Nicole Pearson</h2>
                              <p><strong>About: </strong> Web Designer / UI. </p>
                              <ul class="list-unstyled">
                                <li><i class="fa fa-building"></i> Address: </li>
                                <li><i class="fa fa-phone"></i> Phone #: </li>
                              </ul>
                            </div>
                            <div class="right col-xs-5 text-center">
                              <img src="images/user.png" alt="" class="img-circle img-responsive">
                            </div>
                          </div>
                          <div class="col-xs-12 bottom text-center">
                            <div class="col-xs-12 col-sm-6 emphasis">
                              <p class="ratings">
                                <a>4.0</a>
                                <a href="#"><span class="fa fa-star"></span></a>
                                <a href="#"><span class="fa fa-star"></span></a>
                                <a href="#"><span class="fa fa-star"></span></a>
                                <a href="#"><span class="fa fa-star"></span></a>
                                <a href="#"><span class="fa fa-star-o"></span></a>
                              </p>
                            </div>
                            <div class="col-xs-12 col-sm-6 emphasis">
                              <button type="button" class="btn btn-success btn-xs"> <i class="fa fa-user">
                                </i> <i class="fa fa-comments-o"></i> </button>
                              <button type="button" class="btn btn-primary btn-xs">
                                <i class="fa fa-user"> </i> View Profile
                              </button>
                            </div>
                          </div>
                        </div>
                      </div>

                      <div class="col-md-4 col-sm-4 col-xs-12 profile_details">
                        <div class="well profile_view">
                          <div class="col-sm-12">
                            <h4 class="brief"><i>Digital Strategist</i></h4>
                            <div class="left col-xs-7">
                              <h2>Nicole Pearson</h2>
                              <p><strong>About: </strong> Web Designer / UI. </p>
                              <ul class="list-unstyled">
                                <li><i class="fa fa-building"></i> Address: </li>
                                <li><i class="fa fa-phone"></i> Phone #: </li>
                              </ul>
                            </div>
                            <div class="right col-xs-5 text-center">
                              <img src="images/user.png" alt="" class="img-circle img-responsive">
                            </div>
                          </div>
                          <div class="col-xs-12 bottom text-center">
                            <div class="col-xs-12 col-sm-6 emphasis">
                              <p class="ratings">
                                <a>4.0</a>
                                <a href="#"><span class="fa fa-star"></span></a>
                                <a href="#"><span class="fa fa-star"></span></a>
                                <a href="#"><span class="fa fa-star"></span></a>
                                <a href="#"><span class="fa fa-star"></span></a>
                                <a href="#"><span class="fa fa-star-o"></span></a>
                              </p>
                            </div>
                            <div class="col-xs-12 col-sm-6 emphasis">
                              <button type="button" class="btn btn-success btn-xs"> <i class="fa fa-user">
                                </i> <i class="fa fa-comments-o"></i> </button>
                              <button type="button" class="btn btn-primary btn-xs">
                                <i class="fa fa-user"> </i> View Profile
                              </button>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
		-->
        <!-- /page content -->

        <!-- footer content -->
        <footer>
		 
          <div class="pull-right">
            Designed and Developed By <b>SAS Info Solutions</b></a>
          </div>
		 
          <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
      </div>
    </div>

 

  </body>
  
  
  
  
    <!-- Custom Theme Scripts -->
    <script src="JS/custom.min.js"></script>
    
  <!--   Calling An Servlet -->
    
    
  <!-- <script type="text/javascript">
 
/* var form = $('#FormWithRegNumber');
form.submit(function () {
 
$.ajax({
type: form.attr('method'),
url: form.attr('action'),
data: form.serialize(),
success: function (data) {
 var result=data;
alert(data);
 $('#Main_Content1').html("HI guru"); 
// document.getElementById("Main_Content").innerHTML=result;
 
 alert("Hi");
}
});
 
return false;
}); */


var req;//global variable
//function to get the keyword and generate request object
function sendRequest()
{
//for firefox/safari/opera/google chrome
if (window.XMLHttpRequest) {
	alert('chrome');
req = new XMLHttpRequest( );
}
else if (window.ActiveXObject)//for IE
{req = new ActiveXObject("Microsoft.XMLHTTP");}
//concatenate the city name as parameter value to url
var url = "AjaxServlet?ScheduleInterview="+"Hi";
//check server request state and invoke getResponse()
req.onreadystatechange = getResponse;
req.open("GET", url, true);//send request to server
req.send(null);
}



//function to get the response and display in the specific area
function getResponse()
{
if (req.readyState==4) //if request is complete
{
	alert('dfgdfgdfghxgsdfhdfgdghxd');
if (req.status == 200) //if target page is found
{
	alert("StaTUS");
//write the response text in the div area
alert (req.responseText);
//SendItToDIV(req.responseText);
 document.getElementById("Main_Content1").innerHTML =req.responseText; 
 return false;
/*  document.getElementById("Main_Content1").innerHTML ="fgdfgd"; 
 $(document.getElementById('Main_Content1')).html('fgdfgd');
  $('#Main_Content1').load('ScheduleInterView.jsp');
$('#Result').html("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH"); */

/* alert('Coming to the last page'); */
}
}
}

function SendItToDIV(response)
{
	alert("From SendItToDIV");
	$(document).ready(function(){
		
		alert("From SendItToDIV");
		
	});
	document.getElementById("profile_info1").innerHTML+="fgdfgd";
	
	alert("***w123123* After SendItToDIV *******");
	
	return false;
	}


</script> -->


</html>