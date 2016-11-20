<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <meta charset="UTF-8">
    <title>Game board</title>
  <script src="/resources/jquery-2.1.4.min.js" type="text/javascript"></script>
  <script src="/resources/gameBoard.js" type="text/javascript"></script>
  <script src="/resources/bootstrap.min.js" type="text/javascript"></script>
  <link href="/resources/bootstrap.min.css" rel="stylesheet">
  <link href="/resources/bootstrap-theme.min.css" rel="stylesheet">
  <link href="/resources/Game.css" rel="stylesheet">
</head>
<body>
<p>Компьютер загадал четырехзнвчное число. Вам предлагается его отдагать</p>
<label>Введите Ваш ваиант  числа</label><input type="text" id="userDigit" maxlength="4"><br>
<input type="button" value="Угадать" onclick="userAttempt()" class="btn-success btn-md"><br>
<label>Предыдущие попытки</label>
<ul id="attemptList">
  <c:forEach items="${Log}" var="item">
    <li>${item}</li>
  </c:forEach>
</ul>

<a href="/showStat">Посмотреть статистику</a>
</body>
</html>
