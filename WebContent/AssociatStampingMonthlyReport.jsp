
    
    <h3>Hi.. You can Generate Monthly Report By</h3>
<br/>
<h3>Both Start and End Dates are mandatory.</h3>
<br/> <br/>
<form>

<label>Start Date</label>
<input type="date" name="StartDate" id="StartDate" />
<br/> <br/>

<label>End Date</label>
<input type="date" name="EndDate" id="EndDate" />
<input type="hidden" value="GenerateReport" name="AdmissionReport" id="WhichFunctionToHandle">


     
    <br/> <br/>
<button type="button" id="LifeTimeMembershipReportButton" class="btn btn-info">Get Me Report</button>


</form>



<script>
                                  
	                $('#LifeTimeMembershipReportButton').click(function(event) { 

		                    var StartDate=$('#StartDate').val(); 
		alert(StartDate);
		 var EndDate=$('#EndDate').val();
		alert(EndDate);
		
		var WhichFunctionToHandle="AssociateMonthlyReport";
		alert(WhichFunctionToHandle);
		
		                 $.get('AjaxServlet',{EndDate:EndDate,WhichFunctionToHandle:WhichFunctionToHandle,StartDate:StartDate},function(responseText) { 
		                        $('#profile_info1').html(responseText);         
		                    });
		                });
		           
        </script>