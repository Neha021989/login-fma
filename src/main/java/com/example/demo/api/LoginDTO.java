package com.example.demo.api;

public class LoginDTO {
	public String username;
	public String password;
	public String getUsername() {
		return username;
	}
	public LoginDTO setUsername(String username) {
		this.username = username;
		return this;
	}
	public String getPassword() {
		return password; 
	}
	public LoginDTO setPassword(String password) {
		this.password = password;
		return this;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoginDTO [username=");
		builder.append(username);
		builder.append(", password=");
		builder.append(password);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	

}
