<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户搜索</title>
    <script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="bootstrap/bootstrap.min.js"></script>
    <link rel="stylesheet" href="bootstrap/bootstrap.min.css" type="text/css">
</head>
<body>
<div class="input-group col-md-3" style="margin-top:0px;positon:relative">
    <form action="" method="post">
        <input id="txtSearch" name="name" type="text" style="border: 1px solid #000; width: 128px;" />
        <input type="submit" value="搜索" />
        <div id="searchResult" style="border: 1px solid #000; width: 126px; border-top: 0; margin-top: -1px; display: none;">

        </div>
    </form>
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

<script type="text/javascript">
    $(function() {
        var flag = 0;
        $("#txtSearch").on("keyup", function() {
            if (flag == 0) {
                flag = 1;
                setTimeout(function() {
                    var result = $("#txtSearch").val();
                    $.ajax({
                        url: "sysUserServletApi",
                        data: {
                            "name": result
                        },
                        dataType: "json",
                        success: function(data) {
                            var searchResult = "";
                            if (data == null || data.length == 0) {
                                $("#searchResult").hide();
                            }
                            if (data != null && data.length > 0) {
                                for (var i = 0 ; i < data.length ; i++) {
                                    searchResult += "<div>" + data[i].loginId + "</div>";
                                }
                                $("#searchResult").show();
                                $("#searchResult").html(searchResult);
                            }
                            flag = 0;
                        }
                    });
                }, 500);
            }
        });
    });
</script>
</body>
</html>
