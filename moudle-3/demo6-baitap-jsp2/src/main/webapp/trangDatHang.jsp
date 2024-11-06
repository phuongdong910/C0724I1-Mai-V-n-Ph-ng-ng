<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>trangDatHang</title>
</head>
<body>
<%
    String hoVaTen = request.getParameter("hoVaTen");
    String email = request.getParameter("email");
    String soLuong = request.getParameter("soLuong");
    int soLuongSanPham = 1;
    try {
        soLuongSanPham = Integer.parseInt(soLuong);

    } catch (Exception e) {

    }
%>

<h2>Xac nhan dat hang</h2>
<p>Xin cam on ban <%= hoVaTen %> da dat <b><%= soLuongSanPham %> san pham.
    <br>
    So tien ban can thanh toan la <b><%= soLuongSanPham * 5 %>$</b>.

</p>
<p></b>
    Ban se nhan duoc thong bao qua email: <b><%= email %>
    </b></p>
</body>
</html>
