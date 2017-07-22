<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <!-- Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
    <!-- Font Awesome -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"/>
       <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
     <script src="http://code.jquery.com/jquery-latest.js"></script>

  <!-- Custom Theme Style -->
    <link href="CSS/custom.min.css" rel="stylesheet">
      <link href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.css" rel="stylesheet"/>
 
  <link href="https://cdnjs.cloudflare.com/ajax/libs/nprogress/0.2.0/nprogress.min.css" rel="stylesheet"/>
</head>

<body class="login" >
  
<!--  <img src="bg_Img.png" style="width: 90%; height: 20%"/> -->
    <div>
<!--       <a class="hiddenanchor" id="signup"></a>
      <a class="hiddenanchor" id="signin"></a>
 -->
       <img src="bg_Img.jpg" alt="Smiley face" height="100%" width="100%"> 
        <div class="animate form login_form">
        
      <section class="login_content">
            <form id="LoginToDomain" method="post" action="DomainLogin">
              <h1>Login</h1>
              <div align="center">
                <input type="text" style="width:500px; height:30px;" class="form-control" placeholder="Username" required="" id="UserName" name="UserName"/>
              </div>
              <div align="center">
                <input type="password" style="width:500px; height:30px;" class="form-control" placeholder="Password" required="" id="Password" name="Password"/>
              </div>
          <div   >
        
          <input type="submit" class="btn btn-default submit" id="LoginToDomainSubmit" value="Log in"/>
          
        
          </div>
                <!-- <a class="reset_pass" href="#">Lost your password?</a> -->
             

              <div class="clearfix"></div>

              <div class="separator">
                <p class="change_link">Want An Access ?
                  <a href="#signup" class="to_register"> Create Account </a>
                </p>

                <div class="clearfix"></div>
                <br />

                <div>
                
                  <p>©2016 All Rights Reserved. <a href="http://www.ksbc.co.in"> <b>www.ksbc.co.in </b> </a></p>
                </div>
              </div>
            </form>
          </section>
          
        </div>

        <div id="register" class="animate form registration_form">
          <section class="login_content">
            <form action="SignUpForKSBC" method="post">
              <h1>Create Account</h1>
              <div>
                <input type="text" class="form-control" placeholder="Username" required="" name="Username"/>
              </div>
              <div>
                <input type="email" class="form-control" placeholder="Email" required="" name="Email"/>
              </div>
              <div>
                <select name="Domain" class="form-control selectpicker"  >
      <option value=" " >Please select your Domain</option>
      <option>New Enrollment</option>
      <option>Account Section</option>
       <option>Welfare Section</option>
	  </select>
	  <br/>
              </div>
              <div>
                <input type="submit" class="btn btn-default submit" />
              </div>

              <div class="clearfix"></div>

              <div class="separator">
                <p class="change_link">Already Have an account ?
                  <a href="#signin" class="to_register"> Log in </a>
                </p>

                <div class="clearfix"></div>
                <br />

                <div>
                
                  <p>©2016 All Rights Reserved.  <a href="http://www.ksbc.co.in"> <b>www.ksbc.co.in </b> </a></p>
                </div>
              </div>
            </form>
          </section>
        </div>
      </div>
    </div>
  </body>
</html>