<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Edit exercise</title>
</head>
<body>
<%@ include file="../header.jsp" %>
<h1>Edit exercise</h1>
<form action="/editExcercise" method="POST">
    <label>
        Title:
        <input type="text" name="title">
    </label>
    <label>
        Description:
        <input type="text" name="description">
    </label>
    <input type="submit" value="submit">

</form>
<a href="/excerciseManager">Go back to exercises manager</a>
<%@ include file="../footer.jsp" %>
</body>
</html>
