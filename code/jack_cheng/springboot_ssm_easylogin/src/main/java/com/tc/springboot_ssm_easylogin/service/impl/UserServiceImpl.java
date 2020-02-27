package com.tc.springboot_ssm_easylogin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tc.springboot_ssm_easylogin.dao.UserMapper;
import com.tc.springboot_ssm_easylogin.entity.User;
import com.tc.springboot_ssm_easylogin.service.UserService;

@Service    //@Component这个注解是让接口认识这个实现类
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;    //增加用户
	
	@Override
	public boolean save(User user) {
		int rows =userMapper.save(user);    //行数
		
		/**
		 * 判断行数：
		 * 当行数大于0时候就返回true，否则返回false
		 */
		return rows > 0 ? true : false;
		
	}

	@Override
	public boolean findUserByUsernameAndPassword(User user) {
		//接收mapper查询数据库是否有这个用户，有就不为空
		User temp = userMapper.findUserByUsernameAndPassword(user);
		return temp==null ? false : true;
	}

	@Override
	public boolean isRegister(User user) {
		//看这个用户是否曾经注册过
		
		User register = userMapper.isRegister(user);
		//查询到了返回user
		//没有查询到返回null
		
		return register==null?true:false;
	}

}
