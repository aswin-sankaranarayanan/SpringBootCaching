package com.caching.demo.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import com.caching.demo.entity.Product;
import com.caching.demo.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public void markProductAsSold(Long productId) {
		try {
		Optional<Product> findById = repository.findById(productId);
		Product product = findById.get();
		product.setCheckout(true);
		//repository.save(product);
		Product savedProduct = repository.save(product);
		System.out.println(savedProduct);
		}catch(ObjectOptimisticLockingFailureException ex) {
			System.out.println("Sorry the product has been sold!!!!");
			throw ex;
		}
	}
}
