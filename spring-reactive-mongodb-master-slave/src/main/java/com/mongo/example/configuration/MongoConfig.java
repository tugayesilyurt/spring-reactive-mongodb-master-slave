package com.mongo.example.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

@Configuration
@EnableReactiveMongoRepositories("com.mongo.example.repository")
public class MongoConfig extends AbstractReactiveMongoConfiguration {

	@Override
	protected String getDatabaseName() {
		return "tugayesilyurt";
	}

	@Override
	@Bean
	public MongoClient reactiveMongoClient() {
		return MongoClients.create("mongodb://127.0.0.1:30000,127.0.0.1:30001,127.0.0.1:30002/?replicaSet=rs0");
	}

	@Bean
	public ReactiveMongoTemplate reactiveMongoTemplate() {
		return new ReactiveMongoTemplate(reactiveMongoClient(), getDatabaseName());
	}
}
