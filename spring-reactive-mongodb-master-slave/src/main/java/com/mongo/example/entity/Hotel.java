package com.mongo.example.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Hotels")
public class Hotel{
	
	@Id
	private String id;
	private String name;
	@Indexed(direction = IndexDirection.ASCENDING)
	private int rooms;
	
}
	
