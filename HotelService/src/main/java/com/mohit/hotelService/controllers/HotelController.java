package com.mohit.hotelService.controllers;

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

import com.mohit.hotelService.entities.Hotel;
import com.mohit.hotelService.services.HotelService;


@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	@PostMapping
	public ResponseEntity<Hotel> createUser(@RequestBody Hotel hotel){
		Hotel h1 = hotelService.createHotel(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(h1);
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getSingleUser(@PathVariable String hotelId){
		Hotel u1 = hotelService.getHotel(hotelId);
		return ResponseEntity.ok(u1);
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllUser(){
		List<Hotel> allHotel = hotelService.getAllHotels();
		return ResponseEntity.ok(allHotel);
	}
}
