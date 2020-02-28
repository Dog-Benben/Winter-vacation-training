package com.example.springdemo1.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.springdemo1.eneity.User;

@Mapper
public interface UserMapper {
    
	@Select("select * from User where username = #{username} and password = #{password}")
	User finduser(User user);

}
