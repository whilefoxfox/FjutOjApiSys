<%--
  Created by IntelliJ IDEA.
  User: 迟
  Date: 2019/3/25
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="/dologin" method="post">
    用户名:<input type="text" name="username" id="username"/>
    <br>
    密码:<input type="password" name="password" id="password"/>
    <br>
    <input type="submit" value="登录"/>
</form>
</body>
</html>
