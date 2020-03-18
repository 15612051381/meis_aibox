package com.hzzxkj.cmdAnaliser.cmdModel;

import com.hzzxkj.cmdAnaliser.BaseCommand;
import com.hzzxkj.cmdAnaliser.CmdConstant;
import com.hzzxkj.cmdAnaliser.CmdUtils;

/**
 * 设置报警状态
 * @author liujun
 *
 */
public class _0x0314Command extends BaseCommand {

	/**
	 * 报警状态  0:常灭  1: 常亮   2:闪烁1  3:闪烁2   4 闪烁3
	 */
	public int alterStatus;

	public int getAlterStatus() {
		return alterStatus;
	}

	public void setAlterStatus(int alterStatus) {
		this.alterStatus = alterStatus;
	}

	public _0x0314Command(byte[] cmdbyte) {
		GenerateCmdModel(cmdbyte);
	}

	@Override
	public _0x0314Command GenerateCmdModel(byte[] cmdbyte) {

		return (_0x0314Command) super.GenerateCmdModel(cmdbyte);
	}

	@Override
	public _0x0314Command GenerateReturnCmd(boolean result) {

		return (_0x0314Command) super.GenerateReturnCmd(result);
	}

	@Override
	public byte[] GenerateReturnCmdByte(boolean result) {

		return super.GenerateReturnCmdByte(result);
	}

	@Override
	public void AnalysisSpecialItem() {
		if (originalByte[0] == (byte) CmdConstant.mcuToPcHeaderFirst) {
		this.alterStatus = CmdUtils.ByteToInt(dataByte[0]);
		}
	}
}
