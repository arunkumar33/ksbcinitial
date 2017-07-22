
    
    <h3>Hi.. You can Insert Chairman Signature.</h3>
<br/>
<h3>Both To and From Dates are mandatory.</h3>
<br/> <br/>
<form>
<label>Name</label>
<input type="text" name="Name" id="Name" />
<br/> <br/>
<label>Desc</label>
<input type="text" name="Desc" id="Desc" />
<br/> <br/>
<label>Start Date</label>
<input type="date" name="StartDate" id="StartDate" />
<br/> <br/>

<label>End Date</label>
<input type="date" name="EndDate" id="EndDate" />
<br/> <br/>

<input type="hidden" value="AddPhotoChairman" name="AddPhotoChairman" id="WhichFunctionToHandle">
<br/> <br/>


     
  
<button type="button" id="LifeTimeMembershipReportButton" class="btn btn-info">Next</button>


</form>



<script>
                                  
	                $('#LifeTimeMembershipReportButton').click(function(event) { 
	alert ("LifeTimeMembershipReportButton part");
		                    var StartDate=$('#StartDate').val(); 
	
		 var EndDate=$('#EndDate').val();

		
	
		var WhichFunctionToHandle=$('#WhichFunctionToHandle').val();
	
		var Name=$('#Name').val();
	
		var Desc=$('#Desc').val();
		
		
		                  $.get('AjaxServlet',{Desc:Desc,Name:Name,EndDate:EndDate,WhichFunctionToHandle:WhichFunctionToHandle,StartDate:StartDate},function(responseText) { 
		                        $('#profile_info1').html(responseText);         
		                    });
		                });
		           
        </script>