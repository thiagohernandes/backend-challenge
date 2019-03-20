package com.invillia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.model.Store;
import com.invillia.repository.StoreRepository;

/*
 * REST Controller Store
 * @since 20-03-2019
 * @author: Thiago Hernandes de Souza
 * */

@RestController
@RequestMapping("/api/stores")
public class StoreController {
	
	@Autowired
	StoreRepository storeRepository;
	
	@GetMapping(value="/all")
	public List<Store> todos(){
		return storeRepository.findAll();
	}
	
	@GetMapping(value="/{id}")
	public Optional<Store> produtoById(@PathVariable Integer id){
		return storeRepository.findById(id);
	}

}
