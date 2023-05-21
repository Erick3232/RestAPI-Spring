package com.example.WorkshopMongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.WorkshopMongo.domain.Post;
import com.example.WorkshopMongo.domain.User;
import com.example.WorkshopMongo.dto.AuthorDTO;
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
		User bob = new User(null, "Bob Josh", "bob@gmail.com");
		User u1 = new User(null, "Mr Beast", "beast@gmail.com");
		User u2 = new User(null, "Thomas Edson", "thomas@gmail.com");
		User u3 = new User(null, "Nicolas Tesla", "tesla@gmail.com");
		User u4 = new User(null, "Machiavel", "machiavel@gmail.com");
		User u5 = new User(null, "Gutenberg", "gutenberg@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob,u1,u2,u3,u4,u5));
		
		Post p1 = new Post(null, sdf.parse("21/03/2018"),"Partiu viagem", "Vou viajar para São Paulo", new AuthorDTO(maria));
		Post p2 = new Post(null, sdf.parse("02/03/2018"),"Bom dia", "Acordei feliz hoje!", new AuthorDTO(alex));
		Post p3 = new Post(null, sdf.parse("16/03/2022"),"Partiu viagem", "Vou viajar para São Paulo", new AuthorDTO(bob));
		Post p4 = new Post(null, sdf.parse("30/03/2022"),"Bom dia", "Acordei feliz hoje!", new AuthorDTO(u1));
		Post p5 = new Post(null, sdf.parse("25/09/2011"),"Partiu viagem", "Vou viajar para São Paulo", new AuthorDTO(u2));
		Post p6 = new Post(null, sdf.parse("09/03/2012"),"Bom dia", "Acordei feliz hoje!", new AuthorDTO(u3));
		Post p7 = new Post(null, sdf.parse("13/03/2019"),"Partiu viagem", "Vou viajar para São Paulo", new AuthorDTO(u4));
		Post p8 = new Post(null, sdf.parse("19/03/2018"),"Bom dia", "Acordei feliz hoje!", new AuthorDTO(u5));

		postRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8));
		
		maria.getPosts().addAll(Arrays.asList(p1,p2));
		userRepository.save(maria);
	}

}
