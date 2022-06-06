<%--
  Created by IntelliJ IDEA.
  User: yln
  Date: 2022/6/5
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: yln
  Date: 2022/5/31
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/common/mallIndex.jsp" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<form action="${pageContext.request.contextPath}/feign/insertScore1" method="post">
    <h1 style="text-align: center">添加分数</h1>
    <div class="last" >
        <div style="margin-left: 500px;padding:20px">
            <label for="s_no">学号：</label>
            <input type="text" id="s_no" name="s_no" class="form-control" style="width:500px;"></div>
        <div style="margin-left: 500px;padding:20px">
            <label for="c_no">课程：</label>
            <input type="text" id="c_no" name="c_no" class="form-control" style="width:500px"></div>
        <div style="margin-left: 500px;padding:20px">
            <label for="c_score">成绩：</label>
            <input type="text" id="c_score" name="c_score" class="form-control" style="width:500px"></div>
        <%--        这里的name的大小写要识别清楚哦，因为是间接对应了Mapper里面的数的--%>
        <div style="margin-left: 550px;margin-top:10px">
            <input type="submit" value="添加" class="btn btn-primary"  style="width:100px;margin-right: 30px;">
            <input type="reset" value="重置" class="btn btn-primary" style="width:100px;margin-left:30px; "></div>
    </div>
</form>
</body>
</html>
