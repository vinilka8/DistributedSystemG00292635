<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
	<head>
		<title>Client Fiboncay number Requester</title>
	</head>
	
<body>
	<h1>Chose Length of your fibonacci siqence</h1>
	  
	<form action = "FibServlet" method = "GET" style="height: 105px; ">
		<input type = "hidden" name = "req-leng" value = "add">
		<input type = "text" name = "lengNum"><br> value[1-100]<br>
		<input type = "submit" value = "submit"/>
	</form>
	</body>
</html>