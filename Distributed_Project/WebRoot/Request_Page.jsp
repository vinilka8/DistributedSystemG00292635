<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Client Fiboncay number Requester</title>
	</head>
	
	<input type = "hidden" name = "req-leng" value= "poll">
<body onload="poll()">
<h1>fibonacci Request</h1>
		<h3>Job Number : </h3> 
		<%=(Integer)request.getAttribute("jobNumber")%>
		<h3>Page will refresh in 10 seconds.</h3>
		<% response.addHeader("Refresh","10; http://localhost:8080/Distributed_Project/Result_Page.jsp?fibres="+request.getAttribute("fibres")); %>
		</body>
</html>

	