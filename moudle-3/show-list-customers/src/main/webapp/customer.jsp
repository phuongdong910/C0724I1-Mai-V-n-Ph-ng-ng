<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Danh sách khách hàng</title>
</head>
<body>
<h2>Danh sách khách hàng</h2>
<table border="1">
    <tr>
        <th>Hình ảnh</th>
        <th>Tên</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
    </tr>
    <c:forEach var="customer" items="${customers}">
        <tr>
            <td><img src="images/${customer.image}" width="100" height="100" alt="${customer.name}"></td>
            <td>${customer.name}</td>
            <td>${customer.birthdate}</td>
            <td>${customer.address}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>