package com.example.WorkshopMongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WorkshopMongo.domain.User;
import com.example.WorkshopMongo.dto.UserDTO;
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
	public User insert(User obj) {
		return userRepository.insert(obj);
	}
	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(),userDTO.getName(),userDTO.getEmail());
	}
	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);
	}
	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return userRepository.save(obj);
	}	

	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
	
}
