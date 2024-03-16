package com.pawan.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pawan.blog.entities.User;
import com.pawan.blog.exceptions.ResourceNotFoundException;
import com.pawan.blog.payloads.UserDto;
import com.pawan.blog.repositories.UserRepo;
import com.pawan.blog.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		
		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser);
		
	}

	@Override
	public UserDto updateUser(UserDto userDto, Long userId) {
		
		User user = this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
		
		user.setName(userDto.getName());
		user.setCity(userDto.getCity());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setPhone_number(userDto.getPhone_number());
		user.setAbout(userDto.getAbout());
		
		User updatedUser = this.userRepo.save(user);
		
		UserDto userDto1=this.userToDto(updatedUser);
		
		return userDto1;
		
	}

	@Override
	public UserDto getUserById(Long userId) {
		
		User user = this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
		return this.userToDto(user);
		
	}

	@Override
	public List<UserDto> getAllUsers() {
		
		List<User> users = this.userRepo.findAll();
		List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
		
		return userDtos;
	}

	@Override
	public void deleteUser(Long userId) {
		
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
		
		this.userRepo.delete(user);
	}
	
	public User dtoToUser(UserDto userDto)
	{
		User user = this.modelMapper.map(userDto, User.class);
		
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setCity(userDto.getCity());			//ModelMapper is used to convert
//		user.setEmail(userDto.getEmail());			//one object to another
//		user.setPassword(userDto.getPassword());
//		user.setPhone_number(userDto.getPhone_number());
//		user.setAbout(userDto.getAbout());
		
		return user;
	}
	
	public UserDto userToDto(User user)
	{
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setCity(user.getCity());
//		userDto.setEmail(user.getEmail());
//		userDto.setPassword(user.getPassword());
//		userDto.setPhone_number(user.getPhone_number());
//		userDto.setAbout(user.getAbout());
		
		return userDto;
	}

}
