package com.hzzxkj.cmdAnaliser;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * 帧协议用到的工具类、用于数据类型的转换
 * 
 * @author asus
 *
 */
public class CmdUtils {
	/**
	 * 将int类型数据转换成2个长度的字节数组
	 * 
	 * @param i 待转换的int数据
	 * @return byte[2] 数组
	 */
	public static byte[] IntegerToByteArray2(int i) {

		byte[] result = new byte[2];
		byte[] temp = new byte[4];

		temp = ByteBuffer.allocate(4).putInt(i).array();

		result[0] = temp[3];
		result[1] = temp[2];
		return result;
	}

	/**
	 * 将int数据转换成4个长度的字节数组
	 * 
	 * @param i 带转换的int数据
	 * @return byte[4]数组
	 */
	public static byte[] IntegerToByteArray4(int i) {

		byte[] temp = new byte[4];

		temp = ByteBuffer.allocate(4).putInt(i).array();

		byte[] result = new byte[4];

		result[0] = temp[3];
		result[1] = temp[2];

		result[2] = temp[1];
		result[3] = temp[0];

		return result;
	}

	/**
	 * 从字节集合中的指定位置取2个字节 转换为int数字
	 * 
	 * @param byteList   待转换的字节集合
	 * @param startindex 从哪个字节开始转换
	 * @return int数字
	 */
	public static int ByteArray2ToInteger(ArrayList<Byte> byteList, int startindex) {
		int result = 0;
		byte[] temp = new byte[4];
		temp[0] = 0;
		temp[1] = 0;
		temp[2] = byteList.get(startindex + 1);
		temp[3] = byteList.get(startindex);

		result = ByteBuffer.wrap(temp).getInt();

		return result;
	}

	/**
	 * 从字节集合中的指定位置取4个字节 转换为int数字
	 * 
	 * @param byteList   待转换的字节集合
	 * @param startindex 从哪个字节开始转换
	 * @return int数字
	 */
	public static int ByteArray4ToInteger(ArrayList<Byte> byteList, int startindex) {
		int result = 0;
		byte[] resulttemp = new byte[4];

//		for (int i = 0; i < temp.length; i++) {
//			temp[i] = byteList.get(startindex + i);
//		}
//		resulttemp[0] = byteList.get(startindex + 1);
//		resulttemp[1] = byteList.get(startindex);
//		resulttemp[2] = byteList.get(startindex + 3);
//		resulttemp[3] = byteList.get(startindex + 2);

		resulttemp[0] = byteList.get(startindex + 3);
		resulttemp[1] = byteList.get(startindex+2);
		resulttemp[2] = byteList.get(startindex + 1);
		resulttemp[3] = byteList.get(startindex + 0);

		
		
		result = ByteBuffer.wrap(resulttemp).getInt();

		return result;
	}

	/**
	 * 从字节数组的指定位置取两个字节转换成int数字
	 * 
	 * @param bytearray
	 * @param startindex
	 * @return int数字
	 */
	public static int ByteArray2ToInteger(byte[] bytearray, int startindex) {
		int result = 0;
		byte[] resulttemp = new byte[4];
		resulttemp[0] = 0;
		resulttemp[1] = 0;
		resulttemp[2] = bytearray[startindex + 1];
		resulttemp[3] = bytearray[startindex];
		result = ByteBuffer.wrap(resulttemp).getInt();

		return result;
	}

	/**
	 * 从字节数组的指定位置取4个字节转换成int数字
	 * 
	 * @param bytearray
	 * @param startindex
	 * @return int数字
	 */
	public static int ByteArray4ToInteger(byte[] bytearray, int startindex) {
		int result = 0;
		byte[] resulttemp = new byte[4];

//		for (int i = 0; i < 4; i++) {
//			resulttemp[i] = bytearray[startindex + i];
//		}

		resulttemp[0] = bytearray[startindex + 3];
		resulttemp[1] = bytearray[startindex+2];
		resulttemp[2] = bytearray[startindex + 1];
		resulttemp[3] = bytearray[startindex + 0];

		result = ByteBuffer.wrap(resulttemp).getInt();

		return result;
	}

	/**
	 * 字节数组转换成16进制字符串
	 * 
	 * @param bytearray  待转换的字节数组
	 * @param startindex 带转换的开始索引
	 * @param length     待转换的长度
	 * @return 以,分割的16进制字符串
	 */
	public static String ByteArrayToHexString(byte[] bytearray, int startindex, int length) {

		String[] hexstring = new String[length];

		for (int i = 0; i < length; i++) {
			// hexstring[i] = Integer.toHexString(bytearray[startindex+i]&0xff);
			hexstring[i] = String.format("%02x", bytearray[startindex + i] & 0xff);
		}
		return String.join(" ", hexstring);
	}

	/**
	 * 字节数组转换成16进制字符串
	 * 
	 * @param bytearray 待转换的字节数组
	 * @return 16进制字符串 不带0x
	 */
	public static String ByteArrayToHexString(byte[] bytearray) {
		StringBuilder buf = new StringBuilder(bytearray.length * 2);
		for (byte b : bytearray) { // 使用String的format方法进行转换
			buf.append(String.format("%02x", new Integer(b & 0xff)) + " ");
		}

		return buf.toString();

	}

	/**
	 * 字节数组转换成16进制字符串
	 * 
	 * @param bytearray 待转换的字节数组
	 * @return 16进制字符串  以0x开头
	 */
	public static String ByteArrayToHexStringWithX(byte[] bytearray) {
		StringBuilder buf = new StringBuilder(bytearray.length * 2);
		for (byte b : bytearray) { // 使用String的format方法进行转换
			buf.append("0x" +String.format("%02x", new Integer(b & 0xff)) + " ");
		}

		return buf.toString();

	}
	/**
	 * 将16进制字符串转换为字节数组 必须要有分割符号 如 55 aa bb 对于55aabb不能使用此方法
	 * 
	 * @param hexstring 16进制字符串
	 * @param seperate  分隔符
	 * @return 字节数组
	 */

	public static byte[] HexStringToByteArray(String hexstring, String seperate) {
		String[] temp = hexstring.split(seperate);
		byte[] result = new byte[temp.length];
		for (int i = 0; i < temp.length; i++) {
			int tempvalue = Integer.parseInt(temp[i].replace("0x", ""), 16);
			result[i] = (byte) tempvalue;
		}

		return result;
	}

	/**
	 * byte集合转byte数组
	 * 
	 * @param bytelist
	 * @return
	 */
	public static byte[] ListToArray(ArrayList<Byte> bytelist) {
		byte[] result = new byte[bytelist.size()];

		Byte[] temp = bytelist.toArray(new Byte[bytelist.size()]);

		for (int i = 0; i < temp.length; i++) {
			result[i] = (byte) temp[i];
		}
		return result;
	}

	/**
	 * byte数组转byte集合
	 * 
	 * @param bytearray
	 * @return
	 */
	public static ArrayList<Byte> ArrayToList(byte[] bytearray) {
		ArrayList<Byte> result = new ArrayList<Byte>(bytearray.length);

		for (int i = 0; i < bytearray.length; i++) {
			result.add(bytearray[i]);
		}
		return result;
	}

	/**
	 * 获取指定字节数组的最后几个字节
	 * 
	 * @param originalarray 原始字节数组
	 * @param length        要获取的字节长度
	 * @return 字节数组
	 */

	public static byte[] GetLastByteArray(byte[] originalarray, int length) {

		byte[] result = new byte[length];

		for (int i = 0; i < length; i++) {
			result[i] = originalarray[originalarray.length - length + i];
		}

		return result;
	}

	/**
	 * 从字节数组的指定索引开始的指定长度的数组转换成普通字符串
	 * 
	 * @param bytearray  待转换的字节数组
	 * @param startindex 带转换的开始索引
	 * @param length     待转换的字节长度
	 * @return 字符串
	 */

	public static String ByteArrayToNormalString(byte[] bytearray, int startindex, int length) {

		byte[] temp = new byte[length];
		System.arraycopy(bytearray, startindex, temp, 0, length);

		return new String(temp, StandardCharsets.UTF_8);

	}
	/**
	 * 从字节数组的指定索引开始的指定长度的数组转换成普通字符串
	 * 
	 * @param bytearray  待转换的字节数组
	 * @param startindex 带转换的开始索引
	 * @param length     待转换的字节长度
	 * @return 字符串
	 */

	public static String ByteArrayToNormalString(ArrayList<Byte> bytearray, int startindex, int length) {

		byte[] origi = new byte[bytearray.size()];
		byte[] temp = new byte[length];
		origi = CmdUtils.ListToArray(bytearray);
		
		System.arraycopy(origi, startindex, temp, 0, length);

		return new String(temp, StandardCharsets.UTF_8);
  
	}
	/**
	 * byte数值转int
	 * 
	 * @param byte
	 * @return
	 */
	public static int ByteToInt(byte byteValue) {
		return byteValue & 0xff;
		
	}

	/**
	 * 从数组中的指定位置开始查找第一个目标字节的索引位置
	 * 
	 * @param sourcebyte 源数组
	 * @param destbyte   目标字节值
	 * @param startindex 查找的开始索引
	 * @return 索引位置 -1表示未查找到
	 */
	public static int GetFirstIndex(byte[] sourcebyte, byte destbyte, int startindex) {

		for (int i = startindex; i < sourcebyte.length; i++) {
			if (sourcebyte[i] == destbyte) {
				return i;
			}
		}
		return -1;// 如果未找到返回-1

	}

	/**
	 * 查找目标字节在字节数组中的最后一个的索引位置
	 * 
	 * @param sourcebyte 源数组
	 * @param destbyte   目标字节值
	 * @return 索引位置 -1表示未查找到
	 */
	public static int GetLastIndex(byte[] sourcebyte, byte destbyte) {

		for (int i = 0; i < sourcebyte.length; i++) {
			if (sourcebyte[sourcebyte.length - 1 - i] == destbyte) {
				return sourcebyte.length - 1 - i;
			}
		}
		return -1;// 如果未找到返回-1
	}
}
