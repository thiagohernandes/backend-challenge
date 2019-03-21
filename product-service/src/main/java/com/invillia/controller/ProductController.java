package com.invillia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.model.Product;
import com.invillia.service.ProductService;

/*
 * REST Product Controller
 * @since 20-03-2019
 * @author: Thiago Hernandes de Souza
 * */

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping(value="/all")
	public List<Product> allProducts(){
		return productService.allProducts();
	}
	
	@GetMapping(value="/{id}")
	public Optional<Product> productById(@PathVariable Integer id){
		return productService.productById(id);
	}
	
}