package com.pawan.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pawan.blog.payloads.ApiResponse;
import com.pawan.blog.payloads.UserDto;
import com.pawan.blog.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//create user
	@PostMapping("/create-user")
	public ResponseEntity<UserDto> createUser(@Valid@RequestBody UserDto userDto)
	{	
		UserDto createUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	}
	
	//update user
	@PutMapping("/update-user/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid@RequestBody UserDto userDto, @PathVariable("userId") Long userId)
	{
		UserDto updatedUser = this.userService.updateUser(userDto, userId);
		return ResponseEntity.ok(updatedUser);
	}
	
	//delete user
	@DeleteMapping("/delete-user/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Long userId)
	{
		this.userService.deleteUser(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully", true), HttpStatus.OK);
	}
	
	//get user
	@GetMapping("/get-all-user")
	public ResponseEntity<List<UserDto>> getAllUsers()
	{
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
	
	//get user
	@GetMapping("/get-single-user/{userId}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable Long userId)
	{
		return ResponseEntity.ok(this.userService.getUserById(userId));
	}

}
