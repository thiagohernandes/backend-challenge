package com.invillia.model;

/*
 * User Model - Login
 * @since 22-03-2019
 * @author: Thiago Hernandes de Souza
 * */

public class User {
	
	private String name;
	private String password;
	
	public User() {}
	
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

