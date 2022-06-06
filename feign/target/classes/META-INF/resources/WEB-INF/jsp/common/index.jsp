<%--
  Created by IntelliJ IDEA.
  User: yln
  Date: 2022/6/4
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <meta charset="utf-8">
    <title>管理系统</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/page.css" />
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/css/icons.min.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="page" id="app">
    <div class="nav-left" v-show="navLeftFlag" ref="navLeft">
        <div class="LogoName">
            <p style="font-size:30px;">管理系统</p>
        </div>
        <div class="navDiv">
            <div class="navName"><span style="font-size:30px;">菜单</span></div>
            <div class="nav-list">
                <ul>
                    <li class="nav-tab  nav-ul">
                        <a href="${pageContext.request.contextPath}/feign/Aselectstudent" class="li-a" style="font-size:30px"> <img src="${pageContext.request.contextPath}/images/列表.png" style="width:30px;height:30px">学生信息
                        </a>
                    </li>

                    <li class="nav-tab nav-ul">
                        <a href="${pageContext.request.contextPath}/feign/toAddStudent" class="li-a" style="font-size:22px"><img src="${pageContext.request.contextPath}/images/添加.png" style="width:30px;height:30px">增加学生
                        </a>
                    </li>
                    <li class="nav-tab nav-ul">
                        <a href="${pageContext.request.contextPath}/feign/Aselectteacher"  class="li-a"style="font-size:22px"><img src="${pageContext.request.contextPath}/images/列表.png" style="width:30px;height:30px">教师信息
                        </a>

                    </li>
                    <li class="nav-tab nav-ul">
                        <a href="${pageContext.request.contextPath}/feign/toAddTeacher"  class="li-a"style="font-size:22px"><img src="${pageContext.request.contextPath}/images/添加.png" style="width:30px;height:30px"> 增加教师
                        </a>
                    </li>
                    <li class="nav-tab nav-ul">
                        <a href="${pageContext.request.contextPath}/feign/allScore"  class="li-a"style="font-size:22px"><img src="${pageContext.request.contextPath}/images/添加.png" style="width:30px;height:30px"> 成绩管理
                        </a>
                    </li>
                    <li class="nav-tab nav-ul">
                        <a href="${pageContext.request.contextPath}/feign/index.html"  class="li-a"style="font-size:22px"><img src="${pageContext.request.contextPath}/images/用户.png" style="width:30px;height:30px"> 返回主页
                        </a>
                    </li>
                    <li class="nav-tab nav-ul">
                        <a href="${pageContext.request.contextPath}/hello"  class="li-a"style="font-size:22px"><img src="${pageContext.request.contextPath}/images/用户.png" style="width:30px;height:30px"> 管理聊天
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>

</div>
<input type="hidden" id="path" name="path" value="${pageContext.request.contextPath }"/>
<input type="hidden" id="referer" name="referer" value="<%=request.getHeader("Referer")%>"/>
<script src="${pageContext.request.contextPath}/js/vue.min.js"></script>
<script src="https://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script type="text/javascript">
    $(function() {
        let navflag = false;
        $('.nav-tab').click(function() {
            $(this).siblings().each(function() {
                $(this).removeClass('a_active');
                // $(this).removeClass('a_active');
                $(this).find('.nav-box').css('height', '0')
                //关闭右侧箭头
                if ($(this).attr('class').indexOf('nav-ul') != -1) {
                    $(this).find('.bx-chevron-right').css('transform', 'rotateZ(0deg)')
                    $(this).find('.bx-chevron-right').css('transition', 'all .5s')
                    $(this).removeClass('nav-show')
                    // $(this).find('div').removeClass('nav-box')
                }
            })
            //当前选中
            $(this).addClass('a_active')
            $(this).find('.li-a').addClass('active')
            // 打开右侧箭头
            $(this).find('.bx-chevron-right').css('transform', 'rotateZ(90deg)')
            $(this).find('.bx-chevron-right').css('transition', 'all .5s')
            $(this).addClass('nav-show')
            // $(this).find('div').addClass('nav-box')
        })
        /* 二级菜单a点击事件 */
        $(".li-a-a").click(function() {
            $(".li-a-a").each(function() {
                $(this).removeClass('active-li-a');
            })
            $(this).addClass('active-li-a');
        })

    })
    const vue = new Vue({
        el: '#app',
        data: {
            navLeftFlag: true
        },
        methods: {
            isShowLeft() {
                if (this.navLeftFlag) {
                    this.$refs.navRight.style.paddingLeft = '0px'
                    this.$refs.cPage.style.left = '0px';
                    this.navLeftFlag = false;
                } else {
                    this.$refs.navRight.style.paddingLeft = '240px';
                    this.$refs.cPage.style.left = '240px';
                    this.navLeftFlag = true;
                }
            }
        }
    })
</script>

</body>
</html>

