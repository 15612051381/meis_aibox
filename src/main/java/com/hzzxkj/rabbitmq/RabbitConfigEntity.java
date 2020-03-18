package com.hzzxkj.rabbitmq;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author 闫洋洋
 * @Description //TODO rabbitmq 属性配置类
 * @Date 2020/3/16 12:37
 **/
@Data
@Component
@ConfigurationProperties(prefix = "rabbitmq")
public class RabbitConfigEntity {

    @Value("${rabbitmq.queue}")
    private String queue;

    @Value("${rabbitmq.fanoutExchange}")
    private String fanoutExchange;

}
