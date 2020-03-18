package com.hzzxkj.rabbitmq;

import com.hzzxkj.Logger.HzzxLogger;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @Author 闫洋洋
 * @Description //TODO rabbitmq 配置类
 * @Date 2020/3/16 12:21
 **/
@Configuration
public class RabbitConfig {

    @Autowired
    private RabbitConfigEntity rabbitConfigEntity;

    /**
     * @Author 闫洋洋
     * @Description //TODO 创建队列
     * @Date 12:26 2020/3/16
     * @Param []
     * @return org.springframework.amqp.core.Queue
     **/
    @Bean
    public Queue realtimeQueue() {
        return new Queue(rabbitConfigEntity.getQueue(),true);  //true 是否持久
    }

    /**
     * @Author 闫洋洋
     * @Description //TODO 创建FanoutExchange扇形交换机
     * @Date 12:26 2020/3/16
     * @Param []
     * @return org.springframework.amqp.core.FanoutExchange
     **/
    @Bean
    public FanoutExchange realtimeFanoutExchange() {
        return new FanoutExchange (rabbitConfigEntity.getFanoutExchange());
    }

    /**
     * @Author 闫洋洋
     * @Description //TODO 将队列绑定到交换机上
     * @Date 12:27 2020/3/16
     * @Param []
     * @return org.springframework.amqp.core.Binding
     **/
    @Bean
    public Binding bindingExchangeA() {
        return BindingBuilder.bind(realtimeQueue()).to(realtimeFanoutExchange());
    }

    /**
     * @Author 闫洋洋
     * @Description //TODO 消息发送成功与失败的回调时间,用于程序日志查看
     * @Date 12:27 2020/3/16
     * @Param [connectionFactory]
     * @return org.springframework.amqp.rabbit.core.RabbitTemplate
     **/
    @Bean
    public RabbitTemplate createRabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        //设置开启Mandatory,才能触发回调函数,无论消息推送结果怎么样都强制调用回调函数
        rabbitTemplate.setMandatory(true);
        RabbitTemplate.ConfirmCallback confirmCallback = (correlationData, ack, cause) -> {
            HzzxLogger.error("ConfirmCallback:     相关数据："+correlationData);
            HzzxLogger.error("ConfirmCallback:     确认情况："+ack);
            HzzxLogger.error("ConfirmCallback:     原因："+cause);
        };
        RabbitTemplate.ReturnCallback returnCallback = (message,replyCode,replyText,exchange,routingKey) -> {
            HzzxLogger.error("ReturnCallback:     消息："+message);
            HzzxLogger.error("ReturnCallback:     回应码："+replyCode);
            HzzxLogger.error("ReturnCallback:     回应信息："+replyText);
            HzzxLogger.error("ReturnCallback:     交换机："+exchange);
            HzzxLogger.error("ReturnCallback:     路由键："+routingKey);
        };
        rabbitTemplate.setConfirmCallback(confirmCallback);
        rabbitTemplate.setReturnCallback(returnCallback);
        return rabbitTemplate;
    }

}
