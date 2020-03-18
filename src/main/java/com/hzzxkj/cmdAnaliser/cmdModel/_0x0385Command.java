package com.hzzxkj.cmdAnaliser.cmdModel;

import java.util.ArrayList;
import java.util.Date;

import com.hzzxkj.Logger.HzzxLogger;
import com.hzzxkj.cmdAnaliser.BaseCommand;
import com.hzzxkj.cmdAnaliser.CRC16Util;
import com.hzzxkj.cmdAnaliser.CmdConstant;
import com.hzzxkj.cmdAnaliser.CmdUtils;
import com.hzzxkj.cmdAnaliser.RespiratorModel.Evita_ChannelModel;
import com.hzzxkj.cmdAnaliser.RespiratorModel.Evita_RespiratorModel;
import com.hzzxkj.cmdAnaliser.RespiratorModel.Minary_ChannelModel;
import com.hzzxkj.cmdAnaliser.RespiratorModel.Minary_RespiratorModel;
import com.hzzxkj.utils.DateUtils;

public class _0x0385Command extends BaseCommand {
	/**
	 * 数据包号
	 */
	public int PackageNo;
	/**
	 * 分包标志 1表示此数据是当前波形的最后一包，0表示不是最后一包
	 */
	public int FinalPackageFlag;
	/**
	 * 数据发生时的采集器时间
	 */
	public int collectorDateTime;
	/**
	 * 呼吸机型号，用于波形数据解析
	 */
	public String respiratorType;
	
	/**
	 * 该波形的采样点数
	 */
	public int acquisitionNumber;
	/**
	 * 该波形的采样通道数
	 */
	public int acquisitionChannelNum;
	/**
	 * 该波形的采样通道 通道号以10进制字符串表示 ，各通道以，分割开 如 100,101,102
	 */
	public String acquisitionChannel;
	
	/**
	 * 该波形的采样频率
	 */
	public int acquisitionFrequency;
	/**
	 * 该包内的波形数据
	 */
	public byte[] waveformData;
	/**
	 * 该包数据发生时的呼吸机时间
	 */
	public String RespiratorDateTime_start;
	
	/**
	 * 该包数据结束时的呼吸机时间
	 */
	public String RespiratorDateTime_end;
	/**
	 * 迈瑞波形的通道模型 包括通道的通道号，采样间隔，计算所需的3个值
	 *
	 */
	ArrayList<Minary_ChannelModel> ChannelModelList;

	public ArrayList<Minary_ChannelModel> getChannelModelList() {
		return ChannelModelList;
	}

	public void setChannelModelList(ArrayList<Minary_ChannelModel> channelModelList) {
		ChannelModelList = channelModelList;
	}

	public String getRespiratorType() {
		return respiratorType;
	}

	public void setRespiratorType(String respiratorType) {
		this.respiratorType = respiratorType;
	}

	public int getPackageNo() {
		return PackageNo;
	}

	public void setPackageNo(int packageNo) {
		PackageNo = packageNo;
	}

	public int getFinalPackageFlag() {
		return FinalPackageFlag;
	}

	public void setFinalPackageFlag(int finalPackageFlag) {
		FinalPackageFlag = finalPackageFlag;
	}

	public int getCollectorDateTime() {
		return collectorDateTime;
	}

	public void setCollectorDateTime(int collectorDateTime) {
		this.collectorDateTime = collectorDateTime;
	}

	public int getAcquisitionFrequency() {
		return acquisitionFrequency;
	}

	public void setAcquisitionFrequency(int acquisitionFrequency) {
		this.acquisitionFrequency = acquisitionFrequency;
	}

	public byte[] getWaveformData() {
		return waveformData;
	}

	public void setWaveformData(byte[] waveformData) {
		this.waveformData = waveformData;
	}

	public String getRespiratorDateTime_start() {
		return RespiratorDateTime_start;
	}

	public void setRespiratorDateTime_start(String respiratorDateTime) {
		RespiratorDateTime_start = respiratorDateTime;
	}
	public String getRespiratorDateTime_end() {
		return RespiratorDateTime_end;
	}

	public void setRespiratorDateTime_end(String respiratorDateTime) {
		RespiratorDateTime_end = respiratorDateTime;
	}
	public int getAcquisitionNumber() {
		return acquisitionNumber;
	}

	public void setAcquisitionNumber(int acquisitionNumber) {
		this.acquisitionNumber = acquisitionNumber;
	}

	public int getAcquisitionChannelNum() {
		return acquisitionChannelNum;
	}

	public void setAcquisitionChannelNum(int acquisitionChannelNum) {
		this.acquisitionChannelNum = acquisitionChannelNum;
	}

	public String getAcquisitionChannel() {
		return acquisitionChannel;
	}

	public void setAcquisitionChannel(String acquisitionChannel) {
		this.acquisitionChannel = acquisitionChannel;
	}



	public _0x0385Command(byte[] cmdbyte) {
		GenerateCmdModel(cmdbyte);
	}

	@Override
	public _0x0385Command GenerateCmdModel(byte[] cmdbyte) {

		return (_0x0385Command) super.GenerateCmdModel(cmdbyte);
	}

	@Override
	public _0x0385Command GenerateReturnCmd(boolean result) {

		return (_0x0385Command) super.GenerateReturnCmd(result);
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
				resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.IntegerToByteArray2(PackageNo)));
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
				resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.IntegerToByteArray2(PackageNo)));
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
				resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.IntegerToByteArray2(PackageNo)));
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
		if (originalByte[0] == (byte) CmdConstant.mcuToPcHeaderFirst) {
			this.FinalPackageFlag = CmdUtils.ByteToInt(dataByte[0]);
			this.PackageNo = CmdUtils.ByteArray2ToInteger(dataByte, 1);
			this.respiratorType = CmdUtils.ByteArrayToHexString(dataByte, 3, 2);
			if (PackageNo == 0) {
				// 如果是0包数据，则数据字段指明的是采集参数
				byte[] timebyte = new byte[12];
				
				System.arraycopy(dataByte, 6, timebyte, 0, 12);
				//获取开始时间
				
				String temptime = CmdUtils.ByteArrayToNormalString(timebyte, 0, 12);
				int year = Integer.parseInt(temptime.substring(0, 2).replaceAll(" ", "")) + 2000;
				int month = Integer.parseInt(temptime.substring(2, 4).replaceAll(" ", ""));
				int day = Integer.parseInt(temptime.substring(4, 6).replaceAll(" ", ""));
				int hour = Integer.parseInt(temptime.substring(6, 8).replaceAll(" ", ""));
				int minute = Integer.parseInt(temptime.substring(8, 10).replaceAll(" ", ""));
				int second = Integer.parseInt(temptime.substring(10, 12).replaceAll(" ", ""));
				RespiratorDateTime_start = DateUtils.formatDateTime(year, month, day, hour, minute, second);
				
				System.arraycopy(dataByte, 18, timebyte, 0, 12);
				//获取开始时间
				//获取结束时间
				 temptime = CmdUtils.ByteArrayToNormalString(timebyte, 0, 12);
				 year = Integer.parseInt(temptime.substring(0, 2).replaceAll(" ", "")) + 2000;
				 month = Integer.parseInt(temptime.substring(2, 4).replaceAll(" ", ""));
				 day = Integer.parseInt(temptime.substring(4, 6).replaceAll(" ", ""));
				 hour = Integer.parseInt(temptime.substring(6, 8).replaceAll(" ", ""));
				 minute = Integer.parseInt(temptime.substring(8, 10).replaceAll(" ", ""));
				 second = Integer.parseInt(temptime.substring(10, 12).replaceAll(" ", ""));
				RespiratorDateTime_end = DateUtils.formatDateTime(year, month, day, hour, minute, second);
				//获取结束时间
				this.acquisitionFrequency = CmdUtils.ByteToInt(dataByte[30]);

				this.acquisitionNumber = CmdUtils.ByteArray2ToInteger(dataByte, 31);

				this.acquisitionChannelNum = CmdUtils.ByteToInt(dataByte[33]);
				//获取最后一个|的索引位置
				int index = CmdUtils.GetLastIndex(dataByte, (byte)0x7c);
				//获取通道字符串 各通道以|分隔开  如13310|13312|
				String channelstring = CmdUtils.ByteArrayToNormalString(dataByte, 34, index-34+1);
				String[] channeles = channelstring.split("\\|");
				//重置通道个数，以通道号的个数为准
				this.acquisitionChannelNum = channeles.length;
				ChannelModelList = new ArrayList<Minary_ChannelModel>();
				
				for(int i = 0;i<channeles.length;i++) {
					Minary_ChannelModel model = new Minary_ChannelModel();
					//通道号
					model.ChannelNo =channeles[i] ;
					
					model.setStarttime(RespiratorDateTime_start);
					model.setEndtime(RespiratorDateTime_end);
					
					if (i == 0) {
						this.acquisitionChannel = String.valueOf(model.ChannelNo);
					} else {
						this.acquisitionChannel += ("," + model.ChannelNo);
					}
					
					ChannelModelList.add(model);
				}
			} else {

				// 如果包号>0则说明数据是波形数据   
				
				if (FinalPackageFlag == 1) {
					switch (respiratorType) {
					case "00 01": // evita系列
						Evita_RespiratorModel Evita_RespiratorModel = new Evita_RespiratorModel();
						waveformData = Evita_RespiratorModel.GetLastPackageData(dataByte);
						break;
					case "00 02": // 迈瑞监护仪系列
						Minary_RespiratorModel  Minary_RespiratorModel =new Minary_RespiratorModel();
						waveformData = Minary_RespiratorModel.GetLastPackageData(dataByte);
						break;
					default:
						break;
						}
				}
				else {
					// 不是最后一包，那波形数据就涵盖了250字节
					waveformData = CmdUtils.GetLastByteArray(dataByte, 250);
				}
				
			}
		}
	}
}
