package com.hzzxkj.mongodb.entity;

import java.util.List;

public class ChannelWaveData {

	/**
	 * 通道号
	 */
	private int ChannelNo;
	/**
	 * 通道数据
	 */
	private List<String> ChannelData;
	public int getChannelNo() {
		return ChannelNo;
	}
	public void setChannelNo(int channelNo) {
		this.ChannelNo = channelNo;
	}
	public List<String> getChannelData() {
		return ChannelData;
	}
	public void setChannelData(List<String> channelData) {
		this.ChannelData = channelData;
	}
}
