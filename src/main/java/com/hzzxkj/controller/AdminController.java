package com.hzzxkj.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(value = "/test", tags = "this is a test interface")
@RestController
@RequestMapping("/test")
public class AdminController {
	@ApiOperation(value = "展示首页信息", notes = "展示首页信息")
	@GetMapping("/show")
	public Object showInfo() {
//		Customer customer = new Customer();
//		customer.setGoods("789");
		return 1;
	}

//	@ApiOperation(value = "添加用户信息", notes = "添加用户信息")
//	@ApiImplicitParam(name = "user", value = "User", required = true, dataType = "User")
//	@PostMapping("/addUser")
//	public Object addUser(@RequestBody User user) {
//		return "success";
//	}

//	@ApiOperation(value = "更新用户信息", notes = "更新用户信息")
//	@ApiImplicitParam(name = "user", value = "User", required = true, dataType = "User")
//	@PostMapping("/updateUser")
//	public User updateUser(@RequestBody User user) {
//		user.setName(user.getName() + " success");
//		// TODO More Operation
//		return user;
//	}
}
