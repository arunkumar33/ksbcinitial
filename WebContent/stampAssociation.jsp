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
<form action="AssociationStamp"  method="post" onkeypress="return event.keyCode != 13;">
	<table>

		<tr>
			<td>Select District</td>

			<td><select size="1" id="district" title="" name="district">
					<option value="">-Select District-</option>
					<option value="BANGALORE_DISTRICT">BANGALORE DISTRICT</option>
					<option value="BAGALKOT">BAGALKOT</option>
					<option value="BELAGAUM">BELAGAUM</option>
					<option value="BELLARY">BELLARY</option>
					<option value="BIDAR">BIDAR</option>
					<option value="BIJAPUR">BIJAPUR</option>
					<option value="CHAMARAJNAGAR">CHAMARAJNAGAR</option>
					<option value="CHIKKAMAGALUR">CHIKKAMAGALUR</option>
					<option value="CHICKBALLAPUR">CHICKBALLAPUR</option>
					<option value="CHITRADURGA">CHITRADURGA</option>
					<option value="DAVANGERE">DAVANGERE</option>
					<option value="COORG ">COORG</option>
					<option value="DHARWAD">DHARWAD</option>
					<option value="GADAG">GADAG</option>
					<option value="GULBARGA">GULBARGA</option>
					<option value="HASSAN">HASSAN</option>
					<option value="HAVERI">HAVERI</option>
					<option value="KOLAR">KOLAR</option>
					<option value="KOPPAL">KOPPAL</option>
					<option value="MANDYA">MANDYA</option>
					<option value="MANGALORE">MANGALORE</option>
					<option value="MYSORE">MYSORE</option>
					<option value="NORTH_KARNATAKA_DIST">NORTH KARNATAKA DIST.
					</option>
					<option value="RAMANAGAR">RAMANAGAR</option>
					<option value="RAICHUR">RAICHUR</option>
					<option value="SHIMOGA">SHIMOGA</option>
					<option value="TUMKUR">TUMKUR</option>
					<option value="UDUPI">UDUPI</option>
					<option value="YADGIRI">YADGIRI</option>

			</select></td>
		</tr>

		<tr>
			<td>Select Bar Association</td>
			<td>
				<div class="container" id="container2">

					<div class="BANGALORE_DISTRICT">
						<div></div>
						<select name="Association" id="BANGALORE_DISTRICT" onblur=" GetEnrollmentDetailsForCashSection('BANGALORE_DISTRICT')">
							
							<option value="">-Select Association-</option>
							<option value="BENGALURU BAR ASSOCIATION">BENGALURU BAR
								ASSOCIATION</option>
							<option value="BENGALURU ADV CO-OPERATIVE SOCIETY">BENGALURU
								ADV CO-OPERATIVE SOCIETY</option>
							<option value="ANEKAL BAR ASSOCIATION">ANEKAL BAR
								ASSOCIATION</option>
							<option value="DEVANAHALLI BAR ASSOCIATION">DEVANAHALLI
								BAR ASSOCIATION</option>
							<option value="DODDABALLAPUR BAR ASSOCIATION">DODDABALLAPUR
								BAR ASSOCIATION</option>
							<option value="HOSAKOTE BAR ASSOCIATION">HOSAKOTE BAR
								ASSOCIATION</option>
							<option value="NELAMANGALA BAR ASSOCIATION">NELAMANGALA
								BAR ASSOCIATION</option>

						</select>
					</div>

					<div class="BAGALKOT">

						<select name="Association" id="BAGALKOT" onblur=" GetEnrollmentDetailsForCashSection('BAGALKOT')">
								<option value="">-Select Association-</option>
							<option value="BAGALKOT BAR ASSOCIATION">BAGALKOT BAR
								ASSOCIATION</option>
							<option value="BAGALKOT ADV CO-OPERATIVE SOCIETY">BAGALKOT
								ADV CO-OPERATIVE SOCIETY</option>
							<option value="BADAMI BAR ASSOCIATION">BADAMI BAR
								ASSOCIATION</option>
							<option value="BANAHATTI BAR ASSOCIATION">BANAHATTI BAR
								ASSOCIATION</option>
							<option value="BILIGI BAR ASSOCIATION">BILIGI BAR
								ASSOCIATION</option>
							<option value="GULEDAGUDDA BAR ASSOCIATION">GULEDAGUDDA
								BAR ASSOCIATION</option>
							<option value="HUNGUND BAR ASSOCIATION ">HUNGUND BAR
								ASSOCIATION</option>
							<option value="ILKAL BAR ASSOCIATION">ILKAL BAR
								ASSOCIATION</option>

							<option value="JAMAKHANDI BAR ASSOCIATION">JAMAKHANDI
								BAR ASSOCIATION</option>

							<option value="MUDHOL BAR ASSOCIATION">MUDHOL BAR
								ASSOCIATION</option>


						</select>
					</div>



					<div class="BELAGAUM">

						<select name="Association" id="BELAGAUM" onblur=" GetEnrollmentDetailsForCashSection('BELAGAUM')">
	<option value="">-Select Association-</option>
							<option value="BELAGAUM BAR ASSOCIATION">BELAGAUM BAR
								ASSOCIATION</option>
							<option value="BELAGAUM ADV CO-OPERATIVE SOCIETY">BELAGAUM
								ADV CO-OPERATIVE SOCIETY</option>
							<option value="NIPPANI BAR ASSOCIATION">NIPPANI BAR ASSOCIATION</option>
							<option value="ATHANI BAR ASSOCIATION">ATHANI BAR
								ASSOCIATION</option>
							<option value="BELGAUM CITY BAR ASSOCIATION">BELGAUM
								CITY BAR ASSOCIATION</option>

							<option value="BAILAHONGAL BAR ASSOCIATION">BAILAHONGAL
								BAR ASSOCIATION</option>
							<option value="CHIKODI BAR ASSOCIATION">CHIKODI BAR
								ASSOCIATION</option>
							<option value="GOKAK BAR ASSOCIATION">GOKAK BAR
								ASSOCIATION</option>
							<option value="HUKKERI BAR ASSOCIATION">HUKKERI BAR
								ASSOCIATION</option>

							<option value="KHANAPUR BAR ASSOCIATION">KHANAPUR BAR
								ASSOCIATION</option>

							<option value="KITTUR, Bailhongal TQ BAR ASSOCIATION">KITTUR,
								Bailhongal TQ BAR ASSOCIATION</option>
							<option value="RAMADURGA BAR ASSOCIATION">RAMADURGA BAR
								ASSOCIATION</option>
							<option value="RAIBAG BAR ASSOCIATION">RAIBAG BAR
								ASSOCIATION</option>

							<option value="SANKESHWAR BAR ASSOCIATION">SANKESHWAR
								BAR ASSOCIATION</option>

							<option value="SAUNDATTI BAR ASSOCIATION">SAUNDATTI BAR
								ASSOCIATION</option>

							<option value="MUDALAGI BAR ASSOCIATION">MUDALAGI BAR
								ASSOCIATION</option>

						</select>
					</div>

					<div class="BELLARY">

						<select name="Association" id="BELLARY" onblur=" GetEnrollmentDetailsForCashSection('BELLARY')">
	<option value="">-Select Association-</option>
							<option value="BELLARY  BAR ASSOCIATION">BELLARY BAR
								ASSOCIATION</option>

							<option value="BELLARY ADV CO-OPERATIVE SOCIETY">BELLARY
								ADV CO-OPERATIVE SOCIETY</option>
							<option value="HADAGLI CITY BAR ASSOCIATION">HADAGLI
								CITY BAR ASSOCIATION</option>

							<option value="HAGARAI BOMMANAHAHALLI BAR ASSOCIATION">HAGARAI
								BOMMANAHAHALLI BAR ASSOCIATION</option>
							<option value="HOSPET BAR ASSOCIATION">HOSPET BAR
								ASSOCIATION</option>
							<option value="KUDLIGI BAR ASSOCIATION">KUDLIGI BAR
								ASSOCIATION</option>
							<option value="SANDUR BAR ASSOCIATION">SANDUR BAR
								ASSOCIATION</option>

							<option value="SIRUGUPPA BAR ASSOCIATION">SIRUGUPPA BAR
								ASSOCIATION</option>

						</select>
					</div>

					<div class="BIDAR">

						<select name="Association" id="BIDAR" onblur=" GetEnrollmentDetailsForCashSection('BIDAR')">
							
								<option value="">-Select Association-</option>
							<option value="BIDAR BAR ASSOCIATION">BIDAR BAR
								ASSOCIATION</option>
							<option value="BIDAR ADV CO-OPERATIVE SOCIETY">BIDAR ADV
								CO-OPERATIVE SOCIETY</option>
							<option value="AURAD BAR ASSOCIATION">AURAD BAR
								ASSOCIATION</option>
							<option value="BASAVAKALYAN BAR ASSOCIATION">BASAVAKALYAN
								BAR ASSOCIATION</option>
							<option value="BHALKI BAR ASSOCIATION">BHALKI BAR
								ASSOCIATION</option>
							<option value="HUMNABAD BAR ASSOCIATION ">HUMNABAD BAR
								ASSOCIATION</option>


						</select>
					</div>

					<div class="BIJAPUR">

					<select select name="Association" id="BIJAPUR"  onblur=" GetEnrollmentDetailsForCashSection('BIJAPUR')">
								<option value="">-Select Association-</option>
							
							<option value="BIJAPUR BAR ASSOCIATION">BIJAPUR BAR
								ASSOCIATION</option>
							<option value="BIJAPUR ADV CO-OPERATIVE SOCIETY">BIJAPUR
								ADV CO-OPERATIVE SOCIETY</option>
							<option value="BASAVAN BAGEWADI BAR ASSOCIATION">BASAVAN
								BAGEWADI BAR ASSOCIATION</option>
							<option value="INDI BAR ASSOCIATION">INDI BAR
								ASSOCIATION</option>
							<option value="MUDDEBIHA BAR ASSOCIATION">MUDDEBIHA BAR
								ASSOCIATION</option>
							<option value="SINDAGI BAR ASSOCIATION">SINDAGI BAR
								ASSOCIATION</option>


						</select>
					</div>

					<div class="CHAMARAJNAGAR">

						<select select name="Association" id="CHAMARAJNAGAR"  onblur=" GetEnrollmentDetailsForCashSection('CHAMARAJNAGAR')">
	<option value="">-Select Association-</option>
							<option value="CHAMARAJNAGAR BAR ASSOCIATION">CHAMARAJNAGAR
								BAR ASSOCIATION</option>
							<option value="CHAMARAJNAGAR ADV CO-OPERATIVE SOCIETY">CHAMARAJNAGAR
								ADV CO-OPERATIVE SOCIETY</option>
							<option value="GUNDLUPET BAR ASSOCIATION">GUNDLUPET BAR
								ASSOCIATION</option>
							<option value="KOLLEGAL BAR ASSOCIATION">KOLLEGAL BAR
								ASSOCIATION</option>
							<option value="YELANDUR BAR ASSOCIATION">YELANDUR BAR
								ASSOCIATION</option>

						</select>
					</div>

					<div class="CHIKKAMAGALUR">

						<select select name="Association" id="CHIKKAMAGALUR"  onblur=" GetEnrollmentDetailsForCashSection('CHIKKAMAGALUR')">
							<option value="">-Select Association-</option>	
							
							<option value="CHIKKAMAGALUR BAR ASSOCIATION">CHIKKAMAGALUR
								BAR ASSOCIATION</option>
							<option value="CHIKKAMAGALUR ADV CO-OPERATIVE SOCIETY">CHIKKAMAGALUR
								ADV CO-OPERATIVE SOCIETY</option>
							<option value="KADUR BAR ASSOCIATION">KADUR BAR
								ASSOCIATION</option>
							<option value="KOPPA BAR ASSOCIATION">KOPPA BAR
								ASSOCIATION</option>
							<option value="MUDIGERE BAR ASSOCIATION">MUDIGERE BAR
								ASSOCIATION</option>
							<option value="N.R.PURA BAR ASSOCIATION">N R PURA BAR
								ASSOCIATION</option>
							<option value="SRINGERI BAR ASSOCIATION">SRINGERI BAR
								ASSOCIATION</option>
							<option value="TARIKERE BAR ASSOCIATION">TARIKERE BAR
								ASSOCIATION</option>

						</select>
					</div>
					
					<div class="CHICKBALLAPUR">

						<select select name="Association" id="CHICKBALLAPUR"  onblur=" GetEnrollmentDetailsForCashSection('CHICKBALLAPUR')">
							<option value="">-Select Association-</option>	
							
							<option value="CHICKBALLAPUR BAR ASSOCIATION">CHICKBALLAPUR
								BAR ASSOCIATION</option>
							<option value="CHICKBALLAPUR ADV CO-OPERATIVE SOCIETY">CHICKBALLAPUR
								ADV CO-OPERATIVE SOCIETY</option>
							<option value="BAGEPALLI BAR ASSOCIATION">BAGEPALLI BAR
								ASSOCIATION</option>
							<option value="CHINTAMANI BAR ASSOCIATION">CHINTAMANI BAR
								ASSOCIATION</option>
							<option value="GOWRIBIDNUR BAR ASSOCIATION">GOWRIBIDNUR BAR
								ASSOCIATION</option>
							<option value="SIDLAGHATTA BAR ASSOCIATION">SIDLAGHATTA BAR
								ASSOCIATION</option>
							<option value="GUDIBANDA BAR ASSOCIATION">GUDIBANDA BAR
								ASSOCIATION</option>
							

						</select>
					</div>
					

					<div class="CHITRADURGA">

						<select select name="Association" id="CHITRADURGA"  onblur=" GetEnrollmentDetailsForCashSection('CHITRADURGA')">
							<option value="">-Select Association-</option>
						
							<option value="CHITRADURGA BAR ASSOCIATION">CHITRADURGA
								BAR ASSOCIATION</option>
							<option value="CHITRADURGA ADV CO-OPERATIVE SOCIETY">CHITRADURGA
								ADV CO-OPERATIVE SOCIETY</option>
							<option value="CHALLAKERE BAR ASSOCIATION">CHALLAKERE
								BAR ASSOCIATION</option>
							<option value="HIRIYUR BAR ASSOCIATION">HIRIYUR BAR
								ASSOCIATION</option>
							<option value="HOLALKERE BAR ASSOCIATION">HOLALKERE BAR
								ASSOCIATION</option>
							<option value="HOSADURGA BAR ASSOCIATION">HOSADURGA BAR
								ASSOCIATION</option>
							<option value="MOLAKALMURU BAR ASSOCIATION">MOLAKALMURU
								BAR ASSOCIATION</option>


						</select>
					</div>

					<div class="DAVANGERE">

						<select select name="Association" id="DAVANGERE"  onblur=" GetEnrollmentDetailsForCashSection('DAVANGERE')">
	<option value="">-Select Association-</option>
							<option value="DAVANGERE BAR ASSOCIATION">DAVANGERE BAR
								ASSOCIATION</option>
							<option value="DAVANGERE ADV CO-OPERATIVE SOCIETY">DAVANGERE
								ADV CO-OPERATIVE SOCIETY</option>

							<option value="CHANNAGIRI BAR ASSOCIATION">CHANNAGIRI
								BAR ASSOCIATION</option>
							<option value="HARAPANAHALLI BAR ASSOCIATION">HARAPANAHALLI
								BAR ASSOCIATION</option>
							<option value="HARIHAR BAR ASSOCIATIONBAR ASSOCIATION">HARIHAR
								BAR ASSOCIATIONBAR ASSOCIATION</option>
							<option value="HAONNALI BAR ASSOCIATION">HAONNALI BAR
								ASSOCIATION</option>
							<option value="JAGALUR BAR ASSOCIATION">JAGALUR BAR
								ASSOCIATION</option>

						</select>
					</div>

					<div class="COORG">

						<select select name="Association" id="COORG"  onblur=" GetEnrollmentDetailsForCashSection('COORG')">
	<option value="">-Select Association-</option>
							<option value="MADIKERI BAR ASSOCIATION">MADIKERI BAR
								ASSOCIATION</option>
							<option value="MADIKERI ADV CO-OPERATIVE SOCIETY">MADIKERI
								ADV CO-OPERATIVE SOCIETY</option>
							<option value="MADIKERI BAR ASSOCIATION">MADIKERI BAR
								ASSOCIATION</option>
							<option value="POONAMPET BAR ASSOCIATION">POONAMPET BAR
								ASSOCIATION</option>
							<option value="SOMWARPET BAR ASSOCIATION">SOMWARPET BAR
								ASSOCIATION</option>
							<option value="VIRAJPET BAR ASSOCIATION">VIRAJPET BAR
								ASSOCIATION</option>
							<option value="KUSHALNAGAR BAR ASSOCIATION ">KUSHALNAGAR
								BAR ASSOCIATION</option>

						</select>
					</div>

					<div class="DHARWAD">

						<select select name="Association" id="DHARWAD"  onblur=" GetEnrollmentDetailsForCashSection('DHARWAD')">
						
							<option value="">-Select Association-</option>
							<option value="DHARWAD BAR ASSOCIATION">DHARWAD BAR
								ASSOCIATION</option>
							<option value="DHARWAD ADV CO-OPERATIVE SOCIETY">DHARWAD
								ADV CO-OPERATIVE SOCIETY</option>
							<option value="Belur Industrial Estate BAR ASSOCIATION">Belur
								Industrial Estate BAR ASSOCIATION</option>
							<option value="HUBLI BAR ASSOCIATION">HUBLI BAR
								ASSOCIATION</option>
							<option value="KALAGHATAGI BAR ASSOCIATION">KALAGHATAGI
								BAR ASSOCIATION</option>
							<option value="KUNDAGOL BAR ASSOCIATION">KUNDAGOL BAR
								ASSOCIATION</option>
							<option value="NAVALGUND BAR ASSOCIATION">NAVALGUND BAR
								ASSOCIATION</option>


						</select>
					</div>

					<div class="GADAG">

						<select select name="Association" id="GADAG"  onblur=" GetEnrollmentDetailsForCashSection('GADAG')">
						
							<option value="">-Select Association-</option>
							<option value="GADAG BAR ASSOCIATION">GADAG BAR
								ASSOCIATION</option>
							<option value="GADAG ADV CO-OPERATIVE SOCIETY">GADAG ADV
								CO-OPERATIVE SOCIETY</option>
							<option value="LAXMESHWAR BAR ASSOCIATION">LAXMESHWAR
								BAR ASSOCIATION</option>
							<option value="MUNDARGI BAR ASSOCIATION">MUNDARGI BAR
								ASSOCIATION</option>
							<option value="NARGUND BAR ASSOCIATION">NARGUND BAR
								ASSOCIATION</option>
							<option value="RON BAR ASSOCIATION">RON BAR ASSOCIATION</option>


						</select>
					</div>

					<div class="GULBARGA">

						<select select name="Association" id="GULBARGA"  onblur=" GetEnrollmentDetailsForCashSection('GULBARGA')">
						
							<option value="">-Select Association-</option>
							<option value="GULBARGA BAR ASSOCIATION">GULBARGA BAR
								ASSOCIATION</option>
							<option value="GULBARGA ADV CO-OPERATIVE SOCIETY">GULBARGA
								ADV CO-OPERATIVE SOCIETY</option>

							<option value="ALAND BAR ASSOCIATION">ALAND BAR
								ASSOCIATION</option>
							<option value="CHINCHOLLI BAR ASSOCIATION">CHINCHOLLI
								BAR ASSOCIATION</option>
							<option value="CHITTAPUR BAR ASSOCIATION">CHITTAPUR BAR
								ASSOCIATION</option>
							<option value="JEWARGI BAR ASSOCIATION">JEWARGI BAR
								ASSOCIATION</option>
							<option value="SEDAM BAR ASSOCIATION">SEDAM BAR
								ASSOCIATION</option>

							<option value="SHAHABAD BAR ASSOCIATION">SHAHABAD BAR
								ASSOCIATION</option>


						</select>
					</div>

					<div class="HASSAN">

						<select select name="Association" id="HASSAN"  onblur=" GetEnrollmentDetailsForCashSection('HASSAN')">
								<option value="">-Select Association-</option>
							
							<option value="HASSAN  BAR ASSOCIATION">HASSAN BAR
								ASSOCIATION</option>
							<option value="HASSAN ADV CO-OPERATIVE SOCIETY">HASSAN
								ADV CO-OPERATIVE SOCIETY</option>

							<option value="ALUR BAR ASSOCIATION">ALUR BAR
								ASSOCIATION</option>
							<option value="ARAKALGUD BAR ASSOCIATION">ARAKALGUD BAR
								ASSOCIATION</option>
							<option value="ARASIKERE BAR ASSOCIATION">ARASIKERE BAR
								ASSOCIATION</option>
							<option value="BELUR BAR ASSOCIATION">BELUR BAR
								ASSOCIATION</option>
							<option value="CHANNARAYAPATNA BAR ASSOCIATION">CHANNARAYAPATNA
								BAR ASSOCIATION</option>
							<option value="HOLENARASIPUR BAR ASSOCIATION ">HOLENARASIPUR
								BAR ASSOCIATION</option>
							<option value="SAKALESHPUR BAR ASSOCIATION">SAKALESHPUR
								BAR ASSOCIATION</option>


						</select>
					</div>

					<div class="HAVERI">

						<select select name="Association" id="HAVERI"  onblur=" GetEnrollmentDetailsForCashSection('HAVERI')">
						
							<option value="">-Select Association-</option>
							<option value="HAVERI BAR ASSOCIATION">HAVERI BAR
								ASSOCIATION</option>
							<option value="HAVERI ADV CO-OPERATIVE SOCIETY">HAVERI
								ADV CO-OPERATIVE SOCIETY</option>
							<option value="BYADGI BAR ASSOCIATION">BYADGI BAR
								ASSOCIATION</option>
							<option value="HANAGAL BAR ASSOCIATION">HANAGAL BAR
								ASSOCIATION</option>
							<option value="HIREKERURU BAR ASSOCIATION">HIREKERURU
								BAR ASSOCIATION</option>
							<option value="RANEBENNUR BAR ASSOCIATION">RANEBENNUR
								BAR ASSOCIATION</option>
							<option value="SAVNUR BAR ASSOCIATION">SAVNUR BAR
								ASSOCIATION</option>
							<option value="SHIGGAON BAR ASSOCIATION">SHIGGAON BAR
								ASSOCIATION</option>


						</select>
					</div>

					<div class="KOLAR">

						<select select name="Association" id="KOLAR"  onblur=" GetEnrollmentDetailsForCashSection('KOLAR')">
	<option value="">-Select Association-</option>
							<option value="KOLAR BAR ASSOCIATION">KOLAR BAR
								ASSOCIATION</option>
							<option value="KOLAR ADV CO-OPERATIVE SOCIETY">KOLAR ADV
								CO-OPERATIVE SOCIETY</option>
							<option value="BANGARPET BAR ASSOCIATION">BANGARPET BAR
								ASSOCIATION</option>
							<option value="OORGAUM , K.G.F BAR ASSOCIATION">OORGAUM
								, K.G.F BAR ASSOCIATION</option>
							<option value="MALUR BAR ASSOCIATION">MALUR BAR
								ASSOCIATION</option>
							<option value="MULBAGAL BAR ASSOCIATION">MULBAGAL BAR
								ASSOCIATION</option>
							<option value="SRINIVASAPUR BAR ASSOCIATION">SRINIVASAPUR
								BAR ASSOCIATION</option>

						</select>
					</div>

					<div class="KOPPAL">

						<select select name="Association" id="KOPPAL"  onblur=" GetEnrollmentDetailsForCashSection('KOPPAL')">
							<option value="">-Select Association-</option>
						
							<option value="KOPPAL BAR ASSOCIATION">KOPPAL BAR
								ASSOCIATION</option>
							<option value="KOPPAL ADV CO-OPERATIVE SOCIETY">KOPPAL
								ADV CO-OPERATIVE SOCIETY</option>
							<option value="GANGAVATHI BAR ASSOCIATION">GANGAVATHI
								BAR ASSOCIATION</option>
							<option value="KUSHTAGI BAR ASSOCIATION">KUSHTAGI BAR
								ASSOCIATION</option>
							<option value="YELBURGA BAR ASSOCIATION">YELBURGA BAR
								ASSOCIATION</option>


						</select>
					</div>

					<div class="MANDYA">

						<select select name="Association" id="MANDYA"  onblur=" GetEnrollmentDetailsForCashSection('MANDYA')">
						
							<option value="">-Select Association-</option>
							<option value="MANDYA BAR ASSOCIATIONdi">MANDYA BAR
								ASSOCIATION</option>
							<option value="MANDYA ADV CO-OPERATIVE SOCIETY">MANDYA
								ADV CO-OPERATIVE SOCIETY</option>
							<option value="K R PET BAR ASSOCIATION">K R PET BAR
								ASSOCIATION</option>
							<option value="MADDUR BAR ASSOCIATION">MADDUR BAR
								ASSOCIATION</option>
							<option value="MALAVALLI BAR ASSOCIATION">MALAVALLI BAR
								ASSOCIATION</option>
							<option value="NAGAMANGALA BAR ASSOCIATION">NAGAMANGALA
								BAR ASSOCIATION</option>
							<option value="PANDVAPURA BAR ASSOCIATION">PANDVAPURA
								BAR ASSOCIATION</option>
							<option value="SRIRANGAPATNA BAR ASSOCIATION">SRIRANGAPATNA
								BAR ASSOCIATION</option>


						</select>
					</div>

					<div class="MANGALORE">
<select select name="Association" id="MANGALORE"  onblur=" GetEnrollmentDetailsForCashSection('MANGALORE')">
						
							<option value="">-Select Association-</option>
							<option value="MANGALORE BAR ASSOCIATION">MANGALORE BAR
								ASSOCIATION</option>
							<option value="MANGALORE ADV CO-OPERATIVE SOCIETY">MANGALORE
								ADV CO-OPERATIVE SOCIETY</option>
							<option value="BANTWAL BAR ASSOCIATION">BANTWAL BAR
								ASSOCIATION</option>
							<option value="BELTHANGADY BAR ASSOCIATION">BELTHANGADY
								BAR ASSOCIATION</option>
							<option value="MOODBIDARI BAR ASSOCIATION">MOODBIDARI
								BAR ASSOCIATION</option>
							<option value="PUTTUR BAR ASSOCIATION ">PUTTUR BAR
								ASSOCIATION</option>
							<option value="SULLIA BAR ASSOCIATION">SULLIA BAR
								ASSOCIATION</option>


						</select>
					</div>

					<div class="MYSORE">

						<select select name="Association" id="MYSORE"  onblur=" GetEnrollmentDetailsForCashSection('MYSORE')">
	<option value="">-Select Association-</option>
							<option value="MYSORE BAR ASSOCIATION">MYSORE BAR
								ASSOCIATION</option>
							<option value="MYSORE ADV CO-OPERATIVE SOCIETY">MYSORE
								ADV CO-OPERATIVE SOCIETY</option>
							<option value="H D KOTE BAR ASSOCIATION">H D KOTE BAR
								ASSOCIATION</option>
							<option value="HUNSUR BAR ASSOCIATION">HUNSUR BAR
								ASSOCIATION</option>
							<option value="K R NAGAR BAR ASSOCIATION">K R NAGAR BAR
								ASSOCIATION</option>
							<option value="NANJANGUD BAR ASSOCIATION">NANJANGUD BAR
								ASSOCIATION</option>
							<option value="PERIYAPATNA BAR ASSOCIATION">PERIYAPATNA
								BAR ASSOCIATION</option>

							<option value="T.NARASIPUR BAR ASSOCIATION">T.NARASIPUR
								BAR ASSOCIATION</option>

						</select>
					</div>

					<div class="NORTH_KARNATAKA_DIST">

					<select select name="Association" id="NORTH_KARNATAKA_DIST"  onblur=" GetEnrollmentDetailsForCashSection('NORTH_KARNATAKA_DIST')">
	<option value="">-Select Association-</option>
							<option value="KARWAR BAR ASSOCIATION">KARWAR BAR
								ASSOCIATION</option>
							<option value="KARWAR ADV CO-OPERATIVE SOCIETY">KARWAR
								ADV CO-OPERATIVE SOCIETY</option>
							<option value="ANKOLA BAR ASSOCIATION">ANKOLA BAR
								ASSOCIATION</option>
							<option value="BHATKAL BAR ASSOCIATION">BHATKAL BAR
								ASSOCIATION</option>
							<option value="DANDELI BAR ASSOCIATION">DANDELI BAR
								ASSOCIATION</option>
							<option value="HALIYAL BAR ASSOCIATION">HALIYAL BAR
								ASSOCIATION</option>

							<option value="HONNAVARA BAR ASSOCIATION">HONNAVARA BAR
								ASSOCIATION</option>

							<option value="KUMTA BAR ASSOCIATION">KUMTA BAR
								ASSOCIATION</option>

							<option value="MUNDGOD BAR ASSOCIATION">MUNDGOD BAR
								ASSOCIATION</option>

							<option value="SIDDAPUR BAR ASSOCIATION">SIDDAPUR BAR
								ASSOCIATION</option>

							<option value="SIRSI BAR ASSOCIATION">SIRSI BAR
								ASSOCIATION</option>

							<option value="YELLAPUR BAR ASSOCIATION">YELLAPUR BAR
								ASSOCIATION</option>

						</select>
					</div>

					<div class="RAMANAGAR">

						<select select name="Association" id="RAMANAGAR"  onblur=" GetEnrollmentDetailsForCashSection('RAMANAGAR')">
<option value="">-Select Association-</option>
							<option value="RAMANAGAR BAR ASSOCIATION">RAMANAGAR BAR
								ASSOCIATION</option>
							<option value="RAMANAGAR ADV CO-OPERATIVE SOCIETY">RAMANAGAR
								ADV CO-OPERATIVE SOCIETY</option>
							<option value="KANAKAPURA BAR ASSOCIATION">KANAKAPURA
								BAR ASSOCIATION</option>
							<option value="MAGADI BAR ASSOCIATION">MAGADI BAR
								ASSOCIATION</option>

						</select>
					</div>

					<div class="RAICHUR">
<select select name="Association" id="RAICHUR"  onblur=" GetEnrollmentDetailsForCashSection('RAICHUR')">
							
								<option value="">-Select Association-</option>
							<option value="RAICHUR BAR ASSOCIATION">RAICHUR BAR
								ASSOCIATION</option>
							<option value="RAICHUR ADV CO-OPERATIVE SOCIETY">RAICHUR
								ADV CO-OPERATIVE SOCIETY</option>
							<option value="DEODURGA BAR ASSOCIATION">DEODURGA BAR
								ASSOCIATION</option>
							<option value="LINGSUGUR BAR ASSOCIATION">LINGSUGUR BAR
								ASSOCIATION</option>
							<option value="MANVI BAR ASSOCIATION">MANVI BAR
								ASSOCIATION</option>
							<option value="SINDHANOOR BAR ASSOCIATION">SINDHANOOR
								BAR ASSOCIATION</option>


						</select>
					</div>

					<div class="SHIMOGA">

						<select name="Association" id ='SHIMOGA' onblur=" GetEnrollmentDetailsForCashSection('SHIMOGA')">
	<option value="">-Select Association-</option>
							<option value="SHIMOGA BAR ASSOCIATION">SHIMOGA BAR
								ASSOCIATION</option>
							<option value="SHIMOGA ADV CO-OPERATIVE SOCIETY">SHIMOGA
								ADV CO-OPERATIVE SOCIETY</option>
							<option value="BHADRAVATHI BAR ASSOCIATION">BHADRAVATHI
								BAR ASSOCIATION</option>
							<option value="HOSANAGAR BAR ASSOCIATION">HOSANAGAR BAR
								ASSOCIATION</option>
							<option value="SAGAR BAR ASSOCIATION">SAGAR BAR
								ASSOCIATION</option>
							<option value="SHIKARIPUR BAR ASSOCIATION">SHIKARIPUR
								BAR ASSOCIATION</option>

							<option value="SORABA BAR ASSOCIATION">SORABA BAR
								ASSOCIATION</option>
							<option value="THIRTHAHALLI BAR ASSOCIATION ">THIRTHAHALLI
								BAR ASSOCIATION</option>


						</select>
					</div>

					<div class="TUMKUR">

						<select select name="Association" id="TUMKUR"  onblur=" GetEnrollmentDetailsForCashSection('TUMKUR')">
	<option value="">-Select Association-</option>
							<option value="TUMKUR BAR ASSOCIATION">TUMKUR BAR
								ASSOCIATION</option>
							<option value="TUMKUR ADV CO-OPERATIVE SOCIETY">TUMKUR
								ADV CO-OPERATIVE SOCIETY</option>
							<option value="CHIKKANAYAKANA HALLI BAR ASSOCIATION">CHIKKANAYAKANA
								HALLI BAR ASSOCIATION</option>
							<option value="GUBBI BAR ASSOCIATION">GUBBI BAR
								ASSOCIATION</option>
							<option value="KORATAGERE BAR ASSOCIATION">KORATAGERE
								BAR ASSOCIATION</option>
							<option value="KUNIGAL BAR ASSOCIATION">KUNIGAL BAR
								ASSOCIATION</option>
							<option value="MADHUGIRI BAR ASSOCIATION">MADHUGIRI BAR
								ASSOCIATION</option>
							<option value="PAVAGADA BAR ASSOCIATION">PAVAGADA BAR
								ASSOCIATION</option>
							<option value="SIRA BAR ASSOCIATION">SIRA BAR
								ASSOCIATION</option>
							<option value="TIPTUR BAR ASSOCIATION ">TIPTUR BAR
								ASSOCIATION</option>
							<option value="TURUVEKERE BAR ASSOCIATION">TURUVEKERE
								BAR ASSOCIATION</option>

						</select>
					</div>

					<div class="UDUPI">

						<select select name="Association" id="UDUPI"  onblur=" GetEnrollmentDetailsForCashSection('UDUPI')">
							<option value="">-Select Association-</option>	
							<option value="UDUPI BAR ASSOCIATION">UDUPI BAR
								ASSOCIATION</option>
							<option value="UDUPI ADV CO-OPERATIVE SOCIETY<">UDUPI
								ADV CO-OPERATIVE SOCIETY</option>
							<option value="KARKALA BAR ASSOCIATION">KARKALA BAR
								ASSOCIATION</option>
							<option value="KUNDAPUR BAR ASSOCIATION">KUNDAPUR BAR
								ASSOCIATION</option>


						</select>
					</div>

					<div class="YADGIRI">

					<select select name="Association" id="YADGIRI"  onblur=" GetEnrollmentDetailsForCashSection('YADGIRI')">
							<option value="">-Select Association-</option>
							<option value="YADGIRI BAR ASSOCIATION">YADGIRI BAR
								ASSOCIATION</option>
							<option value="YADGIRI ADV CO-OPERATIVE SOCIETY">YADGIRI
								ADV CO-OPERATIVE SOCIETY</option>
							<option value="SHAHAPUR BAR ASSOCIATION">SHAHAPUR BAR
								ASSOCIATION</option>
							<option value="SHORAPUR BAR ASSOCIATION">SHORAPUR BAR
								ASSOCIATION</option>


						</select>
					</div>
				</div>
			</td>

		</tr>
		<tr>
			<td></td>
			<td></td>
		</tr>

		<tr></tr>
		<!-- This is the main element -->
		<tr>
			<th>Item Name</th>
			<th>Amount</th>
		</tr>

		<!-- Contents are below -->
<tr>
    <td>Name</td>  
    <td><input type="text" name="NameOfAssociation"  placeholder="Please enter Association name"></td>
   </tr>
  
  <tr>
  <td>Place</td>
  <td><input type="text" name="PlaceOfAssociation"  placeholder="Please enter Association Place"></td> 
  </tr>
  
  
 <tr>
    <td>Stamp Fee</td>  
    <td><input type="checkbox" name="Stampfee" id="Stampfee" value="00">
  <input type="number" name="Stampfee2" id="Stampfee2" value="00" onblur="ChangetheValueofCheckList('Stampfee2','Stampfee')"></td>
  </tr>
  
  <tr>
  <td> Postal Charges</td>
  <td><input type="checkbox" name="PostalCharges" id="PostalCharges" value="00"> 
  <input type="number" name="PostalCharges2" id="PostalCharges2" value="00" onblur="ChangetheValueofCheckList('PostalCharges2','PostalCharges')"></td>
 
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
  <br>
   <tr>
  <td> 
   </td>
   <td>Total<input type="number"  name="Total" id="Total"  onblur=" findTotal()" value="00"> 
   <p id="TotalResult"><p>
   </td>
   </tr>
  
  </table>


<br/>
<input type="hidden" name="Association33" id="Association33" value="" ><br><br/>
<input type="submit" class="btn btn-info" value="Submit" ><br><br/>
</form>


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
	alert(KARNumber);
	}



</script>

<script>

function findTotal()
{

	
	

		 
			//  var i = $(BCISubscription).val()); 
			var Stampfee = 0;
			var PostalCharges = 0;
			if (document.getElementById("Stampfee").checked)
				{
				 
				 
				Stampfee = document.getElementById('Stampfee2').value;
				}
			if (document.getElementById("PostalCharges").checked)
			{
			 
			 
				PostalCharges = document.getElementById('PostalCharges2').value;
			}
		
			
			 
		
		
	
	
	
	
	/* document.getElementById("Name").value="Arun";
	document.getElementById("Place").value="Bangalore"; */
	var WhichFunctionToHandle= "GetTotalForAssociate";
	 $.get('AjaxServlet',{PostalCharges:PostalCharges,Stampfee:Stampfee,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) { 
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
	/* 	   document.getElementById("Place").value = res[1]; */
		 
		 
		 
			                          
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

		
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		
		$('#district').bind('change', function() {
			var elements = $('#container2').children().hide(); // hide all the elements
			var value = $(this).val();

			if (value.length) { // if somethings' selected
				elements.filter('.' + value).show(); // show the ones we want
			} 
			
		
		}).trigger('change');
	});
</script>

<script type="text/javascript">

function GetEnrollmentDetailsForCashSection(IdOfAssociation)
{
	var x = document.getElementsByName("Association")[0].value;
	var SHIMOGA = document.getElementById(IdOfAssociation).value;
	document.getElementById('Association33').value=SHIMOGA;
	
	
	}



</script>