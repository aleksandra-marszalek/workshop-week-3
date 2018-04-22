<%--
  Created by IntelliJ IDEA.
  User: janmadej
  Date: 22.04.2018
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Groups manager</title>
</head>
<body>
<%@ include file="../header.jsp" %>

<h1>All Groups</h1>
<p>
    <a href="/addGroup"> Add new Group </a>
</p>
<p>
<table>
    <tr>
        <th>Group id</th>
        <th>Group name </th>
        <th>More...</th>
    </tr>
    <c:forEach items="${allGroups}" var="user_group">
        <tr>
            <td>${user_group.id}</td>
            <td>${user_group.name}</td>
            <td><a href="/editGroup?id=${user_group.id}">edit</a>&nbsp;&nbsp;<a href="/deleteGroup?id=${user_group.id}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</p>


<%@ include file="../footer.jsp" %>
</body>
</html>
