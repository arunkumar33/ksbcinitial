<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.KSBC.JSPRelatedFunctions.JSPRelatedFunctionsimp"%>
<%@page import="com.KSBC.Bean.ScheduleConfirmationBean"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% 

JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
String KARNumber=(String)session.getAttribute("KARNumber");

%>
<h2>Welfare Fund Paid Details</h2>
<%=JSPRelatedFunctionsimp.GetWelfareFund(KARNumber) %>

