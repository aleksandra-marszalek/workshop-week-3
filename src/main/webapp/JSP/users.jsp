<%--
  Created by IntelliJ IDEA.
  User: janmadej
  Date: 22.04.2018
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Users</title>
</head>
<body>
<%@ include file="header.jsp" %>

<h1>All Groups</h1>
<p>
<table>
    <tr>
        <th>User id</th>
        <th>User name</th>
        <th>Details</th>
    </tr>
    <c:forEach items="${allUsers}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td><a href="/userinfo?id=${user.id}"> details </a></td>
        </tr>
    </c:forEach>
</table>
</p>


<%@ include file="footer.jsp" %>

</body>
</html>
