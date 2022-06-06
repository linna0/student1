<%--
  Created by IntelliJ IDEA.
  User: yln
  Date: 2022/6/4
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/common/index.jsp" %>
<html>
<head>
    <title>修改教师信息</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container" style="width:900px;margin: auto">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改教师</small>
                </h1>
            </div>
        </div>
    </div>

<c:forEach var="teachers" items="${requestScope.get('teachers')}" varStatus="status">
<form action="${pageContext.request.contextPath}/feign/alertTeacher" method="post">
    工号：<input type="text" name="t_no" value="${teachers.t_no}" class="form-control"><br>
        姓名：<input type="text" name="t_name" value="${teachers.t_name}" class="form-control"><br>
    <%--    序号：<input type="text" name="s_number" value="${students.s_number}"><br><br><br>--%>
        性别:
        <select name="t_gender" id="t_gender" class="form-control">
            <option value="男">男</option>
            <option value="女">女</option>
        </select><br>
        系别：<input type="text" name="t_department" value="${teachers.t_department}" class="form-control"><br>
    职称：<input type="text" name="t_job" value="${teachers.t_job}" class="form-control"><br>
    授课编号：<input type="text" name="t_lecturenumber" value="${teachers.t_lecturenumber}" class="form-control"><br>
    <input type="submit" value="保存" class="btn btn-primary">
    <input type="reset" value="重置" class="btn btn-primary">
</form>
</c:forEach>
</div>
</body>
</html>
