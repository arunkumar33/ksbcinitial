
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


 -->
<!-- form -->
<div class="container" style="width: 100%">

    <form class="well form-horizontal" action="OfflineLineEnrollemntInsert" method="post"  >
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
  <input  name="KARNumber" placeholder="KAR Name" class="form-control"  type="text" required>
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
  <input  name="first_name" placeholder="First Name" class="form-control"  type="text" required>
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
  <input name="Father_name" placeholder="Father Name" class="form-control"  type="text">
    </div>
  </div>
</div>

<!-- Text input-->
       <div class="form-group">
  <label class="col-md-4 control-label">E-Mail Address </label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
  <input name="email" placeholder="E-Mail Address" class="form-control"  type="text">
    </div>
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label">Permanent Address </label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
  <input name="address" placeholder="Address" class="form-control" type="text">
    </div>
  </div>
</div>


<!-- Text input-->
       
<div class="form-group">
  <label class="col-md-4 control-label">Phone Number (Should be 10 digit)</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
  <input name="phone" placeholder="(845)555-1212" class="form-control" type="number">
    </div>
  </div>
</div>

<!-- Text input-->


<!-- Text input-->
 
<div class="form-group">
  <label class="col-md-4 control-label">City</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
  <input name="city" placeholder="city" class="form-control"  type="text">
    </div>
  </div>
</div>


<div class="form-group">
  <label class="col-md-4 control-label">Remarks</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
  <input name="Remarks" placeholder="Remarks" class="form-control"  type="text">
    </div>
  </div>
</div>
 
  
<div class="form-group">
  <label class="col-md-4 control-label">Enrollment Date</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
  <input name="EnrollmentDate" id="EnrollmentDate"  class="form-control" type="date">
    </div>
  </div>
</div>

<!-- Select Basic -->
   
<div class="form-group"> 
  <label class="col-md-4 control-label">State</label>
    <div class="col-md-4 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
   <select name="state" class="form-control selectpicker" >
      <option value=" " >Please select your state</option>
         
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
<option>YELLAPUR</option> </select>
  </div>
</div>
</div>

<!-- Text input-->

<div class="form-group">
  <label class="col-md-4 control-label">Zip Code</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
  <input name="ZipCode" placeholder="Zip Code" class="form-control"  type="number">
    </div>
</div>
</div>


<!-- Blood Select Input -->
<!-- Select Basic -->
   
<div class="form-group"> 
  <label class="col-md-4 control-label">Blood Group</label>
    <div class="col-md-4 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-tint"></i></span>
    <select name="BloodGroup" class="form-control selectpicker" >
      <option value=" " >Please select your Blood Group</option>
      <option>O Positive</option>
      <option>O Negative</option>
      <option >A Positive</option>
      <option >A Negative</option>
      <option >B Positive</option>
      <option >B Negative</option>
      <option >AB Positive</option>
      <option >AB Negative</option>
     
    </select>
  </div>
</div>
</div>
<!-- Text input-->
<!-- <div class="form-group">
  <label class="col-md-4 control-label">Blood Group</label>  
   <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-tint"></i></span>
  <input name="BloodGroup" placeholder="Blood Group" class="form-control" type="text">
    </div>
  </div>
</div> -->



<!-- DatePicker-->
<div class="form-group">
  <label class="col-md-4 control-label">Date Of Birth (As per SSLC Marks card)</label>  
   <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
  <input name="birthdate" class="form-control" type="date" >
    </div>
  </div>
</div>
 <!--  <input type="date" value="" name="HI"> -->
  
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
  <label class="col-md-4 control-label">Select Your Gender category</label>
    <div class="col-md-4 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
    <select name="GenderCategory" class="form-control selectpicker" >
      <option>M</option>
      
     <option>F</option>
    </select>
  </div>
</div>
</div>

  
<div class="form-group"> 
  <label class="col-md-4 control-label">The place where you intend to practice</label>
    <div class="col-md-4 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
     <select name="PlaceOfPractice" class="form-control selectpicker" >
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
<option>YELLAPUR</option> </select>
  </div>
</div>
</div>

         
  <br/>



<!-- Success message -->
<!-- <div class="alert alert-success" role="alert" id="success_message">Success <i class="glyphicon glyphicon-thumbs-up"></i> Thanks for contacting us, we will get back to you shortly.</div>
 -->
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
</html>