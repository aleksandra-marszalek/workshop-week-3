<%--
  Created by IntelliJ IDEA.
  User: janmadej
  Date: 20.04.2018
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>add user</title>
</head>
<body>
<form action="/addUser" method="POST">
    <label>
        Name:
        <input type="text" name="username">
    </label>
    <label>
        Email:
        <input type="text" name="email">
    </label>
    <label>
        password:
        <input type="text" name="password">
    </label>
    <label>
        user group id:
        <input type="number" name="userId">
    </label>
    <input type="submit" value="submit">

</form>
<a href="/usersManager">Go back to users manager</a>
</body>
</html>
