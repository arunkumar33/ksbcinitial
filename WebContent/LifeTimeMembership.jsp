<h3>Hi.. You can Generate Life TIme MemberShip Report Here</h3>
<br/>
<h3>Both Start and End Dates are mandatory.</h3>
<br/> <br/>
<form>
<label>Start Date</label>
<input type="date" name="StartDate" id="StartDate" />
<br/> <br/>

<label>End Date</label>
<input type="date" name="EndDate" id="EndDate" />
<input type="hidden" value="LifeTimeMembershipReport" name="LifeTimeMembershipReport" id="WhichFunctionToHandle">
<br/> <br/>
<button type="button" id="LifeTimeMembershipReportButton" class="btn btn-info">Get Me Report</button>


</form>



<script>
                                  
	                $('#LifeTimeMembershipReportButton').click(function(event) { 
	alert ("LifeTimeMembershipReportButton part");
		                    var StartDate=$('#StartDate').val(); 
		 var EndDate=$('#EndDate').val();
		var WhichFunctionToHandle=$('#WhichFunctionToHandle').val();
		                 $.get('AjaxServlet',{EndDate:EndDate,WhichFunctionToHandle:WhichFunctionToHandle,StartDate:StartDate},function(responseText) { 
		                        $('#Main_Content1').html(responseText);         
		                    });
		                });
		           
        </script>