package com.tc.springboot_ssm_easylogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	
	
	
	//首页请示：这是前端对应的请求，就是网址打什么命令就对应这个请求
	@RequestMapping("")
	public String mainIndex(){
		
		return "index.html";
	}
	
	
	@RequestMapping("/index")
	public String index() {
		
		return "index.html";
	}
	
}
