
 <form id="FormForScheduleInterview">
<input type="text" placeholder="RegNumber" value="" id="RegNumber"/>

<input type="hidden" value="ScheduleInterview" name="ScheduleInterview" id="WhichFunctionToHandle">
		<input type="button" name="ScheduleInterview" class="btn btn-info" value="Submit"  id="ScheduleInterview"  >
		
		</form>
		
	<!-- 	<form id="form1">
<h1>AJAX Demo using Jquery in JSP and Servlet</h1>
Enter your Name:
<input type="text" id="user"/>
<input type="button" id="submit" value="Ajax Submit"/>
 </form> -->
 <script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
                                
	                $('#ScheduleInterview').click(function(event) { 
	alert("*********************");
		                    var RegNumber=$('#RegNumber').val();
		var WhichFunctionToHandle=$('#WhichFunctionToHandle').val();
		                 $.get('AjaxServlet',{RegNumber:RegNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) { 
		                        $('#Main_Content1').html(responseText);         
		                    });
		                });
		            
        </script>