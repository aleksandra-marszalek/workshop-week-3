<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Users manager</title>
</head>
<body>
<%@ include file="../header.jsp" %>

<h1>All Users</h1>
<p>
    <a href="/addUser"> Add new user </a>
</p>
<p>
<table>
    <tr>
        <th>User id</th>
        <th>Name </th>
        <th>Email </th>
        <th>Password</th>
        <th>Group id </th>
        <th>More...</th>
    </tr>
    <c:forEach items="${allUsers}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td>${user.password}</td>
            <td>${user.user_group_id}</td>
            <td><a href="/editUser?id=${user.id}">edit</a>&nbsp;&nbsp;<a href="/deleteUser?id=${user.id}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</p>


<%@ include file="../footer.jsp" %>
</body>
</html>
