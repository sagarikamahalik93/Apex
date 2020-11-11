<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<%=request.getAttribute("result") %>
<br><br>
<a href="Home.jsp">Back</a>
</body>
</html>