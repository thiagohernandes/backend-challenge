package com.invillia.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.invillia.model.Order;
import com.invillia.service.OrderItemService;
import com.invillia.service.OrderService;
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
	OrderService orderService;
	
	@Autowired
	OrderItemService orderItemService;
	
	@GetMapping(value="/{id}")
	public Optional<Order> getOrderById(@PathVariable Integer id){
		return orderService.getOrderById(id);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public void deleteOrder(@PathVariable("id") Integer id) {
		orderService.deleteOrder(id);
	}
	
	@ResponseBody
	@PutMapping(value="/update/{id}")
	public void alterar(@PathVariable("id") Integer id, @RequestBody Order order) {
		orderService.saveUpdateOrder(order);
	}
	
	@ResponseBody
	@PostMapping("/new")
	public void novo(@RequestBody Order order) {
		orderService.saveUpdateOrder(order);
	}
	
	@ResponseBody
	@PutMapping(value="/confirm/{id}")
	public void confirmOrder(@PathVariable("id") Integer id, @RequestBody Date dateConfirmation) {
		orderService.updateOrderConfirmationDate(dateConfirmation, id);
	}

}
