package com.example.WorkshopMongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WorkshopMongo.domain.User;
import com.example.WorkshopMongo.repository.UserRepository;
import com.example.WorkshopMongo.services.exception.ObjectNotFoundException;

@Service
public class UserServices {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = userRepository.findById(id); // se existe 
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found, try another way!")); //caso contrário
	}
	
}
