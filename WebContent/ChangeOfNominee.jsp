
 <form id="FormForScheduleInterview">
<input type="text" placeholder="KARNumber" value="" id="KARNumber"/>
</br> </br>
<input type="text" placeholder="Nominee Name" value="" id="Nominee Name"/>
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
      
      
       <option>Son-in-Law</option>
      <option>Sister</option>
      <option >YOUNGER BROTHER</option>
      <option >FRIEND</option>
      <option >Sister-In-Law</option>
      <option >Sister</option>
      
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
<input type="hidden" value="NomineeFee" name="WhichFunctionToHandle" id="WhichFunctionToHandle">
		<input type="button" name="SearchWithRegNumber" class="btn btn-info" value="Submit"  id="SearchWithRegNumber"  >
		
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
		                    var RegNumber=$('#RegNumber').val();
		var WhichFunctionToHandle=$('#WhichFunctionToHandle').val();
		                 $.get('AjaxServlet',{RegNumber:RegNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) { 
		                        $('#Main_Content1').html(responseText);         
		                    });
		                });
		            
        </script>