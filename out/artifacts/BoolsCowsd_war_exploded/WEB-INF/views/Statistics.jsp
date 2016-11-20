<%--
  Created by IntelliJ IDEA.
  User: Александр
  Date: 17.11.2016
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Статистика пользователей</title>
  <script src="/resources/jquery-2.1.4.min.js" type="text/javascript"></script>
  <script src="/resources/bootstrap.min.js" type="text/javascript"></script>
  <link href="/resources/bootstrap.min.css" rel="stylesheet">
  <link href="/resources/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
<table class="table table-striped table-hover">
  <thead>
  <tr>
    <th>Статистические показатели</th>>
  </tr>
  </thead>
  <c:forEach items="${statistics}" var="s">
    <tr>
    <td>${s.toString()}</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
