
 <form id="FormForGenerateCertificate">
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
<input type="hidden" value="KARPendingFee" name="KARPendingFee" id="WhichFunctionToHandle">
		<tr>
    <td>Submit</td>
		
	<td>	<input type="button" name="SearchWithRegNumber" value="Submit"  class="btn btn-info" id="SearchWithKARNumberForDuplicateCertificate"  ></td>
		</tr>
		
		</table>
		</form>
		</form>
		
	<!-- 	<form id="form1">
<h1>AJAX Demo using Jquery in JSP and Servlet</h1>
Enter your Name:
<input type="text" id="user"/>
<input type="button" id="submit" value="Ajax Submit"/>
 </form> -->

<script>
                                  
	                $('#SearchWithKARNumberForDuplicateCertificate').click(function(event) { 
	// alert ("Generate Duplicate Certificate part");
		                    var KARNumber=$('#KARNumber').val();
		var WhichFunctionToHandle=$('#WhichFunctionToHandle').val();
		                 $.get('AjaxServlet',{KARNumber:KARNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) { 
		                        $('#Main_Content1').html(responseText);         
		                    });
		                });
		           
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