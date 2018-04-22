<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: janmadej
  Date: 22.04.2018
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Solution</title>
</head>
<body>
<%@ include file="header.jsp" %>


<h1>Details of the solution</h1>
<p><h3>Nr of excercise:</h3> <c:out value="${solution.excercise_id}" default="ex id"/></p>
<p><h3>Solution given:</h3>
    <c:out value="${solution.description}" default="no description provided"/>
</p>

<%@ include file="footer.jsp" %>
</body>
</html>
