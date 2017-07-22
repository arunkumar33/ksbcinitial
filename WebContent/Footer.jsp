<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="keywords" content="footer, address, phone, icons" />

	<title>Footer With Address And Phones</title>

	<link rel="stylesheet" href="CSS/demo.css">
	<link rel="stylesheet" href="CSS/footer-distributed-with-address-and-phones.css">
	
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">

	<link href="http://fonts.googleapis.com/css?family=Cookie" rel="stylesheet" type="text/css">
<style type="text/css">
#BodyOfFooter
{
 position:fixed;
   left:0px;
   bottom:0px;
   height:250px;
   width:100%;
  
}
</style> 
</head>

	<body >

	<div id="BodyOfFooter">

		<footer class="footer-distributed">

			<div class="footer-left">

				<h3>Company<span>logo</span></h3>

				<p class="footer-links">
					<a href="#">Home</a>
					·
					<a href="#">About</a>
					·
					<a href="#">Contact</a>
					·
					<a href="#">Enquiry</a>
					·
					<a href="#">Help</a>
					·
					
				</p>

				<p class="footer-company-name">KSBC &copy; 2016</p>
			</div>

			<div class="footer-center">

				<div>
					<i class="fa fa-map-marker"></i>
					<p><span>Old K.G.I.D. Building, High Court of Karnataka,</span>  Dr.Ambedkar Veedhi, Bengaluru, Karnataka</p>
				</div>

				<div>
					<i class="fa fa-phone"></i>
					<p>088616 40029</p>
				</div>

				<div>
					<i class="fa fa-envelope"></i>
					<p><a href="mailto:support@company.com">support@company.com</a></p>
				</div>

			</div>

			<div class="footer-right">

				<p class="footer-company-about">
					<span>About the company</span>
					KSBC is also know as karnataka state board council. Its a bar council in Ambedkar veedhi bangalore. 
				</p>

				<!-- <div class="footer-icons">

					<a href="#"><i class="fa fa-facebook"></i></a>
					<a href="#"><i class="fa fa-twitter"></i></a>
					<a href="#"><i class="fa fa-linkedin"></i></a>
					<a href="#"><i class="fa fa-github"></i></a>

				</div> -->

			</div>

		</footer>
		</div>

	</body>
<!-- <script type="text/javascript">


$(document).ready(function(){

	var showHeaderAt = 150;

	var win = $(window),
			body = $('body');

	// Show the fixed header only on larger screen devices

	/* if(win.width() > 600){

		// When we scroll more than 150px down, we set the
		// "fixed" class on the body element.

		win.on('scroll', function(e){

			if(win.scrollTop() < showHeaderAt) {
				body.addClass('fixed');
			}
			else {
				body.removeClass('fixed');
			}
		});

	} */
	body.addClass('fixed');

});



</script> -->
</html>
