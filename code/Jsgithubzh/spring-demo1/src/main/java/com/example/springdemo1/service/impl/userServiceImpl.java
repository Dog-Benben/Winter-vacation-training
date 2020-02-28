package com.example.springdemo1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdemo1.dao.UserMapper;
import com.example.springdemo1.eneity.User;
import com.example.springdemo1.service.userService;


@Service
public class userServiceImpl implements userService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public boolean findUser(User user)
	{
		User temp = userMapper.finduser(user);
		
		return temp==null ? false:true;
	}
	

}
