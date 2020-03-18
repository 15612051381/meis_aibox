package com.hzzxkj.cmdAnaliser.cmdModel;

import com.hzzxkj.cmdAnaliser.BaseCommand;
import com.hzzxkj.cmdAnaliser.CmdConstant;
import com.hzzxkj.cmdAnaliser.CmdUtils;

/**
 * 读取采集器备用wifi
 * @author liujun
 *
 */
public class _0x0319Command extends BaseCommand {

	/**
	 * wifi编号
	 */
	public int wifiNo;

	/**
	 * wifi名称
	 */
	public String wifiSsid;
	/**
	 * wifi密码
	 */
	public String wifiPassword;

	public int getWifiNo() {
		return wifiNo;
	}

	public void setWifiNo(int wifiNo) {
		this.wifiNo = wifiNo;
	}

	public String getWifiSsid() {
		return wifiSsid;
	}

	public void setWifiSsid(String wifiSsid) {
		this.wifiSsid = wifiSsid;
	}

	public String getWifiPassword() {
		return wifiPassword;
	}

	public void setWifiPassword(String wifiPassword) {
		this.wifiPassword = wifiPassword;
	}

	public _0x0319Command(byte[] cmdbyte) {
		GenerateCmdModel(cmdbyte);
	}

	@Override
	public _0x0319Command GenerateCmdModel(byte[] cmdbyte) {

		return (_0x0319Command) super.GenerateCmdModel(cmdbyte);
	}

	@Override
	public _0x0319Command GenerateReturnCmd(boolean result) {

		return (_0x0319Command) super.GenerateReturnCmd(result);
	}

	@Override
	public byte[] GenerateReturnCmdByte(boolean result) {

		return super.GenerateReturnCmdByte(result);
	}

	@Override
	public void AnalysisSpecialItem() {
		if (originalByte[0] == (byte) CmdConstant.mcuToPcHeaderFirst) {
		this.wifiNo = CmdUtils.ByteToInt(dataByte[0]);
		this.wifiSsid = CmdUtils.ByteArrayToNormalString(dataByte, 1, 32);
		this.wifiPassword = CmdUtils.ByteArrayToNormalString(dataByte, 33, 32);
		}
	}
}
