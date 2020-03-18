package com.hzzxkj.mongodb.entity;


import java.util.ArrayList;
import java.util.List;

import com.hzzxkj.cmdAnaliser.CMDID;
import com.mysql.fabric.xmlrpc.base.Array;
/**
 * 波形数据实体类
 * @author Administrator
 *
 */
public class WaveData extends MongoBaseEntity {

	private boolean DataCompleted;
	
	private int PackageNo;
	
	private ArrayList<Byte> WaveFormData;
	
	private String RespirateDateTime;
	
	private int CollectorDateTime;
	
	private int AcquisitionFrequency;
	
	private boolean FinalPackageFlag;
	
	private int SampleNumber;
	
	private String AcquisitionChannel;
	
	private int AcquisitionChannelNum;
	
	private ArrayList<ChannelWaveData> Channelwavedata;
	
	private String EventID;
	
	private String RespiratorType;
	
	public String getRespiratorType() {
		return RespiratorType;
	}


	public void setRespiratorType(String respiratorType) {
		this.RespiratorType = respiratorType;
	}


	public WaveData() {
		DataCompleted = false;
		WaveFormData =new  ArrayList<Byte>();
		FinalPackageFlag = false;
		EventID = CMDID.CMD_Trans_Wavedata.toString();
	}
	

	public boolean isDataCompleted() {
		return DataCompleted;
	}

	public void setDataCompleted(boolean dataCompleted) {
		DataCompleted = dataCompleted;
	}

	public int getPackageNo() {
		return PackageNo;
	}

	public void setPackageNo(int packageNo) {
		this.PackageNo = packageNo;
	}

	public ArrayList<Byte> getWaveFormData() {
		return WaveFormData;
	}

	public void setWaveFormData(ArrayList<Byte> waveFormData) {
		this.WaveFormData = waveFormData;
	}

	public String getEventID() {
		return EventID;
	}


	public void setEventID(String eventID) {
		EventID = eventID;
	}


	public String getRespirateDateTime() {
		return RespirateDateTime;
	}

	public void setRespirateDateTime(String respirateDateTime) {
		this.RespirateDateTime = respirateDateTime;
	}

	public int getCollectorDateTime() {
		return CollectorDateTime;
	}

	public void setCollectorDateTime(int collectorDateTime) {
		this.CollectorDateTime = collectorDateTime;
	}

	public int getAcquisitionFrequency() {
		return AcquisitionFrequency;
	}

	public void setAcquisitionFrequency(int acquisitionFrequency) {
		this.AcquisitionFrequency = acquisitionFrequency;
	}

	public boolean isFinalPackageFlag() {
		return FinalPackageFlag;
	}

	public void setFinalPackageFlag(boolean finalPackageFlag) {
		this.FinalPackageFlag = finalPackageFlag;
	}

	public int getSampleNumber() {
		return SampleNumber;
	}

	public void setSampleNumber(int sampleNumber) {
		this.SampleNumber = sampleNumber;
	}

	public String getAcquisitionChannel() {
		return AcquisitionChannel;
	}

	public void setAcquisitionChannel(String acquisitionChannel) {
		this.AcquisitionChannel = acquisitionChannel;
	}

	public int getAcquisitionChannelNum() {
		return AcquisitionChannelNum;
	}

	public void setAcquisitionChannelNum(int acquisitionChannelNum) {
		this.AcquisitionChannelNum = acquisitionChannelNum;
	}

	public List<ChannelWaveData> getChannelwavedata() {
		return Channelwavedata;
	}

	public void setChannelwavedata(ArrayList<ChannelWaveData> channelwavedata) {
		this.Channelwavedata = channelwavedata;
	}
}
