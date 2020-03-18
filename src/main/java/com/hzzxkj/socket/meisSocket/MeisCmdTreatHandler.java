package com.hzzxkj.socket.meisSocket;

import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.hzzxkj.dao.*;
import com.hzzxkj.models.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.hzzxkj.BootApplication;
import com.hzzxkj.LoadinProperties;
import com.hzzxkj.SpringBeanUtil;
import com.hzzxkj.Logger.HzzxLogger;
import com.hzzxkj.cmdAnaliser.*;
import com.hzzxkj.cmdAnaliser.RespiratorModel.Evita_ChannelModel;
import com.hzzxkj.cmdAnaliser.RespiratorModel.Evita_RespiratorModel;
import com.hzzxkj.cmdAnaliser.RespiratorModel.Minary_ChannelModel;
import com.hzzxkj.cmdAnaliser.RespiratorModel.Minary_RespiratorModel;
import com.hzzxkj.cmdAnaliser.RespiratorModel.Serv_RespiratorModel;
import com.hzzxkj.cmdAnaliser.cmdModel.*;
import com.hzzxkj.mongodb.dao.ClientCurrentParamDao;
import com.hzzxkj.mongodb.dao.ClientFalutStatusDao;
import com.hzzxkj.mongodb.dao.ClientParamDao;
import com.hzzxkj.mongodb.dao.ClientStatusDao;
import com.hzzxkj.mongodb.dao.WaveDataDao;
import com.hzzxkj.mongodb.dao.WholeParamDataDao;
import com.hzzxkj.mongodb.entity.ChannelWaveData;
import com.hzzxkj.mongodb.entity.ClientCurrentParam;
import com.hzzxkj.mongodb.entity.ClientFalutStatus;
import com.hzzxkj.mongodb.entity.ClientParam;
import com.hzzxkj.mongodb.entity.ClientParamValue;
import com.hzzxkj.mongodb.entity.ClientStatus;
import com.hzzxkj.mongodb.entity.WaveData;
import com.hzzxkj.mongodb.entity.WholeParamData;
import com.hzzxkj.socket.meisJavaSocket.MeisJavaChannelMap;
import com.hzzxkj.socket.meisJavaSocket.MeisJavaSocketServerInHandler;
import com.hzzxkj.utils.DateUtils;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.beans.factory.annotation.Autowired;

public class MeisCmdTreatHandler extends ChannelHandlerAdapter {

	/**
	 * 是否已发送通道配置
	 */

	public boolean sendchannel = false;

	private HashMap<String, String> respiritorMap = new HashMap<>();

	private boolean isSetRtc = false;

	private Date lastSetRtcTime;

	private boolean isSaveWork = false;

	private int preIsWork =0;// 记录上次设备的工作状态
	
	private int preIsWorkByLog = 0; //记录日志中读取出来的上一个工作状态

	private boolean isSaveFault = false;

	private int preIsFault;// 记录上次设备的故障情况

	private boolean isSaveOpen = false;

	private int preIsOpen;// 记录上次设备的开关机状态

	private String mHospitalId, mDeviceID, mWifiMac;
    
	private ArrayList<Evita_ChannelModel> ChannelModelList; //存储Evita波形图的通道集合
	
	private ArrayList<Minary_ChannelModel> ChannelModelList_minary; //存储迈瑞波形图的通道集合
	/**
	 * 设备状态表操作类
	 */
	@Autowired
	private SysAttrGroupMapper attrGroupMapper;

	@Autowired
	private MdDeviceStatusMapper mdDeviceStatusMapper;

	public ChannelHandlerContext mctx;
	/**
	 * 用于保存每台设备连接时的key
	 */
	String strKey = "NettyLog";
	/**
	 * 数据库操作类工厂
	 */
	public SqlSessionFactory o = (SqlSessionFactory) SpringBeanUtil.getBean("sqlSessionFactory");
	/**
	 * 设备状态实体
	 */
	public ClientInfo cInfo;
	/**
	 * 设备状态表操作类
	 */
	public ClientInfoMapper cinfoMapper;
	/**
	 *  add by liujun  2019-12-20 手机给设备报故障，用于记录devicestatus状态，避免手机报故障后采集器的心跳协议会将clientinfo中的falut状态覆盖掉
	 */
	public DeviceStatus dStatus;

	public DeviceStatusMapper dStatusMapper;
	
	/**
	 * 删除日志是否成功
	 */
	public boolean deleteLogSuccess = true;
	/**
	 * mongodb操作类
	 */
	private ClientStatusDao cd = BootApplication.applicationContext.getBean(ClientStatusDao.class);

	/**
	 * 设备 状态实体，mongodb使用
	 */
	private ClientStatus cs;

	/**
	 * mongodb操作类
	 */
	private ClientFalutStatusDao clientFalutStatusDao = BootApplication.applicationContext
			.getBean(ClientFalutStatusDao.class);

	private ClientCurrentParamDao clientCurrentParamDao = BootApplication.applicationContext
			.getBean(ClientCurrentParamDao.class);

	private ClientParamDao clientParamDao = BootApplication.applicationContext.getBean(ClientParamDao.class);

	/**
	 * 设备 状态实体，mongodb使用
	 */
	private ClientFalutStatus clientFalutStatus;

	/**
	 * 当前波形数据
	 */
	private WaveData currentWaveData;
	/**
	 * 波形数据操作类
	 */
	private WaveDataDao waveDataDao = BootApplication.applicationContext.getBean(WaveDataDao.class);
	/**
	 * 全参数操作
	 */
	private WholeParamData wholeParamData;

	private WholeParamDataDao wholeParamDataDao = BootApplication.applicationContext.getBean(WholeParamDataDao.class);

	private Map<Integer, String> protocolMap;

	private Date ticknumToDate(int ticknum) throws Exception {
		DateFormat ymdhmsFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long nowTimeLong = new Long(ticknum).longValue() * 1000;
		String nowTimeStr = ymdhmsFormat.format(nowTimeLong);
		Date nowTimeDate = ymdhmsFormat.parse(nowTimeStr);
		return nowTimeDate;
	}

	private String DateToString(Date d) {
		DateFormat ymdhmsFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return ymdhmsFormat.format(d);
	}

	/**
	 * 下发呼吸机通道指令
	 * 
	 * @param sysAttrGroup
	 */
	private void sendChannelByDeviceID(SysAttrGroup sysAttrGroup) {
		ArrayList<Byte> databyte = new ArrayList<Byte>();
		byte[] fre = CmdUtils.IntegerToByteArray2(sysAttrGroup.getAgFrequency()); // 平率
		databyte.addAll(CmdUtils.ArrayToList(fre));
		String[] sysAttrID = sysAttrGroup.getSysattrids().split(",");
		for (int i = 0; i < sysAttrID.length; i++) {
			byte[] channel = CmdUtils.IntegerToByteArray2(Integer.valueOf(sysAttrID[i]));
			databyte.addAll(CmdUtils.ArrayToList(channel));
		}
		respiritorMap.put(sysAttrGroup.getAgGroupno(), sysAttrGroup.getSysattrids());
		byte[] temp = new byte[] {};
		switch (sysAttrGroup.getAgGroupno()) {
		case "0302":
			temp = CmdFactory.createcmd_SetChannel0302(0, 0, 0, CmdUtils.ListToArray(databyte));
			break;
		case "0303":
			temp = CmdFactory.createcmd_SetChannel0303(0, 0, 0, CmdUtils.ListToArray(databyte));
			break;
		case "0304":
			temp = CmdFactory.createcmd_SetChannel0304(0, 0, 0, CmdUtils.ListToArray(databyte));
			break;
		case "0305":
			temp = CmdFactory.createcmd_SetChannel0305(0, 0, 0, CmdUtils.ListToArray(databyte));
			break;
		case "0306":
			temp = CmdFactory.createcmd_SetChannel0306(0, 0, 0, CmdUtils.ListToArray(databyte));
			break;
		case "0307":
			temp = CmdFactory.createcmd_SetChannel0307(0, 0, 0, CmdUtils.ListToArray(databyte));
			break;
		case "0308":
			temp = CmdFactory.createcmd_SetChannel0308(0, 0, 0, CmdUtils.ListToArray(databyte));
			break;
		case "0402":
			temp = CmdFactory.createcmd_SetChannel0402(0, 0, 0, CmdUtils.ListToArray(databyte));
			break;
		case "0403":
			temp = CmdFactory.createcmd_SetChannel0403(0, 0, 0, CmdUtils.ListToArray(databyte));
			break;
		case "0404":
			temp = CmdFactory.createcmd_SetChannel0404(0, 0, 0, CmdUtils.ListToArray(databyte));
			break;
		case "0405":
			temp = CmdFactory.createcmd_SetChannel0405(0, 0, 0, CmdUtils.ListToArray(databyte));
			break;
		case "0406":
			temp = CmdFactory.createcmd_SetChannel0406(0, 0, 0, CmdUtils.ListToArray(databyte));
			break;
		case "0407":
			temp = CmdFactory.createcmd_SetChannel0407(0, 0, 0, CmdUtils.ListToArray(databyte));
			break;
		case "0408":
			temp = CmdFactory.createcmd_SetChannel0408(0, 0, 0, CmdUtils.ListToArray(databyte));
			break;
		case "0409":
			temp = CmdFactory.createcmd_SetChannel0409(0, 0, 0, CmdUtils.ListToArray(databyte));
			break;
		case "0410":
			temp = CmdFactory.createcmd_SetChannel0410(0, 0, 0, CmdUtils.ListToArray(databyte));
			break;
		case "0411":
			temp = CmdFactory.createcmd_SetChannel0411(0, 0, 0, CmdUtils.ListToArray(databyte));
			break;
		case "0412":
			temp = CmdFactory.createcmd_SetChannel0412(0, 0, 0, CmdUtils.ListToArray(databyte));
			break;
		case "0413":
			temp = CmdFactory.createcmd_SetChannel0413(0, 0, 0, CmdUtils.ListToArray(databyte));
			break;
		case "0414":
			temp = CmdFactory.createcmd_SetChannel0414(0, 0, 0, CmdUtils.ListToArray(databyte));
			break;
		case "0415":
			temp = CmdFactory.createcmd_SetChannel0415(0, 0, 0, CmdUtils.ListToArray(databyte));
			break;
		case "0416":
			temp = CmdFactory.createcmd_SetChannel0416(0, 0, 0, CmdUtils.ListToArray(databyte));
			break;
		case "0417":
			temp = CmdFactory.createcmd_SetChannel0417(0, 0, 0, CmdUtils.ListToArray(databyte));
			break;
		case "0418":
			temp = CmdFactory.createcmd_SetChannel0418(0, 0, 0, CmdUtils.ListToArray(databyte));
			break;
		case "0419":
			temp = CmdFactory.createcmd_SetChannel0419(0, 0, 0, CmdUtils.ListToArray(databyte));
			break;
		default:
			break;
		}
		SendMsg(mctx, temp, "发送呼吸机通道指令");

	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {

	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {

	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		mctx = ctx;
		try {
			CmdModel model = (CmdModel) msg;
			switch (model.getProtocolVersion()) {
			case 0:// 老采集器协议用hospitalID+deviceID
				strKey = String.valueOf(model.getHospitalID()) + "_" + String.valueOf(model.getDeviceID());
				break;
			case 1:// 新采集器协议 用WiFi的Mac地址作为主键
				strKey = model.getWifiMac();
				break;
			default:
				break;
			}

			
			if (!sendchannel) {
				// * 发送设备配置的通道
				SysAttrGroup sysAttrGroup = new SysAttrGroup();
				sysAttrGroup.setAgDeviceId(model.getDeviceID());
				try {
					List<SysAttrGroup> sysAttrGrouplist = attrGroupMapper
							.selectBySysAttrGroupWhithDeviceID(sysAttrGroup);
					if (sysAttrGrouplist == null || sysAttrGrouplist.size() == 0) {
						HzzxLogger.error("设备未设置通道相关分组信息：", strKey);
					} else {
						for (SysAttrGroup sysAG : sysAttrGrouplist) {
							sendChannelByDeviceID(sysAG);// 调用下发呼吸机通道指令
						}
					}
					sendchannel = true;
				} catch (Exception e) {
					HzzxLogger.error("操作数据库失败：", e, strKey);
				}
			}

			byte[] sendbyte;
			switch (model.getCmd()) {
			case CMD_All_Status_ByBoard:
				HzzxLogger.debug("指令解析完成: 心跳协议", strKey);
				_0x0201Command _0x0201command = (_0x0201Command) model;
				// 查看是否有日志可读
				if (_0x0201command.logCount > 0) {
					HzzxLogger.debug("日志数=" + String.valueOf(_0x0201command.logCount), strKey);
					byte[] cmdbyte = new byte[2];

					cmdbyte = CmdUtils.IntegerToByteArray2(1);
					sendbyte = CmdFactory.CreateCmd(_0x0201command.getProtocolVersion(), _0x0201command.getHospitalID(),
							_0x0201command.getDeviceID(), CMDID.CMD_Get_EquipmentLog, cmdbyte);

					SendMsg(ctx, sendbyte, "发送读日志指令:");
//					ctx.writeAndFlush(Unpooled.copiedBuffer(sendbyte));
//					HzzxLogger.debug("发送读日志指令:" + CmdUtils.ByteArrayToHexString(sendbyte), strKey);

				} else {
					if (!isSetRtc) {
						Date date = new Date();
						int tick = (int) DateUtils.xDateSeconds(date);
						byte[] timebyte = CmdFactory.createcmd_configDateTime(_0x0201command.getProtocolVersion(),
								_0x0201command.getHospitalID(), _0x0201command.getDeviceID(),
								CmdUtils.IntegerToByteArray4(tick));
						SendMsg(ctx, timebyte, "发送同步时间指令:");
//						ctx.writeAndFlush(timebyte);
//						HzzxLogger.debug("发送同步时间指令:" + CmdUtils.ByteArrayToHexString(timebyte), strKey);
						lastSetRtcTime = new Date();
						isSetRtc = true;
					} else {
						int pasthour = (int) DateUtils.pastHour(lastSetRtcTime);
						if (pasthour > LoadinProperties.asyncTimeFrequency) {
							Date date = new Date();
							int tick = (int) DateUtils.xDateSeconds(date);
							byte[] timebyte = CmdFactory.createcmd_configDateTime(_0x0201command.getProtocolVersion(),
									_0x0201command.getHospitalID(), _0x0201command.getDeviceID(),
									CmdUtils.IntegerToByteArray4(tick));
							SendMsg(ctx, timebyte, "发送同步时间指令:");
//							ctx.writeAndFlush(timebyte);
//							HzzxLogger.debug("发送同步时间指令:" + CmdUtils.ByteArrayToHexString(timebyte), strKey);
							lastSetRtcTime = new Date();
						}
					}
				}
				mHospitalId = String.valueOf(_0x0201command.getHospitalID());
				mDeviceID = String.valueOf(_0x0201command.getDeviceID());
				mWifiMac = String.valueOf(_0x0201command.getWifiMac());

				//查看devicestatus表中的状态 
				
				dStatus = new DeviceStatus();
				try {
					mdDeviceStatusMapper.selectByPrimaryKey(_0x0201command.getDeviceID());
					dStatus = dStatusMapper.selectBydeviceID(String.valueOf(_0x0201command.getDeviceID()));
				} catch (Exception e) {
					HzzxLogger.error("操作数据库失败：", e, strKey);
				}
				
				
				// 更新client_info表的设备状态

				cInfo = new ClientInfo();
				cInfo.setIsWork(String.valueOf(_0x0201command.workStatus));
				cInfo.setIsOpen(String.valueOf(_0x0201command.equipmentStatus));
				cInfo.setLogRemainder(_0x0201command.logCount);
				cInfo.setApMac(String.valueOf(_0x0201command.apMac));
				cInfo.setIsFault(String.valueOf(_0x0201command.faultStatus));
				
				if (dStatus!=null && dStatus.getDeviceId()!=null) {
					if(dStatus.getDeviceFault()==1) {
						cInfo.setIsFault("1");
						HzzxLogger.debug("devicestatus故障1 ，修改实时故障为1", strKey);
					}
				}
				
				cInfo.setIsOnline("1");
				cInfo.setLastOnline(new Date());
				cInfo.setHospitalId(String.valueOf(_0x0201command.getHospitalID()));
				cInfo.setDeviceId(String.valueOf(_0x0201command.getDeviceID()));

				try {
					int count = cinfoMapper.existsClinetInfo(cInfo);
					if (count == 0) {
						cInfo.setId(String.valueOf(UUID.randomUUID()));
						cinfoMapper.insertSelective(cInfo);
					} else {
						
						int i = cinfoMapper.updateByhospitalanddevice(cInfo);

						if (i > 0) {
							HzzxLogger.debug("更新cleint_info表成功", strKey);
						} else {
							HzzxLogger.debug("更新cleint_info表失败", strKey);
						}
					}
//
//					if (!isSaveWork && (preIsWork !=_0x0201command.getWorkStatus())) { 
//						ClientStatus clientStatus= new ClientStatus();
//						clientStatus.setCreateTime(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
//						clientStatus.setUpdateTime(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
//						clientStatus.setHospitalId(String.valueOf(_0x0201command.getHospitalID()));
//						clientStatus.setDeviceId(String.valueOf(_0x0201command.getDeviceID()));
//						clientStatus.setEventID(CMDID.CMD_Equipment_WorkStatus_ByBoard.toString());
//						clientStatus.setValue(String.valueOf(_0x0201command.getWorkStatus()));
//						clientStatus.setTickNum(0);
//						clientStatus.setSource("Status");
//						clientStatus.setEventTime(new Date()); 
//						cd.insertDemo(clientStatus);
//						preIsWork=_0x0201command.getWorkStatus();
//						isSaveWork=false;
//					}
//					if (!isSaveOpen && (preIsOpen !=_0x0201command.getEquipmentStatus())) { 
//						ClientStatus clientStatus= new ClientStatus();
//						clientStatus.setCreateTime(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
//						clientStatus.setUpdateTime(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
//						clientStatus.setHospitalId(String.valueOf(_0x0201command.getHospitalID()));
//						clientStatus.setDeviceId(String.valueOf(_0x0201command.getDeviceID()));
//						clientStatus.setEventID(CMDID.CMD_Equipment_OnOff_ByBoard.toString());
//						clientStatus.setValue(String.valueOf(_0x0201command.getEquipmentStatus()));
//						clientStatus.setTickNum(0);
//						clientStatus.setEventTime(new Date()); 
//						clientStatus.setSource("Status");
//						cd.insertDemo(clientStatus);
//						preIsOpen=_0x0201command.getEquipmentStatus();
//						isSaveOpen=false;
//					}
//					 
//					if (!isSaveFault && (preIsFault !=_0x0201command.getFaultStatus())) {  
//						clientFalutStatus.setCreateTime(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
//						clientFalutStatus.setUpdateTime(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
//						clientFalutStatus.setHospitalId(String.valueOf(_0x0201command.getHospitalID()));
//						clientFalutStatus.setDeviceId(String.valueOf(_0x0201command.getDeviceID()));
//						clientFalutStatus.setEventID(CMDID.CMD_Equipment_FaultStatus_ByBoard.toString());
//						clientFalutStatus.setValue(String.valueOf(_0x0201command.getFaultStatus()));
//						clientFalutStatus.setTickNum(0);
//						clientFalutStatus.setSource("Status");
//						clientFalutStatus.setEventTime(new Date()); 
//						clientFalutStatusDao.insertDemo(clientFalutStatus);
//						preIsFault=_0x0201command.getFaultStatus();
//						isSaveFault=false;
//					} 

				} catch (Exception e) {
					// TODO Auto-generated catch block
					HzzxLogger.error("操作数据库失败：", e, strKey);
				}

				break;
			case CMD_Get_EquipmentLog:
				HzzxLogger.debug("指令解析完成: 读取日志指令", strKey);
				_0x0202Command _0x0202Command = (_0x0202Command) model;
				if (deleteLogSuccess) {
					
					//如果是工作状态日志，则必须记录此次状态值，当读到关机日志时，需要根据之前记录的工作
					//状态来决定是否插入一挑待机记录，预防工作明细不准确
					// add liujun  2019-12-05
					//if (_0x0202Command.getEventID()==2) {
					//	preIsWorkByLog =Integer.valueOf((_0x0202Command.getDataByte()[7] & 0xff));
					//}
					if (_0x0202Command.getEventID()==1) {
						//if (preIsWorkByLog==1 && (_0x0202Command.getDataByte()[7] & 0xff)==0) {
						if ((_0x0202Command.getDataByte()[7] & 0xff)==0) {
							cs = new ClientStatus();
							cs.setSource("log");
							cs.setHospitalId(String.valueOf(_0x0202Command.getHospitalID()));
							cs.setCreateTime(DateToString(new Date()));
							cs.setDeviceId(String.valueOf(_0x0202Command.getDeviceID()));
							cs.setEventID(CMDEVENTID.EventIdToEnum(2).toString());
							cs.setEventTime(ticknumToDate(_0x0202Command.getTickNum()));
							cs.setGuid(String.valueOf(UUID.randomUUID()));
							cs.setState("0");
							cs.setTickNum(_0x0202Command.getTickNum());
							cs.setUpdateTime(DateToString(new Date()));
							cs.setValue("0");
							cd.insertDemo(cs);
							HzzxLogger.debug("日志模拟待机日志插入mongodb数据库成功", strKey);
							preIsWorkByLog=0;
						}
					}
					//--------------------------------------------------------------------
					
					// 插入mongodb数据库
					cs = new ClientStatus();
					cs.setSource("log");
					cs.setHospitalId(String.valueOf(_0x0202Command.getHospitalID()));
					cs.setCreateTime(DateToString(new Date()));
					cs.setDeviceId(String.valueOf(_0x0202Command.getDeviceID()));
					cs.setEventID(CMDEVENTID.EventIdToEnum(_0x0202Command.getEventID()).toString());
					cs.setEventTime(ticknumToDate(_0x0202Command.getTickNum()));
					cs.setGuid(String.valueOf(UUID.randomUUID()));
					cs.setState("0");
					cs.setTickNum(_0x0202Command.getTickNum());
					cs.setUpdateTime(DateToString(new Date()));
					cs.setValue(String.valueOf((_0x0202Command.getDataByte()[7] & 0xff)));
					cd.insertDemo(cs);
					HzzxLogger.debug("日志插入mongodb数据库成功", strKey);
					
					
				}
				// 删除此条日志
				HzzxLogger.debug("上条日志删除成功", strKey);
				sendbyte = CmdFactory.CreateCmd(_0x0202Command.getProtocolVersion(), _0x0202Command.getHospitalID(),
						_0x0202Command.getDeviceID(), CMDID.CMD_Delete_Equipment_One_Data,
						_0x0202Command.getDataByte());
				SendMsg(ctx, sendbyte, "发送删除指令");
//				ctx.writeAndFlush(Unpooled.copiedBuffer(sendbyte));
//				HzzxLogger.debug("发送删除指令" + CmdUtils.ByteArrayToHexString(sendbyte), strKey);
				deleteLogSuccess = false;
				break;
			case CMD_Delete_Equipment_One_Data:
				HzzxLogger.debug("指令解析完成: 删除单条日志指令", strKey);
				_0x0203Command _0x0203Command = (_0x0203Command) model;
				if (_0x0203Command.isDeleteSuccess()) {
					HzzxLogger.debug("删除日志成功", strKey);
					deleteLogSuccess = true;
				} else {
					HzzxLogger.debug("删除日志失败", strKey);
					deleteLogSuccess = false;
				}
				break;
			case CMD_Delete_Equipment_All_Data:
				HzzxLogger.debug("指令解析完成: 删除所有日志指令", strKey);
				_0x0204Command _0x0204Command = (_0x0204Command) model;
				if (_0x0204Command.isDeleteSuccess()) {
					HzzxLogger.debug("删除所有日志成功", strKey);
				} else {
					HzzxLogger.debug("删除所有日志失败", strKey);
				}
				break;
			case CMD_Config_Parameters:
				HzzxLogger.debug("指令解析完成: 设置采集器参数指令", strKey);
				_0x0205Command _0x0205Command = (_0x0205Command) model;
				if (_0x0205Command.configSuccess) {
					HzzxLogger.debug("设置成功", strKey);
				} else {
					HzzxLogger.debug("设置失败", strKey);
				}
				break;
			case CMD_Config_Date:
				HzzxLogger.debug("指令解析完成: 设置采集器时间指令", strKey);
				_0x0207Command _0x0207Command = (_0x0207Command) model;
				if (_0x0207Command.isSuccess()) {
					HzzxLogger.debug("设置成功", strKey);
				} else {
					HzzxLogger.debug("设置失败", strKey);
				}
				break;
			case CMD_Get_Parameters:
				HzzxLogger.debug("指令解析完成: 读取采集器参数指令", strKey);
				_0x0206Command _0x0206Command = (_0x0206Command) model;
				break;
			case CMD_Get_Fireware_Version:
				HzzxLogger.debug("指令解析完成: 读取版本指令", strKey);
				_0x020cCommand _0x020cCommand = (_0x020cCommand) model;
				break;
			case CMD_Equipment_ClearFaultStatus_ByBoard:
				HzzxLogger.debug("指令解析完成: 清除报警指令", strKey);
				SendBackToJava(model);
				_0x0214Command _0x0214Command = (_0x0214Command) model;
				clientFalutStatus = new ClientFalutStatus();
				if (_0x0214Command.clearSuccess) {
					HzzxLogger.debug("清除故障成功", strKey);
					clientFalutStatus.setValue("0");
					cInfo = new ClientInfo();
					cInfo.setIsFault("0");
					cInfo.setHospitalId(String.valueOf(_0x0214Command.getHospitalID()));
					cInfo.setDeviceId(String.valueOf(_0x0214Command.getDeviceID()));

					try {
						SqlSession session = o.openSession(true);
						cinfoMapper = session.getMapper(ClientInfoMapper.class);
						int i = cinfoMapper.updateByhospitalanddevice(cInfo);
						session.close();
						if (i > 0) {
							HzzxLogger.debug("更新cleint_info表成功", strKey);
						} else {
							HzzxLogger.debug("更新cleint_info表失败", strKey);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						HzzxLogger.error("操作数据库失败：", e, strKey);
					}
//					cinfoMapper = o.openSession().getMapper(ClientInfoMapper.class);
//					
//					//o.openSession().selectList<>("select * from ccc");
//					//List<Map<String,Object>> sss=	o.openSession().selectList("select * from client_info");

				} else {
					HzzxLogger.debug("清除故障失败", strKey);
				}

				clientFalutStatus.setHospitalId(String.valueOf(_0x0214Command.getHospitalID()));
				clientFalutStatus.setCreateTime(DateToString(new Date()));
				clientFalutStatus.setDeviceId(String.valueOf(_0x0214Command.getDeviceID()));
				clientFalutStatus.setEventID(CMDID.CMD_Equipment_FaultStatus_ByBoard.toString());
				clientFalutStatus.setSource("event");
				clientFalutStatus.setEventTime(new Date());
				clientFalutStatus.setGuid(String.valueOf(UUID.randomUUID()));
				clientFalutStatus.setState("0");
				clientFalutStatus.setTickNum(_0x0214Command.getTickNum());
				clientFalutStatus.setUpdateTime(DateToString(new Date()));
				// clientFalutStatus.setValue(String.valueOf((_0x0214Command.getDataByte()[7] &
				// 0xff)));

				clientFalutStatusDao.insertDemo(clientFalutStatus);
				isSaveFault = true;
				HzzxLogger.debug("日志插入mongodb数据库成功", strKey);

				break;
			case CMD_Set_Baud:
				HzzxLogger.debug("指令解析完成: 切换串口指令", strKey);
				_0x0219Command _0x0219Command = (_0x0219Command) model;
				if (_0x0219Command.setSuccess) {
					HzzxLogger.debug("切换成功", strKey);
				} else {
					HzzxLogger.debug("切换失败", strKey);
				}
				break;
			case CMD_Equipment_MAC:
				HzzxLogger.debug("指令解析完成: 读wifimac指令", strKey);
				_0x021cCommand _0x021cCommand = (_0x021cCommand) model;

				break;
			case CMD_Set_NetPar:
				HzzxLogger.debug("指令解析完成: 设置采集器网络参数指令", strKey);
				_0x021dCommand _0x021dCommand = (_0x021dCommand) model;
				if (_0x021dCommand.isSuccess) {
					HzzxLogger.debug("设置成功", strKey);
				} else {
					HzzxLogger.debug("设置失败", strKey);
				}
				break;
			case CMD_Get_NetPar:
				HzzxLogger.debug("指令解析完成: 读取采集器网络参数指令", strKey);
				_0x021eCommand _0x021eCommand = (_0x021eCommand) model;
				break;
			
			case CMD_Update_Firmware:
				HzzxLogger.debug("指令解析完成: 升级固件指令", strKey);
				_0x021fCommand _0x021fCommand = (_0x021fCommand) model;
				if (_0x021fCommand.isSuccess) {
					HzzxLogger.debug("设置成功", strKey);
				} else {
					HzzxLogger.debug("设置失败", strKey);
				}
				break;
			case CMD_Equipment_OnOff_ByBoard:
				HzzxLogger.debug("指令解析完成: 呼吸机开关机指令", strKey);
				_0x0221Command _0x0221Command = (_0x0221Command) model;

				cInfo = new ClientInfo();
				cInfo.setIsOpen(String.valueOf(_0x0221Command.getOpenCloseStatus()));
				cInfo.setHospitalId(String.valueOf(_0x0221Command.getHospitalID()));
				cInfo.setDeviceId(String.valueOf(_0x0221Command.getDeviceID()));
                if (_0x0221Command.getOpenCloseStatus()==0) {
                	cInfo.setIsWork("0");
                }
				try {
					SqlSession session = o.openSession(true);
					cinfoMapper = session.getMapper(ClientInfoMapper.class);
					int i = cinfoMapper.updateByhospitalanddevice(cInfo);
					session.close();
					if (i > 0) {
						HzzxLogger.debug("更新cleint_info表成功", strKey);
					} else {
						HzzxLogger.debug("更新cleint_info表失败", strKey);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					HzzxLogger.error("操作数据库失败：", e, strKey);
				}
                //------------------------------------------------------------------------------//
				/**
				 * add 刘俊 2019-12-05 当接受到关机指令时，必须判断上一个状态是否工作
				 * 如果是工作，必须插入一个待机指令，否则工作明细不准确
				 * */
				 //if(preIsWork==1 || preIsWorkByLog==1)
				 //{
					    cs = new ClientStatus();
						cs.setSource("event");
						cs.setHospitalId(String.valueOf(_0x0221Command.getHospitalID()));
						cs.setCreateTime(DateToString(new Date()));
						cs.setDeviceId(String.valueOf(_0x0221Command.getDeviceID()));
						cs.setEventID(CMDID.CMD_Equipment_WorkStatus_ByBoard.toString());
						cs.setEventTime(ticknumToDate(_0x0221Command.getTickNum()));
						cs.setTickNum(_0x0221Command.getTickNum());
						cs.setUpdateTime(DateToString(new Date()));
						cs.setValue("0");
						cd.insertDemo(cs);
						preIsWork = 0;
						preIsWorkByLog=0;
						HzzxLogger.debug("模拟待机日志插入mongodb数据库成功", strKey);
				 //}
				//-----------------------------------------------------------------------------//
				
				cs = new ClientStatus();
				cs.setSource("event");
				cs.setHospitalId(String.valueOf(_0x0221Command.getHospitalID()));
				cs.setCreateTime(DateToString(new Date()));
				cs.setDeviceId(String.valueOf(_0x0221Command.getDeviceID()));
				cs.setEventID(CMDID.CMD_Equipment_OnOff_ByBoard.toString());
				cs.setEventTime(ticknumToDate(_0x0221Command.getTickNum()));
				cs.setTickNum(_0x0221Command.getTickNum());
				cs.setUpdateTime(DateToString(new Date()));
				cs.setValue(String.valueOf(_0x0221Command.getOpenCloseStatus()));
				cd.insertDemo(cs);
				isSaveOpen = true;
				HzzxLogger.debug("日志插入mongodb数据库成功", strKey);
				break;
			case CMD_Equipment_WorkStatus_ByBoard:
				HzzxLogger.debug("指令解析完成: 呼吸机工作状态指令", strKey);
				_0x0222Command _0x0222Command = (_0x0222Command) model;

				cInfo = new ClientInfo();
				cInfo.setIsWork(String.valueOf(_0x0222Command.getWorkStatus()));
				cInfo.setHospitalId(String.valueOf(_0x0222Command.getHospitalID()));
				cInfo.setDeviceId(String.valueOf(_0x0222Command.getDeviceID()));
				try {
					SqlSession session = o.openSession(true);
					cinfoMapper = session.getMapper(ClientInfoMapper.class);
					int i = cinfoMapper.updateByhospitalanddevice(cInfo);
					session.close();
					if (i > 0) {
						HzzxLogger.debug("更新cleint_info表成功", strKey);
					} else {
						HzzxLogger.debug("更新cleint_info表失败", strKey);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					HzzxLogger.error("操作数据库失败：", e, strKey);
				}

				cs = new ClientStatus();
				cs.setSource("event");
				cs.setHospitalId(String.valueOf(_0x0222Command.getHospitalID()));
				cs.setCreateTime(DateToString(new Date()));
				cs.setDeviceId(String.valueOf(_0x0222Command.getDeviceID()));
				cs.setEventID(CMDID.CMD_Equipment_WorkStatus_ByBoard.toString());
				cs.setEventTime(ticknumToDate(_0x0222Command.getTickNum()));
				cs.setTickNum(_0x0222Command.getTickNum());
				cs.setUpdateTime(DateToString(new Date()));
				cs.setValue(String.valueOf(_0x0222Command.getWorkStatus()));
				cd.insertDemo(cs);
				//add 刘俊  2019-12-05 由于工作状态不能直接导关机状态，所以要记录设备的上一个工作状态
				preIsWork = _0x0222Command.getWorkStatus();
				//-------------------------------------------------
				isSaveWork = true;
				HzzxLogger.debug("日志插入mongodb数据库成功", strKey);

				break;
			case CMD_Equipment_FaultStatus_ByBoard:
				HzzxLogger.debug("指令解析完成: 人工报故障指令", strKey);
				_0x0225Command _0x0225Command = (_0x0225Command) model;

				cInfo = new ClientInfo();
				cInfo.setIsFault(String.valueOf(_0x0225Command.getErrorStatus()));
				cInfo.setHospitalId(String.valueOf(_0x0225Command.getHospitalID()));
				cInfo.setDeviceId(String.valueOf(_0x0225Command.getDeviceID()));
				try {
					SqlSession session = o.openSession(true);
					cinfoMapper = session.getMapper(ClientInfoMapper.class);
					int i = cinfoMapper.updateByhospitalanddevice(cInfo);
					session.close();
					if (i > 0) {
						HzzxLogger.debug("更新cleint_info表成功", strKey);
					} else {
						HzzxLogger.debug("更新cleint_info表失败", strKey);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					HzzxLogger.error("操作数据库失败：", e, strKey);
				}

				clientFalutStatus = new ClientFalutStatus();
				clientFalutStatus.setHospitalId(String.valueOf(_0x0225Command.getHospitalID()));
				clientFalutStatus.setCreateTime(DateToString(new Date()));
				clientFalutStatus.setDeviceId(String.valueOf(_0x0225Command.getDeviceID()));
				clientFalutStatus.setEventID(CMDID.CMD_Equipment_FaultStatus_ByBoard.toString());
				clientFalutStatus.setSource("equipment");
				clientFalutStatus.setEventTime(ticknumToDate(_0x0225Command.getTickNum()));
				clientFalutStatus.setTickNum(_0x0225Command.getTickNum());
				clientFalutStatus.setUpdateTime(DateToString(new Date()));
				//clientFalutStatus.setValue(String.valueOf((_0x0225Command.getDataByte()[1] & 0xff)));
				//modify 刘俊  2019-03-01
				clientFalutStatus.setValue(String.valueOf((_0x0225Command.getErrorStatus())));
				clientFalutStatusDao.insertDemo(clientFalutStatus);
				HzzxLogger.debug("日志插入mongodb数据库成功", strKey);

				break;
			case CMD_Study_WorkIdleAF:
				HzzxLogger.debug("指令解析完成: 学习关机待机工作参数指令", strKey);
				_0x0250Command _0x0250Command = (_0x0250Command) model;
				if (_0x0250Command.getDataByteLength() == 1) {
					if (_0x0250Command.isReceiveSuccess()) {

					} else {

					}
				} else {

				}
				break;
			case CMD_Get_WorkIdleAF:
				HzzxLogger.debug("指令解析完成: 读取关机待机工作参数指令", strKey);
				_0x0251Command _0x0251Command = (_0x0251Command) model;
				break;
			case CMD_Set_WorkIdleAF:
				HzzxLogger.debug("指令解析完成: 设置关机待机工作参数指令", strKey);
				_0x0252Command _0x0252Command = (_0x0252Command) model;
				if (_0x0252Command.isSuccess()) {
					HzzxLogger.debug("指令解析完成: 设置成功", strKey);
				} else {
					HzzxLogger.debug("指令解析完成: 设置失败", strKey);
				}
				break;
			case CMD_Set_WifiInfo:
				HzzxLogger.debug("指令解析完成: 设置主WIFI指令", strKey);
				_0x0260Command _0x0260Command = (_0x0260Command) model;
				if (_0x0260Command.isSuccess()) {
					HzzxLogger.debug("指令解析完成: 设置成功", strKey);
				} else {
					HzzxLogger.debug("指令解析完成: 设置失败", strKey);
				}
				break;
			case CMD_Get_WifiInfo:
				HzzxLogger.debug("指令解析完成: 读取主WIFI指令", strKey);
				_0x0261Command _0x0261Command = (_0x0261Command) model;
				break;
			case CMD_Set_Mindary_ip:
				HzzxLogger.debug("指令解析完成: 设置迈瑞监护仪网口地址", strKey);
				_0x0262Command _0x0262Command = (_0x0262Command) model;
				if (_0x0262Command.configSuccess) {
					HzzxLogger.debug("设置迈瑞监护仪网口地址成功", strKey);
				} else {
					HzzxLogger.debug("设置迈瑞监护仪网口地址失败", strKey);
				}
				break;
			
			case CMD_Get_Mindary_ip:
				HzzxLogger.debug("指令解析完成: 读取迈瑞监护仪网口地址", strKey);
				_0x0263Command _0x0263Command = (_0x0263Command) model;
				break;
			case CMD_Set_Lan_ip:
				HzzxLogger.debug("指令解析完成: 设置采集器有线网络参数指令", strKey);
				_0x0264Command _0x0264Command = (_0x0264Command) model;
				if (_0x0264Command.isSuccess) {
					HzzxLogger.debug("设置采集器有线网络参数成功", strKey);
				} else {
					HzzxLogger.debug("设置采集器有线网络参数失败", strKey);
				}
				break;
			case CMD_Get_Lan_ip:
				HzzxLogger.debug("指令解析完成: 读取采集器有线网络参数指令", strKey);
				_0x0265Command _0x0265Command = (_0x0265Command) model;
				break;
			case CMD_Set_Lan_mac:
				HzzxLogger.debug("指令解析完成: 设置采集器有线mac指令", strKey);
				_0x0266Command _0x0266Command = (_0x0266Command) model;
				if (_0x0266Command.isSuccess) {
					HzzxLogger.debug("设置采集器有线mac成功", strKey);
				} else {
					HzzxLogger.debug("设置采集器有线mac失败", strKey);
				}
				break;
			case CMD_Get_Lan_mac:
				HzzxLogger.debug("指令解析完成: 读取采集器有线mac指令", strKey);
				_0x0267Command _0x0267Command = (_0x0267Command) model;
				break;
			case CMD_Read_ChannelData:
				HzzxLogger.debug("指令解析完成: 读取呼吸机通道指令", strKey);
				_0x0301Command _0x0301Command = (_0x0301Command) model;

				break;
			case CMD_Set_Channel_0302:
				HzzxLogger.debug("指令解析完成: 设置呼吸机通道指令", strKey);
				_0x0302Command _0x0302Command = (_0x0302Command) model;
				if (_0x0302Command.getDataByteLength() == 1) {
					if (_0x0302Command.isSuccess()) {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0302成功", strKey);
					} else {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0302失败", strKey);
					}
				}
				StoreClientParamData(_0x0302Command);
				break;
			case CMD_Set_Channel_0303:
				HzzxLogger.debug("指令解析完成: 设置呼吸机通道指令", strKey);
				_0x0303Command _0x0303Command = (_0x0303Command) model;
				if (_0x0303Command.getDataByteLength() == 1) {
					if (_0x0303Command.isSuccess()) {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0303成功", strKey);
					} else {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0303失败", strKey);
					}
				}
				StoreClientParamData(_0x0303Command);
				break;
			case CMD_Set_Channel_0304:
				HzzxLogger.debug("指令解析完成: 设置呼吸机通道指令", strKey);
				_0x0304Command _0x0304Command = (_0x0304Command) model;
				if (_0x0304Command.getDataByteLength() == 1) {
					if (_0x0304Command.isSuccess()) {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0304成功", strKey);
					} else {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0304失败", strKey);
					}
				}
				StoreClientParamData(_0x0304Command);
				break;
			case CMD_Set_Channel_0305:
				HzzxLogger.debug("指令解析完成: 设置呼吸机通道指令", strKey);
				_0x0305Command _0x0305Command = (_0x0305Command) model;
				if (_0x0305Command.getDataByteLength() == 1) {
					if (_0x0305Command.isSuccess()) {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0305成功", strKey);
					} else {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0305失败", strKey);
					}
				}
				StoreClientParamData(_0x0305Command);
				break;
			case CMD_Set_Channel_0306:
				HzzxLogger.debug("指令解析完成: 设置呼吸机通道指令", strKey);
				_0x0306Command _0x0306Command = (_0x0306Command) model;
				if (_0x0306Command.getDataByteLength() == 1) {
					if (_0x0306Command.isSuccess()) {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0306成功", strKey);
					} else {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0306失败", strKey);
					}
				}
				StoreClientParamData(_0x0306Command);
				break;
			case CMD_Set_Channel_0307:
				HzzxLogger.debug("指令解析完成: 设置呼吸机通道指令", strKey);
				_0x0307Command _0x0307Command = (_0x0307Command) model;
				if (_0x0307Command.getDataByteLength() == 1) {
					if (_0x0307Command.isSuccess()) {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0307成功", strKey);
					} else {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0307失败", strKey);
					}
				}
				StoreClientParamData(_0x0307Command);
				break;
			case CMD_Set_Channel_0308:
				HzzxLogger.debug("指令解析完成: 设置呼吸机通道指令", strKey);
				_0x0308Command _0x0308Command = (_0x0308Command) model;
				if (_0x0308Command.getDataByteLength() == 1) {
					if (_0x0308Command.isSuccess()) {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0308成功", strKey);
					} else {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0308失败", strKey);
					}
				}
				StoreClientParamData(_0x0308Command);
				break;
			case CMD_Restart_Device:
				HzzxLogger.debug("指令解析完成: 采集器重启指令", strKey);
				_0x0310Command _0x0310Command = (_0x0310Command) model;
				if (_0x0310Command.isSuccess()) {
					HzzxLogger.debug("指令解析完成: 重启成功", strKey);
				} else {
					HzzxLogger.debug("指令解析完成: 重启失败", strKey);
				}
				break;
			case CMD_Get_RespiratorBrandType:
				HzzxLogger.debug("指令解析完成: 获取呼吸机类型指令", strKey);
				_0x0311Command _0x0311Command = (_0x0311Command) model;
				break;
			case CMD_Set_RespiratorBrandType:
				HzzxLogger.debug("指令解析完成: 设置呼吸机类型指令", strKey);
				_0x0312Command _0x0312Command = (_0x0312Command) model;

				if (_0x0312Command.isSuccess()) {
					HzzxLogger.debug("指令解析完成: 设置成功", strKey);
				} else {
					HzzxLogger.debug("指令解析完成: 设置失败", strKey);
				}
				// 将呼吸机类型写入数据库
				break;

			case CMD_Get_Bootloader_version:
				HzzxLogger.debug("指令解析完成: 读取bootloader指令", strKey);
				_0x0313Command _0x0313Command = (_0x0313Command) model;

				break;
			case CMD_Set_AlterStatus:
				HzzxLogger.debug("指令解析完成: 设置报警状态指令", strKey);
				_0x0314Command _0x0314Command = (_0x0314Command) model;
                
				SendBackToJava(model);
				clientFalutStatus = new ClientFalutStatus();
					HzzxLogger.debug("设置故障成功", strKey);
					clientFalutStatus.setValue("1");
					cInfo = new ClientInfo();
					cInfo.setIsFault("1");
					cInfo.setHospitalId(String.valueOf(_0x0314Command.getHospitalID()));
					cInfo.setDeviceId(String.valueOf(_0x0314Command.getDeviceID()));

					try {
						SqlSession session = o.openSession(true);
						cinfoMapper = session.getMapper(ClientInfoMapper.class);
						int i = cinfoMapper.updateByhospitalanddevice(cInfo);
						session.close();
						if (i > 0) {
							HzzxLogger.debug("更新cleint_info表成功", strKey);
						} else {
							HzzxLogger.debug("更新cleint_info表失败", strKey);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						HzzxLogger.error("操作数据库失败：", e, strKey);
					}
				clientFalutStatus.setHospitalId(String.valueOf(_0x0314Command.getHospitalID()));
				clientFalutStatus.setCreateTime(DateToString(new Date()));
				clientFalutStatus.setDeviceId(String.valueOf(_0x0314Command.getDeviceID()));
				clientFalutStatus.setEventID(CMDID.CMD_Equipment_FaultStatus_ByBoard.toString());
				clientFalutStatus.setSource("event");
				clientFalutStatus.setEventTime(new Date());
				clientFalutStatus.setGuid(String.valueOf(UUID.randomUUID()));
				clientFalutStatus.setState("0");
				clientFalutStatus.setTickNum(_0x0314Command.getTickNum());
				clientFalutStatus.setUpdateTime(DateToString(new Date()));

				clientFalutStatusDao.insertDemo(clientFalutStatus);
				isSaveFault = true;
				HzzxLogger.debug("日志插入mongodb数据库成功", strKey);
               
				break;
			case CMD_Set_Serialport_upload:
				HzzxLogger.debug("指令解析完成: 设置串口数据上报指令", strKey);
				_0x0315Command _0x0315Command = (_0x0315Command) model;

				break;
			case CMD_Start_Wavedata:
				HzzxLogger.debug("指令解析完成: 启动呼吸机波形指令", strKey);
				_0x0316Command _0x0316Command = (_0x0316Command) model;
				if (_0x0316Command.isSuccess()) {
					HzzxLogger.debug("指令解析完成: 启动成功", strKey);

					currentWaveData = new WaveData();
					SendBackToJava(model);
				} else {
					HzzxLogger.debug("指令解析完成: 启动失败", strKey);
				}
				break;
			case CMD_Stop_Wavedata:
				HzzxLogger.debug("指令解析完成: 关闭呼吸机波形指令", strKey);
				_0x0317Command _0x0317Command = (_0x0317Command) model;
				if (_0x0317Command.isSuccess()) {
					HzzxLogger.debug("指令解析完成: 关闭成功", strKey);
					currentWaveData = null;
					SendBackToJava(model);
				} else {
					HzzxLogger.debug("指令解析完成: 关闭失败", strKey);
				}
				break;
			case CMD_Set_Channel_0402:
				HzzxLogger.debug("指令解析完成: 设置呼吸机通道指令", strKey);
				_0x0402Command _0x0402Command = (_0x0402Command) model;
				if (_0x0402Command.getDataByteLength() == 1) {
					if (_0x0402Command.isSuccess()) {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0402成功", strKey);
					} else {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0402失败", strKey);
					}
				}
				StoreClientParamData(_0x0402Command);
				break;
			case CMD_Set_Channel_0403:
				HzzxLogger.debug("指令解析完成: 设置呼吸机通道指令", strKey);
				_0x0403Command _0x0403Command = (_0x0403Command) model;
				if (_0x0403Command.getDataByteLength() == 1) {
					if (_0x0403Command.isSuccess()) {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0403成功", strKey);
					} else {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0403失败", strKey);
					}
				}
				StoreClientParamData(_0x0403Command);
				break;
			case CMD_Set_Channel_0404:
				HzzxLogger.debug("指令解析完成: 设置呼吸机通道指令", strKey);
				_0x0404Command _0x0404Command = (_0x0404Command) model;
				if (_0x0404Command.getDataByteLength() == 1) {
					if (_0x0404Command.isSuccess()) {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0404成功", strKey);
					} else {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0404失败", strKey);
					}
				}
				StoreClientParamData(_0x0404Command);
				break;
			case CMD_Set_Channel_0405:
				HzzxLogger.debug("指令解析完成: 设置呼吸机通道指令", strKey);
				_0x0405Command _0x0405Command = (_0x0405Command) model;
				if (_0x0405Command.getDataByteLength() == 1) {
					if (_0x0405Command.isSuccess()) {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0405成功", strKey);
					} else {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0405失败", strKey);
					}
				}
				StoreClientParamData(_0x0405Command);
				break;
			case CMD_Set_Channel_0406:
				HzzxLogger.debug("指令解析完成: 设置呼吸机通道指令", strKey);
				_0x0406Command _0x0406Command = (_0x0406Command) model;
				if (_0x0406Command.getDataByteLength() == 1) {
					if (_0x0406Command.isSuccess()) {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0406成功", strKey);
					} else {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0406失败", strKey);
					}
				}
				StoreClientParamData(_0x0406Command);
				break;
			case CMD_Set_Channel_0407:
				HzzxLogger.debug("指令解析完成: 设置呼吸机通道指令", strKey);
				_0x0407Command _0x0407Command = (_0x0407Command) model;
				if (_0x0407Command.getDataByteLength() == 1) {
					if (_0x0407Command.isSuccess()) {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0407成功", strKey);
					} else {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0407失败", strKey);
					}
				}
				StoreClientParamData(_0x0407Command);
				break;
			case CMD_Set_Channel_0408:
				HzzxLogger.debug("指令解析完成: 设置呼吸机通道指令", strKey);
				_0x0408Command _0x0408Command = (_0x0408Command) model;
				if (_0x0408Command.getDataByteLength() == 1) {
					if (_0x0408Command.isSuccess()) {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0408成功", strKey);
					} else {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0408失败", strKey);
					}
				}
				StoreClientParamData(_0x0408Command);
				break;
			case CMD_Set_Channel_0409:
				HzzxLogger.debug("指令解析完成: 设置呼吸机通道指令", strKey);
				_0x0409Command _0x0409Command = (_0x0409Command) model;
				if (_0x0409Command.getDataByteLength() == 1) {
					if (_0x0409Command.isSuccess()) {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0409成功", strKey);
					} else {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0409失败", strKey);
					}
				}
				StoreClientParamData(_0x0409Command);
				break;
			case CMD_Set_Channel_0410:
				HzzxLogger.debug("指令解析完成: 设置呼吸机通道指令", strKey);
				_0x0410Command _0x0410Command = (_0x0410Command) model;
				if (_0x0410Command.getDataByteLength() == 1) {
					if (_0x0410Command.isSuccess()) {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0410成功", strKey);
					} else {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0410失败", strKey);
					}
				}
				StoreClientParamData(_0x0410Command);
				break;
			case CMD_Set_Channel_0411:
				HzzxLogger.debug("指令解析完成: 设置呼吸机通道指令", strKey);
				_0x0411Command _0x0411Command = (_0x0411Command) model;
				if (_0x0411Command.getDataByteLength() == 1) {
					if (_0x0411Command.isSuccess()) {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0402成功", strKey);
					} else {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0402失败", strKey);
					}
				}
				StoreClientParamData(_0x0411Command);
				break;
			case CMD_Set_Channel_0412:
				HzzxLogger.debug("指令解析完成: 设置呼吸机通道指令", strKey);
				_0x0412Command _0x0412Command = (_0x0412Command) model;
				if (_0x0412Command.getDataByteLength() == 1) {
					if (_0x0412Command.isSuccess()) {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0412成功", strKey);
					} else {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0412失败", strKey);
					}
				}
				StoreClientParamData(_0x0412Command);
				break;
			case CMD_Set_Channel_0413:
				HzzxLogger.debug("指令解析完成: 设置呼吸机通道指令", strKey);
				_0x0413Command _0x0413Command = (_0x0413Command) model;
				if (_0x0413Command.getDataByteLength() == 1) {
					if (_0x0413Command.isSuccess()) {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0413成功", strKey);
					} else {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0413失败", strKey);
					}
				}
				StoreClientParamData(_0x0413Command);
				break;
			case CMD_Set_Channel_0414:
				HzzxLogger.debug("指令解析完成: 设置呼吸机通道指令", strKey);
				_0x0414Command _0x0414Command = (_0x0414Command) model;
				if (_0x0414Command.getDataByteLength() == 1) {
					if (_0x0414Command.isSuccess()) {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0414成功", strKey);
					} else {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0414失败", strKey);
					}
				}
				StoreClientParamData(_0x0414Command);
				break;
			case CMD_Set_Channel_0415:
				HzzxLogger.debug("指令解析完成: 设置呼吸机通道指令", strKey);
				_0x0415Command _0x0415Command = (_0x0415Command) model;
				if (_0x0415Command.getDataByteLength() == 1) {
					if (_0x0415Command.isSuccess()) {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0415成功", strKey);
					} else {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0415失败", strKey);
					}
				}
				StoreClientParamData(_0x0415Command);
				break;
			case CMD_Set_Channel_0416:
				HzzxLogger.debug("指令解析完成: 设置呼吸机通道指令", strKey);
				_0x0416Command _0x0416Command = (_0x0416Command) model;
				if (_0x0416Command.getDataByteLength() == 1) {
					if (_0x0416Command.isSuccess()) {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0416成功", strKey);
					} else {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0416失败", strKey);
					}
				}
				StoreClientParamData(_0x0416Command);
				break;
			case CMD_Set_Channel_0417:
				HzzxLogger.debug("指令解析完成: 设置呼吸机通道指令", strKey);
				_0x0417Command _0x0417Command = (_0x0417Command) model;
				if (_0x0417Command.getDataByteLength() == 1) {
					if (_0x0417Command.isSuccess()) {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0417成功", strKey);
					} else {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0417失败", strKey);
					}
				}
				StoreClientParamData(_0x0417Command);
				break;
			case CMD_Set_Channel_0418:
				HzzxLogger.debug("指令解析完成: 设置呼吸机通道指令", strKey);
				_0x0418Command _0x0418Command = (_0x0418Command) model;
				if (_0x0418Command.getDataByteLength() == 1) {
					if (_0x0418Command.isSuccess()) {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0418成功", strKey);
					} else {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0418失败", strKey);
					}
				}
				StoreClientParamData(_0x0418Command);
				break;
			case CMD_Set_Channel_0419:
				HzzxLogger.debug("指令解析完成: 设置呼吸机通道指令", strKey);
				_0x0419Command _0x0419Command = (_0x0419Command) model;
				if (_0x0419Command.getDataByteLength() == 1) {
					if (_0x0419Command.isSuccess()) {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0419成功", strKey);
					} else {
						HzzxLogger.debug("指令解析完成: 设置呼吸机通道0419失败", strKey);
					}
				}
				StoreClientParamData(_0x0419Command);
				break;
			case CMD_Set_Backup_WifiInfo:
				HzzxLogger.debug("指令解析完成: 设置备用wifi指令", strKey);
				_0x0318Command _0x0318Command = (_0x0318Command) model;
				if (_0x0318Command.isSuccess()) {
					HzzxLogger.debug("指令解析完成: 设置成功", strKey);
				} else {
					HzzxLogger.debug("指令解析完成: 设置失败", strKey);
				}
				break;
			case CMD_Get_Backup_WifiInfo:
				HzzxLogger.debug("指令解析完成: 读取备用wifi指令", strKey);
				_0x0319Command _0x0319Command = (_0x0319Command) model;
				break;
			case CMD_Device_PowerStatus:
				HzzxLogger.debug("指令解析完成: 采集器电源状态指令", strKey);
				_0x0380Command _0x0380Command = (_0x0380Command) model;
				break;
			case Cmd_CallBack:
				HzzxLogger.debug("指令解析完成: 特殊状态指令", strKey);
				_0x0381Command _0x0381Command = (_0x0381Command) model;
				break;
			case CMD_Trans_Wavedata:
				HzzxLogger.debug("指令解析完成: 波形数据传输指令", strKey);
				_0x0383Command _0x0383Command = (_0x0383Command) model;

				HzzxLogger.debug(_0x0383Command.getPackageNo() + "包校验通过", strKey);

				if (_0x0383Command.getPackageNo() == 0) {
					// 包号为0时，数据部分为采集的参数信息
					if (currentWaveData == null) {
						currentWaveData = new WaveData();
					}
					currentWaveData.setPackageNo(0);
					currentWaveData.setHospitalId(String.valueOf(_0x0383Command.getHospitalID()));
					currentWaveData.setDeviceId(String.valueOf(_0x0383Command.getDeviceID()));
					currentWaveData.setRespirateDateTime(_0x0383Command.getRespiratorDateTime());
					currentWaveData.setSampleNumber(_0x0383Command.getAcquisitionNumber());
					currentWaveData.setAcquisitionChannelNum(_0x0383Command.getAcquisitionChannelNum());
					currentWaveData.setAcquisitionChannel(_0x0383Command.getAcquisitionChannel());
					currentWaveData.setAcquisitionFrequency(_0x0383Command.getAcquisitionFrequency());
					currentWaveData.setCollectorDateTime(_0x0383Command.getCollectorDateTime());
					currentWaveData.setWaveFormData(new ArrayList<Byte>());
					currentWaveData.setRespiratorType(_0x0383Command.getRespiratorType());

				} else {
						if (currentWaveData!=null){
						// 包号非0时
						if (_0x0383Command.getPackageNo() == currentWaveData.getPackageNo()) {
							// 当波形数据中已经存储过了相同包号的数据，则不再将该包数据添加到波形数据中
							HzzxLogger.debug(_0x0383Command.getPackageNo() + "包数据已经接收过，此报不再解析", strKey);
						} else {
							// 未存储相同包号的数据，则要判断包号是否连续
							if (_0x0383Command.getPackageNo() != (currentWaveData.getPackageNo() + 1)) {
								HzzxLogger.debug("未收到" + (_0x0383Command.getPackageNo() - 1) + "包数据，此包数据不添加", strKey);
							} else {
								// 包号是连续的、更新最近包号，并将数据加到集合中
								currentWaveData.setPackageNo(_0x0383Command.getPackageNo());
								currentWaveData.getWaveFormData()
										.addAll(CmdUtils.ArrayToList(_0x0383Command.getWaveformData()));
	
								HzzxLogger.debug((_0x0383Command.getPackageNo()) + "包数据接收完毕，数据已添加", strKey);
								// 判断是否最后一包数据
								if (_0x0383Command.getFinalPackageFlag() == 1) {
									HzzxLogger.debug((_0x0383Command.getPackageNo()) + "包数据是最后一包", strKey);
									// 最后一包数据，要对波形数据进行校验
									byte chk = (byte) 0x00;
									byte[] data = CmdUtils.ListToArray(currentWaveData.getWaveFormData());
	//								 for (int j = 0; j < data.length-1; j++) {
	//									chk= (byte) (chk^data[j]);
	//								}
									boolean crcresult = false;
									switch (_0x0383Command.respiratorType) {
									case "00 00":
										Serv_RespiratorModel Serv_RespiratorModel= new Serv_RespiratorModel();
										crcresult = Serv_RespiratorModel.CheckCRC(data, data[data.length - 1]);
										break;
									default:
										break;
									}
									if (crcresult) {
										HzzxLogger.debug("波形数据校验通过", strKey);
										currentWaveData.setFinalPackageFlag(true);
										currentWaveData.setDataCompleted(true);
										StoreWaveFormData(currentWaveData);
									} else {
										HzzxLogger.debug("波形数据校验不通过", strKey);
										currentWaveData = null;
									}
								}
							}
						}
					}
				}
				break;
			case CMD_Trans_Wavedata_evita:
				HzzxLogger.debug("指令解析完成: EVITA波形数据传输指令", strKey);
				_0x0384Command _0x0384Command = (_0x0384Command) model;

				HzzxLogger.debug(_0x0384Command.getPackageNo() + "包校验通过", strKey);

				if (_0x0384Command.getPackageNo() == 0) {
					// 包号为0时，数据部分为采集的参数信息
					if (currentWaveData == null) {
						currentWaveData = new WaveData();
					}
					currentWaveData.setPackageNo(0);
					currentWaveData.setHospitalId(String.valueOf(_0x0384Command.getHospitalID()));
					currentWaveData.setDeviceId(String.valueOf(_0x0384Command.getDeviceID()));
					currentWaveData.setRespirateDateTime(_0x0384Command.getRespiratorDateTime());
					currentWaveData.setSampleNumber(_0x0384Command.getAcquisitionNumber());
					currentWaveData.setAcquisitionChannelNum(_0x0384Command.getAcquisitionChannelNum());
					currentWaveData.setAcquisitionChannel(_0x0384Command.getAcquisitionChannel());
					currentWaveData.setAcquisitionFrequency(_0x0384Command.getAcquisitionFrequency());
					currentWaveData.setCollectorDateTime(_0x0384Command.getCollectorDateTime());
					currentWaveData.setWaveFormData(new ArrayList<Byte>());
					currentWaveData.setRespiratorType(_0x0384Command.getRespiratorType());
					ChannelModelList = _0x0384Command.getChannelModelList();
				} else {
					// 包号非0时
					if (currentWaveData!=null) {
					if (_0x0384Command.getPackageNo() == currentWaveData.getPackageNo()) {
						// 当波形数据中已经存储过了相同包号的数据，则不再将该包数据添加到波形数据中
						HzzxLogger.debug(_0x0384Command.getPackageNo() + "包数据已经接收过，此报不再解析", strKey);
					} else {
						// 未存储相同包号的数据，则要判断包号是否连续
						if (_0x0384Command.getPackageNo() != (currentWaveData.getPackageNo() + 1)) {
							HzzxLogger.debug("未收到" + (_0x0384Command.getPackageNo() - 1) + "包数据，此包数据不添加", strKey);
						} else {
							// 包号是连续的、更新最近包号，并将数据加到集合中
							currentWaveData.setPackageNo(_0x0384Command.getPackageNo());
							currentWaveData.getWaveFormData()
									.addAll(CmdUtils.ArrayToList(_0x0384Command.getWaveformData()));

							HzzxLogger.debug((_0x0384Command.getPackageNo()) + "包数据接收完毕，数据已添加", strKey);
							// 判断是否最后一包数据
							if (_0x0384Command.getFinalPackageFlag() == 1) {
								HzzxLogger.debug((_0x0384Command.getPackageNo()) + "包数据是最后一包", strKey);
								currentWaveData.setFinalPackageFlag(true);
								currentWaveData.setDataCompleted(true);
								StoreWaveFormData(currentWaveData,ChannelModelList);
							}
						}
					}
					}
				}
				break;
				
			case CMD_Trans_Wavedata_minary:
				HzzxLogger.debug("指令解析完成: 迈瑞波形数据传输指令", strKey);
				_0x0385Command _0x0385Command = (_0x0385Command) model;

				HzzxLogger.debug(_0x0385Command.getPackageNo() + "包校验通过", strKey);

				if (_0x0385Command.getPackageNo() == 0) {
					// 包号为0时，数据部分为采集的参数信息
					if (currentWaveData == null) {
						currentWaveData = new WaveData();
					}
					currentWaveData.setPackageNo(0);
					currentWaveData.setHospitalId(String.valueOf(_0x0385Command.getHospitalID()));
					currentWaveData.setDeviceId(String.valueOf(_0x0385Command.getDeviceID()));
					currentWaveData.setRespirateDateTime(_0x0385Command.getRespiratorDateTime_start());
					currentWaveData.setSampleNumber(_0x0385Command.getAcquisitionNumber());
					currentWaveData.setAcquisitionChannelNum(_0x0385Command.getAcquisitionChannelNum());
					currentWaveData.setAcquisitionChannel(_0x0385Command.getAcquisitionChannel());
					currentWaveData.setAcquisitionFrequency(_0x0385Command.getAcquisitionFrequency());
					currentWaveData.setCollectorDateTime(_0x0385Command.getCollectorDateTime());
					currentWaveData.setWaveFormData(new ArrayList<Byte>());
					currentWaveData.setRespiratorType(_0x0385Command.getRespiratorType());
					ChannelModelList_minary = _0x0385Command.getChannelModelList();
				} else {
					// 包号非0时
					if (currentWaveData!=null) {
					if (_0x0385Command.getPackageNo() == currentWaveData.getPackageNo()) {
						// 当波形数据中已经存储过了相同包号的数据，则不再将该包数据添加到波形数据中
						HzzxLogger.debug(_0x0385Command.getPackageNo() + "包数据已经接收过，此报不再解析", strKey);
					} else {
						// 未存储相同包号的数据，则要判断包号是否连续
						if (_0x0385Command.getPackageNo() != (currentWaveData.getPackageNo() + 1)) {
							HzzxLogger.debug("未收到" + (_0x0385Command.getPackageNo() - 1) + "包数据，此包数据不添加", strKey);
						} else {
							// 包号是连续的、更新最近包号，并将数据加到集合中
							currentWaveData.setPackageNo(_0x0385Command.getPackageNo());
							if (_0x0385Command.getWaveformData()!=null) {
								currentWaveData.getWaveFormData()
								.addAll(CmdUtils.ArrayToList(_0x0385Command.getWaveformData()));
                                HzzxLogger.debug((_0x0385Command.getPackageNo()) + "包数据接收完毕，数据已添加", strKey);
							}else {
								HzzxLogger.debug((_0x0385Command.getPackageNo()) + "包数据接收完毕，此包无有效数据", strKey);
							}
							
							// 判断是否最后一包数据
							if (_0x0385Command.getFinalPackageFlag() == 1) {
								HzzxLogger.debug((_0x0385Command.getPackageNo()) + "包数据是最后一包", strKey);
								currentWaveData.setFinalPackageFlag(true);
								currentWaveData.setDataCompleted(true);
								StoreWaveFormData_minary(currentWaveData,ChannelModelList_minary);
							}
						}
					}
					}
				}
				break;	
			case CMD_Set_WholeParameter:
				HzzxLogger.debug("指令解析完成: 设置呼吸机全参数指令", strKey);
				_0x042aCommand _0x042aCommand = (_0x042aCommand) model;
				break;
			case CMD_Trans_WholeParameter:
				HzzxLogger.debug("指令解析完成: 接受呼吸机全参数指令", strKey);
				_0x042bCommand _0x042bCommand = (_0x042bCommand) model;

				HzzxLogger.debug(_0x042bCommand.getPackageNo() + "包校验通过", strKey);

				if (_0x042bCommand.getPackageNo() == 0) {

					wholeParamData = new WholeParamData();

					wholeParamData.setPackageNo(0);
					wholeParamData.setHospitalId(String.valueOf(_0x042bCommand.getHospitalID()));
					wholeParamData.setDeviceId(String.valueOf(_0x042bCommand.getDeviceID()));
					wholeParamData.setProtocolString(_0x042bCommand.getProtocolString());
					wholeParamData.setVersion(_0x042bCommand.getVersion());
					wholeParamData.getOriginalData().addAll(CmdUtils.ArrayToList(_0x042bCommand.getOriginalWaveData()));

				} else {
					// 包号非0时
					if (_0x042bCommand.getPackageNo() == wholeParamData.getPackageNo()) {
						// 当波形数据中已经存储过了相同包号的数据，则不再将该包数据添加到波形数据中
						HzzxLogger.debug(_0x042bCommand.getPackageNo() + "包数据已经接收过，此报不再解析", strKey);
					} else {
						// 未存储相同包号的数据，则要判断包号是否连续
						if (_0x042bCommand.getPackageNo() != (wholeParamData.getPackageNo() + 1)) {
							HzzxLogger.debug("未收到" + (_0x042bCommand.getPackageNo() - 1) + "包数据，此包数据不添加", strKey);
						} else {
							// 包号是连续的、更新最近包号，并将数据加到集合中
							wholeParamData.setPackageNo(_0x042bCommand.getPackageNo());
							wholeParamData.getOriginalData()
									.addAll(CmdUtils.ArrayToList(_0x042bCommand.getOriginalWaveData()));

							HzzxLogger.debug((_0x042bCommand.getPackageNo()) + "包数据接收完毕，数据已添加", strKey);
							// 判断是否最后一包数据
							if (_0x042bCommand.getFinalPackageFlag() == 1) {
								HzzxLogger.debug((_0x042bCommand.getPackageNo()) + "包数据是最后一包", strKey);
								wholeParamData.setFinalPackageFlag(true);
								wholeParamData.setDataCompleted(true);
								wholeParamData.setOriginalDataString(CmdUtils
										.ByteArrayToHexString(CmdUtils.ListToArray(wholeParamData.getOriginalData())));
								StoreWholeParamData(wholeParamData);
							}
						}
					}
				}

				break;
			default:
				break;
			}
			ctx.fireChannelRead(msg);
		} catch (Exception e) {
			HzzxLogger.error("解析错误", e, strKey);
		}
	}

	/**
	 * ser-s存储波形图数据
	 * 
	 * @param w 波形图实体
	 */
	private void StoreWaveFormData(WaveData w) {

		ArrayList<ArrayList<String>> temp = new ArrayList<ArrayList<String>>();
		switch (w.getRespiratorType()) {
		case "00 00":
			Serv_RespiratorModel Serv_RespiratorModel= new Serv_RespiratorModel();
			temp = Serv_RespiratorModel.AnalyzeWaveData(w.getWaveFormData(), w.getAcquisitionChannelNum());
			break;
		default:
			break;
		}

		ArrayList<ChannelWaveData> channelList = new ArrayList<ChannelWaveData>();

		for (int i = 0; i < w.getAcquisitionChannelNum(); i++) {

			ChannelWaveData cWaveData = new ChannelWaveData();
			cWaveData.setChannelNo(Integer.parseInt(w.getAcquisitionChannel().split(",")[i]));
			cWaveData.setChannelData(temp.get(i));

			channelList.add(cWaveData);

		}
		w.setChannelwavedata(channelList);
		w.setCreateTime(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		w.setUpdateTime(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		waveDataDao.insertDemo(w);

	}

	
	/**
	 * evita存储波形图数据
	 * 
	 * @param w 波形图实体
	 */
	private void StoreWaveFormData(WaveData w,ArrayList<Evita_ChannelModel> ChannelModelList) {

		ArrayList<ArrayList<String>> temp = new ArrayList<ArrayList<String>>();
		switch (w.getRespiratorType()) {
		case "00 00":
			Serv_RespiratorModel Serv_RespiratorModel= new Serv_RespiratorModel();
			temp = Serv_RespiratorModel.AnalyzeWaveData(w.getWaveFormData(), w.getAcquisitionChannelNum());
			break;
		case "00 01":
		    Evita_RespiratorModel Evita_RespiratorModel = new Evita_RespiratorModel();
		    Evita_RespiratorModel.setChannelModelList(ChannelModelList);
		    temp = Evita_RespiratorModel.AnalyzeWaveData(w.getWaveFormData(), w.getAcquisitionChannelNum());
		default:
			break;
		}

		ArrayList<ChannelWaveData> channelList = new ArrayList<ChannelWaveData>();

		for (int i = 0; i < w.getAcquisitionChannelNum(); i++) {

			ChannelWaveData cWaveData = new ChannelWaveData();
			cWaveData.setChannelNo(Integer.parseInt(w.getAcquisitionChannel().split(",")[i]));
			cWaveData.setChannelData(temp.get(i));
         
			channelList.add(cWaveData);

		}
		w.setChannelwavedata(channelList);
		w.setCreateTime(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		w.setUpdateTime(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		waveDataDao.insertDemo(w);

	}

	/**
	 * 迈瑞存储波形图数据
	 * 
	 * @param w 波形图实体
	 */
	private void StoreWaveFormData_minary(WaveData w,ArrayList<Minary_ChannelModel> ChannelModelList) {

		ArrayList<ArrayList<String>> temp = new ArrayList<ArrayList<String>>();
		switch (w.getRespiratorType()) {
		case "00 00":
			Serv_RespiratorModel Serv_RespiratorModel= new Serv_RespiratorModel();
			temp = Serv_RespiratorModel.AnalyzeWaveData(w.getWaveFormData(), w.getAcquisitionChannelNum());
			break;
		case "00 02":
		    Minary_RespiratorModel Minary_RespiratorModel = new Minary_RespiratorModel();
		    Minary_RespiratorModel.setChannelModelList(ChannelModelList);
		    temp = Minary_RespiratorModel.AnalyzeWaveData(w.getWaveFormData(), w.getAcquisitionChannelNum());
		default:
			break;
		}

		ArrayList<ChannelWaveData> channelList = new ArrayList<ChannelWaveData>();

		for (int i = 0; i < w.getAcquisitionChannelNum(); i++) {

			ChannelWaveData cWaveData = new ChannelWaveData();
			cWaveData.setChannelNo(Integer.parseInt(w.getAcquisitionChannel().split(",")[i]));
			cWaveData.setChannelData(temp.get(i));
         
			channelList.add(cWaveData);

		}
		
		//重置采样点数
		w.setSampleNumber(temp.get(0).size());
		
		//重置采样频率 首先获取数据的开始时间和结束时间
		Date start = DateUtils.parseDate(ChannelModelList.get(0).getStarttime(),"yyyy-MM-dd HH:mm:ss");
		Date end = DateUtils.parseDate(ChannelModelList.get(0).getEndtime(),"yyyy-MM-dd HH:mm:ss");
		if (start!=null && end !=null) {
			//获取时间差 ，秒数
			double distinceSecond = DateUtils.getSecondDistanceOfTwoDate(start, end);
			//重置采样频率
			w.setAcquisitionFrequency((int)distinceSecond*1000/w.getSampleNumber());
		}
		w.setChannelwavedata(channelList);
		w.setCreateTime(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		w.setUpdateTime(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		waveDataDao.insertDemo(w);

	}

	
	/**
	 * 存储全参数实时数据
	 * 
	 * @param w
	 */
	private void StoreWholeParamData(WholeParamData w) {
		String translateString = "";

		ArrayList<Byte> originalByte = w.getOriginalData();

		String protocolstring = w.getProtocolString();
		int version = w.getVersion();
		/*
		 * 根据protocolstring和version值从数据库中获取对应的解析规则 该规则是一个字典 key value 0 4,1,1000 
		 * 4,2,1001 key的值代表字节中的要解析的索引位置 value是一个以，分割的字符串 第一个字符代表要获取的字节长度
		 * 第二个字符代表转换类型，1代表转换成字符串，2代表转换成float 最后代表通道号
		 */
		if (protocolMap == null) {
			protocolMap = new LinkedHashMap<Integer, String>();
			try {
				SqlSession sqlSession = o.openSession(true);
				ProtocolAnalysisRulerMapper protocolAnalysisRulerMapper = sqlSession
						.getMapper(ProtocolAnalysisRulerMapper.class);
				ProtocolAnalysisRuler protocolAnalysisRuler = new ProtocolAnalysisRuler();
				protocolAnalysisRuler.setProtocolType(protocolstring);
				protocolAnalysisRuler.setProtocolVersion(version);

				List<ProtocolAnalysisRuler> pList = protocolAnalysisRulerMapper
						.selectByTypeAndVersion(protocolAnalysisRuler);
				sqlSession.close();

				for (int i = 0; i < pList.size(); i++) {

					protocolMap.put(pList.get(i).getSegmentIndex(), pList.get(i).getLen_type());
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 遍历map
		for (Map.Entry<Integer, String> entry : protocolMap.entrySet()) {

			String tempresult = "";
			int index = entry.getKey();// 获取要转换的字节索引位置
			int length = Integer.valueOf(entry.getValue().split(",")[0]);// 获取要转换的字节长度
			int translateType = Integer.valueOf(entry.getValue().split(",")[1]);// 获取要转换的类型
			String attr_id = entry.getValue().split(",")[2];
			ClientParamValue cp = new ClientParamValue();
			cp.setIsRawVal("");
			cp.setAddr(attr_id);
			switch (translateType) {
			case 1: // 当需要转换为字符串时
				if (originalByte.get(index) == (byte) 0xff) {
					// 遇到0xff 则转换为空格
					tempresult = " ";
				} else {
					tempresult = CmdUtils.ByteArrayToNormalString(originalByte, index, length);
				}
				tempresult = deleteString(tempresult);
				translateString += tempresult;
				translateString += ",";
				cp.setAddrVal(tempresult);
				break;
			case 2: // 转换成float
				boolean validvalue = true; // 判断是否无效值，当要转换的字节数组全部为0xff时，只需要转换成空格即可
				for (int i = 0; i < length; i++) {
					if (originalByte.get(index + i) != (byte) 0xff) {
						validvalue = false;
						break;
					}
				}
				if (validvalue) {
					tempresult = " ";
				} else {
					float f = Float.intBitsToFloat(CmdUtils.ByteArray4ToInteger(originalByte, index));
					tempresult = String.valueOf(f);
				}
				tempresult = deleteString(tempresult);
				translateString += tempresult;
				translateString += ",";
				cp.setAddrVal(tempresult);
				break;
			default: // 默认转换成字符串
				if (originalByte.get(index) == (byte) 0xff) {
					// 遇到0xff 则转换为空格
					tempresult = " ";
				} else {
					tempresult = CmdUtils.ByteArrayToNormalString(originalByte, index, length);
				}
				tempresult = deleteString(tempresult);
				translateString += tempresult;
				translateString += ",";
				cp.setAddrVal(tempresult);
				break;
			}
			w.getValues().add(cp);
		}

		w.setDataString(translateString);
		w.setCreateTime(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		w.setUpdateTime(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		wholeParamDataDao.insertDemo(w);
	}

	/**
	 * 移除字符串结尾的\0字符
	 * 
	 * @param originalstring
	 * @return
	 */
	private String deleteString(String originalstring) {
		byte[] zero = new byte[1];
		zero[0] = (byte) 0;
		String string = new String(zero);
		originalstring = originalstring.replaceAll(string, " ");

		return originalstring;
	}

	/**
	 * 存储呼吸机通道数据
	 * 
	 * @param model 0302到0419指令
	 */
	private void StoreClientParamData(CmdModel model) {
		if (model.getDataByteLength() > 2) {
			ClientCurrentParam cp = new ClientCurrentParam();
			cp.setDeviceId(String.valueOf(model.getDeviceID()));
			cp.setHospitalId(String.valueOf(model.getHospitalID()));
			cp.setEventId(model.getCmd().toString());
			cp.setCreateTime(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
			cp.setUpdateTime(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
			cp.setEventTime(new Date());
			String[] channelList = respiritorMap
					.get(model.getCmd().toString().substring(model.getCmd().toString().length() - 4)).split(",");
			for (int i = 0; i < channelList.length; i++) {
				ClientParamValue cValue = new ClientParamValue();
				cValue.setAddr(channelList[i]);
				byte[] temp = new byte[4];
				System.arraycopy(model.getDataByte(), i * 4, temp, 0, 4);
				
				cValue.setAddrVal(CmdUtils.ByteArrayToHexStringWithX(temp));
				cValue.setIsRawVal("0");
				cp.getValue().add(cValue);
			}
			// 此操作用作分表操作
			ClientParam clientParam = new ClientParam();
			clientParam.setDeviceId(cp.getDeviceId());
			clientParam.setHospitalId(cp.getHospitalId());
			clientParam.setEventId(cp.getEventId());
			clientParam.setCreateTime(cp.getCreateTime());
			clientParam.setUpdateTime(cp.getUpdateTime());
			clientParam.setEventTime(new Date());
			clientParam.setValue(cp.getValue());
			clientParamDao.insertDemo(clientParam);// 保存历史数据
			clientCurrentParamDao.updateDemo(cp); // 保存实时参数信息

		}
	}

	/**
	 * 发送经过转义的指令
	 * @param ctx
	 * @param sendbyte
	 */
	public void SendMsg(ChannelHandlerContext ctx, byte[] sendbyte, String msg) {
		// 通过channel发送反馈消息，注意 发送数据时要进行转义处理，
		String originalresult = CmdUtils.ByteArrayToHexString(sendbyte);
		//移除最后一个33  cc 
		int lastindex =  originalresult.lastIndexOf("33 cc");
		originalresult = originalresult.substring(0, lastindex);
		//移除第一个 aa 55
		//String tempString = originalresult.replaceAll("aa 55", "").replaceAll("33 cc", "");
		String tempString = originalresult.replaceFirst("aa 55", "");
		tempString = tempString.replaceAll("aa", "aa ff ").replaceAll("33", "33 ff ");
		String finalstring = "aa 55 " + tempString + " 33 cc";
		// 将字符串中的多余空格去除，每个字符串之间保留一个空格即可
		finalstring = finalstring.replaceAll("[\\s]{2,}", " ");
		sendbyte = CmdUtils.HexStringToByteArray(finalstring, " ");
		ctx.writeAndFlush(Unpooled.copiedBuffer(sendbyte));
		HzzxLogger.debug(msg + CmdUtils.ByteArrayToHexString(sendbyte), strKey);
	}

	public void SendBackToJava(CmdModel model) {
		boolean result = false;
		String mString = "";
		switch (model.getCmd()) {
		case CMD_Start_Wavedata:
			_0x0316Command _0x0316Command = (_0x0316Command) model;
			if (_0x0316Command.isSuccess()) {
				result = true;
				mString = "开启波形图";

			} else {

			}
			break;
		case CMD_Stop_Wavedata:
			_0x0317Command _0x0317Command = (_0x0317Command) model;
			if (_0x0317Command.isSuccess()) {
				result = true;
				mString = "停止波形图";
			} else {

			}
			break;
		case CMD_Equipment_ClearFaultStatus_ByBoard:
			_0x0214Command _0x0214Command = (_0x0214Command) model;
			if (_0x0214Command.getClearSuccess()) {
				result = true;
				mString = "清除故障";
			} else {

			}
			break;
		case CMD_Set_AlterStatus:
			_0x0314Command _0x0314Command = (_0x0314Command) model;
			if (_0x0314Command.getAlterStatus()==1) {
				result = true;
				mString = "设置故障";
			} else {

			}
			break;
		}
		// MeisJavaChannelMap.map
		for (Map.Entry<String, Channel> entry : MeisJavaChannelMap.map.entrySet()) {
			Channel ch = entry.getValue();

			ChannelHandler chd = ch.pipeline().get("Javaserverhandler");

			MeisJavaSocketServerInHandler chSocketServerhd = (MeisJavaSocketServerInHandler) chd;// 把得到的channelhandle对象强制转化为对应的MeisSocketServerInHandler，得到MeisSocketServerInHandler中的ctx
			String strresult = result ? "1" : "0";
			byte[] tmpback = strresult.getBytes(StandardCharsets.UTF_8);

			chSocketServerhd.mctx.writeAndFlush(Unpooled.copiedBuffer(tmpback));
			HzzxLogger.debug("发送" + mString + "回馈成功", strKey);

		}
	}

}
