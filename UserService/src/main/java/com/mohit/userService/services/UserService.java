package com.mohit.userService.services;

import java.util.List;

import com.mohit.userService.entities.Users;

public interface UserService {

	Users saveUsers(Users user);
	List<Users> getAllUsers();
	Users getUser(String userId);
	void deleteUser(Users user);
	Users updateUser(Users user);
}
