package com.hzzxkj.cmdAnaliser.cmdModel;

import com.hzzxkj.cmdAnaliser.BaseCommand;
import com.hzzxkj.cmdAnaliser.CmdConstant;
import com.hzzxkj.cmdAnaliser.CmdUtils;

/**
 * 读取采集器wifimac地址
 * @author liujun
 *
 */
public class _0x021cCommand extends BaseCommand {
	
	
	public _0x021cCommand(byte[] cmdbyte) {
		GenerateCmdModel(cmdbyte);
	}
	@Override
	public _0x021cCommand GenerateCmdModel(byte[] cmdbyte) {
		
		return (_0x021cCommand) super.GenerateCmdModel(cmdbyte);
	}

	@Override
	public _0x021cCommand GenerateReturnCmd(boolean result) {
		
       return  (_0x021cCommand)super.GenerateReturnCmd(result);
	}

	@Override
	public byte[] GenerateReturnCmdByte(boolean result) {

		return super.GenerateReturnCmdByte(result);
	}
    
     @Override
    public void AnalysisSpecialItem() {
    	 if (originalByte[0]==(byte)CmdConstant.mcuToPcHeaderFirst) {
    	this.wifiMac = CmdUtils.ByteArrayToNormalString(dataByte, 0, 6);
    	 }
    }
}
