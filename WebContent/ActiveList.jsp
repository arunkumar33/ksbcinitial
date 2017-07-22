
 <form id="FormForScheduleInterview">
 <table>
  <tr>
    <td>KAR Number</td>
<td><input type="text" placeholder="Pleasee enter KAR Number" value="" id="KARNumber" onblur=" GetEnrollmentDetailsForCashSection()"/></td>
</tr>
<tr>
    <td>Name</td>
    <td><input type="text" name="Name" id="Name"></td>
  </tr>
  
   <tr>
    <td>Place</td>
    <td><input type="text" name="Place" id="Place"></td>
  </tr>
  <tr><td></td><td></td></tr>
</br> </br>

<input type="hidden" value="GetStatusFromKARNumber" name="WhichFunctionToHandle" id="WhichFunctionToHandle">
		
		 <tr>
    <td>Submit</td>
		<td><input type="button" name="SearchWithRegNumber" value="Select"  id="SearchWithRegNumber"  ></td>
		</tr>
		
		</table>		
		</form>
		

		
	
 <script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
                                
	                $('#SearchWithRegNumber').click(function(event) { 
	alert("********** Select ***********");
		                    var KARNumber=$('#KARNumber').val();
		var WhichFunctionToHandle=$('#WhichFunctionToHandle').val();
		                 $.get('AjaxServlet',{KARNumber:KARNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) { 
		                        $('#Main_Content1').html(responseText);         
		                    });
		                });
		
	/* 	For Second Form */
		

		            
        </script>

<script>

function GetEnrollmentDetailsForCashSection()
{
	 var KARNumber = document.getElementById("KARNumber").value;
	 
	 /* document.getElementById("Name").value="Arun";
	 document.getElementById("Place").value="Bangalore"; */
	 var WhichFunctionToHandle= "GetEnrollmentDetailsForCashSection";
	  $.get('AjaxServlet',{KARNumber:KARNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) { 
		 
		 var str = responseText;
		    var res = str.split(",");
		    document.getElementById("Name").value = res[0];
		    document.getElementById("Place").value = res[1];
			                           
			                    });
	alert(KARNumber);
	}



</script>