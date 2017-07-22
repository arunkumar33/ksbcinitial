
 <form id="FormForGenerateCertificate">
		<input type="button" name="SearchWithRegNumber" value="Submit"  id="SearchWithKARNumberForStatusChange"  >
		
		</form>
		
hhhhhhhhhhhh

<script>
                                  
	                $('#SearchWithKARNumberForStatusChange').click(function(event) { 
	alert ("SearchWithKARNumberForStatusChange part");
		         
		var WhichFunctionToHandle=$('#MoveDataFromValidatedBeantoEnrollment').val();
		                 $.get('AjaxServlet',{WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) { 
		                        $('#profile_info1').html(responseText);         
		                    });
		                });
		           
        </script>