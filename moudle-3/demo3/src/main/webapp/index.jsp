<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Caculator</title>
</head>
<body>
<h2> Caculator Application </h2>
<form action="caculate" method="post">
    <label >Operand1</label>
    <input type="number" name="operand1" required>
    <br>

    <label >Operand2</label>
    <input type="number" name="operand2" required>
    <br>

    <label > Choose operator</label>
    <select name="operator" >
        <option value="add">Add</option>
        <option value="subtract">Sub</option>
        <option value="multiply">Multi</option>
        <option value="divide">Div</option>
    </select>
    <br>

    <button></button>
</form>
</body>
</html>