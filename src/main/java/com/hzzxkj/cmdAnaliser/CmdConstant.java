package com.hzzxkj.cmdAnaliser;

/**
 * 定义命令对象的常量
 * 
 * @author asus
 *
 */
public class CmdConstant {

	// 采集器向外发送指令帧头首位
	public static final int mcuToPcHeaderFirst = 0x55;
	// 采集器向外发送指令帧头末位
	public static final int mcuToPcHeaderSecond = 0xaa;

	// 外部向采集器发送数据的帧头首位
	public static final int pcToMcuHeaderFirst = 0xaa;
	// 外部向采集器发送数据的帧头末位
	public static final int pcToMcuHeaderSecond = 0x55;

	// 采集器向外发送指令帧尾首位
	public static final int mcuToPcTailFirst = 0x33;
	// 采集器向外发送指令帧尾末位
	public static final int mcuToPcTailSecond = 0xcc;

	// 外部向采集器发送数据的帧尾首位
	public static final int pcToMcuTailFirst = 0x33;
	// 外部向采集器发送数据的帧尾末位
	public static final int pcToMcuTailSecond = 0xcc;

}
