package com.mongo.example.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mongo.example.entity.Hotel;
import com.mongo.example.service.HotelService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class MyRunner implements CommandLineRunner {

    @Autowired
    private HotelService hotelService;

    @Override
    public void run(String... args) throws Exception {

        log.info("Creating hotels");

        var hotels = List.of(new Hotel("120","Zeytin", 40),
                new Hotel("121","Urla", 10),
                new Hotel("122","Voyage", 300),
                new Hotel("123","Max Royal", 400));

        Mono<Void> one = hotelService.deleteAll();
        
        Flux<Hotel> two = hotelService.saveAll(hotels);
   
        Flux<Hotel> three = hotelService.findAll();
 
        three.subscribe(hotel -> log.info("{}", hotel));

        Mono<Void> all = Mono.when(one, two, three);
        all.block();
    }
}