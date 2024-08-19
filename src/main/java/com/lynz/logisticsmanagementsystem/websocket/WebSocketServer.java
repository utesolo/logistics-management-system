package com.lynz.logisticsmanagementsystem.websocket;

import com.lynz.logisticsmanagementsystem.util.SemaphoreUtils;
import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.Semaphore;

/**
 * @author lynz
 */

@Component
@ServerEndpoint("/websocket/message")
public class WebSocketServer {
    // 日志控制器
    private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketServer.class);

    // 最大在线人数
    public static int socketMaxOlineCount = 10;

    private static Semaphore semaphore = new Semaphore(socketMaxOlineCount);

    /*
    * 连接建立成功调用方法
    */
    @OnOpen
    public void onOpen(Session session) throws Exception{
        boolean semaphoreFlag = false;
        semaphoreFlag = SemaphoreUtils.tryAcquire(semaphore);
        if (!semaphoreFlag) {
            // 没有获取到信号量
            LOGGER.error("\n当前在线人数超过限制-{}",socketMaxOlineCount);
            WebSocketUser.sendMessageToUserByText(session, "当前在线人数超过限制数：" + socketMaxOlineCount);
            session.close();
        }else {
            // 添加用户
            WebSocketUser.put(session.getId(), session);
            LOGGER.info("\n 建立连接 - {}", session);
            LOGGER.info("\n 当前人数 - {}", WebSocketUser.getUsers().size());
            WebSocketUser.sendMessageToUserByText(session, "连接成功");

        }
    }

    /*
    * 连接关闭处理
    */
    @OnClose
    public void onClose(Session session){
        LOGGER.info("\n关闭连接-{}",session);
        // 移除用户
        WebSocketUser.remove(session.getId());
        // 释放信号量
        SemaphoreUtils.release(semaphore);
    }

    /**
     * 抛出异常时处理
     */
    @OnError
    public void onError(Session session, Throwable exception) throws Exception
    {
        if (session.isOpen())
        {
            // 关闭连接
            session.close();
        }
        String sessionId = session.getId();
        LOGGER.info("\n 连接异常 - {}", sessionId);
        LOGGER.info("\n 异常信息 - {}", exception);
        // 移出用户
        WebSocketUser.remove(sessionId);
        // 获取到信号量则需释放
        SemaphoreUtils.release(semaphore);
    }

    /**
     * 服务器接收到客户端消息时调用的方法
     */
    @OnMessage
    public void onMessage(String message, Session session)
    {
        broadcastMessage(message);
    }

    public void broadcastMessage(String message) {
        WebSocketUser.sendMessageToUsersByText(message);
    }


}
