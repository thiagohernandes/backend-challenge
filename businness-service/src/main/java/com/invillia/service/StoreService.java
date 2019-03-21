package com.invillia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.invillia.model.Store;
import com.invillia.repository.StoreRepository;

@Service
public class StoreService {

	@Autowired
	StoreRepository storeRepository;
	
	public List<Store> allStores(){
		return storeRepository.findAll();
	}
	
	public Optional<Store> storeById(Integer id){
		return storeRepository.findById(id);
	}
}
