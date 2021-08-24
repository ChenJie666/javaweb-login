<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/14
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>登陆</h1>
<form action="${pageContext.request.contextPath}/sys/login" method="get">
    用户名:<input type="text" name="username"> <br>
    密码:<input type="password" name="password"> <br>
    <input type="submit">
</form>
</body>
</html>
