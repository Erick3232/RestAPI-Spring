package com.example.WorkshopMongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WorkshopMongo.domain.Post;
import com.example.WorkshopMongo.repository.PostRepository;
import com.example.WorkshopMongo.services.exception.ObjectNotFoundException;

@Service
public class PostServices {
	
	@Autowired
	private PostRepository postRepository;
	
	public Post findById(String id) {
		Optional<Post> obj = postRepository.findById(id); // se existe 
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found, try another way!")); //caso contrário
	}
	
	public List<Post> findByTitle(String text){
		return postRepository.findByTitle(text);
	}
}
