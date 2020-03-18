package com.hzzxkj.cmdAnaliser.cmdModel;

import com.hzzxkj.cmdAnaliser.BaseCommand;
import com.hzzxkj.cmdAnaliser.CmdConstant;
import com.hzzxkj.cmdAnaliser.CmdUtils;

/**
 * 读取主wifi信息指令
 * @author liujun
 *
 */
public class _0x0261Command extends BaseCommand {

	/**
	 * wifi名称
	 */
	public String wifiSsid;
	/**
	 * wifi密码
	 */
	public String wifiPassword;
	
	public _0x0261Command(byte[] cmdbyte) {
		GenerateCmdModel(cmdbyte);
	}
	@Override
	public _0x0261Command GenerateCmdModel(byte[] cmdbyte) {
		
		return (_0x0261Command) super.GenerateCmdModel(cmdbyte);
	}

	@Override
	public _0x0261Command GenerateReturnCmd(boolean result) {
		
       return  (_0x0261Command)super.GenerateReturnCmd(result);
	}

	@Override
	public byte[] GenerateReturnCmdByte(boolean result) {

		return super.GenerateReturnCmdByte(result);
	}
    
     @Override
    public void AnalysisSpecialItem() {
    	 if (originalByte[0]==(byte)CmdConstant.mcuToPcHeaderFirst) {
			this.wifiSsid = CmdUtils.ByteArrayToNormalString(dataByte, 0, 32);
			this.wifiPassword = CmdUtils.ByteArrayToNormalString(dataByte, 32,32);
    	 }
    }
}
