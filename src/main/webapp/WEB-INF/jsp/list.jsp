<%--
  Created by IntelliJ IDEA.
  User: 17363
  Date: 2017/12/22
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/queryEmp.do" method="post">
        员工姓名：<input type="text" name="name" value="${param.name}"/>
        员工ID：<input type="text" name="id" value="${param.id}">
        <input type="submit" value="搜索"/>
    </form>
    <table>
        <tr>
            <td>id</td>
            <td>姓名</td>
            <td>入职日期</td>
            <td>部门</td>
        </tr>
        <c:forEach items="${employeeList}" var="emp">
            <tr>
                <td>${emp.id}</td>
                <td>${emp.name}</td>
                <td>${emp.hireDate}</td>
                <td>${emp.dept.name}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
