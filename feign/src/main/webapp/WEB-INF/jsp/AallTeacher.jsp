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
    <title>教师</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container" style="width:900px;margin: auto">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>教师列表 —— 管理员浏览所有教师信息</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="column col-4" style="padding-left:50px;padding-bottom:0">
        <form action="${pageContext.request.contextPath}/feign/AselectteacherById" method="post" class="form-inline">
            <input type="text" name="t_no" placeholder="请输入查询的教师账号" class="form-control">
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
                    <th>工号</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>所属系</th>
                    <th>职称</th>
                    <th>授课编号</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="teacher" items="${requestScope.get('teacher')}" varStatus="status">
                    <tr>
                        <td>${teacher.t_no}</td>
                        <td>${teacher.t_name}</td>
                        <td>${teacher.t_gender}</td>
                        <td>${teacher.t_department}</td>
                        <td>${teacher.t_job}</td>
                        <td>${teacher.t_lecturenumber}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/feign/toalertTeacher/${teacher.getT_no()}"><img src="${pageContext.request.contextPath}/images/modify.png"></a>
                            <a href="${pageContext.request.contextPath}/feign/delTeacher/${teacher.getT_no()}"><img src="${pageContext.request.contextPath}/images/delete.png"></a>
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
