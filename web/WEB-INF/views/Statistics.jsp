<%--
  Created by IntelliJ IDEA.
  User: Александр
  Date: 17.11.2016
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <th>Пользователь</th><th>Среднее число попыток до угадывания</th>
  </tr>
  </thead>
  <c:forEach items="${statistics}" var="s">
    <td>${s.getUser().getName()}</td>
    <td>${s.getAverageAttempt()}</td>
  </c:forEach>
</table>
</body>
</html>
