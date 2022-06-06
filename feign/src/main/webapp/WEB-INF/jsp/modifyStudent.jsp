<%--
  Created by IntelliJ IDEA.
  User: liu'xian
  Date: 2022/5/29
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改学生信息</title>
</head>
<body>
<h2>修改学生信息</h2>
<form action="${pageContext.request.contextPath }/feign/studentModify" method="post">
    <div class="last" >
        <div>学号：
            <input type="text" name="s_id"  value="${student.s_id}" placeholder="请输入学号" readonly /></div>
        <div>姓名：
            <input type="text" name="s_name" value="${student.s_name}" placeholder="请输入姓名" required/></div>
        <div>账号：
            <input type="text" name="s_number" value="${student.s_number}" placeholder="请输入账号" readonly /></div>
        <div>性别：
            <input type="text" name="s_gender" value="${student.s_gender}" placeholder="请输入性别" required /></div>
        <div>学院：
            <input type="text" name="s_school" value="${student.s_school}" placeholder="请输入学院" required /></div>
        <div>专业：
            <input type="text" name="s_pro" value="${student.s_pro}" placeholder="请输入专业" required /></div>
        <div>联系方式：
            <input type="text" name="s_telephone" value="${student.s_telephone}" placeholder="请输入联系方式" required /></div>
        <div>家庭住址：
            <input type="text" name="s_address" value="${student.s_address}" placeholder="请输入家庭地址" required /></div>
        <input class="submit " type="submit" value="修改">
    </div>

</form>
</body>
</html>
