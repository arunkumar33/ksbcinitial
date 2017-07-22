<!DOCTYPE html>
<html>
<head>

 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

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
</head>
<body>

<table>
<!-- This is the main element -->
  <tr>
    <th>Item Name</th>
    <th>Amount</th>
  </tr>
  
 <!-- Contents are below --> 

 <tr>
    <td>BCI-Subscription</td>
    <td><input type="checkbox">
    <input type="number" name="BCISubscription"></td>
  </tr>
  
   <tr>
    <td>FDS </td>
    <td><input type="checkbox">
    <input type="number" value=3000.00 name="FDS"></td>
  </tr>
  
   <tr>
    <td>BCI Subscription Late Fee</td>
   <td><input type="checkbox">
   <input type="number" name="BCISubscriptionLateFee"></td>
  </tr>
  
   <tr>
    <td>FDS Diff. Amt</td>
   <td><input type="checkbox">
   <input type="number" name="FDSDiffAmt"></td>
  </tr>
  
   <tr>
    <td>Cost Receipt</td>
    <td><input type="checkbox">
    <input type="number" name="CostReceipt"></td>
  </tr>
  
   <tr>
    <td>BCI Reimbursment of SalaryDeducion</td>
    <td><input type="checkbox">
    <input type="number" name="BCIReimbursment"></td>
  </tr>
  
   <tr>
    <td>BCI Interest on F.D</td>
   <td><input type="checkbox">
   <input type="number" name="BCIInterestonFD"></td>
  </tr>
  
  <tr>
    <td>BCI Closing F.D</td>
   <td><input type="checkbox">
   <input type="number" name="BCIClosingFD"></td>
  </tr>
  
  <tr>
    <td>FDS Interest on F.D</td>
   <td><input type="checkbox">
   <input type="number" name="FDSInterestonFD"></td>
  </tr>
  
  <tr>
    <td>FDS Closing F.D</td>
   <td><input type="checkbox">
   <input type="number" name="FDSClosingFD"></td>
  </tr>
  
 
   
   </table><br><br>
   
<div class="form-group" style="width: 50%"> 
  <label class="col-md-4 control-label">Payment by: </label>
    <div class="col-md-4 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-th-list"></i></span>
    <select name="category" class="form-control selectpicker" >
      
      <option>Cash</option>
      <option>D.D</option>
      <option>Cheque</option>
      
     
    </select>
  </div>
</div>
</div>

   <br/>


<table>

 <tr>
    <td>Your Name</td>
    <td><input type="text" name="Name" id="Name"></td>
  </tr>
  
   <tr>
    <td>KAR Number</td>
    <td><input type="number" name="KARNumber" id="KARNumber"></td>
  </tr>


 <tr>
    <td>Bank Name</td>
    <td><input type="text" name="BankName" id="BankName"></td>
  </tr>
  
   <tr>
    <td>Branch Name</td>
    <td><input type="text" name="BranchName" id="BranchName"></td>
  </tr>
  
   <tr>
    <td>Amount</td>
   <td><input type="number"  name="Amount" id="Amount" ></td>
  </tr>
  
   <tr>
    <td>Cheque No.</td>
   <td><input type="number"  name="ChequeNumber" id="ChequeNumber" ></td>
  </tr>
  
   <tr>
    <td>D.D No.</td>
   <td><input type="number"  name="DDNumber" id="DDNumber" ></td>
  </tr>

</table>
<br/>




<input type="submit" class="btn btn-info" value="Submit" name="BCIFDSFeeStructureButton" id="BCIFDSFeeStructureButton"><br><br/>
<!-- <button type="button" class="btn btn-danger">Cancel</button> -->
<input type="hidden" value="BCIFDSFeeStructureForKAR" name="BCIFDSFeeStructureForKAR" id="WhichFunctionToHandle">
</form>



<script type="text/javascript">
<!--

//-->
 $('#BCIFDSFeeStructureButton').click(function(event) { 
	alert ("BCIFDSFeeStructureButton part");
	
		var BCISubscription=$('#BCISubscription').val(); 
		var FDS=$('#FDS').val();
		var BCISubscriptionLateFee=$('#BCISubscriptionLateFee').val();
		var FDSDiffAmt=$('#FDSDiffAmt').val();
		var CostReceipt=$('#CostReceipt').val();
		var BCIReimbursment=$('#BCIReimbursment').val();
		var BCIInterestonFD=$('#BCIInterestonFD').val();
		var BCIClosingFD=$('#BCIClosingFD').val();
		var FDSInterestonFD=$('#FDSInterestonFD').val();
		var FDSClosingFD=$('#FDSClosingFD').val();
		
		
		
	
		
		
		
		 $.get('AjaxServlet',{
			BCISubscription:BCISubscription,FDS:FDS,Name:Name,BCISubscriptionLateFee:BCISubscriptionLateFee,
			FDSDiffAmt:FDSDiffAmt,CostReceipt:CostReceipt,BCIReimbursment:BCIReimbursment,BCIInterestonFD:BCIInterestonFD,
			BCIClosingFD:BCIClosingFD,FDSInterestonFD:FDSInterestonFD,FDSClosingFD:FDSClosingFD,
			Name:Name,KARNumber:KARNumber,BankName:BankName,BranchName:BranchName,
			Amount:Amount,ChequeNumber:ChequeNumber,DDNumber:DDNumber
			},function(responseText) { 
			                        $('#Main_Content1').html(responseText);         
			                    });
			                });

</script>





</body>
</html>