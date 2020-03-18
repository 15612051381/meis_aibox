package com.hzzxkj.cmdAnaliser.RespiratorModel;

import java.util.ArrayList;

import com.hzzxkj.cmdAnaliser.CmdUtils;

public class Minary_RespiratorModel extends BaseRespiratorModel {

   ArrayList<Minary_ChannelModel> ChannelModelList;
	
	
	public ArrayList<Minary_ChannelModel> getChannelModelList() {
		return ChannelModelList;
	}
	public void setChannelModelList(ArrayList<Minary_ChannelModel> channelModelList) {
		ChannelModelList = channelModelList;
	}
	/** 迈瑞波形数据采集器一次固定传送250字节，所以有可能最后一包的最后几个字节不是一个有效的通道数据，
	 * 需要过滤掉这些数据  以便得到完整的数据
	 * 完整的通道数据都是   通道1数字^通道1数字^通道1数字|通道2数字^通道2数字^通道2数字|的形式，
	 * 解析规则  |是通道的分隔符，通道数据之间使用^分割开，最后一个数据后面没有^
	 * 数据格式  注意，这里数据都是以字符形式表示的，和evita以数字表示不一样
	 * 找到最后一个|,此字符之前的都是有效数据，之后的都是无效数据
	 */
	@Override
	public byte[] GetLastPackageData(byte[] dataByte) {
         byte[] waveformData;
		
		int index = CmdUtils.GetLastIndex(dataByte, (byte)0x7c);
		if(index==-1) {
		    
			waveformData =null;
		}else {
			//查找到对应索引,则波形数据从databyte的第6个字节到 （index+1）字节
			Object[] temp =  CmdUtils.ArrayToList(dataByte).subList(6, index+2).toArray();
			
			waveformData = new byte[temp.length];
			for (int i = 0; i < temp.length; i++) {
				waveformData[i] = (byte)temp[i];
			}
		}
		
		return waveformData;
		
	}
	/**
	 * 该方法将完整的波形数据计算后拆分成通道数据存入一个二维集合中  这里是迈瑞监护仪系列的实现
	 * MeisCmdTreatHandler中获得最后一包数据时调用此方法
	 * @param datalist   完整的波形数据集合
	 * @param countNum   通道数
	 * @return
	 */
	@Override
	public ArrayList<ArrayList<String>> AnalyzeWaveData(ArrayList<Byte> datalist, int countNum) {
		
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < countNum; i++) {
			result.add(new ArrayList<String>());
		}
		
		//获取各通道数据集合  ru  1^2^3|4^5^6|
		String datastring = CmdUtils.ByteArrayToNormalString(datalist, 0, datalist.size());
		
		//转换成 各通道数组   1^2^3   和  4^5^6
		String[] channelDatas = datastring.split("\\|");
		
		for (int i = 0; i < countNum; i++) {
			//将通道1的数据拆成1,2,3的数组形式
			String[] channeldata = channelDatas[i].split("\\^");
			
			for (int j = 0; j < channeldata.length; j++) {
				result.get(i).add(String.valueOf(j)+'$'+channeldata[j]);
			}
		}
		return  result;
	}
	
	
}
