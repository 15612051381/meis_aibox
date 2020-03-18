package com.hzzxkj.cmdAnaliser.cmdModel;

import com.hzzxkj.cmdAnaliser.BaseCommand;
import com.hzzxkj.cmdAnaliser.CmdConstant;
import com.hzzxkj.cmdAnaliser.CmdUtils;

/**
 * 设置迈瑞监护网口IP
 * @author asus
 *
 */
public class _0x0262Command extends BaseCommand {

	/**
	 * 参数设置是否成功  1 成功 0 失败
	 */
	public boolean configSuccess; 
	
	
	public boolean isConfigSuccess() {
		return configSuccess;
	}
	public void setConfigSuccess(boolean configSuccess) {
		this.configSuccess = configSuccess;
	}
	/**
	 * 构造函数，通过命令字节数组生成一个命令对象
	 * @param cmdbyte   命令字节数组  格式如"55 aa 99 28 2c 2b 03 12 02 00 06 1a 40 65 6e 6e 4c AA 57 00 01 33 cc "
	 */
	public _0x0262Command(byte[] cmdbyte) {
		GenerateCmdModel(cmdbyte);
	}
	@Override
	public _0x0262Command GenerateCmdModel(byte[] cmdbyte) {
		
		return (_0x0262Command) super.GenerateCmdModel(cmdbyte);
	}

	@Override
	public _0x0262Command GenerateReturnCmd(boolean result) {
		
       return  (_0x0262Command)super.GenerateReturnCmd(result);
	}

	@Override
	public byte[] GenerateReturnCmdByte(boolean result) {

		return super.GenerateReturnCmdByte(result);
	}
    
     @Override
    public void AnalysisSpecialItem() {
    	 if (originalByte[0]==(byte)CmdConstant.mcuToPcHeaderFirst) {
    		 this.configSuccess = ( CmdUtils.ByteToInt(dataByte[0])==0?false:true);
		} else {

		}
    	
    }
}
