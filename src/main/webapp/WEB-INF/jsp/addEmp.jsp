<%--
  Created by IntelliJ IDEA.
  User: 17363
  Date: 2017/12/22
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/addEmp.do" method="post">

        部门：<select name="ID">
        <c:forEach items="${deptList}" var="dept">
            <option value="${dept.id}" ${employee.dept.id==dept.id?"selected=selected":""} >${dept.name}</option>
        </c:forEach>

    </select><br/>
        员工姓名：<input type="text" name="name"/><br/>
        入职日期：<input type="text" name="hireDate"><br>
        <input type="submit" value="提交"/>
    </form>

</body>
</html>
