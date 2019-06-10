<%--
  Created by IntelliJ IDEA.
  User: alexbelke
  Date: 2019-06-10
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://example.com/functions" prefix="f" %>
<html>
<head>
    <title>User Meals</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h1>User Meals</h1>
<p>Meals size ${meals.size()}</p>
<table cellspacing="1" cellpadding="1">
    <thead>
    <tr>
        <td>Название</td>
        <td>Калории</td>
        <td>Время</td>
        <td>Exceed</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="meal" items="${meals}">
        <tr>
            <td>${meal.description}</td>
            <td>${meal.calories}</td>
            <td>${f:formatLocalDateTime(meal.dateTime, 'dd.MM.yyyy HH:MM:SS')}</td>
            <td>${meal.excess}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>
