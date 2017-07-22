
 <form id="FormForScheduleInterview">
<input type="text" placeholder="Pleasee enter KAR Number" value="" id="KARNumber"/>
</br> </br>
<input type="hidden" value="KARLoginCheck" name="WhichFunctionToHandle" id="WhichFunctionToHandle">
		<input type="button" name="SearchWithRegNumber" value="Select" class="btn btn-info" id="SearchWithRegNumber"  >
		
		</form>
		
		
		
	
 <script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
                                
	                $('#SearchWithRegNumber').click(function(event) { 
	alert("********** Select ***********");
		                    var KARNumber=$('#KARNumber').val();
		var WhichFunctionToHandle=$('#WhichFunctionToHandle').val();
		                 $.get('AjaxServlet',{KARNumber:KARNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) { 
		                        $('#Main_Content1').html(responseText);         
		                    });
		                });
		
	/* 	For Second Form */
		

		            
        </script>