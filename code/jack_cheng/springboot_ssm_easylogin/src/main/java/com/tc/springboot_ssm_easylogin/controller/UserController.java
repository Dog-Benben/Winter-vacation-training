package com.tc.springboot_ssm_easylogin.controller;
/**
 * 接收在注册页面点击"注册"，返回的路径
 * @author TR
 *
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tc.springboot_ssm_easylogin.entity.User;
import com.tc.springboot_ssm_easylogin.service.UserService;

@Controller
public class UserController {
	
	@Autowired  //这是个接口，当它会吧实现类的方法注入到这个接口
	private UserService userService;
	
	//#############登陸##############
	@RequestMapping("/login")
	public String login(User user,Model model) {
		
		//如果不在实体类引入toString方法，不然它就打出user对象的地址
		System.out.println(user);
		
		boolean success = userService.findUserByUsernameAndPassword(user);
		System.out.println(success);
		//判断是否登录的账号在数据库是不是存在的
		if(success) {
			model.addAttribute("success", "登陆成功了(使用Model继续打出)!!!");
			return "success.html";
		}else {
			//登录失败。就重定向到登录界面
			return "redirect:/";
		}
		
		
		
	}
	
	
	
	
	///#######################註冊############
	@RequestMapping("/register")
	public String register(User user,String repassword,Model model) {
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(repassword);
		
		//校验password和repassword是否一致
		//注意不是整型是字符型
		if(user.getPassword().equals(repassword)) {
			
			//检验用户是否曾注册过
			boolean isRegister = userService.isRegister(user);
			//拿到了isRegister在数据库查询的结果
			//isRegister为空才会返回；不为空就直接去注册
			if(!isRegister) {
				
				model.addAttribute("error", "用户名已经存在!!!");
				return "error.html";
			}
			
			
			//一致
			 boolean success=userService.save(user);//返回是否成功
			 //这是判断是否在数据库创建成功！！！
			if(success) {
				model.addAttribute("error","注册成功!!!");
				return "error.html";
			}else {
				model.addAttribute("error","注册失败？？？!");
				return "error.html";
			}
			
		}else {
			//这样就在error.html页面通过th:text="${error}"取得这个值，就不用多写几个error页面
			model.addAttribute("error", "两次密码输入不一致~~");
			//不一致
			return "error.html";
		}
		
	}
}
