<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理</title>
    <script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="bootstrap/bootstrap.min.js"></script>
    <link rel="stylesheet" href="bootstrap/bootstrap.min.css" type="text/css">
</head>
<body style="font-size: 20px">
    <div>
        <a href="/sysUserServlet?opt=add">新增用户</a>
        <a href="/sysUserServlet?opt=search">搜索用户</a>
        <a href="main.jsp">返回选项</a>
    </div>
    <table class="table table-condensed">
        <thead>
        <tr>
            <th>序号</th>
            <th>用户名</th>
            <th>操作</th></tr>
        </thead>
        <tbody>
        <c:forEach items="${sysUserList}" var="sysUser" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${sysUser.loginId}</td>
                <td>
                    <a href="/sysUserServlet?opt=edit&id=${sysUser.id}">编辑</a>
                    <a href="/sysUserServlet?opt=delete&id=${sysUser.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
