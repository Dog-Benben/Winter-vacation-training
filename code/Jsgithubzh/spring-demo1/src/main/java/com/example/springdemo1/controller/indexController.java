package com.example.springdemo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {
	
	//web首页
	@RequestMapping("")
	public String mainIndex()
	{
		return "index.html";
	}
	
	
	@RequestMapping("/index")
	public String index()
	{
		return "index.html";
	}
	

}
