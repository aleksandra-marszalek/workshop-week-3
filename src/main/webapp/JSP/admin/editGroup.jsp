<%--
  Created by IntelliJ IDEA.
  User: janmadej
  Date: 22.04.2018
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Edit group</title>
</head>
<body>
<%@ include file="../header.jsp" %>
<h1>Edit group</h1>
<form action="/editGroup" method="POST">
    <label>
        Name:
        <input type="text" name="groupName">
    </label>
    <input type="submit" value="submit">

</form>
<a href="/groupsManager">Go back to groups manager</a>
<%@ include file="../footer.jsp" %>
</body>
</html>
