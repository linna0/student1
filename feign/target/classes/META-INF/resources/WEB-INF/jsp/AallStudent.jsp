<%--
  Created by IntelliJ IDEA.
  User: yln
  Date: 2022/6/4
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/common/index.jsp" %>
<html>
<head>
    <title>学生</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container" style="width:900px;margin: auto">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>学生列表 —— 管理员浏览所有学生信息</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="column col-4" style="padding-left:50px;padding-bottom:0">
        <form action="${pageContext.request.contextPath}/feign/AselectstudentById" method="post" class="form-inline">
            <input type="text" name="s_id" placeholder="请输入查询的学生学号" class="form-control">
            <input type="submit" value="查询"  class="btn btn-primary" >
            <button class="btn btn-primary"><a href="${pageContext.request.contextPath}/feign/Aselectstudent" style="color: white;">查询全部信息</a></button>
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
                </tr>
                </thead>
                <tbody>
                <c:forEach var="student" items="${requestScope.get('student')}" varStatus="status">
                    <tr>
                        <td>${student.s_id}</td>
                        <td>${student.s_name}</td>
                        <td>${student.s_number}</td>
                        <td>${student.s_gender}</td>
                        <td>${student.s_school}</td>
                        <td>${student.s_pro}</td>
                        <td>${student.s_telephone}</td>
                        <td>${student.s_address}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/feign/toalertStudent/${student.getS_id()}"><img src="${pageContext.request.contextPath}/images/modify.png"></a>

                            <a href="${pageContext.request.contextPath}/feign/delStudent/${student.getS_id()}"><img src="${pageContext.request.contextPath}/images/delete.png"></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
