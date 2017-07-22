<!-- 
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
<form action="KAWFLateWelfareFund" method="post">
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
This is the main element
  <tr>
    <th>Item Name</th>
    <th>Amount</th>
  </tr>
  
 Contents are below 

 <tr>
    <td>KAWF Membership Fee</td>
    <td><input type="checkbox" name="KAWFfee" value=2050> 2050.00</td>
  </tr>
  
   <tr>
    <td>Welfare Fund Membership Late Fee  </td>
    <td><input type="number" name="WFLateFee" value="50"></td>
  </tr>
  

   </table><br><br>
   
<div class="form-group" style="width: 50%"> 
  <label class="col-md-4 control-label">Payment by: </label>
    <div class="col-md-4 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-th-list"></i></span>
    <select name="category" class="form-control selectpicker" >
      
      <option>Cash</option>
      <option value="DD">DD</option>
      <option>Cheque</option>
      
     
    </select>
  </div>
</div>
</div>

   <br/>


<table>
 <tr>
    <td>Bank Name</td>
    <td><input type="text" name="BankName" id="BankName"></td>
  </tr>
  
   <tr>
    <td>Branch Name</td>
    <td><input type="text" name="BranchName" id="BranchName"></td>
  </tr>
  
   
  
   <tr>
    <td>DD No./Cheque No.</td>
   <td><input type="text"  name="DDNumber" id="DDNumber" ></td>
  </tr>
  
  </table>


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
	  $.get('AjaxServlet',{KARNumber:KARNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) { 
		 
		 var str = responseText;
		    var res = str.split(",");
		    document.getElementById("Name").value = res[0];
		    document.getElementById("Place").value = res[1];
			                           
			                    });
	// alert(KARNumber);
	}



</script> -->

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
<form action="KAWFLateWelfareFund" method="post" onkeypress="return event.keyCode != 13;">
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
    <td>KAWF Membership Fee</td>
 
    
    
    <td><input type="checkbox" name="KAWFfee" id="KAWFfee" value="2050">
  <input type="number" name="KAWFfee2" id="KAWFfee2" value="2050" onblur="ChangetheValueofCheckList('KAWFfee2','KAWFfee')"></td>
  </tr>
  

  
   <tr>
    <td>Welfare Fund Membership Late Fee  </td>
    <td><input type="number" name="WFLateFee"  id="WFLateFee" value="00"></td>
  </tr>
  
 
   </table><br><br>
   
<div class="form-group" style="width: 50%"> 
  <label class="col-md-4 control-label">Payment by: </label>
    <div class="col-md-4 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-th-list"></i></span>
    <select name="category" class="form-control selectpicker" >
      
      <option>Cash</option>
      <option value="DD">DD</option>
     
      
     
    </select>
  </div>
</div>
</div>

   <br/>


<table>
 <tr>
    <td>Bank Name</td>
    <td><input type="text" name="BankName" id="BankName"></td>
  </tr>
  
   <tr>
    <td>Branch Name</td>
    <td><input type="text" name="BranchName" id="BranchName"></td>
  </tr>
  
   
  
   <tr>
    <td>DD No./Cheque No.</td>
   <td><input type="text"  name="DDNumber" id="DDNumber" ></td>
  </tr>
  
   <tr>
    <td>D.D Date</td>
   <td><input type="date"  name="DDDate" id="DDDate" ></td>
  </tr>
  <tr>
   <tr>
  <td> 
   </td>
   <td>Total<input type="number"  name="Total" id="Total"  onblur=" findTotal()" value="00"> 
   <p id="TotalResult"><p>
   </td>
   </tr>
  </table>


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
	  $.get('AjaxServlet',{KARNumber:KARNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) { 
		 
		 var str = responseText;
		    var res = str.split(",");
		    document.getElementById("Name").value = res[0];
		    document.getElementById("Place").value = res[1];
			                           
			                    });
	alert(KARNumber);
	}



</script>

<script>

function findTotal()
{

	
	
	
		 
			//  var i = $(BCISubscription).val()); 
			var WFLateFee = 0;
			var KAWFfee = 0;
			
				 
			WFLateFee = document.getElementById('WFLateFee').value;
				
			 if (document.getElementById("KAWFfee").checked)
			 {
			 
			 
				 KAWFfee = document.getElementById('KAWFfee2').value;
			 }
		
			
			 
		
		
	
	
	
	
	 /* document.getElementById("Name").value="Arun";
	 document.getElementById("Place").value="Bangalore"; */
	 var WhichFunctionToHandle= "GetTotalKAWFlatefeetotal";
	  $.get('AjaxServlet',{WFLateFee:WFLateFee,KAWFfee:KAWFfee,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) { 
		 var str = responseText;
		   /*  var res = str.split(","); */
		   
		  
		   var total=document.getElementById("Total").value;
		   if (total==Number(str))
		   {
	    	document.getElementById("TotalResult").innerHTML="";
		  
		   }
	   else
		   {
		   document.getElementById("TotalResult").innerHTML="<b>Not Matching Please Check it again</b>";
		  
		   }
	/* 	    document.getElementById("Place").value = res[1]; */
		 
			                           
			                    });
	
	/* 
	 */
/*   var tot=BCISubscription+FDS+FDSClosingFD+BCIClosingFD+BCIInterestonFD+BCIReimbursment+CostReceipt+FDSDiffAmt+BCISubscriptionLateFee;
	 alert(tot);   */
	}
</script>
<script>

function ChangetheValueofCheckList(From,To)
{
	// alert (From);
	/*  document.getElementById("Place").value */
//	alert(document.getElementById(From).value);
	var tmp=document.getElementById(From).value;
	document.getElementById(To).value=tmp;
	// alert(document.getElementById(To).value);
	}

</script>