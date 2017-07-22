<%
String KARNumber= (String)session.getAttribute("KARNumber");
System.out.println(KARNumber + "From JSP");
System.out.println(session.getAttribute("KARNumber") + "   KARNumber From JSP");
request.setAttribute("KARNumber", KARNumber);
session.setAttribute("KARNumber", KARNumber);
%>
 <form id="FormCertificate">
<!-- 
 <select name="PaySelect" class="form-control selectpicker"  id="PaySelect">
      <option value=" " >Select Challan to upload</option>
      <option>Apply For Change Of Status</option>
      <option>Name Change</option>
      <option >Nominee Change</option>
      <option >Address Change</option>
      <option >Pay for duplicate Certificate</option>
     Welfare comes here
    </select>
    
    </br>
     </br> -->
      
<input type="hidden" value="SelectPhototoUpload" name="SelectForPhotoUpload" id="WhichFunctionToHandle">
		<input type="button" class="btn btn-info" name="PhotoUploadButton" value="Submit"  id="PhotoUploadButton"  >
		
		</form>
		
	<!-- 	<form id="form1">
<h1>AJAX Demo using Jquery in JSP and Servlet</h1>
Enter your Name:
<input type="text" id="user"/>
<input type="button" id="submit" value="Ajax Submit"/>
 </form> -->
<!--  <script src="http://code.jquery.com/jquery-latest.js"></script> -->
<script>
                                
	                $('#PhotoUploadButton').click(function(event) { 
	alert("*********************");
		                    var PaySelect=$('#PaySelect').val();
		alert(PaySelect);
		var WhichFunctionToHandle=$('#WhichFunctionToHandle').val();
		                 $.get('AjaxServlet',{PaySelect:PaySelect,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) { 
		                        $('#Main_Content1').html(responseText);         
		                    });
		                });
		            
        </script>