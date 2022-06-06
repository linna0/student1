<%--
  Created by IntelliJ IDEA.
  User: yln
  Date: 2022/5/28
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<% pageContext.setAttribute("path", request.getContextPath());%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<html>
<head>
    <title>教师注册</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>教师注册</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/feign/register" method="post">
<%--        <p style="color: red" th:text="${msg}" th:if="${not #strings.isEmpty(msg)}"></p>--%>
        工号：<input type="text" name="t_no" class="form-control"><br><br><br>
        教师姓名：<input type="text" name="t_name" class="form-control"><br><br><br>
        性别：<input type="text" name="t_gender" class="form-control"><br><br><br>
        所属系：<input type="text" name="t_department"class="form-control"><br><br><br>
        职称：<input type="text" name="t_job" class="form-control"><br><br><br>
        授课编号：<input type="text" name="t_lecturenumber" class="form-control"><br><br><br>
        <%--        这里的name的大小写要识别清楚哦，因为是间接对应了Mapper里面的数的--%>
        <input type="submit" value="注册" class="btn-primary btn">
        <a href="${pageContext.request.contextPath}/feign/login.html">已有账号，去登录</a>
    </form>
</div>
</body>
</html>