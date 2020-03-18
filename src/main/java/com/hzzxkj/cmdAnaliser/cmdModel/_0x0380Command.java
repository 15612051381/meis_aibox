package com.hzzxkj.cmdAnaliser.cmdModel;

import com.hzzxkj.cmdAnaliser.BaseCommand;
import com.hzzxkj.cmdAnaliser.CmdConstant;
import com.hzzxkj.cmdAnaliser.CmdUtils;

/**
 * 采集器电源状态
 * @author liujun
 *
 */
public class _0x0380Command extends BaseCommand {

	
	/**
	 * 采集器电源状态  1上电  0 断电
	 */
	public int powerStatus;
    
	public int getPowerStatus() {
		return powerStatus;
	}

	public void setPowerStatus(int powerStatus) {
		this.powerStatus = powerStatus;
	}

	public _0x0380Command(byte[] cmdbyte) {
		GenerateCmdModel(cmdbyte);
	}

	@Override
	public _0x0380Command GenerateCmdModel(byte[] cmdbyte) {

		return (_0x0380Command) super.GenerateCmdModel(cmdbyte);
	}

	@Override
	public _0x0380Command GenerateReturnCmd(boolean result) {

		return (_0x0380Command) super.GenerateReturnCmd(result);
	}

	@Override
	public byte[] GenerateReturnCmdByte(boolean result) {

		return super.GenerateReturnCmdByte(result);
	}

	@Override
	public void AnalysisSpecialItem() {
		if (originalByte[0] == (byte) CmdConstant.mcuToPcHeaderFirst) {
		this.powerStatus = CmdUtils.ByteToInt(dataByte[0]);
		this.TickNum= CmdUtils.ByteArray4ToInteger(dataByte, 5);
		}
	}
}
