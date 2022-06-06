package com.example.feign.socket;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author:yln
 * @create:2022-06-05
 */

        import javax.websocket.Session;
        import java.util.concurrent.ConcurrentHashMap;

public class SocketStorage {

    private SocketStorage(){}

    /**
     * 根据name存储的Socket会话Map
     * key:name, value:session
     */
    public static ConcurrentHashMap<String, Session> sessionMap = new ConcurrentHashMap<>();

    /**
     * 根据Socket会话ID存储的name的Map
     * key:sessionId, value:name
     */
    public static ConcurrentHashMap<String, String> nameMap = new ConcurrentHashMap<>();
}
