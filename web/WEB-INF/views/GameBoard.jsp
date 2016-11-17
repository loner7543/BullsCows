<%--
  Created by IntelliJ IDEA.
  User: Александр
  Date: 17.11.2016
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
    <title>Game board</title>
  <script src="../../resources/jquery-2.1.4.min.js" type="text/javascript"></script>
  <script src="../../resources/gameBoard.js" type="text/javascript"></script>
</head>
<body>
<input type="button" value="Новая игра" onclick="click()">
<label>Введите Ваш ваиант числа</label><input type="text" id="userDigit"><br>
<input type="button" value="Угадать"onclick="userAttempt()">
</body>
</html>
