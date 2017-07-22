
 <form id="FormForGenerateCertificate">
<input type="text" placeholder="KARNumber" value="" id="KARNumber"/>
<input type="hidden" value="SearchWithKARNumberForCertificateStamp" name="SearchWithKARNumberForCertificateStamp" id="WhichFunctionToHandle">
		<input type="button" name="SearchWithRegNumber" value="Submit"  class="btn btn-info" id="SearchWithKARNumberForCertificate"  >
		
		</form>
		
	<!-- 	<form id="form1">
<h1>AJAX Demo using Jquery in JSP and Servlet</h1>
Enter your Name:
<input type="text" id="user"/>
<input type="button" id="submit" value="Ajax Submit"/>
 </form> -->

<script>
                                  
	                $('#SearchWithKARNumberForCertificate').click(function(event) { 
	alert ("Generate Certificate part");
		                    var KARNumber=$('#KARNumber').val();
		var WhichFunctionToHandle=$('#WhichFunctionToHandle').val();
		                 $.get('AjaxServlet',{KARNumber:KARNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) { 
		                        $('#profile_info1').html(responseText);         
		                    });
		                });
		           
        </script>