<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 11/4/2024
  Time: 10:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="header.jsp" %>
<div class="container mt-5">
  <h1>Danh sách sản phẩm</h1>
  <div class="row">
    <c:forEach var="product" items="${products}">
      <div class="col-md-3">
        <div class="card mb-4 shadow-sm">
          <img src="${product.image}" class="card-img-top" alt="${product.name}">
          <div class="card-body">
            <h5 class="card-title">${product.name}</h5>
            <p class="card-text">${product.price} VND</p>
            <a href="${pageContext.request.contextPath}/productDetail.jsp?id=${product.id}" class="btn btn-primary">Xem chi tiết</a>
          </div>
        </div>
      </div>
    </c:forEach>
  </div>
</div>
<%@ include file="footer.jsp" %>
