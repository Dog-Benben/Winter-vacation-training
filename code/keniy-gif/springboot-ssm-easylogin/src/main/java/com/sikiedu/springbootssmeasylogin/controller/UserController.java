package com.sikiedu.springbootssmeasylogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sikiedu.springbootssmeasylogin.entity.User;
import com.sikiedu.springbootssmeasylogin.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/register")
	public String register(User user,String repassword,Model model) {
		
//		System.out.println(user.getUsername());
//		System.out.println(user.getPassword());
//		System.out.println(repassword);
//	
	//校验password以及repassword是否一致
		if(user.getPassword().equals(repassword))
		{
			//一致
		boolean success = 	userService.save(user);
		if(success)
		{
			model.addAttribute("error","注册成功！");
			return "error.html";
		}
		else {
			
			model.addAttribute("error","注册失败！");
			return "error.html";
		}
		}
		
		
		else
	{
			model.addAttribute("error","两次密码输入不一致~");
			//不一致
			return "error.html";
		}
		
		
	}
	
}
