/**  

* <p>Title: MeisCmdVersionMap.java</p>  

* <p>Description:北京惠泽智信科技有限公司 </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: www.hzzxkj.com/</p>  
* @author guoxinan  
* @date 2018年10月11日  
* @version 1.0  
*/  
package com.hzzxkj.socket.meisSocket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.hzzxkj.cmdAnaliser.CmdModel;

import io.netty.channel.Channel;

/**
 * 存储当前连接的设备与他们的协议版本的键值对信息  00为老版本协议   01 为新版本协议
 * @author    guoxinan
 * @date      2018年10月11日

 */
public class MeisCmdVersionMap {
   
	private static Map<String, Integer> map = new ConcurrentHashMap<String, Integer>();
	
	/**
	 * 向map中添加协议版本信息
	 * @param mkey 新协议代表wifiMAC地址   老协议代表医院ID+deviceID
	 * @param mValue 1代表新协议0代表老协议
	 */
	public static void add(String mkey, int mValue) {
		map.put(mkey, mValue);
	}
    /**
     * @param 根据新协议代表wifiMAC地址或者老协议代表医院ID_deviceID得到是新版还是老版协议
     * @param mkey  新协议代表wifiMAC地址   老协议代表医院ID_deviceID
     * @return   如果传递的设备唯一号找不到对应的版本，则返回-1
     */
	public static int get(String mkey) {
		return map.get(mkey)==null?-1:map.get(mkey);
	}
    /**
     * 
     * @param mkey 新协议至wifiMAC地址   老协议指 医院ID_deviceID
     */
	public static void remove(String mkey) {
		for (Map.Entry entry : map.entrySet()) {
			if (entry.getKey()== mkey) {
				map.remove(entry.getKey());
			}
		}
	}
}
