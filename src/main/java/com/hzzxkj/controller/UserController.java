package com.hzzxkj.controller;
 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hzzxkj.cmdAnaliser.CMDID;
import com.hzzxkj.cmdAnaliser.CmdFactory;
import com.hzzxkj.cmdAnaliser.CmdModel;
import com.hzzxkj.socket.meisSocket.MeisChannelMap;
import com.hzzxkj.socket.meisSocket.MeisCmdVersionMap;
import com.hzzxkj.socket.meisSocket.MeisSocketServerInHandler;

import io.netty.channel.Channel; 
import io.netty.channel.ChannelHandler;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/home")
public class UserController {
	@GetMapping("/user/{id}")
	@ResponseBody
	String index(@PathVariable(name = "id") String id) {
		//TODO
		return "Hello World 6666" + id;
	}
	
//	@ApiOperation(value = "更新用户信息", notes = "更新用户信息")
//	@ApiImplicitParam(name = "user", value = "User", required = true, dataType = "User")
//	@PostMapping("/updateUser")
//	public User updateUser(@RequestBody User user) {
//		user.setName(user.getName() + " success");
//		//TODO More Operation
//		return user;
//	}
//	
//	@ApiOperation(value = "添加用户信息", notes = "添加用户信息")
//	@ApiImplicitParam(name = "user", value = "User", required = true, dataType = "User")
//	@PostMapping("/addUser")
//	public Object addUser(@RequestBody User user) {
//		return "success is OK";
//	}
	
	/**
	 * 
	 * @param deviceid  为医院HospitalID+"_"+deviceid 
	 * @return
	 * @throws InterruptedException
	 */
	@ApiOperation(value = "请求接口", notes = "请求接口")
	@ApiImplicitParam(name = "hospitalidAndDeviceid", value = "hospitalidAndDeviceid", required = true)
	@PostMapping("/cancelalter")
	public String  cancelalter(@RequestBody String hospitalidAndDeviceid) throws InterruptedException { 
		int portocolVersion = MeisCmdVersionMap.get(hospitalidAndDeviceid);
		byte[] command =new byte[] {} ;
		switch (portocolVersion) {
			case 0:
				String[] a = hospitalidAndDeviceid.split("_");
				command =  CmdFactory.CreateCmd(portocolVersion, Integer.valueOf(a[0]) , Integer.valueOf(a[1]), CMDID.CMD_Equipment_ClearFaultStatus_ByBoard,null);
				break;
			case 1:
				command =  CmdFactory.CreateCmd(portocolVersion, 1, 2, CMDID.CMD_Equipment_ClearFaultStatus_ByBoard,null); 
				break;
			case -1:
				return  ControllerEorrConstant.getVersionMapErr;
			default:
				break; 
		}
	   return  WriteMsgASYC(hospitalidAndDeviceid,command, CMDID.CMD_Equipment_ClearFaultStatus_ByBoard);  
	}
	
	/**
	 * 
	 * @param  deviceid 目前先用deviceid进行测试  ---------------------后期需要修改的地方，暂时用设备ID表示是那个采集器---------------
	 * @param  msg
	 * @return 0是        1是下发指令并反馈成功      2设备离线下发失败
	 * @throws InterruptedException
	 */ 
	private  String WriteMsgASYC(String deviceid,Object msg,CMDID cmd) throws InterruptedException {
		String strRtn ="";
		try { 
			Channel ch = MeisChannelMap.get(deviceid);//根据传进来的设备ID得到缓存中记录的对应通道的map
			if (ch ==null) {
				strRtn=ControllerEorrConstant.deviceOff;
			} else {
				ChannelHandler chd = ch.pipeline().get("serverhandler");//根据hander名称得到对应的channelHandler，目的是取handle中的属性和方法
				 
				MeisSocketServerInHandler chSocketServerhd = (MeisSocketServerInHandler)chd;//把得到的channelhandle对象强制转化为对应的MeisSocketServerInHandler，得到MeisSocketServerInHandler中的ctx
				
				strRtn= chSocketServerhd.WriteM(chSocketServerhd.mctx, msg,cmd, 10); //调用写方法
			}  
		} catch (Exception e) {
			System.out.println("向采集器发送指令异常信息：" + e.getMessage());
			return ControllerEorrConstant.httpRequestErr;
		}
		return strRtn;
	}
}
