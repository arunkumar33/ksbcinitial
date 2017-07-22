<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>WelfareAccountPortal</title>

    <!-- Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
       <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
     <script src="http://code.jquery.com/jquery-latest.js"></script>
<!--     <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.js" type="text/javascript"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js" type="text/javascript"></script> -->
    <!-- Bootstrap -->
 <!--    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
  
 
  <link href="https://cdnjs.cloudflare.com/ajax/libs/nprogress/0.2.0/nprogress.min.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="CSS/custom.min.css" rel="stylesheet">
    
    <script type="text/javascript">
    function LoadJspIntoTheDIV(JSPpage) {
   /*  	alert("dfgdfg"); */
   if ("ChangeTheNominee"==JSPpage)
	   {
	   $('#Main_Content1').load('ChangeTheNominee.jsp');
	   }
   else if ("ThousandPayedAdvocate"==JSPpage)
	   {
	   $('#Main_Content1').load('ThousandPayedAdvocate.jsp');
	   }
   else if ("NomineeChangeWithKAR"==JSPpage)
   {
   $('#Main_Content1').load('NomineeChangeWithKAR.jsp');
   }
 
   else if ("LifeTimeMembership"==JSPpage)
   {
   $('#Main_Content1').load('LifeTimeMembership.jsp');
   }
   
   else if ("FiveHundreadPayedAdvocate"==JSPpage)
   {
   $('#Main_Content1').load('FiveHundreadPayedAdvocate.jsp');
   }
   
   else if ("RetiredChangeWithKAR"==JSPpage)
   {
   $('#Main_Content1').load('RetiredChangeWithKAR.jsp');
   }
   
   else if ("LateAdvocateChangeWithKAR"==JSPpage)
   {
   $('#Main_Content1').load('LateAdvocateChangeWithKAR.jsp');
   }   
   
   
   else if ("ViewKARStatus"==JSPpage)
   {
   $('#Main_Content1').load('ViewKARStatus.jsp');
   }   
   
   
   else if ("ViewKARBillingStatus"==JSPpage)
   {
   $('#Main_Content1').load('ViewKARBillingStatus.jsp');
   }   
   
   
   
   else if ("KARStatusUSingName"==JSPpage)
   {
   $('#Main_Content1').load('KARStatusUSingName.jsp');
   } 
   else if ("ViewKARBillingStatus"==JSPpage)
   {
   $('#Main_Content1').load('ViewAllKARBillingStatus.jsp');
   }
   
   else if ("SeeAdvocateDetails"==JSPpage)
   {
   $('#Main_Content1').load('SeeAdvocateDetails.jsp');
   } 
   //KARPendingFee
   else if ("KARPendingFee"==JSPpage)
   {
   $('#Main_Content1').load('KARPendingFee.jsp');
   }
   
   
   else if ("UpdateWelfareDate"==JSPpage)
   {
   $('#Main_Content1').load('UpdateWelfareDate.jsp');
   }
   
   else if ("SeeAdvocateLastPay"==JSPpage)
   {
   $('#Main_Content1').load('SeeAdvocateLastPay.jsp');
   }
   else if ("KAWFClaims"==JSPpage)
   {
   $('#Main_Content1').load('KAWFClaims.jsp');
   }
     
   else if ("KARLoginCheck"==JSPpage)
   {
   $('#Main_Content1').load('KARLoginCheck.jsp');
   }
   
   
   else if ("WelfareSectionToDoList"==JSPpage)
   {
   $('#Main_Content1').load('WelfareSectionToDoList.jsp');
   }
   
   
   else if ("WelfarePortalMonthlyReport"==JSPpage)
   {
   $('#Main_Content1').load('WelfarePortalMonthlyReport.jsp');
   }
   
   
   else if ("UpdateTheNominee"==JSPpage)
   {
   $('#Main_Content1').load('UpdateTheNominee.jsp');
   }
   
   
   else if ("SeniorAdvMonthlyReport"==JSPpage)
   {
   $('#Main_Content1').load('SeniorAdvMonthlyReport.jsp');
   }
   
   

   else if ("LifeTimeMonthlyReport"==JSPpage)
   {
   $('#Main_Content1').load('LifeTimeMonthlyReport.jsp');
   }
   
   
   else if ("ClaimMonthlyReport"==JSPpage)
   {
   $('#Main_Content1').load('ClaimMonthlyReport.jsp');
   }
   
   
   else if ("SeniorAdv"==JSPpage)
   {
   $('#Main_Content1').load('SeniorAdv.jsp');
   }
    }
    
   
    
   function  CallToServletFromJSP(RegNumber,WhichMethod)
	    {
	   alert(RegNumber); 
	     alert(WhichMethod); 
	   alert('********** challan ***********');
	   var RegNumber=RegNumber; 
	   var WhichFunctionToHandle=WhichMethod;
	          $.get('AjaxServlet',{RegNumber:RegNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) {  
	   $('#Main_Content1').html(responseText); 
	  
	  }); 
	 /*  +"  }); "*/
/*	 +"   return false; "*/
	   } 
	   
	   
	   function  CallToServletFromJSPWithKARNumber(KARNumber,WhichMethod)
	    {
	   alert(KARNumber); 
	     alert(WhichMethod); 
	   alert('********** challan ***********');
	   var KARNumber=KARNumber; 
	   var WhichFunctionToHandle=WhichMethod;
	          $.get('AjaxServlet',{KARNumber:KARNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) {  
	   $('#Main_Content1').html(responseText); 
	  
	  }); 
	  
	  
	 /*  +"  }); "*/
/*	 +"   return false; "*/
	   } 
	   
	   function CallToServletFromJSPForWelfareList1(ReceiptNumber,Particulars)
	   {
		  
		   alert(ReceiptNumber);
		   alert(Particulars);
		 
				
							  alert(Particulars);
							  if (Particulars=='Enrollment Fee')
								  {
								  LoadJspIntoTheDIV('UpdateTheNominee'); 
								  }
							  else  if (Particulars=='Change Of Address')
							  {
							  LoadJspIntoTheDIV('ChangeKARStatus'); 
							  }
							  else  if (Particulars=='KAWF Subscription Fee')
							  {
							  LoadJspIntoTheDIV('UpdateWelfareDate'); 
							  }
							  else  if (Particulars=='Senior Advocate Contribution')
							  {
								  LoadJspIntoTheDIV('UpdateWelfareDate'); 
							  }
							 
							  
							  else
								  {
								  
								  
								  LoadJspIntoTheDIV('UpdateTheNominee'); 
								  }
							 
					
					  
					
			   }
	   
	   function CallToServletFromJSPForWelfareList2(ReceiptNumber,Particulars)
	   {
		  
		   alert(ReceiptNumber);
		   alert(Particulars);
		   var WhichFunctionToHandle="CallToServletFromJSPForWelfareTodoList";
			          $.get('AjaxServlet',{ReceiptNumber:ReceiptNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText)

					  { 
				
							
								  LoadJspIntoTheDIV('WelfareSectionToDoList'); 
							
							 
					  });  
					  
					
			   }
	   
	     
	   function CallToServletFromJSPForWelfareTodoList(ReceiptNumber)
	   {
		   alert(ReceiptNumber); 
		  
		   alert('********** CallToServletFromJSPForWelfareTodoList ***********');
		   var ReceiptNumber=ReceiptNumber; 
		   var WhichFunctionToHandle="CallToServletFromJSPForWelfareTodoList";
		          $.get('AjaxServlet',{ReceiptNumber:ReceiptNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) {  
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
  
 <%--  <% 
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
  
  %>  --%>
  

  
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
<!--               <a href="index.html" class="site_title"><i class="fa fa-paw"></i> <span>KSBC</span></a>
 -->
  <img alt="ksbc" src="ksbc_logo.jpg">            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            <div class="profile clearfix">
			<!--
              <div class="profile_pic">
                <img src="images/img.jpg" alt="..." class="img-circle profile_img">
              </div>
			  -->
              <div class="profile_info">
			  <h4><b>WELFARE</b></h4> </br>
                <span>Welcome,	</span>

              </div>
            </div>
            <!-- /menu profile quick info -->

            <br />

            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>General</h3>
                <ul class="nav side-menu">
                  <!-- <li><a><i class="fa fa-calendar-check-o"></i>Interview<span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="index.html">Schedule Interview</a></li>
						<li><div class="Schedule" onclick="LoadJspIntoTheDIV('ScheduleInterView')"> <b>Schedule Interview</b></div></li>
                      <li><a onclick="LoadJspIntoTheDIV('ViewInterviewCandidate')">View Eligible Candidate</a></li>
                      <li><a onclick="LoadJspIntoTheDIV('AbsentList')">Absent List</a></li>
                       <li><a onclick="LoadJspIntoTheDIV('ViewInterviewConfirmCandidate')">View Interview Confirm List</a></li>
					  <li><a onclick="LoadJspIntoTheDIV('ConfirmInterview')">Confirm Interview</a></li>
                    </ul> -->
                  </li>
                 <!--  <li><a><i class="fa fa-graduation-cap"></i> Certificate <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a onclick="LoadJspIntoTheDIV('GenerateCertificate')">Generate Certificate</a></li>
                      <li><a onclick="LoadJspIntoTheDIV('GenerateDuplicateCertificate')">Generate duplicate Certificate</a></li>
                     
                    </ul>
                    -->
                  </li>
                  <li><a><i class="fa fa-desktop"></i> See Advocate Details <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a onclick="LoadJspIntoTheDIV('SeeAdvocateDetails')">See Advocate Details</a></li>
                       <li><a onclick="LoadJspIntoTheDIV('SeeAdvocateLastPay')">See Advocate Last pay</a></li>
                     <li><a onclick="LoadJspIntoTheDIV('KARStatusUSingName')">KAR Status Using Name</a></li>
                     <li><a onclick="LoadJspIntoTheDIV('KARPendingFee')">Get Pending Fee For KAR</a></li>
                    </ul>
                  </li> 
                  <li><a><i class="fa fa-table"></i>Generate Report<span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                    
                      <li><a onclick="LoadJspIntoTheDIV('WelfarePortalMonthlyReport')">Welfare Monthly Report</a></li>
                        <li><a onclick="LoadJspIntoTheDIV('KARLoginCheck')">KAR Login Check</a></li>
                      <li><a onclick="LoadJspIntoTheDIV('SeniorAdvMonthlyReport')">SeniorAdv Monthly Report</a></li>
                     
                      <li><a onclick="LoadJspIntoTheDIV('ClaimMonthlyReport')">Claim Monthly Report</a></li>
                      <li><a onclick="LoadJspIntoTheDIV('LifeTimeMonthlyReport')">LifeTime Monthly Report</a></li>
                     
                      
                    </ul>
                  </li>
                  <li><a><i class="fa fa-edit"></i> View Nominee <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                    <!--   <li><a onclick="LoadJspIntoTheDIV('ChangeTheNominee')">Change the Nominee</a></li> -->
                       <li><a onclick="LoadJspIntoTheDIV('UpdateTheNominee')">Update the Nominee</a></li>
                   <li><a onclick="LoadJspIntoTheDIV('KAWFClaims')">Add the Claim</a></li>
                    <li><a onclick="LoadJspIntoTheDIV('UpdateWelfareDate')">Update Welfare Date</a></li>
                  
                   <li><a onclick="LoadJspIntoTheDIV('SeniorAdv')">Add Senior Advocate</a></li>
                 
                       
                    </ul>
                  </li>
				  
				  
				<!--   <li><a><i class="fa fa-edit"></i> View KAR Status <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a onclick="LoadJspIntoTheDIV('ViewKARStatus')">View the KAR Status</a></li>
                       <li><a onclick="LoadJspIntoTheDIV('ViewKARBillingStatus')">View the KAR Billing Status</a></li>
                         <li><a onclick="LoadJspIntoTheDIV('ViewAllKARBillingStatus')">View All the KAR Billing Status</a></li>
                    </ul>
                  </li> -->
                  
                  
                  
                   <li><a><i class="fa fa-desktop"></i>  ToDo List <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a onclick="LoadJspIntoTheDIV('WelfareSectionToDoList')">My To Do List</a></li>
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
		
		<div  id="Main_Content1"> Comes Here</div>
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