
 <form id="FormForScheduleInterview">
<input type="text" placeholder="KAR Number" value="" id="KARNumber"/>

<input type="hidden" value="ViewAllBillingStatus" name="ViewAllBillingStatus" id="WhichFunctionToHandle">
		<input type="button" class="btn btn-info" name="ViewDocumentByRegNumber" value="Submit"  id="ViewDocumentByRegNumber"  >
		
		</form>
		
	<!-- 	<form id="form1">
<h1>AJAX Demo using Jquery in JSP and Servlet</h1>
Enter your Name:
<input type="text" id="user"/>
<input type="button" id="submit" value="Ajax Submit"/>
 </form> -->
 <script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
                                
	                $('#ViewDocumentByRegNumber').click(function(event) { 
	alert("*********************");
		                    var KARNumber=$('#KARNumber').val();
		var WhichFunctionToHandle=$('#WhichFunctionToHandle').val();
		                 $.get('AjaxServlet',{KARNumber:KARNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) { 
		                        $('#Main_Content1').html(responseText);         
		                    });
		                });
		            
        </script>