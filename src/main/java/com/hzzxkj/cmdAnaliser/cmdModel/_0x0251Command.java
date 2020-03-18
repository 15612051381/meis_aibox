package com.hzzxkj.cmdAnaliser.cmdModel;

import com.hzzxkj.cmdAnaliser.BaseCommand;
import com.hzzxkj.cmdAnaliser.CmdConstant;
import com.hzzxkj.cmdAnaliser.CmdUtils;

/**
 * 读取关机待机工作参数
 * @author liujun
 *
 */
public class _0x0251Command extends BaseCommand {

	
	/**
	 * 关机平均值
	 */
	public int closeAverageValue;
	/**
	 * 关机波动值
	 */
	public int closeWaveValue;
	
	/**
	 * 开机平均值
	 */
	public int openAverageValue;
	/**
	 * 开机波动值
	 */
	public int openWaveValue;
	
	/**
	 * 待机平均值
	 */
	public int StandbyAverageValue;
	/**
	 * 待机波动值
	 */
	public int StandbyWaveValue;
	
	
	public int getCloseAverageValue() {
		return closeAverageValue;
	}
	public void setCloseAverageValue(int closeAverageValue) {
		this.closeAverageValue = closeAverageValue;
	}
	public int getCloseWaveValue() {
		return closeWaveValue;
	}
	public void setCloseWaveValue(int closeWaveValue) {
		this.closeWaveValue = closeWaveValue;
	}
	public int getOpenAverageValue() {
		return openAverageValue;
	}
	public void setOpenAverageValue(int openAverageValue) {
		this.openAverageValue = openAverageValue;
	}
	public int getOpenWaveValue() {
		return openWaveValue;
	}
	public void setOpenWaveValue(int openWaveValue) {
		this.openWaveValue = openWaveValue;
	}
	public int getStandbyAverageValue() {
		return StandbyAverageValue;
	}
	public void setStandbyAverageValue(int standbyAverageValue) {
		StandbyAverageValue = standbyAverageValue;
	}
	public int getStandbyWaveValue() {
		return StandbyWaveValue;
	}
	public void setStandbyWaveValue(int standbyWaveValue) {
		StandbyWaveValue = standbyWaveValue;
	}
	public _0x0251Command(byte[] cmdbyte) {
		GenerateCmdModel(cmdbyte);
	}
	@Override
	public _0x0251Command GenerateCmdModel(byte[] cmdbyte) {
		
		return (_0x0251Command) super.GenerateCmdModel(cmdbyte);
	}

	@Override
	public _0x0251Command GenerateReturnCmd(boolean result) {
		
       return  (_0x0251Command)super.GenerateReturnCmd(result);
	}

	@Override
	public byte[] GenerateReturnCmdByte(boolean result) {

		return super.GenerateReturnCmdByte(result);
	}
    
     @Override
    public void AnalysisSpecialItem() {
    	 if (originalByte[0]==(byte)CmdConstant.mcuToPcHeaderFirst) {
			this.closeAverageValue = CmdUtils.ByteArray2ToInteger(dataByte, 0);
			this.closeWaveValue = CmdUtils.ByteArray2ToInteger(dataByte, 2);
			this.StandbyAverageValue = CmdUtils.ByteArray2ToInteger(dataByte, 4);
			this.StandbyWaveValue = CmdUtils.ByteArray2ToInteger(dataByte, 6);
			this.openAverageValue = CmdUtils.ByteArray2ToInteger(dataByte, 8);
			this.openWaveValue = CmdUtils.ByteArray2ToInteger(dataByte, 10);
    	 }
    }
}
