package com.invillia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
@SequenceGenerator(name="seq-gen-item", allocationSize=1)
public class OrderItem {

	@Id
	@SequenceGenerator(name="seq-gen-item",sequenceName="tbl_order_item_id_seq")
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq-gen-item")
	private Integer id;
	@Column(name = "id_order")
	private Integer idOrder;
	@Column(name = "id_product")
	private Integer idProduct;
	private int quantity;
	
	public OrderItem(Integer idOrder, Integer idProduct, int quantity) {
		this.idOrder = idOrder;
		this.idProduct = idProduct;
		this.quantity = quantity;
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
}
