package com.hzzxkj.cmdAnaliser.cmdModel;

import com.hzzxkj.cmdAnaliser.BaseCommand;
import com.hzzxkj.cmdAnaliser.CmdConstant;
import com.hzzxkj.cmdAnaliser.CmdUtils;

/**
 * 清除报警指令
 * @author liujun
 *
 */
public class _0x0214Command extends BaseCommand {

	/**
	 * 清除报警是否成功  1 成功 0 失败
	 */
	public Boolean clearSuccess;
	
	
	public Boolean getClearSuccess() {
		return clearSuccess;
	}
	public void setClearSuccess(Boolean clearSuccess) {
		this.clearSuccess = clearSuccess;
	}
	public _0x0214Command(byte[] cmdbyte) {
		GenerateCmdModel(cmdbyte);
	}
	@Override
	public _0x0214Command GenerateCmdModel(byte[] cmdbyte) {
		
		return (_0x0214Command) super.GenerateCmdModel(cmdbyte);
	}

	@Override
	public _0x0214Command GenerateReturnCmd(boolean result) {
		
       return  (_0x0214Command)super.GenerateReturnCmd(result);
	}

	@Override
	public byte[] GenerateReturnCmdByte(boolean result) {

		return super.GenerateReturnCmdByte(result);
	}
    
     @Override
    public void AnalysisSpecialItem() {
    	 if (originalByte[0]==(byte)CmdConstant.mcuToPcHeaderFirst) {
    	this.clearSuccess = ( CmdUtils.ByteToInt(dataByte[0])==0?false:true);
    	 }
    }
}
