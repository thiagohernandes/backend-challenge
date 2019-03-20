package com.invillia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.model.Payment;
import com.invillia.repository.PaymentRepository;

/*
 * REST Controller Payment
 * @since 20-03-2019
 * @author: Thiago Hernandes de Souza
 * */

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

	@Autowired
	PaymentRepository paymentRepository;
	
	@GetMapping(value="/all")
	public List<Payment> todos(){
		return paymentRepository.findAll();
	}
	
	@GetMapping(value="/{id}")
	public Optional<Payment> produtoById(@PathVariable Integer id){
		return paymentRepository.findById(id);
	}
}
