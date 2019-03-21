package com.invillia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.invillia.model.OrderItem;

/*
 * Repository - Order Item
 * @since 20-03-2019
 * @author: Thiago Hernandes de Souza
 * */

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

}
