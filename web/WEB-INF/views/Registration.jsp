<%--
  Created by IntelliJ IDEA.
  User: sss
  Date: 19.11.16
  Time: 0:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <script src="/resources/jquery-2.1.4.min.js" type="text/javascript"></script>
  <script src="/resources/bootstrap.min.js" type="text/javascript"></script>
  <script src="/resources/registration.js" type="text/javascript"></script>
  <link href="/resources/bootstrap.min.css" rel="stylesheet">
  <link href="/resources/bootstrap-theme.min.css" rel="stylesheet">
    <title>Регистрация</title>
</head>
<body>
<div id="registrationForm">
    <p>Вы не зарегистрированы. Предлагаем пройти регистрацию</p>
      <label>Введите Ваше имя</label><input type="text" id="userName" max="20"><br>
      <label>Введите Ваш пароль</label><input type="text" id="userPassword" max="20"><br>
      <label>Повторите введенный пароль</label><input type="text" id="retypePassword" maxlength="20"><br>
      <input type="button" value="Зарегистрироваться" onclick="SendData()"><input type="button" value="Очистить" onclick="onClear()">
</div>
</body>
</html>
