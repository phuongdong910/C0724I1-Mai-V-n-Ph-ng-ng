<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="dang-nhap" method="post">
    <h1> Đăng Nhập </h1>
    Tên người dùng:<input type="text" name="tenDangNhap" /> <br/>
    Mật khẩu: <input type="password" name="matKhau" /> <br/>  <br/>
    <input type="submit" value="Đăng nhập"/>
</form>

<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>