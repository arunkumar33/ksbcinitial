<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.KSBC.JSPRelatedFunctions.JSPRelatedFunctionsimp"%>
<%@page import="com.KSBC.Bean.ScheduleConfirmationBean"%>
<%@page import="java.util.ArrayList"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% 

JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();

%>
<%= JSPRelatedFunctionsimp.JSPForToDoListOfDcAccount()%>

