package com.invillia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.invillia.model.Store;
import com.invillia.repository.OrderItemRepository;
import com.invillia.repository.OrderRepository;
import com.invillia.util.Util;

/*
 * REST Order Controller
 * @since 20-03-2019
 * @author: Thiago Hernandes de Souza
 * */

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	
	@Autowired
	Util util;
	
	@Autowired
	RestTemplate template;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderItemRepository orderItemRepository;
	
	@GetMapping(value="/teste")
	public Store todas(){
		return template.getForObject(util.URL_BUSINESS_STORES + "/1", Store.class);
	}

}
