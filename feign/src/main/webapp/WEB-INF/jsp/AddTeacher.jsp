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
                    <small>增加教师</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/feign/AddTeacher" method="post">
        工号：<input type="text" name="t_no" class="form-control"><br>
        教师姓名：<input type="text" name="t_name" class="form-control"><br>
        性别:
        <select name="t_gender" id="t_gender" class="form-control">
            <option value="男">男</option>
            <option value="女">女</option>
        </select><br>
        所属系：<input type="text" name="t_department"class="form-control"><br>
        职称：<input type="text" name="t_job" class="form-control"><br>
        授课编号：<input type="text" name="t_lecturenumber" class="form-control"><br>
        <input type="submit" value="确定" class="btn-primary btn">
    </form>
</div>
</body>
</html>