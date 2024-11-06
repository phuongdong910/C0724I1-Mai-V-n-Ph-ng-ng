<%@ page import="java.util.List" %>
<%@ page import="com.example.thimoudle3.model.entity.Room" %>
<%@ page import="com.example.thimoudle3.model.entity.PaymentType" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Room List</title>
</head>
<body>
<h1>Room List</h1>

<!-- Search Form -->
<form method="get">
    <input type="text" name="searchQuery" placeholder="Search by tenant name" />
    <button type="submit">Search</button>
</form>

<table>
    <thead>
    <tr>
        <th>Room ID</th>
        <th>Tenant Name</th>
        <th>Phone Number</th>
        <th>Start Date</th>
        <th>Payment Type</th>
        <th>Notes</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="room" items="${rooms}">
        <tr>
            <td>${room.roomId}</td>
            <td>${room.tenantName}</td>
            <td>${room.phoneNumber}</td>
            <td>${room.startDate}</td>
            <td>
                <c:forEach var="paymentType" items="${paymentTypes}">
                    <c:if test="${room.paymentMethodId == paymentType.id}">
                        ${paymentType.type}
                    </c:if>
                </c:forEach>
            </td>
            <td>${room.notes}</td>
            <td>
                <a href="/room?action=delete&roomId=${room.roomId}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
