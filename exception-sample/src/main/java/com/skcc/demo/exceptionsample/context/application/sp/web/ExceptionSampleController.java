package com.skcc.demo.exceptionsample.context.application.sp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skcc.demo.exceptionsample.context.domain.UsersService;
import com.skcc.demo.exceptionsample.context.domain.users.model.User;

@RestController
@RequestMapping("/test")
public class ExceptionSampleController {
	@Autowired
	UsersService usersService;
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id")Long id){
		User user = usersService.findUser(id);
		
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
}
