package com.skcc.demo.exceptionsample.context.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skcc.demo.exceptionsample.context.domain.users.model.User;
import com.skcc.demo.exceptionsample.context.domain.users.repository.UserRepository;
import com.skcc.demo.exceptionsample.context.exceptionhandle.UserNotFoundException;

@Service
public class UsersLogic implements UsersService{
	@Autowired
	private UserRepository userRepository;
	@Override
	public User findUser(Long id) {
		
		User user = userRepository.findById(id).orElseThrow(()->new UserNotFoundException("User not found"));
		
		return user;
	}
	
}
