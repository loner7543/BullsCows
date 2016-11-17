<!-- обратите внимание на spring тэги -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
  <title>Index Page</title>
  <script src="/resources/jquery-2.1.4.min.js" type="text/javascript"></script>
  <script src="/resources/gameBoard.js" type="text/javascript"></script>
  <script src="/resources/bootstrap.min.js" type="text/javascript"></script>
  <link href="/resources/bootstrap.min.css" rel="stylesheet">
  <link href="/resources/bootstrap-theme.min.css" rel="stylesheet">
</head>

<body>
<spring:form method="post"  modelAttribute="userJSP" action="check-user">

  Name: <spring:input path="name"/><br/>
  Password: <spring:input path="password"/>   <br/>
  <spring:button>Next Page</spring:button>

</spring:form>

</body>

</html>
