
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

<form action="KAWFMiscReceipt" method="post" onkeypress="return event.keyCode != 13;">
<table>
  <tr>
    <td>KAR Number</td>
    <td><input type="text" name="KARNumber" id="KARNumber" onblur=" GetEnrollmentDetailsForCashSection1()"></td>

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
</table>
<table id="WelfareFundFee"></table>

<table id="Total"></table>
<table>

<!-- This is the main element -->
  <tr>
    <th>Item Name</th>
    <th>Amount</th>
  </tr>
  
 <!-- Contents are below --> 


<!-- <th>Fetch Data</th> -->
<!-- <td><input type="text" name="getdata" id="getdata" onblur=" GetFeeForWelfare()"></td> -->

<!-- <th><button value="GetFee" name="GetFeeValue" onclick='return GetFeeForWelfare();'>GetFee</button></th>
 -->
 <!-- For Kawf Fees  trying to hide kawf subscription fee-->
 <tr>
   <!--  <td>KAWF Subscription</td> -->
    <td>
   <input type="hidden" name="KawfSubscription" value="00"></td>
  </tr>
  
  
   <tr>
   <td>KAWF Subscription</td>
    <td>
   <input type="Number" name="KawfSubscriptionForPlender" id="KawfSubscriptionForPlender"  value="00"></td>
  </tr>
   <tr>
    <td>Senior Advocate Contribution </td>
   
    
     <td><input type="checkbox" name="SeniorAdvocateContribution" id="SeniorAdvocateContribution" value="5000">
  <input type="number" name="SeniorAdvocateContribution2" id="SeniorAdvocateContribution2" value="5000" onblur="ChangetheValueofCheckList('SeniorAdvocateContribution2','SeniorAdvocateContribution')"></td>
    
    
  </tr>
  
   <tr>
    <td>Change of Nominee</td>
       <td><input type="checkbox" name="ChangeofNominee" id="ChangeofNominee" value="100">
  <input type="number" name="ChangeofNominee2" id="ChangeofNominee2" value="100" onblur="ChangetheValueofCheckList('ChangeofNominee2','ChangeofNominee')"></td>
    
  
  
  </tr>
  
   <tr>
    <td>Duplicate F/M Certificate</td>
  
   
   <td><input type="checkbox" name="DuplicateCertificate" id="DuplicateCertificate" value="200">
  <input type="number" name="DuplicateCertificate2" id="DuplicateCertificate2" value="200" onblur="ChangetheValueofCheckList('DuplicateCertificate2','DuplicateCertificate')"></td>
   
   
   
  </tr>
  
   <tr>
    <td>Welfare Fund Cost Receipts</td>
   <td><input type="number" name="wfCost"   id="wfCost"value="00" ></td>
  </tr>
  
   <tr>
    <td>Donation</td>
    <td><input type="number" name="donation"  id="donation"  value="00"></td>
  </tr>
  
   <tr>
    <td>Subscription Late Fee</td>
<td><input type="number" name="subscriptionFee"  id="subscriptionFee" value="00"></td>
  </tr>
  
  <tr>
    <td>Senior Advocate Late Fee</td>
 <td><input type="number" name="seniorAdvFee"  id="seniorAdvFee" value="00"></td>
  </tr>
  
  <tr>
    <td>WF Reimbursement of Salary Deduction</td>
<td><input type="number" name="WFsalDeduction"  id="WFsalDeduction" value="00"></td>
  </tr>
  
  <tr>
    <td>Welfare Fund Interest On F.D</td>
<td><input type="number" name="InterestFD"  id="InterestFD" value="00"></td>
  </tr>
  
  <tr>
    <td>Welfare Fund Closing F.D</td>
<td><input type="number" name="closingFD"  id="closingFD" value="00"></td>  </tr>
  
  <tr>
    <td>Sale of Stamp Amount</td>
<td><input type="number" name="stamp"  id="stamp" value="00"></td>  </tr>

  
    <tr>
    <td>Life Membership Fee</td>
  <td><input type="checkbox" name="LifeMembershipFee" id="LifeMembershipFee" value="25000">
  <input type="number" name="LifeMembershipFee2" id="LifeMembershipFee2" value="25000" onblur="ChangetheValueofCheckList('LifeMembershipFee2','LifeMembershipFee')"></td>
  </tr>
  
  
  
  <tr>
    <td>Govt. grant</td>
<td><input type="number" name="grant"  id="grant" value="00"></td>  </tr>
  </tr>
  
  <tr>
    <td>Miscellaneous</td>
<td><input type="number" name="misc"  id="misc" value="00"></td>  </tr>
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
 <br/>
   
   
   <tr>
  <td> 
   </td>
   <td>Total<input type="number"  name="TotalValue" id="TotalValue"  onblur=" findTotal()" value="00"> 
   <p id="TotalResult"><p>
   </td>
   </tr>
</table>
<br/>




<input type="submit" class="btn btn-info" value="Submit" name="NewEnrollmentFeeStructureButton" id="NewEnrollmentFeeStructureButton"><br><br/>
</form>



<script>

function GetEnrollmentDetailsForCashSection1()
{
	 var KARNumber = document.getElementById("KARNumber").value;
	 

	 var WhichFunctionToHandle= "GetEnrollmentDetailsForCashSection1";
	  $.get('AjaxServlet',{KARNumber:KARNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) { 
		 
		 var str = responseText;
		 
		
		    var res = str.split("divForKSBC");
		    document.getElementById("Name").value = res[0];
		    document.getElementById("Place").value = res[1];
		   /*  alert(res[2]); */
		  /*   document.getElementById("KawfSubscriptionForPlender").type="hidden"; */
		  
		    document.getElementById("WelfareFundFee").innerHTML  = res[2];          
			                    });
	/* alert(KARNumber); */
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



<script>

function GetFeeForWelfare()
{
	// alert ('From');
	/*  document.getElementById("Place").value */
//	alert(document.getElementById(From).value);
	misc
	 var WhichFunctionToHandle= "GetFeeForWelfareToDisplay";
	
 var KARNumber = document.getElementById("KARNumber").value;
	
	// alert(document.getElementById(To).value);
	
	$.get('AjaxServlet',{KARNumber:KARNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) { 
		 
		alert(responseText + "Ho");
		    document.getElementById("WelfareFundFee").html = responseText;
		                              
			                    });
	
	}
	
	
	 function handleClick(cb) {
		 
		  
		  var WhichFunctionToHandle= "GetFeeForWelfareToDisplayForTotal";
			
		  var KARNumber = document.getElementById("KARNumber").value;
		//  var ThisYear = document.getElementById("ThisYear").value;
		  
		  if (document.getElementById("ThisYear")==null)
			  {
			  var ThisYear = 0;
			  }
		  else
			  {
			  if(document.getElementById("ThisYear").checked==true)
				  {
				  var ThisYear = document.getElementById("ThisYear").value; 
				  }
			  else
				  {
				  var ThisYear =0; 
				  }
			  
			  }
		  
		  if (document.getElementById("PriviousYear")==null)
		  {
		  var PriviousYear = 0;
		  }
	  else
		  {
		  
		  if(document.getElementById("PriviousYear").checked==true)
		  {
		  var PriviousYear = document.getElementById("PriviousYear").value; 
		  
		  
		  }
	  else
		  {
		  var PriviousYear =0; 
		  }
		  
		 
		  }
		  
		  
		  
		
		 
		 	// alert(document.getElementById(To).value);
		 	
		 	$.get('AjaxServlet',{ThisYear:ThisYear,PriviousYear:PriviousYear,KARNumber:KARNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) { 
		 		 
		 		
		 		document.getElementById("Total").innerHTML = responseText;
		 		                              
		 			                    });
		 	
	}
	
</script>

<script>

function findTotal()
{

	
	
	
		var SeniorAdvocateContribution =0;
		var ChangeofNominee=0;
		var DuplicateCertificate=0;
		var wfCost=0;
		var donation=0;
		var subscriptionFee=0;
		var seniorAdvFee=0;
		var WFsalDeduction=0;
		var InterestFD=0;
		var closingFD=0;
		var stamp=0;
		var LifeMembershipFee=0;
		var grant=0;
		var misc=0;
		var ThisYear=0;
		var PriviousYear=0;
		var KawfSubscriptionForPlender=0;
			//  var i = $(BCISubscription).val()); 
	 
			  if (document.getElementById("ThisYear")!=null)
				  {
			  if(document.getElementById("ThisYear").checked)
				  {
				  ThisYear  =document.getElementById("ThisYear").value;
				 // alert(ThisYear);
				  }
				  }
			  
			  if (document.getElementById("PriviousYear")!=null)
			  {
		  if(document.getElementById("PriviousYear").checked)
			  {
			  PriviousYear  =document.getElementById("PriviousYear").value;
			
			  }
			  }
			  
		  misc = document.getElementById('misc').value;
		
		
		 grant = document.getElementById('grant').value;
		 stamp = document.getElementById('stamp').value;
		 closingFD = document.getElementById('closingFD').value;
		 
		 InterestFD = document.getElementById('InterestFD').value;
		 WFsalDeduction = document.getElementById('WFsalDeduction').value;
		 seniorAdvFee = document.getElementById('seniorAdvFee').value;
		 subscriptionFee = document.getElementById('subscriptionFee').value;
		 
		 donation = document.getElementById('donation').value;
		 
		 wfCost = document.getElementById('wfCost').value;
		 
		
		 
		 
			 KawfSubscriptionForPlender = document.getElementById('KawfSubscriptionForPlender').value;
		 

				 if (document.getElementById("DuplicateCertificate").checked)
					 {
					 
					 
					 DuplicateCertificate = document.getElementById('DuplicateCertificate2').value;
					 }
				 if (document.getElementById("LifeMembershipFee").checked)
				 {
				 
				 
					 LifeMembershipFee = document.getElementById('LifeMembershipFee2').value;
				 }
				 
				 if (document.getElementById("SeniorAdvocateContribution").checked)
				 {
				 
				 
					 SeniorAdvocateContribution = document.getElementById('SeniorAdvocateContribution2').value;
				 }
			 if (document.getElementById("ChangeofNominee").checked)
			 {
			 
			 
				 ChangeofNominee = document.getElementById('ChangeofNominee2').value;
			 } 
			 
		
	
	
	
	
	 /* document.getElementById("Name").value="Arun";
	 document.getElementById("Place").value="Bangalore"; */
	 var WhichFunctionToHandle= "GetTotalKAWFfeetotal";
	  $.get('AjaxServlet',{ThisYear:ThisYear,PriviousYear:PriviousYear,KawfSubscriptionForPlender:KawfSubscriptionForPlender,misc:misc,grant:grant,LifeMembershipFee:LifeMembershipFee,stamp:stamp,closingFD:closingFD,InterestFD:InterestFD,WFsalDeduction:WFsalDeduction,seniorAdvFee:seniorAdvFee,subscriptionFee:subscriptionFee,donation:donation,wfCost:wfCost,DuplicateCertificate:DuplicateCertificate,ChangeofNominee:ChangeofNominee,SeniorAdvocateContribution:SeniorAdvocateContribution,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) { 
		 var str = responseText;
		 
		 
		   var total=document.getElementById("TotalValue").value;
		 
		    if (total==Number(str))
			   {
		    	document.getElementById("TotalResult").innerHTML="";
			  
			   }
		   else
			   {
			   document.getElementById("TotalResult").innerHTML="<b>Not Matching Please Check it again</b>";
			  
			   }
	
		 
		  
		  
			                           
			                    });
	
}
</script>
