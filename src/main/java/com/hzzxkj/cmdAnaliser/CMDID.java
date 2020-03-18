package com.hzzxkj.cmdAnaliser;

import org.apache.ibatis.annotations.Case;

/**
 * 自定义帧协议的命令列表
 * 
 * @author liujun
 *
 */
public enum CMDID {

	/**
	 * 不支持返回指令，当采集器不支持收到的指令时返回
	 */
	CMD_NoCmd(0xffff),
	/**
	 * 心跳包
	 */
	CMD_All_Status_ByBoard(0x0201),
	/**
	 * 读取采集器一条日志
	 */
	CMD_Get_EquipmentLog(0x0202),
	/**
	 * 删除一条日志
	 */
	CMD_Delete_Equipment_One_Data(0x0203),
	/**
	 * 删除所有日志
	 */
	CMD_Delete_Equipment_All_Data(0x0204),
	/**
	 * 设置采集器参数，主要是设置医院编号，设备编号、IP地址等
	 */
	CMD_Config_Parameters(0x0205),
	/**
	 * 读取采集器参数，主要是设置医院编号，设备编号、IP地址等
	 */
	CMD_Get_Parameters(0x0206),
	/// <summary>
	/// 设定时间
	/// </summary>
	 CMD_Config_Date(0x0207),
	// <summary>

	/// <summary>
	/// 查询时间
	/// </summary>
	// CMD_Get_Date(0x0208),

	/**
	 * 设备清除故障指令
	 */
	CMD_Equipment_ClearFaultStatus_ByBoard(0x0214),
	/**
	 * 查询采集器版本信息
	 */
	CMD_Get_Fireware_Version(0x020C),

	/**
	 * 切换串口工作模式
	 */
	CMD_Set_Baud(0x0219),
	/**
	 * 查询wifi模块mac地址
	 */
	CMD_Equipment_MAC(0x021C),
	/**
	 * 设置采集器网络参数
	 */
	CMD_Set_NetPar(0x021D),
	/**
	 * 读取采集器网络参数
	 */
	CMD_Get_NetPar(0x021E),

	/**
	 * 升级固件指令
	 */
	CMD_Update_Firmware(0x021F),

	/**
	 * 呼吸机开关机状态 1开机 0关机
	 */
	CMD_Equipment_OnOff_ByBoard(0x0221),
	/**
	 * 呼吸机工作状态 1工作 0 待机
	 */
	CMD_Equipment_WorkStatus_ByBoard(0x0222),

	/**
	 * 设备人工报故障
	 */
	CMD_Equipment_FaultStatus_ByBoard(0x0225),

	/**
	 * 学习工作待机工作参数指令
	 */
	CMD_Study_WorkIdleAF(0x0250),
	/**
	 * 读取关机待机工作参数
	 */
	CMD_Get_WorkIdleAF(0x0251),
	/**
	 * 设置关机待机工作参数
	 */
	CMD_Set_WorkIdleAF(0x0252),
	/**
	 * 设置主wifi信息
	 */
	CMD_Set_WifiInfo(0x0260),
	/**
	 * 读取主wifi信息指令
	 */
	CMD_Get_WifiInfo(0x0261),
	
	/**
	 * 设置迈瑞网口数据的接收ip和端口     2019-03-25 增加迈瑞网口数据端口设置
	 */
	CMD_Set_Mindary_ip(0x0262),
	
	/**
	 * 读取迈瑞网口数据的接收ip和端口  2019-03-25 增加迈瑞网口数据设置
	 */
	CMD_Get_Mindary_ip(0x0263),
	/**
	 * 设置采集器本地lan   ip   2019-04-08 
	 */
	CMD_Set_Lan_ip(0x0264),
	/**
	 * 读取采集器本地lan   ip 2019-04-08
	 */
	CMD_Get_Lan_ip(0x0265),
	
	
	/**
	 * 设置采集器本地lan   mac   2019-04-08 
	 */
	CMD_Set_Lan_mac(0x0266),
	/**
	 * 读取采集器本地lan   mac 2019-04-08
	 */
	CMD_Get_Lan_mac(0x0267),
	
	
	
	
	/**
	 * 读取呼吸机通道数据
	 */
	CMD_Read_ChannelData(0x0301),
	/**
	 * 设置呼吸机通道
	 */
	CMD_Set_Channel_0302(0x0302),
	/**
	 * 设置呼吸机通道
	 */
	CMD_Set_Channel_0303(0x0303),
	/**
	 * 设置呼吸机通道
	 */
	CMD_Set_Channel_0304(0x0304),
	/**
	 * 设置呼吸机通道
	 */
	CMD_Set_Channel_0305(0x0305),
	/**
	 * 设置呼吸机通道
	 */
	CMD_Set_Channel_0306(0x0306),
	/**
	 * 设置呼吸机通道
	 */
	CMD_Set_Channel_0307(0x0307),
	/**
	 * 设置呼吸机通道
	 */
	CMD_Set_Channel_0308(0x0308),
	/**
	 * 采集器重启指令
	 */
	CMD_Restart_Device(0x0310),
	/**
	 * 读取呼吸机类型
	 */
	CMD_Get_RespiratorBrandType(0x0311),

	/**
	 * 设置呼吸机类型
	 */
	CMD_Set_RespiratorBrandType(0x0312),
	/**
	 * 读取bootloader版本
	 */
	CMD_Get_Bootloader_version(0x0313),
	/**
	 * 设置报警状态
	 */
	CMD_Set_AlterStatus(0x0314),
	/**
	 * 设置串口数据上报
	 */
	CMD_Set_Serialport_upload(0x0315),
	/**
	 * 启动呼吸机波形数据指令
	 */
	CMD_Start_Wavedata(0x0316),
	/**
	 * 关闭呼吸机波形数据
	 */
	CMD_Stop_Wavedata(0x0317),
	/**
	 * 设置采集器辅助wifi
	 */
	CMD_Set_Backup_WifiInfo(0x0318),
	/**
	 * 读取采集器备用wifi
	 */
	CMD_Get_Backup_WifiInfo(0x0319),
	/**
	 * 采集器电源状态
	 */
	CMD_Device_PowerStatus(0x0380),

	/**
	 * 特殊指令，上位机收到后必须回复，且数据部分必须原样,否则采集器将重新连接
	 */
	Cmd_CallBack(0x0381),
	/**
	 * 波形数据传输指令
	 */
	CMD_Trans_Wavedata(0x0383),
	
	/**
	 * 德尔格波形数据传输指令
	 */
	CMD_Trans_Wavedata_evita(0x0384),
	/**
	 * 迈瑞波形数据传输指令
	 */
	CMD_Trans_Wavedata_minary(0x0385),
	/**
	 * 设置呼吸机通道
	 */
	CMD_Set_Channel_0402(0x0402),
	/**
	 * 设置呼吸机通道
	 */
	CMD_Set_Channel_0403(0x0403),
	/**
	 * 设置呼吸机通道
	 */
	CMD_Set_Channel_0404(0x0404),
	/**
	 * 设置呼吸机通道
	 */
	CMD_Set_Channel_0405(0x0405),
	/**
	 * 设置呼吸机通道
	 */
	CMD_Set_Channel_0406(0x0406),
	/**
	 * 设置呼吸机通道
	 */
	CMD_Set_Channel_0407(0x0407),
	/**
	 * 设置呼吸机通道
	 */
	CMD_Set_Channel_0408(0x0408),
	/**
	 * 设置呼吸机通道
	 */
	CMD_Set_Channel_0409(0x0409),
	/**
	 * 设置呼吸机通道
	 */
	CMD_Set_Channel_0410(0x0410),
	/**
	 * 设置呼吸机通道
	 */
	CMD_Set_Channel_0411(0x0411),
	/**
	 * 设置呼吸机通道
	 */
	CMD_Set_Channel_0412(0x0412),
	/**
	 * 设置呼吸机通道
	 */
	CMD_Set_Channel_0413(0x0413),
	/**
	 * 设置呼吸机通道
	 */
	CMD_Set_Channel_0414(0x0414),
	/**
	 * 设置呼吸机通道
	 */
	CMD_Set_Channel_0415(0x0415),
	/**
	 * 设置呼吸机通道
	 */
	CMD_Set_Channel_0416(0x0416),
	/**
	 * 设置呼吸机通道
	 */
	CMD_Set_Channel_0417(0x0417),
	/**
	 * 设置呼吸机通道
	 */
	CMD_Set_Channel_0418(0x0418),
	/**
	 * 设置呼吸机通道
	 */
	CMD_Set_Channel_0419(0x0419),
	
	/**
	 * 设置呼吸机全参数通道
	 */
	CMD_Set_WholeParameter(0x042a),
	
	/**
	 * 接受全参数实时数据
	 */
	CMD_Trans_WholeParameter(0x042b);

	private Integer cmdId;

	public Integer getCmdId() {
		return cmdId;
	}

	public String getCmdHEX() {
		return Integer.toHexString(cmdId);
	}

	CMDID(Integer id) {
		this.cmdId = id;
	}

	public static CMDID CmdIdToEnum(int value) {

		switch (value) {

		case 0x0201:
			return CMD_All_Status_ByBoard;
		case 0x0202:
			return CMD_Get_EquipmentLog;
		case 0x0203:
			return CMD_Delete_Equipment_One_Data;
		case 0x0204:
			return CMD_Delete_Equipment_All_Data;
		case 0x0205:
			return CMD_Config_Parameters;
		case 0x0206:
			return CMD_Get_Parameters;
		case 0x0207:
			return CMD_Config_Date;
		case 0x020c:
			return CMD_Get_Fireware_Version;
		case 0x0214:
			return CMD_Equipment_ClearFaultStatus_ByBoard;
		case 0x0219:
			return CMD_Set_Baud;
		case 0x021c:
			return CMD_Equipment_MAC;
		case 0x021d:
			return CMD_Set_NetPar;
		case 0x021e:
			return CMD_Get_NetPar;
		case 0x021f:
			return CMD_Update_Firmware;
		case 0x0221:
			return CMD_Equipment_OnOff_ByBoard;
		case 0x0222:
			return CMD_Equipment_WorkStatus_ByBoard;
		case 0x0225:
			return CMD_Equipment_FaultStatus_ByBoard;
		case 0x0250:
			return CMD_Study_WorkIdleAF;
		case 0x0251:
			return CMD_Get_WorkIdleAF;
		case 0x0252:
			return CMD_Set_WorkIdleAF;
		case 0x0260:
			return CMD_Set_WifiInfo;
		case 0x0261:
			return CMD_Get_WifiInfo;
		case 0x0262:
			return CMD_Set_Mindary_ip;
		case 0x0263:
			return CMD_Get_Mindary_ip;
		case 0x0264:
			return CMD_Set_Lan_ip;
		case 0x0265:
			return CMD_Get_Lan_ip;
			
		case 0x0266:
			return CMD_Set_Lan_mac;
		case 0x0267:
		    return CMD_Get_Lan_mac;
		case 0x0301:
			return CMD_Read_ChannelData;
		case 0x0302:
			return CMD_Set_Channel_0302;
		case 0x0303:
			return CMD_Set_Channel_0303;
		case 0x0304:
			return CMD_Set_Channel_0304;
		case 0x0305:
			return CMD_Set_Channel_0305;
		case 0x0306:
			return CMD_Set_Channel_0306;
		case 0x0307:
			return CMD_Set_Channel_0307;
		case 0x0308:
			return CMD_Set_Channel_0308;
		case 0x0310:
			return CMD_Restart_Device;
		case 0x0311:
			return CMD_Get_RespiratorBrandType;
		case 0x0312:
			return CMD_Set_RespiratorBrandType;
		case 0x0313:
			return CMD_Get_Bootloader_version;
		case 0x0314:
			return CMD_Set_AlterStatus;
		case 0x0315:
			return CMD_Set_Serialport_upload;
		case 0x0316:
			return CMD_Start_Wavedata;
		case 0x0317:
			return CMD_Stop_Wavedata;
		case 0x0318:
			return CMD_Set_Backup_WifiInfo;
		case 0x0319:
			return CMD_Get_Backup_WifiInfo;
		case 0x0380:
			return CMD_Device_PowerStatus;
		case 0x0381:
			return Cmd_CallBack;
		case 0x0383:
			return CMD_Trans_Wavedata;
		case 0x0384:
			return CMD_Trans_Wavedata_evita;
		case 0x0385:
			return CMD_Trans_Wavedata_minary;
		case 0x0402:
			return CMD_Set_Channel_0402;
		case 0x0403:
			return CMD_Set_Channel_0403;
		case 0x0404:
			return CMD_Set_Channel_0404;
		case 0x0405:
			return CMD_Set_Channel_0405;
		case 0x0406:
			return CMD_Set_Channel_0406;
		case 0x0407:
			return CMD_Set_Channel_0407;
		case 0x0408:
			return CMD_Set_Channel_0408;
		case 0x0409:
			return CMD_Set_Channel_0409;
		case 0x0410:
			return CMD_Set_Channel_0410;
		case 0x0411:
			return CMD_Set_Channel_0411;
		case 0x0412:
			return CMD_Set_Channel_0412;
		case 0x0413:
			return CMD_Set_Channel_0413;
		case 0x0414:
			return CMD_Set_Channel_0414;
		case 0x0415:
			return CMD_Set_Channel_0415;
		case 0x0416:
			return CMD_Set_Channel_0416;
		case 0x0417:
			return CMD_Set_Channel_0417;
		case 0x0418:
			return CMD_Set_Channel_0418;
		case 0x0419:
			return CMD_Set_Channel_0419;
		case 0x042a:
			return CMD_Set_WholeParameter;
		case 0x042b:
			return CMD_Trans_WholeParameter;
		default:
			return CMD_NoCmd;

		}

	}

}
