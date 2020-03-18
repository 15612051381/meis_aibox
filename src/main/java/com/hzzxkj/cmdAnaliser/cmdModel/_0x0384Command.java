package com.hzzxkj.cmdAnaliser.cmdModel;

import java.util.ArrayList;

import com.hzzxkj.cmdAnaliser.BaseCommand;
import com.hzzxkj.cmdAnaliser.CRC16Util;
import com.hzzxkj.cmdAnaliser.CmdConstant;
import com.hzzxkj.cmdAnaliser.CmdUtils;
import com.hzzxkj.cmdAnaliser.RespiratorModel.Evita_ChannelModel;
import com.hzzxkj.cmdAnaliser.RespiratorModel.Evita_RespiratorModel;
import com.hzzxkj.utils.DateUtils;

public class _0x0384Command extends BaseCommand {
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
	public String RespiratorDateTime;
	/**
	 * evita波形的通道模型 包括通道的通道号，采样间隔，计算所需的3个值
	 *
	 */
	ArrayList<Evita_ChannelModel> ChannelModelList;

	public ArrayList<Evita_ChannelModel> getChannelModelList() {
		return ChannelModelList;
	}

	public void setChannelModelList(ArrayList<Evita_ChannelModel> channelModelList) {
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

	public String getRespiratorDateTime() {
		return RespiratorDateTime;
	}

	public void setRespiratorDateTime(String respiratorDateTime) {
		RespiratorDateTime = respiratorDateTime;
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



	public _0x0384Command(byte[] cmdbyte) {
		GenerateCmdModel(cmdbyte);
	}

	@Override
	public _0x0384Command GenerateCmdModel(byte[] cmdbyte) {

		return (_0x0384Command) super.GenerateCmdModel(cmdbyte);
	}

	@Override
	public _0x0384Command GenerateReturnCmd(boolean result) {

		return (_0x0384Command) super.GenerateReturnCmd(result);
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
				//获取呼吸机时间
				
				String temptime = CmdUtils.ByteArrayToNormalString(timebyte, 0, 12);
				int year = Integer.parseInt(temptime.substring(0, 2).replaceAll(" ", "")) + 2000;
				int month = Integer.parseInt(temptime.substring(2, 4).replaceAll(" ", ""));
				int day = Integer.parseInt(temptime.substring(4, 6).replaceAll(" ", ""));
				int hour = Integer.parseInt(temptime.substring(6, 8).replaceAll(" ", ""));
				int minute = Integer.parseInt(temptime.substring(8, 10).replaceAll(" ", ""));
				int second = Integer.parseInt(temptime.substring(10, 12).replaceAll(" ", ""));
				RespiratorDateTime = DateUtils.formatDateTime(year, month, day, hour, minute, second);
				//采样通道数默认0
				this.acquisitionChannelNum=0;
				this.acquisitionNumber= 100;
				//获取evita的通道号和各通道的参数
				ChannelModelList = new ArrayList<Evita_ChannelModel>();
				//EVITA z最大支持10个通道
				for(int i = 0;i<10;i++) {
					Evita_ChannelModel model = new Evita_ChannelModel();
					//通道号
					model.ChannelNo =CmdUtils.ByteArrayToNormalString(dataByte, 18+i*23, 2) ;
					//通道号首字节，如果首字节是0x00 代表着不是通道号，是填充字节,代表所有通道号已经取完了，后续的都是填充
					byte channelBYte = CmdUtils.ArrayToList(dataByte).get(18+i*23);
					if(channelBYte==0x00) {
						break;
					}
					
					if (i == 0) {
						this.acquisitionChannel = String.valueOf(model.ChannelNo);
					} else {
						this.acquisitionChannel += ("," + model.ChannelNo);
					}
					this.acquisitionChannelNum++;
					//采样间隔  8字节字符形式，微秒单位，/1000 得到毫秒
					model.acquisitionFrequency =Integer.parseInt( CmdUtils.ByteArrayToNormalString(dataByte, 20+i*23, 8).trim())/1000 ;
					this.acquisitionFrequency = model.acquisitionFrequency;
					//通道最小值
					model.minvalue =Integer.parseInt( CmdUtils.ByteArrayToNormalString(dataByte, 28+i*23, 5).trim().replaceAll(" ", "") );
					//通道最大值
					model.maxvalue =Integer.parseInt( CmdUtils.ByteArrayToNormalString(dataByte, 33+i*23, 5).trim().replaceAll(" ", "") );
					//通道分辨率
					// 
					String maxbinTemp = CmdUtils.ByteArrayToNormalString(dataByte, 38+i*23, 3).trim().replaceAll(" ", "");
					maxbinTemp =maxbinTemp.substring(1,3)+' '+'0'+maxbinTemp.substring(0,1);
					model.maxbin =CmdUtils.ByteArray2ToInteger(CmdUtils.HexStringToByteArray(maxbinTemp, " "), 0)	;
//			     	 Integer.parseInt( CmdUtils.ByteArrayToNormalString(dataByte, 38+i*23, 3).trim().replaceAll(" ", "") );
					
					ChannelModelList.add(model);
				}
			} else {

				// 如果包号>0则说明数据是波形数据   
				Evita_RespiratorModel Evita_RespiratorModel = new Evita_RespiratorModel();
				
				switch (respiratorType) {
				case "00 01": // evita系列
					waveformData = Evita_RespiratorModel.GetLastPackageData(dataByte);
					break;
				default:
					break;
					}
			}
		}
	}
}
