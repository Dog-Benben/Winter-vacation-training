package com.tc.springboot_ssm_easylogin.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.tc.springboot_ssm_easylogin.entity.User;

@Mapper
public interface UserMapper {
	
	@Insert("insert into user(username,password) value(#{username},#{password})")
	int save(User user);   //返回影响行数
	
	@Select("select * from user where username=#{username} and password=#{password}")
	User findUserByUsernameAndPassword(User user);
	
	//查找用户名是否已经存在
	@Select("select * from user where username = #{username}")
	User isRegister(User user);
}
