package com.hzzxkj.cmdAnaliser;

import java.util.ArrayList;



public class BaseCommand extends CmdModel {

	
	@Override
	public CmdModel GenerateCmdModel(byte[] cmdbyte) {

		// 获取版本号 根据校验位的后两个字节 00 00 为旧协议 00 01 为新协议
		byte[] tempbyte = CmdUtils.GetLastByteArray(cmdbyte, 4);

		byte[] protocolByte = new byte[2];
		System.arraycopy(tempbyte, 0, protocolByte, 0, 2);

		this.ProtocolVersion = CmdUtils.ByteArray2ToInteger(protocolByte, 0);
		// 根据版本号对字节数组进行解析
		switch (ProtocolVersion) {
		case 0:
			// 获取原始字节
			this.originalByte = cmdbyte;
			// 获取医院ID
			this.hospitalID = CmdUtils.ByteArray2ToInteger(cmdbyte, 2);
			// 获取设备ID
			this.deviceID = CmdUtils.ByteArray2ToInteger(cmdbyte, 4);
			// 获取设备类型
			this.cmdType = cmdbyte[6] & 0xff;
			// 获取命令枚举类型
			this.cmd = CMDID.CmdIdToEnum(CmdUtils.ByteArray2ToInteger(cmdbyte, 7));
			// 获取数据长度
			this.dataByteLength = CmdUtils.ByteArray2ToInteger(cmdbyte, 9);
			// 获取自定义数据
			dataByte = new byte[dataByteLength];
			System.arraycopy(cmdbyte, 11, dataByte, 0, dataByteLength);
			// 获取crc校验值
			crcByte = new byte[2];
			System.arraycopy(cmdbyte, 11 + dataByteLength, crcByte, 0, 2);
			// 旧协议不存在这些字段,故都赋予默认值
			this.bluetoothMac = "";
			this.deviceSN = "";
			this.Mac = "";
			this.rfidMac = "";
			this.sectionID = -1;
			this.wifiMac = "";
			this.redundancyByte = null;
			break;
		case 1:
			// 获取原始字节
			this.originalByte = cmdbyte;
			// 获取医院ID
			this.hospitalID = CmdUtils.ByteArray2ToInteger(cmdbyte, 2);
			// 获取科室ID
			this.sectionID = CmdUtils.ByteArray2ToInteger(cmdbyte, 4);
			// 获取设备ID
			this.deviceID = CmdUtils.ByteArray2ToInteger(cmdbyte, 6);
			// 获取设备SN号
			this.deviceSN = CmdUtils.ByteArrayToHexString(cmdbyte, 8, 4);
			// 获取wifi地址
			this.wifiMac = CmdUtils.ByteArrayToHexString(cmdbyte, 12, 6);
			// 获取有线mac
			this.Mac = CmdUtils.ByteArrayToHexString(cmdbyte, 18, 6);
			// 获取蓝牙地址
			this.bluetoothMac = CmdUtils.ByteArrayToHexString(cmdbyte, 24, 6);
			// 获取rfid地址
			this.rfidMac = CmdUtils.ByteArrayToHexString(cmdbyte, 30, 6);
			// 获取冗余字节
			this.redundancyByte = new byte[8];
			System.arraycopy(cmdbyte, 36, redundancyByte, 0, 8);
			// 获取命令类型
			this.cmdType = cmdbyte[44] & 0xff;
			// 获取命令枚举类型 id
			this.cmd = CMDID.CmdIdToEnum(CmdUtils.ByteArray2ToInteger(cmdbyte, 45));
			// 获取数据长度
			this.dataByteLength = CmdUtils.ByteArray2ToInteger(cmdbyte, 47);
			// 获取自定义数据
			dataByte = new byte[dataByteLength];
			System.arraycopy(cmdbyte, 49, dataByte, 0, dataByteLength);
			// 获取crc校验值
			crcByte = new byte[2];
			System.arraycopy(cmdbyte, 49 + dataByteLength, crcByte, 0, 2);
			break;
		default: // 默认按新协议解析
			// 获取原始字节
			this.originalByte = cmdbyte;
			// 获取医院ID
			this.hospitalID = CmdUtils.ByteArray2ToInteger(cmdbyte, 2);
			// 获取科室ID
			this.sectionID = CmdUtils.ByteArray2ToInteger(cmdbyte, 4);
			// 获取设备ID
			this.deviceID = CmdUtils.ByteArray2ToInteger(cmdbyte, 6);
			// 获取设备SN号
			this.deviceSN = CmdUtils.ByteArrayToHexString(cmdbyte, 8, 4);
			// 获取wifi地址
			this.wifiMac = CmdUtils.ByteArrayToHexString(cmdbyte, 12, 6);
			// 获取有线mac
			this.Mac = CmdUtils.ByteArrayToHexString(cmdbyte, 18, 6);
			// 获取蓝牙地址
			this.bluetoothMac = CmdUtils.ByteArrayToHexString(cmdbyte, 24, 6);
			// 获取rfid地址
			this.rfidMac = CmdUtils.ByteArrayToHexString(cmdbyte, 30, 6);
			// 获取冗余字节
			this.redundancyByte = new byte[8];
			System.arraycopy(cmdbyte, 36, redundancyByte, 0, 8);
			// 获取命令类型
			this.cmdType = cmdbyte[44] & 0xff;
			// 获取命令枚举类型 id
			this.cmd = CMDID.CmdIdToEnum(CmdUtils.ByteArray2ToInteger(cmdbyte, 45));
			// 获取数据长度
			this.dataByteLength = CmdUtils.ByteArray2ToInteger(cmdbyte, 47);
			// 获取自定义数据
			dataByte = new byte[dataByteLength];
			System.arraycopy(cmdbyte, 49, dataByte, 0, dataByteLength);
			// 获取crc校验值
			crcByte = new byte[2];
			System.arraycopy(cmdbyte, 49 + dataByteLength, crcByte, 0, 2);
			break;
		}
		//公共字段解析完成后，调用不同子类的特殊分析方法获取不同指令的特殊信息
		AnalysisSpecialItem();
		return this;
	}

	@Override
	public CmdModel GenerateReturnCmd(boolean result) {
		byte[] cmdbyte = GenerateReturnCmdByte(result);

		BaseCommand model = new BaseCommand();

		// 获取版本号 根据校验位的后两个字节 00 00 为旧协议 00 01 为新协议
		byte[] tempbyte = CmdUtils.GetLastByteArray(cmdbyte, 4);

		byte[] protocolByte = new byte[2];
		System.arraycopy(tempbyte, 0, protocolByte, 0, 2);

		this.ProtocolVersion = CmdUtils.ByteArray2ToInteger(protocolByte, 0);
		// 根据版本号对字节数组进行解析
		switch (ProtocolVersion) {
		case 0:
			// 获取原始字节
			model.originalByte = cmdbyte;
			// 获取医院ID
			model.hospitalID = CmdUtils.ByteArray2ToInteger(cmdbyte, 2);
			// 获取设备ID
			model.deviceID = CmdUtils.ByteArray2ToInteger(cmdbyte, 4);
			// 获取设备类型
			model.cmdType = cmdbyte[6] & 0xff;
			// 获取命令枚举类型
			model.cmd = CMDID.CmdIdToEnum(CmdUtils.ByteArray2ToInteger(cmdbyte, 7));
			// 获取数据长度
			model.dataByteLength = CmdUtils.ByteArray2ToInteger(cmdbyte, 9);
			// 获取自定义数据
			dataByte = new byte[dataByteLength];
			System.arraycopy(cmdbyte, 11, dataByte, 0, dataByteLength);
			// 获取crc校验值
			crcByte = new byte[2];
			System.arraycopy(cmdbyte, 11 + dataByteLength, crcByte, 0, 2);
			// 旧协议不存在这些字段,故都赋予默认值
			model.bluetoothMac = "";
			model.deviceSN = "";
			model.Mac = "";
			model.rfidMac = "";
			model.sectionID = -1;
			model.wifiMac = "";
			model.redundancyByte = null;
			break;
		case 1:
			// 获取原始字节
			model.originalByte = cmdbyte;
			// 获取医院ID
			model.hospitalID = CmdUtils.ByteArray2ToInteger(cmdbyte, 2);
			// 获取科室ID
			model.sectionID = CmdUtils.ByteArray2ToInteger(cmdbyte, 4);
			// 获取设备ID
			model.deviceID = CmdUtils.ByteArray2ToInteger(cmdbyte, 6);
			// 获取设备SN号
			model.deviceSN = CmdUtils.ByteArrayToHexString(cmdbyte, 8, 4);
			// 获取wifi地址
			model.wifiMac = CmdUtils.ByteArrayToHexString(cmdbyte, 12, 6);
			// 获取有线mac
			model.Mac = CmdUtils.ByteArrayToHexString(cmdbyte, 18, 6);
			// 获取蓝牙地址
			model.bluetoothMac = CmdUtils.ByteArrayToHexString(cmdbyte, 24, 6);
			// 获取rfid地址
			model.rfidMac = CmdUtils.ByteArrayToHexString(cmdbyte, 30, 6);
			// 获取冗余字节
			model.redundancyByte = new byte[8];
			System.arraycopy(cmdbyte, 36, redundancyByte, 0, 8);
			// 获取命令类型
			model.cmdType = cmdbyte[44] & 0xff;
			// 获取命令枚举类型 id
			model.cmd = CMDID.CmdIdToEnum(CmdUtils.ByteArray2ToInteger(cmdbyte, 45));
			// 获取数据长度
			model.dataByteLength = CmdUtils.ByteArray2ToInteger(cmdbyte, 47);
			// 获取自定义数据
			dataByte = new byte[dataByteLength];
			System.arraycopy(cmdbyte, 49, dataByte, 0, dataByteLength);
			// 获取crc校验值
			crcByte = new byte[2];
			System.arraycopy(cmdbyte, 49 + dataByteLength, crcByte, 0, 2);
			break;
		default: // 默认按新协议解析
			// 获取原始字节
			model.originalByte = cmdbyte;
			// 获取医院ID
			model.hospitalID = CmdUtils.ByteArray2ToInteger(cmdbyte, 2);
			// 获取科室ID
			model.sectionID = CmdUtils.ByteArray2ToInteger(cmdbyte, 4);
			// 获取设备ID
			model.deviceID = CmdUtils.ByteArray2ToInteger(cmdbyte, 6);
			// 获取设备SN号
			model.deviceSN = CmdUtils.ByteArrayToHexString(cmdbyte, 8, 4);
			// 获取wifi地址
			model.wifiMac = CmdUtils.ByteArrayToHexString(cmdbyte, 12, 6);
			// 获取有线mac
			model.Mac = CmdUtils.ByteArrayToHexString(cmdbyte, 18, 6);
			// 获取蓝牙地址
			model.bluetoothMac = CmdUtils.ByteArrayToHexString(cmdbyte, 24, 6);
			// 获取rfid地址
			model.rfidMac = CmdUtils.ByteArrayToHexString(cmdbyte, 30, 6);
			// 获取冗余字节
			model.redundancyByte = new byte[8];
			System.arraycopy(cmdbyte, 36, redundancyByte, 0, 8);
			// 获取命令类型
			model.cmdType = cmdbyte[44] & 0xff;
			// 获取命令枚举类型 id
			model.cmd = CMDID.CmdIdToEnum(CmdUtils.ByteArray2ToInteger(cmdbyte, 45));
			// 获取数据长度
			model.dataByteLength = CmdUtils.ByteArray2ToInteger(cmdbyte, 47);
			// 获取自定义数据
			dataByte = new byte[dataByteLength];
			System.arraycopy(cmdbyte, 49, dataByte, 0, dataByteLength);
			// 获取crc校验值
			crcByte = new byte[2];
			System.arraycopy(cmdbyte, 49 + dataByteLength, crcByte, 0, 2);
			break;
		}
		return model;
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
			if (result) {
				resultbyte.add((byte) 0x01);
			} else {
				resultbyte.add((byte) 0x00);
			}
			int crcvalue = CRC16Util.GetCrcValue(CmdUtils.ListToArray(resultbyte), 2, resultbyte.size() - 2);

			byte[] crcbyte = CmdUtils.IntegerToByteArray2(crcvalue);
			resultbyte.addAll(12, CmdUtils.ArrayToList(crcbyte));
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
			if (result) {
				resultbyte.add((byte) 0x01);
			} else {
				resultbyte.add((byte) 0x00);
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
			resultbyte.add((byte) 0x01);
			resultbyte.add((byte) 0x00);
			if (result) {
				resultbyte.add((byte) 0x01);
			} else {
				resultbyte.add((byte) 0x00);
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
    
	/**
	 * 分析有效数据，并填充具体子类的特有字段值
	 */
	public  void  AnalysisSpecialItem() {
		
	}

}
