package com.hzzxkj.cmdAnaliser.cmdModel;

import com.hzzxkj.cmdAnaliser.BaseCommand;
import com.hzzxkj.cmdAnaliser.CmdConstant;
import com.hzzxkj.cmdAnaliser.CmdUtils;

/**
 * 切换串口工作模式指令
 * 
 * @author liujun
 *
 */
public class _0x0219Command extends BaseCommand {

	/**
	 * 设置是否成功 1成功 0 失败
	 */
	public boolean setSuccess;

	public _0x0219Command(byte[] cmdbyte) {
		GenerateCmdModel(cmdbyte);
	}

	public boolean isSetSuccess() {
		return setSuccess;
	}

	public void setSetSuccess(boolean setSuccess) {
		this.setSuccess = setSuccess;
	}

	@Override
	public _0x0219Command GenerateCmdModel(byte[] cmdbyte) {

		return (_0x0219Command) super.GenerateCmdModel(cmdbyte);
	}

	@Override
	public _0x0219Command GenerateReturnCmd(boolean result) {

		return (_0x0219Command) super.GenerateReturnCmd(result);
	}

	@Override
	public byte[] GenerateReturnCmdByte(boolean result) {

		return super.GenerateReturnCmdByte(result);
	}

	@Override
	public void AnalysisSpecialItem() {
		if (originalByte[0] == (byte) CmdConstant.mcuToPcHeaderFirst) {
			this.setSuccess = (CmdUtils.ByteToInt(dataByte[0]) == 0 ? false : true);
		}
	}
}
