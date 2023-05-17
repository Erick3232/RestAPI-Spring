package com.example.WorkshopMongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.WorkshopMongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	
}
