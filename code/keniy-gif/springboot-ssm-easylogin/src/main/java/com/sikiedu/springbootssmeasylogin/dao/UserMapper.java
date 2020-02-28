package com.sikiedu.springbootssmeasylogin.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.sikiedu.springbootssmeasylogin.entity.User;

@Mapper
public interface UserMapper {

	@Insert("insert into user(username,password) values(#{username},#{password})")
	int save(User user);
	

}
