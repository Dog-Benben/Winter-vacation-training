package com.easylogin.springbootssmeasylogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.easylogin.springbootssmeasylogin.entity.User;
import com.easylogin.springbootssmeasylogin.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String login(User user)
	{
		System.out.println(user);		
		boolean success = userService.findUserByUsernameAndPassword(user);
		
		//登录成功
		if(success)
		{
			return "login-success.html";
		}
		else	return "redirect:/"; //表示重定向：重定向到一个空路径，首页那里
		
		//return "login-success.html";写在这里这个页面是一定会返回的
	}

	@RequestMapping("/register")
	//下面这个register()里的参数，username和password都是包装类型，可以直接用User
	public String register(User user,String repassword,Model model) {
/*	System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(repassword);
*/		
		
		//检验password以及repassword是否一致
		if(user.getPassword().equals(repassword))
		{
			//检验用户是否曾经注册过
			boolean isRegister = userService.isRegister(user);
			if(!isRegister) {
				model.addAttribute("error","用户名已经存在！");
				return "error.html";
			}
			//一致
			boolean success = userService.save(user);
			if(success)
			{
				model.addAttribute("error","注册成功!");
				return "error.html";
			}
			else
			{
				model.addAttribute("error","注册失败！");
				return"error.html";
			}
			
			
		}
		else {
			model.addAttribute("error", "两次密码输入不一致！");
			//第一个值是键值，把后者赋值给error，然后可以传递给html，在html中获得error的值
			//不一致
			return "error.html";
		}
	}
	
	
}
