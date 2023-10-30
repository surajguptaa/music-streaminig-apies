package com.musicstreaminig.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musicstreaminig.api.payloads.ApiResponse;
import com.musicstreaminig.api.payloads.UserDto;
import com.musicstreaminig.api.services.UserService;


@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	//POST-Create user
	
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Validated @RequestBody UserDto userdto)
	{
		UserDto createUserDto = this.userService.createUser(userdto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	}
	
	//PUT - update user
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Validated @RequestBody UserDto userdto, @PathVariable("userId") Integer uId)
	{
		UserDto updatedUser = this.userService.updateUser(userdto, uId);
		return ResponseEntity.ok(updatedUser);
	}
	//DELETE - delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uId)
	{
		this.userService.deleteUser(uId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);
	}
	
//	public ResponseEntity<?> deleteUser(@PathVariable("userId") Integer uId)
//	{
//		this.deleteUser(uId);
//		return ResponseEntity.ok(Map.of("Message", "User Deleted Successfully"));
//	}
//	
	//GET - All get user
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
	
	//GET - get user by id
		@GetMapping("/{userId}")
		public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId){
			return ResponseEntity.ok(this.userService.getUserById(userId));
		}
	
}
