<%--
  Created by IntelliJ IDEA.
  User: janmadej
  Date: 22.04.2018
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="header.jsp" %>

<h1>Last solutions</h1>
<p>
<table>
    <tr>
        <th>Excercise id </th>
        <th>User id </th>
        <th>Created</th>
        <th>Details</th>
    </tr>
    <c:forEach items="${allSolutions}" var="solution">
        <tr>
            <td>${solution.excercise_id}</td>
            <td>${solution.users_id}</td>
            <td>${solution.updated}</td>
            <td><a href="/solution?id=${solution.id}"> details </a></td>
        </tr>
    </c:forEach>
</table>
</p>


<%@ include file="footer.jsp" %>
</body>
</html>
