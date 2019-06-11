<%--
  Created by IntelliJ IDEA.
  User: alexbelke
  Date: 2019-06-11
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <title>Edit Meal</title>
</head>
<body>
<form action="meals" method="post">
    <input hidden name="id" value="${editMeal.id}"/>
    <label>Description</label>
    <input name="description" value="${editMeal.description}">
    <label>Калории</label>
    <input type="number" name="calories" value="${editMeal.calories}">
    <label>Время</label>
    <input type="datetime-local" name="dateTime" value="${editMeal.dateTime}">
    <button type="submit">Submit</button>
</form>
</body>
</html>
