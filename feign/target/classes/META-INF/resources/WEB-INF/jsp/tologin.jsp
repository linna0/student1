<%--
  Created by IntelliJ IDEA.
  User: liu'xian
  Date: 2022/5/4
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head lang="zh">
  <meta charset="UTF-8">
  <title>登录</title>
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css"/>

</head>

<body>
<div id="wrapper" class="login-page">
  <div id="login_form" class="form" >
    <h2>
      学生成绩管理系统
    </h2>
    <form class="register-form" action="${pageContext.request.contextPath}/register.do" method="post" name="actionForm2" id="actionForm2">
        <input type="text" name="s_id" value="" placeholder="请输入学号" required />
        <%--      <div id="t_name" style="font-size: 12px; text-align: left; margin-bottom: 10px;"> &nbsp</div>--%>
        <input type="text" name="s_name" value="" placeholder="请输入姓名" required />
        <input type="text" name="s_number" value="" placeholder="请输入账号" required />
        <!-- <input id="man" type="radio" checked="checked" name="s_gender" />男<input id="woman" type="radio" name="s_gender" />女 -->
        <input type="text" name="s_gender" value="" placeholder="请输入性别(男/女)" required />
        <input type="text" name="s_pro" value="" placeholder="请输入专业" required />
        <input type="text" name="s_telephone" value="" placeholder="请输入联系方式" required />
        <input type="text" name="s_address" value="" placeholder="请输入家庭地址" required />
        <input type="submit" id="create" class="button" value=" 创建账户" />
        <p class="message">已经有了一个账户? <a href="#">立刻登录</a></p>
    </form>
    <form class="login-form" action="${pageContext.request.contextPath}/loginToHome" method="post" name="actionForm"
          id="actionForm">
      <input type="text" placeholder="用户名" id="username" name="s_number" />
        <div id="s_username" style="font-size: 6px; text-align: left; margin-bottom: 10px;"> &nbsp</div>

      <input type="password" placeholder="密码" id="password" name="s_id" />
      <div  style="font-size: 6px; text-align: left; margin-bottom: 10px;"> &nbsp</div>

      <input type="submit" id="login" class="button" value=" 登录 " />
      <p class="message ">还没有账户? <a href="# ">立刻创建</a></p>
    </form>
  </div>
</div>
<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script src="${pageContext.request.contextPath}/js/index.js"></script>
</body>

</html>
