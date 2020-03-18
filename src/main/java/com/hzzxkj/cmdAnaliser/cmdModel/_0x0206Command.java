package com.hzzxkj.cmdAnaliser.cmdModel;

import com.hzzxkj.cmdAnaliser.BaseCommand;
import com.hzzxkj.cmdAnaliser.CmdConstant;
import com.hzzxkj.cmdAnaliser.CmdUtils;

/**
 * 查询设备参数、主要是医院编号 设备编号，sn号、IP地址等
 * @author liujun
 *
 */
public class _0x0206Command extends BaseCommand {

	/**
	 * ip地址
	 */
	public String IP;
	/**
	 * 端口号
	 */
	public int port;

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * 构造函数，通过命令字节数组生成一个命令对象
	 * 
	 * @param cmdbyte 命令字节数组 格式如"55 aa 99 28 2c 2b 03 12 02 00 06 1a 40 65 6e 6e 4c
	 *                AA 57 00 01 33 cc "
	 */
	public _0x0206Command(byte[] cmdbyte) {
		GenerateCmdModel(cmdbyte);
	}

	@Override
	public _0x0206Command GenerateCmdModel(byte[] cmdbyte) {

		return (_0x0206Command) super.GenerateCmdModel(cmdbyte);
	}

	@Override
	public _0x0206Command GenerateReturnCmd(boolean result) {

		return (_0x0206Command) super.GenerateReturnCmd(result);
	}

	@Override
	public byte[] GenerateReturnCmdByte(boolean result) {

		return super.GenerateReturnCmdByte(result);
	}

	@Override
	public void AnalysisSpecialItem() {
		if (originalByte[0]==(byte)CmdConstant.mcuToPcHeaderFirst) {
			this.IP = CmdUtils.ByteArrayToNormalString(dataByte, 7, 4);
			this.port = CmdUtils.ByteArray2ToInteger(dataByte, 11);
		}else {
			
		}
	}

}
