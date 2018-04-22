<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>delete exercises</title>
</head>
<body>
<%@ include file="../header.jsp" %>
<h1>Delete exercise</h1>
<p>
<h3>Are you sure to delete the exercise data? You cannot undo the changes.</h3>
<form action="/deleteExcercise" method="post">
    <input type="radio" name="accept" value="no" checked> no<br>
    <input type="radio" name="accept" value="yes"> yes<br>
    <input type="submit" value="submit">
</form>
</p>

<a href="/exerciseManager">Go back to exercise manager</a>
<%@ include file="../footer.jsp" %>

</body>
</html>
