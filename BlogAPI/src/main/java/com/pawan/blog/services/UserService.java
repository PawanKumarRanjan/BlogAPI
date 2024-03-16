package com.pawan.blog.services;

import java.util.List;

import com.pawan.blog.payloads.UserDto;


public interface UserService {
	
	UserDto createUser(UserDto user);
	
	UserDto updateUser(UserDto user, Long userId);
	
	UserDto getUserById(Long userId);
	
	List<UserDto> getAllUsers();
	
	void deleteUser(Long userId);
	

}
