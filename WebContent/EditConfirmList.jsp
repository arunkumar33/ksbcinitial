
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

    <form class="well form-horizontal" action="OfflineLineFormConfirmationUpdate" method="post"  >
    <!-- id="contact_form" -->
<fieldset>

<!-- Form Name -->
<legend>Application for Enrolment as Advocate under Section 24 of the Advocates Act, 1961 <br> All the fields are mandatory</legend>

<% 
String KARNumber=(String) session.getAttribute("REGnumber");

		String name=(String) session.getAttribute("Name");
		String father=(String) session.getAttribute("father");
		
		System.out.println(father + "father");
		%>
   <img src=<%=session.getAttribute("ImageURL")%> alt="Phto" height="120px" width="100px">
             <br><br><br>
<div class="form-group">
  <label class="col-md-4 control-label">REG Number
</label>  
  <div class="col-md-4 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input  name="REGNumber"  value="<%=KARNumber%>" id="REGNumber" placeholder="REG Number" class="form-control" onblur=" GetEnrollmentDetailsForCashSection1()"  type="text" required>
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
  <input  name="first_name" value="<%=name%>"  id="first_name" placeholder="First Name" class="form-control"  type="text" required>
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
  <input name="Father_name"  value="<%=father%>" id="Father_name" placeholder="Father Name" class="form-control"  type="text">
    </div>
  </div>
</div>

<!-- Text input-->


      <!--  <div class="form-group">
  <label class="col-md-4 control-label">E-Mail Address </label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
  <input name="email"  id="email" placeholder="E-Mail Address" class="form-control"  type="text">
    </div>
  </div>
</div > -->
<!-- 
<div class="form-group">
  <label class="col-md-4 control-label">Permanent Address </label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
  <input name="address"  id="address" placeholder="Address" class="form-control" type="text">
    </div>
  </div>
</div>


Text input
       
<div class="form-group">
  <label class="col-md-4 control-label">Phone Number (Should be 10 digit)</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
  <input name="phone"  id="phone" placeholder="(845)555-1212" class="form-control" type="number">
    </div>
  </div>
</div>

Text input
      
<div class="form-group">
  <label class="col-md-4 control-label">Permanent Address </label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
  <input name="address" placeholder="Address" class="form-control" type="text">
    </div>
  </div>
</div>

Text input
 
<div class="form-group">
  <label class="col-md-4 control-label">City</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
  <input name="city" id="city" placeholder="city" class="form-control"  type="text">
    </div>
  </div>
</div>

Select Basic
   
<div class="form-group"> 
  <label class="col-md-4 control-label">State</label>
    <div class="col-md-4 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
   <select name="state" class="form-control selectpicker" >
      <option value=" " >Please select your state</option>
     <option>Andhra Pradesh</option>
      <option>Arunachal Pradesh</option>
      <option >Assam</option>
      <option >Bihar</option>
      <option >Chhattisgarh</option>
      <option >Goa</option>
      <option >Gujarat</option>
      <option >Haryana</option>
      <option >Himachal Pradesh</option>
      <option> Jammu and Kashmir</option>
      <option >Jharkhand</option>
      <option >Karnataka</option>
      <option >Kerala</option>
      <option >Madhya Pradesh</option>
      <option >Maharashtra</option>
      <option >Manipur</option>
      <option>Meghalaya</option>
      <option >Mizoram</option>
      <option >Nagaland</option>
      <option>Odisha</option>
      <option >Punjab</option>
      <option> Rajasthan</option>
      <option >Sikkim</option>
      <option >Tamil Nadu</option>
      <option>Telangana</option>
      <option>Tripura</option>
      <option>Uttarakhand</option>
      <option>Uttar Pradesh</option>
      <option>West Bengal</option>
     <option>Delhi</option>    </select>
  </div>
</div>
</div>

Text input

<div class="form-group">
  <label class="col-md-4 control-label">Zip Code</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
  <input name="ZipCode"  id="ZipCode" placeholder="Zip Code" class="form-control"  type="number">
    </div>
</div>
</div>


Blood Select Input
Select Basic
   
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
</div> -->
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
 <!-- DatePicker-->
<div class="form-group">
  <label class="col-md-4 control-label">Schedule Interview Date</label>  
   <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
  <input name="ScheduleInterview" class="form-control" type="date" >
    </div>
  </div>
</div> 
  <!-- radio checks  For Clitizen ship-->
<!-- <div class="form-group"> 
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
</div> -->

  
<div class="form-group"> 
  <label class="col-md-4 control-label">The place where you intend to practice</label>
    <div class="col-md-4 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
     <select name="PlaceOfPractice" class="form-control selectpicker" >
      <option value=" " >Please select your Place of practice</option>
     
     <option>Bengaluru Urban</option>
      <option>Bengaluru Rural</option>
      <option >Bagalkot</option>
      <option >Bellary</option>
      <option >Bidar</option>
      <option >Belgaum</option>
      <option >Chamarajanagar</option>
      <option >Chikkamagaluru</option>
      <option >Chikkaballapur</option>
      <option> Chitradurga</option>
      <option >Davanagere</option>
      <option >Kolar</option>
      <option >Ramanagara</option>
      <option >Shivamogga</option>
      <option >Tumkur</option>
      <option >Vijayapura</option>
      <option>Dharwad</option>
      <option >Gadag</option>
      <option >Haveri</option>
      <option>Uttara Kannada</option>
      <option >Kalaburagi</option>
      <option> Koppal</option>
      <option >Raichur</option>
      <option >Yadgir</option>
      <option>Dakshina Kannada</option>
      <option>Hassan</option>
      <option>Kodagu</option>
      <option>Mandya</option>
      <option>Mysuru</option>
     <option>Udupi</option>
     
         </select>
  </div>
</div>
</div>
<!-- 
                    
            <div class="form-group">
                        <label class="col-md-4 control-label">Are you citizen of India ?</label>
                        <div class="col-md-4">
                            <div class="radio">
                                <label>
                                    <input type="radio" name="CitizenOfIndia" value="yes" /> Yes
                                </label>
                            </div>
                            <div class="radio">
                                <label>
                                    <input type="radio" name="CitizenOfIndia" value="no" /> No
                                </label>
                            </div>
                        </div>
                    </div>

IF not a citizen of india 
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
  <label class="col-md-4 control-label">Name, age and address of Nominee or Nominees & relationship (In case nominee is Minor, mention the Date of Birth and Name of the Guardian)</label>
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
        	<textarea class="form-control" name="nomineeDetails" placeholder="Please Give Details"></textarea>
  </div>
  </div>
</div>
Proportion of share to be paid to each
<div class="form-group">
  <label class="col-md-4 control-label"> Proportion of share to be paid to each</label>
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
        	<textarea class="form-control" name="ProportionOfShare" placeholder=" Please Give Details"></textarea>
  </div>
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label">Name of the University </label>  
  <div class="col-md-4 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input  name="University_Name" placeholder="University Name" class="form-control"  type="text">
    </div>
  </div>
</div>

Text input

<div class="form-group">
  <label class="col-md-4 control-label" >Name of the College</label> 
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input name="College" placeholder="College Name" class="form-control"  type="text">
    </div>
  </div>
</div>

Text input
       <div class="form-group">
  <label class="col-md-4 control-label">Year of Completion </label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
  <input name="year_of_Completion" placeholder="EYear of Completion" class="form-control"  type="Number">
    </div>
  </div>
</div>




  radio checks  For Clitizen ship
 <div class="form-group">
                        <label class="col-md-4 control-label">3 or 5 years Course</label>
                        <div class="col-md-4">
                            <div class="radio">
                                <label>
                                    <input type="radio" name="Year_course" value="3" /> 3
                                </label>
                            </div>
                            <div class="radio">
                                <label>
                                    <input type="radio" name="Year_course" value="5" /> 5
                                </label>
                            </div>
                        </div>
                    </div>
Whether engaged in any other profession?

<div class="form-group">
  <label class="col-md-4 control-label">Whether engaged in any other profession?
</label>
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
        	<textarea class="form-control" name="OtherProfessional" placeholder="Whether engaged in any other profession? Detail"></textarea>
  </div>
  </div>
</div>
Have you made any previous application for enrolment as an Advocate?  If so,  give particulars and the result
<div class="form-group">
  <label class="col-md-4 control-label"> Have you made any previous application for enrolment as an Advocate?  If so,  give particulars and the result
</label>
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
        	<textarea class="form-control" name="PreviousApplicationDetails" placeholder=" give particulars and the result"></textarea>
  </div>
  </div>
</div>
IF not a citizen of india 
<div class="form-group">
  <label class="col-md-4 control-label">Whether you are doing business? If so,
a.	Nature of Business furnish details
b.	Partnership
c.	Proprietorship
</label>
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
        	<textarea class="form-control" name="BusinessDetails" placeholder="Nature of Business furnish details
b.	Partnership
c.	Proprietorship"></textarea>
  </div>
  </div>
</div>



Whether you have been dismissed / terminated from service ? If so give full details on which ground you have been dismissed / terminated from service.

<div class="form-group">
  <label class="col-md-4 control-label">Whether you have been dismissed / terminated from service ? If so give full details on which ground you have been dismissed / terminated from service.
</label>
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
        	<textarea class="form-control" name="terminatedDetails" placeholder="Please Give Details"></textarea>
  </div>
  </div>
</div>
Have you ever been convicted previously by any court in India or Outside India? If so, give details.
<div class="form-group">
  <label class="col-md-4 control-label"> Have you ever been convicted previously by any court in India or Outside India? If so, give details.
</label>
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
        	<textarea class="form-control" name="convictedDetails" placeholder=" Please Give Details"></textarea>
  </div>
  </div>
</div>
Is there any pending criminal proceedings against you? If so,  give full particulars 
<div class="form-group">
  <label class="col-md-4 control-label">Is there any pending criminal proceedings against you? If so,  give full particulars
</label>
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
        	<textarea class="form-control" name="PendingCriminalCases" placeholder="Please Give Details"></textarea>
  </div>
  </div>
   -->
  
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

<script>
             function GetEnrollmentDetailsForCashSection1()
{
	// alert ('From');
	/*  document.getElementById("Place").value */
//	alert(document.getElementById(From).value);
	
	 var WhichFunctionToHandle= "GetConfirmationDetails";

 var KARNumber = document.getElementById("REGNumber").value;
	
	
	
	$.get('AjaxServlet',{KARNumber:KARNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) { 
		 
		var StringArry=responseText.split("div");
		
		document.getElementById("first_name").value=	StringArry[0];
		
		 document.getElementById("Father_name").value=	StringArry[1];
		
		document.getElementById("email").value=	StringArry[2];
		
		document.getElementById("address").value=	StringArry[3];
		
		document.getElementById("phone").value=	StringArry[4];
		
		document.getElementById("city").value=	StringArry[5];
		
		document.getElementById("ZipCode").value=	StringArry[6];
		   
		                              
			                    });
	
	}
        </script>
</html>