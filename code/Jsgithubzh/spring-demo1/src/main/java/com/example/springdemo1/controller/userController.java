package com.example.springdemo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springdemo1.eneity.User;
import com.example.springdemo1.service.userService;

@Controller
public class userController {
	
	@Autowired
	private userService userService;
	
	@RequestMapping("/login")
	public String login(User user) 
	{
		boolean sorf = userService.findUser(user);
		System.out.println(sorf);
		//数据库中有效用户为：(admin，12345)和(admin@qq.com，123)，除了这两个账户外都登录失败
		if(sorf==true)
		return "sss.html";
		else
		{
			return "error.html";
		}
	}

}
