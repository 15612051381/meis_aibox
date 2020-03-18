package com.hzzxkj.cmdAnaliser.cmdModel;

import com.hzzxkj.cmdAnaliser.BaseCommand;
import com.hzzxkj.cmdAnaliser.CmdConstant;
import com.hzzxkj.cmdAnaliser.CmdUtils;

/**
 * 读取呼吸机通道数据
 * @author liujun
 *
 */
public class _0x0301Command extends BaseCommand {
   /**
    * 故障码  0 无故障   1地址错误 2数据长度错误  3数据无效
    */
	public int  errCode;
	/**
	 * 故障指针：指示第几个通道错误
	 */
	public int errPoint;
	/**
	 * 通道数据  
	 */
	public byte[] channelData;
	
	
	public _0x0301Command(byte[] cmdbyte) {
		GenerateCmdModel(cmdbyte);
	}
	@Override
	public _0x0301Command GenerateCmdModel(byte[] cmdbyte) {
		
		return (_0x0301Command) super.GenerateCmdModel(cmdbyte);
	}

	@Override
	public _0x0301Command GenerateReturnCmd(boolean result) {
		
       return  (_0x0301Command)super.GenerateReturnCmd(result);
	}

	@Override
	public byte[] GenerateReturnCmdByte(boolean result) {

		return super.GenerateReturnCmdByte(result);
	}
    
     @Override
    public void AnalysisSpecialItem() {
    	 if (originalByte[0]==(byte)CmdConstant.mcuToPcHeaderFirst) {
			this.errCode = CmdUtils.ByteToInt(dataByte[0]);
			this.errPoint = CmdUtils.ByteToInt(dataByte[1]);
			this.channelData = CmdUtils.GetLastByteArray(dataByte, dataByte.length-2);
    	 }
    }
}
