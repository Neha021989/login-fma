package com.example.demo.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.LoginDTO;
import com.example.demo.api.LoginStatus;
import com.example.demo.client.Login;
import com.example.demo.mapper.LoginMapper;
import com.example.demo.service.LoginService;

import reactor.core.publisher.Mono;

@RestController
public class LoginResource {

	public final LoginService loginService;

	@Autowired
	public LoginResource(LoginService loginService) {
		this.loginService = loginService;
	}

	@GetMapping("/login")
	public Mono<String> getHello() {
		return Mono.just("hello world !!!!!");
	}

	@GetMapping("/login/{username}")
	public Mono<LoginDTO> getLoginDetails(@PathVariable String username) {
		return Mono.just(username).flatMap(u -> loginService.getLoginDetails(u)).map(LoginMapper::toApi);
	}

	@PostMapping("/login")
	public Mono<ResponseEntity<LoginStatus>> verifyLogin(@RequestBody LoginDTO loginDTO) {
		return Mono.just(LoginMapper.toClient(loginDTO)).flatMap(u -> loginService.getLoginDetails(u.getUsername()))
				.filter(t -> null != t ? t.getPassword().equals(loginDTO.getPassword()) : null)
				.switchIfEmpty(Mono.just(new Login())).map(t -> checkStatus(t))
				.map(r -> new ResponseEntity<>(r, HttpStatus.OK));
	}

	@PostMapping("/register")
	public Mono<ResponseEntity<LoginDTO>> create(@RequestBody LoginDTO loginDTO) {
		return Mono.just(LoginMapper.toClient(loginDTO)).flatMap(u -> loginService.create(u)).map(LoginMapper::toApi)
				.map(r -> new ResponseEntity<>(r, HttpStatus.OK));
	}

	public LoginStatus checkStatus(Login login) {
		return Optional.ofNullable(login.getUsername()).map(t -> new LoginStatus().setStatus(true))
				.orElse(new LoginStatus().setStatus(false));
	}

}
