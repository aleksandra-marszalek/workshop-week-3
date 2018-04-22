<%--
  Created by IntelliJ IDEA.
  User: janmadej
  Date: 22.04.2018
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>delete group</title>
</head>
<body>
<%@ include file="../header.jsp" %>
<h1>Delete group</h1>
<p>
<h3>Are you sure to delete all this group? All the user data from this group will also be deleted.</h3>
<form action="/deleteGroup" method="post">
    <input type="radio" name="accept" value="no" checked> no<br>
    <input type="radio" name="accept" value="yes"> yes<br>
    <input type="submit" value="submit">
</form>
</p>
<h3>All Users in this group</h3>
<p>
<table>
    <tr>
        <th>User id</th>
        <th>User name</th>
    </tr>
    <c:forEach items="${allUsers}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
        </tr>
    </c:forEach>
</table>
</p>


<%@ include file="../footer.jsp" %>

</body>
</html>
