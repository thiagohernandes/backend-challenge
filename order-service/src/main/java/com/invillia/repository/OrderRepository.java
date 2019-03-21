package com.invillia.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.invillia.model.Order;

/*
 * Repository - Order
 * @since 20-03-2019
 * @author: Thiago Hernandes de Souza
 * */

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

	@Modifying
    @Transactional
	@Query(value=   "UPDATE tbl_order SET confirmation_date = :pDateConfirmation WHERE id = :pIdOrder", nativeQuery=true)
	public void updateConfirmationOrder(@Param("pDateConfirmation") Date pDateConfirmation, @Param("pIdOrder") Integer pIdOrder);

}
