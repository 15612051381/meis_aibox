package com.hzzxkj.cmdAnaliser.cmdModel;

import com.hzzxkj.cmdAnaliser.BaseCommand;
import com.hzzxkj.cmdAnaliser.CmdConstant;
import com.hzzxkj.cmdAnaliser.CmdUtils;

/**
 * 升级固件指令
 * @author liujun
 *
 */
public class _0x021fCommand extends BaseCommand {

	/**
	 * 升级是否成功 1成功  0 失败
	 */
	public boolean isSuccess;
	
	public _0x021fCommand(byte[] cmdbyte) {
		GenerateCmdModel(cmdbyte);
	}
	@Override
	public _0x021fCommand GenerateCmdModel(byte[] cmdbyte) {
		
		return (_0x021fCommand) super.GenerateCmdModel(cmdbyte);
	}

	@Override
	public _0x021fCommand GenerateReturnCmd(boolean result) {
		
       return  (_0x021fCommand)super.GenerateReturnCmd(result);
	}

	@Override
	public byte[] GenerateReturnCmdByte(boolean result) {

		return super.GenerateReturnCmdByte(result);
	}
    
     @Override
    public void AnalysisSpecialItem() {
    	 if (originalByte[0]==(byte)CmdConstant.mcuToPcHeaderFirst) {
    	this.isSuccess = ( CmdUtils.ByteToInt(dataByte[0])==0?false:true);
    	 }
    }
}
