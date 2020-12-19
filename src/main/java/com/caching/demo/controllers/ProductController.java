package com.caching.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caching.demo.entity.Product;
import com.caching.demo.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping
	@Cacheable(value = "productCache")
	public Iterable<Product> getAllProducts(){
		Iterable<Product> products = this.productRepository.findAll();
		return products;
	}
	
	@GetMapping("/update/{productId}")
	public void update(@PathVariable("productId") Long productId) {
		
	}
}
