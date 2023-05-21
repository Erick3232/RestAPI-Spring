package com.example.WorkshopMongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.WorkshopMongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
}
