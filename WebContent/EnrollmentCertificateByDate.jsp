
    
    <h3>Hi.. You can Generate certificate </h3>
<br/>
<h3> Dates are mandatory.</h3>
<br/> <br/>
<form>

<label>Enrollment Date</label>
<input type="date" name="StartDate" id="StartDate" />
<br/> <br/>


<input type="hidden" value="GenerateReport" name="AdmissionReport" id="WhichFunctionToHandle">


     
    <br/> <br/>
<button type="button" id="LifeTimeMembershipReportButton" class="btn btn-info">Get Me Report</button>


</form>



<script>
                                  
	                $('#LifeTimeMembershipReportButton').click(function(event) { 

		 var StartDate=$('#StartDate').val();
		alert(StartDate);
		
		var WhichFunctionToHandle="GenerateAllTheCertificateAtonce";
	
		
		                 $.get('AjaxServlet',{StartDate:StartDate,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) { 
		                        $('#profile_info1').html(responseText);         
		                    });
		                });
		           
        </script>