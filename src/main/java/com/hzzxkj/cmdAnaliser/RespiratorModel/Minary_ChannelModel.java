package com.hzzxkj.cmdAnaliser.RespiratorModel;

import java.util.Date;

import com.mysql.fabric.xmlrpc.base.Data;

public class Minary_ChannelModel {

	 /**
	  * 通道号
	  */
	 public String ChannelNo;
    /**
     * 采样频率
     */
	 public int acquisitionFrequency;
	 /**
	  * 通道最小值
	  */
	 public int minvalue;
	 /**
	  * 通道最大值
	  */
	 public int maxvalue;
	 /**
	  * 
	  */
	 public int maxbin;
	 
	 public String starttime;
	 
	 public String endtime;
	 
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getChannelNo() {
		return ChannelNo;
	}
	public void setChannelNo(String channelNo) {
		ChannelNo = channelNo;
	}
	public int getAcquisitionFrequency() {
		return acquisitionFrequency;
	}
	public void setAcquisitionFrequency(int acquisitionFrequency) {
		this.acquisitionFrequency = acquisitionFrequency;
	}
	public int getMinvalue() {
		return minvalue;
	}
	public void setMinvalue(int minvalue) {
		this.minvalue = minvalue;
	}
	public int getMaxvalue() {
		return maxvalue;
	}
	public void setMaxvalue(int maxvalue) {
		this.maxvalue = maxvalue;
	}
	public int getMaxbin() {
		return maxbin;
	}
	public void setMaxbin(int maxbin) {
		this.maxbin = maxbin;
	}
}
