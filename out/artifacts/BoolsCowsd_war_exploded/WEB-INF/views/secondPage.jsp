<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Second Page</title>
</head>
<body>
Введенное имя: ${userJSP.name};
<br/>
Введенный пароль: ${userJSP.password};
<br/>
<ul>
    <li><a href="/show">Играть</a></li>
    <li><a href="/showStat">Посмотреть статистику</a></li>
</ul>
</body>
</html>
