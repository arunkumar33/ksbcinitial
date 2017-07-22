<!DOCTYPE html>
<html>
<head>

 <!-- <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
 
<table>
<tr>
    <td>KAR Number</td>
    <td><input type="text" name="KARNumber" id="KARNumber" ></td>
  </tr>
  
 <tr>
 
 <tr>
    <td>Name</td>
    <td><input type="text" name="NameOftheClient" id="NameOftheClient" ></td>
  </tr>
  
  
  <tr>
    <td>Place</td>
    <td><input type="text" name="PlaceOftheClient" id="PlaceOftheClient" ></td>
  </tr>
</table>

<br></br>
-->
</head>
<body>
<form method="post" action="KSBCMisc">
<table>
<!-- This is the main element -->
  <tr>
    <th>Item Name</th>
    <th>Amount</th>
  </tr>
  
 <!-- Contents are below --> 

  
   <tr>
    <td>Identity Card</td>
    <td><input type="number" name="IdentityCard" id="IdentityCard" value="0"></td>
  </tr>
  
   <tr>
    <td>Enrolment Application</td>
<td><input type="checkbox" name="EnrollmentApplication" value="50" />50.00 <br /></td>
  </tr>
  
<!--    <tr>
    <td>Complaint Fee</td>
   <td><input type="checkbox" name="ComplaintFee" value="1000" />1000.00 <br /></td>
  </tr>
  
   <tr>
    <td>Change Of Adreess</td>
<td><input type="checkbox" name="ChangeOfAddress" value="25" />25.00 <br /></td>  </tr>
  
   <tr>
    <td>Change of Name Publication Charges</td>
<td><input type="checkbox" name="ChangeOfNamePublication" value="2000" />2000.00 <br /></td>  </tr>
  
   <tr>
    <td>NOC(Transfer of Enrollment)</td>
<td><input type="checkbox" name="NOC" value="2000" />2000.00<br /></td>  </tr>
  
   <tr>
    <td>Process Fee(Transfer of Enrollment)</td>
<td><input type="checkbox" name="ProcessFee" value="2000" />2000.00 <br /></td>
  </tr>
  
   <tr>
    <td>Resumption</td>
<td><input type="checkbox" name="MiscReport" value="5000" />5000.00 <br /></td>
  </tr>
  
   <tr>
    <td>V.S.P</td>
<td><input type="checkbox" name="VSP" value="250" />250.00 <br /></td>
  </tr>
  
   <tr>
    <td>Continuity Certificate</td>
<td><input type="checkbox" name="ContinuityCertificate" value="200" />200.00 <br /></td>  </tr>
  
   <tr>
    <td>Certified Copy Charges</td>
   <td><input type="number" name="CertificateCopyCharges" id="CertificateCopyCharges" value="0"></td>
  </tr>
  
   <tr>
    <td>D.O.B Certificate</td>
    <td><input type="number" name="DOBCertificate" id="DOBCertificate" value="0"></td>
  </tr>
  
   <tr>
    <td>Postage Receipts</td>
    <td><input type="number" name="PostageReceipts" id="PostageReceipts" value="0"></td>
  </tr>
  
   <tr>
    <td>Retd. P.D.C</td>
  <td><input type="number" name="PDC" id="PDC" value="0"> </td>
  </tr>
  
   <tr>
    <td>Retd. Endoment Certificate</td>
   <td><input type="number" name="EndomentCertificate" id="EndomentCertificate" value="0"></td>
  </tr>
  
   <tr>
    <td>Duplicate Enrollment Certificate</td>
   <td><input type="number" name="DuplicateEnrollemt" id="DuplicateEnrollemt" value="0"></td>
  </tr>
  
   <tr>
    <td>Election Deposit</td>
   <td><input type="number" name="ElectionDeposit" id="ElectionDeposit" value="0"></td>
  </tr>
  
   <tr>
    <td>Voter(s)C. D.</td>
  <td><input type="number" name="VoterCD" id="VoterCD" value="0"></td>
  </tr>
  
   <tr>
    <td>Nomination Form</td>
    <td><input type="number" name="NominationForm" id="NominationForm" value="0"></td>
  </tr>
  
   <tr>
    <td>Election Rules</td>
    <td><input type="number" name="ElectionRules" id="ElectionRules" value="0"></td>
  </tr>
  
   <tr>
    <td>Misc. Receipts</td>
    <td><input type="number" name="MiscReceipts" id="MiscReceipts" value="0"></td>
  </tr>
  
   <tr>
    <td>KSBC Cost Receipt</td>
    <td><input type="number" name="KSBCCostReceipt" id="KSBCCostReceipt" value="0"></td>
  </tr>
  
   <tr>
    <td>KSBC Interest on F.D</td> 
    <td><input type="number" name="KSBCInterestONFD" id="KSBCInterestONFD" value="0"></td>
  </tr>
  
   <tr>
    <td>KSBC Closing F.D</td>
    <td><input type="number" name="ClosingFD" id="ClosingFD" value="0"></td>
  </tr>
  
   <tr>
    <td>KSBC Reimbursement of Salary Deduction </td>
   <td><input type="number" name="ReimbursementOFSalaryDeduction" id="ReimbursementOFSalaryDeduction" value="0"></td>
  </tr>
  
   <tr>
    <td>Govt. Grant</td>
    <td><input type="number" name="GOvtGrant" id="GOvtGrant" value="0"></td>
  </tr>
</table>
   <br/><br/>

  
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

<p>Please fill the below details if your payment mode is DD/Cheque</p>
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
   <td><input type="number"  name="Amount" id="Amount"  value="00"></td>
  </tr>
  
   <tr>
    <td>DD No./Cheque No.</td>
   <td><input type="text"  name="DDNumber" id="DDNumber" ></td>
  </tr> -->
  
  

</table>
<br/>



<input type="submit" class="btn btn-info" value="Submit" name="FeeStructureButton" id="FeeStructureButton"><br><br/>
</form>
</body>
</html>