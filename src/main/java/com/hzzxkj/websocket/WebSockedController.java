package com.hzzxkj.websocket;

import com.alibaba.fastjson.JSONObject;
import com.hzzxkj.dao.MdDeviceStatusMapper;
import com.hzzxkj.dao.SysAttrGroupMapper;
import com.hzzxkj.models.MdDeviceStatus;
import com.hzzxkj.models.SysAttrGroup;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Validated
@RestController
public class WebSockedController {

    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    public SysAttrGroupMapper attrGroupMapper;
	@Autowired
	private MdDeviceStatusMapper mdDeviceStatusMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;  //使用RabbitTemplate,这提供了接收/发送等等方法

    @RequestMapping("/queue")
    public MdDeviceStatus queue(){
        return mdDeviceStatusMapper.selectByPrimaryKey(1);
    }


    @MessageMapping("/topics") // @MessageMapping 和 @RequestMapping 功能类似，浏览器向服务器发起消息，映射到该地址。
    @SendTo("/topic/getResponse") // 如果服务器接受到了消息，就会对订阅了 @SendTo 括号中的地址的浏览器发送消息。
    public JSONObject topics(@RequestBody JSONObject jsonObject) {
        return jsonObject;
    }

    @MessageMapping("/queues") // @MessageMapping 和 @RequestMapping 功能类似，浏览器向服务器发起消息，映射到该地址。
    @SendTo("/queue/getResponse") // 如果服务器接受到了消息，就会对订阅了 @SendTo 括号中的地址的浏览器发送消息。
    public JSONObject queue(@RequestBody JSONObject jsonObject) {
        return jsonObject;
    }

    @RequestMapping(value = "/topic",method = RequestMethod.GET)
    public Map<String,String> topic(
            @NotBlank(message = "名字不能为空")
            @Size(min = 3, max = 8, message = "名字长度出错")
            String name,
            @NotNull(message = "邮箱不能为空")
            @Email(message = "邮箱格式错误")
            String email){
        Map<String,String> map = new HashMap<>();
        map.put("name",name);
        map.put("email",email);
        return map;
        //template.convertAndSend("/topic/getResponse",map);
    }





}
