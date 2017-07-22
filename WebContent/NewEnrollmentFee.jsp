
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




<table>
<!-- This is the main element -->
  <tr>
    <th>Item Name</th>
    <th>Amount</th>
  </tr>
  
 <!-- Contents are below --> 

 <tr>
    <td>Enrollment Fee</td>
    <td><input type="number" value=6000.00 name="EnrollmentFee" id="EnrollmentFee"></td>
  </tr>
  
   <tr>
    <td>Identity Card</td>
    <td><input type="number" name="IdentityCard" id="IdentityCard" ></td>
  </tr>
  
   <tr>
    <td>Misc Rts</td>
   <td><input type="number"  name="MiscRTS" id="MiscRTS" ></td>
  </tr>
  
   <tr>
    <td>KSBC Trust</td>
   <td><input type="number"  name="KSBCTrust" id="KSBCTrust" ></td>
  </tr>
  
   <tr>
    <td>KAWF Membership Fee</td>
    <td><input type="number" value=2050.00  name="KAWFMembershipFee" id="KAWFMembershipFee" ></td>
  </tr>
  
   <tr>
    <td>BCI-Subscription</td>
    <td><input type="number"  name="BCISubscription" id="BCISubscription" ></td>
  </tr>
  
   <tr>
    <td>FDS</td>
   <td><input type="number" value=3000.00  name="FDS" id="FDS" ></td>
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
   <td><input type="number"  name="IdentityCard" id="IdentityCard" ></td>
  </tr>
  
   <tr>
    <td>D.D No.</td>
   <td><input type="number"  name="IdentityCard" id="IdentityCard" ></td>
  </tr>

</table>
<br/>

<input type="submit" class="btn btn-info" value="Submit" ><br><br/>

