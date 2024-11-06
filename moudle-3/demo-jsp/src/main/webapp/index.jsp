<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%="Hello World!" %>
    <%
    int a = 7;
    int b = 10;
    int sum = a+b;
    %>
    <span> 7 + 10 = </span> <%= sum %>

</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>



<form >

</form>
</body>
</html>