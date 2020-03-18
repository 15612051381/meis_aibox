package com.hzzxkj.cmdAnaliser.cmdModel;

import com.hzzxkj.cmdAnaliser.BaseCommand;
import com.hzzxkj.cmdAnaliser.CmdConstant;
import com.hzzxkj.cmdAnaliser.CmdUtils;

public class _0x0267Command extends BaseCommand {

	/**
	 * mac地址
	 */
	public String macaddress;
	
	public String getMacaddress() {
		return macaddress;
	}
	public void setMacaddress(String macaddress) {
		this.macaddress = macaddress;
	}
	
	public _0x0267Command(byte[] cmdbyte) {
		GenerateCmdModel(cmdbyte);
	}
	@Override
	public _0x0267Command GenerateCmdModel(byte[] cmdbyte) {
		
		return (_0x0267Command) super.GenerateCmdModel(cmdbyte);
	}

	@Override
	public _0x0267Command GenerateReturnCmd(boolean result) {
		
       return  (_0x0267Command)super.GenerateReturnCmd(result);
	}

	@Override
	public byte[] GenerateReturnCmdByte(boolean result) {

		return super.GenerateReturnCmdByte(result);
	}
    
     @Override
    public void AnalysisSpecialItem() {
    	 if (originalByte[0]==(byte)CmdConstant.mcuToPcHeaderFirst) {
    	
    	this.macaddress = CmdUtils.ByteArrayToNormalString(dataByte, 0, 6);
    	
    	 }
    }
}
