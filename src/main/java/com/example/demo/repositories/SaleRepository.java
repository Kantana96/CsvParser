package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.models.Sale;

public interface SaleRepository extends MongoRepository<Sale, String>{
	public List<Sale> findByCustomerNameLike(String customerName);
}
