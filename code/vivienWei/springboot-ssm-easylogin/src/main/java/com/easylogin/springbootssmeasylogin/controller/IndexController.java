package com.easylogin.springbootssmeasylogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	//首页的展示
	@RequestMapping("")
	public String mainIndex() {
		return "index.html";
	}
	
	@RequestMapping("/index")
	public String index() {
		
		return "index.html";
	}
	
	
	
}
