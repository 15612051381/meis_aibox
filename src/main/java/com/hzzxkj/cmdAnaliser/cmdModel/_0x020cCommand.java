package com.hzzxkj.cmdAnaliser.cmdModel;

import com.hzzxkj.cmdAnaliser.BaseCommand;
import com.hzzxkj.cmdAnaliser.CmdConstant;
import com.hzzxkj.cmdAnaliser.CmdUtils;

/**
 * 查询版本信息
 * @author liujun
 *
 */
public class _0x020cCommand extends BaseCommand {

	public int major;
	
	public int minor;
	
	public int build;
	
	public int getMajor() {
		return major;
	}
	public void setMajor(int major) {
		this.major = major;
	}
	public int getMinor() {
		return minor;
	}
	public void setMinor(int minor) {
		this.minor = minor;
	}
	public int getBuild() {
		return build;
	}
	public void setBuild(int build) {
		this.build = build;
	}
	public _0x020cCommand(byte[] cmdbyte) {
		GenerateCmdModel(cmdbyte);
	}
	@Override
	public _0x020cCommand GenerateCmdModel(byte[] cmdbyte) {
		
		return (_0x020cCommand) super.GenerateCmdModel(cmdbyte);
	}

	@Override
	public _0x020cCommand GenerateReturnCmd(boolean result) {
		
       return  (_0x020cCommand)super.GenerateReturnCmd(result);
	}

	@Override
	public byte[] GenerateReturnCmdByte(boolean result) {

		return super.GenerateReturnCmdByte(result);
	}
    
     @Override
    public void AnalysisSpecialItem() {
    	 if (originalByte[0]==(byte)CmdConstant.mcuToPcHeaderFirst) {
    		 this.major = CmdUtils.ByteArray2ToInteger(dataByte, 0);
    	    	this.minor = CmdUtils.ByteArray2ToInteger(dataByte, 2);
    	    	this.build = CmdUtils.ByteArray2ToInteger(dataByte, 4);
		} else {

		}
    	
    }
	
}
