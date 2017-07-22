<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>


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

 <%
  System.out.println(session.getAttribute("UserName"));
  
  String name=(String)session.getAttribute("UserName");
  session.setAttribute("UserName", name);
  %>
<form action="IndividualStamp" method="post" onkeypress="return event.keyCode != 13;">
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
    <td>Stamp Fee</td>  
    <td><input type="checkbox" name="Stampfee" id="Stampfee" value="00">
  <input type="number" name="Stampfee2" id="Stampfee2" value="00" onblur="ChangetheValueofCheckList('Stampfee2','Stampfee')"></td>
  </tr>
  
  <!-- <tr>
  <td> Postal Charges</td>
  <td><input type="number" name="PostalCharges" value="00"></td>
  
  </tr> -->
   </table><br>
   
   

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

function ChangetheValueofCheckList(From,To)
{
	var tmp=document.getElementById(From).value;
	document.getElementById(To).value=tmp;
	}

</script>
<script>

function findTotal()
{

	
	

		 
			//  var i = $(BCISubscription).val()); 
			var Stampfee = 0;
			
			 if (document.getElementById("Stampfee").checked)
				 {
				 
				 
				 Stampfee = document.getElementById('Stampfee2').value;
				 }
			
		
			
			 
		
		
	

	var str = Stampfee;
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
	 
	 
		   
	
		 
		  
		  
			                           
			                
	
	/* 
	 */
/*   var tot=BCISubscription+FDS+FDSClosingFD+BCIClosingFD+BCIInterestonFD+BCIReimbursment+CostReceipt+FDSDiffAmt+BCISubscriptionLateFee;
	 alert(tot);   */
	}
</script>

</html>

























<!-- 

<body>

<input type="radio" onclick="javascript:Check();" name="individual" id="individual"/>
<input type="radio" onclick="javascript:Check();" name="association" id="association"/>
<br>


<div id="individual" >

  <input type='text' id='yes' name='yes'/>
    <br>What can we do to accommodate you?
        <input type='text' id='acc' name='acc'/>
</div>
   other 3
<input type='text' id='other3' name='other3'>
<br>
    other 4
<input type='text' id='other4' name='other4'>
<br>







</body>



<script type="text/javascript">

function Check() {
    if (document.getElementById('individual').checked) {
        document.getElementById('individual').style.display = 'block';
    } else if
        (document.getElementById('association').cheked){
    	document.getElementById('association').style.display = 'block';
    }}

</script>
</html> -->
