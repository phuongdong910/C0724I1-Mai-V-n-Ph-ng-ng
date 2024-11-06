<%@ page import="java.util.List" %>
<%@ page import="com.example.thimoudle3.model.entity.PaymentType" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Room</title>
</head>
<body>
<h1>Add New Room</h1>

<form method="post">
    <label for="tenantName">Tenant Name:</label>
    <input type="text" id="tenantName" name="tenantName" required /><br />

    <label for="phoneNumber">Phone Number:</label>
    <input type="text" id="phoneNumber" name="phoneNumber" required /><br />

    <label for="startDate">Start Date:</label>
    <input type="date" id="startDate" name="startDate" required /><br />

    <label for="paymentTypeId">Payment Type:</label>
    <select id="paymentTypeId" name="paymentTypeId" required>
        <c:forEach var="paymentType" items="${paymentTypes}">
            <option value="${paymentType.id}">${paymentType.type}</option>
        </c:forEach>
    </select><br />

    <label for="notes">Notes:</label>
    <textarea id="notes" name="notes"></textarea><br />

    <button type="submit">Add Room</button>
</form>
</body>
</html>
