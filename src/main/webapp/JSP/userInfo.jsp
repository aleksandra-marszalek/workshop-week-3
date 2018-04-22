<%--
  Created by IntelliJ IDEA.
  User: janmadej
  Date: 22.04.2018
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>user info</title>
</head>
<body>
<%@ include file="header.jsp" %>
<a href="/users?id=${newUser.user_group_id}">Go back to users</a>
<h1>Details of the user: ${newUser.username}</h1>
<h3>E-mail: ${newUser.email}</h3>
<h3>Solutions given: </h3>

<p>
<table>
    <tr>
        <th>Excercise id </th>
        <th>Created</th>
        <th>Details</th>
    </tr>
    <c:forEach items="${allSolutions}" var="solution">
        <tr>
            <td>${solution.excercise_id}</td>
            <td>${solution.updated}</td>
            <td><a href="/solution?id=${solution.id}"> details </a></td>
        </tr>
    </c:forEach>
</table>
</p>
<%@ include file="footer.jsp" %>
</body>
</html>
