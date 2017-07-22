
    
    <h3>Hi.. You can Generate late advocate Report Here</h3>
<br/>
<h3>Both Start and End Dates are mandatory.</h3>
<br/> <br/>
<form>

<label>KARNumber</label>
<input name="KARNumber"  id="KARNumber" type="text" />
    <br/> <br/>
<label>Welfare Date</label>
<input type="date" name="StartDate" id="StartDate" />
<br/> <br/>

<input type="hidden" value="WelfareUpdate" name="WelfareUpdate" id="WhichFunctionToHandle">
<br/> <br/>
 
    <br/> <br/>
<button type="button" id="LifeTimeMembershipReportButton" class="btn btn-info">Get Me Report</button>


</form>



<script>
                                  
	                $('#LifeTimeMembershipReportButton').click(function(event) { 
	alert ("LifeTimeMembershipReportButton part");
		               
		                    var StartDate=$('#StartDate').val(); 
	
		var WhichFunctionToHandle=$('#WhichFunctionToHandle').val();
	
		var KARNumber=$('#KARNumber').val();
	
		
		                  $.get('AjaxServlet',{KARNumber:KARNumber,WhichFunctionToHandle:WhichFunctionToHandle,StartDate:StartDate},function(responseText) { 
		                        $('#profile_info1').html(responseText);         
		                    });
		                });
		           
        </script>