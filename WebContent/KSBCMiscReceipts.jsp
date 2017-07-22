
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

<form action="KsbcMiscReciept" method="post" onkeypress="return event.keyCode != 13;">
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
    <td>Identity Card</td>
    <td><input type="number" name="IdentityCard" id="IdentityCard" value="00"></td>
  </tr>
  
   <tr>
    <td>Enrollment Application</td>


  <td><input type="checkbox" name="EnrollmentApplication" id="EnrollmentApplication" value="50">
  <input type="number" name="EnrollmentApplication2" id="EnrollmentApplication2" value="50" onblur="ChangetheValueofCheckList('EnrollmentApplication2','EnrollmentApplication')"></td>
</tr>  
   <tr>
    <td>Complaint Fee</td>
   
    <td><input type="checkbox" name="ComplaintFee" id="ComplaintFee" value="1000">
  <input type="number" name="ComplaintFee2" id="ComplaintFee2" value="1000" onblur="ChangetheValueofCheckList('ComplaintFee2','ComplaintFee')"></td>
  </tr>
   
  
  
   <tr>
    <td>Change Of Adreess</td>

  
    <td><input type="checkbox" name="ChangeOfAdreess" id="ChangeOfAdreess" value="25">
  <input type="number" name="ChangeOfAdreess2" id="ChangeOfAdreess2" value="25" onblur="ChangetheValueofCheckList('ChangeOfAdreess2','ChangeOfAdreess')"></td>
  </tr>
   
  
  
  
   <tr>
    <td>Change of Name Publication Charges</td>

  
  <td><input type="checkbox" name="ChangeofNamePublication" id="ChangeofNamePublication" value="2000">
  <input type="number" name="ChangeofNamePublication2" id="ChangeofNamePublication2" value="2000" onblur="ChangetheValueofCheckList('ChangeofNamePublication2','ChangeofNamePublication')"></td>
  </tr>
  
  
   <tr>
    <td>NOC(Transfer of Enrollment)</td>
  <td><input type="checkbox" name="NOC" id="NOC" value="2000">
  <input type="number" name="NOC2" id="NOC2" value="2000" onblur="ChangetheValueofCheckList('NOC2','NOC')"></td>
  </tr>
  


  
   <tr>
    <td>Process Fee(Transfer of Enrollment)</td>
  <td><input type="checkbox" name="ProcessFee" id="ProcessFee" value="2000">
  <input type="number" name="ProcessFee2" id="ProcessFee2" value="2000" onblur="ChangetheValueofCheckList('ProcessFee2','ProcessFee')"></td>
  </tr>
  
   <tr>
    <td>Resumption</td>
  <td><input type="checkbox" name="Resumption" id="Resumption" value="5000">
  <input type="number" name="Resumption2" id="Resumption2" value="5000" onblur="ChangetheValueofCheckList('Resumption2','Resumption')"></td>
  </tr>
  
  
   <tr>
    <td>V.S.P</td>
  <td><input type="checkbox" name="vsp" id="vsp" value="250">
  <input type="number" name="vsp2" id="vsp2" value="250" onblur="ChangetheValueofCheckList('vsp2','vsp')"></td>
  </tr>
  
   <tr>
    <td>Continuity Certificate</td>
  
  <td><input type="checkbox" name="ContinuityCertificate" id="ContinuityCertificate" value="200">
  <input type="number" name="ContinuityCertificate2" id="ContinuityCertificate2" value="200" onblur="ChangetheValueofCheckList('ContinuityCertificate2','ContinuityCertificate')"></td>
</tr>
  
   <tr>
    <td>Certified Copy Charges</td>
   <td><input type="number" name="CertificateCopyCharges" id="CertificateCopyCharges" value="00"></td>
  </tr>
  
   <tr>
    <td>D.O.B Certificate</td>
    <td><input type="number" name="DOBCertificate" id="DOBCertificate" value="00"></td>
  </tr>
  
   <tr>
    <td>Postage Receipts</td>
    <td><input type="number" name="PostageReceipts" id="PostageReceipts" value="00"></td>
  </tr>
  
   <tr>
    <td>Retd. P.D.C</td>
  <td><input type="number" name="PDC" id="PDC" value="00"> </td>
  </tr>
  
   <tr>
    <td>Retd. Endoment Certificate</td>
   <td><input type="number" name="EndomentCertificate" id="EndomentCertificate" value="00"></td>
  </tr>
  
   <tr>
    <td>Duplicate Enrollment Certificate</td>
   <td><input type="number" name="DuplicateEnrollemt" id="DuplicateEnrollemt" value="00"></td>
  </tr>
  
   <tr>
    <td>Election Deposit</td>
   <td><input type="number" name="ElectionDeposit" id="ElectionDeposit" value="00"></td>
  </tr>
  
   <tr>
    <td>Voter(s)C. D.</td>
  <td><input type="number" name="VoterCD" id="VoterCD" value="00"></td>
  </tr>
  
   <tr>
    <td>Nomination Form</td>
    <td><input type="number" name="NominationForm" id="NominationForm" value="00"></td>
  </tr>
  
   <tr>
    <td>Election Rules</td>
    <td><input type="number" name="ElectionRules" id="ElectionRules" value="00"></td>
  </tr>
  
   <tr>
    <td>Misc. Receipts</td>
    <td><input type="number" name="MiscReceipts" id="MiscReceipts" value="00"></td>
  </tr>
  
   <tr>
    <td>KSBC Cost Receipt</td>
    <td><input type="number" name="KSBCCostReceipt" id="KSBCCostReceipt" value="00"></td>
  </tr>
  
   <tr>
    <td>KSBC Interest on F.D</td> 
    <td><input type="number" name="KSBCInterestONFD" id="KSBCInterestONFD" value="00"></td>
  </tr>
  
   <tr>
    <td>KSBC Closing F.D</td>
    <td><input type="number" name="ClosingFD" id="ClosingFD" value="00"></td>
  </tr>
  
   <tr>
    <td>KSBC Reimbursement of Salary Deduction </td>
   <td><input type="number" name="ReimbursementOFSalaryDeduction" id="ReimbursementOFSalaryDeduction" value="00"></td>
  </tr>
  
   <tr>
    <td>Govt. Grant</td>
    <td><input type="number" name="GOvtGrant" id="GOvtGrant" value="00"></td>
  </tr>
  
  
</table>
   <br/>
   
 
   
   <br/>
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
    <td>DD Date</td>
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

	
	

		 
		var IdentityCard=0;
		var EnrollmentApplication=0;
		var ComplaintFee=0;
		var ChangeOfAdreess=0;
		var ChangeofNamePublication=0;
		var NOC=0;
		var ProcessFee=0;
		var Resumption=0;
		var vsp=0;
		var ContinuityCertificate=0;
		var CertificateCopyCharges=0;
		var DOBCertificate=0;
		var PostageReceipts=0;
		var PDC=0;
		var EndomentCertificate=0;
		var DuplicateEnrollemt=0;
		var ElectionDeposit=0;
		var VoterCD=0;
		var NominationForm=0;
		var ElectionRules=0;
		var MiscReceipts=0;
		var KSBCCostReceipt=0;
		var KSBCInterestONFD=0;
		var ClosingFD=0;
		var ReimbursementOFSalaryDeduction=0;
		var GOvtGrant=0;
			//  var i = $(BCISubscription).val()); 
			
					var ReimbursementOFSalaryDeduction = document.getElementById('ReimbursementOFSalaryDeduction').value;
			 
			var GOvtGrant = document.getElementById('GOvtGrant').value;
			
			
			
				
			var IdentityCard = document.getElementById('IdentityCard').value;
			 
			var CertificateCopyCharges = document.getElementById('CertificateCopyCharges').value;
			
			var DOBCertificate = document.getElementById('DOBCertificate').value;
			
			var PostageReceipts = document.getElementById('PostageReceipts').value;
		
			var PDC = document.getElementById('PDC').value;
			
		var EndomentCertificate = document.getElementById('EndomentCertificate').value;
		
		var DuplicateEnrollemt = document.getElementById('DuplicateEnrollemt').value;
		
		
			var ElectionDeposit = document.getElementById('ElectionDeposit').value;
			
			
			//2
			
			
				var VoterCD = document.getElementById('VoterCD').value;
			 
			var NominationForm = document.getElementById('NominationForm').value;
			
			var ElectionRules = document.getElementById('ElectionRules').value;
			
			var MiscReceipts = document.getElementById('MiscReceipts').value;
		
			var KSBCCostReceipt = document.getElementById('KSBCCostReceipt').value;
			
		var KSBCInterestONFD = document.getElementById('KSBCInterestONFD').value;
		
		var ClosingFD = document.getElementById('ClosingFD').value;
		
		
			var ElectionDeposit = document.getElementById('ElectionDeposit').value;
			
			 if (document.getElementById("EnrollmentApplication").checked)
				 {
				 
				 
				 EnrollmentApplication = document.getElementById('EnrollmentApplication2').value;
				 }
			 if (document.getElementById("ComplaintFee").checked)
			 {
			 
			 
				 ComplaintFee = document.getElementById('ComplaintFee2').value;
			 }
		
			 if (document.getElementById("ChangeOfAdreess").checked)
			 {
			 
			 
				 ChangeOfAdreess = document.getElementById('ChangeOfAdreess2').value;
			 }
			 
			 if (document.getElementById("ChangeofNamePublication").checked)
			 {
			 
			 
				 ChangeofNamePublication = document.getElementById('ChangeofNamePublication2').value;
			 }
			 
			 
		 if (document.getElementById("NOC").checked)
		 {
		 
		 
			 NOC = document.getElementById('NOC2').value;
		 }
	
		 
		 if (document.getElementById("ProcessFee").checked)
		 {
		 
		 
			 ProcessFee = document.getElementById('ProcessFee2').value;
		 }
	 if (document.getElementById("Resumption").checked)
	 {
	 
	 
		 Resumption = document.getElementById('Resumption2').value;
	 }

	 
	 if (document.getElementById("vsp").checked)
	 {
	 
	 
		 vsp = document.getElementById('vsp').value;
	 }
 if (document.getElementById("ContinuityCertificate").checked)
 {
 
 
	 ContinuityCertificate = document.getElementById('ContinuityCertificate').value;
 }

 
 
			 
		
		
	
	
	 /* document.getElementById("Name").value="Arun";
	 document.getElementById("Place").value="Bangalore"; */
	 var WhichFunctionToHandle= "GetTotalKSBCfeetotal";
	 
     
	 

	 

	  $.get('AjaxServlet',{IdentityCard:IdentityCard,EnrollmentApplication:EnrollmentApplication,ChangeOfAddress:ChangeOfAdreess,ComplaintFee:ComplaintFee,ChangeofNamePublication:ChangeofNamePublication,NOC:NOC,ProcessFee:ProcessFee,Resumption:Resumption,vsp:vsp,ContinuityCertificate:ContinuityCertificate,CertificateCopyCharges:CertificateCopyCharges,DOBCertificate:DOBCertificate,PostageReceipts:PostageReceipts,PDC:PDC,EndomentCertificate:EndomentCertificate,DuplicateEnrollemt:DuplicateEnrollemt,ElectionDeposit:ElectionDeposit,VoterCD:VoterCD,NominationForm:NominationForm,ElectionRules:ElectionRules,MiscReceipts:MiscReceipts,KSBCCostReceipt:KSBCCostReceipt,KSBCInterestONFD:KSBCInterestONFD,ClosingFD:ClosingFD,ReimbursementOFSalaryDeduction:ReimbursementOFSalaryDeduction,GOvtGrant:GOvtGrant,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) { 
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