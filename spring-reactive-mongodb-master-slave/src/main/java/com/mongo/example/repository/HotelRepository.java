package com.mongo.example.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.mongo.example.entity.Hotel;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Repository
public interface HotelRepository extends ReactiveMongoRepository<Hotel, String>{
	
	Mono<Hotel> findById(String id);
	
	Flux<Hotel> findByRoomsLessThan(int max);
	
	
}
