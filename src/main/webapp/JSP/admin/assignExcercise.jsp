<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Assign exercise</title>
</head>
<body>
<%@ include file="../header.jsp" %>
<h1>Assign exercise to the user</h1>
<form action="/assignExcercise" method="POST">
    <label>
        User id to assign the excercise:
        <input type="number" name="userId">
    </label>
    <input type="submit" value="submit">

</form>
<a href="/excerciseManager">Go back to exercises manager</a>
<%@ include file="../footer.jsp" %>
</body>
</html>