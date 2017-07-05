<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询结果</title>
    <script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="bootstrap/bootstrap.min.js"></script>
    <link rel="stylesheet" href="bootstrap/bootstrap.min.css" type="text/css">
</head>
<body style="font-size: 20px">
<div>
    <a href="/studentSystemServlet?opt=queryInfo">按学生姓名查找科创信息</a>
    <a href="studentSystemServlet?opt=list">返回</a>
</div>
<table class="table table-condensed">
    <thead>
    <tr>
        <th>序号</th>
        <th>学生姓名</th>
        <th>所属部门</th>
        <th>学科竞赛</th>
        <th>软件著作权</th>
        <th>专利</th>
        <th>论文</th>
        <th>科研项目</th>
    </thead>
    <tbody>
    <c:forEach items="${studentSystems}" var="studentSystem" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${studentSystem.student_name}</td>
            <td>${studentSystem.student_department}</td>
            <td>${studentSystem.student_competition}</td>
            <td>${studentSystem.student_copyright}</td>
            <td>${studentSystem.student_patent}</td>
            <td>${studentSystem.student_paper}</td>
            <td>${studentSystem.student_project}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
