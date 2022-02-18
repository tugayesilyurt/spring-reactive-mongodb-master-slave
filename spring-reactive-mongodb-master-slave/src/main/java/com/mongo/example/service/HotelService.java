package com.mongo.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mongo.example.entity.Hotel;
import com.mongo.example.repository.HotelRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class HotelService {
	
	private final HotelRepository hotelRepository;
	
	public Mono<Hotel> save(Hotel hotel) {
		Mono<Hotel> savedData = hotelRepository.save(hotel);
		return savedData;
	}
	
	public Mono<Void> deleteAll(){
		return hotelRepository.deleteAll();
	}
	
	public Flux<Hotel> saveAll(List<Hotel> hotels ){
		return hotelRepository.saveAll(hotels);
	}
	
	public Flux<Hotel> findAll(){
		return hotelRepository.findAll();
	}
	
	public Flux<Hotel> findByRoomsLessThan(int rooms){
		return hotelRepository.findByRoomsLessThan(rooms);
	}

}
