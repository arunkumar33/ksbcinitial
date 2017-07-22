<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.KSBC.BuildDesk.BuildDeskImp"%>
<%@page import="com.KSBC.Bean.ScheduleConfirmationBean"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% 

BuildDeskImp BuildDeskImp = new BuildDeskImp();
String KARNumber=(String)session.getAttribute("KARNumber");

%>
<h2>Welfare Fund Paid Details</h2>
<%=BuildDeskImp.sendPost("")%>

