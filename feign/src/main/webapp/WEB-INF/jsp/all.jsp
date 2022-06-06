<%--
  Created by IntelliJ IDEA.
  User: yln
  Date: 2022/6/2
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<% pageContext.setAttribute("path", request.getContextPath());%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/common/mallIndex.jsp" %>

<html>
<head>
    <title>学生列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/public.css"/>
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
            <input type="text" name="s_id" placeholder="请输入查询的学生学号" class="form-control">
            <input type="submit" value="查询"  id="searchbutton">
        </form>
        </p>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>教师名</th>
                    <th>课程号</th>
                    <th>课程名</th>
                    <th>学分</th>
                    <th>学时</th>
                    <th>学时</th>
                    <th>学生学号</th>
                    <th>学生姓名</th>
                    <th>分数</th>
                    <th>更改</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                <c:forEach var="teacher" items="${requestScope.get('s2')}" varStatus="status" step="1">
                    <td>${teacher}</td>
<%--                    <tr>--%>
<%--                        <td>${teacher.value}</td>--%>
<%--                        <td>${teacher.Courses.c_no}</td>--%>
<%--                        <td>${teacher.Courses.c_name}</td>--%>
<%--                        <td>${teacher.Courses.c_credit}</td>--%>
<%--                        <td>${teacher.Courses.c_semaster}</td>--%>
<%--                        <td>${teacher.Courses.c_studyhour}</td>--%>
<%--                        <td>${teacher.student.s_id}</td>--%>
<%--                        <td>${teacher.student.s_name}</td>--%>
<%--                        <td>${teacher.Scourse.c_score}</td>--%>

<%--                    </tr>--%>



                <c:if test="${status.count%9==0}">
                    <c:forEach var="num1" items="${requestScope.get('num1')}" varStatus="n" step="1">
                    <c:forEach var="s3" items="${requestScope.get('s3')}" varStatus="s" step="1">
                    <c:if test="${status.count/9==n.count&&status.count/9==s.count}">
                    <td><a href="${pageContext.request.contextPath}/feign/toupdateStudent?s_no=${num1}&c_no=${s3}">
                        <img src="${pageContext.request.contextPath}/images/修改.png" style="width:20px; height: 20px">
                    </a></td>
                    </c:if> </c:forEach></c:forEach><tr></tr>
                </c:if>
                </c:forEach>
                </th>
                </tr>

                </tbody>
            </table>
            <input type="hidden" id="totalPageCount" value="${totalPageCount}"/>

        </div>
    </div>
</div>
</body>
</html>