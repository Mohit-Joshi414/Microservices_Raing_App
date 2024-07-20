package com.mohit.hotelService.services;

import java.util.List;

import com.mohit.hotelService.entities.Hotel;

public interface HotelService {

	Hotel createHotel(Hotel hotel);
	List<Hotel> getAllHotels();
	Hotel getHotel(String id);
}
