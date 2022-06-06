<%--
  Created by IntelliJ IDEA.
  User: liu'xian
  Date: 2022/6/4
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath }/css/pagecss.css" type="text/css" rel="stylesheet"/>
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/pagejs.js"></script>
</head>
<body>
<!--currentpage="1" numbercount="100"-->
<div><ul class="page" maxshowpageitem="5" pagelistcount="5"  id="page"></ul></div>
<div ></div>
<!--<div><ul class="page" maxshowpageitem="5" pagelistcount="10"  id="page1"></ul></div>-->
<script type="text/javascript">
    // function tt(dd){
    //     //alert(dd);
    // }
    var GG = {
        "kk":function(mm){
            window.location.href="${pageContext.request.contextPath}/feign/selectAllStudent?pageIndex="+mm;
        }
    }
    $("#page").initPage(${param.totalCount},${param.currentPageNo},GG.kk);
    /*$("#page1").initPage(100,1,GG.kk);*/
</script>
</body>
</html>

