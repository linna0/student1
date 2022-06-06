<%--
  Created by IntelliJ IDEA.
  User: yln
  Date: 2022/6/6
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body style="background-color: skyblue;">
<h1 style="text-align: center; margin-top: 66px;">学生成绩信息管理系统</h1>
<div style="margin: auto ; width: 900px; margin-top: 100px;">
    <div style="float: left; ">
        <a style="cursor: pointer;" href="${pageContext.request.contextPath}/feign/Aselectstudent"><img style="width: 244px;height: 208px;" src="${pageContext.request.contextPath}/images/管理员.png" alt="">
            <p style="text-align: center;">管理员入口</p>
        </a>
    </div>
    <div style="float: left; margin-left: 40px;">
        <a style="cursor: pointer;" href="${pageContext.request.contextPath}/feign/login.html"><img style="width: 244px;height: 208px;" src="${pageContext.request.contextPath}/images/教师.png" alt="">
            <p style="text-align: center;">教师入口</p>
        </a>
    </div>
    <div style="float: left;margin-left: 40px;">
        <a style="cursor: pointer;" href="${pageContext.request.contextPath}/feign/Studentlogin"><img style="width: 244px;height: 208px;" src="${pageContext.request.contextPath}/images/大学生.png" alt="">
            <p style="text-align: center;">学生入口</p>
        </a>
    </div>
</div>
</body>

</html>
