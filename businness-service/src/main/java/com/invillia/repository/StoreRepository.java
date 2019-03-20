package com.invillia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invillia.model.Store;

/*
 * Repository - Store Table
 * @since 20-03-2019
 * @author: Thiago Hernandes de Souza
 * */

public interface StoreRepository extends JpaRepository<Store, Integer> {

}
