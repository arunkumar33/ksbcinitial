<!--  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    Font Awesome
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
       <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
     <script src="http://code.jquery.com/jquery-latest.js"></script>
 -->

<div>District Names:
<select id="districts" name="districts" onchange="return showBarAssociations();">
 <option value="BANGALORE DISTRICT">BANGALORE DISTRICT  </option> 
<option value="BAGALKOT">BAGALKOT </option>
<option value="BELAGAUM">BELAGAUM </option>
<option value="BELLARY">BELLARY </option>
<option value="BIDAR">BIDAR</option>
 <option value="BIJAPUR">BIJAPUR </option>
 <option value="CHAMARAJNAGAR">CHAMARAJNAGAR </option>
<option value="CHIKKAMAGALUR">CHIKKAMAGALUR </option>
<option value="CHITRADURGA"> CHITRADURGA</option>
 <option value="DAVANGERE">DAVANGERE </option>
<option value="COORG "> COORG</option>
<option value="DHARWAD">DHARWAD </option>
<option value="GADAG"> GADAG</option>
<option value="GULBARGA">GULBARGA </option>
  <option value="HASSAN">HASSAN </option>
 <option value="HAVERI">HAVERI </option>
 <option value="KOLAR"> KOLAR</option>
 <option value="KOPPAL">KOPPAL </option>
<option value="MANDYA"> MANDYA</option>
<option value="MANGALORE">MANGALORE </option>
 <option value="MYSORE">MYSORE </option>
 <option value="NORTH KARNATAKA DIST.">NORTH KARNATAKA DIST. </option>
<option value="RAMANAGAR">RAMANAGAR </option>
<option value="RAICHUR">RAICHUR </option>
 <option value="SHIMOGA">SHIMOGA </option>
  <option value="TUMKUR"> TUMKUR</option>
 <option value="UDUPI"> UDUPI</option>
<option value="YADGIRI">YADGIRI </option>  
</select>
 </div>
<div id="StampResult"></div>
<%-- <div id="BANGALORE DISTRICT" style="visibility: hidden;">

<select>
 <option value="BENGALURU BAR ASSOCIATION">BENGALURU BAR ASSOCIATION</option>
    <option value="BENGALURU ADV CO-OPERATIVE SOCIETY">BENGALURU  ADV CO-OPERATIVE SOCIETY</option>
    <option value="ANEKAL BAR ASSOCIATION">ANEKAL BAR ASSOCIATION</option>
    <option value="DEVANAHALLI BAR ASSOCIATION">DEVANAHALLI BAR ASSOCIATION</option>
    <option value="DODDABALLAPUR BAR ASSOCIATION">DODDABALLAPUR BAR ASSOCIATION</option>
    <option value="HOSAKOTE BAR ASSOCIATION">HOSAKOTE BAR ASSOCIATION</option>
    <option value="NELAMANGALA BAR ASSOCIATION">NELAMANGALA BAR ASSOCIATION</option>

</select>
</div>  

<div id="BAGALKOT" style="visibility: hidden;">

<select>
 <option value="BAGALKOT BAR ASSOCIATION">BAGALKOT BAR ASSOCIATION</option>
      <option value="BAGALKOT ADV CO-OPERATIVE SOCIETY">BAGALKOT  ADV CO-OPERATIVE SOCIETY</option>
    <option value="BADAMI BAR ASSOCIATION">BADAMI BAR ASSOCIATION</option>
    <option value="BANAHATTI BAR ASSOCIATION">BANAHATTI BAR ASSOCIATION</option>
    <option value="BILIGI BAR ASSOCIATION">BILIGI BAR ASSOCIATION</option>
     <option value="GULEDAGUDDA BAR ASSOCIATION">GULEDAGUDDA BAR ASSOCIATION</option>
    <option value="HUNGUND BAR ASSOCIATION ">HUNGUND BAR ASSOCIATION </option>
    <option value="ILKAL BAR ASSOCIATION">ILKAL BAR ASSOCIATION</option>
    
    <option value="JAMAKHANDI BAR ASSOCIATION">JAMAKHANDI BAR ASSOCIATION</option>
   
    <option value="MUDHOL BAR ASSOCIATION">MUDHOL BAR ASSOCIATION</option>
   

</select>
</div>  


  
<div id="BELAGAUM" style="visibility: hidden;">

<select>

  <option value="BELAGAUM BAR ASSOCIATION">BELAGAUM BAR ASSOCIATION</option>
        <option value="BELAGAUM ADV CO-OPERATIVE SOCIETY">BELAGAUM  ADV CO-OPERATIVE SOCIETY</option>
   
   
     <option value="ATHANI BAR ASSOCIATION">ATHANI BAR ASSOCIATION</option>
    <option value="BELGAUM CITY BAR ASSOCIATION">BELGAUM CITY BAR ASSOCIATION</option>
  
    <option value="BAILAHONGAL BAR ASSOCIATION">BAILAHONGAL BAR ASSOCIATION</option>
     <option value="CHIKODI BAR ASSOCIATION">CHIKODI BAR ASSOCIATION</option>
    <option value="GOKAK BAR ASSOCIATION">GOKAK BAR ASSOCIATION</option>
    <option value="HUKKERI BAR ASSOCIATION">HUKKERI BAR ASSOCIATION</option>
    
    <option value="KHANAPUR BAR ASSOCIATION">KHANAPUR BAR ASSOCIATION</option>
   
    <option value="KITTUR, Bailhongal TQ BAR ASSOCIATION">KITTUR, Bailhongal TQ BAR ASSOCIATION</option>
    <option value="RAMADURGA BAR ASSOCIATION">RAMADURGA BAR ASSOCIATION</option>
       <option value="RAIBAG BAR ASSOCIATION">RAIBAG BAR ASSOCIATION</option>
   
       <option value="SANKESHWAR BAR ASSOCIATION">SANKESHWAR BAR ASSOCIATION</option>
   
       <option value="SAUNDATTI BAR ASSOCIATION">SAUNDATTI BAR ASSOCIATION</option>
   
       <option value="MUDALAGI BAR ASSOCIATION">MUDALAGI BAR ASSOCIATION</option>

</select>
</div>  

<div id="BELLARY" style="visibility: hidden;">

<select>

 <option value="BELLARY  BAR ASSOCIATION">BELLARY  BAR ASSOCIATION</option>

     <option value="BELLARY ADV CO-OPERATIVE SOCIETY">BELLARY  ADV CO-OPERATIVE SOCIETY</option>
    <option value="HADAGLI CITY BAR ASSOCIATION">HADAGLI CITY BAR ASSOCIATION</option>
  
    <option value="HAGARAI BOMMANAHAHALLI BAR ASSOCIATION">HAGARAI BOMMANAHAHALLI BAR ASSOCIATION</option>
     <option value="HOSPET BAR ASSOCIATION">HOSPET BAR ASSOCIATION</option>
    <option value="KUDLIGI BAR ASSOCIATION">KUDLIGI BAR ASSOCIATION </option>
    <option value="SANDUR BAR ASSOCIATION">SANDUR BAR ASSOCIATION</option>
    
    <option value="SIRUGUPPA BAR ASSOCIATION">SIRUGUPPA BAR ASSOCIATION</option>

</select>
</div>  

<div id="BIDAR" style="visibility: hidden;">

<select>
  <option value="BIDAR BAR ASSOCIATION">BIDAR BAR ASSOCIATION</option>
     <option value="BIDAR ADV CO-OPERATIVE SOCIETY">BIDAR ADV CO-OPERATIVE SOCIETY</option>
    <option value="AURAD BAR ASSOCIATION">AURAD BAR ASSOCIATION</option>
    <option value="BASAVAKALYAN BAR ASSOCIATION">BASAVAKALYAN BAR ASSOCIATION</option>
     <option value="BHALKI BAR ASSOCIATION">BHALKI BAR ASSOCIATION</option>
    <option value="HUMNABAD BAR ASSOCIATION ">HUMNABAD BAR ASSOCIATION </option>
   

</select>
</div>  

<div id="BIJAPUR" style="visibility: hidden;">

<select>
 <option value="BIJAPUR BAR ASSOCIATION">BIJAPUR BAR ASSOCIATION</option>
      <option value="BIJAPUR ADV CO-OPERATIVE SOCIETY">BIJAPUR ADV CO-OPERATIVE SOCIETY</option>
    <option value="BASAVAN BAGEWADI BAR ASSOCIATION">BASAVAN BAGEWADI BAR ASSOCIATION</option>
    <option value="INDI BAR ASSOCIATION">INDI BAR ASSOCIATION</option>
     <option value="MUDDEBIHA BAR ASSOCIATION">MUDDEBIHA BAR ASSOCIATION</option>
    <option value="SINDAGI BAR ASSOCIATION">SINDAGI BAR ASSOCIATION</option>
   

</select>
</div>  

<div id="CHAMARAJNAGAR" style="visibility: hidden;">

<select>

 <option value="CHAMARAJNAGAR BAR ASSOCIATION">CHAMARAJNAGAR BAR ASSOCIATION</option>
         <option value="CHAMARAJNAGAR ADV CO-OPERATIVE SOCIETY">CHAMARAJNAGAR ADV CO-OPERATIVE SOCIETY</option>
    <option value="GUNDLUPET BAR ASSOCIATION">GUNDLUPET BAR ASSOCIATION</option>
    <option value="KOLLEGAL BAR ASSOCIATION">KOLLEGAL BAR ASSOCIATION</option>
     <option value="YELANDUR BAR ASSOCIATION">YELANDUR BAR ASSOCIATION</option>

</select>
</div>  

<div id="CHIKKAMAGALUR" style="visibility: hidden;">

<select>
 <option value="CHIKKAMAGALUR BAR ASSOCIATION">CHIKKAMAGALUR BAR ASSOCIATION</option>
          <option value="CHIKKAMAGALUR ADV CO-OPERATIVE SOCIETY">CHIKKAMAGALUR ADV CO-OPERATIVE SOCIETY</option>
    <option value="KADUR BAR ASSOCIATION">KADUR BAR ASSOCIATION</option>
    <option value="KOPPA BAR ASSOCIATION">KOPPA BAR ASSOCIATION</option>
     <option value="MUDIGERE BAR ASSOCIATION">MUDIGERE BAR ASSOCIATION</option>
    <option value="N.R.PURA BAR ASSOCIATION">N R PURA BAR ASSOCIATION</option>
   <option value="SRINGERI BAR ASSOCIATION">SRINGERI BAR ASSOCIATION</option>
   <option value="TARIKERE BAR ASSOCIATION">TARIKERE BAR ASSOCIATION</option>

</select>
</div>  

<div id="CHITRADURGA" style="visibility: hidden;">

<select>
 <option value="CHITRADURGA BAR ASSOCIATION">CHITRADURGA BAR ASSOCIATION</option>
        <option value="CHITRADURGA ADV CO-OPERATIVE SOCIETY">CHITRADURGA ADV CO-OPERATIVE SOCIETY</option>
    <option value="CHALLAKERE BAR ASSOCIATION">CHALLAKERE BAR ASSOCIATION</option>
    <option value="HIRIYUR BAR ASSOCIATION">HIRIYUR BAR ASSOCIATION</option>
     <option value="HOLALKERE BAR ASSOCIATION">HOLALKERE BAR ASSOCIATION</option>
    <option value="HOSADURGA BAR ASSOCIATION">HOSADURGA BAR ASSOCIATION</option>
   <option value="MOLAKALMURU BAR ASSOCIATION">MOLAKALMURU BAR ASSOCIATION </option>
   

</select>
</div>  

<div id="DAVANGERE" style="visibility: hidden;">

<select>

 <option value="DAVANGERE BAR ASSOCIATION">DAVANGERE BAR ASSOCIATION</option>
     <option value="DAVANGERE ADV CO-OPERATIVE SOCIETY">DAVANGERE ADV CO-OPERATIVE SOCIETY</option>

    <option value="CHANNAGIRI BAR ASSOCIATION">CHANNAGIRI BAR ASSOCIATION</option>
    <option value="HARAPANAHALLI BAR ASSOCIATION">HARAPANAHALLI BAR ASSOCIATION</option>
     <option value="HARIHAR BAR ASSOCIATIONBAR ASSOCIATION">HARIHAR BAR ASSOCIATIONBAR ASSOCIATION</option>
    <option value="HAONNALI BAR ASSOCIATION">HAONNALI BAR ASSOCIATION</option>
   <option value="JAGALUR BAR ASSOCIATION">JAGALUR BAR ASSOCIATION </option>
   
</select>
</div>  

<div id="COORG" style="visibility: hidden;">

<select>

<option value="MADIKERI BAR ASSOCIATION">MADIKERI BAR ASSOCIATION</option>
   <option value="MADIKERI ADV CO-OPERATIVE SOCIETY">MADIKERI ADV CO-OPERATIVE SOCIETY</option>
     <option value="MADIKERI BAR ASSOCIATION">MADIKERI BAR ASSOCIATION</option>
    <option value="POONAMPET BAR ASSOCIATION">POONAMPET BAR ASSOCIATION</option>
    <option value="SOMWARPET BAR ASSOCIATION">SOMWARPET BAR ASSOCIATION</option>
     <option value="VIRAJPET BAR ASSOCIATION">VIRAJPET BAR ASSOCIATION</option>
    <option value="KUSHALNAGAR BAR ASSOCIATION ">KUSHALNAGAR BAR ASSOCIATION </option>
   
</select>
</div>  

<div id="DHARWAD" style="visibility: hidden;">

<select>
 <option value="DHARWAD BAR ASSOCIATION">DHARWAD BAR ASSOCIATION</option>
          <option value="DHARWAD ADV CO-OPERATIVE SOCIETY">DHARWAD ADV CO-OPERATIVE SOCIETY</option>
    <option value="Belur Industrial Estate BAR ASSOCIATION">Belur Industrial Estate BAR ASSOCIATION</option>
    <option value="HUBLI BAR ASSOCIATION">HUBLI BAR ASSOCIATION</option>
     <option value="KALAGHATAGI BAR ASSOCIATION">KALAGHATAGI BAR ASSOCIATION</option>
    <option value="KUNDAGOL BAR ASSOCIATION">KUNDAGOL BAR ASSOCIATION</option>
   <option value="NAVALGUND BAR ASSOCIATION">NAVALGUND BAR ASSOCIATION</option>
   

</select>
</div>  

<div id="GADAG" style="visibility: hidden;">

<select>
 <option value="GADAG BAR ASSOCIATION">GADAG BAR ASSOCIATION</option>
      <option value="GADAG ADV CO-OPERATIVE SOCIETY">GADAG ADV CO-OPERATIVE SOCIETY</option>
    <option value="LAXMESHWAR BAR ASSOCIATION">LAXMESHWAR BAR ASSOCIATION</option>
    <option value="MUNDARGI BAR ASSOCIATION">MUNDARGI BAR ASSOCIATION</option>
     <option value="NARGUND BAR ASSOCIATION">NARGUND BAR ASSOCIATION</option>
    <option value="RON BAR ASSOCIATION">RON BAR ASSOCIATION</option>
  

</select>
</div>  

<div id="GULBARGA" style="visibility: hidden;">

<select>
 <option value="GULBARGA BAR ASSOCIATION">GULBARGA BAR ASSOCIATION</option>
     <option value="GULBARGA ADV CO-OPERATIVE SOCIETY">GULBARGA ADV CO-OPERATIVE SOCIETY</option>

    <option value="ALAND BAR ASSOCIATION">ALAND BAR ASSOCIATION</option>
    <option value="CHINCHOLLI BAR ASSOCIATION">CHINCHOLLI BAR ASSOCIATION</option>
     <option value="CHITTAPUR BAR ASSOCIATION">CHITTAPUR BAR ASSOCIATION</option>
    <option value="JEWARGI BAR ASSOCIATION">JEWARGI BAR ASSOCIATION</option>
   <option value="SEDAM BAR ASSOCIATION">SEDAM BAR ASSOCIATION</option>
   
   <option value="SHAHABAD BAR ASSOCIATION">SHAHABAD BAR ASSOCIATION</option>


</select>
</div>  

<div id="HASSAN" style="visibility: hidden;">

<select>
 <option value="HASSAN  BAR ASSOCIATION">HASSAN  BAR ASSOCIATION</option>
     <option value="HASSAN ADV CO-OPERATIVE SOCIETY">HASSAN ADV CO-OPERATIVE SOCIETY</option>

    <option value="ALUR BAR ASSOCIATION">ALUR BAR ASSOCIATION</option>
    <option value="ARAKALGUD BAR ASSOCIATION">ARAKALGUD BAR ASSOCIATION</option>
     <option value="ARASIKERE BAR ASSOCIATION">ARASIKERE BAR ASSOCIATION</option>
    <option value="BELUR BAR ASSOCIATION">BELUR BAR ASSOCIATION </option>
   <option value="CHANNARAYAPATNA BAR ASSOCIATION">CHANNARAYAPATNA BAR ASSOCIATION</option>
  <option value="HOLENARASIPUR BAR ASSOCIATION ">HOLENARASIPUR BAR ASSOCIATION </option>
   <option value="SAKALESHPUR BAR ASSOCIATION">SAKALESHPUR BAR ASSOCIATION</option>
  

</select>
</div>  

<div id="HAVERI" style="visibility: hidden;">

<select>
<option value="HAVERI BAR ASSOCIATION">HAVERI BAR ASSOCIATION</option>
     <option value="HAVERI ADV CO-OPERATIVE SOCIETY">HAVERI ADV CO-OPERATIVE SOCIETY</option>
    <option value="BYADGI BAR ASSOCIATION">BYADGI BAR ASSOCIATION</option>
    <option value="HANAGAL BAR ASSOCIATION">HANAGAL BAR ASSOCIATION</option>
     <option value="HIREKERURU BAR ASSOCIATION">HIREKERURU BAR ASSOCIATION</option>
    <option value="RANEBENNUR BAR ASSOCIATION">RANEBENNUR BAR ASSOCIATION</option>
   <option value="SAVNUR BAR ASSOCIATION">SAVNUR BAR ASSOCIATION</option>
  <option value="SHIGGAON BAR ASSOCIATION">SHIGGAON BAR ASSOCIATION</option>
 

</select>
</div>  

<div id="KOLAR" style="visibility: hidden;">

<select>

<option value="KOLAR BAR ASSOCIATION">KOLAR BAR ASSOCIATION</option>
      <option value="KOLAR ADV CO-OPERATIVE SOCIETY">KOLAR ADV CO-OPERATIVE SOCIETY</option>
    <option value="BANGARPET BAR ASSOCIATION">BANGARPET BAR ASSOCIATION</option>
    <option value="OORGAUM , K.G.F BAR ASSOCIATION">OORGAUM , K.G.F BAR ASSOCIATION</option>
     <option value="MALUR BAR ASSOCIATION">MALUR BAR ASSOCIATION</option>
    <option value="MULBAGAL BAR ASSOCIATION">MULBAGAL BAR ASSOCIATION</option>
   <option value="SRINIVASAPUR BAR ASSOCIATION">SRINIVASAPUR BAR ASSOCIATION</option>
  
</select>
</div>  

<div id="KOPPAL" style="visibility: hidden;">

<select>
 <option value="KOPPAL BAR ASSOCIATION">KOPPAL BAR ASSOCIATION</option>
     <option value="KOPPAL ADV CO-OPERATIVE SOCIETY">KOPPAL ADV CO-OPERATIVE SOCIETY</option>
    <option value="GANGAVATHI BAR ASSOCIATION">GANGAVATHI BAR ASSOCIATION</option>
    <option value="KUSHTAGI BAR ASSOCIATION">KUSHTAGI BAR ASSOCIATION</option>
     <option value="YELBURGA BAR ASSOCIATION">YELBURGA BAR ASSOCIATION</option>
    

</select>
</div>  

<div id="MANDYA" style="visibility: hidden;">

<select>
 <option value="MANDYA BAR ASSOCIATIONdi">MANDYA BAR ASSOCIATION</option>
         <option value="MANDYA ADV CO-OPERATIVE SOCIETY">MANDYA ADV CO-OPERATIVE SOCIETY</option>
    <option value="K R PET BAR ASSOCIATION">K R PET BAR ASSOCIATION</option>
    <option value="MADDUR BAR ASSOCIATION">MADDUR BAR ASSOCIATION</option>
     <option value="MALAVALLI BAR ASSOCIATION">MALAVALLI BAR ASSOCIATION</option>
    <option value="NAGAMANGALA BAR ASSOCIATION">NAGAMANGALA BAR ASSOCIATION</option>
   <option value="PANDVAPURA BAR ASSOCIATION">PANDVAPURA BAR ASSOCIATION</option>
   <option value="SRIRANGAPATNA BAR ASSOCIATION">SRIRANGAPATNA BAR ASSOCIATION</option>


</select>
</div>  

<div id="MANGALORE" style="visibility: hidden;">

<select>
 <option value="MANGALORE BAR ASSOCIATION">MANGALORE BAR ASSOCIATION</option>
         <option value="MANGALORE ADV CO-OPERATIVE SOCIETY">MANGALORE ADV CO-OPERATIVE SOCIETY</option>
    <option value="BANTWAL BAR ASSOCIATION">BANTWAL BAR ASSOCIATION</option>
    <option value="BELTHANGADY BAR ASSOCIATION">BELTHANGADY BAR ASSOCIATION</option>
     <option value="MOODBIDARI BAR ASSOCIATION">MOODBIDARI BAR ASSOCIATION</option>
    <option value="PUTTUR BAR ASSOCIATION ">PUTTUR BAR ASSOCIATION </option>
   <option value="SULLIA BAR ASSOCIATION">SULLIA BAR ASSOCIATION </option>
  

</select>
</div>  

<div id="MYSORE" style="visibility: hidden;">

<select>

 <option value="MYSORE BAR ASSOCIATION">MYSORE BAR ASSOCIATION</option>
       <option value="MYSORE ADV CO-OPERATIVE SOCIETY">MYSORE ADV CO-OPERATIVE SOCIETY</option>
    <option value="H D KOTE BAR ASSOCIATION">H D KOTE BAR ASSOCIATION</option>
    <option value="HUNSUR BAR ASSOCIATION">HUNSUR BAR ASSOCIATION</option>
     <option value="K R NAGAR BAR ASSOCIATION">K R NAGAR BAR ASSOCIATION</option>
    <option value="NANJANGUD BAR ASSOCIATION">NANJANGUD BAR ASSOCIATION</option>
   <option value="PERIYAPATNA BAR ASSOCIATION">PERIYAPATNA BAR ASSOCIATION</option>

   <option value="T.NARASIPUR BAR ASSOCIATION">   T.NARASIPUR BAR ASSOCIATION</option>
   
</select>
</div>  

<div id="NORTH KARNATAKA DIST." style="visibility: hidden;">

<select>

 <option value="KARWAR BAR ASSOCIATION">KARWAR BAR ASSOCIATION</option>
    <option value="KARWAR ADV CO-OPERATIVE SOCIETY">KARWAR ADV CO-OPERATIVE SOCIETY</option>
    <option value="ANKOLA BAR ASSOCIATION">ANKOLA BAR ASSOCIATION</option>
     <option value="BHATKAL BAR ASSOCIATION">BHATKAL BAR ASSOCIATION</option>
    <option value="DANDELI BAR ASSOCIATION">DANDELI BAR ASSOCIATION</option>
   <option value="HALIYAL BAR ASSOCIATION">HALIYAL BAR ASSOCIATION</option>

   <option value="HONNAVARA BAR ASSOCIATION">HONNAVARA BAR ASSOCIATION</option>

   <option value="KUMTA BAR ASSOCIATION">KUMTA BAR ASSOCIATION </option>

   <option value="MUNDGOD BAR ASSOCIATION">MUNDGOD BAR ASSOCIATION</option>

   <option value="SIDDAPUR BAR ASSOCIATION">SIDDAPUR BAR ASSOCIATION</option>

   <option value="SIRSI BAR ASSOCIATION">SIRSI BAR ASSOCIATION</option>

   <option value="YELLAPUR BAR ASSOCIATION">YELLAPUR BAR ASSOCIATION</option>

</select>
</div>  

<div id="RAMANAGAR" style="visibility: hidden;">

<select>

 <option value="RAMANAGAR BAR ASSOCIATION">RAMANAGAR BAR ASSOCIATION</option>
    <option value="RAMANAGAR ADV CO-OPERATIVE SOCIETY">RAMANAGAR ADV CO-OPERATIVE SOCIETY</option>
    <option value="KANAKAPURA BAR ASSOCIATION">KANAKAPURA BAR ASSOCIATION</option>
     <option value="MAGADI BAR ASSOCIATION">MAGADI BAR ASSOCIATION</option>
 
</select>
</div>  

<div id="RAICHUR" style="visibility: hidden;">

<select>
 <option value="RAICHUR BAR ASSOCIATION">RAICHUR BAR ASSOCIATION</option>
    <option value="RAICHUR ADV CO-OPERATIVE SOCIETY">RAICHUR ADV CO-OPERATIVE SOCIETY</option>
    <option value="DEODURGA BAR ASSOCIATION">DEODURGA BAR ASSOCIATION</option>
     <option value="LINGSUGUR BAR ASSOCIATION">LINGSUGUR BAR ASSOCIATION</option>
    <option value="MANVI BAR ASSOCIATION">MANVI BAR ASSOCIATION</option>
   <option value="SINDHANOOR BAR ASSOCIATION">SINDHANOOR BAR ASSOCIATION</option>
   

</select>
</div>  

<div id="SHIMOGA" style="visibility: hidden;">

<select>

   <option value="SHIMOGA BAR ASSOCIATION">SHIMOGA BAR ASSOCIATION</option>
    <option value="SHIMOGA ADV CO-OPERATIVE SOCIETY">SHIMOGA ADV CO-OPERATIVE SOCIETY</option>
    <option value="BHADRAVATHI BAR ASSOCIATION">BHADRAVATHI BAR ASSOCIATION</option>
     <option value="HOSANAGAR BAR ASSOCIATION">HOSANAGAR BAR ASSOCIATION</option>
    <option value="SAGAR BAR ASSOCIATION">SAGAR BAR ASSOCIATION</option>
   <option value="SHIKARIPUR BAR ASSOCIATION">SHIKARIPUR BAR ASSOCIATION</option>

   <option value="SORABA BAR ASSOCIATION">SORABA BAR ASSOCIATION</option>
   <option value="THIRTHAHALLI BAR ASSOCIATION ">THIRTHAHALLI BAR ASSOCIATION </option>


</select>
</div>  

<div id="TUMKUR" style="visibility: hidden;">

<select>

  <option value="TUMKUR BAR ASSOCIATION">TUMKUR BAR ASSOCIATION</option>
    <option value="TUMKUR ADV CO-OPERATIVE SOCIETY">TUMKUR ADV CO-OPERATIVE SOCIETY</option>
    <option value="CHIKKANAYAKANA HALLI BAR ASSOCIATION">CHIKKANAYAKANA HALLI BAR ASSOCIATION</option>
     <option value="GUBBI BAR ASSOCIATION">GUBBI BAR ASSOCIATION</option>
    <option value="KORATAGERE BAR ASSOCIATION">KORATAGERE BAR ASSOCIATION</option>
   <option value="KUNIGAL BAR ASSOCIATION">KUNIGAL BAR ASSOCIATION </option>
   <option value="MADHUGIRI BAR ASSOCIATION">MADHUGIRI BAR ASSOCIATION</option>
   <option value="PAVAGADA BAR ASSOCIATION">PAVAGADA BAR ASSOCIATION</option>
   <option value="SIRA BAR ASSOCIATION">SIRA BAR ASSOCIATION</option>
   <option value="TIPTUR BAR ASSOCIATION ">TIPTUR BAR ASSOCIATION </option>
   <option value="TURUVEKERE BAR ASSOCIATION">TURUVEKERE BAR ASSOCIATION</option>

</select>
</div>  

<div id="UDUPI" style="visibility: hidden;">

<select>
 <option value="UDUPI BAR ASSOCIATION">UDUPI BAR ASSOCIATION</option>
    <option value="UDUPI ADV CO-OPERATIVE SOCIETY<">UDUPI ADV CO-OPERATIVE SOCIETY</option>
    <option value="KARKALA BAR ASSOCIATION">KARKALA BAR ASSOCIATION</option>
     <option value="KUNDAPUR BAR ASSOCIATION">KUNDAPUR BAR ASSOCIATION</option>


</select>
</div>  

<div id="YADGIRI" style="visibility: hidden;">

<select>
 <option value="YADGIRI BAR ASSOCIATION">YADGIRI BAR ASSOCIATION</option>
    <option value="YADGIRI ADV CO-OPERATIVE SOCIETY">YADGIRI ADV CO-OPERATIVE SOCIETY</option>
    <option value="SHAHAPUR BAR ASSOCIATION">SHAHAPUR BAR ASSOCIATION</option>
     <option value="SHORAPUR BAR ASSOCIATION">SHORAPUR BAR ASSOCIATION</option>


</select> </div> --%>
 
  </div>

  <script>
  function ChangetheValueofCheckList(From,To)
  {
  	// alert (From);
  	/*  document.getElementById("Place").value */
//  	alert(document.getElementById(From).value);
  	var tmp=document.getElementById(From).value;
  	document.getElementById(To).value=tmp;
  	// alert(document.getElementById(To).value);
  	}

  </script>
  <script>
  function showBarAssociations(){
	  alert("Hi");
  	var selectedDistrict=document.getElementById('districts');
  	alert(selectedDistrict);
  	var selectedDistrictName=selectedDistrict.options[selectedDistrict.selectedIndex].value;
  	alert(selectedDistrictName +'   Name'); 
  	var WhichFunctionToHandle= "StampAssociationLoader";
	 
  	  $.get('AjaxServlet',{selectedDistrict:selectedDistrict,selectedDistrictName:selectedDistrictName,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText)
			 { 
		 var str = responseText;
		 document.getElementById('StampResult').innerHTML=str;
		 
		 alert(str);
	 });
  	
  /* 	switch (selectedDistrictName)
      {
      case "BANGALORE DISTRICT" :if(selectedDistrictName=='BANGALORE DISTRICT'){
  		document.getElementById('BANGALORE DISTRICT').style.visibility='visible';
      }else{
      	document.getElementById('BANGALORE DISTRICT').style.visibility='hidden';
      }
  		break;
  		
      case "BAGALKOT" :if(selectedDistrictName=='BAGALKOT'){
  		document.getElementById('BAGALKOT').style.visibility='visible';
      }else{
      	document.getElementById('BAGALKOT').style.visibility='hidden';
      }
  		break;	
  	
      case "BELAGAUM" :if(selectedDistrictName=='BELAGAUM'){
  		document.getElementById('BELAGAUM').style.visibility='visible';
      }else{
      	document.getElementById('BELAGAUM').style.visibility='hidden';
      }
  		break;	
  		
      case "BELLARY" :if(selectedDistrictName=='BELLARY'){
  		document.getElementById('BELLARY').style.visibility='visible';
      }else{
      	document.getElementById('BELLARY').style.visibility='hidden';
      }
  		break;	
  		
      case "BIDAR" :if(selectedDistrictName=='BIDAR'){
  		document.getElementById('BIDAR').style.visibility='visible';
      }else{
      	document.getElementById('BIDAR').style.visibility='hidden';
      }
  		break;	
  		
      case "BIJAPUR" :if(selectedDistrictName=='BIJAPUR'){
  		document.getElementById('BIJAPUR').style.visibility='visible';
      }else{
      	document.getElementById('BAGALKOT').style.visibility='hidden';
      }
  		break;	
  		
      case "CHAMARAJNAGAR" :if(selectedDistrictName=='CHAMARAJNAGAR'){
  		document.getElementById('CHAMARAJNAGAR').style.visibility='visible';
      }else{
      	document.getElementById('CHAMARAJNAGAR').style.visibility='hidden';
      }
  		break;	
  		
      case "CHIKKAMAGALUR" :if(selectedDistrictName=='CHIKKAMAGALUR'){
  		document.getElementById('CHIKKAMAGALUR').style.visibility='visible';
      }else{
      	document.getElementById('CHIKKAMAGALUR').style.visibility='hidden';
      }
  		break;	
  		
      case "CHITRADURGA" :if(selectedDistrictName=='CHITRADURGA'){
  		document.getElementById('CHITRADURGA').style.visibility='visible';
      }else{
      	document.getElementById('CHITRADURGA').style.visibility='hidden';
      }
  		break;	
  		
      case "DAVANGERE" :if(selectedDistrictName=='DAVANGERE'){
  		document.getElementById('DAVANGERE').style.visibility='visible';
      }else{
      	document.getElementById('DAVANGERE').style.visibility='hidden';
      }
  		break;	
  		
      case "COORG" :if(selectedDistrictName=='COORG'){
  		document.getElementById('COORG').style.visibility='visible';
      }else{
      	document.getElementById('COORG').style.visibility='hidden';
      }
  		break;	
  		
      case "DHARWAD" :if(selectedDistrictName=='DHARWAD'){
  		document.getElementById('DHARWAD').style.visibility='visible';
      }else{
      	document.getElementById('DHARWAD').style.visibility='hidden';
      }
  		break;	
  		
      case "GADAG" :if(selectedDistrictName=='GADAG'){
  		document.getElementById('GADAG').style.visibility='visible';
      }else{
      	document.getElementById('GADAG').style.visibility='hidden';
      }
  		break;	
  		
      case "GULBARGA" :if(selectedDistrictName=='GULBARGA'){
  		document.getElementById('GULBARGA').style.visibility='visible';
      }else{
      	document.getElementById('GULBARGA').style.visibility='hidden';
      }
  		break;	
  		
      case "HASSAN" :if(selectedDistrictName=='HASSAN'){
  		document.getElementById('HASSAN').style.visibility='visible';
      }else{
      	document.getElementById('HASSAN').style.visibility='hidden';
      }
  		break;	
  		
      case "HAVERI" :if(selectedDistrictName=='HAVERI'){
  		document.getElementById('HAVERI').style.visibility='visible';
      }else{
      	document.getElementById('HAVERI').style.visibility='hidden';
      }
  		break;	
  		
      case "KOLAR" :if(selectedDistrictName=='KOLAR'){
  		document.getElementById('KOLAR').style.visibility='visible';
      }else{
      	document.getElementById('KOLAR').style.visibility='hidden';
      }
  		break;	
  		
      case "KOPPAL" :if(selectedDistrictName=='KOPPAL'){
  		document.getElementById('KOPPAL').style.visibility='visible';
      }else{
      	document.getElementById('KOPPAL').style.visibility='hidden';
      }
  		break;	
  		
      case "MANDYA" :if(selectedDistrictName=='MANDYA'){
  		document.getElementById('MANDYA').style.visibility='visible';
      }else{
      	document.getElementById('MANDYA').style.visibility='hidden';
      }
  		break;	
  		
      case "MANGALORE" :if(selectedDistrictName=='MANGALORE'){
  		document.getElementById('MANGALORE').style.visibility='visible';
      }else{
      	document.getElementById('MANGALORE').style.visibility='hidden';
      }
  		break;	
  		
      case "MYSORE" :if(selectedDistrictName=='MYSORE'){
  		document.getElementById('MYSORE').style.visibility='visible';
      }else{
      	document.getElementById('MYSORE').style.visibility='hidden';
      }
  		break;	
  		
      case "NORTH KARNATAKA DIST." :if(selectedDistrictName=='NORTH KARNATAKA DIST.'){
  		document.getElementById('NORTH KARNATAKA DIST.').style.visibility='visible';
      }else{
      	document.getElementById('NORTH KARNATAKA DIST.').style.visibility='hidden';
      }
  		break;	
  		
      case "RAMANAGAR" :if(selectedDistrictName=='RAMANAGAR'){
  		document.getElementById('RAMANAGAR').style.visibility='visible';
      }else{
      	document.getElementById('RAMANAGAR').style.visibility='hidden';
      }
  		break;	
  		
      case "RAICHUR" :if(selectedDistrictName=='RAICHUR'){
  		document.getElementById('RAICHUR').style.visibility='visible';
      }else{
      	document.getElementById('RAICHUR').style.visibility='hidden';
      }
  		break;	
  		
      case "SHIMOGA" :if(selectedDistrictName=='SHIMOGA'){
  		document.getElementById('SHIMOGA').style.visibility='visible';
      }else{
      	document.getElementById('SHIMOGA').style.visibility='hidden';
      }
  		break;	
  		
      case "TUMKUR" :if(selectedDistrictName=='TUMKUR'){
  		document.getElementById('TUMKUR').style.visibility='visible';
      }else{
      	document.getElementById('TUMKUR').style.visibility='hidden';
      }
  		break;	
  		
      case "UDUPI" :if(selectedDistrictName=='UDUPI'){
  		document.getElementById('UDUPI').style.visibility='visible';
      }else{
      	document.getElementById('UDUPI').style.visibility='hidden';
      }
  		break;	
  		
      case "YADGIRI" :if(selectedDistrictName=='YADGIRI'){
  		document.getElementById('YADGIRI').style.visibility='visible';
      }else{
      	document.getElementById('YADGIRI').style.visibility='hidden';
      }
  		break;	
  		
      } */
  	return true;
  }

  
  </script>
  
