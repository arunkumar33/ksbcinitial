<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.KSBC.JSPRelatedFunctions.JSPRelatedFunctionsimp"%>
<%@page import="com.KSBC.Bean.ScheduleBean"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% 

JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();

%>
<%= JSPRelatedFunctionsimp.ConfirmInterviewJSP()%>

