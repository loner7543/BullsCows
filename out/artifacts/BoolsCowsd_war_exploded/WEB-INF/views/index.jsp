
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
  <title>Index Page</title>
  <script src="/resources/jquery-2.1.4.min.js" type="text/javascript"></script>
  <script src="/resources/index.js" type="text/javascript"></script>
  <script src="/resources/bootstrap.min.js" type="text/javascript"></script>
  <link href="/resources/bootstrap.min.css" rel="stylesheet">
  <link href="/resources/bootstrap-theme.min.css" rel="stylesheet">
</head>

<body>
  <div id="signInForm">
  Name: <input type="text" id="name"><br/>
  Password: <input type="text" id="pass">  <br/>
<input type="button" value="Войти" onclick="signIn()">
  </div>

</body>

</html>
