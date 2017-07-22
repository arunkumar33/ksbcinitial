<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.KSBC.JSPRelatedFunctions.JSPRelatedFunctionsimp"%>
<%@page import="com.KSBC.Bean.EnrollmentDetails"%>
	<title>Form Sumbmission</title>
<style type="text/css">
	#HeaderBody
	{
	/*  position:fixed;  */
   left:0px;
   top:0px;
   height:100px;
   width:100%;
   padding-bottom: 2px;
  
	}
/* 	#BodyOfFooter
	{
	 left:0px;
   bottom:0px;
   height:150px;
   width:100%;
   margin-top: -50px;
	}
	 */
	</style>

	<style type="text/css">
#success_message{ display: none;}

.bs-wizard {margin-top: 40px;}

/*Form Wizard*/
.bs-wizard {border-bottom: solid 1px #e0e0e0; padding: 0 0 10px 0;}
.bs-wizard > .bs-wizard-step {padding: 0; position: relative;}
.bs-wizard > .bs-wizard-step + .bs-wizard-step {}
.bs-wizard > .bs-wizard-step .bs-wizard-stepnum {color: #595959; font-size: 16px; margin-bottom: 5px;}
.bs-wizard > .bs-wizard-step .bs-wizard-info {color: #999; font-size: 14px;}
.bs-wizard > .bs-wizard-step > .bs-wizard-dot {position: absolute; width: 30px; height: 30px; display: block; background: #fbe8aa; top: 45px; left: 50%; margin-top: -15px; margin-left: -15px; border-radius: 50%;} 
.bs-wizard > .bs-wizard-step > .bs-wizard-dot:after {content: ' '; width: 14px; height: 14px; background: #fbbd19; border-radius: 50px; position: absolute; top: 8px; left: 8px; } 
.bs-wizard > .bs-wizard-step > .progress {position: relative; border-radius: 0px; height: 8px; box-shadow: none; margin: 20px 0;}
.bs-wizard > .bs-wizard-step > .progress > .progress-bar {width:0px; box-shadow: none; background: #fbe8aa;}
.bs-wizard > .bs-wizard-step.complete > .progress > .progress-bar {width:100%;}
.bs-wizard > .bs-wizard-step.active > .progress > .progress-bar {width:50%;}
.bs-wizard > .bs-wizard-step:first-child.active > .progress > .progress-bar {width:0%;}
.bs-wizard > .bs-wizard-step:last-child.active > .progress > .progress-bar {width: 100%;}
.bs-wizard > .bs-wizard-step.disabled > .bs-wizard-dot {background-color: #f5f5f5;}
.bs-wizard > .bs-wizard-step.disabled > .bs-wizard-dot:after {opacity: 0;}
.bs-wizard > .bs-wizard-step:first-child  > .progress {left: 50%; width: 50%;}
.bs-wizard > .bs-wizard-step:last-child  > .progress {width: 50%;}
.bs-wizard > .bs-wizard-step.disabled a.bs-wizard-dot{ pointer-events: none; }
/*END Form Wizard*/
	</style>
<script type="text/javascript">
	  $(document).ready(function() {
    $('#contact_form').bootstrapValidator({
        // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            first_name: {
                validators: {
                        stringLength: {
                        min: 2,
                    },
                        notEmpty: {
                        message: 'Please supply your first name'
                    }
                }
            },
             last_name: {
                validators: {
                     stringLength: {
                        min: 2,
                    },
                    notEmpty: {
                        message: 'Please supply your last name'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: 'Please supply your email address'
                    },
                    emailAddress: {
                        message: 'Please supply a valid email address'
                    }
                }
            },
            phone: {
                validators: {
                    notEmpty: {
                        message: 'Please supply your phone number'
                    }
                }
            },
            address: {
                validators: {
                     stringLength: {
                        min: 8,
                    },
                    notEmpty: {
                        message: 'Please supply your street address'
                    }
                }
            },
            city: {
                validators: {
                     stringLength: {
                        min: 4,
                    },
                    notEmpty: {
                        message: 'Please supply your city'
                    }
                }
            },
            state: {
                validators: {
                    notEmpty: {
                        message: 'Please select your state'
                    }
                }
            },
            BloodGroup: {
                validators: {
                    notEmpty: {
                        message: 'Please select your BloodGroup'
                    }
                }
            },
            zip: {
                validators: {
                    notEmpty: {
                        message: 'Please supply your zip code'
                    }
                }
            },
            NotAnClitizen1: {
                validators: {
                      stringLength: {
                        min: 10,
                        max: 200,
                        message:'Please enter at least 10 characters and no more than 200'
                    },
                    notEmpty: {
                        message: 'Please supply a description of your project'
                    }
                    }
                }
            }
        })
        .on('success.form.bv', function(e) {
            $('#success_message').slideDown({ opacity: "show" }, "slow") // Do something ...
                $('#contact_form').data('bootstrapValidator').resetForm();

            // Prevent form submission
            e.preventDefault();

            // Get the form instance
            var $form = $(e.target);

            // Get the BootstrapValidator instance
            var bv = $form.data('bootstrapValidator');

            // Use Ajax to submit form data
            $.post($form.attr('action'), $form.serialize(), function(result) {
                console.log(result);
            }, 'json');
        });
});



</script>

</head>
<body>

<!-- Header part comes down -->
<div class="container" style="width: 100%">
<div id="HeaderBody">
<header class="header-fixed">

	<div class="header-limiter">

		<h1><a href="#">    KSBC</a></h1>

	<!-- 	<nav>
			<a href="#"class="selected">Home</a>
			<a href="#" >About</a>
			<a href="#">Contact</a>
			<a href="#">Enquiry</a>
			<a href="#">Help</a>
			
		</nav> -->

	</div>

</header>
</div>
</div>
<!-- You need this element to prevent the content of the page from jumping up -->



	
<!-- Step progress in boostrap  -->
<!-- <div class="container" style="width: 100%">
		
        
            <div class="row bs-wizard" style="border-bottom:0;">
                
                <div class="col-xs-3 bs-wizard-step active">
                  <div class="text-center bs-wizard-stepnum">Step 1</div>
                  <div class="progress"><div class="progress-bar"></div></div>
                  <a href="#" class="bs-wizard-dot"></a>
                  <div class="bs-wizard-info text-center">Personal Information</div>
                </div>
                
                <div class="col-xs-3 bs-wizard-step disabled">complete
                  <div class="text-center bs-wizard-stepnum">Step 2</div>
                  <div class="progress"><div class="progress-bar"></div></div>
                  <a href="#" class="bs-wizard-dot"></a>
                  <div class="bs-wizard-info text-center">Educational Information</div>
                </div>
                
                <div class="col-xs-3 bs-wizard-step disabled">complete
                  <div class="text-center bs-wizard-stepnum">Step 3</div>
                  <div class="progress"><div class="progress-bar"></div></div>
                  <a href="#" class="bs-wizard-dot"></a>
                  <div class="bs-wizard-info text-center">Work and Practice</div>
                </div>
                
                <div class="col-xs-3 bs-wizard-step disabled">active
                  <div class="text-center bs-wizard-stepnum">Step 4</div>
                  <div class="progress"><div class="progress-bar"></div></div>
                  <a href="#" class="bs-wizard-dot"></a>
                  <div class="bs-wizard-info text-center"> Payment Option</div>
                </div>
            </div>
        
        
        
        
        
	</div>
</div>

<% 


%>
 -->
<!-- form -->

<img alt="Photo" id="myImg" name="myImg" src="#" height="120px" width="120px">
<div class="container" style="width: 100%">

    <form class="well form-horizontal" action="OfflineLineEnrollemntUpdate" method="post"  >
    <!-- id="contact_form" -->
<fieldset>

<!-- Form Name -->
<legend>Application for Enrolment as Advocate under Section 24 of the Advocates Act, 1961 <br> All the fields are mandatory</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label">KAR Number
</label>  
  <div class="col-md-4 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input  id="KARNumber" name="KARNumber" placeholder="KAR Name"  onblur=" GetEnrollmentDetailsForCashSection1()" class="form-control"  type="text" required>
    </div>
  </div>
</div>

<!-- Text input-->




<div class="form-group">
  <label class="col-md-4 control-label">Name of the Candidate in Full
 (In Block Letters as per Provisional Certificate)
</label>  
  <div class="col-md-4 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input  name="first_name"  id="first_name" placeholder="First Name" class="form-control"  type="text" required>
    </div>
  </div>
</div>

<!-- Text input-->

<div class="form-group">
  <label class="col-md-4 control-label" >Father Name in Full
(in Block letters)
</label> 
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input name="Father_name"  id="Father_name" placeholder="Father Name" class="form-control"  type="text">
    </div>
  </div>
</div>

<!-- Text input-->
       <div class="form-group">
  <label class="col-md-4 control-label">E-Mail Address </label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
  <input name="email"  id="email" placeholder="E-Mail Address" class="form-control"  type="text">
    </div>
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label">Communication Address </label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
        
        	<textarea class="form-control"  name="address"  id="address" placeholder="Address"></textarea>
 <!-- 
  <input name="address"  id="address" placeholder="Address" class="form-control" type="text">
 -->    </div>
  </div>
</div>


<div class="form-group">
  <label class="col-md-4 control-label">Communication Address And Permenent Address Are same</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
        
         <input type="checkbox" id="add"  name="add" value="" onchange="ChangetheValueofCheckList()">Same Address<br> <!-- 
  <input name="address"  id="address" placeholder="Address" class="form-control" type="text">
 -->    </div>
  </div>
</div>


 
<div class="form-group">
  <label class="col-md-4 control-label" >Permanent Address </label> 
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  
  	<textarea class="form-control"  name="Permenent"  id="Permenent" placeholder="Permenent Address"></textarea>
  
 <!--  <input name="Permenent" id="Permenent" placeholder="Permenent address" class="form-control"  type="text">
  -->   </div>
  </div>
</div>



<!-- Text input-->
       
<div class="form-group">
  <label class="col-md-4 control-label">Phone Number (Should be 10 digit)</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
  <input name="phone" id="phone" placeholder="(845)555-1212" class="form-control" type="number">
    </div>
  </div>
</div>




<!-- Text input-->


<!-- Text input-->
<!--  
<div class="form-group">
  <label class="col-md-4 control-label">City</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
  <input name="city"  id="city" placeholder="city" class="form-control"  type="text">
    </div>
  </div>
</div>
 -->
<!-- Select Basic -->
 
  
  <!-- radio checks  For Clitizen ship-->
<div class="form-group"> 
  <label class="col-md-4 control-label">Select Your Cast category</label>
    <div class="col-md-4 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
    <select name="CastCategory" class="form-control selectpicker" >
      <option>General</option>
      
     <option>SC ST</option>
    </select>
  </div>
</div>
</div>


  
<div class="form-group">
  <label class="col-md-4 control-label" >Cast</label> 
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <div id="Castaragraph"></div>  </div>
  </div>
</div>


<div class="form-group"> 
  <label class="col-md-4 control-label">Select Your Gender category</label>
    <div class="col-md-4 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
    <select name="GenderCategory"  id="GenderCategory" class="form-control selectpicker" >
      <option>M</option>
      
     <option>F</option>
    </select>
  </div>
</div>
</div>

  
<div class="form-group">
  <label class="col-md-4 control-label" >Gender</label> 
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <div id="GenderParagraph"></div>  </div>
  </div>
</div>
  
<div class="form-group"> 
  <label class="col-md-4 control-label">The place where you intend to practice</label>
    <div class="col-md-4 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
     <select name="PlaceOfPractice"  id="PlaceOfPractice" class="form-control selectpicker" >
       <option value=" " >Please select your Place of practice</option>
       
   <option>  AFZALPUR </option>
<option>ALAND</option> 
<option>ALUR</option>
<option>ANEKAL</option>
<option>ANKOLA</option>
<option>ARAKALGUD</option>
<option>ARASIKERE</option>
<option>ATHANI</option>
<option>AURAD</option>
<option>BADAMI</option>
<option>BAGALKOT</option>
<option>BAGEPALLI</option>
<option>BAILAHONGAL</option>
<option>BANAHATTI</option>
<option>BANGALORE</option>
<option>BANGARPET</option>
<option>BANTWAL</option>
<option>BASAVAKALYAN</option>
<option>BASAVANA BAGEWADI</option>
<option>BELGAUM</option>
<option>BELLARY</option>
<option>BELTHANGADY</option>
<option>BELUR</option>
<option>Bengaluru Rural</option>
<option>Bengaluru Urban</option>
<option>BHADRAVATHI</option>
<option>BHALKI</option>
<option>BHATKAL</option>
<option>BIDAR</option>
<option>BIJAPUR</option>
<option>BILAGI</option>
<option>BIRUR</option>
<option>BYADAGI</option>
<option>CB DHARWAD</option>
<option>CB Gulbarga</option>
<option>CHALLAKERE</option>
<option>CHAMARAJANAGAR</option>
<option>CHANNAGIRI</option>
<option>CHANNAPATNA</option>
<option>CHANNARAYAPATNA</option>
<option>CHIKBALLAPUR</option>
<option>Chikkaballapur</option>
<option>CHIKKAMAGALUR</option>
<option>Chikkamagaluru</option>
<option>CHIKKANAYANAKANAHALLI</option>
<option>CHIKODI</option>
<option>CHINCHOLI</option>
<option>CHINTAMANI</option>
<option>CHITRADURGA</option>
<option>CHITTAPUR</option>
<option>DANDELI</option>
<option>Davanagere</option>
<option>DAVANGERE</option>
<option>DEODURGA</option>
<option>DEVANAHALLI</option>
<option>DHARWAD</option>
<option>DODDABALLAPURA</option>
<option>GADAG</option>
<option>GANGAVATHI</option>
<option>GOKAK</option>
<option>GOWRIBIDANUR</option>
<option>GUBBI</option>
<option>GUDIBANDE</option>
<option>GULBARGA</option>
<option>GUNDLUPET</option>
<option>GUNTAKAL</option>
<option>HAGARI BOMMANAHALLI</option>
<option>HALIYAL</option>
<option>HANAGAL</option>
<option>HARAPANAHALLI</option>
<option>HARIHAR</option>
<option>HASSAN</option>
<option>HAVERI</option>
<option>HEGGADADEVANAKOTE</option>
<option>HIREKERUR</option>
<option>HIRIYUR</option>
<option>HOLALKERE</option>
<option>HOLENARSIPURA</option>
<option>HONNALI</option>
<option>HONNAVAR</option>
<option>HOSADURGA</option>
<option>HOSANAGARA</option>
<option>HOSKOTE</option>
<option>HOSPET</option>
<option>HUBLI</option>
<option>HUKKERI</option>
<option>HUMNABAD</option>
<option>HUNGUND</option>
<option>HUNSUR</option>
<option>HUVINAHADAGALI</option>
<option>ILKAL</option>
<option>INDI</option>
<option>JAGALUR</option>
<option>JAMKHANDI</option>
<option>JEWARGI</option>
<option>K  G   F</option>
<option>KADUR</option>
<option>Kalaburagi</option>
<option>KALAGHATGI</option>
<option>KALYANDURG</option>
<option>KANAKAPURA</option>
<option>KARKALA</option>
<option>KARWAR</option>
<option>KASARAGOD</option>
<option>KHANAPUR</option>
<option>KITTUR</option>
<option>Kodagu</option>
<option>KOLAR</option>
<option>KOLLEGAL</option>
<option>KOPPA</option>
<option>KOPPAL</option>
<option>KORATAGERE</option>
<option>KRISHNARAJA NAGARA</option>
<option>KRISHNARAJA PET</option>
<option>KUDLIGI</option>
<option>KUMTA</option>
<option>KUNDAGOL</option>
<option>KUNDAPURA</option>
<option>KUNIGAL</option>
<option>KUSHTAGI</option>
<option>LAXMESHWAR</option>
<option>LINGASUGUR</option>
<option>LUCKNOW</option>
<option>MACHALIPATNAM</option>
<option>MADDUR</option>
<option>MADHUGIRI</option>
<option>MADIKERI</option>
<option>MADURAI</option>
<option>MAGADI</option>
<option>MALAVALLI</option>
<option>MALUR</option>
<option>MANDYA</option>
<option>MANGALORE</option>
<option>MANVI</option>
<option>MOLAKALMURU</option>
<option>MOODBIDARI</option>
<option>MUDDEBIHAL</option>
<option>MUDHOL</option>
<option>MUDIGERE</option>
<option>MULBAGAL</option>
<option>MUNDAGOD</option>
<option>MUNDARGI</option>
<option>MYSORE</option>

<option>NAGAMANGALA</option>
<option>NANJANAGUD</option>
<option>NARASIMHA RAJA PURA</option>
<option>NARGUND</option>
<option>NAVALGUND</option>
<option>NELAMANGALA</option>
<option>NIPPANI</option>
<option>PALGHAT</option>
<option>PANDAVAPURA</option>
<option>PAVAGADA</option>
<option>PERIYAPATNA</option>
<option>PONNAMPET</option>
<option>PUTTUR</option>
<option>RABKAVI</option>
<option>RAIBAG</option>
<option>RAICHUR</option>
<option>Ramanagara</option>
<option>RAMANAGARAM</option>
<option>RAMDURG</option>
<option>RANEBENNUR</option>
<option>RON</option>
<option>SAGAR</option>
<option>SAKALESHPUR</option>
<option>SANDUR</option>
<option>SANKESHWAR</option>
<option>SAUNDATTI</option>
<option>SAVANUR</option>
<option>SEDAM</option>
<option>SHAHABAD</option>
<option>SHAHAPUR</option>
<option>SHIDLAGHATTA</option>
<option>SHIGGAON</option>
<option>SHIKARIPURA</option>
<option>SHIMOGA</option>
<option>SHIRAHATTI</option>
<option>SHIRALKOPPA</option>
<option>Shivamogga</option>
<option>SHORAPUR</option>
<option>SIDDAPURA</option>
<option>SINDAGI</option>
<option>SINDHANOOR</option>
<option>SIRA</option>
<option>SIRSI</option>
<option>SIRUGUPPA</option>
<option>SOMWARPET</option>
<option>SORABA</option>
<option>SRINGERI</option>
<option>SRINIVASAPURA</option>
<option>SRIRANGAPATNA</option>
<option>SULLIA</option>
<option>T.NARASIPURA</option>
<option>TARIKERE</option>
<option>THIRTHAHALLI</option>
<option>TIPTUR</option>
<option>TUMKUR</option>
<option>TURUVEKERE</option>
<option>UDUPI</option>
<option>Vijayapura</option>
<option>VIRAJPET</option>

<option>Yadgir</option>
<option>YADGIRI</option>
<option>YELANDUR</option>
<option>YELBURGA</option>
<option>YELLAPUR</option>
         </select>
  </div>
</div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" >Place of Practice</label> 
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <div id="PlaceOfPracticeParagraph"></div>  </div>
  </div>
</div>


      
  <br/>


    <div class="form-group">
                        <label class="col-md-4 control-label">Are you citizen of India ?</label>
                        <div class="col-md-4">
                            <div class="radio">
                                <label>
                                    <input type="radio" name="CitizenOfIndia"  id="CitizenOfIndiaY" value="Y" /> Yes
                                </label>
                            </div>
                            <div class="radio">
                                <label>
                                    <input type="radio" name="CitizenOfIndia" id="CitizenOfIndiaN" value="N" /> No
                                </label>
                            </div>
                        </div>
                    </div>


<div class="form-group">
  <label class="col-md-4 control-label">If not a Citizen state how the applicant is qualified to be admitted as an advocate</label>
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
        	<textarea class="form-control" name="NotAnClitizen" placeholder="how the applicant is qualified to be admitted as an advocate"></textarea>
  </div>
  </div>
</div>





<div class="form-group">
  <label class="col-md-4 control-label">Name of the University </label>  
  <div class="col-md-4 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input  name="University_Name"  id="University_Name" placeholder="University Name" class="form-control"  type="text">
    </div>
  </div>
</div>


<div class="form-group">
  <label class="col-md-4 control-label">Date Of Birth </label>  
  <div class="col-md-4 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input  name="DOB"  id="DOB" class="form-control"  type="date">
    </div>
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" >Date Of Birth Reference</label> 
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <div id="DateOfBirthParagraph"></div>  </div>
  </div>
</div>




<div class="form-group">
  <label class="col-md-4 control-label" >Enrollment Date</label> 
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <div id="EnrollmentDateParagraph"></div>  </div>
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" >Name of the College</label> 
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input name="College" id="College" placeholder="College Name" class="form-control"  type="text">
    </div>
  </div>
</div>


       <div class="form-group">
  <label class="col-md-4 control-label">Year of Completion </label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
  <input name="year_of_Completion" id="year_of_Completion" placeholder="EYear of Completion" class="form-control"   value="0">
    </div>
  </div>
</div>





 <div class="form-group">
                        <label class="col-md-4 control-label">3 or 5 years Course</label>
                        <div class="col-md-4">
                            <div class="radio">
                                <label>
                                    <input type="radio" name="Year_course" id="Year_course3" value="3" /> 3
                                </label>
                            </div>
                            <div class="radio">
                                <label>
                                    <input type="radio" name="Year_course" id="Year_course5" value="5" /> 5
                                </label>
                            </div>
                        </div>
                    </div>

<div class="form-group">
  <label class="col-md-4 control-label">Whether engaged in any other profession?
</label>
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
        	<textarea class="form-control" id="OtherProfessional" name="OtherProfessional" placeholder="Whether engaged in any other profession? Detail"></textarea>
  </div>
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label"> Have you made any previous application for enrolment as an Advocate?  If so,  give particulars and the result
</label>
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
        	<textarea class="form-control"  id="PreviousApplicationDetails"  name="PreviousApplicationDetails" placeholder=" give particulars and the result"></textarea>
  </div>
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label">Whether you are doing business/Company? If so,
a.	Nature of Business furnish details
b.	Partnership
c.	Proprietorship
</label>
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
        	<textarea class="form-control" id="BusinessDetails" name="BusinessDetails" placeholder="Nature of Business furnish details
b.	Partnership
c.	Proprietorship"></textarea>
  </div>
  </div>
</div>




<div class="form-group">
  <label class="col-md-4 control-label">Whether you have been dismissed / terminated from service ? If so give full details on which ground you have been dismissed / terminated from service.
</label>
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
        	<textarea class="form-control" id="terminatedDetails" name="terminatedDetails" placeholder="Please Give Details"></textarea>
  </div>
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label"> Have you ever been convicted previously by any court in India or Outside India? If so, give details.
</label>
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
        	<textarea class="form-control"  id="convictedDetails" name="convictedDetails" placeholder=" Please Give Details"></textarea>
  </div>
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label">Is there any pending criminal proceedings against you? If so,  give full particulars
</label>
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
        	<textarea class="form-control" id="PendingCriminalCases" name="PendingCriminalCases" placeholder="Please Give Details"></textarea>
  </div>
  </div>
  
  <br><br><br><br>
  
  <div class="form-group">
  <label class="col-md-4 control-label" >Remarks</label> 
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input name="Remarks" id="Remarks" placeholder="College Name" class="form-control"  type="text">
    </div>
  </div>
</div>
  
  
  

  <br><br>    

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label"></label>
  <div class="col-md-4">
    <button type="submit" class="btn btn-warning" >Submit <span class="glyphicon glyphicon-send"></span></button>
  </div>
</div>

</fieldset>
</form>
</div>



</body>

 <script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
             function GetEnrollmentDetailsForCashSection1()
{
	// alert ('From');
	/*  document.getElementById("Place").value */
//	alert(document.getElementById(From).value);
	
	 var WhichFunctionToHandle= "GetEnrollMentDetails";
	
 var KARNumber = document.getElementById("KARNumber").value;
 alert('DDDDDDDDDDDDDDDDDDDDDDD');
	// alert(document.getElementById(To).value);
	
	$.get('AjaxServlet',{KARNumber:KARNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) { 
		  
		var StringArry=responseText.split("div");
		alert(responseText);
		document.getElementById("first_name").value=	StringArry[0];
		
		document.getElementById("Father_name").value=	StringArry[1];
		
		document.getElementById("email").value=	StringArry[2];
		
		document.getElementById("address").value=	StringArry[3];
		
		document.getElementById("phone").value=	StringArry[4];
		
		/* document.getElementById("city").value=	StringArry[5]; */
		document.getElementById("myImg").src=StringArry[7];
		document.getElementById("Remarks").value=StringArry[8];
		document.getElementById("University_Name").value=	StringArry[10];
		document.getElementById("College").value=	StringArry[11];
		document.getElementById("year_of_Completion").value=	StringArry[12];
		
		
		document.getElementById("PreviousApplicationDetails").value=	StringArry[16];
		document.getElementById("PendingCriminalCases").value=	StringArry[20];
		document.getElementById("convictedDetails").value=	StringArry[19];
		
		document.getElementById("BusinessDetails").value=	StringArry[14];
		document.getElementById("OtherProfessional").value=	StringArry[17];
		
		alert(StringArry[18]);
		if(StringArry[18]=='N')
			{
			
			 document.getElementById("CitizenOfIndiaN").checked = true;
			 document.getElementById("CitizenOfIndiaY").checked = false;
			}
		else
			{
			
			
			 
			 document.getElementById("CitizenOfIndiaY").checked = true;
			 document.getElementById("CitizenOfIndiaN").checked = false;
			}
		
		if(StringArry[13]=='3')
		{
		
			 document.getElementById("Year_course3").checked = true;
			 document.getElementById("Year_course5").checked = false;
		}
	else
		{
		 document.getElementById("Year_course5").checked = true;
		 document.getElementById("Year_course3").checked = false;
		
		}
		document.getElementById("Permenent").value=	StringArry[22];
		document.getElementById("PlaceOfPracticeParagraph").innerText =	StringArry[23];
		document.getElementById("DateOfBirthParagraph").innerText =		StringArry[24];
		document.getElementById("EnrollmentDateParagraph").innerText =		StringArry[25];
		document.getElementById("GenderParagraph").innerText =		StringArry[27];
		document.getElementById("Castaragraph").innerText =		StringArry[26];
/* 		alert(StringArry[23]);
		alert(StringArry[24]); */
		 // $("#GenderCategory").val(StringArry[6]);
		                              
			                    });
	
	}
	
	function ChangetheValueofCheckList()
	{
		var tmp='';
		if(document.getElementById("add").checked)
			{
			tmp=document.getElementById("address").value;
			
			document.getElementById("Permenent").value=tmp;
			}
		
	}
        </script>
</html>


