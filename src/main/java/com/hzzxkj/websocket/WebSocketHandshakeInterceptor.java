package com.hzzxkj.websocket;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;
import java.util.Map;

/**
 * @Author 闫洋洋
 * @Description //TODO websocket拦截器
 * @Date 2020/3/13 14:55
 **/
@Component
public class WebSocketHandshakeInterceptor implements HandshakeInterceptor {

    /**
     * @Author 闫洋洋
     * @Description //TODO websocket 握手前
     * @Date 11:57 2020/3/12
     * @Param [serverHttpRequest, serverHttpResponse, webSocketHandler, map]
     * @return boolean
     **/
    @Override
    public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String, Object> map) throws Exception {
        System.out.println("开始建立连接");
        return true;
    }

    /**
     * @Author 闫洋洋
     * @Description //TODO websocket 握手后
     * @Date 11:57 2020/3/12
     * @Param [serverHttpRequest, serverHttpResponse, webSocketHandler, e]
     * @return void
     **/
    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {
        System.out.println("握手成功");
    }

}
