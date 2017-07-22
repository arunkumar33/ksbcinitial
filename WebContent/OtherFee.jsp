
 <form id="FormForFeesRecipt">
<input type="text" placeholder="KARNumber" value="" id="KARNumber" name="KARNumber"/>
</br>
<input type="hidden" value="FeeReciptByKARNumber" name="WhichFunctionToHandle" id="WhichFunctionToHandle">
		<input type="button" name="SearchWithKARNumber" value="Submit"  id="SearchWithKARNumber"  >
		
		</form>
		
	<!-- 	<form id="form1">
<h1>AJAX Demo using Jquery in JSP and Servlet</h1>
Enter your Name:
<input type="text" id="user"/>
<input type="button" id="submit" value="Ajax Submit"/>
 </form> -->
 <script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
                                
	                $('#SearchWithKARNumber').click(function(event) { 
	alert("*********************");
		                    var KARNumber=$('#KARNumber').val();
		var WhichFunctionToHandle=$('#WhichFunctionToHandle').val();
		                 $.get('AjaxServlet',{KARNumber:KARNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) { 
		                        $('#Main_Content1').html(responseText);         
		                    });
		                });
		            