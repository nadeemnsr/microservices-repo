package com.discovery.app.user.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.discovery.app.user.ui.model.UserDto;

public interface UserService extends UserDetailsService {

	UserDto createUser(UserDto dto);
	UserDto getUserDetailByEmail(String email);
	//UserDto getUserByUserId(String userId);
	
}
