<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>Basic Header</title>

	<link rel="stylesheet" href="assets/demo.css">
	<link rel="stylesheet" href="assets/header-fixed.css">
	<link href='http://fonts.googleapis.com/css?family=Cookie' rel='stylesheet' type='text/css'>
	<style type="text/css">
	#HeaderBody
	{
	 position:fixed;
   left:0px;
   top:0px;
   height:150px;
   width:100%;
   padding-bottom: 10px;
  
	}
	
	</style>
</head>
<body>
<div id="HeaderBody">
<header class="header-fixed">

	<div class="header-limiter">

		<h1><a href="#">Company<span>logo</span>      KSBC</a></h1>

		<nav>
			<a href="#"class="selected">Home</a>
			<a href="#" >About</a>
			<a href="#">Contact</a>
			<a href="#">Enquiry</a>
			<a href="#">Help</a>
			
		</nav>

	</div>

</header>

<!-- You need this element to prevent the content of the page from jumping up -->
<div class="header-fixed-placeholder"></div>

<!-- The content of your page would go here. -->


</div>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<!-- <script type="text/javascript" src="JS/HeaderScript.js"></script> -->



</body>
</html>