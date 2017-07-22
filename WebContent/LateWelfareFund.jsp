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

<form action="KAWFLateWelfareFund" method="post">
<table>
<!-- This is the main element -->
  <tr>
    <th>Item Name</th>
    <th>Amount</th>
  </tr>
  
 <!-- Contents are below --> 

 <tr>
    <td>KAWF Membership Fee</td>
    <td><input type="number" value="2050.00" id="KAWFMembershipFee" name="KAWFMembershipFee"></td>
  </tr>
  
   <tr>
    <td>Welfare Fund Membership Late Fee  </td>
    <td><input type="number" value="50.00" id="WelfareFundMembership" name="WelfareFundMembership"></td>
  </tr>
  

   </table><br><br>
   
<div class="form-group" style="width: 50%"> 
  <label class="col-md-4 control-label">Payment by: </label>
    <div class="col-md-4 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-th-list"></i></span>
    <select name="category" class="form-control selectpicker" >
      
      <option>Cash</option>
      <option>DD</option>
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
    <td>Cheque No.</td>
   <td><input type="number"  name="IdentityCard" id="IdentityCard" ></td>
  </tr>
  
   <tr>
    <td>D.D No.</td>
   <td><input type="number"  name="IdentityCard" id="IdentityCard" ></td>
  </tr>

</table>
<br/>
<br/>

<input type="submit" class="btn btn-info" value="Submit" ><br><br/>

</form>