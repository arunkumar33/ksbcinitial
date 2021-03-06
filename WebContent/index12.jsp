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
    	
    	        $.post('KARLogin',{KARNumber:KARNumber},function(responseText) {  
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
    <h1 class="newversion">Karnataka State Bar council</h1>
          
          <a href="#about" class="btn btn-default page-scroll">Know More!!</a> </div>
      </div>
    </div>
  </div>
</div>

<!-- About Section -->
<div id="about">
  <div class="container">
    <div class="section-title text-center center">
      <h2>About KSBC</h2>
      <hr>
    </div>
    <div class="row"> 
      <div class="col-md-6"><img src="img/nyaya.jpg" class="img-responsive" height="300px" width="300px"></div>
      <div class="col-md-6">
        <div class="about-text">
          <h2>History Of Legal Profession</h2>
          
          <p><h3>In 1861, British Parliament has passed the Indian High courts Act to establish High Courts in India by Letter Patent.
            This is empowered and authorized the High Courts to make Rules for enrolment of advocates,  legal practitioners and attorneys in 1865,  the High Courts have formulated the Rules for clarification for admission to the Bar of Advocates, Vakils and Attorney.  Further they have also given power to suspend or remove any of the advocates found guilty of professional misconduct.  Under the said Act,  three High courts were established in three Presidency Towns Calcutta, Bombay and Madras and they have been vested with the power with Letter Patent. 
          Subsequently some more High Courts were established in Allahabad, Patna, Lahore and Nagpur.</h3>
          <p><h3>   Clause IX of Letters Patent of High Court of Bengal, Bombay and Madras is as here under :

          "To approve, admit and enroll so many advocates, vakils and attorneys as to the said High court shall seem meet and such advocates,  vakils and attorneys shall be and are hereby authorized to appear for the suitors of the said High court,  and to plead or to act or to plead and act, for the said suitors,  according as the said High Court may be its rules and directions determine any subject to such rules and directions"...<a href="ReadMore.html">Read More</a></p></h3> </p>
         </div>
      </div>
     <!--  <div class="col-md-4">
        <div class="about-text">
          <h4></h4>
          <p> As per the said Rules the legal profession originated which became the part and parcel of Indian Judicial System.  In 1879,  the law relating to Legal Practitioners has been enumerated in the Legal Practitioners Act.  Thereafter the Bombay Pleaders Act, 1920 and Indian Bar Councils Act, 1926 came into force to regulate the legal profession in India.

    All Indian Bar Committee has been constituted in the year 1953 so as to give its recommendation in order to streamline the legal profession in India.  Simultaneously the Law Commission has also suggested the reform in the administration of justice along with the said All India Bar Committee.  On the said recommendations of the Bill was drafted in the year 1959 which was ultimately passed by the Parliament (both the Houses) and introduced the Advocates Act, 1961 after the receipt of the President accent on 19.5.1961.   The said enactment is a complete one giving autonomy to the Bar so as to create a unified All India Bar.  Under this Act,  the State Bar Councils were constituted for each State and one All India Bar Council,  the apex supervisory body of the Bar.  Thus State Bar Councils and the Bar Council of India originated through the Advocates Act, 1961.         

        The State Bar Council consists of 25 Members duly elected by the Advocates on the roll of the respective State.  Each State Bar Council from amongst its Members would elect one Member to the Bar Council of India.  The term of office of the Members of the State Bar Councils is for a period of 5 years in case of Bar Council of India Member.  The term of office is for the period of for which he holds the office as Member of the State Bar Councils provided that every such member shall continue to hold as Member of the Bar Council of India until is successor is elected.

Functions of the State Bar Council :

         To admit persons as advocates, determine cases of misconduct, conduct seminars, law workshops, welfare of advocates, etc.

Staff of Bar Council :Consists of Secretary and other Staffs in order to administer and functions as enumerated supra. </p>
          
        </div>
      </div> -->
    </div>
  </div>
</div>


<!-- Services Section -->
<div id="services" class="text-center">
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
      <hr>
     <p></p>
    </div>
    <div id="row">
      <div class="col-xs-6 col-md-4 col-sm-6">
        <div class="thumbnail"> <img src="img/team/1.jpg" alt="CHAIRMAN" class="img-thumbnail team-img">
          <div class="caption">
            <h3 id="h" style="color:black;">Mr. JAGADEESH C M</h3>
            <p  style="color:black;">CHAIRMAN</p>
          </div>
        </div>
      </div>
      <div class="col-xs-6 col-md-4 col-sm-6">
        <div class="thumbnail"> <img src="img/team/2.jpg" alt="VICE CHAIRMAN" class="img-thumbnail team-img">
          <div class="caption">
       <h3  style="color:black;">Mr. SUBHASH KOWDICHAR</h3>
            <p  style="color:black;">VICE CHAIRMAN</p>
          </div>
        </div>
      </div>
      <div class="col-xs-6 col-md-4 col-sm-6">
        <div class="thumbnail"> <img src="img/team/3.jpg" alt="MEMBER TO BAR COUNCIL OF INDIA" class="img-thumbnail team-img">
          <div class="caption">
            <h3  style="color:black;">Mr. Y R SADASIVA REDDY </h3>
            <p  style="color:black;">MEMBER TO BAR COUNCIL OF INDIA</p>
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
      <br><br><br>
    
     
    </div>
  </div>
  
   
  <div class="container">
    <div class="section-title center">
      <h2  style="color:black;">Gallery</h2>
      <hr>
     <p></p>
    </div>
    <div id="row">
      <div class="col-xs-6 col-md-4 col-sm-6">
         <a class="btn btn-primary" href="staff.html" role="button">View Our Staff Member</a>
        </div>
      </div>
      <div class="col-xs-6 col-md-4 col-sm-6">
         <a class="btn btn-primary" href="GalleryChecking.html" role="button">View Our Present Committee Member</a>
      </div>
     <!--  <div class="col-xs-6 col-md-4 col-sm-6">
        <a class="btn btn-primary" href="GalleryChecking.html" role="button">View Our Past Committy</a>
      </div> -->
      
      
     <!--  <div class="col-xs-6 col-md-3 col-sm-6">
        <div class="thumbnail"> <img src="img/team/4.jpg" alt="EX MUNCIPAL PRESIDENT" class="img-thumbnail team-img">
          <div class="caption">
          <h3>Mr. BHOJE GOWDA S L</h3>
            <p>EX MUNCIPAL PRESIDENT</p>
          </div>
        </div>
      </div> -->
      <br><br><br>
    
     
    </div>
  </div>
  
</div>


<!-- checking -->

<<!-- div class="container">
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
                <img class="port-image" src="img\Abdul Reyazkhan.jpg"/>
                <div class="cap1">
                    <h3>Mr. ABDUL REYAZ KHAN R</h3>
                    <p>NO. 20/22, 2ND FLOOR, , 
BYTAPPA BLDGS., CUBBONPET MAIN ROAD,BANGALORE. 
BANGALORE , BANGALORE , 
560 002 
</p>
                </div>
                <div class="cap2">
                    <p class="text-center">9448078193 </p>
                </div>
                
            </div>
            
        </div>
        
        <div class="col-md-3 filter graphic photo">
            <div class="each-item">
                <img class="port-image" src="img\Malleshaiah.jpg"/>
                <div class="cap1">
                    <h3>CMr. MALLESHAIAH </h3>
                    <p>NO. 56/B, 19TH MAIN ROAD, , 
B S K 1ST STAGE, 2ND BLOCK,BANGALORE 
BANGALORE , BANGALORE , 
560 05 
</p>
                </div>
                <div class="cap2">
                    <p class="text-center">9448467437 </p>
                </div>
            </div>
        </div>
        
        <div class="col-md-3 filter webdesign">
            <div class="each-item">
                <img class="port-image" src="img\Harish S.jpg"/>
                <div class="cap1">
                    <h3>Mr. HARISH S </h3>
                    <p>SRI CHANNAKESHAVA , DODDAJALA AT & POST , 
BANGALORE NORTH TALUK 
BANGALORE , BANGALORE , 
562 157 
</p>
                </div>
                <div class="cap2">
                    <p class="text-center">9620735464 </p>
                </div>
            </div>
        </div>
        
        <div class="col-md-3 filter graphic photo">
            <div class="each-item">
                <img class="port-image" src="img\PatilJayakumarsubarayagouda.jpg"/>
                <div class="cap1">
                    <h3>Mr. PATIL JAYAKUMAR SUBARAYAGOUDA </h3>
                    <p>NO. 9, MEDINI, NANDI VIEW LAYOUT, , 
DINNUR MAIN ROAD, R T NAGAR.BANGALORE 
BANGALORE , BANGALORE , 
560 032 
</p>
                </div>
                <div class="cap2">
                    <p class="text-center">9448477498 </p>
                </div>
            </div>
        </div>
        
        <div class="col-md-3 filter webdesign graphic">
            <div class="each-item">
                <img class="port-image" src="img\Shivaranu HC.jpg"/>
                <div class="cap1">
                    <h3>Mr. SHIVARAMU H C </h3>
                    <p>NO.70/A, 2ND STAGE , 
5TH BLOCK, NAGARABHAVI 
BANGALORE , BANGALORE , 
560010 
</p>
                </div>
                <div class="cap2">
                    <p class="text-center">9485344863 </p>
                </div>
            </div>
        </div>
        
         <div class="col-md-3 filter webdesign graphic">
            <div class="each-item">
                <img class="port-image" src="img\Ravindranath Rai BB.jpg"/>
                <div class="cap1">
                    <h3>Shri. RAVINDRANATH RAI B B 

</h3>
                    <p>LAXMI NIVAS, 3RD CROSS , 
KODIALBAIL P. O 
MANGALORE , MANGALORE , 
575 003 
                    </p>
                </div>
                <div class="cap2">
                    <p class="text-center">9845577997 </p>
                </div>
            </div>
        </div>
        
         <div class="col-md-3 filter webdesign graphic">
            <div class="each-item">
                <img class="port-image" src="img\Magadum anandkumar appu.jpg"/>
                <div class="cap1">
                    <h3>Shri. MAGADUM ANANDKUMAR APPU 

</h3>
                    <p>ANAND, SHIVAGIRI , 
MANJUNATHA LAYOUT 
DHARWAD , DHARWAD , 
580001 
</p>
                </div>
                <div class="cap2">
                    <p class="text-center">9886379039 </p>
                </div>
            </div>
        </div>
        
         <div class="col-md-3 filter webdesign graphic">
            <div class="each-item">
                <img class="port-image" src="img\Patil Ashok Ramanagouda.jpg"/>
                <div class="cap1">
                    <h3>Mr. PATIL ASHOK RAMANAGOUDA</h3>
                    <p>CTS NO. 7221, SECTOR 10, , 
ANJANEYA NAGAR, MALMARUTI EXTENSION,BELGAUM. 
BELGAUM , BELGAUM , 
590 016 
</p>
                </div>
                <div class="cap2">
                    <p class="text-center">9448355634 </p>
                </div>
            </div>
        </div>
        
         <div class="col-md-3 filter webdesign graphic">
            <div class="each-item">
                <img class="port-image" src="img\Sanddya basava Reddy mandinur.jpg"/>
                <div class="cap1">
                    <h3>Mrs. SANDHYA BASAVA REDDY MADINUR </h3>
                    <p>BANDHVYA, NO. 11, K. H. B. COLONY, , 
HOSPET ROAD,KOPPAL, 
KOPPAL , KOPPAL , 
583 231 
</p>
                </div>
                <div class="cap2">
                    <p class="text-center">9845333324 </p>
                </div>
            </div>
        </div>
        
         
         <div class="col-md-3 filter webdesign graphic">
            <div class="each-item">
                <img class="port-image" src="img\Muniyappa.jpg"/>
                <div class="cap1">
                    <h3>Mr. MUNIYAPPA </h3>
                    <p>NO.71, C.M. PLAZA , 
I MAIN, 8TH CROSS, BEHIND RAMANAHSREE HOTEL 
BANGALORE , BANGALORE , 
560 008 
</p>
                </div>
                <div class="cap2">
                    <p class="text-center">9844185200 </p>
                </div>
            </div>
        </div>
        
         <div class="col-md-3 filter webdesign graphic">
            <div class="each-item">
                <img class="port-image" src="img\PAdma prasad hegde.jpg"/>
                <div class="cap1">
                    <h3>Mr. PADMAPRASAD HEGDE @ P P HEGDE 

</h3>
                    <p>THAKSHILA BUILDING, , 
BALLAL BAGH,MANGALORE. 
MANGALORE , MANGALORE , 
575 003 
</p>
                </div>
                <div class="cap2">
                    <p class="text-center">9448503809 </p>
                </div>
            </div>
        </div>
        
         <div class="col-md-3 filter webdesign graphic">
            <div class="each-item">
                <img class="port-image" src="img\Anilkunar JM.jpg"/>
                <div class="cap1">
                    <h3>Shri. ANIL KUMAR J M</h3>
                    <p>NO. 206 2ND FLOOR, ESTEEM PLAZA, UPPER PALACE ORCHARDS , 
SADASHIVANAGAR 
BANGALORE , BANGALORE , 
560080 
</p>
                </div>
                <div class="cap2">
                    <p class="text-center">9448065247 </p>
                </div>
            </div>
        </div>
        
         <div class="col-md-3 filter webdesign graphic">
            <div class="each-item">
                <img class="port-image" src="img\Naik Krishnappa Bhimappa.jpg"/>
                <div class="cap1">
                    <h3>Mr. NAIK KRISHNAPPA BHIMAPPA</h3>
                    <p>PLOT NO. - 16, SECTOR NO. - 2, , 
SHIVABASAVA NAGARBELGAUM 
BELGAUM , BELGAUM , 
590010 
</p>
                </div>
                <div class="cap2">
                    <p class="text-center">9448029740 </p>
                </div>
            </div>
        </div>
        
         <div class="col-md-3 filter webdesign graphic">
            <div class="each-item">
                <img class="port-image" src="img\Konnavar shivalingappa puttap.jpg"/>
                <div class="cap1">
                    <h3>Mr. KONANAVAR SHIVALINGAPPA PUTTAP</h3>
                    <p>PRUTHVI REKHA , 
RAJA RAJESHWARI NAGAR 
RANEBENNUR , HAVERI DISTRICT , 
581115 
</p>
                </div>
                <div class="cap2">
                    <p class="text-center">9448112714 </p>
                </div>
            </div>
        </div>
        
         <div class="col-md-3 filter webdesign graphic">
            <div class="each-item">
                <img class="port-image" src="img\Gopala swamy CR.jpg"/>
                <div class="cap1">
                    <h3>Mr. GOPALA SWAMY C R </h3>
                    <p>NO 1431, THEERTHA ROOPA , 
I STAGEM II PHASE, 2ND CROSS, CHANDRALAYOUT 
BANGALORE , BANGALORE , 
560 040 
</p>
                </div>
                <div class="cap2">
                    <p class="text-center">9845117411 </p>
                </div>
            </div>
        </div>
        
         <div class="col-md-3 filter webdesign graphic">
            <div class="each-item">
                <img class="port-image" src="img\Appaji gowda.jpg"/>
                <div class="cap1">
                    <h3>Mr. APPAJI GOWDA C. </h3>
                    <p>D. NO. 1034, , 
PANCHAMANTHRA ROAD, KUVEMPUNAGAR, 
MYSORE , MYSORE 
</p>
                </div>
                <div class="cap2">
                    <p class="text-center">9845244498 </p>
                </div>
            </div>
        </div>
         -->
      

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
    
    <!-- <script type="text/javascript">
    function CalltheServlet() {
    	
    	
    	alert('********** KARLogin ***********');
    	 KARNumber=$('#KARNumber').val();
    	alert(KARNumber);
    	
    	        $.post('KARLogin',{KARNumber:KARNumber},function(responseText) {  
    	 $('#Main_Content1').html(responseText); 

    	}); 
		return false;
	}
    
    </script> -->
</head>
<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">
<div id="preloader">
  <div id="status"> <img src="img/preloader.gif" height="64" width="64" alt=""> </div>
</div>
<!-- Navigation -->
<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse"> <i class="fa fa-bars"></i> </button>
      <a class="navbar-brand page-scroll" href="#page-top"> <i class="fa fa-paper-plane-o"></i> KSBC</a> </div>
    
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
      <ul class="nav navbar-nav">
        <!-- Hidden li included to remove active class from about link when scrolled up past about section -->
        <li class="hidden"> <a href="#page-top"></a> </li>
        <li> <a class="page-scroll" href="#about">About</a> </li>
        <li> <a class="page-scroll" href="#services">New Enroll</a> </li>
        <!-- <li> <a class="page-scroll" href="#works">New Enroll</a> </li> -->
        <li> <a class="page-scroll" href="#team">Team</a> </li>
        <li> <a class="page-scroll" href="#testimonials">KAR Login</a> </li>
        <li> <a class="page-scroll" href="#contact">Contact</a> </li>
      </ul>
    </div>
    <!-- /.navbar-collapse --> 
  </div>
  <!-- /.container --> 
</nav>

<!-- Header -->
<div id="intro">
  <div class="intro-body">
    <div class="container">
      <div class="row">
        <div class="col-md-10 col-md-offset-1">
          <h1><span class="brand-heading">KSBC</span></h1>
          <p class="intro-text">Karnataka State Board council</p>
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
      <div class="col-md-4"><img src="img/about.jpg" class="img-responsive"></div>
      <div class="col-md-4">
        <div class="about-text">
          <h4>Who We Are</h4>
          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis sed dapibus leo nec ornare diam. Sed commodo nibh ante facilisis bibendum dolor feugiat at. Duis sed dapibus leo nec ornare diam commodo nibh.</p>
          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis sed dapibus leo nec ornare diam. Sed commodo nibh ante facilisis bibendum. </p>
        </div>
      </div>
      <div class="col-md-4">
        <div class="about-text">
          <h4>What We Do</h4>
          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis sed dapibus leo nec ornare diam. Sed commodo nibh ante facilisis bibendum dolor feugiat at. Duis sed dapibus leo nec ornare diam.</p>
          <ul>
            <li>Lorem ipsum dolor sit amet</li>
            <li>Consectetur adipiscing commodo</li>
            <li>Duis sed dapibus leo sed dapibus</li>
            <li>Sed commodo nibh ante bibendum</li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- Services Section -->
<div id="services" class="text-center">
<div class="row">
    <div class="col-md-2 col-md-offset-5">
	<div id="BodyOFLogin">
	<div id="login">
      <form name='form-login' action="KARLog">
	  <p > <b>Username </b></p>
          <input type="text" id="user" placeholder="Username">
       
     <!--   <span class="glyphicon glyphicon-eye-open"></span> -->
	 <p > <b>Password</b> </p>
          <input type="password" id"pass" placeholder="Password">
        
        <input type="submit" value="Login">
        <br></br>
<a href="RegistrationForm.jsp"><b>Dont Have an Account Sign UP..!!</b></a>
</form>
  </div>
  </div>
	</div>
</div>
  <!--  <div class="container">
    <div class="section-title center">
      <h2>Our Services</h2>
      <hr>
    </div>
    <div class="space"></div>
    <div class="row">
      <div class="col-md-3 col-sm-6">
        <div class="service"> <i class="fa fa-desktop"></i>
          <h3>Web Design</h3>
          <p>Lorem ipsum dolor sit amet placerat facilisis felis mi in tempus eleifend pellentesque natoque etiam.</p>
        </div>
      </div>
      <div class="col-md-3 col-sm-6">
        <div class="service"> <i class="fa fa-cogs"></i>
          <h3>Web Development</h3>
          <p>Lorem ipsum dolor sit amet placerat facilisis felis mi in tempus eleifend pellentesque.</p>
        </div>
      </div>
      <div class="col-md-3 col-sm-6">
        <div class="service"> <i class="fa fa-tablet"></i>
          <h3>App Design</h3>
          <p>Lorem ipsum dolor sit amet placerat facilisis felis mi in tempus eleifend pellentesque natoque etiam.</p>
        </div>
      </div>
      <div class="col-md-3 col-sm-6">
        <div class="service"><i class="fa fa-html5"></i>
          <h3>PSD to HTML5</h3>
          <p>Lorem ipsum dolor sit amet placerat facilisis felis mi in tempus eleifend pellentesque natoque.</p>
        </div>
      </div>
    </div>
    <div class="space"></div>
    <div class="row">
      <div class="col-md-3 col-sm-6">
        <div class="service"><i class="fa fa-wordpress"></i>
          <h3>WordPress</h3>
          <p>Lorem ipsum dolor sit amet placerat facilisis felis mi in tempus eleifend pellentesque natoque etiam.</p>
        </div>
      </div>
      <div class="col-md-3 col-sm-6">
        <div class="service"><i class="fa fa-bullhorn"></i>
          <h3>Marketing</h3>
          <p>Lorem ipsum dolor sit amet placerat facilisis felis mi in tempus eleifend pellentesque.</p>
        </div>
      </div>
      <div class="col-md-3 col-sm-6">
        <div class="service"><i class="fa fa-rocket"></i>
          <h3>Branding</h3>
          <p>Lorem ipsum dolor sit amet placerat facilisis felis mi in tempus eleifend pellentesque natoque etiam.</p>
        </div>
      </div>
      <div class="col-md-3 col-sm-6">
        <div class="service"><i class="fa fa-leaf"></i>
          <h3>Print Design</h3>
          <p>Lorem ipsum dolor sit amet placerat facilisis felis mi in tempus eleifend pellentesque natoque.</p>
        </div>
      </div>
    </div>
  </div> -->

</div>
<!-- Portfolio Section  -->
<!-- 
<div id="works">

  <div class="container"> --> <!-- Container -->
  <!--
    <div class="section-title text-center center">
      <h2>Our Portfolio</h2>
      <hr>
      <div class="clearfix"></div>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis sed dapibus leo nec ornare diamcommodo nibh ante facilisis.</p>
    </div>
    <div class="categories">
      <ul class="cat">
        <li>
          <ol class="type">
            <li><a href="#" data-filter="*" class="active">All</a></li>
            <li><a href="#" data-filter=".lorem">Web Design</a></li>
            <li><a href="#" data-filter=".consectetur">Web Development</a></li>
            <li><a href="#" data-filter=".dapibus">Branding</a></li>
          </ol>
        </li>
      </ul>
      <div class="clearfix"></div>
    </div>
    <div class="row">
      <div class="portfolio-items">
        <div class="col-xs-6 col-sm-6 col-md-3 col-lg-3 lorem">
          <div class="portfolio-item">
            <div class="hover-bg"> <a href="img/portfolio/01.jpg" title="Project description" rel="prettyPhoto">
              <div class="hover-text">
                <h4>Project Title</h4>
                <p>Web Design</p>
              </div>
              <img src="img/portfolio/01.jpg" class="img-responsive" alt="Project Title"> </a> </div>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6 col-md-3 col-lg-3 consectetur">
          <div class="portfolio-item">
            <div class="hover-bg"> <a href="img/portfolio/02.jpg" title="Project description" rel="prettyPhoto">
              <div class="hover-text">
                <h4>Project Title</h4>
                <p>Web Development</p>
              </div>
              <img src="img/portfolio/02.jpg" class="img-responsive" alt="Project Title"> </a> </div>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6 col-md-3 col-lg-3 lorem">
          <div class="portfolio-item">
            <div class="hover-bg"> <a href="img/portfolio/03.jpg" title="Project description" rel="prettyPhoto">
              <div class="hover-text">
                <h4>Project Title</h4>
                <p>Web Design</p>
              </div>
              <img src="img/portfolio/03.jpg" class="img-responsive" alt="Project Title"> </a> </div>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6 col-md-3 col-lg-3 lorem">
          <div class="portfolio-item">
            <div class="hover-bg"> <a href="img/portfolio/04.jpg" title="Project description" rel="prettyPhoto">
              <div class="hover-text">
                <h4>Project Title</h4>
                <p>Web Design</p>
              </div>
              <img src="img/portfolio/04.jpg" class="img-responsive" alt="Project Title"> </a> </div>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6 col-md-3 col-lg-3 consectetur">
          <div class="portfolio-item">
            <div class="hover-bg"> <a href="img/portfolio/05.jpg" title="Project description" rel="prettyPhoto">
              <div class="hover-text">
                <h4>Project Title</h4>
                <p>Web Development</p>
              </div>
              <img src="img/portfolio/05.jpg" class="img-responsive" alt="Project Title"> </a> </div>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6 col-md-3 col-lg-3 dapibus">
          <div class="portfolio-item">
            <div class="hover-bg"> <a href="img/portfolio/06.jpg" title="Project description" rel="prettyPhoto">
              <div class="hover-text">
                <h4>Project Title</h4>
                <p>Branding</p>
              </div>
              <img src="img/portfolio/06.jpg" class="img-responsive" alt="Project Title"> </a> </div>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6 col-md-3 col-lg-3 dapibus consectetur">
          <div class="portfolio-item">
            <div class="hover-bg"> <a href="img/portfolio/07.jpg" title="Project description" rel="prettyPhoto">
              <div class="hover-text">
                <h4>Project Title</h4>
                <p>Web Development, Branding</p>
              </div>
              <img src="img/portfolio/07.jpg" class="img-responsive" alt="Project Title"> </a> </div>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6 col-md-3 col-lg-3 lorem">
          <div class="portfolio-item">
            <div class="hover-bg"> <a href="img/portfolio/08.jpg" title="Project description" rel="prettyPhoto">
              <div class="hover-text">
                <h4>Project Title</h4>
                <p>Web Design</p>
              </div>
              <img src="img/portfolio/08.jpg" class="img-responsive" alt="Project Title"> </a> </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
-->
<!-- Team Section -->
<div id="team" class="text-center">
  <div class="container">
    <div class="section-title center">
      <h2>Meet the team</h2>
      <hr>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis sed dapibus leo nec ornare diamcommodo nibh ante facilisis.</p>
    </div>
    <div id="row">
      <div class="col-xs-6 col-md-3 col-sm-6">
        <div class="thumbnail"> <img src="img/team/1.jpg" alt="CHAIRMAN" class="img-thumbnail team-img">
          <div class="caption">
            <h3>Mr. JAGADEESH C M</h3>
            <p>CHAIRMAN</p>
          </div>
        </div>
      </div>
      <div class="col-xs-6 col-md-3 col-sm-6">
        <div class="thumbnail"> <img src="img/team/2.jpg" alt="VICE CHAIRMAN" class="img-thumbnail team-img">
          <div class="caption">
            <h3>Mr. SUBHASH KOWDICHAR</h3>
            <p>VICE CHAIRMAN</p>
          </div>
        </div>
      </div>
      <div class="col-xs-6 col-md-3 col-sm-6">
        <div class="thumbnail"> <img src="img/team/3.jpg" alt="MEMBER TO BAR COUNCIL OF INDIA" class="img-thumbnail team-img">
          <div class="caption">
            <h3>Mr. SADASIVA REDDY Y</h3>
            <p>MEMBER TO BAR COUNCIL OF INDIA</p>
          </div>
        </div>
      </div>
      <div class="col-xs-6 col-md-3 col-sm-6">
        <div class="thumbnail"> <img src="img/team/4.jpg" alt="EX MUNCIPAL PRESIDENT" class="img-thumbnail team-img">
          <div class="caption">
            <h3>Mr. BHOJE GOWDA S L</h3>
            <p>EX MUNCIPAL PRESIDENT</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- Testimonials Section -->
<div id="testimonials" class="text-center">
<div class="row">
    <div class="col-md-2 col-md-offset-5">
	<div id="BodyOFLogin">
	<div id="login1">
      <form name='form_KAR' method="post"  >
	  <p > <b>KAR ID </b></p>
       <!-- <span class="glyphicon glyphicon-user"></span> -->
          <input type="text" id="KARNumber" name="KARNumber" placeholder="KARNumber">
       
 
	 
     
        <input type="submit" value="Login">

</form>
  </div>
  </div>
	</div>
</div>
 <!--  <div class="container">
    <div class="section-title center">
      <h2>What our clients say</h2>
      <hr>
    </div>
    <div class="row">
      <div class="col-md-10 col-md-offset-1">
        <div class="row testimonials">
          <div class="col-sm-4">
            <blockquote><i class="fa fa-quote-left"></i>
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elitduis sed dapibus leo nec ornare.</p>
              <div class="clients-name">
                <p><strong>John Doe</strong><br>
                  <em>CEO, Company Inc.</em></p>
              </div>
            </blockquote>
          </div>
          <div class="col-sm-4">
            <blockquote><i class="fa fa-quote-left"></i>
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elitduis sed dapibus leo nec ornare.</p>
              <div class="clients-name">
                <p><strong>Jane Doe</strong><br>
                  <em>CEO, Company Inc.</em></p>
              </div>
            </blockquote>
          </div>
          <div class="col-sm-4">
            <blockquote><i class="fa fa-quote-left"></i>
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elitduis sed dapibus leo nec ornare.</p>
              <div class="clients-name">
                <p><strong>Chris Smith</strong><br>
                  <em>CEO, Company Inc.</em></p>
              </div>
            </blockquote>
          </div>
        </div>
      </div>
    </div>
  </div>
  -->
</div>

<!-- Contact Section -->
<div id="contact" class="text-center">
  <div class="container">
    <div class="section-title center">
      <h2>Contact us</h2>
      <hr>
      <p>KSBC is also know as karnataka state board council. Its a bar council in Ambedkar veedhi bangalore.</p>
    </div>
    <div class="col-md-8 col-md-offset-2">
      <div class="col-md-4">
        <div class="contact-item"> <i class="fa fa-map-marker fa-2x"></i>
          <p>Old K.G.I.D. Building, High Court of Karnataka,<br>
            Dr.Ambedkar Veedhi, Bengaluru, Karnataka</p>
        </div>
      </div>
      <div class="col-md-4">
        <div class="contact-item"> <i class="fa fa-envelope-o fa-2x"></i>
          <p>ksbc@company.com</p>
        </div>
      </div>
      <div class="col-md-4">
        <div class="contact-item"> <i class="fa fa-phone fa-2x"></i>
          <p> +91 088616 40029<br>
            +91 088616 40029</p>
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
    <p>Copyright &copy; KSBC. Designed by <a href="">Sas Info Solutions</a></p>
  </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 
<script type="text/javascript" src="JS/jquery.1.11.1.js"></script> 
<!-- Include all compiled plugins (below), or include individual files as needed --> 
<script type="text/javascript" src="JS/bootstrap.js"></script> 
<script type="text/javascript" src="JS/SmoothScroll.js"></script> 
<script type="text/javascript" src="JS/jquery.prettyPhoto.js"></script> 
<script type="text/javascript" src="JS/jquery.isotope.js"></script> 
<script type="text/javascript" src="JS/jquery.parallax.js"></script> 
<script type="text/javascript" src="JS/jqBootstrapValidation.js"></script> 
<script type="text/javascript" src="JS/contact_me.js"></script> 

<!-- Javascripts
    ================================================== --> 
<script type="text/javascript" src="JS/main.js"></script>
</body>
</html> --%>