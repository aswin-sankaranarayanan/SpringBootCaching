package com.caching.demo.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.transaction.Transactional;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.ObjectOptimisticLockingFailureException;

import com.caching.demo.entity.Product;
import com.caching.demo.service.ProductService;

@SpringBootTest
class ProductRepositoryTest {

	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private ProductService service;
	
	@Test
	void testCreateProduct() {
		List<Product> products = new ArrayList<Product>();
		
		Product p1 = new Product();
		p1.setName("TradMill");
		p1.setDescription("TradMill Fitness Mela");
		p1.setPrice(30000.00);
		
		Product p2 = new Product();
		p2.setName("HP Laptop");
		p2.setDescription("Electronics");
		p2.setPrice(50000.00);
		
		products.add(p1);
		products.add(p2);
		
		repository.saveAll(products);
		
	}
	
	@RepeatedTest(value = 2)
	void testConcurrentAccess() {
		markProductAsSold(1L);
//		Executor executors = Executors.newFixedThreadPool(2);
//		for(int i=1;i<=2;i++) {
//			executors.execute(()->markProductAsSold(1L));
//		}
	}
	
	//@Transactional
	public void markProductAsSold(Long productId) {
		service.markProductAsSold(1L);
		//assertThrows(ObjectOptimisticLockingFailureException.class, ()->service.markProductAsSold(1L));
		/*Optional<Product> findById = repository.findById(productId);
		Product product = findById.get();
		product.setCheckout(true);
		repository.save(product);
		Product savedProduct = repository.save(product);
		System.out.println(savedProduct);*/
	}

}
