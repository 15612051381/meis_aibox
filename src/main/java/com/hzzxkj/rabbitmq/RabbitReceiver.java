package com.hzzxkj.rabbitmq;

import com.hzzxkj.Logger.HzzxLogger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author 闫洋洋
 * @Description //TODO 消息接收类
 * @Date 2020/3/16 12:28
 **/
@Component
public class RabbitReceiver {

    @Autowired
    private RabbitConfigEntity rabbitConfigEntity;

    /**
     * @Author 闫洋洋
     * @Description //TODO 接收队列为 realtime 的信息
     * @Date 12:29 2020/3/16
     * @Param [Message]
     * @return void
     **/
    @RabbitListener(queues = "realtime")
    public void process(String Message) {
        HzzxLogger.info(rabbitConfigEntity.getQueue() + ",消费者收到消息:" + Message,"realtime");
        //TODO 进行存入mysql and redis 操作

    }

}
