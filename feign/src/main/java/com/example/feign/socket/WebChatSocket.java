package com.example.feign.socket;

/**
 * @author:yln
 * @create:2022-06-05
 */
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.math.raw.Mod;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Controller
@Component
@ServerEndpoint("/socket/{name}")
@Slf4j
public class WebChatSocket {
    public static List<MessageBody> messageBodies=new ArrayList<>();//创建一个集合对象来存储信息
    @OnOpen
    public void onOpen(@PathParam("name") String name, Session session) throws IOException {
        if (SocketStorage.sessionMap.putIfAbsent(name, session) != null){
            log.error("用户名：{} 已存在", name);
            throw new RuntimeException("用户名已存在，请更换用户名。");
        }
        SocketStorage.nameMap.put(session.getId(), name);
        log.info("{}上线了", name);
        MessageBody systemMessage = new MessageBody();
        systemMessage.setContent(name + "成功建立连接");
        systemMessage.setFromName("system");
        session.getBasicRemote().sendText(JSONObject.toJSONString(systemMessage));
        messageBodies.add(systemMessage);
    }

    @OnClose
    public void onClose(Session session){
        String name = SocketStorage.nameMap.remove(session.getId());
        SocketStorage.sessionMap.remove(name);
        log.info("{}下线了", name);
        MessageBody messageBody=new MessageBody();
        messageBody.setContent(name+"下线了");
        messageBodies.add(messageBody);
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        log.info("监听到消息：{}", message);

        MessageBody messageBody = JSONObject.parseObject(message, MessageBody.class);

        if (messageBody == null){
            log.warn("监听到的消息为空或格式不正确，message:{}", message);
            return;
        }
        String fromUser = SocketStorage.nameMap.get(session.getId());
        //设置发消息的人
        messageBody.setFromName(fromUser);
        messageBody.setSendTime(new Date());

        //将消息转发给收消息的人
        Session toSession = SocketStorage.sessionMap.get(messageBody.getToName());
        if (toSession != null){
            toSession.getBasicRemote().sendText(JSONObject.toJSONString(messageBody));
        }else {
            log.info("{}不在线，发送失败", messageBody.getToName());
            MessageBody systemMessage = new MessageBody();
            systemMessage.setContent(messageBody.getToName() + "不在线，发送失败");
            systemMessage.setFromName("system");
            session.getBasicRemote().sendText(JSONObject.toJSONString(systemMessage));
            messageBodies.add(systemMessage);
        }
        messageBodies.add(messageBody);
    }

    @OnError
    public void onError(Session session, Throwable error){
        if (error instanceof EOFException && error.getMessage() == null){
            String name = SocketStorage.nameMap.get(session.getId());
            SocketStorage.nameMap.remove(session.getId());
            SocketStorage.sessionMap.remove(name);
            log.info("{}长时间没有活动，连接已断开", name);
            MessageBody messageBody=new MessageBody();
            messageBody.setContent(name+"长时间没有活动，连接断开");
        }
    }
    @RequestMapping("/hello")
    public ModelAndView hello(){
        ModelAndView m=new ModelAndView();
        m.addObject("messageBodies",messageBodies);
        m.setViewName("hello");
        return m;
    }
}
