<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增科创信息</title>
    <script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="bootstrap/bootstrap.min.js"></script>
    <link rel="stylesheet" href="bootstrap/bootstrap.min.css" type="text/css">
</head>
<body>

<form class="form-horizontal" role="form" action="/studentSystemServlet?opt=insert" method="post">
    <div class="form-group">
        <label for="firstname" class="col-sm-2 control-label">学生姓名</label>
        <div class="col-sm-10">
            <input type="text" name="student_name" class="form-control" id="firstname" placeholder="请输入学生姓名">
        </div>
    </div>
    <div class="form-group">
        <label for="lastname" class="col-sm-2 control-label">所属部门</label>
        <div class="col-sm-10">
            <input type="text" name="student_department" class="form-control" id="lastname" placeholder="请输入所属部门">
        </div>
    </div>
    <div class="form-group">
        <label for="lastname1" class="col-sm-2 control-label">学科竞赛</label>
        <div class="col-sm-10">
            <input type="text" name="student_competition" class="form-control" id="lastname1" placeholder="请输入学科竞赛">
        </div>
    </div>
    <div class="form-group">
        <label for="lastname2" class="col-sm-2 control-label">软件著作权</label>
        <div class="col-sm-10">
            <input type="text" name="student_copyright" class="form-control" id="lastname2" placeholder="请输入软件著作权">
        </div>
    </div>
    <div class="form-group">
        <label for="lastname3" class="col-sm-2 control-label">专利</label>
        <div class="col-sm-10">
            <input type="text" name="student_patent" class="form-control" id="lastname3" placeholder="请输入专利">
        </div>
    </div>
    <div class="form-group">
        <label for="lastname4" class="col-sm-2 control-label">论文</label>
        <div class="col-sm-10">
            <input type="text" name="student_paper" class="form-control" id="lastname4" placeholder="请输入论文">
        </div>
    </div>
    <div class="form-group">
        <label for="lastname5" class="col-sm-2 control-label">科研项目</label>
        <div class="col-sm-10">
            <input type="text" name="student_project" class="form-control" id="lastname5" placeholder="请输入科研项目">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">添加</button>
        </div>
    </div>
</form>
</body>
</html>
