  
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


<form action="EnrollmentNewMember" method="post" onkeypress="return event.keyCode != 13;">
<table>

  <tr>
    <th>Item Name</th>
    <th>Amount</th>
  </tr>
  
<tr>
    <td>KAR Number</td>
    <td><input type="text" name="KARNumber" id="KARNumber" ></td>
  </tr>

 <tr>
    <td>Name</td>
    <td><input type="text" name="Name" id="Name"></td>
  </tr>
  
    <tr>
    <td>Place</td>
    <td><input type="text" name="Place" id="Place"></td>
  </tr>
  
<!--   <tr>
    <td>Enrollment Fee</td>
    
 <td>
  <input type="radio" name="category" value="6000" checked> General &nbsp; (6000)<br>
  <input type="radio" name="category" value="3000"> SC/ST&nbsp; (3000)<br>
  <input type="radio" name="category"  value="8000"> Special General&nbsp; (6000+2000)<br>
  <input type="radio" name="category"  value="5000"> Special SC/ST&nbsp; (3000+2000)
  </td>
   
  </tr>
   -->
   
  <!--  below change is to check fee structure  -->
  <div>
   <tr>
    <td>Enrollment Fee</td>
    
 <td>
  <input type="radio" name="category"   value="6000" > General &nbsp; (11050)<br>
  <input type="radio" name="category" value="3000"> SC/ST&nbsp; (8050)<br>
  <input type="radio" name="category"  value="8000"> Special General&nbsp; (13050)<br>
  <input type="radio" name="category"  value="5000"> Special SC/ST&nbsp; (10050)
  </td>
<!--   checkbox -->
  </tr>
  
  
  </div>
  
   <tr>
    <td>Identity Card</td>
   <td><input type="number" name="identityCard"  id="identityCard" value="00"></td>
  </tr>
  
   <tr>
    <td>Misc Rts</td>
   <td><input type="number" name="miscRts"  id="miscRts" value="00"></td>
  </tr>
  
   <tr>
    <td>KSBC Trust</td>
   <td><input type="number" name="KsbcTrust"  id="KsbcTrust" value="00"></td>
  </tr>
  
   <tr>
    <td>KAWF Membership Fee</td>
   
    
      <td><input type="checkbox" name="KawfMembershipFee" id="KawfMembershipFee" value="2050">
  <input type="number" name="KawfMembershipFee2" id="KawfMembershipFee2" value="2050" onblur="ChangetheValueofCheckList('KawfMembershipFee2','KawfMembershipFee')"></td>
  </tr>
    
    
 
  
   <tr>
    <td>BCI-Subscription</td>
    <td><input type="number" name="BciSubscription"  id="BciSubscription" value="00"></td>
  </tr>
  
   <tr>
    <td>FDS</td>
  
   
   
      <td><input type="checkbox" name="fds" id="fds" value="3000">
  <input type="number" name="fds2" id="fds2" value="3000" onblur="ChangetheValueofCheckList('fds2','fds')"></td>
  </tr>
    
    <tr>
    <td>Certificate Verification Fee</td>
  
   
   
      <td><input type="checkbox" name="CertificateVerificationFee" id="CertificateVerificationFee" value="2500">
  <input type="number" name="CertificateVerificationFee2" id="CertificateVerificationFee2" value="2500" onblur="ChangetheValueofCheckList('CertificateVerificationFee2','CertificateVerificationFee')"></td>
  </tr>
   </table><br><br>
   

   <br/>


 

<div class="form-group" style="width: 50%"> 
  <label class="col-md-4 control-label">Payment by: </label>
    <div class="col-md-4 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-th-list"></i></span>
    <select name="categoryID" class="form-control selectpicker" >
      
      <option>Cash</option>
      <option value="DD">DD</option>
     <option value="DD">Cheque</option>
      
     
    </select>
  </div>
</div>
</div>
  

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

	
	

		 
		 
			//  var i = $(BCISubscription).val()); 
			var category = 0;
			if ($('input[name=category]:checked').val()==6000)
				{
				category=11050;
				
				}
			else if ($('input[name=category]:checked').val()==3000)
			{
			category=8050;
			
			}
			else if ($('input[name=category]:checked').val()==8000)
			{
			category=13050;
			
			}
			else if ($('input[name=category]:checked').val()==5000)
			{
				category=10050;
			
			}
			else
				{
				category=0;
				
				}
		
			var fds = 0;
			var BciSubscription = 0;
			var KawfMembershipFee = 0;
			var KsbcTrust = 0;
			var miscRts = 0;
			var identityCard = 0;
			
			var CertificateVerificationFee=0;
			 
			 
			 var KsbcTrust = document.getElementById('KsbcTrust').value;
			 
			 var BciSubscription = document.getElementById('BciSubscription').value;
			 
			 var miscRts = document.getElementById('miscRts').value;
			 
			 var identityCard = document.getElementById('identityCard').value;
			/*  category = document.getElementsByName('category').value; */
	/* 	alert(category); */
			 if (document.getElementById("KawfMembershipFee").checked)
			 {
			 
			 
				 KawfMembershipFee = document.getElementById('KawfMembershipFee2').value;
			 }
			 
			 if (document.getElementById("fds").checked)
			 {
			 
			 
				 fds = document.getElementById('fds2').value;
			 }
			 
			 
			
			
			 
			 if (document.getElementById("CertificateVerificationFee").checked)
			 {
			 
			 
				 CertificateVerificationFee = document.getElementById('CertificateVerificationFee2').value;
			 }
			 
		
		
	
	
	 /* document.getElementById("Name").value="Arun";
	 document.getElementById("Place").value="Bangalore"; */
	 var WhichFunctionToHandle= "GetTotalForNewEnrollment";
	  $.get('AjaxServlet',{category:category,CertificateVerificationFee:CertificateVerificationFee,identityCard:identityCard,miscRts:miscRts,KsbcTrust:KsbcTrust,fds:fds,BciSubscription:BciSubscription,KawfMembershipFee:KawfMembershipFee,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) { 
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


