/**  

* <p>Title: MongoBaseEntity.java</p>  

* <p>Description:北京惠泽智信科技有限公司 </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: www.hzzxkj.com/</p>  
* @author guoxinan  
* @date 2018年10月22日  
* @version 1.0  
*/  
package com.hzzxkj.mongodb.entity;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.annotation.Id;

/**
 * 
 * @author    guoxinan
 * @date      2018年10月22日 
 */
public  class MongoBaseEntity implements Serializable {
	private static final long serialVersionUID = 1L; 
	
	
	
	
	public String State;
	
	public String Guid;
	
	public String CreateTime;

	public String UpdateTime;


	public String HospitalID;

	public String DeviceID;
	 
	public String wifiMac; 
	
	public String getWifiMac() {
		return wifiMac;
	}

 
	public void setWifiMac(String wifiMac) {
		this.wifiMac = wifiMac;
	}


	public String getCreateTime() {
		return CreateTime;
	}


	public void setCreateTime(String createTime) {
		this.CreateTime = createTime;
	}


	public String getUpdateTime() {
		return UpdateTime;
	}


	public void setUpdateTime(String updateTime) {
		this.UpdateTime = updateTime;
	}


	public String getHospitalId() {
		return HospitalID;
	}


	public void setHospitalId(String hospitalId) {
		this.HospitalID = hospitalId;
	}


	public String getDeviceId() {
		return DeviceID;
	}


	public void setDeviceId(String deviceId) {
		this.DeviceID = deviceId;
	}


	public MongoBaseEntity() {
		State = "0";
		Guid = String.valueOf(UUID.randomUUID());
	}
	
	public String getState() {
		return State;
	}

	public void setState(String state) {
		this.State = state;
	}

	public String getGuid() {
		return Guid;
	}

	public void setGuid(String guid) {
		this.Guid = guid;
	}
}
