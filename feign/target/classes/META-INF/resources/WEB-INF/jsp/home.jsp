<%--
  Created by IntelliJ IDEA.
  User: liu'xian
  Date: 2022/5/11
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/common/mallIndex1.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title>主页</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        .box {
            height: 532px;
        }

        .box-Right {
            float: right;
            width: 300px;
            height: 300px;
            /*box-shadow: #000 2px 1px;*/
            /*border-left: 2px solid #000;*/
            text-align: center;
            /*margin-top: 6px;*/
        }

        .box-Right p {
            margin-top: 20px;
        }

        .box-Left {
            display: inline-block;
        }

        .nav {
            width: 900px;
            /*margin: 15px;*/
            height: 300px;
            box-shadow: slategray 2px 1px;
        }

        .nav h4 {
            margin: 16px 33px;
        }

        .nav li {
            display: inline-block;
            margin-left: 33px;
            margin-top: 18px;
            margin-bottom: 18px;
        }

        .nav li>a {
            text-decoration: none;
            text-align: center;
        }

        .box-left {
            width: 35%;
            display: inline-block;
            height: 200px;
            margin-top: 16px;
            margin-left: 20px;
            padding: 6px;
            text-align: center;
            padding-bottom: 26px;
        }

        .top-nav {
            background-color: skyblue;
            padding: 12px;
        }

        .box-right {
            width: 35%;
            display: inline-block;
            height: 200px;
            /*margin-top: 16px;*/
            margin-left: 20px;
            /*padding: 6px;*/
            text-align: center;
            padding-bottom: 30px;
        }

        .bottom-nav {
            font-size: 30px;
            color: gray;
            margin-bottom: 16px;
        }

        .bottom-nav p {
            font-weight: bold;
            font-size: 45px;
            color: #000;
        }

        .search {
            text-decoration: none;
            padding: 6px;
            background-color: skyblue;
            color: #000;
        }
    </style>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/public.css"/>
</head>

<body>
<div class="right">
    <div class="content-page" ref="cPage">
        <div class="box">
            <div class="box-Left">
                <div class="nav">
                    <h4>常用功能</h4>
                    <ul>
                        <li>
                            <a href=""><img src="${pageContext.request.contextPath}/images/nav1.png" alt="">
                                <p>待付款订单</p>
                            </a>
                        </li>
                        <li>
                            <a href=""><img src="${pageContext.request.contextPath}/images/nav2.png" alt="">
                                <p>待发货订单</p>
                            </a>
                        </li>
                        <li>
                            <a href=""><img src="${pageContext.request.contextPath}/images/nav3.png" alt="">
                                <p>已完成订单</p>
                            </a>
                        </li>
                        <li>
                            <a href=""><img src="${pageContext.request.contextPath}/images/nav4.png" alt="">
                                <p>待确认收货订单</p>
                            </a>
                        </li>
                        <li>
                            <a href=""><img src="${pageContext.request.contextPath}/images/nav5.png" alt="">
                                <p>消息中心</p>
                            </a>
                        </li>
                        <li>
                            <a href=""><img src="${pageContext.request.contextPath}/images/nav6.png" alt="">
                                <p>相册文件</p>
                            </a>
                        </li>

                    </ul>
                </div>
                <div class="nav">
                    <h4>待办事项</h4>
                    <div class="box-left">
                        <p class="top-nav">
                            <img src="${pageContext.request.contextPath}/images/中标.png" alt=""> 新缺货登记
                        </p>
                        <div class="bottom-nav">
                            <p>3</p>待登记数量
                        </div>
                        <a class="search" href="">查看</a>
                    </div>
                    <div class="box-right">
                        <p class="top-nav">
                            <img src="${pageContext.request.contextPath}/images/投标.png" alt=""> 待处理退货订单
                        </p>
                        <div class="bottom-nav">
                            <p>3</p> 待处理数量
                        </div>
                        <a class="search" href="">查看</a>
                    </div>

                </div>
            </div>

        </div>


    </div>
</div>
</body>
</html>








