package com.hzzxkj.cmdAnaliser.cmdModel;

import com.hzzxkj.cmdAnaliser.BaseCommand;
import com.hzzxkj.cmdAnaliser.CmdConstant;
import com.hzzxkj.cmdAnaliser.CmdUtils;

/**
 * 读取呼吸机类型
 * @author liujun
 *
 */
public class _0x0311Command extends BaseCommand {

	/**
	 * 呼吸机类型
	 */
	public String respiratorType;
	
	public String getRespiratorType() {
		return respiratorType;
	}
	public void setRespiratorType(String respiratorType) {
		this.respiratorType = respiratorType;
	}
	public _0x0311Command(byte[] cmdbyte) {
		GenerateCmdModel(cmdbyte);
	}
	@Override
	public _0x0311Command GenerateCmdModel(byte[] cmdbyte) {
		
		return (_0x0311Command) super.GenerateCmdModel(cmdbyte);
	}

	@Override
	public _0x0311Command GenerateReturnCmd(boolean result) {
		
       return  (_0x0311Command)super.GenerateReturnCmd(result);
	}

	@Override
	public byte[] GenerateReturnCmdByte(boolean result) {

		return super.GenerateReturnCmdByte(result);
	}
    
     @Override
    public void AnalysisSpecialItem() {
    	 if (originalByte[0] == (byte) CmdConstant.mcuToPcHeaderFirst) {
    	 this.respiratorType = CmdUtils.ByteArrayToHexString(dataByte);
    	 }
    }
}
