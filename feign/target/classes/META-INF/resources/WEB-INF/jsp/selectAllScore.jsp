<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/common/mallIndex1.jsp" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/public.css"/>
</head>
<body>
<div class="right">
    <div class="search">
        <form method="get" action="${pageContext.request.contextPath }/feign/getScoreList">

            <span>学期：</span>
            <input name="querySemaster" type="text" placeholder="学期" value="${querySemaster}">
            <input value="查询" type="submit" id="searchbutton">
        </form>
    </div>
    <!--商品操作表格-->
    <table class="providerTable" cellpadding="0" cellspacing="0">
        <tr class="firstTr">
            <th>课程号</th>
            <th>课程名</th>
            <th>学分</th>
            <th>学时</th>
            <th>成绩</th>
            <th>授课老师</th>
            <th>学期</th>
        </tr>
        <c:forEach var="studyScore" items="${requestScope.get('collection')}" varStatus="status">
            <tr>
                <td><span>${studyScore.c_no}</span></td>
                <td><span>${studyScore.c_name}</span></td>
                <td><span>${studyScore.c_credit}</span></td>
                <td><span>${studyScore.c_studyhour}</span></td>
                <td><span>${studyScore.c_score}</span></td>
                <td><span>${studyScore.t_name}</span></td>
                <td><span>${studyScore.c_semaster}</span></td>

            </tr>
        </c:forEach>
    </table>
    <input type="hidden" id="totalPageCount" value="${totalPageCount}"/>
    <c:import url="page.jsp">
        <c:param name="totalCount" value="${totalCount}"/>
        <c:param name="currentPageNo" value="${currentPageNo}"/>
        <c:param name="totalPageCount" value="${totalPageCount}"/>
        <c:param name="pageIndex"  value="${pageIndex}"/>
    </c:import>
</div>
</section>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/goodsList.js"></script>
</body>
</html>

