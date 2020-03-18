/**  

* <p>Title: ClientParam.java</p>  

* <p>Description:北京惠泽智信科技有限公司 </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: www.hzzxkj.com/</p>  
* @author guoxinan  
* @date 2018年10月19日  
* @version 1.0  
*/
package com.hzzxkj.mongodb.entity;

import java.util.Date;
import java.util.List;

/**
 * @author guoxinan
 * @date 2018年10月19日
 * @parameter 参数及其意义
 * @return 返回值
 */
public class ClientParam extends MongoBaseEntity {
	private static final long serialVersionUID = 1L;

	

	

	private String EventID;

	private List<ClientParamValue> Value;

	private Date EventTime;

	

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
