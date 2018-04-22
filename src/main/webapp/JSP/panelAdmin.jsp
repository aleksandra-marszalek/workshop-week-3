<%--
  Created by IntelliJ IDEA.
  User: janmadej
  Date: 22.04.2018
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Admin Panel</title>
</head>
<body>
<%@ include file="header.jsp" %>
<table>
    <tr>
        <td><a href="/groupsManager">Groups manager</a></td>
    </tr>
    <tr>
        <td><a href="/usersManager">Users manager</a></td>
    </tr>
    <tr>
        <td><a href="excerciseManager">Excercise manager</a></td>
    </tr>
</table>

<%@ include file="footer.jsp" %>
</body>
</html>
