package com.invillia.model;

import java.util.Date;
import java.util.List;

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
 * Model - Order Table
 * @since 20-03-2019
 * @author: Thiago Hernandes de Souza
 * */

@Entity
@Table(schema="public", name="tbl_order")
@JsonInclude(Include.ALWAYS)
public class Order {

	@Id
	@SequenceGenerator(name = "tbl_order_id_seq", sequenceName = "tbl_order_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbl_order_id_seq")
	private Integer id;
	@Column(name = "buy_date")
	private Date buyDate;
	@Column(name = "confirmation_date")
	private Date confirmationDate;
	private String status;
	@Column(name = "id_store")
	private Integer idStore;
	@Column(name = "id_payment")
	private Integer idPayment;
	@Transient
	private Store store;
	@Transient
	private Payment payment;
	@Transient
	private List<OrderItem> itens;
	
	public Order(Date buyDate, String status, Integer idStore, Integer idPayment) {
		this.buyDate = buyDate;
		this.status = status;
		this.idStore = idStore;
		this.idPayment = idPayment;
	}
	
	public Order(Integer id, Date buyDate, Date confirmationDate, 
				 String status, Integer idStore, Integer idPayment, List<OrderItem> itens) {
		this.id = id;
		this.buyDate = buyDate;
		this.confirmationDate = confirmationDate;
		this.status = status;
		this.idStore = idStore;
		this.idPayment = idPayment;
		this.itens = itens;
	}
	
	public Order() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	public Date getConfirmationDate() {
		return confirmationDate;
	}

	public void setConfirmationDate(Date confirmationDate) {
		this.confirmationDate = confirmationDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getIdStore() {
		return idStore;
	}

	public void setIdStore(Integer idStore) {
		this.idStore = idStore;
	}

	public Integer getIdPayment() {
		return idPayment;
	}

	public void setIdPayment(Integer idPayment) {
		this.idPayment = idPayment;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public List<OrderItem> getItens() {
		return itens;
	}

	public void setItens(List<OrderItem> itens) {
		this.itens = itens;
	}
}
