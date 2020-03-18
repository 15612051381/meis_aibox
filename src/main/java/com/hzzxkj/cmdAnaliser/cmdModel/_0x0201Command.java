package com.hzzxkj.cmdAnaliser.cmdModel;

import com.hzzxkj.cmdAnaliser.BaseCommand;
import com.hzzxkj.cmdAnaliser.CmdConstant;
import com.hzzxkj.cmdAnaliser.CmdUtils;

/**
 * 采集器心跳协议包
 * @author liujun
 *
 */
public class _0x0201Command extends BaseCommand {
	/**
	 * 设备开关机状态  1开机  0 关机
	 */
     public int equipmentStatus;
     /**
      * 设备工作状态 1 工作   0 待机
      */
     public int workStatus;
     public int getEquipmentStatus() {
		return equipmentStatus;
	}
	public void setEquipmentStatus(int equipmentStatus) {
		this.equipmentStatus = equipmentStatus;
	}
	public int getWorkStatus() {
		return workStatus;
	}
	public void setWorkStatus(int workStatus) {
		this.workStatus = workStatus;
	}
	public int getLogCount() {
		return logCount;
	}
	public void setLogCount(int logCount) {
		this.logCount = logCount;
	}
	public int getFaultStatus() {
		return faultStatus;
	}
	public void setFaultStatus(int faultStatus) {
		this.faultStatus = faultStatus;
	}
	public String getApMac() {
		return apMac;
	}
	public void setApMac(String apMac) {
		this.apMac = apMac;
	}

	/**
      * 日志数量
      */
     public int logCount;
     /**
      * 故障状态   1故障  0 无故障
      */
     public int faultStatus;
	/**
	 * 设备的额路由mac地址
	 */
     public String apMac;
     
	/**
	 * 构造函数，通过命令字节数组生成一个命令对象
	 * @param cmdbyte   命令字节数组  格式如"55 aa 99 28 2c 2b 03 12 02 00 06 1a 40 65 6e 6e 4c AA 57 00 01 33 cc "
	 */
	public _0x0201Command(byte[] cmdbyte) {
		GenerateCmdModel(cmdbyte);
	}
	@Override
	public _0x0201Command GenerateCmdModel(byte[] cmdbyte) {
		
		return (_0x0201Command) super.GenerateCmdModel(cmdbyte);
	}

	@Override
	public _0x0201Command GenerateReturnCmd(boolean result) {
		
       return  (_0x0201Command)super.GenerateReturnCmd(result);
	}

	@Override
	public byte[] GenerateReturnCmdByte(boolean result) {

		return super.GenerateReturnCmdByte(result);
	}
    
     @Override
    public void AnalysisSpecialItem() {
    	if (originalByte[0]==(byte)CmdConstant.mcuToPcHeaderFirst) {
			this.equipmentStatus = CmdUtils.ByteToInt(dataByte[0]);
			this.workStatus = CmdUtils.ByteToInt(dataByte[1]);
			this.TickNum = CmdUtils.ByteArray4ToInteger(dataByte, 4);
			this.logCount = CmdUtils.ByteArray2ToInteger(dataByte, 10);
			this.apMac = CmdUtils.ByteArrayToHexString(dataByte, 16, 6);
			this.faultStatus = CmdUtils.ByteToInt(dataByte[22]);
		}
    }
}
