<%--
  Created by IntelliJ IDEA.
  User: liu'xian
  Date: 2022/6/4
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息查看</title>
</head>
<body>
<h2>修改学生信息</h2>
<form action="${pageContext.request.contextPath }/feign/selectAllStudent" method="get">
    <div class="last" >
        <div>学号：${student.s_id}</div>
        <div>姓名：${student.s_name}</div>
        <div>账号：${student.s_number}</div>
        <div>性别：${student.s_gender}</div>
        <div>学院：${student.s_school}</div>
        <div>专业：${student.s_pro}</div>
        <div>联系方式：${student.s_telephone}</div>
        <div>家庭住址：${student.s_address}</div>
        <input class="submit " type="submit" value="返回">
    </div>

</form>
</body>
</html>
