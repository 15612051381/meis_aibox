package com.hzzxkj.cmdAnaliser;

import org.apache.ibatis.annotations.Case;

/**
 * 采集器事件ID
 * 
 * @author Administrator
 *
 */
public enum CMDEVENTID {

	/**
	 * 呼吸机开关机事件 1开机 0关机
	 */
	CMD_Equipment_OnOff_ByBoard(1),
	/**
	 * 呼吸机工作状态 1工作 0 待机
	 */
	CMD_Equipment_WorkStatus_ByBoard(2),

	/**
	 * 电池状态 0充满 1 欠电 2 充满但不欠电
	 */

	CMD_Equipment_batterystatus_ByBoard(3),
	/**
	 * 学习状态 1 已学习 0 未学习
	 */

	CMD_Equipment_study_ByBoard(4),
	
	/**
	 * 故障状态 1故障 0 无故障
	 */
	CMD_Equipment_FaultStatus_ByBoard(5),

	/**
	 * 上电掉电 1 上电 0 掉电
	 */
	CMD_Equipment_Power_ByBoard_ignory(6),
	/**
	 * 采集器电源状态 1 上电 0 掉电 该状态与6一致，代码中基本不用6这个事件了
	 */
	CMD_Equipment_Power_ByBoard(7);

	private Integer eventId;

	public Integer geteventId() {
		return eventId;
	}

	public String getCmdHEX() {
		return Integer.toHexString(eventId);
	}

	CMDEVENTID(Integer id) {
		this.eventId = id;
	}

	public static CMDEVENTID EventIdToEnum(int value) {
		switch (value) {

		case 1:
			return CMDEVENTID.CMD_Equipment_OnOff_ByBoard;
		case 2:
			return CMDEVENTID.CMD_Equipment_WorkStatus_ByBoard;
		case 3:
			return CMD_Equipment_batterystatus_ByBoard;
		case 4:
			return CMD_Equipment_study_ByBoard;
		case 5:
			return CMD_Equipment_FaultStatus_ByBoard;
		case 6:
			return CMD_Equipment_Power_ByBoard_ignory;
		case 7:
			return CMD_Equipment_Power_ByBoard;
		default:
			return CMDEVENTID.CMD_Equipment_OnOff_ByBoard;
		}
	}
}
