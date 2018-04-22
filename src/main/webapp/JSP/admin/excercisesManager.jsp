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
    <title>Excercises manager</title>
</head>
<body>
<%@ include file="../header.jsp" %>

<h1>All Exercises</h1>
<p>
    <a href="/addExcercise"> Add new exercise </a>
</p>
<p>
<table>
    <tr>
        <th>Exercise id</th>
        <th>Exercise title</th>
        <th>Exercise description</th>
        <th>More...</th>
    </tr>
    <c:forEach items="${allExcercises}" var="excercise">
        <tr>
            <td>${excercise.id}</td>
            <td>${excercise.title}</td>
            <td>${excercise.description}</td>
            <td><a href="/editExcercise?id=${excercise.id}">edit</a>&nbsp;&nbsp;
                <a href="/deleteExcercise?id=${excercise.id}">delete</a>&nbsp;&nbsp;
                <a href="/assignExcercise?id=${excercise.id}">assign to User</a></td>
        </tr>
    </c:forEach>
</table>
</p>