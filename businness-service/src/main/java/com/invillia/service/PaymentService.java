package com.invillia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invillia.model.Payment;
import com.invillia.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	PaymentRepository paymentRepository;
	
	public List<Payment> allPayments(){
		return paymentRepository.findAll();
	}
	
	public Optional<Payment> paymentById(Integer id){
		return paymentRepository.findById(id);
	}
}
