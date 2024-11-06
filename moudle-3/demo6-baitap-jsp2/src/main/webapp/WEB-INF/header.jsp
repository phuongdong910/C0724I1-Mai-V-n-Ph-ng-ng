<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 11/4/2024
  Time: 10:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang chủ Shopee</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<header class="header">
    <div class="container">
        <div class="header__top">
            <a href="${pageContext.request.contextPath}/home.jsp" class="header__logo">
                <img src="${pageContext.request.contextPath}/assets/images/logo.png" alt="Logo Shopee" style="height: 40px;">
            </a>
            <form class="header__search" action="${pageContext.request.contextPath}/search" method="GET">
                <input type="text" name="query" class="form-control" placeholder="Tìm kiếm sản phẩm, thương hiệu và nhiều hơn nữa...">
                <button type="submit" class="btn btn-primary"><i class="fas fa-search"></i></button>
            </form>
            <div class="header__user">
                <a href="${pageContext.request.contextPath}/login.jsp" class="btn btn-light">Đăng Nhập</a>
                <a href="${pageContext.request.contextPath}/register.jsp" class="btn btn-light">Đăng Ký</a>
            </div>
        </div>
    </div>
</header>
