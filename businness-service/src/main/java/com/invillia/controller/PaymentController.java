package com.invillia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.model.Payment;
import com.invillia.service.PaymentService;

/*
 * REST Payment Controller
 * @since 20-03-2019
 * @author: Thiago Hernandes de Souza
 * */

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

	@Autowired
	PaymentService PaymentService;
	
	@GetMapping(value="/all")
	public List<Payment> allPayments(){
		return PaymentService.allPayments();
	}
	
	@GetMapping(value="/{id}")
	public Optional<Payment> paymentById(@PathVariable Integer id){
		return PaymentService.paymentById(id);
	}
}
