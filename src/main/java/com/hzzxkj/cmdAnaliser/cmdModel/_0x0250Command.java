package com.hzzxkj.cmdAnaliser.cmdModel;

import com.hzzxkj.cmdAnaliser.BaseCommand;
import com.hzzxkj.cmdAnaliser.CmdUtils;

/**
 * 学习工作待机工作参数指令
 * @author liujun
 *
 */
public class _0x0250Command extends BaseCommand {

	/**
	 * 指令是否接受成功  1 成功  0 失败
	 */
	public boolean receiveSuccess;
	/**
	 * 学习是否成功  1成功  0 失败
	 */
	public boolean studySuccess;
	/**
	 * 学习类型   1开机阈值   2待机阈值   3 关机阈值
	 */
	public int studyType;
	/**
	 * 平均值
	 */
	public int averageValue;
	/**
	 * 波动值
	 */
	public int waveValue;
	
	public boolean isReceiveSuccess() {
		return receiveSuccess;
	}
	public void setReceiveSuccess(boolean receiveSuccess) {
		this.receiveSuccess = receiveSuccess;
	}
	public boolean isStudySuccess() {
		return studySuccess;
	}
	public void setStudySuccess(boolean studySuccess) {
		this.studySuccess = studySuccess;
	}
	public int getStudyType() {
		return studyType;
	}
	public void setStudyType(int studyType) {
		this.studyType = studyType;
	}
	public int getAverageValue() {
		return averageValue;
	}
	public void setAverageValue(int averageValue) {
		this.averageValue = averageValue;
	}
	public int getWaveValue() {
		return waveValue;
	}
	public void setWaveValue(int waveValue) {
		this.waveValue = waveValue;
	}
	public _0x0250Command(byte[] cmdbyte) {
		GenerateCmdModel(cmdbyte);
	}
	@Override
	public _0x0250Command GenerateCmdModel(byte[] cmdbyte) {
		
		return (_0x0250Command) super.GenerateCmdModel(cmdbyte);
	}

	@Override
	public _0x0250Command GenerateReturnCmd(boolean result) {
		
       return  (_0x0250Command)super.GenerateReturnCmd(result);
	}

	@Override
	public byte[] GenerateReturnCmdByte(boolean result) {

		return super.GenerateReturnCmdByte(result);
	}
    
     @Override
    public void AnalysisSpecialItem() {
    	 if (dataByte.length==1) {
    		 this.receiveSuccess = ( CmdUtils.ByteToInt(dataByte[0])==0?false:true);
		} else {
			this.studySuccess = ( CmdUtils.ByteToInt(dataByte[0])==0?false:true);
			this.studyType = CmdUtils.ByteToInt(dataByte[1]);
			this.averageValue = CmdUtils.ByteArray2ToInteger(dataByte, 0);
			this.waveValue = CmdUtils.ByteArray2ToInteger(dataByte, 2);
		}
    	
    }
}
