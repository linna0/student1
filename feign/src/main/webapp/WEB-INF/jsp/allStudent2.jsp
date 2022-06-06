<% pageContext.setAttribute("path", request.getContextPath());%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/common/index.jsp" %>
<html>
<head>
    <title>学生列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/public.css"/>
</head>
<body>
<div class="container">
    <div class="search">
        <form method="get" action="${pageContext.request.contextPath }/feign/selectAllStudent">

            <span>账号：</span>
            <input name="queryNumber" type="text" placeholder="账号" value="${queryNumber}">
            <span>姓名：</span>
            <input name="queryName" type="text" placeholder="姓名" value="${queryName}">
            <input value="查询" type="submit" id="searchbutton">
            <a href="${pageContext.request.contextPath }/feign/addStudent">添加学生</a>

        </form>
    </div>
    <table class="providerTable" cellpadding="0" cellspacing="0">
        <tr class="firstTr">
            <th width="10%">学生学号</th>
            <th width="10%">学生姓名</th>
            <th width="10%">学生账号</th>
            <th width="10%">性别</th>
            <th width="30%">操作</th>
        </tr>
        <c:forEach var="student" items="${requestScope.get('collection')}" varStatus="status">
            <tr>
                <td><span>${student.s_id}</span></td>
                <td><span>${student.s_name}</span></td>
                <td><span>${student.s_number}</span></td>
                <td><span>${student.s_gender}</span></td>
                <td><span><a class="deleteStudent" href="JavaScript:void(0)" onclick="showDelete(${student.s_id})">删除</a></span>
                    <span><a href="${pageContext.request.contextPath }/feign/modifyStudent?id=${student.s_id}">修改</a></span>
                    <span><a href="${pageContext.request.contextPath }/feign/viewStudent?id=${student.s_id}">查看</a></span></td>
            </tr>
        </c:forEach>
    </table>

</div>
<input type="hidden" id="totalPageCount" value="${totalPageCount}"/>
<c:import url="page2.jsp">
    <c:param name="totalCount" value="${totalCount}"/>
    <c:param name="currentPageNo" value="${currentPageNo}"/>
    <c:param name="totalPageCount" value="${totalPageCount}"/>
    <c:param name="pageIndex"  value="${pageIndex}"/>
</c:import>
<script type="text/javascript">
        function showDelete(id) {
        var flag = confirm("确定要删除么？");
        if (flag) {
        location.href = "${pageContext.request.contextPath }/feign/deleteStudent?id=" + id;
    }
    }
</script>

</body>
</html>