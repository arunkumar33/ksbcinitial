
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
<form action="Transfer" method="post">
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
  <br/> <br/>
 <tr>
   
<td>Transfer Date</td>
  <td><input type="date" name="ResumptionDate" id="ResumptionDate" /></td>

  </tr>
  
  <!--  <tr>
    <td>NOC Number </td>
    <td><input type="text" name="NocNumber"  id="NocNumber"  ></td>
  </tr>
  -->
  
 
   <br><br>
   


 
   
  <tr>
   
<td>Remarks</td>
<td>
    <select name="Remarks"  >
      
      <option value="1">Family Transferred</option>
      <option value="2">Shifting To Native</option>
     <option value="3">Better Prospects</option>
    
     
    </select>
    
    </td>
  </tr>
  <br><br>
   <br/>
 <tr>
   
<td>Remarks</td>
  <td><input type="text" name="AnotherRemarks" id="AnotherRemarks" /></td>

  </tr>
<br/>
</table>
<input type="submit" class="btn btn-info" value="Submit" ><br><br/>
</form>


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
