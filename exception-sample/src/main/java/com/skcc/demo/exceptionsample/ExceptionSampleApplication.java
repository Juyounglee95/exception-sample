package com.skcc.demo.exceptionsample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.skcc.demo.exceptionsample.context.domain.users.model.User;
import com.skcc.demo.exceptionsample.context.domain.users.repository.UserRepository;

@SpringBootApplication
public class ExceptionSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExceptionSampleApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner execSample(UserRepository userRepository) {
		return (args) -> {
			insertUser(userRepository);
		
		};
		
	}

	private void insertUser(UserRepository userRepository) {
		User user = new User("name1", "name1@sk.com");
		userRepository.save(user);
	}

}
