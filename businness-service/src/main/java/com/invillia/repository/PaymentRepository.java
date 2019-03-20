package com.invillia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invillia.model.Payment;

/*
 * Repository - Payment Table
 * @since 20-03-2019
 * @author: Thiago Hernandes de Souza
 * */

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
