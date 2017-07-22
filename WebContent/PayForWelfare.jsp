<%-- 

<%
String KARNumber= (String)request.getAttribute("KARNumber");
session.setAttribute("KARNumber", KARNumber);
request.setAttribute("KARNumber", KARNumber);
%>
 <form id="FormForScheduleInterview">

 <select name="PayForWelfareSelect" class="form-control selectpicker"  id="PayForWelfareSelect">
      <option value=" " >Select For pay</option>
      <option>Apply For Change Of Status</option>
      <option>Name Change</option>
      <option >Nominee Change</option>
      <option >Address Change</option>
      <option >Pay for duplicate Certificate</option>
     
    </select>
    
    </br>
     </br>
      
<input type="hidden" value="SelectForwelfarePay" name="SelectForwelfarePay" id="WhichFunctionToHandle">
		<input type="button" class="btn btn-info" name="ChangeForWelfareButton" value="Submit"  id="ChangeForWelfareButton"  >
		
		</form>
		
	<!-- 	<form id="form1">
<h1>AJAX Demo using Jquery in JSP and Servlet</h1>
Enter your Name:
<input type="text" id="user"/>
<input type="button" id="submit" value="Ajax Submit"/>
 </form> -->

<script>
                                
	                $('#ChangeForWelfareButton').click(function(event) { 
	alert("*********************");
		                    var PaySelect=$('#PayForWelfareSelect').val();
		alert(PaySelect);
		var WhichFunctionToHandle=$('#WhichFunctionToHandle').val();
		alert(WhichFunctionToHandle);
		                 $.get('AjaxServlet',{PayForWelfareSelect:PayForWelfareSelect,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) { 
		                        $('#Main_Content1').html(responseText);         
		                    });
		                });
		            
        </script>


  --%>
  
  
  

<%
String KARNumber= (String)request.getAttribute("KARNumber");
session.setAttribute("KARNumber", KARNumber);
%>
 <form id="FormForScheduleInterview">

 <select name="PaySelect" class="form-control selectpicker"  id="PaySelect">
      <option value=" " >Select For pay</option>
      <option>Apply For Change Of Status</option>
      <option>Name Change</option>
      <option >Nominee Change</option>
      <option >Address Change</option>
      <option >Pay for duplicate Certificate</option>
   <!--   welfare should come here -->
    </select>
    
    </br>
     </br>
      
<input type="hidden" value="SelectForWelfareChangesPay" name="SelectForWelfareChangesPay" id="WhichFunctionToHandle">
		<input type="button" class="btn btn-info" name="ChangeOfStatusButton" value="Submit"  id="ChangeOfStatusButton"  >
		
		</form>
		
	<!-- 	<form id="form1">
<h1>AJAX Demo using Jquery in JSP and Servlet</h1>
Enter your Name:
<input type="text" id="user"/>
<input type="button" id="submit" value="Ajax Submit"/>
 </form> -->
<!--  <script src="http://code.jquery.com/jquery-latest.js"></script> -->
<script>
                                
	                $('#ChangeOfStatusButton').click(function(event) { 
	alert("*********************");
		                    var PaySelect=$('#PaySelect').val();
		alert(PaySelect);
		var WhichFunctionToHandle=$('#WhichFunctionToHandle').val();
		                 $.get('AjaxServlet',{PaySelect:PaySelect,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) { 
		                        $('#Main_Content1').html(responseText);         
		                    });
		                });
		            
        </script>


 