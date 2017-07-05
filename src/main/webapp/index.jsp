<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="bootstrap/bootstrap.min.js"></script>
    <link rel="stylesheet" href="bootstrap/bootstrap.min.css" type="text/css">
</head>
<body>
    <c:if test="${message != null}">
        <div style="color: red">${message}</div>
    </c:if>
    <div id="myCarousel" class="carousel slide">
        <!-- 轮播（Carousel）指标 -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <!-- 轮播（Carousel）项目 -->
        <div class="carousel-inner">
            <div class="item active">
                <img src="pictures/banner1.jpg" alt="First slide">
            </div>
            <div class="item">
                <img src="pictures/banner2.jpg" alt="Second slide">
            </div>
            <div class="item">
                <img src="pictures/banner3.jpg" alt="Third slide">
            </div>
        </div>
        <!-- 轮播（Carousel）导航 -->
        <a class="carousel-control left" href="#myCarousel"
           data-slide="prev">&lsaquo;
        </a>
        <a class="carousel-control right" href="#myCarousel"
           data-slide="next">&rsaquo;
        </a>
    </div>
    <h1 style="font-family: 微软雅黑;text-align: center">欢迎来到学生科创信息管理系统！</h1>

    <form class="form-horizontal" role="form" action="/loginServlet?opt=login" method="post">
        <div class="form-group">
            <label for="firstname" class="col-sm-2 control-label">用户名</label>
            <div class="col-sm-10">
                <input type="text" name="loginId" class="form-control" id="firstname" placeholder="请输入用户名">
            </div>
        </div>
        <div class="form-group">
            <label for="lastname" class="col-sm-2 control-label">密码</label>
            <div class="col-sm-10">
                <input type="password" name="loginPass" class="form-control" id="lastname" placeholder="请输入密码">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">登录</button>
            </div>
        </div>
    </form>
</body>
</html>
