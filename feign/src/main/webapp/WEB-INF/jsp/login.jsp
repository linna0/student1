<%--
  Created by IntelliJ IDEA.
  User: yln
  Date: 2022/5/28
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>教师登录</small>
                </h1>
            </div>
        </div>
    </div>

<form action="${pageContext.request.contextPath}/feign/login" method="post">
    工号：<input type="text" name="t_no" class="form-control"><br><br><br>
    教师姓名：<input type="text" name="t_name" class="form-control"><br><br><br>
    <%--        这里的name的大小写要识别清楚哦，因为是间接对应了Mapper里面的数的--%>
    <input type="submit" value="登录" class="btn btn-primary">
    <a href="${pageContext.request.contextPath}/feign/register.html">没有账号，去注册</a>
</form>
</div>
</body>
</html>
