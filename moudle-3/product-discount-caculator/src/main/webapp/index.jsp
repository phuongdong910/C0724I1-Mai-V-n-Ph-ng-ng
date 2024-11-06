<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Discount Calculator</title>
</head>
<body>
<h1>Product  Discount  Caculator</h1>
<form action="display-discount" method="post">
    <lable for="productDescription">Product Description</lable>
    <input type="text" id="productDescription" name="productDescription"><br><br>

    <label for="listPrice">List Price</label>
    <input type="text" id="listPrice" name="listPrice"><br><br>

    <label for="discountPercent">Discount Percent</label>
    <input type="text" id="discountPercent" name="discountPercent"><br><br>

    <button type="submit">Caculate Discount</button>
</form>
</body>
</html>