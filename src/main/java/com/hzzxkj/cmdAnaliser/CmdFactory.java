package com.hzzxkj.cmdAnaliser;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Case;

import com.hzzxkj.cmdAnaliser.cmdModel._0x0201Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0202Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0203Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0204Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0205Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0206Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0207Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x020cCommand;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0214Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0219Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x021cCommand;
import com.hzzxkj.cmdAnaliser.cmdModel._0x021dCommand;
import com.hzzxkj.cmdAnaliser.cmdModel._0x021eCommand;
import com.hzzxkj.cmdAnaliser.cmdModel._0x021fCommand;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0221Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0222Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0225Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0250Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0251Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0252Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0260Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0261Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0262Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0263Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0264Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0265Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0266Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0267Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0301Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0302Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0303Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0304Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0305Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0306Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0307Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0308Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0310Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0311Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0312Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0313Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0314Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0315Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0316Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0317Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0318Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0319Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0380Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0381Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0383Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0384Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0385Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0402Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0403Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0404Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0405Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0406Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0407Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0408Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0409Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0410Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0411Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0412Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0413Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0414Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0415Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0416Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0417Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0418Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x0419Command;
import com.hzzxkj.cmdAnaliser.cmdModel._0x042aCommand;
import com.hzzxkj.cmdAnaliser.cmdModel._0x042bCommand;


/**
 * 命令工厂 主要用于解析命令字节与生成反馈指令，
 * 
 * @author asus
 *
 */
public class CmdFactory {

	/**
	 * 根据接收到的字节数组生成命令对象
	 * 
	 * @param cmdbyte 原始指令
	 * @return 命令对象
	 */
	public static CmdModel CreateCmd(byte[] cmdbyte) {

		//获取命令版本
		byte[] tempbyte = CmdUtils.GetLastByteArray(cmdbyte, 4);

		byte[] protocolByte = new byte[2];
		System.arraycopy(tempbyte, 0, protocolByte, 0, 2);

		int ProtocolVersion = CmdUtils.ByteArray2ToInteger(protocolByte, 0);
		int id = -1;
		// 1 解析命令ID 获取到命令的枚举类型
		
		switch (ProtocolVersion) {
		case 0 :
			id = CmdUtils.ByteArray2ToInteger(cmdbyte, 7);
			break;
		case 1:
			id = CmdUtils.ByteArray2ToInteger(cmdbyte, 45);
			break;
		default:
			break;
		}
		CMDID temp = CMDID.CmdIdToEnum(id);
		// 2根据枚举类型解析对应的数据
		switch (temp) {
		
		case CMD_All_Status_ByBoard:
			return new _0x0201Command(cmdbyte);
		case CMD_Get_EquipmentLog:
			return new _0x0202Command(cmdbyte);
		case CMD_Delete_Equipment_One_Data:
			return new _0x0203Command(cmdbyte);
		case CMD_Delete_Equipment_All_Data:
			return new _0x0204Command(cmdbyte);
		case CMD_Config_Parameters:
			return new _0x0205Command(cmdbyte);
		case CMD_Get_Parameters:
			return new _0x0206Command(cmdbyte);
		case CMD_Config_Date:
			return new _0x0207Command(cmdbyte);
		case CMD_Get_Fireware_Version:
			return new _0x020cCommand(cmdbyte);
		case CMD_Equipment_ClearFaultStatus_ByBoard:
			return new _0x0214Command(cmdbyte);
		case CMD_Set_Baud:
			return new _0x0219Command(cmdbyte);
		case CMD_Equipment_MAC:
			return new _0x021cCommand(cmdbyte);
		case CMD_Set_NetPar:
			return new _0x021dCommand(cmdbyte);
		case CMD_Get_NetPar:
			return new _0x021eCommand(cmdbyte);
		case CMD_Update_Firmware:
			return new _0x021fCommand(cmdbyte);
		case CMD_Equipment_OnOff_ByBoard:
			return new _0x0221Command(cmdbyte);
		case CMD_Equipment_WorkStatus_ByBoard:
			return new _0x0222Command(cmdbyte);
		case CMD_Equipment_FaultStatus_ByBoard:
			return new _0x0225Command(cmdbyte);
		case CMD_Study_WorkIdleAF:
			return new _0x0250Command(cmdbyte);
		case CMD_Get_WorkIdleAF:
			return new _0x0251Command(cmdbyte);
		case CMD_Set_WorkIdleAF:
			return new _0x0252Command(cmdbyte);
		case CMD_Set_WifiInfo:
			return new _0x0260Command(cmdbyte);
		case CMD_Get_WifiInfo:
			return new _0x0261Command(cmdbyte);
		case CMD_Set_Mindary_ip:
			return new _0x0262Command(cmdbyte);
		case CMD_Get_Mindary_ip:
			return new _0x0263Command(cmdbyte);
		case CMD_Set_Lan_ip:
			return new _0x0264Command(cmdbyte);
		case CMD_Get_Lan_ip:
			return new _0x0265Command(cmdbyte);
		case CMD_Set_Lan_mac:
			return new _0x0266Command(cmdbyte);
		case CMD_Get_Lan_mac:
			return new _0x0267Command(cmdbyte);
		case CMD_Read_ChannelData:
			return new _0x0301Command(cmdbyte);
		case CMD_Set_Channel_0302:
			return new _0x0302Command(cmdbyte);
		case CMD_Set_Channel_0303:
			return new _0x0303Command(cmdbyte);
		case CMD_Set_Channel_0304:
			return new _0x0304Command(cmdbyte);
		case CMD_Set_Channel_0305:
			return new _0x0305Command(cmdbyte);
		case CMD_Set_Channel_0306:
			return new _0x0306Command(cmdbyte);
		case CMD_Set_Channel_0307:
			return new _0x0307Command(cmdbyte);
		case CMD_Set_Channel_0308:
			return new _0x0308Command(cmdbyte);
		case CMD_Restart_Device:
			return new _0x0310Command(cmdbyte);
		case CMD_Get_RespiratorBrandType:
			return new _0x0311Command(cmdbyte);
		case CMD_Set_RespiratorBrandType:
			return new _0x0312Command(cmdbyte);
		case CMD_Get_Bootloader_version:
			return new _0x0313Command(cmdbyte);
		case CMD_Set_AlterStatus:
			return new _0x0314Command(cmdbyte);
		case CMD_Set_Serialport_upload:
			return new _0x0315Command(cmdbyte);
		case CMD_Start_Wavedata:
			return new _0x0316Command(cmdbyte);
		case CMD_Stop_Wavedata:
			return new _0x0317Command(cmdbyte);
		case CMD_Set_Backup_WifiInfo:
			return new _0x0318Command(cmdbyte);
		case CMD_Get_Backup_WifiInfo:
			return new _0x0319Command(cmdbyte);
		case CMD_Device_PowerStatus:
			return new _0x0380Command(cmdbyte);
		case Cmd_CallBack:
			return new _0x0381Command(cmdbyte);
		case CMD_Trans_Wavedata:
			return new _0x0383Command(cmdbyte);
		case CMD_Trans_Wavedata_evita:
			return new _0x0384Command(cmdbyte);
		case CMD_Trans_Wavedata_minary:
			return new _0x0385Command(cmdbyte);
		case CMD_Set_Channel_0402:
			return new _0x0402Command(cmdbyte);
		case CMD_Set_Channel_0403:
			return new _0x0403Command(cmdbyte);
		case CMD_Set_Channel_0404:
			return new _0x0404Command(cmdbyte);
		case CMD_Set_Channel_0405:
			return new _0x0405Command(cmdbyte);
		case CMD_Set_Channel_0406:
			return new _0x0406Command(cmdbyte);
		case CMD_Set_Channel_0407:
			return new _0x0407Command(cmdbyte);
		case CMD_Set_Channel_0408:
			return new _0x0408Command(cmdbyte);
		case CMD_Set_Channel_0409:
			return new _0x0409Command(cmdbyte);
		case CMD_Set_Channel_0410:
			return new _0x0410Command(cmdbyte);
		case CMD_Set_Channel_0411:
			return new _0x0411Command(cmdbyte);
		case CMD_Set_Channel_0412:
			return new _0x0412Command(cmdbyte);
		case CMD_Set_Channel_0413:
			return new _0x0413Command(cmdbyte);
		case CMD_Set_Channel_0414:
			return new _0x0414Command(cmdbyte);
		case CMD_Set_Channel_0415:
			return new _0x0415Command(cmdbyte);
		case CMD_Set_Channel_0416:
			return new _0x0416Command(cmdbyte);
		case CMD_Set_Channel_0417:
			return new _0x0417Command(cmdbyte);
		case CMD_Set_Channel_0418:
			return new _0x0418Command(cmdbyte);
		case CMD_Set_Channel_0419:
			return new _0x0419Command(cmdbyte);
		case CMD_Set_WholeParameter:
			return new _0x042aCommand(cmdbyte);
		case CMD_Trans_WholeParameter:
			return new _0x042bCommand(cmdbyte);
		default:
			return null;
		}
	}

	/**
	 * 获取命令对象中的原始字节数据
	 * 
	 * @param model 命令对象
	 * @return 原始字节
	 */
	public static byte[] GetCmdByteFromModel(CmdModel model) {
		return model.originalByte;
	}

	/**
	 * 根据命令和需要的反馈结果生成反馈指令对象
	 * 
	 * @param cmdbyte 原始指令
	 * @param result  反馈结果
	 * @return
	 */
	public static CmdModel GenerateReturnCmd(byte[] cmdbyte, boolean result) {

		//获取命令版本号
		byte[] tempbyte = CmdUtils.GetLastByteArray(cmdbyte, 4);

		byte[] protocolByte = new byte[2];
		System.arraycopy(tempbyte, 0, protocolByte, 0, 2);

		int ProtocolVersion = CmdUtils.ByteArray2ToInteger(protocolByte, 0);
		int id = -1;
		// 1 解析命令ID 获取到命令的枚举类型
		
		switch (ProtocolVersion) {
		case 0 :
			id = CmdUtils.ByteArray2ToInteger(cmdbyte, 7);
			break;
		case 1:
			id = CmdUtils.ByteArray2ToInteger(cmdbyte, 45);
			break;
		default:
			break;
		}

		CMDID temp = CMDID.CmdIdToEnum(id);
		// 2根据枚举类型解析对应的数据
		switch (temp) {

		case CMD_All_Status_ByBoard:
			return new _0x0201Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Get_EquipmentLog:
			return new _0x0202Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Delete_Equipment_One_Data:
			return new _0x0203Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Delete_Equipment_All_Data:
			return new _0x0204Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Config_Parameters:
			return new _0x0205Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Get_Parameters:
			return new _0x0206Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Config_Date:
			return new _0x0207Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Get_Fireware_Version:
			return new _0x020cCommand(cmdbyte).GenerateReturnCmd(result);
		case CMD_Equipment_ClearFaultStatus_ByBoard:
			return new _0x0214Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Set_Baud:
			return new _0x0219Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Equipment_MAC:
			return new _0x021cCommand(cmdbyte).GenerateReturnCmd(result);
		case CMD_Set_NetPar:
			return new _0x021dCommand(cmdbyte).GenerateReturnCmd(result);
		case CMD_Get_NetPar:
			return new _0x021eCommand(cmdbyte).GenerateReturnCmd(result);
		case CMD_Update_Firmware:
			return new _0x021fCommand(cmdbyte).GenerateReturnCmd(result);
		case CMD_Equipment_OnOff_ByBoard:
			return new _0x0221Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Equipment_WorkStatus_ByBoard:
			return new _0x0222Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Equipment_FaultStatus_ByBoard:
			return new _0x0225Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Study_WorkIdleAF:
			return new _0x0250Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Get_WorkIdleAF:
			return new _0x0251Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Set_WorkIdleAF:
			return new _0x0252Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Set_WifiInfo:
			return new _0x0260Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Get_WifiInfo:
			return new _0x0261Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Set_Mindary_ip:
			return new _0x0262Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Get_Mindary_ip:
			return new _0x0263Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Set_Lan_ip:
			return new _0x0264Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Get_Lan_ip:
			return new _0x0265Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Set_Lan_mac:
			return new _0x0266Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Get_Lan_mac:
			return new _0x0267Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Read_ChannelData:
			return new _0x0301Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Set_Channel_0302:
			return new _0x0302Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Set_Channel_0303:
			return new _0x0303Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Set_Channel_0304:
			return new _0x0304Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Set_Channel_0305:
			return new _0x0305Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Set_Channel_0306:
			return new _0x0306Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Set_Channel_0307:
			return new _0x0307Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Set_Channel_0308:
			return new _0x0308Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Restart_Device:
			return new _0x0310Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Get_RespiratorBrandType:
			return new _0x0311Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Set_RespiratorBrandType:
			return new _0x0312Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Get_Bootloader_version:
			return new _0x0313Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Set_AlterStatus:
			return new _0x0314Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Set_Serialport_upload:
			return new _0x0315Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Start_Wavedata:
			return new _0x0316Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Stop_Wavedata:
			return new _0x0317Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Set_Backup_WifiInfo:
			return new _0x0318Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Get_Backup_WifiInfo:
			return new _0x0319Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Device_PowerStatus:
			return new _0x0380Command(cmdbyte).GenerateReturnCmd(result);
		case Cmd_CallBack:
			return new _0x0381Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Trans_Wavedata:
			return new _0x0383Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Trans_Wavedata_evita:
			return new _0x0384Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Trans_Wavedata_minary:
			return new _0x0385Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Set_Channel_0402:
			return new _0x0402Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Set_Channel_0403:
			return new _0x0403Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Set_Channel_0404:
			return new _0x0404Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Set_Channel_0405:
			return new _0x0405Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Set_Channel_0406:
			return new _0x0406Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Set_Channel_0407:
			return new _0x0407Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Set_Channel_0408:
			return new _0x0408Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Set_Channel_0409:
			return new _0x0409Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Set_Channel_0410:
			return new _0x0410Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Set_Channel_0411:
			return new _0x0411Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Set_Channel_0412:
			return new _0x0412Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Set_Channel_0413:
			return new _0x0413Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Set_Channel_0414:
			return new _0x0414Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Set_Channel_0415:
			return new _0x0415Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Set_Channel_0416:
			return new _0x0416Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Set_Channel_0417:
			return new _0x0417Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Set_Channel_0418:
			return new _0x0418Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Set_Channel_0419:
			return new _0x0419Command(cmdbyte).GenerateReturnCmd(result);
		case CMD_Set_WholeParameter:
			return new _0x042aCommand(cmdbyte).GenerateReturnCmd(result);
		case CMD_Trans_WholeParameter:
			return new _0x042bCommand(cmdbyte).GenerateReturnCmd(result);

		default:
			return null;

		}
	}

	/**
	 * 根据命令和需要的反馈结果生成反馈指令字节
	 * 
	 * @param cmdbyte 原始指令
	 * @param result  反馈结果
	 * @return 字节数组
	 */
	public static byte[] GenerateReturnCmdByte(byte[] cmdbyte, boolean result) {
		//获取命令版本号
		byte[] tempbyte = CmdUtils.GetLastByteArray(cmdbyte, 4);

		byte[] protocolByte = new byte[2];
		System.arraycopy(tempbyte, 0, protocolByte, 0, 2);

		int ProtocolVersion = CmdUtils.ByteArray2ToInteger(protocolByte, 0);
		int id = -1;
		// 1 解析命令ID 获取到命令的枚举类型
		
		switch (ProtocolVersion) {
		case 0 :
			id = CmdUtils.ByteArray2ToInteger(cmdbyte, 7);
			break;
		case 1:
			id = CmdUtils.ByteArray2ToInteger(cmdbyte, 45);
			break;
		default:
			break;
		}
		CMDID temp = CMDID.CmdIdToEnum(id);
		// 2根据枚举类型解析对应的数据
		switch (temp) {

		case CMD_All_Status_ByBoard:
			return new _0x0201Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Get_EquipmentLog:
			return new _0x0202Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Delete_Equipment_One_Data:
			return new _0x0203Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Delete_Equipment_All_Data:
			return new _0x0204Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Config_Parameters:
			return new _0x0205Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Get_Parameters:
			return new _0x0206Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Config_Date:
			return new _0x0207Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Get_Fireware_Version:
			return new _0x020cCommand(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Equipment_ClearFaultStatus_ByBoard:
			return new _0x0214Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Set_Baud:
			return new _0x0219Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Equipment_MAC:
			return new _0x021cCommand(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Set_NetPar:
			return new _0x021dCommand(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Get_NetPar:
			return new _0x021eCommand(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Update_Firmware:
			return new _0x021fCommand(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Equipment_OnOff_ByBoard:
			return new _0x0221Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Equipment_WorkStatus_ByBoard:
			return new _0x0222Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Equipment_FaultStatus_ByBoard:
			return new _0x0225Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Study_WorkIdleAF:
			return new _0x0250Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Get_WorkIdleAF:
			return new _0x0251Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Set_WorkIdleAF:
			return new _0x0252Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Set_WifiInfo:
			return new _0x0260Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Get_WifiInfo:
			return new _0x0261Command(cmdbyte).GenerateReturnCmdByte(result);
		
		case CMD_Set_Mindary_ip:
			return new _0x0262Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Get_Mindary_ip:
			return new _0x0263Command(cmdbyte).GenerateReturnCmdByte(result);
			
		case CMD_Set_Lan_ip:
			return new _0x0264Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Get_Lan_ip:
			return new _0x0265Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Set_Lan_mac:
			return new _0x0266Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Get_Lan_mac:
			return new _0x0267Command(cmdbyte).GenerateReturnCmdByte(result);	
			
		case CMD_Read_ChannelData:
			return new _0x0301Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Set_Channel_0302:
			return new _0x0302Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Set_Channel_0303:
			return new _0x0303Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Set_Channel_0304:
			return new _0x0304Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Set_Channel_0305:
			return new _0x0305Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Set_Channel_0306:
			return new _0x0306Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Set_Channel_0307:
			return new _0x0307Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Set_Channel_0308:
			return new _0x0308Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Restart_Device:
			return new _0x0310Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Get_RespiratorBrandType:
			return new _0x0311Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Set_RespiratorBrandType:
			return new _0x0312Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Get_Bootloader_version:
			return new _0x0313Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Set_AlterStatus:
			return new _0x0314Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Set_Serialport_upload:
			return new _0x0315Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Start_Wavedata:
			return new _0x0316Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Stop_Wavedata:
			return new _0x0317Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Set_Backup_WifiInfo:
			return new _0x0318Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Get_Backup_WifiInfo:
			return new _0x0319Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Device_PowerStatus:
			return new _0x0380Command(cmdbyte).GenerateReturnCmdByte(result);
		case Cmd_CallBack:
			return new _0x0381Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Trans_Wavedata:
			return new _0x0383Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Trans_Wavedata_evita:
			return new _0x0384Command(cmdbyte).GenerateReturnCmdByte(result);	
		case CMD_Trans_Wavedata_minary:
			return new _0x0385Command(cmdbyte).GenerateReturnCmdByte(result);	
		case CMD_Set_Channel_0402:
			return new _0x0402Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Set_Channel_0403:
			return new _0x0403Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Set_Channel_0404:
			return new _0x0404Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Set_Channel_0405:
			return new _0x0405Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Set_Channel_0406:
			return new _0x0406Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Set_Channel_0407:
			return new _0x0407Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Set_Channel_0408:
			return new _0x0408Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Set_Channel_0409:
			return new _0x0409Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Set_Channel_0410:
			return new _0x0410Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Set_Channel_0411:
			return new _0x0411Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Set_Channel_0412:
			return new _0x0412Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Set_Channel_0413:
			return new _0x0413Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Set_Channel_0414:
			return new _0x0414Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Set_Channel_0415:
			return new _0x0415Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Set_Channel_0416:
			return new _0x0416Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Set_Channel_0417:
			return new _0x0417Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Set_Channel_0418:
			return new _0x0418Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Set_Channel_0419:
			return new _0x0419Command(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Set_WholeParameter:
			return new _0x042aCommand(cmdbyte).GenerateReturnCmdByte(result);
		case CMD_Trans_WholeParameter:
			return new _0x042bCommand(cmdbyte).GenerateReturnCmdByte(result);

			
		
		default:
			return null;

		}
	}

	/**
	 * 根据参数构建相应的指令字节数组 只用于pc端主动给采集器下发的指令的创建
	 * 
	 * @param portocolVersion 协议版本号
	 * @param hospitalid      医院ID
	 * @param deviceid        设备ID
	 * @param cmd             命令id枚举值
	 * @param  databyte       命令参数
	 * @return 字节数组
	 */
	public static byte[] CreateCmd(int portocolVersion, int hospitalid, int deviceid, CMDID cmd, byte[] databyte) {

		ArrayList<Byte> resultbyte = new ArrayList<>();
		switch (portocolVersion) {
		case 0:
			resultbyte.add((byte) CmdConstant.pcToMcuHeaderFirst);
			resultbyte.add((byte) CmdConstant.pcToMcuHeaderSecond);
			resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.IntegerToByteArray2(hospitalid)));
			resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.IntegerToByteArray2(deviceid)));
			resultbyte.add((byte) 0x01);
			resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.IntegerToByteArray2(cmd.getCmdId())));

			if (databyte == null) {
				resultbyte.add((byte) 0x01);
				resultbyte.add((byte) 0x00);
				resultbyte.add((byte) 0x01);
			} else {
				//resultbyte.add((byte) databyte.length);
				resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.IntegerToByteArray2(databyte.length)));
				
				resultbyte.addAll(CmdUtils.ArrayToList(databyte));
			}

			int crcvalue = CRC16Util.GetCrcValue(CmdUtils.ListToArray(resultbyte), 2, resultbyte.size() - 2);
			byte[] crcbyte = CmdUtils.IntegerToByteArray2(crcvalue);
			resultbyte.addAll(CmdUtils.ArrayToList(crcbyte));
			resultbyte.add((byte) 0x00);
			resultbyte.add((byte) 0x00);
			resultbyte.add((byte) CmdConstant.pcToMcuTailFirst);
			resultbyte.add((byte) CmdConstant.pcToMcuTailSecond);
			break;
		case 1:
			resultbyte.add((byte) CmdConstant.pcToMcuHeaderFirst);
			resultbyte.add((byte) CmdConstant.pcToMcuHeaderSecond);
			resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.IntegerToByteArray2(0x00)));
			resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.IntegerToByteArray2(0x00)));
			resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.IntegerToByteArray2(0x00)));

			resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.HexStringToByteArray("00 00 00 00", " ")));

			resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.HexStringToByteArray("00 00 00 00 00 00", " ")));

			resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.HexStringToByteArray("00 00 00 00 00 00", " ")));

			resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.HexStringToByteArray("00 00 00 00 00 00", " ")));

			resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.HexStringToByteArray("00 00 00 00 00 00", " ")));

			resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.HexStringToByteArray("00 00 00 00 00 00 00 00", " ")));

			resultbyte.add((byte) 0x01);

			resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.IntegerToByteArray2(cmd.getCmdId())));

			if (databyte == null) {
				resultbyte.add((byte) 0x01);
				resultbyte.add((byte) 0x00);
				resultbyte.add((byte) 0x01);
			} else {
				resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.IntegerToByteArray2(databyte.length)));
				resultbyte.addAll(CmdUtils.ArrayToList(databyte));
			}
			int crcvalue1 = CRC16Util.GetCrcValue(CmdUtils.ListToArray(resultbyte), 2, resultbyte.size() - 2);
			byte[] crcbyte1 = CmdUtils.IntegerToByteArray2(crcvalue1);
			resultbyte.addAll(CmdUtils.ArrayToList(crcbyte1));
			resultbyte.add((byte) 0x00);
			resultbyte.add((byte) 0x01);
			resultbyte.add((byte) CmdConstant.pcToMcuTailFirst);
			resultbyte.add((byte) CmdConstant.pcToMcuTailSecond);
			break;
		default:
			resultbyte.add((byte) CmdConstant.pcToMcuHeaderFirst);
			resultbyte.add((byte) CmdConstant.pcToMcuHeaderSecond);
			resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.IntegerToByteArray2(0x00)));
			resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.IntegerToByteArray2(0x00)));
			resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.IntegerToByteArray2(0x00)));

			resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.HexStringToByteArray("00 00 00 00", " ")));

			resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.HexStringToByteArray("00 00 00 00 00 00", " ")));

			resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.HexStringToByteArray("00 00 00 00 00 00", " ")));

			resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.HexStringToByteArray("00 00 00 00 00 00", " ")));

			resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.HexStringToByteArray("00 00 00 00 00 00", " ")));

			resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.HexStringToByteArray("00 00 00 00 00 00 00 00", " ")));
			resultbyte.add((byte) 0x01);

			resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.IntegerToByteArray2(cmd.getCmdId())));

			if (databyte == null) {
				resultbyte.add((byte) 0x01);
				resultbyte.add((byte) 0x00);
				resultbyte.add((byte) 0x01);
			} else {
				resultbyte.addAll(CmdUtils.ArrayToList(CmdUtils.IntegerToByteArray2(databyte.length)));
				resultbyte.addAll(CmdUtils.ArrayToList(databyte));
			}
			int crcvalue2 = CRC16Util.GetCrcValue(CmdUtils.ListToArray(resultbyte), 2, resultbyte.size() - 2);
			byte[] crcbyte2 = CmdUtils.IntegerToByteArray2(crcvalue2);
			resultbyte.addAll(CmdUtils.ArrayToList(crcbyte2));
			resultbyte.add((byte) 0x00);
			resultbyte.add((byte) 0x01);
			resultbyte.add((byte) CmdConstant.pcToMcuTailFirst);
			resultbyte.add((byte) CmdConstant.pcToMcuTailSecond);
			break;
		}

		return CmdUtils.ListToArray(resultbyte);

	}

	/**
	 * 移除对象中的某几个字节并重新生成字节数组，用于生成向第三方发送的字节数组
	 * 
	 * @param model      命令对象
	 * @param startindex 要移除的字节开始索引
	 * @param length     要移除的字节长度
	 * @return 字节数组
	 */
	public static byte[] GenerateCmdByteToOutterService(CmdModel model, int startindex, int length) {

		byte[] tempbyte = model.originalByte; // 获取原始字节数组

		byte[] result = new byte[tempbyte.length - length]; // 新建字节数组存储数据

		int j = 0;
		for (int i = 0; i < tempbyte.length; i++) {
			if (i >= startindex && i < startindex + length) {
				// 若当前索引在要移除的索引范围内
			} else {
				// 若当前索引不在要移除的索引范围内,将两个索引下标都加1
				result[j] = tempbyte[i];
				j++;
			}
		}
		// 计算新字节数组的crc值
		int crcvalue = CRC16Util.GetCrcValue(result, 2, result.length - 8);

		byte[] crcbyte = CmdUtils.IntegerToByteArray2(crcvalue);
		// 替换新的crc字节
		result[result.length - 6] = crcbyte[0];
		result[result.length - 5] = crcbyte[1];

		return result;
	}
    /**
     * 读取采集器单条日志
     * @param portocolVersion   协议版本
     * @param hospitalid        医院编号
     * @param deviceid          设备编号  
     * @param databyte          参数
     * @return
     */
	public static byte[] createcmd_Readlog(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Get_EquipmentLog,databyte );
	}
	/**
	 * 删除一条日志  命令ID 0x0203
	 * @param portocolVersion   协议版本
	 * @param hospitalid        医院编号
	 * @param deviceid          设备编号
	 * @param databyte          参数
	 * @return
	 */
	public static byte[] createcmd_DeleteOneLog(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return  CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Delete_Equipment_One_Data, databyte);
	}
	/**
	 * 删除所有日志  命令ID 0x0204
	 * @param portocolVersion   协议版本
	 * @param hospitalid        医院编号
	 * @param deviceid          设备编号
	 * @param databyte          参数
	 * @return
	 */
	public static byte[] createcmd_DeteteAllLog(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
	   return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Delete_Equipment_All_Data, databyte);
	}
	/**
	 * 设置参数    命令ID 0x0205
	 * @param portocolVersion    协议版本
	 * @param hospitalid         医院编号
	 * @param deviceid           设备编号
	 * @param databyte           参数
	 * @return
	 */
	public static byte[] createcmd_SetConfigParameters(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Config_Parameters, databyte);
	}
	/**
	 * 查询参数   命令ID 0x0206
	 * @param portocolVersion    协议版本
	 * @param hospitalid         医院编号
	 * @param deviceid           设备编号
	 * @param databyte           参数
	 * @return
	 */
	public static byte[] createcmd_GetParameters(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		 return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Get_Parameters, databyte);
	}
	/**
	 * 查询版本信息   命令ID 0x020C
	 * @param portocolVersion     协议版本
	 * @param hospitalid          医院编号
	 * @param deviceid            设备编号
	 * @param databyte            参数
	 * @return
	 */
	public static  byte[] createcmd_GetFirewareVersion(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Get_Fireware_Version, databyte); 
	}
	/**
	 * 清除报警信息  命令ID    0x0214
	 * @param portocolVersion     协议版本
	 * @param hospitalid          医院编号
	 * @param deviceid            设备编号
	 * @param databyte            参数
	 * @return
	 */
	public static byte[] createcmd_ClearFaultStatus(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Equipment_ClearFaultStatus_ByBoard, databyte); 
	}
	/**
	 * 切换串口的工作模式   命令  0x0219
	 * @param portocolVersion     协议版本
	 * @param hospitalid          医院编号
	 * @param deviceid            设备编号
	 * @param databyte            参数
	 * @return
	 */
	public static byte[] createcmd_SetBaud(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Set_Baud, databyte);
	}
	/**
	 * 查询wifi模块的MAC地址    命令ID 0x021C
	 * @param portocolVersion     协议版本
	 * @param hospitalid          医院编号
	 * @param deviceid            设备编号
	 * @param databyte            参数
	 * @return
	 */
	public static byte[] createcmd_GetEquipmentMAC(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Equipment_MAC, databyte);
	}
	/**
	 * 设置本地wifi 模块IP地址    命令ID 0x021D
	 * @param portocolVersion     协议版本
	 * @param hospitalid          医院编号
	 * @param deviceid            设备编号
	 * @param databyte            参数
	 * @return
	 */
	public static byte[] createcmd_SetNetPar(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Set_NetPar, databyte);
	}
	/**
	 * 读取本地wifi模块  IP地址    命令ID  0x021E
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_GetNetPar(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Get_NetPar, databyte);
	}
	/**
	 * 升级固件      命令ID    0x021F
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_UpdateFirmware(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Update_Firmware, databyte);
	}
	/**
	 * 学习关机待机工作参数 命令ID  0x0250
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_StudyWorkIdleAF(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Study_WorkIdleAF, databyte);
	}
	/**
	 * 读取关机待机工作参数  命令ID   0x0251
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_GetWorkIdleAF(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Get_WorkIdleAF, databyte);
	}
	/**
	 * 设置关机待机工作参数    命令ID  0x0252
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_SetWorkIdleAF(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Set_WorkIdleAF, databyte);
	}
	/**
	 * 设置wifi信息   命令ID   0x0260
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_SetWifiInf(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Set_WifiInfo, databyte);
	}
	/**
	 * 读取wifi信息   命令ID   0x0261
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_GetWifiInfo(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Get_WifiInfo, databyte);
	}
	/**
	 * 设置迈瑞监护仪网口数据地址   命令ID   0x0262
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_SetMindaryIP(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Set_Mindary_ip, databyte);
	}
	/**
	 * 读取迈瑞监护仪网口数据地址   命令ID   0x0263
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_GetMindaryIP(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Get_Mindary_ip, databyte);
	}
	
	
	/**
	 * 设置本地网口IP地址    命令ID 0x0264
	 * @param portocolVersion     协议版本
	 * @param hospitalid          医院编号
	 * @param deviceid            设备编号
	 * @param databyte            参数
	 * @return
	 */
	public static byte[] createcmd_SetLanPar(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Set_Lan_ip, databyte);
	}
	/**
	 * 读取本地网口IP地址    命令ID  0x0265
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_GetLanPar(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Get_Lan_ip, databyte);
	}
	
	/**
	 * 设置本地网口IP地址    命令ID 0x0266
	 * @param portocolVersion     协议版本
	 * @param hospitalid          医院编号
	 * @param deviceid            设备编号
	 * @param databyte            参数
	 * @return
	 */
	public static byte[] createcmd_SetLanMac(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Set_Lan_mac, databyte);
	}
	/**
	 * 读取本地网口IP地址    命令ID  0x0267
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_GetLanMac(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Get_Lan_mac, databyte);
	}
	
	
	
	
	/**
	 * 读取呼吸机数据  命令ID   0x0301
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_ReadChannelData(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Read_ChannelData, databyte);
	} 
	/**
	 * 设置呼吸机通道   命令ID  0x0302
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_SetChannel0302(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Set_Channel_0302, databyte);
	}
	/**
	 * 设置呼吸机通道   命令ID  0x0302
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_SetChannel0303(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Set_Channel_0303, databyte);
	}
	/**
	 * 设置呼吸机通道   命令ID  0x0302
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_SetChannel0304(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Set_Channel_0304, databyte);
	}
	/**
	 * 设置呼吸机通道   命令ID  0x0302
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_SetChannel0305(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Set_Channel_0305, databyte);
	}
	/**
	 * 设置呼吸机通道   命令ID  0x0302
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_SetChannel0306(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Set_Channel_0306, databyte);
	}
	/**
	 * 设置呼吸机通道   命令ID  0x0302
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_SetChannel0307(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Set_Channel_0307, databyte);
	}
	/**
	 * 设置呼吸机通道   命令ID  0x0302
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_SetChannel0308(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Set_Channel_0308, databyte);
	}
	/**
	 * 设备重启    命令ID  0x0310
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_RestartDevice(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Restart_Device, databyte);
	}
	/**
	 * 读取呼吸机类型  命令ID  0x0311
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_GetRespiratorBrandType(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Get_RespiratorBrandType, databyte);
	}
	/**
	 * 设置呼吸机类型        命令ID  0x0312
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_SetRespiratorBrandType(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Set_RespiratorBrandType, databyte);
	}
	/**
	 * 读取bootloader版本  命令ID  0x0313
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[]  createcmd_GetBootloaderversion(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Get_Bootloader_version, databyte);
	}
	/**
	 * 设置报警状态         命令ID   0x0314
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_SetAlterStatus(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Set_AlterStatus, databyte);
	}
	/**
	 * 设置串口数据上报    命令ID   0x0315
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_SetSerialPortUpload(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Set_Serialport_upload, databyte);
	}
	/**
	 * 启动呼吸机波形数据指令  命令ID  0x0316 
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_StartWavedata(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Start_Wavedata, databyte);
	} 
	/**
	 * 关闭呼吸机波形数据  命令ID   0x0317 
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_StopWavedata(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Stop_Wavedata, databyte);
	}
	/**
	 * 设置采集器辅助wifi   命令ID  0x0318 
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_SetBackupWifiInfo(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Set_Backup_WifiInfo, databyte);
	}
	/**
	 * 读取采集器辅助wifi  命令ID  0x0319
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] crreatecmd_GetBackupWifiInfo(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Get_Backup_WifiInfo, databyte);
	}
	/**
	 * 采集器电源状态   命令ID  0x0380
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_DevicePowerStatus(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Device_PowerStatus, databyte);
	}
	
	/**
	 * 设置呼吸机通道   命令ID  0x0402
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_SetChannel0402(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Set_Channel_0402, databyte);
	}
	/**
	 * 设置呼吸机通道   命令ID  0x0402
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_SetChannel0403(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Set_Channel_0403, databyte);
	}
	/**
	 * 设置呼吸机通道   命令ID  0x0402
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_SetChannel0404(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Set_Channel_0404, databyte);
	}
	/**
	 * 设置呼吸机通道   命令ID  0x0402
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_SetChannel0405(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Set_Channel_0405, databyte);
	}
	/**
	 * 设置呼吸机通道   命令ID  0x0402
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_SetChannel0406(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Set_Channel_0406, databyte);
	}
	/**
	 * 设置呼吸机通道   命令ID  0x0402
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_SetChannel0407(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Set_Channel_0407, databyte);
	}
	/**
	 * 设置呼吸机通道   命令ID  0x0402
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_SetChannel0408(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Set_Channel_0408, databyte);
	}
	/**
	 * 设置呼吸机通道   命令ID  0x0402
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_SetChannel0409(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Set_Channel_0409, databyte);
	}
	/**
	 * 设置呼吸机通道   命令ID  0x0402
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_SetChannel0410(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Set_Channel_0410, databyte);
	}
	/**
	 * 设置呼吸机通道   命令ID  0x0402
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_SetChannel0411(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Set_Channel_0411, databyte);
	}
	/**
	 * 设置呼吸机通道   命令ID  0x0402
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_SetChannel0412(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Set_Channel_0412, databyte);
	}
	/**
	 * 设置呼吸机通道   命令ID  0x0402
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_SetChannel0413(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Set_Channel_0413, databyte);
	}
	/**
	 * 设置呼吸机通道   命令ID  0x0402
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_SetChannel0414(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Set_Channel_0414, databyte);
	}
	/**
	 * 设置呼吸机通道   命令ID  0x0402
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_SetChannel0415(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Set_Channel_0415, databyte);
	}
	/**
	 * 设置呼吸机通道   命令ID  0x0402
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_SetChannel0416(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Set_Channel_0416, databyte);
	}
	/**
	 * 设置呼吸机通道   命令ID  0x0402
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_SetChannel0417(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Set_Channel_0417, databyte);
	}
	/**
	 * 设置呼吸机通道   命令ID  0x0402
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_SetChannel0418(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Set_Channel_0418, databyte);
	}
	/**
	 * 设置呼吸机通道   命令ID  0x0402
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_SetChannel0419(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Set_Channel_0419, databyte);
	}
	/**
	 * 设置呼吸机全参数   命令ID  0x042a
	 * @param portocolVersion      协议版本
	 * @param hospitalid           医院编号
	 * @param deviceid             设备编号
	 * @param databyte             参数
	 * @return
	 */
	public static byte[] createcmd_SetWholeParameter(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Set_WholeParameter, databyte);
	}
    /**
            *   同步服务器时间 
     * @param portocolVersion
     * @param hospitalid
     * @param deviceid
     * @param databyte
     * @return
     */
	public static byte[] createcmd_configDateTime(int portocolVersion, int hospitalid, int deviceid,byte[] databyte) {
		return CreateCmd(portocolVersion, hospitalid, deviceid, CMDID.CMD_Config_Date, databyte);
	}
}
