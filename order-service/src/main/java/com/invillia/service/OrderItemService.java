package com.invillia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invillia.model.OrderItem;
import com.invillia.repository.OrderItemRepository;

/*
 * Service - Order Item
 * @since 21-03-2019
 * @author: Thiago Hernandes de Souza
 * */

@Service
public class OrderItemService {

	@Autowired 
	private OrderItemRepository orderItemRepository;
	
	public List<OrderItem> itensByOrderId(Integer id){
		return orderItemRepository.getItensOrderByIdOrder(id);
	}
	
	public void saveOrderItem(OrderItem orderItem) {
		orderItemRepository.save(orderItem);
	}
}
