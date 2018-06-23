<%@ page import="java.sql.*" %>
<html>
<body background="C:\Users\user\Downloads\bg8.jpg">
<center>
  <table border="1" width="30%" height="30%">
  <tr><th><font color='Red'>RECEIPE NAME</font></th><th><font color='red'>RECEIPE PRICE</font></th>
<%
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/chooseurtaste","root","1234");			
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select * from chutneysmenu");
  while(rs.next())
  {
	  String ReceipeName=rs.getString("receipeName");
      String ReceipePrice=rs.getString("receipePrice");
      
  %>
<tr>
<td><b><font color='#663300'><%=ReceipeName%></font></b></td>
<td><b><font color='#663300'><%=ReceipePrice%></font></b></td>

</tr>

<%
  }
 %>
 </table>
 <form action="selectedItemsServlet" method="post">
	<div class="iname">
<p><b>Enter Item Name: </b></p><input type="text"  name="name"  placeholder="ItemName"/><br>
</div>
<div class="iprice">
<p><b>Enter Item Price: </b></p><input type="price" name="price" placeholder="Item Price"/><br>
</div>
<br>
</div>
<div class="iquantity">
<p><b>Enter Item Quantity: </b></p><input type="quantity" name="quantity" placeholder="Quantity"/><br>
</div>
<br>
<input type="submit" name="s" value="add to bill"/>
</center>
</form>
</center>
     </body>
</html>
