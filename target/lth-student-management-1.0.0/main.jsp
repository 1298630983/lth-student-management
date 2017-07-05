<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
    <script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="bootstrap/bootstrap.min.js"></script>
    <link rel="stylesheet" href="bootstrap/bootstrap.min.css" type="text/css">
</head>
<body>

    <nav class="navbar navbar-default" role="navigation" style="height: 60px">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="index.jsp" style="font-family: 微软雅黑;color: #080808;font-weight: 100;font-size: 20px">科创信息管理系统</a>
            </div>
            <div style="font-size: 15px">
                <ul class="nav navbar-nav">
                    <li><a href="/sysUserServlet?opt=list">用户管理</a></li>
                    <li><a href="/studentSystemServlet?opt=list">学生科创信息管理</a></li>
                    <li><a href="/loginOutServlet">退出登录</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <div id="myCarousel1" class="carousel slide" style="margin-top: -20px">
        <!-- 轮播（Carousel）指标 -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel1" data-slide-to="0"></li>
            <li data-target="#myCarousel1" data-slide-to="1" class="active"></li>
            <li data-target="#myCarousel1" data-slide-to="2"></li>
        </ol>
        <!-- 轮播（Carousel）项目 -->
        <div class="carousel-inner">
            <div class="item">
                <img src="pictures/banner1.jpg" alt="First slide">
            </div>
            <div class="item active">
                <img src="pictures/banner2.jpg" alt="Second slide">
            </div>
            <div class="item">
                <img src="pictures/banner3.jpg" alt="Third slide">
            </div>
        </div>
        <!-- 轮播（Carousel）导航 -->
        <a class="carousel-control left" href="#myCarousel1"
           data-slide="prev">&lsaquo;
        </a>
        <a class="carousel-control right" href="#myCarousel1"
           data-slide="next">&rsaquo;
        </a>
    </div>

</body>
</html>
