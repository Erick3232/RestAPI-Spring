package com.example.WorkshopMongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.WorkshopMongo.domain.Post;
import com.example.WorkshopMongo.domain.User;
import com.example.WorkshopMongo.repository.PostRepository;
import com.example.WorkshopMongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		User u1 = new User(null, "Lord Gwyn", "gwyn@gmail.com");
		User u2 = new User(null, "Ancient Midir", "midir@gmail.com");
		User u3 = new User(null, "Nameless King", "nameless@gmail.com");
		User u4 = new User(null, "Sister Friede", "friede@gmail.com");
		User u5 = new User(null, "Pontiff Sulyvahn", "sulyvahn@gmail.com");
		
		Post p1 = new Post(null, sdf.parse("21/03/2018"),"Partiu viagem", "Vou viajar para São Paulo", maria);
		Post p2 = new Post(null, sdf.parse("21/03/2018"),"Bom dia", "Acordei feliz hoje!", alex);
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob,u1,u2,u3,u4,u5));
		postRepository.saveAll(Arrays.asList(p1,p2));
	}

}
