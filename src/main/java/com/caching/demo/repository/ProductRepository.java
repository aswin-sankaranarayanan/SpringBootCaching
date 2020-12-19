package com.caching.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.caching.demo.entity.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

}
