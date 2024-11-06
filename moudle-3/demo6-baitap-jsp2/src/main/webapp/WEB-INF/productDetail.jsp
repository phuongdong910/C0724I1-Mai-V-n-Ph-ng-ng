<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 11/4/2024
  Time: 10:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="header.jsp" %>
<div class="container mt-5">
    <h1>${product.name}</h1>
    <div class="row">
        <div class="col-md-6">
            <img src="${product.image}" alt="${product.name}" class="img-fluid">
        </div>
        <div class="col-md-6">
            <h2>${product.price} VND</h2>
            <p>${product.description}</p>
            <form action="${pageContext.request.contextPath}/addToCart" method="post">
                <input type="hidden" name="productId" value="${product.id}">
                <button type="submit" class="btn btn-success">Thêm vào giỏ hàng</button>
            </form>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
