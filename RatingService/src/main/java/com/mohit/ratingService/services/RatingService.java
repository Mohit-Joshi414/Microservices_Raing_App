package com.mohit.ratingService.services;

import java.util.List;

import com.mohit.ratingService.entities.Rating;

public interface RatingService {

	Rating createRating(Rating rating);
	List<Rating> getAllRating();
	List<Rating> getRatingByUserId(String userId);
	List<Rating> getRatingByHotelId(String hotelId);
}
