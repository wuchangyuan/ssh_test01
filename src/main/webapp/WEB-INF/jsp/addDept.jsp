<%--
  Created by IntelliJ IDEA.
  User: 17363
  Date: 2017/12/22
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/queryDept.do" method="post">
        部门名称：<input type="text" name="name" value="${dept.name}"/>${msg}<br>
        <input type="submit" value="添加"/>
    </form>
</body>
</html>
