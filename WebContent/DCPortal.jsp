<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>


  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Cash Section</title>

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
	  $('#Main_Content1').load(JSPpage);
	}
    
   
    
    </script>
    <script type="text/javascript">
  
 function SeeChallan(Reg)  { 
		alert('********** challan ***********');
		 var RegNumber=Reg; 
			 var WhichFunctionToHandle='SeeChallan';
	         $.get('AjaxServlet',{RegNumber:RegNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) {  
	$('#Main_Content1').html(responseText); 
	
	}); 
  }; 



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
};




function  CallToServletForImage(REGNumber,WhichPhoto,WhichMethod)
{
alert(REGNumber); 
 alert(WhichMethod); 
 alert(WhichPhoto);
alert('********** CallToServletForImage ***********');
 var REGNumber=REGNumber; 
var WhichFunctionToHandle=WhichMethod;
var WhichPhoto=WhichPhoto;


        $.get('AjaxServlet',{REGNumber:REGNumber,WhichFunctionToHandle:WhichFunctionToHandle,WhichPhoto:WhichPhoto},function(responseText) {  
 $('#Main_Content1').html(responseText); 

}); 

};



function  CallToServletForKARImage(KARNumber,WhichPhoto,WhichMethod)
{
alert(KARNumber); 
 alert(WhichMethod); 
 alert(WhichPhoto);
alert('********** CallToServletForImage ***********');
 var KARNumber=KARNumber; 
var WhichFunctionToHandle=WhichMethod;
var WhichPhoto=WhichPhoto;


        $.get('AjaxServlet',{KARNumber:KARNumber,WhichFunctionToHandle:WhichFunctionToHandle,WhichPhoto:WhichPhoto},function(responseText) {  
 $('#Main_Content1').html(responseText); 

}); 

};



function  CallToServletFromJSPForKARNumber(KARNumber,WhichMethod,payingFor)
{
alert(KARNumber); 
 alert(WhichMethod); 
alert('********** challan ***********');
 var KARNumber=KARNumber; 
var WhichFunctionToHandle=WhichMethod;
var payingForDetails=payingFor;

alert(payingForDetails);
        $.get('AjaxServlet',{KARNumber:KARNumber,WhichFunctionToHandle:WhichFunctionToHandle,payingForDetails:payingForDetails},function(responseText) {  
 $('#Main_Content1').html(responseText); 

}); 

};



    </script>
   <!-- <script type="text/javascript">
    $('#SeeChallan').click(function(event) { 
	alert('********** SeeChallan Second attempt***********');
	 var RegNumber=$('#RegNumber').val(); "

	var WhichFunctionToHandle='SeeChallan';
		alert(WhichFunctionToHandle);"
       $.get('AjaxServlet',{RegNumber:RegNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) {  "
 $('#Main_Content1').html(responseText);  "+"}); 
  }); 
   </script type="text/javascript"> 

 <script >
	$('#ConfirmChallanPay').click(function(event) { 
		alert('********** challan ***********');
		 var RegNumber=$('#RegNumber').val(); 
			var WhichFunctionToHandle=$('#WhichFunctionToHandle').val();
	        $.get('AjaxServlet',{RegNumber:RegNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) {  
	 $('#Main_Content1').html(responseText);  "+"}); 
	 }); 
	   </script>  -->
  </head>

  <body class="nav-md" id="profile_info1">
  
  <%-- <% 
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
  
  <%
  System.out.println(session.getAttribute("UserName"));
  
  String name=(String)session.getAttribute("UserName");
  session.setAttribute("UserName", name);
  %>
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
<!--               <a href="index.html" class="site_title"><i class="fa fa-paw"></i> <span>KSBC</span></a>
 -->           <img alt="ksbc" src="ksbc_logo.jpg">
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
			  <h4><b>Cash Section</b></h4> </br>
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
                  <li><a><i class="fa fa-file-pdf-o"></i>KSBC Section<span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <!-- <li><a href="index.html">Schedule Interview</a></li> -->
						
						<li><a onclick="LoadJspIntoTheDIV('KSBCMiscReceipts.jsp')"><b>KSBC Misc</b></a></li>
                      <li><a onclick="LoadJspIntoTheDIV('EnrollmentNewMember.jsp')"><b>KSBC Enrollment</b></a></li>
                        <!--  <li><a onclick="LoadJspIntoTheDIV('PDFCreater.jsp')">PDFCreater</a></li>
                      
                      <li><a onclick="LoadJspIntoTheDIV('OtherFee.jsp')">Other Fee</a></li>
					  <li><a onclick="LoadJspIntoTheDIV('EnrollmentFeeWithoutRegNumber.jsp')">Enrollment Fee Without Reg Number</a></li> -->
                    </ul>
                  </li>
                  <li><a><i class="fa fa-credit-card"></i>KAWF<span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a onclick="LoadJspIntoTheDIV('KAWFMisc.jsp')"><b>KAWF Misc</b></a></li>
                    
                 <!--  <li><a onclick="LoadJspIntoTheDIV('VerifyChallanForKARLogin.jsp')">KSWF MemberShip Fee</a></li>
                  -->  <li><a onclick="LoadJspIntoTheDIV('KAWFLateWelfareFund.jsp')"><b>KAWF membership fees</b></a></li>
               
                    </ul>
                  </li>
                
                  
                  
                  <li><a><i class="fa fa-credit-card"></i>BCI - FDS<span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a onclick="LoadJspIntoTheDIV('BCI_FDS.jsp')"><b>BCI - FDS Fee</b></a></li>
                    
                      </ul>
                  </li>
                  
                  
                  <li><a><i class="fa fa-credit-card"></i>Stamp Section<span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a onclick="LoadJspIntoTheDIV('stamp.jsp')"><b>Individual Stamp</b></a></li>
                     <li><a onclick="LoadJspIntoTheDIV('stampAssociation.jsp')"><b>Association Stamp</b></a></li>
                    
                    <li><a onclick="LoadJspIntoTheDIV('StampLoad.jsp')"><b>StampLoad Association Stamp</b></a></li>
                   
                    
                </ul>
                  </li>
                  
                   <li><a><i class="fa fa-credit-card"></i>Cop Section<span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a onclick="LoadJspIntoTheDIV('COP.jsp')"><b>COP</b></a></li>
                   
                </ul>
                  </li>
                   <li><a><i class="fa fa-credit-card"></i>Report Generation<span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a onclick="LoadJspIntoTheDIV('DailyAccountReport.jsp')"><b>Day Report</b></a></li>
                      <li><a onclick="LoadJspIntoTheDIV('DailyReportForUser.jsp')"><b>Day Report Per User</b></a></li>
                      
                      
                      <li><a onclick="LoadJspIntoTheDIV('KSBCMiscMonthlyReport.jsp')"><b>KSBC  Monthly Report</b></a></li>
                       <li><a onclick="LoadJspIntoTheDIV('KSWFMiscMonthlyReport.jsp')"><b>KAWF  Monthly Report</b></a></li>
                      <li><a onclick="LoadJspIntoTheDIV('BCIMonthlyReport.jsp')"><b>BCI Monthly Report</b></a></li>
                     <li><a onclick="LoadJspIntoTheDIV('DailyReportCOP.jsp')"><b>COP Day Report </b></a></li>
                     <li><a onclick="LoadJspIntoTheDIV('DailyReportCOPPerUser.jsp')"><b>COP Day Report Per User </b></a></li>
                    
                      <li><a onclick="LoadJspIntoTheDIV('MonthlyReportCOP.jsp')"><b>COP Monthly Report</b></a></li>
                    
                   <!--    <li><a onclick="LoadJspIntoTheDIV('KSWFMmbershipMonthlyReport.jsp')"><b>KAWF Membership Monthly Report</b></a></li>
                      --> 
                    <!--   <li><a onclick="LoadJspIntoTheDIV('KSBCNewEnrollMonthlyReport.jsp')"><b>KSBC New Enroll Monthly Report</b></a></li>
                   -->  <!-- <li><a onclick="LoadJspIntoTheDIV('IndividualstampingMonthlyReport.jsp')"><b>Individual stamping Monthly Report</b></a></li>
                      <li><a onclick="LoadJspIntoTheDIV('AssociatStampingMonthlyReport.jsp')"><b>Associate stampingMonthly Report</b></a></li>
                      -->
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