<%--无效页面，但留着也行--%>
<% pageContext.setAttribute("path", request.getContextPath());%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>学生列表</title>
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
                    <small>学生列表 —— 浏览所有学生信息</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="column col-4" style="padding-left:50px;padding-bottom:0">
        <form action="${pageContext.request.contextPath}/feign/selectById" method="post" class="form-inline">
            <input type="text" name="s_id" placeholder="请输入查询的学生学号" >
            <input type="submit" value="查询" class="btn btn-primary">
        </form>
        </p>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>学号</th>
                    <th>姓名</th>
                    <th>账号</th>
                    <th>性别</th>
                    <th>学院</th>
                    <th>专业</th>
                    <th>联系方式</th>
                    <th>家庭住址</th>
                    <th>课程名字</th>
                    <th>分数</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="student" items="${requestScope.get('collection')}" varStatus="status">
                    <tr>
                        <td>${student.s_id}</td>
                        <td>${student.s_name}</td>
                        <td>${student.s_number}</td>
                        <td>${student.s_gender}</td>
                        <td>${student.s_school}</td>
                        <td>${student.s_pro}</td>
                        <td>${student.s_telephone}</td>
                        <td>${student.s_address}</td>
                        <td>${student.c_no}</td>
                        <td>${student.c_score}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/feign/toupdateStudent?s_id=${student.getS_id()}&c_no=${student.getC_no()}">更改</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>