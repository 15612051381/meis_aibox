package com.hzzxkj.socket.meisJavaSocket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import io.netty.channel.Channel;

public class MeisJavaChannelMap {
	public static Map<String, Channel> map = new ConcurrentHashMap<String, Channel>();

	/**
	 * 向map添加对应的设备——Channel键值对
	 * 
	 * @param id      
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
