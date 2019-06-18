<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Users</h2>
<table border="1" cellpadding="8" cellspacing="0">
    <thead>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>email</th>
        <th>enabled</th>
        <th>registered</th>
        <th>roles</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <jsp:useBean id="user" type="ru.javawebinar.topjava.model.User" />
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.enabled}</td>
            <td>${user.registered}</td>
            <td>${user.roles}</td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>