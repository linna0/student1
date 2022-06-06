<%--
  Created by IntelliJ IDEA.
  User: liu'xian
  Date: 2022/5/28
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加学生</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/feign/studentAdd" method="post">
    <h2>增加学生</h2>
    <div class="last" >
        <div>学号：
            <input type="text" name="s_id"  value="" placeholder="请输入学号" required /></div>
        <div>姓名：
            <input type="text" name="s_name" value="" placeholder="请输入姓名" required /></div>
        <div>账号：
            <input type="text" name="s_number" value="" placeholder="请输入账号" required /></div>
        <div>性别：
            <input type="text" name="s_gender" value="" placeholder="请输入性别" required /></div>
        <div>学院：
            <input type="text" name="s_school" value="" placeholder="请输入学院" required /></div>
        <div>专业：
            <input type="text" name="s_pro" value="" placeholder="请输入专业" required /></div>
        <div>联系方式：
            <input type="text" name="s_telephone" value="" placeholder="请输入联系方式" required /></div>
        <div>家庭住址：
            <input type="text" name="s_address" value="" placeholder="请输入家庭地址" required /></div>
        <input class="submit " type="submit" value="提交">
    </div>
</form>
</body>
</html>
