package com.hzzxkj.cmdAnaliser.cmdModel;

import java.util.ArrayList;

import com.hzzxkj.cmdAnaliser.BaseCommand;
import com.hzzxkj.cmdAnaliser.CmdConstant;
import com.hzzxkj.cmdAnaliser.CmdUtils;

/**
 * 设置呼吸机通道
 * 
 * @author liujun
 *
 */
public class _0x0302Command extends BaseCommand {

	/**
	 * 呼吸机通道是否设置成功 1成功 0 失败
	 */
	public boolean isSuccess;
	/**
	 * 通道数据 16进制的字符串 每个通道为4个字节的数据
	 */
	public String ChannelData;

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getChannelData() {
		return ChannelData;
	}

	public void setChannelData(String channelData) {
		ChannelData = channelData;
	}

	public _0x0302Command(byte[] cmdbyte) {
		GenerateCmdModel(cmdbyte);
	}

	@Override
	public _0x0302Command GenerateCmdModel(byte[] cmdbyte) {

		return (_0x0302Command) super.GenerateCmdModel(cmdbyte);
	}

	@Override
	public _0x0302Command GenerateReturnCmd(boolean result) {

		return (_0x0302Command) super.GenerateReturnCmd(result);
	}

	@Override
	public byte[] GenerateReturnCmdByte(boolean result) {

		return super.GenerateReturnCmdByte(result);
	}

	@Override
	public void AnalysisSpecialItem() {
		if (originalByte[0] == (byte) CmdConstant.mcuToPcHeaderFirst) {
			if (dataByteLength == 1) {
				this.isSuccess = (CmdUtils.ByteToInt(dataByte[0]) == 0 ? false : true);
			} else {
				ChannelData = CmdUtils.ByteArrayToHexString(dataByte);
			}
		}
	}
}
