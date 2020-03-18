package com.hzzxkj.cmdAnaliser.cmdModel;

import com.hzzxkj.cmdAnaliser.BaseCommand;
import com.hzzxkj.cmdAnaliser.CmdUtils;

/**
 * 设置呼吸机全参数通道
 * @author liujun
 *
 */
public class _0x042aCommand extends BaseCommand {

	/**
	 * 呼吸机全参数通道是否设置成功 1成功  0 失败
	 */
	public boolean isSuccess;
	
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public _0x042aCommand(byte[] cmdbyte) {
		GenerateCmdModel(cmdbyte);
	}
	@Override
	public _0x042aCommand GenerateCmdModel(byte[] cmdbyte) {
		
		return (_0x042aCommand) super.GenerateCmdModel(cmdbyte);
	}

	@Override
	public _0x042aCommand GenerateReturnCmd(boolean result) {
		
       return  (_0x042aCommand)super.GenerateReturnCmd(result);
	}

	@Override
	public byte[] GenerateReturnCmdByte(boolean result) {

		return super.GenerateReturnCmdByte(result);
	}
    
     @Override
    public void AnalysisSpecialItem() {
    	 this.isSuccess = ( CmdUtils.ByteToInt(dataByte[0])==0?false:true);
			
    }
}
