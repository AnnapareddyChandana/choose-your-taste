<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page import="java.sql.*" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body bgcolor="lightgreen">
  <table border="1" width="30%" height="30%">
  <tr><th><font color='white'>ITEM NAME</font></th><th><font color='white'>ITEM PRICE</font></th><th><font color='white'>ITEM QUANTITY</font></th><th><font color='white'>ITEM TOTAL</font></th></tr><%
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/chooseurtaste","root","1234");			
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select * from selecteditems");
  while(rs.next())
  {
	  
      String ReceipeName=rs.getString("receipeName");
      int ReceipePrice=rs.getInt("receipePrice");
      int ReceipeQuantity=rs.getInt("receipeQuantity");
      
      
  %>
<tr>
<td><b><font color='#663300'><%=ReceipeName%></font></b></td>
<td><b><font color='#663300'><%=ReceipePrice%></font></b></td>
<td><b><font color='#663300'><%=ReceipeQuantity%></font></b></td>

<td><%int ReceipeTotal=ReceipePrice*ReceipeQuantity;
out.println(ReceipeTotal); %></td>

</tr>
<%
  }
 %>
 </table>
 
</body>
</html>