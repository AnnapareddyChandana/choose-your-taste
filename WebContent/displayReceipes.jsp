<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.ts.dto.receipeDTO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body  background="C:\Users\user\Downloads\bg8.jpg">
	<basefont size=5>
	<CENTER><br>
		<h1>
			<font color="green">Receipe Details</font>
		</h1>
	</CENTER><br><br><br>
	<table border="1" bgcolor="lightblue" align="center">
		<tr>
			<td><b>ID</b></td>
			<td><b>NAME</b></td>
			<td><b>TYPE</b></td>
			<td><b>PRICE</b></td>
			<th><b>Update</b></th>
			</b>
			
		</tr>
		<c:forEach var="receipe" items="${receipesList}">
			<tr>
				<td>${receipe.receipeId}</td>
				<td>${receipe.receipeName}</td>
				<td>${receipe.receipeType}</td>
				<td>${receipe.receipePrice}</td>
				<td><a href="receipeEditServlet?receipe_id=${receipe.receipeId}">Edit</a></td>
				
			</tr>
			<tr>			
		</c:forEach>		
	</table>
	
</body>
</html>