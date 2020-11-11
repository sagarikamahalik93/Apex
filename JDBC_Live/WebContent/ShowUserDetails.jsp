<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="style.css">
<title>Show User Details</title>
</head>
<body>
	<sql:setDataSource var="myDS" driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/apex_live" user="root"
		password="system" />

	<sql:query var="listUsers" dataSource="${myDS}">
        SELECT * FROM user;
    </sql:query>

	<div align="center">
		<table border="1">
			<caption>List of users</caption>
			<tr>
				<th>User Name</th>
				<th>Password</th>
				<th>Full Name</th>
			</tr>
			<c:forEach var="user" items="${listUsers.rows}">
				<tr>
					<td><c:out value="${user.uname}" /></td>
					<td><c:out value="${user.password}" /></td>
					<td><c:out value="${user.fullname}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br><br>
	<a href="Home.jsp">Back</a>
</body>
</html>