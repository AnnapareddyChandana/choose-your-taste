<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body  background="C:\Users\user\Downloads\bg8.jpg">
<center><br><br><br>
<form action="receipeUpdateServlet" method="post">
<b>Receipe Id : </b><input type="text" name="receipeId" value=${receipedata.receipeId} readOnly=true><br/><br>
<b>Enter ReceipeName :</b> <input type="text" name="receipeName" value=${receipedata.receipeName}><br/><br>
<b>Enter receipeType :</b> <input type="text" name="receipeType" value=${receipedata.receipeType}><br/><br>
<b>Enter receipePrice :</b> <input type="text" name="receipePrice" value=${receipedata.receipePrice}><br/><br>
<input type="submit" value="UPDATE">
</form><br><br>
<a href="index.html">Log Out</a>
</center>
</body>
</html>