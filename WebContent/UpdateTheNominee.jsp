
 <form id="FormForScheduleInterview">
<input type="text" placeholder="KARNumber" value="" id="KARNumber"/>
</br> </br>
<input type="text" placeholder="Nominee Name" value="" id="NomineeName" name="NomineeName"/>
</br> </br>
<input type="text" placeholder="Remarks" value="" id="Remarks"/>
</br> </br>
<select name="RelationShip" placeholder="RelationShip" value="" id="RelationShip" >
      <option value=" " >Please select RelationShip With the Nominee</option>
      
<!--       Father
Wife
Nephew
UNCLE
Grand son
Husband
Son-in-Law
Sister
YOUNGER BROTHER
Sister-In-Law
Son
Grand Daughter
FRIEND
Daughter
Aunt
niece
Mother
Maternal Uncle
Brother
Others -->
     <option>Father</option>
      <option>Wife</option>
      <option >Nephew</option>
      <option >UNCLE</option>
      <option >Grand son</option>
      <option >Husband</option>
       <option>Father/Mother</option>
      <option>Wife/Daughter</option>
      <option>Wife/son</option>
       <option>Son-in-Law</option>
      <option>Sister</option>
      <option >YOUNGER BROTHER</option>
      <option >FRIEND</option>
      <option >Sister-In-Law</option>
      <option >Sister</option>
      <option >son</option>
        <option>Others</option>
      <option>Brother</option>
      <option >Maternal Uncle</option>
      <option >Mother</option>
      <option >niece</option>
      <option >Aunt</option>
      
       <option>Daughter</option>
      <option>Grand Daughter</option>
      
      
      
      
      
      </select>
      </br> </br>
<input type="hidden" value="NomineeFeeUpdate" name="WhichFunctionToHandle" id="WhichFunctionToHandle">
		<input type="button" name="SearchWithRegNumber" value="Submit" class="btn btn-info" id="SearchWithRegNumber"  >
		
		</form>
		
	<!-- 	<form id="form1">
<h1>AJAX Demo using Jquery in JSP and Servlet</h1>
Enter your Name:
<input type="text" id="user"/>
<input type="button" id="submit" value="Ajax Submit"/>
 </form> -->
 <script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
                                
	                $('#SearchWithRegNumber').click(function(event) { 
	alert("*********************");
		                    var KARNumber=$('#KARNumber').val();
		  var RelationShip=$('#RelationShip').val();
		var NomineeName=$('#NomineeName').val();
		var Remarks=$('#Remarks').val();
		
		var WhichFunctionToHandle=$('#WhichFunctionToHandle').val();
		                 $.get('AjaxServlet',{Remarks:Remarks,NomineeName:NomineeName,RelationShip:RelationShip,KARNumber:KARNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) { 
		                        $('#Main_Content1').html(responseText);         
		                    });
		                });
		            
        </script>