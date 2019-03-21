package com.invillia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.invillia.model.Product;

/*
 * Repository - Product Table
 * @since 20-03-2019
 * @author: Thiago Hernandes de Souza
 * */

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query(value=   " SELECT id, description, price  " + 
			"		  FROM tbl_product " + 
			" 		  WHERE " + 
			"		  1 = 1 " + 
			"		  AND id in (:pIds) ", nativeQuery=true)
	public List<Product> consultaProductsByIds(@Param("pIds") List<Integer> idsProducts);
}
