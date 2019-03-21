package com.invillia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/*
 * Model - Order Item Table
 * @since 20-03-2019
 * @author: Thiago Hernandes de Souza
 * */

@Entity
@Table(schema="public", name="tbl_order_item")
@JsonInclude(Include.ALWAYS)
public class OrderItem {

	@Id
	@SequenceGenerator(name = "tbl_order_item_id_seq", sequenceName = "tbl_order_item_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbl_order_item_id_seq")
	private Integer id;
	@Column(name = "id_order")
	private Integer idOrder;
	@Column(name = "id_product")
	private Integer idProduct;
	private int quantity;
	private Double price;
	@Transient
	private String descriptionProduct;
	
	public OrderItem(Integer idOrder, Integer idProduct, int quantity, Double price, String descriptionProduct) {
		this.idOrder = idOrder;
		this.idProduct = idProduct;
		this.quantity = quantity;
		this.price = price;
		this.descriptionProduct = descriptionProduct;
	}
	
	public OrderItem(Integer idOrder, Integer idProduct, int quantity, Double price) {
		this.idOrder = idOrder;
		this.idProduct = idProduct;
		this.quantity = quantity;
		this.price = price;
	}
	
	public OrderItem() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Integer idOrder) {
		this.idOrder = idOrder;
	}

	public Integer getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescriptionProduct() {
		return descriptionProduct;
	}

	public void setDescriptionProduct(String descriptionProduct) {
		this.descriptionProduct = descriptionProduct;
	}
}
