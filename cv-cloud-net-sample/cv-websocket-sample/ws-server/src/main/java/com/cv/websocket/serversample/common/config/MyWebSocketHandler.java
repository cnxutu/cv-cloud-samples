//package com.cv.websocket.serversample.common.config;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.WebSocketHandler;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.WebSocketMessage;
//
///**
// * @author: xutu
// * @since: 2025/3/18 21:49
// */
//@Component
//public class MyWebSocketHandler extends TextWebSocketHandler {
//
//    @Override
//    public void handleTextMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
//        String receivedMessage = (String) message.getPayload();
//        System.out.println("Received message: " + receivedMessage);
//
//        // 动态生成响应
//        String responseMessage = "Hello, you sent: " + receivedMessage;
//
//        // 发送动态响应
//        session.sendMessage(new WebSocketMessage<String>(responseMessage));
//    }
//}
