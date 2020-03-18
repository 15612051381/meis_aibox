package com.hzzxkj.websocket;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author 闫洋洋
 * @Description //TODO websocketStomp 配置类参数
 * @Date 2020/3/16 10:23
 **/
@Data
@Component
@ConfigurationProperties(prefix = "websocket")
public class WebSocketEntity {

    private String[] endpoint = new String[]{"/websocket"};

    private String allowedOrigins = "*";

    private Integer taskpoolSize = 1;

    private String taskThreadNamePrefix = "websocket-thread-";

    private String[] enableSimpleBroker = new String[]{"/topic"};;

    private Integer serverHeartbeat = 10000;

    private Integer clientHeartbeat = 10000;

    private String[] applicationDestinationPrefixes = new String[]{"/app"};

    private Integer messageSizeLimit = 10240;

    private Integer sendBufferSizeLimit = 10240;

    private Integer sendTimeLimit = 10000;

    private Integer corePoolSize = 10;

    private Integer maxPoolSize = 20;

    private Integer keepAliveSeconds = 60;

}
