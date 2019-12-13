package com.elte.recyclean.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.elte.recyclean.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
	
	
}
