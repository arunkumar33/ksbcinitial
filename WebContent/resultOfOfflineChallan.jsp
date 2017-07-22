<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String path=(String )request.getAttribute("KARNumber");

String src="<img  src=ImageServlet?RegNumber="+path+"&WhichPhoto=Photo  />";
System.out.println(src + "src");
%>



<%
String path2=(String )request.getAttribute("message");
System.out.println(path2);
%>

<%=path2 %>
Congratulation Your Form is Uploaded <%= path%>

<br>

 <%= src%> 
</body>
</html>