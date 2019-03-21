package com.invillia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.model.Store;
import com.invillia.service.StoreService;

/*
 * REST Store Controller
 * @since 20-03-2019
 * @author: Thiago Hernandes de Souza
 * */

@RestController
@RequestMapping("/api/stores")
public class StoreController {
	
	@Autowired
	StoreService storeService;
	
	@GetMapping(value="/all")
	public List<Store> allStores(){
		return storeService.allStores();
	}
	
	@GetMapping(value="/{id}")
	public Optional<Store> storeById(@PathVariable Integer id){
		return storeService.storeById(id);
	}

}
