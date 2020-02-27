package com.easylogin.springbootssmeasylogin.service;

import com.easylogin.springbootssmeasylogin.entity.User;

public interface UserService {

	boolean save(User user);

	boolean findUserByUsernameAndPassword(User user);

	boolean isRegister(User user);


	
}
