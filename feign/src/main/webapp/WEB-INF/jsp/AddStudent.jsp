<%--
  Created by IntelliJ IDEA.
  User: yln
  Date: 2022/6/4
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/common/index.jsp" %>
<html>
<head>
    <title>增加教师</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container" style="width:900px;margin: auto">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>增加学生</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/feign/AddStudent" method="post">
        学号：<input type="text" name="s_id" class="form-control"><br>
        姓名：<input type="text" name="s_name" class="form-control"><br>
        账号：<input type="text" name="s_number" class="form-control"><br>
        性别:
        <select name="s_gender" id="s_gender" class="form-control">
            <option value="男">男</option>
            <option value="女">女</option>
        </select><br>
        学院：<input type="text" name="s_school" class="form-control"><br>
        专业：<input type="text" name="s_pro" class="form-control"><br>
        电话：<input type="text" name="s_telephone" class="form-control"><br>
        地址：<input type="text" name="s_address" class="form-control"><br>
        <input type="submit" value="确定" class="btn-primary btn">
    </form>
</div>
</body>
</html>