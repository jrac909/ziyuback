package com.xk.ziyu.controller;


import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@ServerEndpoint("/websocket/{userId}")
public class WebSocket {
    private Session session;

    private static CopyOnWriteArraySet<WebSocket> webSockets =new CopyOnWriteArraySet<>();
    private static Map<String,Session> sessionPool = new HashMap<String,Session>();

    @OnOpen
    public void onOpen(Session session, @PathParam(value="userId")String userId) {
        this.session = session;

        webSockets.add(this);

        sessionPool.put(userId, session);
        System.out.println(userId+"userId");
        System.out.println("【websocket消息】有新的连接，总数为:"+webSockets.size());
        System.out.println("Map大小："+sessionPool.size());
    }

    @OnClose
    public void onClose() {
        webSockets.remove(this);
        System.out.println("【websocket消息】连接断开，总数为:"+webSockets.size());
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println("【websocket消息】收到客户端消息:"+message);
    }

    // 此为广播消息
    public void sendAllMessage(String message) {
        for(WebSocket webSocket : webSockets) {
            System.out.println("【websocket消息】广播消息:"+message);
            try {
                webSocket.session.getAsyncRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 此为单点消息--发送json对象数据
    public int sendOneMessage(String userId, String message) {
        // String userId, JSONObject message
        System.out.println("收到的消息："+userId+message);
        int ok = 2;//1成功
        Session session = sessionPool.get(userId);
        if (session != null) {
            try {
                session.getAsyncRemote().sendText(message);
                // session.getAsyncRemote().sendText(message.toJSONString());
                System.out.println("接收成功");
                ok = 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return ok;
        //        System.out.println("session：："+session);
//        System.out.println("message：："+message.toJSONString());
    }

    public boolean receiveUserOnline(int id){
        if (sessionPool.get(id+"") != null){
            return true;
        } else {
            return false;
        }
    }

    public void closePool(int id){
        sessionPool.remove(id+"");
    }
}
