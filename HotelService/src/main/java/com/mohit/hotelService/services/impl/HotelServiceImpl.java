package com.mohit.hotelService.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohit.hotelService.entities.Hotel;
import com.mohit.hotelService.exceptions.ResourceNotFoundException;
import com.mohit.hotelService.repositories.HotelRepository;
import com.mohit.hotelService.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel createHotel(Hotel hotel) {
		String randomUUID = UUID.randomUUID().toString();
		hotel.setId(randomUUID);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() {
		
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotel(String id) {
		// TODO Auto-generated method stub
		return hotelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Hotel not found for the Id : " + id));
	}
	
	
}
