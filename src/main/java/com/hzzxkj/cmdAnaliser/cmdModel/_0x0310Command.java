package com.hzzxkj.cmdAnaliser.cmdModel;

import com.hzzxkj.cmdAnaliser.BaseCommand;
import com.hzzxkj.cmdAnaliser.CmdConstant;
import com.hzzxkj.cmdAnaliser.CmdUtils;

/**
 * 采集器重启指令
 * @author liujun
 *
 */
public class _0x0310Command extends BaseCommand {

	/**
	 * 采集器重启是否成功 1成功  0 失败
	 */
	public boolean isSuccess;
	
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public _0x0310Command(byte[] cmdbyte) {
		GenerateCmdModel(cmdbyte);
	}
	@Override
	public _0x0310Command GenerateCmdModel(byte[] cmdbyte) {
		
		return (_0x0310Command) super.GenerateCmdModel(cmdbyte);
	}

	@Override
	public _0x0310Command GenerateReturnCmd(boolean result) {
		
       return  (_0x0310Command)super.GenerateReturnCmd(result);
	}

	@Override
	public byte[] GenerateReturnCmdByte(boolean result) {

		return super.GenerateReturnCmdByte(result);
	}
    
     @Override
    public void AnalysisSpecialItem() {
    	 if (originalByte[0] == (byte) CmdConstant.mcuToPcHeaderFirst) {
    	 this.isSuccess = ( CmdUtils.ByteToInt(dataByte[0])==0?false:true);
    	 }
    }
}
