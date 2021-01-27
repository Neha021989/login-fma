package com.example.demo.mapper;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.demo.api.LoginDTO;
import com.example.demo.client.Login;

@Component
public final class LoginMapper {

	public static LoginDTO toApi(Login login)
	{
		return Optional.ofNullable(login).map(i-> new LoginDTO().setUsername(i.getUsername())
				.setPassword(i.getPassword())).orElse(null);
	}
	
	public static Login toClient(LoginDTO loginDTO)
	{
		return Optional.ofNullable(loginDTO).map(i-> new Login().setUsername(i.getUsername())
				.setPassword(i.getPassword())).orElse(null);
	}
}
