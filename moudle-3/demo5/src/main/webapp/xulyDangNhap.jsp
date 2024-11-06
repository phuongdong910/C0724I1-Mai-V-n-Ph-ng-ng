<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 11/4/2024
  Time: 8:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>xulyDangNhap</title>
</head>
<body>
<% String username = request.getParameter("username");
    String password = request.getParameter("password");
%>
<%
       if( username.equalsIgnoreCase("phuongdong")&&password.equals("dong123"))
       {
%>
<h2>Ban da dang nhap thanh cong</h2>
<% } else {

%>
<h2> Khong tim thay tai khoan</h2>
<% }
       %>
</body>
</html>
