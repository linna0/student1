<%--
  Created by IntelliJ IDEA.
  User: yln
  Date: 2022/5/29
  Time: 17:17
  这里是教师修改学生成绩的压面
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/common/mallIndex.jsp" %>
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
<form action="${pageContext.request.contextPath}/feign/updateStudent" method="post">
    学号：<input type="text" name="s_no" value="${students.s_no}" class="form-control"><br><br><br>
<%--    姓名：<input type="text" name="s_name" value="${students.s_name}"><br><br><br>--%>
<%--    序号：<input type="text" name="s_number" value="${students.s_number}"><br><br><br>--%>
<%--    性别:--%>
<%--    <select name="s_gender" id="s_gender">--%>
<%--        <option value="男">男</option>--%>
<%--        <option value="女">女</option>--%>
<%--    </select>--%>
<%--    学院：<input type="text" name="s_school" value="${students.s_school}"><br><br><br>--%>
<%--    专业：<input type="text" name="s_pro" value="${students.s_pro}"><br><br><br>--%>
<%--    电话：<input type="text" name="s_telephone" value="${students.s_telephone}"><br><br><br>--%>
<%--    地址：<input type="text" name="s_address" value="${students.s_address}"><br><br><br>--%>
    课程：<input type="text" name="c_no" value="${students.c_no}" class="form-control"><br><br><br>
    分数：<input type="text" name="c_score" value="${students.c_score}" class="form-control"><br><br><br>
</select>
    <br><br>
    <input type="submit" value="保存" class="btn btn-primary">
    <input type="reset" value="重置"  class="btn btn-primary">
</form>
</div>
</body>
</html>
