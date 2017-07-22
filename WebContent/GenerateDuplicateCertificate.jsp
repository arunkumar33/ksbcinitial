
 <form id="FormForGenerateCertificate">
<input type="text" placeholder="KARNumber" value="" id="KARNumber"/>
<input type="hidden" value="SearchWithKARNumberForDuplicateCertificate" name="SearchWithKARNumberForDuplicateCertificate" id="WhichFunctionToHandle">
		<input type="button" name="SearchWithRegNumber" value="Submit" class="btn btn-info" id="SearchWithKARNumberForDuplicateCertificate"  >
		
		</form>
		
	<!-- 	<form id="form1">
<h1>AJAX Demo using Jquery in JSP and Servlet</h1>
Enter your Name:
<input type="text" id="user"/>
<input type="button" id="submit" value="Ajax Submit"/>
 </form> -->

<script>
                                  
	                $('#SearchWithKARNumberForDuplicateCertificate').click(function(event) { 
	alert ("Generate Duplicate Certificate part");
		                    var KARNumber=$('#KARNumber').val();
		var WhichFunctionToHandle=$('#WhichFunctionToHandle').val();
		                 $.get('AjaxServlet',{KARNumber:KARNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) { 
		                        $('#profile_info1').html(responseText);         
		                    });
		                });
		           
        </script>