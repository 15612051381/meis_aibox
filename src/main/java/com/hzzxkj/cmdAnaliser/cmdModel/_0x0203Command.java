package com.hzzxkj.cmdAnaliser.cmdModel;

import com.hzzxkj.cmdAnaliser.BaseCommand;
import com.hzzxkj.cmdAnaliser.CmdConstant;
import com.hzzxkj.cmdAnaliser.CmdUtils;

/**
 * 删除单条日志指令
 * @author liujun
 *
 */
public class _0x0203Command extends BaseCommand {
    
	/**
	 * 删除一条日志是否成功 0 失败 1成功
	 */
	public boolean DeleteSuccess;

	public boolean isDeleteSuccess() {
		return DeleteSuccess;
	}

	public void setDeleteSuccess(boolean deleteSuccess) {
		DeleteSuccess = deleteSuccess;
	}
	
	/**
	 * 构造函数，通过命令字节数组生成一个命令对象
	 * @param cmdbyte   命令字节数组  格式如"55 aa 99 28 2c 2b 03 12 02 00 06 1a 40 65 6e 6e 4c AA 57 00 01 33 cc "
	 */
	public _0x0203Command(byte[] cmdbyte) {
		GenerateCmdModel(cmdbyte);
		//AnalysisSpecialItem();
	}
	@Override
	public _0x0203Command GenerateCmdModel(byte[] cmdbyte) {
		
		return (_0x0203Command) super.GenerateCmdModel(cmdbyte);
	}

	@Override
	public _0x0203Command GenerateReturnCmd(boolean result) {
		
       return  (_0x0203Command)super.GenerateReturnCmd(result);
	}

	@Override
	public byte[] GenerateReturnCmdByte(boolean result) {

		return super.GenerateReturnCmdByte(result);
	}
    
     @Override
    public void AnalysisSpecialItem() {
    	 if (originalByte[0]==(byte)CmdConstant.mcuToPcHeaderFirst) {
    		 this.DeleteSuccess = ( CmdUtils.ByteToInt(dataByte[0])==0?false:true);
		}
    	
    }

}
