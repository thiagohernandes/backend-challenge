package com.invillia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.model.Product;
import com.invillia.repository.ProductRepository;

/*
 * REST Controller Product
 * @since 20-03-2019
 * @author: Thiago Hernandes de Souza
 * */

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	ProductRepository produtoRepository;
	
	@GetMapping(value="/all")
	public List<Product> todos(){
		return produtoRepository.findAll();
	}
	
	@GetMapping(value="/{id}")
	public Optional<Product> produtoById(@PathVariable Integer id){
		return produtoRepository.findById(id);
	}
	
}