package com.example.WorkshopMongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WorkshopMongo.domain.User;
import com.example.WorkshopMongo.repository.UserRepository;

@Service
public class UserServices {
	
	@Autowired
	private UserRepository userRepository;
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
}
