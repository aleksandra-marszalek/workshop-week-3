<%--
  Created by IntelliJ IDEA.
  User: janmadej
  Date: 22.04.2018
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>delete user</title>
</head>
<body>
<%@ include file="../header.jsp" %>
<h1>Delete user</h1>
<p>
<h3>Are you sure to delete the user data? You cannot undo the changes.</h3>
<form action="/deleteUser" method="post">
    <input type="radio" name="accept" value="no" checked> no<br>
    <input type="radio" name="accept" value="yes"> yes<br>
    <input type="submit" value="submit">
</form>
</p>

<a href="/usersManager">Go back to users manager</a>
<%@ include file="../footer.jsp" %>

</body>
</html>