
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
<div onload="myFunction()">
<form action="StampSectionIndividual" method="post">
	<table>
<tr>
    <td>KAR Number</td>
    <td><input type="text" name="KARNumber" id="KARNumber" onblur=" GetEnrollmentDetailsForCashSection()"></td>
  </tr>
	
<tr>
    <td>Name</td>
    <td><input type="text" name="name" id="Name"></td>
  </tr>
  
   <tr>
    <td>Place</td>
    <td><input type="text" name="place" id="Place"></td>
  </tr>
		<tr></tr>
		<!-- This is the main element -->
		<tr>
			<th>Item Name</th>
			<th>Amount</th>
		</tr>

		<!-- Contents are below -->


		<!-- <tr>
			<td>Name</td>
			<td><input type="text" name="NameOfAssociation"
				placeholder="Please enter Association name"></td>
		</tr>

		<tr>
			<td>Place</td>
			<td><input type="text" name="PlaceOfAssociation"
				placeholder="Please enter Association Place"></td>
		</tr> -->


		<!-- <tr>
			<td>Stamp Fee</td>
			<td><input type="checkbox" name="Stampfee" id="Stampfee"
				value="00"> <input type="number" name="Stampfee2"
				id="Stampfee2" value="00"
				onblur="ChangetheValueofCheckList('Stampfee2','Stampfee')"></td>
		</tr> -->
		<tr>
			<td>Discount Option</td>
			<td>
		
		<select name="BeforeDiscount" class="form-control selectpicker"  id="BeforeDiscount">
      <option >Before</option>
      <option>After</option>
     
      
    </select>
		</td>	
		
		</tr>
		<tr>
		<td>Stamp Fee</td>
		<td>
		<select name="StampFee" id="StampFee">
		
		<option value="5">Rs.5/-</option>
		<option value="10">Rs.10/-</option>
		</select>
		</td>
		</tr>

		<tr>
			<td>Postal Charges</td>
			<td><input type="checkbox" name="PostalCharges"
				id="PostalCharges" value="00"> <input type="number"
				name="PostalCharges2" id="PostalCharges2" value="00"
				onblur="ChangetheValueofCheckList('PostalCharges2','PostalCharges')"></td>

		</tr>
		
		<tr>
<td>Receipt Number</td>
<td>
<input type="number" name="RecepitNumber" id="RecepitNumber" value="0"  onblur="GetEnrollmentDetailsForCashSection1()"></td>
</tr>
 <!-- <tr>
<td>Net Amount</td>
<td>
<input type="number" name="NetAmount" id="NetAmount" value="0"></td>
</tr> -->


<tr>
<td>Gross Amount</td>
<td>
<input type="number" name="Gross_Amount" id="Gross_Amount" value="0"></td>
</tr>
<tr>
<td>Total Amount</td>
<td>
<input type="number" name="Total_Amount" id="Total_Amount" value="0">
</td>
</tr>
<tr>
<td>Total No. of Stamps</td>
<td>
<input type="text" name="Total_Stamp" id="Total_Stamp" value="0">
</td>
</tr>
<tr>
<td>Remarks</td>
<td><textarea name="remarks" rows="4" cols="50"></textarea></td>
</tr>
	</table>
	<br> <br>




	<br />


	<!-- <table>
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
			<td><input type="text" name="DDNumber" id="DDNumber"></td>
		</tr>

		<tr>
			<td>D.D Date</td>
			<td><input type="date" name="DDDate" id="DDDate"></td>
		</tr>
		<br>
		<tr>
			<td></td>
			<td>Total<input type="checkbox" name="Total" id="Total"
				onchange=" findTotal()"> <input type="text"
				name="tataldisplay" id="tataldisplay">
			</td>
		<tr>
	</table> -->


	<br /> <input type="submit" class="btn btn-info" value="Submit"><br>
	<br />
</form>

</div>
<script>
function myFunction() {
    alert("Page is loaded");
}
</script>
<script>
	function GetEnrollmentDetailsForCashSection() {
		var KARNumber = document.getElementById("KARNumber").value;

		/* document.getElementById("Name").value="Arun";
		document.getElementById("Place").value="Bangalore"; */
		var WhichFunctionToHandle = "GetEnrollmentDetailsForCashSection";
		$.get('AjaxServlet', {
			KARNumber : KARNumber,
			WhichFunctionToHandle : WhichFunctionToHandle
		}, function(responseText) {

			var str = responseText;
			var res = str.split(",");
			document.getElementById("Name").value = res[0];
			document.getElementById("Place").value = res[1];

		});
		alert(KARNumber);
	}
</script>



<script>
	function findTotal() {

		if (document.getElementById("Total").checked) {

			//  var i = $(BCISubscription).val()); 
			var Stampfee = 0;
			var PostalCharges = 0;
			if (document.getElementById("Stampfee").checked) {

				Stampfee = document.getElementById('Stampfee2').value;
			}
			if (document.getElementById("PostalCharges").checked) {

				PostalCharges = document.getElementById('PostalCharges2').value;
			}

		}

		else {

			//  var i = $(BCISubscription).val()); 
			var Stampfee = 0;
			var PostalCharges = 0;

		}

		/* document.getElementById("Name").value="Arun";
		document.getElementById("Place").value="Bangalore"; */
		var WhichFunctionToHandle = "GetTotalForAssociate";
		$.get('AjaxServlet', {
			PostalCharges : PostalCharges,
			Stampfee : Stampfee,
			WhichFunctionToHandle : WhichFunctionToHandle
		}, function(responseText) {
			var str = responseText;
			/*  var res = str.split(","); */
			document.getElementById("tataldisplay").value = str;
			/* 	    document.getElementById("Place").value = res[1]; */

		});

		/* 
		 */
		/*   var tot=BCISubscription+FDS+FDSClosingFD+BCIClosingFD+BCIInterestonFD+BCIReimbursment+CostReceipt+FDSDiffAmt+BCISubscriptionLateFee;
		 alert(tot);   */
	}
</script>
<script>
	function ChangetheValueofCheckList(From, To) {
		// alert (From);
		/*  document.getElementById("Place").value */
		//	alert(document.getElementById(From).value);
		var tmp = document.getElementById(From).value;
		document.getElementById(To).value = tmp;
		// alert(document.getElementById(To).value);
	}
</script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<script>
             function GetEnrollmentDetailsForCashSection1()
{
	// alert ('From');
	/*  document.getElementById("Place").value */
//	alert(document.getElementById(From).value);
	
	 var WhichFunctionToHandle= "StampSectionAssociation";
	
 var RecepitNumber = document.getElementById("RecepitNumber").value;
 var PostalCharges = document.getElementById("PostalCharges").value;
 
 
 var StampFee = document.getElementById("StampFee").value;
 var BeforeDiscount = document.getElementById("BeforeDiscount").value;
 
 // alert(document.getElementById(To).value);
	
	$.get('AjaxServlet',{StampFee:StampFee,BeforeDiscount:BeforeDiscount,PostalCharges:PostalCharges,RecepitNumber:RecepitNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) { 
		  
		var StringArry=responseText.split("div");
		
		alert(StringArry);
document.getElementById("Gross_Amount").value=	StringArry[1];
		

		document.getElementById("Total_Amount").value=	StringArry[2];
		
		document.getElementById("Total_Stamp").value=	StringArry[3];
		document.getElementById("KARNumber").value=	StringArry[4];
		document.getElementById("Name").value=	StringArry[5];
		document.getElementById("Place").value=	StringArry[6];
	/* 	document.getElementById("first_name").value=	StringArry[0];
		
		document.getElementById("Father_name").value=	StringArry[1];
		
		document.getElementById("email").value=	StringArry[2];
		 	
		document.getElementById("address").value=	StringArry[3];
		
		document.getElementById("phone").value=	StringArry[4];
		
		document.getElementById("city").value=	StringArry[5];
		document.getElementById("myImg").src=StringArry[7];
		document.getElementById("Remarks").innerHTML=StringArry[8];
		document.getElementById("University_Name").value=	StringArry[10];
		document.getElementById("College").value=	StringArry[11];
		document.getElementById("year_of_Completion").value=	StringArry[12];
		
		
		document.getElementById("PreviousApplicationDetails").value=	StringArry[16];
		document.getElementById("PendingCriminalCases").value=	StringArry[20];
		document.getElementById("convictedDetails").value=	StringArry[19];
		
		document.getElementById("BusinessDetails").value=	StringArry[14];
		document.getElementById("OtherProfessional").value=	StringArry[17];
		
		document.getElementById("Permenent").value=	StringArry[18];
		 */
		 // $("#GenderCategory").val(StringArry[6]);
		                              
			                    });
	
	}
        </script>

