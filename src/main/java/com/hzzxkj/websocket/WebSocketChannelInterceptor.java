package com.hzzxkj.websocket;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import java.util.Map;

public class WebSocketChannelInterceptor implements ChannelInterceptor {

    /**
     * @Author 闫洋洋
     * @Description //TODO 在此表明改用户是否可以订阅此队列
     * 在消息发送之前调用，方法中可以对消息进行修改，
     * 如果此方法返回值为空，则不会发生实际的消息发送调用
     * @Date 16:11 2020/3/13
     * @Param [message, messageChannel]
     * @return org.springframework.messaging.Message<?>
     **/
    @Override
    public Message<?> preSend(Message<?> message, MessageChannel messageChannel) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
        String sessionid = accessor.getSessionId();
        Map<String, Object> httpSession = accessor.getSessionAttributes();
        if(accessor.getDestination() != null && accessor.getSubscriptionId() != null){
//            System.out.println("队列名称：" + accessor.getDestination());
//            System.out.println("订阅编号：" + accessor.getSubscriptionId());
        }
        if(accessor.getCommand()==null){
            return message;
        }
        if(StompCommand.CONNECT.equals(accessor.getCommand())){
            System.out.println("sessionId： " +  sessionid + "，首次连接");
            String token = accessor.getNativeHeader("token").get(0);
            System.out.println("认证用户页面传递令牌：" + token);
            return null;
        }
        switch (accessor.getCommand()){
            //TODO 首次连接
            case CONNECT:
                String token = accessor.getNativeHeader("token").get(0);
                break;
            //TODO 上线
            case CONNECTED:
                break;
            //TODO 订阅
            case SUBSCRIBE:
                break;
            //TODO 发送
            case SEND:
               String destination = accessor.getDestination();
               break;
            //TODO 下线
            case DISCONNECT:
                break;
            default:
                System.out.println("sessionId： " +  sessionid + "，未知的状态：" + accessor.getCommand());
                break;
        }
        return message;
    }

    /**
     * @Author 闫洋洋
     * @Description //TODO 在消息发送后立刻调用，boolean值参数表示该调用的返回值
     * @Date 16:14 2020/3/13
     * @Param [message, messageChannel, b]
     * @return void
     **/
    @Override
    public void postSend(Message<?> message, MessageChannel messageChannel, boolean b) {

    }

}
