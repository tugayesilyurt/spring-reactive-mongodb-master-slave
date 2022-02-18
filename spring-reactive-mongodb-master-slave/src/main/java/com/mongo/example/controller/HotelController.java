package com.mongo.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.example.entity.Hotel;
import com.mongo.example.service.HotelService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/hotels")
public class HotelController {

	private final HotelService hotelService;

	@PostMapping
	public Mono<ResponseEntity<Hotel>> addHotel(@RequestBody Hotel hotel) {
		Mono<Hotel> response = hotelService.save(hotel);
		return response.map(ResponseEntity::ok);
	}

	@GetMapping(produces = "application/json")
	public Flux<Hotel> getAllHotel() {
		Flux<Hotel> hotels = hotelService.findAll();
		return hotels;
	}

	@GetMapping(value = "/rooms/{rooms}", produces = "application/json")
	public Flux<Hotel> findByRoomsLessThan(@PathVariable("rooms") int rooms) {
		return hotelService.findByRoomsLessThan(rooms);
	}

}
