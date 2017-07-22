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
    <td>KAWF Subscription</td>
    <td><input type="checkbox">
   <input type="number" ></td>
  </tr>
  
   <tr>
    <td>Senior Advocate Contribution </td>
    <td><input type="checkbox">
    <input type="number"></td>
  </tr>
  
   <tr>
    <td>Change of Nominee</td>
  <td><input type="checkbox">
  <input type="number" value="100.00"></td>
  </tr>
  
   <tr>
    <td>Duplicate F/M Certificate</td>
   <td><input type="checkbox">
   <input type="number" value="200.00"></td>
  </tr>
  
   <tr>
    <td>Welfare Fund Cost Receipts</td>
   <td><input type="checkbox"><input type="number" ></td>
  </tr>
  
   <tr>
    <td>Donation</td>
    <td><input type="checkbox"><input type="number"></td>
  </tr>
  
   <tr>
    <td>Subscription Late Fee</td>
<td><input type="checkbox"><input type="number" ></td>
  </tr>
  
  <tr>
    <td>Senior Advocate Late Fee</td>
   <td><input type="checkbox"><input type="number" ></td>
  </tr>
  
  <tr>
    <td>WF Reimbursement of Salary Deduction</td>
   <td><input type="checkbox"><input type="number" ></td>
  </tr>
  
  <tr>
    <td>Welfare Fund Interest On F.D</td>
   <td><input type="checkbox"><input type="number" ></td>
  </tr>
  
  <tr>
    <td>Welfare Fund Closing F.D</td>
   <td><input type="checkbox"><input type="number"></td>
  </tr>
  
  <tr>
    <td>Sale of Stamp Amount</td>
   <td><input type="checkbox"><input type="number" ></td>
  </tr>
  
  <tr>
    <td>Life Membership Fee</td>
  <td><input type="checkbox"><input type="number"></td>
  </tr>
  
  <tr>
    <td>Govt. grant</td>
   <td><input type="checkbox"><input type="number" ></td>
  </tr>
  
  <tr>
    <td>Miscellaneous</td>
   <td><input type="checkbox"><input type="number" ></td>
  </tr>
   <br/>
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
    <td><input type="text"></td>
  </tr>
  
   <tr>
    <td>KAR Number</td>
    <td><input type="number"></td>
  </tr>


 <tr>
    <td>Bank Name</td>
    <td><input type="text"></td>
  </tr>
  
   <tr>
    <td>Branch Name</td>
    <td><input type="text"></td>
  </tr>
  
   <tr>
    <td>Amount</td>
   <td><input type="number"></td>
  </tr>
  
   <tr>
    <td>Cheque No.</td>
   <td><input type="number"></td>
  </tr>
  
   <tr>
    <td>D.D No.</td>
   <td><input type="number"></td>
  </tr>

</table>
<br/>

<input type="submit" class="btn btn-info" value="Submit" ><br><br/>

</body>
</html>