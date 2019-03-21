package com.invillia.model;

/*
 * Model - Payment
 * @since 20-03-2019
 * @author: Thiago Hernandes de Souza
 * */

public class Payment {

	private Integer id;
	private String description;
	
	public Payment(Integer id, String description) {
		this.description = description;
	}
	
	
	public Payment(String description) {
		this.description = description;
	}
	
	public Payment() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
