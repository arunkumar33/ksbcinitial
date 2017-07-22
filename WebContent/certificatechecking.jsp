 <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
       <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
     <script src="http://code.jquery.com/jquery-latest.js"></script>
    
    <h3>Hi.. You can Generate Monthly Report By</h3>
<br/>
<h3>Both Start and End Dates are mandatory.</h3>
<br/> <br/>
<form>


<input type="hidden" value="CertificateChecking" name="AdmissionReport" id="WhichFunctionToHandle">


     
    <br/> <br/>
<button type="button" id="LifeTimeMembershipReportButton" class="btn btn-info">Check Certificate</button>


</form>



<script>
                                  
	                $('#LifeTimeMembershipReportButton').click(function(event) { 

		              
		var WhichFunctionToHandle="CertificateChecking";
		alert(WhichFunctionToHandle);
		
		                 $.get('AjaxServlet',{WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) { 
		                        $('#profile_info1').html(responseText);         
		                    });
		                });
		           
        </script>