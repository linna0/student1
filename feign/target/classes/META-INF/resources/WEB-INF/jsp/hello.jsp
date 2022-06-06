<%--
  Created by IntelliJ IDEA.
  User: yln
  Date: 2022/6/6
  Time: 14:59
  这个界面是管理员管理聊天的界面
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/common/index.jsp" %>
<html>
<head>
    <title>管理员监听聊天</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container" style="margin:auto;width:800px;" >
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>管理员监听聊天</small>
                </h1>
            </div>
        </div>
    </div>
<div>
    <c:forEach var="messageBodies" items="${requestScope.get('messageBodies')}" varStatus="status">
    <c:if test="${messageBodies.fromName=='system'}">${messageBodies.content}<br></c:if>
    <c:if test="${messageBodies.fromName!='system'}"><span style="font-size:15px;">时间：${messageBodies.sendTime}</span>${messageBodies.fromName}对${messageBodies.toName} 说：${messageBodies.content}
    <br></c:if>
</c:forEach></div></div>
</body>
</html>
