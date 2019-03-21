package com.invillia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/*
 * Model - Product Table
 * @since 20-03-2019
 * @author: Thiago Hernandes de Souza
 * */

@Entity
@Table(schema="public", name="tbl_product")
@JsonInclude(Include.ALWAYS)
public class Product {
	
	@Id
	@SequenceGenerator(name = "tbl_product_id_seq", sequenceName = "tbl_product_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbl_product_id_seq")
	private Integer id;
	private String description;
	private Double price;
	
	public Product(int id, String description, Double price) {
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

	public Double getValor() {
		return price;
	}

	public void setValor(Double price) {
		this.price = price;
	}
}
