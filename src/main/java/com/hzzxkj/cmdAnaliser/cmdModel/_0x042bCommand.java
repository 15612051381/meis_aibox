package com.hzzxkj.cmdAnaliser.cmdModel;

import java.util.ArrayList;

import com.hzzxkj.cmdAnaliser.BaseCommand;
import com.hzzxkj.cmdAnaliser.CRC16Util;
import com.hzzxkj.cmdAnaliser.CmdConstant;
import com.hzzxkj.cmdAnaliser.CmdUtils;

public class _0x042bCommand extends BaseCommand {

	
	/**
	 * 最后一包数据标志位  0 数据包  1 最后一包
	 */
	public int finalPackageFlag;
	/**
	 * 数据包号
	 */
	public int packageNo;
	/**
	 * 设备参数表版本号
	 */
	public int version;
	/**
	 * 数据包数据长度
	 */
	public int packageLength;
	
	/**
	 * 数据
	 */
	public byte[] originalWaveData;
	
	public String protocolString;
	
	public String getProtocolString() {
		return protocolString;
	}
	public void setProtocolString(String protocolString) {
		this.protocolString = protocolString;
	}
	public int getFinalPackageFlag() {
		return finalPackageFlag;
	}
	public void setFinalPackageFlag(int finalPackageFlag) {
		this.finalPackageFlag = finalPackageFlag;
	}
	public int getPackageNo() {
		return packageNo;
	}
	public void setPackageNo(int packageNo) {
		this.packageNo = packageNo;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public int getPackageLength() {
		return packageLength;
	}
	public void setPackageLength(int packageLength) {
		this.packageLength = packageLength;
	}
	public byte[] getOriginalWaveData() {
		return originalWaveData;
	}
	public void setOriginalWaveData(byte[] originalWaveData) {
		this.originalWaveData = originalWaveData;
	}
	public _0x042bCommand(byte[] cmdbyte) {
		GenerateCmdModel(cmdbyte);
	}
	@Override
	public _0x042bCommand GenerateCmdModel(byte[] cmdbyte) {
		
		return (_0x042bCommand) super.GenerateCmdModel(cmdbyte);
	}

	@Override
	public _0x042bCommand GenerateReturnCmd(boolean result) {
		
       return  (_0x042bCommand)super.GenerateReturnCmd(result);
	}

	@Override
	public byte[] GenerateReturnCmdByte(boolean result) {
		ArrayList<Byte> resultbyte = new ArrayList<>();
		switch (this.ProtocolVersion) {
		case 0:

			resultbyte.add((byte) CmdConstant.pcToMcuHeaderFirst);
			resultbyte.add((byte) CmdConstant.pcToMcuHeaderSecond);

			resultbyte.addAll(2, CmdUtils.ArrayToList(CmdUtils.IntegerToByteArray2(hospitalID)));
			resultbyte.addAll(4, CmdUtils.ArrayToList(CmdUtils.IntegerToByteArray2(deviceID)));
			resultbyte.add((byte) 0x04);
			resultbyte.addAll(7, CmdUtils.ArrayToList(CmdUtils.IntegerToByteArray2(cmd.getCmdId())));
			resultbyte.add((byte) 0x02);
			resultbyte.add((byte) 0x00);
			if (result) {
				resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.IntegerToByteArray2(packageNo)));
			} else {
				resultbyte.add((byte) 0xff);
				resultbyte.add((byte) 0xff);
			}
			int crcvalue = CRC16Util.GetCrcValue(CmdUtils.ListToArray(resultbyte), 2, resultbyte.size() - 2);

			byte[] crcbyte = CmdUtils.IntegerToByteArray2(crcvalue);
			resultbyte.addAll(CmdUtils.ArrayToList(crcbyte));
			resultbyte.add((byte) 0x00);
			resultbyte.add((byte) 0x00);
			resultbyte.add((byte) CmdConstant.pcToMcuTailFirst);
			resultbyte.add((byte) CmdConstant.pcToMcuTailSecond);
			return CmdUtils.ListToArray(resultbyte);
		case 1:
			resultbyte.add((byte) CmdConstant.pcToMcuHeaderFirst);
			resultbyte.add((byte) CmdConstant.pcToMcuHeaderSecond);
			resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.IntegerToByteArray2(hospitalID)));
			resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.IntegerToByteArray2(sectionID)));
			resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.IntegerToByteArray2(deviceID)));

			resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.HexStringToByteArray(deviceSN, " ")));
			resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.HexStringToByteArray(wifiMac, " ")));
			resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.HexStringToByteArray(Mac, " ")));
			resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.HexStringToByteArray(bluetoothMac, " ")));
			resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.HexStringToByteArray(rfidMac, " ")));

			byte[] temp = new byte[] { (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff,
					(byte) 0xff, (byte) 0xff };
			resultbyte.addAll(CmdUtils.ArrayToList(temp));

			resultbyte.add((byte) 0x04);
			resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.IntegerToByteArray2(cmd.getCmdId())));
			resultbyte.add((byte) 0x02);
			resultbyte.add((byte) 0x00);
			if (result) {
				resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.IntegerToByteArray2(packageNo)));
			} else {
				resultbyte.add((byte) 0xff);
				resultbyte.add((byte) 0xff);
			}
			int crcvalue1 = CRC16Util.GetCrcValue(CmdUtils.ListToArray(resultbyte), 2, resultbyte.size() - 2);

			byte[] crcbyte1 = CmdUtils.IntegerToByteArray2(crcvalue1);
			resultbyte.addAll(CmdUtils.ArrayToList(crcbyte1));
			resultbyte.add((byte) 0x00);
			resultbyte.add((byte) 0x01);
			resultbyte.add((byte) CmdConstant.pcToMcuTailFirst);
			resultbyte.add((byte) CmdConstant.pcToMcuTailSecond);
			return CmdUtils.ListToArray(resultbyte);
		default:
			resultbyte.add((byte) CmdConstant.pcToMcuHeaderFirst);
			resultbyte.add((byte) CmdConstant.pcToMcuHeaderSecond);
			resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.IntegerToByteArray2(hospitalID)));
			resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.IntegerToByteArray2(sectionID)));
			resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.IntegerToByteArray2(deviceID)));

			resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.HexStringToByteArray(deviceSN, " ")));
			resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.HexStringToByteArray(wifiMac, " ")));
			resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.HexStringToByteArray(Mac, " ")));
			resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.HexStringToByteArray(bluetoothMac, " ")));
			resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.HexStringToByteArray(rfidMac, " ")));

			byte[] temp1 = new byte[] { (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff,
					(byte) 0xff, (byte) 0xff };
			resultbyte.addAll(CmdUtils.ArrayToList(temp1));

			resultbyte.add((byte) 0x04);
			resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.IntegerToByteArray2(cmd.getCmdId())));
			resultbyte.add((byte) 0x02);
			resultbyte.add((byte) 0x00);
			if (result) {
				resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.IntegerToByteArray2(packageNo)));
			} else {
				resultbyte.add((byte) 0xff);
				resultbyte.add((byte) 0xff);
			}
			int crcvalue2 = CRC16Util.GetCrcValue(CmdUtils.ListToArray(resultbyte), 2, resultbyte.size() - 2);

			byte[] crcbyte2 = CmdUtils.IntegerToByteArray2(crcvalue2);
			resultbyte.addAll(CmdUtils.ArrayToList(crcbyte2));
			resultbyte.add((byte) 0x00);
			resultbyte.add((byte) 0x01);
			resultbyte.add((byte) CmdConstant.pcToMcuTailFirst);
			resultbyte.add((byte) CmdConstant.pcToMcuTailSecond);
			return CmdUtils.ListToArray(resultbyte);
		}
	}
    
     @Override
    public void AnalysisSpecialItem() {
    	 this.finalPackageFlag = CmdUtils.ByteToInt(dataByte[0]);
    	 this.packageNo = CmdUtils.ByteArray2ToInteger(dataByte, 1);
    	 this.version = CmdUtils.ByteToInt(dataByte[3]);
    	 this.packageLength =CmdUtils.ByteToInt(dataByte[4]);
    	 this.protocolString = CmdUtils.ByteArrayToNormalString(dataByte, 6, 4);
    	 originalByte = new byte[packageLength];
    	 originalWaveData = new byte[packageLength];
    	 System.arraycopy(dataByte, 6, originalWaveData, 0, packageLength);
    	 
    }
}
