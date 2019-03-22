package com.invillia.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.invillia.config.RestClient;
import com.invillia.model.Order;
import com.invillia.model.OrderItem;
import com.invillia.model.Payment;
import com.invillia.model.Product;
import com.invillia.model.Store;
import com.invillia.repository.OrderItemRepository;
import com.invillia.repository.OrderRepository;
import com.invillia.util.Util;

/*
 * Service - Order
 * @since 21-03-2019
 * @author: Thiago Hernandes de Souza
 * */

@Service
@Transactional
public class OrderService {
	
	@Autowired
	RestClient restClient;
	
	@Autowired
	RestTemplate template;
	
	@Autowired
	Util util;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired 
	private OrderItemRepository orderItemRepository;
	
	public void saveUpdateOrder(Order order) {
		if (order.getId() != null) {
			orderItemRepository.deleteOrderItemByOrderId(order.getId());
		}
		order.setBuyDate(util.handleDateTemporal(order.getBuyDate().getTime()));
		Order orderSaved = orderRepository.save(order);
		order.getItens().stream().forEach(item -> {
			item.setIdOrder(orderSaved.getId());
			orderItemRepository.save(item); 
		});
		
	}
	
	public void deleteOrder(Integer id) {
		orderItemRepository.deleteOrderItemByOrderId(id);
		Optional<Order> order = orderRepository.findById(id);
		if (order.isPresent()) {
			orderRepository.deleteById(id);
		}
		
	}
	
	public Optional<Order> getOrderById(Integer id) {
		
        HttpEntity<String> entity = new HttpEntity<String>("parameters", restClient.getRequestHeaderBearer());
		
		List<OrderItem> listOrderItens = orderItemRepository.getItensOrderByIdOrder(id);
		if (listOrderItens != null) {
			if (listOrderItens.size() > 0) {
				listOrderItens.stream()
					  .forEach(item -> item
							  .setDescriptionProduct(
									  template
									  .exchange(util.URL_BUSINESS_PRODUCTS + "/{id}", HttpMethod.GET, entity, Product.class, item.getIdProduct()).getBody().getDescription())
									  );
			}
		}
		Optional<Order> order = orderRepository.findById(id);
		
		if (order.isPresent()) {
			Payment payment = new Payment();
			
			payment = template.exchange(util.URL_BUSINESS_PAYMENTS + "/{id}", HttpMethod.GET, entity, Payment.class, order.get().getIdPayment()).getBody();
			Store store = new Store();
			store = template.exchange(util.URL_BUSINESS_STORES + "/{id}", HttpMethod.GET, entity, Store.class, order.get().getIdStore()).getBody();
			
			order.get().setPayment(payment);
			order.get().setStore(store);
			
			if (order.isPresent()) {
				if (listOrderItens.size() > 0) {
					order.get().setItens(listOrderItens);
				}
			}
		} 		
		return order.isPresent() ? order : null;
	}
	
	public void updateOrderConfirmationDate(Date dateConfirmation, Integer idOrder) {
		orderRepository.updateConfirmationOrder(util.handleDateTemporal(dateConfirmation.getTime()), idOrder);
	}
	
	

}
