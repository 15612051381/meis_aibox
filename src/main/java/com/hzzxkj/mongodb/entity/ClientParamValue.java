/**  

* <p>Title: ClientParamValue.java</p>  

* <p>Description:北京惠泽智信科技有限公司 </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: www.hzzxkj.com/</p>  
* @author guoxinan  
* @date 2018年10月19日  
* @version 1.0  
*/
package com.hzzxkj.mongodb.entity;

/**
 * 每种状态中通道值
 * @author guoxinan
 * @date 2018年10月19日 
 */
public class ClientParamValue {

	private String Addr;
	private String AddrVal;
	private String IsRawVal;

	public String getIsRawVal() {
		return IsRawVal;
	}

	public void setIsRawVal(String isRawVal) {
		this.IsRawVal = isRawVal;
	}

	public String getAddr() {
		return Addr;
	}

	public void setAddr(String addr) {
		Addr = addr;
	}

	public String getAddrVal() {
		return AddrVal;
	}

	public void setAddrVal(String addrVal) {
		AddrVal = addrVal;
	}
}
