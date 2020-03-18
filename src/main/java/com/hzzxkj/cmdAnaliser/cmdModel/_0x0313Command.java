package com.hzzxkj.cmdAnaliser.cmdModel;

import com.hzzxkj.cmdAnaliser.BaseCommand;
import com.hzzxkj.cmdAnaliser.CmdConstant;
import com.hzzxkj.cmdAnaliser.CmdUtils;

/**
 * 读取bootloader版本
 * 
 * @author liujun
 *
 */
public class _0x0313Command extends BaseCommand {

	public int major;

	public int minor;

	public int build;

	public int getMajor() {
		return major;
	}

	public void setMajor(int major) {
		this.major = major;
	}

	public int getMinor() {
		return minor;
	}

	public void setMinor(int minor) {
		this.minor = minor;
	}

	public int getBuild() {
		return build;
	}

	public void setBuild(int build) {
		this.build = build;
	}

	public _0x0313Command(byte[] cmdbyte) {
		GenerateCmdModel(cmdbyte);
	}

	@Override
	public _0x0313Command GenerateCmdModel(byte[] cmdbyte) {

		return (_0x0313Command) super.GenerateCmdModel(cmdbyte);
	}

	@Override
	public _0x0313Command GenerateReturnCmd(boolean result) {

		return (_0x0313Command) super.GenerateReturnCmd(result);
	}

	@Override
	public byte[] GenerateReturnCmdByte(boolean result) {

		return super.GenerateReturnCmdByte(result);
	}

	@Override
	public void AnalysisSpecialItem() {
		if (originalByte[0] == (byte) CmdConstant.mcuToPcHeaderFirst) {
		this.major = CmdUtils.ByteArray2ToInteger(dataByte, 0);
		this.minor = CmdUtils.ByteArray2ToInteger(dataByte, 2);
		this.build = CmdUtils.ByteArray2ToInteger(dataByte, 4);
		}
	}
}
