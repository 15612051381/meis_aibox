package com.hzzxkj.cmdAnaliser.cmdModel;

import com.hzzxkj.cmdAnaliser.BaseCommand;
import com.hzzxkj.cmdAnaliser.CmdConstant;
import com.hzzxkj.cmdAnaliser.CmdUtils;

/**
 * 读取采集器网络地址等信息
 * @author liujun
 *
 */
public class _0x021eCommand extends BaseCommand {

	/**
	 * ip地址
	 */
	public String ipaddress;
	/**
	 * 是否打开dhcp  1打开   0 关闭
	 */
	public int dhcpOpen;
	public String getIpaddress() {
		return ipaddress;
	}
	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
	public int getDhcpOpen() {
		return dhcpOpen;
	}
	public void setDhcpOpen(int dhcpOpen) {
		this.dhcpOpen = dhcpOpen;
	}
	public String getNetMask() {
		return netMask;
	}
	public void setNetMask(String netMask) {
		this.netMask = netMask;
	}
	public String getGateWay() {
		return gateWay;
	}
	public void setGateWay(String gateWay) {
		this.gateWay = gateWay;
	}
	public String getDns() {
		return dns;
	}
	public void setDns(String dns) {
		this.dns = dns;
	}

	/**
	 * 子网掩码
	 */
	public String netMask;
	/**
	 * 网关地址
	 */
	public String gateWay;
	/**
	 * dns地址
	 */
	public String dns;
	
	public _0x021eCommand(byte[] cmdbyte) {
		GenerateCmdModel(cmdbyte);
	}
	@Override
	public _0x021eCommand GenerateCmdModel(byte[] cmdbyte) {
		
		return (_0x021eCommand) super.GenerateCmdModel(cmdbyte);
	}

	@Override
	public _0x021eCommand GenerateReturnCmd(boolean result) {
		
       return  (_0x021eCommand)super.GenerateReturnCmd(result);
	}

	@Override
	public byte[] GenerateReturnCmdByte(boolean result) {

		return super.GenerateReturnCmdByte(result);
	}
    
     @Override
    public void AnalysisSpecialItem() {
    	 if (originalByte[0]==(byte)CmdConstant.mcuToPcHeaderFirst) {
    	this.dhcpOpen = CmdUtils.ByteToInt(dataByte[0]);
    	this.ipaddress = CmdUtils.ByteArrayToNormalString(dataByte, 1, 4);
    	this.netMask =  CmdUtils.ByteArrayToNormalString(dataByte, 5, 4);
    	this.gateWay = CmdUtils.ByteArrayToNormalString(dataByte, 9, 4);
    	this.dns = CmdUtils.ByteArrayToNormalString(dataByte, 13, 4);
    	 }
    }
}
