
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
  <title>Index Page</title>
  <script src="/resources/jquery-2.1.4.min.js" type="text/javascript"></script>
  <script src="/resources/index.js" type="text/javascript"></script>
  <script src="/resources/bootstrap.min.js" type="text/javascript"></script>
  <link href="/resources/bootstrap.min.css" rel="stylesheet">
  <link href="/resources/bootstrap-theme.min.css" rel="stylesheet">
  <link href="/resources/Game.css" rel="stylesheet">
</head>

<body>

<form class="form-horizontal" role="form">
  <div class="form-group">
    <label class="col-sm-2 control-label">Логин</label>
    <div class="col-sm-5">
      <input type="text" class="form-control" id="name" placeholder="Ваш логин">
    </div>
  </div>

  <div class="form-group">
    <label for="pass" class="col-sm-2 control-label">Пароль</label>
    <div class="col-sm-5">
      <input type="password" class="form-control" id="pass" placeholder="Ваш пароль">
    </div>
  </div>
  <div class="form-group">
  <input type="button" value="Войти" onclick="signIn()" class="col-md-1 col-md-offset-2 btn btn-primary">
  </div>
</form>



</body>

</html>
