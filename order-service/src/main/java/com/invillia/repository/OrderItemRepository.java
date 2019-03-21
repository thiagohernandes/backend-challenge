package com.invillia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.invillia.model.OrderItem;

/*
 * Repository - Order Item
 * @since 20-03-2019
 * @author: Thiago Hernandes de Souza
 * */

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
	
	@Query(value=   " SELECT id, id_order, id_product, quantity, price  " + 
			"		  FROM tbl_order_item " + 
			" 		  WHERE " + 
			"		  1 = 1 " + 
			"		  AND id_order = :pIdOrder ", nativeQuery=true)
	public List<OrderItem> getItensOrderByIdOrder(@Param("pIdOrder") Integer id_order);
	
	@Modifying
    @Transactional
	@Query(value=   " DELETE FROM tbl_order_item WHERE id_order = :pIdOrder ", nativeQuery=true)
	public void deleteOrderItemByOrderId(@Param("pIdOrder") Integer id_order);

}
