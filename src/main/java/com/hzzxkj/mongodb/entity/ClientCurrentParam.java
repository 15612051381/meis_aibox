/**  

* <p>Title: clientcurrentparam.java</p>  

* <p>Description:北京惠泽智信科技有限公司 </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: www.hzzxkj.com/</p>  
* @author guoxinan  
* @date 2018年10月19日  
* @version 1.0  
*/
package com.hzzxkj.mongodb.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author guoxinan
 * @date 2018年10月19日
 */
public class ClientCurrentParam extends MongoBaseEntity { 
	private static final long serialVersionUID = 1L;

	
	private String EventID;

	private List<ClientParamValue> Value;

	private Date EventTime;

	public ClientCurrentParam() {
		Value = new ArrayList<ClientParamValue>();
		
	}

	public String getEventId() {
		return EventID;
	}

	public void setEventId(String eventId) {
		this.EventID = eventId;
	}

	public List<ClientParamValue> getValue() {
		return Value;
	}

	public void setValue(List<ClientParamValue> value) {
		this.Value = value;
	}

	public Date getEventTime() {
		return EventTime;
	}

	public void setEventTime(Date eventTime) {
		this.EventTime = eventTime;
	}

}
