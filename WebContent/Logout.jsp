<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log out</title>
</head>
<body >
<% 
HttpSession newsession = request.getSession(false);
    if (newsession != null) 
    {
    	 newsession.setAttribute("UserName", null);
         newsession.invalidate();
        
    }

   response.sendRedirect("AccountLogin.jsp");
   
   %>
</body>

<script type = "text/javascript" >
 
</script>
</html>