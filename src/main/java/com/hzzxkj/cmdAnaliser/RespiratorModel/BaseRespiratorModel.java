package com.hzzxkj.cmdAnaliser.RespiratorModel;

import java.util.ArrayList;

import com.hzzxkj.cmdAnaliser.CmdUtils;
import com.hzzxkj.utils.HzzxMathUtils;

/**
 * 基础呼吸机模型，该类型主要用于波形数据帧协议解析和  以及波形数据业务处理以及  全参数解析
 * @author Administrator
 *
 */
public class BaseRespiratorModel {
    
	/**
	 * 该方法用于0383指令解析到最后一包数据时，如何将最后一包数据终端额波形数据取出来，这里默认是serv-s系列的实现
	 * _0x0383Command中调用此方法
	 * @param dataByte
	 * @return
	 */
	public  byte[] GetLastPackageData(byte[] dataByte) {
		
		byte[] waveformData;
		
		int index = CmdUtils.GetLastIndex(dataByte, (byte)0x7f);
		if(index==-1) {
		    //-1表示未查找到字节，只有一种情况会出现这种情况，即上一包数据的最后一个字节是7F，本报数据实际上只有一个校验位是有效的
			//其他都是填充的FF字节
			waveformData =new byte[] { dataByte[6]};
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
	 * 该方法将完整的波形数据计算后拆分成通道数据存入一个二维集合中  这里默认是serv-s系列的实现
	 * MeisCmdTreatHandler中获得最后一包数据时调用此方法
	 * @param datalist   完整的波形数据集合
	 * @param countNum   通道数
	 * @return
	 */
	public  ArrayList<ArrayList<String>> AnalyzeWaveData(ArrayList<Byte> datalist,int countNum){
		//移除最后一位的校验位
		datalist.remove(datalist.size()-1);
		
		boolean isAddChannle =false;
		//记录当前获取的第几通道的数据
		int channelNo=0; 
		//最终结果的前缀至，100000代表吸气相的值，200000代表暂停相 300000代表呼吸相
		double flag = 0;
		//存储各通道当前的基准值，初始未0
		int[] channelBaseValue = new int[countNum]; 
		for (int i = 0; i < channelBaseValue.length; i++) {
			channelBaseValue[i]=0;
		}
		
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < countNum; i++) {
			result.add(new ArrayList<String>());
		}
		
		int x = 0;
		
		//遍历通道数据
		for (int i = 0; i < datalist.size(); i++) {
			switch(datalist.get(i)){
			case (byte)0x80:
				//将0x80后的两个字节取出，转换成10进制，作为通道的基准值 注意，这两个字节在波形里面是大端，而我们默认的转换是小端的。
				byte[] temp = new byte[2];
			    temp[0] = datalist.get(i+2);
				temp[1] = datalist.get(i+1);
			    x= CmdUtils.ByteArray2ToInteger(temp, 0);
			    //更新当前通道的基准值
			    channelBaseValue[channelNo] = x;
			    i=i+2;
			    isAddChannle=true;
			  break;
			case (byte)0x7f:
				isAddChannle = false;
			     break;
			case (byte)0x81:
				if (datalist.get(i+1)==(byte)0x10) {
					flag = 100000;
				}
				if (datalist.get(i+1)==(byte)0x20) {
					flag = 200000;
				}
				if (datalist.get(i+1)==(byte)0x30) {
					flag = 300000;
				}
				i=i+1;
				isAddChannle=false;
				break;
			default:
				//x=CmdUtils.ByteToInt(datalist.get(i));//得到偏移量
				x= datalist.get(i);//得到偏移量,偏移量是有符号数，所以不需要转换
				isAddChannle=true;
				x=channelBaseValue[channelNo]+x; //使用基准值和偏移量得到最终的值
				channelBaseValue[channelNo] = x; //将此值作为该通道的基准值
				break;
			}
			
			double finalValue = 0.00;
			//将得到的值经过转换后的数据加入到对应的通道数据列表中
			switch (channelNo) {
			case 0:
				finalValue =HzzxMathUtils.round((x*0.2713-3333)*60/1000, 4, true) ;
				break;
			case 1:
				finalValue = (x*0.0651-133.3);
				break;
			case 2:
				finalValue = x*0.4;
				break;
			case 3:
				finalValue =x*0.4;
			default:
				break;
			}
			//避免原道81  10 或者81  20 这种不需要数据将通道号和数据弄混
			if (isAddChannle) {
				result.get(channelNo).add(String.valueOf(flag)+"$"+String.valueOf(finalValue));
				channelNo++;
			}
			//档通道数据完成一轮后，需要将通道号回复0重新开始
			if (channelNo>=countNum) {
				channelNo=0;
			}
		}
		return result;
	}

	/**
	 * 波形数据自带的校验方法  这里默认是serv-s系列的实现
	 * MeisCmdTreatHandler中获得最后一包数据时调用此方法
	 * @param data
	 * @param originalcrcvalue
	 * @return
	 */
    public  boolean CheckCRC(byte[] data,byte originalcrcvalue) {
    	byte chk =(byte) 0x00;
		 
		 for (int j = 0; j < data.length-1; j++) {
			chk= (byte) (chk^data[j]);
		}
		 if (chk==originalcrcvalue) {
			return true;
		}else {
			return false;
		}
		 
    }
    
}
