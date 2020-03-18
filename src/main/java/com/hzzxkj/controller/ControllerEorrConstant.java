/**  

* <p>Title: ControllerEorrConstant.java</p>  

* <p>Description:北京惠泽智信科技有限公司 </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: www.hzzxkj.com/</p>  
* @author guoxinan  
* @date 2018年10月11日  
* @version 1.0  
*/  
package com.hzzxkj.controller;

/**
 * @author    guoxinan
 * @date      2018年10月11日
 * @parameter 参数及其意义
 * @return    返回值
 */
public class ControllerEorrConstant {

	/**
	 * http请求成功
	 */
	public static final String success="0"; 
	/**
	 * http请求失败
	 */
	public static final String httpRequestErr="1";
	/**
	 * 检测到设备不在线
	 */
	public static final String deviceOff="2"  ;
	/**
	 * 请求下发指令到控制板错误
	 */
	public static final String httpRequestToBoardErr="3";  
	/**
	 * 控制板反馈错误
	 */
    public static final String responseErr="4"; 
    /**
	 * 获取设备版本失败（主要针对新老协议）
	 */
	public static final String getVersionMapErr="5";  
	
	
	
}
