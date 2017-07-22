<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.KSBC.Bean.EnrollmentDetails"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>KAR Login</title>

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
   if ("ViewCurrentStatus"==JSPpage)
	   {
	   $('#Main_Content1').load('ViewCurrentStatus.jsp');
	   }
   else if ("ChangeOfStatus"==JSPpage)
	   {
	   $('#Main_Content1').load('ChangeOfStatus.jsp');
	   }
   else if ("GenerateDuplicateCertificate"==JSPpage)
	   {
	   $('#Main_Content1').load('GenerateDuplicateCertificateByKAR.jsp');
	   }
   
   else if ("PayForWelfare"==JSPpage)
   {
   $('#Main_Content1').load('PayForWelfare.jsp');
   }  
   else if ("NameChangeWithKAR"==JSPpage)
   {
   $('#Main_Content1').load('NameChangeWithKAR.jsp');
   }   
	 
   
   else if ("NomineeChangeWithKAR"==JSPpage)
   {
   $('#Main_Content1').load('NomineeChangeWithKAR.jsp');
   }   
   
   else if ("AddressChangeWithKAR"==JSPpage)
   {
   $('#Main_Content1').load('AddressChangeWithKAR.jsp');
   }  
   
   
   else if ("DetailsOfWelfareFund"==JSPpage)
   {
   $('#Main_Content1').load('DetailsOfWelfareFund.jsp');
   } 
   
   else if ("PayForDuplicateCertificate"==JSPpage)
   {
   $('#Main_Content1').load('PayForDuplicateCertificate.jsp');
   }    
   
   else if ("UploadMyChallan"==JSPpage)
   {
   $('#Main_Content1').load('UploadMyChallan.jsp');
   } 
   
   
   else if ("ClaimReport"==JSPpage)
   {
   $('#Main_Content1').load('ClaimReport.jsp');
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
    </script>
    
   


  </head>

  <body class="nav-md" id="profile_info1">
  
 <%--  <% 
  System.out.println(session.getAttribute("UserName"));
 
  if ((session.getAttribute("UserName")==null) || (session.getAttribute("UserName")==""))
  {
	  System.out.println("******** UserName and password is not correct  ***********");
	  %>
	   <jsp:forward page="index1.jsp"> 
	<jsp:param name="name" value="ksbc" /> 
	<jsp:param name="site" value="www.ksbc.co.in" /> 
</jsp:forward> 
  <%
  }
  
  %> --%>
  
<%
/* session.setAttribute("KARNumber", "KAR/12/1997"); */
String KARNumber=(String) session.getAttribute("KARNumber");
session.setAttribute("KARNumber", KARNumber);

String status=(String) session.getAttribute("status");

System.out.print(status);
String WelfatreDes=(String) session.getAttribute("WelfatreDes");
session.setAttribute("WelfatreDes", WelfatreDes);
/* session.setAttribute("ImageURL","data:image/png;base64,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");
 */String ImageURL=(String) session.getAttribute("ImageURL");



request.setAttribute("KARNumber", KARNumber); %>
  
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="index.html" class="site_title"><i class="fa fa-paw"></i> <span>KSBC</span></a>
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
              
              
			  <h4><b>KAR User</b></h4> </br>
                <span>Welcome,	</span>
                <img src=<%=session.getAttribute("ImageURL")%> alt="Phto" height="120px" width="100px">
                <h3><%=session.getAttribute("KARNumber") %> , <%= session.getAttribute("Name") %></h3>
              <h3><%=session.getAttribute("status") %> </h3>
            
              </div>
            </div>
            <!-- /menu profile quick info -->
<%


EnrollmentDetails validatedBean=(EnrollmentDetails)request.getAttribute("validatedBean");
request.setAttribute("validatedBean", (EnrollmentDetails)session.getAttribute("validatedBean"));

session.setAttribute("validatedBean", (EnrollmentDetails)session.getAttribute("validatedBean"));

%>
            <br />

            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>General</h3>
                <ul class="nav side-menu">
                  <li><a><i class="fa fa-calendar-check-o"></i>See The Status<span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <!-- <li><a href="index.html">Schedule Interview</a></li> -->
						
                      <li><a onclick="LoadJspIntoTheDIV('ViewCurrentStatus')">View Current KAR Status</a></li>
                    <li><a onclick="LoadJspIntoTheDIV('DetailsOfWelfareFund')">Welfare Fund Payment Details</a></li>
              <li><a onclick="LoadJspIntoTheDIV('ClaimReport')">View My Claim Report</a></li>      
                    </ul>
                  </li>
                <!--   <li><a><i class="fa fa-graduation-cap"></i> WelFare Fund<span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a onclick="LoadJspIntoTheDIV('PayForWelfare')">Pay For Welfare Fund</a></li>
                    
                     
                    </ul>
                  </li>
                  <li><a><i class="fa fa-desktop"></i>Detail Changes<span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a onclick="LoadJspIntoTheDIV('ChangeOfStatus')">Name Change</a></li>
                      <li><a onclick="LoadJspIntoTheDIV('ChangeOfStatus')">Nominee Change</a></li>
                      <li><a onclick="LoadJspIntoTheDIV('ChangeOfStatus')">Address Change</a></li>
                     
                    </ul>
                  </li>
                  <li><a><i class="fa fa-table"></i> Certificate <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a onclick="LoadJspIntoTheDIV('ChangeOfStatus')">Pay for duplicate Certificate</a></li>
                      
                    </ul>
                  </li>
                 
				  <li><a><i class="fa fa-edit"></i> Upload My Challan <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a onclick="LoadJspIntoTheDIV('UploadMyChallan')">Upload My payed Challan</a></li>
                      
                    </ul>
                  </li> -->
                  
                  
                  
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