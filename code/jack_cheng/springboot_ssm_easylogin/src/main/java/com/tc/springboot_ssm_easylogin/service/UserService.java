package com.tc.springboot_ssm_easylogin.service;

import com.tc.springboot_ssm_easylogin.entity.User;

public interface UserService {
	boolean save(User user);

	boolean findUserByUsernameAndPassword(User user);

	boolean isRegister(User user);

}
