/**  

* <p>Title: ClientFalutStatus.java</p>  

* <p>Description:北京惠泽智信科技有限公司 </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: www.hzzxkj.com/</p>  
* @author guoxinan  
* @date 2018年10月22日  
* @version 1.0  
*/
package com.hzzxkj.mongodb.entity;

import java.util.Date;

/**
 * @author guoxinan
 * @date 2018年10月22日 
 */
public class ClientFalutStatus extends MongoBaseEntity {

	private static final long serialVersionUID = 1L;

	

	

	private String EventID;

	private Integer TickNum;

	private String Value;

	private Date EventTime;

	private String source;


	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getEventID() {
		return EventID;
	}

	public void setEventID(String eventID) {
		this.EventID = eventID;
	}

	public Integer getTickNum() {
		return TickNum;
	}

	public void setTickNum(Integer tickNum) {
		this.TickNum = tickNum;
	}

	public String getValue() {
		return Value;
	}

	public void setValue(String value) {
		this.Value = value;
	}

	public Date getEventTime() {
		return EventTime;
	}

	public void setEventTime(Date eventTime) {
		this.EventTime = eventTime;
	}
}
