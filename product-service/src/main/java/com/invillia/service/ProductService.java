package com.invillia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invillia.model.Product;
import com.invillia.repository.ProductRepository;

/*
 * Service - Product
 * @since 20-03-2019
 * @author: Thiago Hernandes de Souza
 * */

@Service
public class ProductService {

	@Autowired
	ProductRepository produtoRepository;
	
	public List<Product> allProducts(){
		return produtoRepository.findAll();
	}
	
	public Optional<Product> productById( Integer id){
		return produtoRepository.findById(id);
	}
}
