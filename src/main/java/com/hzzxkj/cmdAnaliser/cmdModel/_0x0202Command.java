package com.hzzxkj.cmdAnaliser.cmdModel;

import com.hzzxkj.cmdAnaliser.BaseCommand;
import com.hzzxkj.cmdAnaliser.CmdConstant;
import com.hzzxkj.cmdAnaliser.CmdUtils;

/**
 * 读取采集器日志指令
 * @author liujun
 *
 */
public class _0x0202Command extends BaseCommand {
     
	/**
	 * 日志事件id 
	 * 1、开关机 状态
	 * 2、工作状态
	 * 3、电池状态
	 * 4、学习状态 
	 * 5、故障状态
	 * 6、上电状态
	 * 7、采集器电源状态
	 */
	public int EventID;
	/**
	 * 日志事件状态
	 * 开关机状态     1开机   0关机 
	 * 工作状态       0 待机    1工作
	 * 电池状态        0 充满   1欠电  2不满但不欠电
	 * 学习状态    0 未学习   1 学习
	 * 故障状态     0 无故障   1故障
	 * 上电状态    1上电      0掉电
	 * 采集器电源状态  1上电  0掉电  与上电状态一样，
	 */
	public int EventStatus;
	public int getEventID() {
		return EventID;
	}
	public void setEventID(int eventID) {
		EventID = eventID;
	}
	public int getEventStatus() {
		return EventStatus;
	}
	public void setEventStatus(int eventStatus) {
		EventStatus = eventStatus;
	}
	/**
	 * 构造函数，通过命令字节数组生成一个命令对象
	 * @param cmdbyte   命令字节数组  格式如"55 aa 99 28 2c 2b 03 12 02 00 06 1a 40 65 6e 6e 4c AA 57 00 01 33 cc "
	 */
	public _0x0202Command(byte[] cmdbyte) {
		GenerateCmdModel(cmdbyte);
	}
	@Override
	public _0x0202Command GenerateCmdModel(byte[] cmdbyte) {
		
		return (_0x0202Command) super.GenerateCmdModel(cmdbyte);
	}

	@Override
	public _0x0202Command GenerateReturnCmd(boolean result) {
		
       return  (_0x0202Command)super.GenerateReturnCmd(result);
	}

	@Override
	public byte[] GenerateReturnCmdByte(boolean result) {

		return super.GenerateReturnCmdByte(result);
	}
    
     @Override
    public void AnalysisSpecialItem() {
    	if (originalByte[0]==(byte)CmdConstant.mcuToPcHeaderFirst) {
			this.EventID = CmdUtils.ByteToInt(dataByte[6]);
			this.EventStatus = CmdUtils.ByteToInt(dataByte[7]);
			this.TickNum = CmdUtils.ByteArray4ToInteger(dataByte, 0);
		}
    }
}
