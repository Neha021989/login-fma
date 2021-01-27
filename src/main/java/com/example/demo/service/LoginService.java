package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.client.Login;
import com.example.demo.repository.LoginRepository;

import reactor.core.publisher.Mono;

@Service
public class LoginService {
	
	public LoginRepository loginRepository;
	
	public LoginService(LoginRepository loginRepository) {
		this.loginRepository = loginRepository;
	}
	
	public Mono<Login> getLoginDetails(String username) {
		return this.loginRepository.findById(username);
	}
	
	public Mono<Login> create(Login login) {
		return this.loginRepository.save(login);
	}
	
	

}
