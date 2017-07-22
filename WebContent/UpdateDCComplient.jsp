
 <form id="FormForGenerateCertificate">
<input type="text" placeholder="ComplaintNumber" value="" id="ComplaintNumber"/>
<br><br>
<textarea rows="2" cols="2" id="CaseDetails" name="CaseDetails"  placeholder="Case Details"></textarea>

<input type="hidden" value="UpdateCaseDetailsInDC" name="SearchWithKARNumberForDuplicateCertificate" id="WhichFunctionToHandle">
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
		                    var ComplaintNumber=$('#ComplaintNumber').val();
		 var CaseDetails=$('#CaseDetails').val();
		var WhichFunctionToHandle=$('#WhichFunctionToHandle').val();
		                 $.get('AjaxServlet',{CaseDetails:CaseDetails,ComplaintNumber:ComplaintNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) { 
		                        $('#profile_info1').html(responseText);         
		                    });
		                });
		           
        </script>