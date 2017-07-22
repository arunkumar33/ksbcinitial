

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
<form action="COP" method="post">
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
    <td>KSBC COP  Fee</td>
 
    
    
   <td><input type="number" name="KSBCCOPFEE" id="KSBCCOPFEE" value="00"></td>
   </tr>
  


 <tr>
    <td>COP Application Fee</td>
 
    
    
    <td><input type="number" name="COPApplicationFee" id="COPApplicationFee" value="0">
   </tr>
  

  
   <tr>
    <td>COP Application Late Fee  </td>
    <td><input type="number" name="COPApplicationLateFee"  id="COPApplicationLateFee" value="00"></td>
  </tr>
  
  
  <tr>
    <td>COP Resc Fee  </td>
    <td><input type="number" name="RESCFee"  id="RESCFee" value="00"></td>
  </tr>
  
   <tr>
    <td>COP Misc Fee  </td>
    <td><input type="number" name="MiscFee"  id="MiscFee" value="00"></td>
  </tr>
  
  
  <tr>
    <td> Interest on F.D</td> 
    <td><input type="number" name="InterestONFD" id="InterestONFD" value="00"></td>
  </tr>
  
   <tr>
    <td> Closing F.D</td>
    <td><input type="number" name="ClosingFD" id="ClosingFD" value="00"></td>
  </tr>
 
 <tr>
    <td>KSBC COP Senior Advc</td>
    <td><input type="number" name="COPSenioradvc" id="COPSenioradvc" value="00"></td>
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

	
	

		 
		 var KSBCCOPFEE=0;
			//  var i = $(BCISubscription).val()); 
			var COPApplicationFee = 0;
			var COPApplicationLateFee = 0;
			var ClosingFD=0;
			var RESCFee=0;
			var MiscFee=0;
			var COPSenioradvc=0;
			var InterestONFD=0; 
			COPApplicationLateFee = document.getElementById('COPApplicationLateFee').value;
			
			KSBCCOPFEE = document.getElementById('KSBCCOPFEE').value;
			RESCFee = document.getElementById('RESCFee').value;
			MiscFee = document.getElementById('MiscFee').value;
			COPSenioradvc = document.getElementById('COPSenioradvc').value;
			
			
			ClosingFD = document.getElementById('ClosingFD').value;
			InterestONFD = document.getElementById('InterestONFD').value;
				
			
				 COPApplicationFee = document.getElementById('COPApplicationFee').value;
			 
		
			
			 
		
		
	
	
	
	
	 /* document.getElementById("Name").value="Arun";   GetTotalKAWFlatefeetotal
	 document.getElementById("Place").value="Bangalore"; */
	 var WhichFunctionToHandle= "GetTotalCOPfeetotal";
	  $.get('AjaxServlet',{KSBCCOPFEE:KSBCCOPFEE,RESCFee:RESCFee,MiscFee:MiscFee,COPSenioradvc:COPSenioradvc,InterestONFD:InterestONFD,ClosingFD:ClosingFD,COPApplicationLateFee:COPApplicationLateFee,COPApplicationFee:COPApplicationFee,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) { 
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
		  //  document.getElementById("tataldisplay").value = str;
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