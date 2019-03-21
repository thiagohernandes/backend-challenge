package com.invillia.model;

/*
 * Model DTO - Product
 * @since 21-03-2019
 * @author: Thiago Hernandes de Souza
 * */

public class Product {

	private Integer id;
	private String description;
	private Double price;
	
	public Product(Integer id, String description, Double price) {
		this.id = id;
		this.description = description;
		this.price = price;
	}
	
	public Product() {
		
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
}
