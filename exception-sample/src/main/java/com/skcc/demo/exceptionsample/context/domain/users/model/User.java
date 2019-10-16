package com.skcc.demo.exceptionsample.context.domain.users.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull(message="User Name cannot be null!")
	private String name;
	
	private String email;
	
	public User() {
		
	}
	public User(String name, String email) {
		this.name = name;
		this.email= email;
		
	}
}
