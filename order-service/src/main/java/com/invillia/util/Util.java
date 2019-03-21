package com.invillia.util;

import org.springframework.stereotype.Component;

/*
 * Util Component - Functions, variables for all
 * @since 20-03-2019
 * @author: Thiago Hernandes de Souza
 * */

@Component
public class Util {

	public final String URL_BUSINESS_STORES = "http://business-service/api/stores";
	public final String URL_BUSINESS_PAYMENTS = "http://business-service/api/payments";
	public final String URL_BUSINESS_PRODUCTS = "http://product-service/api/products";
	
	public java.sql.Timestamp handleDateTemporal(long data) {
		long hours24 = 24L * 60L * 60L * 1000L;
		return new java.sql.Timestamp(data + hours24);
	}
}
