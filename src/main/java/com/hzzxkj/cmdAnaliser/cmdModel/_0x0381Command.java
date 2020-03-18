package com.hzzxkj.cmdAnaliser.cmdModel;

import java.util.ArrayList;

import com.hzzxkj.cmdAnaliser.BaseCommand;
import com.hzzxkj.cmdAnaliser.CRC16Util;
import com.hzzxkj.cmdAnaliser.CmdConstant;
import com.hzzxkj.cmdAnaliser.CmdUtils;

/**
 * 特殊指令，上位机收到后必须回复，且数据部分必须原样,否则采集器将重新连接
 * @author liujun
 *
 */
public class _0x0381Command extends BaseCommand {

	
	/**
	 * 模拟数据
	 */
	public int simulationData;
    
	public _0x0381Command(byte[] cmdbyte) {
		GenerateCmdModel(cmdbyte);
	}

	public int getSimulationData() {
		return simulationData;
	}

	public void setSimulationData(int simulationData) {
		this.simulationData = simulationData;
	}

	@Override
	public _0x0381Command GenerateCmdModel(byte[] cmdbyte) {

		return (_0x0381Command) super.GenerateCmdModel(cmdbyte);
	}

	@Override
	public _0x0381Command GenerateReturnCmd(boolean result) {

		return (_0x0381Command) super.GenerateReturnCmd(result);
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
			resultbyte.add((byte) 0x01);
			resultbyte.add((byte) 0x00);
			
			resultbyte.addAll(CmdUtils.ArrayToList(getDataByte()));
			
			int crcvalue = CRC16Util.GetCrcValue(CmdUtils.ListToArray(resultbyte), 2, resultbyte.size() - 2);

			byte[] crcbyte = CmdUtils.IntegerToByteArray2(crcvalue);
			resultbyte.addAll( CmdUtils.ArrayToList(crcbyte));
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
			resultbyte.add((byte) 0x01);
			resultbyte.add((byte) 0x00);
			resultbyte.addAll(CmdUtils.ArrayToList(getDataByte()));
			

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
			resultbyte.add((byte) 0x01);
			resultbyte.add((byte) 0x00);
			resultbyte.addAll(CmdUtils.ArrayToList(getDataByte()));
			

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
		if (originalByte[0] == (byte) CmdConstant.mcuToPcHeaderFirst) {
		this.simulationData = CmdUtils.ByteToInt(dataByte[0]);

		}
	}
}
