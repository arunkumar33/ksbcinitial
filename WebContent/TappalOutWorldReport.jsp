
 <form id="FormForGenerateCertificate">
<input type="text" placeholder="In Word ID" value="" id="INworldID"/>
<input type="hidden" value="GetReportForTappalOutworld" name="SearchWithKARNumberForDuplicateCertificate" id="WhichFunctionToHandle">
		<input type="button" name="SearchWithRegNumber" class="btn btn-info" value="Submit"  id="SearchWithKARNumberForDuplicateCertificate"  >
		
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
		                    var INworldID=$('#INworldID').val();
		var WhichFunctionToHandle=$('#WhichFunctionToHandle').val();
		                 $.get('AjaxServlet',{INworldID:INworldID,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) { 
		                        $('#profile_info1').html(responseText);         
		                    });
		                });
		           
        </script>