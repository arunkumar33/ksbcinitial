
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

<form action="KAWFClaims" method="post" onkeypress="return event.keyCode != 13;">
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

  
 <!-- Contents are below --> 

 <tr>
    <td>Claim Application Date</td>
 
    <td><input type="date" name="ClaimDate" id="ClaimDate">

  </tr>
  
  
  
   <tr>
    <td>Claim Type</td>
 
    <td>

 
 <div class="form-group" style="width: 50%"> 
    <select name="ClaimType" class="form-control selectpicker" >
      
      <option value="D">Death</option>
      <option value="R">Retirement</option>
      <option value="M">Medical</option>
      <option value="F">Financial Hardship</option>
      
     
      
     
    </select>
   </div>

  </td></tr>
   <tr>
    <td>Remarks  </td>
    <td><textarea name="Remarks" cols="50">
</textarea></td>
  </tr>
  
  <tr>
    <td>Claim Amount</td>
 
    <td><input type="number" name="ClaimAmount">

  </tr>

 <tr>
    <td>Resolution Number</td>
 
    <td><input type="text" name="ResolutionNumber" >

  </tr>

<tr>
    <td>Resolution Date</td>
 
    <td><input type="date" name="ResolutionDate" >

  </tr>

   </table><br><br>
   

 <input type="submit" class="btn btn-default submit" value="SUBMIT" />

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

	}



</script>

</form>
