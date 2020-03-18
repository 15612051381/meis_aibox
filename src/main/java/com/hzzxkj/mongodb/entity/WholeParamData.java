package com.hzzxkj.mongodb.entity;

import java.util.ArrayList;

import com.hzzxkj.cmdAnaliser.CMDID;

public class WholeParamData extends MongoBaseEntity {

	private boolean DataCompleted;

	private int packageNo;

	private ArrayList<Byte> OriginalData;

	private String OriginalDataString;

	private String DataString;

	private boolean finalPackageFlag;

	private int version;
	
	private String protocolString;

	private ArrayList<ClientParamValue> Values;
	
	private String EventID;

	public String getProtocolString() {
		return protocolString;
	}

	public void setProtocolString(String protocolString) {
		this.protocolString = protocolString;
	}

	public String getEventID() {
		return EventID;
	}

	public void setEventID(String eventID) {
		EventID = eventID;
	}

	public boolean isDataCompleted() {
		return DataCompleted;
	}

	public void setDataCompleted(boolean dataCompleted) {
		DataCompleted = dataCompleted;
	}

	public int getPackageNo() {
		return packageNo;
	}

	public void setPackageNo(int packageNo) {
		this.packageNo = packageNo;
	}

	public ArrayList<Byte> getOriginalData() {
		return OriginalData;
	}

	public void setOriginalData(ArrayList<Byte> originalData) {
		OriginalData = originalData;
	}

	public String getOriginalDataString() {
		return OriginalDataString;
	}

	public void setOriginalDataString(String originalDataString) {
		OriginalDataString = originalDataString;
	}

	public String getDataString() {
		return DataString;
	}

	public void setDataString(String dataString) {
		DataString = dataString;
	}

	public boolean isFinalPackageFlag() {
		return finalPackageFlag;
	}

	public void setFinalPackageFlag(boolean finalPackageFlag) {
		this.finalPackageFlag = finalPackageFlag;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public ArrayList<ClientParamValue> getValues() {
		return Values;
	}

	public void setValues(ArrayList<ClientParamValue> values) {
		this.Values = values;
	}
	
	public WholeParamData() {
		DataCompleted = false;
		Values =new  ArrayList<ClientParamValue>();
		finalPackageFlag = false;
		EventID = CMDID.CMD_Trans_WholeParameter.toString();
		OriginalData = new ArrayList<Byte>();
	}
	
	
	
}
