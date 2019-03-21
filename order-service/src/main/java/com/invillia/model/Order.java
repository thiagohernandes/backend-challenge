package com.invillia.model;

import java.util.Date;

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
@SequenceGenerator(name="seq-gen-order", allocationSize=1)
public class Order {

	@Id
	@SequenceGenerator(name="seq-gen-order",sequenceName="tbl_order_id_seq")
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq-gen-order")
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
	
	public Order(Date buyDate, String status, Integer idStore, Integer idPayment) {
		this.buyDate = buyDate;
		this.status = status;
		this.idStore = idStore;
		this.idPayment = idPayment;
	}
	
	public Order(Date buyDate, Date confirmationDate, String status, Integer idStore, Integer idPayment) {
		this.buyDate = buyDate;
		this.confirmationDate = confirmationDate;
		this.status = status;
		this.idStore = idStore;
		this.idPayment = idPayment;
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
}
