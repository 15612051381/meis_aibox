package com.hzzxkj.cmdAnaliser.RespiratorModel;

import java.nio.ByteBuffer;
import java.util.ArrayList;

import com.hzzxkj.cmdAnaliser.CmdUtils;


public class Evita_RespiratorModel extends BaseRespiratorModel {

	
	ArrayList<Evita_ChannelModel> ChannelModelList;
	
	
	public ArrayList<Evita_ChannelModel> getChannelModelList() {
		return ChannelModelList;
	}
	public void setChannelModelList(ArrayList<Evita_ChannelModel> channelModelList) {
		ChannelModelList = channelModelList;
	}
	/**
	 * evita 波形数据采集器一次固定传送250字节，所以有可能最后几个字节不是一个完整的通道数据，也可能开始的几个字节不是完整的通道数据
	 * 需要过滤掉这些数据  以便得到完整的数据
	 * 完整的通道数据都是以0xD（X）【x为1-F】开始
	 * 解析规则
	 * 数据格式 
	 * 第一个字节是D1-DF 代表后面跟着几个通道的参数
	 * 位表示            1101 X X X X
	 * 如果是D1 则是 1101 0001  代表后面跟着一个通道的参数，该参数两个字节，通道号是0包参数给出的通道顺序第一个
	 * 如果是D2 则是 1101 0010  代表后面跟着一个通道的参数，该参数两个字节，通道号是0包参数给出的通道顺序第二个
	 * 如果是D3 则是 1101 0011  代表后面跟着二个通道的参数，该参数4个字节，前面两个字节是通道顺序第一个的参数，后两个是通道顺序第二个的参数
	 * 以此类推到DF
	 * 所以我们需要找到第一个0XDX，以及最后一个0xDX所需要的参数字节，其他字节都是无用的，需要过滤
	
	 */
	public byte[] GetLastPackageData(byte[] dataByte) {
		
		byte[] waveformData;
		ArrayList<Byte> temp = new ArrayList<Byte>();
		int paramIndex = 0;
		for(int i = 0;i<dataByte.length;i++) {
			
			switch (dataByte[i]) {
			  case (byte)0xD1:
				  for(paramIndex=0;paramIndex<=2;paramIndex++)
				  {  
					  if((i+2)<dataByte.length)
					  {
						  temp.add(dataByte[i+paramIndex]);
					  }
				  }
			      i=i+2;
				  break;
			  case (byte)0xD2:
				  for(paramIndex=0;paramIndex<=2;paramIndex++)
				  {
					  if((i+2)<dataByte.length)
					  {
						  temp.add(dataByte[i+paramIndex]);
					  }
				  }
			      i=i+2;
				  break;
			  case (byte)0xD3:
				  for(paramIndex=0;paramIndex<=4;paramIndex++)
				  {
					  if((i+4)<dataByte.length)
					  {
						  temp.add(dataByte[i+paramIndex]);
					  }
				  }
			      i=i+4;
				  break;
			  case (byte)0xD4:
				  for(paramIndex=0;paramIndex<=2;paramIndex++)
				  {
					  if((i+2)<dataByte.length)
					  {
						  temp.add(dataByte[i+paramIndex]);
					  }
				  }
			      i=i+2;
				  break;
			  case (byte)0xD5:
				  for(paramIndex=0;paramIndex<=4;paramIndex++)
				  {
					  if((i+4)<dataByte.length)
					  {
						  temp.add(dataByte[i+paramIndex]);
					  }
				  }
			      i=i+4;
				  break;
			  case (byte)0xD6:
				  for(paramIndex=0;paramIndex<=4;paramIndex++)
				  {
					  if((i+4)<dataByte.length)
					  {
						  temp.add(dataByte[i+paramIndex]);
					  }
				  }
			      i=i+4;
				  break;
			  case (byte)0xD7:
				  for(paramIndex=0;paramIndex<=6;paramIndex++)
				  {
					  if((i+6)<dataByte.length)
					  {
						  temp.add(dataByte[i+paramIndex]);
					  }
				  }
			      i=i+6;
				  break;
			  case (byte)0xD8:
				  for(paramIndex=0;paramIndex<=2;paramIndex++)
				  {
					  if((i+2)<dataByte.length)
					  {
						  temp.add(dataByte[i+paramIndex]);
					  }
				  }
			      i=i+2;
				  break;
			  case (byte)0xD9:
				  for(paramIndex=0;paramIndex<=4;paramIndex++)
				  {
					  if((i+4)<dataByte.length)
					  {
						  temp.add(dataByte[i+paramIndex]);
					  }
				  }
			      i=i+4;
				  break;
			  case (byte)0xDA:
				  for(paramIndex=0;paramIndex<=4;paramIndex++)
				  {
					  if((i+4)<dataByte.length)
					  {
						  temp.add(dataByte[i+paramIndex]);
					  }
				  }
			      i=i+4;
				  break;
			  case (byte)0xDB:
				  for(paramIndex=0;paramIndex<=6;paramIndex++)
				  {
					  if((i+6)<dataByte.length)
					  {
						  temp.add(dataByte[i+paramIndex]);
					  }
				  }
			      i=i+6;
				  break;
			  case (byte)0xDC:
				  for(paramIndex=0;paramIndex<=4;paramIndex++)
				  {
					  if((i+4)<dataByte.length)
					  {
						  temp.add(dataByte[i+paramIndex]);
					  }
				  }
			      i=i+4;
				  break;
			  case (byte)0xDD:
				  for(paramIndex=0;paramIndex<=6;paramIndex++)
				  {
					  if((i+6)<dataByte.length)
					  {
						  temp.add(dataByte[i+paramIndex]);
					  }
				  }
			      i=i+6;
				  break;
			  case (byte)0xDE:
				  for(paramIndex=0;paramIndex<=6;paramIndex++)
				  {
					  if((i+6)<dataByte.length)
					  {
						  temp.add(dataByte[i+paramIndex]);
					  }
				  }
			      i=i+6;
				  break;
			  case (byte)0xDF:
				  for(paramIndex=0;paramIndex<=8;paramIndex++)
				  {
					  if((i+8)<dataByte.length)
					  {
						  temp.add(dataByte[i+paramIndex]);
					  }
				  }
			      i=i+8;
				  break;
			  default:
				  break;
			}
		}
		waveformData = CmdUtils.ListToArray(temp);
		return waveformData;
		
	}
	/**
	 * 该方法将完整的波形数据计算后拆分成通道数据存入一个二维集合中  这里是evita系列的实现
	 * MeisCmdTreatHandler中获得最后一包数据时调用此方法
	 * @param datalist   完整的波形数据集合
	 * @param countNum   通道数
	 * @return
	 */
	@Override
	public ArrayList<ArrayList<String>> AnalyzeWaveData(ArrayList<Byte> datalist, int countNum) {
		// TODO Auto-generated method stub
		
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < countNum; i++) {
			result.add(new ArrayList<String>());
		}
		int transResult = 0;
		Evita_ChannelModel model;
		double calcResult = 0.00;
		
		for(int i = 0;i<datalist.size();i++) {
			
			switch (datalist.get(i)) {
			  case (byte)0xD1:
				  transResult =TranslateData(datalist.get(i+1),datalist.get(i+2));     
			      AddToResult(transResult,0,result);
			  
				  break;
			  case (byte)0xD2:
				  transResult =TranslateData(datalist.get(i+1),datalist.get(i+2));
			      AddToResult(transResult,1,result);
				  break;
			  case (byte)0xD3:
				  transResult =TranslateData(datalist.get(i+1),datalist.get(i+2));
		           AddToResult(transResult,0,result);
		           transResult =TranslateData(datalist.get(i+3),datalist.get(i+4));
		           AddToResult(transResult,1,result);
				  break;
			  case (byte)0xD4:
				  transResult =TranslateData(datalist.get(i+1),datalist.get(i+2));
			      AddToResult(transResult,2,result);
				  break;
			  case (byte)0xD5:
				  transResult =TranslateData(datalist.get(i+1),datalist.get(i+2));
	           AddToResult(transResult,0,result);
	           transResult =TranslateData(datalist.get(i+3),datalist.get(i+4));
	           AddToResult(transResult,2,result);
				  break;
			  case (byte)0xD6:
				  transResult =TranslateData(datalist.get(i+1),datalist.get(i+2));
	           AddToResult(transResult,1,result);
	           transResult =TranslateData(datalist.get(i+3),datalist.get(i+4));
	           AddToResult(transResult,2,result);
				  break;
			  case (byte)0xD7:
				  transResult =TranslateData(datalist.get(i+1),datalist.get(i+2));
	           AddToResult(transResult,0,result);
	           transResult =TranslateData(datalist.get(i+3),datalist.get(i+4));
	           AddToResult(transResult,1,result);
	           transResult =TranslateData(datalist.get(i+5),datalist.get(i+6));
	           AddToResult(transResult,2,result);
				  break;
			  case (byte)0xD8:
				  transResult =TranslateData(datalist.get(i+1),datalist.get(i+2)) ;
			      AddToResult(transResult,3,result);
				  break;
			  case (byte)0xD9:
				  transResult =TranslateData(datalist.get(i+1),datalist.get(i+2));
	           AddToResult(transResult,0,result);
	           transResult =TranslateData(datalist.get(i+3),datalist.get(i+4));
	           AddToResult(transResult,3,result);
				  break;
			  case (byte)0xDA:
				  transResult =TranslateData(datalist.get(i+1),datalist.get(i+2));
	           AddToResult(transResult,1,result);
	           transResult =TranslateData(datalist.get(i+3),datalist.get(i+4));
	           AddToResult(transResult,3,result);
				  break;
			  case (byte)0xDB:
				  transResult =TranslateData(datalist.get(i+1),datalist.get(i+2));
	           AddToResult(transResult,0,result);
	           transResult =TranslateData(datalist.get(i+3),datalist.get(i+4));
	           AddToResult(transResult,1,result);
	           transResult =TranslateData(datalist.get(i+5),datalist.get(i+6));
	           AddToResult(transResult,3,result);
				  break;
			  case (byte)0xDC:
				  transResult =TranslateData(datalist.get(i+1),datalist.get(i+2));
	           AddToResult(transResult,2,result);
	           transResult =TranslateData(datalist.get(i+3),datalist.get(i+4));
	           AddToResult(transResult,3,result);
				  break;
			  case (byte)0xDD:
				  transResult =TranslateData(datalist.get(i+1),datalist.get(i+2));
	           AddToResult(transResult,0,result);
	           transResult =TranslateData(datalist.get(i+3),datalist.get(i+4));
	           AddToResult(transResult,2,result);
	           transResult =TranslateData(datalist.get(i+5),datalist.get(i+6));
	           AddToResult(transResult,3,result);
				  break;
			  case (byte)0xDE:
				  transResult =TranslateData(datalist.get(i+1),datalist.get(i+2));
	           AddToResult(transResult,1,result);
	           transResult =TranslateData(datalist.get(i+3),datalist.get(i+4));
	           AddToResult(transResult,2,result);
	           transResult =TranslateData(datalist.get(i+5),datalist.get(i+6));
	           AddToResult(transResult,3,result);
				  break;
			  case (byte)0xDF:
				  transResult =TranslateData(datalist.get(i+1),datalist.get(i+2));
	           AddToResult(transResult,0,result);
	           transResult =TranslateData(datalist.get(i+3),datalist.get(i+4));
	           AddToResult(transResult,1,result);
	           transResult =TranslateData(datalist.get(i+5),datalist.get(i+6));
	           AddToResult(transResult,2,result);
	           transResult =TranslateData(datalist.get(i+7),datalist.get(i+8));
	           AddToResult(transResult,3,result);
				  break;
			  default:
				  break;
			}
		}
		
		return result;
		
	}
	
	/**
	 * 解析evita数据，D1 0X91   0X81   转换 0x91 0x81 为dec 81
	 * 0x91  1001 0001
	 * 0x81  1000 0001
	 * 转换规则，去除两个字节的高两位 
	 * 得到01 0001 和  00  0001 
	 * 组合  00  0001 和  01 0001 得到一个12bit的数   0000 0101  0001 
	 * 补全后是 0000 0000 0101 0001 即两个字节 0x00 0x51 转换成10进制为81
	 * @return
	 */
	public int TranslateData(byte a  ,byte  b) {
		//创建一个字符串数组，前4为为0
		 StringBuffer buffer = new StringBuffer(); 
		 buffer.append("0000");
		 //去除字节b的高两位
		 for(int i=2;i<=7;i++) {
			 buffer.append(byteToBit(b).charAt(i));
		 }
		 //去除字节a的高两位
		 for(int i=2;i<=7;i++) {
			 buffer.append(byteToBit(a).charAt(i));
		 }
		 //得到一个长度16的字符串
		 String temp = buffer.toString();
		 //将该长度为16的字符串转换为2个字节
		 byte[] result = new byte[2];
		 byte aa = decodeBinaryString(temp.substring(0, 8));
		 byte bb = decodeBinaryString(temp.substring(8, 16));	
		 result[0]=aa;
		 result[1] =bb;
		int x= ByteBuffer.wrap(result).getShort();
		return  x;
	}
	/**
	  * 把byte转为字符串的bit
	  */
	 public  String byteToBit(byte b) {
	  return ""
	    + (byte) ((b >> 7) & 0x1) + (byte) ((b >> 6) & 0x1)
	    + (byte) ((b >> 5) & 0x1) + (byte) ((b >> 4) & 0x1)
	    + (byte) ((b >> 3) & 0x1) + (byte) ((b >> 2) & 0x1)
	    + (byte) ((b >> 1) & 0x1) + (byte) ((b >> 0) & 0x1);
	 }
	
	 /**
	  * 二进制字符串转byte
	 */
	public  byte decodeBinaryString(String byteStr) {
		 int re, len;
		 if (null == byteStr) {
		  return 0;
		 }
		 len = byteStr.length();
		 if (len != 4 && len != 8) {
		  return 0;
		 }
		 if (len == 8) {// 8 bit处理
		  if (byteStr.charAt(0) == '0') {// 正数
		   re = Integer.parseInt(byteStr, 2);
		  } else {// 负数
		   re = Integer.parseInt(byteStr, 2) - 256;
		  }
		 } else {// 4 bit处理
		  re = Integer.parseInt(byteStr, 2);
		 }
		 return (byte) re;
		}

	/**
	 * 将字节结果通过计算存入到最终的结果结合中
	 * @param transResult  字节结果
	 * @param index   通道索引
	 * @param result  需要结果存入的集合
	 */
	public void AddToResult(int transResult,int index,ArrayList<ArrayList<String>> result) {
		 
		 Evita_ChannelModel model = ChannelModelList.get(index)  ;
	      double calcResult = model.minvalue + transResult*(model.maxvalue-model.minvalue)/model.maxbin;
		 //double calcResult = transResult;
	     result.get(index).add(String.valueOf(transResult)+'$'+String.valueOf(calcResult));
	}
}
