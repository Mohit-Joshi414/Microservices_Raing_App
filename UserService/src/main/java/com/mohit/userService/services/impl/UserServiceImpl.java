package com.mohit.userService.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mohit.userService.entities.Rating;
import com.mohit.userService.entities.Users;
import com.mohit.userService.exceptions.ResourceNotFoundException;
import com.mohit.userService.repositories.UserRepository;
import com.mohit.userService.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	@Override
	public Users saveUsers(Users user) {
		String randomUUID = UUID.randomUUID().toString();
		user.setUserId(randomUUID);
		return userRepo.save(user);
	}

	@Override
	public List<Users> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public Users getUser(String userId) {
		Users user = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with given id is not found on server!!"+userId));
		System.out.println(user.getUserId());
		//logic for fetching rating from rating-service using rest template
		ArrayList<Rating> userRatingList = restTemplate.getForObject("http://localhost:8083/ratings/users/"+user.getUserId(), ArrayList.class);
		System.out.println("http://localhost:8083/ratings/users/"+user.getUserId());
		System.out.println(userRatingList);
		user.setRatings(userRatingList);
		return user;
	}

	@Override
	public void deleteUser(Users user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Users updateUser(Users user) {
		// TODO Auto-generated method stub
		return null;
	}

}
