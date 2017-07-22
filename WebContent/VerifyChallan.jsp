
 <form id="FormForScheduleInterview">
<input type="text" placeholder="RegNumber" value="" id="RegNumber"/>
</br> </br>
<input type="hidden" value="VerifyChallanWithRegNumber" name="WhichFunctionToHandle" id="WhichFunctionToHandle">
		<input type="button" name="SearchWithRegNumber" value="Select"  id="SearchWithRegNumber"  >
		
		</form>
		
		</br> </br>
		<form id="FormForSelectAll">
		
		<input type="button"  class="btn btn-info" name="SearchForSelectAllChallan" value="Select ALL"  id="SearchForSelectAllChallan"  >
		
		</form>
		
	<!-- 	<form id="form1">
<h1>AJAX Demo using Jquery in JSP and Servlet</h1>
Enter your Name:
<input type="text" id="user"/>
<input type="button" id="submit" value="Ajax Submit"/>
 </form> -->
 <script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
                                
	                $('#SearchWithRegNumber').click(function(event) { 
	alert("********** Select ***********");
		                    var RegNumber=$('#RegNumber').val();
		var WhichFunctionToHandle=$('#WhichFunctionToHandle').val();
		                 $.get('AjaxServlet',{RegNumber:RegNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) { 
		                        $('#Main_Content1').html(responseText);         
		                    });
		                });
		
	/* 	For Second Form */
		

		            
        </script>

<script>
 $('#SearchForSelectAllChallan').click(function(event) { 
	alert("********* Select All ************");
		                   
		var WhichFunctionToHandle=$('#WhichFunctionToHandle').val();
		                 $.get('AjaxServlet',{WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) { 
		                        $('#Main_Content1').html(responseText);         
		                    });
		                });




</script>