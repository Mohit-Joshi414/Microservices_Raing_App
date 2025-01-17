package com.mohit.ratingService.controller;

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

import com.mohit.ratingService.entities.Rating;
import com.mohit.ratingService.services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@PostMapping
	public ResponseEntity<Rating> createUser(@RequestBody Rating rating){
		Rating u1 = ratingService.createRating(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(u1);
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
		List<Rating> r1 = ratingService.getRatingByUserId(userId);
		return ResponseEntity.ok(r1);
	}
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
		List<Rating> r1 = ratingService.getRatingByHotelId(hotelId);
		return ResponseEntity.ok(r1);
	}
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRatings(){
		List<Rating> allRatings = ratingService.getAllRating();
		return ResponseEntity.ok(allRatings);
	}
}
