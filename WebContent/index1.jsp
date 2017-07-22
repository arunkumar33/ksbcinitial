<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>KSBC</title>
<meta name="description" content="">
<meta name="author" content="">

<!-- Bootstrap -->
<link rel="stylesheet" type="text/css"  href="CSS/bootstrap.css">
<link rel="stylesheet" type="text/css" href="fonts/font-awesome/css/font-awesome.css">
<style type="text/css">


#login {
  margin: 50px auto;
  width: 320px;
}

#login form {
  margin: auto;
  padding: 22px 22px 22px 22px;
  width: 100%;
  border-radius: 5px;
  background: #282e33;
  border-top: 3px solid #434a52;
  border-bottom: 3px solid #434a52;
}

#login form span {
  background-color: #363b41;
  border-radius: 3px 0px 0px 3px;
  border-right: 3px solid #434a52;
  color: #606468;
  display: block;
  float: left;
  line-height: 50px;
  text-align: center;
  width: 50px;
  height: 50px;
}

#login form input[type="text"] {
  background-color: #3b4148;
  border-radius: 0px 3px 3px 0px;
  color: #a9a9a9;
  margin-bottom: 1em;
  padding: 0 16px;
  width: 235px;
  height: 50px;
}

#login form input[type="password"] {
  background-color: #3b4148;
  border-radius: 0px 3px 3px 0px;
  color: #a9a9a9;
  margin-bottom: 1em;
  padding: 0 16px;
  width: 235px;
  height: 50px;
}

#login form input[type="submit"] {
  background: #b5cd60;
  border: 0;
  width: 100%;
  height: 40px;
  border-radius: 3px;
  color: white;
  cursor: pointer;
  transition: background 0.3s ease-in-out;
}
#login form input[type="submit"]:hover {
  background: #16aa56;
}




#login1 {
  margin: 50px auto;
  width: 320px;
}

#login1 form {
  margin: auto;
  padding: 22px 22px 22px 22px;
  width: 100%;
  border-radius: 5px;
  background: #282e33;
  border-top: 3px solid #434a52;
  border-bottom: 3px solid #434a52;
}

#login1 form span {
  background-color: #363b41;
  border-radius: 3px 0px 0px 3px;
  border-right: 3px solid #434a52;
  color: #606468;
  display: block;
  float: left;
  line-height: 50px;
  text-align: center;
  width: 50px;
  height: 50px;
}

#login1 form input[type="text"] {
  background-color: #3b4148;
  border-radius: 0px 3px 3px 0px;
  color: #a9a9a9;
  margin-bottom: 1em;
  padding: 0 16px;
  width: 235px;
  height: 50px;
}

#login1 form input[type="password"] {
  background-color: #3b4148;
  border-radius: 0px 3px 3px 0px;
  color: #a9a9a9;
  margin-bottom: 1em;
  padding: 0 16px;
  width: 235px;
  height: 50px;
}

#login1 form input[type="submit"] {
  background: #b5cd60;
  border: 0;
  width: 100%;
  height: 40px;
  border-radius: 3px;
  color: white;
  cursor: pointer;
  transition: background 0.3s ease-in-out;
}
#login1 form input[type="submit"]:hover {
  background: #16aa56;
}



</style>
<!-- Stylesheet
    ================================================== -->
<link rel="stylesheet" type="text/css"  href="CSS/style.css">
<link rel="stylesheet" type="text/css" href="CSS/prettyPhoto.css">
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800,600,300' rel='stylesheet' type='text/css'>
<!-- <script type="text/javascript" src="JS/modernizr.custom.js"></script> -->

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    	<script src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.9.1/bootstrap-table.min.js"></script>
	<script src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.9.1/locale/bootstrap-table-pl-PL.min.js"></script>

	<script src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.9.1/extensions/filter/bootstrap-table-filter.min.js"></script>
	<script src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.9.1/extensions/filter-control/bootstrap-table-filter-control.min.js"></script>

    
    <style type="text/css">
    .port-image
{
    width: 100%;
}

.col-md-3
{
    margin-bottom:20px;
}

.each-item
{
    position:relative;
    overflow:hidden;
}

.each-item:hover .cap2, .each-item:hover .cap1
{
    left:0px;
}

.cap1
{
    position:absolute;
    width:100%;
    height:70%;
    background:rgba(255, 255, 255, 0.5);
    top:0px;
    left:-100%;
    padding:10px;
    
    transition: all .5s;
}

.cap2
{
    position:absolute;
    width:100%;
    height:30%;
    background:rgba(0, 178, 255, 0.5);
    bottom:0px;
    left:100%;
    padding:10px;
    
    transition: all .5s;
}
    
    
    
    </style>
    <script type="text/javascript">
    
   

        $(".filter-button").click(function(){
            var value = $(this).attr('data-filter');
           alert("Hi"); 
            if(value == "all")
            {
                //$('.filter').removeClass('hidden');
                $('.filter').show('1000');
            }
            else
            {
//                $('.filter[filter-item="'+value+'"]').removeClass('hidden');
//                $(".filter").not('.filter[filter-item="'+value+'"]').addClass('hidden');
                $(".filter").not('.'+value).hide('3000');
                $('.filter').filter('.'+value).show('3000');
                
            }
        });

   
    
    
    
    function CalltheServlet() {
    	
    	
    	
    	 KARNumber=$('#KARNumber').val();
    	alert(KARNumber);
    	
    	post('KARLogin',{KARNumber:KARNumber},function(responseText) {  
    	 $('#Main_Content1').html(responseText); 

    	}); 
		return false;
	}
    
    </script> 
</head>
<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

<!-- Navigation -->
 <nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse"> <i class="fa fa-bars"></i> </button>
<!--       <a class="navbar-brand page-scroll" href="#page-top"> <i class="fa fa-paper-plane-o"></i> KSBC</a> </div>
 -->     <img alt="ksbc" src="ksbc_logo.jpg"></div>
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
      <ul class="nav navbar-nav">
       
        <li class="hidden"> <a href="#page-top"></a> </li>
        <li> <a class="page-scroll" href="#about">About</a> </li>
        <li> <a class="page-scroll" href="#services">New Enroll</a> </li>
      
        <li> <a class="page-scroll" href="#team">Team</a> </li>
        <li> <a class="page-scroll" href="#testimonials">KAR Login</a> </li>
        <li> <a class="page-scroll" href="#contact">Contact</a> </li>
      </ul>
    </div>
    
  </div>
  
</nav>






<!-- Header -->
<div id="intro">
  <div class="intro-body">
    <div class="container">
      <div class="row">
        <div class="col-md-10 col-md-offset-1">
          <!-- <h1><span class="brand-heading">KSBC</span></h1> -->
 <!--    <h1 class="newversion">Karnataka State Bar council</h1> -->
          <p style="font-size:75px;color:white;">Karnataka State Bar council</p><br>
          <a href="#about" class="btn btn-default page-scroll">Know More!!</a> </div>
      </div>
    </div>
  </div>
</div>

<!-- About Section -->
<div id="about">
  <div class="container">
    <div class="section-title text-center center">
      <h2>About us</h2>
      <hr>
    </div>
    <div class="row">
      <div class="col-md-6"><img src="img/nyaya.jpg" class="img-responsive"></div>
      <div class="col-md-6">
         <div class="about-text">
          <h2>History Of Legal Profession</h2>
          
          <p><h3>In 1861, British Parliament has passed the Indian High courts Act to establish High Courts in India by Letter Patent.
            This is empowered and authorized the High Courts to make Rules for enrolment of advocates,  legal practitioners and attorneys in 1865,  the High Courts have formulated the Rules for clarification for admission to the Bar of Advocates, Vakils and Attorney.  Further they have also given power to suspend or remove any of the advocates found guilty of professional misconduct.  Under the said Act,  three High courts were established in three Presidency Towns Calcutta, Bombay and Madras and they have been vested with the power with Letter Patent. 
          Subsequently some more High Courts were established in Allahabad, Patna, Lahore and Nagpur.</h3>
          <p><h3>   Clause IX of Letters Patent of High Court of Bengal, Bombay and Madras is as here under :

          "To approve, admit and enroll so many advocates, vakils and attorneys as to the said High court shall seem meet and such advocates,  vakils and attorneys shall be and are hereby authorized to appear for the suitors of the said High court,  and to plead or to act or to plead and act, for the said suitors,  according as the said High Court may be its rules and directions determine any subject to such rules and directions"...<a href="ReadMore.html">Read More</a></p></h3> </p>
         </div>
          <table>
			<tr><h3><i><a href="ReadMoreEnrl.html"  class="btn btn-default page-scroll"> Enrolment</a></i></h3></tr>
			<tr><h3><i><a href="ReadMoreKAWF.html" class="btn btn-default page-scroll"> KAWF</a></i></h3></tr>
			<tr><h3><i><a href="ReadMoreDc.html" class="btn btn-default page-scroll">D C</a></i></h3></tr>
			<tr><h3><i><a href="" class="btn btn-default page-scroll">Stamp</a></i></h3></tr>
			<tr><h3><i><a href="" class="btn btn-default page-scroll">Law Academy</a></i></h3></tr>
	
	</table>
      </div>
      
      </div>
    </div>
  </div>



<!-- Services Section -->
<div id="services" class="text-center">
<div> <a href="" class="btn btn-default page-scroll">NEWS AND EVENTS</a></div><br>
	 <div> <a href="" class="btn btn-default page-scroll">NOTIFICATIONS</a></div><br>
<div class="row">
    <div class="col-md-2 col-md-offset-5">
	<div id="BodyOFLogin">
	<div id="login">
	
	
	<!-- remove the action later because it has to validate first -->
	
      <form name='form-login' action="KARSignin">
	  <p > <b>Username </b></p>
       <!-- <span class="glyphicon glyphicon-user"></span> -->
          <input type="text" id="user" placeholder="Username">
       
     <!--   <span class="glyphicon glyphicon-eye-open"></span> -->
	 <p > <b>Password</b> </p>
          <input type="password" id"pass" placeholder="Password">
        
        <input type="submit" value="Login" onclick="CalltheServlet();">
        <br></br>
<a href="RegistrationForm.jsp"><b>Dont Have an Account Sign UP..!!</b></a>
</form>
  </div>
  </div>
	</div>
</div>
  


<!-- Team Section -->
<div id="team" class="text-center">
  <div class="container">
    <div class="section-title center">
      <h2  style="color:black;">Meet the team</h2>
      
      <h3 style="color:black;" > Special Committee under section 8-A of the advocate act,1961 is being constituted which shall consist of  </h3>
      <hr>
     <p></p>
    </div>
    <div id="row">
      <div class="col-xs-6 col-md-4 col-sm-6">
        <div class="thumbnail"> <img src="img/team/Madhusudan R Naik.png" alt="CHAIRMAN" class="img-thumbnail team-img">
          <div class="caption"> 
            <h3 id="h" style="color:black;">Mr. MADHUSUDAN R NAIK</h3>
            <p  style="color:black;">THE ADVOCATE GENERAL OF GOVT KARNATAKA,CHAIRMAN SPECIAL COMMITTEE</p>
          </div>
        </div>
      </div>
      <div class="col-xs-6 col-md-4 col-sm-6">
        <div class="thumbnail"> <img src="img/team/3.jpg" alt="VICE CHAIRMAN" class="img-thumbnail team-img">
          <div class="caption">
     <h3  style="color:black;">Mr. Y R SADASIVA REDDY </h3>
            <p  style="color:black;">MEMBER, BAR COUNCIL OF INDIA</p>
              </div>
        </div>
      </div>
      <div class="col-xs-6 col-md-4 col-sm-6">
        <div class="thumbnail"> <img src="img/team/PatilJayakumarsubarayagouda.jpg" alt="MEMBER TO BAR COUNCIL OF INDIA" class="img-thumbnail team-img">
          <div class="caption">
            <h3  style="color:black;">Mr. JAYAKUMAR S. PATIL </h3>
            <p  style="color:black;">MEMBER,SPECIAL COMITTEE</p>
          </div>
        </div>
      </div>
    <!--   <div class="col-xs-6 col-md-3 col-sm-6">
        <div class="thumbnail"> <img src="img/team/4.jpg" alt="EX MUNCIPAL PRESIDENT" class="img-thumbnail team-img">
          <div class="caption">
          <h3>Mr. BHOJE GOWDA S L</h3>
            <p>EX MUNCIPAL PRESIDENT</p>
          </div>
        </div>
      </div> -->
    </div>
  </div>
</div>



<!-- gallery -->
 <div class="container">
    <div class="section-title center">
      <h2  style="color:black;">Gallery</h2>
       <table align="center">
     <tr><td>
       <div class="col-xs-6 col-md-4 col-sm-6">
        <a class="btn btn-primary" href="GreatestPersonalities.html" role="button">Great Personalities Of Indian Law</a>
      </div> </td></tr>
     <tr><td> <div class="col-xs-6 col-md-4 col-sm-6">
        <a class="btn btn-primary" href="" role="button">Senior designated Advocates of Karnataka</a>
      </div></td></tr>
      <tr><td><div class="col-xs-6 col-md-4 col-sm-6">
        <a class="btn btn-primary" href="" role="button">Past Chairman and Vise Chairman</a>
      </div>  </td></tr>
       <tr><td><div class="col-xs-6 col-md-4 col-sm-6">
         <a class="btn btn-primary" href="staff.html" role="button">View Our Staff Member</a>
        </div></td></tr>
      
      <tr><td><div class="col-xs-6 col-md-4 col-sm-6">
         <a class="btn btn-primary" href="GalleryChecking.html" role="button">View Our Past Committee Member</a>
      </div></td></tr>
      
     <!--  <div class="col-xs-6 col-md-3 col-sm-6">
        <div class="thumbnail"> <img src="img/team/4.jpg" alt="EX MUNCIPAL PRESIDENT" class="img-thumbnail team-img">
          <div class="caption">
          <h3>Mr. BHOJE GOWDA S L</h3>
            <p>EX MUNCIPAL PRESIDENT</p>
          </div>
        </div>
      </div> -->
      <br><br><br>
    
     
    
 </table>
     
    </div>
    <div id="row">
    
 </div>
 </div>
 
<!-- checking -->


<div id="testimonials" class="text-center">
<div class="row">
    <div class="col-md-2 col-md-offset-5">
	<div id="BodyOFLogin">
	<div id="login1">
      <form name='form_KAR' method="post" action="KARLog" >
	  <p > <b>KAR ID </b></p>

 
          <input type="text" id="KARNumber" name="KARNumber" placeholder="KARNumber">
  <input type="submit" value="Login">
       <!--  <input type="submit" value="Login" onclick="return CalltheServlet();"> -->

</form>
</div>
</div>
</div>
</div>
</div>




<!-- <div class="container">
	<div class="">
		<h2>Filtering divs</h2>
	</div>
    <br><br><br><br><br><br>
    <div>
        <button class="btn btn-primary filter-button" data-filter="all">All</button>
        <button class="btn btn-default filter-button" data-filter="photo">Photo</button>
        <button class="btn btn-default filter-button" data-filter="graphic">Graphic</button>
        <button class="btn btn-default filter-button" data-filter="webdesign">Web design</button>
    </div>
    <br/>
    
    <div class="row">
        <div class="col-md-3 filter photo">
            <div class="each-item">
                <img class="port-image" src="http://www.templates4all.com/wp-content/uploads/2011/09/Engon-Joomla-Corporate-Portfolio-Template.jpg"/>
                <div class="cap1">
                    <h3>Car show</h3>
                    <p>A car showroom for all verities of cars to display</p>
                </div>
                <div class="cap2">
                    <p class="text-center">Visit</p>
                </div>
                
            </div>
            
        </div>
        
        <div class="col-md-3 filter graphic photo">
            <div class="each-item">
                <img class="port-image" src="http://www.wpchats.com/wp-content/uploads/2011/11/Mixfolio-Wordpress-HTML5-Portfolio-Theme.jpg"/>
                <div class="cap1">
                    <h3>Car show</h3>
                    <p>A car showroom for all verities of cars to display</p>
                </div>
                <div class="cap2">
                    <p class="text-center">Visit</p>
                </div>
            </div>
        </div>
        
        <div class="col-md-3 filter webdesign">
            <div class="each-item">
                <img class="port-image" src="http://danielsitek.cz/pic/small/daniel-sitek-portfolio_small.jpg"/>
                <div class="cap1">
                    <h3>Car show</h3>
                    <p>A car showroom for all verities of cars to display</p>
                </div>
                <div class="cap2">
                    <p class="text-center">Visit</p>
                </div>
            </div>
        </div>
        
        <div class="col-md-3 filter graphic photo">
            <div class="each-item">
                <img class="port-image" src="http://101bestwebsites.com/public/images/entry_images//2009/05/14/medium_www.matthiasdittrich.com.jpg"/>
                <div class="cap1">
                    <h3>Car show</h3>
                    <p>A car showroom for all verities of cars to display</p>
                </div>
                <div class="cap2">
                    <p class="text-center">Visit</p>
                </div>
            </div>
        </div>
        
        <div class="col-md-3 filter webdesign graphic">
            <div class="each-item">
                <img class="port-image" src="http://paperhaus.com/images/products/shrapnel-design-handmade-double-thick-screwpost-portfolio-cover-11x14-landscape-black-anodized-aluminum-14231_detail.jpg"/>
                <div class="cap1">
                    <h3>Car show</h3>
                    <p>A car showroom for all verities of cars to display</p>
                </div>
                <div class="cap2">
                    <p class="text-center">Visit</p>
                </div>
            </div>
        </div>
        
        <div class="col-md-3 filter photo">
            <div class="each-item">
                <img class="port-image" src="http://4.bp.blogspot.com/_IDQ_mBDYk9I/SsON_Or-mGI/AAAAAAAAAEs/0AchAjEekYU/s400/Portfolio-idea-3.jpg"/>
                <div class="cap1">
                    <h3>Car show</h3>
                    <p>A car showroom for all verities of cars to display</p>
                </div>
                <div class="cap2">
                    <p class="text-center">Visit</p>
                </div>
            </div>
        </div>
    </div>
</div>
 -->
<!-- <form action="second" method="post">
<input type="text" name="kar number">
<input type="submit" value="Login to kar">

</form> -->

<!-- Contact Section -->

  <div id= class="container">
    <div class="section-title center">
      <h2>Contact us</h2>
      <hr>
      <p>KSBC is also know as karnataka state bar council. Its a bar council in Ambedkar veedhi bangalore.</p>
    </div>
    <div class="col-md-8 col-md-offset-2">
      <div class="col-md-4">
        <div class="contact-item"> <i class="fa fa-map-marker fa-2x"></i>
          <p>Old KGID Building, High Court of Karnataka,<br>
            Dr.Ambedkar Veedhi, Bengaluru, Karnataka</p>
        </div>
      </div>
      <div class="col-md-4">
        <div class="contact-item"> <i class="fa fa-envelope-o fa-2x"></i>
          <p>secretary@ksbc.co.in</p>
        </div>
      </div>
      <div class="col-md-4">
        <div class="contact-item"> <i class="fa fa-phone fa-2x"></i>
          <p> +91 0802286 8712<br>
            +91 0802286 8561</p>
        </div>
      </div>
      <div class="clearfix"></div>
    </div>
    <div class="col-md-8 col-md-offset-2">
     
     
    </div>
  </div>
</div>   
<div id="footer">
  <div class="container">
    <p>Copyright &copy; KSBC. Designed by <a href="">Sas Info Solutions</a> 
     <a href="tc.jsp">&nbsp||Terms and condition*</a> </p>
  </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 
 <script type="text/javascript" src="JS/jquery.1.11.1.js"></script>  
<!-- Include all compiled plugins (below), or include individual files as needed --> 

<script type="text/javascript" src="JS/SmoothScroll.js"></script> 
<script type="text/javascript" src="JS/jquery.prettyPhoto.js"></script> 
<script type="text/javascript" src="JS/jquery.isotope.js"></script> 
<script type="text/javascript" src="JS/jquery.parallax.js"></script> 

<script type="text/javascript" src="JS/contact_me.js"></script> 

<!-- Javascripts
    ================================================== --> 


</body>
</html>


 --%>
 
  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>KSBC</title>
<meta name="description" content="">
<meta name="author" content="">

<!-- Bootstrap -->
<link rel="stylesheet" type="text/css"  href="CSS/bootstrap.css">
<link rel="stylesheet" type="text/css" href="fonts/font-awesome/css/font-awesome.css">
<link rel="stylesheet" type="text/css"  href="CSS/bootstrap.css">
<link rel="stylesheet" type="text/css" href="fonts/font-awesome/css/font-awesome.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.dropbtn {
     background-color: #363b41; 
    color: white;
    padding: 16px;
    font-size: 16px;
    border: none;
    cursor: pointer;
}

.dropdown {
    position: relative;
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
  
    min-width: 160px;
    box-shadow: 0px 8px 16px 5px rgba(0,0,0,);
    z-index: 1;
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
    display: block;
}

.dropdown:hover .dropbtn {
    background-color: #3e8e41;
}
</style>
<style type="text/css">


#login {
  margin: 50px auto;
  width: 320px;
}

#login form {
  margin: auto;
  padding: 22px 22px 22px 22px;
  width: 100%;
  border-radius: 5px;
  background: #282e33;
  border-top: 3px solid #434a52;
  border-bottom: 3px solid #434a52;
}

#login form span {
  background-color: #363b41;
  border-radius: 3px 0px 0px 3px;
  border-right: 3px solid #434a52;
  color: #606468;
  display: block;
  float: left;
  line-height: 50px;
  text-align: center;
  width: 50px;
  height: 50px;
}

#login form input[type="text"] {
  background-color: #3b4148;
  border-radius: 0px 3px 3px 0px;
  color: #a9a9a9;
  margin-bottom: 1em;
  padding: 0 16px;
  width: 235px;
  height: 50px;
}

#login form input[type="password"] {
  background-color: #3b4148;
  border-radius: 0px 3px 3px 0px;
  color: #a9a9a9;
  margin-bottom: 1em;
  padding: 0 16px;
  width: 235px;
  height: 50px;
}

#login form input[type="submit"] {
  background: #b5cd60;
  border: 0;
  width: 100%;
  height: 40px;
  border-radius: 3px;
  color: white;
  cursor: pointer;
  transition: background 0.3s ease-in-out;
}
#login form input[type="submit"]:hover {
  background: #16aa56;
}




#login1 {
  margin: 50px auto;
  width: 320px;
}

#login1 form {
  margin: auto;
  padding: 22px 22px 22px 22px;
  width: 100%;
  border-radius: 5px;
  background: #282e33;
  border-top: 3px solid #434a52;
  border-bottom: 3px solid #434a52;
}

#login1 form span {
  background-color: #363b41;
  border-radius: 3px 0px 0px 3px;
  border-right: 3px solid #434a52;
  color: #606468;
  display: block;
  float: left;
  line-height: 50px;
  text-align: center;
  width: 50px;
  height: 50px;
}

#login1 form input[type="text"] {
  background-color: #3b4148;
  border-radius: 0px 3px 3px 0px;
  color: #a9a9a9;
  margin-bottom: 1em;
  padding: 0 16px;
  width: 235px;
  height: 50px;
}

#login1 form input[type="password"] {
  background-color: #3b4148;
  border-radius: 0px 3px 3px 0px;
  color: #a9a9a9;
  margin-bottom: 1em;
  padding: 0 16px;
  width: 235px;
  height: 50px;
}

#login1 form input[type="submit"] {
  background: #b5cd60;
  border: 0;
  width: 100%;
  height: 40px;
  border-radius: 3px;
  color: white;
  cursor: pointer;
  transition: background 0.3s ease-in-out;
}
#login1 form input[type="submit"]:hover {
  background: #16aa56;
}



</style>
<!-- Stylesheet
    ================================================== -->
<link rel="stylesheet" type="text/css"  href="CSS/style.css">
<link rel="stylesheet" type="text/css" href="CSS/prettyPhoto.css">
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800,600,300' rel='stylesheet' type='text/css'>
<!-- <script type="text/javascript" src="JS/modernizr.custom.js"></script> -->

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    	<script src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.9.1/bootstrap-table.min.js"></script>
	<script src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.9.1/locale/bootstrap-table-pl-PL.min.js"></script>

	<script src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.9.1/extensions/filter/bootstrap-table-filter.min.js"></script>
	<script src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.9.1/extensions/filter-control/bootstrap-table-filter-control.min.js"></script>

    
    <style type="text/css">
    .port-image
{
    width: 100%;
}

.col-md-3
{
    margin-bottom:20px;
}

.each-item
{
    position:relative;
    overflow:hidden;
}

.each-item:hover .cap2, .each-item:hover .cap1
{
    left:0px;
}

.cap1
{
    position:absolute;
    width:100%;
    height:70%;
    background:rgba(255, 255, 255, 0.5);
    top:0px;
    left:-100%;
    padding:10px;
    
    transition: all .5s;
}

.cap2
{
    position:absolute;
    width:100%;
    height:30%;
    background:rgba(0, 178, 255, 0.5);
    bottom:0px;
    left:100%;
    padding:10px;
    
    transition: all .5s;
}
    
    
    
    </style>
    <script type="text/javascript">
    
   

        $(".filter-button").click(function(){
            var value = $(this).attr('data-filter');
           alert("Hi"); 
            if(value == "all")
            {
                //$('.filter').removeClass('hidden');
                $('.filter').show('1000');
            }
            else
            {
//                $('.filter[filter-item="'+value+'"]').removeClass('hidden');
//                $(".filter").not('.filter[filter-item="'+value+'"]').addClass('hidden');
                $(".filter").not('.'+value).hide('3000');
                $('.filter').filter('.'+value).show('3000');
                
            }
        });

   
    
    
    
    function CalltheServlet() {
    	
    	
    	alert('**** KARLogin *****');
    	 KARNumber=$('#KARNumber').val();
    	alert(KARNumber);
    	
    	post('KARLogin',{KARNumber:KARNumber},function(responseText) {  
    	 $('#Main_Content1').html(responseText); 

    	}); 
		return false;
	}
    
    </script> 
</head>
<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

<!-- Navigation -->
 <nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse"> <i class="fa fa-bars"></i> </button>
<!--       <a class="navbar-brand page-scroll" href="#page-top"> <i class="fa fa-paper-plane-o"></i> KSBC</a> </div>
 -->     <img alt="ksbc" src="ksbc_logo.jpg"></div>
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
      <ul class="nav navbar-nav">
       
        <li class="hidden"> <a href="#page-top"></a> </li>
       <!--   <li> <a class="page-scroll" href="#about">About Us</a> </li> -->
       <li> <a class="page-scroll" href="#">Home</a> </li>
       <li>
		<div class="dropdown">
  <button class="dropbtn">About</button>
  <div class="dropdown-content">
    <a href="ReadMoreEnrl.html">Enrolment</a>
    <a href="ReadMoreKAWF.html">KAWF</a>
    <a href="ReadMoreDc.html">D C</a>
    <a href="#">Stamp</a>
     <a href="#">Law Academy</a>
  </div>
</div> 

</li>
        <li> <a class="page-scroll" href="#services">New Enroll</a> </li>
      
        <li> <a class="page-scroll" href="#team">Team</a> </li>
        <li> <a class="page-scroll" href="#testimonials">KAR Login</a> </li>
        <li> <a class="page-scroll" href="#contact">Contact</a> </li>
		<li>
		<div class="dropdown">
  <button class="dropbtn">Notification</button>
  <div class="dropdown-content">
    <a href="#">News and Events</a>
    <a href="#">Notifications</a>
  </div>
</div>

</li>


<li>
		<div class="dropdown">
  <button class="dropbtn">Gallery</button>
  <div class="dropdown-content">
     <a href="GreatestPersonalities.html">Great Personalities Of Indian Law</a>
    <a href="#">Senior designated Advocates of Karnataka</a>
    <a href="#">Past Chairman and Vise Chairman</a>
    <a href="staff.html">View Our Staff Member</a>
     <a href="GalleryChecking.html">View Our Past Committee Member</a>
  </div>
</div>

</li>


      </ul>
    </div>
    
  </div>
  
</nav>






<!-- Header -->
<div id="intro">
  <div class="intro-body">
    <div class="container">
      <div class="row">
        <div class="col-md-10 col-md-offset-1">
          <!-- <h1><span class="brand-heading">KSBC</span></h1> -->
 <!--    <h1 class="newversion">Karnataka State Bar council</h1> -->
          <p style="font-size:75px;color:white;">Karnataka State Bar council</p><br>
          <a href="#about" class="btn btn-default page-scroll">Know More!!</a> </div>
      </div>
    </div>
  </div>
</div>

<!-- About Section -->
<div id="about">
  <div class="container">
    <div class="section-title text-center center">
      <h2>About us</h2>
      <hr>
    </div>
    <div class="row">
      <div class="col-md-6"><img src="img/nyaya.jpg" class="img-responsive"></div>
      <div class="col-md-6">
         <div class="about-text">
          <h2>History Of Legal Profession</h2>
          
          <p><h3>In 1861, British Parliament has passed the Indian High courts Act to establish High Courts in India by Letter Patent.
            This is empowered and authorized the High Courts to make Rules for enrolment of advocates,  legal practitioners and attorneys in 1865,  the High Courts have formulated the Rules for clarification for admission to the Bar of Advocates, Vakils and Attorney.  Further they have also given power to suspend or remove any of the advocates found guilty of professional misconduct.  Under the said Act,  three High courts were established in three Presidency Towns Calcutta, Bombay and Madras and they have been vested with the power with Letter Patent. 
          Subsequently some more High Courts were established in Allahabad, Patna, Lahore and Nagpur.</h3>
          <p><h3>   Clause IX of Letters Patent of High Court of Bengal, Bombay and Madras is as here under :

          "To approve, admit and enroll so many advocates, vakils and attorneys as to the said High court shall seem meet and such advocates,  vakils and attorneys shall be and are hereby authorized to appear for the suitors of the said High court,  and to plead or to act or to plead and act, for the said suitors,  according as the said High Court may be its rules and directions determine any subject to such rules and directions"...<a href="ReadMore.html">Read More</a></p></h3> </p>
         </div>
         <!--  <table>
			<tr><h3><i><a href="ReadMoreEnrl.html"  class="btn btn-default page-scroll"> Enrolment</a></i></h3></tr>
			<tr><h3><i><a href="ReadMoreKAWF.html" class="btn btn-default page-scroll"> KAWF</a></i></h3></tr>
			<tr><h3><i><a href="ReadMoreDc.html" class="btn btn-default page-scroll">D C</a></i></h3></tr>
			<tr><h3><i><a href="" class="btn btn-default page-scroll">Stamp</a></i></h3></tr>
			<tr><h3><i><a href="" class="btn btn-default page-scroll">Law Academy</a></i></h3></tr>
	
	</table> -->
      </div>
      
      </div>
    </div>
  </div>



<!-- Services Section -->
<div id="services" class="text-center">
<!-- <div> <a href="" class="btn btn-default page-scroll">NEWS AND EVENTS</a></div><br>
	 <div> <a href="" class="btn btn-default page-scroll">NOTIFICATIONS</a></div><br> -->
<div class="row">
    <div class="col-md-2 col-md-offset-5">
	<div id="BodyOFLogin">
	<div id="login">
	
	
	<!-- remove the action later because it has to validate first -->
	
      <form name='form-login' action="KARSignin">
	  <p > <b>Username </b></p>
       <!-- <span class="glyphicon glyphicon-user"></span> -->
          <input type="text" id="user" placeholder="Username">
       
     <!--   <span class="glyphicon glyphicon-eye-open"></span> -->
	 <p > <b>Password</b> </p>
          <input type="password" id"pass" placeholder="Password">
        
        <input type="submit" value="Login" onclick="CalltheServlet();">
        <br></br>
<a href="RegistrationForm.jsp"><b>Dont Have an Account Sign UP..!!</b></a>
</form>
  </div>
  </div>
	</div>
</div>
  


<!-- Team Section -->
<div id="team" class="text-center">
  <div class="container">
    <div class="section-title center">
      <h2  style="color:black;">Meet the team</h2>
      
      <h3 style="color:black;" > Special Committee under section 8-A of the advocate act,1961 is being constituted which shall consist of  </h3>
      <hr>
     <p></p>
    </div>
    <div id="row">
      <div class="col-xs-6 col-md-4 col-sm-6">
        <div class="thumbnail"> <img src="img/team/Madhusudan R Naik.png" alt="CHAIRMAN" class="img-thumbnail team-img">
          <div class="caption"> 
            <h3 id="h" style="color:black;">Mr. MADHUSUDAN R NAIK</h3>
            <p  style="color:black;">THE ADVOCATE GENERAL OF GOVT KARNATAKA,CHAIRMAN SPECIAL COMMITTEE</p>
          </div>
        </div>
      </div>
      <div class="col-xs-6 col-md-4 col-sm-6">
        <div class="thumbnail"> <img src="img/team/3.jpg" alt="VICE CHAIRMAN" class="img-thumbnail team-img">
          <div class="caption">
     <h3  style="color:black;">Mr. Y R SADASIVA REDDY </h3>
            <p  style="color:black;">MEMBER, BAR COUNCIL OF INDIA</p>
              </div>
        </div>
      </div>
      <div class="col-xs-6 col-md-4 col-sm-6">
        <div class="thumbnail"> <img src="img/team/PatilJayakumarsubarayagouda.jpg" alt="MEMBER TO BAR COUNCIL OF INDIA" class="img-thumbnail team-img">
          <div class="caption">
            <h3  style="color:black;">Mr. JAYAKUMAR S. PATIL </h3>
            <p  style="color:black;">MEMBER,SPECIAL COMITTEE</p>
          </div>
        </div>
      </div>
    <!--   <div class="col-xs-6 col-md-3 col-sm-6">
        <div class="thumbnail"> <img src="img/team/4.jpg" alt="EX MUNCIPAL PRESIDENT" class="img-thumbnail team-img">
          <div class="caption">
          <h3>Mr. BHOJE GOWDA S L</h3>
            <p>EX MUNCIPAL PRESIDENT</p>
          </div>
        </div>
      </div> -->
    </div>
  </div>
</div>



<!-- gallery -->
 <!-- <div class="container">
    <div class="section-title center">
      <h2  style="color:black;">Gallery</h2>
       <table align="center">
     <tr><td>
       <div class="col-xs-6 col-md-4 col-sm-6">
        <a class="btn btn-primary" href="GreatestPersonalities.html" role="button">Great Personalities Of Indian Law</a>
      </div> </td></tr>
     <tr><td> <div class="col-xs-6 col-md-4 col-sm-6">
        <a class="btn btn-primary" href="" role="button">Senior designated Advocates of Karnataka</a>
      </div></td></tr>
      <tr><td><div class="col-xs-6 col-md-4 col-sm-6">
        <a class="btn btn-primary" href="" role="button">Past Chairman and Vise Chairman</a>
      </div>  </td></tr>
       <tr><td><div class="col-xs-6 col-md-4 col-sm-6">
         <a class="btn btn-primary" href="staff.html" role="button">View Our Staff Member</a>
        </div></td></tr>
      
      <tr><td><div class="col-xs-6 col-md-4 col-sm-6">
         <a class="btn btn-primary" href="GalleryChecking.html" role="button">View Our Past Committee Member</a>
      </div></td></tr>
      
      <div class="col-xs-6 col-md-3 col-sm-6">
        <div class="thumbnail"> <img src="img/team/4.jpg" alt="EX MUNCIPAL PRESIDENT" class="img-thumbnail team-img">
          <div class="caption">
          <h3>Mr. BHOJE GOWDA S L</h3>
            <p>EX MUNCIPAL PRESIDENT</p>
          </div>
        </div>
      </div>
      <br><br><br>
    
     
    
 </table>
     
    </div>
    <div id="row">
    
 </div>
 </div> -->
 
<!-- checking -->


<div id="testimonials" class="text-center">
<div class="row">
    <div class="col-md-2 col-md-offset-5">
	<div id="BodyOFLogin">
	<div id="login1">
      <form name='form_KAR' method="post" action="KARLog" >
	  <p > <b>KAR ID </b></p>

 
          <input type="text" id="KARNumber" name="KARNumber" placeholder="KARNumber">
  <input type="submit" value="Login">
       <!--  <input type="submit" value="Login" onclick="return CalltheServlet();"> -->

</form>
</div>
</div>
</div>
</div>
</div>




<!-- Contact Section -->

  <div id="" class="container">
    <div class="section-title center">
      <h2>Contact us</h2>
      <hr>
      <p>KSBC is also know as karnataka state bar council. Its a bar council in Ambedkar veedhi bangalore.</p>
    </div>
    <div class="col-md-8 col-md-offset-2">
      <div class="col-md-4">
        <div class="contact-item"> <i class="fa fa-map-marker fa-2x"></i>
          <p>Old KGID Building, High Court of Karnataka,<br>
            Dr.Ambedkar Veedhi, Bengaluru, Karnataka</p>
        </div>
      </div>
      <div class="col-md-4">
        <div class="contact-item"> <i class="fa fa-envelope-o fa-2x"></i>
          <p>Kar_barcouncil@yahoo.com</p>
        </div>
      </div>
      <div class="col-md-4">
        <div class="contact-item"> <i class="fa fa-phone fa-2x"></i>
          <p> +91 0802286 8712<br>
            +91 0802286 8561</p>
        </div>
      </div>
      <div class="clearfix"></div>
    </div>
    <div class="col-md-8 col-md-offset-2">
     
     
    </div>
  </div>
</div>   
<div id="footer">

<div style="width: 100%;">
   <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d15551.710006237015!2d77.58134917065694!3d12.976488753641416!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3bae1672247a00cd%3A0x9ecc4b78160a8694!2sAmbedkar+Veedhi%2C+Sampangi+Rama+Nagar%2C+Bengaluru%2C+Karnataka!5e0!3m2!1sen!2sin!4v1488769663668" width="100%" height="500" frameborder="0" style="border:0"></iframe>
</div>

  <div class="container">
    <p>Copyright &copy; KSBC. Designed by <a href="">Sas Info Solutions</a> 
     <a href="tc.jsp">&nbsp||Terms and condition*</a> </p>
  </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 
 <script type="text/javascript" src="JS/jquery.1.11.1.js"></script>  
<!-- Include all compiled plugins (below), or include individual files as needed --> 

<script type="text/javascript" src="JS/SmoothScroll.js"></script> 
<script type="text/javascript" src="JS/jquery.prettyPhoto.js"></script> 
<script type="text/javascript" src="JS/jquery.isotope.js"></script> 
<script type="text/javascript" src="JS/jquery.parallax.js"></script> 

<script type="text/javascript" src="JS/contact_me.js"></script> 

<!-- Javascripts
    ================================================== --> 


</body>
</html>











 
 
 
 
 
 
 
 
 
 
 
 
 
 
 