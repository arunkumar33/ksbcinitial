
 <form id="FormForGenerateCertificate">
<input type="date" placeholder="mm/dd/yyyy" value="" id="StartDate"/>
<br>
<input type="text" placeholder="Operator Name" value="" id="Operator"/>
<input type="hidden" value="DailyReportForCashSectionWithOperator" name="SearchWithKARNumberForStatusChange" id="WhichFunctionToHandle">
		<input type="button" name="SearchWithRegNumber" value="Submit" class="btn btn-info" id="SearchWithKARNumberForStatusChange"  >
		
		</form>
		
	<!-- 	<form id="form1">
<h1>AJAX Demo using Jquery in JSP and Servlet</h1>
Enter your Name:
<input type="text" id="user"/>
<input type="button" id="submit" value="Ajax Submit"/>
 </form> -->

<script>
                                  
	                $('#SearchWithKARNumberForStatusChange').click(function(event) { 
	alert ("SearchWithKARNumberForStatusChange part");
		                    var StartDate=$('#StartDate').val();
	var Operator=$('#Operator').val();
		var WhichFunctionToHandle=$('#WhichFunctionToHandle').val();
		                 $.get('AjaxServlet',{Operator:Operator,StartDate:StartDate,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) { 
		                        $('#profile_info1').html(responseText);         
		                    });
		                });
		           
        </script>