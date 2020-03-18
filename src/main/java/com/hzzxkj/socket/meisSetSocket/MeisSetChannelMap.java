/**  

* <p>Title: MeisChannelMap.java</p>  

* <p>Description:北京惠泽智信科技有限公司 </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: www.hzzxkj.com/</p>  
* @author guoxinan  
* @date 2018年10月9日  
* @version 1.0  
*/  
package com.hzzxkj.socket.meisSetSocket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap; 
import io.netty.channel.Channel; 

/**
 * 存储设备唯一号与通信通道的字典、设备连接时插入字典，设备断开连接则从字典中移除
 * @author    guoxinan
 * @date      2018年10月9日
 */
public  class MeisSetChannelMap {
	
	public static Map<String, Channel> map = new ConcurrentHashMap<String, Channel>();

	/**
	 * 向map添加对应的设备——Channel键值对
	 * 
	 * @param id      每台采集器的唯一ID，如果是旧版协议则此ID为医院ID_设备ID,如果是新版协议则为wifiMAC地址
	 * @param socketChannel
	 */
	public static void add(String id, Channel channel) {
		map.put(id, channel);
	}
    /**
     * map的get方法根据设备ID得到对应的Channel
     * @param 设备唯一编号
     * @return
     */
	public static Channel get(String id) {
		return map.get(id);
	}
	/**
	 * 通过channel找到对应的key
	 * @param channel  通过channel找到对应的key
	 * @return  如果找不到对应的key 则返回null
	 */
	public static String getMapKey(Channel channel) {
		for (Map.Entry<String ,Channel> entry : map.entrySet()) {
			if (entry.getValue() == channel) {
				return entry.getKey();
			} 
		}
		return null;
	}
	
    /**
         * 从map中移除已经断开连接的channel
     * @param Channel
     */
	public static void remove(Channel channel) {
		for (Map.Entry entry : map.entrySet()) {
			if (entry.getValue() == channel) {
				map.remove(entry.getKey());
			}
		}
	}
	/**
	 * 获取集合中的数量
	 * @return 集合中的数量
	 */
	public static int getSize() {
		return map.size();
	}
}
