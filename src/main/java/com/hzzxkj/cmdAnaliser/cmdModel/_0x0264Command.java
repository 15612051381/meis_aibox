package com.hzzxkj.cmdAnaliser.cmdModel;

import com.hzzxkj.cmdAnaliser.BaseCommand;
import com.hzzxkj.cmdAnaliser.CmdConstant;
import com.hzzxkj.cmdAnaliser.CmdUtils;
/**
 * 设置采集器网口的本地IP
 * @author asus
 *
 */
public class _0x0264Command extends BaseCommand {

	/**
	 * ip是否设置成功  1 成功  0 失败
	 */
	public boolean isSuccess;
	
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public _0x0264Command(byte[] cmdbyte) {
		GenerateCmdModel(cmdbyte);
	}
	@Override
	public _0x0264Command GenerateCmdModel(byte[] cmdbyte) {
		
		return (_0x0264Command) super.GenerateCmdModel(cmdbyte);
	}

	@Override
	public _0x0264Command GenerateReturnCmd(boolean result) {
		
       return  (_0x0264Command)super.GenerateReturnCmd(result);
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
