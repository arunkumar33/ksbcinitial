
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

<!-- form -->
<div class="container" style="width: 100%">

    <form class="well form-horizontal" action="TappalComplaint" method="post"  >
    <!-- id="contact_form" -->
<fieldset>

<!-- Form Name -->
<legend>Tappal Complaint In World <br> All the fields are mandatory</legend>

<!-- Text input-->

<div class="form-group">
  <label class="col-md-4 control-label">
  Name
</label>  
  <div class="col-md-4 inputGroupContainer"> 
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input  name="UserName" placeholder="User Name" class="form-control"  type="text" required>
    </div>
  </div>
</div>

<!-- Text input-->


<div class="form-group">
  <label class="col-md-4 control-label" >Address
</label> 
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input name="Address" placeholder="Address" class="form-control"  type="text">
    </div>
  </div>
</div>



<div class="form-group">
  <label class="col-md-4 control-label" > Particular
</label> 
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input name="Particular" placeholder=" Particular" class="form-control"  type="text">
    </div>
  </div>
</div>

   <div class="form-group">
  <label class="col-md-4 control-label">Remarks</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
  <input name="Remarks" placeholder="Remarks" class="form-control" type="text">
    </div>
  </div>
</div>


<div class="form-group">
  <label class="col-md-4 control-label">Date</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
  <input name="Date" placeholder="Date" class="form-control" type="date">
    </div>
  </div>
</div>
    <!--   <div class="form-group">
  <label class="col-md-4 control-label">If not a Citizen state how the applicant is qualified to be admitted as an advocate</label>
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
        	<textarea class="form-control" name="NotAnClitizen" placeholder="how the applicant is qualified to be admitted as an advocate"></textarea>
  </div>
  </div>
</div> -->



 <!--  <input type="date" value="" name="HI"> -->
 <!-- DatePicker-->


<!-- Have you ever been convicted previously by any court in India or Outside India? If so, give details. -->

<!-- Is there any pending criminal proceedings against you? If so,  give full particulars  -->

  
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