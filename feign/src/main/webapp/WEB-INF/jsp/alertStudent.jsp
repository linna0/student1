<%--
  Created by IntelliJ IDEA.
  User: yln
  Date: 2022/6/4
  Time: 15:06
  这里是管理员修改学生信息的界面
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/common/index.jsp" %>
<html>
<head>
    <title>修改学生信息</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container" style="width:900px;margin: auto">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改学生</small>
                </h1>
            </div>
        </div>
    </div>
<c:forEach var="students" items="${requestScope.get('students')}" varStatus="status">
<form action="${pageContext.request.contextPath}/feign/alertStudent" method="post">
    学号：<input type="text" name="s_id" value="${students.s_id}"  class="form-control"><br>
        姓名：<input type="text" name="s_name" value="${students.s_name}"  class="form-control"><br>
        序号：<input type="text" name="s_number" value="${students.s_number}"  class="form-control"><br>
        性别:
        <select name="s_gender" id="s_gender" class="form-control">
            <option value="男">男</option>
            <option value="女">女</option>
        </select><br>
        学院：<input type="text" name="s_school" value="${students.s_school}"  class="form-control"><br>
        专业：<input type="text" name="s_pro" value="${students.s_pro}"  class="form-control"><br>
        电话：<input type="text" name="s_telephone" value="${students.s_telephone}"  class="form-control"><br>
        地址：<input type="text" name="s_address" value="${students.s_address}" class="form-control" ><br>
    <input type="submit" value="保存" class="btn btn-primary">
    <input type="reset" value="重置"class="btn btn-primary">
</form>
</c:forEach>
</div>
</body>
</html>
