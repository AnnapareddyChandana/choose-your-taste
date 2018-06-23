<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.ts.dto.branchDTO"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BranchList</title>
</head>
<body background="C:\Users\user\Downloads\bg8.jpg">

<basefont size=5>
	<CENTER><br>
		<h1>
			<font color="green">Branch Details</font>
		</h1>
	</CENTER><br><br><br>
	<table border="1" bgcolor="lightBlue" align="center">
		<tr>
			<td><b>HOTEL ID</b></td>
			<td><b>BRANCH ADDRESS</b></td>	
			<td><b>BRANCH ID</b></td>
			<td><b>ABOUT MENU</b></td>
			</b>
		</tr>
		<c:forEach var="branch" items="${branchesList}">
			<tr>
				<td>${branch.branchId}</td>
				<td>${branch.branchAddress}</td>
				<td>${branch.hotelID}</td>
				<td><a href="receipeServlet">Show Menu</a></td>
			</tr>
			<tr>			
		</c:forEach>		
	</table>
</body>
</html>