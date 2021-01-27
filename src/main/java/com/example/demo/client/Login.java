package com.example.demo.client;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Login {
	
	@Id
	public String username;
	public String password;
	public String getUsername() {
		return username;
	}
	public Login setUsername(String username) {
		this.username = username;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public Login setPassword(String password) {
		this.password = password;
		return this;
	}
	
	
	
	

}
