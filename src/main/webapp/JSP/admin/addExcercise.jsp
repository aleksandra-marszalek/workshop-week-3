<%--
  Created by IntelliJ IDEA.
  User: janmadej
  Date: 22.04.2018
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Add exercise</title>
</head>
<body>
<%@ include file="../header.jsp" %>
<h1>Add new exercise</h1>
<form action="/addExcercise" method="POST">
    <label>
        title:
        <input type="text" name="title">
    </label>
    <label>
        description:
        <input type="text" name="description">
    </label>
    <input type="submit" value="submit">

</form>
<a href="/excerciseManager">Go back to excercise manager</a>
<%@ include file="../footer.jsp" %>
</body>
</html>
