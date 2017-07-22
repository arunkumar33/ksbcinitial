
    
    <h3>Hi.. You can Generate late advocate Report Here</h3>
<br/>
<h3>Both Start and End Dates are mandatory.</h3>
<br/> <br/>
<form>
<label>Select Place Of Practice</label>
<select name="PlaceOfPractice" class="form-control selectpicker"  id="PlaceOfPractice">
      <option>All</option>
      
     <option>Bengaluru Urban</option>
      <option>Bengaluru Rural</option>
      <option >Bagalkot</option>
      <option >Bellary</option>
      <option >Bidar</option>
      <option >Belgaum</option>
      <option >Chamarajanagar</option>
      <option >Chikkamagaluru</option>
      <option >Chikkaballapur</option>
      <option> Chitradurga</option>
      <option >Davanagere</option>
      <option >Kolar</option>
      <option >Ramanagara</option>
      <option >Shivamogga</option>
      <option >Tumkur</option>
      <option >Vijayapura</option>
      <option>Dharwad</option>
      <option >Gadag</option>
      <option >Haveri</option>
      <option>Uttara Kannada</option>
      <option >Kalaburagi</option>
      <option> Koppal</option>
      <option >Raichur</option>
      <option >Yadgir</option>
      <option>Dakshina Kannada</option>
      <option>Hassan</option>
      <option>Kodagu</option>
      <option>Mandya</option>
      <option>Mysuru</option>
     <option>Udupi</option>
    </select>
    <br/> <br/>
<label>Start Date</label>
<input type="date" name="StartDate" id="StartDate" />
<br/> <br/>

<label>End Date</label>
<input type="date" name="EndDate" id="EndDate" />
<input type="hidden" value="AdmissionReport" name="AdmissionReport" id="WhichFunctionToHandle">
<br/> <br/>
<label>Select Cast Category</label>
<select name="CastCategory" class="form-control selectpicker"  id="CastCategory">
      <option >All</option>
      <option>General</option>
      <option>SC ST</option>
      
    </select>
  
  
  <br/> <br/>
<label>Select Gender</label>
<select name="GenderCategory" class="form-control selectpicker"  id="GenderCategory">
      <option >All</option>
      <option>Male</option>
      <option>Female</option>
      
    </select>
     
    <br/> <br/>
<button type="button" id="LifeTimeMembershipReportButton" class="btn btn-info">Get Me Report</button>


</form>



<script>
                                  
	                $('#LifeTimeMembershipReportButton').click(function(event) { 
	alert ("LifeTimeMembershipReportButton part");
		                    var StartDate=$('#StartDate').val(); 
		alert(StartDate);
		 var EndDate=$('#EndDate').val();
		alert(EndDate);
		var PlaceOfPractice=$('#PlaceOfPractice').val();
		alert(PlaceOfPractice);
		var WhichFunctionToHandle=$('#WhichFunctionToHandle').val();
		alert(WhichFunctionToHandle);
		var CastCategory=$('#CastCategory').val();
		alert(CastCategory);
		var GenderCategory=$('#GenderCategory').val();
		alert(GenderCategory);
		
		                 $.get('AjaxServlet',{GenderCategory:GenderCategory,CastCategory:CastCategory,PlaceOfPractice:PlaceOfPractice,EndDate:EndDate,WhichFunctionToHandle:WhichFunctionToHandle,StartDate:StartDate},function(responseText) { 
		                        $('#Main_Content1').html(responseText);         
		                    });
		                });
		           
        </script>