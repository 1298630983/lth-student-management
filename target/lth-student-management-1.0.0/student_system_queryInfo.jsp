<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>按学生姓名查找科创信息</title>
    <script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="bootstrap/bootstrap.min.js"></script>
    <link rel="stylesheet" href="bootstrap/bootstrap.min.css" type="text/css">
</head>
<body>
<form action="/studentSystemServlet?opt=query" method="post">
    请输入学生姓名：<input name="student_name" type="text"  />
    <input type="submit" value="查找" />
</form>
</body>
</html>
