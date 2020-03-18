package com.hzzxkj.cmdAnaliser.cmdModel;

import com.hzzxkj.cmdAnaliser.BaseCommand;
import com.hzzxkj.cmdAnaliser.CmdConstant;
import com.hzzxkj.cmdAnaliser.CmdUtils;

/**
 * 设置串口数据上报
 * @author liujun
 *
 */
public class _0x0315Command extends BaseCommand {

	/**
	 * 是否上传串口数据   1上报   0 不上报
	 */
	public int isUploadData;
	
	public int getIsUploadData() {
		return isUploadData;
	}

	public void setIsUploadData(int isUploadData) {
		this.isUploadData = isUploadData;
	}

	public _0x0315Command(byte[] cmdbyte) {
		GenerateCmdModel(cmdbyte);
	}

	@Override
	public _0x0315Command GenerateCmdModel(byte[] cmdbyte) {

		return (_0x0315Command) super.GenerateCmdModel(cmdbyte);
	}

	@Override
	public _0x0315Command GenerateReturnCmd(boolean result) {

		return (_0x0315Command) super.GenerateReturnCmd(result);
	}

	@Override
	public byte[] GenerateReturnCmdByte(boolean result) {

		return super.GenerateReturnCmdByte(result);
	}

	@Override
	public void AnalysisSpecialItem() {
		if (originalByte[0] == (byte) CmdConstant.mcuToPcHeaderFirst) {
		this.isUploadData = CmdUtils.ByteToInt(dataByte[0]);
		}
	}
}
