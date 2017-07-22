
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
<form action="KAWF" method="post">
<table>
<!-- This is the main element -->
  <tr>
    <th>Item Name</th>
    <th>Amount</th>
  </tr>
  
 <!-- Contents are below --> 

 <tr>
    <td>Enrollment Fee</td>
    <td><input type="number" name="EnrollmentFee" id="EnrollmentFee" value="0"></td>
  </tr>
  
   <tr>
    <td>Identity Card</td>
    <td><input type="number" name="IdentityCard" id="IdentityCard" value="0"></td>
  </tr>
  
</table>
   
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
</div><br/>


<table>

 <tr>
    <td>Your Name</td>
    <td><input type="text" name="Name" id="Name"></td>
  </tr>
  
   <tr>
    <td>Place</td>
    <td><input type="text" name="Place" id="Place"></td>
  </tr>
  
   <tr>
    <td>KAR Number</td>
    <td><input type="text" name="KARNumber" id="KARNumber" value="0"></td>
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
   <td><input type="number"  name="Amount" id="Amount"  value="0"></td>
  </tr>
  
   <tr>
    <td>Cheque No.</td>
   <td><input type="text"  name="ChequeNumber" id="ChequeNumber" ></td>
  </tr>
  
   <tr>
    <td>D.D No.</td>
   <td><input type="text"  name="DDNumber" id="DDNumber" ></td>
  </tr>
<tr>
    <td>D.D Date</td>
   <td><input type="date"  name="DDDate" id="DDDate" ></td>
  </tr>
</table>
<br/>




<input type="submit" class="btn btn-info" value="Submit" class="btn btn-info" name="KAWFFeeStructureButton" id="KAWFFeeStructureButton"><br><br/>
<!-- <button type="button" class="btn btn-danger">Cancel</button> -->
<input type="hidden" value="KAWFFeeStructureForKAR" name="KAWFFeeStructureForKAR" id="WhichFunctionToHandle">
</form>



<script type="text/javascript">
<!--

//-->
 $('#KAWFFeeStructureButton').click(function(event) { 
	alert ("KAWFFeeStructureButton part");
		                    var EnrollmentFee=$('#EnrollmentFee').val(); 
		
		
		
		var IdentityCard=$('#IdentityCard').val();
		
		
		
		 $.get('AjaxServlet',{
			EnrollmentFee:EnrollmentFee,IdentityCard:IdentityCard,Name:Name,KARNumber:KARNumber,BankName:BankName,BranchName:BranchName,
			Amount:Amount,ChequeNumber:ChequeNumber,DDNumber:DDNumber,DDDate:DDDate
			},function(responseText) { 
			                        $('#Main_Content1').html(responseText);         
			                    });
			                });

</script>




</body>
</html>