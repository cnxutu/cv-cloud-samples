package com.cv.websocket.clientsample.client;

import javax.websocket.*;
import java.net.URI;
/**
 * @author: xutu
 * @since: 2025/3/18 21:08
 */
@ClientEndpoint
public class WebSocketClient {

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Connected to server");
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println("Received message: " + message);
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("Disconnected from server");
    }

    public static void main(String[] args) throws Exception {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        URI uri = new URI("ws://localhost:8891/ws");
        container.connectToServer(WebSocketClient.class, uri);
    }
}