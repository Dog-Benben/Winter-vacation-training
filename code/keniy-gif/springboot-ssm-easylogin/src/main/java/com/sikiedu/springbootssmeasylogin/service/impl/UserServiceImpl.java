package com.sikiedu.springbootssmeasylogin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sikiedu.springbootssmeasylogin.dao.UserMapper;
import com.sikiedu.springbootssmeasylogin.entity.User;
import com.sikiedu.springbootssmeasylogin.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	
	
	
	
	@Override
	public boolean save(User user) {
	int rows = userMapper.save(user);
	
	return rows>0 ? true:false;
	}

	
	
	
	
	
}
