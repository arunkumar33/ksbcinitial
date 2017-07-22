
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

<form action="BCI_FDS" method="post" onkeypress="return event.keyCode != 13;">
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




 <!-- Contents are below --> 

 <tr>
    <td>BCI-Subscription</td>
    <td>
    <input type="number"   name="BCISubscription" id="BCISubscription"  value="00"></td>
  </tr>
  
   <tr>
    <td>FDS </td>
    
    
    
    
   <td><input type="checkbox"  name="FDS" id="FDS" onblur="ChangetheValueofCheckList('FDS2','FDS')">
   <input  type="number"   name="FDS2" id="FDS2" value="3000" ></td>
    
   
    
    
  </tr>
  
   <tr>
    <td>BCI Subscription Late Fee</td>
   <td>
   <input  type="number"  name="BCISubscriptionLateFee"  id="BCISubscriptionLateFee" value="00"></td>
  </tr>
  
   <tr>
    <td>FDS Diff. Amt</td>
   <td>
   <input  type="number"  name="FDSDiffAmt" id="FDSDiffAmt" value="00"></td>
  </tr>
  
   <tr>
    <td>Cost Receipt</td>
    <td>
    <input  type="number"  name="CostReceipt"  id="CostReceipt"  value="00"></td>
  </tr>
  
   <tr>
    <td>BCI Reimbursment of SalaryDeducion</td>
    <td>
    <input  type="number"  name="BCIReimbursment"   id="BCIReimbursment"  value="00"></td>
  </tr>
  
   <tr>
    <td>BCI Interest on F.D</td>
   <td>
   <input  type="number"  name="BCIInterestonFD"  id="BCIInterestonFD" value="00"></td>
  </tr>
  
  <tr>
    <td>BCI Closing F.D</td>
   <td>  <input  type="number"  name="BCIClosingFD"   id="BCIClosingFD" value="00"></td>
  </tr>
  
  <tr>
    <td>FDS Interest on F.D</td>
   <td>
   <input  type="number"  name="FDSInterestonFD" id="FDSInterestonFD" value="00"></td>
  </tr>
  
  <tr>
    <td>FDS Closing F.D</td>
   <td>
   <input  type="number" name="FDSClosingFD"  id="FDSClosingFD" value="00"></td>
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
  
   <tr>
    <td>D.D Date</td>
   <td><input type="date"  name="DDDate" id="DDDate" ></td>
  </tr>
    <tr>
  <td> 
   </td>
   <td>Total<input type="number"  name="Total" id="Total"  onblur=" findTotal()" value="00"> 
   <p id="TotalResult"><p>
   </td>
   </tr>
   
   

</table>
<br/>




<input type="submit" class="btn btn-info" value="Submit" name="NewEnrollmentFeeStructureButton" id="NewEnrollmentFeeStructureButton"><br><br/>
</form>





<script>

function GetEnrollmentDetailsForCashSection()
{
	
	 var KARNumber = document.getElementById("KARNumber").value;
	
	 var WhichFunctionToHandle= "GetEnrollmentDetailsForCashSection";
	  $.get('AjaxServlet',{KARNumber:KARNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) { 
		 
		 var str = responseText;
		    var res = str.split(",");
		    document.getElementById("Name").value = res[0];
		    document.getElementById("Place").value = res[1];
			                           
			                    });
	
	}
</script>
<script>

function findTotal()
{

	
	
	
		 var KARNumber = document.getElementById("KARNumber").value;
		 var BCISubscription=document.getElementById("BCISubscription").value;
			//  var i = $(BCISubscription).val()); 
			var FDS = 0;
			 if (document.getElementById("FDS").checked)
				 {
				 
				 
				  FDS = document.getElementById('FDS2').value;
				 }
			
			
			 
			
			var FDSClosingFD = document.getElementById('FDSClosingFD').value;
			 
			var BCIClosingFD = document.getElementById('BCIClosingFD').value;
			
			var BCIInterestonFD = document.getElementById('BCIInterestonFD').value;
			
			var BCIReimbursment = document.getElementById('BCIReimbursment').value;
		
			var CostReceipt = document.getElementById('CostReceipt').value;
			
		var FDSDiffAmt = document.getElementById('FDSDiffAmt').value;
		
		var FDSInterestonFD = document.getElementById('FDSInterestonFD').value;
		
		
			var BCISubscriptionLateFee = document.getElementById('BCISubscriptionLateFee').value;

		
	
	 /* document.getElementById("Name").value="Arun";
	 document.getElementById("Place").value="Bangalore"; */
	 var WhichFunctionToHandle= "GetTotalForBci";
	  $.get('AjaxServlet',{FDSInterestonFD:FDSInterestonFD,FDS:FDS,FDSClosingFD:FDSClosingFD,BCIClosingFD:BCIClosingFD,BCIInterestonFD:BCIInterestonFD,BCIReimbursment:BCIReimbursment,CostReceipt:CostReceipt,FDSDiffAmt:FDSDiffAmt,BCISubscriptionLateFee:BCISubscriptionLateFee,BCISubscription:BCISubscription,KARNumber:KARNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) { 
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