
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 80%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 5px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}

</style>
<form action="SeniorAdv" method="post">
<table>
  <tr>
    <td>KAR Number</td>
    <td><input type="text" name="KARNumber" id="KARNumber" onblur=" GetEnrollmentDetailsForCashSection()"></td>
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
<tr><td></td><td></td></tr>
 
<br></br>
<!-- This is the main element -->
  <tr>
    <th>Item Name</th>
    <th>Amount</th>
  </tr>
  
 <!-- Contents are below --> 

 <tr>
    <td>Payed Amount</td>
 
    
    
    <td><input type="text" name="PayedAmount" id="PayedAmount" value="00">
  </tr>
  

  
   <tr>
    <td>Payed Year </td>
    <td><input type="number" name="PayedYear"  id="PayedYear" value="00"></td>
  </tr>
  
 
   </table><br><br>
   




<br/>

<input type="submit" class="btn btn-info" value="Submit" ><br><br/>
</form>


<script>

function GetEnrollmentDetailsForCashSection()
{
	 var KARNumber = document.getElementById("KARNumber").value;
	 
	 /* document.getElementById("Name").value="Arun";
	 document.getElementById("Place").value="Bangalore"; */
	 var WhichFunctionToHandle= "GetEnrollmentDetailsForCashSection";
	 �$.get('AjaxServlet',{KARNumber:KARNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) { 
		 
		 var str = responseText;
		    var res = str.split(",");
		    document.getElementById("Name").value = res[0];
		    document.getElementById("Place").value = res[1];
			�������������������������� 
			��������������������});
	alert(KARNumber);
	}



</script>