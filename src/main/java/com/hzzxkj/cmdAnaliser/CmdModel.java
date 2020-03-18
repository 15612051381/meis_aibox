package com.hzzxkj.cmdAnaliser;

/**
 * 采集器命令抽象基类
 * 
 * @author asus
 *
 */

public abstract class CmdModel {

	
	protected int TickNum;
	
	public int getTickNum() {
		return TickNum;
	}

	public void setTickNum(int tickNum) {
		TickNum = tickNum;
	}

	// 命令的原始字节值
	protected byte[] originalByte;
	// 医院ID
	protected int hospitalID;
	// 设备ID
	protected int deviceID;
	// 科室ID
	protected int sectionID;
	// 设备SN号
	protected String deviceSN;
	// 命令类型
	protected int cmdType;
	// 命令枚举值
	protected CMDID cmd;
	// 命令数据长度
	protected int dataByteLength;
	// 命令数据
	protected byte[] dataByte;
	// 校验字节
	protected byte[] crcByte;
	// wifi地址
	protected String wifiMac;
	// 蓝牙地址
	protected String bluetoothMac;
	// 有线地址
	protected String Mac;
	// rfid地址
	protected String rfidMac;
	// 冗余字节
	protected byte[] redundancyByte;
	// 协议版本
	protected int ProtocolVersion;

	public byte[] getRedundancyByte() {
		return redundancyByte;
	}

	public void setRedundancyByte(byte[] redundancyByte) {
		this.redundancyByte = redundancyByte;
	}

	public String getRfidMac() {
		return rfidMac;
	}

	public void setRfidMac(String rfidMac) {
		this.rfidMac = rfidMac;
	}

	public int getSectionID() {
		return sectionID;
	}

	public void setSectionID(int sectionID) {
		this.sectionID = sectionID;
	}

	public int getProtocolVersion() {
		return ProtocolVersion;
	}

	public void setProtocolVersion(int protocolVersion) {
		ProtocolVersion = protocolVersion;
	}

	public byte[] getOriginalByte() {
		return originalByte;
	}

	public void setOriginalByte(byte[] originalByte) {
		this.originalByte = originalByte;
	}

	public int getHospitalID() {
		return hospitalID;
	}

	public void setHospitalID(int hospitalID) {
		this.hospitalID = hospitalID;
	}

	public int getDeviceID() {
		return deviceID;
	}

	public void setDeviceID(int deviceID) {
		this.deviceID = deviceID;
	}

	public String getDeviceSN() {
		return deviceSN;
	}

	public void setDeviceSN(String deviceSN) {
		this.deviceSN = deviceSN;
	}

	public int getCmdType() {
		return cmdType;
	}

	public void setCmdType(int cmdType) {
		this.cmdType = cmdType;
	}

	public CMDID getCmd() {
		return cmd;
	}

	public void setCmd(CMDID cmd) {
		this.cmd = cmd;
	}

	public int getDataByteLength() {
		return dataByteLength;
	}

	public void setDataByteLength(int dataByteLength) {
		this.dataByteLength = dataByteLength;
	}

	public byte[] getDataByte() {
		return dataByte;
	}

	public void setDataByte(byte[] dataByte) {
		this.dataByte = dataByte;
	}

	public byte[] getCrcByte() {
		return crcByte;
	}

	public void setCrcByte(byte[] crcByte) {
		this.crcByte = crcByte;
	}

	public String getWifiMac() {
		return wifiMac;
	}

	public void setWifiMac(String wifiMac) {
		this.wifiMac = wifiMac;
	}

	public String getBluetoothMac() {
		return bluetoothMac;
	}

	public void setBluetoothMac(String bluetoothMac) {
		this.bluetoothMac = bluetoothMac;
	}

	public String getMac() {
		return Mac;
	}

	public void setMac(String mac) {
		Mac = mac;
	}

	/**
	 * 分析命令数据，填充命令对象的各个公共字段属性
	 * 
	 * @return 命令对象
	 */
	public abstract CmdModel GenerateCmdModel(byte[] cmdbyte);

	/**
	 * 生成反馈指令对象
	 * 
	 * @return
	 */
	public abstract CmdModel GenerateReturnCmd(boolean result);

	/**
	 * 生成反馈指令字节
	 * 
	 * @return
	 */
	public abstract byte[] GenerateReturnCmdByte(boolean result);
	
	

}
