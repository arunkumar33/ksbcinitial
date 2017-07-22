
 <form id="FormForGenerateCertificate">
<input type="text" placeholder="KARNumber" value="" id="KARNumber"  onblur=" GetEnrollmentDetailsForCashSection1()"/>
<br>
 Name <br>
   <input type="text" name="Name" id="Name">
 <br>
    Place <br>
    <input type="text" name="Place" id="Place">
  <br>

<input type="hidden" value="SearchWithKARNumberForStatusChange" name="SearchWithKARNumberForStatusChange" id="WhichFunctionToHandle">
		<input type="button" name="SearchWithRegNumber" value="Submit"  id="SearchWithKARNumberForStatusChange"  >
		
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
		                    var KARNumber=$('#KARNumber').val();
		var WhichFunctionToHandle=$('#WhichFunctionToHandle').val();
		                 $.get('AjaxServlet',{KARNumber:KARNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) { 
		                        $('#Main_Content1').html(responseText);         
		                    });
		                });
		           
        </script>

<script>

function GetEnrollmentDetailsForCashSection1()
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
	/* alert(KARNumber); */
	}



</script>
