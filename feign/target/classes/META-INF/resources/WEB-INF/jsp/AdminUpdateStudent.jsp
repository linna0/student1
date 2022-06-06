<%--
  Created by IntelliJ IDEA.
  User: yln
  Date: 2022/6/5
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/feign/updateStudent1" method="post">
    学号：<input type="text" name="s_no" value="${students.s_no}"><br><br><br>
    课程：<input type="text" name="c_no" value="${students.c_no}"><br><br><br>
    分数：<input type="text" name="c_score" value="${students.c_score}"><br><br><br>
    </select>
    <br><br>
    <input type="submit" value="保存">
    <input type="reset" value="重置">
</form>
</body>
</html>
