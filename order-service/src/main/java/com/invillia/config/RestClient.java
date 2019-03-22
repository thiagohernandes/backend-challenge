package com.invillia.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.invillia.service.TokenAuthenticationService;

/*
 * RestClient - Generator of tokens for internal services
 * @since 22-03-2019
 * @author: Thiago Hernandes de Souza
 * */

@Component
public class RestClient {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	TokenAuthenticationService tokenAuthenticationService;

	public HttpHeaders getRequestHeaderBearer() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization",TokenAuthenticationService.GENERATE_TOKEN);
		return headers;
	}
	
	public HttpHeaders getRequestHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}
	
	public <T> ResponseEntity<T> restExchangeBearer(String url, HttpMethod httpMethod,
	    Class<T> classObj) {
	
	return restTemplate.exchange(url, httpMethod,
	    new HttpEntity<>("parameters", this.getRequestHeaderBearer()), classObj);
	
	}
	
	public <T> ResponseEntity<T> restExchange(String url, HttpMethod httpMethod,
	    Class<T> classObj) {
	
	return restTemplate.exchange(url, httpMethod,
	    new HttpEntity<>("parameters", this.getRequestHeader()), classObj);
	
	}
}