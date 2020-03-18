package com.hzzxkj.cmdAnaliser.cmdModel;

import com.hzzxkj.cmdAnaliser.BaseCommand;
import com.hzzxkj.cmdAnaliser.CmdConstant;
import com.hzzxkj.cmdAnaliser.CmdUtils;

public class _0x0225Command extends BaseCommand {

	/**
	 * 人工报故障  
	 */
	public int errorStatus;
    
	public int getErrorStatus() {
		return errorStatus;
	}

	public void setErrorStatus(int errorStatus) {
		this.errorStatus = errorStatus;
	}

	public _0x0225Command(byte[] cmdbyte) {
		GenerateCmdModel(cmdbyte);
	}

	@Override
	public _0x0225Command GenerateCmdModel(byte[] cmdbyte) {

		return (_0x0225Command) super.GenerateCmdModel(cmdbyte);
	}

	@Override
	public _0x0225Command GenerateReturnCmd(boolean result) {

		return (_0x0225Command) super.GenerateReturnCmd(result);
	}

	@Override
	public byte[] GenerateReturnCmdByte(boolean result) {

		return super.GenerateReturnCmdByte(result);
	}

	@Override
	public void AnalysisSpecialItem() {
		if (originalByte[0]==(byte)CmdConstant.mcuToPcHeaderFirst) {
		this.errorStatus = CmdUtils.ByteToInt(dataByte[0]);
		this.TickNum= CmdUtils.ByteArray4ToInteger(dataByte, 5);
		}
		
	}
}
