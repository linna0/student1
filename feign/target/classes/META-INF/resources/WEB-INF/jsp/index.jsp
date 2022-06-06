<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/common/mallIndex.jsp" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>聊天</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container" style="margin-left:400px;">
<h1>在线聊天</h1>
<div style="margin:10px;width:500px;"><span style="font-size:30px;">当前登录用户：</span><input id="name" style="width:600px;" placeholder="${name}" value="${name}" class="form-control" readonly/><button id="connBtn" class="btn btn-primary" onclick="connection()">建立连接</button><br/></div>
<div style="margin:10px;width:500px;"><span style="font-size:30px;">接收人：</span><input id="toName" style="width:600px;" class="form-control"/><br/></div>
    <textarea class="form-control" style="height:200px;margin:10px;width:600px;" id="sendContent"></textarea><br/><button class="btn btn-primary" onclick="sendMessage()">发送</button><br/>
聊天记录：
    <div id="messageView" class="border border-dark" style="width:500px;height:500px;"></div></div>
</body>
<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.bootcdn.net/ajax/libs/sockjs-client/1.5.1/sockjs.min.js"></script>
<script>
    var webSocket;
    function connection() {
        let name = $("#name").val();
        if (name){
            if ("WebSocket" in window) {
                webSocket = new WebSocket("ws://localhost:6896/socket/"+name);
                //连通之后的回调事件
                webSocket.onopen = function() {
                    console.log("已经连通了websocket");
                    $("#name").attr('disabled',true);
                    $("#connBtn").attr('disabled',true);
                };

                //接收后台服务端的消息
                webSocket.onmessage = function (evt) {
                    console.log("数据已接收:" +JSON.stringify(evt.data));
                    const messageBody = JSON.parse(evt.data);
                    viewMessage(messageBody);
                };

                //连接关闭的回调事件
                webSocket.onclose = function() {
                    console.log("连接已关闭...");
                    let message = new Object();
                    message.fromName = "system";
                    message.content = "连接已关闭";
                    viewMessage(message);
                };
            }else{
                // 浏览器不支持 WebSocket
                alert("您的浏览器不支持 WebSocket!");
            }
        }else {
            alert("请输入你的名字")
        }
    }
    function sendMessage(){
        let content = $("#sendContent").val();
        if (content){
            let message = new Object();
            message.fromName = $("#name").val();
            message.toName = $("#toName").val();
            message.content = content;
            $("#sendContent").val("");
            viewMessage(message);
            webSocket.send(JSON.stringify(message));
        }else {
            console.log("输入内容为空")
        }
    }
    function viewMessage(message){
        let messageHtml = "<div>"+message.fromName+": "+message.content+"</div>";
        $("#messageView").append(messageHtml);
    }
</script>
</html>
