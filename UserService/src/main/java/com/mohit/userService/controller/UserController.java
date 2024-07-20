package com.mohit.userService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohit.userService.entities.Users;
import com.mohit.userService.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<Users> createUser(@RequestBody Users user){
		Users u1 = userService.saveUsers(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(u1);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<Users> getSingleUser(@PathVariable String userId){
		Users u1 = userService.getUser(userId);
		return ResponseEntity.ok(u1);
	}
	
	@GetMapping
	public ResponseEntity<List<Users>> getAllUser(){
		List<Users> allUsers = userService.getAllUsers();
		return ResponseEntity.ok(allUsers);
	}
}
