package com.hzzxkj.cmdAnaliser.cmdModel;

import com.hzzxkj.cmdAnaliser.BaseCommand;

/**
 * 不支持指令返回包
 * @author liujun
 *
 */
public class _0xffffCommand extends BaseCommand {

	

	
	public _0xffffCommand(byte[] cmdbyte) {
		GenerateCmdModel(cmdbyte);
	}
	@Override
	public _0xffffCommand GenerateCmdModel(byte[] cmdbyte) {
		
		return (_0xffffCommand) super.GenerateCmdModel(cmdbyte);
	}

	@Override
	public _0xffffCommand GenerateReturnCmd(boolean result) {
		
       return  (_0xffffCommand)super.GenerateReturnCmd(result);
	}

	@Override
	public byte[] GenerateReturnCmdByte(boolean result) {

		return super.GenerateReturnCmdByte(result);
	}
    
     @Override
    public void AnalysisSpecialItem() {
    	
    }
}
